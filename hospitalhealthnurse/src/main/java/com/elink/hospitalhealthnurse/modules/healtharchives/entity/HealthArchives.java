package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

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
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 健康档案Entity
 * @author 杜康
 * @version 2016-10-11
 */
@Entity
@Table(name = "hn_health_archives")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HealthArchives extends BaseEntity<HealthArchives> {
	
	private static final long serialVersionUID = 1L;

	public static final String STATE_HOSPITAL = "1";//住院
	public static final String STATE_LEAVE_OUT = "2";//请假外出
	public static final String STATE_LEAVE_HOSPITAL = "3";//出院
	public static final String STATE_YANG = "4";//康养

	public HealthArchives() {
		super();
	}

	public HealthArchives(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.updateDate = new Date();
		this.delFlag = HealthArchives.DEL_FLAG_NORMAL;
	}
	
	@PreUpdate
	public void preUpdate(){
		this.updateDate = new Date();
	}
	
	private String id;	//编号
   
	private String photo; //头像    
   
	private String userId; //用户ID    
   
	private String fullNm; //姓名    
   
	private String sex; //性别    
   
	private String idCard; //身份证号    
   
	private java.util.Date birthDate; //出生日期    
   
	private int height; //身高    
   
	private String weight; //体重    
   
	private double calf; //小腿围    
   
	private String contact; //家属联系方式    
   
	private String occupation; //职业    
   
	private String state; //状态    
   
	private String degree; //文化程度    
   
	private String medicalType; //医保类型    
   
	private java.util.Date createDate; //创建日期    
   
	private String createBy; //创建者    
   
	private String updateBy; //更新者    
   
	private java.util.Date updateDate; //更新时间   
	
	private String delFlag;//删除标记
	
	private String hospitalizationNumber;//住院编号	
	
	private String bedNumber;//床号
	
	private String healthRisk;//风险
	
	private String inpatientId;//所属病区ID
	
	private String inpatientNm;//所属病区
	
	private String age;//年龄
	private String account;//账号
	private String password;//密码

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPhoto(){
		return photo;
	}   
		
	public void setPhoto(String  photo){
		this.photo = photo;
	}   
	
	public String getUserId(){
		return userId;
	}   
		
	public void setUserId(String  userId){
		this.userId = userId;
	}   
	
	public String getFullNm(){
		return fullNm;
	}   
		
	public void setFullNm(String  fullNm){
		this.fullNm = fullNm.trim();
	}   
	
	public String getSex(){
		return sex;
	}   
		
	public void setSex(String  sex){
		this.sex = sex;
	}   
	
	public String getIdCard(){
		return idCard;
	}   
		
	public void setIdCard(String  idCard){
		this.idCard = idCard.trim();
	}   
	
	public java.util.Date getBirthDate(){
		return birthDate;
	}   
		
	public void setBirthDate(java.util.Date  birthDate){
		this.birthDate = birthDate;
	}   
	
	public int getHeight(){
		return height;
	}   
		
	public void setHeight(int  height){
		this.height = height;
	}   
	
	public String getWeight(){
		return weight;
	}   
		
	public void setWeight(String  weight){
		this.weight = weight;
	}   
	
	public double getCalf(){
		return calf;
	}   
		
	public void setCalf(double  calf){
		this.calf = calf;
	}   
	
	public String getContact(){
		return contact;
	}   
		
	public void setContact(String  contact){
		this.contact = contact.trim();
	}   
	
	public String getOccupation(){
		return occupation;
	}   
		
	public void setOccupation(String  occupation){
		this.occupation = occupation;
	}   
	
	public String getState(){
		return state;
	}   
		
	public void setState(String  state){
		this.state = state;
	}   
	
	public String getDegree(){
		return degree;
	}   
		
	public void setDegree(String  degree){
		this.degree = degree;
	}   
	
	public String getMedicalType(){
		return medicalType;
	}   
		
	public void setMedicalType(String  medicalType){
		this.medicalType = medicalType;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public String getCreateBy(){
		return createBy;
	}   
		
	public void setCreateBy(String  createBy){
		this.createBy = createBy;
	}   
	
	public String getUpdateBy(){
		return updateBy;
	}   
		
	public void setUpdateBy(String  updateBy){
		this.updateBy = updateBy;
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
	
	public String getHospitalizationNumber() {
		return hospitalizationNumber;
	}

	public void setHospitalizationNumber(String hospitalizationNumber) {
		this.hospitalizationNumber = hospitalizationNumber;
	}

	@Transient
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
	@Transient
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	@Transient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getHealthRisk() {
		return healthRisk;
	}

	public void setHealthRisk(String healthRisk) {
		this.healthRisk = healthRisk;
	}

	public String getInpatientId() {
		return inpatientId;
	}

	public void setInpatientId(String inpatientId) {
		this.inpatientId = inpatientId;
	}
	@Transient
	public String getInpatientNm() {
		return inpatientNm;
	}

	public void setInpatientNm(String inpatientNm) {
		this.inpatientNm = inpatientNm;
	}
	
}


