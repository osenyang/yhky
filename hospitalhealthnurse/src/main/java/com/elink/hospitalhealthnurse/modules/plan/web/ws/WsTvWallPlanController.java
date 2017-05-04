package com.elink.hospitalhealthnurse.modules.plan.web.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeEx;
import com.elink.hospitalhealthnurse.modules.plan.entity.PlanExecuteRecord;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanExecuteRecordService;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanService;
import com.elink.hospitalhealthnurse.modules.plan.service.TvWallPlanService;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.TvWallPlanExecuteVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.TvWallPlanRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.WsElderPlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.WsPlanExecuteRecordVO;
import com.google.common.collect.Maps;

/**
 * 进入计划Controller
 * @author yfy
 * @version 2016-11-21 
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/tvWallPlan")
public class WsTvWallPlanController {	
	@Autowired
	private TvWallPlanService tvWallPlanService;
	@Autowired
	private PlanService planService;
	@Autowired
	private PlanExecuteRecordService planExecuteRecordService;
	/**
	 * 电视墙老人计划
	 * @author yfy
	 * @data 2016-11-21
	 * */
	@RequestMapping(value = "findTodayPlanByPlanType",method=RequestMethod.GET)
	@ResponseBody
	public String findTodayPlanByPlanType(String planType, HttpServletRequest request){
		List<TvWallPlanRecordVO> list = tvWallPlanService.findTodayPlanByPlanType(planType);
		if(list != null && list.size() > 0){
			for(TvWallPlanRecordVO vo : list){
				if(StringUtils.isNotBlank(vo.getArchivesId())){
					List<TvWallPlanExecuteVO> planList = tvWallPlanService.findTodayPlanByArchivesId(vo.getArchivesId(),planType);
					if(planList != null && planList.size() > 0){
						for(TvWallPlanExecuteVO plan : planList){
							if(StringUtils.isNotBlank(plan.getExpectedStartTime())){
								//开始时间不等于空为执行中,判断结束时间
								if(StringUtils.isNotBlank(plan.getStartTime())){
									if(StringUtils.isNotBlank(plan.getStopTime())){
										plan.setState(PlanExecuteRecord.DEAL_STATE_AUDIT);
									}else{
										plan.setState(PlanExecuteRecord.DEAL_STATE_DELETE);
									}
									plan.setProjectStr(plan.getProjectName()+"("+plan.getServiceUserName()+")");
								}else{
									plan.setState(PlanExecuteRecord.DEAL_STATE_NORMAL);
									plan.setProjectStr(plan.getProjectName()+"("+plan.getQuartersName()+")");
								} 
								String expectedStartTime = plan.getExpectedStartTime().substring(0, plan.getExpectedStartTime().indexOf(":"));
								int expectTime = Integer.parseInt(expectedStartTime);
								if(expectTime == 1){
									vo.getDate1().add(plan);
								}else if(expectTime == 2){
									vo.getDate2().add(plan);
								}else if(expectTime == 3){
									vo.getDate3().add(plan);
								}else if(expectTime == 4){
									vo.getDate4().add(plan);
								}else if(expectTime == 5){
									vo.getDate5().add(plan);
								}else if(expectTime == 6){
									vo.getDate6().add(plan);
								}else if(expectTime == 7){
									vo.getDate7().add(plan);
								}else if(expectTime == 8){
									vo.getDate8().add(plan);
								}else if(expectTime == 9){
									vo.getDate9().add(plan);
								}else if(expectTime == 10){
									vo.getDate10().add(plan);
								}else if(expectTime == 11){
									vo.getDate11().add(plan);
								}else if(expectTime == 12){
									vo.getDate12().add(plan);
								}else if(expectTime == 13){
									vo.getDate13().add(plan);
								}else if(expectTime == 14){
									vo.getDate14().add(plan);
								}else if(expectTime == 15){
									vo.getDate15().add(plan);
								}else if(expectTime == 16){
									vo.getDate16().add(plan);
								}else if(expectTime == 17){
									vo.getDate17().add(plan);
								}else if(expectTime == 18){
									vo.getDate18().add(plan);
								}else if(expectTime == 19){
									vo.getDate19().add(plan);
								}else if(expectTime == 20){
									vo.getDate20().add(plan);
								}else if(expectTime == 21){
									vo.getDate21().add(plan);
								}else if(expectTime == 22){
									vo.getDate22().add(plan);
								}else if(expectTime == 23){
									vo.getDate23().add(plan);
								}else{
									vo.getDate0().add(plan);
								}
							}
						}
					}
				}
			}
		}
		ReturnCodeEx<TvWallPlanRecordVO> returnCode = new ReturnCodeEx<TvWallPlanRecordVO>();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");
		head.put("dateTime", DateUtils.getDate("HH"));
		returnCode.setHead(head);
		returnCode.setData(list);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
	/**
	 * 根据机构获取老人今日计划
	 * @author 王宴萍
	 * @data 2016-11-15 
	 */
	@RequestMapping(value = "getTodayPlans",method=RequestMethod.GET)
	@ResponseBody
	public String getTodayPlans(WsPlanExecuteRecordVO planExecuteRecordVO,String inpatientId,HttpServletRequest request ){
		List<ElderPlanExecuteRecordVO> elderPlanExecuteRecordVOs = planService.findElderInterveneWs(inpatientId);
		for (ElderPlanExecuteRecordVO vo : elderPlanExecuteRecordVOs) {
			List<WsElderPlanExecuteRecordVO> wsElderPlanExecuteRecordVOs = planExecuteRecordService.findElderInfoAndExePlansAfterOne(vo.getArchivesId());
			vo.setPlanExecuteRecordVOs(wsElderPlanExecuteRecordVOs);
			boolean haveCareUnExe=planExecuteRecordService.haveUnExeRecordToday(vo.getId(), PlanExecuteRecord.PLAN_TYPE_CARE);
			boolean haveNurseUnExe=planExecuteRecordService.haveUnExeRecordToday(vo.getId(), PlanExecuteRecord.PLAN_TYPE_NURSE);
			boolean haveRecoverUnExe=planExecuteRecordService.haveUnExeRecordToday(vo.getId(),PlanExecuteRecord.PLAN_TYPE_RECOVER);
			boolean haveNutritionUnExe=planExecuteRecordService.haveUnExeRecordToday(vo.getId(),PlanExecuteRecord.PLAN_TYPE_NUTRITION);
			boolean haveHobbyUnExe=planExecuteRecordService.haveUnExeRecordToday(vo.getId(),PlanExecuteRecord.PLAN_TYPE_SOCIAL_HOBBY);
			vo.setCareHaveUnExe(haveCareUnExe);
			vo.setNurseHaveUnExe(haveNurseUnExe);
			vo.setRecoverHaveUnExe(haveRecoverUnExe);
			vo.setNutritionHaveUnExe(haveNutritionUnExe);
			vo.setHobbyHaveUnExe(haveHobbyUnExe);
		}
//		List<WsElderPlanExecuteRecordVO> returnVos=new ArrayList<WsElderPlanExecuteRecordVO>();
//		String preArchivesIdString="";
//		for(WsElderPlanExecuteRecordVO elderPlanExecuteRecordVO:elderPlanExecuteRecordVOs){
//			if(!elderPlanExecuteRecordVO.getArchivesId().equals(preArchivesIdString)){
//				preArchivesIdString=elderPlanExecuteRecordVO.getArchivesId();
//				returnVos.add(elderPlanExecuteRecordVO);
//			}
//			WsElderPlanExecuteRecordVO returnVo=returnVos.get(returnVos.size()-1);
//			boolean haveUnExe=planExecuteRecordService.haveUnExeRecordToday(elderPlanExecuteRecordVO.getId(), elderPlanExecuteRecordVO.getPlanType());
//			switch (elderPlanExecuteRecordVO.getPlanType()) {
//				case PlanExecuteRecord.PLAN_TYPE_CARE:
//					returnVo.setCareProject(elderPlanExecuteRecordVO.getProjectName());
//					returnVo.setCareTime(elderPlanExecuteRecordVO.getExpectedStartTime());
//					returnVo.setCareHaveUnExe(haveUnExe);
//					break;
//				case PlanExecuteRecord.PLAN_TYPE_NURSE:
//					returnVo.setNurseProject(elderPlanExecuteRecordVO.getProjectName());
//					returnVo.setNurseTime(elderPlanExecuteRecordVO.getExpectedStartTime());
//					returnVo.setNurseHaveUnExe(haveUnExe);
//					break;
//				case PlanExecuteRecord.PLAN_TYPE_RECOVER:
//					returnVo.setRecoverProject(elderPlanExecuteRecordVO.getProjectName());
//					returnVo.setRecoverTime(elderPlanExecuteRecordVO.getExpectedStartTime());
//					returnVo.setRecoverHaveUnExe(haveUnExe);
//					break;
//				case PlanExecuteRecord.PLAN_TYPE_NUTRITION:
//					returnVo.setNutritionProject(elderPlanExecuteRecordVO.getProjectName());
//					returnVo.setNutritionTime(elderPlanExecuteRecordVO.getExpectedStartTime());
//					returnVo.setNutritionHaveUnExe(haveUnExe);
//					break;
//				case PlanExecuteRecord.PLAN_TYPE_SOCIAL_HOBBY:
//					returnVo.setHobbyProject(elderPlanExecuteRecordVO.getProjectName());
//					returnVo.setHobbyTime(elderPlanExecuteRecordVO.getExpectedStartTime());
//					returnVo.setHobbyHaveUnExe(haveUnExe);
//					break;
//				default:
//					break;
//			}
//			elderPlanExecuteRecordVO.setProjectName(null);//多余的项不需要返回
//			elderPlanExecuteRecordVO.setExpectedStartTime(null);
//			elderPlanExecuteRecordVO.setQuartersName(null);
//			elderPlanExecuteRecordVO.setPlanId(null);
//			elderPlanExecuteRecordVO.setPlanType(null);
//		}
		ReturnCodeEx<ElderPlanExecuteRecordVO> returnCode = new ReturnCodeEx<ElderPlanExecuteRecordVO>();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 0);
		head.put("msg", "成功");	
		returnCode.setHead(head);
		returnCode.setData(elderPlanExecuteRecordVOs);
		return JsonMapper.getInstance().toJsonWs(returnCode);
	}
	
}