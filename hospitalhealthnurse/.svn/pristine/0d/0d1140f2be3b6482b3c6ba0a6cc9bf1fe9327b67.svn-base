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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Information;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.InformationVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InformationService;

/**
 * 消息中心Controller
 * @author 杜康
 * @version 2016-10-17
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/information")
public class InformationController extends BaseController {

	@Autowired
	private InformationService informationService;
	
	@ModelAttribute
	public Information get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return informationService.get(id);
		}else{
			return new Information();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Information information, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<InformationVO> page = informationService.find(new Page<InformationVO>(request, response), information); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/informationList";
	}

	

	@RequestMapping(value = "form")
	public String form(Information information, Model model) {
		InformationVO infor = informationService.findById(information.getId());
		model.addAttribute("information", infor);
		informationService.updateReadById(information.getId());
		return "modules/" + "healtharchives/informationForm";
	}

	@RequestMapping(value = "save")
	public String save(Information information, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, information)){
			return form(information, model);
		}
		information.setState(Information.INFOR_STATE_NORMAL);
		informationService.save(information);
		addMessage(redirectAttributes, "发送消息成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/information/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		informationService.delete(id);
		addMessage(redirectAttributes, "删除消息中心成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/information/?repage";
	}

}
