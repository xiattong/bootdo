package com.bootdo.examination.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.examination.domain.PaperDO;
import com.bootdo.examination.service.PaperService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 考试试卷
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 13:18:59
 */
 
@Controller
@RequestMapping("/system/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;
	
	@GetMapping()
	@RequiresPermissions("system:paper:paper")
	String Paper(){
	    return "examintion/paper/paper";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:paper:paper")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PaperDO> paperList = paperService.list(query);
		int total = paperService.count(query);
		PageUtils pageUtils = new PageUtils(paperList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:paper:add")
	String add(){
	    return "examintion/paper/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:paper:edit")
	String edit(@PathVariable("id") String id,Model model){
		PaperDO paper = paperService.get(id);
		model.addAttribute("paper", paper);
	    return "examintion/paper/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:paper:add")
	public R save( PaperDO paper){
		if(paperService.save(paper)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:paper:edit")
	public R update( PaperDO paper){
		paperService.update(paper);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:paper:remove")
	public R remove( String id){
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
	@RequiresPermissions("system:paper:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		paperService.batchRemove(ids);
		return R.ok();
	}
	
}
