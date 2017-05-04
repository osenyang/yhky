package com.elink.hospitalhealthnurse.modules.sys.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sys_token")
@DynamicInsert @DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysToken  extends BaseEntity<SysToken> {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String tokenId;
	private Date newDate;
	private Date validityDate;
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	private String loginName;
	public SysToken(){
		super();
	}
	
	public SysToken(String id){
		this();
		this.id = id;
	}

	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
	}	
	
	@Id
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTokenId() {
		return tokenId;
	}
	
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNewDate() {
		return newDate;
	}
	
	public void setNewDate(Date loginDate) {
		this.newDate = loginDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getValidityDate() {
		return validityDate;
	}
	
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}
}
