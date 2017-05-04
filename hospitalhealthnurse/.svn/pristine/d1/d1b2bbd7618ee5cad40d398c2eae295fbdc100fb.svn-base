<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>评估管理</title>
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
	<form:form id="inputForm" modelAttribute="healthAssess" action="${ctx}/healtharchives/healthAssess/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="archivesId"/>
		<tags:message content="${message}"/>
		
		<%-- <div class="control-group">
			<label class="control-label" for="archivesId"><span class="tishi">*</span>档案ID:</label>
			<div class="controls">			
			 	<form:input path="archivesId" htmlEscape="false" maxlength="32" class="required"/>
				
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label" for="typeNm"><span class="tishi">*</span>评估分类:</label>
			<div class="controls">			
			 	<form:input path="typeNm" htmlEscape="false" maxlength="50" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="questNm"><span class="tishi">*</span>评估量表:</label>
			<div class="controls">			
			 	<form:input path="questNm" htmlEscape="false" maxlength="50" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="gradeNm"><span class="tishi">*</span>评估结果:</label>
			<div class="controls">			
			 	<form:input path="gradeNm" htmlEscape="false" maxlength="50" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="score"><span class="tishi">*</span>评估分数:</label>
			<div class="controls">			
			 	<form:input path="score" htmlEscape="false" maxlength="10" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="discribe"><span class="tishi">*</span>评估标准:</label>
			<div class="controls">			
			 	<form:input path="discribe" htmlEscape="false" maxlength="65535" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="createDate"><span class="tishi">*</span>创建日期:</label>
			<div class="controls">			
				<input id="createDate" name="createDate" type="text" readonly="readonly" maxlength="20" class="Wdate required"
				 value="<fmt:formatDate value="${healthAssess.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
				
			</div>
		</div>

		<%-- <div class="form-actions">
			<shiro:hasPermission name="healtharchives:healthAssess:edit">
				<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div> --%>
	</form:form>
</body>
</html>
