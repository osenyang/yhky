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
import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.statistics.entity.MoodIndex;
import com.elink.hospitalhealthnurse.modules.statistics.vo.MoodIndexVO;
import com.elink.hospitalhealthnurse.modules.statistics.vo.MoodValueVO;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.modules.statistics.dao.MoodIndexDao;

/**
 * 心情指数Service
 * @author 颜福艳
 * @version 2016-10-11
 */
@Component
@Transactional(readOnly = true)
public class MoodIndexService extends BaseService {

	@Autowired
	private MoodIndexDao moodIndexDao;
	
	public MoodIndex get(String id) {
		return moodIndexDao.get(id);
	}
	
	public Page<MoodIndexVO> find(Page<MoodIndexVO> page, MoodIndexVO moodIndex) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.user_id,t.office_id,t.mood_value,DATE_FORMAT(t.create_date, '%Y-%m-%d %H:%i') create_date,");
		sb.append("t1.full_nm,t1.sex,DATE_FORMAT(FROM_DAYS(TO_DAYS(NOW())-TO_DAYS(t1.birth_date)), '%Y')+0 age,t1.photo,");
		sb.append("t2.`name` office_nm");
		sb.append(" FROM hn_mood_index t");
		sb.append(" LEFT JOIN hn_health_archives t1 ON t1.user_id = t.user_id");
		sb.append(" LEFT JOIN sys_office t2 ON t2.id = t.office_id");
		sb.append(" WHERE t.del_flag = '"+MoodIndex.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(moodIndex.getOfficeId())){
			sb.append(" AND t.office_id = '"+moodIndex.getOfficeId()+"'");
		}
		if(StringUtils.isNotBlank(moodIndex.getOfficeNm())){
			sb.append(" AND t2.`name` like '%"+moodIndex.getOfficeNm()+"%'");
		}
		if(StringUtils.isNotBlank(moodIndex.getFullNm())){
			sb.append(" AND t1.full_nm like '%"+moodIndex.getFullNm()+"%'");
		}
		if(StringUtils.isNotBlank(moodIndex.getMoodValue())){
			sb.append(" AND t.mood_value = '"+moodIndex.getMoodValue()+"'");
		}
		if(StringUtils.isNotBlank(moodIndex.getStartDate()) && StringUtils.isNotBlank(moodIndex.getEndDate())){
			sb.append(" AND DATE_FORMAT(t.create_date, '%Y-%m-%d') BETWEEN '"+moodIndex.getStartDate()+"' AND '"+moodIndex.getEndDate()+"'");
		}else if(StringUtils.isNotBlank(moodIndex.getStartDate())){
			sb.append(" AND DATE_FORMAT(t.create_date, '%Y-%m-%d') >= '"+moodIndex.getStartDate()+"'");
		}else if(StringUtils.isNotBlank(moodIndex.getEndDate())){
			sb.append(" AND DATE_FORMAT(t.create_date, '%Y-%m-%d') <= '"+moodIndex.getEndDate()+"'");
		}
		
		sb.append(" ORDER BY t.create_date desc");
		return moodIndexDao.findBySqlExt(page, sb.toString(), MoodIndexVO.class);
	}
	
	public List<MoodIndexVO> wsFind(MoodIndexVO moodIndex) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.id,t.mood_value,DATE_FORMAT(t.create_date, '%Y-%m-%d') create_date");
		sb.append(" FROM hn_mood_index t");
		sb.append(" WHERE t.del_flag = '"+MoodIndex.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(moodIndex.getUserId())){
			sb.append(" AND t.user_id = '"+moodIndex.getUserId()+"'");
		}
		if(StringUtils.isNotBlank(moodIndex.getStartDate()) && StringUtils.isNotBlank(moodIndex.getEndDate())){
			sb.append(" AND DATE_FORMAT(t.create_date, '%Y-%m-%d') BETWEEN '"+moodIndex.getStartDate()+"' AND '"+moodIndex.getEndDate()+"'");
		}
		sb.append(" ORDER BY t.create_date asc");
		return moodIndexDao.findBySqlExt(sb.toString(),null, MoodIndexVO.class);
	}
	
	/****
	 * 获取心情指数数据
	 * @param page
	 * @param userId
	 * @param statType
	 * @return
	 */
	public Map<String,Object[]> getMoodIndexAvgStatValue(Page<MoodValueVO> page,String statType){
		Map<String,Object[]> map = Maps.newHashMap();
		
		Page<MoodValueVO> pageNew = this.getMoodIndexAvg(page, statType);
		List<MoodValueVO> list = pageNew.getList();
		//升序(d1与d2比较，反之为降序)
	    Collections.sort(list, new Comparator<MoodValueVO>() {
            public int compare(MoodValueVO d1, MoodValueVO d2) {
            	String d1Date = d1.getCreateDate();
            	String d2Date = d2.getCreateDate();
                return d1Date.compareTo(d2Date);
            }
        });		
	    if(list != null && list.size() > 0){
	    	String[] timelist = new String[list.size()];
	    	Integer[] joylist = new Integer[list.size()];
	    	Integer[] happylist = new Integer[list.size()];
	    	Integer[] commonlylist = new Integer[list.size()];
	    	Integer[] depressedlist = new Integer[list.size()];
	    	Integer[] angrylist = new Integer[list.size()];
	    	Integer[] sadlist = new Integer[list.size()];
	    	for( int i = 0; i < list.size(); i ++){
	    		MoodValueVO moodValue = list.get(i);		
				timelist[i] = moodValue.getCreateDate();			
				joylist[i]   = moodValue.getJoy();
				happylist[i]   = moodValue.getHappy();
				commonlylist[i] = moodValue.getCommonly();
				depressedlist[i]   = moodValue.getDepressed();
				angrylist[i] = moodValue.getAngry();
				sadlist[i]   = moodValue.getSad();
	    	}
	    	map.put("timelist", timelist);
	    	map.put("joylist", joylist);
	    	map.put("happylist", happylist);
	    	map.put("commonlylist", commonlylist);
	    	map.put("depressedlist", depressedlist);
	    	map.put("angrylist", angrylist);
	    	map.put("sadlist", sadlist);
	    	map.put("pagestr", new String[]{pageNew.toString()});
	    }else{
	    	map.put("timelist", null);
	     	map.put("joylist", null);
	    	map.put("happylist", null);
	    	map.put("commonlylist", null);
	    	map.put("depressedlist", null);
	    	map.put("angrylist", null);
	    	map.put("sadlist", null);
	    	map.put("pagestr", new String[]{pageNew.toString()});
	    }
	    return 	map;
	}
	
	/***
	 * 获取心情指数历史数据
	 * @param page
	 * @param userId
	 * @param statType
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public Page<MoodValueVO> getMoodIndexAvg(Page<MoodValueVO> page,String statType)  {
		String currentDate = DateUtils.getDate();  //当前日期
		String pastDate = DateUtils.getPastDate(statType);  //最近日期的第一天
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t1.create_date,SUM(t1.mood_value = '"+Consts.MOOD_JOY+"') joy,SUM(t1.mood_value = '"+Consts.MOOD_HAPPY+"') happy,");
		sb.append("SUM(t1.mood_value = '"+Consts.MOOD_COMMONLY+"') commonly,SUM(t1.mood_value = '"+Consts.MOOD_DEPRESSED+"') depressed,");
		sb.append("SUM(t1.mood_value = '"+Consts.MOOD_ANGRY+"') angry,SUM(t1.mood_value = '"+Consts.MOOD_SAD+"') sad");
		sb.append(" FROM (");
		sb.append("SELECT DATE_FORMAT(t.create_date, '%Y-%m-%d') create_date,t.mood_value FROM hn_mood_index t WHERE t.del_flag = '"+MoodIndex.DEL_FLAG_NORMAL+"'");
		sb.append(" AND DATE_FORMAT(t.create_date,'%Y-%m-%d') BETWEEN '" + pastDate + "' AND '" +currentDate+ "'");
		sb.append(" ) t1");
		sb.append(" GROUP BY DATE_FORMAT(t1.create_date, '%Y-%m-%d')");
		sb.append(" ORDER BY t1.create_date desc");		
		return  this.moodIndexDao.findBySqlExt(page, sb.toString(), MoodValueVO.class);	
	}	
	
	@Transactional(readOnly = false)
	public void save(MoodIndex moodIndex) {
		moodIndexDao.save(moodIndex);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		moodIndexDao.deleteById(id);
	}
	
}
