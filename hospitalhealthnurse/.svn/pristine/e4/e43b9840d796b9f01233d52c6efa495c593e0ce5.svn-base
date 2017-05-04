package com.elink.hospitalhealthnurse.modules.serviceorg.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.utils.Consts;

/**
 * 医生信息Entity
 * @author 颜福艳
 * @version 2016-09-02
 */
public class ServiceUserVO implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private String id;	//编号
	private String officeId; //所属医院    
	private String officeNm;
	private String name; //医生姓名    
	private String quartersId; //岗位 
	private String quartersNm;
	private String departmentId; //所在科室    
	private String departmentNm;
	private String sex; //性别    
	private String birthDate; //出生日期    
	private String mobile; //联系电话    
	private String jobNumber; //工号
	private String remarks; //简介    
	private String thumbImg; //缩略图    
	private String imgUrl; //图片    
	private String createDate; //创建时间    
	
	private String isLove;
	
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
	public String getOfficeNm() {
		return officeNm;
	}
	public void setOfficeNm(String officeNm) {
		this.officeNm = officeNm.trim();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getQuartersId() {
		return quartersId;
	}
	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}
	public String getQuartersNm() {
		return quartersNm;
	}
	public void setQuartersNm(String quartersNm) {
		this.quartersNm = quartersNm.trim();
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getThumbImg() {
		if(StringUtils.isNotBlank(thumbImg))
			return Global.getConfig(Consts.STATIC_FILE_SITE)+thumbImg;
		return thumbImg;
	}
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
	public String getImgUrl() {
		if(StringUtils.isNotBlank(imgUrl))
			return Global.getConfig(Consts.STATIC_FILE_SITE)+imgUrl;
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getIsLove() {
		return isLove;
	}
	public void setIsLove(String isLove) {
		this.isLove = isLove;
	}
	
	
}


