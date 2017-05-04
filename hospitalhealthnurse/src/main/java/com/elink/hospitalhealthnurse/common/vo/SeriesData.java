package com.elink.hospitalhealthnurse.common.vo;

import java.io.Serializable;

/****
 * Y轴数据
 * @author 刘灵星
 *
 */
public class SeriesData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public SeriesData(){
		
	}
	/***
	 * 
	 * @param value
	 * @param remark
	 */
	public SeriesData(double value,String remark){
		this.value = value;
		this.remark = remark;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private double value;
	
	private  String remark;
}
