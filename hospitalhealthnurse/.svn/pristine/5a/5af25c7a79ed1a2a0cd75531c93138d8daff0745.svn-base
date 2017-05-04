package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Frequencys;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.FrequencysVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.FrequencysDao;

/**
 * 计划频次Service
 * @author 杜康
 * @version 2017-03-17
 */
@Component
@Transactional(readOnly = true)
public class FrequencysService extends BaseService {

	@Autowired
	private FrequencysDao frequencysDao;
	
	public Frequencys get(String id) {
		return frequencysDao.get(id);
	}
	
	public Page<Frequencys> find(Page<Frequencys> page, Frequencys frequencys) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_frequency t");
		sb.append(" WHERE t.del_flag = '"+Frequencys.DEL_FLAG_NORMAL+"'");
		
		sb.append(" ORDER BY t.create_date desc");
		return frequencysDao.findBySqlExt(page, sb.toString(), Frequencys.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Frequencys frequencys) {
		frequencysDao.save(frequencys);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		frequencysDao.deleteById(id);
	}
	
}
