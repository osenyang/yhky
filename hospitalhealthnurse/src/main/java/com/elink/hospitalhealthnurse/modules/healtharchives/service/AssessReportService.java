package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.AssessReport;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.AssessReportDao;

/**
 * 健康建议Service
 * @author 杜康
 * @version 2017-04-12
 */
@Component
@Transactional(readOnly = true)
public class AssessReportService extends BaseService {

	@Autowired
	private AssessReportDao assessReportDao;
	
	public AssessReport get(String id) {
		return assessReportDao.get(id);
	}
	
	public Page<AssessReport> find(Page<AssessReport> page, AssessReport assessReport) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_assess_report t");
		sb.append(" WHERE t.del_flag = '"+AssessReport.DEL_FLAG_NORMAL+"'");
		
		sb.append(" ORDER BY t.create_date desc");
		return assessReportDao.findBySqlExt(page, sb.toString(), AssessReport.class);
	}
	
	@Transactional(readOnly = false)
	public void save(AssessReport assessReport) {
		assessReportDao.save(assessReport);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		assessReportDao.deleteById(id);
	}
	/**
	 * 根据档案ID查询评估记录
	 * */
	public List<AssessReport> findByArchivesId(String archivesId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_assess_report t ");
		sb.append(" WHERE t.del_flag = '"+AssessReport.DEL_FLAG_NORMAL+"'");
		if(StringUtils.isNotBlank(archivesId)){
			sb.append(" and t.archives_id = '"+archivesId+"'");
		}
		return assessReportDao.findBySqlExt(sb.toString(), null, AssessReport.class);
	}
}
