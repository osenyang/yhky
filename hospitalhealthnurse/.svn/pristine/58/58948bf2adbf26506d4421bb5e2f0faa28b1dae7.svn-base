package com.elink.hospitalhealthnurse.modules.sys.web.ws;

import java.util.HashMap;
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
import com.elink.hospitalhealthnurse.modules.sys.entity.About;
import com.elink.hospitalhealthnurse.modules.sys.service.AboutService;

@Controller
@RequestMapping(value = "${adminPath}/ws/about")
public class WsAboutController {
	
	@Autowired
	private AboutService aboutService;

	/**
	 * 获取护工端关于|评估说明
	 * @param about
	 * @param request
	 * @param response
	 * @return
	 * @author 周贤舟 2015年8月17日
	 */
	@RequestMapping(value="getAbout", method = RequestMethod.GET)
	@ResponseBody
	public String getAbout(About about, HttpServletRequest request, HttpServletResponse response){
		List<About> list = aboutService.find(about);
		ReturnCodeEx<About> returnCode = new ReturnCodeEx<About>();
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ret", 0);
		head.put("msg", "成功");
		returnCode.setHead(head);
		returnCode.setData(list);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
}
