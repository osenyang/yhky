package com.elink.hospitalhealthnurse.common.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;

/**
 * 输出到HttpServletResponse工具类
 * 
 * @author 欧建东
 * @email oyjd@163.com
 * 
 */
public class OutUtil {
	private static Logger log = Logger.getLogger(OutUtil.class);
	private static String charsetName = "utf-8";

	/**
	 * 输出下载文件
	 * 
	 * @param m
	 * @param response
	 */
	public static void outDownFile(byte[] b, String downName, HttpServletResponse response) {
		try {
			downName = new String(downName.getBytes("GBK"), "iso8859-1");
			response.setHeader("content-disposition", "attachment;filename=" + downName);
			response.setContentType("application/octet-stream; charset=" + charsetName);
			response.setContentLength(b.length);
			out(new ByteArrayInputStream(b), response.getOutputStream());			
		} catch (Exception err) {
			log.error(err.getMessage(), err);
		}
	}

	/**
	 * 输出下载文件
	 * 
	 * @param m
	 * @param response
	 */
	public static void outDownFile(String path, String downName, HttpServletResponse response) {
		try {
			downName = new String(downName.getBytes("GBK"), "iso8859-1");
			response.setHeader("content-disposition", "attachment;filename=" + downName);
			response.setContentType("application/octet-stream; charset=" + charsetName);
			File file = new File(path);
			response.setContentLength((int) file.length());
			out(new FileInputStream(file), response.getOutputStream());
		} catch (Exception err) {
			log.error(err.getMessage(), err);
		}
	}
	
	/**
	 * 输出下载文件
	 * 
	 * @param m
	 * @param response
	 */
	public static void outOpenFile(String path, HttpServletResponse response) {
		try {			
			File file = new File(path);
			response.setContentLength((int) file.length());
			out(new FileInputStream(file), response.getOutputStream());
		} catch (Exception err) {
			log.error(err.getMessage(), err);
		}
	}

	/**
	 * 输出字符信息
	 * 
	 * @param m
	 * @param response
	 */
	public static void outString(String s, HttpServletResponse response) {
		try {
			byte[] b = s.getBytes(charsetName);
			response.setContentType("text/html; charset=" + charsetName);
			response.setContentLength(b.length);
			out(new ByteArrayInputStream(b), response.getOutputStream());
		} catch (Exception err) {
			log.error(err.getMessage(), err);
		}
	}

	/**
	 * 输出Json
	 * 
	 * @param m
	 * @param response
	 */
	public static void outJson(Object m, HttpServletResponse response) {
		try {
			Object json;
			json = JsonMapper.getInstance().toJson(m);
			byte[] b = json.toString().getBytes(charsetName);
			response.setContentType("text/html; charset=" + charsetName);
			response.setContentLength(b.length);
			out(new ByteArrayInputStream(b), response.getOutputStream());
		} catch (Exception err) {
			log.error(err.getMessage(), err);
		}
	}

	/**
	 * 输出XML
	 * 
	 * @param document
	 * @param response
	 * @param charsetName
	 */
	public static void outXml(Document document, HttpServletResponse response) {
		try {
			document.setXMLEncoding(charsetName);
			byte[] b = document.asXML().getBytes(charsetName);
			response.setContentType("text/xml; charset=" + charsetName);
			response.setContentLength(b.length);
			out(new ByteArrayInputStream(b), response.getOutputStream());
		} catch (Exception err) {
			log.error(err.getMessage(), err);
		}
	}

	/**
	 * 基础字节数组输出
	 * 
	 * @param b
	 * @param response
	 */
	public static void out(InputStream is, OutputStream os) {
		try {
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = is.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
			os.flush();
			os.close();
			is.close();
		} catch (Exception err) {
			log.error(err.getMessage(), err);
		}
	}
	

}
