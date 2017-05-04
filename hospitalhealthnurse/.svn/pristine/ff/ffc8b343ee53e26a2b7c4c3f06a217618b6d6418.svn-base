package com.elink.hospitalhealthnurse.modules.plan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Length;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 服务人员排班Entity
 * @author 王宴萍
 * @version 2016-10-10
 */
@Entity
@Table(name = "sys_service_user_roster")
@DynamicInsert @DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ServiceUserRoster extends BaseEntity<ServiceUserRoster> {

	private static final long serialVersionUID = 1L;
	private String id;		// 编号
	private String serviceUserId;	// 服务人员id
	private String serialNumber;// 序号
	private Date beginDate;// 上班时间
	private Date endDate;// 下班时间
	private User createBy;	// 创建者
	private Date createDate;// 创建日期
	private String delFlag; // 删除标记（0：正常；1：删除；2：审核）

	public ServiceUserRoster() {
		super();
	}
	
	public ServiceUserRoster(String id) {
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.delFlag = DEL_FLAG_NORMAL;
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.createBy = user;
		}
		this.createDate = new Date();
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Length(min=1, max=1)
	@Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceUserId() {
		return serviceUserId;
	}

	public void setServiceUserId(String serviceUserId) {
		this.serviceUserId = serviceUserId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber.trim();
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


}