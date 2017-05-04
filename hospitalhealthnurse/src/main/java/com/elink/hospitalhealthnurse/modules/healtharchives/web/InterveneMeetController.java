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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.InterveneMeet;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneMeetService;

/**
 * 干预方案——应急计划关联表Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/interveneMeet")
public class InterveneMeetController extends BaseController {

	@Autowired
	private InterveneMeetService interveneMeetService;
	
	@ModelAttribute
	public InterveneMeet get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return interveneMeetService.get(id);
		}else{
			return new InterveneMeet();
		}
	}
	
	@RequiresPermissions("healtharchives:interveneMeet:view")
	@RequestMapping(value = {"list", ""})
	public String list(InterveneMeet interveneMeet, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<InterveneMeet> page = interveneMeetService.find(new Page<InterveneMeet>(request, response), interveneMeet); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/interveneMeetList";
	}

	@RequiresPermissions("healtharchives:interveneMeet:view")
	@RequestMapping(value = "form")
	public String form(InterveneMeet interveneMeet, Model model) {
		model.addAttribute("interveneMeet", interveneMeet);
		return "modules/" + "healtharchives/interveneMeetForm";
	}

	@RequiresPermissions("healtharchives:interveneMeet:edit")
	@RequestMapping(value = "save")
	public String save(InterveneMeet interveneMeet, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, interveneMeet)){
			return form(interveneMeet, model);
		}
		interveneMeetService.save(interveneMeet);
		addMessage(redirectAttributes, "保存干预方案——应急计划关联表成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/interveneMeet/?repage";
	}
	
	@RequiresPermissions("healtharchives:interveneMeet:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		interveneMeetService.delete(id);
		addMessage(redirectAttributes, "删除干预方案——应急计划关联表成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/interveneMeet/?repage";
	}

}
