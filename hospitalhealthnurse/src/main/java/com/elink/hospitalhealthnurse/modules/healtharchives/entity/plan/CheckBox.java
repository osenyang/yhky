package com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 单纯的多选框的内容，父实体
 * Title: com.elink.entity.tcm.CheckBox
 * Description:
 * @createTime: 2017年3月17日 - 上午10:59:54
 * @Company: Elink
 * @author: OsenYang
 * @version: 1.0
 */
@MappedSuperclass
public abstract class CheckBox implements Serializable{

	private static final long serialVersionUID = 5663379436624107367L;
	
	/** 中医药-保健指导 */
	public static final String TYPE_HEALTH_CARE = "healthCare";
	/** 高血压记录表里面的： 症状 */
	public static final String TYPE_HYPTSN_SYMPTOM = "hyptsn_symptom";
	/** 糖尿病记录表里面的： 症状 */
	public static final String TYPE_TCM_SYMPTOM = "tcm_symptom";
	
	
	protected String id;
	/** 内容、名称 */
	protected String name;
	/** 所属类别 */
	protected String type;
	
	
	protected String selected;
	//***************************************************************
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Transient
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	
}
