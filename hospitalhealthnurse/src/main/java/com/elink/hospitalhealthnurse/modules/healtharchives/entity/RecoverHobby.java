package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 社工计划--兴趣爱好关联表Entity
 * @author 杜康
 * @version 2016-10-26
 */
@Entity
@Table(name = "hn_recover_hobby")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RecoverHobby extends BaseEntity<RecoverHobby> {
	
	private static final long serialVersionUID = 1L;

	public RecoverHobby() {
		super();
	}

	public RecoverHobby(String id){
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
   
	private String hobbyId; //兴趣爱好主键ID    
   
	private String recoverId; //社工计划主键ID    

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getHobbyId(){
		return hobbyId;
	}   
		
	public void setHobbyId(String  hobbyId){
		this.hobbyId = hobbyId;
	}   
	
	public String getRecoverId(){
		return recoverId;
	}   
		
	public void setRecoverId(String  recoverId){
		this.recoverId = recoverId;
	}   
	
}


