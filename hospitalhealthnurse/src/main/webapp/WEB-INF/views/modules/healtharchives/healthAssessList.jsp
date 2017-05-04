<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>评估管理</title>
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
	<form:form id="searchForm" modelAttribute="healthAssess" action="${ctx}/healtharchives/healthAssess/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<shiro:hasPermission name="healtharchives:healthAssess:edit"><a href="${ctx}/healtharchives/healthAssess/form"><input id="btnSubmit" class="btn btn-primary" type="button" value="新增评估"/></a></shiro:hasPermission>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>档案ID</th>
			<th>评估分类</th>
			<th>评估量表</th>
			<th>评估结果</th>
			<th>评估分数</th>
			<th>评估标准</th>
			<th>创建日期</th>
			<th>删除标记</th>
		<shiro:hasPermission name="healtharchives:healthAssess:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="healthAssess">
			<tr>			
				<td>${healthAssess.archivesId}</td>
				<td>${healthAssess.typeNm}</td>
				<td>${healthAssess.questNm}</td>
				<td>${healthAssess.gradeNm}</td>
				<td>${healthAssess.score}</td>
				<td>${healthAssess.discribe}</td>
				<td>${healthAssess.createDate}</td>
				<td>${healthAssess.delFlag}</td>
			<!-- 
				<td><a href="${ctx}/healtharchives/healthAssess/form?id=${healthAssess.id}">${healthAssess.name}</a></td>
			-->			
				<shiro:hasPermission name="healtharchives:healthAssess:edit"><td>
    				<a href="${ctx}/healtharchives/healthAssess/form?id=${healthAssess.id}">修改</a>
					<a href="${ctx}/healtharchives/healthAssess/delete?id=${healthAssess.id}" onclick="return confirmx('确认要删除该评估吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
