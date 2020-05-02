package com.bootdo.examination.service.impl;

import com.bootdo.examination.dao.ManagementDao;
import com.bootdo.examination.domain.ManagementDO;
import com.bootdo.examination.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class ManagementServiceImpl implements ManagementService {
	@Autowired
	private ManagementDao managementDao;
	
	@Override
	public ManagementDO get(String id){
		return managementDao.get(id);
	}
	
	@Override
	public List<ManagementDO> list(Map<String, Object> map){
		return managementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return managementDao.count(map);
	}
	
	@Override
	public int save(ManagementDO management){
		return managementDao.save(management);
	}
	
	@Override
	public int update(ManagementDO management){
		return managementDao.update(management);
	}
	
	@Override
	public int remove(String id){
		return managementDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return managementDao.batchRemove(ids);
	}
	
}
