package com.elink.hospitalhealthnurse.modules.statistics.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.utils.Consts;

/**
 * 喜爱统计Entity
 * @author 颜福艳
 * @version 2016-10-11
 */
public class LoveCensusVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String userId; //老人id  
	private String fullNm; //老人姓名
	private String sex; //老人性别
	private Integer age; //老人年龄
	private String photo; //图片   
	private String serviceUserId; //服务人员id 
	private String serviceUserNm; //服务人员id 
	private String thumbImg; //缩略图    
	private String imgUrl; //图片   
	private String officeId; //所属机构 
	private String officeNm; //机构名称
	private String departmentId; //科室    
	private String departmentNm; //科室名称
	private String createDate; //创建时间
	private String hospitalizationNumber;//住院编号
	private String inpatientNm;//所属病区
	
	private String startDate; //开始时间
	private String endDate; //结束时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullNm() {
		return fullNm;
	}
	public void setFullNm(String fullNm) {
		this.fullNm = fullNm.trim();
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex.trim();
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhoto() {
		if(StringUtils.isNotBlank(photo))
			return Global.getConfig(Consts.STATIC_FILE_SITE)+photo;
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
		this.serviceUserNm = serviceUserNm.trim();
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getHospitalizationNumber() {
		return hospitalizationNumber;
	}
	public void setHospitalizationNumber(String hospitalizationNumber) {
		this.hospitalizationNumber = hospitalizationNumber;
	}
	public String getInpatientNm() {
		return inpatientNm;
	}
	public void setInpatientNm(String inpatientNm) {
		this.inpatientNm = inpatientNm;
	}
	
	
}


