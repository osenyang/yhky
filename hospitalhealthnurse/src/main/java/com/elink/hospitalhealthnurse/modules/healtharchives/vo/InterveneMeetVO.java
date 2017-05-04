package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;

/**
 * 干预方案——应急计划关联表Entity
 * @author 杜康
 * @version 2016-10-26
 */
public class InterveneMeetVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String interveneId; //干预方案主键ID    
	private String meetId; //应急计划主键ID    

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


