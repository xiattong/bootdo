package com.bootdo.exam.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 试卷模板表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
public class PaperTemplateDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//模板编号
	private Long id;
	//模板名称
	private String name;
	//单选题数量
	private int singleChoiceAmount;
	//单选题分值
	private int singleChoiceScore;
	//多选题数量
	private int multipleChoiceAmount;
	//多选题分值
	private int multipleChoiceScore;
	//填空题数量
	private int completionAmount;
	//填空题分值
	private int completionScore;
	//卷面满分分值
	private int fullScore;
	//答题时间，分钟
	private int answerTime;

	/**
	 * 设置：模板编号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：模板编号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：模板名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：模板名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：单选题数量
	 */
	public void setSingleChoiceAmount(int singleChoiceAmount) {
		this.singleChoiceAmount = singleChoiceAmount;
	}
	/**
	 * 获取：单选题数量
	 */
	public int getSingleChoiceAmount() {
		return singleChoiceAmount;
	}
	/**
	 * 设置：单选题分值
	 */
	public void setSingleChoiceScore(int singleChoiceScore) {
		this.singleChoiceScore = singleChoiceScore;
	}
	/**
	 * 获取：单选题分值
	 */
	public int getSingleChoiceScore() {
		return singleChoiceScore;
	}
	/**
	 * 设置：多选题数量
	 */
	public void setMultipleChoiceAmount(int multipleChoiceAmount) {
		this.multipleChoiceAmount = multipleChoiceAmount;
	}
	/**
	 * 获取：多选题数量
	 */
	public int getMultipleChoiceAmount() {
		return multipleChoiceAmount;
	}
	/**
	 * 设置：多选题分值
	 */
	public void setMultipleChoiceScore(int multipleChoiceScore) {
		this.multipleChoiceScore = multipleChoiceScore;
	}
	/**
	 * 获取：多选题分值
	 */
	public int getMultipleChoiceScore() {
		return multipleChoiceScore;
	}
	/**
	 * 设置：填空题数量
	 */
	public void setCompletionAmount(int completionAmount) {
		this.completionAmount = completionAmount;
	}
	/**
	 * 获取：填空题数量
	 */
	public int getCompletionAmount() {
		return completionAmount;
	}
	/**
	 * 设置：填空题分值
	 */
	public void setCompletionScore(int completionScore) {
		this.completionScore = completionScore;
	}
	/**
	 * 获取：填空题分值
	 */
	public int getCompletionScore() {
		return completionScore;
	}
	/**
	 * 设置：卷面满分分值
	 */
	public void setFullScore(int fullScore) {
		this.fullScore = fullScore;
	}
	public void fillFullScore() {
		this.fullScore = this.singleChoiceScore * this.singleChoiceAmount +
						 this.multipleChoiceScore * this.multipleChoiceAmount +
						this.completionScore * this.completionAmount;
	}
	/**
	 * 获取：卷面满分分值
	 */
	public int getFullScore() {
		return fullScore;
	}
	/**
	 * 设置：答题时间，分钟
	 */
	public void setAnswerTime(int answerTime) {
		this.answerTime = answerTime;
	}
	/**
	 * 获取：答题时间，分钟
	 */
	public int getAnswerTime() {
		return answerTime;
	}
}
