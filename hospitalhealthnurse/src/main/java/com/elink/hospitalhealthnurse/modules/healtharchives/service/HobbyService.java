package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Hobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HobbyVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.HobbyDao;

/**
 * 兴趣爱好Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class HobbyService extends BaseService {

	@Autowired
	private HobbyDao hobbyDao;
	
	public Hobby get(String id) {
		return hobbyDao.get(id);
	}
	
	public Page<Hobby> find(Page<Hobby> page, Hobby hobby) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_hobby t");
		sb.append(" WHERE t.del_flag = '"+Hobby.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return hobbyDao.findBySqlExt(page, sb.toString(), Hobby.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Hobby hobby) {
		hobbyDao.save(hobby);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		hobbyDao.deleteById(id);
	}
	/**
	 * 根据方案ID查询兴趣爱好
	 * @author dk
	 * @data 2016-11-8 
	 * 
	 * */
	public List<Hobby> findByInterveneId(String interveneId){
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from hn_health_hobby t ");
		sql.append(" left join hn_recover_hobby t1 on t.id = t1.hobby_id ");
		sql.append(" left join hn_intervene t2 on t1.recover_id = t2.id ");
		sql.append(" where 1=1 ");
		sql.append(" and t2.id = '"+interveneId+"'");
		return hobbyDao.findBySqlExt(sql.toString(), null, Hobby.class);
	}
	
	@Transactional(readOnly = false)
	public void deleteById(String id) {
		hobbyDao.deleteByIdPhysic(id);
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	public HobbyVO findByIdWs(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from hn_health_hobby t where id = '"+id+"'");
		List<HobbyVO> hobbyList = hobbyDao.findBySqlExt(sql.toString(), null, HobbyVO.class);
		if(hobbyList != null && hobbyList.size() > 0){
			return hobbyList.get(0);
		}
		return new HobbyVO();
	}
}
