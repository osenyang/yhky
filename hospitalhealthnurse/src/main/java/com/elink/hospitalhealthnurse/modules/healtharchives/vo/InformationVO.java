package com.elink.hospitalhealthnurse.modules.healtharchives.vo;

import java.io.Serializable;

import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Information;

/**
 * 消息中心Entity
 * @author 杜康
 * @version 2016-10-17
 */
public class InformationVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
	private String title;//标题
	private String content; //消息内容    
	private String archivesId; //档案ID    
	private String state; //状态（1、已读，0、未读）    
	private java.util.Date createDate; //发送时间    
	private String delFlag; //删除标记    
	private String receiveUsers; //接收人    
	private String fullNm;//会诊老人
	private String sendNm;//发布人
	private String stateName;//状态
	private String departmentNm;//所属科室
	private String sendJobNumber; //发送人工号    
	private String receiveJobNumber; //接收人工号

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

	public String getFullNm() {
		return fullNm;
	}

	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
	}

	public String getSendNm() {
		return sendNm;
	}

	public void setSendNm(String sendNm) {
		this.sendNm = sendNm;
	}

	public String getStateName() {
		if(this.state.equals(Information.INFOR_STATE_NORMAL)){
			return "未读";
		}else{
			return "已读";
		}
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDepartmentNm() {
		return departmentNm;
	}

	public void setDepartmentNm(String departmentNm) {
		this.departmentNm = departmentNm;
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
}


