package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 应急计划Entity
 * @author 杜康
 * @version 2016-10-26
 */
@Entity
@Table(name = "hn_health_meet")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Meet extends BaseEntity<Meet> {
	
	private static final long serialVersionUID = 1L;

	public Meet() {
		super();
	}

	public Meet(String id){
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
   
	private String entryName; //项目名称    
   
	private String frequencyTotal; //共多少次    
   
	private String frequency; //一天多少次    
   
	private String frequencyTime; //每次时长（分钟）    
   
	private Date startTime; //开始时间    
   
	private Date endTime; //结束时间    
   
	private String quartersId; //执行人/岗位   
	
	private String quartersNm; //执行人/岗位   

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getEntryName(){
		return entryName;
	}   
		
	public void setEntryName(String  entryName){
		this.entryName = entryName;
	}   
	
	public String getFrequencyTotal(){
		return frequencyTotal;
	}   
		
	public void setFrequencyTotal(String  frequencyTotal){
		this.frequencyTotal = frequencyTotal;
	}   
	
	public String getFrequency(){
		return frequency;
	}   
		
	public void setFrequency(String  frequency){
		this.frequency = frequency;
	}   
	
	public String getFrequencyTime(){
		return frequencyTime;
	}   
		
	public void setFrequencyTime(String  frequencyTime){
		this.frequencyTime = frequencyTime;
	}   
	
	public Date getStartTime(){
		return startTime;
	}   
		
	public void setStartTime(Date  startTime){
		this.startTime = startTime;
	}   
	
	public Date getEndTime(){
		return endTime;
	}   
		
	public void setEndTime(Date  endTime){
		this.endTime = endTime;
	}   
	
	public String getQuartersId(){
		return quartersId;
	}   
		
	public void setQuartersId(String  quartersId){
		this.quartersId = quartersId;
	}

	public String getQuartersNm() {
		return quartersNm;
	}

	public void setQuartersNm(String quartersNm) {
		this.quartersNm = quartersNm;
	}   
	@Transient
	public String toString(){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return "{'id':'"+this.id+"','entryName':'"+this.entryName+"','frequencyTotal':'"+this.frequencyTotal+"',"
				+ "'frequency':'"+this.frequency+"','frequencyTime':'"+this.frequencyTime+"',"
				+ "'startTime':'"+format.format(this.startTime)+"','endTime':'"+format.format(this.endTime)+"',"
				+ "'quartersId':'"+this.quartersId+"','quartersNm':'"+this.quartersNm+"'}";
	}
}


