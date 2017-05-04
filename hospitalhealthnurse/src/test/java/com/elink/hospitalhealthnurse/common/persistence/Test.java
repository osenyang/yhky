package com.elink.hospitalhealthnurse.common.persistence;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;

public class Test {
	
	public static void main(String[] args) throws IOException {
//		Integer videoTime = 30;
//		String totalTime = "1016";
//		
//		videoTime = (videoTime*60) - Integer.parseInt(totalTime);
//		System.out.println(videoTime);
//		if(videoTime <= 0){
//			videoTime = 0;
//		}
//		double v= (double)videoTime/60;
//		Double s = Math.ceil(v);
//		System.out.println(s.intValue());
//		String date = "2016-09-09";
//		boolean result = false;
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
//		String currentDate = DateUtils.getDate();
//		try {
//			Date dt1 = df.parse(date);
//			Date currentTime = df.parse(currentDate);
//			if (currentTime.getTime() == dt1.getTime()) {
//				result = true;
//			} 
//		} catch (Exception exception) {
//			exception.printStackTrace();
//		}
//		
//		System.out.println(result);
		
//		int money = 3000/2;
//		System.out.println(money);
		
//		String surplusVideoTime = "3600";  
//		System.out.println(DateUtils.secToTime(Integer.parseInt(surplusVideoTime)));  
		
		System.out.println(DateUtils.getLastDate(9));
		
	}
	
}
