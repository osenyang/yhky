<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务明细</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	var title="执行中";
		$(document).ready(function() {
			 $("#menuDiv .btn").click(function(){
			    	$("#menuDiv .btn").each(function(){
			    		$(this).removeClass("selected");
			    	}); 
			        $(this).addClass("selected");  
			    }); 
			$("#exePlanRecordControl").load("${ctx}/plan/planExecuteRecord/serviceUserExeServices?serviceUserId=${serviceUserExePlanRecordVO.serviceUserId}");
			$("#completedPlanRecordControl").load("${ctx}/plan/planExecuteRecord/serviceUserCompletedServices?serviceUserId=${serviceUserExePlanRecordVO.serviceUserId}");
		});
		function page(n,s){
			if(title=="执行中"){
				$("#exePlanRecordControl").load("${ctx}/plan/planExecuteRecord/serviceUserExeServices?serviceUserId=${serviceUserExePlanRecordVO.serviceUserId}&pageNo="+n+"&pageSize="+s);
			}else{
				$("#completedPlanRecordControl").load("${ctx}/plan/planExecuteRecord/serviceUserCompletedServices?serviceUserId=${serviceUserExePlanRecordVO.serviceUserId}&pageNo="+n+"&pageSize="+s);
			}
	     }
		function changeDiv(index){
			if(index=="exePlanRecordControl"){
				title="执行中";
				$("#exePlanRecordControl").show();
				$("#completedPlanRecordControl").hide();
			}else if(index=="completedPlanRecordControl"){
				title="已完成";
				$("#exePlanRecordControl").hide();
				$("#completedPlanRecordControl").show();
			}
	    	return false;
	    }
	    function preview(){
        	var menuData=$("#menuDiv").html();
        	$(".form-actions").hide();
        	$("#menuDiv").html(title);
        	window.print(); 
        	$(".form-actions").show();
        	$("#menuDiv").html(menuData);
        	 $("#menuDiv .btn").click(function(){
			    	$("#menuDiv .btn").each(function(){
			    		$(this).removeClass("selected");
			    	}); 
			        $(this).addClass("selected");  
			    }); 
		}
	    function exportExcel(){
        	top.$.jBox.confirm("确认要导出服务数据吗？","系统提示",function(v,h,f){
				if(v == "ok"){
					var url="${ctx}/plan/planExecuteRecord/sericeUserExportExcel?serviceUserId=${serviceUserExePlanRecordVO.serviceUserId}&serviceUserName=${serviceUserExePlanRecordVO.serviceUserName}";
					if(title=="执行中"){
						url+="&type=0";
					}else{
						url+="&type=1";
					}
					location.href =url;
				}
			},{buttonsFocus:1});
			top.$('.jbox-body .jbox-icon').css('top','55px');
        }
	</script>
	<style type="text/css">
	.selected{
		background: #20B496 !important;
		color: #FFFFFF !important;
	}
	</style>
</head>
<body>
<div id="msg"></div>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/plan/planExecuteRecord/serviceUserPlanList">人员计划</a></li>
		<li class="active"><a href="${ctx}/plan/planExecuteRecord/serviceUserPlanInfo?serviceUserId=${serviceUserExePlanRecordVO.serviceUserId}">服务明细</a></li>
	</ul><br/>
	<div class="form-horizontal" id="infoControl">
		<tags:message content="${message}"/>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">人员头像:</label>
				<tags:printImg defaultUrl="/static/images/archives.png" imgOriUrl="${serviceUserExePlanRecordVO.imgUrl}" imgUrl="${serviceUserExePlanRecordVO.thumbImg}" width="60" height="60" />
			</div>
			<div class="from-info">	
				<label class="control-label">岗         位:</label><label class="lbl">${serviceUserExePlanRecordVO.quartersName}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info">	
				<label class="control-label">人员姓名:</label><label class="lbl">${serviceUserExePlanRecordVO.serviceUserName}</label>
			</div>
			<div class="from-info">	
				<label class="control-label">所在科室:</label><label class="lbl">${serviceUserExePlanRecordVO.departmentName}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info">	
				<label class="control-label">状         态:</label><label class="lbl">
				<c:if test="${serviceUserExePlanRecordVO.exeCount > 0 }"><font color='red'>执行服务中</font></c:if>
				<c:if test="${serviceUserExePlanRecordVO.exeCount == 0 }">空闲中</c:if></label>
			</div>
		</div>
		<div class="infoTitle" id="menuDiv">
			<input class="btn selected" type="button" value="执行中" onclick="changeDiv('exePlanRecordControl')">
			<input class="btn" type="button" value="已完成" onclick="changeDiv('completedPlanRecordControl')">
		</div>
		<div class="control-group">
			<div class="" id="exePlanRecordControl">
			</div>
			<div class="" id="completedPlanRecordControl" style="display:none;">
			</div>
		</div>
		<div class="form-actions">
			<input id="btnPrint" class="btn" type="button" value="导出" onclick="exportExcel()"/>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</div>
	
</body>
</html>
