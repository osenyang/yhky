package com.elink.hospitalhealthnurse.modules.serviceorg.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 科室管理Entity
 * @author 颜福艳
 * @version 2016-10-09
 */
@Entity
@Table(name = "sys_department")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department extends BaseEntity<Department> {
	
	private static final long serialVersionUID = 1L;
	 
	public static final String root_id = "1";

	public Department() {
		super();
	}

	public Department(String id){
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

	private String name; //科室名称    
	
	private String officeId;
   
	private String createBy; //创建者    
   
	private java.util.Date createDate; //创建时间    
   
	private String remarks; //备注    
	
	private String officeNm;//医院名称
	
	private String delFlag; //删除标记（0：正常1：删除2：审核）    

	private Department parent;
	
	private List<Department> children;
	
	@Id	
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
		this.name = name.trim();
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getCreateBy(){
		return createBy;
	}   
		
	public void setCreateBy(String  createBy){
		this.createBy = createBy;
	}   
	
	public java.util.Date getCreateDate(){
		return createDate;
	}   
		
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}   
	
	public String getRemarks(){
		return remarks;
	}   
		
	public void setRemarks(String  remarks){
		if(StringUtils.isNotBlank(remarks)){
			this.remarks = remarks.trim();
		}else{
			this.remarks = remarks;
		}
	}
	
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Transient
	public String getOfficeNm() {
		return officeNm;
	}

	public void setOfficeNm(String officeNm) {
		this.officeNm = officeNm.trim();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@NotNull
	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}
	
	@OneToMany(mappedBy = "parent", fetch=FetchType.LAZY)
	@OrderBy(value="sort") @Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}
	
	@Transient
	public static void sortList(List<Department> list, List<Department> sourcelist, String parentId){
		for (int i=0; i<sourcelist.size(); i++){
			Department e = sourcelist.get(i);
			if (e.getParent() != null && e.getParent().getId() != null
					&& e.getParent().getId().equals(parentId)){
				list.add(e);
				// 判断是否还有子节点, 有则继续获取子节点
				for (int j=0; j<sourcelist.size(); j++){
					Department childe = sourcelist.get(j);
					if (childe.getParent()!=null && childe.getParent().getId()!=null
							&& childe.getParent().getId().equals(e.getId())){
						sortList(list, sourcelist, e.getId());
						break;
					}
				}
			}
		}
	}
}


