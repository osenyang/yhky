package com.elink.hospitalhealthnurse.modules.statistics.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.statistics.vo.MoodValueVO;
import com.elink.hospitalhealthnurse.modules.statistics.service.BaseDataService;

/**
 * 基础数据Controller
 * @author 颜福艳
 * @version 2016-10-19
 */
@Controller
@RequestMapping(value = "${adminPath}/statistics/baseData")
public class BaseDataController extends BaseController {

	@Autowired
	private BaseDataService baseDataService;
	
	@RequestMapping(value = {"list", ""})
	public String list(Model model) {
		return "modules/" + "statistics/baseDataList";
	}
	
	/****
	 * 获取老人性别趋势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getSexAvgTrend")
	@ResponseBody
	public String getSexAvgTrend(String statType,HttpServletRequest request,HttpServletResponse response) {
		Page<MoodValueVO> page = new Page<MoodValueVO>(request, response);
		page.setFuncName("launchSexChart");
		Map<String,int[]>  returnCode = baseDataService.getSexAvgStatValue();
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	
	
	/****
	 * 获取老人年龄趋势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getAgeAvgTrend")
	@ResponseBody
	public String getAgeAvgTrend(String statType,HttpServletRequest request,HttpServletResponse response) {
		Page<MoodValueVO> page = new Page<MoodValueVO>(request, response);
		page.setFuncName("launchAgeChart");
		Map<String,int[]>  returnCode = baseDataService.getAgeAvgStatValue();
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}
	
	/****
	 * 获取康复情况趋势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getRecureAvgTrend")
	@ResponseBody
	public String getRecureAvgTrend(String statType,HttpServletRequest request,HttpServletResponse response) {
		Page<MoodValueVO> page = new Page<MoodValueVO>(request, response);
		page.setFuncName("launchRecureChart");
		Map<String,int[]>  returnCode = baseDataService.getRecureAvgStatValue();
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	
	
	/****
	 * 获取计划类型趋势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getPlanAvgTrend")
	@ResponseBody
	public String getPlanAvgTrend(String statType,HttpServletRequest request,HttpServletResponse response) {
		Page<MoodValueVO> page = new Page<MoodValueVO>(request, response);
		page.setFuncName("launchPlanChart");
		Map<String,int[]>  returnCode = baseDataService.getPlanAvgStatValue();
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	

}
