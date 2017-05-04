<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>健康档案管理</title>
<meta name="decorator" content="default"/>
<script type="text/javascript">
	$(document).ready(function(){
		$("#inputForm").validate({
			rules : {
				title:{userName:true},
			},
			messages: {
				title:{userName:"只能输入中文字、英文字母、数字"},
			},
		});
	/* 	$("#title").keyup(function(){
			//如果输入非中文，则替换为''.
		    this.value = this.value.replace(/[^\u4E00-\u9FA5]/g, '');
		});
		$("#title").blur(function(){
	   	 	//如果输入非中文，则替换为''.
	        this.value = this.value.replace(/[^\u4E00-\u9FA5]/g, '');
	   	}); */
		$("#btnSubmit").click(function(){ 
			var bool = ($("#content").val().length > 0); 
			if(bool){ 
				if($("#inputForm").valid()){
					$("#inputForm").submit();
				}
			}else{
				alert("请输入会诊内容");
			} 
		});
	});
	 
</script>
<style type="text/css">
	.tishi{
		color: #FF0000;
		font-weight: bold;
		margin-right: 5px;
	}
</style>
</head>
<body>
	<br/>
	<form:form id="inputForm" modelAttribute="information" action="${ctx}/healtharchives/healthArchives/saveInformation" method="post" class="form-horizontal">
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="title"><span class="tishi">*</span>标题:</label>
			 	<input id="title" name="title" type="text" value="老年多学科综合会诊">
			</div>
			
			<div class="from-info">		
				<label class="control-label" for="calf">会诊老人:</label>	
  				<input type="text" value="${healthArchives.fullNm}" readonly="readonly"/>
				<input id="archivesId" name="archivesId" type="hidden" value="${healthArchives.id}">
			</div>
		</div>
		<div class="control-group">
			<div class="control">
				<label class="control-label"><span class="tishi">*</span>内容:</label>
				<textarea id="content" name="content" rows="5" cols="5" style="min-width: 400px;"></textarea>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="name"><span class="tishi">*</span>人员:</label>
			<div class="controls">			
				<tags:treeselect url="/healtharchives/healthArchives/treeData" id="jobNumbers" name="jobNumbers" checked="true"
				value="" labelName="receiveUsers"  labelValue="" title="选择人员" cssClass="required input-xxlarge"></tags:treeselect>	
			</div>
		</div>
		
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="button" value="一键发送"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
