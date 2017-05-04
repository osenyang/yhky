package com.elink.hospitalhealthnurse.modules.plan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/***
 * 
 * @author elink
 *
 */
public class SerialNumberGenUtils {
	/***
	 * 根据参数获取过去的日期
	 * @param statType (1:最近一周，2:最近一月，3:最近一季, 4: 最近一年,4:自定义)
	 * @return
	 */
	public static String genSerialNumber(){
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(date);
         
         String number =UUID.randomUUID().toString()+"_"+dateStr;
		return number;
	}
	public static void main(String[] args){
		SerialNumberGenUtils.genSerialNumber();
	}
}
