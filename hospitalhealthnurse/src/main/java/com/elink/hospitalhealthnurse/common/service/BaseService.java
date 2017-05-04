/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.common.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.sys.entity.Office;
import com.elink.hospitalhealthnurse.modules.sys.entity.Role;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.google.common.collect.Lists;

/**
 * Service基类
 * @author 刘灵星
 * @version 2013-05-15
 */
public abstract class BaseService {
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 数据范围过滤
	 * @param user 当前用户对象，通过“UserUtils.getUser()”获取
	 * @param officeAlias 机构表别名，例如：dc.createAlias("office", "office");
	 * @param userAlias 用户表别名，传递空，忽略此参数
	 * @return 标准连接条件对象
	 */
	protected static Junction dataScopeFilter(User user, String officeAlias, String userAlias) {

		// 进行权限过滤，多个角色权限范围之间为或者关系。
		List<String> dataScope = Lists.newArrayList();
		Junction junction = Restrictions.disjunction();
		
		// 超级管理员，跳过权限过滤
		if (!user.isAdmin()){
			for (Role r : user.getRoleList()){
				if (!dataScope.contains(r.getDataScope()) && StringUtils.isNotBlank(officeAlias)){
					boolean isDataScopeAll = false;
					if (Role.DATA_SCOPE_ALL.equals(r.getDataScope())){//所有数据
						isDataScopeAll = true;
					}
					else if (Role.DATA_SCOPE_OFFICE.equals(r.getDataScope())){//机构数据
						junction.add(Restrictions.eq(officeAlias+".id", user.getOffice().getId()));
					}
					else if (Role.DATA_SCOPE_CUSTOM.equals(r.getDataScope())){//明细数据
						junction.add(Restrictions.in(officeAlias+".id", r.getOfficeIdList()));
					}
					else if (Role.DATA_SCOPE_SELF.equals(r.getDataScope())){//本人数据
						junction.add(Restrictions.eq("id", user.getId()));
					}
					if (!isDataScopeAll){
						if (StringUtils.isNotBlank(userAlias)){
							junction.add(Restrictions.eq(userAlias+".id", user.getId()));
						}else {
//							junction.add(Restrictions.isNull(officeAlias+".id"));
						}
					}else{
						// 如果包含全部权限，则去掉之前添加的所有条件，并跳出循环。
						junction = Restrictions.disjunction();
						break;
					}
					dataScope.add(r.getDataScope());
				}
			}
		}
		return junction;
	}
	
	

	/***
	 * 根据角色定义的数据权限进行过滤
	 * @param user 当前用户
	 * @param officeAlias   机构ID的查询别名,例 ：t.office_id
	 * @param userAlias     用户ID的查询别名,例 ： t.create_by
	 * @return
	 */
	protected static String dataScopeFilterBySQL(User user, String officeAlias,String userAlias) {
		// 进行权限过滤，多个角色权限范围之间为或者关系。
		List<String> dataScope = Lists.newArrayList();
		String filterSQL = "";		
		// 超级管理员，跳过权限过滤
		if (!user.isAdmin()){
			Office office = user.getOffice();
			for (Role r : user.getRoleList()){
				if (!dataScope.contains(r.getDataScope())){
					boolean isDataScopeAll = false;
					if (Role.DATA_SCOPE_ALL.equals(r.getDataScope())){
						isDataScopeAll = true;
					}else if (Role.DATA_SCOPE_OFFICE.equals(r.getDataScope())){
						if(StringUtils.isNotBlank(officeAlias)){
							filterSQL = " and " + officeAlias + " ='" + office.getId()+"'";
						}
					}else if (Role.DATA_SCOPE_SELF.equals(r.getDataScope())){
						if(StringUtils.isNotBlank(userAlias)){
							filterSQL = " and " + userAlias + " ='" + user.getId()+"'";
						}
					}else if (Role.DATA_SCOPE_CUSTOM.equals(r.getDataScope())){
						filterSQL = " and " + officeAlias + " in (" +StringUtils.getStrInFroList(r.getOfficeIdList())+")";
					}
					//else if (Role.DATA_SCOPE_SELF.equals(r.getDataScope())){
					if (isDataScopeAll){
							
					}				
					dataScope.add(r.getDataScope());
				}
			}
		}
		return filterSQL;
	}
	
	
	/**
	 * 数据范围过滤
	 * @param user 当前用户对象，通过“UserUtils.getUser()”获取
	 * @param officeAlias 机构表别名，例如：dc.createAlias("office", "office");
	 * @param userAlias 用户表别名，传递空，忽略此参数
	 * @return ql查询字符串
	 */
	protected static String dataScopeFilterString(User user, String officeAlias, String userAlias) {
		Junction junction = dataScopeFilter(user, officeAlias, userAlias);
		Iterator<Criterion> it = junction.conditions().iterator();
		StringBuilder ql = new StringBuilder();
		ql.append(" and (");
		if (it.hasNext()){
			ql.append(it.next());
		}
		//".parentIds like ", 
		String[] strField = {".type="}; // 需要给字段增加“单引号”的字段。
		while (it.hasNext()) {
			ql.append(" or (");
			String s = it.next().toString();
			for(String field : strField){
				s = s.replaceAll(field + "(\\w.*)", field + "'$1'");
			}
			ql.append(s).append(")");
		}
		ql.append(")");
		return ql.toString();
	}

	protected List<Long> getIdList(String ids) {
		List<Long> idList = Lists.newArrayList();
		if(StringUtils.isNotBlank(ids)) {
			ids = ids.trim().replace("　", ",").replace(" ", ",").replace("，", ",");
			String[] arrId = ids.split(",");
			for(String id:arrId) {
				if(id.matches("\\d*")) {
					idList.add(Long.valueOf(id));
				}
			}
		}
		return idList;
	}
}
