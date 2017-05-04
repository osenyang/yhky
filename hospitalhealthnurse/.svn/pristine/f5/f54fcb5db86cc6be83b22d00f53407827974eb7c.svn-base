package com.elink.hospitalhealthnurse.modules.statistics.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 心情指数Entity
 * @author 颜福艳
 * @version 2016-10-11
 */
@Entity
@Table(name = "hn_mood_index")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MoodIndex extends BaseEntity<MoodIndex> {
	
	private static final long serialVersionUID = 1L;

	public MoodIndex() {
		super();
	}

	public MoodIndex(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	private String id;	//编号
   
	private String userId; //老人id    
   
	private String officeId; //所属机构    
   
	private String moodValue; //心情值    
   
	private java.util.Date createDate; //记录日期    
   
	private String delFlag; //删除标记（0：正常1：删除2：审核）    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId(){
		return userId;
	}   
		
	public void setUserId(String  userId){
		this.userId = userId;
	}   
	
	public String getOfficeId(){
		return officeId;
	}   
		
	public void setOfficeId(String  officeId){
		this.officeId = officeId;
	}   
	
	public String getMoodValue(){
		return moodValue;
	}   
		
	public void setMoodValue(String  moodValue){
		this.moodValue = moodValue.trim();
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public String getDelFlag(){
		return delFlag;
	}   
		
	public void setDelFlag(String  delFlag){
		this.delFlag = delFlag;
	}   
	
}


