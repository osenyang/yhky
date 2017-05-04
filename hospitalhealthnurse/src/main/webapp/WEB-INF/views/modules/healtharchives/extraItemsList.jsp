<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>额外项目管理</title>
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
	<form:form id="searchForm" modelAttribute="extraItems" action="${ctx}/healtharchives/extraItems/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="healtharchives:extraItems:edit"><a href="${ctx}/healtharchives/extraItems/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增额外项目"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>项目名称</th>
			<th>执行人/岗位</th>
			<th>执行人/岗位</th>
			<th>执行时间</th>
			<th>频次类型（0、天,1、周）</th>
			<th>间隔时间</th>
			<th>时间数组</th>
			<th>删除标记</th>
		<shiro:hasPermission name="healtharchives:extraItems:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="extraItems">
			<tr>			
				<td>${extraItems.projectNm}</td>
				<td>${extraItems.quartersId}</td>
				<td>${extraItems.quartersNm}</td>
				<td>${extraItems.exeTime}</td>
				<td>${extraItems.frequencyType}</td>
				<td>${extraItems.intervals}</td>
				<td>${extraItems.dateArray}</td>
				<td>${extraItems.delFlag}</td>
			<!-- 
				<td><a href="${ctx}/healtharchives/extraItems/form?id=${extraItems.id}">${extraItems.name}</a></td>
			-->			
				<shiro:hasPermission name="healtharchives:extraItems:edit"><td>
    				<a href="${ctx}/healtharchives/extraItems/form?id=${extraItems.id}">修改</a>
					<a href="${ctx}/healtharchives/extraItems/delete?id=${extraItems.id}" onclick="return confirmx('确认要删除该额外项目吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
