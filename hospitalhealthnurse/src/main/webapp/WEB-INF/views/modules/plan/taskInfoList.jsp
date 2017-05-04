<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>任务清单</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<table id="infoListTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>老人姓名</th>		
			<th>房号/床号</th>
			<th>服务项目</th>
			<th>执行人（岗位）</th>
			<th>执行时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="planExecuteRecordVO" varStatus="status">
			<tr>			
				<td>${planExecuteRecordVO.elderName}</td>
				<td>${planExecuteRecordVO.bedNumber}</td>
				<td>${planExecuteRecordVO.projectName}</td>
				<td>
					<c:if test="${empty planExecuteRecordVO.serviceUserName}">${planExecuteRecordVO.quartersName}</c:if>
					<c:if test="${not empty planExecuteRecordVO.serviceUserName}">${planExecuteRecordVO.serviceUserName}</c:if>
				</td>
				<td>
					<c:if test="${empty planExecuteRecordVO.startTime}"><fmt:formatDate value="${planExecuteRecordVO.expectedStartTime}" pattern="yyyy-MM-dd HH:mm"/></c:if>
					<c:if test="${not empty planExecuteRecordVO.startTime}"><fmt:formatDate value="${planExecuteRecordVO.startTime}" pattern="yyyy-MM-dd HH:mm"/></c:if>
				</td>
				<td><a href="${ctx}/plan/planExecuteRecord/planExeRecordInfo?id=${planExecuteRecordVO.id}">查看</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
