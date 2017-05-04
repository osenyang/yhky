package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务人员排班VO
 * @author 王宴萍
 * @version 2016-10-11
 */
public class ServiceUserRosterVO implements Serializable{

	private static final long serialVersionUID = 3137186236814593212L;
	private String id;	
	private String officeId;	
	private String officeName;	
	private String departmentId;	
	private String departmentName;	
	private String quartersId;	
	private String quartersName;	
	private String serviceUserId;	// 服务人员id
	private String serviceUserName;	
	private String serialNumber;// 序号
	private Date createDate;// 创建时间
	private Date beginDate;// 上班时间
	private Date endDate;// 下班时间
	
	private int serialNumberRowspan;//显示时所占行数
	private int officeRowspan;//显示时所占行数
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOfficeId() {
		return officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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
		this.departmentName = departmentName;
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
		this.quartersName = quartersName;
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
		this.serviceUserName = serviceUserName;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getSerialNumberRowspan() {
		return serialNumberRowspan;
	}
	public void setSerialNumberRowspan(int serialNumberRowspan) {
		this.serialNumberRowspan = serialNumberRowspan;
	}
	public int getOfficeRowspan() {
		return officeRowspan;
	}
	public void setOfficeRowspan(int officeRowspan) {
		this.officeRowspan = officeRowspan;
	}
	
	
}
