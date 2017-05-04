<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>健康建议管理</title>
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
	<form:form id="searchForm" modelAttribute="assessReport" action="${ctx}/healtharchives/assessReport/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="healtharchives:assessReport:edit"><a href="${ctx}/healtharchives/assessReport/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增健康建议"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>档案ID</th>
			<th>医生姓名</th>
			<th>健康建议</th>
			<th>创建日期</th>
			<th>删除标记</th>
		<shiro:hasPermission name="healtharchives:assessReport:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="assessReport">
			<tr>			
				<td>${assessReport.archivesId}</td>
				<td>${assessReport.doctorNm}</td>
				<td>${assessReport.content}</td>
				<td>${assessReport.createDate}</td>
				<td>${assessReport.delFlag}</td>
			<!-- 
				<td><a href="${ctx}/healtharchives/assessReport/form?id=${assessReport.id}">${assessReport.name}</a></td>
			-->			
				<shiro:hasPermission name="healtharchives:assessReport:edit"><td>
    				<a href="${ctx}/healtharchives/assessReport/form?id=${assessReport.id}">修改</a>
					<a href="${ctx}/healtharchives/assessReport/delete?id=${assessReport.id}" onclick="return confirmx('确认要删除该健康建议吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
