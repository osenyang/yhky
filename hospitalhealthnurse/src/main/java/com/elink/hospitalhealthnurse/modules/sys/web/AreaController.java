/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.modules.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.sys.entity.Area;
import com.elink.hospitalhealthnurse.modules.sys.service.AreaService;
import com.elink.hospitalhealthnurse.modules.sys.vo.AreaVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 区域Controller
 * @author 刘灵星
 * @version 2013-5-15
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/area")
public class AreaController extends BaseController {

	@Autowired
	private AreaService areaService;
	
	@ModelAttribute("area")
	public Area get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return areaService.get(id);
		}else{
			return new Area();
		}
	}

	@RequiresPermissions("sys:area:view")
	@RequestMapping(value = {"list", ""})
	public String list(Area area, Model model) {
		area.setId("1");
		model.addAttribute("area", area);
		List<Area> list = Lists.newArrayList();
		List<Area> sourcelist = areaService.findAll();
		Area.sortList(list, sourcelist, area.getId());
        model.addAttribute("list", list);
		return "modules/sys/areaList";
	}

	@RequiresPermissions("sys:area:view")
	@RequestMapping(value = "form")
	public String form(Area area, Model model) {
		area.setParent(areaService.get(area.getParent().getId()));
		model.addAttribute("area", area);
		return "modules/sys/areaForm";
	}
	
	@RequiresPermissions("sys:area:edit")
	@RequestMapping(value = "save")
	public String save(Area area, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, area)){
			return form(area, model);
		}
		areaService.save(area);
		addMessage(redirectAttributes, "保存区域'" + area.getName() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/sys/area/";
	}
	
	@RequiresPermissions("sys:area:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		if (Area.isAdmin(id)){
			addMessage(redirectAttributes, "删除区域失败, 不允许删除顶级区域或编号为空");
		}else{
			areaService.delete(id);
			addMessage(redirectAttributes, "删除区域成功");
		}
		return "redirect:"+Global.getAdminPath()+"/sys/area/";
	}

	/**
	 * 构造地区树结构
	 * @param extId
	 * @param response
	 * @return
	 * @author 周贤舟 2015年5月19日
	 */
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findAll();
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			if (extId == null || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParent()!=null?e.getParent().getId():0);
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeDataJG")
	public List<Map<String, Object>> treeDataJG(@RequestParam(required=false) String extId, HttpServletResponse response){
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findJgAll();
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			if (extId == null || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParent()!=null?e.getParent().getId():0);
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	/**
	 * 获取下级地区
	 * @param parentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "areaList")
	public List<Map<String, Object>> areaList(String parentId, HttpServletResponse response){
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<AreaVO> areaList = areaService.findListByParentId(parentId);
		for (AreaVO areaVo : areaList) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", areaVo.getId());
			map.put("code", areaVo.getCode());
			map.put("name", areaVo.getName());
			mapList.add(map);
		}
		return mapList;
	}
}