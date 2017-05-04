package com.web.util;

import java.util.UUID;

/** 
* @ClassName: UUIDUtil 
* @Description: 获取数据库主键
* @author lj
* @date 2014-4-17 
*/ 
public class UUIDUtil {
	
	/** 
	* @Description: 获取UUID
	* @author lj
	* @return String
	* @date 2014-4-17
	*/
	public static String getUUID()
	{
		String s = UUID.randomUUID().toString();
	    return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	}

}
