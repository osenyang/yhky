package com.elink.hospitalhealthnurse.modules.healtharchives.web.ws;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthInpatient;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthInpatientService;
import com.google.common.collect.Maps;

/**
 * 病区管理Controller
 * @author dk
 * @version 2017-3-29
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/healthInpatient")
public class WsHealthInpatientController {	
	@Autowired
	private HealthInpatientService healthInpatientService;
	
	/**
	 * 查询所有病区
	 * @param officeId
	 * @author dk
	 * @data 2016-10-14 
	 */
	@RequestMapping(value = "findAll")
	@ResponseBody
	public String findAll(String officeId,HttpServletRequest request ){
		List<HealthInpatient> list = healthInpatientService.findByOfficeIdWs(officeId);
		ReturnCodeEx<HealthInpatient> returnCode = new ReturnCodeEx<HealthInpatient>();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(list);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
}
