package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.RecoverHobby;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.RecoverHobbyDao;

/**
 * 社工计划--兴趣爱好关联表Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class RecoverHobbyService extends BaseService {

	@Autowired
	private RecoverHobbyDao recoverHobbyDao;
	
	public RecoverHobby get(String id) {
		return recoverHobbyDao.get(id);
	}
	
	public Page<RecoverHobby> find(Page<RecoverHobby> page, RecoverHobby recoverHobby) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_recover_hobby t");
		sb.append(" WHERE t.del_flag = '"+RecoverHobby.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return recoverHobbyDao.findBySqlExt(page, sb.toString(), RecoverHobby.class);
	}
	
	@Transactional(readOnly = false)
	public void save(RecoverHobby recoverHobby) {
		recoverHobbyDao.update("delete RecoverHobby where hobbyId = :p1 and recoverId=  :p2",
	            new Parameter(recoverHobby.getHobbyId(),recoverHobby.getRecoverId()));
		recoverHobbyDao.save(recoverHobby);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		recoverHobbyDao.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void deleteByHobbyId(String hobbyId) {
		String sql = "delete RecoverHobby where hobbyId = '"+hobbyId+"'";
		recoverHobbyDao.update(sql);
	}
	
}
