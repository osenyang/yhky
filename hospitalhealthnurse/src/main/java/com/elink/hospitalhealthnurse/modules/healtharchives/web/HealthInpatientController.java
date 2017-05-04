package com.elink.hospitalhealthnurse.modules.healtharchives.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthInpatient;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthInpatientService;

/**
 * 病区管理Controller
 * @author 杜康
 * @version 2017-03-27
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/healthInpatient")
public class HealthInpatientController extends BaseController {

	@Autowired
	private HealthInpatientService healthInpatientService;
	
	@ModelAttribute
	public HealthInpatient get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return healthInpatientService.get(id);
		}else{
			return new HealthInpatient();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(HealthInpatient healthInpatient, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<HealthInpatient> page = healthInpatientService.find(new Page<HealthInpatient>(request, response), healthInpatient); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/healthInpatientList";
	}

	@RequestMapping(value = "form")
	public String form(HealthInpatient healthInpatient, Model model) {
		model.addAttribute("healthInpatient", healthInpatient);
		return "modules/" + "healtharchives/healthInpatientForm";
	}

	@RequestMapping(value = "save")
	public String save(HealthInpatient healthInpatient, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, healthInpatient)){
			return form(healthInpatient, model);
		}
		healthInpatientService.save(healthInpatient);
		addMessage(redirectAttributes, "保存病区管理成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthInpatient/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		healthInpatientService.delete(id);
		addMessage(redirectAttributes, "删除病区管理成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthInpatient/?repage";
	}

}
