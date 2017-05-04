package com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * 营养计划 Title:
 * com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionPlan
 * Description:
 * 
 * @createTime: 2017年4月26日 - 上午11:22:21
 * @Company: Elink
 * @author: 杨鉴浩
 * @version: 1.0
 */
@Entity
@Table(name = "plan_nutrition")
public class NutritionPlan extends BasePlan {

	private static final long serialVersionUID = -5122943652967859069L;
	/**
	 * 
	 */

	/** 身高（m) */
	private String height;
	/** 体重（kg) */
	private String weight;
	/** 小腿围（cm) */
	private String calf;
	/** BMI值 */
	private String bmi;

	/** 营养相关疾病 */
	private String disease;

	/** MNA-SF营养评估结果 */
	private String mnaSf;
	/** 该患者属于 */
	private String belong;
	/** 营养诊断 */
	private List<NutritionDiagnosis> nutritionDiagnosis;
	/** 营养诊断 ids */
	private List<String> nutritionDiagnosisIds;
	/** 经口摄食能力 */
	private String feedingActivity;
	/** 消化吸收能力 */
	private String digestibility;
	/** 食欲情况 */
	private String appetite;
	/** 营养代谢 */
	private String nutritionAndMetabolism;

	/** 计划每日所需能量/kcal */
	private String dailyEnergy;
	/** 计划每日所需水量/ml */
	private String dailyWater;
	/** 计划每日蛋白质供给量/g */
	private String dailyProtein;
	/** 实际能量合计/kcal */
	private String actualTotalEnergy;
	/** 实际水量合计/ml */
	private String actualTotalWater;
	/** 实际蛋白质合计/g */
	private String actualTotalProtein;
	/** 能量差额/kcal */
	private String marginEnergy;
	/** 水量差额/ml */
	private String marginWater;
	/** 蛋白质差额/g */
	private String marginProtein;

	/** 膳食营养相关指导 */
	private String direct;

	/** 营养项目 */
	private List<NutritionItem> items;
	private List<String> itemNames;
	private List<String> takeWays;
	private List<String> mealNums;

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getCalf() {
		return calf;
	}

	public void setCalf(String calf) {
		this.calf = calf;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getMnaSf() {
		return mnaSf;
	}

	public void setMnaSf(String mnaSf) {
		this.mnaSf = mnaSf;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	@ManyToMany
	@OrderBy(value  = "name asc")
	public List<NutritionDiagnosis> getNutritionDiagnosis() {
		return nutritionDiagnosis;
	}

	public void setNutritionDiagnosis(List<NutritionDiagnosis> nutritionDiagnosis) {
		this.nutritionDiagnosis = nutritionDiagnosis;
	}

	@Transient
	public List<String> getNutritionDiagnosisIds() {
		return nutritionDiagnosisIds;
	}

	public void setNutritionDiagnosisIds(List<String> nutritionDiagnosisIds) {
		this.nutritionDiagnosisIds = nutritionDiagnosisIds;
	}

	public String getFeedingActivity() {
		return feedingActivity;
	}

	public void setFeedingActivity(String feedingActivity) {
		this.feedingActivity = feedingActivity;
	}

	public String getDigestibility() {
		return digestibility;
	}

	public void setDigestibility(String digestibility) {
		this.digestibility = digestibility;
	}

	public String getAppetite() {
		return appetite;
	}

	public void setAppetite(String appetite) {
		this.appetite = appetite;
	}

	public String getNutritionAndMetabolism() {
		return nutritionAndMetabolism;
	}

	public void setNutritionAndMetabolism(String nutritionAndMetabolism) {
		this.nutritionAndMetabolism = nutritionAndMetabolism;
	}

	public String getDailyEnergy() {
		return dailyEnergy;
	}

	public void setDailyEnergy(String dailyEnergy) {
		this.dailyEnergy = dailyEnergy;
	}

	public String getDailyWater() {
		return dailyWater;
	}

	public void setDailyWater(String dailyWater) {
		this.dailyWater = dailyWater;
	}

	public String getDailyProtein() {
		return dailyProtein;
	}

	public void setDailyProtein(String dailyProtein) {
		this.dailyProtein = dailyProtein;
	}

	public String getActualTotalEnergy() {
		return actualTotalEnergy;
	}

	public void setActualTotalEnergy(String actualTotalEnergy) {
		this.actualTotalEnergy = actualTotalEnergy;
	}

	public String getActualTotalWater() {
		return actualTotalWater;
	}

	public void setActualTotalWater(String actualTotalWater) {
		this.actualTotalWater = actualTotalWater;
	}

	public String getActualTotalProtein() {
		return actualTotalProtein;
	}

	public void setActualTotalProtein(String actualTotalProtein) {
		this.actualTotalProtein = actualTotalProtein;
	}

	public String getMarginEnergy() {
		return marginEnergy;
	}

	public void setMarginEnergy(String marginEnergy) {
		this.marginEnergy = marginEnergy;
	}

	public String getMarginWater() {
		return marginWater;
	}

	public void setMarginWater(String marginWater) {
		this.marginWater = marginWater;
	}

	public String getMarginProtein() {
		return marginProtein;
	}

	public void setMarginProtein(String marginProtein) {
		this.marginProtein = marginProtein;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	@OneToMany
	@OrderBy(value  = "itemName asc")
	@JoinColumn(name = "nutrition_plan_id")
	@Cascade(value= {CascadeType.SAVE_UPDATE,CascadeType.PERSIST,CascadeType.MERGE})
	public List<NutritionItem> getItems() {
		return items;
	}

	public void setItems(List<NutritionItem> items) {
		this.items = items;
	}

	@Transient
	public List<String> getItemNames() {
		return itemNames;
	}

	public void setItemNames(List<String> itemNames) {
		this.itemNames = itemNames;
	}

	@Transient
	public List<String> getTakeWays() {
		return takeWays;
	}

	public void setTakeWays(List<String> takeWays) {
		this.takeWays = takeWays;
	}

	@Transient
	public List<String> getMealNums() {
		return mealNums;
	}

	public void setMealNums(List<String> mealNums) {
		this.mealNums = mealNums;
	}

}
