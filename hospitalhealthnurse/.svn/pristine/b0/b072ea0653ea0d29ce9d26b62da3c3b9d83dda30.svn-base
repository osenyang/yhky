package com.elink.hospitalhealthnurse.modules.healtharchives.web.ws;

import java.util.ArrayList;
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
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimple;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimpleEx;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthArchives;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Hobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Meet;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Social;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessmentService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.CareService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.FrequencysService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthArchivesService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HobbyService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.MeetService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NurserService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NutritionService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.RecoverService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.SocialService;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.AssessmentVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.CareVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthArchivesVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.InterveneVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.ItemVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.NurserVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.NutritionVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.RecoverVO;
import com.google.common.collect.Maps;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * 老人健康档案Controller
 * @author dk
 * @version 2016-10-14 
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/healthArchives")
public class WsHealthArchivesController {	
	@Autowired
	private HealthArchivesService healthArchivesService;
	
	@Autowired
	private InterveneService interveneService;
	
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
	private MeetService meetService;
	
	@Autowired
	private FrequencysService frequencysService;
	
	/**
	 * 根据USERID获取健康档案信息
	 * @author dk
	 * @data 2016-10-14 
	 */
	@RequestMapping(value = "getHealthArchives",method=RequestMethod.GET)
	@ResponseBody
	public String getHealthArchives(String userId,HttpServletRequest request ){
		List<HealthArchivesVO> list = healthArchivesService.findByUserId(userId);
		ReturnCodeEx<HealthArchivesVO> returnCode = new ReturnCodeEx<HealthArchivesVO>();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(list);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 修改健康档案
	 * @author dk
	 * @data 2016-10-14 
	 */
	@RequestMapping(value = "submitHealthArchives",method=RequestMethod.POST)
	@ResponseBody
	public String submitHealthArchives(HealthArchives healthArchives,HttpServletRequest request ){
		healthArchivesService.save(healthArchives);
		ReturnCodeSimpleEx returnCode = new ReturnCodeSimpleEx();
		Map<String, Object> head = Maps.newHashMap();

		head.put("ret", 0);
		head.put("msg", "修改档案成功");	
		returnCode.setHead(head);
		returnCode.setData(null);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	
	/**
	 * 查询最新的方案
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findInterveneByUserId",method=RequestMethod.POST)
	@ResponseBody
	public String findInterveneByUserId(String userId,HttpServletRequest request ){
		InterveneVO interveneVO = interveneService.findByArchivesId(userId);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(interveneVO);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 查询诊疗计划
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findAssessmentById")
	@ResponseBody
	public String findAssessmentById(String assessmentId,HttpServletRequest request ){
		AssessmentVO ass = assessmentService.findByIdWs(assessmentId);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(ass);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 查询护理计划
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findCareById")
	@ResponseBody
	public String findCareById(String careId,HttpServletRequest request ){
		CareVO care = careService.findByIdWs(careId);
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		//护理等级    
		if(StringUtils.isNotBlank(care.getNuserGrade()) && null != care.getNuserGradeTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(care.getNuserGradeNm());
			it.setServiceNm(care.getNuserGrade());
			it.setItemTime(sdf.format(care.getNuserGradeTime()));
			it.setQuartersNm(care.getNuserGradeQuartersNm());
			itemList.add(it);
		}
		//饮食护理  
		if(StringUtils.isNotBlank(care.getDeitNuser()) && null != care.getDeitNuserTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(care.getDeitNuserNm());
			it.setServiceNm(care.getDeitNuser());
			it.setItemTime(sdf.format(care.getDeitNuserTime()));
			it.setQuartersNm(care.getDeitNuserQuartersNm());
			itemList.add(it);
		}
		//静脉输液    
		if(StringUtils.isNotBlank(care.getVeinInfusion()) && null != care.getVeinInfusionTime()){
			Frequencys frequencys = frequencysService.get(care.getVeinInfusion());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getVeinInfusionNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getVeinInfusionTime()));
			it.setQuartersNm(care.getVeinInfusionQuartersNm());
			itemList.add(it);
		}
		//吸氧
		if(StringUtils.isNotBlank(care.getOxygen()) && null != care.getOxygenTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(care.getOxygenNm());
			it.setServiceNm(care.getOxygen());
			it.setItemTime(sdf.format(care.getOxygenTime()));
			it.setQuartersNm(care.getOxygenQuartersNm());
			itemList.add(it);
		}
		//更换湿化瓶
		if(StringUtils.isNotBlank(care.getReplaceWefFlask()) && null != care.getReplaceWefFlaskTime()){
			Frequencys frequencys = frequencysService.get(care.getReplaceWefFlask());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getReplaceWefFlaskNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getReplaceWefFlaskTime()));
			it.setQuartersNm(care.getReplaceWefFlaskQuartersNm());
			itemList.add(it);
		}
		//吸痰
		if(StringUtils.isNotBlank(care.getSputumSuction()) && null != care.getSputumSuctionTime()){
			Frequencys frequencys = frequencysService.get(care.getSputumSuction());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getSputumSuctionNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getSputumSuctionTime()));
			it.setQuartersNm(care.getSputumSuctionQuartersNm());
			itemList.add(it);
		}
		//雾化    
	 	if(StringUtils.isNotBlank(care.getAtomization()) && null != care.getAtomizationTime()){
	 		Frequencys frequencys = frequencysService.get(care.getAtomization());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getAtomizationNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getAtomizationTime()));
			it.setQuartersNm(care.getAtomizationQuartersNm());
			itemList.add(it);
		}
	 	//口腔护理    
	 	if(StringUtils.isNotBlank(care.getOralNuser()) && null != care.getOralNuserTime()){
	 		Frequencys frequencys = frequencysService.get(care.getOralNuser());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getOralNuserNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getOralNuserTime()));
			it.setQuartersNm(care.getOralNuserQuartersNm());
			itemList.add(it);
		}
	 	//尿管护理    
	 	if(StringUtils.isNotBlank(care.getUreterNuser()) && null != care.getUreterNuserTime()){
	 		Frequencys frequencys = frequencysService.get(care.getUreterNuser());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getUreterNuserNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getUreterNuserTime()));
			it.setQuartersNm(care.getUreterNuserQuartersNm());
			itemList.add(it);
		}
	 	//深静脉置管护理    
	 	if(StringUtils.isNotBlank(care.getDeepVein()) && null != care.getDeepVeinTime()){
	 		Frequencys frequencys = frequencysService.get(care.getDeepVein());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getDeepVeinNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getDeepVeinTime()));
			it.setQuartersNm(care.getDeepVeinQuartersNm());
			itemList.add(it);
		}
	 	//气管切开护理    
	 	if(StringUtils.isNotBlank(care.getTracheaNuser()) && null != care.getTracheaNuserTime()){
	 		Frequencys frequencys = frequencysService.get(care.getTracheaNuser());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getTracheaNuserNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getTracheaNuserTime()));
			it.setQuartersNm(care.getTracheaNuserQuartersNm());
			itemList.add(it);
		}
	 	//口服药    
	 	if(StringUtils.isNotBlank(care.getOralMedicine()) && null != care.getOralMedicineTime()){
	 		Frequencys frequencys = frequencysService.get(care.getOralMedicine());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getOralMedicineNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getOralMedicineTime()));
			it.setQuartersNm(care.getOralMedicineQuartersNm());
			itemList.add(it);
		}
	 	//中药    
	 	if(StringUtils.isNotBlank(care.getChineseMedicine()) && null != care.getChineseMedicineTime()){
	 		Frequencys frequencys = frequencysService.get(care.getChineseMedicine());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getChineseMedicineNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getChineseMedicineTime()));
			it.setQuartersNm(care.getChineseMedicineQuartersNm());
			itemList.add(it);
		}
	 	//特殊用药    
	 	if(StringUtils.isNotBlank(care.getSpecialMedicine()) && null != care.getSpecialMedicineTime()){
	 		Frequencys frequencys = frequencysService.get(care.getSpecialMedicine());
	 		ItemVO it = new ItemVO();
			it.setItemNm(care.getSpecialMedicineNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getSpecialMedicineTime()));
			it.setQuartersNm(care.getSpecialMedicineQuartersNm());
			itemList.add(it);
		}
	 	//康复护理    
	 	if(StringUtils.isNotBlank(care.getRecoveryNuser()) && null != care.getRecoveryNuserTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(care.getRecoveryNuserNm());
			it.setServiceNm(care.getRecoveryNuser());
			it.setItemTime(sdf.format(care.getRecoveryNuserTime()));
			it.setQuartersNm(care.getRecoveryNuserQuartersNm());
			itemList.add(it);
		}
	 	//营养餐    
	 	if(StringUtils.isNotBlank(care.getNutritionMeal()) && null != care.getNutritionMealTime()){
	 		Frequencys frequencys = frequencysService.get(care.getNutritionMeal());
			ItemVO it = new ItemVO();
			it.setItemNm(care.getNutritionMealNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(care.getNutritionMealTime()));
			it.setQuartersNm(care.getNutritionMealQuartersNm());
			itemList.add(it);
		}
	 	//健康教育    
	 	if(StringUtils.isNotBlank(care.getHealthEducation()) && null != care.getHealthEducationTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(care.getHealthEducationNm());
			it.setServiceNm(care.getHealthEducation());
			it.setItemTime(sdf.format(care.getHealthEducationTime()));
			it.setQuartersNm(care.getHealthEducationQuartersNm());
			itemList.add(it);
		}
	 	care.setItemList(itemList);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(care);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 查询照护计划
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findNurserById")
	@ResponseBody
	public String findNurserById(String nurserId,HttpServletRequest request ){
		NurserVO nurser = nurserService.findByIdWs(nurserId);
		
		SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		//照护级别    
		if(StringUtils.isNotBlank(nurser.getCareLevel()) && null != nurser.getCareLevelTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getCareLevelNm());
			it.setServiceNm(nurser.getCareLevel());
			it.setItemTime(sdf.format(nurser.getCareLevelTime()));
			it.setQuartersNm(nurser.getCareLevelQuartersNm());
			itemList.add(it);
		}
		//饮食护理
		if(StringUtils.isNotBlank(nurser.getDeitNuser()) && null != nurser.getDeitNuserTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getDeitNuserNm());
			it.setServiceNm(nurser.getDeitNuser());
			it.setItemTime(sdf.format(nurser.getDeitNuserTime()));
			it.setQuartersNm(nurser.getDeitNuserQuartersNm());
			itemList.add(it);
		}
		//介护口腔清洗
		if(StringUtils.isNotBlank(nurser.getCavityClean()) && null != nurser.getCavityCleanTime()){
			Frequencys frequencys = frequencysService.get(nurser.getCavityClean());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getCavityCleanNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getCavityCleanTime()));
			it.setQuartersNm(nurser.getCavityCleanQuartersNm());
			itemList.add(it);
		}
		//介护会阴冲洗  
		if(StringUtils.isNotBlank(nurser.getPerinealWash()) && null != nurser.getPerinealWashTime()){
			Frequencys frequencys = frequencysService.get(nurser.getPerinealWash());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getPerinealWashNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getPerinealWashTime()));
			it.setQuartersNm(nurser.getPerinealWashQuartersNm());
			itemList.add(it);
		}
		//介护洗澡    
		if(StringUtils.isNotBlank(nurser.getBathBath()) && null != nurser.getBathBathTime()){
			Frequencys frequencys = frequencysService.get(nurser.getBathBath());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getBathBathNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getBathBathTime()));
			it.setQuartersNm(nurser.getBathBathQuartersNm());
			itemList.add(it);
		}
		//介护洗头  
		if(StringUtils.isNotBlank(nurser.getWashHair()) && null != nurser.getWashHairTime()){
			Frequencys frequencys = frequencysService.get(nurser.getWashHair());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getWashHairNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getWashHairTime()));
			it.setQuartersNm(nurser.getWashHairQuartersNm());
			itemList.add(it);
		}
		//介护服药   
		if(StringUtils.isNotBlank(nurser.getOralMedicine()) && null != nurser.getOralMedicineTime()){
			Frequencys frequencys = frequencysService.get(nurser.getOralMedicine());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getOralMedicineNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getOralMedicineTime()));
			it.setQuartersNm(nurser.getOralMedicineQuartersNm());
			itemList.add(it);
		}
		//介护服中药  
		if(StringUtils.isNotBlank(nurser.getChineseMedicine()) && null != nurser.getChineseMedicineTime()){
			Frequencys frequencys = frequencysService.get(nurser.getChineseMedicine());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getChineseMedicineNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getChineseMedicineTime()));
			it.setQuartersNm(nurser.getChineseMedicineQuartersNm());
			itemList.add(it);
		}
		//翻身    
		if(StringUtils.isNotBlank(nurser.getTurnOver()) && null != nurser.getTurnOverTime()){
			Frequencys frequencys = frequencysService.get(nurser.getTurnOver());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getTurnOverNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getTurnOverTime()));
			it.setQuartersNm(nurser.getTurnOverQuartersNm());
			itemList.add(it);
		}
		//拍背   
		if(StringUtils.isNotBlank(nurser.getBackslap()) && null != nurser.getBackslapTime()){
			Frequencys frequencys = frequencysService.get(nurser.getBackslap());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getBackslapNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getBackslapTime()));
			it.setQuartersNm(nurser.getBackslapQuartersNm());
			itemList.add(it);
		}
		//皮肤观察     
		if(StringUtils.isNotBlank(nurser.getSkipWatch()) && null != nurser.getSkipWatchTime()){
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getSkipWatchNm());
			it.setServiceNm(nurser.getSkipWatch());
			it.setItemTime(sdf.format(nurser.getSkipWatchTime()));
			it.setQuartersNm(nurser.getSkipWatchQuartersNm());
			itemList.add(it);
		}
		//下腹部按摩   
		if(StringUtils.isNotBlank(nurser.getBellyMassage()) && null != nurser.getBellyMassageTime()){
			Frequencys frequencys = frequencysService.get(nurser.getBellyMassage());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getBellyMassageNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getBellyMassageTime()));
			it.setQuartersNm(nurser.getBellyMassageQuartersNm());
			itemList.add(it);
		}
		//饮水  
		if(StringUtils.isNotBlank(nurser.getDrinkWater()) && null != nurser.getDrinkWaterTime()){
			Frequencys frequencys = frequencysService.get(nurser.getDrinkWater());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getDrinkWaterNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getDrinkWaterTime()));
			it.setQuartersNm(nurser.getDrinkWaterQuartersNm());
			itemList.add(it);
		}
		//沟通   
		if(StringUtils.isNotBlank(nurser.getCommunicate()) && null != nurser.getCommunicateTime()){
			Frequencys frequencys = frequencysService.get(nurser.getCommunicate());
			ItemVO it = new ItemVO();
			it.setItemNm(nurser.getCommunicateNm());
			it.setServiceNm(frequencys.getDateArray());
			it.setItemTime(sdf.format(nurser.getCommunicateTime()));
			it.setQuartersNm(nurser.getCommunicateQuartersNm());
			itemList.add(it);
		}
		nurser.setCarePlanList(itemList);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(nurser);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 查询营养计划
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findNutritionById")
	@ResponseBody
	public String findNutritionById(String nutritionId,HttpServletRequest request ){
		NutritionVO nutrition = nutritionService.findByIdWs(nutritionId);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(nutrition);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 查询康复计划
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findRecoverById")
	@ResponseBody
	public String findRecoverById(String recoverId,HttpServletRequest request ){
		RecoverVO recover = recoverService.findByIdWs(recoverId);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(recover);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}

	/**
	 * 查询社工计划
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findSocialById")
	@ResponseBody
	public String findSocialById(String socialId,String interveneId,HttpServletRequest request ){
		Social social = socialService.get(socialId);
		List<Hobby> hobbyList = hobbyService.findByInterveneId(interveneId);
		if(hobbyList != null && hobbyList.size() > 0){
			social.setHobbyList(hobbyList);
		}
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(social);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	

	/**
	 * 查询应急计划
	 * @author dk
	 * @data 2016-11-8 
	 * */
	@RequestMapping(value = "findMeetById")
	@ResponseBody
	public String findMeetById(String interveneId,HttpServletRequest request ){
		List<Meet> meetList = meetService.findByInterveneId(interveneId);
		ReturnCodeEx<Meet> returnCode = new ReturnCodeEx<Meet>();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(meetList);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	/****
	 * 查询所有老人姓名和身份证号码
	 * @param request
	 * @param response
	 * @return
	 */	
	@RequestMapping(value = "findAllFull")
	@ResponseBody
	public String findAllFull(HttpServletRequest request, HttpServletResponse response){
		List<HealthArchives> list = healthArchivesService.findAllFull();
		ReturnCodeEx<HealthArchives> returnCode = new ReturnCodeEx<HealthArchives>();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(list);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
}
