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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Recover;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.RecoverService;

/**
 * 康复计划Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/recover")
public class RecoverController extends BaseController {

	@Autowired
	private RecoverService recoverService;
	
	@ModelAttribute
	public Recover get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return recoverService.get(id);
		}else{
			return new Recover();
		}
	}
	
	@RequiresPermissions("healtharchives:recover:view")
	@RequestMapping(value = {"list", ""})
	public String list(Recover recover, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Recover> page = recoverService.find(new Page<Recover>(request, response), recover); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/recoverList";
	}

	@RequiresPermissions("healtharchives:recover:view")
	@RequestMapping(value = "form")
	public String form(Recover recover, Model model) {
		model.addAttribute("recover", recover);
		return "modules/" + "healtharchives/recoverForm";
	}

	@RequiresPermissions("healtharchives:recover:edit")
	@RequestMapping(value = "save")
	public String save(Recover recover, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, recover)){
			return form(recover, model);
		}
		recoverService.save(recover);
		addMessage(redirectAttributes, "保存康复计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/recover/?repage";
	}
	
	@RequiresPermissions("healtharchives:recover:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		recoverService.delete(id);
		addMessage(redirectAttributes, "删除康复计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/recover/?repage";
	}

}
