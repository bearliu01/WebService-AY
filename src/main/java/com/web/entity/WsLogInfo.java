package com.web.entity;

import org.springframework.stereotype.Component;

/** 阀门操作记录
 * @author Administrator
 *
 */
@Component
public class WsLogInfo {
	
	/**
	 * 记录编号
	 */
	private String wsId;
	
	/**
	 *  仪表编号
	 */
	private String meterNo;
	
	/**
	 * 创建日期
	 */
	private String wsDt;
	
	/**
	 * 操作人
	 */
	private String wsUser;
	
	/**
	 * 操作状态
	 */
	private Integer wsFlag;
	
	/**
	 * 成功状态
	 */
	private Integer succFlag;

	public String getWsId() {
		return wsId;
	}

	public void setWsId(String wsId) {
		this.wsId = wsId;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getWsDt() {
		return wsDt;
	}

	public void setWsDt(String wsDt) {
		this.wsDt = wsDt;
	}

	public String getWsUser() {
		return wsUser;
	}

	public void setWsUser(String wsUser) {
		this.wsUser = wsUser;
	}

	public Integer getWsFlag() {
		return wsFlag;
	}

	public void setWsFlag(Integer wsFlag) {
		this.wsFlag = wsFlag;
	}

	public Integer getSuccFlag() {
		return succFlag;
	}

	public void setSuccFlag(Integer succFlag) {
		this.succFlag = succFlag;
	}
	
	

}
