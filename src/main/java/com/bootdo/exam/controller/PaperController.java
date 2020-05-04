package com.bootdo.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.exam.domain.PaperDO;
import com.bootdo.exam.service.PaperService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 试卷表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
 
@Controller
@RequestMapping("/exam/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;
	
	@GetMapping()
	String Paper(){
	    return "exam/paper/paper";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PaperDO> paperList = paperService.list(query);
		int total = paperService.count(query);
		PageUtils pageUtils = new PageUtils(paperList, total);
		return pageUtils;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( PaperDO paper){
		if(paperService.save(paper)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(paperService.remove(id)>0){
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
		paperService.batchRemove(ids);
		return R.ok();
	}
}
