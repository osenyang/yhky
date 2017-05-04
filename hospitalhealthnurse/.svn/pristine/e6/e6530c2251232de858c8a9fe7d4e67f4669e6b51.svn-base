<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>干预方案管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			window.parent.window.document.getElementById("menuFrame").contentWindow.changeClick("干预方案"); 
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
	<form:form id="searchForm" modelAttribute="interveneVO" action="${ctx}/healtharchives/intervene/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>老人姓名 ：</label><form:input path="fullNm" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
		&nbsp;<label>身份证号码 ：</label><form:input path="idCard" htmlEscape="false" maxlength="18" class="input-small card" onkeydown="if(event.keyCode==13){query();return false;}" />
		&nbsp;<label>住院号 ：</label><form:input path="hospitalizationNumber" htmlEscape="false" maxlength="10" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}"/>
		<br /><br />
		<label>　　床号 ：</label><form:input path="bedNumber" htmlEscape="false" maxlength="50" class="input-small"  onkeydown="if(event.keyCode==13){query();return false;}"/>
		&nbsp;<label>状态 ：</label>
		<form:select path="archivesState" cssClass="input-medium-select">
			<form:option value="">请选择</form:option>
			<form:options items="${fns:getDictList('archive_state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
		</form:select>
		&nbsp;<label>病区 ：</label><form:input path="inpatientNm" htmlEscape="false" maxlength="50" class="input-small"  onkeydown="if(event.keyCode==13){query();return false;}"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>住院号</th>
			<th>床号</th>
			<th>病区</th>
			<th>老人状态</th>
			<th>身份证号码</th>
			<th>更新时间</th>
			<th>状态</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="intervene" varStatus="status">
			<tr>			
				<td>${status.index+1}</td>
				<td>${intervene.fullNm}</td>
				<td>${intervene.sex}</td>
				<td>${intervene.age}</td>
				<td>${intervene.hospitalizationNumber}</td>
				<td>${intervene.bedNumber}</td>
				<td>${intervene.inpatientNm}</td>
				<td>${fns:getDictLabel(intervene.archivesState, 'archive_state', '无')}</td>
				<td>${intervene.idCard}</td>
				<td><fmt:formatDate value="${intervene.updateDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>${fns:getDictLabel(intervene.state, 'plan_state', '无')}</td>
				<td>
					<c:if test="${intervene.state == '0'}">
						<a href="${ctx}/healtharchives/intervene/form?id=${intervene.id}">设定方案</a>
						<c:if test="${not empty intervene.assessmentId || not empty intervene.careId || not empty intervene.nutritionId || not empty intervene.recoverId || not empty intervene.nurserId || not empty intervene.socialId  }">
							<a href="${ctx}/healtharchives/intervene/startState?id=${intervene.id}" onclick="return confirmx('确认要执行该干预方案吗？',this.href)">执行方案</a>
						</c:if>
					</c:if>
					<c:if test="${intervene.state == '1'}">
						<a href="${ctx}/healtharchives/intervene/pauseState?id=${intervene.id}" onclick="return confirmx('确认要暂停该干预方案吗？',this.href)">暂停</a>
						<a href="${ctx}/healtharchives/intervene/form?id=${intervene.id}">查看方案</a>
						<a href="${ctx}/healtharchives/intervene/stopState?id=${intervene.id}" onclick="return confirmx('确认要终止该干预方案吗？',this.href)">终止</a>
					</c:if>
					<c:if test="${intervene.state == '2'}">
						<a href="${ctx}/healtharchives/intervene/startState?id=${intervene.id}" onclick="return confirmx('确认要继续执行该干预方案吗？',this.href)">继续执行</a>
						<a href="${ctx}/healtharchives/intervene/form?id=${intervene.id}">修改方案</a>
					</c:if>
					<c:if test="${intervene.state == '3'}">
						<a href="${ctx}/healtharchives/intervene/form?id=${intervene.id}">查看方案</a>
					</c:if>
					<c:if test="${fns:getUser().isAdmin()}">
						<a href="${ctx}/healtharchives/intervene/delete?id=${intervene.id}" onclick="return confirmx('确认要删除该方案吗？', this.href)">删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
