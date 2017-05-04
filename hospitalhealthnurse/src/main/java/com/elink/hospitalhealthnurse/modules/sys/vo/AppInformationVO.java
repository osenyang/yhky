package com.elink.hospitalhealthnurse.modules.sys.vo;

import java.io.Serializable;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;


/**
 * APP信息VO
 * @Title AppInformationVO.java
 * @Package com.elink.hospitalhealthnurse.modules.sys.vo
 * @author 杜康
 * @date 2017-03-28
 * @update
 */
public class AppInformationVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7179173740530053118L;
	private String id;	//编号
	private String appName;//app名称
	private String appAddress;//app地址
	private String appVersion;//app版本
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppAddress() {
		if(StringUtils.isBlank(appAddress))
			return " ";
		return Global.getConfig(Consts.STATIC_FILE_SITE) + appAddress;
	}

	public void setAppAddress(String appAddress) {
		this.appAddress = appAddress;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
}
