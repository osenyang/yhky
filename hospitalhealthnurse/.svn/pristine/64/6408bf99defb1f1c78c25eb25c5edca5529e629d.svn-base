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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.FrequencysVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.FrequencysService;

/**
 * 计划频次Controller
 * @author 杜康
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/frequencys")
public class FrequencysController extends BaseController {

	@Autowired
	private FrequencysService frequencysService;
	
	@ModelAttribute
	public Frequencys get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return frequencysService.get(id);
		}else{
			return new Frequencys();
		}
	}
	
	@RequiresPermissions("healtharchives:frequencys:view")
	@RequestMapping(value = {"list", ""})
	public String list(Frequencys frequencys, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Frequencys> page = frequencysService.find(new Page<Frequencys>(request, response), frequencys); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/frequencysList";
	}

	@RequiresPermissions("healtharchives:frequencys:view")
	@RequestMapping(value = "form")
	public String form(Frequencys frequencys, Model model) {
		model.addAttribute("frequencys", frequencys);
		return "modules/" + "healtharchives/frequencysForm";
	}

	@RequiresPermissions("healtharchives:frequencys:edit")
	@RequestMapping(value = "save")
	public String save(Frequencys frequencys, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, frequencys)){
			return form(frequencys, model);
		}
		frequencysService.save(frequencys);
		addMessage(redirectAttributes, "保存计划频次成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/frequencys/?repage";
	}
	
	@RequiresPermissions("healtharchives:frequencys:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		frequencysService.delete(id);
		addMessage(redirectAttributes, "删除计划频次成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/frequencys/?repage";
	}

}
