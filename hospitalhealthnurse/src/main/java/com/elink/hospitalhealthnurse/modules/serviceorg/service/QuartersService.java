package com.elink.hospitalhealthnurse.modules.serviceorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.serviceorg.dao.QuartersDao;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Quarters;
import com.elink.hospitalhealthnurse.modules.serviceorg.vo.QuartersVO;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;

/**
 * 岗位管理Service
 * @author 颜福艳
 * @version 2016-10-10
 */
@Component
@Transactional(readOnly = true)
public class QuartersService extends BaseService {

	@Autowired
	private QuartersDao quartersDao;
	
	public Quarters get(String id) {
		return quartersDao.get(id);
	}
	
	public Page<QuartersVO> find(Page<QuartersVO> page, QuartersVO quarters) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.name,t.office_id,t.department_id,DATE_FORMAT(t.create_date, '%Y-%m-%d %H:%i') create_date,");
		sb.append(" t1.name office_nm,t2.name department_nm");
		sb.append(" FROM sys_quarters t");
		sb.append(" LEFT JOIN sys_office t1 ON t1.id = t.office_id");
		sb.append(" LEFT JOIN sys_department t2 ON t2.id = t.department_id");
		sb.append(" WHERE t.del_flag = '"+Quarters.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(quarters.getName())){
			sb.append(" AND t.name like '%"+quarters.getName()+"%'");
		}
		if(StringUtils.isNotBlank(quarters.getDepartmentId())){
			sb.append(" and (t2.id = '"+quarters.getDepartmentId()+"' or t2.parent_id = '" + quarters.getDepartmentId() + "')");
		}
		sb.append(" ORDER BY t.department_id,t.create_date desc");
		return quartersDao.findBySqlExt(page, sb.toString(), QuartersVO.class);
	}
	
	public List<Quarters> findList(String departmentId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.name FROM sys_quarters t");
		sb.append(" WHERE t.del_flag = '"+Quarters.DEL_FLAG_NORMAL+"'");
		sb.append(" AND t.department_id = '"+departmentId+"'");
		sb.append(" ORDER BY t.create_date desc");
		return quartersDao.findBySqlExt(sb.toString(),null, Quarters.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Quarters quarters) {
		quartersDao.save(quarters);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		quartersDao.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void deleteByDepartmentId(String departmentId) {
		String hql = "update Quarters SET delFlag = :p1 WHERE departmentId = :p2 ";
		quartersDao.update(hql.toString(), new Parameter(BaseEntity.DEL_FLAG_DELETE,departmentId));
	}
	
	/**
	 * 查询所有科室和岗位
	 * */
	public List<Quarters> findAllQuarters() throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("select t.id,t.`name`,t.parent_id department_id from sys_department t WHERE t.del_flag = '"+Quarters.DEL_FLAG_NORMAL+"'");
		sb.append(" union all ");
		sb.append(" select t1.id,t1.`name`,t1.department_id from sys_quarters t1 where t1.del_flag = '"+Quarters.DEAL_STATE_NORMAL+"'");
		return quartersDao.findBySqlExt(sb.toString(), null, Quarters.class);
	}
	
	public boolean existsName(String departmentId,String name){
		String sql = "select t.id,t.name from sys_quarters t where t.department_id = '"+departmentId+"' and t.name = '"+name+"' and t.del_flag = '"+Quarters.DEL_FLAG_NORMAL+"'";
		List<Quarters> list = quartersDao.findBySqlExt(sql, null, Quarters.class);
		if(list != null && list.size() > 0){
			return true;
		}
		return false;
	}
	
}
