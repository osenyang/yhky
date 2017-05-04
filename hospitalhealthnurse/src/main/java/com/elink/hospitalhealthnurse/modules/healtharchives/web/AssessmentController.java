package com.elink.hospitalhealthnurse.modules.healtharchives.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Assessment;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessmentService;

/**
 * 诊疗计划Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/assessment")
public class AssessmentController extends BaseController {

	@Autowired
	private AssessmentService assessmentService;
	
	@ModelAttribute
	public Assessment get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return assessmentService.get(id);
		}else{
			return new Assessment();
		}
	}
	
	@RequiresPermissions("healtharchives:assessment:view")
	@RequestMapping(value = {"list", ""})
	public String list(Assessment assessment, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Assessment> page = assessmentService.find(new Page<Assessment>(request, response), assessment); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/assessmentList";
	}

	@RequiresPermissions("healtharchives:assessment:view")
	@RequestMapping(value = "form")
	public String form(Assessment assessment, Model model) {
		model.addAttribute("assessment", assessment);
		return "modules/" + "healtharchives/assessmentForm";
	}

	@RequiresPermissions("healtharchives:assessment:edit")
	@RequestMapping(value = "save")
	public String save(Assessment assessment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, assessment)){
			return form(assessment, model);
		}
		assessmentService.save(assessment);
		addMessage(redirectAttributes, "保存诊疗计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/assessment/?repage";
	}
	
	@RequiresPermissions("healtharchives:assessment:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		assessmentService.delete(id);
		addMessage(redirectAttributes, "删除诊疗计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/assessment/?repage";
	}

}
