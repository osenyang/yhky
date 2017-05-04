/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.common.persistence;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;

/**
 * Entity支持类
 * @author 刘灵星
 * @version 2013-01-15
 */
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 当前用户
	 */
	protected User currentUser;
	
	/**
	 * 当前实体分页对象
	 */
	protected Page<T> page;

	/**
	 * 自定义SQL（SQL标识，SQL内容）
	 */
	protected Map<String, String> sqlMap;

	/**
	 *从页面搜索还是从菜单搜索（用于非页面搜索时设置默认搜索条件）
	 */
	private boolean searchFromPage;

	/**
	 *用于搜索多个ID的时候设置搜索条件
	 */
	private String ids;
	
	@JsonIgnore
	@XmlTransient
	@Transient
	public User getCurrentUser() {
		if(currentUser == null){
			currentUser = UserUtils.getUser();
		}
		return currentUser;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	@JsonIgnore
	@XmlTransient
	@Transient
	public Page<T> getPage() {
		if (page == null){
			page = new Page<T>();
		}
		return page;
	}
	
	public Page<T> setPage(Page<T> page) {
		this.page = page;
		return page;
	}

	@JsonIgnore
	@XmlTransient
	@Transient
	public Map<String, String> getSqlMap() {
		if (sqlMap == null){
			sqlMap = Maps.newHashMap();
		}
		return sqlMap;
	}

	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	@Transient
	public boolean isSearchFromPage() {
		return searchFromPage;
	}

	@Transient
	public void setSearchFromPage(boolean searchFromPage) {
		this.searchFromPage = searchFromPage;
	}

	@Transient
	public String getIds() {
		return ids;
	}

	@Transient
	public void setIds(String ids) {
		this.ids = ids;
	}

	
	// 显示/隐藏
	public static final String SHOW = "1";
	public static final String HIDE = "0";
	
	// 是/否
	public static final String YES = "1";
	public static final String NO = "0";

	// 删除标记（0：正常；1：删除；2：审核；）
	public static final String FIELD_DEL_FLAG = "delFlag";
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";	
	
	// 处理标记（0：未处理；1：处理中；2：已处理；）
	public static final String FIELD_DEAL_STATE = "dealState";
	public static final String DEAL_STATE_NORMAL = "0";
	public static final String DEAL_STATE_DELETE = "1";
	public static final String DEAL_STATE_AUDIT = "2";
	
	// 1-未读/2-已读
	public static final String STATE_NO = "1";
	public static final String STATE_YES = "2";
	
	// 发布状态（0-待发布；1-已发布；2-已下线）
	public static final String STATE_WAIT = "0";
	public static final String STATE_ONLINE = "1";
	public static final String STATE_OFFLINE = "2";
	
	// 服务类型（1-个人；2-团队）
	public static final String SERVICE_TYPE_PERSONAL = "1";
	public static final String SERVICE_TYPE_TEAM = "2";
	
	// 初始化评价率（100好评率；0中|差评率）
	public static final String EVALUATION_GOOD = "100";
	public static final String EVALUATION_NO_GOOD = "0";
	
	// 服务状态（0-待服务；1-服务中；2-已服务；3-已取消）
	public static final String SERVICE_STATE_WAIT = "0";
	public static final String SERVICE_STATE_IN = "1";
	public static final String SERVICE_STATE_END = "2";
	public static final String SERVICE_STATE_CANCEL = "3";
	
	// 订单支付状态（0-未付款；1-已付款；2-已退款,3-已取消）
	public static final String PAY_STATE_NO =  "0";
	public static final String PAY_STATE_YES = "1";
	public static final String PAY_STATE_REFUND = "2";
	public static final String PAY_STATE_CANCEL = "3";
	
	// 执行状态（0-待执行;1-准时执行;2-延迟执行;3-已完成）
	public static final String EXECUTE_STATE_WAIT = "0";
	public static final String EXECUTE_STATE_ONTIME = "1";
	public static final String EXECUTE_STATE_DELAY = "2";
	
}
