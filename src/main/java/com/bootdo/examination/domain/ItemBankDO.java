package com.bootdo.examination.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-29 21:36:43
 */
public class ItemBankDO extends DataEntity  <ItemBankDO> {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//题目类型(单选，多选，填空题）
	private String topicType;
	//题号
	private String titleNumber;
	//题目分数
	private String fraction;
	//题目
	private String subject;
	//题目选项
	private String topicOptions;
	//题目答案
	private String questionAnswer;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：题目类型(单选，多选，填空题）
	 */
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	/**
	 * 获取：题目类型(单选，多选，填空题）
	 */
	public String getTopicType() {
		return topicType;
	}
	/**
	 * 设置：题目分数
	 */
	public void setFraction(String fraction) {
		this.fraction = fraction;
	}
	/**
	 * 获取：题目分数
	 */
	public String getFraction() {
		return fraction;
	}
	/**
	 * 设置：题目
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：题目
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：题目选项
	 */
	public void setTopicOptions(String topicOptions) {
		this.topicOptions = topicOptions;
	}
	/**
	 * 获取：题目选项
	 */
	public String getTopicOptions() {
		return topicOptions;
	}
	/**
	 * 设置：题目答案
	 */
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	/**
	 * 获取：题目答案
	 */
	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public String getTitleNumber() {
		return titleNumber;
	}

	public void setTitleNumber(String titleNumber) {
		this.titleNumber = titleNumber;
	}
}
