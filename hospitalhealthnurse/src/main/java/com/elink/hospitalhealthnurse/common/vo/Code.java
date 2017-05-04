package com.elink.hospitalhealthnurse.common.vo;

import java.io.Serializable;
import java.util.List;

public class Code implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Code(String key,String value){
		this.key = key;
		this.value = value;
	}
	
	public Code(){
		
	}	

	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public List<Code> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Code> childrens) {
		this.childrens = childrens;
	}
	
	private String key;
	private String value;	
	private List<Code> childrens;

}
