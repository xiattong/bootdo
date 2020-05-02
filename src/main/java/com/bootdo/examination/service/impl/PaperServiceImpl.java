package com.bootdo.examination.service.impl;

import com.bootdo.examination.dao.PaperDao;
import com.bootdo.examination.domain.PaperDO;
import com.bootdo.examination.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class PaperServiceImpl implements PaperService {
	@Autowired
	private PaperDao paperDao;
	
	@Override
	public PaperDO get(String id){
		return paperDao.get(id);
	}
	
	@Override
	public List<PaperDO> list(Map<String, Object> map){
		return paperDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return paperDao.count(map);
	}
	
	@Override
	public int save(PaperDO paper){
		return paperDao.save(paper);
	}
	
	@Override
	public int update(PaperDO paper){
		return paperDao.update(paper);
	}
	
	@Override
	public int remove(String id){
		return paperDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return paperDao.batchRemove(ids);
	}
	
}
