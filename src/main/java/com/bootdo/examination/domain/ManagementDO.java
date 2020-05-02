package com.bootdo.examination.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 文件管理
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 22:15:18
 */
public class ManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//文件名
	private String fileName;
	//文件路径
	private String filePath;
	//创建时间
	private Date createTime;

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
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：文件路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * 获取：文件路径
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
