<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>老人今日计划</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<table id="infoListTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>计划类型</th>		
			<th>服务项目</th>		
			<th>执行人（岗位）</th>
			<th>执行时间</th>
			<th>状态</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="planExecuteRecordVO" varStatus="status">
			<tr>			
				<td>${fns:getDictLabel(planExecuteRecordVO.planType, 'SERVICE_TYPE', '护理计划')}</td>
				<td>${planExecuteRecordVO.projectName}</td>
				<td>
					<c:choose>
						<c:when test="${planExecuteRecordVO.state==0}">${planExecuteRecordVO.quartersName }</c:when>
						<c:otherwise>${planExecuteRecordVO.serviceUserName }</c:otherwise>
					</c:choose>
				</td>
				<td>
					<fmt:formatDate value="${planExecuteRecordVO.expectedStartTime}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td>
					<c:choose>
						<c:when test="${planExecuteRecordVO.state==0}">待服务</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${planExecuteRecordVO.stopTime == null}">正在执行</c:when>
								<c:otherwise>已服务</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</td>
				<td><a href="${ctx}/plan/planExecuteRecord/planExeRecordInfo?id=${planExecuteRecordVO.id}">详情</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
