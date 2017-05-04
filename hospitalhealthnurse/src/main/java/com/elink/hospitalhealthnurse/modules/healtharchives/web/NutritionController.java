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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nutrition;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NutritionService;

/**
 * 营养计划Controller
 * @author 杜康
 * @version 2016-10-26
 */
//@Controller
//@RequestMapping(value = "${adminPath}/healtharchives/nutrition")
public class NutritionController extends BaseController {

	/*@Autowired
	private NutritionService nutritionService;
	
	@ModelAttribute
	public Nutrition get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return nutritionService.get(id);
		}else{
			return new Nutrition();
		}
	}
	
	@RequiresPermissions("healtharchives:nutrition:view")
	@RequestMapping(value = {"list", ""})
	public String list(Nutrition nutrition, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Nutrition> page = nutritionService.find(new Page<Nutrition>(request, response), nutrition); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/nutritionList";
	}

	@RequiresPermissions("healtharchives:nutrition:view")
	@RequestMapping(value = "form")
	public String form(Nutrition nutrition, Model model) {
		model.addAttribute("nutrition", nutrition);
		return "modules/" + "healtharchives/nutritionForm";
	}

	@RequiresPermissions("healtharchives:nutrition:edit")
	@RequestMapping(value = "save")
	public String save(Nutrition nutrition, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nutrition)){
			return form(nutrition, model);
		}
		nutritionService.save(nutrition);
		addMessage(redirectAttributes, "保存营养计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/nutrition/?repage";
	}
	
	@RequiresPermissions("healtharchives:nutrition:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		nutritionService.delete(id);
		addMessage(redirectAttributes, "删除营养计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/nutrition/?repage";
	}*/

}
