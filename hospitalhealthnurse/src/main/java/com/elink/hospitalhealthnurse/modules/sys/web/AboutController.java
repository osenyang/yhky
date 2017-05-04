package com.elink.hospitalhealthnurse.modules.sys.web;

import java.util.List;

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
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.sys.entity.About;
import com.elink.hospitalhealthnurse.modules.sys.service.AboutService;

/**
 * 关于我们Controller
 * @author 周贤舟
 * @version 2015-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/about")
public class AboutController extends BaseController {

	@Autowired
	private AboutService aboutService;
	
	@ModelAttribute
	public About get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return aboutService.get(id);
		}else{
			return new About();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(About about, HttpServletRequest request, HttpServletResponse response, Model model) {
        List<About> list = aboutService.find(about); 
        model.addAttribute("list", list);
		return "modules/" + "sys/aboutList";
	}

	@RequiresPermissions("sys:about:view")
	@RequestMapping(value = "form")
	public String form(About about, Model model) {
		model.addAttribute("about", about);
		return "modules/" + "sys/aboutForm";
	}

	@RequiresPermissions("sys:about:edit")
	@RequestMapping(value = "save")
	public String save(About about, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, about)){
			return form(about, model);
		}
		aboutService.save(about);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:"+Global.getAdminPath()+"/sys/about/?repage";
	}
	
	@RequiresPermissions("sys:about:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		aboutService.delete(id);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:"+Global.getAdminPath()+"/sys/about/?repage";
	}

}
