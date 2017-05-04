<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>健康建议管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
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
	<form:form id="inputForm" modelAttribute="assessReport" action="${ctx}/healtharchives/assessReport/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="archivesId"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="doctorId"><span class="tishi">*</span>医生姓名:</label>
			<div class="controls">			
			 	<form:input path="doctorNm" htmlEscape="false" maxlength="64" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="content"><span class="tishi">*</span>健康建议:</label>
			<div class="controls">			
			 	<form:input path="content" htmlEscape="false" maxlength="65535" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="createDate"><span class="tishi">*</span>创建日期:</label>
			<div class="controls">			
				<input id="createDate" name="createDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
				 value="<fmt:formatDate value="${assessReport.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</div>
		</div>

	</form:form>
</body>
</html>
