<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>健康档案管理</title>
<meta name="decorator" content="default"/>
<script type="text/javascript">
$(document).ready(function() {
	showDiv(1);
});
//切换视图
function showDiv(value){
	for(var i = 1; i<4;i++){
		$("#healthArchives"+i).removeClass().addClass("btn");
		$("#showhealthArchives"+i).hide();
	}
	$("#healthArchives"+value).removeClass().addClass("btn active");
	$("#showhealthArchives"+value).show();
}
function assessPreview(){
	$("#showActive").hide();
	$("#showSubmit").hide();
	window.print();
	$("#showActive").show();
	$("#showSubmit").show();
}

function exportAssessExcel(){
	$("#inputForm").attr("action","${ctx}/healtharchives/healthArchives/exportAssessExcel").submit();
	return false;
}
function jumpUrl(url){
	$("#inputForm").attr("action",url).submit();
	return false;
}
//添加评估记录
function addAssess(){
	top.$.jBox.open("iframe:${ctx}/healtharchives/healthAssess/form?archivesId=${healthArchives.id}", "添加评估记录", 400, 450, {
		buttons:{"确定":"ok","关闭":true}, submit:function(v, h, f){
			if (v=="ok"){
				var fromdata = h.find("iframe")[0].contentWindow.$("#inputForm");
				if(fromdata.valid()){
					$.ajax({
				        cache: true,
				        type: "POST",
				        url:"${ctx}/healtharchives/healthAssess/saveBean",
				        data:fromdata.serialize(),
				        async: false,
				        error: function(request) {
				            alert("Connection error");
				        },
				        success: function(data) {
				        	var obj = eval("("+data+")");
				        	var healthAssess = eval("("+obj.healthAssess+")");
				        	var str = "<tr id='"+healthAssess.id+"'><td>"+healthAssess.typeNm+"</td><td>"+healthAssess.questNm+"</td>"+
				        	"<td>"+healthAssess.gradeNm+"</td><td>"+healthAssess.score+"</td><td>"+healthAssess.discribe+"</td><td>"+healthAssess.createDate+"</td>"+
				        	"<td><a onclick=\"updateAssess('"+healthAssess.id+"')\">修改</a>　<a onclick=\"deleteAssess('"+healthAssess.id+"')\">删除</a>	</td></tr>";
				        	$('#assessTable').append(str);
				        	alert(obj.message);
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
//修改评估记录
function updateAssess(healthAssessId){
	top.$.jBox.open("iframe:${ctx}/healtharchives/healthAssess/form?id="+healthAssessId+"&archivesId=${healthArchives.id}", "修改评估记录", 400, 450, {
		buttons:{"确定":"ok","关闭":true}, submit:function(v, h, f){
			if (v=="ok"){
				var fromdata = h.find("iframe")[0].contentWindow.$("#inputForm");
				if(fromdata.valid()){
					$.ajax({
				        cache: true,
				        type: "POST",
				        url:"${ctx}/healtharchives/healthAssess/saveBean",
				        data:fromdata.serialize(),
				        async: false,
				        error: function(request) {
				            alert("Connection error");
				        },
				        success: function(data) {
				        	var obj = eval("("+data+")");
				        	var healthAssess = eval("("+obj.healthAssess+")");
				        	$("#"+healthAssessId).remove();
				        	var str = "<tr id='"+healthAssess.id+"'><td>"+healthAssess.typeNm+"</td><td>"+healthAssess.questNm+"</td>"+
				        	"<td>"+healthAssess.gradeNm+"</td><td>"+healthAssess.score+"</td><td>"+healthAssess.discribe+"</td><td>"+healthAssess.createDate+"</td>"+
				        	"<td><a onclick=\"updateAssess('"+healthAssess.id+"')\">修改</a>　<a onclick=\"deleteAssess('"+healthAssess.id+"')\">删除</a>	</td></tr>";
				        	$('#assessTable').append(str);
				        	alert(obj.message);
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
//删除评估记录
function deleteAssess(healthAssessId){
	if(confirm("确定要删除该评估记录吗？")){
		$.ajax({
	        cache: true,
	        type: "POST",
	        url: "${ctx}/healtharchives/healthAssess/deleteById?id="+healthAssessId,
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	var obj = eval("("+data+")");
	            alert(obj.message);
	            $("#"+healthAssessId).remove();
	        }
	    }); 
	}
}

//添加健康建议
function addReport(){
	top.$.jBox.open("iframe:${ctx}/healtharchives/assessReport/form?archivesId=${healthArchives.id}", "添加健康建议", 400, 300, {
		buttons:{"确定":"ok","关闭":true}, submit:function(v, h, f){
			if (v=="ok"){
				var fromdata = h.find("iframe")[0].contentWindow.$("#inputForm");
				if(fromdata.valid()){
					$.ajax({
				        cache: true,
				        type: "POST",
				        url:"${ctx}/healtharchives/assessReport/saveBean",
				        data:fromdata.serialize(),
				        async: false,
				        error: function(request) {
				            alert("Connection error");
				        },
				        success: function(data) {
				        	var obj = eval("("+data+")");
				        	var assessReport = eval("("+obj.assessReport+")");
				        	var str = "<tr id='"+assessReport.id+"'><td>"+assessReport.content+"</td><td>"+assessReport.doctorNm+"</td>"+
				        	"<td>"+assessReport.createDate+"</td>"+
				        	"<td><a onclick=\"updateReport('"+assessReport.id+"')\">修改</a>　<a onclick=\"deleteReport('"+assessReport.id+"')\">删除</a>	</td></tr>";
				        	$('#reportTable').append(str);
				        	alert(obj.message);
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
//修改评估记录
function updateReport(reportId){
	top.$.jBox.open("iframe:${ctx}/healtharchives/assessReport/form?id="+reportId+"&archivesId=${healthArchives.id}", "修改健康建议", 400, 300, {
		buttons:{"确定":"ok","关闭":true}, submit:function(v, h, f){
			if (v=="ok"){
				var fromdata = h.find("iframe")[0].contentWindow.$("#inputForm");
				if(fromdata.valid()){
					$.ajax({
				        cache: true,
				        type: "POST",
				        url:"${ctx}/healtharchives/assessReport/saveBean",
				        data:fromdata.serialize(),
				        async: false,
				        error: function(request) {
				            alert("Connection error");
				        },
				        success: function(data) {
				        	var obj = eval("("+data+")");
				        	var assessReport = eval("("+obj.assessReport+")");
				        	$("#"+reportId).remove();
				        	var str = "<tr id='"+assessReport.id+"'><td>"+assessReport.content+"</td><td>"+assessReport.doctorNm+"</td>"+
				        	"<td>"+assessReport.createDate+"</td>"+
				        	"<td><a onclick=\"updateReport('"+assessReport.id+"')\">修改</a>　<a onclick=\"deleteReport('"+assessReport.id+"')\">删除</a>	</td></tr>";
				        	$('#reportTable').append(str);
				        	alert(obj.message);
				        	
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
//删除评估记录
function deleteReport(reportId){
	if(confirm("确定要删除该评估记录吗？")){
		$.ajax({
	        cache: true,
	        type: "POST",
	        url: "${ctx}/healtharchives/assessReport/deleteById?id="+reportId,
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	var obj = eval("("+data+")");
	            alert(obj.message);
	            $("#"+reportId).remove();
	        }
	    }); 
	}
}
</script>
<style type="text/css">
#showSubmit{
text-align: center;
}
</style>
</head>
<body>
	<br/>
	<form:form id="inputForm" modelAttribute="healthArchives" action="${ctx}/healtharchives/healthArchives/find" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group" id="showActive" style="border-bottom: 2px solid #93BAB6">
			<label class="control-label" for="hospitalNumber"></label>
			<input id="healthArchives1" class="btn active" type="button" onclick="showDiv(1)" value="基本信息"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthArchives2" class="btn" type="button" onclick="showDiv(2)" value="评估记录"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthArchives3" class="btn" type="button" onclick="showDiv(3)" value="手动记录"/>
		</div>
		<div id="showhealthArchives1">
			<jsp:include page="healthArchivesInfo.jsp" /> 
		</div>
		<div id="showhealthArchives2">
			<jsp:include page="healthArchivesInfo1.jsp" /> 
		</div>
		
		<%-- <div class="infoTitle">基本信息</div>
		<div class="control-group">		
			<label class="control-label" for="photo">头像：</label>
   			<div id="imgContent" style="text-align: center;">
   				<tags:printImg  defaultUrl="/static/images/archives.png" imgOriUrl="${healthArchives.photo}" imgUrl="${healthArchives.photo}" width="100" height="90" />
   			</div>		
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="fullNm">姓名：</label>${healthArchives.fullNm}
			</div>
			
			<div class="from-info">		
				<label class="control-label" for="calf">小腿围/CM：</label>${healthArchives.calf}	
				
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="hospitalizationNumber">住院号：</label>${healthArchives.hospitalizationNumber}	
			</div>
			<div class="from-info">	
				<label class="control-label" for="bedNumber">床号：</label>${healthArchives.bedNumber}	
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">		
				<label class="control-label" for="sex">性别：</label>	${healthArchives.sex}	
			</div>
			
			<div class="from-info">
				<label class="control-label" for="height">身高/CM：</label>${healthArchives.height}	
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">			
				<label class="control-label" >身份证号：</label>${healthArchives.idCard}	
			</div>
			<div class="from-info">			
				<label class="control-label">出生日期：</label><fmt:formatDate value="${healthArchives.birthDate}" pattern="yyyy-MM-dd"/>
			</div>
		</div>
		
		<div class="control-group">
			<div class="from-info">		
				<label class="control-label" for="occupation">职业：</label>	${healthArchives.occupation}	
			</div>
			
			<div class="from-info">
				<label class="control-label" for="weight">体重/KG：</label>${healthArchives.weight}	
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="medicalType">医保类型：</label>	${fns:getDictLabel(healthArchives.medicalType, 'medical_type', '无')}		
			</div>
			
			<div class="from-info">
				<label class="control-label" for="degree">文化程度：</label>${fns:getDictLabel(healthArchives.degree, 'hn_culture', '无')}	
			</div>
		</div>
		
		<div class="control-group">
			<div class="from-info">
				<label class="control-label" for="state">状态：</label>${fns:getDictLabel(healthArchives.state, 'archive_state', '无')}
			</div>
		
			<div class="from-info">		
				<label class="control-label" for="contact">家属联系方式：</label>${healthArchives.contact}		
			</div>
		</div>
		
		<div class="control-group">
			<div class="from-info">		
				<label class="control-label" for="healthRisk">风险：</label>${healthArchives.healthRisk}	
			</div>
		</div>
		<div id="hideAssessTitle" class="infoTitle">评估记录</div>
		<div id="hideAssessDiv" class="control-group">
			<label>时间段 ：</label><input id="startDate" name="startDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate" value="${startDate}"
						 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,maxDate:'#F{$dp.$D(\'endDate\')}'});" />
			- <input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate" value="${endDate}" 
						 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,minDate:'#F{$dp.$D(\'startDate\')}'});" />
			&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查 询"/>
			<!-- &nbsp;<input id="btnSubmit" class="btn btn-primary" type="button" onclick="assessPreview()" value="打 印"/> -->
			<!-- &nbsp;<input id="btnSubmit" class="btn btn-primary" type="button" onclick="exportAssessExcel()" value="导出EXCEL"/> -->
		</div>
		<div id="hideAssessTable" class="control-group">
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead><tr>
					<th>序号</th>
					<th>评估人</th>
					<th>评估类别</th>
					<th>评估项目</th>
					<th>评估分数</th>
					<th>评估结果</th>
					<th>评估时间</th>
				</tr></thead>
				<tbody>
				<c:forEach items="${assessList}" var="assess" varStatus="status">
					<tr>			
						<td>${status.count}</td>
						<td>${assess.doctorNm}</td>
						<td>${assess.typeNm}</td>
						<td>${assess.questNm}</td>
						<td>${assess.score}</td>
						<td>${assess.gradeNm}</td>
						<td>${assess.createDate}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div> 

		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
		--%>
	</form:form>
	<div id="showhealthArchives3">
		<jsp:include page="healthArchivesInfo2.jsp" /> 
	</div>
	<div class="form-actions" id="showSubmit">
		<input id="btnSubmit" class="btn btn-primary" type="button" onclick="assessPreview()" value="打 印"/>
		<!-- &nbsp;<input id="btnSubmit" class="btn btn-primary" type="button" onclick="exportAssessExcel()" value="导出EXCEL"/> -->
		&nbsp;<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</body>
</html>
