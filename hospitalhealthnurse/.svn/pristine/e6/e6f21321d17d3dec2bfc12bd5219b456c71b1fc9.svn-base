package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 社工计划Entity
 * @author 杜康
 * @version 2016-10-26
 */
@Entity
@Table(name = "hn_health_social")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Social extends BaseEntity<Social> {
	
	private static final long serialVersionUID = 1L;

	public Social() {
		super();
	}

	public Social(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
//		this.createDate = new Date();
//		this.updateDate = new Date();
//		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	@PreUpdate
	public void preUpdate(){
//		this.updateDate = new Date();
	}
	
	private String id;	//编号
   
	private String familyFather; //父亲    
   
	private String familyMother; //母亲    
   
	private String familySpouse; //配偶    
   
	private String familySon; //儿子    
   
	private String familyDaughter; //女儿    
   
	private String familyBrother; //哥哥    
   
	private String familySister; //姐姐    
   
	private String familyYoungerBrother; //弟弟    
   
	private String familyYoungerSister; //妹妹    
   
	private String wageStatus; //工资状况    
   
	private String deposit; //存款    
   
	private String depositMoney; //存款(金额)    
   
	private String costBear; //现在费用承担情况    
   
	private String nuserLevel; //初步护理级别    
   
	private String specialAsk; //特殊要求    
	
	private List<Hobby> hobbyList;//兴趣爱好集合
	
	private Date socialStartTime;//社工计划开始执行时间
	
	private Date socialEndTime;//社工计划结束执行时间

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getFamilyFather(){
		return familyFather;
	}   
		
	public void setFamilyFather(String  familyFather){
		this.familyFather = familyFather;
	}   
	
	public String getFamilyMother(){
		return familyMother;
	}   
		
	public void setFamilyMother(String  familyMother){
		this.familyMother = familyMother;
	}   
	
	public String getFamilySpouse(){
		return familySpouse;
	}   
		
	public void setFamilySpouse(String  familySpouse){
		this.familySpouse = familySpouse;
	}   
	
	public String getFamilySon(){
		return familySon;
	}   
		
	public void setFamilySon(String  familySon){
		this.familySon = familySon;
	}   
	
	public String getFamilyDaughter(){
		return familyDaughter;
	}   
		
	public void setFamilyDaughter(String  familyDaughter){
		this.familyDaughter = familyDaughter;
	}   
	
	public String getFamilyBrother(){
		return familyBrother;
	}   
		
	public void setFamilyBrother(String  familyBrother){
		this.familyBrother = familyBrother;
	}   
	
	public String getFamilySister(){
		return familySister;
	}   
		
	public void setFamilySister(String  familySister){
		this.familySister = familySister;
	}   
	
	public String getFamilyYoungerBrother(){
		return familyYoungerBrother;
	}   
		
	public void setFamilyYoungerBrother(String  familyYoungerBrother){
		this.familyYoungerBrother = familyYoungerBrother;
	}   
	
	public String getFamilyYoungerSister(){
		return familyYoungerSister;
	}   
		
	public void setFamilyYoungerSister(String  familyYoungerSister){
		this.familyYoungerSister = familyYoungerSister;
	}   
	
	public String getWageStatus(){
		return wageStatus;
	}   
		
	public void setWageStatus(String  wageStatus){
		this.wageStatus = wageStatus;
	}   
	
	public String getDeposit(){
		return deposit;
	}   
		
	public void setDeposit(String  deposit){
		this.deposit = deposit;
	}   
	
	public String getDepositMoney(){
		return depositMoney;
	}   
		
	public void setDepositMoney(String  depositMoney){
		this.depositMoney = depositMoney;
	}   
	
	public String getCostBear(){
		return costBear;
	}   
		
	public void setCostBear(String  costBear){
		this.costBear = costBear;
	}   
	
	public String getNuserLevel(){
		return nuserLevel;
	}   
		
	public void setNuserLevel(String  nuserLevel){
		this.nuserLevel = nuserLevel;
	}   
	
	public String getSpecialAsk(){
		return specialAsk;
	}   
		
	public void setSpecialAsk(String  specialAsk){
		this.specialAsk = specialAsk;
	}
	@Transient
	public List<Hobby> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<Hobby> hobbyList) {
		this.hobbyList = hobbyList;
	}

	public Date getSocialStartTime() {
		return socialStartTime;
	}

	public void setSocialStartTime(Date socialStartTime) {
		this.socialStartTime = socialStartTime;
	}

	public Date getSocialEndTime() {
		return socialEndTime;
	}

	public void setSocialEndTime(Date socialEndTime) {
		this.socialEndTime = socialEndTime;
	}   
	
}


