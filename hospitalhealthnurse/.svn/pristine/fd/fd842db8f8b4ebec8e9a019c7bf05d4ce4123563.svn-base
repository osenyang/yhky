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
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCode;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.statistics.entity.MoodIndex;
import com.elink.hospitalhealthnurse.modules.statistics.service.MoodIndexService;
import com.elink.hospitalhealthnurse.modules.statistics.vo.MoodIndexVO;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.google.common.collect.Maps;

/**
 * 心情指数Controller
 * @author 颜福艳
 * @version 2016-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/moodIndex")
public class WsMoodIndexController extends BaseController {

	@Autowired
	private MoodIndexService moodIndexService;
	@Autowired
	private SystemService systemService;
	
	/**
	 * 获取老人心情指数
	 * @param moodIndex
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getMoodIndexList", method = RequestMethod.GET)
	@ResponseBody
	public String getMoodIndexList(MoodIndexVO moodIndex, HttpServletRequest request, HttpServletResponse response){
		try {
			if(StringUtils.isBlank(moodIndex.getUserId())){
				return this.systemService.getErrReturnCode("用户ID为空");
			}
			List<MoodIndexVO> list = moodIndexService.wsFind(moodIndex);
			ReturnCodeEx<MoodIndexVO> returnCode = new ReturnCodeEx<MoodIndexVO>();
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
	 * 提交老人心情指数
	 * @param moodIndex
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="submitMoodIndex", method = RequestMethod.POST)
	@ResponseBody
	public String submitMoodIndex(MoodIndex moodIndex, HttpServletRequest request, HttpServletResponse response){
		try {
			if(StringUtils.isBlank(moodIndex.getUserId())){
				return this.systemService.getErrReturnCode("用户ID为空");
			}
			if(StringUtils.isBlank(moodIndex.getMoodValue())){
				return this.systemService.getErrReturnCode("心情值为空");
			}
			User user = systemService.getUser(moodIndex.getUserId());
			moodIndex.setOfficeId(user.getOffice().getId());
			moodIndexService.save(moodIndex); 
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
