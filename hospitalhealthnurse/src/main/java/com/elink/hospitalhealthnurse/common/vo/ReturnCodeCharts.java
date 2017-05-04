package com.elink.hospitalhealthnurse.common.vo;

import java.util.Map;

public class ReturnCodeCharts {
	
	private Map<String,Object> head;
	
	private Highcharts data;
	
	public Map<String, Object> getHead() {
		return head;
	}

	public void setHead(Map<String, Object> head) {
		this.head = head;
	}

	public Highcharts getData() {
		return data;
	}

	public void setData(Highcharts data) {
		this.data = data;
	}
}
