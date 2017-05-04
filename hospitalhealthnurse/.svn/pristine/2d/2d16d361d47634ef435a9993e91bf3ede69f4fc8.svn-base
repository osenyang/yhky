<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>app版本管理管理</title>
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
	<form:form id="inputForm" modelAttribute="appInformation" action="${ctx}/sys/appInformation/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="appName"><span class="tishi">*</span>APP名称:</label>
			<div class="controls">			
			 	<form:input path="appName" htmlEscape="false" maxlength="30" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="appAddress"><span class="tishi">*</span>APP地址:</label>
			<div class="controls">			
			 	<form:input path="appAddress" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="appVersion"><span class="tishi">*</span>版本号:</label>
			<div class="controls">			
			 	<form:input path="appVersion" htmlEscape="false" maxlength="10" class="required"/>
				
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sys:appInformation:edit">
				<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
