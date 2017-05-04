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
 * 历史方案Entity
 * @author 杜康
 * @version 2017-04-11
 */
@Entity
@Table(name = "hn_hostory_plan")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HostoryPlan extends BaseEntity<HostoryPlan> {
	
	private static final long serialVersionUID = 1L;

	public HostoryPlan() {
		super();
	}

	public HostoryPlan(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
	}
	
	private String id;	//编号
   
	private String planId; //计划类型    
   
	private String planType; //计划类型    
   
	private String createBy; //创建者    
   
	private java.util.Date createDate; //创建日期    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPlanId(){
		return planId;
	}   
		
	public void setPlanId(String  planId){
		this.planId = planId;
	}   
	
	public String getPlanType(){
		return planType;
	}   
		
	public void setPlanType(String  planType){
		this.planType = planType;
	}   
	
	public String getCreateBy(){
		return createBy;
	}   
		
	public void setCreateBy(String  createBy){
		this.createBy = createBy;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
}


