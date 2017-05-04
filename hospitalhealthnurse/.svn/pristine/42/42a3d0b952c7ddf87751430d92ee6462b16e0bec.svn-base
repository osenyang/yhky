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
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimple;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.sys.service.OfficeService;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.elink.hospitalhealthnurse.modules.sys.vo.OfficeVO;
import com.google.common.collect.Maps;

/**
 * 医院管理Controller
 * @author 颜福艳
 * @version 2016-09-02
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/hospital")
public class WsOfficeController extends BaseController {

	@Autowired
	private OfficeService officeService;
	@Autowired
	private SystemService systemService;
	
	/**
	 * 获取所有医院信息
	 * @param request
	 * @param response
	 * @return
	 * @author 颜福艳
	 */
	@RequestMapping(value = "getHospitalList",method=RequestMethod.GET)
	@ResponseBody
	public String getHospitalList(HttpServletRequest request, HttpServletResponse response){
		try {
			List<OfficeVO> list = officeService.WsfindList();
			ReturnCodeEx<OfficeVO> returnCodeEx = new ReturnCodeEx<OfficeVO>();
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
	
	/**
	 * 获取医院详细信息
	 * @param request
	 * @param response
	 * @return
	 * @author 颜福艳
	 */
	@RequestMapping(value = "getHospital",method=RequestMethod.GET)
	@ResponseBody
	public String getDevIdcard(String hospitalId,HttpServletRequest request, HttpServletResponse response){
		try {
			OfficeVO vo = officeService.WsfindHospital(hospitalId);
			ReturnCodeSimple returnCodeEx = new ReturnCodeSimple();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");
			returnCodeEx.setHead(head);
			returnCodeEx.setData(vo);
			return JsonMapper.getInstance().toJsonWs(returnCodeEx);
		} catch (Exception e) {
			return systemService.getErrReturnCode(e.getMessage());
		}
	}
	
	
}
