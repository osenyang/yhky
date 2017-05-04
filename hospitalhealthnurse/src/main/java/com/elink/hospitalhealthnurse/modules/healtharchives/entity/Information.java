package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 消息中心Entity
 * @author 杜康
 * @version 2016-10-17
 */
@Entity
@Table(name = "hn_information")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Information extends BaseEntity<Information> {
	
	private static final long serialVersionUID = 1L;
	
	public static final String INFOR_STATE_NORMAL = "0";//未读
	public static final String INFOR_STATE_READ = "1";//已读

	public Information() {
		super();
	}

	public Information(String id){
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
	
	private String title;//标题
   
	private String content; //消息内容    
   
	private String archivesId; //档案ID    
   
	private String sendJobNumber; //发送人    
   
	private String receiveJobNumber; //接收人    
   
	private String state; //状态（1、已读，0、未读）    
   
	private java.util.Date createDate; //发送时间    
   
	private String delFlag; //删除标记    
   
	private String receiveUsers; //接收人    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent(){
		return content;
	}   
		
	public void setContent(String  content){
		this.content = content;
	}   
	
	public String getArchivesId(){
		return archivesId;
	}   
		
	public void setArchivesId(String  archivesId){
		this.archivesId = archivesId;
	}   
	
	public String getSendJobNumber() {
		return sendJobNumber;
	}

	public void setSendJobNumber(String sendJobNumber) {
		this.sendJobNumber = sendJobNumber;
	}

	public String getReceiveJobNumber() {
		return receiveJobNumber;
	}

	public void setReceiveJobNumber(String receiveJobNumber) {
		this.receiveJobNumber = receiveJobNumber;
	}

	public String getState(){
		return state;
	}   
		
	public void setState(String  state){
		this.state = state;
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
	
	public String getReceiveUsers(){
		return receiveUsers;
	}   
		
	public void setReceiveUsers(String  receiveUsers){
		this.receiveUsers = receiveUsers;
	}   
	
}


