<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>查看</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#infoListControl").load("${ctx}/plan/planExecuteRecord/departmentExePlanRecordList?departmentId=${departmentId}");
		});
		 function preview(){
			 var headstr = "<html><head><title></title></head><div class='infoTitle'>任务清单</div><body>";
	        	var footstr = "</body></html>";
	        	var printData =$("#infoListControl").html();
	        	var oldstr = document.body.innerHTML; 
	        	document.body.innerHTML = headstr+printData+footstr; 
	        	window.print(); 
	        	document.body.innerHTML = oldstr; 
		}
		 function page(n,s){
				$("#infoListControl").load("${ctx}/plan/planExecuteRecord/departmentExePlanRecordList?departmentId=${departmentId}&pageNo="+n+"&pageSize="+s);
	        	return false;
	        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/plan/serviceUserRoster/todayTask">当日任务</a></li>
		<li class="active"><a href="${ctx}/plan/serviceUserRoster/todayTaskInfo?departmentId=${departmentId}">查看</a></li>
	</ul>
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
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="todayTaskVO" varStatus="status">
			<tr class='todayTask${todayTaskVO.departmentId}'>			
				<td>${status.count}</td>
				<c:if test="${status.count==1}">
					<td rowspan="${fn:length(page.list) }" style="vertical-align:middle;text-align:center;">${todayTaskVO.officeName}</td>
				<td rowspan="${fn:length(page.list) }" style="vertical-align:middle;text-align:center;">${todayTaskVO.departmentName}</td>
				</c:if>
				<td>${todayTaskVO.quartersName}</td>
				<td>${todayTaskVO.serviceUserName}</td>
				<td><fmt:formatDate value="${todayTaskVO.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${todayTaskVO.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="infoTitle">任务清单</div>
	<div class="control-group">
		<div class="from-info" id="infoListControl">
		</div>
	</div>
	<div class="form-actions">
		<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview()"/>
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</body>
</html>
