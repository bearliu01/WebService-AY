package com.web.entity;

import org.springframework.stereotype.Component;

/** 日用量信息
 * @author Administrator
 *
 */
@Component
public class DosageDays {
	
	/**
	 * 仪表编号
	 */
	private String meterNo;
	
	/**
	 * 标识日期
	 */
	private String markDay;
	
	/**
	 * 日用量
	 */
	private Double dayDosage;
	
	/**
	 * 累计用量
	 */
	private Double dosageSum;
	
	/**
	 * 原始累计用量
	 */
	private Double realDosageSum;
	
	/**
	 * 抄读时间
	 */
	private String readDt;
	
	/**
	 * 抄读人员
	 */
	private String readUser;
	
	/**
	 * 用量状态
	 */
	private Integer checkFlag;
	
	/**
	 * 审核时间
	 */
	private String checkDt;
	
	/**
	 * 审核人员
	 */
	private String checker;
	
	/**
	 * 审核失败原因
	 */
	private String checkErrReason;

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getMarkDay() {
		return markDay;
	}

	public void setMarkDay(String markDay) {
		this.markDay = markDay;
	}

	public Double getDayDosage() {
		return dayDosage;
	}

	public void setDayDosage(Double dayDosage) {
		this.dayDosage = dayDosage;
	}

	public Double getDosageSum() {
		return dosageSum;
	}

	public void setDosageSum(Double dosageSum) {
		this.dosageSum = dosageSum;
	}

	public Double getRealDosageSum() {
		return realDosageSum;
	}

	public void setRealDosageSum(Double realDosageSum) {
		this.realDosageSum = realDosageSum;
	}

	public String getReadDt() {
		return readDt;
	}

	public void setReadDt(String readDt) {
		this.readDt = readDt;
	}

	public String getReadUser() {
		return readUser;
	}

	public void setReadUser(String readUser) {
		this.readUser = readUser;
	}

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getCheckDt() {
		return checkDt;
	}

	public void setCheckDt(String checkDt) {
		this.checkDt = checkDt;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckErrReason() {
		return checkErrReason;
	}

	public void setCheckErrReason(String checkErrReason) {
		this.checkErrReason = checkErrReason;
	}

	
}
