<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>历史计划项目</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			//$("#inputForm").validate();
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
	<form:form id="inputForm" modelAttribute="planExecuteRecord" action="${ctx}/plan/planExecuteRecord/doPlan" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label" for="projectName"><span class="tishi">*</span>计划项目:</label>
			${planExecuteRecord.projectName }
		</div>
		<div class="control-group">
			<label class="control-label" for="startTime"><span class="tishi">*</span>执行时间:</label>
			<div class="controls">	
				<c:if test="${not empty planExecuteRecord.startTime}">
					<input id="startTime" value="<fmt:formatDate value="${planExecuteRecord.startTime}" pattern="yyyy-MM-dd HH:mm"/>"  name="startTime" type="text" maxlength="20" class="required"  readonly="readonly"/>
				</c:if>
				<c:if test="${empty planExecuteRecord.startTime}">
					<input id="startTime" name="startTime" type="text" readonly="readonly" maxlength="20" class="required Wdate"
				value="<fmt:formatDate value="${planExecuteRecord.startTime}" pattern="yyyy-MM-dd HH:mm"/>" pattern="yyyy-MM-dd HH:mm" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>		
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="stopTime"><span class="tishi">*</span>完成时间:</label>
			<div class="controls">			
			 	<input id="stopTime" name="stopTime" type="text" readonly="readonly" maxlength="20" class="required Wdate"
				value="<fmt:formatDate value="${planExecuteRecord.stopTime}" pattern="yyyy-MM-dd HH:mm"/>" pattern="yyyy-MM-dd HH:mm" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>		
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="jobNumber"><span class="tishi">*</span>服务人员号:</label>
			<div class="controls">			
				<input id="jobNumber" name="jobNumber" type="text" maxlength="20" class="required"/>
			</div>
		</div>
	</form:form>
</body>
</html>
