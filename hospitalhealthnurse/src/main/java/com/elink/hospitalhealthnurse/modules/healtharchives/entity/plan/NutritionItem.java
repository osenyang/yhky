package com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;

/**
 * 营养项目 Title:
 * com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan.NutritionItem
 * Description:
 * 
 * @createTime: 2017年4月26日 - 上午10:57:44
 * @Company: Elink
 * @author: 杨鉴浩
 * @version: 1.0
 */
@Entity
@Table(name="plan_nutrition_item")
public class NutritionItem implements Serializable {

	private static final long serialVersionUID = 6215959704727169371L;
	/**
	 * 
	 */
	private String id;
	/** 项目名称 */
	private String itemName;
	/** 给予服药方式 */
	private String takeWay;
	/** 餐次 */
	private String mealNum;
	/** 摄入量 */
	private String intake;
	/** 能量 */
	private String energy;
	/** 蛋白质 */
	private String protein;
	/** 配餐时间 */
	private String caterTime;
	/** 进餐时间 */
	private String mealtime;


	/** 配餐人 */
	private ServiceUser caterUser;
	private String caterUserId;//存储的是工号jobNumber
	/** 接收人 */
	private ServiceUser receiveUser;
	private String receiveUserId;
	/** 执行人 */
	private ServiceUser executeUser;
	private String executeUserId;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTakeWay() {
		return takeWay;
	}

	public void setTakeWay(String takeWay) {
		this.takeWay = takeWay;
	}

	public String getMealNum() {
		return mealNum;
	}

	public void setMealNum(String mealNum) {
		this.mealNum = mealNum;
	}

	public String getIntake() {
		return intake;
	}

	public void setIntake(String intake) {
		this.intake = intake;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getCaterTime() {
		return caterTime;
	}

	public void setCaterTime(String caterTime) {
		this.caterTime = caterTime;
	}

	public String getMealtime() {
		return mealtime;
	}

	public void setMealtime(String mealtime) {
		this.mealtime = mealtime;
	}

//	@ManyToOne
//	@JoinColumn(name="cater_user_id")
//	@Cascade(value= {CascadeType.SAVE_UPDATE,CascadeType.PERSIST,CascadeType.MERGE})
	@Transient
	public ServiceUser getCaterUser() {
		return caterUser;
	}

	public void setCaterUser(ServiceUser caterUser) {
		this.caterUser = caterUser;
	}

//	@ManyToOne
//	@JoinColumn(name="receive_user_id")
//	@Cascade(value= {CascadeType.SAVE_UPDATE,CascadeType.PERSIST,CascadeType.MERGE})
	@Transient
	public ServiceUser getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(ServiceUser receiveUser) {
		this.receiveUser = receiveUser;
	}

//	@ManyToOne
//	@JoinColumn(name="execute_user_id")
//	@Cascade(value= {CascadeType.SAVE_UPDATE,CascadeType.PERSIST,CascadeType.MERGE})
	@Transient
	public ServiceUser getExecuteUser() {
		return executeUser;
	}

	public void setExecuteUser(ServiceUser executeUser) {
		this.executeUser = executeUser;
	}

	public String getCaterUserId() {
		return caterUserId;
	}

	public void setCaterUserId(String caterUserId) {
		this.caterUserId = caterUserId;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getExecuteUserId() {
		return executeUserId;
	}

	public void setExecuteUserId(String executeUserId) {
		this.executeUserId = executeUserId;
	}

}
