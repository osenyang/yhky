package com.elink.hospitalhealthnurse.modules.healtharchives.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.elink.hospitalhealthnurse.common.utils.IdGen;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Assessment;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Care;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessmentService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.CareService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.FrequencysService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneService;

/**
 * 护理计划Controller
 * @author 杜康
 * @version 2016-10-28
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/care")
public class CareController extends BaseController {

	@Autowired
	private CareService careService;
	
	@Autowired
	private FrequencysService frequencysService;
	
	@Autowired
	private InterveneService interveneService;
	
	@Autowired
	private AssessmentService assessmentService;
	
	@ModelAttribute
	public Care get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return careService.get(id);
		}else{
			return new Care();
		}
	}
	
	@RequiresPermissions("healtharchives:care:view")
	@RequestMapping(value = {"list", ""})
	public String list(Care care, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Care> page = careService.find(new Page<Care>(request, response), care); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/careList";
	}

	@RequestMapping(value = "form")
	public String form(Care care, Model model) {
		model.addAttribute("care", care);
		return "modules/" + "healtharchives/careForm";
	}

	@RequiresPermissions("healtharchives:care:edit")
	@RequestMapping(value = "save")
	public String save(Care care, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, care)){
			return form(care, model);
		}
		careService.save(care);
		addMessage(redirectAttributes, "保存护理计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/care/?repage";
	}
	
	@RequiresPermissions("healtharchives:care:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		careService.delete(id);
		addMessage(redirectAttributes, "删除护理计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/care/?repage";
	}

	/**
	 * 根据ID获得护理计划
	 * */
	@RequestMapping(value = "findById")
	public String findById(Care care, Model model, HttpServletRequest reques) {
		String interveneId = reques.getParameter("interveneId");
		String state = reques.getParameter("state");
		//静脉输液
		if(StringUtils.isNotBlank(care.getVeinInfusion())){
			Frequencys frequency = frequencysService.get(care.getVeinInfusion());
			if(frequency != null){
				care.setVeinInfusionType(frequency.getFrequencyType());
				care.setVeinInfusionInterval(frequency.getIntervals());
				care.setVeinInfusionDetails(frequency.getDateArray());
			}
		}
		//更换湿化瓶
		if(StringUtils.isNotBlank(care.getReplaceWefFlask())){
			Frequencys frequency = frequencysService.get(care.getReplaceWefFlask());
			if(frequency != null){
				care.setReplaceWefFlaskType(frequency.getFrequencyType());
				care.setReplaceWefFlaskInterval(frequency.getIntervals());
				care.setReplaceWefFlaskDetails(frequency.getDateArray());
			}
		}
		//吸痰
		if(StringUtils.isNotBlank(care.getSputumSuction())){
			Frequencys frequency = frequencysService.get(care.getSputumSuction());
			if(frequency != null){
				care.setSputumSuctionType(frequency.getFrequencyType());
				care.setSputumSuctionInterval(frequency.getIntervals());
				care.setSputumSuctionDetails(frequency.getDateArray());
			}
		}
		//雾化
		if(StringUtils.isNotBlank(care.getAtomization())){
			Frequencys frequency = frequencysService.get(care.getAtomization());
			if(frequency != null){
				care.setAtomizationType(frequency.getFrequencyType());
				care.setAtomizationInterval(frequency.getIntervals());
				care.setAtomizationDetails(frequency.getDateArray());
			}
		}
		//口腔护理
		if(StringUtils.isNotBlank(care.getOralNuser())){
			Frequencys frequency = frequencysService.get(care.getOralNuser());
			if(frequency != null){
				care.setOralNuserType(frequency.getFrequencyType());
				care.setOralNuserInterval(frequency.getIntervals());
				care.setOralNuserDetails(frequency.getDateArray());
			}
		}
		//尿管护理
		if(StringUtils.isNotBlank(care.getUreterNuser())){
			Frequencys frequency = frequencysService.get(care.getUreterNuser());
			if(frequency != null){
				care.setUreterNuserType(frequency.getFrequencyType());
				care.setUreterNuserInterval(frequency.getIntervals());
				care.setUreterNuserDetails(frequency.getDateArray());
			}
		}
		//深静脉置管护理
		if(StringUtils.isNotBlank(care.getDeepVein())){
			Frequencys frequency = frequencysService.get(care.getDeepVein());
			if(frequency != null){
				care.setDeepVeinType(frequency.getFrequencyType());
				care.setDeepVeinInterval(frequency.getIntervals());
				care.setDeepVeinDetails(frequency.getDateArray());
			}
		}
		//气管切开护理
		if(StringUtils.isNotBlank(care.getTracheaNuser())){
			Frequencys frequency = frequencysService.get(care.getTracheaNuser());
			if(frequency != null){
				care.setTracheaNuserType(frequency.getFrequencyType());
				care.setTracheaNuserInterval(frequency.getIntervals());
				care.setTracheaNuserDetails(frequency.getDateArray());
			}
		}
		//口服药
		if(StringUtils.isNotBlank(care.getOralMedicine())){
			Frequencys frequency = frequencysService.get(care.getOralMedicine());
			if(frequency != null){
				care.setOralMedicineType(frequency.getFrequencyType());
				care.setOralMedicineInterval(frequency.getIntervals());
				care.setOralMedicineDetails(frequency.getDateArray());
			}
		}
		//中药
		if(StringUtils.isNotBlank(care.getChineseMedicine())){
			Frequencys frequency = frequencysService.get(care.getChineseMedicine());
			if(frequency != null){
				care.setChineseMedicineType(frequency.getFrequencyType());
				care.setChineseMedicineInterval(frequency.getIntervals());
				care.setChineseMedicineDetails(frequency.getDateArray());
			}
		}
		//特殊用药
		if(StringUtils.isNotBlank(care.getSpecialMedicine())){
			Frequencys frequency = frequencysService.get(care.getSpecialMedicine());
			if(frequency != null){
				care.setSpecialMedicineType(frequency.getFrequencyType());
				care.setSpecialMedicineInterval(frequency.getIntervals());
				care.setSpecialMedicineDetails(frequency.getDateArray());
			}
		}
		//营养餐
		if(StringUtils.isNotBlank(care.getNutritionMeal())){
			Frequencys frequency = frequencysService.get(care.getNutritionMeal());
			if(frequency != null){
				care.setNutritionMealType(frequency.getFrequencyType());
				care.setNutritionMealInterval(frequency.getIntervals());
				care.setNutritionMealDetails(frequency.getDateArray());
			}
		}
		Intervene intervene	= interveneService.get(interveneId);
		if(StringUtils.isNotBlank(intervene.getAssessmentId())){
			Assessment assessment = assessmentService.get(intervene.getAssessmentId());
			care.setDiagnosis(assessment.getDiagnosis());
		}
		
		model.addAttribute("care", care);
		model.addAttribute("interveneId", interveneId);
		model.addAttribute("state", state);
		return "modules/" + "healtharchives/careForm";
	}
	
	/**
	 * 保存护理计划
	 * @author dk
	 * @data 2017-3-18 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveCare")
	@ResponseBody
	public String saveCare(Intervene intervene,Care care, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String id = IdGen.uuid();
		String interveneId = request.getParameter("interveneId");
		//静脉输液
		if(StringUtils.isNotBlank(care.getVeinInfusionType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getVeinInfusionType());
			frequency.setIntervals(care.getVeinInfusionInterval());
			frequency.setDateArray(care.getVeinInfusionDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setVeinInfusion(frequency.getId());
		}
		//更换湿化瓶
		if(StringUtils.isNotBlank(care.getReplaceWefFlaskType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getReplaceWefFlaskType());
			frequency.setIntervals(care.getReplaceWefFlaskInterval());
			frequency.setDateArray(care.getReplaceWefFlaskDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setReplaceWefFlask(frequency.getId());
		}
		//吸痰
		if(StringUtils.isNotBlank(care.getSputumSuctionType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getSputumSuctionType());
			frequency.setIntervals(care.getSputumSuctionInterval());
			frequency.setDateArray(care.getSputumSuctionDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setSputumSuction(frequency.getId());
		}
		//雾化
		if(StringUtils.isNotBlank(care.getAtomizationType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getAtomizationType());
			frequency.setIntervals(care.getAtomizationInterval());
			frequency.setDateArray(care.getAtomizationDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setAtomization(frequency.getId());
		}
		//口腔护理
		if(StringUtils.isNotBlank(care.getOralNuserType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getOralNuserType());
			frequency.setIntervals(care.getOralNuserInterval());
			frequency.setDateArray(care.getOralNuserDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setOralNuser(frequency.getId());
		}
		//尿管护理
		if(StringUtils.isNotBlank(care.getUreterNuserType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getUreterNuserType());
			frequency.setIntervals(care.getUreterNuserInterval());
			frequency.setDateArray(care.getUreterNuserDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setUreterNuser(frequency.getId());
		}
		//深静脉置管护理
		if(StringUtils.isNotBlank(care.getDeepVeinType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getDeepVeinType());
			frequency.setIntervals(care.getDeepVeinInterval());
			frequency.setDateArray(care.getDeepVeinDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setDeepVein(frequency.getId());
		}
		//气管切开护理
		if(StringUtils.isNotBlank(care.getTracheaNuserType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getTracheaNuserType());
			frequency.setIntervals(care.getTracheaNuserInterval());
			frequency.setDateArray(care.getTracheaNuserDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setTracheaNuser(frequency.getId());
		}
		//口服药
		if(StringUtils.isNotBlank(care.getOralMedicineType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getOralMedicineType());
			frequency.setIntervals(care.getOralMedicineInterval());
			frequency.setDateArray(care.getOralMedicineDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setOralMedicine(frequency.getId());
		}
		//中药
		if(StringUtils.isNotBlank(care.getChineseMedicineType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getChineseMedicineType());
			frequency.setIntervals(care.getChineseMedicineInterval());
			frequency.setDateArray(care.getChineseMedicineDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setChineseMedicine(frequency.getId());
		}
		//特殊用药
		if(StringUtils.isNotBlank(care.getSpecialMedicineType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getSpecialMedicineType());
			frequency.setIntervals(care.getSpecialMedicineInterval());
			frequency.setDateArray(care.getSpecialMedicineDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setSpecialMedicine(frequency.getId());
		}
		//营养餐
		if(StringUtils.isNotBlank(care.getNutritionMealType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(care.getNutritionMealType());
			frequency.setIntervals(care.getNutritionMealInterval());
			frequency.setDateArray(care.getNutritionMealDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			care.setNutritionMeal(frequency.getId());
		}
		care.setId(id);
		careService.save(care);
		if(StringUtils.isNotBlank(interveneId)){
			intervene = interveneService.get(interveneId);
			intervene.setCareId(care.getId());
			interveneService.save(intervene);
		}
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "保存护理计划成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
}
