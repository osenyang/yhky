package com.elink.hospitalhealthnurse.modules.plan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Length;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 计划执行记录Entity
 * @author 王宴萍
 * @version 2016-10-10
 */
@Entity
@Table(name = "hn_plan_execute_record")
@DynamicInsert @DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PlanExecuteRecord extends BaseEntity<PlanExecuteRecord> {
	private static final long serialVersionUID = 1L;
	
	public static final String PLAN_TYPE_ASSESSMENT="0";//诊疗
	public static final String PLAN_TYPE_CARE="1";//护理
	public static final String PLAN_TYPE_NURSE="2";//照护
	public static final String PLAN_TYPE_NUTRITION="3";//营养
	public static final String PLAN_TYPE_RECOVER="4";//康复
	public static final String PLAN_TYPE_SOCIAL_HOBBY="5";//社工-喜好
	public static final String PLAN_TYPE_MEET="6";//应急
	public static final String EXECUTE_STATE_OVERDUE = "3";//过期未执行
	private String id;		// 编号
	private String interveneId;		// 干预方案id
	private String archivesId;		// 档案id
	private String planType;	// 计划类型 
	private String planId;	// 
	private String projectTypeCode;// 服务项目类型（PlanProjectTypeEnum）
	private String projectName;// 服务项目类型
	private String projectSubName;// 服务项目子类型
	private String serviceUserId;	// 服务人员id
	private String serviceUserName;	// 服务人员id
	private String quartersId; //(执行人/岗位)    
	private Date expectedStartTime;// 预计执行开始时间
	private Date startTime;// 执行开始时间
	private Date stopTime;// 执行结束时间
	private Date createDate;// 执行结束时间
	private String state;// 执行状态
	private String delFlag;// 删除状态
	private String otherTime;// 其余时间

	public PlanExecuteRecord() {
		super();
	}
	
	public PlanExecuteRecord(String id) {
		this();
		this.id = id;
	}
	
	public PlanExecuteRecord(String interveneId,String archivesId,String projectName,String projectSubName, String planType,
			String planId, String projectTypeCode, String serviceUserId,
			Date expectedStartTime, Date startTime, Date stopTime,String quartersId,String otherTime,
			String state) {
		super();
		this.interveneId = interveneId;
		this.archivesId = archivesId;
		this.projectName = projectName;
		this.projectSubName = projectSubName;
		this.planType = planType;
		this.planId = planId;
		this.projectTypeCode = projectTypeCode;
		this.serviceUserId = serviceUserId;
		this.expectedStartTime = expectedStartTime;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.quartersId = quartersId;
		this.otherTime = otherTime;
		this.state = state;
	}

	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.delFlag = DEL_FLAG_NORMAL;
		this.state = EXECUTE_STATE_WAIT;
		this.createDate=new Date();
	}
	@Length(min=1, max=1)
	@Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInterveneId() {
		return interveneId;
	}

	public void setInterveneId(String interveneId) {
		this.interveneId = interveneId.trim();
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType.trim();
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
		this.projectTypeCode = projectTypeCode.trim();
	}

	public String getServiceUserId() {
		return serviceUserId;
	}

	public void setServiceUserId(String serviceUserId) {
		this.serviceUserId = serviceUserId;
	}

	public Date getExpectedStartTime() {
		return expectedStartTime;
	}

	public void setExpectedStartTime(Date expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}

	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}


	public String getOtherTime() {
		return otherTime;
	}

	public void setOtherTime(String otherTime) {
		this.otherTime = otherTime;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName.trim();
	}

	public String getProjectSubName() {
		return projectSubName;
	}

	public void setProjectSubName(String projectSubName) {
		this.projectSubName = projectSubName;
	}

	@Transient
	public String getServiceUserName() {
		return serviceUserName;
	}

	public void setServiceUserName(String serviceUserName) {
		this.serviceUserName = serviceUserName.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}