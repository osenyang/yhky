<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人员计划</title>
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
	<form:form id="searchForm" modelAttribute="serviceUserPlanExeRecordVO" action="${ctx}/plan/planExecuteRecord/serviceUserPlanList" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
		<label>人员姓名 ：</label><form:input path="serviceUserName" htmlEscape="false" maxlength="30" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}"/>
		<label>科室 ：</label>
		<tags:treeselect id="department" name="departmentId" parentId="officeId" value="${serviceUserPlanExeRecordVO.departmentId}" labelName="departmentName" labelValue="${serviceUserPlanExeRecordVO.departmentName}" 
			title="科室" url="/serviceorg/department/departmentDataByOfficeId" cssStyle="width:125px;" cssClass="required" allowClear="true" />
		<label>状态 ：</label>
		<form:select path="state" cssClass="input-medium-select required">
			<form:option value="-1">全部</form:option> 
			<form:option value="0">空闲中</form:option> 
			<form:option value="1">执行服务中</form:option> 
		</form:select>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>		
			<th>头像</th>
			<th>人员姓名</th>
			<th>科室</th>
			<th>岗位</th>
			<th>已完成</th>
			<th>状态</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="serviceUserPlanExeRecordVO" varStatus="status">
			<tr class='roster${status.count}'>			
				<td>${status.count}</td>
				<td><tags:printImg defaultUrl="/static/images/archives.png" imgOriUrl="${serviceUserPlanExeRecordVO.imgUrl}" imgUrl="${serviceUserPlanExeRecordVO.thumbImg}" width="60" height="60" /></td>
				<td>${serviceUserPlanExeRecordVO.serviceUserName}</td>
				<td>${serviceUserPlanExeRecordVO.departmentName}</td>
				<td>${serviceUserPlanExeRecordVO.quartersName}</td>
				<td>${serviceUserPlanExeRecordVO.completedCount}</td>
				<td>
					<c:if test="${serviceUserPlanExeRecordVO.exeCount > 0 }">执行服务中</c:if>
					<c:if test="${serviceUserPlanExeRecordVO.exeCount == 0 }">空闲中</c:if>
				</td>
				<td><a href="${ctx}/plan/planExecuteRecord/serviceUserPlanInfo?serviceUserId=${serviceUserPlanExeRecordVO.serviceUserId}">服务明细</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
