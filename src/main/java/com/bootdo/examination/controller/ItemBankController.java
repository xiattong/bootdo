package com.bootdo.examination.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.examination.domain.ItemBankDO;
import com.bootdo.examination.service.ItemBankService;
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
 *
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-29 21:36:43
 */

@Controller
@RequestMapping("/system/bank")
public class ItemBankController {
    @Autowired
    private ItemBankService bankService;

    @GetMapping()
    @RequiresPermissions("system:bank:bank")
    String Bank(){
        return "examintion/itemBank/bank";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:bank:bank")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ItemBankDO> bankList = bankService.list(query);
        int total = bankService.count(query);
        PageUtils pageUtils = new PageUtils(bankList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:bank:add")
    String add(){
        return "examintion/itemBank/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:bank:edit")
    String edit(@PathVariable("id") String id,Model model){
        ItemBankDO bank = bankService.get(id);
        model.addAttribute("bank", bank);
        return "examintion/itemBank/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:bank:add")
    public R save( ItemBankDO bank){
        if(bankService.save(bank)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:bank:edit")
    public R update( ItemBankDO bank){
        bankService.update(bank);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("system:bank:remove")
    public R remove( String id){
        if(bankService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:bank:batchRemove")
    public R remove(@RequestParam("ids[]") String[] ids){
        bankService.batchRemove(ids);
        return R.ok();
    }

}
