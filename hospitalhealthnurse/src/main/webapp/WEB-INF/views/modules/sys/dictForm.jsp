<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#value").focus();
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
	<form:form id="inputForm" modelAttribute="dict" action="${ctx}/sys/dict/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="value"><span class="tishi">*</span>键值:</label>
			<div class="controls">
				<form:input path="value" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="label"><span class="tishi">*</span>标签:</label>
			<div class="controls">
				<form:input path="label" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="type"><span class="tishi">*</span>类型:</label>
			<div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="50" class="required abc"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="description"><span class="tishi">*</span>描述:</label>
			<div class="controls">
				<form:input path="description" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="sort"><span class="tishi">*</span>排序:</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" maxlength="11" class="required digits"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:dict:edit">
				<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>