package com.bootdo.exam.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.exam.domain.QuestionBankDO;
import com.bootdo.exam.service.QuestionBankService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 题库表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:10
 */
 
@Controller
@RequestMapping("/exam/questionBank")
public class QuestionBankController {
	@Autowired
	private QuestionBankService questionBankService;

	@Autowired
	private DictService dictService;
	
	@GetMapping()
	String QuestionBank(){
	    return "exam/questionBank/questionBank";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<QuestionBankDO> questionBankList = questionBankService.list(query);
		int total = questionBankService.count(query);
		PageUtils pageUtils = new PageUtils(questionBankList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add(Model model){
		//查询题型
		List<DictDO> questionTypes = dictService.listByType("question_type");
		model.addAttribute("questionTypes", questionTypes);
	    return "exam/questionBank/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model){
		QuestionBankDO questionBank = questionBankService.get(id);
		model.addAttribute("questionBank", questionBank);
		//查询题型
		List<DictDO> questionTypes = dictService.listByType("question_type");
		model.addAttribute("questionTypes", questionTypes);
		return "exam/questionBank/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( QuestionBankDO questionBank){
		if(questionBankService.save(questionBank)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( QuestionBankDO questionBank){
		questionBankService.update(questionBank);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(questionBankService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] ids){
		questionBankService.batchRemove(ids);
		return R.ok();
	}
	
}
