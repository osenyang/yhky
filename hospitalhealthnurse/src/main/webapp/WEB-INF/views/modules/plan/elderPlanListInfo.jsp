<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>老人计划详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var title="今日计划";
		$(document).ready(function() {
			 $("#menuDiv .btn").click(function(){
			    	$("#menuDiv .btn").each(function(){
			    		$(this).removeClass("selected");
			    	}); 
			        $(this).addClass("selected");  
			    }); 
			$("#todayPlanControl").load("${ctx}/plan/planExecuteRecord/todayElderPlans?archivesId=${elderPlanVO.id}");
			$("#historyPlanControl").load("${ctx}/plan/planExecuteRecord/historyElderPlans?archivesId=${elderPlanVO.id}");
		});
		function page(n,s){
			if(title=="今日计划"){
				$("#todayPlanControl").load("${ctx}/plan/planExecuteRecord/todayElderPlans?archivesId=${elderPlanVO.id}&pageNo="+n+"&pageSize="+s);
			}else{
				$("#historyPlanControl").load("${ctx}/plan/planExecuteRecord/historyElderPlans?archivesId=${elderPlanVO.id}&pageNo="+n+"&pageSize="+s);
			}
	     }
	    function query(){
			$("#pageNo").val(1);
			$("#searchForm").submit();
	    	return false;
	    }
	    function changeDiv(index){
			if(index=="todayPlanControl"){
				title="今日计划";
				$("#todayPlanControl").show();
				$("#historyPlanControl").hide();
			}else if(index=="historyPlanControl"){
				title="历史计划";
				$("#todayPlanControl").hide();
				$("#historyPlanControl").show();
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
        	top.$.jBox.confirm("确认要导出计划数据吗？","系统提示",function(v,h,f){
				if(v == "ok"){
					var url="${ctx}/plan/planExecuteRecord/elderElderExportExcel?archivesId=${elderPlanVO.id}&elderName=${elderPlanVO.elderName}";
					if(title=="今日计划"){
						url+="&type=0";
					}else{
						url+="&type=1";
					}
					location.href =url;
				}
			},{buttonsFocus:1});
			top.$('.jbox-body .jbox-icon').css('top','55px');
        }
	    function doRecord(id){
			top.$.jBox.open("iframe:${ctx}/plan/planExecuteRecord/form?id="+id, "完善历史计划项目", 400, 300, {
				buttons:{"确定":"ok","关闭":true}, submit:function(v, h, f){
					if (v=="ok"){
						var fromdata = h.find("iframe")[0].contentWindow.$("#inputForm");
						if(fromdata.valid()){
							$.ajax({
						        cache: true,
						        type: "POST",
						        url:"${ctx}/plan/planExecuteRecord/doPlan",
						        data:fromdata.serialize(),
						        async: false,
						        error: function(request) {
						            alert("Connection error");
						        },
						        success: function(data) {
						        	var obj = eval("("+data+")");
						        	alert(obj.message);
						        	if(obj.message=="操作成功"){
						        		$("#historyRecord_start"+obj.id).html(obj.startTime);
							        	$("#historyRecord_stop"+obj.id).html(obj.stopTime);
							        	if(obj.state==0){
							        		$("#historyRecord_state"+obj.id).html("待执行");
							        	}else if(obj.state==1){
							        		$("#historyRecord_state"+obj.id).html("准时执行");
							        	}else if(obj.state==2){
							        		$("#historyRecord_state"+obj.id).html("延迟执行");
							        	}
							        	$("#historyRecord_do"+obj.id).html("<a href='${ctx}/plan/planExecuteRecord/planExeRecordInfo?id='"+obj.id+"'>详情</a>");
						        	}
						        }
						    }); 
						}else{
							return false;
						}
					}
				}, loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
				}
			});
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
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/plan/planExecuteRecord/elderPlanlist">老人计划</a></li>
		<li class="active"><a href="${ctx}/plan/planExecuteRecord/elderPlanInfo?id=${elderPlanVO.id}">服务明细</a></li>
	</ul><br/>
	<div class="form-horizontal" id="infoControl">
		<tags:message content="${message}"/>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">老人姓名:</label><label class="lbl">${elderPlanVO.elderName}</label>
			</div>
			<div class="from-info">	
				<label class="control-label">住院号:</label><label class="lbl">${elderPlanVO.hospitalizationNumber}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info">	
				<label class="control-label">性         别:</label><label class="lbl">${elderPlanVO.sex}</label>
			</div>
			<div class="from-info">	
				<label class="control-label">执行进度:</label><label class="lbl">
				<fmt:formatNumber type="percent" minFractionDigits="2" value="${elderPlanVO.completedCount/elderPlanVO.totalCount}" />
				（已完成${elderPlanVO.completedCount}，服务总数${elderPlanVO.totalCount}）</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info">	
				<label class="control-label">年          龄:</label><label class="lbl">${elderPlanVO.age}</label>
			</div>
			
		</div>
		<div class="infoTitle" id="menuDiv">
			<input class="btn selected" type="button" value="今日计划" onclick="changeDiv('todayPlanControl')">
			<input class="btn" type="button" value="历史计划" onclick="changeDiv('historyPlanControl')">
		</div>
		<div class="control-group">
			<div class=""  id="todayPlanControl">
			</div>
			<div class="" id="historyPlanControl" style="display:none;">
			</div>
		</div>
		<!-- <div class="infoTitle">历史计划</div> -->
		<div class="form-actions">
			<input id="btnPrint" class="btn" type="button" value="导出" onclick="exportExcel()"/>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</div>
	
</body>
</html>
