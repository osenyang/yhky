package com.elink.hospitalhealthnurse.common.web;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimpleEx;
import com.google.common.collect.Maps;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * 文件控制类
 * @author 刘灵星
 * @version 2013-3-23
 */
@Controller
@RequestMapping(value = "${adminPath}/common/file")
public class FileController extends BaseController{

	private String fileSizeLimit;
	private File file;
	
	
	public File getFile() {
		return file;
	}

	@RequiresUser
	@RequestMapping(value = "uploadFile")
	@ResponseBody
	public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException{
		fileSizeLimit = Global.getConfig("upload.file.Size.Limit");
		String uploadPath = request.getParameter("uploadPath");

		String uploadDir = Global.getConfig("upload.foloder") + File.separatorChar + uploadPath + File.separatorChar;
		//每天上传的文件根据日期存放在不同的文件夹
		String autoCreatedDateDirByParttern = "yyyy" + File.separatorChar + "MM" + File.separatorChar + "dd"
				+ File.separatorChar;
		String autoCreatedDateDir = DateFormatUtils.format(new java.util.Date(), autoCreatedDateDirByParttern);
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
	        // 上传文件数  
	    int fileCount = 0;  
	        // 重命名策略  
	    MyFileRenamePolicy rfrp = new MyFileRenamePolicy();  
	        // 上传文件  
	    MultipartRequest mulit = new MultipartRequest(request, saveDirectory,          maxPostSize, "UTF-8", rfrp);//取得上传文件  
        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
        while (filesname.hasMoreElements()) {  
            String name = (String) filesname.nextElement();//标识  
            System.out.println(name);  
            fileName = mulit.getFilesystemName(name); //取得文件名  
            String contentType = mulit.getContentType(name);//工具标识取得的文件类型  
            if (fileName != null) {  
                fileCount++;  
            }  
            System.out.println("文件名：" + fileName);  
            System.out.println("文件类型： " + contentType);   
        }  
        System.out.println("共上传" + fileCount + "个文件！");   

		
		

		ReturnCodeSimpleEx returnCodeErr = new ReturnCodeSimpleEx();
		Map<String, Object> headErr = Maps.newHashMap();
		headErr.put("ret", 0);
		headErr.put("msg", "成功");				
		returnCodeErr.setHead(headErr);
		returnCodeErr.setData(null);		
		return JsonMapper.getInstance().toJson(returnCodeErr);
	}
	
	@RequiresUser
	@RequestMapping(value = "deleteFile")
	@ResponseBody
	public String deleteFile(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	
	@RequiresUser
	@RequestMapping(value = "downFile")
	@ResponseBody
	public String downFile(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	
	class MyFileRenamePolicy implements FileRenamePolicy {
		public File rename(File file1) {
			file = file1;
			String fileSaveName = StringUtils.join(new String[] { java.util.UUID.randomUUID().toString(), ".",
					FilenameUtils.getExtension(file1.getName()) });
			File result = new File(file1.getParentFile(), fileSaveName);
			return result;
		}
	}
	
}
