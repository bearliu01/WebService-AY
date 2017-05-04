package com.web.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Tools {

	
	/**
	 * 取系统当前日期
	 * @param 
	 * @return 返回系统日期 yyyy-MM-dd HH:mm:ss
	 */
	public static String getNow()
	{
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = df.format(new Date());
		return str;
	}
	
	/**
	 * 
	 * 描述： 获取当前日期
	 * @参数：null
	 * @返回值：返回系统日期 yyMMdd
	 */
	public static String getNowDT(){
		SimpleDateFormat df =new SimpleDateFormat("yyMMdd");
		String str = df.format(new Date());
		return str;
	}
	
	/**
	 * 描述：获取当前日期yyyy年MM月dd日  星期
	 * @return
	 */
	public static String getNowWeek(){
		SimpleDateFormat df =new SimpleDateFormat("yyyy年MM月dd日  EEEE");
		String str = df.format(new Date());		
		return str;
	}
		
	/**
	 * 浮点数转换成两位小数
	 * @param 传入double型数值
	 * @return 返回保留两位小数的字符串
	 */
	public static String formatFloat(double db){		
		DecimalFormat df = new DecimalFormat("#.00");	
		return df.format(db);
	}
	
	/**
	 * 
	 * 描述： 根据传入的仪表序号重写recno
	 * @参数：recNo
	 * @返回值：recNo
	 */
	public static String formatRecNo(String recNo){
		switch(recNo.length()){
			case 1 :
				recNo = "000"+recNo ;
				break;
			case 2 :
				recNo = "00"+recNo ;
				break;
			case 3 :
				recNo = "0"+recNo ;
				break;		
			default :
				recNo = "0001" ;
		}
		return recNo;
	}
	
	/**
	 * 
	 * 描述：返回n天前日期 格式yyyy-MM-dd
	 * @param n
	 * @return
	 */
	public static String getForNDay(int n){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -n);    
		String  dayDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return dayDate;
	}
	
	/**
	 * 
	 * 描述：返回n天后日期 格式yyyyMMdd
	 * @param n
	 * @return
	 */
	public static String getForNRDay(int n){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n);    
		String  dayDate = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return dayDate;
	}
	
	/**
	 * 
	 * 描述：得到前n个月的月份字符串
	 * @param n
	 * @return
	 */
	public static String getForNMonth(int n){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -n);
		String  monthDate = new SimpleDateFormat("yyyy-MM").format(cal.getTime());
		return monthDate;
	}	

	/**
	 * 
	 * 描述：用指定字符填充字符串
	 * @param id
	 * @param len
	 * @param c
	 * @return
	 */
	public static String lpad(String id,int len,char c){
		if(!id.equals("")){
			while(id.length()<len){
				id=c+id;
			}
		}
		return id;
	}
	
	/**
	 * 将日期字符串类型转换成Integer类型 ,格式为 yyyyMMdd 例：返回20091011
	 * @param str
	 * @return
	 */
	public static Integer getIntDate(String str) {	   
	   str = str.replace("-", "").substring(0,8);
	   Integer intDate = Integer.parseInt(str);
	   return intDate;
	}
	
	/**
	 * 计算bdate-smdate之间的天数
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    } 
	
	/**
	 * 
	 * 描述：判断字符串是不是数字类型
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str){ 
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"); 
	}
	
	/**
	 * 描述：获取服务器MAC地址
	 * @return
	 * @throws IOException
	 */
	public static String getMacByIp() throws IOException{
    	String MacStr="";
		InetAddress ia;
		try {
			ia = InetAddress.getLocalHost();
			byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();			
			StringBuffer sb = new StringBuffer("");
			for(int i=0; i<mac.length; i++) {
				//字节转换为整数
				int temp = mac[i]&0xff;
				String str = Integer.toHexString(temp);				
				if(str.length()==1) {
					sb.append("0"+str);
				}else {
					sb.append(str);
				}
			}
			MacStr = sb.toString().toUpperCase();
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}
		
    	return MacStr;
    }
	/**
	 * 
	 * @Description 获取当前年
	 * @return
	 */
	public static String getCurDateY() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(date);
	}
	
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	}	
	
	/**
	 * 字符串转换成日期时间
	 * @param 传入字符串
	 * @return 返回被格式化的日期 yyyy-MM-dd HH:mm:ss
	 */
	public static Date strToDateTime(String str)
	{
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        Date date = null;
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}   
        return date;
	}
	
	/**
	 * @Description: 获取系统当前日期
	 * @return String
	 */
	public static String getCurDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	/** 
	* @Description:获取系统当前月第一天日期
	* @return String
	*/
	public static String getFirstDateByCurMonth(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		return format.format(date)+"-01";
	}
	public static String getCurMonth() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		return format.format(date);
	}
	/**
	 * 获取从当前月向后推一年的日期
	 * @Description 
	 * @return
	 */
	public static String getLastOneYear() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -1);
		date=calendar.getTime();
		String currentDate=format.format(date);
		return currentDate;
	}
	/** 
	* @Description:当前月向前推1个月的日期  eg2016-12-06向前一月是2016-11-07
	* @author zj
	* @return String
	* @date 2016-12-6
	*/
	public static String getLastOneMonth() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)-1);
		curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)+1);
		Date date=curr.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return  format.format(date);

	}
	/**
	 * 获取从当前月向后推一年的日期
	 * @Description 
	 * @return
	 */
	public static String getLastOneYears() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -1);
		date=calendar.getTime();
		String currentDate=format.format(date);
		return currentDate;
	}
	
	public static void main(String[] args) {
		System.out.println(Tools.getNowWeek());
	}

}
