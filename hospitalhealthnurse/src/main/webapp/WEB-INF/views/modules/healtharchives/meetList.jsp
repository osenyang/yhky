<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>应急计划管理</title>
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
	<form:form id="searchForm" modelAttribute="meet" action="${ctx}/healtharchives/meet/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="healtharchives:meet:edit"><a href="${ctx}/healtharchives/meet/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增应急计划"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>项目名称</th>
			<th>共多少次</th>
			<th>一天多少次</th>
			<th>每次时长（分钟）</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>执行人/岗位</th>
			<th>执行人/岗位</th>
		<shiro:hasPermission name="healtharchives:meet:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="meet">
			<tr>			
				<td>${meet.entryName}</td>
				<td>${meet.frequencyTotal}</td>
				<td>${meet.frequency}</td>
				<td>${meet.frequencyTime}</td>
				<td>${meet.startTime}</td>
				<td>${meet.endTime}</td>
				<td>${meet.quartersId}</td>
				<td>${meet.quartersNm}</td>
			<!-- 
				<td><a href="${ctx}/healtharchives/meet/form?id=${meet.id}">${meet.name}</a></td>
			-->			
				<shiro:hasPermission name="healtharchives:meet:edit"><td>
    				<a href="${ctx}/healtharchives/meet/form?id=${meet.id}">修改</a>
					<a href="${ctx}/healtharchives/meet/delete?id=${meet.id}" onclick="return confirmx('确认要删除该应急计划吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
