package com.elink.hospitalhealthnurse.modules.serviceorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.serviceorg.dao.ServiceUserDao;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.vo.ServiceUserVO;

/**
 * 服务人员信息Service
 * @author 颜福艳
 * @version 2016-10-09
 */
@Component
@Transactional(readOnly = true)
public class ServiceUserService extends BaseService {

	@Autowired
	private ServiceUserDao serviceUserDao;
	
	public ServiceUser get(String id) {
		return serviceUserDao.get(id);
	}
	
	public Page<ServiceUserVO> find(Page<ServiceUserVO> page, ServiceUserVO serviceUser) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.office_id,t.name,t.quarters_id,t.department_id,t.sex,t.mobile,t.job_number,t.thumb_img,t.img_url,");
		sb.append("DATE_FORMAT(t.birth_date, '%Y-%m-%d') birth_date,DATE_FORMAT(t.create_date, '%Y-%m-%d %H:%i') create_date,");
		sb.append("t1.`name` office_nm,t2.`name` department_nm,t3.`name` quarters_nm");
		sb.append("	FROM sys_service_user t");
		sb.append("	LEFT JOIN sys_office t1 ON t1.id = t.office_id ");
		sb.append("	LEFT JOIN sys_department t2 ON t2.id = t.department_id ");
		sb.append("	LEFT JOIN sys_quarters t3 ON t3.id = t.quarters_id ");
		sb.append(" WHERE t.del_flag = '"+ServiceUser.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(serviceUser.getName())){
			sb.append(" AND t.name like '%"+serviceUser.getName()+"%'");
		}
		if (StringUtils.isNotEmpty(serviceUser.getOfficeId())){
			sb.append(" AND t.office_id = '"+serviceUser.getOfficeId()+"'");
		}
		if (StringUtils.isNotEmpty(serviceUser.getDepartmentId())){
			sb.append(" and (t2.id = '"+serviceUser.getDepartmentId()+"' or t2.parent_id = '" + serviceUser.getDepartmentId() + "')");
		}
		if (StringUtils.isNotEmpty(serviceUser.getQuartersId())){
			sb.append(" AND t.quarters_id = '"+serviceUser.getQuartersId()+"'");
		}
		sb.append(" ORDER BY t.create_date desc");
		return serviceUserDao.findBySqlExt(page, sb.toString(), ServiceUserVO.class);
	}
	
	public Page<ServiceUserVO> Wsfind(Page<ServiceUserVO> page,String userId, ServiceUserVO serviceUser) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.name,t.job_number,t.thumb_img,t.img_url,t1.`name` department_nm,t2.`name` quarters_nm");
		sb.append("	FROM sys_service_user t");
		sb.append("	LEFT JOIN sys_department t1 ON t1.id = t.department_id ");
		sb.append("	LEFT JOIN sys_quarters t2 ON t2.id = t.quarters_id ");
		sb.append(" WHERE t.del_flag = '"+ServiceUser.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(serviceUser.getName())){
			sb.append(" AND t.name like '%"+serviceUser.getName()+"%'");
		}
		if (StringUtils.isNotEmpty(serviceUser.getDepartmentId())){
			sb.append(" and (t1.id = '"+serviceUser.getDepartmentId()+"' or t1.parent_id = '" + serviceUser.getDepartmentId() + "')");
		}
		if(StringUtils.isNotBlank(serviceUser.getIsLove()) && serviceUser.getIsLove().equals("true")){
			sb.append(" AND not t.id in (SELECT service_user_id FROM hn_love_census WHERE user_id = '"+userId+"' AND del_flag = '"+ServiceUser.DEL_FLAG_NORMAL+"')");
		}
		
		sb.append(" ORDER BY t.create_date desc");
		return serviceUserDao.findBySqlExt(page, sb.toString(), ServiceUserVO.class);
	}
	
	public Page<ServiceUserVO> WsfindByUserId(Page<ServiceUserVO> page,String userId,String archivesId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.name,t.job_number,t.thumb_img,t.img_url,t1.`name` department_nm,t2.`name` quarters_nm");
		sb.append("	FROM sys_service_user t");
		sb.append("	LEFT JOIN sys_department t1 ON t1.id = t.department_id ");
		sb.append("	LEFT JOIN sys_quarters t2 ON t2.id = t.quarters_id ");
		sb.append(" WHERE t.del_flag = '"+ServiceUser.DEL_FLAG_NORMAL+"'");
		sb.append(" AND not t.id in (SELECT service_user_id FROM hn_love_census WHERE user_id = '"+userId+"' AND del_flag = '"+ServiceUser.DEL_FLAG_NORMAL+"')");
		sb.append(" AND t.id in(SELECT service_user_id FROM hn_plan_execute_record WHERE archives_id = '"+archivesId+"' AND state in('1','2') AND del_flag = '"+ServiceUser.DEL_FLAG_NORMAL+"')");
		sb.append(" ORDER BY t.create_date desc");
		return serviceUserDao.findBySqlExt(page, sb.toString(), ServiceUserVO.class);
	}
	
	/****
	 * 获取服务人员详情
	 * @param serviceUserId
	 * @return
	 * @throws Exception 
	 */
	public ServiceUserVO getServiceUserDetail(String serviceUserId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.office_id,t.name,t.quarters_id,t.department_id,t.sex,t.mobile,t.job_number,t.remarks,t.thumb_img,t.img_url,");
		sb.append("DATE_FORMAT(t.birth_date, '%Y-%m-%d') birth_date,DATE_FORMAT(t.create_date, '%Y-%m-%d %H:%i') create_date,");
		sb.append("t1.`name` office_nm,t2.`name` department_nm,t3.`name` quarters_nm");
		sb.append(" FROM sys_service_user t  ");
		sb.append("	LEFT JOIN sys_office t1 ON t1.id = t.office_id ");
		sb.append("	LEFT JOIN sys_department t2 ON t2.id = t.department_id ");
		sb.append("	LEFT JOIN sys_quarters t3 ON t3.id = t.quarters_id ");
		sb.append(" WHERE t.id = '"+serviceUserId+"'");
		List<ServiceUserVO> list = serviceUserDao.findBySqlExt(sb.toString(), null, ServiceUserVO.class);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Transactional(readOnly = false)
	public void save(ServiceUser serviceUser) {
		serviceUserDao.save(serviceUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		serviceUserDao.deleteById(id);
	}
	/**
	 * 是否已存在当前手机号码
	 * @param loginName
	 * @return
	 */
	public boolean existsMobile(String mobile) {
		String sql = "SELECT * FROM sys_service_user WHERE mobile = '"+mobile+"' and del_flag = '"+BaseEntity.DEL_FLAG_NORMAL+"'";
		List<ServiceUser> list = serviceUserDao.findBySqlExt(sql, null, ServiceUser.class);
		if(list != null && list.size() > 0 ){
			return true;
		}
		return false;
	}
	public List<ServiceUser> findByDepartment(String departmentId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM sys_service_user t where t.del_flag = '"+BaseEntity.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(departmentId)){
			sb.append(" and t.department_id = '"+departmentId+"'");
		}
		return serviceUserDao.findBySqlExt(sb.toString(), null, ServiceUser.class);
	}
	
	public List<ServiceUser> findByQuarters(String quartersId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM sys_service_user t where t.del_flag = '"+BaseEntity.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(quartersId)){
			sb.append(" and t.quarters_id = '"+quartersId+"'");
		}
		return serviceUserDao.findBySqlExt(sb.toString(), null, ServiceUser.class);
	}
	
	/**
	 * 是否已存在当前工号
	 * @param loginName
	 * @return
	 */
	public boolean existsJobNumber(String jobNumber) {
		String sql = "SELECT * FROM sys_service_user WHERE job_number = '"+jobNumber+"' and del_flag = '"+BaseEntity.DEL_FLAG_NORMAL+"'";
		List<ServiceUser> list = serviceUserDao.findBySqlExt(sql, null, ServiceUser.class);
		if(list != null && list.size() > 0 ){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证当前岗位是否存在当前工号
	 * @param loginName
	 * @return
	 */
	public String validateJobNumber(String jobNumber,String quartersId){
		String sql = "SELECT * FROM sys_service_user WHERE job_number = '"+jobNumber+"' and quarters_id = '"+quartersId+"' and del_flag = '"+BaseEntity.DEL_FLAG_NORMAL+"'";
		List<ServiceUser> list = serviceUserDao.findBySqlExt(sql, null, ServiceUser.class);
		if(list != null && list.size() > 0 ){
			return list.get(0).getId();
		}
		return "";
	}
	
}
