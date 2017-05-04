<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>应急计划管理</title>
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
	<form:form id="inputForm" modelAttribute="meet" action="${ctx}/healtharchives/meet/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<input type="hidden" id="interveneId" name="interveneId" value="${interveneId}">
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="entryName"><span class="tishi">*</span>项目名称:</label>
			<div class="controls">			
			 	<form:input path="entryName" htmlEscape="false" maxlength="20" class="required"/>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="frequencyTotal"><span class="tishi">*</span>共多少次:</label>
			<div class="controls">			
			 	<form:input path="frequencyTotal" htmlEscape="false" maxlength="5" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="frequency"><span class="tishi">*</span>次/日:</label>
			<div class="controls">			
			 	<form:input path="frequency" htmlEscape="false" maxlength="5" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="frequencyTime"><span class="tishi">*</span>分钟/次:</label>
			<div class="controls">			
			 	<form:input path="frequencyTime" htmlEscape="false" maxlength="5" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="startTime"><span class="tishi">*</span>开始时间:</label>
			<div class="controls">			
				<input id="startTime" name="startTime" type="text" readonly="readonly" maxlength="20" class="required Wdate"
				 value="<fmt:formatDate value="${meet.startTime}" pattern="yyyy-MM-dd HH:mm"/>" pattern="yyyy-MM-dd HH:mm" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="endTime"><span class="tishi">*</span>结束时间:</label>
			<div class="controls">			
				<input id="endTime" name="endTime" type="text" readonly="readonly" maxlength="20" class="required Wdate"
				 value="<fmt:formatDate value="${meet.endTime}" pattern="yyyy-MM-dd HH:mm"/>" pattern="yyyy-MM-dd HH:mm" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="quartersNm"><span class="tishi">*</span>执行人/岗位:</label>
			<div class="controls">			
			 	<tags:treeselect url="/healtharchives/intervene/treeData" id="quartersId" name="quartersId"
				value="${meet.quartersId}" labelName="quartersNm"  labelValue="${meet.quartersNm}" title="选择执行人(岗位)" cssClass="required"></tags:treeselect>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="healtharchives:meet:edit">
				<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</shiro:hasPermission>
		</div>
	</form:form>
</body>
</html>
