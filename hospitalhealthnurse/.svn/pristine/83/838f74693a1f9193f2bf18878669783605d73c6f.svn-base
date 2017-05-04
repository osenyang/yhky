package com.elink.hospitalhealthnurse.modules.sys.utils;

import java.util.List;

import com.elink.hospitalhealthnurse.common.utils.CacheUtils;
import com.elink.hospitalhealthnurse.common.utils.SpringContextHolder;
import com.elink.hospitalhealthnurse.common.vo.Code;
import com.elink.hospitalhealthnurse.modules.sys.dao.AreaDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.Area;
import com.google.common.collect.Lists;

/**
 * 区域工具类
 * @author 刘灵星
 * @version 2013-5-29
 */
public class AreaUtils {

	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	
	private static final String CACHE_AREA_PROVINCE_LIST = "CACHE_AREA_PROVINCE_LIST";
	
	private static final String CACHE_AREA_PREFIX= "CACHE_AREA_";
	
	/***
	 * 获取区域内容
	 * @param id
	 * @return
	 */
	public static String getAreaValue(String id){
		 Area area = areaDao.get(id);
		 if(area != null)
			 return area.getName();
		 return null;		 
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Code> getProvinceArea(){		
		List<Code> areaList = (List<Code>)CacheUtils.get(CACHE_AREA_PROVINCE_LIST);
		if (areaList == null){
			areaList = Lists.newArrayList();
			List<Area>	list  = areaDao.findJGList();
			for(Area area : list){
				areaList.add(new Code(area.getId(),area.getName()));
			}

			CacheUtils.put(CACHE_AREA_PROVINCE_LIST, areaList);
		}
		return areaList;		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Code> getChildArea(String parentId){
		List<Code> areaList = (List<Code>)CacheUtils.get(CACHE_AREA_PREFIX+parentId);
		if (areaList == null){
			areaList = Lists.newArrayList();
			Area areaTmpe  = areaDao.get(parentId);
			if(areaTmpe != null){
				List<Area> list = areaTmpe.getChildList();
				for(Area area : list){
					areaList.add(new Code(area.getId(),area.getName()));
				}
			}
			CacheUtils.put(CACHE_AREA_PREFIX+parentId, areaList);
		}
		return areaList;		
	}
	
}
