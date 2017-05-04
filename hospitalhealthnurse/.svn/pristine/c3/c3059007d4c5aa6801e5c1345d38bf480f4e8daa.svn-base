package com.elink.hospitalhealthnurse.modules.sys.web.ws;

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
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.elink.hospitalhealthnurse.modules.sys.utils.AreaUtils;
import com.google.common.collect.Maps;

/****
 * 地区接口
 * @author elink
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/area")
public class WsAreaController {
	
	@Autowired
	private SystemService systemService;
	
	/***
	 * 获取省份
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getProvinceArea",method=RequestMethod.GET)
	@ResponseBody
	public String getProvinceArea(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Code> list = AreaUtils.getProvinceArea();
			ReturnCodeEx<Code> returnCode = new ReturnCodeEx<Code>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			returnCode.setHead(head);
			returnCode.setData(list);			
			return JsonMapper.getInstance().toJsonWs(returnCode);
		}catch(Exception ex){
			return systemService.getErrReturnCode(ex.getMessage());
		}
	}	
	
	/***
	 * 获取地市
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getCityArea",method=RequestMethod.GET)
	@ResponseBody
	public String getCityArea(HttpServletRequest request, HttpServletResponse response){
		try{
			String parentId = request.getParameter("provinceId");
			List<Code> list = AreaUtils.getChildArea(parentId);
			ReturnCodeEx<Code> returnCode = new ReturnCodeEx<Code>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			returnCode.setHead(head);
			returnCode.setData(list);			
			return JsonMapper.getInstance().toJsonWs(returnCode);
		}catch(Exception ex){
			return systemService.getErrReturnCode(ex.getMessage());
		}
	}
	
	/****
	 * 获取区县
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getDistrictArea",method=RequestMethod.GET)
	@ResponseBody
	public String getDistrictArea(HttpServletRequest request, HttpServletResponse response){
		try{
			String parentId = request.getParameter("cityId");
			List<Code> list = AreaUtils.getChildArea(parentId);
			ReturnCodeEx<Code> returnCode = new ReturnCodeEx<Code>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			returnCode.setHead(head);
			returnCode.setData(list);			
			return JsonMapper.getInstance().toJsonWs(returnCode);
		}catch(Exception ex){
			return systemService.getErrReturnCode(ex.getMessage());
		}
	}
}
