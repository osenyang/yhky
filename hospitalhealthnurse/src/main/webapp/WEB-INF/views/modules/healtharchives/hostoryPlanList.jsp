<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>历史方案管理</title>
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
	<form:form id="searchForm" modelAttribute="hostoryPlan" action="${ctx}/healtharchives/hostoryPlan/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="healtharchives:hostoryPlan:edit"><a href="${ctx}/healtharchives/hostoryPlan/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增历史方案"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>计划类型</th>
			<th>计划类型</th>
			<th>创建者</th>
			<th>创建日期</th>
		<shiro:hasPermission name="healtharchives:hostoryPlan:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="hostoryPlan">
			<tr>			
				<td>${hostoryPlan.planId}</td>
				<td>${hostoryPlan.planType}</td>
				<td>${hostoryPlan.createBy}</td>
				<td>${hostoryPlan.createDate}</td>
			<!-- 
				<td><a href="${ctx}/healtharchives/hostoryPlan/form?id=${hostoryPlan.id}">${hostoryPlan.name}</a></td>
			-->			
				<shiro:hasPermission name="healtharchives:hostoryPlan:edit"><td>
    				<a href="${ctx}/healtharchives/hostoryPlan/form?id=${hostoryPlan.id}">修改</a>
					<a href="${ctx}/healtharchives/hostoryPlan/delete?id=${hostoryPlan.id}" onclick="return confirmx('确认要删除该历史方案吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
