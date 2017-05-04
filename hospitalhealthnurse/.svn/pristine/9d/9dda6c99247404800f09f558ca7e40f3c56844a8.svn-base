package com.elink.hospitalhealthnurse.modules.statistics.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.statistics.entity.LoveCensus;
import com.elink.hospitalhealthnurse.modules.statistics.entity.MoodIndex;
import com.elink.hospitalhealthnurse.modules.statistics.vo.LoveCensusVO;
import com.elink.hospitalhealthnurse.modules.statistics.vo.LoveValueVO;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.modules.statistics.dao.LoveCensusDao;

/**
 * 喜爱统计Service
 * @author 颜福艳
 * @version 2016-10-11
 */
@Component
@Transactional(readOnly = true)
public class LoveCensusService extends BaseService {

	@Autowired
	private LoveCensusDao loveCensusDao;
	
	public LoveCensus get(String id) {
		return loveCensusDao.get(id);
	}
	
	public Page<LoveCensusVO> find(Page<LoveCensusVO> page, LoveCensusVO loveCensus) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.user_id,t.service_user_id,DATE_FORMAT(t.create_date, '%Y-%m-%d %H:%i') create_date,");
		sb.append(" t1.hospitalization_number, t5.area_nm inpatient_nm,");
		sb.append("t1.full_nm,t1.sex,DATE_FORMAT(FROM_DAYS(TO_DAYS(NOW())-TO_DAYS(t1.birth_date)), '%Y')+0 age,t1.photo,t2.thumb_img,t2.img_url,");
		sb.append("t2.`name` service_user_nm,t2.office_id,t2.department_id,t3.`name` office_nm,t4.`name` department_nm");
		sb.append(" FROM hn_love_census t");
		sb.append(" LEFT JOIN hn_health_archives t1 ON t1.user_id = t.user_id");
		sb.append(" LEFT JOIN sys_service_user t2 ON t2.id = t.service_user_id");
		sb.append(" LEFT JOIN sys_office t3 ON t3.id = t2.office_id");
		sb.append(" LEFT JOIN sys_department t4 ON t4.id = t2.department_id");
		sb.append(" left join hn_health_inpatient t5 on t1.inpatient_id = t5.id ");
		sb.append(" WHERE t.del_flag = '"+MoodIndex.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(loveCensus.getFullNm())){
			sb.append(" AND t1.full_nm like '%"+loveCensus.getFullNm()+"%'");
		}
		if(StringUtils.isNotBlank(loveCensus.getServiceUserNm())){
			sb.append(" AND t2.`name` like '%"+loveCensus.getServiceUserNm()+"%'");
		}
		if(StringUtils.isNotBlank(loveCensus.getOfficeNm())){
			sb.append(" AND t3.`name` like '%"+loveCensus.getOfficeNm()+"%'");
		}
		if(StringUtils.isNotBlank(loveCensus.getOfficeId())){
			sb.append(" AND t2.office_id = '"+loveCensus.getOfficeId()+"'");
		}
		if(StringUtils.isNotBlank(loveCensus.getDepartmentId())){
			sb.append(" AND t2.department_id = '"+loveCensus.getDepartmentId()+"'");
		}
		if(StringUtils.isNotBlank(loveCensus.getHospitalizationNumber())){
			sb.append(" AND t1.hospitalization_number = '"+loveCensus.getHospitalizationNumber()+"'");
		}
		if(StringUtils.isNotBlank(loveCensus.getInpatientNm())){
			sb.append(" AND t5.area_nm = '"+loveCensus.getInpatientNm()+"'");
		}
		if(StringUtils.isNotBlank(loveCensus.getStartDate()) && StringUtils.isNotBlank(loveCensus.getEndDate())){
			sb.append(" AND DATE_FORMAT(t.create_date, '%Y-%m-%d') BETWEEN '"+loveCensus.getStartDate()+"' AND '"+loveCensus.getEndDate()+"'");
		}else if(StringUtils.isNotBlank(loveCensus.getStartDate())){
			sb.append(" AND DATE_FORMAT(t.create_date, '%Y-%m-%d') >= '"+loveCensus.getStartDate()+"'");
		}else if(StringUtils.isNotBlank(loveCensus.getEndDate())){
			sb.append(" AND DATE_FORMAT(t.create_date, '%Y-%m-%d') <= '"+loveCensus.getEndDate()+"'");
		}
		
		sb.append(" ORDER BY t.create_date desc");
		return loveCensusDao.findBySqlExt(page, sb.toString(), LoveCensusVO.class);
	}
	
	public List<LoveCensusVO> wsFind(String userId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t1.img_url,t1.thumb_img,t1.`name` service_user_nm,t2.`name` department_nm");
		sb.append(" FROM hn_love_census t");
		sb.append(" LEFT JOIN sys_service_user t1 ON t1.id = t.service_user_id");
		sb.append(" LEFT JOIN sys_department t2 ON t2.id = t1.department_id");
		sb.append(" WHERE t.del_flag = '"+MoodIndex.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(userId)){
			sb.append(" AND t.user_id like '"+userId+"'");
		}
		sb.append(" ORDER BY t.create_date desc");
		return loveCensusDao.findBySqlExt(sb.toString(),null, LoveCensusVO.class);
	}
	
	/**
	 * 获取喜爱统计数据
	 * @param page
	 * @param statType
	 * @param departmentId
	 * @return
	 */
	public Map<String,Object[]> getLoveCensusAvgStatValue(Page<LoveValueVO> page,String statType,String departmentId){
		Map<String,Object[]> map = Maps.newHashMap();
		
		Page<LoveValueVO> pageNew = this.getLoveCensusAvg(page, statType,departmentId,LoveCensus.DEL_FLAG_NORMAL);
		List<LoveValueVO> list = pageNew.getList();
		//升序(d1与d2比较，反之为降序)
	    Collections.sort(list, new Comparator<LoveValueVO>() {
            public int compare(LoveValueVO d1, LoveValueVO d2) {
            	Integer d1Number = d1.getNumber();
            	Integer d2Number = d2.getNumber();
                return d1Number.compareTo(d2Number);
            }
        });		
	    if(list != null && list.size() > 0){
	    	String[] serviceUserNmlist = new String[list.size()];
	    	Integer[] numberlist = new Integer[list.size()];
	    	for( int i = 0; i < list.size(); i ++){
	    		LoveValueVO loveValue = list.get(i);		
	    		serviceUserNmlist[i] = loveValue.getServiceUserNm();			
				numberlist[i]   = loveValue.getNumber();
	    	}
	    	map.put("serviceUserNmlist", serviceUserNmlist);
	    	map.put("numberlist", numberlist);
	    	map.put("pagestr", new String[]{pageNew.toString()});
	    }else{
	    	map.put("serviceUserNmlist", null);
	     	map.put("numberlist", null);
	    	map.put("pagestr", new String[]{pageNew.toString()});
	    }
	    return 	map;
	}
	
	/**
	 * 获取撤销喜爱统计数据
	 * @param page
	 * @param statType
	 * @param departmentId
	 * @return
	 */
	public Map<String,Object[]> getNotLoveCensusAvgStatValue(Page<LoveValueVO> page,String statType,String departmentId){
		Map<String,Object[]> map = Maps.newHashMap();
		
		Page<LoveValueVO> pageNew = this.getLoveCensusAvg(page, statType,departmentId,LoveCensus.DEL_FLAG_DELETE);
		List<LoveValueVO> list = pageNew.getList();
		//升序(d1与d2比较，反之为降序)
	    Collections.sort(list, new Comparator<LoveValueVO>() {
            public int compare(LoveValueVO d1, LoveValueVO d2) {
            	Integer d1Number = d1.getNumber();
            	Integer d2Number = d2.getNumber();
                return d1Number.compareTo(d2Number);
            }
        });		
	    if(list != null && list.size() > 0){
	    	String[] serviceUserNmlist = new String[list.size()];
	    	Integer[] numberlist = new Integer[list.size()];
	    	for( int i = 0; i < list.size(); i ++){
	    		LoveValueVO loveValue = list.get(i);		
	    		serviceUserNmlist[i] = loveValue.getServiceUserNm();			
				numberlist[i]   = loveValue.getNumber();
	    	}
	    	map.put("serviceUserNmlist", serviceUserNmlist);
	    	map.put("numberlist", numberlist);
	    	map.put("pagestr", new String[]{pageNew.toString()});
	    }else{
	    	map.put("serviceUserNmlist", null);
	     	map.put("numberlist", null);
	    	map.put("pagestr", new String[]{pageNew.toString()});
	    }
	    return 	map;
	}
	
	/***
	 * 获取喜爱统计历史数据
	 * @param page
	 * @param statType
	 * @return
	 * @throws Exception
	 */
	public Page<LoveValueVO> getLoveCensusAvg(Page<LoveValueVO> page,String statType,String departmentId,String delFlag)  {
		String currentDate = DateUtils.getDate();  //当前日期
		String pastDate = DateUtils.getPastDate(statType);  //最近日期的第一天				
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT hn.*,COUNT(hn.user_id) number FROM (");
		sb.append(" SELECT t.user_id,t.service_user_id,t2.`name` service_user_nm,t2.department_id,t4.`name` department_nm");
		sb.append(" FROM hn_love_census t");
		sb.append(" LEFT JOIN hn_health_archives t1 ON t1.user_id = t.user_id");
		sb.append(" LEFT JOIN sys_service_user t2 ON t2.id = t.service_user_id");
		sb.append(" LEFT JOIN sys_office t3 ON t3.id = t2.office_id");
		sb.append(" LEFT JOIN sys_department t4 ON t4.id = t2.department_id");
		sb.append(" WHERE t.del_flag = '"+delFlag+"'");
		sb.append(" AND DATE_FORMAT(t.create_date,'%Y-%m-%d') BETWEEN '" + pastDate + "' AND '" +currentDate+ "'");
		if(StringUtils.isNotBlank(departmentId)){
			sb.append(" AND t2.department_id = '"+departmentId+"'");
		}
		sb.append(" ) hn");
		sb.append(" GROUP BY hn.service_user_id");
		sb.append(" ORDER BY COUNT(hn.user_id) desc");		
		return  this.loveCensusDao.findBySqlExt(page, sb.toString(), LoveValueVO.class);	
	}
	
	@Transactional(readOnly = false)
	public void save(LoveCensus loveCensus) {
		loveCensusDao.save(loveCensus);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		loveCensusDao.deleteById(id);
	}
	
}
