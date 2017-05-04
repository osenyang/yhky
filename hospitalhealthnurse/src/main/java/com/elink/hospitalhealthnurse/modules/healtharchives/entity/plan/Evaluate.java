package com.elink.hospitalhealthnurse.modules.healtharchives.entity.plan;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 *  Title:康复评定
 * 
 * @createTime: 2017年4月26日 - 下午2:40:17
 * @Company: Elink
 * @author: 杨鉴浩
 * @version: 1.0
 */
@Entity
@Table(name="plan_evaluate")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Evaluate implements Serializable {

	private static final long serialVersionUID = -104972384902767250L;
	/**
	 * 
	 */
	/** ST(言语治疗) */
	public static final String TYPE_ST = "st";
	/** PT(物理治疗) */
	public static final String TYPE_PT = "pt";
	/** 0T(作业治疗) */
	public static final String TYPE_OT = "ot";
	/** CPT(心肺康复) */
	public static final String TYPE_CPT = "cpt";
	/** 传统康复治疗 */
	public static final String TYPE_TRADITION = "tradition";

	private String id;
	private String name;
	private String content;
	/** 分类 */
	private String type;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
