<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>当日任务</title>
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
        function taskPreview(printId){
        	var headstr = "<html><head><title></title></head><body><table id='contentTable' class='table table-striped table-bordered table-condensed'>";
        	headstr+="<thead><tr><th>机构名称</th><th>科室</th><th>岗位</th><th>值班人</th><th>上班时间</th><th>下班时间</th></tr></thead><tbody>"; 
        	var footstr = "</tbody></table></body>";
        	var printData ="";
        	var arr = $("."+printId);
			for(var i=0;i<arr.length;i++)
			{
				printData+="<tr>"+$(arr[i]).html()+"</tr>";
			}
        	var oldstr = document.body.innerHTML; 
        	document.body.innerHTML = headstr+printData+footstr; 
        	$(".printHide").hide();
        	window.print(); 
        	$(".printHide").show();
        	document.body.innerHTML = oldstr; 
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
		<li class="active"><a href="${ctx}/plan/serviceUserRoster/todayTask">当日任务</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="todayTaskVO" action="${ctx}/plan/serviceUserRoster/todayTask" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>值班人 ：</label><form:input path="serviceUserName" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>		
			<th>机构名称</th>
			<th>科室</th>
			<th>岗位</th>
			<th>值班人</th>
			<th>上班时间</th>
			<th>下班时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:set var="departmentId" value="${todayTaskVO.departmentId }"></c:set>
		<c:forEach items="${page.list}" var="todayTaskVO" varStatus="status">
			<tr class='todayTask${todayTaskVO.departmentId}'>			
				<td class='printHide'>${status.count}</td>
				<c:if test="${todayTaskVO.officeRowspan>0}">
					<td rowspan="${todayTaskVO.officeRowspan}" style="vertical-align:middle;text-align:center;">${todayTaskVO.officeName}</td>
				</c:if>
				<c:if test="${todayTaskVO.departmentRowspan>0}">
					<td rowspan="${todayTaskVO.departmentRowspan}" style="vertical-align:middle;text-align:center;">${todayTaskVO.departmentName}</td>
				</c:if>
				<td>${todayTaskVO.quartersName}</td>
				<td>${todayTaskVO.serviceUserName}</td>
				<td><fmt:formatDate value="${todayTaskVO.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${todayTaskVO.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<c:if test="${todayTaskVO.departmentRowspan>0}">
					<td class='printHide' rowspan="${todayTaskVO.departmentRowspan}" style="vertical-align:middle;text-align:center;">
	    				<a href="${ctx}/plan/serviceUserRoster/todayTaskInfo?departmentId=${todayTaskVO.departmentId}">查看</a>
	    				<a href="javascript:void(0)"  onclick="taskPreview('todayTask${todayTaskVO.departmentId}')">打印任务</a>
					</td>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
