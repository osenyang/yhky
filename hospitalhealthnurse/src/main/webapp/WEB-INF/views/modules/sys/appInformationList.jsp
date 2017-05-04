<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>app版本管理管理</title>
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
	<form:form id="searchForm" modelAttribute="appInformation" action="${ctx}/sys/appInformation/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>APP名称 ：</label><form:input path="appName" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="sys:appInformation:edit"><a href="${ctx}/sys/appInformation/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增app版本"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>APP名称</th>
			<th>APP地址</th>
			<th>版本号</th>
		<shiro:hasPermission name="sys:appInformation:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="appInformation">
			<tr>			
				<td>${appInformation.appName}</td>
				<td>${appInformation.appAddress}</td>
				<td>${appInformation.appVersion}</td>
				<shiro:hasPermission name="sys:appInformation:edit"><td>
    				<a href="${ctx}/sys/appInformation/form?id=${appInformation.id}">修改</a>
					<a href="${ctx}/sys/appInformation/delete?id=${appInformation.id}" onclick="return confirmx('确认要删除该app版本吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
