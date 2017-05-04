<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>健康记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			window.parent.window.document.getElementById("menuFrame").contentWindow.changeClick("健康记录"); 
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
	<form:form id="searchForm" modelAttribute="healthRecordVO" action="${ctx}/healtharchives/healthRecord/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>老人姓名 ：</label><form:input path="fullNm" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
		&nbsp;<label>住院号 ：</label><form:input path="hospitalizationNumber" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
		&nbsp;<label>床号 ：</label><form:input path="bedNumber" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
		&nbsp;<label>病区 ：</label><form:input path="inpatientNm" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<a href="${ctx}/healtharchives/healthRecord/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增记录"/></a>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>住院号</th>
			<th>病区</th>
			<th>床号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>婚姻状况</th>
			<th>民族</th>
			<th>入住日期</th>
			<th>记录时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="healthRecord" varStatus="status">
			<tr>			
				<td>${status.count}</td>
				<td>${healthRecord.hospitalizationNumber}</td>
				<td>${healthRecord.inpatientNm}</td>
				<td>${healthRecord.bedNumber}</td>
				<td>${healthRecord.fullNm}</td>
				<td>${healthRecord.sex}</td>
				<td>${healthRecord.age}</td>
				<td>${fns:getDictLabel(healthRecord.maritalStatus,'marital_status','')}</td>
				<td>${healthRecord.nation}</td>
				<td><fmt:formatDate value="${healthRecord.arrivalDate}" type="date"/></td>
				<td><fmt:formatDate value="${healthRecord.createDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>
    				<a href="${ctx}/healtharchives/healthRecord/info?id=${healthRecord.id}">查看</a>
    				<a href="${ctx}/healtharchives/healthRecord/form?id=${healthRecord.id}">修改</a>
					<a href="${ctx}/healtharchives/healthRecord/delete?id=${healthRecord.id}" onclick="return confirmx('确认要删除该记录吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
