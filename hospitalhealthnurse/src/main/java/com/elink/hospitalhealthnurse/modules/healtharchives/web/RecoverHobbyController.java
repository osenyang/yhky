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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.RecoverHobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.RecoverHobbyService;

/**
 * 社工计划--兴趣爱好关联表Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/recoverHobby")
public class RecoverHobbyController extends BaseController {

	@Autowired
	private RecoverHobbyService recoverHobbyService;
	
	@ModelAttribute
	public RecoverHobby get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return recoverHobbyService.get(id);
		}else{
			return new RecoverHobby();
		}
	}
	
	@RequiresPermissions("healtharchives:recoverHobby:view")
	@RequestMapping(value = {"list", ""})
	public String list(RecoverHobby recoverHobby, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<RecoverHobby> page = recoverHobbyService.find(new Page<RecoverHobby>(request, response), recoverHobby); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/recoverHobbyList";
	}

	@RequiresPermissions("healtharchives:recoverHobby:view")
	@RequestMapping(value = "form")
	public String form(RecoverHobby recoverHobby, Model model) {
		model.addAttribute("recoverHobby", recoverHobby);
		return "modules/" + "healtharchives/recoverHobbyForm";
	}

	@RequiresPermissions("healtharchives:recoverHobby:edit")
	@RequestMapping(value = "save")
	public String save(RecoverHobby recoverHobby, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, recoverHobby)){
			return form(recoverHobby, model);
		}
		recoverHobbyService.save(recoverHobby);
		addMessage(redirectAttributes, "保存社工计划--兴趣爱好关联表成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/recoverHobby/?repage";
	}
	
	@RequiresPermissions("healtharchives:recoverHobby:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		recoverHobbyService.delete(id);
		addMessage(redirectAttributes, "删除社工计划--兴趣爱好关联表成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/recoverHobby/?repage";
	}

}
