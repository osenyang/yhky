/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.modules.sys.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.elink.hospitalhealthnurse.common.utils.CacheUtils;
import com.elink.hospitalhealthnurse.common.utils.SpringContextHolder;
import com.elink.hospitalhealthnurse.common.vo.Code;
import com.elink.hospitalhealthnurse.modules.serviceorg.dao.QuartersDao;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Quarters;
import com.elink.hospitalhealthnurse.modules.sys.dao.DictDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.Dict;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 字典工具类
 * @author 刘灵星
 * @version 2013-5-29
 */
public class DictUtils {
	
	private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
	
	private static QuartersDao quartersDao = SpringContextHolder.getBean(QuartersDao.class);

	public static final String CACHE_DICT_MAP = "dictMap";
	
	public static final String CACHE_DICT_MAP_WS = "dictMapWl";
	
	/***
	 * 获取字典标签
	 * @param value
	 * @param type
	 * @param defaultValue
	 * @return
	 */
	public static String getDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}
	
	/***
	 * 
	 * @param value
	 * @param type
	 * @param defaultValue
	 * @return
	 */
	public static String getDictLabelArr(String value, String type, String defaultValue){
		String returnValue = "";
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			String[] dictValueArr = value.split(",");
			if(dictValueArr != null && dictValueArr.length > 0){
				for(String dictValue : dictValueArr ){
					for (Dict dict : getDictList(type)){
						if (type.equals(dict.getType()) && dictValue.equals(dict.getValue())){
							returnValue += ","+dict.getLabel();
						}
					}
				}		
			}	
		}
		if(StringUtils.isNotEmpty(returnValue)){
			return returnValue.substring(1);
		}
		return defaultValue;
	}

	/***
	 * 获取字典内容值
	 * @param label
	 * @param type
	 * @param defaultLabel
	 * @return
	 */
	public static String getDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}
	
	/****
	 * 获取字典列表
	 * @param type
	 * @return
	 */
	public static List<Code> getDictListByWs(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<Code>> dictMap = (Map<String, List<Code>>)CacheUtils.get(CACHE_DICT_MAP_WS);
		if (dictMap == null){
			dictMap = Maps.newHashMap();
			List<Dict>  list = dictDao.findAllList();
			//List<Code>  codeList = Lists.newArrayList();
			for (Dict dict : list ){
				List<Code> dictList = dictMap.get(dict.getType());
				if (dictList != null){
					dictList.add(new Code(dict.getValue(),dict.getLabel()));
				}else{
					dictMap.put(dict.getType(), Lists.newArrayList(new Code(dict.getValue(),dict.getLabel())));
				}
			}
			CacheUtils.put(CACHE_DICT_MAP_WS, dictMap);
		}
		
		List<Code> dictList = dictMap.get(type);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}
	
	/****
	 * 获取字典列表
	 * @param type
	 * @return
	 */	
	public static List<Dict> getDictList(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get(CACHE_DICT_MAP);
		if (dictMap == null){
			dictMap = Maps.newHashMap();
			List<Dict>  list = dictDao.findAllList();
			for (Dict dict : list ){
				List<Dict> dictList = dictMap.get(dict.getType());
				if (dictList != null){
					dictList.add(dict);
				}else{
					dictMap.put(dict.getType(), Lists.newArrayList(dict));
				}
			}
			CacheUtils.put(CACHE_DICT_MAP, dictMap);
		}
		
		List<Dict> dictList = dictMap.get(type);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}
	
	/***
	 * 根据ID查看姓名
	 * @param value
	 * @param type
	 * @param defaultValue
	 * @return
	 */
	public static String getQuartersName(String id,  String defaultValue){
		if (StringUtils.isNotBlank(id)){
			Quarters quarters = quartersDao.get(id);
			if(quarters != null && StringUtils.isNotBlank(quarters.getName())){
				return quarters.getName();
			}
		}
		return defaultValue;
	}
	
}
