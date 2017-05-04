package com.elink.hospitalhealthnurse.modules.serviceorg.web.ws;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.vo.Code;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Department;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.DepartmentService;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 科室管理Controller
 * @author 颜福艳
 * @version 2016-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/department")
public class WsDepartmentController extends BaseController {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private SystemService systemService;
	
	/**
	 * 根据医院获取所有科室信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getDepartmentList",method=RequestMethod.GET)
	@ResponseBody
	public String getDepartmentList(String userId,HttpServletRequest request, HttpServletResponse response){
		try {
			User user = systemService.getUser(userId);
			List<Department> list = departmentService.findByOfficeIdByWs(user.getOffice().getId());
			List<Code> codes = Lists.newArrayList();
			if(list !=  null && list.size() > 0){
				for(Department dept : list){
					List<Department>  childrens =   departmentService.findChildDeptByWs(dept.getId());
					Code code = new Code(dept.getId(),dept.getName());					
					if(childrens != null && childrens.size() > 0){
						List<Code> subCodes = Lists.newArrayList();
						for(Department childDept : childrens){
							subCodes.add(new Code(childDept.getId(),childDept.getName()));
						}
						code.setChildrens(subCodes);
					}
					codes.add(code);
				}
			}
			ReturnCodeEx<Code> returnCode = new ReturnCodeEx<Code>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");
			returnCode.setHead(head);
			returnCode.setData(codes);
			return JsonMapper.getInstance().toJsonWs(returnCode);
		} catch (Exception e) {
			return systemService.getErrReturnCode(e.getMessage());
		}
	}
	
	/**
	 * 根据医院获取科室信息
	 * @param request
	 * @param response
	 * @return
	 * @author 颜福艳
	 */
	@RequestMapping(value = "getChildDepartment",method=RequestMethod.GET)
	@ResponseBody
	public String getChildDepartment(String parentId,HttpServletRequest request, HttpServletResponse response){
		try {
			List<Department> list = departmentService.findChildDeptByWs(parentId);
			ReturnCodeEx<Department> returnCodeEx = new ReturnCodeEx<Department>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");
			returnCodeEx.setHead(head);
			returnCodeEx.setData(list);
			return JsonMapper.getInstance().toJsonWs(returnCodeEx);
		} catch (Exception e) {
			return systemService.getErrReturnCode(e.getMessage());
		}
	}
	
}
