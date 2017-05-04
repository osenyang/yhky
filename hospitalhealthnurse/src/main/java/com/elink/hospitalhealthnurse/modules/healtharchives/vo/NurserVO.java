package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList;

/**
 * 照护计划Entity
 * @author 杜康
 * @version 2016-11-03
 */
public class NurserVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String doctorId; //主管医师  
	private String nurseId; //主管护士  
	private String directorId; //主管护理员  
	private String careDiagnosis; //照护诊断  
	private String fallScore; //跌倒评分  
	private String ulcerScore; //压疮评分  
	private String mmseScore; //MMSE  
	private String adlScore; //ADL  
	private String watianScore; //洼田饮水  
	private String careLevel; //照护级别  
	private String careLevelQuartersId; //照护级别(执行人/岗位)  
	private java.util.Date careLevelTime; //照护级别(执行时间)  
	private String deitNuser; //饮食护理  
	private String deitNuserQuartersId; //饮食护理(执行人/岗位)  
	private java.util.Date deitNuserTime; //饮食护理(执行时间)  
	private String cavityClean; //介护口腔清洗  
	private String cavityCleanQuartersId; //介护口腔清洗(执行人/岗位)  
	private java.util.Date cavityCleanTime; //介护口腔清洗(执行时间)  
	private String perinealWash; //介护会阴冲洗  
	private String perinealWashQuartersId; //介护会阴冲洗(执行人/岗位)  
	private java.util.Date perinealWashTime; //介护会阴冲洗(执行时间)  
	private String bathBath; //介护洗澡  
	private String bathBathQuartersId; //介护洗澡(执行人/岗位)  
	private java.util.Date bathBathTime; //介护洗澡(执行时间)  
	private String washHair; //介护洗头  
	private String washHairQuartersId; //介护洗头(执行人/岗位)  
	private java.util.Date washHairTime; //介护洗头(执行时间)  
	private String oralMedicine; //介护服药  
	private String oralMedicineQuartersId; //介护服药(执行人/岗位)  
	private java.util.Date oralMedicineTime; //介护服药(执行时间)  
	private String chineseMedicine; //介护服中药  
	private String chineseMedicineQuartersId; //介护服中药(执行人/岗位)  
	private java.util.Date chineseMedicineTime; //介护服中药(执行时间)  
	private String turnOver; //翻身  
	private String turnOverQuartersId; //翻身(执行人/岗位)  
	private java.util.Date turnOverTime; //翻身(执行时间)  
	private String backslap; //拍背  
	private String backslapQuartersId; //拍背(执行人/岗位)  
	private java.util.Date backslapTime; //拍背(执行时间)  
	private String skipWatch; //皮肤观察  
	private String skipWatchQuartersId; //皮肤观察(执行人/岗位)  
	private java.util.Date skipWatchTime; //皮肤观察(执行时间)  
	private String skipWatchOther; //皮肤观察(其他)  
	private String bellyMassage; //下腹部按摩  
	private String bellyMassageQuartersId; //下腹部按摩(执行人/岗位)  
	private java.util.Date bellyMassageTime; //下腹部按摩(执行时间)  
	private String drinkWater; //饮水  
	private String drinkWaterQuartersId; //饮水(执行人/岗位)  
	private java.util.Date drinkWaterTime; //饮水(执行时间)  
	private String communicate; //沟通  
	private String communicateQuartersId; //沟通(执行人/岗位)  
	private java.util.Date communicateTime; //沟通(执行时间)  
	private String dailyLife; //日常生活活动能力下降  
	private String dailyLifeQuartersId; //日常生活活动能力下降(执行人/岗位)  
	private java.util.Date dailyLifeTime; //日常生活活动能力下降(执行时间)  
	private String skipIntegrity; //皮肤完整性受损的危险  
	private String skipIntegrityQuartersId; //皮肤完整性受损的危险(执行人/岗位)  
	private java.util.Date skipIntegrityTime; //皮肤完整性受损的危险(执行时间)  
	private String anxiety; //孤独、焦虑  
	private String anxietyQuartersId; //孤独、焦虑(执行人/岗位)  
	private java.util.Date anxietyTime; //孤独、焦虑(执行时间)  
	private String solicitude; //关怀  
	private String solicitudeQuartersId; //关怀(执行人/岗位)  
	private java.util.Date solicitudeTime; //关怀(执行时间)  
	private String walkTrain; //行走训练  
	private String walkTrainQuartersId; //行走训练(执行人/岗位)  
	private java.util.Date walkTrainTime; //行走训练(执行时间)  
	private String astriction; //便秘  
	private String astrictionQuartersId; //便秘(执行人/岗位)  
	private java.util.Date astrictionTime; //便秘(执行时间)  
	private String potentialInfection; //潜在并发症：感染  
	private String potentialInfectionQuartersId; //潜在并发症：感染(执行人/岗位)  
	private java.util.Date potentialInfectionTime; //潜在并发症：感染(执行时间)  
	private String other; //其他  
	private String doctorNm; //主管医师  
	private String nurseNm; //主管护士  
	private String directorNm; //主管护理员  
	private String careLevelQuartersNm; //照护级别(执行人/岗位)  
	private String deitNuserQuartersNm; //饮食护理(执行人/岗位)  
	private String cavityCleanQuartersNm; //介护口腔清洗(执行人/岗位)  
	private String perinealWashQuartersNm; //介护会阴冲洗(执行人/岗位)  
	private String bathBathQuartersNm; //介护洗澡(执行人/岗位)  
	private String washHairQuartersNm; //介护洗头(执行人/岗位)  
	private String oralMedicineQuartersNm; //介护服药(执行人/岗位)  
	private String chineseMedicineQuartersNm; //介护服中药(执行人/岗位)  
	private String turnOverQuartersNm; //翻身(执行人/岗位)  
	private String backslapQuartersNm; //拍背(执行人/岗位)  
	private String skipWatchQuartersNm; //皮肤观察(执行人/岗位)  
	private String bellyMassageQuartersNm; //下腹部按摩(执行人/岗位)  
	private String drinkWaterQuartersNm; //饮水(执行人/岗位)  
	private String communicateQuartersNm; //沟通(执行人/岗位)  
	private String dailyLifeQuartersNm; //日常生活活动能力下降(执行人/岗位)  
	private String skipIntegrityQuartersNm; //皮肤完整性受损的危险(执行人/岗位)  
	private String anxietyQuartersNm; //孤独、焦虑(执行人/岗位)  
	private String solicitudeQuartersNm; //关怀(执行人/岗位)  
	private String walkTrainQuartersNm; //行走训练(执行人/岗位)  
	private String astrictionQuartersNm; //便秘(执行人/岗位)  
	private String potentialInfectionQuartersNm; //潜在并发症：感染(执行人/岗位)  
	private String cavityCleanOther; //介护口腔清洗(其他)  
	private String perinealWashOther; //介护会阴冲洗(其他)  
	private String bathBathOther; //介护洗澡(其他)  
	private String washHairOther; //介护洗头(其他)  
	private String oralMedicineOther; //介护服药(其他)  
	private String chineseMedicineOther; //介护服中药(其他)  
	private String turnOverOther; //翻身(其他)  
	private String backslapOther; //拍背(其他)  
	private String bellyMassageOther; //下腹部按摩(其他)  
	private String drinkWaterOther; //饮水(其他)  
	private String communicateOther; //沟通(其他) 
	private String extraItemsId;//额外项目ID
	
	private String careLevelNm; //照护级别  
	private String deitNuserNm; //饮食护理  
	private String cavityCleanNm; //介护口腔清洗  
	private String perinealWashNm; //介护会阴冲洗  
	private String bathBathNm; //介护洗澡  
	private String washHairNm; //介护洗头  
	private String oralMedicineNm; //介护服药  
	private String chineseMedicineNm; //介护服中药  
	private String turnOverNm; //翻身  
	private String backslapNm; //拍背  
	private String skipWatchNm; //皮肤观察  
	private String bellyMassageNm; //下腹部按摩  
	private String drinkWaterNm; //饮水  
	private String communicateNm; //沟通  
	private String dailyLifeNm; //日常生活活动能力下降  
	private String skipIntegrityNm; //皮肤完整性受损的危险  
	private String anxietyNm; //孤独、焦虑  
	private String solicitudeNm; //关怀  
	private String walkTrainNm; //行走训练  
	private String astrictionNm; //便秘  
	private String potentialInfectionNm; //潜在并发症：感染 
	
	private List<ItemVO> CarePlanList; //照护计划与频次
	private List<ItemVO> CareProjectList; //照护项目
	
	private String doctorPhoto; //主管医师  
	private String nursePhoto; //主管护士  
	private String directorPhoto; //主管护理员 
	
	/**介护口腔清洗 */
	private String cavityCleanType;//频次类型（0、天,1、周）
	private String cavityCleanInterval;//间隔时间
	private String cavityCleanDetails;//时间数组
	/**介护会阴冲洗  */
	private String perinealWashType;//频次类型（0、天,1、周）
	private String perinealWashInterval;//间隔时间
	private String perinealWashDetails;//时间数组
	/**介护洗澡  */
	private String bathBathType;//频次类型（0、天,1、周）
	private String bathBathInterval;//间隔时间
	private String bathBathDetails;//时间数组
	/**介护洗头  */
	private String washHairType;//频次类型（0、天,1、周）
	private String washHairInterval;//间隔时间
	private String washHairDetails;//时间数组
	/**介护服药 */
	private String oralMedicineType;//频次类型（0、天,1、周）
	private String oralMedicineInterval;//间隔时间
	private String oralMedicineDetails;//时间数组
	/**介护服中药*/
	private String chineseMedicineType;//频次类型（0、天,1、周）
	private String chineseMedicineInterval;//间隔时间
	private String chineseMedicineDetails;//时间数组
	/**翻身  */
	private String turnOverType;//频次类型（0、天,1、周）
	private String turnOverInterval;//间隔时间
	private String turnOverDetails;//时间数组
	/**拍背*/
	private String backslapType;//频次类型（0、天,1、周）
	private String backslapInterval;//间隔时间
	private String backslapDetails;//时间数组
	/**下腹部按摩   */
	private String bellyMassageType;//频次类型（0、天,1、周）
	private String bellyMassageInterval;//间隔时间
	private String bellyMassageDetails;//时间数组
	/**饮水*/
	private String drinkWaterType;//频次类型（0、天,1、周）
	private String drinkWaterInterval;//间隔时间
	private String drinkWaterDetails;//时间数组
	/**沟通*/
	private String communicateType;//频次类型（0、天,1、周）
	private String communicateInterval;//间隔时间
	private String communicateDetails;//时间数组

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDoctorId(){
		return doctorId;
	}  
		
	public void setDoctorId(String doctorId){
		this.doctorId = doctorId;
	}  
	
	public String getNurseId(){
		return nurseId;
	}  
		
	public void setNurseId(String nurseId){
		this.nurseId = nurseId;
	}  
	
	public String getDirectorId(){
		return directorId;
	}  
		
	public void setDirectorId(String directorId){
		this.directorId = directorId;
	}  
	
	public String getCareDiagnosis(){
		return careDiagnosis;
	}  
		
	public void setCareDiagnosis(String careDiagnosis){
		this.careDiagnosis = careDiagnosis;
	}  
	
	public String getFallScore(){
		return fallScore;
	}  
		
	public void setFallScore(String fallScore){
		this.fallScore = fallScore;
	}  
	
	public String getUlcerScore(){
		return ulcerScore;
	}  
		
	public void setUlcerScore(String ulcerScore){
		this.ulcerScore = ulcerScore;
	}  
	
	public String getMmseScore(){
		return mmseScore;
	}  
		
	public void setMmseScore(String mmseScore){
		this.mmseScore = mmseScore;
	}  
	
	public String getAdlScore(){
		return adlScore;
	}  
		
	public void setAdlScore(String adlScore){
		this.adlScore = adlScore;
	}  
	
	public String getWatianScore(){
		return watianScore;
	}  
		
	public void setWatianScore(String watianScore){
		this.watianScore = watianScore;
	}  
	
	public String getCareLevel(){
		return EnumList.NurserPanLevelEnum.findByIndex(careLevel);
	}  
		
	public void setCareLevel(String careLevel){
		this.careLevel = careLevel;
	}  
	
	public String getCareLevelQuartersId(){
		return careLevelQuartersId;
	}  
		
	public void setCareLevelQuartersId(String careLevelQuartersId){
		this.careLevelQuartersId = careLevelQuartersId;
	}  
	
	public java.util.Date getCareLevelTime(){
		return careLevelTime;
	}  
		
	public void setCareLevelTime(java.util.Date careLevelTime){
		this.careLevelTime = careLevelTime;
	}  
	
	public String getDeitNuser(){
		return EnumList.NurserPanDietEnum.findByIndex(deitNuser);
	}  
		
	public void setDeitNuser(String deitNuser){
		this.deitNuser = deitNuser;
	}  
	
	public String getDeitNuserQuartersId(){
		return deitNuserQuartersId;
	}  
		
	public void setDeitNuserQuartersId(String deitNuserQuartersId){
		this.deitNuserQuartersId = deitNuserQuartersId;
	}  
	
	public java.util.Date getDeitNuserTime(){
		return deitNuserTime;
	}  
		
	public void setDeitNuserTime(java.util.Date deitNuserTime){
		this.deitNuserTime = deitNuserTime;
	}  
	
	public String getCavityClean(){
		if(StringUtils.isNotBlank(cavityClean)){
			if("0".equals(cavityClean) && StringUtils.isNotBlank(this.getCavityCleanOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(cavityClean))+"("+this.getCavityCleanOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(cavityClean));
		}
		return cavityClean;
	}  
		
	public void setCavityClean(String cavityClean){
		this.cavityClean = cavityClean;
	}  
	
	public String getCavityCleanQuartersId(){
		return cavityCleanQuartersId;
	}  
		
	public void setCavityCleanQuartersId(String cavityCleanQuartersId){
		this.cavityCleanQuartersId = cavityCleanQuartersId;
	}  
	
	public java.util.Date getCavityCleanTime(){
		return cavityCleanTime;
	}  
		
	public void setCavityCleanTime(java.util.Date cavityCleanTime){
		this.cavityCleanTime = cavityCleanTime;
	}  
	
	public String getPerinealWash(){
		/*if(StringUtils.isNotBlank(perinealWash)){
			if("0".equals(perinealWash) && StringUtils.isNotBlank(this.getPerinealWashOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(perinealWash))+"("+this.getPerinealWashOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(perinealWash));
		}*/
		return perinealWash;
	}  
		
	public void setPerinealWash(String perinealWash){
		this.perinealWash = perinealWash;
	}  
	
	public String getPerinealWashQuartersId(){
		return perinealWashQuartersId;
	}  
		
	public void setPerinealWashQuartersId(String perinealWashQuartersId){
		this.perinealWashQuartersId = perinealWashQuartersId;
	}  
	
	public java.util.Date getPerinealWashTime(){
		return perinealWashTime;
	}  
		
	public void setPerinealWashTime(java.util.Date perinealWashTime){
		this.perinealWashTime = perinealWashTime;
	}  
	
	public String getBathBath(){
		/*if(StringUtils.isNotBlank(bathBath)){
			if("0".equals(bathBath) && StringUtils.isNotBlank(this.getBathBathOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(bathBath))+"("+this.getBathBathOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(bathBath));
		}*/
		return bathBath;
	}  
		
	public void setBathBath(String bathBath){
		this.bathBath = bathBath;
	}  
	
	public String getBathBathQuartersId(){
		return bathBathQuartersId;
	}  
		
	public void setBathBathQuartersId(String bathBathQuartersId){
		this.bathBathQuartersId = bathBathQuartersId;
	}  
	
	public java.util.Date getBathBathTime(){
		return bathBathTime;
	}  
		
	public void setBathBathTime(java.util.Date bathBathTime){
		this.bathBathTime = bathBathTime;
	}  
	
	public String getWashHair(){
		/*if(StringUtils.containInt(washHair, "0") && StringUtils.isNotBlank(this.getWashHairOther())){
			return EnumList.NurserPanWashHairEnum.findByIndex(washHair)+"("+this.getWashHairOther()+")";
		}*/
		return EnumList.NurserPanWashHairEnum.findByIndex(washHair);
	}  
		
	public void setWashHair(String washHair){
		this.washHair = washHair;
	}  
	
	public String getWashHairQuartersId(){
		return washHairQuartersId;
	}  
		
	public void setWashHairQuartersId(String washHairQuartersId){
		this.washHairQuartersId = washHairQuartersId;
	}  
	
	public java.util.Date getWashHairTime(){
		return washHairTime;
	}  
		
	public void setWashHairTime(java.util.Date washHairTime){
		this.washHairTime = washHairTime;
	}  
	
	public String getOralMedicine(){
		/*if(StringUtils.isNotBlank(oralMedicine)){
			if("0".equals(oralMedicine) && StringUtils.isNotBlank(this.getOralMedicineOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(oralMedicine))+"("+this.getOralMedicineOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(oralMedicine));
		}*/
		return oralMedicine;
	}  
		
	public void setOralMedicine(String oralMedicine){
		this.oralMedicine = oralMedicine;
	}  
	
	public String getOralMedicineQuartersId(){
		return oralMedicineQuartersId;
	}  
		
	public void setOralMedicineQuartersId(String oralMedicineQuartersId){
		this.oralMedicineQuartersId = oralMedicineQuartersId;
	}  
	
	public java.util.Date getOralMedicineTime(){
		return oralMedicineTime;
	}  
		
	public void setOralMedicineTime(java.util.Date oralMedicineTime){
		this.oralMedicineTime = oralMedicineTime;
	}  
	
	public String getChineseMedicine(){
		/*if(StringUtils.isNotBlank(chineseMedicine)){
			if("0".equals(chineseMedicine) && StringUtils.isNotBlank(this.getChineseMedicineOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(chineseMedicine))+"("+this.getChineseMedicineOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(chineseMedicine));
		}*/
		return chineseMedicine;
	}  
		
	public void setChineseMedicine(String chineseMedicine){
		this.chineseMedicine = chineseMedicine;
	}  
	
	public String getChineseMedicineQuartersId(){
		return chineseMedicineQuartersId;
	}  
		
	public void setChineseMedicineQuartersId(String chineseMedicineQuartersId){
		this.chineseMedicineQuartersId = chineseMedicineQuartersId;
	}  
	
	public java.util.Date getChineseMedicineTime(){
		return chineseMedicineTime;
	}  
		
	public void setChineseMedicineTime(java.util.Date chineseMedicineTime){
		this.chineseMedicineTime = chineseMedicineTime;
	}  
	
	public String getTurnOver(){
		/*if(StringUtils.containInt(turnOver, "0") && StringUtils.isNotBlank(this.getTurnOverOther())){
			return EnumList.NurserPanTurnOverEnum.findByIndex(turnOver)+"("+this.getTurnOverOther()+")";
		}*/
		return EnumList.NurserPanTurnOverEnum.findByIndex(turnOver);
	}  
		
	public void setTurnOver(String turnOver){
		this.turnOver = turnOver;
	}  
	
	public String getTurnOverQuartersId(){
		return turnOverQuartersId;
	}  
		
	public void setTurnOverQuartersId(String turnOverQuartersId){
		this.turnOverQuartersId = turnOverQuartersId;
	}  
	
	public java.util.Date getTurnOverTime(){
		return turnOverTime;
	}  
		
	public void setTurnOverTime(java.util.Date turnOverTime){
		this.turnOverTime = turnOverTime;
	}  
	
	public String getBackslap(){
		/*if(StringUtils.isNotBlank(backslap)){
			if("0".equals(backslap) && StringUtils.isNotBlank(this.getBackslapOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(backslap))+"("+this.getBackslapOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(backslap));
		}*/
		return backslap;
	}  
		
	public void setBackslap(String backslap){
		this.backslap = backslap;
	}  
	
	public String getBackslapQuartersId(){
		return backslapQuartersId;
	}  
		
	public void setBackslapQuartersId(String backslapQuartersId){
		this.backslapQuartersId = backslapQuartersId;
	}  
	
	public java.util.Date getBackslapTime(){
		return backslapTime;
	}  
		
	public void setBackslapTime(java.util.Date backslapTime){
		this.backslapTime = backslapTime;
	}  
	
	public String getSkipWatch(){
		return EnumList.NurserPanSkinObservationEnum.findByIndex(skipWatch);
	}  
		
	public void setSkipWatch(String skipWatch){
		this.skipWatch = skipWatch;
	}  
	
	public String getSkipWatchQuartersId(){
		return skipWatchQuartersId;
	}  
		
	public void setSkipWatchQuartersId(String skipWatchQuartersId){
		this.skipWatchQuartersId = skipWatchQuartersId;
	}  
	
	public java.util.Date getSkipWatchTime(){
		return skipWatchTime;
	}  
		
	public void setSkipWatchTime(java.util.Date skipWatchTime){
		this.skipWatchTime = skipWatchTime;
	}  
	
	public String getSkipWatchOther(){
		return skipWatchOther;
	}  
		
	public void setSkipWatchOther(String skipWatchOther){
		this.skipWatchOther = skipWatchOther;
	}  
	
	public String getBellyMassage(){
		/*if(StringUtils.isNotBlank(bellyMassage)){
			if("0".equals(bellyMassage) && StringUtils.isNotBlank(this.getBellyMassageOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(bellyMassage))+"("+this.getBellyMassageOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(bellyMassage));
		}*/
		return bellyMassage;
	}  
		
	public void setBellyMassage(String bellyMassage){
		this.bellyMassage = bellyMassage;
	}  
	
	public String getBellyMassageQuartersId(){
		return bellyMassageQuartersId;
	}  
		
	public void setBellyMassageQuartersId(String bellyMassageQuartersId){
		this.bellyMassageQuartersId = bellyMassageQuartersId;
	}  
	
	public java.util.Date getBellyMassageTime(){
		return bellyMassageTime;
	}  
		
	public void setBellyMassageTime(java.util.Date bellyMassageTime){
		this.bellyMassageTime = bellyMassageTime;
	}  
	
	public String getDrinkWater(){
		/*if(StringUtils.isNotBlank(drinkWater)){
			if("0".equals(drinkWater) && StringUtils.isNotBlank(this.getDrinkWaterOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(drinkWater))+"("+this.getDrinkWaterOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(drinkWater));
		}*/
		return drinkWater;
	}  
		
	public void setDrinkWater(String drinkWater){
		this.drinkWater = drinkWater;
	}  
	
	public String getDrinkWaterQuartersId(){
		return drinkWaterQuartersId;
	}  
		
	public void setDrinkWaterQuartersId(String drinkWaterQuartersId){
		this.drinkWaterQuartersId = drinkWaterQuartersId;
	}  
	
	public java.util.Date getDrinkWaterTime(){
		return drinkWaterTime;
	}  
		
	public void setDrinkWaterTime(java.util.Date drinkWaterTime){
		this.drinkWaterTime = drinkWaterTime;
	}  
	
	public String getCommunicate(){
		/*if(StringUtils.isNotBlank(communicate)){
			if("0".equals(communicate) && StringUtils.isNotBlank(this.getCommunicateOther())){
				return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(communicate))+"("+this.getCommunicateOther()+")";
			}
			return EnumList.CareIntervalTime.findValueByIndex(Integer.valueOf(communicate));
		}*/
		return communicate;
	}  
		
	public void setCommunicate(String communicate){
		this.communicate = communicate;
	}  
	
	public String getCommunicateQuartersId(){
		return communicateQuartersId;
	}  
		
	public void setCommunicateQuartersId(String communicateQuartersId){
		this.communicateQuartersId = communicateQuartersId;
	}  
	
	public java.util.Date getCommunicateTime(){
		return communicateTime;
	}  
		
	public void setCommunicateTime(java.util.Date communicateTime){
		this.communicateTime = communicateTime;
	}  
	
	public String getDailyLife(){
		return EnumList.NurserPanDecreasedLivingAbiliEnum.findByIndex(dailyLife);
	}  
		
	public void setDailyLife(String dailyLife){
		this.dailyLife = dailyLife;
	}  
	
	public String getDailyLifeQuartersId(){
		return dailyLifeQuartersId;
	}  
		
	public void setDailyLifeQuartersId(String dailyLifeQuartersId){
		this.dailyLifeQuartersId = dailyLifeQuartersId;
	}  
	
	public java.util.Date getDailyLifeTime(){
		return dailyLifeTime;
	}  
		
	public void setDailyLifeTime(java.util.Date dailyLifeTime){
		this.dailyLifeTime = dailyLifeTime;
	}  
	
	public String getSkipIntegrity(){
		return EnumList.NurserPanRiskSkinIntegrityEnum.findByIndex(skipIntegrity);
	}  
		
	public void setSkipIntegrity(String skipIntegrity){
		this.skipIntegrity = skipIntegrity;
	}  
	
	public String getSkipIntegrityQuartersId(){
		return skipIntegrityQuartersId;
	}  
		
	public void setSkipIntegrityQuartersId(String skipIntegrityQuartersId){
		this.skipIntegrityQuartersId = skipIntegrityQuartersId;
	}  
	
	public java.util.Date getSkipIntegrityTime(){
		return skipIntegrityTime;
	}  
		
	public void setSkipIntegrityTime(java.util.Date skipIntegrityTime){
		this.skipIntegrityTime = skipIntegrityTime;
	}  
	
	public String getAnxiety(){
		return EnumList.NurserPanLonelinessAnxietyEnum.findByIndex(anxiety);
	}  
		
	public void setAnxiety(String anxiety){
		this.anxiety = anxiety;
	}  
	
	public String getAnxietyQuartersId(){
		return anxietyQuartersId;
	}  
		
	public void setAnxietyQuartersId(String anxietyQuartersId){
		this.anxietyQuartersId = anxietyQuartersId;
	}  
	
	public java.util.Date getAnxietyTime(){
		return anxietyTime;
	}  
		
	public void setAnxietyTime(java.util.Date anxietyTime){
		this.anxietyTime = anxietyTime;
	}  
	
	public String getSolicitude(){
		return EnumList.NurserPanCareEnum.findByIndex(solicitude);
	}  
		
	public void setSolicitude(String solicitude){
		this.solicitude = solicitude;
	}  
	
	public String getSolicitudeQuartersId(){
		return solicitudeQuartersId;
	}  
		
	public void setSolicitudeQuartersId(String solicitudeQuartersId){
		this.solicitudeQuartersId = solicitudeQuartersId;
	}  
	
	public java.util.Date getSolicitudeTime(){
		return solicitudeTime;
	}  
		
	public void setSolicitudeTime(java.util.Date solicitudeTime){
		this.solicitudeTime = solicitudeTime;
	}  
	
	public String getWalkTrain(){
		return EnumList.NurserPanWalkingTrainingEnum.findByIndex(walkTrain);
	}  
		
	public void setWalkTrain(String walkTrain){
		this.walkTrain = walkTrain;
	}  
	
	public String getWalkTrainQuartersId(){
		return walkTrainQuartersId;
	}  
		
	public void setWalkTrainQuartersId(String walkTrainQuartersId){
		this.walkTrainQuartersId = walkTrainQuartersId;
	}  
	
	public java.util.Date getWalkTrainTime(){
		return walkTrainTime;
	}  
		
	public void setWalkTrainTime(java.util.Date walkTrainTime){
		this.walkTrainTime = walkTrainTime;
	}  
	
	public String getAstriction(){
		return EnumList.NurserPanAstrictionEnum.findByIndex(astriction);
	}  
		
	public void setAstriction(String astriction){
		this.astriction = astriction;
	}  
	
	public String getAstrictionQuartersId(){
		return astrictionQuartersId;
	}  
		
	public void setAstrictionQuartersId(String astrictionQuartersId){
		this.astrictionQuartersId = astrictionQuartersId;
	}  
	
	public java.util.Date getAstrictionTime(){
		return astrictionTime;
	}  
		
	public void setAstrictionTime(java.util.Date astrictionTime){
		this.astrictionTime = astrictionTime;
	}  
	
	public String getPotentialInfection(){
		return EnumList.NurserPanPotentialComplicationsEnum.findByIndex(potentialInfection);
	}  
		
	public void setPotentialInfection(String potentialInfection){
		this.potentialInfection = potentialInfection;
	}  
	
	public String getPotentialInfectionQuartersId(){
		return potentialInfectionQuartersId;
	}  
		
	public void setPotentialInfectionQuartersId(String potentialInfectionQuartersId){
		this.potentialInfectionQuartersId = potentialInfectionQuartersId;
	}  
	
	public java.util.Date getPotentialInfectionTime(){
		return potentialInfectionTime;
	}  
		
	public void setPotentialInfectionTime(java.util.Date potentialInfectionTime){
		this.potentialInfectionTime = potentialInfectionTime;
	}  
	
	public String getOther(){
		return other;
	}  
		
	public void setOther(String other){
		this.other = other;
	}  
	
	public String getDoctorNm(){
		return doctorNm;
	}  
		
	public void setDoctorNm(String doctorNm){
		this.doctorNm = doctorNm;
	}  
	
	public String getNurseNm(){
		return nurseNm;
	}  
		
	public void setNurseNm(String nurseNm){
		this.nurseNm = nurseNm;
	}  
	
	public String getDirectorNm(){
		return directorNm;
	}  
		
	public void setDirectorNm(String directorNm){
		this.directorNm = directorNm;
	}  
	
	public String getCareLevelQuartersNm(){
		return careLevelQuartersNm;
	}  
		
	public void setCareLevelQuartersNm(String careLevelQuartersNm){
		this.careLevelQuartersNm = careLevelQuartersNm;
	}  
	
	public String getDeitNuserQuartersNm(){
		return deitNuserQuartersNm;
	}  
		
	public void setDeitNuserQuartersNm(String deitNuserQuartersNm){
		this.deitNuserQuartersNm = deitNuserQuartersNm;
	}  
	
	public String getCavityCleanQuartersNm(){
		return cavityCleanQuartersNm;
	}  
		
	public void setCavityCleanQuartersNm(String cavityCleanQuartersNm){
		this.cavityCleanQuartersNm = cavityCleanQuartersNm;
	}  
	
	public String getPerinealWashQuartersNm(){
		return perinealWashQuartersNm;
	}  
		
	public void setPerinealWashQuartersNm(String perinealWashQuartersNm){
		this.perinealWashQuartersNm = perinealWashQuartersNm;
	}  
	
	public String getBathBathQuartersNm(){
		return bathBathQuartersNm;
	}  
		
	public void setBathBathQuartersNm(String bathBathQuartersNm){
		this.bathBathQuartersNm = bathBathQuartersNm;
	}  
	
	public String getWashHairQuartersNm(){
		return washHairQuartersNm;
	}  
		
	public void setWashHairQuartersNm(String washHairQuartersNm){
		this.washHairQuartersNm = washHairQuartersNm;
	}  
	
	public String getOralMedicineQuartersNm(){
		return oralMedicineQuartersNm;
	}  
		
	public void setOralMedicineQuartersNm(String oralMedicineQuartersNm){
		this.oralMedicineQuartersNm = oralMedicineQuartersNm;
	}  
	
	public String getChineseMedicineQuartersNm(){
		return chineseMedicineQuartersNm;
	}  
		
	public void setChineseMedicineQuartersNm(String chineseMedicineQuartersNm){
		this.chineseMedicineQuartersNm = chineseMedicineQuartersNm;
	}  
	
	public String getTurnOverQuartersNm(){
		return turnOverQuartersNm;
	}  
		
	public void setTurnOverQuartersNm(String turnOverQuartersNm){
		this.turnOverQuartersNm = turnOverQuartersNm;
	}  
	
	public String getBackslapQuartersNm(){
		return backslapQuartersNm;
	}  
		
	public void setBackslapQuartersNm(String backslapQuartersNm){
		this.backslapQuartersNm = backslapQuartersNm;
	}  
	
	public String getSkipWatchQuartersNm(){
		return skipWatchQuartersNm;
	}  
		
	public void setSkipWatchQuartersNm(String skipWatchQuartersNm){
		this.skipWatchQuartersNm = skipWatchQuartersNm;
	}  
	
	public String getBellyMassageQuartersNm(){
		return bellyMassageQuartersNm;
	}  
		
	public void setBellyMassageQuartersNm(String bellyMassageQuartersNm){
		this.bellyMassageQuartersNm = bellyMassageQuartersNm;
	}  
	
	public String getDrinkWaterQuartersNm(){
		return drinkWaterQuartersNm;
	}  
		
	public void setDrinkWaterQuartersNm(String drinkWaterQuartersNm){
		this.drinkWaterQuartersNm = drinkWaterQuartersNm;
	}  
	
	public String getCommunicateQuartersNm(){
		return communicateQuartersNm;
	}  
		
	public void setCommunicateQuartersNm(String communicateQuartersNm){
		this.communicateQuartersNm = communicateQuartersNm;
	}  
	
	public String getDailyLifeQuartersNm(){
		return dailyLifeQuartersNm;
	}  
		
	public void setDailyLifeQuartersNm(String dailyLifeQuartersNm){
		this.dailyLifeQuartersNm = dailyLifeQuartersNm;
	}  
	
	public String getSkipIntegrityQuartersNm(){
		return skipIntegrityQuartersNm;
	}  
		
	public void setSkipIntegrityQuartersNm(String skipIntegrityQuartersNm){
		this.skipIntegrityQuartersNm = skipIntegrityQuartersNm;
	}  
	
	public String getAnxietyQuartersNm(){
		return anxietyQuartersNm;
	}  
		
	public void setAnxietyQuartersNm(String anxietyQuartersNm){
		this.anxietyQuartersNm = anxietyQuartersNm;
	}  
	
	public String getSolicitudeQuartersNm(){
		return solicitudeQuartersNm;
	}  
		
	public void setSolicitudeQuartersNm(String solicitudeQuartersNm){
		this.solicitudeQuartersNm = solicitudeQuartersNm;
	}  
	
	public String getWalkTrainQuartersNm(){
		return walkTrainQuartersNm;
	}  
		
	public void setWalkTrainQuartersNm(String walkTrainQuartersNm){
		this.walkTrainQuartersNm = walkTrainQuartersNm;
	}  
	
	public String getAstrictionQuartersNm(){
		return astrictionQuartersNm;
	}  
		
	public void setAstrictionQuartersNm(String astrictionQuartersNm){
		this.astrictionQuartersNm = astrictionQuartersNm;
	}  
	
	public String getPotentialInfectionQuartersNm(){
		return potentialInfectionQuartersNm;
	}  
		
	public void setPotentialInfectionQuartersNm(String potentialInfectionQuartersNm){
		this.potentialInfectionQuartersNm = potentialInfectionQuartersNm;
	}  
	
	public String getCavityCleanOther(){
		return cavityCleanOther;
	}  
		
	public void setCavityCleanOther(String cavityCleanOther){
		this.cavityCleanOther = cavityCleanOther;
	}  
	
	public String getPerinealWashOther(){
		return perinealWashOther;
	}  
		
	public void setPerinealWashOther(String perinealWashOther){
		this.perinealWashOther = perinealWashOther;
	}  
	
	public String getBathBathOther(){
		return bathBathOther;
	}  
		
	public void setBathBathOther(String bathBathOther){
		this.bathBathOther = bathBathOther;
	}  
	
	public String getWashHairOther(){
		return washHairOther;
	}  
		
	public void setWashHairOther(String washHairOther){
		this.washHairOther = washHairOther;
	}  
	
	public String getOralMedicineOther(){
		return oralMedicineOther;
	}  
		
	public void setOralMedicineOther(String oralMedicineOther){
		this.oralMedicineOther = oralMedicineOther;
	}  
	
	public String getChineseMedicineOther(){
		return chineseMedicineOther;
	}  
		
	public void setChineseMedicineOther(String chineseMedicineOther){
		this.chineseMedicineOther = chineseMedicineOther;
	}  
	
	public String getTurnOverOther(){
		return turnOverOther;
	}  
		
	public void setTurnOverOther(String turnOverOther){
		this.turnOverOther = turnOverOther;
	}  
	
	public String getBackslapOther(){
		return backslapOther;
	}  
		
	public void setBackslapOther(String backslapOther){
		this.backslapOther = backslapOther;
	}  
	
	public String getBellyMassageOther(){
		return bellyMassageOther;
	}  
		
	public void setBellyMassageOther(String bellyMassageOther){
		this.bellyMassageOther = bellyMassageOther;
	}  
	
	public String getDrinkWaterOther(){
		return drinkWaterOther;
	}  
		
	public void setDrinkWaterOther(String drinkWaterOther){
		this.drinkWaterOther = drinkWaterOther;
	}  
	
	public String getCommunicateOther(){
		return communicateOther;
	}  
		
	public void setCommunicateOther(String communicateOther){
		this.communicateOther = communicateOther;
	}

	public String getCareLevelNm() {
		if(StringUtils.isNotBlank(this.careLevel)){
			return EnumList.NurserEnum.CARE_LEVEL.getValues();
		}
		return careLevelNm;
	}

	public void setCareLevelNm(String careLevelNm) {
		this.careLevelNm = careLevelNm;
	}

	public String getDeitNuserNm() {
		if(StringUtils.isNotBlank(this.deitNuser)){
			return EnumList.NurserEnum.DEIT_NUSER.getValues();
		}
		return deitNuserNm;
	}

	public void setDeitNuserNm(String deitNuserNm) {
		this.deitNuserNm = deitNuserNm;
	}

	public String getCavityCleanNm() {
		if(StringUtils.isNotBlank(this.cavityClean)){
			return EnumList.NurserEnum.CAVITY_CLEAN.getValues();
		}
		return cavityCleanNm;
	}

	public void setCavityCleanNm(String cavityCleanNm) {
		this.cavityCleanNm = cavityCleanNm;
	}

	public String getPerinealWashNm() {
		if(StringUtils.isNotBlank(this.perinealWash)){
			return EnumList.NurserEnum.PERINEAL_WASH.getValues();
		}
		return perinealWashNm;
	}

	public void setPerinealWashNm(String perinealWashNm) {
		this.perinealWashNm = perinealWashNm;
	}

	public String getBathBathNm() {
		if(StringUtils.isNotBlank(this.bathBath)){
			return EnumList.NurserEnum.BATH_BATH.getValues();
		}
		return bathBathNm;
	}

	public void setBathBathNm(String bathBathNm) {
		this.bathBathNm = bathBathNm;
	}

	public String getWashHairNm() {
		if(StringUtils.isNotBlank(this.washHair)){
			return EnumList.NurserEnum.WASH_HAIR.getValues();
		}
		return washHairNm;
	}

	public void setWashHairNm(String washHairNm) {
		this.washHairNm = washHairNm;
	}

	public String getOralMedicineNm() {
		if(StringUtils.isNotBlank(this.oralMedicine)){
			return EnumList.NurserEnum.ORAL_MEDICINE.getValues();
		}
		return oralMedicineNm;
	}

	public void setOralMedicineNm(String oralMedicineNm) {
		this.oralMedicineNm = oralMedicineNm;
	}

	public String getChineseMedicineNm() {
		if(StringUtils.isNotBlank(this.chineseMedicine)){
			return EnumList.NurserEnum.CHINESE_MEDICINE.getValues();
		}
		return chineseMedicineNm;
	}

	public void setChineseMedicineNm(String chineseMedicineNm) {
		this.chineseMedicineNm = chineseMedicineNm;
	}

	public String getTurnOverNm() {
		if(StringUtils.isNotBlank(this.turnOver)){
			return EnumList.NurserEnum.TURN_OVER.getValues();
		}
		return turnOverNm;
	}

	public void setTurnOverNm(String turnOverNm) {
		this.turnOverNm = turnOverNm;
	}

	public String getBackslapNm() {
		if(StringUtils.isNotBlank(this.backslap)){
			return EnumList.NurserEnum.BACKSLAP.getValues();
		}
		return backslapNm;
	}

	public void setBackslapNm(String backslapNm) {
		this.backslapNm = backslapNm;
	}

	public String getSkipWatchNm() {
		if(StringUtils.isNotBlank(this.skipWatch)){
			return EnumList.NurserEnum.SKIP_WATCH.getValues();
		}
		return skipWatchNm;
	}

	public void setSkipWatchNm(String skipWatchNm) {
		this.skipWatchNm = skipWatchNm;
	}

	public String getBellyMassageNm() {
		if(StringUtils.isNotBlank(this.bellyMassage)){
			return EnumList.NurserEnum.BELLY_MASSAGE.getValues();
		}
		return bellyMassageNm;
	}

	public void setBellyMassageNm(String bellyMassageNm) {
		this.bellyMassageNm = bellyMassageNm;
	}

	public String getDrinkWaterNm() {
		if(StringUtils.isNotBlank(this.drinkWater)){
			return EnumList.NurserEnum.DRINK_WATER.getValues();
		}
		return drinkWaterNm;
	}

	public void setDrinkWaterNm(String drinkWaterNm) {
		this.drinkWaterNm = drinkWaterNm;
	}

	public String getCommunicateNm() {
		if(StringUtils.isNotBlank(this.communicate)){
			return EnumList.NurserEnum.COMMUNICATE.getValues();
		}
		return communicateNm;
	}

	public void setCommunicateNm(String communicateNm) {
		this.communicateNm = communicateNm;
	}

	public String getDailyLifeNm() {
		if(StringUtils.isNotBlank(this.dailyLife)){
			return EnumList.NurserEnum.DAILY_LIFE.getValues();
		}
		return dailyLifeNm;
	}

	public void setDailyLifeNm(String dailyLifeNm) {
		this.dailyLifeNm = dailyLifeNm;
	}

	public String getSkipIntegrityNm() {
		if(StringUtils.isNotBlank(this.skipIntegrity)){
			return EnumList.NurserEnum.SKIP_INTEGRITY.getValues();
		}
		return skipIntegrityNm;
	}

	public void setSkipIntegrityNm(String skipIntegrityNm) {
		this.skipIntegrityNm = skipIntegrityNm;
	}

	public String getAnxietyNm() {
		if(StringUtils.isNotBlank(this.anxiety)){
			return EnumList.NurserEnum.ANXIETY.getValues();
		}
		return anxietyNm;
	}

	public void setAnxietyNm(String anxietyNm) {
		this.anxietyNm = anxietyNm;
	}

	public String getSolicitudeNm() {
		if(StringUtils.isNotBlank(this.solicitude)){
			return EnumList.NurserEnum.SOLICITUDE.getValues();
		}
		return solicitudeNm;
	}

	public void setSolicitudeNm(String solicitudeNm) {
		this.solicitudeNm = solicitudeNm;
	}

	public String getWalkTrainNm() {
		if(StringUtils.isNotBlank(this.walkTrain)){
			return EnumList.NurserEnum.WALK_TRAIN.getValues();
		}
		return walkTrainNm;
	}

	public void setWalkTrainNm(String walkTrainNm) {
		this.walkTrainNm = walkTrainNm;
	}

	public String getAstrictionNm() {
		if(StringUtils.isNotBlank(this.astriction)){
			return EnumList.NurserEnum.ASTRICTION.getValues();
		}
		return astrictionNm;
	}

	public void setAstrictionNm(String astrictionNm) {
		this.astrictionNm = astrictionNm;
	}

	public String getPotentialInfectionNm() {
		if(StringUtils.isNotBlank(this.potentialInfection)){
			return EnumList.NurserEnum.POTENTIAL_INFECTION.getValues();
		}
		return potentialInfectionNm;
	}

	public void setPotentialInfectionNm(String potentialInfectionNm) {
		this.potentialInfectionNm = potentialInfectionNm;
	}  
	public String getDoctorPhoto() {
		if(StringUtils.isNotBlank(doctorPhoto)){
			return Global.getConfig(Consts.STATIC_FILE_SITE)+doctorPhoto;
		}
		return doctorPhoto;
	}

	public void setDoctorPhoto(String doctorPhoto) {
		this.doctorPhoto = doctorPhoto;
	}

	public String getNursePhoto() {
		if(StringUtils.isNotBlank(nursePhoto)){
			return Global.getConfig(Consts.STATIC_FILE_SITE)+nursePhoto;
		}
		return nursePhoto;
	}

	public void setNursePhoto(String nursePhoto) {
		this.nursePhoto = nursePhoto;
	}

	public String getDirectorPhoto() {
		if(StringUtils.isNotBlank(directorPhoto)){
			return Global.getConfig(Consts.STATIC_FILE_SITE)+directorPhoto;
		}
		return directorPhoto;
	}

	public void setDirectorPhoto(String directorPhoto) {
		this.directorPhoto = directorPhoto;
	}

	public List<ItemVO> getCarePlanList() {
		return CarePlanList;
	}

	public void setCarePlanList(List<ItemVO> carePlanList) {
		this.CarePlanList = carePlanList;
	}

	public List<ItemVO> getCareProjectList() {
		SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		//日常生活活动能力下降     
		if(StringUtils.isNotBlank(getDailyLife()) && null != getDailyLifeTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(getDailyLifeNm());
			it.setServiceNm(getDailyLife());
			it.setItemTime(sdf.format(getDailyLifeTime()));
			it.setQuartersNm(getDailyLifeQuartersNm());
			itemList.add(it);
		}
		//皮肤完整性受损的危险   
		if(StringUtils.isNotBlank(getSkipIntegrity()) && null != getSkipIntegrityTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(getSkipIntegrityNm());
			it.setServiceNm(getSkipIntegrity());
			it.setItemTime(sdf.format(getSkipIntegrityTime()));
			it.setQuartersNm(getSkipIntegrityQuartersNm());
			itemList.add(it);
		}
		//孤独、焦虑    
		if(StringUtils.isNotBlank(getAnxiety()) && null != getAnxietyTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(getAnxietyNm());
			it.setServiceNm(getAnxiety());
			it.setItemTime(sdf.format(getAnxietyTime()));
			it.setQuartersNm(getAnxietyQuartersNm());
			itemList.add(it);
		}
		//关怀     
		if(StringUtils.isNotBlank(getSolicitude()) && null != getSolicitudeTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(getSolicitudeNm());
			it.setServiceNm(getSolicitude());
			it.setItemTime(sdf.format(getSolicitudeTime()));
			it.setQuartersNm(getSolicitudeQuartersNm());
			itemList.add(it);
		}
		//行走训练    
		if(StringUtils.isNotBlank(getWalkTrain()) && null != getWalkTrainTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(getWalkTrainNm());
			it.setServiceNm(getWalkTrain());
			it.setItemTime(sdf.format(getWalkTrainTime()));
			it.setQuartersNm(getWalkTrainQuartersNm());
			itemList.add(it);
		}
		//便秘   
		if(StringUtils.isNotBlank(getAstriction()) && null != getAstrictionTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(getAstrictionNm());
			it.setServiceNm(getAstriction());
			it.setItemTime(sdf.format(getAstrictionTime()));
			it.setQuartersNm(getAstrictionQuartersNm());
			itemList.add(it);
		}
	 	//潜在并发症：感染 
	 	if(StringUtils.isNotBlank(getPotentialInfection()) && null != getPotentialInfectionTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(getPotentialInfectionNm());
			it.setServiceNm(getPotentialInfection());
			it.setItemTime(sdf.format(getPotentialInfectionTime()));
			it.setQuartersNm(getPotentialInfectionQuartersNm());
			itemList.add(it);
		}
	 	//其他
	 	if(StringUtils.isNotBlank(getOther())){
			ItemVO it = new ItemVO();
			it.setItemNm("其他");
			it.setServiceNm(getOther());
			itemList.add(it);
		}
		return itemList;
	}

	public void setCareProjectList(List<ItemVO> careProjectList) {
		this.CareProjectList = careProjectList;
	}

	public String getCavityCleanType() {
		return cavityCleanType;
	}

	public void setCavityCleanType(String cavityCleanType) {
		this.cavityCleanType = cavityCleanType;
	}

	public String getCavityCleanInterval() {
		return cavityCleanInterval;
	}

	public void setCavityCleanInterval(String cavityCleanInterval) {
		this.cavityCleanInterval = cavityCleanInterval;
	}

	public String getCavityCleanDetails() {
		return cavityCleanDetails;
	}

	public void setCavityCleanDetails(String cavityCleanDetails) {
		this.cavityCleanDetails = cavityCleanDetails;
	}

	public String getPerinealWashType() {
		return perinealWashType;
	}

	public void setPerinealWashType(String perinealWashType) {
		this.perinealWashType = perinealWashType;
	}

	public String getPerinealWashInterval() {
		return perinealWashInterval;
	}

	public void setPerinealWashInterval(String perinealWashInterval) {
		this.perinealWashInterval = perinealWashInterval;
	}

	public String getPerinealWashDetails() {
		return perinealWashDetails;
	}

	public void setPerinealWashDetails(String perinealWashDetails) {
		this.perinealWashDetails = perinealWashDetails;
	}

	public String getBathBathType() {
		return bathBathType;
	}

	public void setBathBathType(String bathBathType) {
		this.bathBathType = bathBathType;
	}

	public String getBathBathInterval() {
		return bathBathInterval;
	}

	public void setBathBathInterval(String bathBathInterval) {
		this.bathBathInterval = bathBathInterval;
	}

	public String getBathBathDetails() {
		return bathBathDetails;
	}

	public void setBathBathDetails(String bathBathDetails) {
		this.bathBathDetails = bathBathDetails;
	}

	public String getWashHairType() {
		return washHairType;
	}

	public void setWashHairType(String washHairType) {
		this.washHairType = washHairType;
	}

	public String getWashHairInterval() {
		return washHairInterval;
	}

	public void setWashHairInterval(String washHairInterval) {
		this.washHairInterval = washHairInterval;
	}

	public String getWashHairDetails() {
		return washHairDetails;
	}

	public void setWashHairDetails(String washHairDetails) {
		this.washHairDetails = washHairDetails;
	}

	public String getOralMedicineType() {
		return oralMedicineType;
	}

	public void setOralMedicineType(String oralMedicineType) {
		this.oralMedicineType = oralMedicineType;
	}

	public String getOralMedicineInterval() {
		return oralMedicineInterval;
	}

	public void setOralMedicineInterval(String oralMedicineInterval) {
		this.oralMedicineInterval = oralMedicineInterval;
	}

	public String getOralMedicineDetails() {
		return oralMedicineDetails;
	}

	public void setOralMedicineDetails(String oralMedicineDetails) {
		this.oralMedicineDetails = oralMedicineDetails;
	}

	public String getChineseMedicineType() {
		return chineseMedicineType;
	}

	public void setChineseMedicineType(String chineseMedicineType) {
		this.chineseMedicineType = chineseMedicineType;
	}

	public String getChineseMedicineInterval() {
		return chineseMedicineInterval;
	}

	public void setChineseMedicineInterval(String chineseMedicineInterval) {
		this.chineseMedicineInterval = chineseMedicineInterval;
	}

	public String getChineseMedicineDetails() {
		return chineseMedicineDetails;
	}

	public void setChineseMedicineDetails(String chineseMedicineDetails) {
		this.chineseMedicineDetails = chineseMedicineDetails;
	}

	public String getTurnOverType() {
		return turnOverType;
	}

	public void setTurnOverType(String turnOverType) {
		this.turnOverType = turnOverType;
	}

	public String getTurnOverInterval() {
		return turnOverInterval;
	}

	public void setTurnOverInterval(String turnOverInterval) {
		this.turnOverInterval = turnOverInterval;
	}

	public String getTurnOverDetails() {
		return turnOverDetails;
	}

	public void setTurnOverDetails(String turnOverDetails) {
		this.turnOverDetails = turnOverDetails;
	}

	public String getBackslapType() {
		return backslapType;
	}

	public void setBackslapType(String backslapType) {
		this.backslapType = backslapType;
	}

	public String getBackslapInterval() {
		return backslapInterval;
	}

	public void setBackslapInterval(String backslapInterval) {
		this.backslapInterval = backslapInterval;
	}

	public String getBackslapDetails() {
		return backslapDetails;
	}

	public void setBackslapDetails(String backslapDetails) {
		this.backslapDetails = backslapDetails;
	}

	public String getBellyMassageType() {
		return bellyMassageType;
	}

	public void setBellyMassageType(String bellyMassageType) {
		this.bellyMassageType = bellyMassageType;
	}

	public String getBellyMassageInterval() {
		return bellyMassageInterval;
	}

	public void setBellyMassageInterval(String bellyMassageInterval) {
		this.bellyMassageInterval = bellyMassageInterval;
	}

	public String getBellyMassageDetails() {
		return bellyMassageDetails;
	}

	public void setBellyMassageDetails(String bellyMassageDetails) {
		this.bellyMassageDetails = bellyMassageDetails;
	}

	public String getDrinkWaterType() {
		return drinkWaterType;
	}

	public void setDrinkWaterType(String drinkWaterType) {
		this.drinkWaterType = drinkWaterType;
	}

	public String getDrinkWaterInterval() {
		return drinkWaterInterval;
	}

	public void setDrinkWaterInterval(String drinkWaterInterval) {
		this.drinkWaterInterval = drinkWaterInterval;
	}

	public String getDrinkWaterDetails() {
		return drinkWaterDetails;
	}

	public void setDrinkWaterDetails(String drinkWaterDetails) {
		this.drinkWaterDetails = drinkWaterDetails;
	}

	public String getCommunicateType() {
		return communicateType;
	}

	public void setCommunicateType(String communicateType) {
		this.communicateType = communicateType;
	}

	public String getCommunicateInterval() {
		return communicateInterval;
	}

	public void setCommunicateInterval(String communicateInterval) {
		this.communicateInterval = communicateInterval;
	}

	public String getCommunicateDetails() {
		return communicateDetails;
	}

	public void setCommunicateDetails(String communicateDetails) {
		this.communicateDetails = communicateDetails;
	}

	public String getExtraItemsId() {
		return extraItemsId;
	}

	public void setExtraItemsId(String extraItemsId) {
		this.extraItemsId = extraItemsId;
	}
	
	
}


