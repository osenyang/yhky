package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 评估Entity
 * @author 杜康
 * @version 2017-04-12
 */
@Entity
@Table(name = "hn_health_assess")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HealthAssess extends BaseEntity<HealthAssess> {
	
	private static final long serialVersionUID = 1L;

	public HealthAssess() {
		super();
	}

	public HealthAssess(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	private String id;	//编号
   
	private String archivesId; //档案ID    
   
	private String typeNm; //评估分类    
   
	private String questNm; //评估量表    
   
	private String gradeNm; //评估结果    
   
	private String score; //评估分数    
   
	private String discribe; //评估标准    
   
	private java.util.Date createDate; //创建日期    
   
	private String delFlag; //删除标记    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getArchivesId(){
		return archivesId;
	}   
		
	public void setArchivesId(String  archivesId){
		this.archivesId = archivesId;
	}   
	
	public String getTypeNm(){
		return typeNm;
	}   
		
	public void setTypeNm(String  typeNm){
		this.typeNm = typeNm;
	}   
	
	public String getQuestNm(){
		return questNm;
	}   
		
	public void setQuestNm(String  questNm){
		this.questNm = questNm;
	}   
	
	public String getGradeNm(){
		return gradeNm;
	}   
		
	public void setGradeNm(String  gradeNm){
		this.gradeNm = gradeNm;
	}   
	
	public String getScore(){
		return score;
	}   
		
	public void setScore(String  score){
		this.score = score;
	}   
	
	public String getDiscribe(){
		return discribe;
	}   
		
	public void setDiscribe(String  discribe){
		this.discribe = discribe;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date  createDate){
		this.createDate = createDate;
	}   
	
	public String getDelFlag(){
		return delFlag;
	}   
		
	public void setDelFlag(String  delFlag){
		this.delFlag = delFlag;
	}   
	@Transient
	public String toString(){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "{'id':'"+this.id+"','archivesId':'"+this.archivesId+"','typeNm':'"+this.typeNm+"',"
				+ "'questNm':'"+this.questNm+"','gradeNm':'"+this.gradeNm+"',"
				+ "'score':'"+this.score+"','createDate':'"+format.format(this.createDate)+"',"
				+ "'discribe':'"+this.discribe+"'}";
	}
}


