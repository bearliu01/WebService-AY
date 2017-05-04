/**  
* @Title: MusterService.java 
* @Package com.flag.util
* @Description:socket操作类
* @author x.zitao 
* @date 2014-12-23
*/
package com.web.util;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/** 
 * @Description:
 * @author x.zitao
 * @return ARMCilentSocket
 * @date 2014-12-23
 */
public class ARMCilentSocket {

	/**
	 * 远程抄表IP
	 */
	private String ip;   	
	/**
	 * 远程抄表端口
	 */
	private int port;   	
	/**
	 * 返回数据
	 */
	public String Data="";
	/**
	 * Socket连接
	 */
	public Socket socket = null;   	
	/**
	 * DataOutputStream数据输出流 将Java基本数据类型写入数据输出流中。并可以通过数据输入流DataInputStream将数据读入。
	 */
	DataOutputStream out = null;   	
	/**
	 * 数据输入流
	 */
	DataInputStream getMessageStream = null;   
	
	public ARMCilentSocket(String ip, int port) {   
	    this.ip = ip;   
	    this.port = port;   
	}  
	
	public ARMCilentSocket() {   
	   
	}
	
	/**  
	 * 创建socket连接  
	 *   
	 * @throws Exception            
	 */
	public void CreateConnection() throws Exception {
	    try {	    				
	    	//socket = BaseSocket.getSocket(ip, port);
	    	socket = new Socket(ip,port);
	    	socket.setKeepAlive(true);
	    } catch (Exception e) {
	    	Data = "底层连接失败";
	    	System.out.println("Socket建立错误:"+e.getMessage());
	    	
	    	if (socket != null)
	    		socket.close();
	        throw e;   
	    }
	}   
	
	/**
	 * 
	* @Description:发送消息
	* @param sendMessage
	* @throws Exception
	* void
	* @author x.zitao
	* @date 2014-12-23
	 */
	public void sendMessage(byte[] sendMessage) throws Exception {   
	    try {   
	    	if (sendMessage != null){	    		
	    		out = new DataOutputStream(socket.getOutputStream());   
		        out.write(sendMessage);   
		        out.flush();		        
	    	}             
	    } catch (Exception e) {   
	        e.printStackTrace();   
	        if (out != null)   
	            out.close();   
	        throw e;   
	    } finally {   
	    }   
	}   
	
	/**
	 * 
	* @Description:接收消息
	* @return
	* @throws Exception
	* DataInputStream
	* @author x.zitao
	* @date 2014-12-23
	 */
	public DataInputStream getMessageStream() throws Exception {
		getMessageStream = null; 
	    try {   
	        getMessageStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));   
	        return getMessageStream;   
	    } catch (Exception e) {   
	        e.printStackTrace();   
	        if (getMessageStream != null)   
	            getMessageStream.close();   
	        throw e;   
	    } finally {
	    	
	    }   
	}   
	
	/**
	 * 关闭socket连接
	 *
	 */
	public void shutDownConnection() {   
	    try {   
	        if (out != null)   
	            out.close();   
	        if (getMessageStream != null)   
	            getMessageStream.close();   
	        if (socket != null)   
	            socket.close();   
	    } catch (Exception e) {   
	    	System.out.println(e.getMessage());
	    }   
	}
	
	
	
}