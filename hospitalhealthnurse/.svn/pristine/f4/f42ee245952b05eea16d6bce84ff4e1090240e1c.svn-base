<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医生信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			var departmentId = $("#departmentId").val();
			if(departmentId != null && departmentId != ""){
				$("#showquarters").show();
			}
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
	<form:form id="searchForm" modelAttribute="serviceUserVO" action="${ctx}/serviceorg/serviceUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
		<label>人员姓名 ：</label><form:input path="name" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}"/>
		<label>科室 ：</label>
		<tags:treeselect id="department" name="departmentId" parentId="officeId" value="${serviceUserVO.departmentId}" labelName="departmentNm" labelValue="${serviceUserVO.departmentNm}" 
				title="科室" url="/serviceorg/department/departmentDataByOfficeId" notAllowSelectParent="true" cssClass="required" cssStyle="width:125px;" allowClear="true" changeQuarters="true" onshow="true"/>
		<span id="showquarters" style="display: none;">
			<label>岗位 ：</label>
			<tags:treeselect id="quarters" name="quartersId" parentId="departmentId" value="${serviceUserVO.quartersId}" labelName="quartersNm"  labelValue="${serviceUserVO.quartersNm}" 
				 	title="岗位" url="/serviceorg/quarters/treeData" cssStyle="width:125px;" cssClass="required"></tags:treeselect>
		</span>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<a href="${ctx}/serviceorg/serviceUser/form"><input class="btn btn-yellow" type="button" value="新增服务人员"/></a>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>		
			<th>人员姓名</th>
			<th>所属机构</th>
			<th>所在科室</th>
			<th>岗位</th>
			<th>工号</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="serviceUser" varStatus="status">
			<tr>			
				<td>${status.count}</td>
				<td>${serviceUser.name}</td>
				<td>${serviceUser.officeNm}</td>
				<td>${serviceUser.departmentNm}</td>
				<td>${serviceUser.quartersNm}</td>
				<td>${serviceUser.jobNumber}</td>
				<td>
    				<a href="${ctx}/serviceorg/serviceUser/form?id=${serviceUser.id}">修改</a>
					<a href="${ctx}/serviceorg/serviceUser/delete?id=${serviceUser.id}" onclick="return confirmx('确认要删除该医生信息吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
