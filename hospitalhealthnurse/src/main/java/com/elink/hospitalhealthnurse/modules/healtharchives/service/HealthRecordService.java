package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthRecord;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthRecordVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.HealthRecordDao;

/**
 * 健康记录Service
 * @author 颜福艳
 * @version 2016-11-01
 */
@Component
@Transactional(readOnly = true)
public class HealthRecordService extends BaseService {

	@Autowired
	private HealthRecordDao healthRecordDao;
	
	public HealthRecord get(String id) {
		return healthRecordDao.get(id);
	}
	
	public Page<HealthRecordVO> find(Page<HealthRecordVO> page, HealthRecordVO healthRecord) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,t1.full_nm,t1.sex,t1.photo,t1.birth_date,t1.bed_number,t1.hospitalization_number,t2.area_nm inpatient_nm");
		sb.append("	FROM hn_health_record t");
		sb.append("	LEFT JOIN hn_health_archives t1 ON t1.user_id = t.user_id");
		sb.append("	LEFT JOIN hn_health_inpatient t2 ON t1.inpatient_id = t2.id");
		sb.append(" WHERE t.del_flag = '"+HealthRecord.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(healthRecord.getFullNm())){
			sb.append(" AND t1.full_nm like '%"+healthRecord.getFullNm()+"%'");
		}
		
		if(StringUtils.isNotBlank(healthRecord.getBedNumber())){
			sb.append(" AND t1.bed_number like '%"+healthRecord.getBedNumber()+"%'");
		}
		
		if(StringUtils.isNotBlank(healthRecord.getHospitalizationNumber())){
			sb.append(" AND t1.hospitalization_number like '%"+healthRecord.getHospitalizationNumber()+"%'");
		}
		
		if(StringUtils.isNotBlank(healthRecord.getInpatientNm())){
			sb.append(" AND t2.area_nm like '%"+healthRecord.getInpatientNm()+"%'");
		}
		
		sb.append(" ORDER BY t.create_date desc");
		return healthRecordDao.findBySqlExt(page, sb.toString(), HealthRecordVO.class);
	}
	
	@Transactional(readOnly = false)
	public void save(HealthRecord healthRecord) {
		healthRecordDao.save(healthRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		healthRecordDao.deleteById(id);
	}
	
}
