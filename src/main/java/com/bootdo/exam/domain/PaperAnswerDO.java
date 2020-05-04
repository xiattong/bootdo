package com.bootdo.exam.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 答卷表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
public class PaperAnswerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//应试人，关联sys_user/user_id
	private Long userId;
	//试卷编号，关联exam_paper/id
	private Long paperId;
	//应试开始时间 yyyy-MM-dd HH:mm:ss
	private String examTimeStart;
	//应试结束时间
	private String examTimeEnd;
	//单选题应试答案，每题答案中间用逗号隔开
	private String singleChoiceAnswer;
	//单选题应试得分
	private Integer singleChoiceScore;
	//多选题应试答案
	private String multipleChoiceAnswer;
	//多选题应试得分
	private Integer multipleChoiceScore;
	//填空题应试答案
	private String completionAnswer;
	//填空题应试得分
	private Integer completionScore;
	//应试得分
	private Integer finalScore;

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
	 * 设置：应试人，关联sys_user/user_id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：应试人，关联sys_user/user_id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：试卷编号，关联exam_paper/id
	 */
	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}
	/**
	 * 获取：试卷编号，关联exam_paper/id
	 */
	public Long getPaperId() {
		return paperId;
	}
	/**
	 * 设置：应试开始时间 yyyy-MM-dd HH:mm:ss
	 */
	public void setExamTimeStart(String examTimeStart) {
		this.examTimeStart = examTimeStart;
	}
	/**
	 * 获取：应试开始时间 yyyy-MM-dd HH:mm:ss
	 */
	public String getExamTimeStart() {
		return examTimeStart;
	}
	/**
	 * 设置：应试结束时间
	 */
	public void setExamTimeEnd(String examTimeEnd) {
		this.examTimeEnd = examTimeEnd;
	}
	/**
	 * 获取：应试结束时间
	 */
	public String getExamTimeEnd() {
		return examTimeEnd;
	}
	/**
	 * 设置：单选题应试答案，每题答案中间用逗号隔开
	 */
	public void setSingleChoiceAnswer(String singleChoiceAnswer) {
		this.singleChoiceAnswer = singleChoiceAnswer;
	}
	/**
	 * 获取：单选题应试答案，每题答案中间用逗号隔开
	 */
	public String getSingleChoiceAnswer() {
		return singleChoiceAnswer;
	}
	/**
	 * 设置：单选题应试得分
	 */
	public void setSingleChoiceScore(Integer singleChoiceScore) {
		this.singleChoiceScore = singleChoiceScore;
	}
	/**
	 * 获取：单选题应试得分
	 */
	public Integer getSingleChoiceScore() {
		return singleChoiceScore;
	}
	/**
	 * 设置：多选题应试答案
	 */
	public void setMultipleChoiceAnswer(String multipleChoiceAnswer) {
		this.multipleChoiceAnswer = multipleChoiceAnswer;
	}
	/**
	 * 获取：多选题应试答案
	 */
	public String getMultipleChoiceAnswer() {
		return multipleChoiceAnswer;
	}
	/**
	 * 设置：多选题应试得分
	 */
	public void setMultipleChoiceScore(Integer multipleChoiceScore) {
		this.multipleChoiceScore = multipleChoiceScore;
	}
	/**
	 * 获取：多选题应试得分
	 */
	public Integer getMultipleChoiceScore() {
		return multipleChoiceScore;
	}
	/**
	 * 设置：填空题应试答案
	 */
	public void setCompletionAnswer(String completionAnswer) {
		this.completionAnswer = completionAnswer;
	}
	/**
	 * 获取：填空题应试答案
	 */
	public String getCompletionAnswer() {
		return completionAnswer;
	}
	/**
	 * 设置：填空题应试得分
	 */
	public void setCompletionScore(Integer completionScore) {
		this.completionScore = completionScore;
	}
	/**
	 * 获取：填空题应试得分
	 */
	public Integer getCompletionScore() {
		return completionScore;
	}
	/**
	 * 设置：应试得分
	 */
	public void setFinalScore(Integer finalScore) {
		this.finalScore = finalScore;
	}
	/**
	 * 获取：应试得分
	 */
	public Integer getFinalScore() {
		return finalScore;
	}
}
