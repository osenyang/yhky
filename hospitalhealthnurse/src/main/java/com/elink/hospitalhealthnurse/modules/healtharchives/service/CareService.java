package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Care;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.CareVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.CareDao;

/**
 * 护理计划Service
 * @author 杜康
 * @version 2016-10-28
 */
@Component
@Transactional(readOnly = true)
public class CareService extends BaseService {

	@Autowired
	private CareDao careDao;
	
	public Care get(String id) {
		return careDao.get(id);
	}
	
	public Page<Care> find(Page<Care> page, Care care) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_care t");
		sb.append(" WHERE t.del_flag = '"+Care.DEL_FLAG_NORMAL+"'");
		
//		if(StringUtils.isNotBlank(care.getName())){
//			sb.append(" AND t.name like '%"+care.getName()+"%'");
//		}
		
		sb.append(" ORDER BY t.create_date desc");
		return careDao.findBySqlExt(page, sb.toString(), Care.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Care care) {
		careDao.save(care);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		careDao.deleteById(id);
	}
	
	
	/**
	 * 根据ID查询护理计划
	 * @author dk
	 * @data 2016-11-15
	 * @param Id
	 * @return 
	 * */
	public CareVO findByIdWs(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from hn_health_care t where id = '"+id+"'");
		List<CareVO> careList = careDao.findBySqlExt(sql.toString(), null, CareVO.class);
		if(careList != null && careList.size() > 0){
			return careList.get(0);
		}
		return new CareVO();
	}
}
