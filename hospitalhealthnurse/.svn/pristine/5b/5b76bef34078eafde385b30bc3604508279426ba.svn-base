package com.elink.hospitalhealthnurse.modules.statistics.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.utils.Consts;

/**
 * 心情指数Entity
 * @author 颜福艳
 * @version 2016-10-11
 */
public class MoodIndexVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String userId; //老人id  
	private String fullNm; //老人姓名
	private String sex; //老人性别
	private Integer age; //老人年龄
	private String photo; //图片   
	private String officeId; //所属机构 
	private String officeNm; //机构名称
	private String moodValue; //心情值    
	private String createDate; //记录日期    
	
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
	public String getMoodValue() {
		return moodValue;
	}
	public void setMoodValue(String moodValue) {
		this.moodValue = moodValue;
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

}


