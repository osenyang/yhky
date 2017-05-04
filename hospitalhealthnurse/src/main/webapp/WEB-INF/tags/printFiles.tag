<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="fileUrl" type="java.lang.String" required="true" description="文件地址"%>
<%@ attribute name="contentType" type="java.lang.String" required="false" description="文件类型"%>
<%@ attribute name="width" type="java.lang.String" required="false" description="图片宽度"%>
<%@ attribute name="height" type="java.lang.String" required="false" description="图片高度"%>
<script type="text/javascript">	
	var fileUrl = "${fileUrl}";
 	var staticUrl = "${fns:getConfig('elink.staticfilesite')}";
	var contentType = "${contentType}";
	var url = "";
	if(fileUrl.indexOf("http://") == -1){
		fileUrl = staticUrl + fileUrl;
	}
	
	if(contentType == 'doc' || contentType == 'docx'){
		url = "${ctxStatic}/images/word.png";
	}else if(contentType == 'xls' || contentType == 'xlsx'){
		url = "${ctxStatic}/images/excel.png";
	}else if(contentType == 'pdf'){
		url = "${ctxStatic}/images/pdf.png";
	}else{
		url = "${ctxStatic}/images/mp3.png";
	}
	
 	document.write("<a href=\""+fileUrl+"\"><img src='" +  url +"'  style=\"max-width:${width}px;max-height:${height}px;_height:${height}px;-width:${width}px;border:0;padding:3px;\" /></a>");
 </script>