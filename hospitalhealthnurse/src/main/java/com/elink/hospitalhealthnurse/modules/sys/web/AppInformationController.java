package com.elink.hospitalhealthnurse.modules.sys.web;

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
import com.elink.hospitalhealthnurse.modules.sys.entity.AppInformation;
import com.elink.hospitalhealthnurse.modules.sys.vo.AppInformationVO;
import com.elink.hospitalhealthnurse.modules.sys.service.AppInformationService;

/**
 * app版本管理Controller
 * @author 杜康
 * @version 2017-03-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/appInformation")
public class AppInformationController extends BaseController {

	@Autowired
	private AppInformationService appInformationService;
	
	@ModelAttribute
	public AppInformation get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return appInformationService.get(id);
		}else{
			return new AppInformation();
		}
	}
	
	@RequiresPermissions("sys:appInformation:view")
	@RequestMapping(value = {"list", ""})
	public String list(AppInformation appInformation, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<AppInformation> page = appInformationService.find(new Page<AppInformation>(request, response), appInformation); 
        model.addAttribute("page", page);
		return "modules/" + "sys/appInformationList";
	}

	@RequiresPermissions("sys:appInformation:view")
	@RequestMapping(value = "form")
	public String form(AppInformation appInformation, Model model) {
		model.addAttribute("appInformation", appInformation);
		return "modules/" + "sys/appInformationForm";
	}

	@RequiresPermissions("sys:appInformation:edit")
	@RequestMapping(value = "save")
	public String save(AppInformation appInformation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, appInformation)){
			return form(appInformation, model);
		}
		appInformationService.save(appInformation);
		addMessage(redirectAttributes, "保存app版本管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/appInformation/?repage";
	}
	
	@RequiresPermissions("sys:appInformation:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		appInformationService.delete(id);
		addMessage(redirectAttributes, "删除app版本管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/appInformation/?repage";
	}

}
