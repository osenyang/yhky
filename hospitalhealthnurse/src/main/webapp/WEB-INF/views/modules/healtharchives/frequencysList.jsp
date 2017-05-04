<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计划频次管理</title>
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
	<form:form id="searchForm" modelAttribute="frequencys" action="${ctx}/healtharchives/frequencys/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="healtharchives:frequencys:edit"><a href="${ctx}/healtharchives/frequencys/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增计划频次"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>干预方案主键ID</th>
			<th>计划ID</th>
			<th>频次类型（0、天,1、周）</th>
			<th>间隔时间</th>
			<th>时间数组</th>
			<th>创建时间</th>
		<shiro:hasPermission name="healtharchives:frequencys:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="frequencys">
			<tr>			
				<td>${frequencys.interveneId}</td>
				<td>${frequencys.planId}</td>
				<td>${frequencys.frequencyType}</td>
				<td>${frequencys.interval}</td>
				<td>${frequencys.dateArray}</td>
				<td>${frequencys.createDate}</td>
			<!-- 
				<td><a href="${ctx}/healtharchives/frequencys/form?id=${frequencys.id}">${frequencys.name}</a></td>
			-->			
				<shiro:hasPermission name="healtharchives:frequencys:edit"><td>
    				<a href="${ctx}/healtharchives/frequencys/form?id=${frequencys.id}">修改</a>
					<a href="${ctx}/healtharchives/frequencys/delete?id=${frequencys.id}" onclick="return confirmx('确认要删除该计划频次吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
