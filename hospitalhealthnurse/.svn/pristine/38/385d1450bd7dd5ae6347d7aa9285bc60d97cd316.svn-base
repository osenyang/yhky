package com.elink.hospitalhealthnurse.modules.plan.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.InterveneDao;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.plan.entity.PlanExecuteRecord;
import com.elink.hospitalhealthnurse.modules.plan.vo.TvWallPlanExecuteVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.TvWallPlanRecordVO;


/**
 * 计划Service
 * @author yfy
 * @version 2016-11-21
 */
@Component
@Transactional(readOnly = true)
public class TvWallPlanService extends BaseService {

	@Autowired
	private InterveneDao interveneDao;
	
	/**
	 * 查询正在执行计划的老人
	 * @param planType
	 * @return
	 */
	public List<TvWallPlanRecordVO> findTodayPlanByPlanType(String planType) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.archives_id,t3.bed_number,t3.full_nm elder_name,t4.area_nm inpatient_nm");
		sb.append(" FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN hn_intervene t2 on t1.intervene_id = t2.id ");
		sb.append(" LEFT JOIN hn_health_archives t3 on t1.archives_id = t3.id ");
		sb.append("left join hn_health_inpatient t4 on t3.inpatient_id = t4.id ");
		sb.append(" WHERE t1.del_flag = '"+PlanExecuteRecord.DEL_FLAG_NORMAL+"'");
		sb.append(" AND t1.plan_Type = '"+planType+"'");
		sb.append(" AND t2.state = '"+Intervene.INTER_STATE_EXECUTE+"'");
		sb.append(" AND DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
		sb.append(" GROUP BY archives_id");
		sb.append(" ORDER BY t3.bed_number+0,t1.expected_start_time");
		return interveneDao.findBySqlExt(sb.toString(),null,TvWallPlanRecordVO.class);
	}
	
	/**
	 * 查询老人对应的今日计划
	 * @param archivesId
	 * @param planType
	 * @return
	 */
	public List<TvWallPlanExecuteVO> findTodayPlanByArchivesId(String archivesId,String planType) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.service_user_id,t1.quarters_id,t2.`name` service_user_name,t3.`name` quarters_name,t1.project_name,");
		sb.append("DATE_FORMAT(t1.expected_start_time, '%H:%i') expected_start_time,DATE_FORMAT(t1.start_time, '%H:%i') start_time,");
		sb.append("DATE_FORMAT(t1.stop_time, '%H:%i') stop_time");
		sb.append(" FROM hn_plan_execute_record t1");
		sb.append(" LEFT JOIN sys_service_user t2 on t1.service_user_id = t2.id");
		sb.append(" LEFT JOIN sys_quarters t3 on t1.quarters_id = t3.id ");
		sb.append(" LEFT JOIN hn_intervene t4 on t1.intervene_id = t4.id ");
		sb.append(" LEFT JOIN hn_health_archives t5 on t1.archives_id = t5.id ");
		sb.append(" WHERE t1.del_flag = '"+PlanExecuteRecord.DEL_FLAG_NORMAL+"'");
		sb.append(" AND t1.plan_Type = '"+planType+"'");
		sb.append(" AND t4.state = '"+Intervene.INTER_STATE_EXECUTE+"'");
		sb.append(" AND t1.archives_id = '"+archivesId+"'");
		sb.append(" AND DATE_FORMAT(t1.expected_start_time, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
		sb.append(" ORDER BY t1.expected_start_time asc");
		return interveneDao.findBySqlExt(sb.toString(),null,TvWallPlanExecuteVO.class);
	}
	
}
