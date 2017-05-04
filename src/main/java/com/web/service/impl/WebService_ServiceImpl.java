package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.entity.ChangeMeter;
import com.web.entity.DosageDays;
import com.web.entity.DosageMonth;
import com.web.entity.MeterInfo;
import com.web.entity.SendData;
import com.web.entity.SendList;
import com.web.entity.WsLogInfo;
import com.web.mapper.WebServiceMapper;
import com.web.service.IWebService_Service;
import com.web.util.Tools;
import com.web.util.UUIDUtil;

@Transactional
@Service
public class WebService_ServiceImpl implements IWebService_Service{
	
	@Autowired
	private WebServiceMapper webServiceMapper;
	@Autowired
	private SendList sendList;
	@Autowired
	private DosageDays dosageDays;
	@Autowired
	private WsLogInfo wsLogInfo;
	@Autowired
	private SendData sendData;
	@Autowired
	private ChangeMeter changeMeter;

	/* (non-Javadoc) 通过集中器编号获取集中器端口号(为了解决同一系统不同底层的问题)
	 * @see com.web.service.IWebService_Service#getCommPort(java.lang.String)
	 */
	public Integer getCommPort(String musterNo) throws Exception{
		return webServiceMapper.getCommPort(musterNo);
	}
	
	/* (non-Javadoc)通过仪表编号获取通讯参数
	 * @see com.web.service.ReadMeterService#getCommPara(java.lang.String)
	 */
	public String getCommPara(String meterNo) throws Exception {
		return webServiceMapper.getCommPara(meterNo);
	}

	/* (non-Javadoc) 通过仪表编号获取仪表信息
	 * @see com.web.service.IWebService_Service#getMeterInfoById(java.lang.String)
	 */
	public MeterInfo getMeterInfoById(String meterNo) throws Exception {
		return webServiceMapper.getMeterInfoById(meterNo);
	}

	/* (non-Javadoc) 新增物联网表操作记录
	 * @see com.web.service.IWebService_Service#insertSendList(com.web.entity.SendList)
	 */
	public void insertSendList(String meterNo,Integer sendType,String sendContent,Integer manageFlag,String manageDt) {
		sendList.setListId(UUIDUtil.getUUID());//333e2c34d87e4228827529a7ee432e64
		sendList.setMeterNo(meterNo);//641606100184
		sendList.setSendType(sendType);//1
		sendList.setSendContent(sendContent);//""
		sendList.setCreateDt(Tools.getNow());//2017-04-26 14:52:22
		sendList.setManageDt(manageDt);//2017-04-26 14:52:19
		sendList.setManageFlag(manageFlag);//0
		
		webServiceMapper.insertSendList(sendList);
	}

	/* (non-Javadoc) 更新当前量及抄读时间
	 * @see com.web.service.IWebService_Service#updateDosageAndReadDate(java.lang.String, java.lang.Double, java.lang.String)
	 */
	public void updateDosageAndReadDate(String meterNo, Double dosageSum,
			String readDt) {
		webServiceMapper.updateDosageAndReadDate(meterNo, dosageSum, readDt);
	}

	/* (non-Javadoc) 向日用量表中插入累计用量
	 * @see com.web.service.IWebService_Service#insertDosageDays(com.web.entity.DosageDays)
	 */
	public void insertDosageDays(String meterNo,Double dosage,Integer n,String readUser) {
		dosageDays.setMeterNo(meterNo);
		dosageDays.setMarkDay(Tools.getForNDay(n));
		dosageDays.setDosageSum(dosage);
		dosageDays.setRealDosageSum(dosage);
		dosageDays.setReadDt(Tools.getNow());
		dosageDays.setReadUser(readUser);
		dosageDays.setCheckFlag(1);
		webServiceMapper.insertDosageDays(dosageDays);
	}

	/* (non-Javadoc) 修改仪表阀门状态
	 * @see com.web.service.IWebService_Service#updateMeterSwitchState(java.lang.String, java.lang.Integer)
	 */
	public void updateMeterSwitchState(String meterNo, Integer switchState) {
		webServiceMapper.updateMeterSwitchState(meterNo, switchState);
	}

	/* (non-Javadoc) 插入操作阀门记录
	 * @see com.web.service.IWebService_Service#insertSwitchLog(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	public void insertSwitchLog(String meterNo, Integer meterState,
			Integer succFlag, String opName) {
		
		wsLogInfo.setWsId(UUIDUtil.getUUID());
		wsLogInfo.setMeterNo(meterNo);
		wsLogInfo.setWsDt(Tools.getNow());
		wsLogInfo.setWsUser(opName);
		wsLogInfo.setWsFlag(meterState);
		wsLogInfo.setSuccFlag(succFlag);
		webServiceMapper.insertSwitchLog(wsLogInfo);
		
	}

	/* (non-Javadoc) 新增待下载数据
	 * @see com.web.service.IWebService_Service#insertSendData(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void insertSendData(String meterNo, Integer sendType,
			String sendContent) throws Exception {
		//通过仪表编号获取集中器号
		MeterInfo meterInfo = webServiceMapper.getMeterInfoById(meterNo);
		String id = UUIDUtil.getUUID();
		id = id.substring(id.length()-12,id.length());
		sendData.setSendId(id);
		sendData.setMeterNo(meterNo);
		sendData.setSendType(sendType);
		sendData.setSendContent(sendContent);
		sendData.setCreateDt(Tools.getNow());
		sendData.setManageFlag(0);
		sendData.setSdMusterNo(meterInfo.getMusterNo());
		
		webServiceMapper.insertSendData(sendData);
	}

	/* (non-Javadoc) 获取日用量
	 * @see com.web.service.IWebService_Service#getDosageDays(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<DosageDays> getDosageDays(String meterNo, String startDt,
			String endDt) {
		return webServiceMapper.getDosageDays(meterNo, startDt, endDt);
	}

	/* (non-Javadoc)获取月用量
	 * @see com.web.service.IWebService_Service#getDosageMonth(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<DosageMonth> getDosageMonth(String meterNo, String startMonth,
			String endMonth) {
		
		return webServiceMapper.getDosageMonth(meterNo, startMonth, endMonth);
	}

	/* (non-Javadoc) 换表
	 * @see com.web.service.IWebService_Service#insertChangeMeter(java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void insertChangeMeter(String changeDt, String oldMeterNo,
			Float oldDosageSum, String newMeterNo, Float startDosage,
			String changeReason, String changeUser) throws Exception {

		changeMeter.setChangeDt(changeDt);
		changeMeter.setChangeReason(changeReason);
		changeMeter.setChangeUser(changeUser);
		changeMeter.setNewMeterNo(newMeterNo);
		changeMeter.setOldDosageSum(oldDosageSum);
		changeMeter.setOldMeterNo(oldMeterNo);
		changeMeter.setStartDosage(startDosage);
		
		webServiceMapper.insertChangeMeter(changeMeter);
	}


	

}
