package com.bootdo.examination.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.examination.domain.ManagementDO;
import com.bootdo.examination.service.ManagementService;
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
 * 文件管理
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 22:15:18
 */
 
@Controller
@RequestMapping("/system/file")
public class ManagementController {
	@Autowired
	private ManagementService managementService;
	
	@GetMapping()
	@RequiresPermissions("system:fileMange:fileMange")
	String Management(){
	    return "examintion/fileMange/fileMange";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:fileMange:fileMange")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ManagementDO> managementList = managementService.list(query);
		int total = managementService.count(query);
		PageUtils pageUtils = new PageUtils(managementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:fileMange:add")
	String add(){
	    return "system/fileMange/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:fileMange:edit")
	String edit(@PathVariable("id") String id,Model model){
		ManagementDO management = managementService.get(id);
		model.addAttribute("management", management);
	    return "system/fileMange/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:fileMange:add")
	public R save( ManagementDO management){
		if(managementService.save(management)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:fileMange:edit")
	public R update( ManagementDO management){
		managementService.update(management);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:fileMange:remove")
	public R remove( String id){
		if(managementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:fileMange:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		managementService.batchRemove(ids);
		return R.ok();
	}
	
}
