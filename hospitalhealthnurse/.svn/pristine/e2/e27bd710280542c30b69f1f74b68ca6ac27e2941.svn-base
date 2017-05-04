package com.elink.hospitalhealthnurse.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.sys.dao.OfficeDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.Office;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.elink.hospitalhealthnurse.modules.sys.vo.OfficeVO;

/**
 * 医院管理Service
 * @author 颜福艳
 * @version 2016-09-02
 */
@Component
@Transactional(readOnly = true)
public class OfficeService extends BaseService {

	@Autowired
	private OfficeDao officeDao;
	
	public Office get(String id) {
		return officeDao.get(id);
	}
	
	public List<Office> findAll(){
		return UserUtils.getOfficeList();
	}
	
	public Page<OfficeVO> find(Page<OfficeVO> page, Office office) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,(SELECT GROUP_CONCAT(name SEPARATOR '') name from sys_area where id in(t.province,t.city,t.area)) area_nm");
		sb.append("	FROM sys_office t");
		sb.append(" WHERE t.del_flag = '"+Office.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(office.getName())){
			sb.append(" AND t.name like '%"+office.getName()+"%'");
		}
		sb.append(" ORDER BY t.create_date desc");
		return officeDao.findBySqlExt(page, sb.toString(), OfficeVO.class);
	}
	
	public List<Office> findList() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.name FROM sys_office t");
		sb.append(" WHERE t.del_flag = '"+Office.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return officeDao.findBySqlExt(sb.toString(),null, Office.class);
	}
	
	public List<OfficeVO> WsfindList() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,(SELECT GROUP_CONCAT(name SEPARATOR '') name from sys_area where id in(t.province,t.city,t.area)) area_nm");
		sb.append(" FROM sys_office t");
		sb.append(" WHERE t.del_flag = '"+Office.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return officeDao.findBySqlExt(sb.toString(),null, OfficeVO.class);
	}
	
	public OfficeVO WsfindHospital(String hospitalId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,(SELECT GROUP_CONCAT(name SEPARATOR '') name from sys_area where id in(t.province,t.city,t.area)) area_nm");
		sb.append(" FROM sys_office t");
		sb.append(" WHERE t.id = '"+hospitalId+"'");
		List<OfficeVO> list = officeDao.findBySqlExt(sb.toString(),null, OfficeVO.class);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	@Transactional(readOnly = false)
	public void save(Office office) {
		officeDao.save(office);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		officeDao.deleteById(id);
	}
	
}
