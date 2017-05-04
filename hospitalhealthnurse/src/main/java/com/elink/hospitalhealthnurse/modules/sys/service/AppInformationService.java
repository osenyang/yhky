package com.elink.hospitalhealthnurse.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.sys.entity.AppInformation;
import com.elink.hospitalhealthnurse.modules.sys.vo.AppInformationVO;
import com.elink.hospitalhealthnurse.modules.sys.dao.AppInformationDao;

/**
 * app版本管理Service
 * @author 杜康
 * @version 2017-03-28
 */
@Component
@Transactional(readOnly = true)
public class AppInformationService extends BaseService {

	@Autowired
	private AppInformationDao appInformationDao;
	
	public AppInformation get(String id) {
		return appInformationDao.get(id);
	}
	
	public Page<AppInformation> find(Page<AppInformation> page, AppInformation appInformation) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM app_information t where 1=1 ");
		if(StringUtils.isNotBlank(appInformation.getAppName())){
			sb.append(" and t.app_name like '%"+appInformation.getAppName()+"%' ");
		}
		return appInformationDao.findBySqlExt(page, sb.toString(), AppInformation.class);
	}
	
	@Transactional(readOnly = false)
	public void save(AppInformation appInformation) {
		appInformationDao.save(appInformation);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		appInformationDao.deleteByIdPhysic(id);
	}
	/**
	 * 查询版本号
	 * */
	public List<AppInformationVO> findByAppName(String appName){
		String sql = "select * from app_information t where t.app_name = '"+appName+"' ";
		return appInformationDao.findBySqlExt(sql, null, AppInformationVO.class);
	}
}
