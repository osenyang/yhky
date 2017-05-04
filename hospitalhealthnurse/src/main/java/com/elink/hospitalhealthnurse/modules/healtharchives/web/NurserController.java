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
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nurser;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.FrequencysService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NurserService;

/**
 * 照护计划Controller
 * @author 杜康
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/nurser")
public class NurserController extends BaseController {

	@Autowired
	private NurserService nurserService;
	
	@Autowired
	private FrequencysService frequencysService;
	
	@Autowired
	private InterveneService interveneService;
	
	@ModelAttribute
	public Nurser get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return nurserService.get(id);
		}else{
			return new Nurser();
		}
	}
	
	@RequiresPermissions("healtharchives:nurser:view")
	@RequestMapping(value = {"list", ""})
	public String list(Nurser nurser, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Nurser> page = nurserService.find(new Page<Nurser>(request, response), nurser); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/nurserList";
	}

	@RequiresPermissions("healtharchives:nurser:view")
	@RequestMapping(value = "form")
	public String form(Nurser nurser, Model model) {
		model.addAttribute("nurser", nurser);
		return "modules/" + "healtharchives/nurserForm";
	}

	@RequiresPermissions("healtharchives:nurser:edit")
	@RequestMapping(value = "save")
	public String save(Nurser nurser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nurser)){
			return form(nurser, model);
		}
		nurserService.save(nurser);
		addMessage(redirectAttributes, "保存照护计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/nurser/?repage";
	}
	
	@RequiresPermissions("healtharchives:nurser:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		nurserService.delete(id);
		addMessage(redirectAttributes, "删除照护计划成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/nurser/?repage";
	}
	/**
	 * 根据ID获得护理计划
	 * */
	@RequestMapping(value = "findById")
	public String findById(Nurser nurser, Model model, HttpServletRequest reques) {
		String interveneId = reques.getParameter("interveneId");
		String state = reques.getParameter("state");
		
		//介护口腔清洗 
		if(StringUtils.isNotBlank(nurser.getCavityClean())){
			Frequencys frequency = frequencysService.get(nurser.getCavityClean());
			if(frequency != null){
				nurser.setCavityCleanType(frequency.getFrequencyType());
				nurser.setCavityCleanInterval(frequency.getIntervals());
				nurser.setCavityCleanDetails(frequency.getDateArray());
			}
		}
		 
		//介护会阴冲洗  
		if(StringUtils.isNotBlank(nurser.getPerinealWash())){
			Frequencys frequency = frequencysService.get(nurser.getPerinealWash());
			if(frequency != null){
				nurser.setPerinealWashType(frequency.getFrequencyType());
				nurser.setPerinealWashInterval(frequency.getIntervals());
				nurser.setPerinealWashDetails(frequency.getDateArray());
			}
		}
		
		//介护洗澡
		if(StringUtils.isNotBlank(nurser.getBathBath())){
			Frequencys frequency = frequencysService.get(nurser.getBathBath());
			if(frequency != null){
				nurser.setBathBathType(frequency.getFrequencyType());
				nurser.setBathBathInterval(frequency.getIntervals());
				nurser.setBathBathDetails(frequency.getDateArray());
			}
		}
		
		//介护洗头 
		if(StringUtils.isNotBlank(nurser.getWashHair())){
			Frequencys frequency = frequencysService.get(nurser.getWashHair());
			if(frequency != null){
				nurser.setWashHairType(frequency.getFrequencyType());
				nurser.setWashHairInterval(frequency.getIntervals());
				nurser.setWashHairDetails(frequency.getDateArray());
			}
		}
		
		//介护服药
		if(StringUtils.isNotBlank(nurser.getOralMedicine())){
			Frequencys frequency = frequencysService.get(nurser.getOralMedicine());
			if(frequency != null){
				nurser.setOralMedicineType(frequency.getFrequencyType());
				nurser.setOralMedicineInterval(frequency.getIntervals());
				nurser.setOralMedicineDetails(frequency.getDateArray());
			}
		}
		
		//介护服中药    
		if(StringUtils.isNotBlank(nurser.getChineseMedicine())){
			Frequencys frequency = frequencysService.get(nurser.getChineseMedicine());
			if(frequency != null){
				nurser.setChineseMedicineType(frequency.getFrequencyType());
				nurser.setChineseMedicineInterval(frequency.getIntervals());
				nurser.setChineseMedicineDetails(frequency.getDateArray());
			}
		}
		
		//翻身
		if(StringUtils.isNotBlank(nurser.getTurnOver())){
			Frequencys frequency = frequencysService.get(nurser.getTurnOver());
			if(frequency != null){
				nurser.setTurnOverType(frequency.getFrequencyType());
				nurser.setTurnOverInterval(frequency.getIntervals());
				nurser.setTurnOverDetails(frequency.getDateArray());
			}
		}
		
		//拍背
		if(StringUtils.isNotBlank(nurser.getBackslap())){
			Frequencys frequency = frequencysService.get(nurser.getBackslap());
			if(frequency != null){
				nurser.setBackslapType(frequency.getFrequencyType());
				nurser.setBackslapInterval(frequency.getIntervals());
				nurser.setBackslapDetails(frequency.getDateArray());
			}
		}
		
		//下腹部按摩 
		if(StringUtils.isNotBlank(nurser.getBellyMassage())){
			Frequencys frequency = frequencysService.get(nurser.getBellyMassage());
			if(frequency != null){
				nurser.setBellyMassageType(frequency.getFrequencyType());
				nurser.setBellyMassageInterval(frequency.getIntervals());
				nurser.setBellyMassageDetails(frequency.getDateArray());
			}
		}
		
		//饮水   
		if(StringUtils.isNotBlank(nurser.getDrinkWater())){
			Frequencys frequency = frequencysService.get(nurser.getDrinkWater());
			if(frequency != null){
				nurser.setDrinkWaterType(frequency.getFrequencyType());
				nurser.setDrinkWaterInterval(frequency.getIntervals());
				nurser.setDrinkWaterDetails(frequency.getDateArray());
			}
		}
		
		//沟通
		if(StringUtils.isNotBlank(nurser.getCommunicate())){
			Frequencys frequency = frequencysService.get(nurser.getCommunicate());
			if(frequency != null){
				nurser.setCommunicateType(frequency.getFrequencyType());
				nurser.setCommunicateInterval(frequency.getIntervals());
				nurser.setCommunicateDetails(frequency.getDateArray());
			}
		}
		
		model.addAttribute("nurser", nurser);
		model.addAttribute("interveneId", interveneId);
		model.addAttribute("state", state);
		return "modules/healtharchives/nurserForm";
	}
	
	/**
	 * 保存照护计划
	 * @author dk
	 * @data 2017-3-18 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveNurser")
	@ResponseBody
	public String saveNurser(Intervene intervene,Nurser nurser, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String id = IdGen.uuid();
		String interveneId = request.getParameter("interveneId");
		//介护口腔清洗 
		if(StringUtils.isNotBlank(nurser.getCavityCleanType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getCavityCleanType());
			frequency.setIntervals(nurser.getCavityCleanInterval());
			frequency.setDateArray(nurser.getCavityCleanDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setCavityClean(frequency.getId());
		}
				 
		//介护会阴冲洗   
		if(StringUtils.isNotBlank(nurser.getPerinealWashType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getPerinealWashType());
			frequency.setIntervals(nurser.getPerinealWashInterval());
			frequency.setDateArray(nurser.getPerinealWashDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setPerinealWash(frequency.getId());
		}	
		
		//介护洗澡
		if(StringUtils.isNotBlank(nurser.getBathBathType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getBathBathType());
			frequency.setIntervals(nurser.getBathBathInterval());
			frequency.setDateArray(nurser.getBathBathDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setBathBath(frequency.getId());
		}
		
		//介护洗头 
		if(StringUtils.isNotBlank(nurser.getWashHairType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getWashHairType());
			frequency.setIntervals(nurser.getWashHairInterval());
			frequency.setDateArray(nurser.getWashHairDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setWashHair(frequency.getId());
		}
		
		//介护服药
		if(StringUtils.isNotBlank(nurser.getOralMedicineType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getOralMedicineType());
			frequency.setIntervals(nurser.getOralMedicineInterval());
			frequency.setDateArray(nurser.getOralMedicineDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setOralMedicine(frequency.getId());
		}
		
		//介护服中药   
		if(StringUtils.isNotBlank(nurser.getChineseMedicineType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getChineseMedicineType());
			frequency.setIntervals(nurser.getChineseMedicineInterval());
			frequency.setDateArray(nurser.getChineseMedicineDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setChineseMedicine(frequency.getId());
		}
		
		//翻身
		if(StringUtils.isNotBlank(nurser.getTurnOverType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getTurnOverType());
			frequency.setIntervals(nurser.getTurnOverInterval());
			frequency.setDateArray(nurser.getTurnOverDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setTurnOver(frequency.getId());
		}
		
		//拍背
		if(StringUtils.isNotBlank(nurser.getBackslapType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getBackslapType());
			frequency.setIntervals(nurser.getBackslapInterval());
			frequency.setDateArray(nurser.getBackslapDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setBackslap(frequency.getId());
		}
		
		
		//下腹部按摩 
		if(StringUtils.isNotBlank(nurser.getBellyMassageType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getBellyMassageType());
			frequency.setIntervals(nurser.getBellyMassageInterval());
			frequency.setDateArray(nurser.getBellyMassageDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setBellyMassage(frequency.getId());
		}
		
		//饮水   
		if(StringUtils.isNotBlank(nurser.getDrinkWaterType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getDrinkWaterType());
			frequency.setIntervals(nurser.getDrinkWaterInterval());
			frequency.setDateArray(nurser.getDrinkWaterDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setDrinkWater(frequency.getId());
		}
		
		//沟通
		if(StringUtils.isNotBlank(nurser.getCommunicateType())){
			Frequencys frequency = new Frequencys();
			frequency.setFrequencyType(nurser.getCommunicateType());
			frequency.setIntervals(nurser.getCommunicateInterval());
			frequency.setDateArray(nurser.getCommunicateDetails());
			frequency.setInterveneId(interveneId);
			frequency.setPlanId(id);
			frequencysService.save(frequency);
			nurser.setCommunicate(frequency.getId());
		}
		nurser.setId(id);		
		nurserService.save(nurser);
		if(StringUtils.isNotBlank(interveneId)){
			intervene = interveneService.get(interveneId);
			intervene.setNurserId(nurser.getId());
			interveneService.save(intervene);
		}
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "保存照护计划成功");
//		returnCode.put("id", care.getId());
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
}
