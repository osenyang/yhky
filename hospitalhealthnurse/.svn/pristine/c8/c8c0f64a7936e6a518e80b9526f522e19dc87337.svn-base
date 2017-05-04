package com.elink.hospitalhealthnurse.modules.healtharchives.enumlist;

import com.elink.hospitalhealthnurse.common.utils.StringUtils;

public class ArrangeEnum {
	// 1. 定义枚举类型 
	public enum ArrangeList{
		OTHER(0,"其他"),ONE(1,"01:00"),TWO(2,"02:00"),THREE(3,"03:00"),FOUR(4,"04:00"),FIVE(5,"05:00"),
		SIX(6,"06:00"),SEVEN(7,"07:00"),EIGHT(8,"08:00"),NINE(9,"09:00"),TEN(10,"10:00"),
		ELEVEN(11,"11:00"),TWELVE(12,"12:00"),THIRTEEN(13,"13:00"),FOURTEEN(14,"14:00"),FIFTEEN(15,"15:00"),
		SIXTEEN(16,"16:00"),SEVENTEEN(17,"17:00"),EIGHTEEN(18,"18:00"),NINETEEN(19,"19:00"),TWENTY(20,"20:00"),
		TWENTY_ONE(21,"21:00"),TWENTY_TWO(22,"22:00"),TWENTY_THREE(23,"23:00"),TWENTY_FOUR(24,"24:00");
		
		// 定义私有变量
		private int index;
		
		private String values;
		
		private ArrangeList(int index,String values){
			this.index = index;
			this.values = values;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		/*根据index查询value*/
		public static String findByIndex(String index){
			String returnStr = "";
			if(StringUtils.isNotBlank(index)){
				for (ArrangeList cd : ArrangeList.values()) {
		        	String[] strs = index.split(",");
		        	for(String str : strs){
		        		if (Integer.valueOf(str) == cd.index){
			            	returnStr += "," + cd.values;
			            }
		        	}
		        }
		        if(StringUtils.isNotBlank(returnStr)){
		        	returnStr = returnStr.substring(1);
				}
			}
	        return returnStr;
		}
	}
}
