package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Assessment;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.AssessmentVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.AssessmentDao;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanAssessmentVO;

/**
 * 诊疗计划Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class AssessmentService extends BaseService {

	@Autowired
	private AssessmentDao assessmentDao;
	
	public Assessment get(String id) {
		return assessmentDao.get(id);
	}
	
	public Page<Assessment> find(Page<Assessment> page, Assessment assessment) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_assessment t");
		sb.append(" WHERE t.del_flag = '"+Assessment.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return assessmentDao.findBySqlExt(page, sb.toString(), Assessment.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Assessment assessment) {
		assessmentDao.save(assessment);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		assessmentDao.deleteById(id);
	}
	/***
	 * 根据ID查询护理计划
	 * @param id
	 * @return
	 */
	public AssessmentVO findByIdWs(String id) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t1.img_url nurse_photo,t2.img_url doctor_photo,t3.img_url director_photo, t.* FROM hn_health_assessment t");
		sb.append(" left join sys_service_user t1 on t1.job_number = t.nurse_id ");
		sb.append(" left join sys_service_user t2 on t2.job_number = t.doctor_id ");
		sb.append(" left join sys_service_user t3 on t3.job_number = t.director_id  ");
		sb.append(" WHERE t.id = '"+id+"'");
		List<AssessmentVO> aList=assessmentDao.findBySqlExt(sb.toString(), null, AssessmentVO.class);
		if(aList!=null&&aList.size()>0){
			return aList.get(0);
		}
		return new AssessmentVO();
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	public ElderPlanAssessmentVO findVOById(String id) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t1.*,t2.archives_id,t3.full_nm elder_name,t3.photo elder_photo FROM hn_health_assessment t1");
		sb.append(" left join hn_intervene t2 on t2.assessment_id=t1.id");
	    sb.append("l eft join hn_health_archives t3 on t2.archives_id=t3.id");
		sb.append(" WHERE t.id = '"+id+"'");
		List<ElderPlanAssessmentVO> aList=assessmentDao.findBySqlExt(sb.toString(), null, ElderPlanAssessmentVO.class);
		if(aList!=null&&aList.size()>0)
			return aList.get(0);
		return new ElderPlanAssessmentVO();
	}
	
}
