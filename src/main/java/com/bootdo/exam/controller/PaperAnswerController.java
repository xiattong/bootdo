package com.bootdo.exam.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.exam.domain.PaperDO;
import com.bootdo.exam.service.PaperService;
import com.bootdo.system.domain.UserDO;
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

import com.bootdo.exam.domain.PaperAnswerDO;
import com.bootdo.exam.service.PaperAnswerService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 答卷表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
 
@Controller
@RequestMapping("/exam/paperAnswer")
public class PaperAnswerController {
	@Autowired
	private PaperAnswerService paperAnswerService;
	@Autowired
	private PaperService paperService;
	
	@GetMapping()
	String PaperAnswer(){
	    return "exam/paperAnswer/paperAnswer";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PaperAnswerDO> paperAnswerList = paperAnswerService.list(query);
		int total = paperAnswerService.count(query);
		PageUtils pageUtils = new PageUtils(paperAnswerList, total);
		return pageUtils;
	}

	/**
	 * 发放试卷
	 * @return
	 */
	@GetMapping("paperGrant/{id}")
	String paperGrant(@PathVariable("id") Long id,Model model){
		//查询试卷
		PaperDO paper = paperService.getPlus(id);
		model.addAttribute("paper",paper);
		//答卷人
		UserDO user = ShiroUtils.getUser();
		model.addAttribute("paper",paper);
		model.addAttribute("user",user);
		return "exam/paperAnswer/paperGrant";
	}
	
	/**
	 * 提交试卷
	 */
	@ResponseBody
	@PostMapping("/upLoadPaper")
	public R upLoadPaper( PaperAnswerDO paperAnswer){
		if(paperAnswerService.save(paperAnswer)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 提交试卷
	 */
	@GetMapping("/showPaper/{id}")
	String showPaper(@PathVariable("id") Long id,Model model){
		//答卷人
		UserDO user = ShiroUtils.getUser();
		model.addAttribute("user",user);
		//答卷内容
		PaperAnswerDO paperAnswer = paperAnswerService.get(id);
		model.addAttribute("paperAnswer", paperAnswer);
		//试卷内容
		PaperDO paper = paperService.getPlus(paperAnswer.getPaperId());
		model.addAttribute("paper",paper);

		return "exam/paperAnswer/paperDetail";
	}
	
}
