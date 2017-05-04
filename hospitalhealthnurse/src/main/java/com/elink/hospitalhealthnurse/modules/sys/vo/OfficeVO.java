package com.elink.hospitalhealthnurse.modules.sys.vo;

import java.io.Serializable;

/**
 * 医院管理Entity
 * @author 颜福艳
 * @version 2016-09-02
 */
public class OfficeVO implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private String id;	//编号
	private String name; //医院名称    
	private String contacts; //联系人    
	private String mobile; //联系电话    
	private String fax; //传真    
	private String province; //省    
	private String city; //市    
	private String area; //区    
	private String areaNm;
	private String address; //联系地址    
	private java.util.Date createDate; //创建日期 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAreaNm() {
		return areaNm;
	}
	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}
	public String getAddress() {
		return areaNm+address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

}


