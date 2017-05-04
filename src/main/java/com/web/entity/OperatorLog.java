package com.web.entity;

import org.springframework.stereotype.Component;

@Component
public class OperatorLog {
	
	private String olId;
	private String operatorId;
	private String olDt;
	private String olfmName;
	private String olDesc;
	private String olIp;
	private String olArea;
	private String olRemark;
	public String getOlId() {
		return olId;
	}
	public void setOlId(String olId) {
		this.olId = olId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getOlDt() {
		return olDt;
	}
	public void setOlDt(String olDt) {
		this.olDt = olDt;
	}
	public String getOlfmName() {
		return olfmName;
	}
	public void setOlfmName(String olfmName) {
		this.olfmName = olfmName;
	}
	public String getOlDesc() {
		return olDesc;
	}
	public void setOlDesc(String olDesc) {
		this.olDesc = olDesc;
	}
	public String getOlIp() {
		return olIp;
	}
	public void setOlIp(String olIp) {
		this.olIp = olIp;
	}
	public String getOlArea() {
		return olArea;
	}
	public void setOlArea(String olArea) {
		this.olArea = olArea;
	}
	public String getOlRemark() {
		return olRemark;
	}
	public void setOlRemark(String olRemark) {
		this.olRemark = olRemark;
	}
	
	
	

}
