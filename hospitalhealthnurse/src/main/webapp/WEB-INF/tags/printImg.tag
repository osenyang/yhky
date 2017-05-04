<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="imgUrl" type="java.lang.String" required="true" description="图片地址"%>
<%@ attribute name="imgOriUrl" type="java.lang.String" required="true" description="原图图片"%>
<%@ attribute name="defaultUrl" type="java.lang.String" required="false" description="默认图片"%>
<%@ attribute name="width" type="java.lang.String" required="false" description="图片宽度"%>
<%@ attribute name="height" type="java.lang.String" required="false" description="图片高度"%>
<script type="text/javascript">	
	var url = "${imgUrl}";
	var imgOriUrl = "${imgOriUrl}";
	var staticUrl = "${fns:getConfig('elink.staticfilesite')}";
	var defaultUrl = "${defaultUrl}";
	
 	if(url == "" && defaultUrl != ""){
 		url = staticUrl + defaultUrl;
 	}else if(url.indexOf("http://") == -1){
		url = staticUrl + url;
 	}
	
	if(imgOriUrl == "" && defaultUrl != ""){
		imgOriUrl = staticUrl + defaultUrl;
	}else if(imgOriUrl.indexOf("http://") == -1){
		imgOriUrl = staticUrl  + imgOriUrl;
	}
	
	if(imgOriUrl == ""){
		imgOriUrl = staticUrl + "/static/images/no_image.jpg";
	}
	
	if(url == ""){
		url = staticUrl + "/static/images/no_image.jpg";
	}
	
	document.write("<a href=\""+imgOriUrl+"\" url=\"" +  imgOriUrl+"\" class=\"fancybox\" rel=\"gallery\"><img src='" +  url +"'  style=\"max-width:${width}px;max-height:${height}px;_height:${height}px;-width:${width}px;border:0;padding:3px;\" /></a>");
</script>