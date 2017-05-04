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
 * 健康建议Entity
 * @author 杜康
 * @version 2017-04-12
 */
@Entity
@Table(name = "hn_assess_report")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AssessReport extends BaseEntity<AssessReport> {
	
	private static final long serialVersionUID = 1L;

	public AssessReport() {
		super();
	}

	public AssessReport(String id){
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
   
	private String doctorNm; //医生ID    
   
	private String content; //健康建议    
   
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
	
	public String getDoctorNm() {
		return doctorNm;
	}

	public void setDoctorNm(String doctorNm) {
		this.doctorNm = doctorNm;
	}

	public String getContent(){
		return content;
	}   
		
	public void setContent(String  content){
		this.content = content;
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
		return "{'id':'"+this.id+"','archivesId':'"+this.archivesId+"','doctorNm':'"+this.doctorNm+"',"
				+ "'content':'"+this.content+"','createDate':'"+format.format(this.createDate)+"'}";
	}
}


