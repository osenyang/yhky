package com.elink.hospitalhealthnurse.modules.plan.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthArchives;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Hobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.ArrangeEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareActivityIntolerance;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareAnxiety;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareConstipation;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareDeitNuser;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareFallRisk;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareHealthEducation;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareIncontinence;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareIntervalTime;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareLanguageBalk;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareMenu;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareNuserGrade;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareOxygen;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CarePain;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CarePotentialAsphyxia;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CarePotentialBleeding;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CarePotentialInfection;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareRecoveryNuser;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareRespiratoryTract;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareSleepDisorder;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareTemperatureOvertop;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.CareUlcerRisk;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanAstrictionEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanCareEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanDecreasedLivingAbiliEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanDietEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanLevelEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanLonelinessAnxietyEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanPotentialComplicationsEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanRiskSkinIntegrityEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanSkinObservationEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanTurnOverEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanWalkingTrainingEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.enumlist.EnumList.NurserPanWashHairEnum;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.FrequencysService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HobbyService;
import com.elink.hospitalhealthnurse.modules.plan.dao.PlanExecuteRecordDao;
import com.elink.hospitalhealthnurse.modules.plan.entity.PlanExecuteRecord;
import com.elink.hospitalhealthnurse.modules.plan.utils.PlanProjectTypeEnum;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanAssessmentVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanCareVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanSocialVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanMeetVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNurserVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNutritionVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanRecoverVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.PlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ServiceUserPlanExeRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.WsElderPlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.WsPlanExecuteRecordVO;

/**
 * 计划执行记录Service
 * @author 王宴萍
 * @version 2016-10-11
 */
@Component
@Transactional(readOnly = true)
public class PlanExecuteRecordService extends BaseService {
	

	@Autowired
	private PlanExecuteRecordDao planExecuteRecordDao;
	@Autowired
	private PlanService planService;
	@Autowired
	private HobbyService hobbyService;
	@Autowired
	private FrequencysService frequencysService;
	
	public PlanExecuteRecord get(String id) {
		return planExecuteRecordDao.get(id);
	}
	
	@Transactional(readOnly = false)
	public void save(PlanExecuteRecord planExecuteRecord) {
		planExecuteRecordDao.save(planExecuteRecord);
	}
	@Transactional(readOnly = false)
	public void update(PlanExecuteRecord planExecuteRecord) {
		planExecuteRecordDao.save(planExecuteRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		planExecuteRecordDao.delete(id);
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	public PlanExecuteRecordVO findByIdWs(String id){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.*,t2.`name` service_user_name,t3.`name` quarters_name,t6.bed_number,t6.full_nm elder_name,t6.photo,t4.name department_name  FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id=t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id=t3.id ");
		sb.append(" left JOIN sys_department t4 on t3.department_id=t4.id ");
		sb.append(" left join hn_intervene t5 on t5.id=t1.intervene_id ");
		sb.append(" left join hn_health_archives t6 on t6.id=t5.archives_id ");
		sb.append(" WHERE t1.id = '"+id+"'");
		List<PlanExecuteRecordVO> careList = planExecuteRecordDao.findBySqlExt(sb.toString(), null, PlanExecuteRecordVO.class);
		if(careList != null && careList.size() > 0){
			return careList.get(0);
		}
		return new PlanExecuteRecordVO();
	}
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	public List<PlanExecuteRecordVO> findListByIdWs(String id){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.*,t2.`name` service_user_name,t3.`name` quarters_name  FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id=t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id=t3.id ");
		sb.append(" WHERE t1.id = '"+id+"'");
		return planExecuteRecordDao.findBySqlExt(sb.toString(), null, PlanExecuteRecordVO.class);
	}
	/***
	 * 查询机构的所有老人的信息和执行记录统计
	 * @param id
	 * @return
	 */
	public Page<ElderPlanVO> findTodayElderPlans(Page<ElderPlanVO> page,ElderPlanVO elderPlanVO){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.id archives_id,t1.full_nm elder_name,t1.sex,t1.birth_date,t1.photo,t1.hospitalization_number,t4.area_nm inpatient_nm, ");
		sb.append(" t1.state,t1.id,sum(if(t3.stop_time is not NULL,1,0)) completed_count, ");
		sb.append(" sum(if(t3.stop_time is NULL and t3.expected_start_time < now() and t3.state = '0' or t3.state = '3',1,0)) expired_service_count, ");
		sb.append(" sum(if(t3.stop_time is NULL and t3.expected_start_time < now() and t3.state = '1',1,0)) not_expired_count, ");
		sb.append(" COUNT(t3.id) total_count,(COUNT(t3.id)-sum(if(t3.stop_time is not NULL,1,0))) exe_count ");
		sb.append("  FROM hn_health_archives t1 ");
		sb.append(" JOIN hn_intervene t2 on t2.archives_id=t1.id ");
		sb.append(" LEFT JOIN hn_plan_execute_record t3 ON t3.intervene_id=t2.id ");
		sb.append("	LEFT JOIN hn_health_inpatient t4 ON t1.inpatient_id = t4.id");
		sb.append(" WHERE 1=1 and t1.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(elderPlanVO.getElderName())){
			sb.append("  and t1.full_nm like '%"+elderPlanVO.getElderName()+"%'");
		}
		if(StringUtils.isNotBlank(elderPlanVO.getHospitalizationNumber())){
			sb.append("  and t1.hospitalization_number like '%"+elderPlanVO.getHospitalizationNumber()+"%'");
		}
		if(StringUtils.isNotBlank(elderPlanVO.getInpatientNm())){
			sb.append("  and t4.area_nm like '%"+elderPlanVO.getInpatientNm()+"%'");
		}
		sb.append(" GROUP BY t1.id");
		return planExecuteRecordDao.findBySqlExt(page,sb.toString(),ElderPlanVO.class);
	}
	/***
	 * 查询机构的所有老人的信息和执行记录统计
	 * @param id
	 * @return
	 */
	public ElderPlanVO findElderPlanVO(String id){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.id archives_id,t1.full_nm elder_name,t1.sex,t1.birth_date,t1.hospitalization_number,t1.photo, ");
		sb.append(" t1.state,t1.id,sum(if(t3.stop_time is not NULL,1,0)) completed_count, ");
		sb.append(" COUNT(t3.id) total_count,(COUNT(t3.id)-sum(if(t3.stop_time is not NULL,1,0))) exe_count ");
		sb.append("  FROM hn_health_archives t1 ");
		sb.append(" JOIN hn_intervene t2 on t2.archives_id=t1.id ");
		sb.append(" LEFT JOIN hn_plan_execute_record t3 ON t3.intervene_id=t2.id ");
		sb.append(" WHERE t1.id = '"+id+"' and t1.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"'");
		List<ElderPlanVO> list=planExecuteRecordDao.findBySqlExt(sb.toString(), null, ElderPlanVO.class);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/***
	 * 查询服务人员执行计划记录VO
	 * @param page
	 * @param serviceUserExePlanVO
	 * @return
	 */
	public Page<ServiceUserPlanExeRecordVO> findServiceUserPlanExeRecord(Page<ServiceUserPlanExeRecordVO> page,ServiceUserPlanExeRecordVO serviceUserExePlanRecordVO) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.thumb_img,t1.img_url,t1.office_id,t1.id service_user_id,t1.name service_user_name,");
		sb.append(" t1.department_id,t3.name department_name,t1.quarters_id,t4.`name` quarters_name,");
		sb.append(" sum(if(t2.stop_time is not NULL,1,0)) completed_count,COUNT(t2.id) record_count,");
		sb.append(" (COUNT(t2.id)-sum(if(t2.stop_time is not NULL,1,0))) exe_count");
		sb.append(" FROM sys_service_user t1");
		sb.append(" LEFT JOIN hn_plan_execute_record t2 ON t1.id=t2.service_user_id ");
		sb.append(" LEFT JOIN sys_department t3 ON t3.id=t1.department_id ");
		sb.append(" LEFT JOIN sys_quarters t4 ON t4.id=t1.quarters_id ");
		sb.append(" WHERE t1.del_flag='"+PlanExecuteRecord.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(serviceUserExePlanRecordVO.getDepartmentId())){
			sb.append(" AND (t3.id = '"+serviceUserExePlanRecordVO.getDepartmentId()+"' or t3.parent_id = '"+serviceUserExePlanRecordVO.getDepartmentId()+"')");
		}
		if(StringUtils.isNotBlank(serviceUserExePlanRecordVO.getServiceUserName())){
			sb.append(" AND t1.name like '%"+serviceUserExePlanRecordVO.getServiceUserName()+"%'");
		}
		sb.append(" GROUP BY t1.id ");	
		if(StringUtils.isNotBlank(serviceUserExePlanRecordVO.getState())){
			if(serviceUserExePlanRecordVO.getState().equals(ServiceUserPlanExeRecordVO.STATE_FREE)){
				sb.append("  HAVING exe_count = 0");
			}else if(serviceUserExePlanRecordVO.getState().equals(ServiceUserPlanExeRecordVO.STATE_EXE)){
				sb.append(" HAVING exe_count > 0");
			}
		}
		sb.append(" ORDER BY exe_count desc ");	
		return planExecuteRecordDao.findBySqlExt(page, sb.toString(), ServiceUserPlanExeRecordVO.class);
	}
	/***
	 * 查询服务人员执行计划记录信息VO
	 * @param serviceUserId 服务人员id
	 * @param exeState 执行状态：0，已完成，1，正在执行
	 * @return
	 */
	public Page<PlanExecuteRecordVO> findServiceUserPlanExeRecordVO(Page<PlanExecuteRecordVO> page,String serviceUserId,String exeState) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.archives_id,t3.full_nm elder_name,t1.project_name,t1.project_sub_name,t3.bed_number, ");
		sb.append(" t1.expected_start_time,t1.start_time,t1.stop_time,t1.state,t1.id FROM hn_plan_execute_record t1 ");
		sb.append(" JOIN hn_intervene t2 on t2.id=t1.intervene_id");
		sb.append(" LEFT JOIN hn_health_archives t3 ON t3.id=t2.archives_id ");
		sb.append(" WHERE t1.service_user_id = '"+serviceUserId+"' ");
		if(exeState.equals(ServiceUserPlanExeRecordVO.STATE_FREE)){
			sb.append("  and t1.stop_time is not null");
		}else if(exeState.equals(ServiceUserPlanExeRecordVO.STATE_EXE)){
			sb.append("  and t1.stop_time is null");
		}
		return planExecuteRecordDao.findBySqlExt(page,sb.toString(),PlanExecuteRecordVO.class);
	}
	/***
	 * 查询老人执行计划记录信息VO
	 * @param serviceUserId 服务人员id
	 * @param exeState 执行状态：0，已完成，1，正在执行
	 * @return
	 */
	public Page<PlanExecuteRecordVO> findElderTodayExeRecordVO(Page<PlanExecuteRecordVO> page,String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.plan_type,t2.archives_id,t3.full_nm elder_name,t1.project_name,t1.project_sub_name,t3.bed_number,t4.name quarters_name, ");
		sb.append(" t1.expected_start_time,t1.start_time,t1.stop_time,t1.state,t1.id,t5.`name` service_user_name FROM hn_plan_execute_record t1 ");
		sb.append(" JOIN hn_intervene t2 on t2.id=t1.intervene_id");
		sb.append(" LEFT JOIN hn_health_archives t3 ON t3.id=t2.archives_id ");
		sb.append(" LEFT JOIN sys_quarters t4 ON t4.id=t1.quarters_id ");
		sb.append(" LEFT JOIN sys_service_user t5 ON t5.id=t1.service_user_id ");
		sb.append(" WHERE t3.id = '"+archivesId+"' ");
		sb.append(" and (DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
		sb.append(" or DATE_FORMAT(t1.start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d'))");
		sb.append(" order by t1.start_time asc,t1.expected_start_time asc");
		return planExecuteRecordDao.findBySqlExt(page,sb.toString(),PlanExecuteRecordVO.class);
	}
	/***
	 * 查询老人历史执行计划记录信息VO
	 * @param serviceUserId 服务人员id
	 * @param exeState 执行状态：0，已完成，1，正在执行
	 * @return
	 */
	public Page<PlanExecuteRecordVO> findElderHisotyExeRecordVO(Page<PlanExecuteRecordVO> page,String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.plan_type,t2.archives_id,t3.full_nm elder_name,t1.project_name,t1.project_sub_name,t3.bed_number, ");
		sb.append(" t1.expected_start_time,t1.start_time,t1.stop_time,t1.state,t1.id FROM hn_plan_execute_record t1 ");
		sb.append(" JOIN hn_intervene t2 on t2.id=t1.intervene_id");
		sb.append(" LEFT JOIN hn_health_archives t3 ON t3.id=t2.archives_id ");
		sb.append(" WHERE t3.id = '"+archivesId+"' ");
		sb.append(" and (DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') < DATE_FORMAT(SYSDATE(), '%Y-%m-%d'))");
//		sb.append(" and t1.start_time is not null)");
		sb.append(" order by t1.start_time desc,t1.expected_start_time desc");
		return planExecuteRecordDao.findBySqlExt(page,sb.toString(),PlanExecuteRecordVO.class);
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	public ServiceUserPlanExeRecordVO getVO(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.thumb_img,t1.img_url,t1.office_id,t1.id service_user_id,t1.name service_user_name,");
		sb.append(" t1.department_id,t3.name department_name,t1.quarters_id,t4.`name` quarters_name,");
		sb.append(" sum(if(t2.stop_time is not NULL,1,0)) completed_count,COUNT(t2.id) record_count,");
		sb.append(" (COUNT(t2.id)-sum(if(t2.stop_time is not NULL,1,0))) exe_count");
		sb.append(" FROM sys_service_user t1");
		sb.append(" LEFT JOIN hn_plan_execute_record t2 ON t1.id=t2.service_user_id ");
		sb.append(" LEFT JOIN sys_department t3 ON t3.id=t1.department_id ");
		sb.append(" LEFT JOIN sys_quarters t4 ON t4.id=t1.quarters_id ");
		sb.append(" WHERE t1.id = '"+id+"' ");
		List<ServiceUserPlanExeRecordVO> list=planExecuteRecordDao.findBySqlExt(sb.toString(), null, ServiceUserPlanExeRecordVO.class);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/***
	 * 查询某个科室当日的任务清单
	 * @return
	 */
	public Page<PlanExecuteRecordVO> findDepartmentTodayExePlans(Page<PlanExecuteRecordVO> page,String departmentId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.*,t2.`name` service_user_name,t3.`name` quarters_name,t6.bed_number,t6.full_nm elder_name  FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id=t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id=t3.id ");
		sb.append(" left JOIN sys_department t4 on t3.department_id=t4.id ");
		sb.append(" left join hn_intervene t5 on t5.id=t1.intervene_id ");
		sb.append(" left join hn_health_archives t6 on t6.id=t5.archives_id ");
		sb.append(" WHERE t4.id = '"+departmentId+"'");
		sb.append(" and (DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
		sb.append(" or DATE_FORMAT(t1.start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d'))");
		sb.append(" order by t1.start_time asc,t1.expected_start_time asc");
		return planExecuteRecordDao.findBySqlExt(page, sb.toString(), PlanExecuteRecordVO.class);
	}
	/***
	 * 查询老人今日需要执行的计划
	 * @return
	 */
	public List<WsPlanExecuteRecordVO> findTodayExePlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.*,t2.`name` service_user_name,t3.`name` quarters_name  FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id=t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id=t3.id ");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"'");
		sb.append(" and (DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
		sb.append(" or DATE_FORMAT(t1.start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d'))");
		sb.append(" order by t1.start_time asc,t1.expected_start_time asc");
		return planExecuteRecordDao.findBySqlExt(sb.toString(),null,WsPlanExecuteRecordVO.class);
	}
	/***
	 * 查询老人今日需要执行的计划(少数据)
	 * @return
	 */
	public List<WsPlanExecuteRecordVO> findElderTodayExePlansBySimple(String archivesId) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.id,t1.project_name,t1.project_sub_name,t1.plan_type,t1.expected_start_time");
		sb.append(" ,t1.start_time,t1.state,t1.other_time,t2.`name` service_user_name,t3.`name` quarters_name  FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id=t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id=t3.id ");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"'");
		sb.append(" and (DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
		sb.append(" or DATE_FORMAT(t1.start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d'))");
		sb.append(" order by t1.start_time asc,t1.expected_start_time asc");
		return planExecuteRecordDao.findBySqlExt(sb.toString(),null,WsPlanExecuteRecordVO.class);
	}
	/***
	 * 查询老人在当前时间之后要执行的记录最近的一条
	 * @return
	 */
	public WsPlanExecuteRecordVO findElderTodayExePlansAfterOne(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.id,t1.project_name,t1.plan_type,t1.expected_start_time");
		sb.append(" ,t1.start_time,t1.state,t1.other_time,t2.`name` service_user_name,t3.`name` quarters_name  FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id=t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id=t3.id ");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"'");
		sb.append(" and (DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d %H:%i:%s') >= DATE_FORMAT(SYSDATE(), '%Y-%m-%d %H:%i:%s')");
		sb.append(" or DATE_FORMAT(t1.start_time, '%Y-%m-%d %H:%i:%s') >= DATE_FORMAT(SYSDATE(), '%Y-%m-%d %H:%i:%s'))");
		sb.append(" order by t1.start_time asc,t1.expected_start_time asc");
		List<WsPlanExecuteRecordVO> lists=planExecuteRecordDao.findBySqlExt(sb.toString(),null,WsPlanExecuteRecordVO.class);
		if(lists!=null&&lists.size()>0)
			return lists.get(0);
		return null;
	}
	/***
	 * 查询老人信息和在当前时间之后要执行的记录最近的一条
	 * @return
	 */
	public List<WsElderPlanExecuteRecordVO> findElderInfoAndExePlansAfterOne(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("select elderExeRecord.* from (SELECT t1.id recordId,t1.project_name,t1.plan_type,t1.expected_start_time");
		sb.append(" ,t1.start_time,t1.state recordState,t1.other_time,t2.`name` service_user_name,t3.`name` quarters_name,");
		sb.append("   t1.intervene_id id");
		sb.append("   FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id=t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id=t3.id ");
		sb.append(" where 1=1  and t1.archives_id = '"+archivesId+"'  ");
		sb.append(" and (DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d %H:%i:%s') >= DATE_FORMAT(SYSDATE(), '%Y-%m-%d %H:%i:%s')");
		sb.append(" or DATE_FORMAT(t1.start_time, '%Y-%m-%d %H:%i:%s') >= DATE_FORMAT(SYSDATE(), '%Y-%m-%d %H:%i:%s'))");
		sb.append(" order by t1.expected_start_time asc,t1.plan_type asc) elderExeRecord");
		sb.append(" group by elderExeRecord.plan_type  ");
//		sb.append(" order by elderExeRecord.plan_type asc");
		return planExecuteRecordDao.findBySqlExt(sb.toString(),null,WsElderPlanExecuteRecordVO.class);
	}
	
	/***
	 * 查看是否生产了今天的执行记录
	 * @param planId
	 * @return
	 */
	public boolean isGenTodayRecord(String interveneId,String planId,String planType){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.id FROM hn_plan_execute_record t1 ");
		sb.append(" WHERE t1.intervene_id = '"+interveneId+"' and t1.plan_id = '"+planId+"' and t1.plan_type = '"+planType+"' ");
		sb.append(" and DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d') ");
		List<Object> list=planExecuteRecordDao.findBySql(sb.toString(), null);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	/***
	 * 今天的某段时间之前的方案计划是否有未执行的
	 * @param planId
	 * @return
	 */
	public boolean haveUnExeRecordToday(String interveneId,String planType){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.id FROM hn_plan_execute_record t1 ");
		sb.append(" WHERE t1.intervene_id = '"+interveneId+"' and t1.plan_type = '"+planType+"' and t1.state = '"+PlanExecuteRecord.EXECUTE_STATE_WAIT+"' ");
		sb.append(" and DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d') ");
		sb.append(" and DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d %H:%i:%s') < DATE_FORMAT(SYSDATE(), '%Y-%m-%d %H:%i:%s') ");
		List<Object> list=planExecuteRecordDao.findBySql(sb.toString(), null);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	
	/***
	 * 根据照护计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecord(ElderPlanNurserVO planVO){
		String planType=PlanExecuteRecord.PLAN_TYPE_NURSE;
		String interveneId=planVO.getInterveneId();
		String archivesId=planVO.getArchivesId();
		Date startTimeDate=planVO.getNurserStartTime();
		Date endTimeDate=planVO.getNurserEndTime();
		if(endTimeDate==null)
			endTimeDate=DateUtils.getDateByString("2018-01-01 01:01:01");//暂时解决有些数据的结束时间未空的问题
		//根据每个项目类型生成在今天需要执行的执行记录保存到表
		if(StringUtils.isNotBlank(planVO.getCareLevelQuartersId())&&StringUtils.isNotBlank(planVO.getCareLevel())&&planVO.getCareLevelTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getCareLevelTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getCareLevelTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.CARE_LEVEL.getValues();
				String projectSubName=NurserPanLevelEnum.findByIndex(planVO.getCareLevel());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_CARE_LEVEL_CODE, null, exeDate, null, null,planVO.getCareLevelQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getDeitNuserQuartersId())&&StringUtils.isNotBlank(planVO.getDeitNuser())&&planVO.getDeitNuserTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getDeitNuserTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getDeitNuserTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.DEIT_NUSER.getValues();
				String projectSubName=NurserPanDietEnum.findByIndex(planVO.getDeitNuser());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_DIET_NURSER_CODE, null, exeDate, null, null,planVO.getDeitNuserQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getCavityCleanQuartersId())&&StringUtils.isNotBlank(planVO.getCavityClean())&&planVO.getCavityCleanTime()!=null){
			int index=Integer.parseInt(planVO.getCavityClean());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.CAVITY_CLEAN.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getCavityClean().equals("0")){
				projectSubName="其他("+planVO.getCavityCleanOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_CAVITY_CLEAN_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getCavityCleanQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getCavityCleanTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getCavityCleanTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_CAVITY_CLEAN_CODE, null, exeDate, null, null,planVO.getCavityCleanQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		}  
		if(StringUtils.isNotBlank(planVO.getPerinealWashQuartersId())&&StringUtils.isNotBlank(planVO.getPerinealWash())&&planVO.getPerinealWashTime()!=null){
			int index=Integer.parseInt(planVO.getPerinealWash());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.PERINEAL_WASH.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getPerinealWash().equals("0")){
				projectSubName="其他("+planVO.getPerinealWashOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_PERINEAL_WASH_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getPerinealWashQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getPerinealWashTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getPerinealWashTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_PERINEAL_WASH_CODE, null, exeDate, null, null,planVO.getPerinealWashQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		}  
		if(StringUtils.isNotBlank(planVO.getBathBathQuartersId())&&StringUtils.isNotBlank(planVO.getBathBath())&&planVO.getBathBathTime()!=null){
			int index=Integer.parseInt(planVO.getBathBath());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.BATH_BATH.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getBathBath().equals("0")){
				projectSubName="其他("+planVO.getBathBathOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_BATH_BATH_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getBathBathQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getBathBathTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getBathBathTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_BATH_BATH_CODE, null, exeDate, null, null,planVO.getBathBathQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		}  
		if(StringUtils.isNotBlank(planVO.getWashHairQuartersId())&&StringUtils.isNotBlank(planVO.getWashHair())&&planVO.getWashHairTime()!=null){
			int index=Integer.parseInt(planVO.getWashHair());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.WASH_HAIR.getValues();
			String projectSubName=NurserPanWashHairEnum.findByIndex(planVO.getWashHair());
			if(planVO.getWashHair().equals("0")){
				projectSubName="其他("+planVO.getWashHairOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_WASH_HAIR_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getWashHairQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getWashHairTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getWashHairTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_WASH_HAIR_CODE, null, exeDate, null, null,planVO.getWashHairQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		} 
		if(StringUtils.isNotBlank(planVO.getOralMedicineQuartersId())&&StringUtils.isNotBlank(planVO.getOralMedicine())&&planVO.getOralMedicineTime()!=null){
			int index=Integer.parseInt(planVO.getOralMedicine());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.ORAL_MEDICINE.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getOralMedicine().equals("0")){
				projectSubName="其他("+planVO.getOralMedicineOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_ORAL_MEDICINE_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getOralMedicineQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getOralMedicineTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getOralMedicineTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_ORAL_MEDICINE_CODE, null, exeDate, null, null,planVO.getOralMedicineQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		} 
		if(StringUtils.isNotBlank(planVO.getChineseMedicineQuartersId())&&StringUtils.isNotBlank(planVO.getChineseMedicine())&&planVO.getChineseMedicineTime()!=null){
			int index=Integer.parseInt(planVO.getChineseMedicine());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.CHINESE_MEDICINE.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getChineseMedicine().equals("0")){
				projectSubName="其他("+planVO.getChineseMedicineOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_CHINESE_MEDICINE_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getChineseMedicineQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getChineseMedicineTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getChineseMedicineTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_CHINESE_MEDICINE_CODE, null, exeDate, null, null,planVO.getChineseMedicineQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		} 
		if(StringUtils.isNotBlank(planVO.getTurnOverQuartersId())&&StringUtils.isNotBlank(planVO.getTurnOver())&&planVO.getTurnOverTime()!=null){
			String[] skip_watchs=planVO.getTurnOver().split(",");
			/***
			 * ENUM_VALUE_1("1","定时翻身"),
		ENUM_VALUE_2("2","每小时一次"),
		ENUM_VALUE_3("3","每两小时一次"),
		ENUM_VALUE_4("4","每四小时一次"),
		ENUM_VALUE_5("0","其他");
			 */
			int index=0;
			String projectName=NurserEnum.TURN_OVER.getValues();
			String projectSubName=NurserPanTurnOverEnum.findByIndex(planVO.getTurnOver());
			boolean timeTurn=false;
			for (int i = 0; i < skip_watchs.length; i++) {
				int value=Integer.parseInt(skip_watchs[i]);
				if(value==1){//
					timeTurn=true;
				}
				if(timeTurn){//定时翻身只去勾选的第一个
					if(value==2||value==3)
						index=value-1;
					if(value==4)
						index=value;
				}
				if(value==0){//qita
					projectSubName+="("+planVO.getTurnOverOther()+")";
				}
			}
			if(timeTurn){
				int[] datas=fromDictToData(index);
				int count=0;
				while (true) {
//					if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//								PlanProjectTypeEnum.NURSER_TRUN_OVER_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getTurnOverQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//						save(pRecord);
//						break;
//					}
					Date exeDate=calExeTime(planVO.getTurnOverTime(), count, datas[0], datas[1], datas[2]);
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getTurnOverTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_TRUN_OVER_CODE, null, exeDate, null, null,planVO.getTurnOverQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						break;
					}
					count++;
				}
			}else{//不是定时翻身，是根据选择的时间翻身
				if(DateUtils.getDateCompare(planVO.getTurnOverTime())){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_TRUN_OVER_CODE, null, planVO.getTurnOverTime(), null, null,planVO.getTurnOverQuartersId(),null,null);
					save(pRecord);
				}
			}
			
		} 
		if(StringUtils.isNotBlank(planVO.getBackslapQuartersId())&&StringUtils.isNotBlank(planVO.getBackslap())&&planVO.getBackslapTime()!=null){
			int index=Integer.parseInt(planVO.getBackslap());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.BACKSLAP.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getBackslap().equals("0")){
				projectSubName="其他("+planVO.getBackslapOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_BACKSLAP_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getBackslapQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getBackslapTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getBackslapTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_BACKSLAP_CODE, null, exeDate, null, null,planVO.getBackslapQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		} 
		if(StringUtils.isNotBlank(planVO.getSkipWatchQuartersId())&&StringUtils.isNotBlank(planVO.getSkipWatch())&&planVO.getSkipWatchTime()!=null){
			String[] skip_watchs=planVO.getSkipWatch().split(",");
			/***
			 * ENUM_VALUE_1("1","床单元整洁"),
		ENUM_VALUE_2("2","皮肤观察"),
		ENUM_VALUE_3("3","每小时一次"),
		ENUM_VALUE_4("4","每两小时一次"),
		ENUM_VALUE_5("5","每四小时一次"),
		ENUM_VALUE_6("6","每六小时一次");
			 */
			int index=0;
			String projectSubName="";
			boolean isWatch=false;
			for (int i = 0; i < skip_watchs.length; i++) {
				int value=Integer.parseInt(skip_watchs[i]);
				if(value==2){
					projectSubName+="皮肤观察";
					isWatch=true;
				}else if(isWatch){//
					projectSubName+="("+NurserPanSkinObservationEnum.getByIndex(skip_watchs[i])+")";
					if(value==3||value==4)
						index=value-2;
					if(value==5)
						index=value-1;
					if(value==6)
						index=value;
					break;
				}
			}
			String projectName=NurserEnum.SKIP_WATCH.getValues();
			if(isWatch){
				int[] datas=fromDictToData(index);
				int count=0,saveCount=0;
				while (true) {//第一次的皮肤观察和床单元整洁放一起
//					if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//								PlanProjectTypeEnum.NURSER_SKIN_WATCH_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getSkipWatchQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//						save(pRecord);
//						break;
//					}
					Date exeDate=calExeTime(planVO.getSkipWatchTime(), count, datas[0], datas[1], datas[2]);
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getSkipWatchTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						saveCount++;
						if(saveCount==1){
							count++;
							continue;
						}
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_SKIN_WATCH_CODE, null, exeDate, null, null,planVO.getSkipWatchQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						break;
					}
					count++;
				}
			}
			projectSubName=NurserPanSkinObservationEnum.findByIndex(planVO.getSkipWatch());
			Date exeDate=dateToTodayTime(planVO.getSkipWatchTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getSkipWatchTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_SKIN_WATCH_CODE, null, exeDate, null, null,planVO.getSkipWatchQuartersId(),null,null);
				save(pRecord);
			}
		} 
		if(StringUtils.isNotBlank(planVO.getBellyMassageQuartersId())&&StringUtils.isNotBlank(planVO.getBellyMassage())&&planVO.getBellyMassageTime()!=null){
			int index=Integer.parseInt(planVO.getBellyMassage());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.BELLY_MASSAGE.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getBellyMassage().equals("0")){
				projectSubName="其他("+planVO.getBellyMassageOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_BELLY_MASSAGE_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getBellyMassageQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getBellyMassageTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getBellyMassageTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_BELLY_MASSAGE_CODE, null, exeDate, null, null,planVO.getBellyMassageQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		} 
		if(StringUtils.isNotBlank(planVO.getDrinkWaterQuartersId())&&StringUtils.isNotBlank(planVO.getDrinkWater())&&planVO.getDrinkWaterTime()!=null){
			int index=Integer.parseInt(planVO.getDrinkWater());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.DRINK_WATER.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getDrinkWater().equals("0")){
				projectSubName="其他("+planVO.getDrinkWaterOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_DRINK_WATER_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getDrinkWaterQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getDrinkWaterTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getDrinkWaterTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_DRINK_WATER_CODE, null, exeDate, null, null,planVO.getDrinkWaterQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		} 
		if(StringUtils.isNotBlank(planVO.getCommunicateQuartersId())&&StringUtils.isNotBlank(planVO.getCommunicate())&&planVO.getCommunicateTime()!=null){
			int index=Integer.parseInt(planVO.getCommunicate());
			int[] datas=fromDictToData(index);
			String projectName=NurserEnum.COMMUNICATE.getValues();
			String projectSubName=CareIntervalTime.findValueByIndex(index);
			if(planVO.getCommunicate().equals("0")){
				projectSubName="其他("+planVO.getCommunicateOther()+")";
			}
			int count=0;
			while (true) {
//				if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//							PlanProjectTypeEnum.NURSER_COMMUNICATE_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getCommunicateQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//					save(pRecord);
//					break;
//				}
				Date exeDate=calExeTime(planVO.getCommunicateTime(), count, datas[0], datas[1], datas[2]);
				if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getCommunicateTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
							PlanProjectTypeEnum.NURSER_COMMUNICATE_CODE, null, exeDate, null, null,planVO.getCommunicateQuartersId(),null,null);
					save(pRecord);
				}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
					break;
				}
				count++;
			}
		} 
		if(StringUtils.isNotBlank(planVO.getDailyLifeQuartersId())&&StringUtils.isNotBlank(planVO.getDailyLife())&&planVO.getDailyLifeTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getDailyLifeTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getDailyLifeTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.DAILY_LIFE.getValues();
				String projectSubName=NurserPanDecreasedLivingAbiliEnum.findByIndex(planVO.getDailyLife());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_DAILY_LIFE_CODE, null, exeDate, null, null,planVO.getDailyLifeQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getSkipIntegrityQuartersId())&&StringUtils.isNotBlank(planVO.getSkipIntegrity())&&planVO.getSkipIntegrityTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getSkipIntegrityTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getSkipIntegrityTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.SKIP_INTEGRITY.getValues();
				String projectSubName=NurserPanRiskSkinIntegrityEnum.findByIndex(planVO.getSkipIntegrity());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_SKIN_INTEGRITY_CODE, null, exeDate, null, null,planVO.getSkipIntegrityQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getAnxietyQuartersId())&&StringUtils.isNotBlank(planVO.getAnxiety())&&planVO.getAnxietyTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getAnxietyTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getAnxietyTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.ANXIETY.getValues();
				String projectSubName=NurserPanLonelinessAnxietyEnum.findByIndex(planVO.getAnxiety());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_ANXIETY_CODE, null, exeDate, null, null,planVO.getAnxietyQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getSolicitudeQuartersId())&&StringUtils.isNotBlank(planVO.getSolicitude())&&planVO.getSolicitudeTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getSolicitudeTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getSolicitudeTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.SOLICITUDE.getValues();
				String projectSubName=NurserPanCareEnum.findByIndex(planVO.getSolicitude());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_SOLICITUDE_CODE, null, exeDate, null, null,planVO.getSolicitudeQuartersId(),null,null);
				save(pRecord);
				if(planVO.getSolicitude().contains("4")){//心理慰藉是每天两次
					exeDate=calExeTime(planVO.getSolicitudeTime(), 1, 1, 2, 2);
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getSolicitudeTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord2=new PlanExecuteRecord(interveneId,archivesId,projectName,"心理慰藉", planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_SOLICITUDE_CODE, null, exeDate, null, null,planVO.getSolicitudeQuartersId(),null,null);
						save(pRecord2);
					}
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getWalkTrainQuartersId())&&StringUtils.isNotBlank(planVO.getWalkTrain())&&planVO.getWalkTrainTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getWalkTrainTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getWalkTrainTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.WALK_TRAIN.getValues();
				String projectSubName=NurserPanWalkingTrainingEnum.findByIndex(planVO.getWalkTrain());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_WALK_TRAIN_CODE, null, exeDate, null, null,planVO.getWalkTrainQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getAstrictionQuartersId())&&StringUtils.isNotBlank(planVO.getAstriction())&&planVO.getAstrictionTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getAstrictionTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getAstrictionTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.ASTRICTION.getValues();
				String projectSubName=NurserPanAstrictionEnum.findByIndex(planVO.getAstriction());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_ASTRICTION_CODE, null, exeDate, null, null,planVO.getAstrictionQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getPotentialInfectionQuartersId())&&StringUtils.isNotBlank(planVO.getPotentialInfection())&&planVO.getPotentialInfectionTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getPotentialInfectionTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getPotentialInfectionTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=NurserEnum.POTENTIAL_INFECTION.getValues();
				String projectSubName=NurserPanPotentialComplicationsEnum.findByIndex(planVO.getPotentialInfection());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_POTENTIAL_INFECTION_CODE, null, exeDate, null, null,planVO.getPotentialInfectionQuartersId(),null,null);
				save(pRecord);
			}
		}
		
		
	}
	/***
	 * 根据康复计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecord(ElderPlanRecoverVO planVO){
		String planType=PlanExecuteRecord.PLAN_TYPE_RECOVER;
		String interveneId=planVO.getInterveneId();
		String archivesId=planVO.getArchivesId();
		Date startTimeDate=planVO.getRecoverStartTime();
		Date endTimeDate=planVO.getRecoverEndTime();
		if(endTimeDate==null)
			endTimeDate=DateUtils.getDateByString("2018-01-01 01:01:01");//暂时解决有些数据的结束时间未空的问题
		//根据每个项目类型生成在今天需要执行的执行记录保存到表
		if(planVO.getAcupuncture()!=null){
			Date startDateTime=planVO.getAcupunctureStartTime();//第一次的开始时间
			Date stopDateTime=planVO.getAcupunctureEndTime();
//			Date todayDateTime=new Date();
			Date todayDateTime=dateToTodayTime(startDateTime, new Date()) ;
			if(StringUtils.isNotBlank(planVO.getAcupunctureQuartersId())&&DateUtils.compareDate(startDateTime,stopDateTime,todayDateTime)){//当前时间在开始结束时间之间
				String projectName=PlanProjectTypeEnum.RECOVER_ACUPUNCTURE.getDesc();
//				String projectSubName=RecoverAcupunctureEnum.findByIndex(planVO.getAcupuncture());
				String projectSubName=planVO.getAcupuncture();
				String ymdStr=DateUtils.formatDateTime(new Date()).split(" ")[0];//今天的日期字符串
				String hmsStr=DateUtils.formatDateTime(startDateTime).split(" ")[1];//开始时间的时间字符串
				Date todayFirstDate=DateUtils.getDateTimeByString(ymdStr+" "+hmsStr);//今天第一次执行的时间
				int frequency=Integer.parseInt(planVO.getAcupunctureFrequency());//一天多少次
				long minutes=DateUtils.getLastMinutes(todayFirstDate);//第一次开始距离当天结束的时间
				int gapMinutes=(int) (minutes/frequency);//每次开始的间隔时间
				String typeCode=PlanProjectTypeEnum.RECOVER_ACUPUNCTURE_CODE;
				for(int i=0;i<frequency;i++){
					Date exeDate=DateUtils.addMinutesToDateTime(todayFirstDate, gapMinutes*i);
					if(exeDate.getTime()<=endTimeDate.getTime()){
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
								typeCode, null, exeDate, null, null,planVO.getAcupunctureQuartersId(),null,null);
						save(pRecord);
					}
				}
			}
		} 
		if(planVO.getPsychologyRecover()!=null){
			Date startDateTime=planVO.getPsychologyRecoverStartTime();//第一次的开始时间
			Date stopDateTime=planVO.getPsychologyRecoverEndTime();
//			Date todayDateTime=new Date();
			Date todayDateTime=dateToTodayTime(startDateTime, new Date()) ;
			if(StringUtils.isNotBlank(planVO.getPsychologyRecoverQuartersId())&&DateUtils.compareDate(startDateTime,stopDateTime,todayDateTime)){//当前时间在开始结束时间之间
				String ymdStr=DateUtils.formatDateTime(new Date()).split(" ")[0];//今天的日期字符串
				String hmsStr=DateUtils.formatDateTime(startDateTime).split(" ")[1];//开始时间的时间字符串
				Date todayFirstDate=DateUtils.getDateTimeByString(ymdStr+" "+hmsStr);//今天第一次执行的时间
				int frequency=Integer.parseInt(planVO.getPsychologyRecoverFrequency());//一天多少次
				long minutes=DateUtils.getLastMinutes(todayFirstDate);//第一次开始距离当天结束的时间
				int gapMinutes=(int) (minutes/frequency);//每次开始的间隔时间
				String typeCode=PlanProjectTypeEnum.RECOVER_PSYCHOLOGY_RECOVER_CODE;
//				String projectName=PlanProjectTypeEnum.RECOVER_PSYCHOLOGY_RECOVER.getDesc();
				String projectName=planVO.getPsychologyRecover();
				for(int i=0;i<frequency;i++){
					Date exeDate=DateUtils.addMinutesToDateTime(todayFirstDate, gapMinutes*i);
					if(exeDate.getTime()<=endTimeDate.getTime()){
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectName, planType, planVO.getId(), 
								typeCode, null, exeDate, null, null,planVO.getPsychologyRecoverQuartersId(),null,null);
						save(pRecord);
					}
				}
			}
		} 
		if(planVO.getLimbsTrain()!=null){
			Date startDateTime=planVO.getLimbsTrainStartTime();//第一次的开始时间
			Date stopDateTime=planVO.getLimbsTrainEndTime();
//			Date todayDateTime=new Date();
			Date todayDateTime=dateToTodayTime(startDateTime, new Date()) ;
			if(StringUtils.isNotBlank(planVO.getLimbsTrainQuartersId())&&DateUtils.compareDate(startDateTime,stopDateTime,todayDateTime)){//当前时间在开始结束时间之间
				String ymdStr=DateUtils.formatDateTime(new Date()).split(" ")[0];//今天的日期字符串
				String hmsStr=DateUtils.formatDateTime(startDateTime).split(" ")[1];//开始时间的时间字符串
				Date todayFirstDate=DateUtils.getDateTimeByString(ymdStr+" "+hmsStr);//今天第一次执行的时间
				int frequency=Integer.parseInt(planVO.getLimbsTrainFrequency());//一天多少次
				long minutes=DateUtils.getLastMinutes(todayFirstDate);//第一次开始距离当天结束的时间
				int gapMinutes=(int) (minutes/frequency);//每次开始的间隔时间
				String typeCode=PlanProjectTypeEnum.RECOVER_LIMBS_TRAIN_CODE;
//				String projectName=PlanProjectTypeEnum.RECOVER_LIMBS_TRAIN.getDesc();
				String projectName=planVO.getLimbsTrain();
				for(int i=0;i<frequency;i++){
					Date exeDate=DateUtils.addMinutesToDateTime(todayFirstDate, gapMinutes*i);
					if(exeDate.getTime()<=endTimeDate.getTime()){
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectName, planType, planVO.getId(), 
								typeCode, null, exeDate, null, null,planVO.getLimbsTrainQuartersId(),null,null);
						save(pRecord);
					}
				}
			}
		} 
		if(planVO.getTaskTreatment()!=null){
			Date startDateTime=planVO.getTaskTreatmentStartTime();//第一次的开始时间
			Date stopDateTime=planVO.getTaskTreatmentEndTime();
//			Date todayDateTime=new Date();
			Date todayDateTime=dateToTodayTime(startDateTime, new Date()) ;
			if(StringUtils.isNotBlank(planVO.getTaskTreatmentQuartersId())&&DateUtils.compareDate(startDateTime,stopDateTime,todayDateTime)){//当前时间在开始结束时间之间
				String ymdStr=DateUtils.formatDateTime(new Date()).split(" ")[0];//今天的日期字符串
				String hmsStr=DateUtils.formatDateTime(startDateTime).split(" ")[1];//开始时间的时间字符串
				Date todayFirstDate=DateUtils.getDateTimeByString(ymdStr+" "+hmsStr);//今天第一次执行的时间
				int frequency=Integer.parseInt(planVO.getTaskTreatmentFrequency());//一天多少次
				long minutes=DateUtils.getLastMinutes(todayFirstDate);//第一次开始距离当天结束的时间
				int gapMinutes=(int) (minutes/frequency);//每次开始的间隔时间
				String typeCode=PlanProjectTypeEnum.RECOVER_TASK_TREATMENT_CODE;
//				String projectName=PlanProjectTypeEnum.RECOVER_TASK_TREATMENT.getDesc();
				String projectName=planVO.getTaskTreatment();
				for(int i=0;i<frequency;i++){
					Date exeDate=DateUtils.addMinutesToDateTime(todayFirstDate, gapMinutes*i);
					if(exeDate.getTime()<=endTimeDate.getTime()){
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectName, planType, planVO.getId(), 
								typeCode, null, exeDate, null, null,planVO.getTaskTreatmentQuartersId(),null,null);
						save(pRecord);
					}
				}
			}
		} 
	}
	/***
	 * 根据营养计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecord(ElderPlanNutritionVO planVO){
		String planType=PlanExecuteRecord.PLAN_TYPE_NUTRITION;
		String interveneId=planVO.getInterveneId();
		String archivesId=planVO.getArchivesId();
		Date startDateTime=planVO.getTreatStartTime();//第一次的开始时间
		Date stopDateTime=planVO.getTreatEndTime();
//		Date todayDateTime=new Date();
		String ymdStr=DateUtils.formatDateTime(new Date()).split(" ")[0];//今天的日期字符串
		if(startDateTime!=null&&stopDateTime!=null){
			Date todayDateTime=dateToTodayTime(startDateTime, new Date()) ;
			if(DateUtils.compareDate(startDateTime,stopDateTime,todayDateTime)){
				//根据每个项目类型生成在今天需要执行的执行记录保存到表
				if(StringUtils.isNotBlank(planVO.getFoodQuartersId())&&StringUtils.isNotBlank(planVO.getFoodArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_FOOD_CODE;
					String projectName=PlanProjectTypeEnum.NUTRITION_FOOD.getDesc();
					String[] times=planVO.getFoodArrange().split(",");
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,"基础饮食",projectName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getFoodQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getPapmeatQuartersId())&&StringUtils.isNotBlank(planVO.getPapmeatArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_PAPMEAT_CODE;
					String[] times=planVO.getPapmeatArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_PAPMEAT.getDesc();
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,"基础饮食",projectName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getPapmeatQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getSemiLiquidQuartersId())&&StringUtils.isNotBlank(planVO.getSemiLiquidArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_SEMI_LIQUID_CODE;
					String[] times=planVO.getSemiLiquidArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_SEMI_LIQUID.getDesc();
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,"基础饮食",projectName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getSemiLiquidQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getLiquidQuartersId())&&StringUtils.isNotBlank(planVO.getLiquidArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_LIQUID_CODE;
					String[] times=planVO.getLiquidArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_LIQUID.getDesc();
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,"基础饮食",projectName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getLiquidQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getOnsQuartersId())&&StringUtils.isNotBlank(planVO.getOnsArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_ONS_CODE;
					String[] times=planVO.getOnsArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_ONS.getDesc();
					String projectSubName="每日"+planVO.getOnsMeals()+"餐,每餐"+planVO.getOnsMealsNumber()+"g"+",产生能量"+planVO.getOnsEnergy()+"千焦";
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getOnsQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getTenQuartersId())&&StringUtils.isNotBlank(planVO.getTenArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_TEN_CODE;
					String[] times=planVO.getTenArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_TEN.getDesc();
					String projectSubName="每日"+planVO.getTenMeals()+"餐,每餐"+planVO.getTenMealsNumber()+"g"+",产生能量"+planVO.getTenEnergy()+"千焦";
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getTenQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getPenQuartersId())&&StringUtils.isNotBlank(planVO.getPenArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_PEN_CODE;
					String[] times=planVO.getPenArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_PEN.getDesc();
					String projectSubName="每日"+planVO.getPenMeals()+"餐,每餐"+planVO.getPenMealsNumber()+"g"+",产生能量"+planVO.getPenEnergy()+"千焦";
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getPenQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getPpnQuartersId())&&StringUtils.isNotBlank(planVO.getPpnArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_PPN_CODE;
					String[] times=planVO.getPpnArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_PPN.getDesc();
					String projectSubName="每日"+planVO.getPpnMeals()+"餐,每餐"+planVO.getPpnMealsNumber()+"g"+",产生能量"+planVO.getPpnEnergy()+"千焦";
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getPpnQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getTpnQuartersId())&&StringUtils.isNotBlank(planVO.getTpnArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_TPN_CODE;
					String[] times=planVO.getTpnArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_TPN.getDesc();
					String projectSubName="每日"+planVO.getTpnMeals()+"餐,每餐"+planVO.getTpnMealsNumber()+"g"+",产生能量"+planVO.getTpnEnergy()+"千焦";
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getTpnQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
				if(StringUtils.isNotBlank(planVO.getDrinkWaterQuartersId())&&StringUtils.isNotBlank(planVO.getDrinkWaterArrange())){
					String typeCode=PlanProjectTypeEnum.NUTRITION_DRINK_WATER_CODE;
					String[] times=planVO.getDrinkWaterArrange().split(",");
					String projectName=PlanProjectTypeEnum.NUTRITION_DRINK_WATER.getDesc();
					String projectSubName="每日"+planVO.getDrinkWaterMeals()+"ml,每餐"+planVO.getDrinkWaterMealsNumber()+"g"+",产生能量"+planVO.getDrinkWaterEnergy()+"千焦";
					for (int i = 0; i < times.length; i++) {
						Date exeDate=DateUtils.getDateTimeByString(ymdStr+" "+times[i]+":00");
						if(exeDate.getTime()<=stopDateTime.getTime()){
							PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
									typeCode, null, exeDate, null, null,planVO.getDrinkWaterQuartersId(),null,null);
							save(pRecord);
						}
					}
				} 
			}
			
		}
	}
	/***
	 * 根据社工-喜好计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecord(ElderPlanSocialVO planVO){
		String interveneId=planVO.getInterveneId();
		String archivesId=planVO.getArchivesId();
		String typeCode=PlanProjectTypeEnum.HOBBY_CODE;
		String planType=PlanExecuteRecord.PLAN_TYPE_SOCIAL_HOBBY;
		Date startTimeDate=planVO.getSocialStartTime();
		Date endTimeDate=planVO.getSocialEndTime();
		if(endTimeDate==null)
			endTimeDate=DateUtils.getDateByString("2018-01-01 01:01:01");//暂时解决有些数据的结束时间未空的问题
		List<Hobby> hobbies=hobbyService.findByInterveneId(interveneId);
		for (Hobby hobby:hobbies) {
			Date startDateTime=hobby.getHobbyStartTime();//第一次的开始时间
			if(StringUtils.isNotBlank(hobby.getHobbyQuartersId())&&startDateTime!=null){//开始时间是否为当前日期
				Date exeDate=dateToTodayTime(startDateTime, new Date()) ;
				if(exeDate.getTime()>=startDateTime.getTime()&&exeDate.getTime()<hobby.getHobbyEndTime().getTime()&&exeDate.getTime()<endTimeDate.getTime()){//执行时间大于预定时间
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,hobby.getHobby(),hobby.getHobbyAsk(), planType, planVO.getId(), 
							typeCode, null, exeDate, null, null,hobby.getHobbyQuartersId(),null,null);
					save(pRecord);
				}
			}
		}
		
	}
	/***
	 * 根据应急计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecord(ElderPlanMeetVO planVO){
		String planType=PlanExecuteRecord.PLAN_TYPE_MEET;
		String interveneId=planVO.getInterveneId();
		String archivesId=planVO.getArchivesId();
		Date startDateTime=planVO.getStartTime();//第一次的开始时间
		Date stopDateTime=planVO.getEndTime();
		
//		Date todayDateTime=new Date();
		if(StringUtils.isNotBlank(planVO.getQuartersId())&&startDateTime!=null&&stopDateTime!=null){//当前时间在开始结束时间之间
			Date todayDateTime=dateToTodayTime(startDateTime, new Date()) ;
			if(DateUtils.compareDate(startDateTime,stopDateTime,todayDateTime)){
				String ymdStr=DateUtils.formatDateTime(new Date()).split(" ")[0];//今天的日期字符串
				String hmsStr=DateUtils.formatDateTime(startDateTime).split(" ")[1];//开始时间的时间字符串
				Date todayFirstDate=DateUtils.getDateTimeByString(ymdStr+" "+hmsStr);//今天第一次执行的时间
				int frequency=Integer.parseInt(planVO.getFrequency());//一天多少次
				long minutes=DateUtils.getLastMinutes(todayFirstDate);//第一次开始距离当天结束的时间
				int gapMinutes=(int) (minutes/frequency);//每次开始的间隔时间
				String typeCode=PlanProjectTypeEnum.MEET_CODE;
				String projectSubName="共"+planVO.getFrequencyTotal()+"次,一天"+planVO.getFrequency()+"次,每次时长"+planVO.getFrequencyTime()+"分钟";
				for(int i=0;i<frequency;i++){
					Date exeDate=DateUtils.addMinutesToDateTime(todayFirstDate, gapMinutes*i);
					PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,planVO.getEntryName(),projectSubName,planType, planVO.getId(), 
							typeCode, null, exeDate, null, null,planVO.getQuartersId(),null,null);
					save(pRecord);
				}
			}
		}
	}
	/***
	 * 根据诊疗计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecord(ElderPlanAssessmentVO planVO){
		if(StringUtils.isNotBlank(planVO.getQuartersId())){
			String planType=PlanExecuteRecord.PLAN_TYPE_ASSESSMENT;
			String interveneId=planVO.getInterveneId();
			String archivesId=planVO.getArchivesId();
			
			String typeCode=PlanProjectTypeEnum.ASSESSMENT_CODE;
			String projectName=PlanProjectTypeEnum.ASSESSMENT.getDesc();
			String projectSubName=planVO.getDiagnosis();
			Date exeDate=dateToTodayTime(planVO.getStartTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getStartTime().getTime()&&exeDate.getTime()<planVO.getEndTime().getTime()){//执行时间大于预定时间
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						typeCode, null, exeDate, null, null,planVO.getQuartersId(),null,null);
				save(pRecord);
			}
			
		}
	}
	/***
	 *int[0]:执行时间段：eg：n分钟/小时/天/周
	 * int[1]:时间段类型：0，分钟；1，小时；2，天；3，周，4,半月，5，月
	 * int[2]:每执行时间段执行次数：eg： n 分钟/小时/天/周/半月/月 times次
	 * @param dictValue
	 * @return
	 */
	public int[] fromDictToData(int dictValue){
		/***
		 * ONE(1,"每小时一次"),TWO(2,"每两小时一次 "),THREE(4,"每四小时一次 "),FOUR(6,"每六小时一次 "),FIVE(8,"每八小时一次"),
		SIX(31,"每天一次"),SEVEN(32,"每天两次"),EIGHT(33,"每天三次"),NINE(34,"每天四次"),
		TEN(41,"隔天一次"),ELEVEN(64,"每周四次"),TWELVE(0,"其他"),
		THIRTEEN(91,"医嘱"),FOURTEEN(92,"睡前"),FIFTEEN(93,"睡时"),;
		 */
		int[] datas=new int[3];//间隔、类型、次数
		if(dictValue<0)
			dictValue=0;
		int n=dictValue%10;//个位
		int m=dictValue/10;//十位
		if (dictValue==0||m==9) {
			datas[0]=m;
			datas[1]=n;
			datas[2]=0;
			return datas;
		}
		switch (m) {
			case 0://每n小时 每一小时1次
				datas[0]=n;
				datas[1]=1;
				datas[2]=1;
				break;
			case 1://每n小时 每十小时1次
				datas[0]=dictValue;
				datas[1]=1;
				datas[2]=1;
				break;
			case 2://每二十小时1次
				datas[0]=dictValue;
				datas[1]=1;
				datas[2]=1;
				break;
			case 3://每n天 每1天n次
				datas[0]=1;
				datas[1]=2;
				datas[2]=n;
				break;
			case 4://每n天1次
				datas[0]=n;
				datas[1]=2;
				datas[2]=1;
				break;
			case 5://每n周1次
				if(n<4){
					datas[0]=n;
					datas[1]=3;
					datas[2]=1;
				}else if(n==4){//每半月1次
					datas[0]=1;
					datas[1]=4;
					datas[2]=1;
				}else {//每1月一次
					datas[0]=1;
					datas[1]=5;
					datas[2]=1;
				}
				break;
			case 6://每1周4次
				datas[0]=1;
				datas[1]=3;
				datas[2]=n;
				break;
	
			default:
				break;
		}
		return datas;
	}
	public Date getSleepTime(Date date){//获取睡觉时间
		String dateStr=DateUtils.formatDate(date);
		String dateTimeStr=dateStr+" 21:00:00";
		return DateUtils.getDateTimeByString(dateTimeStr);
	}
	public Date getGetUpTime(Date date){//获取起床时间
		String dateStr=DateUtils.formatDate(date);
		String dateTimeStr=dateStr+" 07:00:00";
		return DateUtils.getDateTimeByString(dateTimeStr);
	}
	public Date getBreakFastTime(Date date){//获取早餐时间
		String dateStr=DateUtils.formatDate(date);
		String dateTimeStr=dateStr+" 08:00:00";
		return DateUtils.getDateTimeByString(dateTimeStr);
	}
	public Date getLunchTime(Date date){//获取午餐时间
		String dateStr=DateUtils.formatDate(date);
		String dateTimeStr=dateStr+" 12:00:00";
		return DateUtils.getDateTimeByString(dateTimeStr);
	}
	public Date getDinnerTime(Date date){//获取晚餐时间
		String dateStr=DateUtils.formatDate(date);
		String dateTimeStr=dateStr+" 19:00:00";
		return DateUtils.getDateTimeByString(dateTimeStr);
	}
	/***
	 * 根据日期时间对应到某天的相应时间
	 * @param date
	 * @return
	 */
	public Date dateToTodayTime(Date date,Date toDate){
		String dateStr=DateUtils.formatDateTime(date);
		String toDateStr=DateUtils.formatDate(toDate);
		String dateTimeStr=toDateStr+" "+dateStr.split(" ")[1];
		return DateUtils.getDateTimeByString(dateTimeStr);
	}
	/***
	 * 计算当天的执行时间
	 * @param startTime 第一次的执行时间
	 * @param count 执行了多少次
	 * @param n 执行时间段：n分钟/小时/天/周
	 * @param type 时间段类型：0，分钟；1，小时；2，天；3，周，4,半月，5，月
	 * @param times 每执行时间段执行次数：n 分钟/小时/天/周/半月/月 times次
	 * @return
	 */
	public Date calExeTime(Date startTime,int count,int n,int type,int times){
		int gapMinutes=0;//每次周期间隔分钟数
		String ymdStr=DateUtils.formatDateTime(new Date()).split(" ")[0];//今天是日期字符串
		String hmsStr=DateUtils.formatDateTime(startTime).split(" ")[1];//开始时间的时间字符串
		Date todayFirstDate=DateUtils.getDateTimeByString(ymdStr+" "+hmsStr);//今天第一次执行的时间
		Date curStartTime=null;
		int hout_to_minutes=60;
		int day_to_minutes=60*24;
		int week_to_minutes=7*60*24;
		//n 分钟/小时/天/周/半月/月 times次
		if(n==0||n==9){//THIRTEEN(91,"医嘱"),FOURTEEN(92,"睡前"),FIFTEEN(93,"睡时"),;
			if(type==2||type==3){
				startTime=getSleepTime(new Date());
			}
			curStartTime=DateUtils.addDaysToDateTime(startTime, count);
			return curStartTime;
		}
		if(type==0){//n分钟times次
			if(gapMinutes==0){
				gapMinutes=n/times;
			}
			if(count==0){//今天第一次执行
				curStartTime=todayFirstDate;
			}else{//今天第count+1次执行
				curStartTime=DateUtils.addMinutesToDateTime(todayFirstDate, gapMinutes*count);
			}
		}else if(type==1){//n小时times次
			if(gapMinutes==0){
				gapMinutes=n*hout_to_minutes/times;
			}
			if(count==0){//今天第一次执行
				curStartTime=todayFirstDate;
			}else{//今天第count+1次执行
				curStartTime=DateUtils.addMinutesToDateTime(todayFirstDate, gapMinutes*count);
			}
		}else if(type==2){//n天times次
			if(n==1){//一天times次的单独处理，避免晚上9点以后执行
				day_to_minutes=60*12;//在早上7点到晚上8点之间执行，整个执行覆盖时间12个小时
			}
			if(gapMinutes==0){
				gapMinutes=n*day_to_minutes/times;
			}
			int cycleCount=count/times;//小周期循环次数
			Date cycleStartDate=DateUtils.addDaysToDateTime(startTime, cycleCount*n);//小周期循环开始时间
			int m=count%times;// 小周内的循环次数
			curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*m);
//			if(m==0){//小周期循环第一次开始
//				curStartTime=cycleStartDate;
//			}else{
//				curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*m);
//			}
		}else if(type==3){//n周times次
			if(gapMinutes==0){
				gapMinutes=n*week_to_minutes/times;
			}
			int cycleCount=count/times;//小周期循环次数
			Date cycleStartDate=DateUtils.addDaysToDateTime(startTime, cycleCount*n*7);//小周期循环开始时间
			int m=count%times;// 小周内的循环次数
			curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*m);
//			if((count%times)==0){//小周期循环第一次开始
//				curStartTime=cycleStartDate;
//			}else{
//				curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*count);
//			}
		}else if(type==4){//半月times次
			if(gapMinutes==0){
				gapMinutes=n*week_to_minutes/times;
			}
			int cycleCount=count/times;//小周期循环次数
			Date cycleStartDate=DateUtils.addDaysToDateTime(startTime, cycleCount*n*15);//小周期循环开始时间
			int m=count%times;// 小周内的循环次数
			curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*m);
//			if((count%times)==0){//小周期循环第一次开始
//				curStartTime=cycleStartDate;
//			}else{
//				curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*count);
//			}
		}else if(type==5){//n月times次
			if(gapMinutes==0){
				gapMinutes=n*week_to_minutes/times;
			}
			int cycleCount=count/times;//小周期循环次数
			Date cycleStartDate=DateUtils.addDaysToDateTime(startTime, cycleCount*n*15);//小周期循环开始时间
			int m=count%times;// 小周内的循环次数
			curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*m);
//			if((count%times)==0){//小周期循环第一次开始
//				curStartTime=cycleStartDate;
//			}else{
//				curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, gapMinutes*count);
//			}
		}
		return curStartTime;
	}
	
	
	/**
	 * 开始执行计划
	 * @param serviceUserId
	 */
	@Transactional(readOnly = false)
	public String executionPlan(String id,String serviceUserId,String state) {
		Date date = new Date();
		String sql = "update PlanExecuteRecord set serviceUserId = :p1,startTime = :p2,state = :p3 where id = :p4";
		planExecuteRecordDao.update(sql.toString(),new Parameter(serviceUserId, date, state, id));
		return DateUtils.formatDate(date,"yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 结束执行计划
	 * @param serviceUserId
	 */
	@Transactional(readOnly = false)
	public void endExecutionPlan(String id) {
		String sql = "update PlanExecuteRecord set stopTime = :p1 where id = :p2";
		planExecuteRecordDao.update(sql.toString(),new Parameter(new Date(), id));
	}
	/***
	 * 删除方案对应的今日未执行的计划记录
	 * @param id 方案id
	 * @return
	 */
	@Transactional(readOnly = false)
	public void delTodayUnExePlanRecord(String id){
		String sql="delete from hn_plan_execute_record WHERE intervene_id = '"+id+"'"
				+ " and state = '"+PlanExecuteRecord.EXECUTE_STATE_WAIT+"'"
				+ " and DATE_FORMAT(expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')";
		planExecuteRecordDao.updateBySql(sql, null);	
	}
	/***
	 * 生产方案今天某个时间后的对应执行记录
	 * @param id 方案id
	 * @param dataTime
	 */
	@Transactional(readOnly = false)
	public void genTodayPlanExeRecord(String id,Date dataTime){
		List<ElderPlanAssessmentVO> elderPlanAssessmentVOs = planService.findAssessmentPlans(id);
		List<ElderPlanCareVO> elderPlanCareVOs = planService.findCarePlans(id);
		List<ElderPlanNurserVO> elderPlanNurserVOs = planService.findNurserPlans(id);
		List<ElderPlanRecoverVO> elderPlanRecoverVOs = planService.findRecoverPlans(id);
		List<ElderPlanNutritionVO> elderPlanNutritionVOs = planService.findNutritionPlans(id);
		List<ElderPlanSocialVO> elderPlanHobbyVOs = planService.findSoialPlans(id);
		List<ElderPlanMeetVO> elderPlanMeetVOs = planService.findMeetPlans(id);
		
		/*for(ElderPlanAssessmentVO vo:elderPlanAssessmentVOs){
			savePlanExeRecord(vo);
		}*/
		for(ElderPlanCareVO vo:elderPlanCareVOs){
			savePlanExeRecordNew(vo);
		}
		for(ElderPlanRecoverVO vo:elderPlanRecoverVOs){
			savePlanExeRecord(vo);
		}
		for(ElderPlanNutritionVO vo:elderPlanNutritionVOs){
			savePlanExeRecord(vo);
		}
		for(ElderPlanSocialVO vo:elderPlanHobbyVOs){
			savePlanExeRecord(vo);
		}
		for(ElderPlanMeetVO vo:elderPlanMeetVOs){
			savePlanExeRecord(vo);
		}
		for(ElderPlanNurserVO vo:elderPlanNurserVOs){
			savePlanExeRecordNew(vo);
		}
	}
	
	
	
	/***
	 * 根据护理计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecordNew(ElderPlanCareVO planVO){
		String planType=PlanExecuteRecord.PLAN_TYPE_CARE;
		String interveneId=planVO.getInterveneId();
		String archivesId=planVO.getArchivesId();
		Date startTimeDate=planVO.getCareStartTime();
		Date endTimeDate=planVO.getCareEndTime();
		if(endTimeDate==null)
			endTimeDate=DateUtils.getDateByString("2018-01-01 01:01:01");//暂时解决有些数据的结束时间未空的问题
		//根据每个项目类型生成在今天需要执行的执行记录保存到表
		if(StringUtils.isNotBlank(planVO.getVeinInfusionQuartersId())&&StringUtils.isNotBlank(planVO.getVeinInfusion())&&planVO.getVeinInfusionTime()!=null){
			String projectName=CareMenu.VEIN_INFUSION.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getVeinInfusion());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getVeinInfusionTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getVeinInfusionTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_VEIN_INFUSION_CODE, null, exeDate, null, null,planVO.getVeinInfusionQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getOxygenQuartersId())&&StringUtils.isNotBlank(planVO.getOxygen())&&planVO.getOxygenTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getOxygenTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getOxygenTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=CareMenu.OXYGEN.getValues();
				String projectSubName=CareOxygen.findByIndex(planVO.getOxygen());
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.CARE_OXYGEN_CODE, null, exeDate, null, null,planVO.getOxygenQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getReplaceWefFlaskQuartersId())&&StringUtils.isNotBlank(planVO.getReplaceWefFlask())&&planVO.getReplaceWefFlaskTime()!=null){
			String projectName=CareMenu.REPLACE_WEF_FLASK.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getReplaceWefFlask());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getReplaceWefFlaskTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getReplaceWefFlaskTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_REPLACE_WEF_FLASK_CODE, null, exeDate, null, null,planVO.getReplaceWefFlaskQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getSputumSuctionQuartersId())&&StringUtils.isNotBlank(planVO.getSputumSuction())&&planVO.getSputumSuctionTime()!=null){
			String projectName=CareMenu.SPUTUM_SUCTION.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getSputumSuction());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getSputumSuctionTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getSputumSuctionTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_SPUTUM_SUCTION_CODE, null, exeDate, null, null,planVO.getSputumSuctionQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getAtomizationQuartersId())&&StringUtils.isNotBlank(planVO.getAtomization())&&planVO.getAtomizationTime()!=null){
			String projectName=CareMenu.ATOMIZATION.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getAtomization());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getAtomizationTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getAtomizationTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_ATOMIZATION_CODE, null, exeDate, null, null,planVO.getAtomizationQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getOralNuserQuartersId())&&StringUtils.isNotBlank(planVO.getOralNuser())&&planVO.getOralNuserTime()!=null){
			String projectName=CareMenu.ORAL_NUSER.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getOralNuser());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getOralNuserTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getOralNuserTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_ORAL_NUSER_CODE, null, exeDate, null, null,planVO.getOralNuserQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getUreterNuserQuartersId())&&StringUtils.isNotBlank(planVO.getUreterNuser())&&planVO.getUreterNuserTime()!=null){
			String projectName=CareMenu.URETER_NUSER.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getUreterNuser());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getUreterNuserTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getUreterNuserTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_URETER_NUSER_CODE, null, exeDate, null, null,planVO.getUreterNuserQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getDeepVeinQuartersId())&&StringUtils.isNotBlank(planVO.getDeepVein())&&planVO.getDeepVeinTime()!=null){
			String projectName=CareMenu.DEEP_VEIN.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getDeepVein());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getDeepVeinTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getDeepVeinTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_DEEP_VEIN_CODE, null, exeDate, null, null,planVO.getDeepVeinQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getTracheaNuserQuartersId())&&StringUtils.isNotBlank(planVO.getTracheaNuser())&&planVO.getTracheaNuserTime()!=null){
			String projectName=CareMenu.TRACHEA_NUSER.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getTracheaNuser());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getTracheaNuserTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getTracheaNuserTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_TRACHEA_NUSER_CODE, null, exeDate, null, null,planVO.getTracheaNuserQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getOralMedicineQuartersId())&&StringUtils.isNotBlank(planVO.getOralMedicine())&&planVO.getOralMedicineTime()!=null){
			String projectName=CareMenu.ORAL_MEDICINE.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getOralMedicine());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getOralMedicineTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getOralMedicineTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_ORAL_MEDICINE_CODE, null, exeDate, null, null,planVO.getOralMedicineQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getChineseMedicineQuartersId())&&StringUtils.isNotBlank(planVO.getChineseMedicine())&&planVO.getChineseMedicineTime()!=null){
			String projectName=CareMenu.CHINESE_MEDICINE.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getChineseMedicine());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getChineseMedicineTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getChineseMedicineTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_CHINESE_MEDICINE_CODE, null, exeDate, null, null,planVO.getChineseMedicineQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getSpecialMedicineQuartersId())&&StringUtils.isNotBlank(planVO.getSpecialMedicine())&&planVO.getSpecialMedicineTime()!=null){
			String projectName=CareMenu.SPECIAL_MEDICINE.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getSpecialMedicine());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getSpecialMedicineTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getSpecialMedicineTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_SPECIAL_MEDICINE_CODE, null, exeDate, null, null,planVO.getSpecialMedicineQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
		if(StringUtils.isNotBlank(planVO.getRecoveryNuserQuartersId())&&StringUtils.isNotBlank(planVO.getRecoveryNuser())&&planVO.getRecoveryNuserTime()!=null){
			Date exeDate=dateToTodayTime(planVO.getRecoveryNuserTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getRecoveryNuserTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//执行时间大于预定时间
				String projectName=CareMenu.RECOVERY_NUSER.getValues();
				String projectSubName=CareRecoveryNuser.findByIndex(planVO.getRecoveryNuser());
				if(planVO.getRecoveryNuser().equals("0")){
					projectSubName="其他("+planVO.getRecoveryNuserOther()+")";
				}
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.CARE_RECOVERY_NUSER_CODE, null, exeDate, null, null,planVO.getRecoveryNuserQuartersId(),null,null);
				save(pRecord);
			}
		}
		if(StringUtils.isNotBlank(planVO.getNutritionMealQuartersId())&&StringUtils.isNotBlank(planVO.getNutritionMeal())&&planVO.getNutritionMealTime()!=null){
			String projectName=CareMenu.NUTRITION_MEAL.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getNutritionMeal());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getNutritionMealTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getNutritionMealTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.CARE_NUTRITION_MEAL_CODE, null, exeDate, null, null,planVO.getNutritionMealQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}
	}
	/***
	 * 根据照护计划添加执行记录
	 * @param care
	 */
	public void savePlanExeRecordNew(ElderPlanNurserVO planVO){
		String planType=PlanExecuteRecord.PLAN_TYPE_NURSE;
		String interveneId=planVO.getInterveneId();
		String archivesId=planVO.getArchivesId();
		Date startTimeDate=planVO.getNurserStartTime();
		Date endTimeDate=planVO.getNurserEndTime();
		if(endTimeDate==null)
			endTimeDate=DateUtils.getDateByString("2018-01-01 01:01:01");//暂时解决有些数据的结束时间未空的问题
		//根据每个项目类型生成在今天需要执行的执行记录保存到表
		if(StringUtils.isNotBlank(planVO.getCavityCleanQuartersId())&&StringUtils.isNotBlank(planVO.getCavityClean())&&planVO.getCavityCleanTime()!=null){
			String projectName=NurserEnum.CAVITY_CLEAN.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getCavityClean());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getCavityCleanTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getCavityCleanTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_CAVITY_CLEAN_CODE, null, exeDate, null, null,planVO.getCavityCleanQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}  
		if(StringUtils.isNotBlank(planVO.getPerinealWashQuartersId())&&StringUtils.isNotBlank(planVO.getPerinealWash())&&planVO.getPerinealWashTime()!=null){
			String projectName=NurserEnum.PERINEAL_WASH.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getPerinealWash());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getPerinealWashTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getPerinealWashTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_PERINEAL_WASH_CODE, null, exeDate, null, null,planVO.getPerinealWashQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}  
		if(StringUtils.isNotBlank(planVO.getBathBathQuartersId())&&StringUtils.isNotBlank(planVO.getBathBath())&&planVO.getBathBathTime()!=null){
			String projectName=NurserEnum.BATH_BATH.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getBathBath());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getBathBathTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getBathBathTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_BATH_BATH_CODE, null, exeDate, null, null,planVO.getBathBathQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		}  
		if(StringUtils.isNotBlank(planVO.getWashHairQuartersId())&&StringUtils.isNotBlank(planVO.getWashHair())&&planVO.getWashHairTime()!=null){
			String projectName=NurserEnum.WASH_HAIR.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getWashHair());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getWashHairTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getWashHairTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_WASH_HAIR_CODE, null, exeDate, null, null,planVO.getWashHairQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		} 
		if(StringUtils.isNotBlank(planVO.getOralMedicineQuartersId())&&StringUtils.isNotBlank(planVO.getOralMedicine())&&planVO.getOralMedicineTime()!=null){
			String projectName=NurserEnum.ORAL_MEDICINE.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getOralMedicine());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getOralMedicineTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getOralMedicineTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_ORAL_MEDICINE_CODE, null, exeDate, null, null,planVO.getOralMedicineQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		} 
		if(StringUtils.isNotBlank(planVO.getChineseMedicineQuartersId())&&StringUtils.isNotBlank(planVO.getChineseMedicine())&&planVO.getChineseMedicineTime()!=null){
			String projectName=NurserEnum.CHINESE_MEDICINE.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getChineseMedicine());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getChineseMedicineTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getChineseMedicineTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_CHINESE_MEDICINE_CODE, null, exeDate, null, null,planVO.getChineseMedicineQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		} 
		if(StringUtils.isNotBlank(planVO.getTurnOverQuartersId())&&StringUtils.isNotBlank(planVO.getTurnOver())&&planVO.getTurnOverTime()!=null){
			String projectName=NurserEnum.TURN_OVER.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getTurnOver());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getTurnOverTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getTurnOverTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_TRUN_OVER_CODE, null, exeDate, null, null,planVO.getTurnOverQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
			
		} 
		if(StringUtils.isNotBlank(planVO.getBackslapQuartersId())&&StringUtils.isNotBlank(planVO.getBackslap())&&planVO.getBackslapTime()!=null){
			String projectName=NurserEnum.BACKSLAP.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getBackslap());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getBackslapTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getBackslapTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_BACKSLAP_CODE, null, exeDate, null, null,planVO.getBackslapQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		} 
		if(StringUtils.isNotBlank(planVO.getSkipWatchQuartersId())&&StringUtils.isNotBlank(planVO.getSkipWatch())&&planVO.getSkipWatchTime()!=null){
			String[] skip_watchs=planVO.getSkipWatch().split(",");
			/***
			 * ENUM_VALUE_1("1","床单元整洁"),
		ENUM_VALUE_2("2","皮肤观察"),
		ENUM_VALUE_3("3","每小时一次"),
		ENUM_VALUE_4("4","每两小时一次"),
		ENUM_VALUE_5("5","每四小时一次"),
		ENUM_VALUE_6("6","每六小时一次");
			 */
			int index=0;
			String projectSubName="";
			boolean isWatch=false;
			for (int i = 0; i < skip_watchs.length; i++) {
				int value=Integer.parseInt(skip_watchs[i]);
				if(value==2){
					projectSubName+="皮肤观察";
					isWatch=true;
				}else if(isWatch){//
					projectSubName+="("+NurserPanSkinObservationEnum.getByIndex(skip_watchs[i])+")";
					if(value==3||value==4)
						index=value-2;
					if(value==5)
						index=value-1;
					if(value==6)
						index=value;
					break;
				}
			}
			String projectName=NurserEnum.SKIP_WATCH.getValues();
			if(isWatch){
				int[] datas=fromDictToData(index);
				int count=0,saveCount=0;
				while (true) {//第一次的皮肤观察和床单元整洁放一起
//					if(datas[0]==0&&datas[1]==0&&datas[2]==0){
//						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
//								PlanProjectTypeEnum.NURSER_SKIN_WATCH_CODE, null, DateUtils.getDateStart(new Date()), null, null,planVO.getSkipWatchQuartersId(),CareIntervalTime.findValueByIndex(index),null);
//						save(pRecord);
//						break;
//					}
					Date exeDate=calExeTime(planVO.getSkipWatchTime(), count, datas[0], datas[1], datas[2]);
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getSkipWatchTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						saveCount++;
						if(saveCount==1){
							count++;
							continue;
						}
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_SKIN_WATCH_CODE, null, exeDate, null, null,planVO.getSkipWatchQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						break;
					}
					count++;
				}
			}
			projectSubName=NurserPanSkinObservationEnum.findByIndex(planVO.getSkipWatch());
			Date exeDate=dateToTodayTime(planVO.getSkipWatchTime(), new Date()) ;
			if(exeDate.getTime()>=planVO.getSkipWatchTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//
				PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,projectSubName, planType, planVO.getId(), 
						PlanProjectTypeEnum.NURSER_SKIN_WATCH_CODE, null, exeDate, null, null,planVO.getSkipWatchQuartersId(),null,null);
				save(pRecord);
			}
		} 
		if(StringUtils.isNotBlank(planVO.getBellyMassageQuartersId())&&StringUtils.isNotBlank(planVO.getBellyMassage())&&planVO.getBellyMassageTime()!=null){
			String projectName=NurserEnum.BELLY_MASSAGE.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getBellyMassage());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getBellyMassageTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getBellyMassageTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_BELLY_MASSAGE_CODE, null, exeDate, null, null,planVO.getBellyMassageQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		} 
		if(StringUtils.isNotBlank(planVO.getDrinkWaterQuartersId())&&StringUtils.isNotBlank(planVO.getDrinkWater())&&planVO.getDrinkWaterTime()!=null){
			String projectName=NurserEnum.DRINK_WATER.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getDrinkWater());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getDrinkWaterTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getDrinkWaterTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_DRINK_WATER_CODE, null, exeDate, null, null,planVO.getDrinkWaterQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		} 
		if(StringUtils.isNotBlank(planVO.getCommunicateQuartersId())&&StringUtils.isNotBlank(planVO.getCommunicate())&&planVO.getCommunicateTime()!=null){
			String projectName=NurserEnum.COMMUNICATE.getValues();
			Frequencys frequencys = frequencysService.get(planVO.getCommunicate());
			int count=0;
			int numbers = 0;
			while (true) {
				String[] datetimes = frequencys.getDateArray().split(";");
				for(String datetime : datetimes){
					Date exeDate=calExeTimeNew(planVO.getCommunicateTime(), count, frequencys.getFrequencyType(),frequencys.getIntervals(),datetime+":00");
					if(DateUtils.getDateCompare(exeDate)&&exeDate.getTime()>=planVO.getCommunicateTime().getTime()&&exeDate.getTime()<=endTimeDate.getTime()){//为当前日期
						PlanExecuteRecord pRecord=new PlanExecuteRecord(interveneId,archivesId,projectName,null, planType, planVO.getId(), 
								PlanProjectTypeEnum.NURSER_COMMUNICATE_CODE, null, exeDate, null, null,planVO.getCommunicateQuartersId(),null,null);
						save(pRecord);
					}else if(DateUtils.compareCurrDate(exeDate)){//大于当前日期
						++numbers;
					}
				}
				count++;
				if(numbers > 0){
					break;
				}
			}
		} 
		
		
	}
	/***
	 * 计算当天的执行时间
	 * @param startTime 开始执行时间
	 * @param counts 循环次数
	 * @param frequencyType 执行频次（0、天,1、周）
	 * @param intervals 间隔时间 
	 * @param dateTime 时间
	 * @return
	 */
	public Date calExeTimeNew(Date startTime, int counts,String frequencyType,String intervals,String dateTime){
		String hmsStr=DateUtils.formatDateTime(startTime).split(" ")[0];//开始时间的日期字符串
		Date curStartTime=null;
		int day_to_minutes=60*24;
		int week_to_minutes=7*60*24;
		int interval = Integer.parseInt(intervals);
		if("0".equals(frequencyType)){
			Date cycleStartDate = DateUtils.getDateTimeByString(hmsStr+" "+dateTime);
			curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, day_to_minutes*counts*interval);
		}else if("1".equals(frequencyType)){
			Date cycleStartDate = DateUtils.getDateTimeByString(dateTime);
			curStartTime=DateUtils.addMinutesToDateTime(cycleStartDate, week_to_minutes*counts);
		}
		return curStartTime;
	}
	
	public static void main(String[] args){
		PlanExecuteRecordService service=new PlanExecuteRecordService();
		Date startTime=DateUtils.getDateTimeByString("2016-11-30 08:00:00");
		for (int i = 0; i <2; i++) {
			startTime=service.calExeTimeNew(startTime, 2, "0", "0", "08:00:00");
			System.out.println(startTime.toLocaleString());
		}
	}
}
