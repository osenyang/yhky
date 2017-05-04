package com.elink.hospitalhealthnurse.modules.healtharchives.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Hobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HobbyService;

/**
 * 兴趣爱好Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/hobby")
public class HobbyController extends BaseController {

	@Autowired
	private HobbyService hobbyService;
	
	@ModelAttribute
	public Hobby get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return hobbyService.get(id);
		}else{
			return new Hobby();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Hobby hobby, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Hobby> page = hobbyService.find(new Page<Hobby>(request, response), hobby); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/hobbyList";
	}

	@RequestMapping(value = "form")
	public String form(Hobby hobby,String interveneId, Model model) {
		model.addAttribute("hobby", hobby);
		model.addAttribute("interveneId", interveneId);
		return "modules/" + "healtharchives/hobbyForm";
	}

	@RequestMapping(value = "save")
	public String save(Hobby hobby,String interveneId, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, hobby)){
			return form(hobby, interveneId, model);
		}
		hobbyService.save(hobby);
		addMessage(redirectAttributes, "保存兴趣爱好成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/hobby/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		hobbyService.delete(id);
		addMessage(redirectAttributes, "删除兴趣爱好成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/hobby/?repage";
	}

}
