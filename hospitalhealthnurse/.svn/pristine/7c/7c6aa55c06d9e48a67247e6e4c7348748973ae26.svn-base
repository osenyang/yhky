package com.elink.hospitalhealthnurse.modules.plan.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.NutritionItemVO;

/**
 * 营养计划Entity
 * @author 杜康
 * @version 2016-11-04
 */
public class ElderPlanNutritionVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String archivesId;	
	private String elderName;	
	private String quartersId;	
	private String quartersName;	
	private String interveneId;	
	private String bedNumber;
	
	private String dietitianId; //主管营养师    
	private java.util.Date treatStartTime; //营养支持治疗开始时间    
	private java.util.Date treatEndTime; //营养支持治疗结束时间    
	private String assessResult; //营养评估结果    
	private String clinicalDiagnosis; //临床诊断    
	private String food; //普食    
	private String foodMeals; //普食(每天几餐)    
	private String foodMealsNumber; //普食(每餐摄入量)    
	private String foodEnergy; //普食(产生能量)    
	private String foodArrange; //普食(餐次安排)    
	private String foodQuartersId; //普食(执行人/岗位)    
	private String papmeat; //软食    
	private String papmeatMeals; //软食(每天几餐)    
	private String papmeatMealsNumber; //软食(每餐摄入量)    
	private String papmeatEnergy; //软食(产生能量)    
	private String papmeatArrange; //软食(餐次安排)    
	private String papmeatQuartersId; //软食(执行人/岗位)    
	private String semiLiquid; //半流质    
	private String semiLiquidMeals; //半流质(每天几餐)    
	private String semiLiquidMealsNumber; //半流质(每餐摄入量)    
	private String semiLiquidEnergy; //半流质(产生能量)    
	private String semiLiquidArrange; //半流质(餐次安排)    
	private String semiLiquidQuartersId; //半流质(执行人/岗位)    
	private String liquid; //流质    
	private String liquidMeals; //流质(每天几餐)    
	private String liquidMealsNumber; //流质(每餐摄入量)    
	private String liquidEnergy; //流质(产生能量)    
	private String liquidArrange; //流质(餐次安排)    
	private String liquidQuartersId; //流质(执行人/岗位)    
	private String ons; //口服营养补充    
	private String onsMeals; //口服营养补充(每天几餐)    
	private String onsMealsNumber; //口服营养补充(每餐摄入量)    
	private String onsEnergy; //口服营养补充(产生能量)    
	private String onsArrange; //口服营养补充(餐次安排)    
	private String onsQuartersId; //口服营养补充(执行人/岗位)    
	private String ten; //全天肠内营养    
	private String tenMeals; //全天肠内营养(每天几餐)    
	private String tenMealsNumber; //全天肠内营养(每餐摄入量)    
	private String tenEnergy; //全天肠内营养(产生能量)    
	private String tenArrange; //全天肠内营养(餐次安排)    
	private String tenQuartersId; //全天肠内营养(执行人/岗位)    
	private String pen; //部分肠内    
	private String penMeals; //部分肠内(每天几餐)    
	private String penMealsNumber; //部分肠内(每餐摄入量)    
	private String penEnergy; //部分肠内(产生能量)    
	private String penArrange; //部分肠内(餐次安排)    
	private String penQuartersId; //部分肠内(执行人/岗位)    
	private String ppn; //部分肠外    
	private String ppnMeals; //部分肠外(每天几餐)    
	private String ppnMealsNumber; //部分肠外(每餐摄入量)    
	private String ppnEnergy; //部分肠外(产生能量)    
	private String ppnArrange; //部分肠外(餐次安排)    
	private String ppnQuartersId; //部分肠外(执行人/岗位)    
	private String tpn; //全天肠外营养    
	private String tpnMeals; //全天肠外营养(每天几餐)    
	private String tpnMealsNumber; //全天肠外营养(每餐摄入量)    
	private String tpnEnergy; //全天肠外营养(产生能量)    
	private String tpnArrange; //全天肠外营养(餐次安排)    
	private String tpnQuartersId; //全天肠外营养(执行人/岗位)    
	private String drinkWater; //饮水/喂水量    
	private String drinkWaterMeals; //饮水/喂水量(每天几餐)    
	private String drinkWaterMealsNumber; //饮水/喂水量(每餐摄入量)    
	private String drinkWaterEnergy; //饮水/喂水量(产生能量)    
	private String drinkWaterArrange; //饮水/喂水量(餐次安排)    
	private String drinkWaterQuartersId; //饮水/喂水量(执行人/岗位)    
	private String waterTotal; //合计摄入水量/ml    
	private String energyTotal; //合计能量/千焦    
	private String dineAmbient; //进餐环境设置    
	private String dineTableware; //进餐餐具    
	private String dineAttention; //进餐注意事项    
	private String dietitianNm; //主管营养师    
	private String foodQuartersNm; //普食(执行人/岗位)    
	private String papmeatQuartersNm; //软食(执行人/岗位)    
	private String semiLiquidQuartersNm; //半流质(执行人/岗位)    
	private String liquidQuartersNm; //流质(执行人/岗位)    
	private String onsQuartersNm; //口服营养补充(执行人/岗位)    
	private String tenQuartersNm; //全天肠内营养(执行人/岗位)    
	private String penQuartersNm; //部分肠内(执行人/岗位)    
	private String ppnQuartersNm; //部分肠外(执行人/岗位)    
	private String tpnQuartersNm; //全天肠外营养(执行人/岗位)    
	private String drinkWaterQuartersNm; //饮水/喂水量(执行人/岗位) 
	
	private List<NutritionItemVO> itemList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDietitianId(){
		return dietitianId;
	}   
		
	public void setDietitianId(String  dietitianId){
		this.dietitianId = dietitianId;
	}   
	
	public java.util.Date getTreatStartTime(){
		return treatStartTime;
	}   
		
	public void setTreatStartTime(java.util.Date  treatStartTime){
		this.treatStartTime = treatStartTime;
	}   
	
	public java.util.Date getTreatEndTime(){
		return treatEndTime;
	}   
		
	public void setTreatEndTime(java.util.Date  treatEndTime){
		this.treatEndTime = treatEndTime;
	}   
	
	public String getAssessResult(){
		return assessResult;
	}   
		
	public void setAssessResult(String  assessResult){
		this.assessResult = assessResult;
	}   
	
	public String getClinicalDiagnosis(){
		return clinicalDiagnosis;
	}   
		
	public void setClinicalDiagnosis(String  clinicalDiagnosis){
		this.clinicalDiagnosis = clinicalDiagnosis;
	}   
	
	public String getFood(){
		return food;
	}   
		
	public void setFood(String  food){
		this.food = food;
	}   
	
	public String getFoodMeals(){
		return foodMeals;
	}   
		
	public void setFoodMeals(String  foodMeals){
		this.foodMeals = foodMeals;
	}   
	
	public String getFoodMealsNumber(){
		return foodMealsNumber;
	}   
		
	public void setFoodMealsNumber(String  foodMealsNumber){
		this.foodMealsNumber = foodMealsNumber;
	}   
	
	public String getFoodEnergy(){
		return foodEnergy;
	}   
		
	public void setFoodEnergy(String  foodEnergy){
		this.foodEnergy = foodEnergy;
	}   
	
	public String getFoodArrange(){
		return foodArrange;
	}   
		
	public void setFoodArrange(String  foodArrange){
		this.foodArrange = foodArrange;
	}   
	
	public String getFoodQuartersId(){
		return foodQuartersId;
	}   
		
	public void setFoodQuartersId(String  foodQuartersId){
		this.foodQuartersId = foodQuartersId;
	}   
	
	public String getPapmeat(){
		return papmeat;
	}   
		
	public void setPapmeat(String  papmeat){
		this.papmeat = papmeat;
	}   
	
	public String getPapmeatMeals(){
		return papmeatMeals;
	}   
		
	public void setPapmeatMeals(String  papmeatMeals){
		this.papmeatMeals = papmeatMeals;
	}   
	
	public String getPapmeatMealsNumber(){
		return papmeatMealsNumber;
	}   
		
	public void setPapmeatMealsNumber(String  papmeatMealsNumber){
		this.papmeatMealsNumber = papmeatMealsNumber;
	}   
	
	public String getPapmeatEnergy(){
		return papmeatEnergy;
	}   
		
	public void setPapmeatEnergy(String  papmeatEnergy){
		this.papmeatEnergy = papmeatEnergy;
	}   
	
	public String getPapmeatArrange(){
		return papmeatArrange;
	}   
		
	public void setPapmeatArrange(String  papmeatArrange){
		this.papmeatArrange = papmeatArrange;
	}   
	
	public String getPapmeatQuartersId(){
		return papmeatQuartersId;
	}   
		
	public void setPapmeatQuartersId(String  papmeatQuartersId){
		this.papmeatQuartersId = papmeatQuartersId;
	}   
	
	public String getSemiLiquid(){
		return semiLiquid;
	}   
		
	public void setSemiLiquid(String  semiLiquid){
		this.semiLiquid = semiLiquid;
	}   
	
	public String getSemiLiquidMeals(){
		return semiLiquidMeals;
	}   
		
	public void setSemiLiquidMeals(String  semiLiquidMeals){
		this.semiLiquidMeals = semiLiquidMeals;
	}   
	
	public String getSemiLiquidMealsNumber(){
		return semiLiquidMealsNumber;
	}   
		
	public void setSemiLiquidMealsNumber(String  semiLiquidMealsNumber){
		this.semiLiquidMealsNumber = semiLiquidMealsNumber;
	}   
	
	public String getSemiLiquidEnergy(){
		return semiLiquidEnergy;
	}   
		
	public void setSemiLiquidEnergy(String  semiLiquidEnergy){
		this.semiLiquidEnergy = semiLiquidEnergy;
	}   
	
	public String getSemiLiquidArrange(){
		return semiLiquidArrange;
	}   
		
	public void setSemiLiquidArrange(String  semiLiquidArrange){
		this.semiLiquidArrange = semiLiquidArrange;
	}   
	
	public String getSemiLiquidQuartersId(){
		return semiLiquidQuartersId;
	}   
		
	public void setSemiLiquidQuartersId(String  semiLiquidQuartersId){
		this.semiLiquidQuartersId = semiLiquidQuartersId;
	}   
	
	public String getLiquid(){
		return liquid;
	}   
		
	public void setLiquid(String  liquid){
		this.liquid = liquid;
	}   
	
	public String getLiquidMeals(){
		return liquidMeals;
	}   
		
	public void setLiquidMeals(String  liquidMeals){
		this.liquidMeals = liquidMeals;
	}   
	
	public String getLiquidMealsNumber(){
		return liquidMealsNumber;
	}   
		
	public void setLiquidMealsNumber(String  liquidMealsNumber){
		this.liquidMealsNumber = liquidMealsNumber;
	}   
	
	public String getLiquidEnergy(){
		return liquidEnergy;
	}   
		
	public void setLiquidEnergy(String  liquidEnergy){
		this.liquidEnergy = liquidEnergy;
	}   
	
	public String getLiquidArrange(){
		return liquidArrange;
	}   
		
	public void setLiquidArrange(String  liquidArrange){
		this.liquidArrange = liquidArrange;
	}   
	
	public String getLiquidQuartersId(){
		return liquidQuartersId;
	}   
		
	public void setLiquidQuartersId(String  liquidQuartersId){
		this.liquidQuartersId = liquidQuartersId;
	}   
	
	public String getOns(){
		return ons;
	}   
		
	public void setOns(String  ons){
		this.ons = ons;
	}   
	
	public String getOnsMeals(){
		return onsMeals;
	}   
		
	public void setOnsMeals(String  onsMeals){
		this.onsMeals = onsMeals;
	}   
	
	public String getOnsMealsNumber(){
		return onsMealsNumber;
	}   
		
	public void setOnsMealsNumber(String  onsMealsNumber){
		this.onsMealsNumber = onsMealsNumber;
	}   
	
	public String getOnsEnergy(){
		return onsEnergy;
	}   
		
	public void setOnsEnergy(String  onsEnergy){
		this.onsEnergy = onsEnergy;
	}   
	
	public String getOnsArrange(){
		return onsArrange;
	}   
		
	public void setOnsArrange(String  onsArrange){
		this.onsArrange = onsArrange;
	}   
	
	public String getOnsQuartersId(){
		return onsQuartersId;
	}   
		
	public void setOnsQuartersId(String  onsQuartersId){
		this.onsQuartersId = onsQuartersId;
	}   
	
	public String getTen(){
		return ten;
	}   
		
	public void setTen(String  ten){
		this.ten = ten;
	}   
	
	public String getTenMeals(){
		return tenMeals;
	}   
		
	public void setTenMeals(String  tenMeals){
		this.tenMeals = tenMeals;
	}   
	
	public String getTenMealsNumber(){
		return tenMealsNumber;
	}   
		
	public void setTenMealsNumber(String  tenMealsNumber){
		this.tenMealsNumber = tenMealsNumber;
	}   
	
	public String getTenEnergy(){
		return tenEnergy;
	}   
		
	public void setTenEnergy(String  tenEnergy){
		this.tenEnergy = tenEnergy;
	}   
	
	public String getTenArrange(){
		return tenArrange;
	}   
		
	public void setTenArrange(String  tenArrange){
		this.tenArrange = tenArrange;
	}   
	
	public String getTenQuartersId(){
		return tenQuartersId;
	}   
		
	public void setTenQuartersId(String  tenQuartersId){
		this.tenQuartersId = tenQuartersId;
	}   
	
	public String getPen(){
		return pen;
	}   
		
	public void setPen(String  pen){
		this.pen = pen;
	}   
	
	public String getPenMeals(){
		return penMeals;
	}   
		
	public void setPenMeals(String  penMeals){
		this.penMeals = penMeals;
	}   
	
	public String getPenMealsNumber(){
		return penMealsNumber;
	}   
		
	public void setPenMealsNumber(String  penMealsNumber){
		this.penMealsNumber = penMealsNumber;
	}   
	
	public String getPenEnergy(){
		return penEnergy;
	}   
		
	public void setPenEnergy(String  penEnergy){
		this.penEnergy = penEnergy;
	}   
	
	public String getPenArrange(){
		return penArrange;
	}   
		
	public void setPenArrange(String  penArrange){
		this.penArrange = penArrange;
	}   
	
	public String getPenQuartersId(){
		return penQuartersId;
	}   
		
	public void setPenQuartersId(String  penQuartersId){
		this.penQuartersId = penQuartersId;
	}   
	
	public String getPpn(){
		return ppn;
	}   
		
	public void setPpn(String  ppn){
		this.ppn = ppn;
	}   
	
	public String getPpnMeals(){
		return ppnMeals;
	}   
		
	public void setPpnMeals(String  ppnMeals){
		this.ppnMeals = ppnMeals;
	}   
	
	public String getPpnMealsNumber(){
		return ppnMealsNumber;
	}   
		
	public void setPpnMealsNumber(String  ppnMealsNumber){
		this.ppnMealsNumber = ppnMealsNumber;
	}   
	
	public String getPpnEnergy(){
		return ppnEnergy;
	}   
		
	public void setPpnEnergy(String  ppnEnergy){
		this.ppnEnergy = ppnEnergy;
	}   
	
	public String getPpnArrange(){
		return ppnArrange;
	}   
		
	public void setPpnArrange(String  ppnArrange){
		this.ppnArrange = ppnArrange;
	}   
	
	public String getPpnQuartersId(){
		return ppnQuartersId;
	}   
		
	public void setPpnQuartersId(String  ppnQuartersId){
		this.ppnQuartersId = ppnQuartersId;
	}   
	
	public String getTpn(){
		return tpn;
	}   
		
	public void setTpn(String  tpn){
		this.tpn = tpn;
	}   
	
	public String getTpnMeals(){
		return tpnMeals;
	}   
		
	public void setTpnMeals(String  tpnMeals){
		this.tpnMeals = tpnMeals;
	}   
	
	public String getTpnMealsNumber(){
		return tpnMealsNumber;
	}   
		
	public void setTpnMealsNumber(String  tpnMealsNumber){
		this.tpnMealsNumber = tpnMealsNumber;
	}   
	
	public String getTpnEnergy(){
		return tpnEnergy;
	}   
		
	public void setTpnEnergy(String  tpnEnergy){
		this.tpnEnergy = tpnEnergy;
	}   
	
	public String getTpnArrange(){
		return tpnArrange;
	}   
		
	public void setTpnArrange(String  tpnArrange){
		this.tpnArrange = tpnArrange;
	}   
	
	public String getTpnQuartersId(){
		return tpnQuartersId;
	}   
		
	public void setTpnQuartersId(String  tpnQuartersId){
		this.tpnQuartersId = tpnQuartersId;
	}   
	
	public String getDrinkWater(){
		return drinkWater;
	}   
		
	public void setDrinkWater(String  drinkWater){
		this.drinkWater = drinkWater;
	}   
	
	public String getDrinkWaterMeals(){
		return drinkWaterMeals;
	}   
		
	public void setDrinkWaterMeals(String  drinkWaterMeals){
		this.drinkWaterMeals = drinkWaterMeals;
	}   
	
	public String getDrinkWaterMealsNumber(){
		return drinkWaterMealsNumber;
	}   
		
	public void setDrinkWaterMealsNumber(String  drinkWaterMealsNumber){
		this.drinkWaterMealsNumber = drinkWaterMealsNumber;
	}   
	
	public String getDrinkWaterEnergy(){
		return drinkWaterEnergy;
	}   
		
	public void setDrinkWaterEnergy(String  drinkWaterEnergy){
		this.drinkWaterEnergy = drinkWaterEnergy;
	}   
	
	public String getDrinkWaterArrange(){
		return drinkWaterArrange;
	}   
		
	public void setDrinkWaterArrange(String  drinkWaterArrange){
		this.drinkWaterArrange = drinkWaterArrange;
	}   
	
	public String getDrinkWaterQuartersId(){
		return drinkWaterQuartersId;
	}   
		
	public void setDrinkWaterQuartersId(String  drinkWaterQuartersId){
		this.drinkWaterQuartersId = drinkWaterQuartersId;
	}   
	
	public String getWaterTotal(){
		return waterTotal;
	}   
		
	public void setWaterTotal(String  waterTotal){
		this.waterTotal = waterTotal;
	}   
	
	public String getEnergyTotal(){
		return energyTotal;
	}   
		
	public void setEnergyTotal(String  energyTotal){
		this.energyTotal = energyTotal;
	}   
	
	public String getDineAmbient(){
		return dineAmbient;
	}   
		
	public void setDineAmbient(String  dineAmbient){
		this.dineAmbient = dineAmbient;
	}   
	
	public String getDineTableware(){
		return dineTableware;
	}   
		
	public void setDineTableware(String  dineTableware){
		this.dineTableware = dineTableware;
	}   
	
	public String getDineAttention(){
		return dineAttention;
	}   
		
	public void setDineAttention(String  dineAttention){
		this.dineAttention = dineAttention;
	}   
	
	public String getDietitianNm(){
		return dietitianNm;
	}   
		
	public void setDietitianNm(String  dietitianNm){
		this.dietitianNm = dietitianNm;
	}   
	
	public String getFoodQuartersNm(){
		return foodQuartersNm;
	}   
		
	public void setFoodQuartersNm(String  foodQuartersNm){
		this.foodQuartersNm = foodQuartersNm;
	}   
	
	public String getPapmeatQuartersNm(){
		return papmeatQuartersNm;
	}   
		
	public void setPapmeatQuartersNm(String  papmeatQuartersNm){
		this.papmeatQuartersNm = papmeatQuartersNm;
	}   
	
	public String getSemiLiquidQuartersNm(){
		return semiLiquidQuartersNm;
	}   
		
	public void setSemiLiquidQuartersNm(String  semiLiquidQuartersNm){
		this.semiLiquidQuartersNm = semiLiquidQuartersNm;
	}   
	
	public String getLiquidQuartersNm(){
		return liquidQuartersNm;
	}   
		
	public void setLiquidQuartersNm(String  liquidQuartersNm){
		this.liquidQuartersNm = liquidQuartersNm;
	}   
	
	public String getOnsQuartersNm(){
		return onsQuartersNm;
	}   
		
	public void setOnsQuartersNm(String  onsQuartersNm){
		this.onsQuartersNm = onsQuartersNm;
	}   
	
	public String getTenQuartersNm(){
		return tenQuartersNm;
	}   
		
	public void setTenQuartersNm(String  tenQuartersNm){
		this.tenQuartersNm = tenQuartersNm;
	}   
	
	public String getPenQuartersNm(){
		return penQuartersNm;
	}   
		
	public void setPenQuartersNm(String  penQuartersNm){
		this.penQuartersNm = penQuartersNm;
	}   
	
	public String getPpnQuartersNm(){
		return ppnQuartersNm;
	}   
		
	public void setPpnQuartersNm(String  ppnQuartersNm){
		this.ppnQuartersNm = ppnQuartersNm;
	}   
	
	public String getTpnQuartersNm(){
		return tpnQuartersNm;
	}   
		
	public void setTpnQuartersNm(String  tpnQuartersNm){
		this.tpnQuartersNm = tpnQuartersNm;
	}   
	
	public String getDrinkWaterQuartersNm(){
		return drinkWaterQuartersNm;
	}   
		
	public void setDrinkWaterQuartersNm(String  drinkWaterQuartersNm){
		this.drinkWaterQuartersNm = drinkWaterQuartersNm;
	}

	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}

	public String getElderName() {
		return elderName;
	}

	public void setElderName(String elderName) {
		this.elderName = elderName.trim();
	}

	public String getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(String quartersId) {
		this.quartersId = quartersId;
	}

	public String getQuartersName() {
		return quartersName;
	}

	public void setQuartersName(String quartersName) {
		this.quartersName = quartersName.trim();
	}

	public String getInterveneId() {
		return interveneId;
	}

	public void setInterveneId(String interveneId) {
		this.interveneId = interveneId;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber.trim();
	}

	public List<NutritionItemVO> getItemList() {
		List<NutritionItemVO> itemsList = new ArrayList<NutritionItemVO>();
		//普食
		if(StringUtils.isNotBlank(getFoodMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("基础饮食（普食）");
			item.setMeals(getFoodMeals());
			item.setMealsNumber(getFoodMealsNumber());
			item.setEnergy(getFoodEnergy());
			item.setArrange(getFoodArrange());
			item.setQuartersNm(getFoodQuartersNm());
			itemsList.add(item);
		}
		//软食  
		if(StringUtils.isNotBlank(getPapmeatMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("基础饮食（软食  ）");
			item.setMeals(getPapmeatMeals());
			item.setMealsNumber(getPapmeatMealsNumber());
			item.setEnergy(getPapmeatEnergy());
			item.setArrange(getPapmeatArrange());
			item.setQuartersNm(getPapmeatQuartersNm());
			itemsList.add(item);
		}
		//半流质
		if(StringUtils.isNotBlank(getSemiLiquidMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("基础饮食（半流质）");
			item.setMeals(getSemiLiquidMeals());
			item.setMealsNumber(getSemiLiquidMealsNumber());
			item.setEnergy(getSemiLiquidEnergy());
			item.setArrange(getSemiLiquidArrange());
			item.setQuartersNm(getSemiLiquidQuartersNm());
			itemsList.add(item);
		}
		//流质
		if(StringUtils.isNotBlank(getLiquidMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("基础饮食（流质）");
			item.setMeals(getLiquidMeals());
			item.setMealsNumber(getLiquidMealsNumber());
			item.setEnergy(getLiquidEnergy());
			item.setArrange(getLiquidArrange());
			item.setQuartersNm(getLiquidQuartersNm());
			itemsList.add(item);
		}
		//口服营养补充 
		if(StringUtils.isNotBlank(getOnsMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("口服营养补充 ");
			item.setMeals(getOnsMeals());
			item.setMealsNumber(getOnsMealsNumber());
			item.setEnergy(getOnsEnergy());
			item.setArrange(getOnsArrange());
			item.setQuartersNm(getOnsQuartersNm());
			itemsList.add(item);
		}
		//全天肠内营养 
		if(StringUtils.isNotBlank(getTenMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("全天肠内营养 ");
			item.setMeals(getTenMeals());
			item.setMealsNumber(getTenMealsNumber());
			item.setEnergy(getTenEnergy());
			item.setArrange(getTenArrange());
			item.setQuartersNm(getTenQuartersNm());
			itemsList.add(item);
		}
		//部分肠内 
		if(StringUtils.isNotBlank(getPenMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("部分肠内 ");
			item.setMeals(getPenMeals());
			item.setMealsNumber(getPenMealsNumber());
			item.setEnergy(getPenEnergy());
			item.setArrange(getPenArrange());
			item.setQuartersNm(getPenQuartersNm());
			itemsList.add(item);
		}
		//部分肠外 
		if(StringUtils.isNotBlank(getPpnMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("部分肠外 ");
			item.setMeals(getPpnMeals());
			item.setMealsNumber(getPpnMealsNumber());
			item.setEnergy(getPpnEnergy());
			item.setArrange(getPpnArrange());
			item.setQuartersNm(getPpnQuartersNm());
			itemsList.add(item);
		}
		//全天肠外营养
		if(StringUtils.isNotBlank(getTpnMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("全天肠外营养");
			item.setMeals(getTpnMeals());
			item.setMealsNumber(getTpnMealsNumber());
			item.setEnergy(getTpnEnergy());
			item.setArrange(getTpnArrange());
			item.setQuartersNm(getTpnQuartersNm());
			itemsList.add(item);
		}
		//饮水/喂水量
		if(StringUtils.isNotBlank(getDrinkWaterMeals())){
			NutritionItemVO item = new NutritionItemVO();
			item.setItemNm("饮水/喂水量");
			item.setMeals(getDrinkWaterMeals());
			item.setMealsNumber(getDrinkWaterMealsNumber());
			item.setEnergy(getDrinkWaterEnergy());
			item.setArrange(getDrinkWaterArrange());
			item.setQuartersNm(getDrinkWaterQuartersNm());
			itemsList.add(item);
		}
		return itemsList;
	}

	public void setItemList(List<NutritionItemVO> itemList) {
		this.itemList = itemList;
	}   
	
}


