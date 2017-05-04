<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>收获地址管理</title>
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
	</script>
</head>
<body>
	<form:form id="searchForm" modelAttribute="sysUserAddress" action="${ctx}/sys/sysUserAddress/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>老人用户ID</th>
			<th>省级</th>
			<th>城市</th>
			<th>地区县区</th>
			<th>地址</th>
			<th>邮政编码</th>
			<th>创建时间</th>
		<shiro:hasPermission name="sys:sysUserAddress:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysUserAddress">
			<tr>			
				<td>${sysUserAddress.userId}</td>
				<td>${sysUserAddress.province}</td>
				<td>${sysUserAddress.city}</td>
				<td>${sysUserAddress.area}</td>
				<td>${sysUserAddress.address}</td>
				<td>${sysUserAddress.coded}</td>
				<td>${sysUserAddress.createDate}</td>
			<!-- 
				<td><a href="${ctx}/sys/sysUserAddress/form?id=${sysUserAddress.id}">${sysUserAddress.name}</a></td>
			-->			
				<shiro:hasPermission name="sys:sysUserAddress:edit"><td>
    				<a href="${ctx}/sys/sysUserAddress/form?id=${sysUserAddress.id}">修改</a>
					<a href="${ctx}/sys/sysUserAddress/delete?id=${sysUserAddress.id}" onclick="return confirmx('确认要删除该收获地址吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
