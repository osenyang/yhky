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
 * 服务人员信息Entity
 * @author 颜福艳
 * @version 2016-10-09
 */
@Entity
@Table(name = "sys_service_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ServiceUser extends BaseEntity<ServiceUser> {
	
	private static final long serialVersionUID = 1L;

	public static final String TABLE_NM = "sys_service_user";
	
	public ServiceUser() {
		super();
	}

	public ServiceUser(String id){
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
   
	private String officeId; //所属医院    
   
	private String name; //医生姓名    
   
	private String quartersId; //岗位    
   
	private String departmentId; //所在科室 
	
	private String sex; //性别    
   
	private java.util.Date birthDate; //出生日期    
   
	private String mobile; //联系电话    
	
	private String jobNumber; //工号
   
	private String remarks; //简介    
   
	private String thumbImg; //缩略图    
   
	private String imgUrl; //图片    
   
	private java.util.Date createDate; //创建时间    
   
	private java.util.Date updateDate; //更新时间
   
	private String delFlag; //删除标记（0：正常1：删除2：审核）    

	private String quartersNm;
	private String departmentNm;
	
	@Id	
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

	public String getName(){
		return name;
	}   
		
	public void setName(String name){
		this.name = name.trim();
	}   
	
	public String getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}

	public String getDepartmentId(){
		return departmentId;
	}   
		
	public void setDepartmentId(String  departmentId){
		this.departmentId = departmentId;
	}   
	
	public String getSex(){
		return sex;
	}   
		
	public void setSex(String  sex){
		this.sex = sex.trim();
	}   
	
	public java.util.Date getBirthDate(){
		return birthDate;
	}   
		
	public void setBirthDate(java.util.Date  birthDate){
		this.birthDate = birthDate;
	}   
	
	public String getMobile(){
		return mobile;
	}   
		
	public void setMobile(String  mobile){
		this.mobile = mobile.trim();
	}   
	
	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber.trim();
	}
	
	public String getRemarks(){
		return remarks;
	}   
		
	public void setRemarks(String  remarks){
		this.remarks = remarks.trim();
	}   
	
	public String getThumbImg(){
		return thumbImg;
	}   
		
	public void setThumbImg(String  thumbImg){
		this.thumbImg = thumbImg;
	}   
	
	public String getImgUrl(){
		return imgUrl;
	}   
		
	public void setImgUrl(String  imgUrl){
		this.imgUrl = imgUrl;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getDelFlag(){
		return delFlag;
	}   
		
	public void setDelFlag(String  delFlag){
		this.delFlag = delFlag;
	}
	
	@Transient
	public String getQuartersNm() {
		return quartersNm;
	}

	public void setQuartersNm(String quartersNm) {
		this.quartersNm = quartersNm.trim();
	}

	@Transient
	public String getDepartmentNm() {
		return departmentNm;
	}

	public void setDepartmentNm(String departmentNm) {
		this.departmentNm = departmentNm.trim();
	}   
	
}


