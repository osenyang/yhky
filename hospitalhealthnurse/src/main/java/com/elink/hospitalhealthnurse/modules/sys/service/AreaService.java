/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.sys.dao.AreaDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.Area;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.elink.hospitalhealthnurse.modules.sys.vo.AreaVO;

/**
 * 区域Service
 * @author 刘灵星
 * @version 2013-5-29
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends BaseService {

	@Autowired
	private AreaDao areaDao;
	
	public Area get(String id) {
		return areaDao.get(id);
	}
	
	public List<Area> findAll(){
		return UserUtils.getAreaList();
	}
	
	public List<Area> findJgAll(){
		return UserUtils.getAreaJgList();
	}
	
	public Area getAreaByNm(String areaNm) throws Exception {
		String str = "select id,code,name from sys_area where name = '"+areaNm+"'";
		return areaDao.findFirstBySQL(str, null, Area.class);
	}
	
	public List<Area> getAreaById(String province,String city,String area) {
		String str = "select id,name,code from sys_area where id in ('"+province+"','"+city+"','"+area+"') and del_flag =  '" + Area.DEL_FLAG_NORMAL + "'";
		return areaDao.findBySqlExt(str, null, Area.class);
	}
	
	@SuppressWarnings("rawtypes")
	public boolean isParent(String parentId) throws Exception{
		String str = "select * from sys_area where parent_id = '" +parentId+ "' and del_flag =  '" + Area.DEL_FLAG_NORMAL + "'"; 
		List list =  areaDao.findBySql(str);
		if(list.size() > 0 ){
			return false;
		}
		return true;
	}
	
	
	
	@Transactional(readOnly = false)
	public void save(Area area) {
		area.setParent(this.get(area.getParent().getId()));
		String oldParentIds = area.getParentIds(); // 获取修改前的parentIds，用于更新子节点的parentIds
		area.setParentIds(area.getParent().getParentIds()+area.getParent().getId()+",");
		areaDao.clear();
		areaDao.save(area);
		// 更新子节点 parentIds
		List<Area> list = areaDao.findByParentIdsLike("%,"+area.getId()+",%");
		for (Area e : list){
			e.setParentIds(e.getParentIds().replace(oldParentIds, area.getParentIds()));
		}
		areaDao.save(list);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		areaDao.deleteById(id, "%,"+id+",%");
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}

	/***
	 * 获取下级全部节点
	 * @param parentId
	 * @return
	 */
	public List<Area> findByPId(String parentId) {
		return areaDao.findByParentIdsLike(parentId);
	}
	
	/***
	 * 只获取下级节点，不需获取全部
	 * @param parentId
	 * @return
	 */
	public List<AreaVO> findListByParentId(String parentId) {
		String str = "select id,name,code,parent_id,type from sys_area where parent_id = '" +parentId+ "' and del_flag =  '" + Area.DEL_FLAG_NORMAL + "'"; 
		return areaDao.findBySqlExt(str, null, AreaVO.class);	
	}
	
	
}
