package com.elink.hospitalhealthnurse.modules.serviceorg.web;

import java.util.List;
import java.util.Map;

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
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Department;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.DepartmentService;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.QuartersService;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.ServiceUserService;
import com.elink.hospitalhealthnurse.modules.sys.entity.Office;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.service.OfficeService;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 科室管理Controller
 * @author 颜福艳
 * @version 2016-10-10
 */
@Controller
@RequestMapping(value = "${adminPath}/serviceorg/department")
public class DepartmentController extends BaseController {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private ServiceUserService serviceUserService;
	@Autowired
	private QuartersService quartersService;
	
	/**默认的根节点id*/
	private static String DEFAULT_ROOT_ID = "1"; 
	
	@ModelAttribute
	public Department get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return departmentService.get(id);
		}else{
			return new Department();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Department department, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		department.setId(DEFAULT_ROOT_ID);
		model.addAttribute("department", department);
		List<Department> list = Lists.newArrayList();
		List<Department> sourcelist = Lists.newArrayList();
		sourcelist = departmentService.findAllList();
		Department.sortList(list, sourcelist, department.getId());
		if(list != null && list.size() > 0){
			for(Department dep:list){
				Office office = officeService.get(dep.getOfficeId());
				dep.setOfficeNm(office.getName());
			}
		}
        model.addAttribute("list", list);
        return "modules/" + "serviceorg/departmentList";
	}

	@RequestMapping(value = "form")
	public String form(Department department, Model model) {
		if(department.getParent() != null && StringUtils.isNotBlank(department.getParent().getId())){
			Department temp = departmentService.get(department.getParent().getId());
			department.getParent().setName(temp.getName());
		}
		model.addAttribute("department", department);
		return "modules/" + "serviceorg/departmentForm";
	}

	@RequestMapping(value = "save")
	public String save(Department department, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, department)){
			return form(department, model);
		}
		
		//如果是顶级科室（department.getParentId() == null），需要将department.parentId树状列表才能正常显示
		if(department.getParent() == null || "".equals(department.getParent().getId()) ) {
			department.setParent(new Department(DEFAULT_ROOT_ID));
		}
		departmentService.save(department);
		addMessage(redirectAttributes, "保存科室成功");
		return "redirect:"+Global.getAdminPath()+"/serviceorg/department/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		
		List<Department> depList = departmentService.findChildDeptByWs(id);
		List<ServiceUser> list = serviceUserService.findByDepartment(id);
		if(depList != null && depList.size() > 0){
			addMessage(redirectAttributes, "删除科室失败，请先删除下级科室");
		}else if(list != null && list.size() > 0){
			addMessage(redirectAttributes, "删除科室失败，请先删除关联的服务人员");
		}else{
			//1.先删除下级科室
			departmentService.deleteByPId(id);
			departmentService.delete(id);
			//删除科室同时删除科室下的岗位
			quartersService.deleteByDepartmentId(id);
			addMessage(redirectAttributes, "删除科室成功");
		}
		return "redirect:"+Global.getAdminPath()+"/serviceorg/department/?repage";
	}
	@ResponseBody
	@RequestMapping(value = "departmentData")
	public List<Map<String,Object>> departmentData(String parentId) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		User user = UserUtils.getUser();
		List<Department> list = departmentService.findByParentId(user.getOffice().getId(),parentId);
		for (int i=0; i<list.size(); i++){
			Department department = list.get(i);
			
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", department.getId());
			//department.getParentId() == 1时表示这个department是根节点，所以pId设置为0，子节点则将pId设置为父节点的ID
			map.put("pId", department.getParent() == null ? "0" : department.getParent().getId());
			map.put("name", department.getName());
			mapList.add(map);
		}
		return mapList;
	}
	
	@ResponseBody
	@RequestMapping(value = "departmentDataByOfficeId")
	public List<Map<String,Object>> departmentDataByOfficeId(String parentId) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Department> list = departmentService.findByOfficeId(parentId);
		for (int i=0; i<list.size(); i++){
			Department department = list.get(i);
			
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", department.getId());
			//department.getParentId() == 1时表示这个department是根节点，所以pId设置为0，子节点则将pId设置为父节点的ID
			map.put("pId", department.getParent() == null ? "0" : department.getParent().getId());
			map.put("name", department.getName());
			mapList.add(map);
		}
		return mapList;
	}
	
	@ResponseBody
	@RequestMapping("checkName")
	public String checkName(String oldName,String name,String oldParentId,String parentId) throws Exception {
		if(StringUtils.isNotBlank(name) && name.equals(oldName) && parentId.equals(oldParentId)){
			return "true";
		}else {
			if (StringUtils.isNotBlank(name)) {
				if(StringUtils.isNotBlank(oldParentId)){//修改
					if(!name.equals(oldName) && parentId.equals(oldParentId)){
						Boolean result = departmentService.existsParentIdByName(oldParentId,name);
						if(result){
							return "false";
						}else{
							return "true";
						}
					}else{
						Boolean result = departmentService.existsParentIdByName(parentId,name);
						if(result){
							return "false";
						}else{
							return "true";
						}
					}
				}else{//新增
					if(StringUtils.isNotBlank(parentId)){
						Boolean result = departmentService.existsParentIdByName(parentId,name);
						if(result){
							return "false";
						}else{
							return "true";
						}
					}else{
						Boolean result = departmentService.existsName(name);
						if(result){
							return "false";
						}else{
							return "true";
						}
					}
				}
			}
		}
		return "false";
	}
	
}
