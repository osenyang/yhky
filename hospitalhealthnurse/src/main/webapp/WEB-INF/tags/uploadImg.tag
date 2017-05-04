<%@ tag pageEncoding="UTF-8" body-content="empty" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script src="${pageContext.request.contextPath}/static/jquery/ajaxupload.3.9.js" type="text/javascript"></script>
<%@ attribute name="imgThumb"  type="java.lang.String" required="true" description="缩略图地址"%>
<%@ attribute name="imgOri"  type="java.lang.String" required="true" description="原图地址"%>	
<%@ attribute name="uploadPath" type="java.lang.String" required="true" description="上传路径 "%> 	
<%@ attribute name="imgContent" type="java.lang.String" required="true" description="图片显示位置"%> 	
<%@ attribute name="isDelete" type="java.lang.Boolean" description="是否显示删除按钮"%> 	
	
 <input type="button" class="btn" value="请选择您的图片" id="fileButton"/>
 <span id="loading" class="help-inline">支持图片类型：*.jpg;*.png;*.bmp;*.jpeg文件最大限制：2MB</span>
 <!-- 初始化swfupload 对象-->
<script type="text/javascript">		
var imgThumb =  document.getElementById("${imgThumb}").value;
var imgOri = document.getElementById("${imgOri}").value ;
new AjaxUpload("#fileButton",{
	action:"${pageContext.request.contextPath}/uploadServlet?uploadPath=${uploadPath}&oldImgUrlOri=" +imgOri + "&oldImgUrlThumb="+imgThumb,
	autoSubmit:true,
	name:"myfile",
	onSubmit:function(file, extension){
		if (extension && /^(pdf|jpg|png|jpeg|bmp)$/.test(extension))
		{
			$("#url-span label").remove();
			$("#loading").html('<img src="${ctxStatic}/images/loading.gif">');
			$("#loading").show();
			$("#fileButton").attr("disabled","disabled");
		}
		else
		{
			$("#loading").html("你所选择的文件不受系统支持");
			$("#loading").show();
			return false;
		}
	},
	onComplete:function(file, response){		
		var dataObj=eval("("+response+")");//转换为json对象 	
		var header = dataObj.head;
		var data = dataObj.data;		
		if(header.ret == 0){		
			$("#${imgContent}").html("");				
			document.getElementById("${imgOri}").value = data.oriImg;	
			document.getElementById("${imgThumb}").value = data.thumbImg;
			$("#loading").html("图片上传成功！");
			if("${isDelete}"){
				$("#loading").html("图片上传成功！<input id=\"urlSubmit\" class=\"btn btn-yellow\" type=\"button\" onclick=\"deleteUrl(1);\" value=\"删除\" />");
			}
			$("#loading").show();
			$("#fileButton").removeAttr("disabled");
			
			$("#${imgContent}").html("<a href=\"${fns:getConfig('elink.staticfilesite')}"+data.oriImg+"\" url=\"${fns:getConfig('elink.staticfilesite')}" +  data.oriImg+"\" class=\"fancybox\" rel=\"gallery\"><img src='${fns:getConfig('elink.staticfilesite')}" +  data.thumbImg +"'  style=\"max-width:100px;max-height:100px;_height:100px;-width:100px;border:0;padding:3px;\" /></a>");
			$("#${imgContent}").show();
			
		}else{
			alert("附件过大！");
			$("#loading").html("支持图片类型：*.jpg;*.png;*.bmp;*.jpeg文件最大限制：2MB");
			$("#fileButton").removeAttr("disabled");
		}
	}
});
	   
</script>