<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>病区管理管理</title>
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
	<form:form id="searchForm" modelAttribute="healthInpatient" action="${ctx}/healtharchives/healthInpatient/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>病区名称 ：</label><form:input path="areaNm" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<a href="${ctx}/healtharchives/healthInpatient/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增病区"/></a>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>病区名称</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="healthInpatient">
			<tr>			
				<td>${healthInpatient.areaNm}</td>
				<td><fmt:formatDate value="${healthInpatient.updateDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>
    				<a href="${ctx}/healtharchives/healthInpatient/form?id=${healthInpatient.id}">修改</a>
					<a href="${ctx}/healtharchives/healthInpatient/delete?id=${healthInpatient.id}" onclick="return confirmx('确认要删除该病区管理吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
