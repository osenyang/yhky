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
import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.vo.Code;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.elink.hospitalhealthnurse.modules.sys.utils.DictUtils;
import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "${adminPath}/ws/dict")
public class WsDictController {

	@Autowired
	private SystemService systemService;
	
	/****
	 * 获取服务类型选项接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getServiceTypeOption",method=RequestMethod.GET)
	@ResponseBody
	public String getServiceTypeOption(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Code> list = DictUtils.getDictListByWs(Consts.DICT_TYPE_SERVICE_TYPE);
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
	 * 获取医保类型选项接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getMedicalTypeOption",method=RequestMethod.GET)
	@ResponseBody
	public String getMedicalTypeOption(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Code> list = DictUtils.getDictListByWs(Consts.DICT_TYPE_MEDICAL_TYPE);
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
	 * 获取文化程度选项接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getCultureTypeOption",method=RequestMethod.GET)
	@ResponseBody
	public String getCultureTypeOption(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Code> list = DictUtils.getDictListByWs(Consts.DICT_TYPE_CULTURE_TYPE);
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
	 * 获取TV端时间段接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getTimeTypeOption",method=RequestMethod.GET)
	@ResponseBody
	public String getTimeTypeOption(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Code> list = DictUtils.getDictListByWs(Consts.DICT_TYPE_TIME_TYPE);
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
