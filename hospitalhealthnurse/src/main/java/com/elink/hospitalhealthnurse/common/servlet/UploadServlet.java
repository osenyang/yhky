package com.elink.hospitalhealthnurse.common.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.utils.FileUtils;
import com.elink.hospitalhealthnurse.common.utils.IdGen;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimpleEx;
import com.google.common.collect.Maps;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
/**
 * 文件上传类
 * @author 刘灵星
 * @version 2015-5-19
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	private String fileSizeLimit;
	
    public UploadServlet() {  
        super();  
    }  
    

    public void destroy() {    
        super.destroy();    
    }  
   
    @SuppressWarnings("unchecked")  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException{  
		fileSizeLimit = Global.getConfig("upload.file.Size.Limit");
		String uploadPath = request.getParameter("uploadPath");
		
		String oldImgUrlThumb = request.getParameter("oldImgUrlThumb");//之前上传的缩略图
		String oldImgUrlOri = request.getParameter("oldImgUrlOri");//之前上传的原图
		String oldFile = request.getParameter("oldFile");//之前上传的文件
		String uploadDir = Global.getConfig("upload.foloder") + File.separatorChar ;
		String oldImgUrlThumbUrl = null;
		String oldImgUrlOribUrl = null;
		String oldFileUrl = null;
		if(StringUtils.isNotBlank(oldImgUrlThumb)){
			oldImgUrlThumbUrl =  Global.getConfig("upload.foloder") + oldImgUrlThumb;
		}		
		if(StringUtils.isNotBlank(oldImgUrlOri)){
			oldImgUrlOribUrl =  Global.getConfig("upload.foloder") + oldImgUrlOri;
		}	
		if(StringUtils.isNotBlank(oldFile)){
			oldFileUrl =  Global.getConfig("upload.foloder") + oldFile;
		}	
		//每天上传的文件根据日期存放在不同的文件夹
		String autoCreatedDateDirByParttern = "yyyy" + File.separatorChar + "MM" + File.separatorChar;
		String autoCreatedDateDir = uploadPath + File.separatorChar + DateFormatUtils.format(new java.util.Date(), autoCreatedDateDirByParttern);
		File savePath = new File(uploadDir + autoCreatedDateDir);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}
		String saveDirectory =  uploadDir + autoCreatedDateDir;		
		if (StringUtils.isBlank(this.fileSizeLimit.toString())) {
			this.fileSizeLimit = "2";// 默认2M
		}
		int maxPostSize = Integer.parseInt(this.fileSizeLimit) * 1024 * 1024;
	    // 存放文件描述  
	    @SuppressWarnings("unused")  
	    String[] fileDiscription = { null, null };  
	    // 文件名  
	    String fileName = null; 
	    String fileThumbName = null;
	    String fileType = null;
	    // 重命名策略  
	    RandomFileRenamePolicy rfrp = new RandomFileRenamePolicy();  
	    // 上传文件  
	    MultipartRequest mulit;
	    PrintWriter writer  = null;
		try {
			mulit = new MultipartRequest(request,saveDirectory,maxPostSize, "UTF-8", rfrp);
	        Enumeration<String> filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        while (filesname.hasMoreElements()) {  
	            String name = (String) filesname.nextElement();//标识  	     
	            fileName = mulit.getFilesystemName(name); //取得文件名  	  	   
	        }  	     
	        if(StringUtils.isNotBlank(fileName)){
	        	String[] fileNameArr = fileName.split("\\.");
	        	String extendNm = fileNameArr[1];
	        	extendNm = extendNm.toLowerCase();
	        	fileThumbName = fileNameArr[0] + "_small." + extendNm;
	        }
	        fileType = FilenameUtils.getExtension(fileName);
	        //生成 缩略图
	        if("jpg".equalsIgnoreCase(fileType) || "jpeg".equalsIgnoreCase(fileType )|| "png".equalsIgnoreCase(fileType ) ||"bmp".equalsIgnoreCase(fileType)
	        		||"gif".equalsIgnoreCase(fileType)){
	        	FileUtils.saveImageAsJpg(saveDirectory + File.separator + fileName , saveDirectory + File.separator +fileThumbName , 120, 120);
	        }
	        
	        //将原来上传的图片删除
			if(StringUtils.isNotBlank(oldImgUrlThumbUrl)){
				//oldImgUrlThumbUrl = oldImgUrlThumbUrl.replaceAll("/","\\\\");
				File imgFile  = new File(oldImgUrlThumbUrl);
				if(imgFile.exists()) 
					imgFile.delete();
			}		
			if(StringUtils.isNotBlank(oldImgUrlOribUrl)){		
				//oldImgUrlOribUrl = oldImgUrlOribUrl.replaceAll("/","\\\\");
				File imgFile  = new File(oldImgUrlOribUrl);
				if(imgFile.exists()) 
					imgFile.delete();
			}	
	        
			if(StringUtils.isNotBlank(oldFileUrl)){
				//oldFileUrl = oldFileUrl.replaceAll("/","\\\\");
				File deleteFile  = new File(oldFileUrl);
				if(deleteFile.exists()) 
					deleteFile.delete();
			}	
			
			ReturnCodeSimpleEx returnCodeErr = new ReturnCodeSimpleEx();
			Map<String, Object> headErr = Maps.newHashMap();
			Map<String, Object> data = Maps.newHashMap();
			headErr.put("ret", 0);
			headErr.put("msg", "成功");	
			String thumbImg = File.separatorChar + autoCreatedDateDir +  fileThumbName;
			String oriImg   = File.separatorChar + autoCreatedDateDir +  fileName;
			oriImg = oriImg.replaceAll("\\\\", "/");
			thumbImg = thumbImg.replaceAll("\\\\", "/");			
			data.put("thumbImg", thumbImg);	
			data.put("oriImg", oriImg);	
			data.put("fileType", fileType);	
			returnCodeErr.setHead(headErr);
			returnCodeErr.setData(data);		
			response.setContentType("text/html; charset=UTF-8"); 
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();			
			writer.print( JsonMapper.getInstance().toJson(returnCodeErr));	
			writer.close();
		} catch (IOException e) {
			ReturnCodeSimpleEx returnCodeErr = new ReturnCodeSimpleEx();
			Map<String, Object> headErr = Maps.newHashMap();
			Map<String, Object> data = Maps.newHashMap();
			headErr.put("ret", 1);
			headErr.put("msg", "附件过大");	
			data.put("fileType", fileType);	
			returnCodeErr.setHead(headErr);
			returnCodeErr.setData(data);	
			response.setContentType("text/html; charset=UTF-8"); 
			response.setCharacterEncoding("utf-8");
			try {
				writer = response.getWriter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			writer.print( JsonMapper.getInstance().toJson(returnCodeErr));	
			writer.close();
//			throw new RuntimeException(e);
		}finally{
			if(writer != null)
				writer.close();
		}
	}  
   
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {   
        this.doGet(request, response);  
    }   
      
    @Override
    public void init() throws ServletException {  
    }
    
	class RandomFileRenamePolicy implements FileRenamePolicy {
		public File rename(File file1) {			
			String fileSaveName = StringUtils.join(new String[] { IdGen.uuid(), ".",
					FilenameUtils.getExtension(file1.getName()) });
			File result = new File(file1.getParentFile(), fileSaveName);
			return result;
		}
	}
  
}
