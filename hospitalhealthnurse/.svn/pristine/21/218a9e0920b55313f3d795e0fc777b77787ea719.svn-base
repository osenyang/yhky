package ${packageName}.${moduleName}.vo${subModuleName};

import java.io.Serializable;

/**
 * ${functionName}Entity
 * @author ${classAuthor}
 * @version ${classVersion}
 */
public class ${ClassName}VO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;	//编号
    <#list listFeild as map>       
	private ${map["feildType"]} ${map["feildNm"]}; //${map["colContent"]}    
    </#list>      

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


