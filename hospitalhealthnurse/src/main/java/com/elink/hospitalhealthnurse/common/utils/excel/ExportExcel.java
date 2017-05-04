/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.common.utils.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.Encodes;
import com.elink.hospitalhealthnurse.common.utils.Reflections;
import com.elink.hospitalhealthnurse.common.utils.excel.annotation.ExcelField;
import com.elink.hospitalhealthnurse.modules.plan.utils.PlanProjectTypeEnum;
import com.elink.hospitalhealthnurse.modules.plan.vo.PlanExecuteRecordVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ServiceUserRosterVO;
import com.elink.hospitalhealthnurse.modules.sys.utils.DictUtils;
import com.google.common.collect.Lists;

/**
 * 导出Excel文件（导出“XLSX”格式，支持大数据量导出   @see org.apache.poi.ss.SpreadsheetVersion）
 * @author 刘灵星
 * @version 2013-04-21
 */
public class ExportExcel {
	
	private static Logger log = LoggerFactory.getLogger(ExportExcel.class);
			
	/**
	 * 工作薄对象
	 */
	private SXSSFWorkbook wb;
	
	/**
	 * 工作表对象
	 */
	private Sheet sheet;
	
	/**
	 * 样式列表
	 */
	private Map<String, CellStyle> styles;
	
	/**
	 * 当前行号
	 */
	private int rownum;
	
	/**
	 * 注解列表（Object[]{ ExcelField, Field/Method }）
	 */
	List<Object[]> annotationList = Lists.newArrayList();
	
	/**
	 * 构造函数
	 * @param title 表格标题，传“空值”，表示无标题
	 * @param cls 实体对象，通过annotation.ExportField获取标题
	 */
	public ExportExcel(String title, Class<?> cls){
		this(title, cls, 1);
	}
	
	public ExportExcel(){}
	
	/**
	 * 构造函数
	 * @param title 表格标题，传“空值”，表示无标题
	 * @param cls 实体对象，通过annotation.ExportField获取标题
	 * @param type 导出类型（1:导出数据；2：导出模板）
	 * @param groups 导入分组
	 */
	public ExportExcel(String title, Class<?> cls, int type, int... groups){
		// Get annotation field 
		Field[] fs = cls.getDeclaredFields();
		for (Field f : fs){
			ExcelField ef = f.getAnnotation(ExcelField.class);
			if (ef != null && (ef.type()==0 || ef.type()==type)){
				if (groups!=null && groups.length>0){
					boolean inGroup = false;
					for (int g : groups){
						if (inGroup){
							break;
						}
						for (int efg : ef.groups()){
							if (g == efg){
								inGroup = true;
								annotationList.add(new Object[]{ef, f});
								break;
							}
						}
					}
				}else{
					annotationList.add(new Object[]{ef, f});
				}
			}
		}
		// Get annotation method
		Method[] ms = cls.getDeclaredMethods();
		for (Method m : ms){
			ExcelField ef = m.getAnnotation(ExcelField.class);
			if (ef != null && (ef.type()==0 || ef.type()==type)){
				if (groups!=null && groups.length>0){
					boolean inGroup = false;
					for (int g : groups){
						if (inGroup){
							break;
						}
						for (int efg : ef.groups()){
							if (g == efg){
								inGroup = true;
								annotationList.add(new Object[]{ef, m});
								break;
							}
						}
					}
				}else{
					annotationList.add(new Object[]{ef, m});
				}
			}
		}
		// Field sorting
		Collections.sort(annotationList, new Comparator<Object[]>() {
			public int compare(Object[] o1, Object[] o2) {
				return new Integer(((ExcelField)o1[0]).sort()).compareTo(
						new Integer(((ExcelField)o2[0]).sort()));
			};
		});
		// Initialize
		List<String> headerList = Lists.newArrayList();
		for (Object[] os : annotationList){
			String t = ((ExcelField)os[0]).title();
			// 如果是导出，则去掉注释
			if (type==1){
				String[] ss = StringUtils.split(t, "**", 2);
				if (ss.length==2){
					t = ss[0];
				}
			}
			headerList.add(t);
		}
		initialize(title, headerList);
	}
	
	/**
	 * 构造函数
	 * @param title 表格标题，传“空值”，表示无标题
	 * @param headers 表头数组
	 */
	public ExportExcel(String title, String[] headers) {
		initialize(title, Lists.newArrayList(headers));
	}
	
	/**
	 * 构造函数
	 * @param title 表格标题，传“空值”，表示无标题
	 * @param headerList 表头列表
	 */
	public ExportExcel(String title, List<String> headerList) {
		initialize(title, headerList);
	}
	
	/**
	 * 初始化函数
	 * @param title 表格标题，传“空值”，表示无标题
	 * @param headerList 表头列表
	 */
	private void initialize(String title, List<String> headerList) {
		this.wb = new SXSSFWorkbook(500);
		this.sheet = wb.createSheet("Export");
		this.styles = createStyles(wb);
		// Create title
		if (StringUtils.isNotBlank(title)){
			Row titleRow = sheet.createRow(rownum++);
			titleRow.setHeightInPoints(30);
			Cell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styles.get("title"));
			titleCell.setCellValue(title);
			sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(),
					titleRow.getRowNum(), titleRow.getRowNum(), headerList.size()-1));
		}
		// Create header
		if (headerList == null){
			throw new RuntimeException("headerList not null!");
		}
		Row headerRow = sheet.createRow(rownum++);
		headerRow.setHeightInPoints(30);
		for (int i = 0; i < headerList.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellStyle(styles.get("header"));
			String[] ss = StringUtils.split(headerList.get(i), "**", 2);
			if (ss.length==2){
				cell.setCellValue(ss[0]);
				Comment comment = this.sheet.createDrawingPatriarch().createCellComment(
						new XSSFClientAnchor(0, 0, 0, 0, (short) 3, 3, (short) 5, 6));
				comment.setString(new XSSFRichTextString(ss[1]));
				cell.setCellComment(comment);
			}else{
				cell.setCellValue(headerList.get(i));
			}
			sheet.autoSizeColumn(i);
		}
		if(headerList.size() == 17){
			sheet.setColumnWidth(0, 2000);  
			sheet.setColumnWidth(1, 2000);  
			sheet.setColumnWidth(2, 2000);  
			sheet.setColumnWidth(3, 3000);  
			sheet.setColumnWidth(4, 3000);  
			sheet.setColumnWidth(5, 3000);  
			sheet.setColumnWidth(6, 3000);  
			sheet.setColumnWidth(7, 2000);  
			sheet.setColumnWidth(8, 2200);  
			sheet.setColumnWidth(9, 2000);  
			sheet.setColumnWidth(10, 2200);  
			sheet.setColumnWidth(12, 2000);  
			sheet.setColumnWidth(13, 2000);  
			sheet.setColumnWidth(14, 2000);  
			sheet.setColumnWidth(15, 2000);  
			sheet.setColumnWidth(16, 4000);  
		}else if(headerList.size() == 16){
			sheet.setColumnWidth(0, 2000);  
			sheet.setColumnWidth(1, 2000);  
			sheet.setColumnWidth(2, 2000);  
			sheet.setColumnWidth(3, 3000);  
			sheet.setColumnWidth(4, 3000);  
			sheet.setColumnWidth(5, 3000);  
			sheet.setColumnWidth(6, 3000);  
			sheet.setColumnWidth(7, 2000);  
			sheet.setColumnWidth(8, 2200);  
			sheet.setColumnWidth(9, 2000);  
			sheet.setColumnWidth(10, 2200);  
			sheet.setColumnWidth(12, 2000);  
			sheet.setColumnWidth(13, 2000);  
			sheet.setColumnWidth(14, 2000);  
			sheet.setColumnWidth(15, 4000);  
		}
		
		/*for (int i = 0; i < headerList.size(); i++) {  
			int colWidth = sheet.getColumnWidth(i)*2;
			sheet.setColumnWidth(i, colWidth < 2000 ? 2000 : colWidth);  
		}*/
		log.debug("Initialize success.");
	}
	
	/**
	 * 创建表格样式
	 * @param wb 工作薄对象
	 * @return 样式列表
	 */
	private Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		Font titleFont = wb.createFont();
		titleFont.setFontName("Arial");
		titleFont.setFontHeightInPoints((short) 13);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(titleFont);
		styles.put("title", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setBorderRight(CellStyle.BORDER_THIN);
	//	style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
//		style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
	//	style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
	//	style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		Font dataFont = wb.createFont();
		dataFont.setFontName("宋体");
		dataFont.setFontHeightInPoints((short) 11);
		style.setFont(dataFont);
		styles.put("data", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_LEFT);
		styles.put("data1", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		styles.put("data2", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		styles.put("data3", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font font4 = wb.createFont();
		font4.setFontName("宋体");
		font4.setFontHeightInPoints((short) 11);
		font4.setColor(HSSFColor.BLUE.index);
		style.setFont(font4);
		styles.put("data4", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font font5 = wb.createFont();
		font5.setFontName("宋体");
		font5.setFontHeightInPoints((short) 11);
		font5.setColor(HSSFColor.DARK_RED.index);
		style.setFont(font5);
		styles.put("data5", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		Font font6 = wb.createFont();
		font6.setFontName("宋体");
		font6.setFontHeightInPoints((short) 11);
		font6.setColor(HSSFColor.DARK_GREEN.index);
		style.setFont(font6);
		styles.put("data6", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		Font font7 = wb.createFont();
		font7.setFontName("宋体");
		font7.setFontHeightInPoints((short) 11);
		font7.setColor(HSSFColor.RED.index);
		style.setFont(font7);
		styles.put("data7", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
//		style.setWrapText(true);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderRight(CellStyle.BORDER_THIN);
	//	style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
//		style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
	//	style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
	//	style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		Font headerFont = wb.createFont();
		headerFont.setFontName("宋体");
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
//		headerFont.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(headerFont);
		styles.put("header", style);
		
		return styles;
	}

	/**
	 * 添加一行
	 * @return 行对象
	 */
	public Row addRow(){
		return sheet.createRow(rownum++);
	}
	

	/**
	 * 添加一个单元格
	 * @param row 添加的行
	 * @param column 添加列号
	 * @param val 添加值
	 * @return 单元格对象
	 */
	public Cell addCell(Row row, int column, Object val){
		return this.addCell(row, column, val, 0, Class.class);
	}
	
	/**
	 * 添加一个单元格
	 * @param row 添加的行
	 * @param column 添加列号
	 * @param val 添加值
	 * @param align 对齐方式（1：靠左；2：居中；3：靠右）
	 * @return 单元格对象
	 */
	public Cell addCell(Row row, int column, Object val, int align, Class<?> fieldType){
		Cell cell = row.createCell(column);
		CellStyle style = styles.get("data"+(align>=1&&align<=7?align:""));
		try {
			if (val == null){
				cell.setCellValue("");
			} else if (val instanceof String) {
				cell.setCellValue((String) val);
			} else if (val instanceof Integer) {
				cell.setCellValue((Integer) val);
			} else if (val instanceof Long) {
				cell.setCellValue((Long) val);
			} else if (val instanceof Double) {
				cell.setCellValue((Double) val);
			} else if (val instanceof Float) {
				cell.setCellValue((Float) val);
			} else if (val instanceof Date) {
				DataFormat format = wb.createDataFormat();
	            style.setDataFormat(format.getFormat("yyyy-MM-dd"));
				cell.setCellValue((Date) val);
			} else {
				if (fieldType != Class.class){
					cell.setCellValue((String)fieldType.getMethod("setValue", Object.class).invoke(null, val));
				}else{
					cell.setCellValue((String)Class.forName(this.getClass().getName().replaceAll(this.getClass().getSimpleName(), 
						"fieldtype."+val.getClass().getSimpleName()+"Type")).getMethod("setValue", Object.class).invoke(null, val));
				}
			}
		} catch (Exception ex) {
			log.info("Set cell value ["+row.getRowNum()+","+column+"] error: " + ex.toString());
			cell.setCellValue(val.toString());
		}
		cell.setCellStyle(style);
		return cell;
	}

	/**
	 * 添加数据（通过annotation.ExportField添加数据）
	 * @return list 数据列表
	 */
	public <E> ExportExcel setDataList(List<E> list){
		for (E e : list){
			int colunm = 0;
			Row row = this.addRow();
			StringBuilder sb = new StringBuilder();
			for (Object[] os : annotationList){
				ExcelField ef = (ExcelField)os[0];
				Object val = null;
				// Get entity value
				try{
					if (StringUtils.isNotBlank(ef.value())){
						val = Reflections.invokeGetter(e, ef.value());
					}else{
						if (os[1] instanceof Field){
							val = Reflections.invokeGetter(e, ((Field)os[1]).getName());
						}else if (os[1] instanceof Method){
							val = Reflections.invokeMethod(e, ((Method)os[1]).getName(), new Class[] {}, new Object[] {});
						}
					}
					// If is dict, get dict label
					if (StringUtils.isNotBlank(ef.dictType())){
						val = DictUtils.getDictLabel(val==null?"":val.toString(), ef.dictType(), "");
					}
				}catch(Exception ex) {
					// Failure to ignore
					log.info(ex.toString());
					val = "";
				}
				this.addCell(row, colunm++, val, ef.align(), ef.fieldType());
				sb.append(val + ", ");
			}
			log.debug("Write success: ["+row.getRowNum()+"] "+sb.toString());
		}
		return this;
	}
	
	/**
	 * 输出数据流
	 * @param os 输出数据流
	 */
	public ExportExcel write(OutputStream os) throws IOException{
		wb.write(os);
		return this;
	}
	
	/**
	 * 输出到客户端
	 * @param fileName 输出文件名
	 */
	public ExportExcel write(HttpServletResponse response, String fileName) throws IOException{
		response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+new String( fileName.getBytes( "utf-8" ), "ISO8859-1" ));
//        response.setHeader("Content-Disposition", "attachment; filename="+Encodes.urlEncode(fileName));
		write(response.getOutputStream());
		return this;
	}
	
	/**
	 * 输出到文件
	 * @param fileName 输出文件名
	 */
	public ExportExcel writeFile(String name) throws FileNotFoundException, IOException{
		FileOutputStream os = new FileOutputStream(name);
		this.write(os);
		return this;
	}
	
	/**
	 * 清理临时文件
	 */
	public ExportExcel dispose(){
		wb.dispose();
		return this;
	}
	public List<String> getServiceUserRosterHeader(){
		List<String> headerList = Lists.newArrayList();
		headerList.add("序号");
		headerList.add("机构名称");
		headerList.add("排班序号");
		headerList.add("科室");
		headerList.add("岗位");
		headerList.add("值班人");
		headerList.add("上班时间");
		headerList.add("下班时间");
		return headerList;
	}
	/**
	 * 服务人员排班
	 * @author yfy
	 */
	public ExportExcel getServiceUserRosterExcel(List<ServiceUserRosterVO> list, String title){
		List<String> headerList = getServiceUserRosterHeader();
		ExportExcel ee = new ExportExcel(title, headerList);
		for (int i = 0; i < list.size(); i++) {
			ServiceUserRosterVO vo = list.get(i);
			Row row = ee.addRow();
			ee.addCell(row, 0, new Integer(i+1), 2, null);
			ee.addCell(row, 1, vo.getOfficeName(), 2, null);
			ee.addCell(row, 2, vo.getSerialNumber().split("_")[1], 2, null);
			ee.addCell(row, 3, vo.getDepartmentName(), 2, null);
			ee.addCell(row, 4, vo.getQuartersName(), 2, null);
			ee.addCell(row, 5, vo.getServiceUserName(), 2, null);
			ee.addCell(row, 6, DateUtils.formatDateTime(vo.getBeginDate()), 2, null);
			ee.addCell(row, 7, DateUtils.formatDateTime(vo.getEndDate()), 2, null);
		}
		return ee;
	}
	/***
	 * 服务人服务明细导出header
	 * @param type 0，正执行，1，已完成
	 * @return
	 */
	public List<String> getServiceUserPlanExeRecordHeader(String type){
		List<String> headerList = Lists.newArrayList();
		headerList.add("床号/房号");
		headerList.add("老人姓名");
		headerList.add("服务项目");
		if(type.equals("0")){
			headerList.add("执行时间");
		}else{
			headerList.add("预计执行时间");
			headerList.add("开始执行时间");
			headerList.add("结束执行时间");
			headerList.add("执行情况");
		}
		return headerList;
	}
	/***
	 * 服务人员服务明细导出
	 * @param list
	 * @param title
	 * @param type 
	 * @return
	 */
	public ExportExcel getServiceUserPlanExeRecord(List<PlanExecuteRecordVO> list, String title,String type){
		List<String> headerList = getServiceUserPlanExeRecordHeader(type);
		ExportExcel ee = new ExportExcel(title, headerList);
		for (int i = 0; i < list.size(); i++) {
			PlanExecuteRecordVO vo = list.get(i);
			Row row = ee.addRow();
			ee.addCell(row, 0, vo.getBedNumber(), 2, null);
			ee.addCell(row, 1, vo.getElderName(), 2, null);
			if(type.equals("0")){
				ee.addCell(row, 2, vo.getProjectName(), 2, null);
				ee.addCell(row, 3, DateUtils.formatDateTime(vo.getExpectedStartTime()), 2, null);
			}else{
				ee.addCell(row, 2, vo.getProjectName()+"("+vo.getProjectSubName()+")", 2, null);
				ee.addCell(row, 3, DateUtils.formatDateTime(vo.getExpectedStartTime()), 2, null);
				ee.addCell(row, 4, DateUtils.formatDateTime(vo.getStartTime()), 2, null);
				ee.addCell(row, 5, DateUtils.formatDateTime(vo.getStopTime()), 2, null);
				if(vo.getState().equals("1")){
					ee.addCell(row, 6,"准时", 2, null);
				}else if(vo.getState().equals("2")){
					ee.addCell(row, 6,"延时", 2, null);
				}
			}
		}
		return ee;
	}
	/***
	 * 老人计划导出header
	 * @param type 0，今日，1，历史
	 * @return
	 */
	public List<String> getElderPlanExeRecordHeader(String type){
		List<String> headerList = Lists.newArrayList();
		
		if(type.equals("0")){
			headerList.add("计划类型");
			headerList.add("服务项目");
			headerList.add("执行人（岗位）");
			headerList.add("执行时间");
			headerList.add("状态");
		}else{
			headerList.add("床号/房号");
			headerList.add("老人姓名");
			headerList.add("服务项目");
			headerList.add("预计执行时间");
			headerList.add("开始执行时间");
			headerList.add("结束执行时间");
			headerList.add("执行情况");
		}
		return headerList;
	}
	/**
	 * 老人计划导出
	 * 
	 */
	public ExportExcel getElderPlanExeRecord(List<PlanExecuteRecordVO> list, String title,String type){
		List<String> headerList = getElderPlanExeRecordHeader(type);
		ExportExcel ee = new ExportExcel(title, headerList);
		for (int i = 0; i < list.size(); i++) {
			PlanExecuteRecordVO vo = list.get(i);
			Row row = ee.addRow();
			if(type.equals("0")){
				ee.addCell(row, 0,DictUtils.getDictLabel(vo.getPlanType(), "SERVICE_TYPE", ""), 2, null);
				ee.addCell(row, 1,vo.getProjectName(), 2, null);
				if(vo.getServiceUserName()!=null){
					ee.addCell(row, 2,vo.getServiceUserName(), 2, null);
				}else{
					ee.addCell(row, 2,vo.getQuartersName(), 2, null);
				}
				ee.addCell(row, 3,DateUtils.formatDateTime(vo.getExpectedStartTime()), 2, null);
				if(vo.getState().equals("0")){
					ee.addCell(row, 4,"待服务", 2, null);
				}else{
					if(vo.getStopTime()==null){
						ee.addCell(row, 4,"正在执行", 2, null);
					}else{
						ee.addCell(row, 4,"已服务", 2, null);
					}
				}
			}else{
				ee.addCell(row, 0, vo.getBedNumber(), 2, null);
				ee.addCell(row, 1, vo.getElderName(), 2, null);
				ee.addCell(row, 2, vo.getProjectName()+"("+vo.getProjectSubName()+")", 2, null);
				ee.addCell(row, 3, DateUtils.formatDateTime(vo.getExpectedStartTime()), 2, null);
				ee.addCell(row, 4, DateUtils.formatDateTime(vo.getStartTime()), 2, null);
				ee.addCell(row, 5, DateUtils.formatDateTime(vo.getStopTime()), 2, null);
				if(vo.getState().equals("1")){
					ee.addCell(row, 6,"准时执行", 2, null);
				}else if(vo.getState().equals("2")){
					ee.addCell(row, 6,"延迟执行", 2, null);
				}
			}
		}
		return ee;
	}
}
