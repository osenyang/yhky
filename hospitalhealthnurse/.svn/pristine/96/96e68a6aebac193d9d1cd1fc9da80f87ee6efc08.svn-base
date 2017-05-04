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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthAssess;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthAssessService;

/**
 * 评估Controller
 * @author 杜康
 * @version 2017-04-12
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/healthAssess")
public class HealthAssessController extends BaseController {

	@Autowired
	private HealthAssessService healthAssessService;
	
	@ModelAttribute
	public HealthAssess get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return healthAssessService.get(id);
		}else{
			return new HealthAssess();
		}
	}
	
	@RequiresPermissions("healtharchives:healthAssess:view")
	@RequestMapping(value = {"list", ""})
	public String list(HealthAssess healthAssess, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<HealthAssess> page = healthAssessService.find(new Page<HealthAssess>(request, response), healthAssess); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/healthAssessList";
	}

	@RequestMapping(value = "form")
	public String form(HealthAssess healthAssess, Model model) {
		model.addAttribute("healthAssess", healthAssess);
		return "modules/" + "healtharchives/healthAssessForm";
	}

	@RequiresPermissions("healtharchives:healthAssess:edit")
	@RequestMapping(value = "save")
	public String save(HealthAssess healthAssess, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, healthAssess)){
			return form(healthAssess, model);
		}
		healthAssessService.save(healthAssess);
		addMessage(redirectAttributes, "保存评估成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthAssess/?repage";
	}
	
	@RequiresPermissions("healtharchives:healthAssess:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		healthAssessService.delete(id);
		addMessage(redirectAttributes, "删除评估成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthAssess/?repage";
	}
	/**
	 * 添加评估记录
	 * @author dk
	 * @date 2017-4-13
	 * */
	@RequestMapping(value = "saveBean")
	@ResponseBody
	public String saveBean(HealthAssess healthAssess, HttpServletRequest request, HttpServletResponse response) {
		String str;
		if(StringUtils.isNotBlank(healthAssess.getId())){
			str = "修改评估记录成功";
		}else{
			str = "添加评估记录成功";
		}
		healthAssessService.save(healthAssess);
		Map<String, Object> json = Maps.newHashMap();
		json.put("message", str);
		json.put("healthAssess", healthAssess.toString());
		return JsonMapper.getInstance().toJson(json);
	}
	/**
	 * 删除评估记录
	 * @author dk
	 * @date 2017-4-13
	 * */
	@RequestMapping(value = "deleteById")
	@ResponseBody
	public String deleteById(String id){
		healthAssessService.delete(id);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "删除评估记录成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
}
