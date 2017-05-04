package com.elink.hospitalhealthnurse.modules.plan.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.utils.CookieUtils;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.utils.excel.ExportExcel;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Assessment;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Care;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Hobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Meet;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nurser;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nutrition;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Recover;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Social;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessmentService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.CareService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.FrequencysService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HobbyService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.MeetService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NurserService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.NutritionService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.RecoverService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.SocialService;
import com.elink.hospitalhealthnurse.modules.healtharchives.web.CareController;
import com.elink.hospitalhealthnurse.modules.plan.entity.PlanExecuteRecord;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanExecuteRecordService;
import com.elink.hospitalhealthnurse.modules.plan.service.ServiceUserRosterService;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.PlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ServiceUserPlanExeRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ServiceUserRosterVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.TodayTaskVO;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Department;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.ServiceUserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 计划执行记录Controller
 * @author 王宴萍
 * @version 2016-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/plan/planExecuteRecord")
public class PlanExecuteRecordController extends BaseController {

	@Autowired
	private PlanExecuteRecordService planExecuteRecordService;
	@Autowired
	private ServiceUserRosterService serviceUserRosterService;
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
	private HobbyService hobbyService;
	@Autowired
	private MeetService meetService;
	@Autowired
	private SocialService socialService;
	@Autowired
	private ServiceUserService serviceUserService;
	@Autowired
	private FrequencysService frequencysService;
	
	
	/***
	 * 查找人员计划
	 * @param ServiceUserExePlanRecordVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "serviceUserPlanList")
	public String serviceUserPlanList(ServiceUserPlanExeRecordVO serviceUserPlanExeRecordVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ServiceUserPlanExeRecordVO> page = planExecuteRecordService.findServiceUserPlanExeRecord(new Page<ServiceUserPlanExeRecordVO>(request, response),serviceUserPlanExeRecordVO); 
		model.addAttribute("page", page);
		return "modules/" + "plan/serviceUserPlanList";
	}
	@RequestMapping(value = {"elderPlanlist", ""})
	public String elderPlanlist(ElderPlanVO elderPlanVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ElderPlanVO> page = planExecuteRecordService.findTodayElderPlans(new Page<ElderPlanVO>(request, response),elderPlanVO); 
        model.addAttribute("page", page);
		return "modules/" + "plan/elderPlanList";
	}
	/***
	 * 服务人员执行计划执行记录详情
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "serviceUserPlanInfo")
	public String serviceUserPlanInfo(ServiceUserPlanExeRecordVO serviceUserExePlanRecordVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotBlank(serviceUserExePlanRecordVO.getServiceUserId())){
			serviceUserExePlanRecordVO=planExecuteRecordService.getVO(serviceUserExePlanRecordVO.getServiceUserId());
		}
		model.addAttribute("serviceUserExePlanRecordVO", serviceUserExePlanRecordVO);
		return "modules/" + "plan/serviceUserPlanListInfo";
	}
	/***
	 * 老人计划执行记录详情
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "elderPlanInfo")
	public String elderPlanInfo(ElderPlanVO elderPlanVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotBlank(elderPlanVO.getId())){
			elderPlanVO=planExecuteRecordService.findElderPlanVO(elderPlanVO.getId());
		}
		model.addAttribute("elderPlanVO", elderPlanVO);
		return "modules/" + "plan/elderPlanListInfo";
	}
	/***
	 * 老人今日计划的服务明细
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "todayElderPlans")
	public String todayElderPlans (String archivesId,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PlanExecuteRecordVO> page=planExecuteRecordService.findElderTodayExeRecordVO(new Page<PlanExecuteRecordVO>(request, response),archivesId);
		model.addAttribute("page", page);
		return "modules/" + "plan/elderTodayServices";
	}
	/***
	 * 老人历史计划的服务明细
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "historyElderPlans")
	public String historyElderPlans (String archivesId,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PlanExecuteRecordVO> page=planExecuteRecordService.findElderHisotyExeRecordVO(new Page<PlanExecuteRecordVO>(request, response),archivesId);
		model.addAttribute("page", page);
		return "modules/" + "plan/elderHistoryServices";
	}
	/***
	 * 服务人员正在执行的服务明细
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "serviceUserExeServices")
	public String serviceUserExeServices (String serviceUserId,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PlanExecuteRecordVO> page=planExecuteRecordService.findServiceUserPlanExeRecordVO(new Page<PlanExecuteRecordVO>(request, response),serviceUserId,ServiceUserPlanExeRecordVO.STATE_EXE);
		model.addAttribute("page", page);
		return "modules/" + "plan/serviceUserExeServices";
	}
	/***
	 * 服务人员已完成的服务明细
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "serviceUserCompletedServices")
	public String serviceUserCompletedServices (String serviceUserId,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PlanExecuteRecordVO> page=planExecuteRecordService.findServiceUserPlanExeRecordVO(new Page<PlanExecuteRecordVO>(request, response),serviceUserId,ServiceUserPlanExeRecordVO.STATE_FREE);
		model.addAttribute("page", page);
		return "modules/" + "plan/serviceUserCompletedServices";
	}
	
	/***
	 * 查询当日任务详情
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "todayTaskInfo")
	public String todayTaskInfo(TodayTaskVO todayTaskVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TodayTaskVO> page = serviceUserRosterService.findTodayTask(new Page<TodayTaskVO>(request, response),todayTaskVO); 
		model.addAttribute("departmentId", todayTaskVO.getDepartmentId());
		model.addAttribute("page", page);
		return "modules/" + "plan/todayTaskInfo";
	}
	@RequestMapping(value = "planStatChart")
	public String planStatChart(ElderPlanVO elderPlanVO, HttpServletRequest request, HttpServletResponse response, Model model) {
//        List<About> list = aboutService.find(about); 
        model.addAttribute("elderPlanVO", elderPlanVO);
		return "modules/" + "plan/planStatChart";
	}
	/***
	 * 当日科室任务执行记录清单
	 * @param departmentId 科室id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "departmentExePlanRecordList")
	public String departmentExePlanRecordList(String departmentId,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PlanExecuteRecordVO> page=planExecuteRecordService.findDepartmentTodayExePlans(new Page<PlanExecuteRecordVO>(request, response),departmentId);
		model.addAttribute("page", page);
		model.addAttribute("departmentId", departmentId);
		return "modules/" + "plan/taskInfoList";
	}
	/***
	 * 执行记录对应计划详情
	 * @param id 执行记录id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "planExeRecordInfo")
	public String planExeRecordInfo(String id,HttpServletRequest request, HttpServletResponse response, Model model) {
		PlanExecuteRecordVO planExecuteRecord=planExecuteRecordService.findByIdWs(id);
		if(planExecuteRecord.getId()!=null){
			model.addAttribute("planExecuteRecord", planExecuteRecord);
			String planId=planExecuteRecord.getPlanId();
			
			switch (planExecuteRecord.getPlanType()) {
				case PlanExecuteRecord.PLAN_TYPE_ASSESSMENT:
//					AssessmentVO assessmentVO=assessmentService.findByIdWs(planId);
//					model.addAttribute("assessmentVO", assessmentVO);
					Assessment assessment = assessmentService.get(planId);
					model.addAttribute("assessment", assessment);
					return "modules/" + "plan/assessmentPlanInfo";
				case PlanExecuteRecord.PLAN_TYPE_CARE:
//					CareVO careVO=careService.findByIdWs(planId);
//					model.addAttribute("careVO", careVO);
					Care care = careService.get(planId);
					care = getCare(care);
					model.addAttribute("care", care);
					return "modules/" + "plan/carePlanInfo";
				case PlanExecuteRecord.PLAN_TYPE_NURSE:
//					NurserVO nurserVO=nurserService.findByIdWs(planId);
//					model.addAttribute("nurserVO", nurserVO);
					Nurser nurser = nurserService.get(planId);
					nurser = getNurser(nurser);
					model.addAttribute("nurser", nurser);
					return "modules/" + "plan/nurserPlanInfo";
				case PlanExecuteRecord.PLAN_TYPE_NUTRITION:
//					Nutrition nutritionVO=nutritionService.findByIdWs(planId);
//					model.addAttribute("nutritionVO",nutritionVO);
					Nutrition nutrition = nutritionService.get(planId);
					model.addAttribute("nutrition", nutrition);
					return "modules/" + "plan/nutritionPlanInfo";
				case PlanExecuteRecord.PLAN_TYPE_RECOVER:
//					RecoverVO recoverVO=recoverService.findByIdWs(planId);
//					model.addAttribute("recoverVO",recoverVO);
					Recover recover = recoverService.get(planId);
					model.addAttribute("recover", recover);
					return "modules/" + "plan/recoverPlanInfo";
				case PlanExecuteRecord.PLAN_TYPE_SOCIAL_HOBBY:
					List<Hobby> hobbies=hobbyService.findByInterveneId(planExecuteRecord.getInterveneId());
					model.addAttribute("hobbies",hobbies);
					Social social = socialService.get(planId);
					social.setHobbyList(hobbies);
					model.addAttribute("social", social);
					return "modules/" + "plan/socialHobbyPlanInfo";
				case PlanExecuteRecord.PLAN_TYPE_MEET:
//					List<Meet> meets=meetService.findByInterveneId(planExecuteRecord.getInterveneId());
//					model.addAttribute("meets",meets);
					List<Meet> meetList = meetService.findByInterveneId(planExecuteRecord.getInterveneId());
					model.addAttribute("meetList",meetList);
					return "modules/" + "plan/meetPlanInfo";
				default:
					break;
			}
		}
		return "modules/" + "plan/taskInfoList";
	}
	/****
	 * 获取计划统计数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getPlanStatTrend")
	@ResponseBody
	public String  getPlanStatTrend(HttpServletRequest request,HttpServletResponse response) {
		String departmentId = request.getParameter("departmentId");
		String statType = request.getParameter("statType");		

		if(StringUtils.isNotBlank(statType)){
			CookieUtils.setCookie(response, "statType", statType);
		}else{
			statType = CookieUtils.getCookie(request, "statType");
		}		
		Map<String,Object[]>  returnCode = serviceUserRosterService.getPlanStatValue(departmentId,statType);
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	
	/**
	 * 老人执行项目明细
	 * @author 王宴萍
	 */
	@RequestMapping(value = "elderElderExportExcel", method=RequestMethod.GET)
    public String elderElderExportExcel(PlanExecuteRecordVO planExecuteRecordVO,HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String type=request.getParameter("type");
			String archivesId=request.getParameter("archivesId");
			String elderName=request.getParameter("elderName");
			Page<PlanExecuteRecordVO> pageM=new Page<PlanExecuteRecordVO>(request, response);
			pageM.setPageSize(10000);
			pageM.setPageNo(0);
			Page<PlanExecuteRecordVO> page=null;
			String fileName = "老人-"+elderName;
			if(type.equals("0")){
				fileName+="-今日计划";
				page=planExecuteRecordService.findElderTodayExeRecordVO(pageM,archivesId);
			}else{
				fileName+="-历史计划";
				page=planExecuteRecordService.findElderHisotyExeRecordVO(pageM,archivesId);
			}
			fileName+=DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx"; 
			String title ="计划数据";
			new ExportExcel().getElderPlanExeRecord(page.getList(), title,type).write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出数据失败！失败信息："+e.getMessage());
		}
		return null;
    }
	/**
	 * 服务人员服务明细
	 * @author 王宴萍
	 */
	@RequestMapping(value = "sericeUserExportExcel", method=RequestMethod.GET)
	public String sericeUserExportExcel(PlanExecuteRecordVO planExecuteRecordVO,HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String type=request.getParameter("type");
			String serviceUserId=request.getParameter("serviceUserId");
			String serviceUserName=request.getParameter("serviceUserName");
			Page<PlanExecuteRecordVO> pageM=new Page<PlanExecuteRecordVO>(request, response);
			pageM.setPageSize(10000);
			pageM.setPageNo(0);
			Page<PlanExecuteRecordVO> page=null;
			String fileName = "服务人员-"+serviceUserName;
			if(type.equals("0")){
				fileName+="-执行中";
				page=planExecuteRecordService.findServiceUserPlanExeRecordVO(pageM,serviceUserId,ServiceUserPlanExeRecordVO.STATE_EXE);
			}else{
				fileName+="-已完成";
				page=planExecuteRecordService.findServiceUserPlanExeRecordVO(pageM,serviceUserId,ServiceUserPlanExeRecordVO.STATE_FREE);
			}
			fileName+= fileName+"服务明细-"+DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx"; 
			String title ="服务明细";
			new ExportExcel().getServiceUserPlanExeRecord(page.getList(), title,type).write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出数据失败！失败信息："+e.getMessage());
		}
		return null;
	}
	/***
	 * 
	 * @param planExecuteRecord
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "form")
	public String form(PlanExecuteRecord planExecuteRecord, Model model) {
		planExecuteRecord=planExecuteRecordService.get(planExecuteRecord.getId());
		model.addAttribute("planExecuteRecord", planExecuteRecord);
		return "modules/" + "plan/planExecuteRecordForm";
	}
	/**
	 * 对历史计划的操作（为完成的确定完成，未执行的补充执行）
	 * @param response
	 * @return
	 * @throws Exception
	 * @author 王宴萍 2017-01-03
	 */
	@RequestMapping(value = "doPlan")
	@ResponseBody
	public String doPlan(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("application/json; charset=UTF-8");
		String id = request.getParameter("id");
		String startTime = request.getParameter("startTime");
		String stopTime = request.getParameter("stopTime");
		String jobNumber = request.getParameter("jobNumber");
		PlanExecuteRecord planExecuteRecord=planExecuteRecordService.get(id);
		Map<String, String> map = new HashMap<String,String>();
		if(planExecuteRecord!=null){
			String serviceUserId = serviceUserService.validateJobNumber(jobNumber,planExecuteRecord.getQuartersId());
			if(StringUtils.isBlank(serviceUserId)){
				map.put("message","当前执行岗位无此工号");
				return JsonMapper.getInstance().toJsonWs(map);
			}
			planExecuteRecord.setServiceUserId(serviceUserId);
			if(StringUtils.isNotBlank(startTime)){
				planExecuteRecord.setStartTime(DateUtils.getDateTimeByString(startTime+":00"));
			}
			if(StringUtils.isNotBlank(stopTime)){
				planExecuteRecord.setStopTime(DateUtils.getDateTimeByString(stopTime+":00"));
			}
			if(planExecuteRecord.getState().equals(PlanExecuteRecord.SERVICE_STATE_WAIT)){
				planExecuteRecord.setState(PlanExecuteRecord.EXECUTE_STATE_OVERDUE);
			}
			planExecuteRecordService.update(planExecuteRecord);
			ServiceUser serviceUser=serviceUserService.get(serviceUserId);
			
			map.put("message","操作成功");
			map.put("id",planExecuteRecord.getId());
			map.put("startTime",startTime);
			map.put("stopTime",stopTime);
			map.put("state",planExecuteRecord.getState());
			map.put("serviceUserName",serviceUser.getName());
			return JsonMapper.getInstance().toJsonWs(map);
		}
		map.put("message","没有该执行记录");
		return JsonMapper.getInstance().toJsonWs(map);
	}
	
	/**
	 * 获取护理计划频次详情
	 * */
	public Care getCare(Care care){
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
		return care;
	}
	
	/**
	 * 获取照护计划频次详情
	 * */
	public Nurser getNurser(Nurser nurser){
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
		return nurser;
	}
}
