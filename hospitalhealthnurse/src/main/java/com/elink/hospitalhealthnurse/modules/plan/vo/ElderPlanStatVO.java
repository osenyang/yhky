package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;

/**
 * 老人计划统计VO
 * @author 王宴萍
 * @version 2016-10-11
 */
public class ElderPlanStatVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int total; //计划总数    
	private int unFinish; //未完成 数
	private int onTimeComp; //即时完成数 	
	private int delayComp; //延时完成数     	
	private String gatherDateStr;//采集日期	

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getUnFinish() {
		return unFinish;
	}
	public void setUnFinish(int unFinish) {
		this.unFinish = unFinish;
	}
	public int getOnTimeComp() {
		return onTimeComp;
	}
	public void setOnTimeComp(int onTimeComp) {
		this.onTimeComp = onTimeComp;
	}
	public int getDelayComp() {
		return delayComp;
	}
	public void setDelayComp(int delayComp) {
		this.delayComp = delayComp;
	}
	public String getGatherDateStr() {
		return gatherDateStr;
	}
	public void setGatherDateStr(String gatherDateStr) {
		this.gatherDateStr = gatherDateStr;
	}
	
	
}
