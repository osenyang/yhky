package com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;


/**
 * 
 * Title: 康复计划
 * Description:
 * @createTime: 2017年4月26日 - 下午3:05:12
 * @Company: Elink
 * @author: 杨鉴浩
 * @version: 1.0
 */
@Entity
@Table(name="plan_recovery")
public class RecoveryPlan extends BasePlan {

	private static final long serialVersionUID = 2521492444022682265L;
	/**
	 * 
	 */
	
	/** 病史摘要和主要功能障碍 */
	private String digest;
	/** 病种 */
	private List<Disease> diseaseList;
	/** 自定义病种 */
	private String diseaseCustom;
	/** 主要功能障碍 */
	private List<Dysfunction> dysfunctionList;
	
	/** 康复近期目标 */
	private String recentGoal;
	/** 康复远期目标 */
	private String longGoal;
	
	//康复评定
	private List<Evaluate> evaluates;
	//康复计划
	private List<EvaluatePlan> evaluatePlans;

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	@ManyToMany
	@OrderBy(clause = "name asc")
	public List<Disease> getDiseaseList() {
		return diseaseList;
	}

	public void setDiseaseList(List<Disease> diseaseList) {
		this.diseaseList = diseaseList;
	}

	public String getDiseaseCustom() {
		return diseaseCustom;
	}

	public void setDiseaseCustom(String diseaseCustom) {
		this.diseaseCustom = diseaseCustom;
	}

	@ManyToMany
	@OrderBy(clause = "name asc")
	public List<Dysfunction> getDysfunctionList() {
		return dysfunctionList;
	}

	public void setDysfunctionList(List<Dysfunction> dysfunctionList) {
		this.dysfunctionList = dysfunctionList;
	}

	public String getRecentGoal() {
		return recentGoal;
	}

	public void setRecentGoal(String recentGoal) {
		this.recentGoal = recentGoal;
	}

	public String getLongGoal() {
		return longGoal;
	}

	public void setLongGoal(String longGoal) {
		this.longGoal = longGoal;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="recovery_plan_id")
	@OrderBy(clause = "type asc")
	public List<Evaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="recovery_plan_id")
	@OrderBy(clause = "type asc")
	public List<EvaluatePlan> getEvaluatePlans() {
		return evaluatePlans;
	}

	public void setEvaluatePlans(List<EvaluatePlan> evaluatePlans) {
		this.evaluatePlans = evaluatePlans;
	}

}
