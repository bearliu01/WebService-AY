package com.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.ChangeMeter;
import com.web.entity.DosageDays;
import com.web.entity.DosageMonth;
import com.web.entity.MeterInfo;
import com.web.entity.SendData;
import com.web.entity.SendList;
import com.web.entity.WsLogInfo;

/** WebService接口业务持久层
 * @author Administrator
 * 
 */
public interface WebServiceMapper {
	
	/** 通过集中器编号获取集中器端口号
	 * @param musterNo
	 * @return
	 */
	public Integer getCommPort(String musterNo)throws Exception;
	
	
	/**通过仪表编号获取通信参数
	 * @param meterNo
	 * @return
	 * @throws Exception
	 */
	public String getCommPara(String meterNo)throws Exception;
	
	
	/**
	 * @param meterId 通过仪表编号获取仪表信息
	 * @return
	 */
	public MeterInfo getMeterInfoById(String meterNo)throws Exception;
	
	
	/** 新增"物联网表"操作记录
	 * @param sendList
	 */
	public void insertSendList(SendList sendList);
	
	/** 更新用量及抄读时间
	 * @param meterNo 仪表编号
	 * @param dosageSum 用量
	 * @param readDt 抄读时间
	 */
	public void updateDosageAndReadDate(@Param("meterNo")String meterNo,@Param("dosageSum")Double dosageSum, @Param("readDt")String readDt);
	
	/**向日用量表中插入累计量
	 * @param dosageDays
	 */
	public void insertDosageDays(DosageDays dosageDays);
	
	/** 更新阀门状态
	 * @param meterNo 仪表编号
	 * @param switchState 阀门状态
	 */
	public void updateMeterSwitchState(@Param("meterNo")String meterNo, @Param("switchState")Integer switchState );
	
	
	/** 记录开关阀操作
	 * @param wsLogInfo
	 */
	public void insertSwitchLog(WsLogInfo wsLogInfo);
	
	/** 新增待下载数据
	 * @param sendData
	 */
	public void insertSendData(SendData sendData);
	
	/** 获取日用量
	 * @param meterNo 仪表编号
	 * @param startDt 开始日期
	 * @param endDt 结束日期
	 * @return
	 */
	public List<DosageDays> getDosageDays(@Param("meterNo")String meterNo,@Param("startDt")String startDt,@Param("endDt")String endDt );

	/** 获取月用量
	 * @param meterNo 仪表编号
	 * @param startDt 开始日期
	 * @param endDt 截止日期
	 * @return
	 */
	public List<DosageMonth> getDosageMonth(@Param("meterNo")String meterNo,@Param("startMonth")String startMonth,@Param("endMonth")String endMonth );
	
	/** 新增换表
	 * @param changeMeter
	 */
	public void insertChangeMeter(ChangeMeter changeMeter);
}
