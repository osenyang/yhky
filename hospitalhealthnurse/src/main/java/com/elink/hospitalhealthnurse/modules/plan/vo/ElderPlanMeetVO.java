package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 老人方案-应急计划Entity
 * @author 王宴萍
 * @version 2016-11-18
 */
public class ElderPlanMeetVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String archivesId;	
	private String elderName;	
	private String quartersName;	
	private String interveneId;	
	private String bedNumber;
	private String interveneMeetId;//方案-应急-中间键id
	
	private String entryName; //项目名称    
	private String frequencyTotal; //共多少次    
	private String frequency; //一天多少次    
	private String frequencyTime; //每次时长（分钟）    
	private Date startTime; //开始时间    
	private Date endTime; //结束时间    
	private String quartersId; //执行人/岗位    
	private String quartersNm; //执行人/岗位   

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}

	public String getElderName() {
		return elderName;
	}

	public void setElderName(String elderName) {
		this.elderName = elderName.trim();
	}

	public String getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}

	public String getQuartersName() {
		return quartersName;
	}

	public void setQuartersName(String quartersName) {
		this.quartersName = quartersName.trim();
	}

	public String getInterveneId() {
		return interveneId;
	}

	public void setInterveneId(String interveneId) {
		this.interveneId = interveneId;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber.trim();
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getFrequencyTotal() {
		return frequencyTotal;
	}

	public void setFrequencyTotal(String frequencyTotal) {
		this.frequencyTotal = frequencyTotal;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFrequencyTime() {
		return frequencyTime;
	}

	public void setFrequencyTime(String frequencyTime) {
		this.frequencyTime = frequencyTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getQuartersNm() {
		return quartersNm;
	}

	public void setQuartersNm(String quartersNm) {
		this.quartersNm = quartersNm;
	}

	public String getInterveneMeetId() {
		return interveneMeetId;
	}

	public void setInterveneMeetId(String interveneMeetId) {
		this.interveneMeetId = interveneMeetId;
	}   
	
}


