package com.elink.hospitalhealthnurse.modules.serviceorg.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.serviceorg.dao.DepartmentDao;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Department;

/**
 * 科室管理Service
 * @author 颜福艳
 * @version 2016-10-09
 */
@Component
@Transactional(readOnly = true)
public class DepartmentService extends BaseService {

	@Autowired
	private DepartmentDao departmentDao;
	
	public Department get(String id) {
		return departmentDao.get(id);
	}
	
	public Page<Department> find(Page<Department> page, Department department) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,t1.name office_nm FROM sys_department t ");
		sb.append(" LEFT JOIN sys_office t1 ON t.office_id = t1.id");
		sb.append(" WHERE t.del_flag = '"+Department.DEL_FLAG_NORMAL+"'");
		
		if (StringUtils.isNotEmpty(department.getName())){
			sb.append(" and t.name like '%"+department.getName()+"%'");
		}
		
		return departmentDao.findBySqlExt(page, sb.toString(), Department.class);
	}
	
	@Transactional(readOnly = false)
	public void save(Department department) {
		departmentDao.save(department);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		departmentDao.deleteById(id);
	}
	
	public List<Department> findAll() throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,t1.name office_nm FROM sys_department t ");
		sb.append(" LEFT JOIN sys_office t1 ON t.office_id = t1.id");
		sb.append(" WHERE t.del_flag = '"+Department.DEL_FLAG_NORMAL+"'");
		return departmentDao.findBySqlExt(sb.toString(), null, Department.class);
	}
	
	public List<Department> findAllHql() {
		return departmentDao.findAll();
	}
	
	/**
	 * @return
	 */
	public List<Department> findAllList() {
		String sql = "from Department t where t.delFlag = '"+Department.DEL_FLAG_NORMAL+"'";
		return departmentDao.find(sql);
	}
	
	/**
	 * 根据医院ID查找该医院中的所有科室
	 * @param officeId 医院ID
	 * @return
	 */
	public List<Department> findByOfficeId(String officeId) {
		String sql = "from Department t where t.officeId='"+officeId+"' and t.delFlag = '"+Department.DEL_FLAG_NORMAL+"'";
		return departmentDao.find(sql);
	}
	
	/**
	 * 根据医院ID查找该医院中的所有科室
	 * @param officeId 医院ID
	 * @return
	 */
	public List<Department> findByParentId(String officeId,String parentId) {
		String sql = "from Department t where t.officeId='"+officeId+"' and t.delFlag = '"+Department.DEL_FLAG_NORMAL+"'";
		if(StringUtils.isNotBlank(parentId)){
			sql+="and t.parent.id = '"+parentId+"'";
		}
		return departmentDao.find(sql);
	}

	/**
	 * 通过上级科室ID删除所有下级科室
	 * @param id 上级科室ID
	 */
	@Transactional(readOnly = false)
	public void deleteByPId(String id) {
		String sql = "update from Department t set t.delFlag = '"+Department.DEL_FLAG_DELETE+"' where t.parent.id=:p1";
		Query query = departmentDao.createQuery(sql, new Parameter(id));
		query.executeUpdate();
	}
	
	/***
	 * 根据officeId,查询科室的第一层
	 * @param officeId
	 * @return
	 */
	public List<Department> findByOfficeIdByWs(String officeId){
		String sql = "select t.* from sys_department t where t.office_id ='"+officeId+
				      "' and t.parent_id =  '"+Department.root_id+"' and t.del_flag = '"+Department.DEL_FLAG_NORMAL+"'";
		return departmentDao.findBySqlExt(sql, null, Department.class);
	}
	
	public List<Department> findChildDeptByWs(String parentId){
		String sql = "select t.id,t.name  from sys_department t where t.parent_id =  '" + parentId + "' and t.del_flag = '"+Department.DEL_FLAG_NORMAL+"'";
		return departmentDao.findBySqlExt(sql, null, Department.class);
	}
	
	public boolean existsParentIdByName(String parentId,String name){
		String sql = "select t.id,t.name  from sys_department t where t.parent_id =  '" + parentId + "' and t.name = '"+name+"' and t.del_flag = '"+Department.DEL_FLAG_NORMAL+"'";
		List<Department> list = departmentDao.findBySqlExt(sql, null, Department.class);
		if(list != null && list.size() > 0){
			return true;
		}
		return false;
	}
	
	public boolean existsName(String name){
		String sql = "select t.id,t.name  from sys_department t where t.name = '"+name+"' and t.del_flag = '"+Department.DEL_FLAG_NORMAL+"'";
		List<Department> list = departmentDao.findBySqlExt(sql, null, Department.class);
		if(list != null && list.size() > 0){
			return true;
		}
		return false;
	}

	
}
