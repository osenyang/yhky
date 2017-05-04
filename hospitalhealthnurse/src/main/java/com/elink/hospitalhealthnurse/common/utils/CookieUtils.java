/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;

/**
 * Cookie工具类
 * @author 刘灵星
 * @version 2013-01-15
 */
public class CookieUtils {

	/**
	 * 设置 Cookie（生成时间为1天）
	 * @param name 名称
	 * @param value 值
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 60*60*24);
	}
	
	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		String path = SpringContextHolder.getApplicationContext().getApplicationName();
		Cookie cookie = new Cookie(path+name, null);		
        if(StringUtils.isNotBlank(path)){
            cookie.setPath(path);
        }else{
            cookie.setPath("/");
        }
		cookie.setMaxAge(maxAge);
		try {
			cookie.setValue(URLEncoder.encode(value, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
	}
	
	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 */
	public static void setCookieObject(HttpServletResponse response, String name, 	Object value, int maxAge) {
		String path = SpringContextHolder.getApplicationContext().getApplicationName();
		Cookie cookie = new Cookie(path+name, null);		
        if(StringUtils.isNotBlank(path)){
            cookie.setPath(path);
        }else{
            cookie.setPath("/");
        }		 
		cookie.setMaxAge(maxAge);
		String jsonValue = JsonMapper.getInstance().toJsonWs(value);
		try {
			cookie.setValue(URLEncoder.encode(jsonValue, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
	}
	
	/**
	 * 设置 Cookie（生成时间为1天）
	 * @param name 名称
	 * @param value 值
	 */
	public static void setCookieObject(HttpServletResponse response, String name, Object value) {
		setCookieObject(response, name, value, 60*60*24);
	}
	
	
	/**
	 * 获得指定Cookie的值
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, null, name, false);
	}
	/**
	 * 获得指定Cookie的值，并删除。
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		return getCookie(request, response, name, true);
	}
	/**
	 * 获得指定Cookie的值
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param name 名字
	 * @param isRemove 是否移除
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
		String value = null;
		Cookie[] cookies = request.getCookies();		
		String cookiePath = SpringContextHolder.getApplicationContext().getApplicationName();
		String pathName =  cookiePath + name;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(pathName)) {
					//判断cookie路径是否是应用的路径，防止cookie重复时取取内容					
					try {
						value = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (isRemove) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return value;
	}
}
