package ${packageName}.${moduleName}.entity${subModuleName};

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.elink.hospitalhealthnurse.common.persistence.IdEntity;

/**
 * ${functionName}Entity
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Entity
@Table(name = "${tableName}")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ${ClassName} extends IdEntity<${ClassName}> {
	
	private static final long serialVersionUID = 1L;

	public ${ClassName}() {
		super();
	}

	public ${ClassName}(String id){
		this();
		this.id = id;
	}
	 

	
}


