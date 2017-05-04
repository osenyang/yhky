package com.elink.hospitalhealthnurse.modules.statistics.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.statistics.vo.BaseDataVO;
import com.google.common.collect.Maps;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.HealthArchivesDao;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthArchives;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;

/**
 * 基础数据Service
 * @author 颜福艳
 * @version 2016-10-19
 */
@Component
@Transactional(readOnly = true)
public class BaseDataService extends BaseService {

	@Autowired
	private HealthArchivesDao healthArchivesDao;
	
	/****
	 * 获取基础数据-性别
	 * @return
	 */
	public Map<String,int[]> getSexAvgStatValue(){
		Map<String,int[]> map = Maps.newHashMap();
    	int[] valuelist = new int[2];
		List<BaseDataVO> list = this.getSexAvg();
	    if(list != null && list.size() > 0){
	    	BaseDataVO data = list.get(0);
			valuelist[0]   = data.getValue();//女
			valuelist[1]   = data.getValue1();//男
	    	map.put("valuelist", valuelist);
	    }else{
	     	map.put("valuelist", valuelist);
	    }
	    return 	map;
	}
	
	/***
	 * 获取基础数据-性别
	 * @return
	 */
	public List<BaseDataVO> getSexAvg()  {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SUM(t.sex = '女') value,SUM(t.sex = '男') value1 ");
		sb.append("FROM hn_health_archives t WHERE t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		return  this.healthArchivesDao.findBySqlExt(sb.toString(),null, BaseDataVO.class);	
	}	
	
	/****
	 * 获取基础数据-年龄
	 * @return
	 */
	public Map<String,int[]> getAgeAvgStatValue(){
		Map<String,int[]> map = Maps.newHashMap();
    	int[] valuelist = new int[4];
		List<BaseDataVO> list = this.getAgeAvg();
		if(list != null && list.size() > 0){
			BaseDataVO ageVo = list.get(0);
			valuelist[0]   = ageVo.getValue();//60岁以下
			valuelist[1]   = ageVo.getValue1();//60~69岁
			valuelist[2]   = ageVo.getValue2();//70~79岁
			valuelist[3]   = ageVo.getValue3();//80岁以上
	    	map.put("valuelist", valuelist);
	    }else{
	     	map.put("valuelist", valuelist);
	    }
	    return 	map;
	}
	
	/***
	 * 获取基础数据-年龄
	 * @return
	 */
	public List<BaseDataVO> getAgeAvg()  {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT sum(t1.age < 60) value,sum(t1.age >= 60 and t1.age < 70) value1,");
		sb.append("sum(t1.age >= 70 and t1.age < 80) value2,sum(t1.age >= 80) value3 FROM (");
		sb.append("SELECT t.id,DATE_FORMAT(FROM_DAYS(TO_DAYS(NOW())-TO_DAYS(t.birth_date)), '%Y')+0 AS age ");
		sb.append("FROM hn_health_archives t WHERE t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		sb.append(")t1");
		return this.healthArchivesDao.findBySqlExt(sb.toString(),null, BaseDataVO.class);	
	}	
	
	/****
	 * 获取基础数据-康复情况
	 * @return
	 */
	public Map<String,int[]> getRecureAvgStatValue(){
		Map<String,int[]> map = Maps.newHashMap();
    	int[] valuelist = new int[2];
		List<BaseDataVO> list = this.getRecureAvg();
	    if(list != null && list.size() > 0){
	    	BaseDataVO data = list.get(0);
			valuelist[0]   = data.getValue();//已康复
			valuelist[1]   = data.getValue1();//治疗中
	    	map.put("valuelist", valuelist);
	    }else{
	     	map.put("valuelist", valuelist);
	    }
	    return 	map;
	}
	
	/***
	 * 获取基础数据-康复情况
	 * @return
	 */
	public List<BaseDataVO> getRecureAvg()  {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SUM(t.state = '"+Intervene.INTER_STATE_STOP+"') value,SUM(t.state = '"+Intervene.INTER_STATE_EXECUTE+"' OR t.state = '"+Intervene.INTER_STATE_PAUSE+"') value1 ");
		sb.append("FROM hn_intervene t WHERE t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		return  this.healthArchivesDao.findBySqlExt(sb.toString(),null, BaseDataVO.class);	
	}
	
	/****
	 * 获取基础数据-计划类型
	 * @return
	 */
	public Map<String,int[]> getPlanAvgStatValue(){
		Map<String,int[]> map = Maps.newHashMap();
		int[] valuelist = new int[7];
		List<BaseDataVO> list = this.getPlanAvg();
	    if(list != null && list.size() > 0){
	    	BaseDataVO data = list.get(0);
			valuelist[0]   = data.getValue();//诊疗计划
			valuelist[1]   = data.getValue1();//护理计划
			valuelist[2]   = data.getValue2();//护照计划
			valuelist[3]   = data.getValue3();//营养计划
			valuelist[4]   = data.getValue4();//康复计划
			valuelist[5]   = data.getValue5();//社工计划
			valuelist[6]   = data.getValue6();//其他计划
	    	map.put("valuelist", valuelist);
	    }else{
	     	map.put("valuelist", valuelist);
	    }
	    return 	map;
	}
	
	/***
	 * 获取基础数据-计划类型
	 * @return
	 */
	public List<BaseDataVO> getPlanAvg()  {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SUM(t.assessment_id != '') value,SUM(t.nurser_id != '') value1,");
		sb.append("SUM(t.care_id != '') value2,SUM(t.nutrition_id != '') value3,");
		sb.append("SUM(t.recover_id != '') value4,SUM(t.social_id != '') value5,");
		sb.append("(SELECT COUNT(t1.id) FROM hn_intervene_meet t1 where t1.intervene_id in(SELECT id FROM hn_intervene WHERE del_flag = '0' and (state = '1' OR state = '2'))) value6 ");
		sb.append("FROM hn_intervene t WHERE t.del_flag = '"+HealthArchives.DEL_FLAG_NORMAL+"' ");
		sb.append("AND (t.state = '"+Intervene.INTER_STATE_EXECUTE+"' OR t.state = '"+Intervene.INTER_STATE_PAUSE+"')");
		return  this.healthArchivesDao.findBySqlExt(sb.toString(),null, BaseDataVO.class);	
	}
}
