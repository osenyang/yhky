package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Information;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.InformationVO;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.InformationDao;

/**
 * 消息中心Service
 * @author 杜康
 * @version 2016-10-17
 */
@Component
@Transactional(readOnly = true)
public class InformationService extends BaseService {

	@Autowired
	private InformationDao informationDao;
	
	public Information get(String id) {
		return informationDao.get(id);
	}
	
	public Page<InformationVO> find(Page<InformationVO> page, Information information) {
		User user = UserUtils.getUser();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,t1.full_nm,t2.`name` send_nm,t3.`name` department_nm FROM hn_information t");
		sb.append(" left join hn_health_archives t1 on t.archives_id = t1.id ");
		sb.append(" left join sys_service_user t2 on t.send_job_number = t2.job_number ");
		sb.append(" left join sys_department t3 on t2.department_id = t3.id  ");
		sb.append(" WHERE t.del_flag = '"+Information.DEL_FLAG_NORMAL+"'");
		sb.append(" and t.receive_job_number = '"+user.getJobNumber()+"' ");
		if(StringUtils.isNotBlank(information.getTitle())){
			sb.append(" and t.title like '%"+information.getTitle()+"%'");
		}
		sb.append(" ORDER BY t.create_date desc");
		return informationDao.findBySqlExt(page, sb.toString(), InformationVO.class);
	}
	
	/**
	 * 根据ID查询内容
	 * @author dk
	 * @param id
	 * @return InformationVO
	 * */
	public InformationVO findById(String id){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,t1.full_nm,t2.`name` send_nm,t3.`name` department_nm FROM hn_information t");
		sb.append(" left join hn_health_archives t1 on t.archives_id = t1.id ");
		sb.append(" left join sys_service_user t2 on t.send_job_number = t2.job_number ");
		sb.append(" left join sys_department t3 on t2.department_id = t3.id  ");
		sb.append(" WHERE t.del_flag = '"+Information.DEL_FLAG_NORMAL+"'");
		sb.append(" and t.id = '"+id+"' ");
		List<InformationVO> list = informationDao.findBySqlExt(sb.toString(), null, InformationVO.class);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return new InformationVO();
	}
	
	/**
	 * 修改状态为已读
	 * @author dk
	 * @param id
	 * @return 
	 * */
	@Transactional(readOnly = false)
	public void updateReadById(String id){
		informationDao.update("update Information  set state = '"+Information.INFOR_STATE_READ+"' where id = '"+id+"'");
	}
	@Transactional(readOnly = false)
	public void save(Information information) {
		informationDao.save(information);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		informationDao.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void saveBean(Information infor,String[] jobArr){
		for(String jobNumber : jobArr){
			Information newInfor = new Information();
			newInfor.setReceiveJobNumber(jobNumber);
			newInfor.setContent(infor.getContent());
			newInfor.setTitle(infor.getTitle());
			newInfor.setArchivesId(infor.getArchivesId());
			newInfor.setReceiveUsers(infor.getReceiveUsers());
			newInfor.setSendJobNumber(infor.getSendJobNumber());
			newInfor.setState(Information.INFOR_STATE_NORMAL);
			informationDao.save(newInfor);
		}
	}
	
}
