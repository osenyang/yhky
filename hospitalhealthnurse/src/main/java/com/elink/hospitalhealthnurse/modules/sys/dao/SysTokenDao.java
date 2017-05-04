package com.elink.hospitalhealthnurse.modules.sys.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.elink.hospitalhealthnurse.common.persistence.BaseDao;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;
import com.elink.hospitalhealthnurse.modules.sys.entity.SysToken;

/**
 * 登录用户Token生成
 * @author 刘灵星
 * @version 2013-8-23
 */
@Repository
public class SysTokenDao extends BaseDao<SysToken> {

	
	/***
	 * 判断是否存在tokenId
	 * @param tokenId
	 * @return
	 */
	public boolean isExistsToken(String tokenId){
		boolean result = true;
		SysToken sysToken = getByHql("from SysToken where tokenId = :p1 ", new Parameter(tokenId));
		if(sysToken != null && StringUtils.isNotBlank(sysToken.getId())){
			result = false;
		}
		return result;
	}
}
