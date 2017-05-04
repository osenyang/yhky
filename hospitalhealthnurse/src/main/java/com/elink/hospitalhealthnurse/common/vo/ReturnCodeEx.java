package com.elink.hospitalhealthnurse.common.vo;

import java.util.List;
import java.util.Map;

public class  ReturnCodeEx<E> {
	
	public Map<String, Object> getHead() {
		return head;
	}

	public void setHead(Map<String, Object> head) {
		this.head = head;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	private Map<String,Object> head;
	
	private List<E> data;
}
