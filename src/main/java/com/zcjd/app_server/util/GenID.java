package com.zcjd.app_server.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 生成id
 * @author Administrator
 *
 */
public class GenID {

	/**
	 * 生成UUID 32位
	 * @return
	 */
	public static String GenUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * yyMMddHHmmssSSS日期编号Id 15位
	 * @return
	 */
	public static String genDateCODE(){
		Date  date = new Date();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		return sdf.format(date);
	}
}
