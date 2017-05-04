package com.elink.hospitalhealthnurse.modules.healtharchives.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
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
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Assessment;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Care;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.ExtraItems;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Hobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.InterveneMeet;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Meet;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nurser;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nutrition;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Recover;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.RecoverHobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Social;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionDiagnosis;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionItem;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionPlan;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.ArrangeEnum.ArrangeList;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.InterveneVO;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanExecuteRecordService;
import com.elink.hospitalhealthnurse.modules.serviceorg.dao.ServiceUserDao;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Quarters;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.QuartersService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessmentService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.CareService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.ExtraItemsService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.FrequencysService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HobbyService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneMeetService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.MeetService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NurserService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NutritionService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.RecoverHobbyService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.RecoverService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.SocialService;

/**
 * 干预方案Controller
 * @author 杜康
 * @version 2016-10-22
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/intervene")
public class InterveneController extends BaseController {

	@Autowired
	private InterveneService interveneService;
	
	@Autowired
	private QuartersService quartersService;
	
	@Autowired
	private AssessmentService assessmentService;
	
	@Autowired
	private CareService careService;
	
	@Autowired
	private NutritionService nutritionService;
	
	@Autowired
	private RecoverService recoverService;
	
	@Autowired
	private NurserService nurserService;
	
	@Autowired
	private SocialService socialService;
	
	@Autowired
	private HobbyService hobbyService;
	
	@Autowired
	private RecoverHobbyService recoverHobbyService;
	
	@Autowired
	private MeetService meetService;
	
	@Autowired
	private InterveneMeetService interveneMeetService;
	
	@Autowired
	private PlanExecuteRecordService planExecuteRecordService;
	
	@Autowired
	private FrequencysService frequencysService;
	
	@Autowired
	private ExtraItemsService extraItemsService;
	
	@Autowired
	private ServiceUserDao userDao;
	
	
	@ModelAttribute
	public Intervene get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return interveneService.get(id);
		}else{
			return new Intervene();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(InterveneVO interveneVO, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<InterveneVO> page = interveneService.find(new Page<InterveneVO>(request, response), interveneVO); 
        model.addAttribute("page", page);
		return "modules/" + "healtharchives/interveneList";
	}
	
	/**
	 * 执行方案
	 * @author dk
	 * @data 2016-11-9
	 * */
	@RequestMapping(value = "startState")
	public String startState(Intervene intervene, Model model, RedirectAttributes redirectAttributes) {
		boolean bl = interveneService.findStateByArchivesId(intervene.getArchivesId());
		if(bl){
			interveneService.updateState(intervene.getId(), Intervene.INTER_STATE_EXECUTE);
			planExecuteRecordService.genTodayPlanExeRecord(intervene.getId(),new Date());
			addMessage(redirectAttributes, "执行方案成功");
		}else{
			addMessage(redirectAttributes, "已经有方案在执行，一个人在同一时间只能执行一个方案。");
		}
		return "redirect:"+Global.getAdminPath()+"/healtharchives/intervene/?repage";
	}
	/**
	 * 暂停方案
	 * @author dk
	 * @data 2016-11-9
	 * */
	@RequestMapping(value = "pauseState")
	public String pauseState(Intervene intervene, Model model, RedirectAttributes redirectAttributes) {
		interveneService.updateState(intervene.getId(), Intervene.INTER_STATE_PAUSE);
		planExecuteRecordService.delTodayUnExePlanRecord(intervene.getId());
		addMessage(redirectAttributes, "暂停方案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/intervene/?repage";
	}
	/**
	 * 停止方案
	 * @author dk
	 * @data 2016-11-9
	 * */
	@RequestMapping(value = "stopState")
	public String stopState(Intervene intervene, Model model, RedirectAttributes redirectAttributes) {
		interveneService.updateState(intervene.getId(), Intervene.INTER_STATE_STOP);
		planExecuteRecordService.delTodayUnExePlanRecord(intervene.getId());
		addMessage(redirectAttributes, "停止方案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/intervene/?repage";
	}

	@RequestMapping(value = "form")
	public String form(Intervene intervene, Model model) {
		InterveneVO inter = interveneService.findById(intervene.getId());
		//诊疗计划
		if(StringUtils.isNotBlank(inter.getAssessmentId())){
			Assessment assessment = assessmentService.get(inter.getAssessmentId());
			model.addAttribute("assessment", assessment);
		}else{
			model.addAttribute("assessment", new Assessment());
		}
		//护理计划
		if(StringUtils.isNotBlank(inter.getCareId())){
			Care care = careService.get(inter.getCareId());
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
			if(StringUtils.isNotBlank(care.getExtraItemsId())){
				String[] ids = care.getExtraItemsId().split(",");
				List<ExtraItems> extList = Lists.newArrayList();
				for(String extId :ids){
					ExtraItems extraItems = extraItemsService.get(extId);
					extList.add(extraItems);
				}
				care.setExtList(extList);
			}
			/*if(StringUtils.isNotBlank(intervene.getAssessmentId())){
				Assessment assessment = assessmentService.get(inter.getAssessmentId());
				care.setDiagnosis(assessment.getDiagnosis());
			}*/
			model.addAttribute("care", care);
		}else{
			model.addAttribute("care", new Care());
		}
		//照护计划
		if(StringUtils.isNotBlank(inter.getNurserId())){
			Nurser nurser = nurserService.get(inter.getNurserId());
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
		}else{
			model.addAttribute("nurser", new Nurser());
		}
		//营养计划//TODO
		if(StringUtils.isNotBlank(inter.getNutritionId())){
			NutritionPlan nutrition = nutritionService.get(inter.getNutritionId());
			
			List<String> itemNames = nutritionService.getItemNames();
			nutrition.setItemNames(itemNames);
			List<String> takeWays = nutritionService.getTakeWays();
			nutrition.setTakeWays(takeWays);
			List<String> mealNums = nutritionService.getMealNums();
			nutrition.setMealNums(mealNums);
			
			model.addAttribute("nutrition", nutrition);
			
			List<NutritionDiagnosis> nutritionDiagnosisList = nutritionService.getNdList();
			for (NutritionDiagnosis nutritionDiagnosis : nutrition.getNutritionDiagnosis()) {
				for (NutritionDiagnosis nutritionDiagnosis2 : nutritionDiagnosisList) {
					if (nutritionDiagnosis2.getId().equals(nutritionDiagnosis.getId())) {
						nutritionDiagnosis2.setSelected("selected");
						break;
					}
				}
			}
			
			model.addAttribute("nutritionDiagnosisList", nutritionDiagnosisList);
			
			List<NutritionItem> items = nutrition.getItems();
			for (NutritionItem nutritionItem : items) {
				String caterUserId = nutritionItem.getCaterUserId();
				if (org.apache.commons.lang3.StringUtils.isNotBlank(caterUserId)) {
					ServiceUser caterUser = userDao.getByJobNo(caterUserId);
					nutritionItem.setCaterUser(caterUser);
				}
				String receiveUserId = nutritionItem.getReceiveUserId();
				if (org.apache.commons.lang3.StringUtils.isNotBlank(receiveUserId)) {
					ServiceUser receiveUser = userDao.getByJobNo(receiveUserId);
					nutritionItem.setReceiveUser(receiveUser);
				}
				String executeUserId = nutritionItem.getExecuteUserId();
				if (org.apache.commons.lang3.StringUtils.isNotBlank(executeUserId)) {
					ServiceUser executeUser = userDao.getByJobNo(executeUserId);
					nutritionItem.setExecuteUser(executeUser);
				}
			}
		}else{
			model.addAttribute("nutrition", new NutritionPlan());
		}
		//康复计划//TODO
		if(StringUtils.isNotBlank(inter.getRecoverId())){
			Recover recover = recoverService.get(inter.getRecoverId());
			model.addAttribute("recover", recover);
		}else{
			model.addAttribute("recover", new Recover());
		}
		//社工计划
		if(StringUtils.isNotBlank(inter.getSocialId())){
			Social social = socialService.get(inter.getSocialId());
			model.addAttribute("social", social);
		}else{
			model.addAttribute("social", new Social());
		}
		
		//兴趣爱好
		if(StringUtils.isNotBlank(inter.getId())){
			List<Hobby> hobbyList = hobbyService.findByInterveneId(inter.getId());
			model.addAttribute("hobbyList", hobbyList);
		}
		
		List<Meet> meetList = meetService.findByInterveneId(inter.getId());
		model.addAttribute("meetList",meetList);
		
		model.addAttribute("intervene", inter);
		return "modules/" + "healtharchives/interveneForm";
	}

	@RequestMapping(value = "save")
	public String save(Intervene intervene, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, intervene)){
			return form(intervene, model);
		}
		interveneService.save(intervene);
		addMessage(redirectAttributes, "添加干预方案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/intervene/?repage";
	}
	/**
	 * 保存诊疗计划
	 * @author dk
	 * @data 2016-11-2 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveAssessment")
	@ResponseBody
	public String saveAssessment(Intervene intervene,Assessment assessment, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		assessmentService.save(assessment);
		String interveneId = request.getParameter("interveneId");
		if(StringUtils.isNotBlank(interveneId)){
			intervene = interveneService.get(interveneId);
			intervene.setAssessmentId(assessment.getId());
			interveneService.save(intervene);
		}
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "保存诊疗计划成功");
//		returnCode.put("id", assessment.getId());
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	/**
	 * 保存护理计划
	 * @author dk
	 * @data 2016-11-2 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveCare")
	@ResponseBody
	public String saveCare(Intervene intervene,Care care, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		careService.save(care);
		String interveneId = request.getParameter("interveneId");
		if(StringUtils.isNotBlank(interveneId)){
			intervene = interveneService.get(interveneId);
			intervene.setCareId(care.getId());
			interveneService.save(intervene);
		}
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "保存护理计划成功");
//		returnCode.put("id", care.getId());
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 保存照护计划
	 * @author dk
	 * @data 2016-11-3 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveNurser")
	@ResponseBody
	public String saveNurser(Intervene intervene,Nurser nurser, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		nurserService.save(nurser);
		String interveneId = request.getParameter("interveneId");
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
	
	/**
	 * 保存营养计划
	 * @param intervene  干预方案
	 * @param nutritionPlan
	 * @param model
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
	//TODO
	@RequestMapping(value = "saveNutrition")
	@ResponseBody
	public String saveNutrition(Intervene intervene,NutritionPlan nutritionPlan, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		nutritionService.save(nutritionPlan);
		String interveneId = request.getParameter("interveneId");
		if(StringUtils.isNotBlank(interveneId)){
			intervene = interveneService.get(interveneId);
			intervene.setNutritionId(nutritionPlan.getId());
			interveneService.save(intervene);
		}
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "保存营养计划成功");
//		returnCode.put("id", care.getId());
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 保存康复计划
	 * @author dk
	 * @data 2016-11-4 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveRecover")
	@ResponseBody
	public String saveRecover(Intervene intervene,Recover recover, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		recoverService.save(recover);
		String interveneId = request.getParameter("interveneId");
		if(StringUtils.isNotBlank(interveneId)){
			intervene = interveneService.get(interveneId);
			intervene.setRecoverId(recover.getId());
			interveneService.save(intervene);
		}
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "保存康复计划成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 保存社工计划
	 * @author dk
	 * @data 2016-11-4 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveSocial")
	@ResponseBody
	public String saveSocial(Intervene intervene,Social social, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		socialService.save(social);
		String interveneId = request.getParameter("interveneId");
		if(StringUtils.isNotBlank(interveneId)){
			intervene = interveneService.get(interveneId);
			intervene.setSocialId(social.getId());
			interveneService.save(intervene);
		}
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "保存社工计划成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 保存兴趣爱好
	 * @author dk
	 * @data 2016-11-7 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveHobby")
	@ResponseBody
	public String saveHobby(String interveneId,Hobby hobby, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String str;
		if(StringUtils.isNotBlank(hobby.getId())){
			str = "修改兴趣爱好成功";
		}else{
			str = "添加兴趣爱好成功";
		}
		hobbyService.save(hobby);
		System.out.println(interveneId);
		RecoverHobby rh = new RecoverHobby();
		rh.setHobbyId(hobby.getId());
		rh.setRecoverId(interveneId);
		recoverHobbyService.save(rh);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", str);
		returnCode.put("hobby", hobby.toString());
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 保存应急计划
	 * @author dk
	 * @data 2016-11-7 
	 * @return String
	 * 
	 * **/
	@RequestMapping(value = "saveMeet")
	@ResponseBody
	public String saveMeet(String interveneId,Meet meet, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String str;
		if(StringUtils.isNotBlank(meet.getId())){
			str = "修改应急计划成功";
		}else{
			str = "添加应急计划成功";
		}
		meetService.save(meet);
		InterveneMeet im = new InterveneMeet();
		im.setInterveneId(interveneId);
		im.setMeetId(meet.getId());
		interveneMeetService.save(im);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", str);
		returnCode.put("meet", meet.toString());
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		interveneService.delete(id);
		addMessage(redirectAttributes, "删除干预方案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/intervene/?repage";
	}
	
	/**
	 * 删除兴趣爱好
	 * @author dk
	 * @data 2016-11-8 
	 * 
	 * */
	@RequestMapping(value = "deleteByHobbyId")
	@ResponseBody
	public String deleteByHobbyId(String hobbyId){
		hobbyService.deleteById(hobbyId);
		recoverHobbyService.deleteByHobbyId(hobbyId);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "删除兴趣爱好成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 删除应急计划
	 * @author dk
	 * @data 2016-11-8 
	 * 
	 * */
	@RequestMapping(value = "deleteByMeetId")
	@ResponseBody
	public String deleteByMeetId(String meetId){
		meetService.deleteById(meetId);
		interveneMeetService.deleteByMeetId(meetId);
		Map<String, String> returnCode = new HashMap<String,String>();
		returnCode.put("message", "删除应急计划成功");
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 构造岗位树结构
	 * @param extId
	 * @param response
	 * @return
	 * @author dk
	 */
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId,String parentId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Quarters> list;
		try {
			list = quartersService.findAllQuarters();
			for (int i=0; i<list.size(); i++){
				Quarters e = list.get(i);
				if (extId == null || (extId!=null && !extId.equals(e.getId()))){
					Map<String, Object> map = Maps.newHashMap();
					map.put("id", e.getId());
					map.put("pId", e.getDepartmentId());
					map.put("name", e.getName());
					mapList.add(map);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return mapList;
	}
	
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "itemNameTree")
	public List<Map<String, Object>> itemNameTree(@RequestParam(required=false) String extId,String parentId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<String> list;
			list = nutritionService.getItemNames();
			for (int i=0; i<list.size(); i++){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", list.get(i));
				map.put("pId", list.get(i));
				map.put("name", list.get(i));
				mapList.add(map);
			}
		return mapList;
	}
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "mealNumTree")
	public List<Map<String, Object>> mealNumTree(@RequestParam(required=false) String extId,String parentId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<String> list;
		list = nutritionService.getMealNums();
		for (int i=0; i<list.size(); i++){
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", list.get(i));
			map.put("pId", list.get(i));
			map.put("name", list.get(i));
			mapList.add(map);
		}
		return mapList;
	}
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "takeWayTree")
	public List<Map<String, Object>> takeWayTree(@RequestParam(required=false) String extId,String parentId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<String> list;
		list = nutritionService.getTakeWays();
		for (int i=0; i<list.size(); i++){
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", list.get(i));
			map.put("pId", list.get(i));
			map.put("name", list.get(i));
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * 构造医护人员树结构
	 * @param extId
	 * @param response
	 * @return
	 * @author dk
	 */
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeDataForEnum")
	public List<Map<String, Object>> treeDataForEnum(@RequestParam(required=false) String extId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		ArrangeList[] allArrange = ArrangeList.values();
		for (ArrangeList arr:allArrange){
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", arr.getValues());
			map.put("pId", 0);
			map.put("name", arr.getValues());
			mapList.add(map);
		}
		return mapList;
	}
}
