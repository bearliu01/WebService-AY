package com.web.entity;

import org.springframework.stereotype.Component;


/** 物联网表操作记录
 * @author Administrator
 *
 */
@Component
public class SendList {
	
	/**
	 * 记录ID
	 */
	private String listId;
	
	/**
	 * 仪表编号
	 */
	private String meterNo;
	
	/**
	 * 下载类型  0-默认
	 */
	private Integer sendType;
	
	/**
	 * 下载内容：0-开通   1-关断
	 */
	private String sendContent;
	
	/**
	 * 创建日期
	 */
	private String createDt;

	/**
	 * 执行日期
	 */
	private String manageDt;
	
	/**
	 * 执行结果标记：0-未执行  1-已执行
	 */
	private Integer manageFlag;

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getManageDt() {
		return manageDt;
	}

	public void setManageDt(String manageDt) {
		this.manageDt = manageDt;
	}

	public Integer getManageFlag() {
		return manageFlag;
	}

	public void setManageFlag(Integer manageFlag) {
		this.manageFlag = manageFlag;
	}
	
	
	
}
