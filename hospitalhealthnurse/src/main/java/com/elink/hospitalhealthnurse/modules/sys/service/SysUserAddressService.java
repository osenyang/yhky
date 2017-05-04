package com.elink.hospitalhealthnurse.modules.sys.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.sys.dao.SysUserAddressDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.SysUserAddress;

/**
 * 收获地址Service
 * @author 周贤舟
 * @version 2015-06-12
 */
@Component
@Transactional(readOnly = true)
public class SysUserAddressService extends BaseService {

	@Autowired
	private SysUserAddressDao sysUserAddressDao;
	
	public SysUserAddress get(String id) {
		return sysUserAddressDao.get(id);
	}
	
	/**
	 * 根据userId查询收获地址
	 * @param userId
	 * @return
	 * @author 周贤舟 2015年6月12日
	 */
	public List<SysUserAddress> find(String userId) {
		DetachedCriteria dc = sysUserAddressDao.createDetachedCriteria();
		dc.add(Restrictions.eq("userId", userId));
		dc.addOrder(Order.desc("createDate"));
		return sysUserAddressDao.find(dc);
	}
	
	@Transactional(readOnly = false)
	public void save(SysUserAddress sysUserAddress) {
		sysUserAddressDao.save(sysUserAddress);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		sysUserAddressDao.deleteByIdPhysic(id);
	}
	
}
