package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;

/**
 * 服务人员-计划执行VO
 * @author 王宴萍
 * @version 2016-10-28
 */
public class WsElderPlanExecuteRecordVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//方案编号
	private String bedNumber;//执行i
	private String archivesId;//档案id
	private String elderName;//老人姓名
	private String doctorId; //责任医生    
	private String doctorNm; //责任医生    
	
	private String state;// 老人状态
	private String healthRisk;//风险
	
	private String recordId;	//执行记录编号
	private String serviceUserName;//执行人员姓名
	private String sex;//
	private String age;//
	private String projectName;// 服务项目类型
	private String projectSubName;// 服务项目子类型
	private String quartersName;//执行岗位名称
	private String quartersId;//执行i
	private String photo;//老人头像
	private String departmentName;//所在科室
	
	private String interveneId;		// 干预方案id
	private String planType;	// 计划类型 
	private String planId;	// 
	private String projectTypeCode;// 服务项目类型（PlanProjectTypeEnum）
	private String serviceUserId;	// 服务人员id
	private String expectedStartTime;// 预计执行开始时间
	private String startTime;// 执行开始时间
	private String stopTime;// 执行结束时间
	private String recordState;// 执行状态
	private String otherTime;// 其余时间
	
	private String careTime;
	private String careProject;
	
	private String nurseTime;
	private String nurseProject;
	
	private String nutritionTime;
	private String nutritionProject;
	
	private String recoverTime;
	private String recoverProject;
	
	private String hobbyTime;
	private String hobbyProject;
	
	
	public WsElderPlanExecuteRecordVO(){
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber.trim();
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorNm() {
		return doctorNm;
	}

	public void setDoctorNm(String doctorNm) {
		this.doctorNm = doctorNm.trim();
	}


	public String getHealthRisk() {
		return healthRisk;
	}

	public void setHealthRisk(String healthRisk) {
		this.healthRisk = healthRisk;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getServiceUserName() {
		return serviceUserName;
	}

	public void setServiceUserName(String serviceUserName) {
		this.serviceUserName = serviceUserName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectSubName() {
		return projectSubName;
	}

	public void setProjectSubName(String projectSubName) {
		this.projectSubName = projectSubName;
	}

	public String getQuartersName() {
		return quartersName;
	}

	public void setQuartersName(String quartersName) {
		this.quartersName = quartersName;
	}

	public String getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getInterveneId() {
		return interveneId;
	}

	public void setInterveneId(String interveneId) {
		this.interveneId = interveneId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getProjectTypeCode() {
		return projectTypeCode;
	}

	public void setProjectTypeCode(String projectTypeCode) {
		this.projectTypeCode = projectTypeCode;
	}

	public String getServiceUserId() {
		return serviceUserId;
	}

	public void setServiceUserId(String serviceUserId) {
		this.serviceUserId = serviceUserId;
	}

	public String getExpectedStartTime() {
		return expectedStartTime;
	}

	public void setExpectedStartTime(String expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public String getOtherTime() {
		return otherTime;
	}

	public void setOtherTime(String otherTime) {
		this.otherTime = otherTime;
	}

	public String getCareTime() {
		return careTime;
	}

	public void setCareTime(String careTime) {
		this.careTime = careTime;
	}

	public String getCareProject() {
		return careProject;
	}

	public void setCareProject(String careProject) {
		this.careProject = careProject;
	}

	public String getNurseTime() {
		return nurseTime;
	}

	public void setNurseTime(String nurseTime) {
		this.nurseTime = nurseTime;
	}

	public String getNurseProject() {
		return nurseProject;
	}

	public void setNurseProject(String nurseProject) {
		this.nurseProject = nurseProject;
	}

	public String getNutritionTime() {
		return nutritionTime;
	}

	public void setNutritionTime(String nutritionTime) {
		this.nutritionTime = nutritionTime;
	}

	public String getNutritionProject() {
		return nutritionProject;
	}

	public void setNutritionProject(String nutritionProject) {
		this.nutritionProject = nutritionProject;
	}

	public String getRecoverTime() {
		return recoverTime;
	}

	public void setRecoverTime(String recoverTime) {
		this.recoverTime = recoverTime;
	}

	public String getRecoverProject() {
		return recoverProject;
	}

	public void setRecoverProject(String recoverProject) {
		this.recoverProject = recoverProject;
	}

	public String getHobbyTime() {
		return hobbyTime;
	}

	public void setHobbyTime(String hobbyTime) {
		this.hobbyTime = hobbyTime;
	}

	public String getHobbyProject() {
		return hobbyProject;
	}

	public void setHobbyProject(String hobbyProject) {
		this.hobbyProject = hobbyProject;
	}

	

	
}


