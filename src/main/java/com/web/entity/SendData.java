package com.web.entity;

import org.springframework.stereotype.Component;

/** 待下载数据
 * @author Administrator
 *
 */
@Component
public class SendData {
	
	/**
	 * 待下载数据编号
	 */
	private String sendId;
	
	/**
	 * 仪表编号
	 */
	private String meterNo; 

	/**
	 * 发送信息类型  0-开通  1-关断
	 */
	private Integer sendType;
	
	/**
	 * 发送信息内容 0-开通  1-关断
	 */
	private String sendContent;
	
	/**
	 * 收费项目编号
	 */
	private String feeNo;
	
	/**
	 * 创建日期
	 */
	private String createDt;
	
	/**
	 * 处理标志   0-为处理（默认） 1-已处理
	 */
	private Integer manageFlag;
	
	/**
	 * 处理时间
	 */
	private String manageDt;
	
	/**
	 * 处理次数
	 */
	private Integer manageCount;
	
	/**
	 * 集中器编号
	 */
	private String sdMusterNo;

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
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

	public String getFeeNo() {
		return feeNo;
	}

	public void setFeeNo(String feeNo) {
		this.feeNo = feeNo;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public Integer getManageFlag() {
		return manageFlag;
	}

	public void setManageFlag(Integer manageFlag) {
		this.manageFlag = manageFlag;
	}

	public String getManageDt() {
		return manageDt;
	}

	public void setManageDt(String manageDt) {
		this.manageDt = manageDt;
	}

	public Integer getManageCount() {
		return manageCount;
	}

	public void setManageCount(Integer manageCount) {
		this.manageCount = manageCount;
	}

	public String getSdMusterNo() {
		return sdMusterNo;
	}

	public void setSdMusterNo(String sdMusterNo) {
		this.sdMusterNo = sdMusterNo;
	}
	
	
}
