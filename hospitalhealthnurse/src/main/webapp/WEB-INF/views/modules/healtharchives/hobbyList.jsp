<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>兴趣爱好管理</title>
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
	<form:form id="searchForm" modelAttribute="hobby" action="${ctx}/healtharchives/hobby/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="healtharchives:hobby:edit"><a href="${ctx}/healtharchives/hobby/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增兴趣爱好"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>兴趣爱好</th>
			<th>兴趣爱好要求</th>
			<th>兴趣爱好(开始时间)</th>
			<th>兴趣爱好(结束时间)</th>
			<th>兴趣爱好(其他)</th>
			<th>兴趣爱好(执行人/岗位)</th>
		<shiro:hasPermission name="healtharchives:hobby:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="hobby">
			<tr>			
				<td>${hobby.hobby}</td>
				<td>${hobby.hobbyAsk}</td>
				<td>${hobby.hobbyStartTime}</td>
				<td>${hobby.hobbyEndTime}</td>
				<td>${hobby.hobbyOther}</td>
				<td>${hobby.hobbyQuartersId}</td>
			<!-- 
				<td><a href="${ctx}/healtharchives/hobby/form?id=${hobby.id}">${hobby.name}</a></td>
			-->			
				<shiro:hasPermission name="healtharchives:hobby:edit"><td>
    				<a href="${ctx}/healtharchives/hobby/form?id=${hobby.id}">修改</a>
					<a href="${ctx}/healtharchives/hobby/delete?id=${hobby.id}" onclick="return confirmx('确认要删除该兴趣爱好吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>