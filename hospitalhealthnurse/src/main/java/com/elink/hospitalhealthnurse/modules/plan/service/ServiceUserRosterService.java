package com.elink.hospitalhealthnurse.modules.plan.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.persistence.Parameter;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.plan.dao.ServiceUserRosterDao;
import com.elink.hospitalhealthnurse.modules.plan.entity.PlanExecuteRecord;
import com.elink.hospitalhealthnurse.modules.plan.entity.ServiceUserRoster;
import com.elink.hospitalhealthnurse.modules.plan.utils.ElderPlanUtils;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanStatVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ServiceUserRosterVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.TodayTaskVO;
import com.elink.hospitalhealthnurse.modules.statistics.entity.MoodIndex;
import com.google.common.collect.Maps;


/**
 * 服务人员排班Service
 * @author 王宴萍
 * @version 2016-10-11
 */
@Component
@Transactional(readOnly = true)
public class ServiceUserRosterService extends BaseService {

	@Autowired
	private ServiceUserRosterDao serviceUserRosterDao;
	
	public ServiceUserRoster get(String id) {
		return serviceUserRosterDao.get(id);
	}
	
	@Transactional(readOnly = false)
	public void save(ServiceUserRoster serviceUserRoster) {
		serviceUserRosterDao.save(serviceUserRoster);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		serviceUserRosterDao.deleteByIdPhysic(id);
	}
	public ServiceUserRosterVO getVO(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("select t1.id,t1.service_user_id,t1.serial_number,t1.create_date,t1.begin_date,t1.end_date,");
		sb.append(" t2.office_id,t2.name service_user_name,t3.name office_name,");
		sb.append(" t2.quarters_id,t4.name quarters_name,t2.department_id,t5.name department_name");
		sb.append(" from sys_service_user_roster t1");
		sb.append("	left join sys_service_user t2 on t2.id=t1.service_user_id");
		sb.append("	left join sys_office t3 on t2.office_id=t3.id ");
		sb.append("	left join sys_quarters t4 on t2.quarters_id=t4.id ");
		sb.append("	left join sys_department t5 on t2.department_id=t5.id ");
		sb.append("	where t1.id = '"+id+"' ");	
		List<ServiceUserRosterVO> serviceUserRosterVOs=serviceUserRosterDao.findBySqlExt(sb.toString(), null, ServiceUserRosterVO.class);
		if(serviceUserRosterVOs!=null&&serviceUserRosterVOs.size()>0){
			return serviceUserRosterVOs.get(0);
		}
		return null;
	}
	/***
	 * 查询服务人员排班VO
	 * @param page
	 * @param serviceUserRosterVO
	 * @return
	 */
	public Page<ServiceUserRosterVO> find(Page<ServiceUserRosterVO> page,ServiceUserRosterVO serviceUserRosterVO) {
		StringBuilder sb = new StringBuilder();
		sb.append("select (SUBSTRING_INDEX(t1.serial_number,'_',-1)) order1,t1.id,t1.service_user_id,t1.serial_number,t1.create_date,t1.begin_date,t1.end_date,");
		sb.append(" t2.office_id,t2.name service_user_name,t3.name office_name,");
		sb.append(" t2.quarters_id,t4.name quarters_name,t2.department_id,t5.name department_name");
		sb.append(" from sys_service_user_roster t1");
		sb.append("	left join sys_service_user t2 on t2.id=t1.service_user_id");
		sb.append("	left join sys_office t3 on t2.office_id=t3.id ");
		sb.append("	left join sys_quarters t4 on t2.quarters_id=t4.id ");
		sb.append("	left join sys_department t5 on t2.department_id=t5.id ");
		sb.append("	where 1=1 ");	
		
		if(StringUtils.isNotBlank(serviceUserRosterVO.getOfficeName())){
			sb.append(" and t3.name like '%"+serviceUserRosterVO.getOfficeName()+"%'" );
		}
		if (StringUtils.isNotBlank(serviceUserRosterVO.getServiceUserName())){
			sb.append(" and t2.name like '%"+serviceUserRosterVO.getServiceUserName()+"%'");
		}
		if (StringUtils.isNotBlank(serviceUserRosterVO.getDepartmentId())){
			sb.append(" and t5.id = '"+serviceUserRosterVO.getDepartmentId()+"'");
		}
		if (StringUtils.isNotBlank(serviceUserRosterVO.getSerialNumber())){
			sb.append(" and t1.serial_number like '%"+serviceUserRosterVO.getSerialNumber()+"%'");
		}
		if (serviceUserRosterVO.getBeginDate()!=null){
			sb.append(" and t1.begin_date >= '"+DateUtils.formatDateTime(serviceUserRosterVO.getBeginDate())+"'");
		}
		if (serviceUserRosterVO.getEndDate()!=null){
			sb.append(" and t1.end_date <= '"+DateUtils.formatDateTime(serviceUserRosterVO.getEndDate())+"'");
		}
		sb.append(" ORDER BY t2.office_id asc,order1 desc,t1.begin_date DESC,t2.department_id asc");	
//		sb.append(" ORDER BY t2.office_id asc,t1.serial_number asc,t1.create_date DESC,t2.department_id asc");	
		return serviceUserRosterDao.findBySqlExt(page, sb.toString(), ServiceUserRosterVO.class);
	}
	/***
	 * 查询服务人员排班
	 * @param serviceUserRoster
	 * @return
	 */
	public List<ServiceUserRosterVO> findBySerialNumber(String serialNumber) {
		StringBuilder sb = new StringBuilder();
		sb.append("select t1.id,t1.service_user_id,t1.serial_number,t1.create_date,t1.begin_date,t1.end_date,");
		sb.append(" t2.name service_user_name,t2.department_id,t3.name department_name");
		sb.append(" from sys_service_user_roster t1");
		sb.append("	left join sys_service_user t2 on t2.id=t1.service_user_id");
		sb.append("	left join sys_department t3 on t2.department_id=t3.id ");
		sb.append(" where serial_number =  '"+serialNumber+"' ");
		return serviceUserRosterDao.findBySqlExt(sb.toString(), null, ServiceUserRosterVO.class);
	}
	/***
	 * 查询服务人员是否有排班覆盖
	 * @param serviceUserId
	 * @param serialNumber
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public boolean isHaveRoster(String serviceUserId,String serialNumber,Date beginDate,Date endDate) {
		String beginStr=DateUtils.formatDateTime(beginDate);
		String endStr=DateUtils.formatDateTime(endDate);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t.id FROM sys_service_user_roster t WHERE t.service_user_id = '"+serviceUserId+"' and");
		sb.append(" ((t.begin_date >= '"+beginStr+"' and t.begin_date <= '"+endStr+"')");
		sb.append("OR (t.end_date >= '"+beginStr+"' and t.end_date <= '"+endStr+"')");
		sb.append("OR (t.begin_date <= '"+beginStr+"' and t.end_date >= '"+endStr+"'))");
		if(StringUtils.isNotBlank(serialNumber)){
			sb.append("and t.serial_number !='"+serialNumber+"'");
		}
		List list=serviceUserRosterDao.findBySql(sb.toString(), null);
		if(list!=null&&list.size()>0)
			return true;
		return false;
	}
	/***
	 * 根据序号删除排班
	 * @param serialNumber
	 */
	@Transactional(readOnly = false)
	public void delBySerialNumber(String serialNumber){
		String sql="delete from ServiceUserRoster  where serialNumber = :p1";
		Query query = serviceUserRosterDao.createQuery(sql, new Parameter(serialNumber));
		query.executeUpdate();
	}
	/***
	 * 根据序号删除今天之后的排班
	 * @param serialNumber
	 */
	@Transactional(readOnly = false)
	public void delBySerialNumberAfterToday(String serialNumber){// and TO_DATE(beginDate , 'yyyy-mm-dd') > TO_DATE('"+DateUtils.getDate()+"' , 'yyyy-mm-dd') 
		String sql="delete from sys_service_user_roster where serial_number = '"+serialNumber+"' and DATE_FORMAT(begin_date, '%Y-%m-%d') > DATE_FORMAT(SYSDATE(), '%Y-%m-%d')";
		serviceUserRosterDao.updateBySql(sql, null);	
	}
	/***
	 * 查找排班日期
	 * @param serialNumber
	 */
	public List<ServiceUserRosterVO> findRosterDate(ServiceUserRosterVO serviceUserRosterVO){
		String sql="select * from sys_service_user_roster where 1=1";
		if(StringUtils.isNotBlank(serviceUserRosterVO.getSerialNumber())){
			sql+=" and serial_number = '"+serviceUserRosterVO.getSerialNumber()+"'";
		}
		if(StringUtils.isNotBlank(serviceUserRosterVO.getServiceUserId())){
			sql+=" and service_user_id = '"+serviceUserRosterVO.getServiceUserId()+"'";
		}
		sql+=" group by begin_date order by begin_date asc";
		return serviceUserRosterDao.findBySqlExt(sql, null, ServiceUserRosterVO.class);
	}
	/***
	 * 获取老人计划详情
	 * @param page
	 * @param taskListVO
	 * @return
	 */
	public ElderPlanVO getElderPlanVO(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("select t1.id,t1.service_user_id,");
		sb.append(" t1.begin_date,t1.end_date,t1.times,t1.gap_time,t1.gap_type,t1.intensive,t1.recover_place,");
		sb.append(" t1.do_state,t1.state,t1.short_goal,t1.long_goal,t1.notice,t1.expected_start_time,t1.expected_stop_time,");
		sb.append(" t2.name service_user_name,t2.quarters_id,t3.name quarters_name,");
		sb.append(" t2.department_id,t4.name department_name");
		sb.append(" from sys_elder_plan t1");
		sb.append("	left join sys_service_user t2 on t2.id=t1.service_user_id");
		sb.append("	left join sys_quarters t3 on t2.quarters_id=t3.id ");
		sb.append("	left join sys_department t4 on t1.department_id=t4.id ");
		sb.append("	where t1.id = '"+id+"' ");	
		List<ElderPlanVO> elderPlanVOs=serviceUserRosterDao.findBySqlExt(sb.toString(), null, ElderPlanVO.class);
		if(elderPlanVOs!=null&&elderPlanVOs.size()>0)
			return elderPlanVOs.get(0);
		return null;
	}
	/***
	 * 查询服务人员当日排班任务VO
	 * @param page
	 * @param serviceUserRosterVO
	 * @return
	 */
	public Page<TodayTaskVO> findTodayTask(Page<TodayTaskVO> page,TodayTaskVO todayTaskVO) {
		StringBuilder sb = new StringBuilder();
		sb.append("select t1.id,t1.service_user_id,");
		sb.append(" t2.office_id,t2.name service_user_name,t3.name office_name,");
		sb.append(" t2.quarters_id,t4.name quarters_name,t2.department_id,t5.name department_name,");
		sb.append(" t1.begin_date,t1.end_date");
		sb.append(" from sys_service_user_roster t1");
		sb.append("	left join sys_service_user t2 on t2.id=t1.service_user_id");
		sb.append("	left join sys_office t3 on t2.office_id=t3.id ");
		sb.append("	left join sys_quarters t4 on t2.quarters_id=t4.id ");
		sb.append("	left join sys_department t5 on t2.department_id=t5.id ");
		sb.append("	where 1=1 ");	
		
		if(StringUtils.isNotBlank(todayTaskVO.getOfficeName())){
			sb.append(" and t3.name like '%"+todayTaskVO.getOfficeName()+"%'" );
		}
		if (StringUtils.isNotEmpty(todayTaskVO.getServiceUserName())){
			sb.append(" and t2.name like '%"+todayTaskVO.getServiceUserName()+"%'");
		}
		if (StringUtils.isNotEmpty(todayTaskVO.getDepartmentId())){
			sb.append(" and t2.department_id = '"+todayTaskVO.getDepartmentId()+"'");
		}
		sb.append(" and DATE_FORMAT(t1.begin_date, '%Y-%m-%d') = DATE_FORMAT(SYSDATE(), '%Y-%m-%d')");
		sb.append(" ORDER BY t2.office_id asc,t2.department_id asc,t1.begin_date DESC");	
		return serviceUserRosterDao.findBySqlExt(page, sb.toString(), TodayTaskVO.class);
	}
	/****
	 * 获取计划统计数据
	 * @param page
	 * @param departmentId
	 * @param statType
	 * @return
	 */
	public Map<String,Object[]> getPlanStatValue(String departmentId, String statType){
		Map<String,Object[]> map = Maps.newHashMap();
		
		List<ElderPlanStatVO> list = this.getElderPlanCount(departmentId, statType);
		//升序(d1与d2比较，反之为降序)
	    Collections.sort(list, new Comparator<ElderPlanStatVO>() {
            public int compare(ElderPlanStatVO d1, ElderPlanStatVO d2) {
            	String d1Date = d1.getGatherDateStr();
            	String d2Date = d2.getGatherDateStr();
                return d1Date.compareTo(d2Date);
            }
        });		
	    if(list != null && list.size() > 0){
	    	String[] timelist = new String[list.size()];
	    	Integer[] totallist = new Integer[list.size()];
	    	Integer[] unFinishlist = new Integer[list.size()];
	    	Integer[] onTimeComplist = new Integer[list.size()];
	    	Integer[] delayComplist = new Integer[list.size()];
	    	for( int i = 0; i < list.size(); i ++){
	    		ElderPlanStatVO elderPlanStatVO = list.get(i);		
				timelist[i] = elderPlanStatVO.getGatherDateStr();			
				totallist[i]   = elderPlanStatVO.getTotal();
				unFinishlist[i]   = elderPlanStatVO.getUnFinish();
				onTimeComplist[i] = elderPlanStatVO.getOnTimeComp();
				delayComplist[i] = elderPlanStatVO.getDelayComp();
	    	}
	    	map.put("timelist", timelist);
	    	map.put("totallist", totallist);
	    	map.put("unFinishlist", unFinishlist);
	    	map.put("onTimeComplist", onTimeComplist);
	    	map.put("delayComplist", delayComplist);
	    }else{
	     	map.put("timelist", null);
	     	map.put("totallist", null);
	    	map.put("unFinishlist", null);
	    	map.put("onTimeComplist", null);
	    	map.put("delayComplist", null);
	    }
	    return 	map;
	}
	/***
	 * 获取计划历史数据
	 * @param page
	 * @param departmentId
	 * @param statType
	 * @param statBegDate
	 * @param statEndDate
	 * @return
	 * @throws Exception
	 */
	public List<ElderPlanStatVO> getElderPlanCount(String departmentId, String statType)  {
		String currentDate = DateUtils.getDate();  //当前日期
		String pastDate = "";  //最近日期的第一天				
		pastDate = ElderPlanUtils.getPastDate(statType);	
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t1.gather_date_str,COUNT(*) total,SUM(t1.state = '"+PlanExecuteRecord.EXECUTE_STATE_WAIT+"') un_finish,");
		sb.append("SUM(t1.state = '"+PlanExecuteRecord.EXECUTE_STATE_ONTIME+"') on_time_comp,SUM(t1.state = '"+PlanExecuteRecord.EXECUTE_STATE_DELAY+"') delay_comp");
		sb.append(" FROM (");
		sb.append("SELECT DATE_FORMAT(t.expected_start_time, '%Y-%m-%d') gather_date_str,t.state FROM hn_plan_execute_record t WHERE t.del_flag = '"+MoodIndex.DEL_FLAG_NORMAL+"'");
		sb.append(" AND DATE_FORMAT(t.expected_start_time,'%Y-%m-%d') BETWEEN '" + pastDate + "' AND '" +currentDate+ "'");
		if(StringUtils.isNotBlank(departmentId)){
			sb.append(" AND t.quarters_id in(SELECT id FROM sys_quarters WHERE department_id = '"+departmentId+"' AND del_flag = '"+MoodIndex.DEL_FLAG_NORMAL+"')");
		}
		sb.append(" ) t1");
		sb.append(" GROUP BY DATE_FORMAT(t1.gather_date_str, '%Y-%m-%d')");
		sb.append(" ORDER BY t1.gather_date_str desc");		
		return  this.serviceUserRosterDao.findBySqlExt(sb.toString(), null, ElderPlanStatVO.class);	
	}	
}
