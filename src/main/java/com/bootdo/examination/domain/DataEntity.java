package com.bootdo.examination.domain;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.examination.utils.UidUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 数据Entity类
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	protected String remarks;	// 备注
	protected Date createDate;	// 创建日期
	protected Date updateDate;	// 更新日期
	protected String createBy;  // 创建者
	protected String updateBy;  // 更新者
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
   
	
	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public DataEntity(String id) {
		super(id);
	}
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert(){
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord){
			//setId(IdGen.uuid());  //更换id  生成方式
			setId(UidUtil.getInstance().getUid());
			
		}
		setDelFlag(DEL_FLAG_NORMAL);
		this.createBy = ShiroUtils.getUserId().toString();
		//this.updateDate = new Date();   //2018-1-24 modify by zc  添加数据时候不需要插入更新日期
		this.createDate = new Date();
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate(){
		this.updateBy = ShiroUtils.getUserId().toString();
		this.updateDate = new Date();
	}
	
	@Length(min=0, max=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
//	@Length(min=0, max=255)
//	public String getCreateBy() {
//		return createBy;
//	}
//
//	public void setCreateBy(String createBy) {
//		this.createBy = createBy;
//	}
//	@Length(min=0, max=255)
//	public String getUpdateBy() {
//		return updateBy;
//	}
//
//	public void setUpdateBy(String updateBy) {
//		this.updateBy = updateBy;
//	} 
}
