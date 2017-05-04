package com.elink.hospitalhealthnurse.modules.healtharchives.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.AssessReport;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessReportService;

/**
 * 健康建议Controller
 * @author 杜康
 * @version 2017-04-12
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/assessReport")
public class AssessReportController extends BaseController {

	@Autowired
	private AssessReportService assessReportService;
	
	@ModelAttribute
	public AssessReport get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return assessReportService.get(id);
		}else{
			return new AssessReport();
		}
	}
	
	@RequiresPermissions("healtharchives:assessReport:view")
	@RequestMapping(value = {"list", ""})
	public String list(AssessReport assessReport, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<AssessReport> page = assessReportService.find(new Page<AssessReport>(request, response), assessReport); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/assessReportList";
	}

	@RequestMapping(value = "form")
	public String form(AssessReport assessReport, Model model) {
		model.addAttribute("assessReport", assessReport);
		return "modules/" + "healtharchives/assessReportForm";
	}

	@RequiresPermissions("healtharchives:assessReport:edit")
	@RequestMapping(value = "save")
	public String save(AssessReport assessReport, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, assessReport)){
			return form(assessReport, model);
		}
		assessReportService.save(assessReport);
		addMessage(redirectAttributes, "保存健康建议成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/assessReport/?repage";
	}
	
	@RequiresPermissions("healtharchives:assessReport:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		assessReportService.delete(id);
		addMessage(redirectAttributes, "删除健康建议成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/assessReport/?repage";
	}
	/**
	 * 添加健康建议
	 * @author dk
	 * @date 2017-4-13
	 * */
	@RequestMapping(value = "saveBean")
	@ResponseBody
	public String saveBean(AssessReport assessReport, HttpServletRequest request, HttpServletResponse response) {
		String str;
		if(StringUtils.isNotBlank(assessReport.getId())){
			str = "修改评估记录成功";
		}else{
			str = "添加评估记录成功";
		}
		assessReportService.save(assessReport);
		Map<String, Object> json = Maps.newHashMap();
		json.put("message", str);
		json.put("assessReport", assessReport.toString());
		return JsonMapper.getInstance().toJson(json);
	}
	/**
	 * 删除健康建议
	 * @author dk
	 * @date 2017-4-13
	 * */
	@RequestMapping(value = "deleteById")
	@ResponseBody
	public String deleteById(String id){
		assessReportService.delete(id);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "删除评估记录成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
}
