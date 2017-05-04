package com.elink.hospitalhealthnurse.modules.serviceorg.web.ws;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimpleEx;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthArchivesService;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthArchivesVO;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.ServiceUserService;
import com.elink.hospitalhealthnurse.modules.serviceorg.vo.ServiceUserVO;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.google.common.collect.Maps;

/**
 * 服务人员信息Controller
 * @author 颜福艳
 * @version 2016-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/serviceUser")
public class WsServiceUserController extends BaseController {

	@Autowired
	private ServiceUserService serviceUserService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private HealthArchivesService healthArchivesService;
	
	/****
	 * 获取服务人员列表
	 * @param serviceUser
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getServiceUserList",method=RequestMethod.GET)
	@ResponseBody
	public String getServiceUserList(ServiceUserVO serviceUser,String userId, HttpServletRequest request, HttpServletResponse response){
		try{
			Page<ServiceUserVO> page = serviceUserService.Wsfind(new Page<ServiceUserVO>(request, response),userId, serviceUser);
			ReturnCodeEx<ServiceUserVO> returnCode = new ReturnCodeEx<ServiceUserVO>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			head.put("totalPage", page.getTotalPage());
			head.put("total", page.getCount());	
			head.put("pageSize", page.getPageSize());
			returnCode.setHead(head);
			returnCode.setData(page.getList());			
			return JsonMapper.getInstance().toJsonWs(returnCode);
		}catch(Exception ex){
			return systemService.getErrReturnCode(ex.getMessage());
		}
	}
	
	/****
	 * 获取服务过当前老人的服务人员列表
	 * @param serviceUser
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getServiceUserListByUserId",method=RequestMethod.GET)
	@ResponseBody
	public String getServiceUserListByUserId(String userId, HttpServletRequest request, HttpServletResponse response){
		try{
			HealthArchivesVO archives = healthArchivesService.getUserByUserId(userId);
			if(archives == null){
				return systemService.getErrReturnCode("当前用户没有档案资料");
			}
			Page<ServiceUserVO> page = serviceUserService.WsfindByUserId(new Page<ServiceUserVO>(request, response),userId,archives.getId());
			ReturnCodeEx<ServiceUserVO> returnCode = new ReturnCodeEx<ServiceUserVO>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			head.put("totalPage", page.getTotalPage());
			head.put("total", page.getCount());	
			head.put("pageSize", page.getPageSize());
			returnCode.setHead(head);
			returnCode.setData(page.getList());			
			return JsonMapper.getInstance().toJsonWs(returnCode);
		}catch(Exception ex){
			return systemService.getErrReturnCode(ex.getMessage());
		}
	}
	
	/***
	 * 获取服务人员详细
	 * @param serviceUser
	 * @param request
	 * @param response
	 * @return
	 * @throws RuntimeException
	 */
	@RequestMapping(value = "getServiceUserDetail",method=RequestMethod.GET)
	@ResponseBody
	public String getServiceUserDetail(String serviceUserId, HttpServletRequest request, HttpServletResponse response)throws RuntimeException{
		try{
			ServiceUserVO serviceUser = serviceUserService.getServiceUserDetail(serviceUserId);
			ReturnCodeSimpleEx returnCode = new ReturnCodeSimpleEx();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			Map<String, Object> data = Maps.newHashMap();
			data.put("serviceUser", serviceUser);
			returnCode.setHead(head);
			returnCode.setData(data);	
			return JsonMapper.getInstance().toJsonWs(returnCode);
		}catch(Exception ex){
			return systemService.getErrReturnCode(ex.getMessage());
		}
	}
}
