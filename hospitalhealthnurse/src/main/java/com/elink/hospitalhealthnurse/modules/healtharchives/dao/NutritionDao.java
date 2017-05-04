package com.elink.hospitalhealthnurse.modules.healtharchives.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.elink.hospitalhealthnurse.common.persistence.BaseDao;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionDiagnosis;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionPlan;

/**
 * 营养计划DAO接口
 * @author 杜康
 * @version 2016-10-26
 */
@Repository
public class NutritionDao extends BaseDao<NutritionPlan> {

	
	
	public NutritionPlan mergeOrUpdate(NutritionPlan nutritionPlan) {
		return mergeOrUpdate(nutritionPlan, nutritionPlan.getId());
	}

	@SuppressWarnings("unchecked")
	public List<NutritionDiagnosis> getNdList() {
		String hql = "FROM NutritionDiagnosis";
		
		return getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<NutritionDiagnosis> getNdListByIds(List<String> nutritionDiagnosisIds) {
		String hql = "FROM NutritionDiagnosis where id in (:ids)";
		
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids", nutritionDiagnosisIds);
		return query.list();
	}

	
	
}
