package com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Title: 康复计划 里面的计划明细
 * Description:
 * @createTime: 2017年4月26日 - 下午2:50:54
 * @Company: Elink
 * @author: 杨鉴浩
 * @version: 1.0
 */
@Entity
@Table(name="plan_evaluate_plan")
public class EvaluatePlan extends Evaluate {

	private static final long serialVersionUID = -6945745786333725713L;
	/**
	 * 
	 */
	/** 执行频次 */
	private String frequency;

	/** 科室外键id */
	private String divisionId;
	/** 岗位外键id */
	private String quartersId;

	/** 开始执行日期 */
	private String beginDate;
	/** 开始执行时间 */
	private String beginTime;

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

}
