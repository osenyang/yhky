<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>健康管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
        
        function query(){
			$("#pageNo").val(1);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<form:form id="searchForm" modelAttribute="information" action="${ctx}/healtharchives/information/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>标题 ：</label><form:input path="title" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>标题</th>
			<th>会诊老人 </th>
			<th>发布人</th>
			<th>状态</th>
			<th>发送时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="information" varStatus="status">
			<tr>			
				<td>${status.index + 1}</td>
				<td>${information.title}</td>
				<td>${information.fullNm}</td>
				<td>${information.sendNm}</td>
				<td <c:if test="${information.state == '0'}"> style="color: red;"</c:if>>${information.stateName}</td>
				<td><fmt:formatDate value="${information.createDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>
    				<a href="${ctx}/healtharchives/information/form?id=${information.id}">查看内容</a>
					<a href="${ctx}/healtharchives/information/delete?id=${information.id}" onclick="return confirmx('确认要删除该条消息吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
