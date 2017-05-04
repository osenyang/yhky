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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Meet;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.MeetService;

/**
 * 应急计划Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/meet")
public class MeetController extends BaseController {

	@Autowired
	private MeetService meetService;
	
	@ModelAttribute
	public Meet get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return meetService.get(id);
		}else{
			return new Meet();
		}
	}
	
	@RequiresPermissions("healtharchives:meet:view")
	@RequestMapping(value = {"list", ""})
	public String list(Meet meet, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Meet> page = meetService.find(new Page<Meet>(request, response), meet); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/meetList";
	}

	@RequiresPermissions("healtharchives:meet:view")
	@RequestMapping(value = "form")
	public String form(Meet meet, Model model) {
		model.addAttribute("meet", meet);
		return "modules/" + "healtharchives/meetForm";
	}
	
	@RequestMapping(value = "formByInterveneId")
	public String formByInterveneId(Meet meet,String interveneId, Model model) {
		model.addAttribute("meet", meet);
		model.addAttribute("interveneId", interveneId);
		return "modules/" + "healtharchives/meetForm";
	}

	@RequiresPermissions("healtharchives:meet:edit")
	@RequestMapping(value = "save")
	public String save(Meet meet, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, meet)){
			return form(meet, model);
		}
		meetService.save(meet);
		addMessage(redirectAttributes, "保存应急计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/meet/?repage";
	}
	
	@RequiresPermissions("healtharchives:meet:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		meetService.delete(id);
		addMessage(redirectAttributes, "删除应急计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/meet/?repage";
	}

}
