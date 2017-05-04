package ${packageName}.${moduleName}.service${subModuleName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.service.BaseService;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import ${packageName}.${moduleName}.entity${subModuleName}.${ClassName};
import ${packageName}.${moduleName}.vo${subModuleName}.${ClassName}VO;
import ${packageName}.${moduleName}.dao${subModuleName}.${ClassName}Dao;

/**
 * ${functionName}Service
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Component
@Transactional(readOnly = true)
public class ${ClassName}Service extends BaseService {

	@Autowired
	private ${ClassName}Dao ${className}Dao;
	
	public ${ClassName} get(String id) {
		return ${className}Dao.get(id);
	}
	
	public Page<${ClassName}> find(Page<${ClassName}> page, ${ClassName} ${className}) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.* FROM ${tableName} t");
		sb.append(" WHERE t.del_flag = '"+${ClassName}.DEL_FLAG_NORMAL+"'");
		
		if(StringUtils.isNotBlank(${className}.getName())){
			sb.append(" AND t.name like '%"+${className}.getName()+"%'");
		}
		
		sb.append(" ORDER BY t.create_date desc");
		return ${className}Dao.findBySqlExt(page, sb.toString(), ${ClassName}.class);
	}
	
	@Transactional(readOnly = false)
	public void save(${ClassName} ${className}) {
		${className}Dao.save(${className});
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		${className}Dao.deleteById(id);
	}
	
}
