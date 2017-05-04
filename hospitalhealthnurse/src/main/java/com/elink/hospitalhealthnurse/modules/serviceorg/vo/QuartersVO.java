package com.elink.hospitalhealthnurse.modules.serviceorg.vo;

import java.io.Serializable;

/**
 * 岗位管理Entity
 * @author 颜福艳
 * @version 2016-10-10
 */
public class QuartersVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String name; //岗位名称    
	private String officeId; //所属机构
	private String officeNm; //医院名称
	private String departmentId; //科室ID
	private String departmentNm; //科室名称
	private String createDate; //创建时间    
	private String updateDate; // 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}   
		
	public void setName(String  name){
		this.name = name.trim();
	}   
	
	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getOfficeNm() {
		return officeNm;
	}

	public void setOfficeNm(String officeNm) {
		this.officeNm = officeNm.trim();
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
		this.departmentNm = departmentNm.trim();
	}

	public String getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(String  createDate){
		this.createDate = createDate;
	}   
	
	public String getUpdateDate(){
		return updateDate;
	}   
		
	public void setUpdateDate(String  updateDate){
		this.updateDate = updateDate;
	}
	
}


