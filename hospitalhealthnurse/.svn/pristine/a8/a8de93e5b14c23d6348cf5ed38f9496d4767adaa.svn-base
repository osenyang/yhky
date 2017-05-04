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
public class ElderPlanExecuteRecordVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String bedNumber;//执行i
	private String archivesId;//档案id
	private String elderName;//老人姓名
	private String doctorId; //责任医生    
	private String doctorNm; //责任医生    
	
	private String state;// 老人状态
	private String healthRisk;//风险
	
	private boolean careHaveUnExe;
	private boolean nurseHaveUnExe;
	private boolean nutritionHaveUnExe;
	private boolean recoverHaveUnExe;
	private boolean hobbyHaveUnExe;
	List<WsElderPlanExecuteRecordVO> planExecuteRecordVOs;
	public ElderPlanExecuteRecordVO() {
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

	

	public List<WsElderPlanExecuteRecordVO> getPlanExecuteRecordVOs() {
		return planExecuteRecordVOs;
	}

	public void setPlanExecuteRecordVOs(
			List<WsElderPlanExecuteRecordVO> planExecuteRecordVOs) {
		this.planExecuteRecordVOs = planExecuteRecordVOs;
	}

	public String getHealthRisk() {
		return healthRisk;
	}

	public void setHealthRisk(String healthRisk) {
		this.healthRisk = healthRisk;
	}

	public boolean isCareHaveUnExe() {
		return careHaveUnExe;
	}

	public void setCareHaveUnExe(boolean careHaveUnExe) {
		this.careHaveUnExe = careHaveUnExe;
	}

	public boolean isNurseHaveUnExe() {
		return nurseHaveUnExe;
	}

	public void setNurseHaveUnExe(boolean nurseHaveUnExe) {
		this.nurseHaveUnExe = nurseHaveUnExe;
	}

	public boolean isNutritionHaveUnExe() {
		return nutritionHaveUnExe;
	}

	public void setNutritionHaveUnExe(boolean nutritionHaveUnExe) {
		this.nutritionHaveUnExe = nutritionHaveUnExe;
	}

	public boolean isRecoverHaveUnExe() {
		return recoverHaveUnExe;
	}

	public void setRecoverHaveUnExe(boolean recoverHaveUnExe) {
		this.recoverHaveUnExe = recoverHaveUnExe;
	}

	public boolean isHobbyHaveUnExe() {
		return hobbyHaveUnExe;
	}

	public void setHobbyHaveUnExe(boolean hobbyHaveUnExe) {
		this.hobbyHaveUnExe = hobbyHaveUnExe;
	}

	
}


