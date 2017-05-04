package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthInpatient;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.HealthInpatientDao;

/**
 * 病区管理Service
 * @author 杜康
 * @version 2017-03-27
 */
@Component
@Transactional(readOnly = true)
public class HealthInpatientService extends BaseService {

	@Autowired
	private HealthInpatientDao healthInpatientDao;
	
	public HealthInpatient get(String id) {
		return healthInpatientDao.get(id);
	}
	
	public Page<HealthInpatient> find(Page<HealthInpatient> page, HealthInpatient healthInpatient) {
		User user = UserUtils.getUser();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_inpatient t");
		sb.append(" WHERE t.del_flag = '"+HealthInpatient.DEL_FLAG_NORMAL+"'");
		if(!user.isAdmin()){
			sb.append(" and t.office_id = '"+user.getOffice().getId()+"'");
		}
		sb.append(" ORDER BY t.create_date desc");
		return healthInpatientDao.findBySqlExt(page, sb.toString(), HealthInpatient.class);
	}
	
	@Transactional(readOnly = false)
	public void save(HealthInpatient healthInpatient) {
		healthInpatientDao.save(healthInpatient);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		healthInpatientDao.deleteById(id);
	}
	
	/**
	 * 查询机构下的所有病区
	 * */
	public List<HealthInpatient> findByOfficeId(String officeId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_inpatient t");
		sb.append(" WHERE t.del_flag = '"+HealthInpatient.DEL_FLAG_NORMAL+"'");
		sb.append(" and t.office_id = '"+officeId+"'");
		sb.append(" ORDER BY t.create_date desc");
		return healthInpatientDao.findBySqlExt(sb.toString(), null, HealthInpatient.class);
	}
	
	/**
	 * 查询机构下的所有病区
	 * */
	public List<HealthInpatient> findByOfficeIdWs(String officeId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_inpatient t");
		sb.append(" WHERE t.del_flag = '"+HealthInpatient.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(officeId)){
			sb.append(" and t.office_id = '"+officeId+"'");
		}
		sb.append(" ORDER BY t.create_date desc");
		return healthInpatientDao.findBySqlExt(sb.toString(), null, HealthInpatient.class);
	}
}
