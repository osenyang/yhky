package com.elink.hospitalhealthnurse.modules.healtharchives.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthRecord;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthArchivesVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthRecordVO;
import com.elink.hospitalhealthnurse.modules.sys.entity.Area;
import com.elink.hospitalhealthnurse.modules.sys.service.AreaService;
import com.elink.hospitalhealthnurse.modules.sys.vo.AreaVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthArchivesService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthRecordService;

/**
 * 健康记录Controller
 * @author 颜福艳
 * @version 2016-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/healthRecord")
public class HealthRecordController extends BaseController {

	@Autowired
	private HealthRecordService healthRecordService;
	@Autowired
	private HealthArchivesService healthArchivesService;
	@Autowired
	private AreaService areaService;
	
	@ModelAttribute
	public HealthRecord get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return healthRecordService.get(id);
		}else{
			return new HealthRecord();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(HealthRecordVO healthRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<HealthRecordVO> page = healthRecordService.find(new Page<HealthRecordVO>(request, response), healthRecord); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/healthRecordList";
	}

	@RequestMapping(value = "form")
	public String form(HealthRecord healthRecord, Model model) {
		if(healthRecord != null && StringUtils.isNotBlank(healthRecord.getUserId())){
			HealthArchivesVO vo =  healthArchivesService.getUserByUserId(healthRecord.getUserId());
			healthRecord.setPhoto(vo.getPhoto());
			healthRecord.setFullNm(vo.getFullNm());
			healthRecord.setSex(vo.getSex());
			healthRecord.setAge(vo.getAge());
		}
		model.addAttribute("healthRecord", healthRecord);
		List<Area> provinceList = areaService.findJgAll();
		model.addAttribute("provinceList", provinceList);
		if(healthRecord != null && StringUtils.isNotEmpty(healthRecord.getProvince())){
			List<AreaVO> cityList = areaService.findListByParentId(healthRecord.getProvince());
			model.addAttribute("cityList", cityList);
		}
		if(healthRecord != null && StringUtils.isNotEmpty(healthRecord.getCity())){
			List<AreaVO> areaList = areaService.findListByParentId(healthRecord.getCity());
			model.addAttribute("areaList", areaList);
		}
		return "modules/" + "healtharchives/healthRecordForm";
	}
	
	@RequestMapping(value = "info")
	public String info(HealthRecord healthRecord, Model model) {
		if(healthRecord != null && StringUtils.isNotBlank(healthRecord.getUserId())){
			HealthArchivesVO vo =  healthArchivesService.getUserByUserId(healthRecord.getUserId());
			healthRecord.setPhoto(vo.getPhoto());
			healthRecord.setFullNm(vo.getFullNm());
			healthRecord.setSex(vo.getSex());
			healthRecord.setAge(vo.getAge());
		}
		String areaAddress = "";
		List<Area> areaList = areaService.getAreaById(healthRecord.getProvince(),healthRecord.getCity(),healthRecord.getArea());
		if(areaList != null && areaList.size() > 0){
			for(Area area:areaList){
				areaAddress += area.getName();
			}
		}
		model.addAttribute("areaAddress", areaAddress);
		model.addAttribute("healthRecord", healthRecord);
		return "modules/" + "healtharchives/healthRecordInfo";
	}

	@RequestMapping(value = "save")
	public String save(HealthRecord healthRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, healthRecord)){
			return form(healthRecord, model);
		}
		healthRecordService.save(healthRecord);
		addMessage(redirectAttributes, "保存记录成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthRecord/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		healthRecordService.delete(id);
		addMessage(redirectAttributes, "删除记录成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthRecord/?repage";
	}

}
