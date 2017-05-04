<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>岗位管理管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/dialog.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			merge();
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
		
    	function merge(){
			var orderIdList = new Array();
		    var j=1,k=0;
		    //获取table的行
		    var table=document.getElementById("contentTable"); 
		    var rows=table.rows; 
		    //获取ID数组
		    var orderIds = document.getElementsByName("tempId");
		    //根据ID分组
		   	for(var i =1; i<orderIds.length;i++){
		   		if(orderIds[i].value == orderIds[i-1].value){
		   			j++;
		   		}else{
		   			orderIdList[k] = j;
		   			k++;
		   			j = 1;
		   		}
		    }
		   	if(j != 1){
		   		orderIdList[k] = j;
		   	}
		   	var tdNumber = 1;
		   	for(var i in orderIdList){
		   		for(var j=tdNumber+1;j<tdNumber+orderIdList[i];j++){
		   			rows[j].removeChild(rows[j].cells[1]);
		   	  	}
		   		rows[tdNumber].cells[1].rowSpan=orderIdList[i];
		   		tdNumber += orderIdList[i];
		   	}
		}
    	 $("body").keydown(function() {
             if (event.keyCode == "13") {//keyCode=13是回车键
                 $('#btnSubmit').click();
             }
         });
	</script>
</head>
<body>
	<form:form id="searchForm" modelAttribute="quartersVO" action="${ctx}/serviceorg/quarters/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
		<label>岗位名称 ：</label><form:input path="name" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}"/>
		<label>科室 ：</label>
		<tags:treeselect id="department" name="departmentId" parentId="officeId" value="${quarters.departmentId}" labelName="departmentNm" labelValue="${quarters.departmentNm}" 
				title="科室" url="/serviceorg/department/departmentDataByOfficeId" cssStyle="width:125px;" allowClear="true" />
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		&nbsp;<a href="${ctx}/serviceorg/quarters/form"><input class="btn btn-yellow" type="button" value="新增岗位"/></a>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th style="text-align: center;display:table-cell; vertical-align:middle">序号</th>
			<th style="text-align: center;display:table-cell; vertical-align:middle">所属科室</th>
			<th style="text-align: center;display:table-cell; vertical-align:middle">岗位名称</th>
			<th style="text-align: center;display:table-cell; vertical-align:middle">创建时间</th>
			<th style="text-align: center;display:table-cell; vertical-align:middle">操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="quarters" varStatus="status">
			<tr>
				<td style="text-align: center;display:table-cell; vertical-align:middle">${status.count}<input type="hidden" name="tempId" value="${quarters.departmentId}" /></td>
				<td style="text-align: center;display:table-cell; vertical-align:middle">${quarters.departmentNm}</td>
				<td style="text-align: center;display:table-cell; vertical-align:middle">${quarters.name}</td>
				<td style="text-align: center;display:table-cell; vertical-align:middle">${quarters.createDate}</td>
				<td style="text-align: center;display:table-cell; vertical-align:middle">
    				<a href="${ctx}/serviceorg/quarters/form?id=${quarters.id}">修改</a>
					<a href="${ctx}/serviceorg/quarters/delete?id=${quarters.id}" onclick="return confirmx('确认要删除该岗位吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
