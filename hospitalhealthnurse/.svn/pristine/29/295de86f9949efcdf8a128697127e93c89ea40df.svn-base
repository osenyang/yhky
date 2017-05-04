package com.elink.hospitalhealthnurse.modules.serviceorg.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Department;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Quarters;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.DepartmentService;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.QuartersService;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.ServiceUserService;
import com.elink.hospitalhealthnurse.modules.serviceorg.vo.ServiceUserVO;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;

/**
 * 服务人员信息Controller
 * @author 颜福艳
 * @version 2016-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/serviceorg/serviceUser")
public class ServiceUserController extends BaseController {

	@Autowired
	private ServiceUserService serviceUserService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private QuartersService quartersService;
	@Autowired
	private SystemService systemService;
	
	@ModelAttribute
	public ServiceUser get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return serviceUserService.get(id);
		}else{
			return new ServiceUser();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ServiceUserVO serviceUser, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<ServiceUserVO> page = serviceUserService.find(new Page<ServiceUserVO>(request, response), serviceUser); 
    	model.addAttribute("page", page);
		return "modules/" + "serviceorg/serviceUserList";
	}
	
	@RequestMapping(value = "form")
	public String form(ServiceUser serviceUser, Model model) {
		if(StringUtils.isNotBlank(serviceUser.getDepartmentId())){
			Department department = departmentService.get(serviceUser.getDepartmentId());
			if(department != null){
				serviceUser.setDepartmentNm(department.getName());
			}
			Quarters quarters = quartersService.get(serviceUser.getQuartersId());
			if(quarters != null){
				serviceUser.setQuartersNm(quarters.getName());
			}
		}
        model.addAttribute("serviceUser", serviceUser);
		return "modules/" + "serviceorg/serviceUserForm";
	}

	@RequestMapping(value = "save")
	public String save(ServiceUser serviceUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, serviceUser)){
			return form(serviceUser, model);
		}
		serviceUserService.save(serviceUser);
		addMessage(redirectAttributes, "保存服务人员信息成功");
		return "redirect:"+Global.getAdminPath()+"/serviceorg/serviceUser/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		serviceUserService.delete(id);
		addMessage(redirectAttributes, "删除服务人员信息成功");
		return "redirect:"+Global.getAdminPath()+"/serviceorg/serviceUser/?repage";
	}
	
	@ResponseBody
	@RequestMapping("checkMobile")
	public String checkMobile(String oldMobile,String mobile) throws Exception {
		if(mobile != null && mobile.equals(oldMobile)) {
			return "true";
		}else {
			if (mobile != null) {
				Boolean result = serviceUserService.existsMobile(mobile);
				if(result){
					return "false";
				}else{
					return "true";
				}
			}
		}
		return "false";
	}
	
	@ResponseBody
	@RequestMapping("checkJobNumber")
	public String checkJobNumber(String oldJobNumber,String jobNumber) throws Exception {
		if(jobNumber != null && jobNumber.equals(oldJobNumber)) {
			return "true";
		}else {
			if (jobNumber != null) {
				Boolean result = serviceUserService.existsJobNumber(jobNumber);
				if(result){
					result = systemService.existsJobNumber(jobNumber);
					if(result){
						return "false";
					}else{
						return "true";
					}
				}else{
					return "true";
				}
			}else{
				return "true";
			}
		}
		
	}
	
	
}
