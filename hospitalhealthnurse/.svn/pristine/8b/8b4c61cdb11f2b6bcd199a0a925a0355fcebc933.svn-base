package com.elink.hospitalhealthnurse.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.DefaultResourceLoader;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.FileUtils;
import com.elink.hospitalhealthnurse.common.utils.FreeMarkers;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 代码生成器(实体类)
 * 
 * @author 刘灵星
 * @version 2014-1-15
 */
public class GenerateEntity {

	//private static Logger logger = LoggerFactory.getLogger(GenerateEntity.class);

	private static String tableNm = "his_nurse_serv_price";
	
	private static Map<String,String> filterMap = new HashMap<String ,String>();  //过滤的字段
    private static List<Map<String,String>> listFeild  =  Lists.newArrayList();


	// 数据库连接
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jeesite?useUnicode=true&characterEncoding=utf-8";
	private static final String NAME = "root";
	private static final String PASS = "123456";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	public static void main(String[] args)throws Exception {

		// ========== ↓↓↓↓↓↓ 执行前请修改参数，谨慎执行。↓↓↓↓↓↓ ====================

		// 主要提供基本功能模块代码生成。
		// 目录生成结构：{packageName}/{moduleName}/{dao,entity,service,web}/{subModuleName}/{className}

		// packageName
		// 包名，这里如果更改包名，请在applicationContext.xml和srping-mvc.xml中配置base-package、packagesToScan属性，来指定多个（共4处需要修改）。
		
		
		String packageName = "com.elink.hospitalhealthnurse.modules";
		String moduleName = "his"; // 模块名，例：sys
		String subModuleName = ""; // 子模块名（可选）
		String className = "nurseServPrice"; // 类名，例：user		
		String classAuthor = "刘灵星"; // 类作者，例：刘灵星
		String functionName = "护工服务内容价格设置"; // 功能名，例：用户
		filterMap.put("id", "id");
//		filterMap.put("create_by", "create_by");
//		filterMap.put("create_date", "create_date");
//		filterMap.put("update_by", "update_by");
//		filterMap.put("update_date", "update_date");
//		filterMap.put("del_flag", "del_flag");
		filterMap.put("remarks", "remarks");

		// 是否启用生成工具
		// Boolean isEnable = false;
		Boolean isEnable = true;

		// ========== ↑↑↑↑↑↑ 执行前请修改参数，谨慎执行。↑↑↑↑↑↑ ====================

		if (!isEnable) {
			//logger.error("请启用代码生成工具，设置参数：isEnable = true");
			return;
		}

		if (StringUtils.isBlank(moduleName) || StringUtils.isBlank(moduleName)
				|| StringUtils.isBlank(className)
				|| StringUtils.isBlank(functionName)) {
			//logger.error("参数设置错误：包名、模块名、类名、功能名不能为空。");
			return;
		}

		// 获取文件分隔符
		String separator = File.separator;

		// 获取工程路径
		File projectPath = new DefaultResourceLoader().getResource("").getFile();
		while (!new File(projectPath.getPath() + separator + "src" + separator	+ "main").exists()) {
			projectPath = projectPath.getParentFile();
		}
		//logger.info("Project Path: {}", projectPath);

		// 模板文件路径
		String tplPath = StringUtils.replace(projectPath + "/src/main/java/com/elink/generate/template", "/", separator);
		//logger.info("Template Path: {}", tplPath);

		// Java文件路径
		String javaPath = StringUtils.replaceEach(projectPath	+ "/src/main/java/" + StringUtils.lowerCase(packageName),
				new String[] { "/", "." },	new String[] { separator, separator });
		///logger.info("Java Path: {}", javaPath);

		// 代码模板配置
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setDirectoryForTemplateLoading(new File(tplPath));

		// 定义模板变量
		Map<String, Object> model = Maps.newHashMap();
		model.put("packageName", StringUtils.lowerCase(packageName));
		model.put("moduleName", StringUtils.lowerCase(moduleName));
		model.put("subModuleName", StringUtils.isNotBlank(subModuleName) ? "."	+ StringUtils.lowerCase(subModuleName) : "");
		model.put("className", StringUtils.uncapitalize(className));
		model.put("ClassName", StringUtils.capitalize(className));
		model.put("classAuthor",	StringUtils.isNotBlank(classAuthor) ? classAuthor	: "Generate Tools");
		model.put("classVersion", DateUtils.getDate());
		model.put("functionName", functionName);
		model.put("tableName", tableNm);
		
		initEntityInfoMysql(filterMap);
		
		model.put("listFeild", listFeild);

		// 生成 Entity
		Template template = cfg.getTemplate("entity_new.ftl");
		String content = FreeMarkers.renderTemplate(template, model);
		String filePath = javaPath + separator + model.get("moduleName") + separator + "entity" + separator	+ 
				          StringUtils.lowerCase(subModuleName) + separator + model.get("ClassName") + ".java";
		writeFile(content, filePath);
		//logger.info("Entity: {}", filePath);
		System.out.println("Generate Success.");
		//logger.info("Generate Success.");
	}



	/**
	 * 将内容写入文件
	 * 
	 * @param content
	 * @param filePath
	 */
	public static void writeFile(String content, String filePath) {
		try {
			if (FileUtils.createFile(filePath)) {
				FileOutputStream fos = new FileOutputStream(filePath);
				Writer writer = new OutputStreamWriter(fos, "UTF-8");
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				bufferedWriter.write(content);
				bufferedWriter.close();
				writer.close();
			} else {
				//logger.info("生成失败，文件已存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 初始数据;
	 */
	public static void initEntityInfoMysql(Map<String,String> filterMap) {
		// 创建连接
		Connection con = null;
		ResultSetMetaData rsmd =  null;
		PreparedStatement pStemt = null;
		
		// 查要生成实体类的表
		String sql = "select * from " + tableNm;
		try {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			con = DriverManager.getConnection(URL, NAME, PASS);
			pStemt = con.prepareStatement(sql);
			rsmd = pStemt.getMetaData();
			int size = rsmd.getColumnCount(); // 统计列
	
			for (int i = 0; i < size; i++) {
				String  colnames = rsmd.getColumnName(i + 1);
				String  colTypes = rsmd.getColumnTypeName(i + 1);
				String  colContent = rsmd.getColumnLabel(i + 1);
				int     colSize = rsmd.getColumnDisplaySize(i + 1);
				
				String feildNm =  StringUtils.spellField(colnames);
				String methodFeildNm = StringUtils.upperFirst(feildNm);
				
				String feildType = StringUtils.sqlType2JavaType(colTypes);
				if(!filterMap.containsKey(StringUtils.lowerCase(colnames))){
					Map<String,String> map = new HashMap<String ,String>(); 
					map.put("feildNm", feildNm);					
					map.put("colContent", colContent);
					map.put("methodFeildNm", methodFeildNm);
					map.put("feildType", feildType);
					map.put("colSize", String.valueOf(colSize));				
					listFeild.add(map);
				}			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 try {
				 con.close();
				 pStemt.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		}
	}
}
