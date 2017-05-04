<%@ tag pageEncoding="UTF-8" body-content="empty" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="formId"  type="java.lang.String" required="true" description="表单ID"%>
<%@ attribute name="fileId"  type="java.lang.String" required="true" description="文件ID"%>
<%@ attribute name="contentType"  type="java.lang.String" required="true" description="文件类型"%>
<%@ attribute name="uploadPath" type="java.lang.String" required="true" description="上传路径 "%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/SWFUoload/css/default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/SWFUoload/css/button.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/SWFUoload/js/swfupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/SWFUoload/js/swfupload.queue.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/SWFUoload/js/fileprogress.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/SWFUoload/js/handlers.js"></script>
<div style="padding-left: 5px; margin-top:20px;">
	<span id="spanButtonPlaceholder1${formId}"></span>	
	<input id="btnCancel1${formId}" type="button" value="取消上传" onclick="cancelQueue(upload1${formId});" disabled="disabled" style="margin-left:8px; height:26px; font-size: 12px; width:70px;" />			
	<span class="help-inline">&nbsp;&nbsp;支持文件类型：*.mp4;*.mp3;*.flv;*.pdf;*.apk文件最大限制：1024MB</span>
</div>
<div class="fieldset flash"  style="width:50%;padding:20px;">
	<div id="fsUploadProgress1${formId}">
		<span class="legend">资源文件</span>
		<div style="clear:both;"></div>
	</div>
	<div  style="clear:both;"></div>
</div>

<div class="auditingBnGroup">
	<div class="btn btn-primary" onclick="upload${formId}();">上&nbsp;传</div>
</div>
 <!-- 初始化swfupload 对象-->
<script type="text/javascript">	
		
		var upload1${formId};
		window.onload = function(){
			var oldFile = document.getElementById("${fileId}").value;
			upload1${formId} = new SWFUpload({
				//提交路径
				upload_url: "${pageContext.request.contextPath}/uploadServlet?uploadPath=${uploadPath}&oldFile="+oldFile+";jsessionid=${pageContext.session.id}",
				//向后台传递额外的参数
				post_params: {"session" : ""},
				//上传文件的名称
				file_post_name: "file",
				//Post方式上传
				use_query_string:false,				
				// 下面自己按照字面意思理解
				file_size_limit : "1024000",	// 1G
				file_types : "*.mp4;*.mp3;*.flv;*.pdf;*.apk",
				file_types_description : "文件格式", 
				file_upload_limit : "1",
				file_queue_limit : "1",
				// 事件处理				
				file_dialog_start_handler : fileDialogStart,
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess${formId},
				upload_complete_handler : uploadComplete,

				// 按钮的处理
				button_image_url : "${pageContext.request.contextPath}/static/SWFUoload/images/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder1${formId}",
				button_width: 100,
				button_height: 26,
				//button_text:"选择文件",
				// Flash Settings
				flash_url : "${pageContext.request.contextPath}/static/SWFUoload/js/swfupload.swf",
				
				custom_settings : {
					progressTarget : "fsUploadProgress1${formId}",
					cancelButtonId : "btnCancel1${formId}"
				},				
				// Debug Settings
				debug: false
			});
	     };

		
	function upload${formId}(){
		upload1${formId}.startUpload();
	}
	
	function uploadSuccess${formId}(file, serverData){		
		var dataObj=eval("("+serverData+")");//转换为json对象 	
		if(dataObj.head ){
			var header = dataObj.head;
			var data = dataObj.data;
			if(header.ret == 0){				
				document.getElementById("${fileId}").value = data.oriImg;
				document.getElementById("${contentType}").value = data.fileType;
				alert("上传成功！");				
			}
		}	
	}
</script>