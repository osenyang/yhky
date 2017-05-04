package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;
import java.util.Date;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;

/**
 * 老人计划VO
 * @author 王宴萍
 * @version 2016-10-11
 */
public class ElderPlanVO implements Serializable{
	private static final long serialVersionUID = 3930005789617368799L;
	private String id;	//编号
	private String bedNumber;//床号
	private String archivesId;//档案id
	private String elderName;//老人姓名
	private String state;// 老人状态
	private String inpatientNm;//所属病区
	private String hospitalizationNumber;//住院编号	
	
	private int completedCount;//完成数
	private int exeCount;//正在执行数
	private int totalCount;//总数
	private int expiredServiceCount;//过期未服务
	private int notExpiredCount;//过期未结束 
	private String sex;//年龄
	private String age;//年龄
	private String photo;//年龄
	private Date birthDate; //出生日期    
	
	private String departmentId;
	private String departmentNm;
	
	public ElderPlanVO() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}
	public String getElderName() {
		return elderName;
	}
	public void setElderName(String elderName) {
		this.elderName = elderName.trim();
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}


	public int getCompletedCount() {
		return completedCount;
	}

	public void setCompletedCount(int completedCount) {
		this.completedCount = completedCount;
	}

	public int getExeCount() {
		return exeCount;
	}

	public void setExeCount(int exeCount) {
		this.exeCount = exeCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getExpiredServiceCount() {
		return expiredServiceCount;
	}

	public void setExpiredServiceCount(int expiredServiceCount) {
		this.expiredServiceCount = expiredServiceCount;
	}

	public int getNotExpiredCount() {
		return notExpiredCount;
	}

	public void setNotExpiredCount(int notExpiredCount) {
		this.notExpiredCount = notExpiredCount;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getInpatientNm() {
		return inpatientNm;
	}

	public void setInpatientNm(String inpatientNm) {
		this.inpatientNm = inpatientNm;
	}

	public String getHospitalizationNumber() {
		return hospitalizationNumber;
	}

	public void setHospitalizationNumber(String hospitalizationNumber) {
		this.hospitalizationNumber = hospitalizationNumber;
	}
	
	
}
