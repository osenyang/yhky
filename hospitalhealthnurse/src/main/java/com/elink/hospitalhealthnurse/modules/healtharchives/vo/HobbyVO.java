package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;

/**
 * 兴趣爱好Entity
 * @author 杜康
 * @version 2016-10-26
 */
public class HobbyVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String hobby; //兴趣爱好    
	private String hobbyAsk; //兴趣爱好要求    
	private java.util.Date hobbyStartTime; //兴趣爱好(开始时间)    
	private java.util.Date hobbyEndTime; //兴趣爱好(结束时间)    
	private String hobbyOther; //兴趣爱好(其他)    
	private String hobbyQuartersId; //兴趣爱好(执行人/岗位)
	private String hobbyQuartersNm; //兴趣爱好(执行人/岗位)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getHobby(){
		return hobby;
	}   
		
	public void setHobby(String  hobby){
		this.hobby = hobby;
	}   
	
	public String getHobbyAsk(){
		return hobbyAsk;
	}   
		
	public void setHobbyAsk(String  hobbyAsk){
		this.hobbyAsk = hobbyAsk;
	}   
	
	public java.util.Date getHobbyStartTime(){
		return hobbyStartTime;
	}   
		
	public void setHobbyStartTime(java.util.Date  hobbyStartTime){
		this.hobbyStartTime = hobbyStartTime;
	}   
	
	public java.util.Date getHobbyEndTime(){
		return hobbyEndTime;
	}   
		
	public void setHobbyEndTime(java.util.Date  hobbyEndTime){
		this.hobbyEndTime = hobbyEndTime;
	}   
	
	public String getHobbyOther(){
		return hobbyOther;
	}   
		
	public void setHobbyOther(String  hobbyOther){
		this.hobbyOther = hobbyOther;
	}   
	
	public String getHobbyQuartersId(){
		return hobbyQuartersId;
	}   
		
	public void setHobbyQuartersId(String  hobbyQuartersId){
		this.hobbyQuartersId = hobbyQuartersId;
	}

	public String getHobbyQuartersNm() {
		return hobbyQuartersNm;
	}

	public void setHobbyQuartersNm(String hobbyQuartersNm) {
		this.hobbyQuartersNm = hobbyQuartersNm;
	}   
	
}


