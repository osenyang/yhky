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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HostoryPlan;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HostoryPlanVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HostoryPlanService;

/**
 * 历史方案Controller
 * @author 杜康
 * @version 2017-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/hostoryPlan")
public class HostoryPlanController extends BaseController {

	@Autowired
	private HostoryPlanService hostoryPlanService;
	
	@ModelAttribute
	public HostoryPlan get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return hostoryPlanService.get(id);
		}else{
			return new HostoryPlan();
		}
	}
	
	@RequiresPermissions("healtharchives:hostoryPlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(HostoryPlan hostoryPlan, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<HostoryPlan> page = hostoryPlanService.find(new Page<HostoryPlan>(request, response), hostoryPlan); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/hostoryPlanList";
	}

	@RequiresPermissions("healtharchives:hostoryPlan:view")
	@RequestMapping(value = "form")
	public String form(HostoryPlan hostoryPlan, Model model) {
		model.addAttribute("hostoryPlan", hostoryPlan);
		return "modules/" + "healtharchives/hostoryPlanForm";
	}

	@RequiresPermissions("healtharchives:hostoryPlan:edit")
	@RequestMapping(value = "save")
	public String save(HostoryPlan hostoryPlan, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, hostoryPlan)){
			return form(hostoryPlan, model);
		}
		hostoryPlanService.save(hostoryPlan);
		addMessage(redirectAttributes, "保存历史方案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/hostoryPlan/?repage";
	}
	
	@RequiresPermissions("healtharchives:hostoryPlan:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		hostoryPlanService.delete(id);
		addMessage(redirectAttributes, "删除历史方案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/hostoryPlan/?repage";
	}

}
