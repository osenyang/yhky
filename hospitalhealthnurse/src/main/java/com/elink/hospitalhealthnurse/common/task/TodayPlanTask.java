package com.elink.hospitalhealthnurse.common.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.plan.entity.PlanExecuteRecord;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanExecuteRecordService;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanService;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanAssessmentVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanCareVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanSocialVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanMeetVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNurserVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNutritionVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanRecoverVO;

/***
 * 
 * 生成所有老人今日计划
 * @author yfy
 * @version 2015-11-22
 *
 */
@Component("todayPlanTask")
@Transactional(readOnly = true)
public class TodayPlanTask extends BaseService{
	
	@Autowired
	private PlanService planService;
	@Autowired
	private PlanExecuteRecordService planExecuteRecordService;
	
	/****
	 * 生成计划,每天凌晨0点执行一次
	 * @throws Exception 
	 */
//	@Scheduled(cron = "0 10 10 * * ? ")
	@Scheduled(cron = "0 0 1 * * ? ")
	@Transactional(readOnly = false)
	public void jobJudgeHandle() throws Exception  {		
		System.out.println("任务进行中。。。");
		//生成所有老人的计划
		handTodayPlan();
		
		System.out.println("任务结束。。。");
	}
	
	/***
	 * 生成所有老人的计划
	 * @return
	 * @throws Exception 
	 */
	@Transactional(readOnly = false)
	public void handTodayPlan() {
		List<ElderPlanExecuteRecordVO> list = planService.findElderIntervene();
		if(list != null && list.size() > 0){
			for(ElderPlanExecuteRecordVO plan : list){
				List<ElderPlanCareVO> elderPlanCareVOs = planService.findElderTodayCarePlans(plan.getArchivesId());
				List<ElderPlanNurserVO> elderPlanNurserVOs = planService.findElderTodayNurserPlans(plan.getArchivesId());
				List<ElderPlanRecoverVO> elderPlanRecoverVOs = planService.findElderTodayRecoverPlans(plan.getArchivesId());
				List<ElderPlanNutritionVO> elderPlanNutritionVOs = planService.findElderTodayNutritionPlans(plan.getArchivesId());
				List<ElderPlanSocialVO> elderPlanHobbyVOs = planService.findElderTodaySocialPlans(plan.getArchivesId());
				List<ElderPlanMeetVO> elderPlanMeetVOs = planService.findElderTodayMeetPlans(plan.getArchivesId());
				
				for(ElderPlanCareVO vo:elderPlanCareVOs){
					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_CARE)){
						planExecuteRecordService.savePlanExeRecordNew(vo);
					}
				}
				for(ElderPlanRecoverVO vo:elderPlanRecoverVOs){
					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_RECOVER)){
						planExecuteRecordService.savePlanExeRecord(vo);
					}
				}
				for(ElderPlanNutritionVO vo:elderPlanNutritionVOs){
					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_NUTRITION)){
						planExecuteRecordService.savePlanExeRecord(vo);
					}
				}
				for(ElderPlanSocialVO vo:elderPlanHobbyVOs){
					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_SOCIAL_HOBBY)){
						planExecuteRecordService.savePlanExeRecord(vo);
					}
				}
				for(ElderPlanMeetVO vo:elderPlanMeetVOs){
					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_MEET)){
						planExecuteRecordService.savePlanExeRecord(vo);
					}
				}
				for(ElderPlanNurserVO vo:elderPlanNurserVOs){
					if(!planExecuteRecordService.isGenTodayRecord(vo.getInterveneId(), vo.getId(),PlanExecuteRecord.PLAN_TYPE_NURSE)){
						planExecuteRecordService.savePlanExeRecordNew(vo);
					}
				}
				
			}
		}
	}


}
