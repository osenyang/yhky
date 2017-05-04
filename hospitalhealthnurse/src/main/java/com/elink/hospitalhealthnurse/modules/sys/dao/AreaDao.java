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
import com.elink.hospitalhealthnurse.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author 刘灵星
 * @version 2013-8-23
 */
@Repository
public class AreaDao extends BaseDao<Area> {
	
	public List<Area> findByParentIdsLike(String parentIds){
		return find("from Area where parentIds like :p1", new Parameter(parentIds));
	}


	public List<Area> findAllList(){
		return find("from Area where delFlag=:p1 order by code", new Parameter(Area.DEL_FLAG_NORMAL));
	}
	
	public List<Area> findJGList(){
		return find("from Area where delFlag=:p1 and ( type=:p2 ) order by code", new Parameter(Area.DEL_FLAG_NORMAL,"2"));
	}
	
	public List<Area> findProvinceAreaList(){
		return find("from Area where delFlag=:p1 and ( type=:p2 ) order by code", new Parameter(Area.DEL_FLAG_NORMAL,"2"));
	}
	
	public List<Area> findAllChild(String parentId, String likeParentIds){
		return find("from Area where delFlag=:p1 and (id=:p2 or parent.id=:p2 or parentIds like :p3) order by code", 
				new Parameter(Area.DEL_FLAG_NORMAL, parentId, likeParentIds));
	}
	
	
}
