<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>已完成任务</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<table id="infoListTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>床号/房号</th>	
			<th>老人姓名</th>		
			<th>服务项目</th>
			<th>预计执行时间</th>
			<th>开始执行时间</th>
			<th>结束执行时间</th>
			<th>执行情况</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="planExecuteRecordVO" varStatus="status">
			<tr>			
				<td>${planExecuteRecordVO.bedNumber}</td>
				<td>${planExecuteRecordVO.elderName}</td>
				<td>${planExecuteRecordVO.projectName}</td>
				<td>
					<fmt:formatDate value="${planExecuteRecordVO.expectedStartTime}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td>
					<fmt:formatDate value="${planExecuteRecordVO.startTime}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td>
					<fmt:formatDate value="${planExecuteRecordVO.stopTime}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td>
					<c:if test="${planExecuteRecordVO.state==1}">准时</c:if>
					<c:if test="${planExecuteRecordVO.state==2}">延时</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
