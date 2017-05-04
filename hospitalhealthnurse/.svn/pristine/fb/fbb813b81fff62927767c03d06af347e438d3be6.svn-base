<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>营养计划详情</title>
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
				<label class="control-label">老人头像:</label>
				<tags:printImg defaultUrl="/static/images/archives.png" imgOriUrl="${planExecuteRecord.photo}" imgUrl="${planExecuteRecord.photo}" width="60" height="60" />
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">老人姓名:</label><label class="lbl">${planExecuteRecord.elderName}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info">
				<label class="control-label">主管营养师:</label><label class="lbl">${nutrition.dietitianNm}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">营养支持治疗时间:</label>
				<label class="lbl">
					<fmt:formatDate value="${nutrition.treatStartTime}" pattern="yyyy-MM-dd"/>~
							<fmt:formatDate value="${nutrition.treatEndTime}" pattern="yyyy-MM-dd"/>
				</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">营养评估结果:</label>
				<label class="lbl">${nutrition.assessResult}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">临床诊断:</label>
				<label class="lbl">${nutrition.clinicalDiagnosis}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="lineDiv"><input type="button" value="营养计划"></div>
			<table class="interveneTable">
				<tr>
					<th colspan="2" width="20%"></th>
					<th colspan="2" width="25%">近期摄入量</th>
					<th width="15%">产生能量</th>
					<th width="20%">餐次安排</th>
					<th width="20%">执行人(岗位)</th>
				</tr>
				<tr>
					<td width="40" rowspan="4">基础饮食</td>
					<td style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.foodMeals}">checked="checked"</c:if>>普食
					</td>
					<td>
						每日 ${nutrition.foodMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.foodMealsNumber} g
					</td>
					<td>
						${nutrition.foodEnergy } 千焦
					</td>
					<td>
						${nutrition.foodArrange}
					</td>
					<td>${nutrition.foodQuartersNm}
					</td>
				</tr>
				<tr>
					<td style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.papmeatMeals}">checked="checked"</c:if>>软食 
					</td>
					<td>
						每日 ${nutrition.papmeatMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.papmeatMealsNumber} g
					</td>
					<td>
						${nutrition.papmeatEnergy } 千焦
					</td>
					<td>${nutrition.papmeatArrange}
					</td>
					<td>${nutrition.papmeatQuartersNm}
					</td>
				</tr> 
				<tr>
					<td style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.semiLiquidMeals}">checked="checked"</c:if>>半流质 
					</td>
					<td>
						每日 ${nutrition.semiLiquidMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.semiLiquidMealsNumber} g 
					</td>
					<td>
						${nutrition.semiLiquidEnergy } 千焦
					</td>
					<td>${nutrition.semiLiquidArrange}
					</td>
					<td>
						${nutrition.semiLiquidQuartersNm}
					</td>
				</tr>
				<tr>
					<td style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.liquidMeals}">checked="checked"</c:if>>流质
					</td>
					<td>
						每日 ${nutrition.liquidMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.liquidMealsNumber} g 
					</td>
					<td>
						${nutrition.liquidEnergy } 千焦
					</td>
					<td>${nutrition.liquidArrange}
					</td>
					<td>${nutrition.liquidQuartersNm}
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.onsMeals}">checked="checked"</c:if>>口服营养补充（ONS）
					</td>
					<td>
						每日 ${nutrition.onsMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.onsMealsNumber} g 
					</td>
					<td>
						${nutrition.onsEnergy } 千焦
					</td>
					<td>${nutrition.onsArrange}
					</td>
					<td>${nutrition.onsQuartersNm}
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.tenMeals}">checked="checked"</c:if>>全天肠内营养(TEN)
					</td>
					<td>
						每日 ${nutrition.tenMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.tenMealsNumber} g 
					</td>
					<td>
						${nutrition.tenEnergy } 千焦
					</td>
					<td>${nutrition.tenArrange}
					</td>
					<td>${nutrition.tenQuartersNm}
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.penMeals}">checked="checked"</c:if>>部分肠内（PEN）
					</td>
					<td>
						每日 ${nutrition.penMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.penMealsNumber} g 
					</td>
					<td>
						${nutrition.penEnergy } 千焦
					</td>
					<td>${nutrition.penArrange}
					</td>
					<td>${nutrition.penQuartersNm}
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.ppnMeals}">checked="checked"</c:if>>部分肠外（PPN）
					</td>
					<td>
						每日 ${nutrition.ppnMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.ppnMealsNumber} g 
					</td>
					<td>
						${nutrition.ppnEnergy } 千焦
					</td>
					<td>${nutrition.ppnArrange}
					</td>
					<td>${nutrition.ppnQuartersNm}
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.tpnMeals}">checked="checked"</c:if>>全天肠外营养(TPN)
					</td>
					<td>
						每日 ${nutrition.tpnMeals} 餐
					</td>
					<td>
						每餐 ${nutrition.tpnMealsNumber} g 
					</td>
					<td>
						${nutrition.tpnEnergy } 千焦
					</td>
					<td>${nutrition.tpnArrange}
					</td>
					<td>${nutrition.tpnQuartersNm}
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nutrition.drinkWaterMeals}">checked="checked"</c:if>>饮水/喂水量 
					</td>
					<td style="text-align: left;">
						${nutrition.drinkWaterMealsNumber} ml
					</td>
					<td></td>
					<td>
						${nutrition.drinkWaterEnergy } 千焦
					</td>
					<td>
						${nutrition.drinkWaterArrange}
					</td>
					<td>
						${nutrition.drinkWaterQuartersNm}
					</td>
				</tr>
				<tr>
					<td colspan="2">合计摄入水量 ${nutrition.waterTotal} ml
					</td>
					<td colspan="2">合计能量 ${nutrition.energyTotal} 千焦
					</td>
				</tr>
			</table>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">进餐环境:</label>
				<label class="lbl">${nutrition.dineAmbient}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">进餐餐具:</label>
				<label class="lbl">${nutrition.dineTableware}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">注意事项:</label>
				<label class="lbl">${nutrition.dineAttention}</label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview()"/>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</div>
</body>
</html>
