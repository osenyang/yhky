package com.elink.hospitalhealthnurse.modules.sys.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 关于我们Entity
 * @author 周贤舟
 * @version 2015-08-11
 */
@Entity
@Table(name = "sys_about")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class About extends BaseEntity<About> {
	
	private static final long serialVersionUID = 1L;
	
	private String id;	//编号
	private String type; //类型 1:护工端 2:评估说明
	private String content; //关于我们
	private Date createDate; //创建时间

	public About() {
		super();
	}

	public About(String id){
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}


