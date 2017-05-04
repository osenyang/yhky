package com.elink.hospitalhealthnurse.modules.statistics.vo;

import java.io.Serializable;

/**
 * 喜爱统计Entity
 * @author 颜福艳
 * @version 2016-10-11
 */
public class LoveValueVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer number; //人数
	private String serviceUserId; //服务人员ID
	private String serviceUserNm; //服务人员姓名
	private String departmentId; //科室ID
	private String departmentNm; //科室名称
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getServiceUserId() {
		return serviceUserId;
	}
	public void setServiceUserId(String serviceUserId) {
		this.serviceUserId = serviceUserId;
	}
	public String getServiceUserNm() {
		return serviceUserNm;
	}
	public void setServiceUserNm(String serviceUserNm) {
		this.serviceUserNm = serviceUserNm;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentNm() {
		return departmentNm;
	}
	public void setDepartmentNm(String departmentNm) {
		this.departmentNm = departmentNm;
	}
	
}


