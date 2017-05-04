<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>老人计划</title>
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
        $("body").keydown(function() {
            if (event.keyCode == "13") {//keyCode=13是回车键
                $('#btnSubmit').click();
            }
        });
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/plan/planExecuteRecord/elderPlanlist">老人计划</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="elderPlanVO" action="${ctx}/plan/planExecuteRecord/elderPlanlist" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>老人姓名 ：</label><form:input path="elderName" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<label>住院号 ：</label><form:input path="hospitalizationNumber" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<label>病区 ：</label><form:input path="inpatientNm" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>		
			<th>住院号</th>
			<th>病区</th>
			<th>老人姓名</th>
			<th>年龄</th>
			<th>过期未服务</th>
			<th>过期未结束</th>
			<th>已完成</th>
			<th>待服务</th>
			<th>服务总数</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="elderPlanVO" varStatus="status">
			<tr class='roster${status.count}'>			
				<td>${status.count}</td>
				<td>${elderPlanVO.hospitalizationNumber }</td>
				<td>${elderPlanVO.inpatientNm }</td>
				<td>${elderPlanVO.elderName }</td>
				<td>${elderPlanVO.age }</td>
				<td>${elderPlanVO.expiredServiceCount }</td>
				<td>${elderPlanVO.notExpiredCount }</td>
				<td>${elderPlanVO.completedCount }</td>
				<td>${elderPlanVO.exeCount }</td>
				<td>${elderPlanVO.totalCount }</td>
				<td><a href="${ctx}/plan/planExecuteRecord/elderPlanInfo?id=${elderPlanVO.id}">服务明细</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
