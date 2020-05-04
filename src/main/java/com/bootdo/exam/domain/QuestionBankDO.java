package com.bootdo.exam.domain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;



/**
 * 题库表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:10
 */
public class QuestionBankDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//题型，关联表sys_dict/question_type
	private String questionType;
	//题目
	private String question;
	//选项(选择题有值，使用json字符串存储 {"A":"*****","B":"******"})
	private String options;
	private JSONArray optionsJson;
	//答案
	private String answer;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：题型，关联表sys_dict/question_type
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	/**
	 * 获取：题型，关联表sys_dict/question_type
	 */
	public String getQuestionType() {
		return questionType;
	}
	/**
	 * 设置：题目
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 获取：题目
	 */
	public String getQuestion() {
		return question;
	}

	public JSONArray getOptionsJson() {
		this.optionsJson = JSONObject.parseArray(this.options);
		return optionsJson;
	}

	/**
	 * 设置：选项(选择题有值，使用json字符串存储 {"A":"*****","B":"******"})
	 */
	public void setOptions(String options) {
		this.options = options;
	}
	/**
	 * 获取：选项(选择题有值，使用json字符串存储 {"A":"*****","B":"******"})
	 */
	public String getOptions() {
		return options;
	}
	/**
	 * 设置：答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：答案
	 */
	public String getAnswer() {
		return answer;
	}
}
