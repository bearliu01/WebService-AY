package com.web.webservice;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.web.entity.DosageDays;
import com.web.entity.DosageMonth;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ReadMeter {
	
//	public OperatorLog findOperatorLogById(String id) throws Exception;
//	
//	
//	public Integer getCommPort(String musterNo ) throws Exception;
	
	/**  对仪表进行操作
	 * @param meterNo 仪表编号
	 * @param cmd 抄表类型     1000-读当前量  1902-读阀门状态   2000-开阀门   2002-关阀门
	 * @param iotFlag 物联网表标记
	 * @return
	 */
	public String meterHandle(String meterNo, String cmd, String iotFlag);
	
	
	/** 缴费成功后待下载数据
	 * @param meterNo 仪表编号
	 * @param sendType 发送信息类型
	 * @param sendContent 发送信息内容
	 * @return
	 */
	public String downloadData(String meterNo,Integer sendType,String sendContent);
	
	/** 获取日用量
	 * @param meterNo 仪表编号
	 * @param startDt 开始日期
	 * @param endDt 截止日期
	 * @return
	 */
	public List<DosageDays> getDosageDays(String meterNo, String startDt,String endDt);
	
	/** 获取月用量
	 * @param meterNo 仪表编号
	 * @param startDt 开始日期
	 * @param endDt 截止日期
	 * @return
	 */
	public List<DosageMonth> getDosageMonth(String meterNo, String startMonth, String endMonth);
	
	/** 换表
	 * @param changeDt 换表时间
	 * @param oldMeterNo 旧表表号
	 * @param oldDosageSum 旧表累计量
	 * @param newMeterNo 新表表号
	 * @param startDosage 新表起始量
	 * @param changeReason 换表原因
	 * @param changeUser 换表人
	 */
	public String changeMeter(String changeDt, String oldMeterNo,
			Float oldDosageSum, String newMeterNo, Float startDosage,
			String changeReason, String changeUser) throws Exception;
	
}
