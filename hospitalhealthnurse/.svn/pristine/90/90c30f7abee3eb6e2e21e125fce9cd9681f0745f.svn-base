package com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;

/**
 * 基础的计划entity 父类
 * Title: com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.BasePlan
 * Description:
 * @createTime: 2017年4月25日 - 上午10:28:23
 * @Company: Elink
 * @author: 杨鉴浩
 * @version: 1.0
 */
@MappedSuperclass
public abstract class BasePlan implements Serializable{

	private static final long serialVersionUID = 2320933573812228053L;
	/**
	 * 
	 */
	
	private String id;
	
	/** 提供服务的人员，医生什么的 */
	private ServiceUser serviceUser;
	
	private java.util.Date startTime; //计划开始时间    
	   
	private java.util.Date endTime; //计划结束时间    
	
	/** 诊断（临床诊断） */
	private String diagnosis;
	
	/** 注意事项 */
	private String notice;
	

	
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="s_user_id")
	public ServiceUser getServiceUser() {
		return serviceUser;
	}

	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceUser = serviceUser;
	}

	public java.util.Date getStartTime() {
		return startTime;
	}

	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	
	
}
