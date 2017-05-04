<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${functionName}管理</title>
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
	<form:form id="searchForm" modelAttribute="${className}" action="${r"${ctx}"}/${urlPrefix}/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${r"${page.pageNo}"}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${r"${page.pageSize}"}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="${permissionPrefix}:edit"><a href="${r"${ctx}"}/${urlPrefix}/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增${functionName}"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${r"${message}"}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
		<#list listFeild as map> 
			<th>${map["colContent"]}</th>
		</#list> 	
		<shiro:hasPermission name="${permissionPrefix}:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${r"${page.list}"}" var="${className}">
			<tr>			
			<#list listFeild as map> 
				<td>${"${"+className+".${map['feildNm']}}"}</td>
			</#list> 
			<!-- 
				<td><a href="${r"${ctx}"}/${urlPrefix}/form?id=${"${"+className+".id}"}">${"${"+className+".name}"}</a></td>
			-->			
				<shiro:hasPermission name="${permissionPrefix}:edit"><td>
    				<a href="${r"${ctx}"}/${urlPrefix}/form?id=${"${"+className+".id}"}">修改</a>
					<a href="${r"${ctx}"}/${urlPrefix}/delete?id=${"${"+className+".id}"}" onclick="return confirmx('确认要删除该${functionName}吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${r"${page}"}</div>
</body>
</html>
