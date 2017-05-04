/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.modules.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.elink.hospitalhealthnurse.common.persistence.BaseDao;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;
import com.elink.hospitalhealthnurse.modules.sys.entity.Dict;

/**
 * 字典DAO接口
 * @author 刘灵星
 * @version 2013-8-23
 */
@Repository
public class DictDao extends BaseDao<Dict> {

	public List<Dict> findAllList(){
		return find("from Dict where delFlag=:p1 order by sort", new Parameter(Dict.DEL_FLAG_NORMAL));
	}

	public List<String> findTypeList(){
		return find("select type from Dict where delFlag=:p1 group by type", new Parameter(Dict.DEL_FLAG_NORMAL));
	}
	
	public List<Dict> findTypeDictList(){
		return find(" from Dict where delFlag=:p1 group by type", new Parameter(Dict.DEL_FLAG_NORMAL));
	}
	
	public Dict findTypeInList(String types){
		String sql = "select * from sys_dict where del_flag = :p1 and type = 'nurse_range'  and value = :p2 ";
		return (Dict) findBySqlExt(sql, new Parameter(Dict.DEL_FLAG_NORMAL, types), Dict.class).get(0);
	}
	
	public List<Dict> findByType(String types){
		String sql = " from Dict where delFlag = :p1 and type = :p2 ";
		return find(sql, new Parameter(Dict.DEL_FLAG_NORMAL, types));
	}
	
	 
}
