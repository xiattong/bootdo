package com.bootdo.exam.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.exam.domain.PaperTemplateDO;
import com.bootdo.exam.service.PaperTemplateService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 试卷模板表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
 
@Controller
@RequestMapping("/exam/paperTemplate")
public class PaperTemplateController {
	@Autowired
	private PaperTemplateService paperTemplateService;
	
	@GetMapping()
	String PaperTemplate(){
	    return "exam/paperTemplate/paperTemplate";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PaperTemplateDO> paperTemplateList = paperTemplateService.list(query);
		int total = paperTemplateService.count(query);
		PageUtils pageUtils = new PageUtils(paperTemplateList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "exam/paperTemplate/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id,Model model){
		PaperTemplateDO paperTemplate = paperTemplateService.get(id);
		model.addAttribute("paperTemplate", paperTemplate);
	    return "exam/paperTemplate/edit";
	}

	@GetMapping("/createPaper/{id}")
	String createPaper(@PathVariable("id") Long id,Model model){
		PaperTemplateDO paperTemplate = paperTemplateService.get(id);
		model.addAttribute("paperTemplate", paperTemplate);
		return "exam/paperTemplate/createPaper";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( PaperTemplateDO paperTemplate){
		//满分分值赋值
		paperTemplate.fillFullScore();
		if(paperTemplateService.save(paperTemplate)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( PaperTemplateDO paperTemplate){
		paperTemplateService.update(paperTemplate);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(paperTemplateService.remove(id)>0){
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
		paperTemplateService.batchRemove(ids);
		return R.ok();
	}
	
}
