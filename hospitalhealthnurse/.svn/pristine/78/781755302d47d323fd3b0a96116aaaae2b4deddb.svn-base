package com.elink.hospitalhealthnurse.modules.sys.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * app版本管理Entity
 * @author 杜康
 * @version 2017-03-28
 */
@Entity
@Table(name = "app_information")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AppInformation extends BaseEntity<AppInformation> {
	
	private static final long serialVersionUID = 1L;

	public AppInformation() {
		super();
	}

	public AppInformation(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
	}
	
	private String id;	//编号
   
	private String appName; //APP名称    
   
	private String appAddress; //APP地址    
   
	private String appVersion; //版本号    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getAppName(){
		return appName;
	}   
		
	public void setAppName(String  appName){
		this.appName = appName;
	}   
	
	public String getAppAddress(){
		return appAddress;
	}   
		
	public void setAppAddress(String  appAddress){
		this.appAddress = appAddress;
	}   
	
	public String getAppVersion(){
		return appVersion;
	}   
		
	public void setAppVersion(String  appVersion){
		this.appVersion = appVersion;
	}   
	
}


