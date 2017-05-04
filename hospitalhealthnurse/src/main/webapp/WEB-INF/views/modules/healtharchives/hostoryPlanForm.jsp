<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>历史方案管理</title>
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
	<form:form id="inputForm" modelAttribute="hostoryPlan" action="${ctx}/healtharchives/hostoryPlan/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="planId"><span class="tishi">*</span>计划类型:</label>
			<div class="controls">			
			 	<form:input path="planId" htmlEscape="false" maxlength="32" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="planType"><span class="tishi">*</span>计划类型:</label>
			<div class="controls">			
			 	<form:input path="planType" htmlEscape="false" maxlength="2" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="createBy"><span class="tishi">*</span>创建者:</label>
			<div class="controls">			
			 	<form:input path="createBy" htmlEscape="false" maxlength="64" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="createDate"><span class="tishi">*</span>创建日期:</label>
			<div class="controls">			
				<input id="createDate" name="createDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
				 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>
				
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="healtharchives:hostoryPlan:edit">
				<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
