<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关于我们管理</title>
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
	<form:form id="searchForm" modelAttribute="about" action="${ctx}/sys/about/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		<shiro:hasPermission name="sys:about:edit"><a href="${ctx}/sys/about/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="添加关于我们"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
		<shiro:hasPermission name="sys:about:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="about">
			<tr>			
			<!-- 
				<td><a href="${ctx}/sys/about/form?id=${about.id}">${about.name}</a></td>
			-->			
				<shiro:hasPermission name="sys:about:edit"><td>
    				<a href="${ctx}/sys/about/form?id=${about.id}">修改</a>
					<a href="${ctx}/sys/about/delete?id=${about.id}" onclick="return confirmx('确认要删除该关于我们吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
