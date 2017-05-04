package com.elink.hospitalhealthnurse.modules.statistics.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.common.utils.CookieUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.statistics.entity.LoveCensus;
import com.elink.hospitalhealthnurse.modules.statistics.vo.LoveCensusVO;
import com.elink.hospitalhealthnurse.modules.statistics.vo.LoveValueVO;
import com.elink.hospitalhealthnurse.modules.statistics.service.LoveCensusService;

/**
 * 喜爱统计Controller
 * @author 颜福艳
 * @version 2016-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/statistics/loveCensus")
public class LoveCensusController extends BaseController {

	@Autowired
	private LoveCensusService loveCensusService;
	
	@ModelAttribute
	public LoveCensus get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return loveCensusService.get(id);
		}else{
			return new LoveCensus();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(LoveCensusVO loveCensus, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<LoveCensusVO> page = loveCensusService.find(new Page<LoveCensusVO>(request, response), loveCensus); 
        model.addAttribute("page", page);
		return "modules/" + "statistics/loveCensusList";
	}
	
	/****
	 * 获取喜爱统计趋势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getLoveCensusAvgTrend")
	@ResponseBody
	public String getLoveCensusAvgTrend(String statType,String departmentId, HttpServletRequest request,HttpServletResponse response) {

		if(StringUtils.isNotBlank(statType)){
			CookieUtils.setCookie(response, "statType", statType);
		}else{
			statType = CookieUtils.getCookie(request, "statType");
		}		
		Page<LoveValueVO> page = new Page<LoveValueVO>(request, response);
		page.setFuncName("launchLoveChart");
		Map<String,Object[]>  returnCode = loveCensusService.getLoveCensusAvgStatValue(page,statType,departmentId);
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	
	
	/****
	 * 获取撤销喜爱统计趋势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getNotLoveCensusAvgTrend")
	@ResponseBody
	public String getNotLoveCensusAvgTrend(String statType,String departmentId, HttpServletRequest request,HttpServletResponse response) {

		if(StringUtils.isNotBlank(statType)){
			CookieUtils.setCookie(response, "statType", statType);
		}else{
			statType = CookieUtils.getCookie(request, "statType");
		}		
		Page<LoveValueVO> page = new Page<LoveValueVO>(request, response);
		page.setFuncName("launchNotLoveChart");
		Map<String,Object[]>  returnCode = loveCensusService.getNotLoveCensusAvgStatValue(page,statType,departmentId);
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	

	@RequestMapping(value = "form")
	public String form(LoveCensus loveCensus, Model model) {
		model.addAttribute("loveCensus", loveCensus);
		return "modules/" + "statistics/loveCensusForm";
	}

	@RequestMapping(value = "save")
	public String save(LoveCensus loveCensus, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, loveCensus)){
			return form(loveCensus, model);
		}
		loveCensusService.save(loveCensus);
		addMessage(redirectAttributes, "保存喜爱统计成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/loveCensus/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		loveCensusService.delete(id);
		addMessage(redirectAttributes, "删除喜爱统计成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/loveCensus/?repage";
	}

}
