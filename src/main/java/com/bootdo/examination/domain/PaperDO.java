package com.bootdo.examination.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 考试试卷
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 13:18:59
 */
public class PaperDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//题目类型
	private String topicType;
	//考生姓名
	private String candidateName;
	//总分
	private String totalScore;
	//考试时间
	private Date examinationTime;
	//题号
	private String titleNumber;
	//题目
	private String subject;
	//题目正确答案
	private String questionAnswer;
	//考试选择答案
	private String chooseAnswer;
	//最终得分
	private String 
finalScore;
	//每题分数
	private String 
scorePerQuestion;

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
	 * 设置：题目类型
	 */
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	/**
	 * 获取：题目类型
	 */
	public String getTopicType() {
		return topicType;
	}
	/**
	 * 设置：考生姓名
	 */
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	/**
	 * 获取：考生姓名
	 */
	public String getCandidateName() {
		return candidateName;
	}
	/**
	 * 设置：总分
	 */
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	/**
	 * 获取：总分
	 */
	public String getTotalScore() {
		return totalScore;
	}
	/**
	 * 设置：考试时间
	 */
	public void setExaminationTime(Date examinationTime) {
		this.examinationTime = examinationTime;
	}
	/**
	 * 获取：考试时间
	 */
	public Date getExaminationTime() {
		return examinationTime;
	}
	/**
	 * 设置：题号
	 */
	public void setTitleNumber(String titleNumber) {
		this.titleNumber = titleNumber;
	}
	/**
	 * 获取：题号
	 */
	public String getTitleNumber() {
		return titleNumber;
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
	 * 设置：题目正确答案
	 */
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	/**
	 * 获取：题目正确答案
	 */
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	/**
	 * 设置：考试选择答案
	 */
	public void setChooseAnswer(String chooseAnswer) {
		this.chooseAnswer = chooseAnswer;
	}
	/**
	 * 获取：考试选择答案
	 */
	public String getChooseAnswer() {
		return chooseAnswer;
	}
	/**
	 * 设置：最终得分
	 */
	public void setfinalScore(String
finalScore) {
		this.
finalScore = 
finalScore;
	}
	/**
	 * 获取：最终得分
	 */
	public String getfinalScore() {
		return 
finalScore;
	}
	/**
	 * 设置：每题分数
	 */
	public void setscorePerQuestion(String
scorePerQuestion) {
		this.
scorePerQuestion = 
scorePerQuestion;
	}
	/**
	 * 获取：每题分数
	 */
	public String getscorePerQuestion() {
		return scorePerQuestion;
	}
}
