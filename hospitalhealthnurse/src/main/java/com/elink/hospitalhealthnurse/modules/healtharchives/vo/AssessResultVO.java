package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;


/**
 * 评估结果
 * @author dk
 */
public class AssessResultVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeNm() {
		return typeNm;
	}
	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}
	
	public String getQuestId() {
		return questId;
	}
	public void setQuestId(String questId) {
		this.questId = questId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getGradeNm() {
		return gradeNm;
	}
	public void setGradeNm(String gradeNm) {
		this.gradeNm = gradeNm;
	}
	public String getQuestNm() {
		return questNm;
	}
	public void setQuestNm(String questNm) {
		this.questNm = questNm;
	}
	public String getFullNm() {
		return fullNm;
	}
	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
	public int getAge() {
		if(StringUtils.isNotBlank(birthDate)){		
			Date date = DateUtils.parseDate(birthDate);
			return DateUtils.getYearByBrithDate(date);
		}
		return age;		
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorNm() {
		return doctorNm;
	}
	public void setDoctorNm(String doctorNm) {
		this.doctorNm = doctorNm;
	}
	
	private String id;	//编号
	private String userId; //人员ID    
	private String typeId; //类型ID    
	private String typeNm; //类型名称  
	private String questId; //问卷ID   
	private double score; //分数    
	private String createDate; //创建时间    
	private String gradeNm; //评估结果
	private String questNm; //问卷名称	
	private String fullNm; 
	private String idCard;
	private String sex;
	private String birthDate;
	private int age;
	private String doctorId;//医生ID	
	private String doctorNm;//医生姓名
}


