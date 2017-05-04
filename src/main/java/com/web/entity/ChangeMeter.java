package com.web.entity;

import org.springframework.stereotype.Component;

/** 换表
 * @author Administrator
 *
 */
@Component
public class ChangeMeter {

	/**
	 * 换表时间
	 */
	private String changeDt;
	
	/**
	 * 旧表号
	 */
	private String oldMeterNo;
	
	/**
	 * 旧表累计量
	 */
	private Float oldDosageSum;
	
	/**
	 * 新表表号
	 */
	private String newMeterNo;
	
	/**
	 * 新表起始量
	 */
	private Float startDosage;
	
	/**
	 * 换表原因
	 */
	private String changeReason;
	
	/**
	 * 换表人
	 */
	private String changeUser;

	public String getChangeDt() {
		return changeDt;
	}

	public void setChangeDt(String changeDt) {
		this.changeDt = changeDt;
	}

	public String getOldMeterNo() {
		return oldMeterNo;
	}

	public void setOldMeterNo(String oldMeterNo) {
		this.oldMeterNo = oldMeterNo;
	}

	public Float getOldDosageSum() {
		return oldDosageSum;
	}

	public void setOldDosageSum(Float oldDosageSum) {
		this.oldDosageSum = oldDosageSum;
	}

	public String getNewMeterNo() {
		return newMeterNo;
	}

	public void setNewMeterNo(String newMeterNo) {
		this.newMeterNo = newMeterNo;
	}

	public Float getStartDosage() {
		return startDosage;
	}

	public void setStartDosage(Float startDosage) {
		this.startDosage = startDosage;
	}

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public String getChangeUser() {
		return changeUser;
	}

	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}
	
	
	
}
