package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.InterveneVO;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.InterveneDao;

/**
 * 干预方案Service
 * @author 杜康
 * @version 2016-10-22
 */
@Component
@Transactional(readOnly = true)
public class InterveneService extends BaseService {

	@Autowired
	private InterveneDao interveneDao;
	
	public Intervene get(String id) {
		return interveneDao.get(id);
	}
	
	public Page<InterveneVO> find(Page<InterveneVO> page, InterveneVO interveneVO) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,t1.state archives_state,t1.photo,t1.full_nm,t1.sex,t1.birth_date,t1.weight,t1.hospitalization_number,t1.id_card,t1.bed_number,t2.area_nm inpatient_nm FROM hn_intervene t");
		sb.append(" left join hn_health_archives t1 on t.archives_id = t1.id ");
		sb.append(" left join hn_health_inpatient t2 on t1.inpatient_id = t2.id ");
		sb.append(" WHERE t.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(interveneVO.getFullNm())){
			sb.append(" AND t1.full_nm like '%"+interveneVO.getFullNm()+"%'");
		}
		
		if(StringUtils.isNotBlank(interveneVO.getIdCard())){
			sb.append(" AND t1.id_card like '%"+interveneVO.getIdCard()+"%'");
		}
		
		if(StringUtils.isNotBlank(interveneVO.getHospitalizationNumber())){
			sb.append(" AND t1.hospitalization_number like '%"+interveneVO.getHospitalizationNumber()+"%'");
		}
		
		if(StringUtils.isNotBlank(interveneVO.getBedNumber())){
			sb.append(" AND t1.bed_number like '%"+interveneVO.getBedNumber()+"%'");
		}
		
		if(StringUtils.isNotBlank(interveneVO.getArchivesState())){
			sb.append(" AND t1.state = '"+interveneVO.getArchivesState()+"'");
		}
		
		if(StringUtils.isNotBlank(interveneVO.getInpatientNm())){
			sb.append(" AND t2.area_nm like '%"+interveneVO.getInpatientNm()+"%'");
		}
		
		sb.append(" ORDER BY t.create_date desc");
		return interveneDao.findBySqlExt(page, sb.toString(), InterveneVO.class);
	}
	
	
	/**
	 * 根据ID查询
	 * @author dk
	 * @param id
	 * @return InterveneVO
	 * **/
	public InterveneVO findById(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.*,t1.photo,t1.full_nm,t1.sex,t1.birth_date,t1.weight,t1.hospitalization_number,t1.id_card,t1.degree,t1.occupation,t1.medical_type,t1.bed_number FROM hn_intervene t");
		sql.append(" left join hn_health_archives t1 on t.archives_id = t1.id ");
		sql.append(" WHERE t.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"'");
		sql.append(" and t.id = '"+id+"'");
		sql.append(" ORDER BY t.create_date desc");
		List<InterveneVO> list = interveneDao.findBySqlExt(sql.toString(), null, InterveneVO.class);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return new InterveneVO();
	}
	
	/**
	 * 根据userID查询
	 * @author dk
	 * @param id
	 * @return InterveneVO
	 * **/
	public InterveneVO findByArchivesId(String userId){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.*,t1.photo,t1.full_nm,t1.sex,t1.birth_date,t1.weight,t1.hospitalization_number,t1.id_card,t1.degree,t1.occupation,t1.medical_type FROM hn_intervene t");
		sql.append(" left join hn_health_archives t1 on t.archives_id = t1.id ");
		sql.append(" WHERE t.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"'");
		sql.append(" and t1.user_id = '"+userId+"'");
		sql.append(" ORDER BY t.create_date desc");
		List<InterveneVO> list = interveneDao.findBySqlExt(sql.toString(), null, InterveneVO.class);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return new InterveneVO();
	}
	
	/**
	 * 根据userID查询
	 * @author dk
	 * @param id
	 * @return InterveneVO
	 * **/
	public Boolean findStateByArchivesId(String archivesId){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.* FROM hn_intervene t");
		sql.append(" left join hn_health_archives t1 on t.archives_id = t1.id ");
		sql.append(" WHERE t.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"'");
		sql.append(" and t.state = '"+Intervene.INTER_STATE_EXECUTE+"'");
		sql.append(" and t.archives_id = '"+archivesId+"'");
		sql.append(" ORDER BY t.create_date desc");
		List<InterveneVO> list = interveneDao.findBySqlExt(sql.toString(), null, InterveneVO.class);
		if(list != null && list.size() > 0){
			return false;
		}
		return true;
	}
	
	
	@Transactional(readOnly = false)
	public void save(Intervene intervene) {
		interveneDao.save(intervene);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		interveneDao.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void updateState(String id,String state) {
		String sql = "update Intervene set state = '"+state+"' where id = '"+id+"'";
		interveneDao.update(sql);
	}
	
	/**
	 * 根据userID查询是否有方案
	 * @author dk
	 * @param userId
	 * @return Boolean
	 * **/
	public boolean findInterveneByArchivesId(String archivesId){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.* FROM hn_intervene t ");
		sql.append(" WHERE t.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"' and  t.archives_id = '"+archivesId+"'");
		sql.append(" ORDER BY t.create_date desc");
		List<InterveneVO> list = interveneDao.findBySqlExt(sql.toString(), null, InterveneVO.class);
		if(list != null && list.size() > 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 根据userID查询方案
	 * @author dk
	 * @param userId
	 * @return Intervene
	 * **/
	public Intervene findIntervene(String archivesId){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.* FROM hn_intervene t ");
		sql.append(" WHERE t.del_flag = '"+Intervene.DEL_FLAG_NORMAL+"' and  t.archives_id = '"+archivesId+"'");
		sql.append(" ORDER BY t.create_date desc");
		List<Intervene> list = interveneDao.findBySqlExt(sql.toString(), null, Intervene.class);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return new Intervene();
	}
	
}
