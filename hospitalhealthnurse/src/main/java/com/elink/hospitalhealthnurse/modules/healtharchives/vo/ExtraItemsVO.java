package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;

/**
 * 额外项目Entity
 * @author 杜康
 * @version 2017-04-11
 */
public class ExtraItemsVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String projectNm; //项目名称    
	private String quartersId; //执行人/岗位    
	private String quartersNm; //执行人/岗位    
	private java.util.Date exeTime; //执行时间    
	private String frequencyType; //频次类型（0、天,1、周）    
	private String intervals; //间隔时间    
	private String dateArray; //时间数组    
	private String delFlag; //删除标记    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getProjectNm(){
		return projectNm;
	}   
		
	public void setProjectNm(String  projectNm){
		this.projectNm = projectNm;
	}   
	
	public String getQuartersId(){
		return quartersId;
	}   
		
	public void setQuartersId(String  quartersId){
		this.quartersId = quartersId;
	}   
	
	public String getQuartersNm(){
		return quartersNm;
	}   
		
	public void setQuartersNm(String  quartersNm){
		this.quartersNm = quartersNm;
	}   
	
	public java.util.Date getExeTime(){
		return exeTime;
	}   
		
	public void setExeTime(java.util.Date  exeTime){
		this.exeTime = exeTime;
	}   
	
	public String getFrequencyType(){
		return frequencyType;
	}   
		
	public void setFrequencyType(String  frequencyType){
		this.frequencyType = frequencyType;
	}   
	
	public String getIntervals(){
		return intervals;
	}   
		
	public void setIntervals(String  intervals){
		this.intervals = intervals;
	}   
	
	public String getDateArray(){
		return dateArray;
	}   
		
	public void setDateArray(String  dateArray){
		this.dateArray = dateArray;
	}   
	
	public String getDelFlag(){
		return delFlag;
	}   
		
	public void setDelFlag(String  delFlag){
		this.delFlag = delFlag;
	}   
	
}

