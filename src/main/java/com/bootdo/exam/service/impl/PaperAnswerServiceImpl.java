package com.bootdo.exam.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.exam.dao.PaperDao;
import com.bootdo.exam.dao.QuestionBankDao;
import com.bootdo.exam.domain.PaperDO;
import com.bootdo.exam.domain.QuestionBankDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.exam.dao.PaperAnswerDao;
import com.bootdo.exam.domain.PaperAnswerDO;
import com.bootdo.exam.service.PaperAnswerService;



@Service
public class PaperAnswerServiceImpl implements PaperAnswerService {
	@Autowired
	private PaperAnswerDao paperAnswerDao;
	@Autowired
	private QuestionBankDao questionBankDao;
	@Autowired
	private PaperDao paperDao;

	@Override
	public PaperAnswerDO get(Long id){
		return paperAnswerDao.get(id);
	}
	
	@Override
	public List<PaperAnswerDO> list(Map<String, Object> map){
		return paperAnswerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return paperAnswerDao.count(map);
	}
	
	@Override
	public int save(PaperAnswerDO paperAnswer){
		//获取试卷信息
		PaperDO paper = paperDao.get(paperAnswer.getPaperId());
		//单选分数
		JSONArray singleAnswer = JSONArray.parseArray(paperAnswer.getSingleChoiceAnswer());
		String[] singleScore = getScore(paper.getSingleChoiceKey(),singleAnswer,paper.getSingleChoiceScore());
		paperAnswer.setSingleChoiceScore(Integer.parseInt(singleScore[0]));
		paperAnswer.setSingleChoiceAnswer(singleScore[1]);
		//多选分数
		JSONArray multipleAnswer = JSONArray.parseArray(paperAnswer.getMultipleChoiceAnswer());
		String[] multipleScore = getScore(paper.getMultipleChoiceKey(),multipleAnswer,paper.getMultipleChoiceScore());
		paperAnswer.setMultipleChoiceScore(Integer.parseInt(multipleScore[0]));
		paperAnswer.setMultipleChoiceAnswer(multipleScore[1]);
		//填空分数
		JSONArray completionAnswer = JSONArray.parseArray(paperAnswer.getCompletionAnswer());
		String[] completionScore = getScore(paper.getCompletionKey(),completionAnswer,paper.getCompletionScore());
		paperAnswer.setCompletionScore(Integer.parseInt(completionScore[0]));
		paperAnswer.setCompletionAnswer(completionScore[1]);
		//总分
		paperAnswer.setFinalScore(paperAnswer.getSingleChoiceScore() + paperAnswer.getMultipleChoiceScore() + paperAnswer.getCompletionScore());

		return paperAnswerDao.save(paperAnswer);
	}

	private String[] getScore(String keys,JSONArray answerArray,int score){
		String[] result = new String[2];
		int totalScore= 0 ;
		StringBuilder answerBuilder = new StringBuilder();
		String[] keyArray = keys.split(",");
		for(int i = 0 ; i< answerArray.size(); i++){
			String key = keyArray[i];
			String answer =  ((JSONObject)answerArray.get(i)).getString("value");
			answerBuilder.append(answer+",");
			if(key.equals(answer)){
				totalScore = totalScore + score;
			}
		}
		String asw = answerBuilder.toString();
		result[0] = totalScore+"";
		result[1] = asw.substring(0,asw.length()-1);
		return result;
	}
	
	@Override
	public int update(PaperAnswerDO paperAnswer){
		return paperAnswerDao.update(paperAnswer);
	}
	
	@Override
	public int remove(Long id){
		return paperAnswerDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return paperAnswerDao.batchRemove(ids);
	}
	
}
