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
import com.elink.hospitalhealthnurse.modules.sys.service.AppInformationService;
import com.elink.hospitalhealthnurse.modules.sys.vo.AppInformationVO;
import com.google.common.collect.Maps;

/**
 * APP接口
 * @Title WsMachineController.java
 * @Package com.elink.communityhealth.modules.machine.web.ws
 * @author 杜康
 * @date 2016年6月4日
 * @update
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/app")
public class WsAppController extends BaseController {

	@Autowired
	private AppInformationService appInformationService;
	
	/**
	 * 请求APP版本和地址
	 * @author 杜康
	 * @date 2017-03-28
	 */
	@RequestMapping(value="requestApp", method = RequestMethod.GET)
	@ResponseBody
	public String request(HttpServletRequest request, HttpServletResponse response,String appName){
		try {
			List<AppInformationVO> list = appInformationService.findByAppName(appName);
			ReturnCodeEx<AppInformationVO> returnCode = new ReturnCodeEx<AppInformationVO>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			returnCode.setHead(head);
			returnCode.setData(list);
			return JsonMapper.getInstance().toJsonWs(returnCode);
		} catch (Exception e) {
			ReturnCodeSimple returnCodeErr = new ReturnCodeSimple();
			Map<String, Object> headErr = Maps.newHashMap();
			headErr.put("ret", 1);
			headErr.put("msg", e.getMessage());	
			returnCodeErr.setHead(headErr);
			return JsonMapper.getInstance().toJsonWs(returnCodeErr);
		}
	}
}
