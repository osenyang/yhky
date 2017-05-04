package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthAssess;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.HealthAssessDao;

/**
 * 评估Service
 * @author 杜康
 * @version 2017-04-12
 */
@Component
@Transactional(readOnly = true)
public class HealthAssessService extends BaseService {

	@Autowired
	private HealthAssessDao healthAssessDao;
	
	public HealthAssess get(String id) {
		return healthAssessDao.get(id);
	}
	
	public Page<HealthAssess> find(Page<HealthAssess> page, HealthAssess healthAssess) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_assess t");
		sb.append(" WHERE t.del_flag = '"+HealthAssess.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return healthAssessDao.findBySqlExt(page, sb.toString(), HealthAssess.class);
	}
	
	@Transactional(readOnly = false)
	public void save(HealthAssess healthAssess) {
		healthAssessDao.save(healthAssess);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		healthAssessDao.deleteById(id);
	}
	/**
	 * 根据档案ID查询评估记录
	 * */
	public List<HealthAssess> findByArchivesId(String archivesId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_assess t ");
		sb.append(" WHERE t.del_flag = '"+HealthAssess.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(archivesId)){
			sb.append(" and t.archives_id = '"+archivesId+"'");
		}
		return healthAssessDao.findBySqlExt(sb.toString(), null, HealthAssess.class);
	}
}
