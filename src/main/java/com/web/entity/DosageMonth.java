package com.web.entity;

import org.springframework.stereotype.Component;

@Component
public class DosageMonth {
	
	/**
	 * 仪表编号
	 */
	private String meterNo;
	/**
	 * 月用量日期
	 */
	private String markMonth;
	/**
	 * 当月用量
	 */
	private Float monthDosage;
	/**
	 * 总用量
	 */
	private Float dosageSum;
	/**
	 * 抄读日期
	 */
	private String readDt;
	public String getMeterNo() {
		return meterNo;
	}
	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}
	public String getMarkMonth() {
		return markMonth;
	}
	public void setMarkMonth(String markMonth) {
		this.markMonth = markMonth;
	}
	public Float getMonthDosage() {
		return monthDosage;
	}
	public void setMonthDosage(Float monthDosage) {
		this.monthDosage = monthDosage;
	}
	public Float getDosageSum() {
		return dosageSum;
	}
	public void setDosageSum(Float dosageSum) {
		this.dosageSum = dosageSum;
	}
	public String getReadDt() {
		return readDt;
	}
	public void setReadDt(String readDt) {
		this.readDt = readDt;
	}
	
	

}
