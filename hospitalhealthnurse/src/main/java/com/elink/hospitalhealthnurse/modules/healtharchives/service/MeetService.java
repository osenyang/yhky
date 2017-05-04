package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Meet;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.MeetVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.MeetDao;

/**
 * 应急计划Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class MeetService extends BaseService {

	@Autowired
	private MeetDao meetDao;
	
	public Meet get(String id) {
		return meetDao.get(id);
	}
	
	public Page<Meet> find(Page<Meet> page, Meet meet) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_meet t");
		sb.append(" WHERE t.del_flag = '"+Meet.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return meetDao.findBySqlExt(page, sb.toString(), Meet.class);
	}
	/**
	 * 根据方案ID查询应急计划
	 * @author dk
	 * @data 2016-11-8 
	 * 
	 * */
	public List<Meet> findByInterveneId(String interveneId){
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from hn_health_meet t ");
		sql.append(" left join hn_intervene_meet t1 on t.id = t1.meet_id ");
		sql.append(" left join hn_intervene t2 on t1.intervene_id = t2.id ");
		sql.append(" where 1=1 ");
		sql.append(" and t2.id = '"+interveneId+"'");
		return meetDao.findBySqlExt(sql.toString(), null, Meet.class);
	}
	@Transactional(readOnly = false)
	public void save(Meet meet) {
		meetDao.save(meet);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		meetDao.deleteById(id);
	}
	
	
	@Transactional(readOnly = false)
	public void deleteById(String id) {
		meetDao.deleteByIdPhysic(id);
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	public MeetVO findByIdWs(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from hn_health_meet t where id = '"+id+"'");
		List<MeetVO> voList = meetDao.findBySqlExt(sql.toString(), null, MeetVO.class);
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new MeetVO();
	}
}
