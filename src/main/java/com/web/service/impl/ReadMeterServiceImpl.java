package com.web.service.impl;

import java.io.DataInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.service.IReadMeterService;
import com.web.service.IWebService_Service;
import com.web.util.ARMCilentSocket;
import com.web.util.ConstParam;
import com.web.util.Tools;

/**
 * @author Administrator
 * 抄表接口的业务层
 */
@Transactional
@Service
public class ReadMeterServiceImpl implements IReadMeterService{
	
	@Autowired
	private IWebService_Service webService_Service;
	
    private ARMCilentSocket cs = null;
    /**
     * 通讯所需的参数  
     */
    private byte[] buf =  new byte[533];
    /**
     * 返回的数据
     */
    public String Data = "";

   
	
	
    /**创建Socket连接
     * @param port
     * @return
     */
    private boolean createConnection(Integer port) {  				      
        try {   
			cs = new ARMCilentSocket(ConstParam.SOCKETIP, port);  
            cs.CreateConnection();
            return true;
        } catch (Exception e) {   
            Data = "连接服务器失败";
            return false;  
        }    
    }
    
    /**发送Socket消息
     * @return
     */
    private boolean sendMessage() {   
    	
    	boolean sucflag = false; //下发参数正确标志   	
        if (cs == null){
            return false;
        }      	   
        try {         	
            cs.sendMessage(buf);  
            sucflag = true;
        } catch (Exception e) {   
            Data = "发送消息失败";
            sucflag = false;
        }  
        return sucflag;
    }
    
	/**
	 * 返回消息
	 */
	private void getMessage() {   
        if (cs == null)
            return;   
        DataInputStream inputStream = null;   
        try {       	   	
            inputStream = cs.getMessageStream();   
            try {            	
            	int firstChar = inputStream.read();   
            	int length = inputStream.available();   
            	byte[] recData = new byte[length+1];   
            	recData[0] = (byte)firstChar;   
            	inputStream.read(recData,1,length); 
            	Data = new String(recData);	
            	if(Data.indexOf("Idle")!=-1){ //判断若存在空闲链接Idle则等待1秒。
            		Thread.sleep(1000);
            		getMessage();
            	}
            } catch (Exception e) {   
                System.out.println("接收消息错误");   
                Data = "接收消息错误";
                return;   
            } 
        } catch (Exception e) {   
            System.out.println("接收消息缓存错误");   
            Data = "接收消息缓存错误";
            return;
        } finally{
        	cs.shutDownConnection();
        }             
    }
	
	

	/* (non-Javadoc) 对仪表进行操作
	 * @see com.web.service.IReadMeterService#meterHandle(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	public synchronized String meterHandle(String musterNo, String channelInfo,
			String meterNO, String cmd, String assist, String comPara,
			String opName, int iotFlag) {
		int manageFlag = 0;
		
		int tRecNo = 1;//更新后的recno
		
		buf =  new byte[534];
		byte[] temp = new byte[533];
		
		temp = musterNo.getBytes();   
		System.arraycopy(temp,0,buf,0,temp.length);   
         
		temp = channelInfo.getBytes();   
		System.arraycopy(temp,0,buf,12,temp.length); 
		
		temp = meterNO.getBytes();   
		System.arraycopy(temp,0,buf,62,temp.length);
   
		temp = cmd.getBytes();      
		System.arraycopy(temp,0,buf,74,temp.length); 
		
		temp = assist.getBytes();
		System.arraycopy(temp,0,buf,78,temp.length);
		
		temp = comPara.getBytes();
		System.arraycopy(temp,0,buf,483,temp.length);
		
	    String Prioprity="0";
	    temp = Prioprity.getBytes();
		
	    System.arraycopy(temp,0,buf,533,temp.length);
	    
	    try {
			if(createConnection(webService_Service.getCommPort(musterNo))){
				if (sendMessage()){					 
					 getMessage(); 
				}else{
					System.out.println("发送参数失败");
			 	}
			}
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
	    
	    //当前量
        if (cmd.equals("1000")){
        	if ("Send OK".equals(Data)){
        		if (iotFlag == 1){
        			//插入物联网操作记录
        			webService_Service.insertSendList(meterNO,1, "", manageFlag, Tools.getNow());
        		}
        		return "数据请求已下发";
        	}
        	try{
        		Data = String.valueOf(Double.parseDouble(Data));
        		//物联网表
        		manageFlag =1;
        		if (musterNo.length()==11){
        			//插入物联网操作记录
        			webService_Service.insertSendList(meterNO,1,"",manageFlag,Tools.getNow());
        		}
        		//更新当前量及抄读时间
        		webService_Service.updateDosageAndReadDate(meterNO, Double.parseDouble(Data), Tools.getNow());
        		//向日用量表中插入累积量
        		webService_Service.insertDosageDays(meterNO, Double.parseDouble(Data), 1, "0000"); 
        		
        	}catch(Exception e){
        		e.printStackTrace();
        		manageFlag =0;       		
        	}      	
        }
        
        //读阀门状态
        if (cmd.equals("1902")){ 
        	if ("Send OK".equals(Data)){
        		if (iotFlag == 1){
        			//新增物联网表操作记录
        			webService_Service.insertSendList(meterNO,2,"",manageFlag,"");
        		}
        		return "数据请求已下发";
        	}
        	try{
        		webService_Service.updateMeterSwitchState(meterNO,Integer.parseInt(Data));
        		if (Data.equals("0"))
        			Data = "开通";
        		else if (Data.equals("1"))
        			Data = "关断";
        		else if (Data.equals("2"))
        			Data = "开通*";
        		else if (Data.equals("3"))
        			Data = "关断*";
        	}catch(Exception e){
        		e.printStackTrace();
        	} 
        }
        
        //开阀门
        if (cmd.equals("2000")){
        	
    		if (iotFlag == 1){
    			if ("Send OK".equals(Data)){
    				manageFlag =0;
    				webService_Service.insertSendList(meterNO,0,"0",manageFlag,""); 
    				webService_Service.insertSwitchLog(meterNO, 0, 0, opName);
    				return "数据请求已下发";
        		}
    			else if ("0".equals(Data)){
    				manageFlag =1;
    				Data = "开通";
    				webService_Service.insertSendList(meterNO,0,"0",manageFlag,Tools.getNow());
    			}else{
    				manageFlag =1;
    				Data = "开通*";
    				webService_Service.insertSendList(meterNO,0,"0",manageFlag,Tools.getNow());
    			}    			
    		}
        	    		       		
    		if (iotFlag != 1){
	        	try{   
	        		webService_Service.insertSwitchLog(meterNO, 0, 0, opName);
	        		webService_Service.updateMeterSwitchState(meterNO,0);
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
    		}
        }
        
        //关阀门
        if (cmd.equals("2002")){
        	if (iotFlag == 1){
    			if ("Send OK".equals(Data)){
    				manageFlag =0;
    				webService_Service.insertSendList(meterNO,0,"1",manageFlag,"");
    				webService_Service.insertSwitchLog(meterNO,1,0,opName);
    				return "数据请求已下发";
        		}else if ("1".equals(Data)){
    				manageFlag =1;
    				Data = "关断";
    				webService_Service.insertSendList(meterNO,0,"1",manageFlag,Tools.getNow());
    			}else{
    				manageFlag =1;
    				Data = "关断*";
    				webService_Service.insertSendList(meterNO,0,"1",manageFlag,Tools.getNow());
    			}      			
    		}        	       	
        	
        	if (iotFlag != 1){
	        	try{
	        		webService_Service.insertSwitchLog(meterNO,1,0,opName);
	        		webService_Service.updateMeterSwitchState(meterNO,1);	        		
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
        	}
        }
	    
	    return Data;
	}



//	public OperatorLog findOperatorLogById(String id) throws Exception {
//		return operatorLogMapper.findOperatorLogById(id);
//	}


}
