package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;

/**
 * 评估Entity
 * @author 杜康
 * @version 2017-04-12
 */
public class HealthAssessVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String archivesId; //档案ID    
	private String typeNm; //评估分类    
	private String questNm; //评估量表    
	private String gradeNm; //评估结果    
	private String score; //评估分数    
	private String discribe; //评估标准    
	private java.util.Date createDate; //创建日期    
	private String delFlag; //删除标记    

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
	
}


