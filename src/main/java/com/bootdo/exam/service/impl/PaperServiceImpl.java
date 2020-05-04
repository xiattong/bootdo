package com.bootdo.exam.service.impl;

import com.bootdo.exam.dao.PaperTemplateDao;
import com.bootdo.exam.dao.QuestionBankDao;
import com.bootdo.exam.domain.PaperTemplateDO;
import com.bootdo.exam.domain.QuestionBankDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.exam.dao.PaperDao;
import com.bootdo.exam.domain.PaperDO;
import com.bootdo.exam.service.PaperService;



@Service
public class PaperServiceImpl implements PaperService {
	@Autowired
	private PaperDao paperDao;
	@Autowired
	private PaperTemplateDao paperTemplateDao;
	@Autowired
	private QuestionBankDao questionBankDao;
	
	@Override
	public PaperDO get(Long id){
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
		//查询模板
		PaperTemplateDO templateDO = paperTemplateDao.get(paper.getTemplateId());
		//随机收取单选题
		List<QuestionBankDO> singleChoiceList
				= questionBankDao.randomListByType("single_choice",templateDO.getSingleChoiceAmount());
		String singleChoiceMenu = new String();
		String singleChoiceKey = new String();
		String[] singleArray = getMenuAndKey(singleChoiceMenu,singleChoiceKey,singleChoiceList);
		paper.setSingleChoiceMenu(singleArray[0]);
		paper.setSingleChoiceKey(singleArray[1]);
		paper.setSingleChoiceScore(templateDO.getSingleChoiceScore());

		//随机收取多选题
		List<QuestionBankDO> multipleChoiceList
				= questionBankDao.randomListByType("multiple_choice",templateDO.getMultipleChoiceAmount());
		String multipleChoiceMenu = new String();
		String multipleChoiceKey = new String();
		String[] multipleArray =  getMenuAndKey(multipleChoiceMenu,multipleChoiceKey,multipleChoiceList);
		paper.setMultipleChoiceMenu(multipleArray[0]);
		paper.setMultipleChoiceKey(multipleArray[1]);
		paper.setMultipleChoiceScore(templateDO.getMultipleChoiceScore());

		//随机收取填空题
		List<QuestionBankDO> completionList
				= questionBankDao.randomListByType("completion",templateDO.getCompletionAmount());
		String completionMenu = new String();
		String completionKey = new String();
		String[] completionArray =  getMenuAndKey(completionMenu,completionKey,completionList);
		paper.setCompletionMenu(completionArray[0]);
		paper.setCompletionKey(completionArray[1]);
		paper.setCompletionScore(templateDO.getCompletionScore());

		return paperDao.save(paper);
	}

	private String[] getMenuAndKey(String menu,String key,List<QuestionBankDO> questions){
		String[] menuAndKey = new String[2];
		StringBuilder menuBuilder = new StringBuilder();
		StringBuilder keyBuilder = new StringBuilder();
		for (QuestionBankDO questionBankDO : questions) {
			menuBuilder.append(questionBankDO.getId()+",");
			keyBuilder.append(questionBankDO.getAnswer()+",");
		}
		menu = menuBuilder.toString();
		menuAndKey[0] = menu.substring(0,menu.length()-1);
		key = keyBuilder.toString();
		menuAndKey[1] = key.substring(0,key.length()-1);
		return menuAndKey;
	}
	
	@Override
	public int update(PaperDO paper){
		return paperDao.update(paper);
	}
	
	@Override
	public int remove(Long id){
		return paperDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return paperDao.batchRemove(ids);
	}

	@Override
	public PaperDO getPlus(Long id){
		PaperDO paper =  paperDao.get(id);
		//获取试卷题目的详细信息
		List<QuestionBankDO> singleChoiceBank =  questionBankDao.listByMenu(paper.getSingleChoiceMenu());
		List<QuestionBankDO> multipleChoiceBank =  questionBankDao.listByMenu(paper.getMultipleChoiceMenu());
		List<QuestionBankDO> completionBank =  questionBankDao.listByMenu(paper.getCompletionMenu());

		paper.setSingleChoiceBank(singleChoiceBank);
		paper.setMultipleChoiceBank(multipleChoiceBank);
		paper.setCompletionBank(completionBank);

		return paper;
	}


	
}
