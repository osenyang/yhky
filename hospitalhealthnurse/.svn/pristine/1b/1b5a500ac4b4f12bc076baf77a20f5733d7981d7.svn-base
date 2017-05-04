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
 * 计划频次Entity
 * @author 杜康
 * @version 2017-03-17
 */
@Entity
@Table(name = "hn_frequency")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Frequencys extends BaseEntity<Frequencys> {
	
	private static final long serialVersionUID = 1L;

	public Frequencys() {
		super();
	}

	public Frequencys(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
	}
	
	private String id;	//编号
   
	private String interveneId; //干预方案主键ID    
   
	private String planId; //计划ID    
   
	private String frequencyType; //频次类型（0、天,1、周）    
   
	private String intervals; //间隔时间    
   
	private String dateArray; //时间数组    
   
	private java.util.Date createDate; //创建时间    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getInterveneId(){
		return interveneId;
	}   
		
	public void setInterveneId(String  interveneId){
		this.interveneId = interveneId;
	}   
	
	public String getPlanId(){
		return planId;
	}   
		
	public void setPlanId(String  planId){
		this.planId = planId;
	}   
	
	public String getFrequencyType(){
		return frequencyType;
	}   
		
	public void setFrequencyType(String  frequencyType){
		this.frequencyType = frequencyType;
	}   
	
	public String getIntervals() {
		return intervals;
	}

	public void setIntervals(String intervals) {
		this.intervals = intervals;
	}

	public String getDateArray(){
		return dateArray;
	}   
		
	public void setDateArray(String  dateArray){
		this.dateArray = dateArray;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
}


