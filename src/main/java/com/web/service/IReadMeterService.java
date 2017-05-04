package com.web.service;


/**
 * @author Administrator
 *
 */
public interface IReadMeterService {
	
	/**仪表操作
	 * @param musterNo 集中器编号
	 * @param channelInfo 集中器参数compara
	 * @param meterNO 仪表编号
	 * @param cmd 抄表类型
	 * @param assist
	 * @param comPara 仪表端口号(comNo)+"|"+"波特率(波特率)"
	 * @param opName 操作员
	 * @param iotFlag 1-物联网表
	 * @return
	 */
	public  String meterHandle(String musterNo, String channelInfo, String meterNO,String cmd, String assist, String comPara, String opName, int iotFlag);

}
