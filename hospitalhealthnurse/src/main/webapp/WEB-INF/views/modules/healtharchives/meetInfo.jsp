<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<form:form id="meetForm" modelAttribute="meet" action="${ctx}/healtharchives/intervene/saveMeet" method="post">
<input type="hidden" id="id" name="id" value="${meet.id}">
<input type="hidden" id="interveneId" name="interveneId" value="${intervene.id}">
<table id="meetTable" class="interveneTable" style="text-align: center;">
	<tr>
		<th>项目名称</th>
		<th colspan="3">治疗频次</th>
		<th>执行时间</th>
		<th>执行人(岗位)</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${meetList}" var="meet">
		<tr id="${meet.id}">
			<td>${meet.entryName}</td>
			<td>共${meet.frequencyTotal}次</td>
			<td>${meet.frequency}次/日</td>
			<td>${meet.frequencyTime}分钟/次</td>
			<td><fmt:formatDate value="${meet.startTime}" pattern="yyyy-MM-dd HH:mm"/>~<fmt:formatDate value="${meet.endTime}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td>${meet.quartersNm}</td>
			<td>
			<c:if test="${intervene.state == 0 || intervene.state == 2 }">
				<a onclick="updateMeet('${meet.id}')">修改</a>　
				<a onclick="deleteMeet('${meet.id}')">删除</a>
			</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${intervene.state == 0 || intervene.state == 2 }">
<div class="addTableDiv">
	<input type="button" value="添加" onclick="addMeet()">
</div>
</c:if>
<div class="form-actions">
	<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview('1');"/>
</div>
</form:form>