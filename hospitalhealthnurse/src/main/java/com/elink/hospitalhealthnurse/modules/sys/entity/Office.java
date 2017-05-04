package com.elink.hospitalhealthnurse.modules.sys.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.utils.IdGen;
import com.google.common.collect.Lists;

/**
 * 医院管理Entity
 * @author 颜福艳
 * @version 2016-09-02
 */
@Entity
@Table(name = "sys_office")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Office extends BaseEntity<Office> {
	
	private static final long serialVersionUID = 1L;

	public Office() {
		super();
	}

	public Office(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	private String id;	//编号
   
	private String name; //医院名称    
   
	private String contacts; //联系人    
   
	private String mobile; //联系电话    
   
	private String fax; //传真    
   
	private String province; //省    
   
	private String city; //市    
   
	private String area; //区    
   
	private String address; //联系地址    
   
	private java.util.Date createDate; //创建日期    
   
	private String delFlag; //删除标记（0：正常1：删除2：审核）    
	
	private List<User> userList = Lists.newArrayList();   // 拥有用户列表

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}   
		
	public void setName(String  name){
		this.name = name.trim();
	}   
	
	public String getContacts(){
		return contacts;
	}   
		
	public void setContacts(String  contacts){
		this.contacts = contacts.trim();
	}   
	
	public String getMobile(){
		return mobile;
	}   
		
	public void setMobile(String  mobile){
		this.mobile = mobile;
	}   
	
	public String getFax(){
		return fax;
	}   
		
	public void setFax(String  fax){
		this.fax = fax;
	}   
	
	public String getProvince(){
		return province;
	}   
		
	public void setProvince(String  province){
		this.province = province;
	}   
	
	public String getCity(){
		return city;
	}   
		
	public void setCity(String  city){
		this.city = city;
	}   
	
	public String getArea(){
		return area;
	}   
		
	public void setArea(String  area){
		this.area = area;
	}   
	
	public String getAddress(){
		return address;
	}   
		
	public void setAddress(String  address){
		this.address = address.trim();
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public String getDelFlag(){
		return delFlag;
	}   
		
	public void setDelFlag(String  delFlag){
		this.delFlag = delFlag;
	}   
	
	@OneToMany(mappedBy = "office", fetch=FetchType.EAGER)
	@Where(clause="del_flag='"+DEL_FLAG_NORMAL+"' and user_type='"+Consts.USER_TYPE_COMMON+"'")
	@OrderBy(value="id") @Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}


