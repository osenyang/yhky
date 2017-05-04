package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Recover;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.RecoverVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.RecoverDao;

/**
 * 康复计划Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class RecoverService extends BaseService {

	@Autowired
	private RecoverDao recoverDao;
	
	public Recover get(String id) {
		return recoverDao.get(id);
	}
	
	public Page<Recover> find(Page<Recover> page, Recover recover) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_recover t");
		sb.append(" WHERE t.del_flag = '"+Recover.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return recoverDao.findBySqlExt(page, sb.toString(), Recover.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Recover recover) {
		recoverDao.save(recover);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		recoverDao.deleteById(id);
	}
	/**
	 * 根据ID查询康复计划
	 * @author dk
	 * @data 2016-11-16
	 * @param Id
	 * @return 
	 * */
	public RecoverVO findByIdWs(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.img_url doctor_photo, t.* from hn_health_recover t");
		sql.append(" left join sys_service_user t1 on t1.job_number = t.doctor_id ");
		sql.append(" where t.id = '"+id+"'");
		List<RecoverVO> recoverVOList = recoverDao.findBySqlExt(sql.toString(), null, RecoverVO.class);
		if(recoverVOList != null && recoverVOList.size() > 0){
			return recoverVOList.get(0);
		}
		return new RecoverVO();
	}
}
