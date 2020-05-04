package com.bootdo.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.exam.dao.QuestionBankDao;
import com.bootdo.exam.domain.QuestionBankDO;
import com.bootdo.exam.service.QuestionBankService;



@Service
public class QuestionBankServiceImpl implements QuestionBankService {
	@Autowired
	private QuestionBankDao questionBankDao;
	
	@Override
	public QuestionBankDO get(Long id){
		return questionBankDao.get(id);
	}
	
	@Override
	public List<QuestionBankDO> list(Map<String, Object> map){
		return questionBankDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return questionBankDao.count(map);
	}
	
	@Override
	public int save(QuestionBankDO questionBank){
		return questionBankDao.save(questionBank);
	}
	
	@Override
	public int update(QuestionBankDO questionBank){
		return questionBankDao.update(questionBank);
	}
	
	@Override
	public int remove(Long id){
		return questionBankDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return questionBankDao.batchRemove(ids);
	}
	
}
