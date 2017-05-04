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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Social;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.SocialService;

/**
 * 社工计划Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/social")
public class SocialController extends BaseController {

	@Autowired
	private SocialService socialService;
	
	@ModelAttribute
	public Social get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return socialService.get(id);
		}else{
			return new Social();
		}
	}
	
	@RequiresPermissions("healtharchives:social:view")
	@RequestMapping(value = {"list", ""})
	public String list(Social social, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Social> page = socialService.find(new Page<Social>(request, response), social); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/socialList";
	}

	@RequiresPermissions("healtharchives:social:view")
	@RequestMapping(value = "form")
	public String form(Social social, Model model) {
		model.addAttribute("social", social);
		return "modules/" + "healtharchives/socialForm";
	}

	@RequiresPermissions("healtharchives:social:edit")
	@RequestMapping(value = "save")
	public String save(Social social, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, social)){
			return form(social, model);
		}
		socialService.save(social);
		addMessage(redirectAttributes, "保存社工计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/social/?repage";
	}
	
	@RequiresPermissions("healtharchives:social:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		socialService.delete(id);
		addMessage(redirectAttributes, "删除社工计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/social/?repage";
	}

}
