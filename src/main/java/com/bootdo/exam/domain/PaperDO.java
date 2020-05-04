package com.bootdo.exam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 试卷表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
public class PaperDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//试卷标题
	private String title;
	//模板编码,关联exam_paper_template:id
	private Long templateId;
	private String templateName;
	//单选题菜单，关联题库表中的id， 中间用逗号隔开
	private String singleChoiceMenu;
	private List<QuestionBankDO> singleChoiceBank;
	//单选题答案
	private String singleChoiceKey;
	private int singleChoiceScore;
	//多选题菜单
	private String multipleChoiceMenu;
	private List<QuestionBankDO> multipleChoiceBank;
	//多选题答案
	private String multipleChoiceKey;
	private int multipleChoiceScore;
	//填空题菜单
	private String completionMenu;
	private List<QuestionBankDO> completionBank;
	//填空题答案
	private String completionKey;
	private int completionScore;

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
	 * 设置：试卷标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：试卷标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：模板编码,关联exam_paper_template:id
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板编码,关联exam_paper_template:id
	 */
	public Long getTemplateId() {
		return templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * 设置：单选题菜单，关联题库表中的id， 中间用逗号隔开
	 */
	public void setSingleChoiceMenu(String singleChoiceMenu) {
		this.singleChoiceMenu = singleChoiceMenu;
	}
	/**
	 * 获取：单选题菜单，关联题库表中的id， 中间用逗号隔开
	 */
	public String getSingleChoiceMenu() {
		return singleChoiceMenu;
	}
	/**
	 * 设置：试卷标题
	 */
	public void setSingleChoiceKey(String singleChoiceKey) {
		this.singleChoiceKey = singleChoiceKey;
	}
	/**
	 * 获取：试卷标题
	 */
	public String getSingleChoiceKey() {
		return singleChoiceKey;
	}
	/**
	 * 设置：多选题菜单
	 */
	public void setMultipleChoiceMenu(String multipleChoiceMenu) {
		this.multipleChoiceMenu = multipleChoiceMenu;
	}
	/**
	 * 获取：多选题菜单
	 */
	public String getMultipleChoiceMenu() {
		return multipleChoiceMenu;
	}
	/**
	 * 设置：多选题答案
	 */
	public void setMultipleChoiceKey(String multipleChoiceKey) {
		this.multipleChoiceKey = multipleChoiceKey;
	}
	/**
	 * 获取：多选题答案
	 */
	public String getMultipleChoiceKey() {
		return multipleChoiceKey;
	}
	/**
	 * 设置：填空题菜单
	 */
	public void setCompletionMenu(String completionMenu) {
		this.completionMenu = completionMenu;
	}
	/**
	 * 获取：填空题菜单
	 */
	public String getCompletionMenu() {
		return completionMenu;
	}
	/**
	 * 设置：填空题答案
	 */
	public void setCompletionKey(String completionKey) {
		this.completionKey = completionKey;
	}
	/**
	 * 获取：填空题答案
	 */
	public String getCompletionKey() {
		return completionKey;
	}

	public List<QuestionBankDO> getSingleChoiceBank() {
		return singleChoiceBank;
	}

	public void setSingleChoiceBank(List<QuestionBankDO> singleChoiceBank) {
		this.singleChoiceBank = singleChoiceBank;
	}

	public List<QuestionBankDO> getMultipleChoiceBank() {
		return multipleChoiceBank;
	}

	public void setMultipleChoiceBank(List<QuestionBankDO> multipleChoiceBank) {
		this.multipleChoiceBank = multipleChoiceBank;
	}

	public List<QuestionBankDO> getCompletionBank() {
		return completionBank;
	}

	public void setCompletionBank(List<QuestionBankDO> completionBank) {
		this.completionBank = completionBank;
	}


	public int getSingleChoiceScore() {
		return singleChoiceScore;
	}

	public void setSingleChoiceScore(int singleChoiceScore) {
		this.singleChoiceScore = singleChoiceScore;
	}

	public int getMultipleChoiceScore() {
		return multipleChoiceScore;
	}

	public void setMultipleChoiceScore(int multipleChoiceScore) {
		this.multipleChoiceScore = multipleChoiceScore;
	}

	public int getCompletionScore() {
		return completionScore;
	}

	public void setCompletionScore(int completionScore) {
		this.completionScore = completionScore;
	}

}
