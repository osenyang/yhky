package com.elink.hospitalhealthnurse.modules.statistics.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.common.utils.CookieUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.statistics.entity.MoodIndex;
import com.elink.hospitalhealthnurse.modules.statistics.vo.MoodIndexVO;
import com.elink.hospitalhealthnurse.modules.statistics.vo.MoodValueVO;
import com.elink.hospitalhealthnurse.modules.statistics.service.MoodIndexService;

/**
 * 心情指数Controller
 * @author 颜福艳
 * @version 2016-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/statistics/moodIndex")
public class MoodIndexController extends BaseController {

	@Autowired
	private MoodIndexService moodIndexService;
	
	@ModelAttribute
	public MoodIndex get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return moodIndexService.get(id);
		}else{
			return new MoodIndex();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(MoodIndexVO moodIndex, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<MoodIndexVO> page = moodIndexService.find(new Page<MoodIndexVO>(request, response), moodIndex); 
        model.addAttribute("page", page);
		return "modules/" + "statistics/moodIndexList";
	}
	
	/****
	 * 获取心情指数趋势图数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getMoodIndexAvgTrend")
	@ResponseBody
	public String getMoodIndexAvgTrend(String statType,HttpServletRequest request,HttpServletResponse response) {

		if(StringUtils.isNotBlank(statType)){
			CookieUtils.setCookie(response, "statType", statType);
		}else{
			statType = CookieUtils.getCookie(request, "statType");
		}		
		Page<MoodValueVO> page = new Page<MoodValueVO>(request, response);
		page.setFuncName("launchMoodChart");
		Map<String,Object[]>  returnCode = moodIndexService.getMoodIndexAvgStatValue(page,statType);
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	
	

	@RequestMapping(value = "form")
	public String form(MoodIndex moodIndex, Model model) {
		model.addAttribute("moodIndex", moodIndex);
		return "modules/" + "statistics/moodIndexForm";
	}

	@RequestMapping(value = "save")
	public String save(MoodIndex moodIndex, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, moodIndex)){
			return form(moodIndex, model);
		}
		moodIndexService.save(moodIndex);
		addMessage(redirectAttributes, "保存心情指数成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/moodIndex/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		moodIndexService.delete(id);
		addMessage(redirectAttributes, "删除心情指数成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/moodIndex/?repage";
	}

}
