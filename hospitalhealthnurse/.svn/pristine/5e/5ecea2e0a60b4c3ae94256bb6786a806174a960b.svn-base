<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>健康记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
			
			showDiv(1);
			
			var id = $("#id").val();
			if(id == null || id == ""){
				$("#btnSubmit").attr("disabled","disabled");
			}
			
		});
		function doClick(){
			var hospitalNumber = $("#hospitalNumber").val();
			if(hospitalNumber != null && hospitalNumber != ''){
				$.get("${ctx}/healtharchives/healthArchives/selectHealth?hospitalNumber="+hospitalNumber,
					function(json){
						json = eval("("+json+")"); 
						if(json.healthArchives != null && json.healthArchives != ""){
							$("#userId").val(json.healthArchives.userId);
							$("#photo").html("<img src='"+json.healthArchives.photo+"' style='width:35px;height:35;'></img>");
							$("#fullNm").html(json.healthArchives.fullNm);
							$("#sex").html(json.healthArchives.sex);
							$("#age").html(json.healthArchives.age);
							$("#hospitalNumberLabel").hide();
							$("#btnSubmit").removeAttr("disabled");
						}else{
							$("#hospitalNumberLabel").show();
						}
				});
			}else{
				$("#userId").val('');
				$("#photo").html("");
				$("#fullNm").html("");
				$("#sex").html("");
				$("#age").html("");
				$("#hospitalNumberLabel").show();
			}
		}
		function hideLabel(){
			$("#hospitalNumberLabel").hide();
		}
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
		
		//通过上级地区获取下级地区
		function showArea(areaId,count){
			if(count == 1){
				$("#city").empty();
				$("#city").html("<option value=''>市</option>");
				$("#area").empty();
				$("#area").html("<option value=''>县/区</option>");
			}else{
				$("#area").empty();
				$("#area").html("<option value=''>市</option>");
			}
			if(areaId != null && areaId != ""){
				$.get("${ctx}/sys/area/areaList",{parentId:areaId},
					function(json){
						if(count == 1){
							$("#city").empty();
							var options = "<option value=''>市</option>";
							$.each(json, function(n, value){
								options += "<option value='"+value.id+"'>"+value.name+"</option>";
							});
							$("#city").html(options);
							$("#city").select2('val','');
						}else {
							$("#area").empty();
							var options = "<option value=''>县/区</option>";
							$.each(json, function(n, value){
								options += "<option value='"+value.id+"'>"+value.name+"</option>";
							});
							$("#area").html(options);
							$("#area").select2('val','');
						}
				});
			}
		}
		//是否便秘
		function showlooseStoolsNumber(value){
			if(value == '2'){
				$("#showlooseStoolsNumber").show();
			}else{
				$("#showlooseStoolsNumber").hide();
				$("#looseStoolsNumber").val('');
				$("#looseStoolsDays").val('');
			}
		}
		//是否过敏
		function showanaphylactogen(value){
			if(value == '2'){
				$("#showanaphylactogen").show();
			}else{
				$("#showanaphylactogen").hide();
				$("#anaphylactogen").val('');
				$("#allergyClinicalManifestation").val('');
			}
		}
		//是否有皮疹
		function showerythraType(value){
			if(value == '2'){
				$("#showerythraType").show();
			}else{
				$("#showerythraType").hide();
				$("#erythraType").val('');
			}
		}
		//是否皮下出血
		function showsubcutaneousHemorrhageType(value){
			if(value == '2'){
				$("#showsubcutaneousHemorrhageType").show();
			}else{
				$("#showsubcutaneousHemorrhageType").hide();
				$("#subcutaneousHemorrhageType").val('');
			}
		}
		//毛发分布是否脱落
		function showhairDistributionPosition(value){
			if(value == '4'){
				$("#showhairDistributionPosition").show();
			}else{
				$("#showhairDistributionPosition").hide();
				$("#hairDistributionPosition").val('');
			}
		}
		//是否水肿
		function showedemaPosition(value){
			if(value == '2'){
				$("#showedemaPosition").show();
			}else{
				$("#showedemaPosition").hide();
				$("#edemaPosition").val('');
			}
		}
		//是否有蜘蛛痣
		function showspiderPosition(value){
			if(value == '2'){
				$("#showspiderPosition").show();
			}else{
				$("#showspiderPosition").hide();
				$("#spiderPosition").val('');
			}
		}
		//淋巴结是否肿大
		function showsuperficialLymphNodesPosition(value){
			if(value == '2'){
				$("#showsuperficialLymphNodesPosition").show();
			}else{
				$("#showsuperficialLymphNodesPosition").hide();
				$("#superficialLymphNodesPosition").val('');
			}
		}
		//外耳道分泌物性质
		function showexternalSecretionNature(value){
			if(value == '2' || value == '3'){
				$("#showexternalSecretionNature").show();
			}else{
				$("#showexternalSecretionNature").hide();
				$("#externalSecretionNature").val('');
			}
		}
		//齿列不齐
		function showagomphosisNumber(value){
			if(value == '2' || value == '3' || value == '4'){
				$("#agomphosisNumber").show();
			}else{
				$("#agomphosisNumber").hide();
				$("#agomphosisNumber").val('');
			}
		}
		//甲状腺肿大度
		function showthyroidTumefaction(value){
			if(value == '2'){
				$("#thyroidTumefaction").show();
				$("#thyroidTumefaction").after("<span id='delTume'>度</span>");
			}else{
				$("#thyroidTumefaction").hide();
				$("#delTume").remove();
				$("#thyroidTumefaction").val('');
			}
		}
		//肋间隙变窄部位
		function showribSpacePosition(value){
			if(value == '3'){
				$("#showribSpacePosition").show();
			}else{
				$("#showribSpacePosition").hide();
				$("#ribSpacePosition").val('');
			}
		}
		//胸膜摩擦感部位
		function showpleuralFrictionPosition(value){
			if(value == '2'){
				$("#showpleuralFrictionPosition").show();
			}else{
				$("#showpleuralFrictionPosition").hide();
				$("#pleuralFrictionPosition").val('');
			}
		}
		//皮下捻发感部位
		function showsubcutaneousCrepitusPosition(value){
			if(value == '2'){
				$("#showsubcutaneousCrepitusPosition").show();
			}else{
				$("#showsubcutaneousCrepitusPosition").hide();
				$("#subcutaneousCrepitusPosition").val('');
			}
		}
		//呼吸音是否正常
		function showbreathSoundsPosition(value){
			if(value == '3'){
				$("#showbreathSoundsPosition").show();
			}else{
				$("#showbreathSoundsPosition").hide();
				$("#breathSoundsPosition").val('');
			}
		}
		//心尖搏动位置
		function showlmcl(value){
			if(value == '2'){
				$("#showlmcl").show();
			}else{
				$("#showlmcl").hide();
				$("#lmcl").val('');
			}
		}
		//震颤部位和时期
		function showtremor(value){
			if(value == '2'){
				$("#showtremor").show();
			}else{
				$("#showtremor").hide();
				$("#tremor").val('');
				$("#tremorSite").val('');
			}
		}
		//有无杂音
		function showcorriganPulseMurmurPosition(value){
			if(value == '2'){
				$("#showcorriganPulseMurmurPosition").show();
			}else{
				$("#showcorriganPulseMurmurPosition").hide();
				$("#corriganPulseMurmurPosition").val('');
			}
		}
		//蛙腹腹围
		function showfrogBelly(value){
			if(value == '3'){
				$("#showfrogBelly").show();
			}else{
				$("#showfrogBelly").hide();
				$("#frogBelly").val('');
			}
		}
		//触诊部位
		function showpalpationPosition(value){
			if(value == '2'){
				$("#showpalpationPosition").show();
			}else{
				$("#showpalpationPosition").hide();
				$("#palpationPosition").val('');
			}
		}
		//触诊-压痛部位
		function showtendernessPosition(value){
			if(value == '2'){
				$("#showtendernessPosition").show();
			}else{
				$("#showtendernessPosition").hide();
				$("#tendernessPosition").val('');
			}
		}
		//反跳痛部位
		function showreboundTendernessPosition(value){
			if(value == '2'){
				$("#showreboundTendernessPosition").show();
			}else{
				$("#showreboundTendernessPosition").hide();
				$("#reboundTendernessPosition").val('');
			}
		}
		//腹部包块
		function showabdominalMassPosition(value){
			if(value == '2'){
				$("#showabdominalMassPosition").show();
			}else{
				$("#showabdominalMassPosition").hide();
				$("#abdominalMassPosition").val('');
				$("#abdominalMassSize").val('');
				$("#abdominalMassNature").val('');
			}
		}
		//肝肋下及特征
		function showliverSubcostal(value){
			if(value == '2'){
				$("#showliverSubcostal").show();
			}else{
				$("#showliverSubcostal").hide();
				$("#liverSubcostal").val('');
				$("#liverFeature").val('');
			}
		}
		//胆大小
		function showgallbladderSize(value){
			if(value == '2'){
				$("#showgallbladderSize").show();
			}else{
				$("#showgallbladderSize").hide();
				$("#gallbladderSize").val('');
			}
		}
		//脾肋下及特征
		function showspleenSubcostal(value){
			if(value == '2'){
				$("#showspleenSubcostal").show();
			}else{
				$("#showspleenSubcostal").hide();
				$("#spleenSubcostal").val('');
				$("#spleenFeature").val('');
			}
		}
		//输尿管压痛点
		function showtenderSpotUreterPosition(value){
			if(value == '2'){
				$("#showtenderSpotUreterPosition").show();
			}else{
				$("#showtenderSpotUreterPosition").hide();
				$("#tenderSpotUreterPosition").val('');
			}
		}
		//血管杂音部位
		function showvascularMurmurPosition(value){
			if(value == '2'){
				$("#showvascularMurmurPosition").show();
			}else{
				$("#showvascularMurmurPosition").hide();
				$("#vascularMurmurPosition").val('');
			}
		}
		//棘突扣痛部位
		function showspinousProcessPosition(value){
			if(value == '2'){
				$("#showspinousProcessPosition").show();
			}else{
				$("#showspinousProcessPosition").hide();
				$("#spinousProcessPosition").val('');
			}
		}
		//下肢静脉曲张
		function showvarixLowerLimbPosition(value){
			if(value == '2'){
				$("#showvarixLowerLimbPosition").show();
			}else{
				$("#showvarixLowerLimbPosition").hide();
				$("#varixLowerLimbPosition").val('');
			}
		}
		//打印
		function preview(){
			$("#showHospitalNumber").hide();
			$("#showActive").hide();
			$("#showSubmit").hide();
			
			window.print();
			$("#showHospitalNumber").show();
			$("#showActive").show();
			$("#showSubmit").show();
		}
	</script>
	<style type="text/css">
		.tishi{
			color: #FF0000;
			font-weight: bold;
			margin-right: 5px;
		}
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
		<div class="control-group" id="showHospitalNumber" style="<c:choose><c:when test="${healthRecord.id == null || healthRecord.id == ''}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
			<label class="control-label" for="hospitalNumber">住院号:</label>
			<form:input path="hospitalNumber" htmlEscape="false" maxlength="15" onkeydown="if(event.keyCode==13){doClick();return false;}" />
			<input class="btn btn-yellow" type="button" onclick="doClick()" onblur="hideLabel();" value="查询"/>&nbsp;
			<label id='hospitalNumberLabel' class="error" style="display: none;">请输入存在的住院号</label>
		</div>
		<div class="control-group" id="showActive" style="border-bottom: 2px solid #93BAB6">
			<label class="control-label" for="hospitalNumber"></label>
			<input id="healthRecord1" class="btn active" type="button" onclick="showDiv(1)" value="基本情况"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthRecord2" class="btn" type="button" onclick="showDiv(2)" value="体格检查1"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthRecord3" class="btn" type="button" onclick="showDiv(3)" value="体格检查2"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input id="healthRecord4" class="btn" type="button" onclick="showDiv(4)" value="体格检查3"/>
		</div>
		<div id="showhealthRecord1">
			<jsp:include page="physicalExaminationForm.jsp" /> 
		</div>
		<div id="showhealthRecord2">
			<jsp:include page="physicalExaminationForm1.jsp" /> 
		</div>
		<div id="showhealthRecord3">
			<jsp:include page="physicalExaminationForm2.jsp" /> 
		</div>
		<div id="showhealthRecord4">
			<jsp:include page="physicalExaminationForm3.jsp" /> 
		</div>
		<div class="form-actions" id="showSubmit">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="preview()" value="打印"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
