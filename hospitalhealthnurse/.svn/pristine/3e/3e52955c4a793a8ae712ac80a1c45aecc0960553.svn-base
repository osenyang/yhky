<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医院管理管理</title>
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
	<form:form id="searchForm" modelAttribute="office" action="${ctx}/sys/office/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
<%-- 		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}"/> --%>
<!-- 		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/> -->
<%-- 		&nbsp;<a href="${ctx}/sys/office/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增医院"/></a> --%>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>医院名称</th>
			<th>联系人</th>
			<th>联系电话</th>
			<th>联系地址</th>
			<th>传真</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="office" varStatus="status">
			<tr>		
				<td>${status.count}</td>	
				<td>${office.name}</td>
				<td>${office.contacts}</td>
				<td>${office.mobile}</td>
				<td>${office.address}</td>
				<td>${office.fax}</td>
				<td><fmt:formatDate value="${office.createDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>
    				<a href="${ctx}/sys/office/form?id=${office.id}">修改</a>
<%-- 					<a href="${ctx}/sys/office/delete?id=${office.id}" onclick="return confirmx('确认要删除该医院管理吗？', this.href)">删除</a> --%>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<%-- 	<div class="pagination">${page}</div> --%>
</body>
</html>
