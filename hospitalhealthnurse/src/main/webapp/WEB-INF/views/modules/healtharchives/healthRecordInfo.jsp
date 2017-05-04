<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>健康记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			showDiv(1);
		});
		//切换视图
		function showDiv(value){
			if(value == 1){
				$("#healthRecord"+value).removeClass().addClass("btn active");
				$("#showhealthRecord"+value).show();
				for(var i = 2; i<5;i++){
					$("#healthRecord"+i).removeClass().addClass("btn");
					$("#showhealthRecord"+i).hide();
				}
			}else if(value == 2){
				$("#healthRecord"+value).removeClass().addClass("btn active");
				$("#showhealthRecord"+value).show();
				$("#healthRecord1").removeClass().addClass("btn");
				$("#showhealthRecord1").hide();
				for(var i = 3; i<5;i++){
					$("#healthRecord"+i).removeClass().addClass("btn");
					$("#showhealthRecord"+i).hide();
				}
			}else if(value == 3){
				$("#healthRecord"+value).removeClass().addClass("btn active");
				$("#showhealthRecord"+value).show();
				for(var i = 1; i<3;i++){
					$("#healthRecord"+i).removeClass().addClass("btn");
					$("#showhealthRecord"+i).hide();
				}
				$("#healthRecord4").removeClass().addClass("btn");
				$("#showhealthRecord4").hide();
			}else{
				$("#healthRecord"+value).removeClass().addClass("btn active");
				$("#showhealthRecord"+value).show();
				for(var i = 1; i<4;i++){
					$("#healthRecord"+i).removeClass().addClass("btn");
					$("#showhealthRecord"+i).hide();
				}
			}
		}
		//打印
		function preview(){
			$("#showActive").hide();
			$("#showSubmit").hide();
			window.print();
			$("#showActive").show();
			$("#showSubmit").show();
		}
	</script>
	<style type="text/css">
  		.div-col{
 			width: 350px;
  			float: left;
		} 
		.div-colm{
			width: 700px;
  			float: left;
		}
		.label-col{
			padding-top:5px;
		}
		.control-label-col{
			width: 60px;
			margin-left:55px;
		}
	</style>
</head>
<body>
	<br/>
	<form:form id="inputForm" modelAttribute="healthRecord" action="${ctx}/healtharchives/healthRecord/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group" id="showActive" style="border-bottom: 2px solid #93BAB6">
			<label class="control-label" for="hospitalNumber"></label>
			<input id="healthRecord1" class="btn active" type="button" onclick="showDiv(1)" value="基本情况"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthRecord2" class="btn" type="button" onclick="showDiv(2)" value="体格检查1"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthRecord3" class="btn" type="button" onclick="showDiv(3)" value="体格检查2"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthRecord4" class="btn" type="button" onclick="showDiv(4)" value="体格检查3"/>
		</div>
		<div id="showhealthRecord1">
			<jsp:include page="physicalExaminationInfo.jsp" /> 
		</div>
		<div id="showhealthRecord2">
			<jsp:include page="physicalExaminationInfo1.jsp" /> 
		</div>
		<div id="showhealthRecord3">
			<jsp:include page="physicalExaminationInfo2.jsp" /> 
		</div>
		<div id="showhealthRecord4">
			<jsp:include page="physicalExaminationInfo3.jsp" /> 
		</div>
		<div class="form-actions" id="showSubmit">
			<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="preview()" value="打印"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
