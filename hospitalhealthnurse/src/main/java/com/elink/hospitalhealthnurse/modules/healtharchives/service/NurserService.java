package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nurser;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.NurserVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.NurserDao;

/**
 * 照护计划Service
 * @author 杜康
 * @version 2016-10-26
 */
@Component
@Transactional(readOnly = true)
public class NurserService extends BaseService {

	@Autowired
	private NurserDao nurserDao;
	
	public Nurser get(String id) {
		return nurserDao.get(id);
	}
	
	public Page<Nurser> find(Page<Nurser> page, Nurser nurser) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_nurser t");
		sb.append(" WHERE t.del_flag = '"+Nurser.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return nurserDao.findBySqlExt(page, sb.toString(), Nurser.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Nurser nurser) {
		nurserDao.save(nurser);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		nurserDao.deleteById(id);
	}
	/**
	 * 根据ID查询照护计划
	 * @author dk
	 * @data 2016-11-16
	 * @param Id
	 * @return 
	 * */
	public NurserVO findByIdWs(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.img_url nurse_photo,t2.img_url doctor_photo,t3.img_url director_photo, t.* from hn_health_nurser t ");
		sql.append(" left join sys_service_user t1 on t1.job_number = t.nurse_id ");
		sql.append(" left join sys_service_user t2 on t2.job_number = t.doctor_id ");
		sql.append(" left join sys_service_user t3 on t3.job_number = t.director_id  ");
		sql.append(" where t.id = '"+id+"'");
		List<NurserVO> nurserList = nurserDao.findBySqlExt(sql.toString(), null, NurserVO.class);
		if(nurserList != null && nurserList.size() > 0){
			return nurserList.get(0);
		}
		return new NurserVO();
	}
}
