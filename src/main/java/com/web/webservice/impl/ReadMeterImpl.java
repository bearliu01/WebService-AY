package com.web.webservice.impl;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.entity.DosageDays;
import com.web.entity.DosageMonth;
import com.web.entity.MeterInfo;
import com.web.service.IReadMeterService;
import com.web.service.IWebService_Service;
import com.web.webservice.ReadMeter;

@Component("ReadMeter")
@WebService
@SOAPBinding(style = Style.RPC)
public class ReadMeterImpl implements ReadMeter{
	
	@Autowired
	private IReadMeterService readMeterService;
	@Autowired
	private IWebService_Service WebService_Service;

	/* (non-Javadoc) 对仪表进行操作
	 * @see com.web.webservice.ReadMeter#getDosage(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String meterHandle(String meterNo, String cmd, String iotFlag) {
		
		String data="";
		try {
			//通过仪表编号获取仪表信息
			MeterInfo meterInfo = WebService_Service.getMeterInfoById(meterNo);
			data = readMeterService.meterHandle(meterInfo.getMusterNo(), meterInfo.getConnecter_commPara(), meterInfo.getMeterNo()
					, cmd, "", meterInfo.getComNo()+"|"+meterInfo.getBaud(), "接口调用", 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data = "仪表操作失败！";
		}
		
		return data;
	}

	/* (non-Javadoc) 缴费成功后发送的待下载数据 
	 * @see com.web.webservice.ReadMeter#downloadData(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public String downloadData(String meterNo, Integer sendType,
			String sendContent) {
		try {
			WebService_Service.insertSendData(meterNo, sendType, sendContent);
			if(sendType == 0)
				return "开通命令已下发！";
			else
				return "关断命令已下发！";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(sendType == 0)
				return "开通命令下发失败！";
			else
				return "关断命令下发失败！";
		}
	}

	/* (non-Javadoc) 获取日用量
	 * @see com.web.webservice.ReadMeter#getDosageDays(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<DosageDays> getDosageDays(String meterNo, String startDt,
			String endDt) {
		return WebService_Service.getDosageDays(meterNo, startDt, endDt);

	}

	/* (non-Javadoc) 获取月用量
	 * @see com.web.webservice.ReadMeter#getDosageMonth(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<DosageMonth> getDosageMonth(String meterNo, String startMonth,
			String endMonth) {
		return WebService_Service.getDosageMonth(meterNo, startMonth, endMonth);
	}

	/* (non-Javadoc) 换表
	 * @see com.web.webservice.ReadMeter#changeMeter(java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.Float, java.lang.String, java.lang.String)
	 */
	public String changeMeter(String changeDt, String oldMeterNo,
			Float oldDosageSum, String newMeterNo, Float startDosage,
			String changeReason, String changeUser) {
		String resultCode = "";
		try {
			WebService_Service.insertChangeMeter(changeDt, oldMeterNo, oldDosageSum, newMeterNo, startDosage, changeReason, changeUser);
			resultCode = "0";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultCode = "1";
		}
		return resultCode;
	}


}
