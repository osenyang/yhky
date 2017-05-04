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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.ExtraItems;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.ExtraItemsService;

/**
 * 额外项目Controller
 * @author 杜康
 * @version 2017-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/extraItems")
public class ExtraItemsController extends BaseController {

	@Autowired
	private ExtraItemsService extraItemsService;
	
	@ModelAttribute
	public ExtraItems get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return extraItemsService.get(id);
		}else{
			return new ExtraItems();
		}
	}
	
	@RequiresPermissions("healtharchives:extraItems:view")
	@RequestMapping(value = {"list", ""})
	public String list(ExtraItems extraItems, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<ExtraItems> page = extraItemsService.find(new Page<ExtraItems>(request, response), extraItems); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/extraItemsList";
	}

	@RequestMapping(value = "form")
	public String form(ExtraItems extraItems, Model model) {
		model.addAttribute("extraItems", extraItems);
		return "modules/" + "healtharchives/extraItemsForm";
	}

	@RequiresPermissions("healtharchives:extraItems:edit")
	@RequestMapping(value = "save")
	public String save(ExtraItems extraItems, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, extraItems)){
			return form(extraItems, model);
		}
		extraItemsService.save(extraItems);
		addMessage(redirectAttributes, "保存额外项目成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/extraItems/?repage";
	}
	
	@RequiresPermissions("healtharchives:extraItems:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		extraItemsService.delete(id);
		addMessage(redirectAttributes, "删除额外项目成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/extraItems/?repage";
	}
	
	/**
	 * 保存额外项目
	 * @author dk
	 * @data 2017-4-20
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveBean")
	@ResponseBody
	public String saveBean(ExtraItems extraItems, Model model, HttpServletRequest request) {
		String str;
		if(StringUtils.isNotBlank(extraItems.getId())){
			str = "修改项目成功";
		}else{
			str = "添加项目成功";
		}
		extraItemsService.save(extraItems);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", str);
		returnCode.put("extraItems", extraItems.toString());
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	@RequestMapping(value = "deleteById")
	@ResponseBody
	public String deleteById(String id, HttpServletRequest request) {
		extraItemsService.delete(id);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "删除项目成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
}
