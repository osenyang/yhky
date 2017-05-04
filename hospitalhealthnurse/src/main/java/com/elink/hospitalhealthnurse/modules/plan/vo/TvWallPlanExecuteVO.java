package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;

public class TvWallPlanExecuteVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String serviceUserId;// 服务人员id
	private String serviceUserName;//执行人员姓名
	private String projectName;//服务项目类型
	private String quartersName;//执行岗位名称
	private String quartersId;//执行岗位名称
	private String expectedStartTime;// 预计执行开始时间
	private String startTime;// 执行开始时间
	private String stopTime;// 执行结束时间
	private String projectStr; //
	private String state; //0-未执行1-执行中2-执行完
	
	public String getServiceUserId() {
		return serviceUserId;
	}
	public void setServiceUserId(String serviceUserId) {
		this.serviceUserId = serviceUserId;
	}
	public String getServiceUserName() {
		return serviceUserName;
	}
	public void setServiceUserName(String serviceUserName) {
		this.serviceUserName = serviceUserName.trim();
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName.trim();
	}
	public String getQuartersName() {
		return quartersName;
	}
	public void setQuartersName(String quartersName) {
		this.quartersName = quartersName.trim();
	}
	public String getQuartersId() {
		return quartersId;
	}
	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}
	public String getExpectedStartTime() {
		return expectedStartTime;
	}
	public void setExpectedStartTime(String expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getProjectStr() {
		return projectStr;
	}
	public void setProjectStr(String projectStr) {
		this.projectStr = projectStr.trim();
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
