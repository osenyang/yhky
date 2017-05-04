package ${packageName}.${moduleName}.entity${subModuleName};

import java.util.Date;

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
 * ${functionName}Entity
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Entity
@Table(name = "${tableName}")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ${ClassName} extends BaseEntity<${ClassName}> {
	
	private static final long serialVersionUID = 1L;

	public ${ClassName}() {
		super();
	}

	public ${ClassName}(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.updateDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	@PreUpdate
	public void preUpdate(){
		this.updateDate = new Date();
	}
	
	private String id;	//编号
    <#list listFeild as map>       
   
	private ${map["feildType"]} ${map["feildNm"]}; //${map["colContent"]}    
    </#list>      

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    <#list listFeild as map>        
	public ${map["feildType"]} get${map["methodFeildNm"]}(){
		return ${map["feildNm"]};
	}   
		
	public void set${map["methodFeildNm"]}(${map["feildType"]}  ${map["feildNm"]}){
		this.${map["feildNm"]} = ${map["feildNm"]};
	}   
	
    </#list>  	
}


