package com.bootdo.examination.service.impl;

import com.bootdo.examination.dao.ItemBankDao;
import com.bootdo.examination.domain.ItemBankDO;
import com.bootdo.examination.service.ItemBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BankServiceImpl implements ItemBankService {
	@Autowired
	private ItemBankDao bankDao;
	
	@Override
	public ItemBankDO get(String id){
		return bankDao.get(id);
	}
	
	@Override
	public List<ItemBankDO> list(Map<String, Object> map){
		return bankDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bankDao.count(map);
	}
	
	@Override
	public int save(ItemBankDO bank){
		bank.preInsert();
		return bankDao.save(bank);
	}
	
	@Override
	public int update(ItemBankDO bank){
		return bankDao.update(bank);
	}
	
	@Override
	public int remove(String id){
		return bankDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return bankDao.batchRemove(ids);
	}
	
}
