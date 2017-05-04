package com.elink.hospitalhealthnurse.modules.plan.utils;

public enum PlanProjectTypeEnum {
	
	ASSESSMENT("000","诊疗"),
	
	CARE_NURSE_GRADE("100","护理等级"),
	CARE_DIET_NUSER("101","饮食护理"),
	CARE_VEIN_INFUSION("102","静脉输液"),
	CARE_OXYGEN("103","吸氧"),
	CARE_REPLACE_WEF_FLASK("104","更换湿化瓶"),
	CARE_SPUTUM_SUCTION("105","吸痰 "),     
	CARE_ATOMIZATION("106","雾化"),         
	CARE_ORAL_NUSER("107","口腔护理"),         
	CARE_URETER_NUSER("108","尿管护理"),         
	CARE_DEEP_VEIN("109","深静脉置管护理"),         
	CARE_TRACHEA_NUSER("110","气管切开护理 "),         
	CARE_ORAL_MEDICINE("111","口服药"),         
	CARE_CHINESE_MEDICINE("112","中药"),         
	CARE_SPECIAL_MEDICINE("113","特殊用药"),         
	CARE_RECOVERY_NUSER("114","康复护理"),         
	CARE_NUTRITION_MEAL("115","营养餐"),         
	CARE_HEALTH_EDUCATION("116","健康教育"),         
	CARE_FALL_RISK("117","跌倒风险"),         
	CARE_ULCER_RISK("118","压疮风险"),         
	CARE_ANXIETY("119","孤独、焦虑、抑郁"),         
	CARE_LANGUAGE_BALK("120","语言沟通障碍"),         
	CARE_SLEEP_DISORDER("121","睡眠状态紊乱"),         
	CARE_TEMPERATURE_OVER_TOP("122","体温过高"),         
	CARE_RESPIRATORY_TRACT("123","清理呼吸道无效"),         
	CARE_PAIN("124","疼痛"),         
	CARE_CONSTIPATION("125","便秘"),         
	CARE_INCONTINENCE("126","失禁"),         
	CARE_ACTIVITY_INTOLERANCE("127","活动无耐力"),         
	CARE_POTENTIAL_ASPHYXIA("128","潜在并发症：窒息"),         
	CARE_POTENTIAL_BLEEDING("129","潜在并发症：出血"),         
	CARE_POTENTIAL_INFECTION("130","潜在并发症：感染"),         
	CARE_OTHER("131","其他"),
	
	NURSER_CARE_LEVEL("200","照护级别"),
	NURSER_DIET_NURSER("201","饮食护理"),
	NURSER_CAVITY_CLEAN("202","介护口腔清洗"),
	NURSER_PERINEAL_WASH("203","介护会阴冲洗"),
	NURSER_BATH_BATH("204","介护洗澡"),
	NURSER_WASH_HAIR("205","介护洗头"),
	NURSER_ORAL_MEDICINE("206","介护服药"),
	NURSER_CHINESE_MEDICINE("207","介护服中药"),
	NURSER_TRUN_OVER("208","翻身"),
	NURSER_BACKSLAP("209","拍背"),
	NURSER_SKIN_WATCH("210","皮肤观察"),
	NURSER_BELLY_MASSAGE("211","下腹部按摩"),
	NURSER_DRINK_WATER("212","饮水"),
	NURSER_COMMUNICATE("213","沟通"),
	NURSER_DAILY_LIFE("214","日常生活活动能力下降"),
	NURSER_SKIN_INTEGRITY("215","皮肤完整性受损的危险"),
	NURSER_ANXIETY("216","孤独、焦虑"),
	NURSER_SOLICITUDE("217","关怀"),
	NURSER_WALK_TRAIN("218","行走训练"),
	NURSER_ASTRICTION("219","便秘"),
	NURSER_POTENTIAL_INFECTION("220","潜在并发症：感染"),
	NURSER_OTHER("221","其他"),
	
	NUTRITION_FOOD("300","普食"),
	NUTRITION_PAPMEAT("301","软食"),
	NUTRITION_SEMI_LIQUID("302","半流质"),
	NUTRITION_LIQUID("303","流质"),
	NUTRITION_ONS("304","口服营养补充"),
	NUTRITION_TEN("305","全天肠内营养"),
	NUTRITION_PEN("306","部分肠内"),
	NUTRITION_PPN("307","部分肠外"),
	NUTRITION_TPN("308","全天肠外营养"),
	NUTRITION_DRINK_WATER("309","饮水/喂水量"),
	
	RECOVER_ACUPUNCTURE("400","温针、头皮针"),
	RECOVER_PSYCHOLOGY_RECOVER("401","心理康复"),
	RECOVER_LIMBS_TRAIN("402","偏瘫肢体综合训练"),
	RECOVER_TASK_TREATMENT("403","作业治疗"),
	
	HOBBY("500","兴趣爱好"),
	MEET("600","应急计划"),
	;           
	public static final String ASSESSMENT_CODE="000";
	public static final String CARE_NURSE_GRADE_CODE="100";
	public static final String CARE_DIET_NUSER_CODE="101";
	public static final String CARE_VEIN_INFUSION_CODE="102";
	public static final String CARE_OXYGEN_CODE="103";
	public static final String CARE_REPLACE_WEF_FLASK_CODE="104";
	public static final String CARE_SPUTUM_SUCTION_CODE="105";     
	public static final String CARE_ATOMIZATION_CODE="106";     
	public static final String CARE_ORAL_NUSER_CODE="107";        
	public static final String CARE_URETER_NUSER_CODE="108"; 
	public static final String CARE_DEEP_VEIN_CODE="109";         
	public static final String CARE_TRACHEA_NUSER_CODE="110";     
	public static final String CARE_ORAL_MEDICINE_CODE="111";        
	public static final String CARE_CHINESE_MEDICINE_CODE="112";       
	public static final String CARE_SPECIAL_MEDICINE_CODE="113";        
	public static final String CARE_RECOVERY_NUSER_CODE="114";         
	public static final String CARE_NUTRITION_MEAL_CODE="115";         
	public static final String CARE_HEALTH_EDUCATION_CODE="116";        
	public static final String CARE_FALL_RISK_CODE="117";         
	public static final String CARE_ULCER_RISK_CODE="118";         
	public static final String CARE_ANXIETY_CODE="119";         
	public static final String CARE_LANGUAGE_BALK_CODE="120";         
	public static final String CARE_SLEEP_DISORDER_CODE="121";         
	public static final String CARE_TEMPERATURE_OVER_TOP_CODE="122";        
	public static final String CARE_RESPIRATORY_TRACT_CODE="123";         
	public static final String CARE_PAIN_CODE="124";         
	public static final String CARE_CONSTIPATION_CODE="125";         
	public static final String CARE_INCONTINENCE_CODE="126";         
	public static final String CARE_ACTIVITY_INTOLERANCE_CODE="127";         
	public static final String CARE_POTENTIAL_ASPHYXIA_CODE="128";         
	public static final String CARE_POTENTIAL_BLEEDING_CODE="129";        
	public static final String CARE_POTENTIAL_INFECTION_CODE="130";         
	public static final String CARE_OTHER_CODE="131";
	
	public static final String NURSER_CARE_LEVEL_CODE="200";
	public static final String NURSER_DIET_NURSER_CODE="201";
	public static final String NURSER_CAVITY_CLEAN_CODE="202";
	public static final String NURSER_PERINEAL_WASH_CODE="203";
	public static final String NURSER_BATH_BATH_CODE="204";
	public static final String NURSER_WASH_HAIR_CODE="205";
	public static final String NURSER_ORAL_MEDICINE_CODE="206";
	public static final String NURSER_CHINESE_MEDICINE_CODE="207";
	public static final String NURSER_TRUN_OVER_CODE="208";
	public static final String NURSER_BACKSLAP_CODE="209";
	public static final String NURSER_SKIN_WATCH_CODE="210";
	public static final String NURSER_BELLY_MASSAGE_CODE="211";
	public static final String NURSER_DRINK_WATER_CODE="212";
	public static final String NURSER_COMMUNICATE_CODE="213";
	public static final String NURSER_DAILY_LIFE_CODE="214";
	public static final String NURSER_SKIN_INTEGRITY_CODE="215";
	public static final String NURSER_ANXIETY_CODE="216";
	public static final String NURSER_SOLICITUDE_CODE="217";
	public static final String NURSER_WALK_TRAIN_CODE="218";
	public static final String NURSER_ASTRICTION_CODE="219";
	public static final String NURSER_POTENTIAL_INFECTION_CODE="220";
	public static final String NURSER_OTHER_CODE="221";
	
	public static final String NUTRITION_FOOD_CODE="300";
	public static final String NUTRITION_PAPMEAT_CODE="301";
	public static final String NUTRITION_SEMI_LIQUID_CODE="302";
	public static final String NUTRITION_LIQUID_CODE="303";
	public static final String NUTRITION_ONS_CODE="304";
	public static final String NUTRITION_TEN_CODE="305";
	public static final String NUTRITION_PEN_CODE="306";
	public static final String NUTRITION_PPN_CODE="307";
	public static final String NUTRITION_TPN_CODE="308";
	public static final String NUTRITION_DRINK_WATER_CODE="309";
	
	public static final String RECOVER_ACUPUNCTURE_CODE="400";
	public static final String RECOVER_PSYCHOLOGY_RECOVER_CODE="401";
	public static final String RECOVER_LIMBS_TRAIN_CODE="402";
	public static final String RECOVER_TASK_TREATMENT_CODE="403";
	
	public static final String HOBBY_CODE="500";
	public static final String MEET_CODE="600";
	;           
	         

	
	
	private String code;
	private String desc;
	
	private PlanProjectTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
    public static String getDesc(String code) {
        switch (code) {
			case "000":
				return ASSESSMENT.getDesc();
			case "101":
				return CARE_DIET_NUSER.getDesc();
			case "102":
				return CARE_VEIN_INFUSION.getDesc();
			case "103":
				return CARE_OXYGEN.getDesc();
			case "104":
				return CARE_REPLACE_WEF_FLASK.getDesc();
			case "105":
				return CARE_SPUTUM_SUCTION.getDesc();
			case "106":
				return CARE_ATOMIZATION.getDesc();
			case "107":
				return CARE_ORAL_NUSER.getDesc();
			case "108":
				return CARE_URETER_NUSER.getDesc();
			case "109":
				return CARE_DEEP_VEIN.getDesc();
			case "110":
				return CARE_TRACHEA_NUSER.getDesc();
			case "111":
				return CARE_ORAL_MEDICINE.getDesc();
			case "112":
				return CARE_CHINESE_MEDICINE.getDesc();
			case "113":
				return CARE_SPECIAL_MEDICINE.getDesc();
			case "114":
				return CARE_RECOVERY_NUSER.getDesc();
			case "115":
				return CARE_NUTRITION_MEAL.getDesc();
			case "116":
				return CARE_HEALTH_EDUCATION.getDesc();
			case "117":
				return CARE_FALL_RISK.getDesc();
			case "118":
				return CARE_ULCER_RISK.getDesc();
			case "119":
				return CARE_ANXIETY.getDesc();
			case "121":
				return CARE_SLEEP_DISORDER.getDesc();
			case "122":
				return CARE_TEMPERATURE_OVER_TOP.getDesc();
			case "123":
				return CARE_RESPIRATORY_TRACT.getDesc();
			case "124":
				return CARE_PAIN.getDesc();
			case "125":
				return CARE_CONSTIPATION.getDesc();
			case "126":
				return CARE_INCONTINENCE.getDesc();
			case "127":
				return CARE_ACTIVITY_INTOLERANCE.getDesc();
			case "128":
				return CARE_POTENTIAL_ASPHYXIA.getDesc();
			case "129":
				return CARE_POTENTIAL_BLEEDING.getDesc();
			case "130":
				return CARE_POTENTIAL_INFECTION.getDesc();
			case "131":
				return CARE_OTHER.getDesc();
			case "200":
				return NURSER_CARE_LEVEL.getDesc();
			case "201":
				return NURSER_DIET_NURSER.getDesc();
			case "202":
				return NURSER_CAVITY_CLEAN.getDesc();
			case "203":
				return NURSER_PERINEAL_WASH.getDesc();
			case "204":
				return NURSER_BATH_BATH.getDesc();
			case "205":
				return NURSER_WASH_HAIR.getDesc();
			case "206":
				return NURSER_ORAL_MEDICINE.getDesc();
			case "207":
				return NURSER_CHINESE_MEDICINE.getDesc();
			case "208":
				return NURSER_TRUN_OVER.getDesc();
			case "209":
				return NURSER_BACKSLAP.getDesc();
			case "210":
				return NURSER_SKIN_WATCH.getDesc();
			case "211":
				return NURSER_BELLY_MASSAGE.getDesc();
			case "212":
				return NURSER_DRINK_WATER.getDesc();
			case "213":
				return NURSER_COMMUNICATE.getDesc();
			case "214":
				return NURSER_DAILY_LIFE.getDesc();
			case "215":
				return NURSER_SKIN_INTEGRITY.getDesc();
			case "216":
				return NURSER_ANXIETY.getDesc();
			case "217":
				return NURSER_SOLICITUDE.getDesc();
			case "218":
				return NURSER_WALK_TRAIN.getDesc();
			case "219":
				return NURSER_ASTRICTION.getDesc();
			case "220":
				return NURSER_POTENTIAL_INFECTION.getDesc();
			case "221":
				return NURSER_OTHER.getDesc();
			case "300":
				return NUTRITION_FOOD.getDesc();
			case "301":
				return NUTRITION_PAPMEAT.getDesc();
			case "302":
				return NUTRITION_SEMI_LIQUID.getDesc();
			case "303":
				return NUTRITION_LIQUID.getDesc();
			case "304":
				return NUTRITION_ONS.getDesc();
			case "305":
				return NUTRITION_TEN.getDesc();
			case "306":
				return NUTRITION_PEN.getDesc();
			case "307":
				return NUTRITION_PPN.getDesc();
			case "308":
				return NUTRITION_TPN.getDesc();
			case "309":
				return NUTRITION_DRINK_WATER.getDesc();
			case "400":
				return RECOVER_ACUPUNCTURE.getDesc();
			case "401":
				return RECOVER_PSYCHOLOGY_RECOVER.getDesc();
			case "402":
				return RECOVER_LIMBS_TRAIN.getDesc();
			case "403":
				return RECOVER_TASK_TREATMENT.getDesc();
			case "500":
				return HOBBY.getDesc();
			case "600":
				return MEET.getDesc();
			default:
				break;
		}
        return null;
    }
	
}
