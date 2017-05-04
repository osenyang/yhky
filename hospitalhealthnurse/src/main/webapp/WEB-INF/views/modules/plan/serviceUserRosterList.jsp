<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人员排班</title>
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
        function rosterPreview(printId,officeName){
        	var headstr = "<html><head><title></title></head><body><table id='contentTable' class='table table-striped table-bordered table-condensed'>";
        	headstr+="<thead><tr><th>机构名称</th><th>排班序号</th><th>科室</th><th>岗位</th><th>值班人</th><th>创建时间</th><th>上班时间</th></tr></thead><tbody>"; 
        	var footstr = "</tbody></table></body>";
        	var printData ="";
        	var arr = $("."+printId);
			for(var i=0;i<arr.length;i++)
			{
				if(i==0){
					printData+="<tr><td rowspan='"+arr.length+"'  style='vertical-align:middle;text-align:center;'>"+officeName+"</td>"+$(arr[i]).html()+"</tr>";
				}else{
					printData+="<tr>"+$(arr[i]).html()+"</tr>";
				}
			}
        	var oldstr = document.body.innerHTML; 
        	document.body.innerHTML = headstr+printData+footstr; 
        	$(".printHide").hide();
        	window.print(); 
        	$(".printHide").show();
        	document.body.innerHTML = oldstr; 
		}
        function exportExcel(exeSerialNumber){
        	top.$.jBox.confirm("确认要导出排班数据吗？","系统提示",function(v,h,f){
				if(v == "ok"){
					$("#searchForm").attr("action","${ctx}/plan/serviceUserRoster/exportExcel?exeSerialNumber="+exeSerialNumber).submit();
					$("#searchForm").attr("action","${ctx}/plan/serviceUserRoster");
				}
			},{buttonsFocus:1});
			top.$('.jbox-body .jbox-icon').css('top','55px');
        }
        $("body").keydown(function() {
            if (event.keyCode == "13") {//keyCode=13是回车键
                $('#btnSubmit').click();
            }
        });
	</script>
</head>
<body>
	<form:form id="searchForm" modelAttribute="serviceUserRosterVO" action="${ctx}/plan/serviceUserRoster/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>值班人 ：</label><form:input path="serviceUserName" htmlEscape="false" maxlength="50" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}"/>
		<label>科室 ：</label>
		<tags:treeselect id="department" name="departmentId" value="${serviceUserRosterVO.departmentId}" labelName="departmentName" labelValue="${serviceUserRosterVO.departmentName}" 
						title="科室" url="/serviceorg/department/departmentData" notAllowSelectParent="true" cssClass="required" cssStyle="width:125px;" allowClear="true"/>
	   <label>排班序号 ：</label><form:input path="serialNumber" htmlEscape="false" maxlength="50" class="input-small"  onkeydown="if(event.keyCode==13){query();return false;}"/>
	  </p>
	   <label>时间范围 ：</label>
	   <input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" pattern=""yyyy-MM-dd HH:mm"
			  	onclick="WdatePicker({dateFmt:'yyyy-MM-dd H:mm',isShowClear:true});"  
			  	value="<fmt:formatDate value='${serviceUserRosterVO.beginDate}' pattern="yyyy-MM-dd HH:mm"/>"  onkeydown="if(event.keyCode==13){query();return false;}"/>
			  	~
	  	<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" pattern="yyyy-MM-dd HH:mm"
			  	onclick="WdatePicker({dateFmt:'yyyy-MM-dd H:mm',isShowClear:true});"  
			  	value="<fmt:formatDate value='${serviceUserRosterVO.endDate}' pattern="yyyy-MM-dd HH:mm"/>"  onkeydown="if(event.keyCode==13){query();return false;}"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query();" value="查询"/>
		<a href="${ctx}/plan/serviceUserRoster/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="排班登记"/></a>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>		
			<th>机构名称</th>
			<th>排班序号</th>
			<th>科室</th>
			<th>岗位</th>
			<th>值班人</th>
			<th>上班时间</th>
			<th>下班时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="serviceUserRoster" varStatus="status">
			<tr class='roster${fn:substringAfter(serviceUserRoster.serialNumber, "_")}'>			
				<td class='printHide'>${status.count}</td>
				<c:if test="${serviceUserRoster.officeRowspan>0}">
					<td class='printHide' rowspan="${serviceUserRoster.officeRowspan}" style="vertical-align:middle;text-align:center;">${serviceUserRoster.officeName}</td>
				</c:if>
				<c:if test="${serviceUserRoster.serialNumberRowspan>0}">
					<td rowspan="${serviceUserRoster.serialNumberRowspan}" style="vertical-align:middle;text-align:center;">${fn:substringAfter(serviceUserRoster.serialNumber, "_")}</td>
				</c:if>
				<td>${serviceUserRoster.departmentName}</td>
				<td>${serviceUserRoster.quartersName}</td>
				<td>${serviceUserRoster.serviceUserName}</td>
				<td><fmt:formatDate value="${serviceUserRoster.beginDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td><fmt:formatDate value="${serviceUserRoster.endDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<c:if test="${serviceUserRoster.serialNumberRowspan>0}">
					<td class='printHide' rowspan="${serviceUserRoster.serialNumberRowspan}" style="vertical-align:middle;text-align:center;">
	    				<a href="${ctx}/plan/serviceUserRoster/form?id=${serviceUserRoster.id}">编辑</a>
	    				<!-- <a href="javascript:void(0)"  onclick="rosterPreview('roster${fn:substringAfter(serviceUserRoster.serialNumber, "_")}','${serviceUserRoster.officeName}')">打印</a> -->
						<a href="javascript:void(0)" onclick="exportExcel('${serviceUserRoster.serialNumber}')">导出</a>
						<a href="${ctx}/plan/serviceUserRoster/deleteBySerialNb?serialNumber=${serviceUserRoster.serialNumber}" onclick="return confirmx('确认要删除该排班信息吗？', this.href)">删除</a>
				</c:if>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	<div class="printInfoDiv"></div>
</body>
</html>
