<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>额外项目管理</title>
<meta name="decorator" content="default"/>
<script type="text/javascript">
$(document).ready(function() {
	$("#name").focus();
	$("#inputForm").validate();
});
/**类型更改事件*/
function changeType(){
	if($("#frequencyType").val() == '0'){
		$("#frequencyDay").show();
		$("#frequencyWeek").hide();
		$("#intervals").val($("#frequencyDaySelect").val());
	}else if($("#frequencyType").val() == '1'){
		$("#frequencyDay").hide();
		$("#frequencyWeek").show();
		$("#intervals").val($("#frequencyWeekSelect").val());
	}
	$("#dateArray").val("");
}
/**间隔天更改事件*/
function changeSelectDay(){
	$("#intervals").val($("#frequencyDaySelect").val());
}
/**间隔一周更改事件*/
function changeSelectWeek(){
	$("#intervals").val($("#frequencyWeekSelect").val());
}
/**静脉输液*/
function addfrequency(){
	if($("#dateArray").val().length>0){
		if($("#dateArray").val().indexOf($("#frequencyHide").val()) == -1){
			$("#dateArray").val($("#dateArray").val()+";"+$("#frequencyHide").val());
		}
	}else{
		$("#dateArray").val($("#frequencyHide").val());
	}
}
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
	<form:form id="inputForm" modelAttribute="extraItems" action="${ctx}/healtharchives/extraItems/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="projectNm"><span class="tishi">*</span>项目名称:</label>
			<div class="controls">			
			 	<form:input path="projectNm" htmlEscape="false" maxlength="32" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="frequencyType"><span class="tishi">*</span>间隔周期:</label>
			<div class="controls">			
			 	<select class="selectType" style="width: 100px;" id="frequencyType" name="frequencyType" onchange="changeType()">
					<option value="0" <c:if test="${extraItems.frequencyType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${extraItems.frequencyType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><span class="tishi">*</span>间隔频次:</label>
			<div class="controls">
			 	<div id="frequencyDay" class="dateDay" <c:if test="${extraItems.frequencyType != '0' && not empty extraItems.frequencyType}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay()" class="selectType" style="width: 100px;" id="frequencyDaySelect" name="frequencyDaySelect">
						<option value="1" <c:if test="${extraItems.intervals == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${extraItems.intervals == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${extraItems.intervals == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${extraItems.intervals == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'frequencyHide',dateFmt:'HH:mm',onpicked:addfrequency})" class="btn" type="button" value="请选择" />
				</div>
				<div id="frequencyWeek" class="dateWeek" <c:if test="${extraItems.frequencyType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek()" class="selectType" style="width: 100px;" id="frequencyWeekSelect" name="frequencyWeekSelect">
						<option value="1" <c:if test="${extraItems.intervals == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${extraItems.intervals == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${extraItems.intervals == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${extraItems.intervals == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'frequencyHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addfrequency})" class="btn" type="button" value="请选择" />
				</div>
				<input id="frequencyHide" name="frequencyHide" type="hidden">
				<input id="intervals" name="intervals" value="${empty extraItems.intervals?'1':extraItems.intervals}" type="hidden">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="dateArray"><span class="tishi">*</span>执行时间:</label>
			<div class="controls">			
			 	<input type="text" readonly="readonly" id="dateArray" name="dateArray" class="required" value="${extraItems.dateArray}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="quartersId"><span class="tishi">*</span>执行人/岗位:</label>
			<div class="controls">
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="quartersId" name="quartersId" 
		value="${extraItems.quartersId}" labelName="quartersNm"  labelValue="${extraItems.quartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>			
			 	<%-- <form:input path="quartersId" htmlEscape="false" maxlength="32" class="required"/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="exeTime"><span class="tishi">*</span>开始执行时间:</label>
			<div class="controls">			
				<input id="exeTime" name="exeTime" type="text" readonly="readonly" maxlength="20" class="Wdate"
				 pattern="yyyy-MM-dd HH:mm" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</div>
		</div>
	</form:form>
</body>
</html>
