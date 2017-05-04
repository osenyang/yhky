package com.elink.hospitalhealthnurse.modules.statistics.web.ws;

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
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCode;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.modules.statistics.entity.LoveCensus;
import com.elink.hospitalhealthnurse.modules.statistics.vo.LoveCensusVO;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.modules.statistics.service.LoveCensusService;

/**
 * 喜爱统计Controller
 * @author 颜福艳
 * @version 2016-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/loveCensus")
public class WsLoveCensusController extends BaseController {

	@Autowired
	private LoveCensusService loveCensusService;
	@Autowired
	private SystemService systemService;
	
	/**
	 * 获取喜爱的服务人员
	 * @param userId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getLoveCensusList", method = RequestMethod.GET)
	@ResponseBody
	public String getLoveCensusList(String userId, HttpServletRequest request, HttpServletResponse response){
		try {
			if(StringUtils.isBlank(userId)){
				return this.systemService.getErrReturnCode("用户ID为空");
			}
			List<LoveCensusVO> list = loveCensusService.wsFind(userId);
			ReturnCodeEx<LoveCensusVO> returnCode = new ReturnCodeEx<LoveCensusVO>();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			returnCode.setHead(head);
			returnCode.setData(list);
			return JsonMapper.getInstance().toJsonWs(returnCode);
		} catch (Exception e) {
			return systemService.getErrReturnCode(e.getMessage());
		}
	}
	
	/**
	 * 提交喜爱的服务人员
	 * @param loveCensus
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="submitLoveCensus", method = RequestMethod.POST)
	@ResponseBody
	public String submitLoveCensus(LoveCensus loveCensus, HttpServletRequest request, HttpServletResponse response){
		try {
			if(StringUtils.isBlank(loveCensus.getUserId())){
				return this.systemService.getErrReturnCode("用户ID为空");
			}
			if(StringUtils.isBlank(loveCensus.getServiceUserId())){
				return this.systemService.getErrReturnCode("喜爱的服务人员ID为空");
			}
			loveCensusService.save(loveCensus); 
			ReturnCode returnCode = new ReturnCode();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			returnCode.setHead(head);
			returnCode.setData(null);
			return JsonMapper.getInstance().toJsonWs(returnCode);		
		} catch (Exception e) {
			return systemService.getErrReturnCode(e.getMessage());
		}
	}
	
	/**
	 * 撤销喜爱的服务人员
	 * @param lifeServeRecord
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="cancelLove", method = RequestMethod.POST)
	@ResponseBody
	public String cancelLove(String loveId, HttpServletRequest request, HttpServletResponse response){
		try {
			if(StringUtils.isBlank(loveId)){
				return this.systemService.getErrReturnCode("喜爱人员ID为空");
			}
			loveCensusService.delete(loveId);
			ReturnCode returnCode = new ReturnCode();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "成功");	
			returnCode.setHead(head);
			returnCode.setData(null);
			return JsonMapper.getInstance().toJsonWs(returnCode);		
		} catch (Exception e) {
			return systemService.getErrReturnCode(e.getMessage());
		}
	}

}
