package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 老人-方案-康复计划Entity
 * @author 王宴萍
 * @version 2016-11-15
 */
public class ElderPlanRecoverVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String archivesId;	
	private String elderName;	
	private String quartersId;	
	private String quartersName;	
	private String interveneId;	
	private String bedNumber;
	
	private String doctorId; //康复治疗师    
	private String recoveryEvaluate; //康复评定    
	private String dysfunction; //病史摘要和存在的主要功能障碍    
	private String recoveryPlan; //康复计划    
	private String recoverPlace; //康复场所    
	private String recoverPlaceOther; //康复场所(其他)    
	private String acupuncture; //温针、头皮针    
	private Date acupunctureStartTime; //温针、头皮针(开始时间)    
	private Date acupunctureEndTime; //温针、头皮针(结束时间)    
	private String acupunctureTotal; //温针、头皮针(共多少次)    
	private String acupunctureFrequency; //温针、头皮针(频率)    
	private String acupunctureWhen; //温针、头皮针(时长)    
	private String acupunctureStrength; //温针、头皮针(训练强度)    
	private String acupunctureQuartersId; //温针、头皮针(执行人/岗位)    
	private String psychologyRecover; //心理康复    
	private Date psychologyRecoverStartTime; //心理康复(开始时间)    
	private Date psychologyRecoverEndTime; //心理康复(结束时间)    
	private String psychologyRecoverTotal; //心理康复(共多少次)    
	private String psychologyRecoverFrequency; //心理康复(频率)    
	private String psychologyRecoverWhen; //心理康复(时长)    
	private String psychologyRecoverStrength; //心理康复(训练强度)    
	private String psychologyRecoverQuartersId; //心理康复(执行人/岗位)    
	private String limbsTrain; //偏瘫肢体综合训练    
	private Date limbsTrainStartTime; //偏瘫肢体综合训练(开始时间)    
	private Date limbsTrainEndTime; //偏瘫肢体综合训练(结束时间)    
	private String limbsTrainTotal; //偏瘫肢体综合训练(共多少次)    
	private String limbsTrainFrequency; //偏瘫肢体综合训练(频率)    
	private String limbsTrainWhen; //偏瘫肢体综合训练(时长)    
	private String limbsTrainStrength; //偏瘫肢体综合训练(训练强度)    
	private String limbsTrainQuartersId; //偏瘫肢体综合训练(执行人/岗位)    
	private String taskTreatment; //偏瘫肢体综合训练    
	private Date taskTreatmentStartTime; //偏瘫肢体综合训练(开始时间)    
	private Date taskTreatmentEndTime; //偏瘫肢体综合训练(结束时间)    
	private String taskTreatmentTotal; //偏瘫肢体综合训练(共多少次)    
	private String taskTreatmentFrequency; //偏瘫肢体综合训练(频率)    
	private String taskTreatmentWhen; //偏瘫肢体综合训练(时长)    
	private String taskTreatmentStrength; //偏瘫肢体综合训练(训练强度)    
	private String taskTreatmentQuartersId; //偏瘫肢体综合训练(执行人/岗位)    
	private String recentTarget; //康复近期目标    
	private String forwardTarget; //康复远期目标    
	private String carefulMatter; //注意事项    
	private String doctorNm; //康复治疗师    
	private String acupunctureQuartersNm; //温针、头皮针(执行人/岗位)    
	private String psychologyRecoverQuartersNm; //心理康复(执行人/岗位)    
	private String limbsTrainQuartersNm; //偏瘫肢体综合训练(执行人/岗位)    
	private String taskTreatmentQuartersNm; //偏瘫肢体综合训练(执行人/岗位)    

	private Date recoverStartTime;//康复计划开始执行时间
	
	private Date recoverEndTime;//康复计划结束执行时间
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
	
	public String getRecoveryEvaluate(){
		return recoveryEvaluate;
	}   
		
	public void setRecoveryEvaluate(String  recoveryEvaluate){
		this.recoveryEvaluate = recoveryEvaluate.trim();
	}   
	
	public String getDysfunction(){
		return dysfunction;
	}   
		
	public void setDysfunction(String  dysfunction){
		this.dysfunction = dysfunction.trim();
	}   
	
	public String getRecoveryPlan(){
		return recoveryPlan;
	}   
		
	public void setRecoveryPlan(String  recoveryPlan){
		this.recoveryPlan = recoveryPlan.trim();
	}   
	
	public String getRecoverPlace(){
		return recoverPlace;
	}   
		
	public void setRecoverPlace(String  recoverPlace){
		this.recoverPlace = recoverPlace;
	}   
	
	public String getRecoverPlaceOther(){
		return recoverPlaceOther;
	}   
		
	public void setRecoverPlaceOther(String  recoverPlaceOther){
		this.recoverPlaceOther = recoverPlaceOther.trim();
	}   
	
	public String getAcupuncture(){
		return acupuncture;
	}   
		
	public void setAcupuncture(String  acupuncture){
		this.acupuncture = acupuncture.trim();
	}   
	
	public Date getAcupunctureStartTime(){
		return acupunctureStartTime;
	}   
		
	public void setAcupunctureStartTime(Date  acupunctureStartTime){
		this.acupunctureStartTime = acupunctureStartTime;
	}   
	
	public Date getAcupunctureEndTime(){
		return acupunctureEndTime;
	}   
		
	public void setAcupunctureEndTime(Date  acupunctureEndTime){
		this.acupunctureEndTime = acupunctureEndTime;
	}   
	
	public String getAcupunctureTotal(){
		return acupunctureTotal;
	}   
		
	public void setAcupunctureTotal(String  acupunctureTotal){
		this.acupunctureTotal = acupunctureTotal;
	}   
	
	public String getAcupunctureFrequency(){
		return acupunctureFrequency;
	}   
		
	public void setAcupunctureFrequency(String  acupunctureFrequency){
		this.acupunctureFrequency = acupunctureFrequency;
	}   
	
	public String getAcupunctureWhen(){
		return acupunctureWhen;
	}   
		
	public void setAcupunctureWhen(String  acupunctureWhen){
		this.acupunctureWhen = acupunctureWhen;
	}   
	
	public String getAcupunctureStrength(){
		return acupunctureStrength;
	}   
		
	public void setAcupunctureStrength(String  acupunctureStrength){
		this.acupunctureStrength = acupunctureStrength;
	}   
	
	public String getAcupunctureQuartersId(){
		return acupunctureQuartersId;
	}   
		
	public void setAcupunctureQuartersId(String  acupunctureQuartersId){
		this.acupunctureQuartersId = acupunctureQuartersId;
	}   
	
	public String getPsychologyRecover(){
		return psychologyRecover;
	}   
		
	public void setPsychologyRecover(String  psychologyRecover){
		this.psychologyRecover = psychologyRecover;
	}   
	
	public Date getPsychologyRecoverStartTime(){
		return psychologyRecoverStartTime;
	}   
		
	public void setPsychologyRecoverStartTime(Date  psychologyRecoverStartTime){
		this.psychologyRecoverStartTime = psychologyRecoverStartTime;
	}   
	
	public Date getPsychologyRecoverEndTime(){
		return psychologyRecoverEndTime;
	}   
		
	public void setPsychologyRecoverEndTime(Date  psychologyRecoverEndTime){
		this.psychologyRecoverEndTime = psychologyRecoverEndTime;
	}   
	
	public String getPsychologyRecoverTotal(){
		return psychologyRecoverTotal;
	}   
		
	public void setPsychologyRecoverTotal(String  psychologyRecoverTotal){
		this.psychologyRecoverTotal = psychologyRecoverTotal;
	}   
	
	public String getPsychologyRecoverFrequency(){
		return psychologyRecoverFrequency;
	}   
		
	public void setPsychologyRecoverFrequency(String  psychologyRecoverFrequency){
		this.psychologyRecoverFrequency = psychologyRecoverFrequency;
	}   
	
	public String getPsychologyRecoverWhen(){
		return psychologyRecoverWhen;
	}   
		
	public void setPsychologyRecoverWhen(String  psychologyRecoverWhen){
		this.psychologyRecoverWhen = psychologyRecoverWhen;
	}   
	
	public String getPsychologyRecoverStrength(){
		return psychologyRecoverStrength;
	}   
		
	public void setPsychologyRecoverStrength(String  psychologyRecoverStrength){
		this.psychologyRecoverStrength = psychologyRecoverStrength;
	}   
	
	public String getPsychologyRecoverQuartersId(){
		return psychologyRecoverQuartersId;
	}   
		
	public void setPsychologyRecoverQuartersId(String  psychologyRecoverQuartersId){
		this.psychologyRecoverQuartersId = psychologyRecoverQuartersId;
	}   
	
	public String getLimbsTrain(){
		return limbsTrain;
	}   
		
	public void setLimbsTrain(String  limbsTrain){
		this.limbsTrain = limbsTrain;
	}   
	
	public Date getLimbsTrainStartTime(){
		return limbsTrainStartTime;
	}   
		
	public void setLimbsTrainStartTime(Date  limbsTrainStartTime){
		this.limbsTrainStartTime = limbsTrainStartTime;
	}   
	
	public Date getLimbsTrainEndTime(){
		return limbsTrainEndTime;
	}   
		
	public void setLimbsTrainEndTime(Date  limbsTrainEndTime){
		this.limbsTrainEndTime = limbsTrainEndTime;
	}   
	
	public String getLimbsTrainTotal(){
		return limbsTrainTotal;
	}   
		
	public void setLimbsTrainTotal(String  limbsTrainTotal){
		this.limbsTrainTotal = limbsTrainTotal;
	}   
	
	public String getLimbsTrainFrequency(){
		return limbsTrainFrequency;
	}   
		
	public void setLimbsTrainFrequency(String  limbsTrainFrequency){
		this.limbsTrainFrequency = limbsTrainFrequency;
	}   
	
	public String getLimbsTrainWhen(){
		return limbsTrainWhen;
	}   
		
	public void setLimbsTrainWhen(String  limbsTrainWhen){
		this.limbsTrainWhen = limbsTrainWhen;
	}   
	
	public String getLimbsTrainStrength(){
		return limbsTrainStrength;
	}   
		
	public void setLimbsTrainStrength(String  limbsTrainStrength){
		this.limbsTrainStrength = limbsTrainStrength;
	}   
	
	public String getLimbsTrainQuartersId(){
		return limbsTrainQuartersId;
	}   
		
	public void setLimbsTrainQuartersId(String  limbsTrainQuartersId){
		this.limbsTrainQuartersId = limbsTrainQuartersId;
	}   
	
	public String getTaskTreatment(){
		return taskTreatment;
	}   
		
	public void setTaskTreatment(String  taskTreatment){
		this.taskTreatment = taskTreatment;
	}   
	
	public Date getTaskTreatmentStartTime(){
		return taskTreatmentStartTime;
	}   
		
	public void setTaskTreatmentStartTime(Date  taskTreatmentStartTime){
		this.taskTreatmentStartTime = taskTreatmentStartTime;
	}   
	
	public Date getTaskTreatmentEndTime(){
		return taskTreatmentEndTime;
	}   
		
	public void setTaskTreatmentEndTime(Date  taskTreatmentEndTime){
		this.taskTreatmentEndTime = taskTreatmentEndTime;
	}   
	
	public String getTaskTreatmentTotal(){
		return taskTreatmentTotal;
	}   
		
	public void setTaskTreatmentTotal(String  taskTreatmentTotal){
		this.taskTreatmentTotal = taskTreatmentTotal;
	}   
	
	public String getTaskTreatmentFrequency(){
		return taskTreatmentFrequency;
	}   
		
	public void setTaskTreatmentFrequency(String  taskTreatmentFrequency){
		this.taskTreatmentFrequency = taskTreatmentFrequency;
	}   
	
	public String getTaskTreatmentWhen(){
		return taskTreatmentWhen;
	}   
		
	public void setTaskTreatmentWhen(String  taskTreatmentWhen){
		this.taskTreatmentWhen = taskTreatmentWhen;
	}   
	
	public String getTaskTreatmentStrength(){
		return taskTreatmentStrength;
	}   
		
	public void setTaskTreatmentStrength(String  taskTreatmentStrength){
		this.taskTreatmentStrength = taskTreatmentStrength;
	}   
	
	public String getTaskTreatmentQuartersId(){
		return taskTreatmentQuartersId;
	}   
		
	public void setTaskTreatmentQuartersId(String  taskTreatmentQuartersId){
		this.taskTreatmentQuartersId = taskTreatmentQuartersId;
	}   
	
	public String getRecentTarget(){
		return recentTarget;
	}   
		
	public void setRecentTarget(String  recentTarget){
		this.recentTarget = recentTarget;
	}   
	
	public String getForwardTarget(){
		return forwardTarget;
	}   
		
	public void setForwardTarget(String  forwardTarget){
		this.forwardTarget = forwardTarget;
	}   
	
	public String getCarefulMatter(){
		return carefulMatter;
	}   
		
	public void setCarefulMatter(String  carefulMatter){
		this.carefulMatter = carefulMatter;
	}   
	
	public String getDoctorNm(){
		return doctorNm;
	}   
		
	public void setDoctorNm(String  doctorNm){
		this.doctorNm = doctorNm.trim();
	}   
	
	public String getAcupunctureQuartersNm(){
		return acupunctureQuartersNm;
	}   
		
	public void setAcupunctureQuartersNm(String  acupunctureQuartersNm){
		this.acupunctureQuartersNm = acupunctureQuartersNm.trim();
	}   
	
	public String getPsychologyRecoverQuartersNm(){
		return psychologyRecoverQuartersNm;
	}   
		
	public void setPsychologyRecoverQuartersNm(String  psychologyRecoverQuartersNm){
		this.psychologyRecoverQuartersNm = psychologyRecoverQuartersNm.trim();
	}   
	
	public String getLimbsTrainQuartersNm(){
		return limbsTrainQuartersNm;
	}   
		
	public void setLimbsTrainQuartersNm(String  limbsTrainQuartersNm){
		this.limbsTrainQuartersNm = limbsTrainQuartersNm.trim();
	}   
	
	public String getTaskTreatmentQuartersNm(){
		return taskTreatmentQuartersNm;
	}   
		
	public void setTaskTreatmentQuartersNm(String  taskTreatmentQuartersNm){
		this.taskTreatmentQuartersNm = taskTreatmentQuartersNm.trim();
	}

	
	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}

	public String getElderName() {
		return elderName;
	}

	public void setElderName(String elderName) {
		this.elderName = elderName.trim();
	}

	public String getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}

	public String getQuartersName() {
		return quartersName;
	}

	public void setQuartersName(String quartersName) {
		this.quartersName = quartersName.trim();
	}

	public String getInterveneId() {
		return interveneId;
	}

	public void setInterveneId(String interveneId) {
		this.interveneId = interveneId;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber.trim();
	}

	public Date getRecoverStartTime() {
		return recoverStartTime;
	}

	public void setRecoverStartTime(Date recoverStartTime) {
		this.recoverStartTime = recoverStartTime;
	}

	public Date getRecoverEndTime() {
		return recoverEndTime;
	}

	public void setRecoverEndTime(Date recoverEndTime) {
		this.recoverEndTime = recoverEndTime;
	}   
	
}


