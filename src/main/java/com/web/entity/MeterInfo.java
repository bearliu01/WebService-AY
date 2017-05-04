package com.web.entity;

import org.springframework.stereotype.Component;

@Component
public class MeterInfo {
	
	/**
	 * 仪表编号
	 */
	private String meterNo;
	
	/**
	 * 所属集中器
	 */
	private String musterNo;
	
	/**
	 * 端口号
	 */
	private String comNo;
	
	/**
	 * 波特率
	 */
	private String baud;
	
	/**
	 * 集中器通讯参数
	 */
	private String connecter_commPara;

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getMusterNo() {
		return musterNo;
	}

	public void setMusterNo(String musterNo) {
		this.musterNo = musterNo;
	}

	public String getComNo() {
		return comNo;
	}

	public void setComNo(String comNo) {
		this.comNo = comNo;
	}

	public String getBaud() {
		return baud;
	}

	public void setBaud(String baud) {
		this.baud = baud;
	}

	public String getConnecter_commPara() {
		return connecter_commPara;
	}

	public void setConnecter_commPara(String connecter_commPara) {
		this.connecter_commPara = connecter_commPara;
	}
	
	

}
