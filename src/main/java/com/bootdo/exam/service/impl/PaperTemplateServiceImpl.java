package com.bootdo.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.exam.dao.PaperTemplateDao;
import com.bootdo.exam.domain.PaperTemplateDO;
import com.bootdo.exam.service.PaperTemplateService;



@Service
public class PaperTemplateServiceImpl implements PaperTemplateService {
	@Autowired
	private PaperTemplateDao paperTemplateDao;
	
	@Override
	public PaperTemplateDO get(Long id){
		return paperTemplateDao.get(id);
	}
	
	@Override
	public List<PaperTemplateDO> list(Map<String, Object> map){
		return paperTemplateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return paperTemplateDao.count(map);
	}
	
	@Override
	public int save(PaperTemplateDO paperTemplate){
		return paperTemplateDao.save(paperTemplate);
	}
	
	@Override
	public int update(PaperTemplateDO paperTemplate){
		return paperTemplateDao.update(paperTemplate);
	}
	
	@Override
	public int remove(Long id){
		return paperTemplateDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return paperTemplateDao.batchRemove(ids);
	}
	
}
