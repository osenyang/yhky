package com.elink.easemob.server.common;

import com.elink.hospitalhealthnurse.common.config.Global;

/**
 * Constants
 * 
 * @author Lynch 2014-09-15
 *
 */
public interface Constants {

	// API_HTTP_SCHEMA
	public static String API_HTTP_SCHEMA = "https";
	// API_SERVER_HOST
	public static String API_SERVER_HOST = Global.getConfig("API_SERVER_HOST");
	// APPKEY
	public static String APPKEY = Global.getConfig("APPKEY");
	// APP_CLIENT_ID
	public static String APP_CLIENT_ID = Global.getConfig("APP_CLIENT_ID");
	// APP_CLIENT_SECRET
	public static String APP_CLIENT_SECRET = Global.getConfig("APP_CLIENT_SECRET");
	// DEFAULT_PASSWORD
	public static String DEFAULT_PASSWORD = "123456";
	//DEFAULT_SUCCESS
	public static String STATUS_CODE_SUCCESS = "200";
	//评估
	public static String API_HOSPITAL_HOST = Global.getConfig("API_HOSPITAL_HOST");
	
}