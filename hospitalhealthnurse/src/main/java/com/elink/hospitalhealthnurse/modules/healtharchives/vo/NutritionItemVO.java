package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;


public class NutritionItemVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String itemNm;//项目名称
	private String meals; //每天几餐    
	private String mealsNumber; //每餐摄入量    
	private String energy; //产生能量    
	private String arrange; //餐次安排   
	private String quartersNm;//执行人/岗位
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getMealsNumber() {
		return mealsNumber;
	}
	public void setMealsNumber(String mealsNumber) {
		this.mealsNumber = mealsNumber;
	}
	public String getEnergy() {
		return energy;
	}
	public void setEnergy(String energy) {
		this.energy = energy;
	}
	public String getArrange() {
		return arrange;
	}
	public void setArrange(String arrange) {
		this.arrange = arrange;
	}
	public String getQuartersNm() {
		return quartersNm;
	}
	public void setQuartersNm(String quartersNm) {
		this.quartersNm = quartersNm;
	}
	
	
}


