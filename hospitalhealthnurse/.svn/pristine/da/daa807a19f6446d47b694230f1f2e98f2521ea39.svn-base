<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>健康档案管理</title>
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
	<form:form id="searchForm" modelAttribute="healthArchives" action="${ctx}/healtharchives/healthArchives/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div>
			<label>老人姓名 ：</label><form:input path="fullNm" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
			<label>住院号 ：</label><form:input path="hospitalizationNumber" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
			<label>状态 ：</label>
			<form:select path="state" cssClass="input-medium-select">
				<form:option value="">请选择</form:option>
				<form:options items="${fns:getDictList('archive_state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select>
			&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
			&nbsp;<a href="${ctx}/healtharchives/healthArchives/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增健康档案"/></a>
		</div>
		<div style="margin-top: 8px;">
			<label>　　床号 ：</label><form:input path="bedNumber" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
			<label>　病区 ：</label><form:input path="inpatientNm" htmlEscape="false" maxlength="50" class="input-small"/>
		</div>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>住院号</th>
			<th>床号</th>
			<th>病区</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>身份证号</th>
			<th>状态</th>
			<th>更新时间</th>
			<th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="healthArchives" varStatus="status">
			<tr>			
				<td>${status.index + 1}</td>
				<td>${healthArchives.hospitalizationNumber}</td>
				<td>${healthArchives.bedNumber}</td>
				<td>${healthArchives.inpatientNm}</td>
				<td>${healthArchives.fullNm}</td>
				<td>${healthArchives.sex}</td>
				<td>${healthArchives.age}</td>
				<td>${healthArchives.idCard}</td>
				<td>${fns:getDictLabel(healthArchives.state, 'archive_state', '无')}</td>
				<td><fmt:formatDate value="${healthArchives.updateDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>
					<c:if test="${healthArchives.state != '3'}">
						<a href="${ctx}/healtharchives/healthArchives/leave?id=${healthArchives.id}" onclick="return confirmx('确认要离院吗？', this.href)">离院</a>
					</c:if>
					<a href="${ctx}/healtharchives/healthArchives/find?id=${healthArchives.id}">查看</a>
    				<a href="${ctx}/healtharchives/healthArchives/form?id=${healthArchives.id}">修改</a>
					<c:if test="${not empty fns:getUser().jobNumber}">
					<a href="${ctx}/healtharchives/healthArchives/diagnosis?id=${healthArchives.id}">发起综合会诊</a>
					<shiro:hasPermission name="/healtharchives/healthArchives:edit"><a href="${ctx}/healtharchives/healthArchives/saveIntervene?archivesId=${healthArchives.id}">添加干预方案</a></shiro:hasPermission>
					<shiro:hasPermission name="/healtharchives/healthArchives:edit"><a href="${ctx}/healtharchives/healthArchives/delete?id=${healthArchives.id}" onclick="return confirmx('确认要删除该健康档案吗？', this.href)">删除</a></shiro:hasPermission>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
