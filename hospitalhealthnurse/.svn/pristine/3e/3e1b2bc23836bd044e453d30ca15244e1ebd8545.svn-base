package com.elink.hospitalhealthnurse.modules.serviceorg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 岗位管理Entity
 * @author 颜福艳
 * @version 2016-10-10
 */
@Entity
@Table(name = "sys_quarters")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Quarters extends BaseEntity<Quarters> {
	
	private static final long serialVersionUID = 1L;

	public Quarters() {
		super();
	}

	public Quarters(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.updateDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	@PreUpdate
	public void preUpdate(){
		this.updateDate = new Date();
	}
	
	private String id;	//编号
	
	private String name; //岗位名称    
	
	private String officeId; //机构ID
	
	private String departmentId; //科室ID
   
	private java.util.Date createDate; //创建时间    
   
	private java.util.Date updateDate; // 更新时间
	
	private String delFlag; //删除标记（0：正常1：删除2：审核）    
	
	private String departmentNm; //机构名称

	@Id	
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public java.util.Date getUpdateDate(){
		return updateDate;
	}   
		
	public void setUpdateDate(java.util.Date  updateDate){
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Transient
	public String getDepartmentNm() {
		return departmentNm;
	}

	public void setDepartmentNm(String departmentNm) {
		this.departmentNm = departmentNm.trim();
	}   
	
}


