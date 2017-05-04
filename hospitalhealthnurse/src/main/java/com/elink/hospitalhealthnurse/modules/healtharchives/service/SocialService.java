package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Social;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.SocialDao;

/**
 * 社工计划Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class SocialService extends BaseService {

	@Autowired
	private SocialDao socialDao;
	
	public Social get(String id) {
		return socialDao.get(id);
	}
	
	public Page<Social> find(Page<Social> page, Social social) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_social t");
		sb.append(" WHERE t.del_flag = '"+Social.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return socialDao.findBySqlExt(page, sb.toString(), Social.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Social social) {
		socialDao.save(social);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		socialDao.deleteById(id);
	}
	
}
