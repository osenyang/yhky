package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;


/**
 * 干预方案Entity
 * @author 杜康
 * @version 2016-10-22
 */
public class InterveneVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String archivesId; //档案ID    
	private String state; //状态(0、未设定，1、执行中，2暂停中，3终止)    
	private java.util.Date createDate; //发送时间    
	private java.util.Date updateDate;//修改时间
	private String delFlag; //删除标记   
	private String assessmentId;//诊疗计划ID
	private String careId;//照护计划ID
	private String nutritionId;//营养计划ID
	private String recoverId;//康复计划ID
	private String nurserId;//护理计计划ID
	private String socialId;//社工计划ID
	private String meetId;//应急计划ID
	private String photo;//头像
	private String fullNm; //姓名    
	private String sex; //性别    
	private String idCard; //身份证号    
	private java.util.Date birthDate; //出生日期
	private int height; //身高    
	private String weight; //体重    
	private String contact; //家属联系方式    
	private String occupation; //职业    
	private String degree; //文化程度    
	private String medicalType; //医保类型
	private String hospitalizationNumber;//住院编号	
	private String age;//年龄
	private String bedNumber;//床号
	private String inpatientNm;//病区
	private String archivesState;//老人状态

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getArchivesId(){
		return archivesId;
	}   
		
	public void setArchivesId(String  archivesId){
		this.archivesId = archivesId;
	}   
	
	public String getState(){
		return state;
	}   
		
	public void setState(String  state){
		this.state = state;
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

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getCareId() {
		return careId;
	}

	public void setCareId(String careId) {
		this.careId = careId;
	}

	public String getNutritionId() {
		return nutritionId;
	}

	public void setNutritionId(String nutritionId) {
		this.nutritionId = nutritionId;
	}

	public String getRecoverId() {
		return recoverId;
	}

	public void setRecoverId(String recoverId) {
		this.recoverId = recoverId;
	}

	public String getNurserId() {
		return nurserId;
	}

	public void setNurserId(String nurserId) {
		this.nurserId = nurserId;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getMeetId() {
		return meetId;
	}

	public void setMeetId(String meetId) {
		this.meetId = meetId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getFullNm() {
		return fullNm;
	}

	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public java.util.Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMedicalType() {
		return medicalType;
	}

	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	public String getHospitalizationNumber() {
		return hospitalizationNumber;
	}

	public void setHospitalizationNumber(String hospitalizationNumber) {
		this.hospitalizationNumber = hospitalizationNumber;
	}

	public String getAge(){
		if(birthDate != null){
			int curYear = Integer.parseInt(DateUtils.getYear());
			int birthYear = Integer.parseInt(DateUtils.formatDate(birthDate, "yyyy"));
			return (curYear-birthYear)+"";
		}
		age = "0";
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getInpatientNm() {
		return inpatientNm;
	}

	public void setInpatientNm(String inpatientNm) {
		this.inpatientNm = inpatientNm;
	}

	public String getArchivesState() {
		return archivesState;
	}

	public void setArchivesState(String archivesState) {
		this.archivesState = archivesState;
	}   
	
}


