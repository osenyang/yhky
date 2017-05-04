package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

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
 * 干预方案——应急计划关联表Entity
 * @author 杜康
 * @version 2016-10-26
 */
@Entity
@Table(name = "hn_intervene_meet")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class InterveneMeet extends BaseEntity<InterveneMeet> {
	
	private static final long serialVersionUID = 1L;

	public InterveneMeet() {
		super();
	}

	public InterveneMeet(String id){
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
   
	private String interveneId; //干预方案主键ID    
   
	private String meetId; //应急计划主键ID    

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
	
	public String getMeetId(){
		return meetId;
	}   
		
	public void setMeetId(String  meetId){
		this.meetId = meetId;
	}   
	
}


