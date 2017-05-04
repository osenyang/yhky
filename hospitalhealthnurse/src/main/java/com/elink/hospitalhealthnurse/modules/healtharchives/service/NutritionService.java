package com.elink.hospitalhealthnurse.modules.healtharchives.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Nutrition;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionDiagnosis;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionItem;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionPlan;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.NutritionVO;
import com.elink.hospitalhealthnurse.modules.serviceorg.dao.ServiceUserDao;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.google.common.collect.Lists;
import com.elink.hospitalhealthnurse.modules.healtharchives.dao.NutritionDao;

/**
 * 营养计划
 * Title: com.elink.hospitalhealthnurse.modules.healtharchives.service.NutritionService
 * Description:
 * @createTime: 2017年5月3日 - 上午9:26:52
 * @Company: Elink
 * @author: 杨鉴浩
 * @version: 1.0
 */
@Component
@Transactional(readOnly = true)
public class NutritionService extends BaseService {

	@Autowired
	private NutritionDao nutritionDao;
	@Autowired
	private ServiceUserDao userDao;
	
	public NutritionPlan get(String id) {
		return nutritionDao.get(id);
	}
	
	public Page<Nutrition> find(Page<Nutrition> page, Nutrition nutrition) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM hn_health_nutrition t");
		sb.append(" WHERE t.del_flag = '"+Nutrition.DEL_FLAG_NORMAL+"'");
		sb.append(" ORDER BY t.create_date desc");
		return nutritionDao.findBySqlExt(page, sb.toString(), Nutrition.class);
	}
	
	/*@Transactional(readOnly = false)
	public void save(Nutrition nutrition) {
		nutritionDao.save(nutrition);
	}*/
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		nutritionDao.deleteById(id);
	}
	/**
	 * 根据ID查询营养计划
	 * @author dk
	 * @data 2016-11-16
	 * @param Id
	 * @return 
	 * */
	public NutritionVO findByIdWs(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.img_url dietitian_photo, t.* from hn_health_nutrition t ");
		sql.append(" left join sys_service_user t1 on t1.job_number = t.dietitian_id ");
		sql.append(" where t.id = '"+id+"'");
		List<NutritionVO> nutritionList = nutritionDao.findBySqlExt(sql.toString(), null, NutritionVO.class);
		if(nutritionList != null && nutritionList.size() > 0){
			return nutritionList.get(0);
		}
		return new NutritionVO();
	}

	@Transactional(readOnly = false)
	public NutritionPlan save(NutritionPlan nutritionPlan) {
		BigDecimal weight = new BigDecimal(nutritionPlan.getWeight());
		BigDecimal height = new BigDecimal(nutritionPlan.getHeight());
		BigDecimal multiply = height.multiply(height);
		BigDecimal divide = weight.divide(multiply, 2, BigDecimal.ROUND_HALF_UP);
		String bmi =  divide.toString();
		nutritionPlan.setBmi(bmi);
		
		
		
		ServiceUser serviceUser = userDao.getByJobNo(nutritionPlan.getServiceUser().getJobNumber());
		nutritionPlan.setServiceUser(serviceUser);
		
		
		List<NutritionItem> items = nutritionPlan.getItems();
		
		/*for (NutritionItem nutritionItem : items) {
			
			String jobNumber = nutritionItem.getCaterUser().getJobNumber();
			if (StringUtils.isNotBlank(jobNumber)) {
				ServiceUser caterUser = userDao.getByJobNo(jobNumber);
				nutritionItem.setCaterUser(caterUser);
			}
			
			String jobNumber2 = nutritionItem.getReceiveUser().getJobNumber();
			if (StringUtils.isNotBlank(jobNumber2)) {
				
				ServiceUser receiveUser = userDao.getByJobNo(jobNumber2);
				nutritionItem.setReceiveUser(receiveUser);
			}
			
			String jobNumber3 = nutritionItem.getExecuteUser().getJobNumber();
			if (StringUtils.isNotBlank(jobNumber3)) {
				
				ServiceUser executeUser = userDao.getByJobNo(jobNumber3);
				nutritionItem.setReceiveUser(executeUser);
			}
		}*/
		
//		nutritionPlan.setItems(null);
		
		
		List<NutritionDiagnosis> nutritionDiagnosis = nutritionDao.getNdListByIds(nutritionPlan.getNutritionDiagnosisIds());
		nutritionPlan.setNutritionDiagnosis(nutritionDiagnosis);
		
		nutritionDao.mergeOrUpdate(nutritionPlan);
		
		return nutritionPlan;
	}

	public List<NutritionDiagnosis> getNdList() {
		return nutritionDao.getNdList();
	}

	public List<String> getItemNames() {
		List<String> strs = Lists.newArrayList();
		strs.add("流质饮食（1200kcal套餐）");
		strs.add("流质饮食（1600kcal套餐）");
		strs.add("水剂口服营养补充");
		strs.add("粉剂口服营养补充");
		strs.add("全天肠内营养制剂");
		strs.add("高能量膳食");
		strs.add("高蛋白膳食");
		strs.add("高膳食纤维膳食");
		strs.add("益生菌补充");
		strs.add("饮水+增稠剂粉剂");
		strs.add("增稠剂水剂");
		return strs;
	}

	public List<String> getTakeWays() {
		List<String> strs = Lists.newArrayList();
		strs.add("按餐口服");
		strs.add("鼻饲推注");
		strs.add("鼻饲泵入");
		strs.add("鼻肠推注");
		strs.add("鼻肠泵入");
		strs.add("十二指肠推注");
		strs.add("十二指肠泵入");
		strs.add("高温冲服");
		strs.add("温水冲服");
		strs.add("缓慢多次给予");
		return strs;
	}

	public List<String> getMealNums() {
		List<String> strs = Lists.newArrayList();
		for (int i = 1; i < 9; i++) {
			strs.add(Integer.toString(i));
		}
		return strs;
	}
}
