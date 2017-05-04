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
import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.utils.IdGen;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimpleEx;
import com.google.common.collect.Maps;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * 文件上传(Android)类
 * @author 刘灵星
 * @version 2015-5-19
 */
public class UploadAndroidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	private String fileSizeLimit;
	
    public UploadAndroidServlet() {  
        super();  
    }  
    

    public void destroy() {    
        super.destroy();    
    }  
    
    protected void service(HttpServletRequest request, HttpServletResponse response){
		fileSizeLimit = Global.getConfig("upload.file.Size.Limit");
		String uploadPath = request.getParameter("uploadPath"); //语音的存放路径	
		if(StringUtils.isBlank(uploadPath)){
			uploadPath = "healthArchives";
		}
		String uploadDir = Global.getConfig("upload.foloder") + File.separatorChar ;
		//每天上传的文件根据日期存放在不同的文件夹
		String autoCreatedDateDirByParttern = "yyyy" + File.separatorChar + "MM" + File.separatorChar;
		String autoCreatedDateDir = uploadPath + File.separatorChar + DateFormatUtils.format(new java.util.Date(), autoCreatedDateDirByParttern);
		File savePath = new File(uploadDir + autoCreatedDateDir);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}
		String saveDirectory =  uploadDir + autoCreatedDateDir;		
		if (StringUtils.isBlank(this.fileSizeLimit.toString())) {
			this.fileSizeLimit = "100";// 默认100M
		}
		int maxPostSize = Integer.parseInt(this.fileSizeLimit) * 1024 * 1024;
	    // 存放文件描述  
	    @SuppressWarnings("unused")  
	    String[] fileDiscription = { null, null };  
	    // 文件名  
	    String fileName = null; 
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
			ReturnCodeSimpleEx returnCodeErr = new ReturnCodeSimpleEx();
			Map<String, Object> headErr = Maps.newHashMap();
			Map<String, Object> data = Maps.newHashMap();
			headErr.put("ret", 0);
			headErr.put("msg", "成功");	
			String fileUrl   = File.separatorChar + autoCreatedDateDir +  fileName;
			fileUrl = fileUrl.replaceAll("\\\\", "/");	
			data.put("audioUrl", fileUrl);	
			data.put("website", Global.getConfig(Consts.STATIC_FILE_SITE));	
			returnCodeErr.setHead(headErr);
			returnCodeErr.setData(data);		
			response.setContentType("text/html; charset=UTF-8"); 
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();			
			writer.print( JsonMapper.getInstance().toJson(returnCodeErr));	
			writer.close();
		} catch (IOException e) {		
			throw new RuntimeException(e);
		}finally{
			if(writer != null)
				writer.close();
		}
    }
   
  @SuppressWarnings("unchecked")  
  public void doGet(HttpServletRequest request, HttpServletResponse response){  
  	   service(request, response); 
  }  
//   
  public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {   
      this.doGet(request, response);  
  }   
      
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
