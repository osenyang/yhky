<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${functionName}管理</title>
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
	<form:form id="inputForm" modelAttribute="${className}" action="${r"${ctx}"}/${urlPrefix}/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${r"${message}"}"/>
		
		<#list listFeild as map>  
		<div class="control-group">
			<label class="control-label" for="${map["feildNm"]}"><span class="tishi">*</span>${map["colContent"]}:</label>
			<div class="controls">			
			<#if map["feildType"] == "double">
  				<form:input path="${map["feildNm"]}" htmlEscape="false"  class="required"/>
			<#elseif map["feildType"] == "String">
			 	<form:input path="${map["feildNm"]}" htmlEscape="false" maxlength="${map["colSize"]}" class="required"/>
			<#elseif map["feildType"] == "java.util.Date">
				<input id="${map["feildNm"]}" name="${map["feildNm"]}" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
				 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>
			<#else>
			 	<form:input path="${map["feildNm"]}" htmlEscape="false" maxlength="${map["colSize"]}" class="required"/>
			</#if>
				
			</div>
		</div>
		</#list>  		

		<div class="form-actions">
			<shiro:hasPermission name="${permissionPrefix}:edit">
				<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
