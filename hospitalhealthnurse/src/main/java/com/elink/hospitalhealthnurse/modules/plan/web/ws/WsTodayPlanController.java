package com.elink.hospitalhealthnurse.modules.plan.web.ws;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimple;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimpleEx;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Assessment;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Care;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthArchives;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Hobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Meet;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nurser;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nutrition;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Recover;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Social;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessmentService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.CareService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthArchivesService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HobbyService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.MeetService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NurserService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NutritionService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.RecoverService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.SocialService;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.InterveneVO;
import com.elink.hospitalhealthnurse.modules.plan.entity.PlanExecuteRecord;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanExecuteRecordService;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanService;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanAssessmentVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanCareVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanMeetVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNurserVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNutritionVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanRecoverVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanSocialVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.WsPlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.ServiceUserService;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.google.common.collect.Maps;

/**
 * 进入计划Controller
 * @author 王宴萍
 * @version 2016-11-15 
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/todayPlan")
public class WsTodayPlanController {	
	@Autowired
	private HealthArchivesService healthArchivesService;
	@Autowired
	private SystemService systemService;
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
	private PlanService planService;
	@Autowired
	private PlanExecuteRecordService planExecuteRecordService;
	@Autowired
	private ServiceUserService serviceUserService;
	
	/**
	 * 根据archivesId获取老人今日计划
	 * @author 王宴萍
	 * @data 2016-11-15 
	 */
	@RequestMapping(value = "getElderTodayPlans",method=RequestMethod.GET)
	@ResponseBody
	public String getElderTodayPlans(String archivesId,WsPlanExecuteRecordVO planExecuteRecordVO,HttpServletRequest request ){
		List<WsPlanExecuteRecordVO> eRecordVOs=planExecuteRecordService.findTodayExePlans(archivesId);
		ReturnCodeEx<WsPlanExecuteRecordVO> returnCode = new ReturnCodeEx<WsPlanExecuteRecordVO>();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(eRecordVOs);
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
		Assessment ass = assessmentService.get(assessmentId);
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
		Care care = careService.get(careId);
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
		Nurser nurser = nurserService.get(nurserId);
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
		Nutrition nutrition = nutritionService.get(nutritionId);
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
		Recover recover = recoverService.get(recoverId);
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
	
	/**
	 * 执行计划
	 * @param id
	 * @param serviceUserId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "executionPlan",method=RequestMethod.POST)
	@ResponseBody
	public String executionPlan(String id,String jobNumber,String quartersId,HttpServletRequest request ){
		//验证当前岗位是否存在当前工号
		String serviceUserId = serviceUserService.validateJobNumber(jobNumber,quartersId);
		if(StringUtils.isBlank(serviceUserId)){
			return systemService.getErrReturnCode("当前执行岗位无此工号");
		}
		String state = PlanExecuteRecord.EXECUTE_STATE_ONTIME;
		PlanExecuteRecord plan = planExecuteRecordService.get(id);
		if(plan != null){
			if(plan.getExpectedStartTime().getTime() < (new Date()).getTime()){
				state = PlanExecuteRecord.EXECUTE_STATE_DELAY;
			}
		}
		String dateStr = planExecuteRecordService.executionPlan(id,serviceUserId,state);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(dateStr);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 结束执行计划
	 * @param id
	 * @param serviceUserId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "endExecutionPlan",method=RequestMethod.POST)
	@ResponseBody
	public String endExecutionPlan(String id,HttpServletRequest request ){
		planExecuteRecordService.endExecutionPlan(id);
		ReturnCodeSimple returnCode = new ReturnCodeSimple();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(null);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
//	/***
//	 * 
//	 * @param archivesId
//	 * @param planExecuteRecordVO
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "genTodayExeRecords",method=RequestMethod.GET)
//	@ResponseBody
//	public String genTodayExeRecords(WsPlanExecuteRecordVO planExecuteRecordVO,HttpServletRequest request ){
//		ReturnCodeEx<WsPlanExecuteRecordVO> returnCode = new ReturnCodeEx<WsPlanExecuteRecordVO>();
//		List<ElderPlanExecuteRecordVO> list = planService.findElderIntervene();
//		if(list != null && list.size() > 0){
//			for(ElderPlanExecuteRecordVO plan : list){
//				
//				List<ElderPlanAssessmentVO> elderPlanAssessmentVOs = planService.findElderTodayAssessmentPlans(plan.getArchivesId());
//				List<ElderPlanCareVO> elderPlanCareVOs = planService.findElderTodayCarePlans(plan.getArchivesId());
//				List<ElderPlanNurserVO> elderPlanNurserVOs = planService.findElderTodayNurserPlans(plan.getArchivesId());
//				List<ElderPlanRecoverVO> elderPlanRecoverVOs = planService.findElderTodayRecoverPlans(plan.getArchivesId());
//				List<ElderPlanNutritionVO> elderPlanNutritionVOs = planService.findElderTodayNutritionPlans(plan.getArchivesId());
//				List<ElderPlanSocialVO> elderPlanHobbyVOs = planService.findElderTodaySocialPlans(plan.getArchivesId());
//				List<ElderPlanMeetVO> elderPlanMeetVOs = planService.findElderTodayMeetPlans(plan.getArchivesId());
//				
//				for(ElderPlanAssessmentVO vo:elderPlanAssessmentVOs){
//					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_ASSESSMENT)){
//						planExecuteRecordService.savePlanExeRecord(vo);
//					}
//				}
//				for(ElderPlanCareVO vo:elderPlanCareVOs){
//					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_CARE)){
//						planExecuteRecordService.savePlanExeRecord(vo);
//					}
//				}
//				for(ElderPlanRecoverVO vo:elderPlanRecoverVOs){
//					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_RECOVER)){
//						planExecuteRecordService.savePlanExeRecord(vo);
//					}
//				}
//				for(ElderPlanNutritionVO vo:elderPlanNutritionVOs){
//					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_NUTRITION)){
//						planExecuteRecordService.savePlanExeRecord(vo);
//					}
//				}
//				for(ElderPlanSocialVO vo:elderPlanHobbyVOs){
//					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_SOCIAL_HOBBY)){
//						planExecuteRecordService.savePlanExeRecord(vo);
//					}
//				}
//				for(ElderPlanMeetVO vo:elderPlanMeetVOs){
//					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_MEET)){
//						planExecuteRecordService.savePlanExeRecord(vo);
//					}
//				}
//				for(ElderPlanNurserVO vo:elderPlanNurserVOs){
//					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_NURSE)){
//						planExecuteRecordService.savePlanExeRecord(vo);
//					}
//				}
//				
//			}
//		}
//		Map<String, Object> head = Maps.newHashMap();
//		head.put("ret", 0);
//		head.put("msg", "成功");	
//		returnCode.setHead(head);
//		return JsonMapper.getInstance().toJsonWs(returnCode);
//	}
	
}
