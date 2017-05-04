package com.elink.hospitalhealthnurse.modules.serviceorg.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Department;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Quarters;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.DepartmentService;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.QuartersService;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.ServiceUserService;
import com.elink.hospitalhealthnurse.modules.serviceorg.vo.QuartersVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;

/**
 * 岗位管理Controller
 * @author 颜福艳
 * @version 2016-10-10
 */
@Controller
@RequestMapping(value = "${adminPath}/serviceorg/quarters")
public class QuartersController extends BaseController {

	@Autowired
	private QuartersService quartersService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ServiceUserService serviceUserService;
	
	@ModelAttribute
	public Quarters get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return quartersService.get(id);
		}else{
			return new Quarters();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(QuartersVO quarters, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<QuartersVO> page = quartersService.find(new Page<QuartersVO>(request, response), quarters); 
        model.addAttribute("page", page);
        model.addAttribute("quarters", quarters);
		return "modules/" + "serviceorg/quartersList";
	}

	@RequestMapping(value = "form")
	public String form(Quarters quarters, Model model) {
		if(StringUtils.isNotBlank(quarters.getDepartmentId())){
			Department department = departmentService.get(quarters.getDepartmentId());
			if(department != null){
				quarters.setDepartmentNm(department.getName());
			}
		}
		model.addAttribute("doctorQuarters", quarters);
		return "modules/" + "serviceorg/quartersForm";
	}

	@RequestMapping(value = "save")
	public String save(Quarters quarters, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, quarters)){
			return form(quarters, model);
		}
		quartersService.save(quarters);
		addMessage(redirectAttributes, "保存岗位成功");
		return "redirect:"+Global.getAdminPath()+"/serviceorg/quarters/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		List<ServiceUser> list = serviceUserService.findByQuarters(id);
		if(list != null && list.size() > 0){
			addMessage(redirectAttributes, "删除岗位失败，请先删除关联的服务人员");
		}else{
			quartersService.delete(id);
			addMessage(redirectAttributes, "删除岗位成功");
		}
		return "redirect:"+Global.getAdminPath()+"/serviceorg/quarters/?repage";
	}
	
	/**
	 * 构造岗位树结构
	 * @param response
	 * @return
	 */
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(String parentId,HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Quarters> list = quartersService.findList(parentId);
		for (int i=0; i<list.size(); i++){
			Quarters e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("name", e.getName());
			mapList.add(map);
		}
		return mapList;
	}
	
	@ResponseBody
	@RequestMapping("checkName")
	public String checkName(String oldName,String name,String oldDepartmentId,String departmentId) throws Exception {
		if(StringUtils.isNotBlank(name) && name.equals(oldName) && StringUtils.isNotBlank(departmentId) && departmentId.equals(oldDepartmentId)) {
			return "true";
		}else {
			if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(departmentId)) {
				Boolean result = quartersService.existsName(departmentId,name);
				if(result){
					return "false";
				}else{
					return "true";
				}
			}
		}
		return "false";
	}

}
