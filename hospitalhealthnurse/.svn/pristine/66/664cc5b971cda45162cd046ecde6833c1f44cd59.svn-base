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
 * 干预方案Entity
 * @author 杜康
 * @version 2016-10-22
 */
@Entity
@Table(name = "hn_intervene")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Intervene extends BaseEntity<Intervene> {
	
	private static final long serialVersionUID = 1L;
	
	// 状态（0：未设定；1：执行中；2：暂停中；3：终止）
	public static final String INTER_STATE_NORMAL = "0";//未设定
	public static final String INTER_STATE_EXECUTE = "1";//执行中
	public static final String INTER_STATE_PAUSE = "2";//暂停中
	public static final String INTER_STATE_STOP = "3";//终止

	public Intervene() {
		super();
	}

	public Intervene(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.updateDate = new Date();
		this.delFlag = Intervene.DEL_FLAG_NORMAL;
		this.state = Intervene.INTER_STATE_NORMAL;
	}
	
	@PreUpdate
	public void preUpdate(){
		this.updateDate = new Date();
	}
	
	private String id;	//编号
   
	private String archivesId; //档案ID    
   
	private String state; //状态(0、未设定，1、执行中，2暂停中，3终止)    
   
	private Date createDate; //发送时间    
	
	private Date updateDate;//修改时间
   
	private String delFlag; //删除标记    
	
	private String assessmentId;//诊疗计划ID
	private String careId;//护理计划ID
	private String nutritionId;//营养计划ID
	private String recoverId;//康复计划ID
	private String nurserId;//照护计计划ID
	private String socialId;//社工计划ID

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getArchivesId(){
		return archivesId;
	}   
		
	public void setArchivesId(String  archivesId){
		this.archivesId = archivesId;
	}   
	
	public String getState(){
		return state;
	}   
		
	public void setState(String  state){
		this.state = state;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag(){
		return delFlag;
	}   
		
	public void setDelFlag(String  delFlag){
		this.delFlag = delFlag;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getCareId() {
		return careId;
	}

	public void setCareId(String careId) {
		this.careId = careId;
	}

	public String getNutritionId() {
		return nutritionId;
	}

	public void setNutritionId(String nutritionId) {
		this.nutritionId = nutritionId;
	}

	public String getRecoverId() {
		return recoverId;
	}

	public void setRecoverId(String recoverId) {
		this.recoverId = recoverId;
	}

	public String getNurserId() {
		return nurserId;
	}

	public void setNurserId(String nurserId) {
		this.nurserId = nurserId;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	
}


