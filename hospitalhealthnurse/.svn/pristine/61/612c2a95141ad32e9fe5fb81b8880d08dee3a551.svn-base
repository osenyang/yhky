package com.elink.hospitalhealthnurse.modules.healtharchives.enumlist;

import org.eclipse.draw2d.SWTEventDispatcher;

import com.elink.hospitalhealthnurse.common.utils.StringUtils;

public class EnumList {
	/**
	 * 护理计划菜单枚举类型
	 * */
	public enum CareMenu{
		NUSER_GRADE("护理级别"),DEIT_NUSER("饮食护理"),VEIN_INFUSION("静脉输液"),
		OXYGEN("吸氧"),REPLACE_WEF_FLASK("更换湿化瓶"),SPUTUM_SUCTION("吸痰"),    
		ATOMIZATION("雾化"),ORAL_NUSER("口腔护理"),URETER_NUSER("尿管护理"),    
		DEEP_VEIN("深静脉置管护理"),TRACHEA_NUSER("气管切开护理"),ORAL_MEDICINE("口服药"),   
		CHINESE_MEDICINE("中药"),SPECIAL_MEDICINE("特殊用药"),RECOVERY_NUSER("康复护理"),
		NUTRITION_MEAL("营养餐"),HEALTH_EDUCATION("健康教育"),FALL_RISK("跌倒风险"),
		ULCER_RISK("压疮风险"),ANXIETY("孤独、焦虑、抑郁"),LANGUAGE_BALK("语言沟通障碍"),
		SLEEP_DISORDER("睡眠状态紊乱"),TEMPERATURE_OVERTOP("体温过高"),RESPIRATORY_TRACT("清理呼吸道无效"),
		PAIN("疼痛"),CONSTIPATION("便秘"),INCONTINENCE("失禁"), ACTIVITY_INTOLERANCE("活动无耐力"), 
		POTENTIAL_ASPHYXIA("潜在并发症：窒息"),POTENTIAL_BLEEDING("潜在并发症：出血"),POTENTIAL_INFECTION("潜在并发症：感染");
		
		private String values;
		
		private CareMenu(String values){
			this.values = values;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
	}
	
	/**
	 * 护理计划-护理间隔时间
	 * */
	public enum CareIntervalTime{
		CAREINTERVAL_1(1,"每小时一次"),
		CAREINTERVAL_2(2,"每两小时一次 "),
		CAREINTERVAL_4(4,"每四小时一次 "),
		CAREINTERVAL_6(6,"每六小时一次 "),
		CAREINTERVAL_8(8,"每八小时一次"),
		CAREINTERVAL_31(31,"每天一次"),
		CAREINTERVAL_32(32,"每天两次"),
		CAREINTERVAL_33(33,"每天三次"),
		CAREINTERVAL_34(34,"每天四次"),
		CAREINTERVAL_41(41,"隔天一次"),
		CAREINTERVAL_64(64,"每周四次"),
		CAREINTERVAL_0(0,"其他"),
		CAREINTERVAL_51(51,"每周一次"),
		CAREINTERVAL_91(91,"医嘱"),
		CAREINTERVAL_92(92,"睡前"),
		CAREINTERVAL_93(93,"睡时"),;
		// 定义私有变量
		private Integer index;
		
		private String values;
		
		private CareIntervalTime(Integer index,String values){
			this.index = index;
			this.values = values;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		
		public static String findValueByIndex(Integer index){
			String returnStr = "";
	        for (CareIntervalTime ci : CareIntervalTime.values()) {
	            if (ci.index == index) {
	            	return ci.values;
	            }
	        }
	        return returnStr;
		}
	}

	/**
	 * 护理计划-护理级别
	 * */
	public enum CareNuserGrade{
		ONE("1","病危"),TWO("2","病重"),THREE("3","Ⅰ级护理"),FOUR("4","Ⅱ级护理"),FIVE("5","Ⅲ级护理");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareNuserGrade(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		
		public static String findByIndex(String index){
			String returnStr = "";
	        for (CareNuserGrade ng : CareNuserGrade.values()) {
	            if (StringUtils.containStr(index, ng.index)) {
	            	returnStr += "," + ng.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}

	/**
	 * 护理计划-饮食护理
	 * */
	public enum CareDeitNuser{
		ONE("1","普通饮食"),TWO("2","流质饮食"),THREE("3","低盐低脂饮食"),FOUR("4","糖尿病饮食"),FIVE("5","软食"),SIX("6","禁食");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareDeitNuser(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		
		public static String findByIndex(String index){
			String returnStr = "";
	        for (CareDeitNuser cd : CareDeitNuser.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}

	}
	
	/**
	 * 护理计划-吸氧  
	 * */
	public enum CareOxygen{
		ONE("1","持续吸氧"),TWO("2","吸氧管"),THREE("3","面罩"),FOUR("4","间断吸氧");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareOxygen(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		
		public static String findByIndex(String index){
			String returnStr = "";
	        for (CareOxygen cd : CareOxygen.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}

	}
	/**
	 * 护理计划-特殊用药
	 * */
	public enum CareSpecialMedicine{
		SPECIAL_MEDICINE_1("1","餐前"),
		SPECIAL_MEDICINE_2("2","早"),
		SPECIAL_MEDICINE_3("3","中 "),
		SPECIAL_MEDICINE_4("4","晚"),
		SPECIAL_MEDICINE_5("5","餐中途"),
		SPECIAL_MEDICINE_6("6","早 "),
		SPECIAL_MEDICINE_7("7","中 "),
		SPECIAL_MEDICINE_8("8","晚 "),
		SPECIAL_MEDICINE_9("9","晨起 "),
		SPECIAL_MEDICINE_10("10","睡前 "),
		SPECIAL_MEDICINE_0("0","其他 ");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareSpecialMedicine(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		
		public static String findByIndex(String index){
			String returnStr = "";
	        for (CareSpecialMedicine cd : CareSpecialMedicine.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}

	}
	/**
	 * 护理计划-康复护理
	 * */
	public enum CareRecoveryNuser{
		Recovery_Nuser_1("1","良肢位摆放"),
		Recovery_Nuser_2("2","进食（饮水）训练"),
		Recovery_Nuser_3("3","行走训练  "),
		Recovery_Nuser_4("4","穿衣训练"),
		Recovery_Nuser_5("5","洗漱训练"),
		Recovery_Nuser_6("6","记忆力训练"),
		Recovery_Nuser_0("0","其他");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareRecoveryNuser(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		
		public static String findByIndex(String index){
			String returnStr = "";
	        for (CareRecoveryNuser cd : CareRecoveryNuser.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}

	}
	/**
	 * 护理计划-健康教育 
	 * */
	public enum CareHealthEducation{
		ENUM_VALUE_1("1","高血压"),
		ENUM_VALUE_2("2","糖尿病"),
		ENUM_VALUE_3("3","肺炎 "),
		ENUM_VALUE_4("4","COPD"),
		ENUM_VALUE_5("5","冠心病"),
		ENUM_VALUE_6("6","痛风"),
		ENUM_VALUE_7("7","脑梗塞（脑出血）"),
		ENUM_VALUE_8("8","帕金森"),
		ENUM_VALUE_9("9","美尼尔氏综合症"),
		ENUM_VALUE_10("10","消化道出血"),
		ENUM_VALUE_0("0","其他 ");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareHealthEducation(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareHealthEducation cd : CareHealthEducation.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-跌倒风险
	 * */
	public enum CareFallRisk{
		ENUM_VALUE_1("1","评估危险因数并记录"),
		ENUM_VALUE_2("2","环境安全管理 "),
		ENUM_VALUE_3("3","警示标识"),
		ENUM_VALUE_4("4","床档 "),
		ENUM_VALUE_5("5","保护性约束"),
		ENUM_VALUE_6("6","陪护");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareFallRisk(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareFallRisk cd : CareFallRisk.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 护理计划-压疮风险
	 * */
	public enum CareUlcerRisk{
		ENUM_VALUE_1("1","评估皮肤受损的危险因数并记录"),
		ENUM_VALUE_2("2","当时正确更换体位 "),
		ENUM_VALUE_3("3","警示标识 "),
		ENUM_VALUE_4("4","给予减压用具"),
		ENUM_VALUE_5("5","定时翻身"),
		ENUM_VALUE_6("6","每小时一次"),
		ENUM_VALUE_7("7","每两小时一次 "),
		ENUM_VALUE_8("8","每四小时一次"),
		ENUM_VALUE_9("9","其他"),
		ENUM_VALUE_10("10","营养指导"),
		ENUM_VALUE_11("11","皮肤护理-洗澡（擦拭）"),
		ENUM_VALUE_12("12","每天一次"),
		ENUM_VALUE_13("13","隔天一次"),
		ENUM_VALUE_14("14","每周四次"),
		ENUM_VALUE_15("15","其他"),
		ENUM_VALUE_0("0","其他");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareUlcerRisk(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareUlcerRisk cd : CareUlcerRisk.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
		/*根据index查询value*/
		public static String getByIndex(String index){
			String returnStr = "";
	        switch (index) {
	        case "0":
	        	returnStr=ENUM_VALUE_0.getValues();
	        	break;
			case "1":
				returnStr=ENUM_VALUE_1.getValues();
				break;
			case "2":
				returnStr=ENUM_VALUE_2.getValues();
				break;
			case "3":
				returnStr=ENUM_VALUE_3.getValues();
				break;
			case "4":
				returnStr=ENUM_VALUE_4.getValues();
				break;
			case "5":
				returnStr=ENUM_VALUE_5.getValues();
				break;
			case "6":
				returnStr=ENUM_VALUE_7.getValues();
				break;
			case "7":
				returnStr=ENUM_VALUE_7.getValues();
				break;
			case "8":
				returnStr=ENUM_VALUE_8.getValues();
				break;
			case "9":
				returnStr=ENUM_VALUE_9.getValues();
				break;
			case "10":
				returnStr=ENUM_VALUE_10.getValues();
				break;
			case "11":
				returnStr=ENUM_VALUE_11.getValues();
				break;
			case "12":
				returnStr=ENUM_VALUE_12.getValues();
				break;
			case "13":
				returnStr=ENUM_VALUE_13.getValues();
				break;
			case "14":
				returnStr=ENUM_VALUE_14.getValues();
				break;
			case "15":
				returnStr=ENUM_VALUE_15.getValues();
				break;
			default:
				break;
			}
	        return returnStr;
		}
	}
	/**
	 * 护理计划-孤独、焦虑、抑郁    
	 * */
	public enum CareAnxiety{
		ENUM_VALUE_1("1","讲解疾病治疗、转归及预后知识"),
		ENUM_VALUE_2("2","指导患者采取放松措施"),
		ENUM_VALUE_3("3","听音乐"),
		ENUM_VALUE_4("4","讲故事"),
		ENUM_VALUE_5("5","聊天"),
		ENUM_VALUE_6("6","看电视"),
		ENUM_VALUE_7("0","其他"),
		ENUM_VALUE_8("7","心理支持");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareAnxiety(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareAnxiety cd : CareAnxiety.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 护理计划-语言沟通障碍    
	 * */
	public enum CareLanguageBalk{
		ENUM_VALUE_1("1","尊重患者"),
		ENUM_VALUE_2("2","使用肢体语言沟通"),
		ENUM_VALUE_3("3","借助纸笔方式沟通"),
		ENUM_VALUE_4("4","其他（采用是否问答方式）");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareLanguageBalk(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareLanguageBalk cd : CareLanguageBalk.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-睡眠状态紊乱
	 * */
	public enum CareSleepDisorder{
		ENUM_VALUE_1("1","提供安静舒适的病区环境"),
		ENUM_VALUE_2("2","尽量减少对患者的干扰"),
		ENUM_VALUE_3("3","指导患者运用睡眠促进措施"),
		ENUM_VALUE_4("4","遵医嘱用药并评价其效果");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareSleepDisorder(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareSleepDisorder cd : CareSleepDisorder.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 护理计划-体温过高   
	 * **/
	public enum CareTemperatureOvertop{
		ENUM_VALUE_1("1","测量体温"),
		ENUM_VALUE_2("2","物理降温"),
		ENUM_VALUE_3("3","药物温度及效果观察"),
		ENUM_VALUE_4("4","皮肤护理");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareTemperatureOvertop(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareTemperatureOvertop cd : CareTemperatureOvertop.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-清理呼吸道无效
	 * */
	public enum CareRespiratoryTract{
		ENUM_VALUE_1("1","指导咳嗽 "),
		ENUM_VALUE_2("2","呼吸训练"),
		ENUM_VALUE_3("3","每天一次"),
		ENUM_VALUE_4("4","每天两次"),
		ENUM_VALUE_5("5","每天三次"),
		ENUM_VALUE_6("0","其他"),
		ENUM_VALUE_7("6","雾化吸入"),
		ENUM_VALUE_8("7","吸痰"),
		ENUM_VALUE_9("8","体位引流");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareRespiratoryTract(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareRespiratoryTract cd : CareRespiratoryTract.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
		/*根据index查询value*/
		public static String getByIndex(String index){
			String returnStr = "";
	        switch (index) {
	        case "0":
	        	returnStr=ENUM_VALUE_6.getValues();
	        	break;
			case "1":
				returnStr=ENUM_VALUE_1.getValues();
				break;
			case "2":
				returnStr=ENUM_VALUE_2.getValues();
				break;
			case "3":
				returnStr=ENUM_VALUE_3.getValues();
				break;
			case "4":
				returnStr=ENUM_VALUE_4.getValues();
				break;
			case "5":
				returnStr=ENUM_VALUE_5.getValues();
				break;
			case "6":
				returnStr=ENUM_VALUE_7.getValues();
				break;
			case "7":
				returnStr=ENUM_VALUE_8.getValues();
				break;
			case "8":
				returnStr=ENUM_VALUE_9.getValues();
				break;
			default:
				break;
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-疼痛
	 * */
	public enum CarePain{
		ENUM_VALUE_1("1","评估疼痛级别"),
		ENUM_VALUE_2("2","观察记录疼痛性质、程度、规律"),
		ENUM_VALUE_3("3","指导使用放松技术"),
		ENUM_VALUE_4("4","按医嘱使用止痛剂");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CarePain(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CarePain cd : CarePain.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-便秘 
	 * */
	public enum CareConstipation{
		ENUM_VALUE_1("1","饮食指导"),
		ENUM_VALUE_2("2","活动指导"),
		ENUM_VALUE_3("3","局部按摩"),
		ENUM_VALUE_4("4","缓泻剂应用 "),
		ENUM_VALUE_5("5","灌肠治疗"),
		ENUM_VALUE_6("6","记录排便次数");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareConstipation(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareConstipation cd : CareConstipation.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-失禁 
	 * */
	public enum CareIncontinence{
		ENUM_VALUE_1("1","评估失禁程度"),
		ENUM_VALUE_2("2","观察排尿规律"),
		ENUM_VALUE_3("3","正确使用便器 "),
		ENUM_VALUE_4("4","帮助不方便的患者排尿"),
		ENUM_VALUE_5("5","正确使用尿不湿"),
		ENUM_VALUE_6("6","加强会阴部皮肤护理");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareIncontinence(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareIncontinence cd : CareIncontinence.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-活动无耐力   
	 * */
	public enum CareActivityIntolerance{
		ENUM_VALUE_1("1","评估患者活动能力"),
		ENUM_VALUE_2("2","协助患者完成生活护理"),
		ENUM_VALUE_3("3","防跌倒指导 "),
		ENUM_VALUE_4("4","指导床上活动");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareActivityIntolerance(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CareActivityIntolerance cd : CareActivityIntolerance.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-潜在并发症：窒息
	 * */
	public enum CarePotentialAsphyxia{
		ENUM_VALUE_1("1","评估可能发生窒息的危险因数并记录"),
		ENUM_VALUE_2("2","保护呼吸道通畅"),
		ENUM_VALUE_3("3","体位管理"),
		ENUM_VALUE_4("4","床旁备吸痰器");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CarePotentialAsphyxia(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CarePotentialAsphyxia cd : CarePotentialAsphyxia.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-潜在并发症：出血   
	 * */
	public enum CarePotentialBleeding{
		ENUM_VALUE_1("1","检查生命体征、意识 "),
		ENUM_VALUE_2("2","观察引流物性质及量"),
		ENUM_VALUE_3("3","观察伤口敷料"),
		ENUM_VALUE_4("4","观察皮肤颜色及温度"),
		ENUM_VALUE_5("5","遵医嘱使用止血药");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CarePotentialBleeding(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CarePotentialBleeding cd : CarePotentialBleeding.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 护理计划-潜在并发症：感染    
	 * */
	public enum CarePotentialInfection{
		ENUM_VALUE_1("1","监测患者体温、脉搏"),
		ENUM_VALUE_2("2","观察引流物的性质"),
		ENUM_VALUE_3("3","加强管道护理"),
		ENUM_VALUE_4("4","口腔护理"),
		ENUM_VALUE_5("5","伤口护理");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CarePotentialInfection(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (CarePotentialInfection cd : CarePotentialInfection.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 照护计划-菜单枚举
	 * */
	public enum NurserEnum{
		CARE_LEVEL("照护级别"),
		DEIT_NUSER("饮食护理"),
		CAVITY_CLEAN("介护口腔清洗"),
		PERINEAL_WASH("介护会阴冲洗"),
		BATH_BATH("介护洗澡"),
		WASH_HAIR("介护洗头"),
		ORAL_MEDICINE("介护服药"),
		CHINESE_MEDICINE("介护服中药"),
		TURN_OVER("翻身"),
		BACKSLAP("拍背"),
		SKIP_WATCH("皮肤观察"),
		BELLY_MASSAGE("下腹部按摩"),
		DRINK_WATER("饮水"),
		COMMUNICATE("沟通"),
		DAILY_LIFE("日常生活活动能力下降"),
		SKIP_INTEGRITY("皮肤完整性受损的危险"),
		ANXIETY("孤独、焦虑"),
		SOLICITUDE("关怀"),
		WALK_TRAIN("行走训练"),
		ASTRICTION("便秘"),
		POTENTIAL_INFECTION("潜在并发症:感染"),
		OTHER("其他");
		
		// 定义私有变量
		private String values;
		
		private NurserEnum(String values){
			this.values = values;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
	}
	
	/**
	 * 照护计划-菜单-照护级别枚举
	 * */
	public enum NurserPanLevelEnum{
		ENUM_VALUE_1("1","特级照护"),
		ENUM_VALUE_2("2","Ⅲ级照护"),
		ENUM_VALUE_3("3","Ⅱ级照护"),
		ENUM_VALUE_4("4","Ⅰ级照护");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanLevelEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanLevelEnum cd : NurserPanLevelEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 照护计划-菜单-饮食护理枚举
	 * */
	public enum NurserPanDietEnum{
		ENUM_VALUE_1("1","普通饮食"),
		ENUM_VALUE_2("2","流质饮食"),
		ENUM_VALUE_3("3","低盐低脂饮食"),
		ENUM_VALUE_4("4","糖尿病饮食"),
		ENUM_VALUE_5("5","营养餐");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanDietEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanDietEnum cd : NurserPanDietEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 照护计划-菜单-介护洗头枚举
	 * */
	public enum NurserPanWashHairEnum{
		ENUM_VALUE_1("62","BW"),
		ENUM_VALUE_2("0","其他");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanWashHairEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanWashHairEnum cd : NurserPanWashHairEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 照护计划-菜单-翻身枚举
	 * */
	public enum NurserPanTurnOverEnum{
		ENUM_VALUE_1("1","定时翻身"),
		ENUM_VALUE_2("2","每小时一次"),
		ENUM_VALUE_3("3","每两小时一次"),
		ENUM_VALUE_4("4","每四小时一次"),
		ENUM_VALUE_5("0","其他");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanTurnOverEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanTurnOverEnum cd : NurserPanTurnOverEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 照护计划-菜单-皮肤观察枚举
	 * */
	public enum NurserPanSkinObservationEnum{
		ENUM_VALUE_1("1","床单元整洁"),
		ENUM_VALUE_2("2","皮肤观察"),
		ENUM_VALUE_3("3","每小时一次"),
		ENUM_VALUE_4("4","每两小时一次"),
		ENUM_VALUE_5("5","每四小时一次"),
		ENUM_VALUE_6("6","每六小时一次");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanSkinObservationEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanSkinObservationEnum cd : NurserPanSkinObservationEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
		/*根据index查询value*/
		public static String getByIndex(String index){
			String returnStr = "";
			for (NurserPanSkinObservationEnum cd : NurserPanSkinObservationEnum.values()) {
				if (index.equals(cd.index)) {
					returnStr=cd.values;
					break;
				}
			}
			return returnStr;
		}
	}
	/**
	 * 照护计划-菜单-日常生活活动能力下降枚举
	 * */
	public enum NurserPanDecreasedLivingAbiliEnum{
		ENUM_VALUE_1("1","常用物品放置在老人易取的地方"),
		ENUM_VALUE_2("2","协助进食"),
		ENUM_VALUE_3("3","协助洗漱"),
		ENUM_VALUE_4("4","协助更衣");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanDecreasedLivingAbiliEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanDecreasedLivingAbiliEnum cd : NurserPanDecreasedLivingAbiliEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 照护计划-菜单-皮肤完整性受损的危险枚举
	 * */
	public enum NurserPanRiskSkinIntegrityEnum{
		ENUM_VALUE_1("1","评估危险因数并记录"),
		ENUM_VALUE_2("2","环境安全管理"),
		ENUM_VALUE_3("3","警示标识"),
		ENUM_VALUE_4("4","床档"),
		ENUM_VALUE_5("5","必要时使用安全带");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanRiskSkinIntegrityEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanRiskSkinIntegrityEnum cd : NurserPanRiskSkinIntegrityEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	/**
	 * 照护计划-菜单-孤独、焦虑枚举
	 * */
	public enum NurserPanLonelinessAnxietyEnum{
		ENUM_VALUE_1("1","听音乐"),
		ENUM_VALUE_2("2","看电视"),
		ENUM_VALUE_3("3","折纸"),
		ENUM_VALUE_4("4","熟悉的话题沟通"),
		ENUM_VALUE_5("5","心理支持"),
		ENUM_VALUE_6("6","使用肢体语言沟通"),
		ENUM_VALUE_7("7","借助纸笔方式沟通"),
		ENUM_VALUE_8("0","其他(采用是否问题方式)");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanLonelinessAnxietyEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanLonelinessAnxietyEnum cd : NurserPanLonelinessAnxietyEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 照护计划-菜单-关怀枚举
	 * */
	public enum NurserPanCareEnum{
		ENUM_VALUE_1("1","职业尊称"),
		ENUM_VALUE_2("2","职务尊称"),
		ENUM_VALUE_3("3","年龄尊称"),
		ENUM_VALUE_4("4","心理慰藉[每天两次]");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanCareEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanCareEnum cd : NurserPanCareEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 照护计划-菜单-行走训练枚举
	 * */
	public enum NurserPanWalkingTrainingEnum{
		ENUM_VALUE_1("1","协助行走"),
		ENUM_VALUE_2("2","提供安静舒适的病区环境"),
		ENUM_VALUE_3("3","尽量减少对患者的干扰");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanWalkingTrainingEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanWalkingTrainingEnum cd : NurserPanWalkingTrainingEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 照护计划-菜单-便秘枚举
	 * */
	public enum NurserPanAstrictionEnum{
		ENUM_VALUE_1("1","饮食指导"),
		ENUM_VALUE_2("2","活动指导"),
		ENUM_VALUE_3("3","药物应用"),
		ENUM_VALUE_4("4","下腹部顺时针按摩"),
		ENUM_VALUE_5("5","记录排便次数");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanAstrictionEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanAstrictionEnum cd : NurserPanAstrictionEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 照护计划-菜单-潜在并发症:感染枚举
	 * */
	public enum NurserPanPotentialComplicationsEnum{
		ENUM_VALUE_1("1","拍背"),
		ENUM_VALUE_2("2","注意保暖"),
		ENUM_VALUE_3("3","坐起"),
		ENUM_VALUE_4("4","口腔清洁");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private NurserPanPotentialComplicationsEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (NurserPanPotentialComplicationsEnum cd : NurserPanPotentialComplicationsEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	/**
	 * 康复计划-康复项目
	 * */
	public enum RecoverAcupunctureEnum{
		ENUM_VALUE_1("1","温针"),
		ENUM_VALUE_2("2","头皮针");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private RecoverAcupunctureEnum(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
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
	        for (RecoverAcupunctureEnum cd : RecoverAcupunctureEnum.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}
	
	
	/**
	 * 护理计划-饮食护理
	 * */
/*	public enum CareDeitNuser{
		ENUM_VALUE_1("1","普通饮食"),
		ENUM_VALUE_2("2","流质饮食"),
		ENUM_VALUE_3("3","低盐低脂饮食"),
		ENUM_VALUE_4("4","糖尿病饮食"),
		ENUM_VALUE_5("5","软食"),
		ENUM_VALUE_6("6","禁食");
		
		// 定义私有变量
		private String index;
		private String values;
		
		private CareDeitNuser(String index,String values){
			this.index = index;
			this.values = values;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		//根据index查询value
		public static String findByIndex(String index){
			String returnStr = "";
	        for (CareDeitNuser cd : CareDeitNuser.values()) {
	            if (StringUtils.containStr(index, cd.index)) {
	            	returnStr += "," + cd.values;
	            }
	        }
	        if(StringUtils.isNotBlank(returnStr)){
	        	returnStr = returnStr.substring(1);
			}
	        return returnStr;
		}
	}*/
}
