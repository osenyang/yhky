<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>科室管理管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#contentTable").treeTable({expandLevel : 5});
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
 	<form:form id="searchForm" modelAttribute="department" action="${ctx}/serviceorg/department/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
<%-- 		<label>科室名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/> --%>
<!-- 		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="submit" value="查询"/> -->
		&nbsp;<a href="${ctx}/serviceorg/department/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增科室"/></a>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>科室名称</th>
			<th>所属医院</th>
			<th>备注</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${list}" var="department">
			<tr id="${department.id}" pId="${department.parent.id ne requestScope.department.id?department.parent.id:'0'}">			
				<td><a href="${ctx}/serviceorg/department/form?id=${department.id}">${department.name}</a></td>
				<td>${department.officeNm}</td>
				<td>${department.remarks}</td>
				<td>
    				<a href="${ctx}/serviceorg/department/form?parent.id=${department.id}&officeId=${department.officeId}">添加下级科室</a>
    				<a href="${ctx}/serviceorg/department/form?id=${department.id}">修改</a>
					<a href="${ctx}/serviceorg/department/delete?id=${department.id}" onclick="return confirmx('确定要删除该科室吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
