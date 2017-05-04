package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.util.Date;
import java.util.List;

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
 * 护理计划Entity
 * @author 杜康
 * @version 2016-11-02
 */
@Entity
@Table(name = "hn_health_care")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Care extends BaseEntity<Care> {
	
	private static final long serialVersionUID = 1L;

	public Care() {
		super();
	}

	public Care(String id){
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
   
	private String diagnosis; //临床诊断    
   
	private String nuserGrade; //护理等级    
   
	private String nuserGradeQuartersId; //护理等级(执行人/岗位)    
   
	private java.util.Date nuserGradeTime; //护理等级(执行时间)    
   
	private String deitNuser; //饮食护理    
   
	private String deitNuserQuartersId; //饮食护理(执行人/岗位)    
   
	private java.util.Date deitNuserTime; //饮食护理(执行时间)    
   
	private String veinInfusion; //静脉输液    
   
	private String veinInfusionQuartersId; //静脉输液(执行人/岗位)    
   
	private java.util.Date veinInfusionTime; //静脉输液(执行时间)    
   
	private String veinInfusionOther; //静脉输液(其他)    
   
	private String oxygen; //吸氧    
   
	private String oxygenQuartersId; //吸氧(执行人/岗位)    
   
	private java.util.Date oxygenTime; //吸氧(执行时间)    
   
	private String replaceWefFlask; //更换湿化瓶    
   
	private String replaceWefFlaskQuartersId; //更换湿化瓶(执行人/岗位)    
   
	private java.util.Date replaceWefFlaskTime; //更换湿化瓶(执行时间)    
   
	private String replaceWefFlaskOther; //更换湿化瓶(其他)    
   
	private String sputumSuction; //吸痰    
   
	private String sputumSuctionQuartersId; //吸痰(执行人/岗位)    
   
	private java.util.Date sputumSuctionTime; //吸痰(执行时间)    
   
	private String sputumSuctionOther; //吸痰(其他)    
   
	private String atomization; //雾化    
   
	private String atomizationQuartersId; //雾化(执行人/岗位)    
   
	private java.util.Date atomizationTime; //雾化(执行时间)    
   
	private String atomizationOther; //雾化(其他)    
   
	private String oralNuser; //口腔护理    
   
	private String oralNuserQuartersId; //口腔护理(执行人/岗位)    
   
	private java.util.Date oralNuserTime; //口腔护理(执行时间)    
   
	private String oralNuserOther; //口腔护理(其他)    
   
	private String ureterNuser; //尿管护理    
   
	private String ureterNuserQuartersId; //尿管护理(执行人/岗位)    
   
	private java.util.Date ureterNuserTime; //尿管护理(执行时间)    
   
	private String ureterNuserOther; //尿管护理(其他)    
   
	private String deepVein; //深静脉置管护理    
   
	private String deepVeinQuartersId; //深静脉置管护理(执行人/岗位)    
   
	private java.util.Date deepVeinTime; //深静脉置管护理(执行时间)    
   
	private String deepVeinOther; //深静脉置管护理(其他)    
   
	private String tracheaNuser; //气管切开护理    
   
	private String tracheaNuserQuartersId; //气管切开护理(执行人/岗位)    
   
	private java.util.Date tracheaNuserTime; //气管切开护理(执行时间)    
   
	private String tracheaNuserOther; //气管切开护理(其他)    
   
	private String tracheaNuserOtherTwo; //气管切开护理(每周四次)    
   
	private String oralMedicine; //口服药    
   
	private String oralMedicineQuartersId; //口服药(执行人/岗位)    
   
	private java.util.Date oralMedicineTime; //口服药(执行时间)    
   
	private String oralMedicineOther; //口服药(其他)    
   
	private String chineseMedicine; //中药    
   
	private String chineseMedicineQuartersId; //中药(执行人/岗位)    
   
	private java.util.Date chineseMedicineTime; //中药(执行时间)    
   
	private String chineseMedicineOther; //中药(其他)    
   
	private String specialMedicine; //特殊用药    
   
	private String specialMedicineQuartersId; //特殊用药(执行人/岗位)    
   
	private java.util.Date specialMedicineTime; //特殊用药(执行时间)    
   
	private String specialMedicineOther; //特殊用药(其他)    
   
	private String recoveryNuser; //康复护理    
   
	private String recoveryNuserQuartersId; //康复护理(执行人/岗位)    
   
	private java.util.Date recoveryNuserTime; //康复护理(执行时间)    
   
	private String recoveryNuserOther; //康复护理(其他)    
   
	private String nutritionMeal; //营养餐    
   
	private String nutritionMealQuartersId; //营养餐(执行人/岗位)    
   
	private java.util.Date nutritionMealTime; //营养餐(执行时间)    
   
	private String nutritionMealOther; //营养餐(其他)    
   
	private String healthEducation; //健康教育    
   
	private String healthEducationQuartersId; //健康教育(执行人/岗位)    
   
	private java.util.Date healthEducationTime; //健康教育(执行时间)    
   
	private String healthEducationOther; //健康教育(其他)    
   
	private String fallRisk; //跌倒风险    
   
	private String fallRiskQuartersId; //跌倒风险(执行人/岗位)    
   
	private java.util.Date fallRiskTime; //跌倒风险(执行时间)    
   
	private String ulcerRisk; //压疮风险    
   
	private String ulcerRiskQuartersId; //压疮风险(执行人/岗位)    
   
	private java.util.Date ulcerRiskTime; //压疮风险(执行时间)    
   
	private String ulcerRiskOther; //压疮风险(其他)    
   
	private String ulcerRiskOtherTwo; //压疮风险(定时翻身-其他)    
   
	private String ulcerRiskOtherThree; //压疮风险(皮肤护理-其他)    
   
	private String anxiety; //孤独、焦虑、抑郁    
   
	private String anxietyQuartersId; //孤独、焦虑、抑郁(执行人/岗位)    
   
	private java.util.Date anxietyTime; //孤独、焦虑、抑郁(执行时间)    
   
	private String anxietyOther; //孤独、焦虑、抑郁(其他)    
   
	private String languageBalk; //语言沟通障碍    
   
	private String languageBalkQuartersId; //语言沟通障碍(执行人/岗位)    
   
	private java.util.Date languageBalkTime; //语言沟通障碍(执行时间)    
   
	private String sleepDisorder; //睡眠状态紊乱    
   
	private String sleepDisorderQuartersId; //睡眠状态紊乱(执行人/岗位)    
   
	private java.util.Date sleepDisorderTime; //睡眠状态紊乱(执行时间)    
   
	private String temperatureOvertop; //体温过高    
   
	private String temperatureOvertopQuartersId; //体温过高(执行人/岗位)    
   
	private java.util.Date temperatureOvertopTime; //体温过高(执行时间)    
   
	private String respiratoryTract; //清理呼吸道无效    
   
	private String respiratoryTractQuartersId; //清理呼吸道无效(执行人/岗位)    
   
	private java.util.Date respiratoryTractTime; //清理呼吸道无效(执行时间)    
   
	private String respiratoryTractOther; //清理呼吸道无效(其他)    
   
	private String pain; //疼痛    
   
	private String painQuartersId; //疼痛(执行人/岗位)    
   
	private java.util.Date painTime; //疼痛(执行时间)    
   
	private String constipation; //便秘    
   
	private String constipationQuartersId; //便秘(执行人/岗位)    
   
	private java.util.Date constipationTime; //便秘(执行时间)    
   
	private String incontinence; //失禁    
   
	private String incontinenceQuartersId; //失禁(执行人/岗位)    
   
	private java.util.Date incontinenceTime; //失禁(执行时间)    
   
	private String activityIntolerance; //活动无耐力    
   
	private String activityIntoleranceQuartersId; //活动无耐力(执行人/岗位)    
   
	private java.util.Date activityIntoleranceTime; //活动无耐力(执行时间)    
   
	private String potentialAsphyxia; //潜在并发症：窒息    
   
	private String potentialAsphyxiaQuartersId; //潜在并发症：窒息(执行人/岗位)    
   
	private java.util.Date potentialAsphyxiaTime; //潜在并发症：窒息(执行时间)    
   
	private String potentialBleeding; //潜在并发症：出血    
   
	private String potentialBleedingQuartersId; //潜在并发症：出血(执行人/岗位)    
   
	private java.util.Date potentialBleedingTime; //潜在并发症：出血(执行时间)    
   
	private String potentialInfection; //潜在并发症：感染    
   
	private String potentialInfectionQuartersId; //潜在并发症：感染(执行人/岗位)    
   
	private java.util.Date potentialInfectionTime; //潜在并发症：感染(执行时间)    
   
	private String other; //其他    
   
	private String nuserGradeQuartersNm; //护理等级(执行人/岗位)    
   
	private String deitNuserQuartersNm; //饮食护理(执行人/岗位)    
   
	private String veinInfusionQuartersNm; //静脉输液(执行人/岗位)    
   
	private String oxygenQuartersNm; //吸氧(执行人/岗位)    
   
	private String replaceWefFlaskQuartersNm; //更换湿化瓶(执行人/岗位)    
   
	private String sputumSuctionQuartersNm; //吸痰(执行人/岗位)    
   
	private String atomizationQuartersNm; //雾化(执行人/岗位)    
   
	private String oralNuserQuartersNm; //口腔护理(执行人/岗位)    
   
	private String ureterNuserQuartersNm; //尿管护理(执行人/岗位)    
   
	private String deepVeinQuartersNm; //深静脉置管护理(执行人/岗位)    
   
	private String tracheaNuserQuartersNm; //气管切开护理(执行人/岗位)    
   
	private String oralMedicineQuartersNm; //口服药(执行人/岗位)    
   
	private String chineseMedicineQuartersNm; //中药(执行人/岗位)    
   
	private String specialMedicineQuartersNm; //特殊用药(执行人/岗位)    
   
	private String recoveryNuserQuartersNm; //康复护理(执行人/岗位)    
   
	private String nutritionMealQuartersNm; //营养餐(执行人/岗位)    
   
	private String healthEducationQuartersNm; //健康教育(执行人/岗位)    
   
	private String fallRiskQuartersNm; //跌倒风险(执行人/岗位)    
   
	private String ulcerRiskQuartersNm; //压疮风险(执行人/岗位)    
   
	private String anxietyQuartersNm; //孤独、焦虑、抑郁(执行人/岗位)    
   
	private String languageBalkQuartersNm; //语言沟通障碍(执行人/岗位)    
   
	private String sleepDisorderQuartersNm; //睡眠状态紊乱(执行人/岗位)    
   
	private String temperatureOvertopQuartersNm; //体温过高(执行人/岗位)    
   
	private String respiratoryTractQuartersNm; //清理呼吸道无效(执行人/岗位)    
   
	private String painQuartersNm; //疼痛(执行人/岗位)    
   
	private String constipationQuartersNm; //便秘(执行人/岗位)    
   
	private String incontinenceQuartersNm; //失禁(执行人/岗位)    
   
	private String activityIntoleranceQuartersNm; //活动无耐力(执行人/岗位)    
   
	private String potentialAsphyxiaQuartersNm; //潜在并发症：窒息(执行人/岗位)    
   
	private String potentialBleedingQuartersNm; //潜在并发症：出血(执行人/岗位)    
   
	private String potentialInfectionQuartersNm; //潜在并发症：感染(执行人/岗位) 
	
	private Date careStartTime;//护理计划开始执行时间
	
	private Date careEndTime;//护理计划结束执行时间
	
	private String extraItemsId;//额外项目ID
	
	/**静脉输液*/
	private String veinInfusionType;//频次类型（0、天,1、周）
	private String veinInfusionInterval;//间隔时间
	private String veinInfusionDetails;//时间数组
	
	/**更换湿化瓶*/
	private String replaceWefFlaskType;//频次类型（0、天,1、周）
	private String replaceWefFlaskInterval;//间隔时间
	private String replaceWefFlaskDetails;//时间数组
	
	/**吸痰*/
	private String sputumSuctionType;//频次类型（0、天,1、周）
	private String sputumSuctionInterval;//间隔时间
	private String sputumSuctionDetails;//时间数组
	
	/**雾化*/
	private String atomizationType;//频次类型（0、天,1、周）
	private String atomizationInterval;//间隔时间
	private String atomizationDetails;//时间数组
	
	/**口腔护理*/
	private String oralNuserType;//频次类型（0、天,1、周）
	private String oralNuserInterval;//间隔时间
	private String oralNuserDetails;//时间数组
	
	/**尿管护理*/
	private String ureterNuserType;//频次类型（0、天,1、周）
	private String ureterNuserInterval;//间隔时间
	private String ureterNuserDetails;//时间数组
	
	/**深静脉置管护理*/
	private String deepVeinType;//频次类型（0、天,1、周）
	private String deepVeinInterval;//间隔时间
	private String deepVeinDetails;//时间数组
	
	/**气管切开护理*/
	private String tracheaNuserType;//频次类型（0、天,1、周）
	private String tracheaNuserInterval;//间隔时间
	private String tracheaNuserDetails;//时间数组
	
	/**口服药*/
	private String oralMedicineType;//频次类型（0、天,1、周）
	private String oralMedicineInterval;//间隔时间
	private String oralMedicineDetails;//时间数组
	
	/**中药*/
	private String chineseMedicineType;//频次类型（0、天,1、周）
	private String chineseMedicineInterval;//间隔时间
	private String chineseMedicineDetails;//时间数组
	
	/**特殊用药*/
	private String specialMedicineType;//频次类型（0、天,1、周）
	private String specialMedicineInterval;//间隔时间
	private String specialMedicineDetails;//时间数组
	
	/**营养餐*/
	private String nutritionMealType;//频次类型（0、天,1、周）
	private String nutritionMealInterval;//间隔时间
	private String nutritionMealDetails;//时间数组
	
	private List<ExtraItems> extList;
	
	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDiagnosis(){
		return diagnosis;
	}   
		
	public void setDiagnosis(String  diagnosis){
		this.diagnosis = diagnosis;
	}   
	
	public String getNuserGrade(){
		return nuserGrade;
	}   
		
	public void setNuserGrade(String  nuserGrade){
		this.nuserGrade = nuserGrade;
	}   
	
	public String getNuserGradeQuartersId(){
		return nuserGradeQuartersId;
	}   
		
	public void setNuserGradeQuartersId(String  nuserGradeQuartersId){
		this.nuserGradeQuartersId = nuserGradeQuartersId;
	}   
	
	public java.util.Date getNuserGradeTime(){
		return nuserGradeTime;
	}   
		
	public void setNuserGradeTime(java.util.Date  nuserGradeTime){
		this.nuserGradeTime = nuserGradeTime;
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
	
	public String getVeinInfusion(){
		return veinInfusion;
	}   
		
	public void setVeinInfusion(String  veinInfusion){
		this.veinInfusion = veinInfusion;
	}   
	
	public String getVeinInfusionQuartersId(){
		return veinInfusionQuartersId;
	}   
		
	public void setVeinInfusionQuartersId(String  veinInfusionQuartersId){
		this.veinInfusionQuartersId = veinInfusionQuartersId;
	}   
	
	public java.util.Date getVeinInfusionTime(){
		return veinInfusionTime;
	}   
		
	public void setVeinInfusionTime(java.util.Date  veinInfusionTime){
		this.veinInfusionTime = veinInfusionTime;
	}   
	
	public String getVeinInfusionOther(){
		return veinInfusionOther;
	}   
		
	public void setVeinInfusionOther(String  veinInfusionOther){
		this.veinInfusionOther = veinInfusionOther;
	}   
	
	public String getOxygen(){
		return oxygen;
	}   
		
	public void setOxygen(String  oxygen){
		this.oxygen = oxygen;
	}   
	
	public String getOxygenQuartersId(){
		return oxygenQuartersId;
	}   
		
	public void setOxygenQuartersId(String  oxygenQuartersId){
		this.oxygenQuartersId = oxygenQuartersId;
	}   
	
	public java.util.Date getOxygenTime(){
		return oxygenTime;
	}   
		
	public void setOxygenTime(java.util.Date  oxygenTime){
		this.oxygenTime = oxygenTime;
	}   
	
	public String getReplaceWefFlask(){
		return replaceWefFlask;
	}   
		
	public void setReplaceWefFlask(String  replaceWefFlask){
		this.replaceWefFlask = replaceWefFlask;
	}   
	
	public String getReplaceWefFlaskQuartersId(){
		return replaceWefFlaskQuartersId;
	}   
		
	public void setReplaceWefFlaskQuartersId(String  replaceWefFlaskQuartersId){
		this.replaceWefFlaskQuartersId = replaceWefFlaskQuartersId;
	}   
	
	public java.util.Date getReplaceWefFlaskTime(){
		return replaceWefFlaskTime;
	}   
		
	public void setReplaceWefFlaskTime(java.util.Date  replaceWefFlaskTime){
		this.replaceWefFlaskTime = replaceWefFlaskTime;
	}   
	
	public String getReplaceWefFlaskOther(){
		return replaceWefFlaskOther;
	}   
		
	public void setReplaceWefFlaskOther(String  replaceWefFlaskOther){
		this.replaceWefFlaskOther = replaceWefFlaskOther;
	}   
	
	public String getSputumSuction(){
		return sputumSuction;
	}   
		
	public void setSputumSuction(String  sputumSuction){
		this.sputumSuction = sputumSuction;
	}   
	
	public String getSputumSuctionQuartersId(){
		return sputumSuctionQuartersId;
	}   
		
	public void setSputumSuctionQuartersId(String  sputumSuctionQuartersId){
		this.sputumSuctionQuartersId = sputumSuctionQuartersId;
	}   
	
	public java.util.Date getSputumSuctionTime(){
		return sputumSuctionTime;
	}   
		
	public void setSputumSuctionTime(java.util.Date  sputumSuctionTime){
		this.sputumSuctionTime = sputumSuctionTime;
	}   
	
	public String getSputumSuctionOther(){
		return sputumSuctionOther;
	}   
		
	public void setSputumSuctionOther(String  sputumSuctionOther){
		this.sputumSuctionOther = sputumSuctionOther;
	}   
	
	public String getAtomization(){
		return atomization;
	}   
		
	public void setAtomization(String  atomization){
		this.atomization = atomization;
	}   
	
	public String getAtomizationQuartersId(){
		return atomizationQuartersId;
	}   
		
	public void setAtomizationQuartersId(String  atomizationQuartersId){
		this.atomizationQuartersId = atomizationQuartersId;
	}   
	
	public java.util.Date getAtomizationTime(){
		return atomizationTime;
	}   
		
	public void setAtomizationTime(java.util.Date  atomizationTime){
		this.atomizationTime = atomizationTime;
	}   
	
	public String getAtomizationOther(){
		return atomizationOther;
	}   
		
	public void setAtomizationOther(String  atomizationOther){
		this.atomizationOther = atomizationOther;
	}   
	
	public String getOralNuser(){
		return oralNuser;
	}   
		
	public void setOralNuser(String  oralNuser){
		this.oralNuser = oralNuser;
	}   
	
	public String getOralNuserQuartersId(){
		return oralNuserQuartersId;
	}   
		
	public void setOralNuserQuartersId(String  oralNuserQuartersId){
		this.oralNuserQuartersId = oralNuserQuartersId;
	}   
	
	public java.util.Date getOralNuserTime(){
		return oralNuserTime;
	}   
		
	public void setOralNuserTime(java.util.Date  oralNuserTime){
		this.oralNuserTime = oralNuserTime;
	}   
	
	public String getOralNuserOther(){
		return oralNuserOther;
	}   
		
	public void setOralNuserOther(String  oralNuserOther){
		this.oralNuserOther = oralNuserOther;
	}   
	
	public String getUreterNuser(){
		return ureterNuser;
	}   
		
	public void setUreterNuser(String  ureterNuser){
		this.ureterNuser = ureterNuser;
	}   
	
	public String getUreterNuserQuartersId(){
		return ureterNuserQuartersId;
	}   
		
	public void setUreterNuserQuartersId(String  ureterNuserQuartersId){
		this.ureterNuserQuartersId = ureterNuserQuartersId;
	}   
	
	public java.util.Date getUreterNuserTime(){
		return ureterNuserTime;
	}   
		
	public void setUreterNuserTime(java.util.Date  ureterNuserTime){
		this.ureterNuserTime = ureterNuserTime;
	}   
	
	public String getUreterNuserOther(){
		return ureterNuserOther;
	}   
		
	public void setUreterNuserOther(String  ureterNuserOther){
		this.ureterNuserOther = ureterNuserOther;
	}   
	
	public String getDeepVein(){
		return deepVein;
	}   
		
	public void setDeepVein(String  deepVein){
		this.deepVein = deepVein;
	}   
	
	public String getDeepVeinQuartersId(){
		return deepVeinQuartersId;
	}   
		
	public void setDeepVeinQuartersId(String  deepVeinQuartersId){
		this.deepVeinQuartersId = deepVeinQuartersId;
	}   
	
	public java.util.Date getDeepVeinTime(){
		return deepVeinTime;
	}   
		
	public void setDeepVeinTime(java.util.Date  deepVeinTime){
		this.deepVeinTime = deepVeinTime;
	}   
	
	public String getDeepVeinOther(){
		return deepVeinOther;
	}   
		
	public void setDeepVeinOther(String  deepVeinOther){
		this.deepVeinOther = deepVeinOther;
	}   
	
	public String getTracheaNuser(){
		return tracheaNuser;
	}   
		
	public void setTracheaNuser(String  tracheaNuser){
		this.tracheaNuser = tracheaNuser;
	}   
	
	public String getTracheaNuserQuartersId(){
		return tracheaNuserQuartersId;
	}   
		
	public void setTracheaNuserQuartersId(String  tracheaNuserQuartersId){
		this.tracheaNuserQuartersId = tracheaNuserQuartersId;
	}   
	
	public java.util.Date getTracheaNuserTime(){
		return tracheaNuserTime;
	}   
		
	public void setTracheaNuserTime(java.util.Date  tracheaNuserTime){
		this.tracheaNuserTime = tracheaNuserTime;
	}   
	
	public String getTracheaNuserOther(){
		return tracheaNuserOther;
	}   
		
	public void setTracheaNuserOther(String  tracheaNuserOther){
		this.tracheaNuserOther = tracheaNuserOther;
	}   
	
	public String getTracheaNuserOtherTwo(){
		return tracheaNuserOtherTwo;
	}   
		
	public void setTracheaNuserOtherTwo(String  tracheaNuserOtherTwo){
		this.tracheaNuserOtherTwo = tracheaNuserOtherTwo;
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
	
	public String getOralMedicineOther(){
		return oralMedicineOther;
	}   
		
	public void setOralMedicineOther(String  oralMedicineOther){
		this.oralMedicineOther = oralMedicineOther;
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
	
	public String getChineseMedicineOther(){
		return chineseMedicineOther;
	}   
		
	public void setChineseMedicineOther(String  chineseMedicineOther){
		this.chineseMedicineOther = chineseMedicineOther;
	}   
	
	public String getSpecialMedicine(){
		return specialMedicine;
	}   
		
	public void setSpecialMedicine(String  specialMedicine){
		this.specialMedicine = specialMedicine;
	}   
	
	public String getSpecialMedicineQuartersId(){
		return specialMedicineQuartersId;
	}   
		
	public void setSpecialMedicineQuartersId(String  specialMedicineQuartersId){
		this.specialMedicineQuartersId = specialMedicineQuartersId;
	}   
	
	public java.util.Date getSpecialMedicineTime(){
		return specialMedicineTime;
	}   
		
	public void setSpecialMedicineTime(java.util.Date  specialMedicineTime){
		this.specialMedicineTime = specialMedicineTime;
	}   
	
	public String getSpecialMedicineOther(){
		return specialMedicineOther;
	}   
		
	public void setSpecialMedicineOther(String  specialMedicineOther){
		this.specialMedicineOther = specialMedicineOther;
	}   
	
	public String getRecoveryNuser(){
		return recoveryNuser;
	}   
		
	public void setRecoveryNuser(String  recoveryNuser){
		this.recoveryNuser = recoveryNuser;
	}   
	
	public String getRecoveryNuserQuartersId(){
		return recoveryNuserQuartersId;
	}   
		
	public void setRecoveryNuserQuartersId(String  recoveryNuserQuartersId){
		this.recoveryNuserQuartersId = recoveryNuserQuartersId;
	}   
	
	public java.util.Date getRecoveryNuserTime(){
		return recoveryNuserTime;
	}   
		
	public void setRecoveryNuserTime(java.util.Date  recoveryNuserTime){
		this.recoveryNuserTime = recoveryNuserTime;
	}   
	
	public String getRecoveryNuserOther(){
		return recoveryNuserOther;
	}   
		
	public void setRecoveryNuserOther(String  recoveryNuserOther){
		this.recoveryNuserOther = recoveryNuserOther;
	}   
	
	public String getNutritionMeal(){
		return nutritionMeal;
	}   
		
	public void setNutritionMeal(String  nutritionMeal){
		this.nutritionMeal = nutritionMeal;
	}   
	
	public String getNutritionMealQuartersId(){
		return nutritionMealQuartersId;
	}   
		
	public void setNutritionMealQuartersId(String  nutritionMealQuartersId){
		this.nutritionMealQuartersId = nutritionMealQuartersId;
	}   
	
	public java.util.Date getNutritionMealTime(){
		return nutritionMealTime;
	}   
		
	public void setNutritionMealTime(java.util.Date  nutritionMealTime){
		this.nutritionMealTime = nutritionMealTime;
	}   
	
	public String getNutritionMealOther(){
		return nutritionMealOther;
	}   
		
	public void setNutritionMealOther(String  nutritionMealOther){
		this.nutritionMealOther = nutritionMealOther;
	}   
	
	public String getHealthEducation(){
		return healthEducation;
	}   
		
	public void setHealthEducation(String  healthEducation){
		this.healthEducation = healthEducation;
	}   
	
	public String getHealthEducationQuartersId(){
		return healthEducationQuartersId;
	}   
		
	public void setHealthEducationQuartersId(String  healthEducationQuartersId){
		this.healthEducationQuartersId = healthEducationQuartersId;
	}   
	
	public java.util.Date getHealthEducationTime(){
		return healthEducationTime;
	}   
		
	public void setHealthEducationTime(java.util.Date  healthEducationTime){
		this.healthEducationTime = healthEducationTime;
	}   
	
	public String getHealthEducationOther(){
		return healthEducationOther;
	}   
		
	public void setHealthEducationOther(String  healthEducationOther){
		this.healthEducationOther = healthEducationOther;
	}   
	
	public String getFallRisk(){
		return fallRisk;
	}   
		
	public void setFallRisk(String  fallRisk){
		this.fallRisk = fallRisk;
	}   
	
	public String getFallRiskQuartersId(){
		return fallRiskQuartersId;
	}   
		
	public void setFallRiskQuartersId(String  fallRiskQuartersId){
		this.fallRiskQuartersId = fallRiskQuartersId;
	}   
	
	public java.util.Date getFallRiskTime(){
		return fallRiskTime;
	}   
		
	public void setFallRiskTime(java.util.Date  fallRiskTime){
		this.fallRiskTime = fallRiskTime;
	}   
	
	public String getUlcerRisk(){
		return ulcerRisk;
	}   
		
	public void setUlcerRisk(String  ulcerRisk){
		this.ulcerRisk = ulcerRisk;
	}   
	
	public String getUlcerRiskQuartersId(){
		return ulcerRiskQuartersId;
	}   
		
	public void setUlcerRiskQuartersId(String  ulcerRiskQuartersId){
		this.ulcerRiskQuartersId = ulcerRiskQuartersId;
	}   
	
	public java.util.Date getUlcerRiskTime(){
		return ulcerRiskTime;
	}   
		
	public void setUlcerRiskTime(java.util.Date  ulcerRiskTime){
		this.ulcerRiskTime = ulcerRiskTime;
	}   
	
	public String getUlcerRiskOther(){
		return ulcerRiskOther;
	}   
		
	public void setUlcerRiskOther(String  ulcerRiskOther){
		this.ulcerRiskOther = ulcerRiskOther;
	}   
	
	public String getUlcerRiskOtherTwo(){
		return ulcerRiskOtherTwo;
	}   
		
	public void setUlcerRiskOtherTwo(String  ulcerRiskOtherTwo){
		this.ulcerRiskOtherTwo = ulcerRiskOtherTwo;
	}   
	
	public String getUlcerRiskOtherThree(){
		return ulcerRiskOtherThree;
	}   
		
	public void setUlcerRiskOtherThree(String  ulcerRiskOtherThree){
		this.ulcerRiskOtherThree = ulcerRiskOtherThree;
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
	
	public String getAnxietyOther(){
		return anxietyOther;
	}   
		
	public void setAnxietyOther(String  anxietyOther){
		this.anxietyOther = anxietyOther;
	}   
	
	public String getLanguageBalk(){
		return languageBalk;
	}   
		
	public void setLanguageBalk(String  languageBalk){
		this.languageBalk = languageBalk;
	}   
	
	public String getLanguageBalkQuartersId(){
		return languageBalkQuartersId;
	}   
		
	public void setLanguageBalkQuartersId(String  languageBalkQuartersId){
		this.languageBalkQuartersId = languageBalkQuartersId;
	}   
	
	public java.util.Date getLanguageBalkTime(){
		return languageBalkTime;
	}   
		
	public void setLanguageBalkTime(java.util.Date  languageBalkTime){
		this.languageBalkTime = languageBalkTime;
	}   
	
	public String getSleepDisorder(){
		return sleepDisorder;
	}   
		
	public void setSleepDisorder(String  sleepDisorder){
		this.sleepDisorder = sleepDisorder;
	}   
	
	public String getSleepDisorderQuartersId(){
		return sleepDisorderQuartersId;
	}   
		
	public void setSleepDisorderQuartersId(String  sleepDisorderQuartersId){
		this.sleepDisorderQuartersId = sleepDisorderQuartersId;
	}   
	
	public java.util.Date getSleepDisorderTime(){
		return sleepDisorderTime;
	}   
		
	public void setSleepDisorderTime(java.util.Date  sleepDisorderTime){
		this.sleepDisorderTime = sleepDisorderTime;
	}   
	
	public String getTemperatureOvertop(){
		return temperatureOvertop;
	}   
		
	public void setTemperatureOvertop(String  temperatureOvertop){
		this.temperatureOvertop = temperatureOvertop;
	}   
	
	public String getTemperatureOvertopQuartersId(){
		return temperatureOvertopQuartersId;
	}   
		
	public void setTemperatureOvertopQuartersId(String  temperatureOvertopQuartersId){
		this.temperatureOvertopQuartersId = temperatureOvertopQuartersId;
	}   
	
	public java.util.Date getTemperatureOvertopTime(){
		return temperatureOvertopTime;
	}   
		
	public void setTemperatureOvertopTime(java.util.Date  temperatureOvertopTime){
		this.temperatureOvertopTime = temperatureOvertopTime;
	}   
	
	public String getRespiratoryTract(){
		return respiratoryTract;
	}   
		
	public void setRespiratoryTract(String  respiratoryTract){
		this.respiratoryTract = respiratoryTract;
	}   
	
	public String getRespiratoryTractQuartersId(){
		return respiratoryTractQuartersId;
	}   
		
	public void setRespiratoryTractQuartersId(String  respiratoryTractQuartersId){
		this.respiratoryTractQuartersId = respiratoryTractQuartersId;
	}   
	
	public java.util.Date getRespiratoryTractTime(){
		return respiratoryTractTime;
	}   
		
	public void setRespiratoryTractTime(java.util.Date  respiratoryTractTime){
		this.respiratoryTractTime = respiratoryTractTime;
	}   
	
	public String getRespiratoryTractOther(){
		return respiratoryTractOther;
	}   
		
	public void setRespiratoryTractOther(String  respiratoryTractOther){
		this.respiratoryTractOther = respiratoryTractOther;
	}   
	
	public String getPain(){
		return pain;
	}   
		
	public void setPain(String  pain){
		this.pain = pain;
	}   
	
	public String getPainQuartersId(){
		return painQuartersId;
	}   
		
	public void setPainQuartersId(String  painQuartersId){
		this.painQuartersId = painQuartersId;
	}   
	
	public java.util.Date getPainTime(){
		return painTime;
	}   
		
	public void setPainTime(java.util.Date  painTime){
		this.painTime = painTime;
	}   
	
	public String getConstipation(){
		return constipation;
	}   
		
	public void setConstipation(String  constipation){
		this.constipation = constipation;
	}   
	
	public String getConstipationQuartersId(){
		return constipationQuartersId;
	}   
		
	public void setConstipationQuartersId(String  constipationQuartersId){
		this.constipationQuartersId = constipationQuartersId;
	}   
	
	public java.util.Date getConstipationTime(){
		return constipationTime;
	}   
		
	public void setConstipationTime(java.util.Date  constipationTime){
		this.constipationTime = constipationTime;
	}   
	
	public String getIncontinence(){
		return incontinence;
	}   
		
	public void setIncontinence(String  incontinence){
		this.incontinence = incontinence;
	}   
	
	public String getIncontinenceQuartersId(){
		return incontinenceQuartersId;
	}   
		
	public void setIncontinenceQuartersId(String  incontinenceQuartersId){
		this.incontinenceQuartersId = incontinenceQuartersId;
	}   
	
	public java.util.Date getIncontinenceTime(){
		return incontinenceTime;
	}   
		
	public void setIncontinenceTime(java.util.Date  incontinenceTime){
		this.incontinenceTime = incontinenceTime;
	}   
	
	public String getActivityIntolerance(){
		return activityIntolerance;
	}   
		
	public void setActivityIntolerance(String  activityIntolerance){
		this.activityIntolerance = activityIntolerance;
	}   
	
	public String getActivityIntoleranceQuartersId(){
		return activityIntoleranceQuartersId;
	}   
		
	public void setActivityIntoleranceQuartersId(String  activityIntoleranceQuartersId){
		this.activityIntoleranceQuartersId = activityIntoleranceQuartersId;
	}   
	
	public java.util.Date getActivityIntoleranceTime(){
		return activityIntoleranceTime;
	}   
		
	public void setActivityIntoleranceTime(java.util.Date  activityIntoleranceTime){
		this.activityIntoleranceTime = activityIntoleranceTime;
	}   
	
	public String getPotentialAsphyxia(){
		return potentialAsphyxia;
	}   
		
	public void setPotentialAsphyxia(String  potentialAsphyxia){
		this.potentialAsphyxia = potentialAsphyxia;
	}   
	
	public String getPotentialAsphyxiaQuartersId(){
		return potentialAsphyxiaQuartersId;
	}   
		
	public void setPotentialAsphyxiaQuartersId(String  potentialAsphyxiaQuartersId){
		this.potentialAsphyxiaQuartersId = potentialAsphyxiaQuartersId;
	}   
	
	public java.util.Date getPotentialAsphyxiaTime(){
		return potentialAsphyxiaTime;
	}   
		
	public void setPotentialAsphyxiaTime(java.util.Date  potentialAsphyxiaTime){
		this.potentialAsphyxiaTime = potentialAsphyxiaTime;
	}   
	
	public String getPotentialBleeding(){
		return potentialBleeding;
	}   
		
	public void setPotentialBleeding(String  potentialBleeding){
		this.potentialBleeding = potentialBleeding;
	}   
	
	public String getPotentialBleedingQuartersId(){
		return potentialBleedingQuartersId;
	}   
		
	public void setPotentialBleedingQuartersId(String  potentialBleedingQuartersId){
		this.potentialBleedingQuartersId = potentialBleedingQuartersId;
	}   
	
	public java.util.Date getPotentialBleedingTime(){
		return potentialBleedingTime;
	}   
		
	public void setPotentialBleedingTime(java.util.Date  potentialBleedingTime){
		this.potentialBleedingTime = potentialBleedingTime;
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
	
	public String getNuserGradeQuartersNm(){
		return nuserGradeQuartersNm;
	}   
		
	public void setNuserGradeQuartersNm(String  nuserGradeQuartersNm){
		this.nuserGradeQuartersNm = nuserGradeQuartersNm;
	}   
	
	public String getDeitNuserQuartersNm(){
		return deitNuserQuartersNm;
	}   
		
	public void setDeitNuserQuartersNm(String  deitNuserQuartersNm){
		this.deitNuserQuartersNm = deitNuserQuartersNm;
	}   
	
	public String getVeinInfusionQuartersNm(){
		return veinInfusionQuartersNm;
	}   
		
	public void setVeinInfusionQuartersNm(String  veinInfusionQuartersNm){
		this.veinInfusionQuartersNm = veinInfusionQuartersNm;
	}   
	
	public String getOxygenQuartersNm(){
		return oxygenQuartersNm;
	}   
		
	public void setOxygenQuartersNm(String  oxygenQuartersNm){
		this.oxygenQuartersNm = oxygenQuartersNm;
	}   
	
	public String getReplaceWefFlaskQuartersNm(){
		return replaceWefFlaskQuartersNm;
	}   
		
	public void setReplaceWefFlaskQuartersNm(String  replaceWefFlaskQuartersNm){
		this.replaceWefFlaskQuartersNm = replaceWefFlaskQuartersNm;
	}   
	
	public String getSputumSuctionQuartersNm(){
		return sputumSuctionQuartersNm;
	}   
		
	public void setSputumSuctionQuartersNm(String  sputumSuctionQuartersNm){
		this.sputumSuctionQuartersNm = sputumSuctionQuartersNm;
	}   
	
	public String getAtomizationQuartersNm(){
		return atomizationQuartersNm;
	}   
		
	public void setAtomizationQuartersNm(String  atomizationQuartersNm){
		this.atomizationQuartersNm = atomizationQuartersNm;
	}   
	
	public String getOralNuserQuartersNm(){
		return oralNuserQuartersNm;
	}   
		
	public void setOralNuserQuartersNm(String  oralNuserQuartersNm){
		this.oralNuserQuartersNm = oralNuserQuartersNm;
	}   
	
	public String getUreterNuserQuartersNm(){
		return ureterNuserQuartersNm;
	}   
		
	public void setUreterNuserQuartersNm(String  ureterNuserQuartersNm){
		this.ureterNuserQuartersNm = ureterNuserQuartersNm;
	}   
	
	public String getDeepVeinQuartersNm(){
		return deepVeinQuartersNm;
	}   
		
	public void setDeepVeinQuartersNm(String  deepVeinQuartersNm){
		this.deepVeinQuartersNm = deepVeinQuartersNm;
	}   
	
	public String getTracheaNuserQuartersNm(){
		return tracheaNuserQuartersNm;
	}   
		
	public void setTracheaNuserQuartersNm(String  tracheaNuserQuartersNm){
		this.tracheaNuserQuartersNm = tracheaNuserQuartersNm;
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
	
	public String getSpecialMedicineQuartersNm(){
		return specialMedicineQuartersNm;
	}   
		
	public void setSpecialMedicineQuartersNm(String  specialMedicineQuartersNm){
		this.specialMedicineQuartersNm = specialMedicineQuartersNm;
	}   
	
	public String getRecoveryNuserQuartersNm(){
		return recoveryNuserQuartersNm;
	}   
		
	public void setRecoveryNuserQuartersNm(String  recoveryNuserQuartersNm){
		this.recoveryNuserQuartersNm = recoveryNuserQuartersNm;
	}   
	
	public String getNutritionMealQuartersNm(){
		return nutritionMealQuartersNm;
	}   
		
	public void setNutritionMealQuartersNm(String  nutritionMealQuartersNm){
		this.nutritionMealQuartersNm = nutritionMealQuartersNm;
	}   
	
	public String getHealthEducationQuartersNm(){
		return healthEducationQuartersNm;
	}   
		
	public void setHealthEducationQuartersNm(String  healthEducationQuartersNm){
		this.healthEducationQuartersNm = healthEducationQuartersNm;
	}   
	
	public String getFallRiskQuartersNm(){
		return fallRiskQuartersNm;
	}   
		
	public void setFallRiskQuartersNm(String  fallRiskQuartersNm){
		this.fallRiskQuartersNm = fallRiskQuartersNm;
	}   
	
	public String getUlcerRiskQuartersNm(){
		return ulcerRiskQuartersNm;
	}   
		
	public void setUlcerRiskQuartersNm(String  ulcerRiskQuartersNm){
		this.ulcerRiskQuartersNm = ulcerRiskQuartersNm;
	}   
	
	public String getAnxietyQuartersNm(){
		return anxietyQuartersNm;
	}   
		
	public void setAnxietyQuartersNm(String  anxietyQuartersNm){
		this.anxietyQuartersNm = anxietyQuartersNm;
	}   
	
	public String getLanguageBalkQuartersNm(){
		return languageBalkQuartersNm;
	}   
		
	public void setLanguageBalkQuartersNm(String  languageBalkQuartersNm){
		this.languageBalkQuartersNm = languageBalkQuartersNm;
	}   
	
	public String getSleepDisorderQuartersNm(){
		return sleepDisorderQuartersNm;
	}   
		
	public void setSleepDisorderQuartersNm(String  sleepDisorderQuartersNm){
		this.sleepDisorderQuartersNm = sleepDisorderQuartersNm;
	}   
	
	public String getTemperatureOvertopQuartersNm(){
		return temperatureOvertopQuartersNm;
	}   
		
	public void setTemperatureOvertopQuartersNm(String  temperatureOvertopQuartersNm){
		this.temperatureOvertopQuartersNm = temperatureOvertopQuartersNm;
	}   
	
	public String getRespiratoryTractQuartersNm(){
		return respiratoryTractQuartersNm;
	}   
		
	public void setRespiratoryTractQuartersNm(String  respiratoryTractQuartersNm){
		this.respiratoryTractQuartersNm = respiratoryTractQuartersNm;
	}   
	
	public String getPainQuartersNm(){
		return painQuartersNm;
	}   
		
	public void setPainQuartersNm(String  painQuartersNm){
		this.painQuartersNm = painQuartersNm;
	}   
	
	public String getConstipationQuartersNm(){
		return constipationQuartersNm;
	}   
		
	public void setConstipationQuartersNm(String  constipationQuartersNm){
		this.constipationQuartersNm = constipationQuartersNm;
	}   
	
	public String getIncontinenceQuartersNm(){
		return incontinenceQuartersNm;
	}   
		
	public void setIncontinenceQuartersNm(String  incontinenceQuartersNm){
		this.incontinenceQuartersNm = incontinenceQuartersNm;
	}   
	
	public String getActivityIntoleranceQuartersNm(){
		return activityIntoleranceQuartersNm;
	}   
		
	public void setActivityIntoleranceQuartersNm(String  activityIntoleranceQuartersNm){
		this.activityIntoleranceQuartersNm = activityIntoleranceQuartersNm;
	}   
	
	public String getPotentialAsphyxiaQuartersNm(){
		return potentialAsphyxiaQuartersNm;
	}   
		
	public void setPotentialAsphyxiaQuartersNm(String  potentialAsphyxiaQuartersNm){
		this.potentialAsphyxiaQuartersNm = potentialAsphyxiaQuartersNm;
	}   
	
	public String getPotentialBleedingQuartersNm(){
		return potentialBleedingQuartersNm;
	}   
		
	public void setPotentialBleedingQuartersNm(String  potentialBleedingQuartersNm){
		this.potentialBleedingQuartersNm = potentialBleedingQuartersNm;
	}   
	
	public String getPotentialInfectionQuartersNm(){
		return potentialInfectionQuartersNm;
	}   
		
	public void setPotentialInfectionQuartersNm(String  potentialInfectionQuartersNm){
		this.potentialInfectionQuartersNm = potentialInfectionQuartersNm;
	}

	public Date getCareStartTime() {
		return careStartTime;
	}

	public void setCareStartTime(Date careStartTime) {
		this.careStartTime = careStartTime;
	}

	public Date getCareEndTime() {
		return careEndTime;
	}

	public void setCareEndTime(Date careEndTime) {
		this.careEndTime = careEndTime;
	}
	
	public String getExtraItemsId() {
		return extraItemsId;
	}

	public void setExtraItemsId(String extraItemsId) {
		this.extraItemsId = extraItemsId;
	}

	@Transient
	public String getVeinInfusionType() {
		return veinInfusionType;
	}

	public void setVeinInfusionType(String veinInfusionType) {
		this.veinInfusionType = veinInfusionType;
	}
	@Transient
	public String getVeinInfusionInterval() {
		return veinInfusionInterval;
	}

	public void setVeinInfusionInterval(String veinInfusionInterval) {
		this.veinInfusionInterval = veinInfusionInterval;
	}
	@Transient
	public String getVeinInfusionDetails() {
		return veinInfusionDetails;
	}

	public void setVeinInfusionDetails(String veinInfusionDetails) {
		this.veinInfusionDetails = veinInfusionDetails;
	}
	@Transient
	public String getReplaceWefFlaskType() {
		return replaceWefFlaskType;
	}

	public void setReplaceWefFlaskType(String replaceWefFlaskType) {
		this.replaceWefFlaskType = replaceWefFlaskType;
	}
	@Transient
	public String getReplaceWefFlaskInterval() {
		return replaceWefFlaskInterval;
	}

	public void setReplaceWefFlaskInterval(String replaceWefFlaskInterval) {
		this.replaceWefFlaskInterval = replaceWefFlaskInterval;
	}
	@Transient
	public String getReplaceWefFlaskDetails() {
		return replaceWefFlaskDetails;
	}

	public void setReplaceWefFlaskDetails(String replaceWefFlaskDetails) {
		this.replaceWefFlaskDetails = replaceWefFlaskDetails;
	}
	@Transient
	public String getSputumSuctionType() {
		return sputumSuctionType;
	}

	public void setSputumSuctionType(String sputumSuctionType) {
		this.sputumSuctionType = sputumSuctionType;
	}
	@Transient
	public String getSputumSuctionInterval() {
		return sputumSuctionInterval;
	}

	public void setSputumSuctionInterval(String sputumSuctionInterval) {
		this.sputumSuctionInterval = sputumSuctionInterval;
	}
	@Transient
	public String getSputumSuctionDetails() {
		return sputumSuctionDetails;
	}

	public void setSputumSuctionDetails(String sputumSuctionDetails) {
		this.sputumSuctionDetails = sputumSuctionDetails;
	}
	@Transient
	public String getAtomizationType() {
		return atomizationType;
	}

	public void setAtomizationType(String atomizationType) {
		this.atomizationType = atomizationType;
	}
	@Transient
	public String getAtomizationInterval() {
		return atomizationInterval;
	}

	public void setAtomizationInterval(String atomizationInterval) {
		this.atomizationInterval = atomizationInterval;
	}
	@Transient
	public String getAtomizationDetails() {
		return atomizationDetails;
	}

	public void setAtomizationDetails(String atomizationDetails) {
		this.atomizationDetails = atomizationDetails;
	}
	@Transient
	public String getOralNuserType() {
		return oralNuserType;
	}

	public void setOralNuserType(String oralNuserType) {
		this.oralNuserType = oralNuserType;
	}
	@Transient
	public String getOralNuserInterval() {
		return oralNuserInterval;
	}

	public void setOralNuserInterval(String oralNuserInterval) {
		this.oralNuserInterval = oralNuserInterval;
	}
	@Transient
	public String getOralNuserDetails() {
		return oralNuserDetails;
	}

	public void setOralNuserDetails(String oralNuserDetails) {
		this.oralNuserDetails = oralNuserDetails;
	}
	@Transient
	public String getUreterNuserType() {
		return ureterNuserType;
	}

	public void setUreterNuserType(String ureterNuserType) {
		this.ureterNuserType = ureterNuserType;
	}
	@Transient
	public String getUreterNuserInterval() {
		return ureterNuserInterval;
	}

	public void setUreterNuserInterval(String ureterNuserInterval) {
		this.ureterNuserInterval = ureterNuserInterval;
	}
	@Transient
	public String getUreterNuserDetails() {
		return ureterNuserDetails;
	}

	public void setUreterNuserDetails(String ureterNuserDetails) {
		this.ureterNuserDetails = ureterNuserDetails;
	}
	@Transient
	public String getDeepVeinType() {
		return deepVeinType;
	}

	public void setDeepVeinType(String deepVeinType) {
		this.deepVeinType = deepVeinType;
	}
	@Transient
	public String getDeepVeinInterval() {
		return deepVeinInterval;
	}

	public void setDeepVeinInterval(String deepVeinInterval) {
		this.deepVeinInterval = deepVeinInterval;
	}
	@Transient
	public String getDeepVeinDetails() {
		return deepVeinDetails;
	}

	public void setDeepVeinDetails(String deepVeinDetails) {
		this.deepVeinDetails = deepVeinDetails;
	}
	@Transient
	public String getTracheaNuserType() {
		return tracheaNuserType;
	}

	public void setTracheaNuserType(String tracheaNuserType) {
		this.tracheaNuserType = tracheaNuserType;
	}
	@Transient
	public String getTracheaNuserInterval() {
		return tracheaNuserInterval;
	}

	public void setTracheaNuserInterval(String tracheaNuserInterval) {
		this.tracheaNuserInterval = tracheaNuserInterval;
	}
	@Transient
	public String getTracheaNuserDetails() {
		return tracheaNuserDetails;
	}

	public void setTracheaNuserDetails(String tracheaNuserDetails) {
		this.tracheaNuserDetails = tracheaNuserDetails;
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
	public String getSpecialMedicineType() {
		return specialMedicineType;
	}

	public void setSpecialMedicineType(String specialMedicineType) {
		this.specialMedicineType = specialMedicineType;
	}
	@Transient
	public String getSpecialMedicineInterval() {
		return specialMedicineInterval;
	}

	public void setSpecialMedicineInterval(String specialMedicineInterval) {
		this.specialMedicineInterval = specialMedicineInterval;
	}
	@Transient
	public String getSpecialMedicineDetails() {
		return specialMedicineDetails;
	}

	public void setSpecialMedicineDetails(String specialMedicineDetails) {
		this.specialMedicineDetails = specialMedicineDetails;
	}
	@Transient
	public String getNutritionMealType() {
		return nutritionMealType;
	}

	public void setNutritionMealType(String nutritionMealType) {
		this.nutritionMealType = nutritionMealType;
	}
	@Transient
	public String getNutritionMealInterval() {
		return nutritionMealInterval;
	}

	public void setNutritionMealInterval(String nutritionMealInterval) {
		this.nutritionMealInterval = nutritionMealInterval;
	}
	@Transient
	public String getNutritionMealDetails() {
		return nutritionMealDetails;
	}

	public void setNutritionMealDetails(String nutritionMealDetails) {
		this.nutritionMealDetails = nutritionMealDetails;
	}
	@Transient
	public List<ExtraItems> getExtList() {
		return extList;
	}

	public void setExtList(List<ExtraItems> extList) {
		this.extList = extList;
	}
	
}