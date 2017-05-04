<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>诊疗计划详情</title>
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
			<div class="from-info" style="width:30%;">	
				<label class="control-label">责任医生:</label><label class="lbl">${assessment.doctorNm}	</label>
			</div>
			<div class="from-info" style="width:30%;">	
				<label class="control-label">护士长:</label><label class="lbl">${assessment.nurseNm}</label>
			</div>
			<div class="from-info" style="width:30%;">	
				<label class="control-label"> 科主任:</label><label class="lbl">${assessment.directorNm}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">	
				<label class="control-label">计划有效日期:</label>
				<label class="lbl">
					<fmt:formatDate value="${assessment.startTime}" pattern="yyyy-MM-dd HH:mm"/>
					~
					<fmt:formatDate value="${assessment.endTime}" pattern="yyyy-MM-dd HH:mm"/>
				</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="lineDiv"><input type="button" value="医疗"></div>
			<table class="interveneTable">
				<tr>
					<td width="150"><label class="table-label">主要诊断:</label></td>
					<td>
					${assessment.diagnosis}
					</td>
				</tr>
				<tr>
					<td><label class="table-label">全身情况:</label></td>
					<td>${assessment.generalCondition}</td>
				</tr>
				<tr>
					<td><label class="table-label">综合评估:</label></td>
					<td>${assessment.colligateAssess}</td>
				</tr>
				<tr>
					<td><label class="table-label">诊疗计划:</label></td>
					<td>${assessment.medicalPlan}</td>
				</tr>
				<tr>
					<td><label class="table-label">家属需求:</label></td>
					<td>${assessment.familyNeeds}</td>
				</tr>
				<tr>
					<td><label class="table-label">请会诊科室:</label></td>
					<td>${assessment.consultationDepartment}</td>
				</tr>
				<tr>
					<td><label class="table-label">目前最急迫处理病情:</label></td>
					<td>${assessment.illnessTook}</td>
				</tr>
			</table>
			<div class="lineDiv"><input type="button" value="护理"></div>
			<table class="interveneTable">
				<tr>
					<td width="150"><label class="table-label">护理项目:</label></td>
					<td>${assessment.nurseItem}</td>
				</tr>
			</table>
			<div class="lineDiv"><input type="button" value="营养"></div>
			<table class="interveneTable">
				<tr>
					<td width="150"><label class="table-label">计划每日所需液体量:</label></td>
					<td>${assessment.liquid}毫升</span></td>
					<td width="150"><label class="table-label">计划每日热卡:</label></td>
					<td>${assessment.calorie}</td>
					<td width="150"><label class="table-label">途径:</label></td>
					<td>${assessment.channel}</td>
				</tr>
				<tr>
					<td width="150"><label class="table-label">进餐方式:</label></td>
					<td>${assessment.dining}</td>
					<td width="150"><label class="table-label">每日:</label></td>
					<td>${assessment.frequency}次</span></td>
					<td width="150"><label class="table-label">每次剂量:</label></td>
					<td>${assessment.dose}g</span></td>
				</tr>
				<tr>
					<td width="150"><label class="table-label">营养餐性质:</label></td>
					<td>${assessment.nutritionalMeal}</td>
					<td width="150"><label class="table-label">进餐体位:</label></td>
					<td>${assessment.diningPosition}</td>
					<td width="150"><label class="table-label">餐后体位保持时间:</label></td>
					<td>${assessment.holdTime}分钟</span></td>
				</tr>
			</table>
			<div class="lineDiv"><input type="button" value="照护"></div>
			<table class="interveneTable">
				<tr>
					<td width="150"><label class="table-label">功能缺陷程度:</label></td>
					<td>${assessment.defectDegree}</td>
					<td width="150"><label class="table-label">照护注意事项:</label></td>
					<td>${assessment.needingAttention}</td>
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
