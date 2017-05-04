]<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<form:form id="searchForm" modelAttribute="role" action="${ctx}/sys/role/" method="post" class="breadcrumb form-search">
		<shiro:hasPermission name="sys:role:edit"><a href="${ctx}/sys/role/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增角色"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tr>
			<th>序号</th>
			<th>角色名称</th>
<!-- 			<th>数据范围</th> -->
			<shiro:hasPermission name="sys:role:edit"><th>操作</th></shiro:hasPermission>
		</tr>
		<c:forEach items="${list}" var="role" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><a href="form?id=${role.id}">${role.name}</a></td>
<%-- 				<td>${fns:getDictLabel(role.dataScope,'sys_data_scope','')}</td> --%>
				<shiro:hasPermission name="sys:role:edit"><td>
					<a href="${ctx}/sys/role/assign?id=${role.id}">分配</a>
					<a href="${ctx}/sys/role/form?id=${role.id}">修改</a>
					<a href="${ctx}/sys/role/delete?id=${role.id}" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td></shiro:hasPermission>	
			</tr>
		</c:forEach>
	</table>
</body>
</html>