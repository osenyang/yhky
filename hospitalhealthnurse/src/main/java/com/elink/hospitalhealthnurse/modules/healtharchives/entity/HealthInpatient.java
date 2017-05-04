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
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;

/**
 * 病区管理Entity
 * @author 杜康
 * @version 2017-03-27
 */
@Entity
@Table(name = "hn_health_inpatient")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HealthInpatient extends BaseEntity<HealthInpatient> {
	
	private static final long serialVersionUID = 1L;

	public HealthInpatient() {
		super();
	}

	public HealthInpatient(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.updateDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
		this.officeId = UserUtils.getUser().getOffice().getId();
	}
	
	@PreUpdate
	public void preUpdate(){
		this.updateDate = new Date();
	}
	
	private String id;	//编号
   
	private String areaNm; //病区名称    
   
	private String officeId; //所属机构ID    
   
	private java.util.Date createDate; //创建时间    
   
	private String createBy; //创建者    
   
	private String updateBy; //更新者    
   
	private java.util.Date updateDate; //更新时间    
	
	private String delFlag;//删除标记

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getAreaNm(){
		return areaNm;
	}   
		
	public void setAreaNm(String  areaNm){
		this.areaNm = areaNm;
	}   
	
	public String getOfficeId(){
		return officeId;
	}   
		
	public void setOfficeId(String  officeId){
		this.officeId = officeId;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public String getCreateBy(){
		return createBy;
	}   
		
	public void setCreateBy(String  createBy){
		this.createBy = createBy;
	}   
	
	public String getUpdateBy(){
		return updateBy;
	}   
		
	public void setUpdateBy(String  updateBy){
		this.updateBy = updateBy;
	}   
	
	public java.util.Date getUpdateDate(){
		return updateDate;
	}   
		
	public void setUpdateDate(java.util.Date  updateDate){
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}   
	
}


