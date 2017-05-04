package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.ExtraItems;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.ExtraItemsVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.ExtraItemsDao;

/**
 * 额外项目Service
 * @author 杜康
 * @version 2017-04-11
 */
@Component
@Transactional(readOnly = true)
public class ExtraItemsService extends BaseService {

	@Autowired
	private ExtraItemsDao extraItemsDao;
	
	public ExtraItems get(String id) {
		return extraItemsDao.get(id);
	}
	
	public Page<ExtraItems> find(Page<ExtraItems> page, ExtraItems extraItems) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_extra_items t");
		sb.append(" WHERE t.del_flag = '"+ExtraItems.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return extraItemsDao.findBySqlExt(page, sb.toString(), ExtraItems.class);
	}
	
	@Transactional(readOnly = false)
	public void save(ExtraItems extraItems) {
		extraItemsDao.save(extraItems);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		extraItemsDao.deleteById(id);
	}
	
}
