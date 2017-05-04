package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.InterveneMeet;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.InterveneMeetDao;

/**
 * 干预方案——应急计划关联表Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class InterveneMeetService extends BaseService {

	@Autowired
	private InterveneMeetDao interveneMeetDao;
	
	public InterveneMeet get(String id) {
		return interveneMeetDao.get(id);
	}
	
	public Page<InterveneMeet> find(Page<InterveneMeet> page, InterveneMeet interveneMeet) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_intervene_meet t");
		sb.append(" WHERE t.del_flag = '"+InterveneMeet.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return interveneMeetDao.findBySqlExt(page, sb.toString(), InterveneMeet.class);
	}
	
	@Transactional(readOnly = false)
	public void save(InterveneMeet interveneMeet) {
		interveneMeetDao.update("delete InterveneMeet where interveneId = :p1 and meetId=  :p2",
	            new Parameter(interveneMeet.getInterveneId(),interveneMeet.getMeetId()));
		interveneMeetDao.save(interveneMeet);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		interveneMeetDao.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void deleteByMeetId(String meetId) {
		String sql = "delete InterveneMeet where meetId = '"+meetId+"'";
		interveneMeetDao.update(sql);
	}
	
}
