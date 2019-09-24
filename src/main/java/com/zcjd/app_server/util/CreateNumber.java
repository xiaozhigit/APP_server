package com.zcjd.app_server.util;



import com.zcjd.app_server.model.CoderulePojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CreateNumber {

	/**
	 * @param coderule 编码规则
	 * @param number_list 根据编码规则得到该规则下所有的账号
	 * @return 403表示流水号已到最大值
	 * @throws Exception 
	 */
	public static String productNumber(CoderulePojo coderule, List<String> number_list){
		
		//流水号起始值:1
		Integer beginVal = coderule.getFirstNumber() == null ? 0 : coderule.getFirstNumber();
		Integer numberLength = coderule.getNumberLength();
		String code = "";
		//循环判断编号是否存在
		if(number_list != null && number_list.size() > 0){
			 while(number_list.size()>0) {
				code =  CreateNumber.returnNumber(coderule,beginVal);
				 number_list.contains(code);
				 if(number_list.contains(code)){
					 beginVal++;
					 if(beginVal.toString().length() > numberLength){
						 return "403";
					 }
				 }else{
					 return code;
				 }
			 }
		}else{
			code =  CreateNumber.returnNumber(coderule,beginVal);
		}
		return code;
	}
	/**
	 * 生成编号
	 * @param pojo
	 * @param begin起始值
	 * @return
	 */
	public static String returnNumber(CoderulePojo pojo,int begin){
		//最终的编号 num_str
		//流水号起始值 fnum;//流水号长度  numl;
		String num_str="";
		if(pojo!=null){
			int fl = String.valueOf(begin).length();//流水号起始值
			//流水号
			String zero = "";
			for(int i=0;i<pojo.getNumberLength()-fl;i++){
				zero +="0";
			}
			//流水号字符串 
			String f_num = zero + begin;
			//获取日期格式字符串 d_num
			Date date = new Date();
			String dateStyle = pojo.getDateStyle();
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateStyle);
			String d_num = dateFormat.format(date);

			num_str = pojo.getPrefixValue()+pojo.getPrefixSeparatorDate()+d_num
			+pojo.getDateSeparatorNumber()+f_num+pojo.getNumberSeparatorSuffix()
			+pojo.getSuffixValue();
		}
		return num_str;
	}
}
