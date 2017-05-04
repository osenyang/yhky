package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HostoryPlan;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HostoryPlanVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.HostoryPlanDao;

/**
 * 历史方案Service
 * @author 杜康
 * @version 2017-04-11
 */
@Component
@Transactional(readOnly = true)
public class HostoryPlanService extends BaseService {

	@Autowired
	private HostoryPlanDao hostoryPlanDao;
	
	public HostoryPlan get(String id) {
		return hostoryPlanDao.get(id);
	}
	
	public Page<HostoryPlan> find(Page<HostoryPlan> page, HostoryPlan hostoryPlan) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_hostory_plan t");
		sb.append(" WHERE t.del_flag = '"+HostoryPlan.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return hostoryPlanDao.findBySqlExt(page, sb.toString(), HostoryPlan.class);
	}
	
	@Transactional(readOnly = false)
	public void save(HostoryPlan hostoryPlan) {
		hostoryPlanDao.save(hostoryPlan);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		hostoryPlanDao.deleteById(id);
	}
	
}
