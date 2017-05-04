package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;


public class ItemVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String itemNm;//项目名称
	private String serviceNm;//服务项名称
	private String itemTime;//服务时间
	private String quartersNm;//执行人/岗位
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	public String getServiceNm() {
		return serviceNm;
	}
	public void setServiceNm(String serviceNm) {
		this.serviceNm = serviceNm;
	}
	public String getItemTime() {
		return itemTime;
	}
	public void setItemTime(String itemTime) {
		this.itemTime = itemTime;
	}
	public String getQuartersNm() {
		return quartersNm;
	}
	public void setQuartersNm(String quartersNm) {
		this.quartersNm = quartersNm;
	}
	
	
}


