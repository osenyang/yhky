package com.elink.hospitalhealthnurse.modules.sys.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.sys.dao.AboutDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.About;

/**
 * 关于我们Service
 * @author 周贤舟
 * @version 2015-08-11
 */
@Component
@Transactional(readOnly = true)
public class AboutService extends BaseService {

	@Autowired
	private AboutDao aboutDao;
	
	public About get(String id) {
		return aboutDao.get(id);
	}
	
	public List<About> find(About about) {
		DetachedCriteria dc = aboutDao.createDetachedCriteria();
		if(StringUtils.isNotBlank(about.getType())){
			dc.add(Restrictions.eq("type", about.getType())); 
		}
		dc.addOrder(Order.desc("id"));
		return aboutDao.find(dc);
	}
	
	@Transactional(readOnly = false)
	public void save(About about) {
		aboutDao.save(about);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		aboutDao.deleteById(id);
	}
	
}
