package com.web.service;

import java.util.List;

import com.web.entity.DosageDays;
import com.web.entity.DosageMonth;
import com.web.entity.MeterInfo;


public interface IWebService_Service {
	
	public Integer getCommPort(String musterNo)throws Exception;

	public String getCommPara(String meterNo)throws Exception;
	
	/** 获取仪表信息
	 * @param meterNo
	 * @return
	 * @throws Exception
	 */
	public MeterInfo getMeterInfoById(String meterNo)throws Exception;
	
	/** 新增物联网表操作记录
	 * @param meterNo
	 * @param sendType
	 * @param sendContent
	 * @param manageFlag
	 * @param manageDt
	 */
	public void insertSendList(String meterNo,Integer sendType,String sendContent,Integer manageFlag,String manageDt);

	/** 更新当前量及抄读时间
	 * @param meterNo
	 * @param dosageSum
	 * @param readDt
	 */
	public void updateDosageAndReadDate(String meterNo, Double dosageSum, String readDt);
	
	/**向日用量表中插入累积量
	 * @param meterNo
	 * @param dosage
	 * @param n
	 * @param readUser
	 */
	public void insertDosageDays(String meterNo,Double dosage,Integer n,String readUser);
	
	/** 修改仪表阀门状态
	 * @param meterNo
	 * @param switchState
	 */
	public void updateMeterSwitchState(String meterNo,Integer switchState);
	
	/** 插入开关阀操作日志
	 * @param meterNo
	 * @param meterState
	 * @param succFlag
	 * @param opName
	 */
	public void insertSwitchLog(String meterNo, Integer meterState, Integer succFlag, String opName);
	 
	/** 新增待下载数据
	 * @param meterNo 仪表编号
	 * @param sendType 发送信息类型 ：0-开通  1-关断
	 * @param sendContent 发送信息内容：0-开通  1-关断
	 * @throws Exception 
	 */
	public void insertSendData(String meterNo, Integer sendType,String sendContent) throws Exception;
	
	/** 获取日用量
	 * @param meterNo 仪表编号
	 * @param startDt 开始日期
	 * @param endDt 截止日期
	 * @return
	 */
	public List<DosageDays> getDosageDays(String meterNo, String startDt, String endDt);
	
	/** 获取月用量
	 * @param meterNo 仪表编号
	 * @param startMonth 开始日期
	 * @param endMonth 截止日期
	 * @return
	 */
	public List<DosageMonth> getDosageMonth(String meterNo, String startMonth, String endMonth);
	
	/** 换表
	 * @param changeDt 换表时间
	 * @param oldMeterNo 旧表表号
	 * @param oldDosageSum  旧表累计量
	 * @param newMeterNo 新表表号
	 * @param startDosage 新表起始量
	 * @param changeReason 换表原因
	 * @param changeUser 换表人
	 */
	public void insertChangeMeter(String changeDt, String oldMeterNo, Float oldDosageSum,String newMeterNo,Float startDosage,String changeReason,String changeUser)throws Exception;
}
