package com.elink.hospitalhealthnurse.modules.sys.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 收获地址Entity
 * @author 周贤舟
 * @version 2015-06-12
 */
@Entity
@Table(name = "sys_user_address")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysUserAddress extends BaseEntity<SysUserAddress> {
	
	private static final long serialVersionUID = 1L;

	public SysUserAddress() {
		super();
	}

	public SysUserAddress(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
	}
	
	private String id;	//编号
	private String userId; //老人用户ID
	private String takeName; //收货人
	private String phone; //固定电话
	private String mobile; //手机号码
	private String province; //省级    
	private String city; //城市    
	private String area; //地区县区    
	private String address; //地址    
	private String coded; //邮政编码
	private java.util.Date createDate; //创建时间    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId(){
		return userId;
	}   
		
	public void setUserId(String  userId){
		this.userId = userId;
	}   
	
	
	public String getAddress(){
		return address;
	}   
		
	public void setAddress(String  address){
		this.address = address;
	}   
	
	public String getCoded(){
		return coded;
	}   
		
	public void setCoded(String  coded){
		this.coded = coded;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}

	public String getTakeName() {
		return takeName;
	}

	public void setTakeName(String takeName) {
		this.takeName = takeName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	
	
}


