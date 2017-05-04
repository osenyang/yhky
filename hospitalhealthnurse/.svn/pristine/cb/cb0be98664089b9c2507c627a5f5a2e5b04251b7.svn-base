package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.easemob.server.common.Constants;
import com.elink.easemob.server.common.HTTPMethod;
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.utils.HttpClient;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthArchives;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.AssessResultVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthArchivesVO;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.vo.ServiceUserVO;
import com.elink.hospitalhealthnurse.modules.sys.dao.UserDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.Office;
import com.elink.hospitalhealthnurse.modules.sys.entity.Role;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.google.common.collect.Lists;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.HealthArchivesDao;

/**
 * 健康档案Service
 * @author 杜康
 * @version 2016-10-11
 */
@Component
@Transactional(readOnly = true)
public class HealthArchivesService extends BaseService {

	@Autowired
	private HealthArchivesDao healthArchivesDao;
	
	@Autowired
	private UserDao userDao;
	
	public HealthArchives get(String id) {
		return healthArchivesDao.get(id);
	}
	
	public Page<HealthArchives> find(Page<HealthArchives> page, HealthArchives healthArchives) {
		StringBuffer sb = new StringBuffer();
		sb.append("select t2.* from (select t.* from (");
		sb.append(" select t1.*,t3.area_nm inpatient_nm from hn_health_archives t1 ");
		sb.append(" left join hn_health_inpatient t3 on t1.inpatient_id = t3.id  ");
		sb.append(" where t1.state not in ('"+HealthArchives.STATE_LEAVE_HOSPITAL+"') and t1.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		sb.append("  order by t1.update_date desc) t ");
		sb.append(" union all ");
		sb.append(" select t.* from (select t1.*,t3.area_nm inpatient_nm from hn_health_archives t1 ");
		sb.append(" left join hn_health_inpatient t3 on t1.inpatient_id = t3.id  ");
		sb.append(" where t1.state in ('"+HealthArchives.STATE_LEAVE_HOSPITAL+"') and t1.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		sb.append("  order by t1.update_date desc) t ) t2 ");
		sb.append(" where 1=1 ");
		if(StringUtils.isNotBlank(healthArchives.getFullNm())){
			sb.append(" and t2.full_nm like '%"+healthArchives.getFullNm()+"%'");
		}
		if(StringUtils.isNotBlank(healthArchives.getBedNumber())){
			sb.append(" and t2.bed_number like '%"+healthArchives.getBedNumber()+"%'");
		}
		if(StringUtils.isNotBlank(healthArchives.getState())){
			sb.append(" and t2.state = '"+healthArchives.getState()+"'");
		}
		if(StringUtils.isNotBlank(healthArchives.getHospitalizationNumber())){
			sb.append(" and t2.hospitalization_number like '%"+healthArchives.getHospitalizationNumber()+"%'");
		}
		if(StringUtils.isNotBlank(healthArchives.getInpatientNm())){
			sb.append(" and t2.inpatient_nm like '%"+healthArchives.getInpatientNm()+"%'");
		}
		return healthArchivesDao.findBySqlExt(page, sb.toString(), HealthArchives.class);
	}
	
	/**
	 * 根据userid查询档案信息
	 * @param userId
	 * @author dk
	 * @data 2016-10-14
	 * @return list
	 * */
	public List<HealthArchivesVO> findByUserId(String userId){
		StringBuffer sql = new StringBuffer();
		sql.append("select t.*,t1.label medical_type_nm,t2.label degree_nm from hn_health_archives t ");
		sql.append(" left join sys_dict t1 on t.medical_type = t1.`value` and t1.type = 'medical_type' ");
		sql.append(" left join sys_dict t2 on t.degree = t2.`value` and t2.type = 'hn_culture' ");
		sql.append(" where t.user_id = '"+userId+"'");
		return healthArchivesDao.findBySqlExt(sql.toString(), null, HealthArchivesVO.class);
	}
	
	@Transactional(readOnly = false)
	public void save(HealthArchives healthArchives) {
		healthArchivesDao.save(healthArchives);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		healthArchivesDao.deleteById(id);
	}
	
	/***
	 * 验证老人健康档案的身份证号码是否重复
	 * @param idCard
	 * @return
	 */
	public boolean validateIdCard(String idCard){
		String sqlString = "select id_card from hn_health_archives t where 1=1 ";
		sqlString += " and t.id_card = '" + idCard+"' and t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"'";
		List<HealthArchives> list =  healthArchivesDao.findBySqlExt(sqlString, null, HealthArchives.class);
		if(list != null && list.size() > 0)
			return true;
		else 
			return false;
	}
	
	/***
	 * 验证老人健康档案的住院号是否重复
	 * @param numbers
	 * @return
	 */
	public boolean validateHospitalizationNumber(String numbers){
		String sqlString = "select id_card from hn_health_archives t where 1=1 ";
		sqlString += " and t.hospitalization_number = '" + numbers+"'";
		List<HealthArchives> list =  healthArchivesDao.findBySqlExt(sqlString, null, HealthArchives.class);
		if(list != null && list.size() > 0)
			return true;
		else 
			return false;
	}
	
	/***
	 * 验证老人健康档案的床号是否重复
	 * @param numbers
	 * @return
	 */
	public boolean validateBedNumber(String numbers,String inpatientId,String id){
		StringBuffer sql = new StringBuffer();
		sql.append("select id_card from hn_health_archives t where 1=1 ");
		sql.append(" and t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		sql.append(" and t.state != '"+HealthArchives.STATE_LEAVE_HOSPITAL+"' ");
		sql.append(" and t.bed_number = '" + numbers+"'");
		sql.append(" and t.inpatient_id = '"+inpatientId+"' ");
		sql.append(" and t.id != '"+id+"'");
		List<HealthArchives> list =  healthArchivesDao.findBySqlExt(sql.toString(), null, HealthArchives.class);
		if(list != null && list.size() > 0)
			return true;
		else 
			return false;
	}
	
	/***
	 * 验证老人健康档案是否有病区ID
	 * @param numbers
	 * @return
	 */
	public boolean validateInpatient(String inpatientId){
		StringBuffer sql = new StringBuffer();
		sql.append("select id_card from hn_health_archives t where 1=1 ");
		sql.append(" and t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		sql.append(" and t.inpatient_id = '"+inpatientId+"' ");
		List<HealthArchives> list =  healthArchivesDao.findBySqlExt(sql.toString(), null, HealthArchives.class);
		if(list != null && list.size() > 0)
			return true;
		else 
			return false;
	}
	
	/***
	 * 保存健康档案，并新增一条用户信息到用户表.
	 * @param healthArchives
	 * @throws Exception 
	 */
	@Transactional(readOnly = false)
	public void saveHealthArchivesByWs(HealthArchives healthArchives, String officeId) throws Exception {
		User user = null;
		if(StringUtils.isNotBlank(healthArchives.getUserId())){
			user = userDao.get(healthArchives.getUserId());
		}else{
			if(StringUtils.isNotBlank(healthArchives.getIdCard())){
				user = userDao.findByLoginName(healthArchives.getIdCard());
			}			
		}		
		if(user == null){
			user = new User();
		}
//		String newIdCard = healthArchives.getIdCard();
//		String oldIdCard = "";
//		user.setCompany(new Office(officeId));
		user.setOffice(new Office(officeId));
		user.setLoginName(healthArchives.getIdCard());
		user.setName(healthArchives.getFullNm());
		if(StringUtils.isNotBlank(healthArchives.getId())){
			if(StringUtils.isNotBlank(healthArchives.getPassword())){
				user.setPassword(SystemService.entryptPassword(healthArchives.getPassword()));
			}
		}else{
			if(StringUtils.isNotBlank(healthArchives.getPassword())){
				user.setPassword(SystemService.entryptPassword(healthArchives.getPassword()));
			}else{
				user.setPassword(SystemService.entryptPassword(Consts.DEFAULT_PASSWORD));
			}
		}
		
		user.setName(healthArchives.getFullNm());
//		user.setMobile(healthArchives.getTel());
//		user.setPhone(healthArchives.getTel());
		user.setUserType(Consts.USER_TYPE_ELDER);
		Role role = new Role(Consts.ROLE_PERSONAL,"个人角色");
		List<Role> roleList = Lists.newArrayList();
		roleList.add(role);
		user.setRoleList(roleList);
		userDao.clear();
		userDao.save(user);		
		healthArchives.setUserId(user.getId());	
		healthArchives.setDelFlag(HealthArchives.DEL_FLAG_NORMAL); 
//		if(oldHealthArchives != null){
//			oldIdCard = oldHealthArchives.getIdCard();
//			healthArchivesDao.save(healthArchives);				
//		}else{
			healthArchivesDao.save(healthArchives);				
//		}				
		
	}
	
	/**
	 * 构造医护人员树结构
	 * **/
	public List<ServiceUserVO> findServiceUser() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.job_number,t.name,t2.`name` department_nm ");
		sb.append("	FROM sys_service_user t");
		sb.append("	LEFT JOIN sys_department t2 ON t2.id = t.department_id ");
		sb.append("	left join sys_user t3 on t.job_number = t3.job_number ");
		sb.append(" WHERE t.del_flag = '"+ServiceUser.DEL_FLAG_NORMAL+"'");
		sb.append(" and t3.job_number is not null ");
		return healthArchivesDao.findBySqlExt(sb.toString(), null, ServiceUserVO.class);
	}
	
	@Transactional(readOnly = false)
	public void evict(HealthArchives healthArchives){
		healthArchivesDao.getSession().evict(healthArchives); 
	}
	
	/***
	 * 根据住院编号获取住院用户信息
	 * @param hospitalNumber
	 * @return
	 */
	public HealthArchivesVO getUserByHospitalNumber(String hospitalNumber){
		String sqlString = "select id,user_id,full_nm,sex,photo,birth_date from hn_health_archives where 1=1 ";
		sqlString += " and hospitalization_number = '" + hospitalNumber+"'";
		List<HealthArchivesVO> list =  healthArchivesDao.findBySqlExt(sqlString, null, HealthArchivesVO.class);
		if(list != null && list.size() > 0)
			return list.get(0);
		else 
			return null;
	}
	
	/***
	 * 根据用户编号获取用户信息
	 * @param uerId
	 * @return
	 */
	public HealthArchivesVO getUserByUserId(String userId){
		String sqlString = "select id,user_id,full_nm,sex,photo,birth_date from hn_health_archives where del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ";
		sqlString += " and user_id = '" + userId+"'";
		List<HealthArchivesVO> list =  healthArchivesDao.findBySqlExt(sqlString, null, HealthArchivesVO.class);
		if(list != null && list.size() > 0)
			return list.get(0);
		else 
			return null;
	}
	/**
	 * 根据archivesId查询档案信息
	 * @param archivesId
	 * @author 王宴萍
	 * @data 2016-11-15
	 * @return 
	 * */
	public HealthArchivesVO findById(String archivesId){
		StringBuffer sql = new StringBuffer();
		sql.append("select t.*,t1.label medical_type_nm,t2.label degree_nm from hn_health_archives t ");
		sql.append(" left join sys_dict t1 on t.medical_type = t1.`value` and t1.type = 'medical_type' ");
		sql.append(" left join sys_dict t2 on t.degree = t2.`value` and t2.type = 'hn_culture' ");
		sql.append(" where t.id = '"+archivesId+"'");
		List<HealthArchivesVO> list= healthArchivesDao.findBySqlExt(sql.toString(), null, HealthArchivesVO.class);
		if(list != null && list.size() > 0)
			return list.get(0);
		else 
			return null;
	}
	
	/**
	 * 获取评估结果
	 * @param healthArchives
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<AssessResultVO> getAssessResultVOList(String idCard,String startDate,String endDate){
		List<AssessResultVO> assessList = new ArrayList<AssessResultVO>();
		if(StringUtils.isEmpty(startDate)){
			startDate = "";
		}
		if(StringUtils.isEmpty(endDate)){
			endDate = "";
		}
		String url = Constants.API_HOSPITAL_HOST+"/admin/ws/assessResult/getAssessResultByIdCard?idCard="+idCard+"&startDate="+startDate+"&endDate="+endDate;
		try {
			JSONObject obj = HttpClient.httpClient(url, null, HTTPMethod.METHOD_GET);
			if(obj != null){
				JSONArray jsonArray = obj.optJSONArray("data");
				if(jsonArray != null && jsonArray.length() > 0){
					for(int i=0;i<jsonArray.length();i++){      	
						JSONObject jsonObjct = (JSONObject) jsonArray.get(i);
						AssessResultVO vo = JsonMapper.getInstance().fromJson(jsonObjct.toString(),AssessResultVO.class);
						assessList.add(vo);
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
        return assessList;
	}
	/**
	 * 查询所有老人的姓名和身份证号码
	 * @author dk
	 * @date 2017-3-13 
	 * @return
	 * */
	public List<HealthArchives> findAllFull(){
		String sql = "select t.id,t.user_id,t.full_nm,t.id_card from hn_health_archives t where t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' and t.id in (select distinct t.archives_id from hn_intervene t  where t.state = '"+Intervene.INTER_STATE_EXECUTE+"')";
		return healthArchivesDao.findBySqlExt(sql, null, HealthArchives.class);
	}
}
