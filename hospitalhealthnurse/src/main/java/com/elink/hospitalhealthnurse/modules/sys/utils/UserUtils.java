/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.modules.sys.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.SpringContextHolder;
import com.elink.hospitalhealthnurse.modules.sys.dao.AreaDao;
import com.elink.hospitalhealthnurse.modules.sys.dao.MenuDao;
import com.elink.hospitalhealthnurse.modules.sys.dao.OfficeDao;
import com.elink.hospitalhealthnurse.modules.sys.dao.RoleDao;
import com.elink.hospitalhealthnurse.modules.sys.dao.UserDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.Area;
import com.elink.hospitalhealthnurse.modules.sys.entity.Menu;
import com.elink.hospitalhealthnurse.modules.sys.entity.Office;
import com.elink.hospitalhealthnurse.modules.sys.entity.Role;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.security.SystemAuthorizingRealm.Principal;
//import com.elink.communitykanglehome.modules.team.dao.DoctorTypeDao;
import com.google.common.collect.Maps;

/**
 * 用户工具类
 * @author 刘灵星
 * @version 2013-5-29
 */
public class UserUtils extends BaseService {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);

	public static final String CACHE_USER = "user";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_AREA_JG_LIST = "areaJgList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	
	public static final String CACHE_USER_LIST = "userList";
	
	public static User getUser(){
		User user = (User)getCache(CACHE_USER);
		if (user == null){
			try{
				Subject subject = SecurityUtils.getSubject();
				Principal principal = (Principal)subject.getPrincipal();
				if (principal!=null){
					user = userDao.get(principal.getId());
//					Hibernate.initialize(user.getRoleList());
					putCache(CACHE_USER, user);
				}
			}catch (UnavailableSecurityManagerException e) {
				
			}catch (InvalidSessionException e){
				
			}
		}
		if (user == null){
			user = new User();
			try{
				SecurityUtils.getSubject().logout();
			}catch (UnavailableSecurityManagerException e) {
				
			}catch (InvalidSessionException e){
				
			}
		}
		return user;
	}
	
	public static User getUser(boolean isRefresh){
		if (isRefresh){
			removeCache(CACHE_USER);
		}
		return getUser();
	}

	public static List<Role> getRoleList(){
		@SuppressWarnings("unchecked")
		List<Role> list = (List<Role>)getCache(CACHE_ROLE_LIST);
		if (list == null){
//			User user = getUser();
			DetachedCriteria dc = roleDao.createDetachedCriteria();
			dc.createAlias("userList", "userList", JoinType.LEFT_OUTER_JOIN);
//			dc.add(dataScopeFilter(user, "office", "userList"));
			dc.add(Restrictions.eq(Role.FIELD_DEL_FLAG, Role.DEL_FLAG_NORMAL));
			dc.addOrder(Order.asc("createDate"));
			list = roleDao.find(dc);
			putCache(CACHE_ROLE_LIST, list);
		}
		return list;
	}
	
	public static List<Menu> getMenuList(){
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_LIST);
		if (menuList == null){
			User user = getUser();
			if (user.isAdmin()){
				menuList = menuDao.findAllList();
			}else{
				menuList = menuDao.findByUserId(user.getId());
			}
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}
	
	public static List<Area> getAreaList(){
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>)getCache(CACHE_AREA_LIST);
		if (areaList == null){
			User user = getUser();
			if (user.isAdmin()){
				areaList = areaDao.findAllList();
			}else{
				areaList = areaDao.findAllChild(user.getOffice().getArea(), "%,"+user.getOffice().getArea()+",%");
			}
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}
	
	public static List<Area> getAreaJgList(){
//		@SuppressWarnings("unchecked")
//		List<Area> areaList = (List<Area>)getCache(CACHE_AREA_JG_LIST);
		List<Area> areaList = new ArrayList<Area>();
//		if (areaList == null){
//			User user = getUser();
//			if (user.isAdmin()){
				areaList = areaDao.findJGList();
//			}else{
//				areaList = areaDao.findAllChild(user.getArea().getId(), "%,"+user.getArea().getId()+",%");
//			}
//			putCache(CACHE_AREA_JG_LIST, areaList);
//		}
		return areaList;
	}
	
	public static List<Office> getOfficeList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_LIST);
		if (officeList == null){
			User user = getUser();
			DetachedCriteria dc = officeDao.createDetachedCriteria();
			dc.add(dataScopeFilter(user, dc.getAlias(), ""));
			dc.add(Restrictions.eq(Office.FIELD_DEL_FLAG, Office.DEL_FLAG_NORMAL));
			dc.addOrder(Order.asc("createDate"));
			officeList = officeDao.find(dc);
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}
	
	@SuppressWarnings("unchecked")
	public static List<User> getUserList(){
		//User user = (User)getCache(CACHE_USER);
		List<User> userList = (List<User>) getCache(CACHE_USER_LIST);
		if (userList == null){
			User user = getUser();
			
			DetachedCriteria dc = userDao.createDetachedCriteria();
			dc.add(dataScopeFilter(user, dc.getAlias(), ""));
			dc.add(Restrictions.eq(User.FIELD_DEL_FLAG, User.DEL_FLAG_NORMAL));
			dc.addOrder(Order.asc("id"));
			
			userList = userDao.find(dc);
			
			putCache(CACHE_USER_LIST, userList);
		}
		return userList;
	}
	

	public static User getUserById(String id){
		if(StringUtils.isNotBlank(id)) {
			return userDao.get(id);
		} else {
			return null;
		}
	}
	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	/**
	 * 向已有的List缓冲添加内容
	 * @param listKey 列表Key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public static void addCache(String listKey,Object value) {
		List<Object> list = (List<Object>) getCache(listKey);
		list.add(value);
		getCacheMap().put(listKey, list);
	}
	
	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}
	
	public static Map<String, Object> getCacheMap(){
		Map<String, Object> map = Maps.newHashMap();
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			return principal!=null?principal.getCacheMap():map;
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return map;
	}
	
}