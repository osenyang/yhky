package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 照护计划Entity
 * @author 杜康
 * @version 2016-11-03
 */
@Entity
@Table(name = "hn_health_nurser")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Nurser extends BaseEntity<Nurser> {
	
	private static final long serialVersionUID = 1L;

	public Nurser() {
		super();
	}

	public Nurser(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
//		this.createDate = new Date();
//		this.updateDate = new Date();
//		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	@PreUpdate
	public void preUpdate(){
//		this.updateDate = new Date();
	}
	
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
	
	private Date nurserStartTime;//照护计划开始执行时间
	
	private Date nurserEndTime;//照护计划结束执行时间
	
	private String extraItemsId;//额外项目ID
	
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

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDoctorId(){
		return doctorId;
	}   
		
	public void setDoctorId(String  doctorId){
		this.doctorId = doctorId;
	}   
	
	public String getNurseId(){
		return nurseId;
	}   
		
	public void setNurseId(String  nurseId){
		this.nurseId = nurseId;
	}   
	
	public String getDirectorId(){
		return directorId;
	}   
		
	public void setDirectorId(String  directorId){
		this.directorId = directorId;
	}   
	
	public String getCareDiagnosis(){
		return careDiagnosis;
	}   
		
	public void setCareDiagnosis(String  careDiagnosis){
		this.careDiagnosis = careDiagnosis;
	}   
	
	public String getFallScore(){
		return fallScore;
	}   
		
	public void setFallScore(String  fallScore){
		this.fallScore = fallScore;
	}   
	
	public String getUlcerScore(){
		return ulcerScore;
	}   
		
	public void setUlcerScore(String  ulcerScore){
		this.ulcerScore = ulcerScore;
	}   
	
	public String getMmseScore(){
		return mmseScore;
	}   
		
	public void setMmseScore(String  mmseScore){
		this.mmseScore = mmseScore;
	}   
	
	public String getAdlScore(){
		return adlScore;
	}   
		
	public void setAdlScore(String  adlScore){
		this.adlScore = adlScore;
	}   
	
	public String getWatianScore(){
		return watianScore;
	}   
		
	public void setWatianScore(String  watianScore){
		this.watianScore = watianScore;
	}   
	
	public String getCareLevel(){
		return careLevel;
	}   
		
	public void setCareLevel(String  careLevel){
		this.careLevel = careLevel;
	}   
	
	public String getCareLevelQuartersId(){
		return careLevelQuartersId;
	}   
		
	public void setCareLevelQuartersId(String  careLevelQuartersId){
		this.careLevelQuartersId = careLevelQuartersId;
	}   
	
	public java.util.Date getCareLevelTime(){
		return careLevelTime;
	}   
		
	public void setCareLevelTime(java.util.Date  careLevelTime){
		this.careLevelTime = careLevelTime;
	}   
	
	public String getDeitNuser(){
		return deitNuser;
	}   
		
	public void setDeitNuser(String  deitNuser){
		this.deitNuser = deitNuser;
	}   
	
	public String getDeitNuserQuartersId(){
		return deitNuserQuartersId;
	}   
		
	public void setDeitNuserQuartersId(String  deitNuserQuartersId){
		this.deitNuserQuartersId = deitNuserQuartersId;
	}   
	
	public java.util.Date getDeitNuserTime(){
		return deitNuserTime;
	}   
		
	public void setDeitNuserTime(java.util.Date  deitNuserTime){
		this.deitNuserTime = deitNuserTime;
	}   
	
	public String getCavityClean(){
		return cavityClean;
	}   
		
	public void setCavityClean(String  cavityClean){
		this.cavityClean = cavityClean;
	}   
	
	public String getCavityCleanQuartersId(){
		return cavityCleanQuartersId;
	}   
		
	public void setCavityCleanQuartersId(String  cavityCleanQuartersId){
		this.cavityCleanQuartersId = cavityCleanQuartersId;
	}   
	
	public java.util.Date getCavityCleanTime(){
		return cavityCleanTime;
	}   
		
	public void setCavityCleanTime(java.util.Date  cavityCleanTime){
		this.cavityCleanTime = cavityCleanTime;
	}   
	
	public String getPerinealWash(){
		return perinealWash;
	}   
		
	public void setPerinealWash(String  perinealWash){
		this.perinealWash = perinealWash;
	}   
	
	public String getPerinealWashQuartersId(){
		return perinealWashQuartersId;
	}   
		
	public void setPerinealWashQuartersId(String  perinealWashQuartersId){
		this.perinealWashQuartersId = perinealWashQuartersId;
	}   
	
	public java.util.Date getPerinealWashTime(){
		return perinealWashTime;
	}   
		
	public void setPerinealWashTime(java.util.Date  perinealWashTime){
		this.perinealWashTime = perinealWashTime;
	}   
	
	public String getBathBath(){
		return bathBath;
	}   
		
	public void setBathBath(String  bathBath){
		this.bathBath = bathBath;
	}   
	
	public String getBathBathQuartersId(){
		return bathBathQuartersId;
	}   
		
	public void setBathBathQuartersId(String  bathBathQuartersId){
		this.bathBathQuartersId = bathBathQuartersId;
	}   
	
	public java.util.Date getBathBathTime(){
		return bathBathTime;
	}   
		
	public void setBathBathTime(java.util.Date  bathBathTime){
		this.bathBathTime = bathBathTime;
	}   
	
	public String getWashHair(){
		return washHair;
	}   
		
	public void setWashHair(String  washHair){
		this.washHair = washHair;
	}   
	
	public String getWashHairQuartersId(){
		return washHairQuartersId;
	}   
		
	public void setWashHairQuartersId(String  washHairQuartersId){
		this.washHairQuartersId = washHairQuartersId;
	}   
	
	public java.util.Date getWashHairTime(){
		return washHairTime;
	}   
		
	public void setWashHairTime(java.util.Date  washHairTime){
		this.washHairTime = washHairTime;
	}   
	
	public String getOralMedicine(){
		return oralMedicine;
	}   
		
	public void setOralMedicine(String  oralMedicine){
		this.oralMedicine = oralMedicine;
	}   
	
	public String getOralMedicineQuartersId(){
		return oralMedicineQuartersId;
	}   
		
	public void setOralMedicineQuartersId(String  oralMedicineQuartersId){
		this.oralMedicineQuartersId = oralMedicineQuartersId;
	}   
	
	public java.util.Date getOralMedicineTime(){
		return oralMedicineTime;
	}   
		
	public void setOralMedicineTime(java.util.Date  oralMedicineTime){
		this.oralMedicineTime = oralMedicineTime;
	}   
	
	public String getChineseMedicine(){
		return chineseMedicine;
	}   
		
	public void setChineseMedicine(String  chineseMedicine){
		this.chineseMedicine = chineseMedicine;
	}   
	
	public String getChineseMedicineQuartersId(){
		return chineseMedicineQuartersId;
	}   
		
	public void setChineseMedicineQuartersId(String  chineseMedicineQuartersId){
		this.chineseMedicineQuartersId = chineseMedicineQuartersId;
	}   
	
	public java.util.Date getChineseMedicineTime(){
		return chineseMedicineTime;
	}   
		
	public void setChineseMedicineTime(java.util.Date  chineseMedicineTime){
		this.chineseMedicineTime = chineseMedicineTime;
	}   
	
	public String getTurnOver(){
		return turnOver;
	}   
		
	public void setTurnOver(String  turnOver){
		this.turnOver = turnOver;
	}   
	
	public String getTurnOverQuartersId(){
		return turnOverQuartersId;
	}   
		
	public void setTurnOverQuartersId(String  turnOverQuartersId){
		this.turnOverQuartersId = turnOverQuartersId;
	}   
	
	public java.util.Date getTurnOverTime(){
		return turnOverTime;
	}   
		
	public void setTurnOverTime(java.util.Date  turnOverTime){
		this.turnOverTime = turnOverTime;
	}   
	
	public String getBackslap(){
		return backslap;
	}   
		
	public void setBackslap(String  backslap){
		this.backslap = backslap;
	}   
	
	public String getBackslapQuartersId(){
		return backslapQuartersId;
	}   
		
	public void setBackslapQuartersId(String  backslapQuartersId){
		this.backslapQuartersId = backslapQuartersId;
	}   
	
	public java.util.Date getBackslapTime(){
		return backslapTime;
	}   
		
	public void setBackslapTime(java.util.Date  backslapTime){
		this.backslapTime = backslapTime;
	}   
	
	public String getSkipWatch(){
		return skipWatch;
	}   
		
	public void setSkipWatch(String  skipWatch){
		this.skipWatch = skipWatch;
	}   
	
	public String getSkipWatchQuartersId(){
		return skipWatchQuartersId;
	}   
		
	public void setSkipWatchQuartersId(String  skipWatchQuartersId){
		this.skipWatchQuartersId = skipWatchQuartersId;
	}   
	
	public java.util.Date getSkipWatchTime(){
		return skipWatchTime;
	}   
		
	public void setSkipWatchTime(java.util.Date  skipWatchTime){
		this.skipWatchTime = skipWatchTime;
	}   
	
	public String getSkipWatchOther(){
		return skipWatchOther;
	}   
		
	public void setSkipWatchOther(String  skipWatchOther){
		this.skipWatchOther = skipWatchOther;
	}   
	
	public String getBellyMassage(){
		return bellyMassage;
	}   
		
	public void setBellyMassage(String  bellyMassage){
		this.bellyMassage = bellyMassage;
	}   
	
	public String getBellyMassageQuartersId(){
		return bellyMassageQuartersId;
	}   
		
	public void setBellyMassageQuartersId(String  bellyMassageQuartersId){
		this.bellyMassageQuartersId = bellyMassageQuartersId;
	}   
	
	public java.util.Date getBellyMassageTime(){
		return bellyMassageTime;
	}   
		
	public void setBellyMassageTime(java.util.Date  bellyMassageTime){
		this.bellyMassageTime = bellyMassageTime;
	}   
	
	public String getDrinkWater(){
		return drinkWater;
	}   
		
	public void setDrinkWater(String  drinkWater){
		this.drinkWater = drinkWater;
	}   
	
	public String getDrinkWaterQuartersId(){
		return drinkWaterQuartersId;
	}   
		
	public void setDrinkWaterQuartersId(String  drinkWaterQuartersId){
		this.drinkWaterQuartersId = drinkWaterQuartersId;
	}   
	
	public java.util.Date getDrinkWaterTime(){
		return drinkWaterTime;
	}   
		
	public void setDrinkWaterTime(java.util.Date  drinkWaterTime){
		this.drinkWaterTime = drinkWaterTime;
	}   
	
	public String getCommunicate(){
		return communicate;
	}   
		
	public void setCommunicate(String  communicate){
		this.communicate = communicate;
	}   
	
	public String getCommunicateQuartersId(){
		return communicateQuartersId;
	}   
		
	public void setCommunicateQuartersId(String  communicateQuartersId){
		this.communicateQuartersId = communicateQuartersId;
	}   
	
	public java.util.Date getCommunicateTime(){
		return communicateTime;
	}   
		
	public void setCommunicateTime(java.util.Date  communicateTime){
		this.communicateTime = communicateTime;
	}   
	
	public String getDailyLife(){
		return dailyLife;
	}   
		
	public void setDailyLife(String  dailyLife){
		this.dailyLife = dailyLife;
	}   
	
	public String getDailyLifeQuartersId(){
		return dailyLifeQuartersId;
	}   
		
	public void setDailyLifeQuartersId(String  dailyLifeQuartersId){
		this.dailyLifeQuartersId = dailyLifeQuartersId;
	}   
	
	public java.util.Date getDailyLifeTime(){
		return dailyLifeTime;
	}   
		
	public void setDailyLifeTime(java.util.Date  dailyLifeTime){
		this.dailyLifeTime = dailyLifeTime;
	}   
	
	public String getSkipIntegrity(){
		return skipIntegrity;
	}   
		
	public void setSkipIntegrity(String  skipIntegrity){
		this.skipIntegrity = skipIntegrity;
	}   
	
	public String getSkipIntegrityQuartersId(){
		return skipIntegrityQuartersId;
	}   
		
	public void setSkipIntegrityQuartersId(String  skipIntegrityQuartersId){
		this.skipIntegrityQuartersId = skipIntegrityQuartersId;
	}   
	
	public java.util.Date getSkipIntegrityTime(){
		return skipIntegrityTime;
	}   
		
	public void setSkipIntegrityTime(java.util.Date  skipIntegrityTime){
		this.skipIntegrityTime = skipIntegrityTime;
	}   
	
	public String getAnxiety(){
		return anxiety;
	}   
		
	public void setAnxiety(String  anxiety){
		this.anxiety = anxiety;
	}   
	
	public String getAnxietyQuartersId(){
		return anxietyQuartersId;
	}   
		
	public void setAnxietyQuartersId(String  anxietyQuartersId){
		this.anxietyQuartersId = anxietyQuartersId;
	}   
	
	public java.util.Date getAnxietyTime(){
		return anxietyTime;
	}   
		
	public void setAnxietyTime(java.util.Date  anxietyTime){
		this.anxietyTime = anxietyTime;
	}   
	
	public String getSolicitude(){
		return solicitude;
	}   
		
	public void setSolicitude(String  solicitude){
		this.solicitude = solicitude;
	}   
	
	public String getSolicitudeQuartersId(){
		return solicitudeQuartersId;
	}   
		
	public void setSolicitudeQuartersId(String  solicitudeQuartersId){
		this.solicitudeQuartersId = solicitudeQuartersId;
	}   
	
	public java.util.Date getSolicitudeTime(){
		return solicitudeTime;
	}   
		
	public void setSolicitudeTime(java.util.Date  solicitudeTime){
		this.solicitudeTime = solicitudeTime;
	}   
	
	public String getWalkTrain(){
		return walkTrain;
	}   
		
	public void setWalkTrain(String  walkTrain){
		this.walkTrain = walkTrain;
	}   
	
	public String getWalkTrainQuartersId(){
		return walkTrainQuartersId;
	}   
		
	public void setWalkTrainQuartersId(String  walkTrainQuartersId){
		this.walkTrainQuartersId = walkTrainQuartersId;
	}   
	
	public java.util.Date getWalkTrainTime(){
		return walkTrainTime;
	}   
		
	public void setWalkTrainTime(java.util.Date  walkTrainTime){
		this.walkTrainTime = walkTrainTime;
	}   
	
	public String getAstriction(){
		return astriction;
	}   
		
	public void setAstriction(String  astriction){
		this.astriction = astriction;
	}   
	
	public String getAstrictionQuartersId(){
		return astrictionQuartersId;
	}   
		
	public void setAstrictionQuartersId(String  astrictionQuartersId){
		this.astrictionQuartersId = astrictionQuartersId;
	}   
	
	public java.util.Date getAstrictionTime(){
		return astrictionTime;
	}   
		
	public void setAstrictionTime(java.util.Date  astrictionTime){
		this.astrictionTime = astrictionTime;
	}   
	
	public String getPotentialInfection(){
		return potentialInfection;
	}   
		
	public void setPotentialInfection(String  potentialInfection){
		this.potentialInfection = potentialInfection;
	}   
	
	public String getPotentialInfectionQuartersId(){
		return potentialInfectionQuartersId;
	}   
		
	public void setPotentialInfectionQuartersId(String  potentialInfectionQuartersId){
		this.potentialInfectionQuartersId = potentialInfectionQuartersId;
	}   
	
	public java.util.Date getPotentialInfectionTime(){
		return potentialInfectionTime;
	}   
		
	public void setPotentialInfectionTime(java.util.Date  potentialInfectionTime){
		this.potentialInfectionTime = potentialInfectionTime;
	}   
	
	public String getOther(){
		return other;
	}   
		
	public void setOther(String  other){
		this.other = other;
	}   
	
	public String getDoctorNm(){
		return doctorNm;
	}   
		
	public void setDoctorNm(String  doctorNm){
		this.doctorNm = doctorNm;
	}   
	
	public String getNurseNm(){
		return nurseNm;
	}   
		
	public void setNurseNm(String  nurseNm){
		this.nurseNm = nurseNm;
	}   
	
	public String getDirectorNm(){
		return directorNm;
	}   
		
	public void setDirectorNm(String  directorNm){
		this.directorNm = directorNm;
	}   
	
	public String getCareLevelQuartersNm(){
		return careLevelQuartersNm;
	}   
		
	public void setCareLevelQuartersNm(String  careLevelQuartersNm){
		this.careLevelQuartersNm = careLevelQuartersNm;
	}   
	
	public String getDeitNuserQuartersNm(){
		return deitNuserQuartersNm;
	}   
		
	public void setDeitNuserQuartersNm(String  deitNuserQuartersNm){
		this.deitNuserQuartersNm = deitNuserQuartersNm;
	}   
	
	public String getCavityCleanQuartersNm(){
		return cavityCleanQuartersNm;
	}   
		
	public void setCavityCleanQuartersNm(String  cavityCleanQuartersNm){
		this.cavityCleanQuartersNm = cavityCleanQuartersNm;
	}   
	
	public String getPerinealWashQuartersNm(){
		return perinealWashQuartersNm;
	}   
		
	public void setPerinealWashQuartersNm(String  perinealWashQuartersNm){
		this.perinealWashQuartersNm = perinealWashQuartersNm;
	}   
	
	public String getBathBathQuartersNm(){
		return bathBathQuartersNm;
	}   
		
	public void setBathBathQuartersNm(String  bathBathQuartersNm){
		this.bathBathQuartersNm = bathBathQuartersNm;
	}   
	
	public String getWashHairQuartersNm(){
		return washHairQuartersNm;
	}   
		
	public void setWashHairQuartersNm(String  washHairQuartersNm){
		this.washHairQuartersNm = washHairQuartersNm;
	}   
	
	public String getOralMedicineQuartersNm(){
		return oralMedicineQuartersNm;
	}   
		
	public void setOralMedicineQuartersNm(String  oralMedicineQuartersNm){
		this.oralMedicineQuartersNm = oralMedicineQuartersNm;
	}   
	
	public String getChineseMedicineQuartersNm(){
		return chineseMedicineQuartersNm;
	}   
		
	public void setChineseMedicineQuartersNm(String  chineseMedicineQuartersNm){
		this.chineseMedicineQuartersNm = chineseMedicineQuartersNm;
	}   
	
	public String getTurnOverQuartersNm(){
		return turnOverQuartersNm;
	}   
		
	public void setTurnOverQuartersNm(String  turnOverQuartersNm){
		this.turnOverQuartersNm = turnOverQuartersNm;
	}   
	
	public String getBackslapQuartersNm(){
		return backslapQuartersNm;
	}   
		
	public void setBackslapQuartersNm(String  backslapQuartersNm){
		this.backslapQuartersNm = backslapQuartersNm;
	}   
	
	public String getSkipWatchQuartersNm(){
		return skipWatchQuartersNm;
	}   
		
	public void setSkipWatchQuartersNm(String  skipWatchQuartersNm){
		this.skipWatchQuartersNm = skipWatchQuartersNm;
	}   
	
	public String getBellyMassageQuartersNm(){
		return bellyMassageQuartersNm;
	}   
		
	public void setBellyMassageQuartersNm(String  bellyMassageQuartersNm){
		this.bellyMassageQuartersNm = bellyMassageQuartersNm;
	}   
	
	public String getDrinkWaterQuartersNm(){
		return drinkWaterQuartersNm;
	}   
		
	public void setDrinkWaterQuartersNm(String  drinkWaterQuartersNm){
		this.drinkWaterQuartersNm = drinkWaterQuartersNm;
	}   
	
	public String getCommunicateQuartersNm(){
		return communicateQuartersNm;
	}   
		
	public void setCommunicateQuartersNm(String  communicateQuartersNm){
		this.communicateQuartersNm = communicateQuartersNm;
	}   
	
	public String getDailyLifeQuartersNm(){
		return dailyLifeQuartersNm;
	}   
		
	public void setDailyLifeQuartersNm(String  dailyLifeQuartersNm){
		this.dailyLifeQuartersNm = dailyLifeQuartersNm;
	}   
	
	public String getSkipIntegrityQuartersNm(){
		return skipIntegrityQuartersNm;
	}   
		
	public void setSkipIntegrityQuartersNm(String  skipIntegrityQuartersNm){
		this.skipIntegrityQuartersNm = skipIntegrityQuartersNm;
	}   
	
	public String getAnxietyQuartersNm(){
		return anxietyQuartersNm;
	}   
		
	public void setAnxietyQuartersNm(String  anxietyQuartersNm){
		this.anxietyQuartersNm = anxietyQuartersNm;
	}   
	
	public String getSolicitudeQuartersNm(){
		return solicitudeQuartersNm;
	}   
		
	public void setSolicitudeQuartersNm(String  solicitudeQuartersNm){
		this.solicitudeQuartersNm = solicitudeQuartersNm;
	}   
	
	public String getWalkTrainQuartersNm(){
		return walkTrainQuartersNm;
	}   
		
	public void setWalkTrainQuartersNm(String  walkTrainQuartersNm){
		this.walkTrainQuartersNm = walkTrainQuartersNm;
	}   
	
	public String getAstrictionQuartersNm(){
		return astrictionQuartersNm;
	}   
		
	public void setAstrictionQuartersNm(String  astrictionQuartersNm){
		this.astrictionQuartersNm = astrictionQuartersNm;
	}   
	
	public String getPotentialInfectionQuartersNm(){
		return potentialInfectionQuartersNm;
	}   
		
	public void setPotentialInfectionQuartersNm(String  potentialInfectionQuartersNm){
		this.potentialInfectionQuartersNm = potentialInfectionQuartersNm;
	}   
	
	public String getCavityCleanOther(){
		return cavityCleanOther;
	}   
		
	public void setCavityCleanOther(String  cavityCleanOther){
		this.cavityCleanOther = cavityCleanOther;
	}   
	
	public String getPerinealWashOther(){
		return perinealWashOther;
	}   
		
	public void setPerinealWashOther(String  perinealWashOther){
		this.perinealWashOther = perinealWashOther;
	}   
	
	public String getBathBathOther(){
		return bathBathOther;
	}   
		
	public void setBathBathOther(String  bathBathOther){
		this.bathBathOther = bathBathOther;
	}   
	
	public String getWashHairOther(){
		return washHairOther;
	}   
		
	public void setWashHairOther(String  washHairOther){
		this.washHairOther = washHairOther;
	}   
	
	public String getOralMedicineOther(){
		return oralMedicineOther;
	}   
		
	public void setOralMedicineOther(String  oralMedicineOther){
		this.oralMedicineOther = oralMedicineOther;
	}   
	
	public String getChineseMedicineOther(){
		return chineseMedicineOther;
	}   
		
	public void setChineseMedicineOther(String  chineseMedicineOther){
		this.chineseMedicineOther = chineseMedicineOther;
	}   
	
	public String getTurnOverOther(){
		return turnOverOther;
	}   
		
	public void setTurnOverOther(String  turnOverOther){
		this.turnOverOther = turnOverOther;
	}   
	
	public String getBackslapOther(){
		return backslapOther;
	}   
		
	public void setBackslapOther(String  backslapOther){
		this.backslapOther = backslapOther;
	}   
	
	public String getBellyMassageOther(){
		return bellyMassageOther;
	}   
		
	public void setBellyMassageOther(String  bellyMassageOther){
		this.bellyMassageOther = bellyMassageOther;
	}   
	
	public String getDrinkWaterOther(){
		return drinkWaterOther;
	}   
		
	public void setDrinkWaterOther(String  drinkWaterOther){
		this.drinkWaterOther = drinkWaterOther;
	}   
	
	public String getCommunicateOther(){
		return communicateOther;
	}   
		
	public void setCommunicateOther(String  communicateOther){
		this.communicateOther = communicateOther;
	}

	public Date getNurserStartTime() {
		return nurserStartTime;
	}

	public void setNurserStartTime(Date nurserStartTime) {
		this.nurserStartTime = nurserStartTime;
	}

	public Date getNurserEndTime() {
		return nurserEndTime;
	}

	public void setNurserEndTime(Date nurserEndTime) {
		this.nurserEndTime = nurserEndTime;
	}
	
	public String getExtraItemsId() {
		return extraItemsId;
	}

	public void setExtraItemsId(String extraItemsId) {
		this.extraItemsId = extraItemsId;
	}

	@Transient
	public String getCavityCleanType() {
		return cavityCleanType;
	}

	public void setCavityCleanType(String cavityCleanType) {
		this.cavityCleanType = cavityCleanType;
	}
	@Transient
	public String getCavityCleanInterval() {
		return cavityCleanInterval;
	}

	public void setCavityCleanInterval(String cavityCleanInterval) {
		this.cavityCleanInterval = cavityCleanInterval;
	}
	@Transient
	public String getCavityCleanDetails() {
		return cavityCleanDetails;
	}

	public void setCavityCleanDetails(String cavityCleanDetails) {
		this.cavityCleanDetails = cavityCleanDetails;
	}
	@Transient
	public String getPerinealWashType() {
		return perinealWashType;
	}

	public void setPerinealWashType(String perinealWashType) {
		this.perinealWashType = perinealWashType;
	}
	@Transient
	public String getPerinealWashInterval() {
		return perinealWashInterval;
	}

	public void setPerinealWashInterval(String perinealWashInterval) {
		this.perinealWashInterval = perinealWashInterval;
	}
	@Transient
	public String getPerinealWashDetails() {
		return perinealWashDetails;
	}

	public void setPerinealWashDetails(String perinealWashDetails) {
		this.perinealWashDetails = perinealWashDetails;
	}
	@Transient
	public String getBathBathType() {
		return bathBathType;
	}

	public void setBathBathType(String bathBathType) {
		this.bathBathType = bathBathType;
	}
	@Transient
	public String getBathBathInterval() {
		return bathBathInterval;
	}

	public void setBathBathInterval(String bathBathInterval) {
		this.bathBathInterval = bathBathInterval;
	}
	@Transient
	public String getBathBathDetails() {
		return bathBathDetails;
	}

	public void setBathBathDetails(String bathBathDetails) {
		this.bathBathDetails = bathBathDetails;
	}
	@Transient
	public String getWashHairType() {
		return washHairType;
	}

	public void setWashHairType(String washHairType) {
		this.washHairType = washHairType;
	}
	@Transient
	public String getWashHairInterval() {
		return washHairInterval;
	}

	public void setWashHairInterval(String washHairInterval) {
		this.washHairInterval = washHairInterval;
	}
	@Transient
	public String getWashHairDetails() {
		return washHairDetails;
	}

	public void setWashHairDetails(String washHairDetails) {
		this.washHairDetails = washHairDetails;
	}
	@Transient
	public String getOralMedicineType() {
		return oralMedicineType;
	}

	public void setOralMedicineType(String oralMedicineType) {
		this.oralMedicineType = oralMedicineType;
	}
	@Transient
	public String getOralMedicineInterval() {
		return oralMedicineInterval;
	}

	public void setOralMedicineInterval(String oralMedicineInterval) {
		this.oralMedicineInterval = oralMedicineInterval;
	}
	@Transient
	public String getOralMedicineDetails() {
		return oralMedicineDetails;
	}

	public void setOralMedicineDetails(String oralMedicineDetails) {
		this.oralMedicineDetails = oralMedicineDetails;
	}
	@Transient
	public String getChineseMedicineType() {
		return chineseMedicineType;
	}

	public void setChineseMedicineType(String chineseMedicineType) {
		this.chineseMedicineType = chineseMedicineType;
	}
	@Transient
	public String getChineseMedicineInterval() {
		return chineseMedicineInterval;
	}

	public void setChineseMedicineInterval(String chineseMedicineInterval) {
		this.chineseMedicineInterval = chineseMedicineInterval;
	}
	@Transient
	public String getChineseMedicineDetails() {
		return chineseMedicineDetails;
	}

	public void setChineseMedicineDetails(String chineseMedicineDetails) {
		this.chineseMedicineDetails = chineseMedicineDetails;
	}
	@Transient
	public String getTurnOverType() {
		return turnOverType;
	}

	public void setTurnOverType(String turnOverType) {
		this.turnOverType = turnOverType;
	}
	@Transient
	public String getTurnOverInterval() {
		return turnOverInterval;
	}

	public void setTurnOverInterval(String turnOverInterval) {
		this.turnOverInterval = turnOverInterval;
	}
	@Transient
	public String getTurnOverDetails() {
		return turnOverDetails;
	}

	public void setTurnOverDetails(String turnOverDetails) {
		this.turnOverDetails = turnOverDetails;
	}
	@Transient
	public String getBackslapType() {
		return backslapType;
	}

	public void setBackslapType(String backslapType) {
		this.backslapType = backslapType;
	}
	@Transient
	public String getBackslapInterval() {
		return backslapInterval;
	}

	public void setBackslapInterval(String backslapInterval) {
		this.backslapInterval = backslapInterval;
	}
	@Transient
	public String getBackslapDetails() {
		return backslapDetails;
	}

	public void setBackslapDetails(String backslapDetails) {
		this.backslapDetails = backslapDetails;
	}
	@Transient
	public String getBellyMassageType() {
		return bellyMassageType;
	}

	public void setBellyMassageType(String bellyMassageType) {
		this.bellyMassageType = bellyMassageType;
	}
	@Transient
	public String getBellyMassageInterval() {
		return bellyMassageInterval;
	}

	public void setBellyMassageInterval(String bellyMassageInterval) {
		this.bellyMassageInterval = bellyMassageInterval;
	}
	@Transient
	public String getBellyMassageDetails() {
		return bellyMassageDetails;
	}

	public void setBellyMassageDetails(String bellyMassageDetails) {
		this.bellyMassageDetails = bellyMassageDetails;
	}
	@Transient
	public String getDrinkWaterType() {
		return drinkWaterType;
	}

	public void setDrinkWaterType(String drinkWaterType) {
		this.drinkWaterType = drinkWaterType;
	}
	@Transient
	public String getDrinkWaterInterval() {
		return drinkWaterInterval;
	}

	public void setDrinkWaterInterval(String drinkWaterInterval) {
		this.drinkWaterInterval = drinkWaterInterval;
	}
	@Transient
	public String getDrinkWaterDetails() {
		return drinkWaterDetails;
	}

	public void setDrinkWaterDetails(String drinkWaterDetails) {
		this.drinkWaterDetails = drinkWaterDetails;
	}
	@Transient
	public String getCommunicateType() {
		return communicateType;
	}

	public void setCommunicateType(String communicateType) {
		this.communicateType = communicateType;
	}
	@Transient
	public String getCommunicateInterval() {
		return communicateInterval;
	}

	public void setCommunicateInterval(String communicateInterval) {
		this.communicateInterval = communicateInterval;
	}
	@Transient
	public String getCommunicateDetails() {
		return communicateDetails;
	}

	public void setCommunicateDetails(String communicateDetails) {
		this.communicateDetails = communicateDetails;
	}   
	
}


