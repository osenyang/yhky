package com.elink.hospitalhealthnurse.modules.serviceorg.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.elink.hospitalhealthnurse.common.persistence.BaseDao;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;

/**
 * 服务人员信息DAO接口
 * @author 颜福艳
 * @version 2016-10-09
 */
@Repository
public class ServiceUserDao extends BaseDao<ServiceUser> {
	
	/***
	 * 获取下一个服务人员工号,自动生成
	 * @param sequenceNm
	 * @return
	 */
	public String getNextJobNumber(String sequenceNm){
		return StringUtils.leftFillZero(5,String.valueOf(this.getNextValue(sequenceNm)));
	}
	
	
	public ServiceUser getByJobNo(String jobNo){
		String hql = "FROM ServiceUser WHERE jobNumber = :jobNo";
		Query query = getSession().createQuery(hql);
		query.setString("jobNo", jobNo);
		
		return (ServiceUser) query.uniqueResult();
	}
	
}
