package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 诊疗计划Entity
 * @author 杜康
 * @version 2016-10-26
 */
@Entity
@Table(name = "hn_health_assessment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Assessment extends BaseEntity<Assessment> {
	
	private static final long serialVersionUID = 1L;

	public Assessment() {
		super();
	}

	public Assessment(String id){
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
   
	private String doctorId; //责任医生    
	   
	private String nurseId; //护士长    
   
	private String directorId; //科主任  
	
	private String doctorNm; //责任医生    
	   
	private String nurseNm; //护士长    
   
	private String directorNm; //科主任  
   
	private String diagnosis; //主要诊断    
   
	private String generalCondition; //全身情况    
   
	private String colligateAssess; //综合评估    
   
	private String medicalPlan; //诊疗计划    
   
	private String familyNeeds; //家属需求    
   
	private String consultationDepartment; //会诊结论   
   
	private String illnessTook; //目前最急迫处理病情    
   
	private String nurseItem; //护理项目    
   
	private String liquid; //计划每日所需液体量    
   
	private String calorie; //计划每日热卡    
   
	private String channel; //途径    
   
	private String dining; // 进餐方式   
   
	private String frequency; //每日进餐次数    
   
	private String dose; //每次剂量    
   
	private String nutritionalMeal; //营养餐性质    
   
	private String diningPosition; //进餐体位    
   
	private String holdTime; //餐后体位保持时间    
   
	private String defectDegree; //功能缺陷程度    
   
	private String needingAttention; //照护注意事项    
	
	private Date startTime;//开始执行时间
	
	private Date endTime;//结束执行时间
	
	private Date assessmentStartTime;//诊疗计划开始执行时间
	
	private Date assessmentEndTime;//诊疗计划结束执行时间

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
	
	public String getDoctorNm() {
		return doctorNm;
	}

	public void setDoctorNm(String doctorNm) {
		this.doctorNm = doctorNm;
	}

	public String getNurseNm() {
		return nurseNm;
	}

	public void setNurseNm(String nurseNm) {
		this.nurseNm = nurseNm;
	}

	public String getDirectorNm() {
		return directorNm;
	}

	public void setDirectorNm(String directorNm) {
		this.directorNm = directorNm;
	}

	public String getDiagnosis(){
		return diagnosis;
	}   
		
	public void setDiagnosis(String  diagnosis){
		this.diagnosis = diagnosis;
	}   
	
	public String getGeneralCondition(){
		return generalCondition;
	}   
		
	public void setGeneralCondition(String  generalCondition){
		this.generalCondition = generalCondition;
	}   
	
	public String getColligateAssess(){
		return colligateAssess;
	}   
		
	public void setColligateAssess(String  colligateAssess){
		this.colligateAssess = colligateAssess;
	}   
	
	public String getMedicalPlan(){
		return medicalPlan;
	}   
		
	public void setMedicalPlan(String  medicalPlan){
		this.medicalPlan = medicalPlan;
	}   
	
	public String getFamilyNeeds(){
		return familyNeeds;
	}   
		
	public void setFamilyNeeds(String  familyNeeds){
		this.familyNeeds = familyNeeds;
	}   
	
	public String getConsultationDepartment(){
		return consultationDepartment;
	}   
		
	public void setConsultationDepartment(String  consultationDepartment){
		this.consultationDepartment = consultationDepartment;
	}   
	
	public String getIllnessTook(){
		return illnessTook;
	}   
		
	public void setIllnessTook(String  illnessTook){
		this.illnessTook = illnessTook;
	}   
	
	public String getNurseItem(){
		return nurseItem;
	}   
		
	public void setNurseItem(String  nurseItem){
		this.nurseItem = nurseItem;
	}   
	
	public String getLiquid(){
		return liquid;
	}   
		
	public void setLiquid(String  liquid){
		this.liquid = liquid;
	}   
	
	public String getCalorie(){
		return calorie;
	}   
		
	public void setCalorie(String  calorie){
		this.calorie = calorie;
	}   
	
	public String getChannel(){
		return channel;
	}   
		
	public void setChannel(String  channel){
		this.channel = channel;
	}   
	
	public String getDining(){
		return dining;
	}   
		
	public void setDining(String  dining){
		this.dining = dining;
	}   
	
	public String getFrequency(){
		return frequency;
	}   
		
	public void setFrequency(String  frequency){
		this.frequency = frequency;
	}   
	
	public String getDose(){
		return dose;
	}   
		
	public void setDose(String  dose){
		this.dose = dose;
	}   
	
	public String getNutritionalMeal(){
		return nutritionalMeal;
	}   
		
	public void setNutritionalMeal(String  nutritionalMeal){
		this.nutritionalMeal = nutritionalMeal;
	}   
	
	public String getDiningPosition(){
		return diningPosition;
	}   
		
	public void setDiningPosition(String  diningPosition){
		this.diningPosition = diningPosition;
	}   
	
	public String getHoldTime(){
		return holdTime;
	}   
		
	public void setHoldTime(String  holdTime){
		this.holdTime = holdTime;
	}   
	
	public String getDefectDegree(){
		return defectDegree;
	}   
		
	public void setDefectDegree(String  defectDegree){
		this.defectDegree = defectDegree;
	}   
	
	public String getNeedingAttention(){
		return needingAttention;
	}   
		
	public void setNeedingAttention(String  needingAttention){
		this.needingAttention = needingAttention;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getAssessmentStartTime() {
		return assessmentStartTime;
	}

	public void setAssessmentStartTime(Date assessmentStartTime) {
		this.assessmentStartTime = assessmentStartTime;
	}

	public Date getAssessmentEndTime() {
		return assessmentEndTime;
	}

	public void setAssessmentEndTime(Date assessmentEndTime) {
		this.assessmentEndTime = assessmentEndTime;
	}   
	
}


