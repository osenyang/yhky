package com.elink.hospitalhealthnurse.modules.plan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.InterveneDao;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanAssessmentVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanCareVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanSocialVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanMeetVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNurserVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanNutritionVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanRecoverVO;


/**
 * 计划Service
 * @author 王宴萍
 * @version 2016-10-11
 */
@Component
@Transactional(readOnly = true)
public class PlanService extends BaseService {

	@Autowired
	private InterveneDao interveneDao;
	
	/***
	 * 查询机构的老人正在执行的方案信息
	 * @return
	 */
	public List<ElderPlanExecuteRecordVO> findElderIntervene() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.id,t2.archives_id,t1.bed_number,t1.full_nm elder_name,t1.state,t1.health_risk,t3.doctor_id,t3.doctor_nm");
		sb.append(" FROM hn_health_archives t1 ");
		sb.append(" JOIN hn_intervene t2 ON t1.id=t2.archives_id and t2.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"'");
		sb.append(" LEFT JOIN hn_health_assessment t3 ON t3.id=t2.assessment_id ");
		sb.append(" WHERE t2.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' order by t1.bed_number+0");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanExecuteRecordVO.class);
	}
	
	/***
	 * 查询机构的老人正在执行的方案信息
	 * @return
	 */
	public List<ElderPlanExecuteRecordVO> findElderInterveneWs(String inpatientId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.id,t2.archives_id,t1.bed_number,t1.full_nm elder_name,t1.state,t1.health_risk,t3.doctor_id,t3.doctor_nm");
		sb.append(" FROM hn_health_archives t1 ");
		sb.append(" JOIN hn_intervene t2 ON t1.id=t2.archives_id and t2.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"'");
		sb.append(" LEFT JOIN hn_health_assessment t3 ON t3.id=t2.assessment_id ");
		sb.append(" WHERE t2.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='"+Intervene.DEL_FLAG_NORMAL+"' ");
		if(StringUtils.isNotBlank(inpatientId)){
			sb.append(" and t1.inpatient_id = '"+inpatientId+"'");
		}
		sb.append(" order by t1.bed_number+0");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanExecuteRecordVO.class);
	}
	/***
	 * 查询方案对应的诊疗计划
	 * @param id 方案id
	 * @return
	 */
	public List<ElderPlanAssessmentVO> findAssessmentPlans(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.*,t1.id intervene_id,t1.archives_id,t2.id recover_hobby_id,t3.quarters_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_assessment t2 ON t1.assessment_id=t2.id ");
		sb.append(" LEFT JOIN sys_service_user t3 ON t2.doctor_id=t3.job_number ");
		sb.append(" WHERE t1.id = '"+id+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanAssessmentVO.class);
	}
	/***
	 * 查询方案对应的社工-喜好计划
	 * @param id 方案id
	 * @return
	 */
	public List<ElderPlanSocialVO> findSoialPlans(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.*,t1.id intervene_id,t1.archives_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_social t2 on t1.social_id=t2.id");
		sb.append(" WHERE t1.id = '"+id+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanSocialVO.class);
	}
	/***
	 * 查询方案对应的应急计划
	 * @param id 方案id
	 * @return
	 */
	public List<ElderPlanMeetVO> findMeetPlans(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t3.*,t1.id intervene_id,t1.archives_id,t2.id intervene_meet_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_intervene_meet t2 ON t1.id=t2.intervene_id ");
		sb.append(" LEFT JOIN hn_health_meet t3 on t2.meet_id=t3.id");
		sb.append(" WHERE t1.id = '"+id+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanMeetVO.class);
	}
	/***
	 * 查询方案对应的营养计划
	 * @param id 方案id
	 * @return
	 */
	public List<ElderPlanNutritionVO> findNutritionPlans(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_nutrition t2 ON t1.nutrition_id=t2.id ");
		sb.append(" WHERE t1.id = '"+id+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanNutritionVO.class);
	}
	/***
	 *查询方案对应的康复计划
	 *@param id 方案id
	 * @return
	 */
	public List<ElderPlanRecoverVO> findRecoverPlans(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_recover t2 ON t1.recover_id=t2.id ");
		sb.append(" WHERE t1.id = '"+id+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanRecoverVO.class);
	}
	/***
	 * 查询方案对应的护理计划
	 * @param id 方案id
	 * @return
	 */
	public List<ElderPlanCareVO> findCarePlans(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_care t2 ON t1.care_id=t2.id ");
		sb.append(" WHERE t1.id = '"+id+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanCareVO.class);
	}
	/***
	 * 查询方案对应的照护计划
	 * @param id 方案id
	 * @return
	 */
	public List<ElderPlanNurserVO> findNurserPlans(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append("LEFT JOIN hn_health_nurser t2 ON t1.nurser_id=t2.id ");
		sb.append("WHERE t1.id = '"+id+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanNurserVO.class);
	}
	/***
	 * 查询老人的正在执行的诊疗计划
	 * @return
	 */
	/*public List<ElderPlanAssessmentVO> findElderTodayAssessmentPlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.*,t1.id intervene_id,t1.archives_id,t2.id recover_hobby_id,t3.quarters_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_assessment t2 ON t1.assessment_id=t2.id ");
		sb.append(" LEFT JOIN sys_service_user t3 ON t2.doctor_id=t3.job_number ");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanAssessmentVO.class);
	}*/
	/***
	 * 查询老人的正在执行的社工-喜好计划
	 * @return
	 */
	public List<ElderPlanSocialVO> findElderTodaySocialPlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.*,t1.id intervene_id,t1.archives_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_social t2 on t1.social_id=t2.id");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanSocialVO.class);
	}
	/***
	 * 查询老人的正在执行的应急计划
	 * @return
	 */
	public List<ElderPlanMeetVO> findElderTodayMeetPlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t3.*,t1.id intervene_id,t1.archives_id,t2.id intervene_meet_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_intervene_meet t2 ON t1.id=t2.intervene_id ");
		sb.append(" LEFT JOIN hn_health_meet t3 on t2.meet_id=t3.id");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanMeetVO.class);
	}
	/***
	 * 查询老人的正在执行的营养计划
	 * @return
	 */
	public List<ElderPlanNutritionVO> findElderTodayNutritionPlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_nutrition t2 ON t1.nutrition_id=t2.id ");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanNutritionVO.class);
	}
	/***
	 * 查询老人的正在执行的康复计划
	 * @return
	 */
	public List<ElderPlanRecoverVO> findElderTodayRecoverPlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_recover t2 ON t1.recover_id=t2.id ");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanRecoverVO.class);
	}
	/***
	 * 查询老人的正在执行的护理计划
	 * @return
	 */
	public List<ElderPlanCareVO> findElderTodayCarePlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_care t2 ON t1.care_id=t2.id ");
		sb.append(" WHERE t1.archives_id = '"+archivesId+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanCareVO.class);
	}
	/***
	 * 查询老人的正在执行的照护计划
	 * @return
	 */
	public List<ElderPlanNurserVO> findElderTodayNurserPlans(String archivesId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append("LEFT JOIN hn_health_nurser t2 ON t1.nurser_id=t2.id ");
		sb.append("WHERE t1.archives_id = '"+archivesId+"' and t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanNurserVO.class);
	}
	/***
	 * 查询机构的老人正在执行的诊疗计划
	 * @return
	 */
	public List<ElderPlanAssessmentVO> findElderTodayAssessmentPlans() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.*,t1.id intervene_id,t1.archives_id,t2.id recover_hobby_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_assessment t2 ON t1.assessment_id=t2.id ");
		sb.append(" WHERE t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanAssessmentVO.class);
	}
	/***
	 * 查询机构的老人正在执行的社工-喜好计划
	 * @return
	 */
	public List<ElderPlanSocialVO> findElderTodaySocialPlans() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t2.*,t1.id intervene_id,t1.archives_id,t2.id recover_hobby_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_recover_hobby t2 ON t1.id=t2.recover_id ");
		sb.append(" LEFT JOIN hn_health_hobby t2 on t2.hobby_id=t3.id");
		sb.append(" WHERE t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanSocialVO.class);
	}
	/***
	 * 查询机构的老人正在执行的应急计划
	 * @return
	 */
	public List<ElderPlanMeetVO> findElderTodayMeetPlans() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t3.*,t1.id intervene_id,t1.archives_id,t2.id intervene_meet_id");
		sb.append(" FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_intervene_meet t2 ON t1.id=t2.intervene_id ");
		sb.append(" LEFT JOIN hn_health_meet t3 on t2.meet_id=t3.id");
		sb.append(" WHERE t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanMeetVO.class);
	}
	/***
	 * 查询机构的老人正在执行的营养计划
	 * @return
	 */
	public List<ElderPlanNutritionVO> findElderTodayNutritionPlans() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_nutrition t2 ON t1.nutrition_id=t2.id ");
		sb.append(" WHERE t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanNutritionVO.class);
	}
	/***
	 * 查询机构的老人正在执行的康复计划
	 * @return
	 */
	public List<ElderPlanRecoverVO> findElderTodayRecoverPlans() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_recover t2 ON t1.recover_id=t2.id ");
		sb.append(" WHERE t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanRecoverVO.class);
	}
	/***
	 * 查询机构的老人正在执行的护理计划
	 * @return
	 */
	public List<ElderPlanCareVO> findElderTodayCarePlans() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" t2.*,t1.id intervene_id,t1.archives_id FROM hn_intervene t1 ");
		sb.append(" LEFT JOIN hn_health_care t2 ON t1.care_id=t2.id ");
		sb.append(" WHERE t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanCareVO.class);
	}
	/***
	 * 查询机构的老人正在执行的照护计划
	 * @return
	 */
	public List<ElderPlanNurserVO> findElderTodayNurserPlans() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("t2.*,t1.id intervene_id,t1.archives_id  FROM hn_intervene t1 ");
		sb.append("LEFT JOIN hn_health_nurser t2 ON t1.nurser_id=t2.id ");
		sb.append("WHERE t1.state='"+Intervene.INTER_STATE_EXECUTE+"' AND t1.del_flag ='0' ");
		return interveneDao.findBySqlExt(sb.toString(),null,ElderPlanNurserVO.class);
	}
}
