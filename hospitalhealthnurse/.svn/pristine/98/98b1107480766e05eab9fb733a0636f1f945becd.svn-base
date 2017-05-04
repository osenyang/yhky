package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 兴趣爱好Entity
 * @author 杜康
 * @version 2016-10-26
 */
@Entity
@Table(name = "hn_health_hobby")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Hobby extends BaseEntity<Hobby> {
	
	private static final long serialVersionUID = 1L;

	public Hobby() {
		super();
	}

	public Hobby(String id){
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
   
	private String hobby; //兴趣爱好    
   
	private String hobbyAsk; //兴趣爱好要求    
   
	private Date hobbyStartTime; //兴趣爱好(开始时间)    
   
	private Date hobbyEndTime; //兴趣爱好(结束时间)    
   
	private String hobbyOther; //兴趣爱好(其他)    
   
	private String hobbyQuartersId; //兴趣爱好(执行人/岗位)  
	
	private String hobbyQuartersNm; //兴趣爱好(执行人/岗位)

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getHobby(){
		return hobby;
	}   
		
	public void setHobby(String  hobby){
		this.hobby = hobby;
	}   
	
	public String getHobbyAsk(){
		return hobbyAsk;
	}   
		
	public void setHobbyAsk(String  hobbyAsk){
		this.hobbyAsk = hobbyAsk;
	}   
	
	public Date getHobbyStartTime(){
		return hobbyStartTime;
	}   
		
	public void setHobbyStartTime(Date  hobbyStartTime){
		this.hobbyStartTime = hobbyStartTime;
	}   
	
	public Date getHobbyEndTime(){
		return hobbyEndTime;
	}   
		
	public void setHobbyEndTime(Date  hobbyEndTime){
		this.hobbyEndTime = hobbyEndTime;
	}   
	
	public String getHobbyOther(){
		return hobbyOther;
	}   
		
	public void setHobbyOther(String  hobbyOther){
		this.hobbyOther = hobbyOther;
	}   
	
	public String getHobbyQuartersId(){
		return hobbyQuartersId;
	}   
		
	public void setHobbyQuartersId(String  hobbyQuartersId){
		this.hobbyQuartersId = hobbyQuartersId;
	}   
	
	public String getHobbyQuartersNm() {
		return hobbyQuartersNm;
	}

	public void setHobbyQuartersNm(String hobbyQuartersNm) {
		this.hobbyQuartersNm = hobbyQuartersNm;
	}
	@Transient
	public String toString(){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return "{'id':'"+this.id+"','hobby':'"+this.hobby+"','hobbyAsk':'"+this.hobbyAsk+"',"
				+ "'hobbyStartTime':'"+format.format(this.hobbyStartTime)+"','hobbyEndTime':'"+format.format(this.hobbyEndTime)+"',"
				+ "'hobbyOther':'"+this.hobbyOther+"','hobbyQuartersId':'"+this.hobbyQuartersId+"',"
				+ "'hobbyQuartersNm':'"+this.hobbyQuartersNm+"'}";
	}
}


