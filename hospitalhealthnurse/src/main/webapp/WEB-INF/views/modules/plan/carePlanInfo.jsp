<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>护理计划详情</title>
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
   function preview(){
      	$(".form-actions").hide();
      	window.print(); 
      	$(".form-actions").show();
}
</script>
<style type="text/css">
.tishi{
	color: #FF0000;
	font-weight: bold;
	margin-right: 5px;
}
.photoDiv{
	float: left;
	width: 100px;
	height: 100px;
	margin:0 20px;
}
.inforDiv{
	float: left;
	left: 100px;
	height: 50px;
	width: 90%;
	padding: 0;
	margin: 0;
}
.inforLabel{
	height: 20px;
	line-height: 20px;
	font-size: 20px;
	top: 15px;
	position: relative;
	margin-left: 20px;
	min-width: 100px;
}
.inforLabel span{
	font-weight: bold;
}
.planDiv{
	text-align: center;
}
.planDiv input{
	margin: 0 15px;
}
.docDiv{
	width: 100%;
	float: left;
	margin-top: 20px;
}
.doctorDiv{
	float: left;
	margin: auto 20px;
}
.doctorLabel{
	min-width: 120px;
	text-align: right;
}
.table-label{
	float: right;
}
.table-textarea{
	float: left;
}
.lineDiv{
	border-bottom: 1px solid #93BAB6; 
	width: 100%;
	float: left;
	margin-top: 5px;
	margin-bottom: 20px;
}
.lineDiv input{
	min-width: 100px;
	background: #49AFB3;
	border: 0;
	border-radius: 1px;
	color: #FFFFFF;
	font-size: 14px;
	font-weight: bold;
}
.groupDiv{
	width: 100%;
	float: left;
	margin-top: 5px;
}
.control-div{
	margin-top: 10px;
	float: left;
}
.control-input{
	float: left;
}
.control-span{
	float: left;
	margin: 5px;
}
.interveneTable{
	width: 90%;
	margin: auto 5%; 
	border: 1px dotted #b7d5df;
}

.nutritionMeals,.nutritionEnergy,.energyTotal,.nutritionDrinkWater,.recoverInput,.socialFamily{
	width: 50px
}
.recoverQuarters{
	width: 100px;
}
.recoverTime{
	width: 130px;
}
.socialLabel{
	min-width: 130px;
}
.addTableDiv{
	width: 80%;
	float: left;
	text-align: right;
	margin: 20px 10% auto;
}
.selected{
	background: #20B496 !important;
	color: #FFFFFF !important;
}
.lbl{
	display:block;
}
.interveneTable tr{
	height:40px;
	border-top: 1px dotted #b7d5df;
	border-bottom: 1px dotted #b7d5df;
}
.interveneTable tr td{
	border-left: 1px dotted #b7d5df;
	border-right: 1px dotted #b7d5df;
}
.interveneTable tr th{
	border-left: 1px dotted #b7d5df;
	border-right: 1px dotted #b7d5df;
	background-color: #b7d5df;
}
.form-actions{
	text-align: center;
}
</style>
</head>
<body>
	<tags:message content="${message}"/>
	<div class="form-horizontal" id="infoControl">
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">老人姓名:</label><label class="lbl">${planExecuteRecord.elderName}</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info" style="width:100%;">	
				<label class="control-label">临床诊断:</label><label class="lbl">${care.diagnosis}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">	
				<label class="control-label">计划有效日期:</label>
				<label class="lbl">
					<fmt:formatDate value="${care.careStartTime}" pattern="yyyy-MM-dd HH:mm"/>
					~
					<fmt:formatDate value="${care.careEndTime}" pattern="yyyy-MM-dd HH:mm"/>
				</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="lineDiv"><input type="button" value="护理诊疗计划"></div>
			<table class="interveneTable">
				<tr>
					<th width="15%"></th>
					<th width="55%"></th>
					<th width="15%">执行人(岗位)</th>
					<th width="15%">开始执行时间</th>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.nuserGrade}">checked="checked"</c:if>>
						护理级别
					</td>
					<td>
						<c:if test="${fns:containInt(care.nuserGrade,'1')}" >病危,</c:if>
						<c:if test="${fns:containInt(care.nuserGrade,'2')}" >病重,</c:if>
						<c:if test="${fns:containInt(care.nuserGrade,'3')}" >Ⅰ级护理,</c:if>
						<c:if test="${fns:containInt(care.nuserGrade,'4')}" >Ⅱ级护理,</c:if>
						<c:if test="${fns:containInt(care.nuserGrade,'5')}" >Ⅲ级护理</c:if>
					</td>
					<td>
						${care.nuserGradeQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.nuserGradeTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.deitNuser}">checked="checked"</c:if>>
						饮食护理
					</td>
					<td>
						<c:if test="${fns:containInt(care.deitNuser,'1')}" >普通饮食,</c:if>
						<c:if test="${fns:containInt(care.deitNuser,'2')}" >流质饮食,</c:if>
						<c:if test="${fns:containInt(care.deitNuser,'3')}" >低盐低脂饮食,</c:if>
						<c:if test="${fns:containInt(care.deitNuser,'4')}" >糖尿病饮食,</c:if>
						<c:if test="${fns:containInt(care.deitNuser,'5')}" >软食,</c:if>
						<c:if test="${fns:containInt(care.deitNuser,'6')}" >禁食,</c:if>
					</td>
					<td>${care.deitNuserQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.deitNuserTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.veinInfusion}">checked="checked"</c:if>>
						静脉输液
					</td>
					<td>
						<c:if test="${care.veinInfusionType == '0'}">
							<c:if test="${care.veinInfusionInterval == '1'}">每天</c:if>
							<c:if test="${care.veinInfusionInterval == '2'}">隔天</c:if>
							<c:if test="${care.veinInfusionInterval == '3'}">隔两天</c:if>
							<c:if test="${care.veinInfusionInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.veinInfusionType == '1'}">
							<c:if test="${care.veinInfusionInterval == '1'}">每周</c:if>
							<c:if test="${care.veinInfusionInterval == '2'}">隔周</c:if>
							<c:if test="${care.veinInfusionInterval == '3'}">隔两周</c:if>
							<c:if test="${care.veinInfusionInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.veinInfusionDetails}
					</td>
					<td>${care.veinInfusionQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.veinInfusionTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.oxygen}">checked="checked"</c:if>>
						吸氧
					</td>
					<td>
						<c:if test="${fns:containInt(care.oxygen,'1')}" >持续吸氧[</c:if>
						<c:if test="${fns:containInt(care.oxygen,'2')}" >吸氧管</c:if>
						<c:if test="${fns:containInt(care.oxygen,'3')}" >面罩</c:if>
						<c:if test="${fns:containInt(care.oxygen,'1')}" >]</c:if>
						<c:if test="${fns:containInt(care.oxygen,'4')}" >间断吸氧</c:if>
					</td>
					<td>${care.oxygenQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.oxygenTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.replaceWefFlask}">checked="checked"</c:if>>
						更换湿化瓶
					</td>
					<td>
						<c:if test="${care.replaceWefFlaskType == '0'}">
							<c:if test="${care.replaceWefFlaskInterval == '1'}">每天</c:if>
							<c:if test="${care.replaceWefFlaskInterval == '2'}">隔天</c:if>
							<c:if test="${care.replaceWefFlaskInterval == '3'}">隔两天</c:if>
							<c:if test="${care.replaceWefFlaskInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.replaceWefFlaskType == '1'}">
							<c:if test="${care.replaceWefFlaskInterval == '1'}">每周</c:if>
							<c:if test="${care.replaceWefFlaskInterval == '2'}">隔周</c:if>
							<c:if test="${care.replaceWefFlaskInterval == '3'}">隔两周</c:if>
							<c:if test="${care.replaceWefFlaskInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.replaceWefFlaskDetails}
					</td>
					<td>${care.replaceWefFlaskQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.replaceWefFlaskTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.sputumSuction}">checked="checked"</c:if>>
						吸痰 
					</td>
					<td>
						<c:if test="${care.sputumSuctionType == '0'}">
							<c:if test="${care.sputumSuctionInterval == '1'}">每天</c:if>
							<c:if test="${care.sputumSuctionInterval == '2'}">隔天</c:if>
							<c:if test="${care.sputumSuctionInterval == '3'}">隔两天</c:if>
							<c:if test="${care.sputumSuctionInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.sputumSuctionType == '1'}">
							<c:if test="${care.sputumSuctionInterval == '1'}">每周</c:if>
							<c:if test="${care.sputumSuctionInterval == '2'}">隔周</c:if>
							<c:if test="${care.sputumSuctionInterval == '3'}">隔两周</c:if>
							<c:if test="${care.sputumSuctionInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.sputumSuctionDetails}
					</td>
					<td>${care.sputumSuctionQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.sputumSuctionTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.atomization}">checked="checked"</c:if>>
						雾化
					</td>
					<td>
						<c:if test="${care.atomizationType == '0'}">
							<c:if test="${care.atomizationInterval == '1'}">每天</c:if>
							<c:if test="${care.atomizationInterval == '2'}">隔天</c:if>
							<c:if test="${care.atomizationInterval == '3'}">隔两天</c:if>
							<c:if test="${care.atomizationInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.atomizationType == '1'}">
							<c:if test="${care.atomizationInterval == '1'}">每周</c:if>
							<c:if test="${care.atomizationInterval == '2'}">隔周</c:if>
							<c:if test="${care.atomizationInterval == '3'}">隔两周</c:if>
							<c:if test="${care.atomizationInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.atomizationDetails}
					</td>
					<td>${care.atomizationQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.atomizationTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.oralNuser}">checked="checked"</c:if>>
						口腔护理
					</td>
					<td>
						<c:if test="${care.oralNuserType == '0'}">
							<c:if test="${care.oralNuserInterval == '1'}">每天</c:if>
							<c:if test="${care.oralNuserInterval == '2'}">隔天</c:if>
							<c:if test="${care.oralNuserInterval == '3'}">隔两天</c:if>
							<c:if test="${care.oralNuserInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.oralNuserType == '1'}">
							<c:if test="${care.oralNuserInterval == '1'}">每周</c:if>
							<c:if test="${care.oralNuserInterval == '2'}">隔周</c:if>
							<c:if test="${care.oralNuserInterval == '3'}">隔两周</c:if>
							<c:if test="${care.oralNuserInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.oralNuserDetails}
					</td>
					<td>${care.oralNuserQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.oralNuserTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.ureterNuser}">checked="checked"</c:if>>
						尿管护理
					</td>
					<td>
						<c:if test="${care.ureterNuserType == '0'}">
							<c:if test="${care.ureterNuserInterval == '1'}">每天</c:if>
							<c:if test="${care.ureterNuserInterval == '2'}">隔天</c:if>
							<c:if test="${care.ureterNuserInterval == '3'}">隔两天</c:if>
							<c:if test="${care.ureterNuserInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.ureterNuserType == '1'}">
							<c:if test="${care.ureterNuserInterval == '1'}">每周</c:if>
							<c:if test="${care.ureterNuserInterval == '2'}">隔周</c:if>
							<c:if test="${care.ureterNuserInterval == '3'}">隔两周</c:if>
							<c:if test="${care.ureterNuserInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.ureterNuserDetails}
					</td>
					<td>${care.ureterNuserQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.ureterNuserTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.deepVein}">checked="checked"</c:if>>深静脉置管护理
					</td>
					<td>
						<c:if test="${care.deepVeinType == '0'}">
							<c:if test="${care.deepVeinInterval == '1'}">每天</c:if>
							<c:if test="${care.deepVeinInterval == '2'}">隔天</c:if>
							<c:if test="${care.deepVeinInterval == '3'}">隔两天</c:if>
							<c:if test="${care.deepVeinInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.deepVeinType == '1'}">
							<c:if test="${care.deepVeinInterval == '1'}">每周</c:if>
							<c:if test="${care.deepVeinInterval == '2'}">隔周</c:if>
							<c:if test="${care.deepVeinInterval == '3'}">隔两周</c:if>
							<c:if test="${care.deepVeinInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.deepVeinDetails}
					</td>
					<td>${care.deepVeinQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.deepVeinTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.tracheaNuser}">checked="checked"</c:if>>气管切开护理  
					</td>
					<td>
						<c:if test="${care.tracheaNuserType == '0'}">
							<c:if test="${care.tracheaNuserInterval == '1'}">每天</c:if>
							<c:if test="${care.tracheaNuserInterval == '2'}">隔天</c:if>
							<c:if test="${care.tracheaNuserInterval == '3'}">隔两天</c:if>
							<c:if test="${care.tracheaNuserInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.tracheaNuserType == '1'}">
							<c:if test="${care.tracheaNuserInterval == '1'}">每周</c:if>
							<c:if test="${care.tracheaNuserInterval == '2'}">隔周</c:if>
							<c:if test="${care.tracheaNuserInterval == '3'}">隔两周</c:if>
							<c:if test="${care.tracheaNuserInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.tracheaNuserDetails}
					</td>
					<td>${care.tracheaNuserQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.tracheaNuserTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.oralMedicine}">checked="checked"</c:if>>口服药
					</td>
					<td>
						<c:if test="${care.oralMedicineType == '0'}">
							<c:if test="${care.oralMedicineInterval == '1'}">每天</c:if>
							<c:if test="${care.oralMedicineInterval == '2'}">隔天</c:if>
							<c:if test="${care.oralMedicineInterval == '3'}">隔两天</c:if>
							<c:if test="${care.oralMedicineInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.oralMedicineType == '1'}">
							<c:if test="${care.oralMedicineInterval == '1'}">每周</c:if>
							<c:if test="${care.oralMedicineInterval == '2'}">隔周</c:if>
							<c:if test="${care.oralMedicineInterval == '3'}">隔两周</c:if>
							<c:if test="${care.oralMedicineInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.oralMedicineDetails}
					</td>
					<td>${care.oralMedicineQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.oralMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.chineseMedicine}">checked="checked"</c:if>>中药
					</td>
					<td>
						<c:if test="${care.chineseMedicineType == '0'}">
							<c:if test="${care.chineseMedicineInterval == '1'}">每天</c:if>
							<c:if test="${care.chineseMedicineInterval == '2'}">隔天</c:if>
							<c:if test="${care.chineseMedicineInterval == '3'}">隔两天</c:if>
							<c:if test="${care.chineseMedicineInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.chineseMedicineType == '1'}">
							<c:if test="${care.chineseMedicineInterval == '1'}">每周</c:if>
							<c:if test="${care.chineseMedicineInterval == '2'}">隔周</c:if>
							<c:if test="${care.chineseMedicineInterval == '3'}">隔两周</c:if>
							<c:if test="${care.chineseMedicineInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.chineseMedicineDetails}
					</td>
					<td>${care.chineseMedicineQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.chineseMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.specialMedicine}">checked="checked"</c:if>>特殊用药
					</td>
					<td>
						<c:if test="${care.specialMedicineType == '0'}">
							<c:if test="${care.specialMedicineInterval == '1'}">每天</c:if>
							<c:if test="${care.specialMedicineInterval == '2'}">隔天</c:if>
							<c:if test="${care.specialMedicineInterval == '3'}">隔两天</c:if>
							<c:if test="${care.specialMedicineInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.specialMedicineType == '1'}">
							<c:if test="${care.specialMedicineInterval == '1'}">每周</c:if>
							<c:if test="${care.specialMedicineInterval == '2'}">隔周</c:if>
							<c:if test="${care.specialMedicineInterval == '3'}">隔两周</c:if>
							<c:if test="${care.specialMedicineInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.specialMedicineDetails}
					</td>
					<td>${care.specialMedicineQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.specialMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.recoveryNuser}">checked="checked"</c:if>>康复护理
					</td>
					<td>
						<c:if test="${fns:containInt(care.recoveryNuser,'1')}" >良肢位摆放,</c:if>
						<c:if test="${fns:containInt(care.recoveryNuser,'2')}" >进食（饮水）训练,</c:if>
						<c:if test="${fns:containInt(care.recoveryNuser,'3')}" >行走训练,</c:if>
						<c:if test="${fns:containInt(care.recoveryNuser,'4')}" >穿衣训练,</c:if>
						<c:if test="${fns:containInt(care.recoveryNuser,'5')}" >洗漱训练,</c:if>
						<c:if test="${fns:containInt(care.recoveryNuser,'6')}" >记忆力训练</c:if>
						<c:if test="${fns:containInt(care.recoveryNuser,'0')}" >${care.recoveryNuserOther }</c:if>
					</td>
					<td>${care.recoveryNuserQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.recoveryNuserTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.nutritionMeal}">checked="checked"</c:if>>营养餐
					</td>
					<td>
						<c:if test="${care.nutritionMealType == '0'}">
							<c:if test="${care.nutritionMealInterval == '1'}">每天</c:if>
							<c:if test="${care.nutritionMealInterval == '2'}">隔天</c:if>
							<c:if test="${care.nutritionMealInterval == '3'}">隔两天</c:if>
							<c:if test="${care.nutritionMealInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${care.nutritionMealType == '1'}">
							<c:if test="${care.nutritionMealInterval == '1'}">每周</c:if>
							<c:if test="${care.nutritionMealInterval == '2'}">隔周</c:if>
							<c:if test="${care.nutritionMealInterval == '3'}">隔两周</c:if>
							<c:if test="${care.nutritionMealInterval == '4'}">隔三周</c:if>
						</c:if>
						${care.nutritionMealDetails}
					</td>
					<td>${care.nutritionMealQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.nutritionMealTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.healthEducation}">checked="checked"</c:if>>健康教育
					</td>
					<td>
						<c:if test="${fns:containInt(care.healthEducation,'1')}" >高血压,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'2')}" >糖尿病,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'3')}" >肺炎,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'4')}" >COPD,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'5')}" >冠心病,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'6')}" >痛风,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'7')}" >脑梗塞（脑出血）,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'8')}" >帕金森,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'9')}" >美尼尔氏综合症,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'10')}" >消化道出血,</c:if>
						<c:if test="${fns:containInt(care.healthEducation,'0')}" >${care.healthEducationOther }</c:if>
					</td>
					<td>${care.healthEducationQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.healthEducationTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
			</table>
			<div class="lineDiv"><input type="button" value="护理诊断"></div>
			<table class="interveneTable">
				<tr>
					<th width="15%"></th>
					<th width="55%"></th>
					<th width="15%">执行人(岗位)</th>
					<th width="15%">开始执行时间</th>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.fallRisk}">checked="checked"</c:if>>跌倒风险
					</td>
					<td>
						<c:if test="${fns:containStr(care.fallRisk,'1')}" >评估危险因数并记录,</c:if>
						<c:if test="${fns:containStr(care.fallRisk,'2')}" >环境安全管理,</c:if>
						<c:if test="${fns:containStr(care.fallRisk,'3')}" >警示标识,</c:if>
						<c:if test="${fns:containStr(care.fallRisk,'4')}" >床档,</c:if>
						<c:if test="${fns:containStr(care.fallRisk,'5')}" >保护性约束,</c:if>
						<c:if test="${fns:containStr(care.fallRisk,'6')}" >陪护</c:if>
					</td>
					<td>${care.fallRiskQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.fallRiskTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.ulcerRisk}">checked="checked"</c:if>>压疮风险
					</td>
					<td>
						<c:if test="${fns:containInt(care.ulcerRisk,'1')}" >评估皮肤受损的危险因数并记录,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'2')}" >当时正确更换体位,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'3')}" >警示标识,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'4')}" >给予减压用具,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'5')}" >定时翻身[</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'6')}" >每小时一次,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'7')}" >每两小时一次,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'8')}" >每四小时一次,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'9')}" >${care.ulcerRiskOtherTwo }</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'5')}" >],</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'10')}" >营养指导,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'11')}" >皮肤护理 洗澡（擦拭）[</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'12')}" >每天一次,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'13')}" >隔天一次,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'14')}" >每周四次,</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'15')}" >${care.ulcerRiskOtherThree }</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'11')}" >],</c:if>
						<c:if test="${fns:containInt(care.ulcerRisk,'0')}" >${care.ulcerRiskOther }</c:if>
					</td>
					<td>${care.ulcerRiskQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.ulcerRiskTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.anxiety}">checked="checked"</c:if>>孤独、焦虑、抑郁
					</td>
					<td>
						<c:if test="${fns:containInt(care.anxiety,'1')}" >讲解疾病治疗、转归及预后知识,</c:if>
						<c:if test="${fns:containInt(care.anxiety,'2')}" >指导患者采取放松措施[</c:if>
						<c:if test="${fns:containInt(care.anxiety,'3')}" >听音乐,</c:if>
						<c:if test="${fns:containInt(care.anxiety,'4')}" >讲故事,</c:if>
						<c:if test="${fns:containInt(care.anxiety,'5')}" >聊天,</c:if>
						<c:if test="${fns:containInt(care.anxiety,'6')}" >看电视,</c:if>
						<c:if test="${fns:containInt(care.anxiety,'0')}" >${care.anxietyOther },</c:if>
						<c:if test="${fns:containInt(care.anxiety,'2')}" >],</c:if>
						<c:if test="${fns:containInt(care.anxiety,'7')}" >心理支持(每天两次)</c:if>
					</td>
					<td>${care.anxietyQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.anxietyTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.languageBalk}">checked="checked"</c:if>>语言沟通障碍
					</td>
					<td>
						<c:if test="${fns:containInt(care.languageBalk,'1')}" >尊重患者,</c:if>
						<c:if test="${fns:containInt(care.languageBalk,'2')}" >使用肢体语言沟通,</c:if>
						<c:if test="${fns:containInt(care.languageBalk,'3')}" >借助纸笔方式沟通,</c:if>
						<c:if test="${fns:containInt(care.languageBalk,'4')}" >其他（采用是否问答方式）</c:if>
					</td>
					<td>${care.languageBalkQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.languageBalkTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.sleepDisorder}">checked="checked"</c:if>>睡眠状态紊乱
					</td>
					<td>
						<c:if test="${fns:containInt(care.sleepDisorder,'1')}" >提供安静舒适的病区环境,</c:if>
						<c:if test="${fns:containInt(care.sleepDisorder,'2')}" >尽量减少对患者的干扰,</c:if>
						<c:if test="${fns:containInt(care.sleepDisorder,'3')}" >指导患者运用睡眠促进措施,</c:if>
						<c:if test="${fns:containInt(care.sleepDisorder,'4')}" >遵医嘱用药并评价其效果</c:if>
					</td>
					<td>${care.sleepDisorderQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.sleepDisorderTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.temperatureOvertop}">checked="checked"</c:if>>体温过高  
					</td>
					<td>
						<c:if test="${fns:containInt(care.temperatureOvertop,'1')}" >测量体温,</c:if>
						<c:if test="${fns:containInt(care.temperatureOvertop,'2')}" >物理降温,</c:if>
						<c:if test="${fns:containInt(care.temperatureOvertop,'3')}" >药物温度及效果观察,</c:if>
						<c:if test="${fns:containInt(care.temperatureOvertop,'4')}" >皮肤护理</c:if>
					</td>
					<td>${care.temperatureOvertopQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.temperatureOvertopTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.respiratoryTract}">checked="checked"</c:if>>清理呼吸道无效 
					</td>
					<td>
						<c:if test="${fns:containInt(care.respiratoryTract,'1')}" >指导咳嗽,</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'2')}" >呼吸训练[</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'3')}" >每天一次,</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'4')}" >每天两次,</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'5')}" >每天三次,</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'0')}" >${care.respiratoryTractOther }</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'2')}" >],</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'6')}" >雾化吸入,</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'7')}" >吸痰,</c:if>
						<c:if test="${fns:containInt(care.respiratoryTract,'8')}" >体位引流</c:if>
					</td>
					<td>${care.respiratoryTractQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.respiratoryTractTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.pain}">checked="checked"</c:if>>疼痛    
					</td>
					<td>
						<c:if test="${fns:containInt(care.pain,'1')}" >评估疼痛级别,</c:if>
						<c:if test="${fns:containInt(care.pain,'2')}" >观察记录疼痛性质、程度、规律,</c:if>
						<c:if test="${fns:containInt(care.pain,'3')}" >指导使用放松技术,</c:if>
						<c:if test="${fns:containInt(care.pain,'4')}" >按医嘱使用止痛剂,</c:if>
					</td>
					<td>${care.painQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.painTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.constipation}">checked="checked"</c:if>>便秘  
					</td>
					<td>
						<c:if test="${fns:containInt(care.constipation,'1')}" >饮食指导,</c:if>
						<c:if test="${fns:containInt(care.constipation,'2')}" >活动指导,</c:if>
						<c:if test="${fns:containInt(care.constipation,'3')}" >局部按摩,</c:if>
						<c:if test="${fns:containInt(care.constipation,'4')}" >缓泻剂应用,</c:if>
						<c:if test="${fns:containInt(care.constipation,'5')}" >灌肠治疗,</c:if>
						<c:if test="${fns:containInt(care.constipation,'6')}" >记录排便次数</c:if>
					</td>
					<td>${care.constipationQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.constipationTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.incontinence}">checked="checked"</c:if>>失禁
					</td>
					<td>
						<c:if test="${fns:containInt(care.incontinence,'1')}" >评估失禁程度,</c:if>
						<c:if test="${fns:containInt(care.incontinence,'2')}" >观察排尿规律,</c:if>
						<c:if test="${fns:containInt(care.incontinence,'3')}" >正确使用便器,</c:if>
						<c:if test="${fns:containInt(care.incontinence,'4')}" >帮助不方便的患者排尿,</c:if>
						<c:if test="${fns:containInt(care.incontinence,'5')}" >正确使用尿不湿,</c:if>
						<c:if test="${fns:containInt(care.incontinence,'6')}" >加强会阴部皮肤护理</c:if>
					</td>
					<td>${care.incontinenceQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.incontinenceTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.activityIntolerance}">checked="checked"</c:if>>活动无耐力
					</td>
					<td>
						<c:if test="${fns:containInt(care.activityIntolerance,'1')}" >评估患者活动能力,</c:if>
						<c:if test="${fns:containInt(care.activityIntolerance,'2')}" >协助患者完成生活护理,</c:if>
						<c:if test="${fns:containInt(care.activityIntolerance,'3')}" >防跌倒指导,</c:if>
						<c:if test="${fns:containInt(care.activityIntolerance,'4')}" >指导床上活动</c:if>
					</td>
					<td>${care.activityIntoleranceQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.activityIntoleranceTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.potentialAsphyxia}">checked="checked"</c:if>>潜在并发症：窒息 
					</td>
					<td>
						<c:if test="${fns:containInt(care.potentialAsphyxia,'1')}" >评估可能发生窒息的危险因数并记录,</c:if>
						<c:if test="${fns:containInt(care.potentialAsphyxia,'2')}" >保护呼吸道通畅,</c:if>
						<c:if test="${fns:containInt(care.potentialAsphyxia,'3')}" >体位管理,</c:if>
						<c:if test="${fns:containInt(care.potentialAsphyxia,'4')}" >床旁备吸痰器</c:if>
					</td>
					<td>${care.potentialAsphyxiaQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.potentialAsphyxiaTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.potentialBleeding}">checked="checked"</c:if>>潜在并发症：出血
					</td>
					<td>
						<c:if test="${fns:containInt(care.potentialBleeding,'1')}" >检查生命体征、意识,</c:if>
						<c:if test="${fns:containInt(care.potentialBleeding,'2')}" >观察引流物性质及量,</c:if>
						<c:if test="${fns:containInt(care.potentialBleeding,'3')}" >观察伤口敷料,</c:if>
						<c:if test="${fns:containInt(care.potentialBleeding,'4')}" >观察皮肤颜色及温度, </c:if>
						<c:if test="${fns:containInt(care.potentialBleeding,'5')}" >遵医嘱使用止血药</c:if>
					</td>
					<td>${care.potentialBleedingQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.potentialBleedingTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.potentialInfection}">checked="checked"</c:if>>潜在并发症：感染 
					</td>
					<td>
						<c:if test="${fns:containInt(care.potentialInfection,'1')}" >监测患者体温、脉搏,</c:if>
						<c:if test="${fns:containInt(care.potentialInfection,'2')}" >观察引流物的性质,</c:if>
						<c:if test="${fns:containInt(care.potentialInfection,'3')}" >加强管道护理,</c:if>
						<c:if test="${fns:containInt(care.potentialInfection,'4')}" >口腔护理,</c:if>
						<c:if test="${fns:containInt(care.potentialInfection,'5')}" >伤口护理</c:if>
					</td>
					<td>${care.potentialInfectionQuartersNm}
					</td>
					<td><fmt:formatDate value="${care.potentialInfectionTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled"  type="checkbox" <c:if test="${not empty care.other}">checked="checked"</c:if>>其他
					</td>
					<td>
						${care.other }
					</td>
				</tr>
			</table>
			<div class="form-actions">
				<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview()"/>
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</div>
	</div>
	
</body>
</html>
