package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;
/**
 * 服务人员执行计划记录VO
 * @author 王宴萍
 * @version 2016-10-10
 */
public class ServiceUserPlanExeRecordVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String STATE_FREE="0";//空闲
	public static final String STATE_EXE="1";//正在执行
	private String serviceUserId;	// 服务人员id
	private String serviceUserName;	// 服务人员id
	private String thumbImg; //缩略图    
	private String imgUrl; //图片 
	private String departmentId;	
	private String departmentName;	
	private String quartersId;	
	private String quartersName;
	private int completedCount;//完成数
	private int exeCount;//正在执行数
	private String state;//状态

	public ServiceUserPlanExeRecordVO() {
		super();
	}

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

	public String getThumbImg() {
		return thumbImg;
	}

	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName.trim();
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

	public int getCompletedCount() {
		return completedCount;
	}

	public void setCompletedCount(int completedCount) {
		this.completedCount = completedCount;
	}

	public int getExeCount() {
		return exeCount;
	}

	public void setExeCount(int exeCount) {
		this.exeCount = exeCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}