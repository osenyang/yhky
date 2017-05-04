<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>照护计划详情</title>
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
				<label class="control-label">主管医师:</label><label class="lbl">${nurser.doctorNm}</label>
			</div>
			<div class="from-info" style="width:30%;">
				<label class="control-label">主管护士:</label><label class="lbl">${nurser.nurseNm}</label>
			</div>
			<div class="from-info" style="width:30%;">
				<label class="control-label">主管护理员:</label><label class="lbl">${nurser.directorNm}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">照护诊断:</label><label class="lbl">${nurser.careDiagnosis}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">
				<label class="control-label">	
					护理评估:
				</label>
				<label class="lbl">
					<div class="doctorDiv">	
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.fallScore}">checked="checked"</c:if>>
						跌倒：
						<input disabled="disabled" type="text" value="${nurser.fallScore}" style="width: 50px;">分	
					</div>
					<div class="doctorDiv">	
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.ulcerScore}">checked="checked"</c:if>>
						压疮评估：
						<input disabled="disabled" type="text" value="${nurser.ulcerScore }" style="width: 50px;">分	
					</div>
					<div class="doctorDiv">	
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.mmseScore}">checked="checked"</c:if>>
						MMSE:
						<input disabled="disabled" type="text" value="${nurser.mmseScore }" style="width: 50px;">分
					</div>
					<div class="doctorDiv">	
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.adlScore}">checked="checked"</c:if>>
						ADL:
						<input disabled="disabled" type="text" value="${nurser.adlScore }" style="width: 50px;">分	
					</div>
					<div class="doctorDiv">	
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.watianScore}">checked="checked"</c:if>>
						洼田饮水：
						<input disabled="disabled" type="text" value="${nurser.watianScore }" style="width: 50px;">	
					</div>
				</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">	
				<label class="control-label">计划有效日期:</label>
				<label class="lbl">
					<fmt:formatDate value="${nurser.nurserStartTime}" pattern="yyyy-MM-dd HH:mm"/>
					~
					<fmt:formatDate value="${nurser.nurserEndTime}" pattern="yyyy-MM-dd HH:mm"/>
				</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="lineDiv"><input type="button" value="照护计划与频次"></div>
			<table class="interveneTable">
				<tr>
					<th width="15%"></th>
					<th width="55%"></th>
					<th width="15%">执行人(岗位)</th>
					<th width="15%">开始执行时间</th>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.careLevel}">checked="checked"</c:if>>照护级别
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.careLevel,'1')}" >特级照护,</c:if>
						<c:if test="${fns:containStr(nurser.careLevel,'2')}" >Ⅲ级照护,</c:if>
						<c:if test="${fns:containStr(nurser.careLevel,'3')}" >Ⅱ级照护,</c:if>
						<c:if test="${fns:containStr(nurser.careLevel,'4')}" >Ⅰ级照护</c:if>
					</td>
					<td>${nurser.careLevelQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.careLevelTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.deitNuser}">checked="checked"</c:if>>饮食护理 
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.deitNuser,'1')}" >普通饮食,</c:if>
						<c:if test="${fns:containStr(nurser.deitNuser,'2')}" >流质饮食,</c:if>
						<c:if test="${fns:containStr(nurser.deitNuser,'3')}" >低盐低脂饮食,</c:if>
						<c:if test="${fns:containStr(nurser.deitNuser,'4')}" >糖尿病饮食,</c:if>
						<c:if test="${fns:containStr(nurser.deitNuser,'5')}" >营养餐</c:if>
					</td>
					<td>${nurser.deitNuserQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.deitNuserTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.cavityClean}">checked="checked"</c:if>>介护口腔清洗 
					</td>
					<td>
						<c:if test="${nurser.cavityCleanType == '0'}">
							<c:if test="${nurser.cavityCleanInterval == '1'}">每天</c:if>
							<c:if test="${nurser.cavityCleanInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.cavityCleanInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.cavityCleanInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.cavityCleanType == '1'}">
							<c:if test="${nurser.cavityCleanInterval == '1'}">每周</c:if>
							<c:if test="${nurser.cavityCleanInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.cavityCleanInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.cavityCleanInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.cavityCleanDetails}
					</td>
					<td>${nurser.cavityCleanQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.cavityCleanTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.perinealWash}">checked="checked"</c:if>>介护会阴冲洗
					</td>
					<td>
						<c:if test="${nurser.perinealWashType == '0'}">
							<c:if test="${nurser.perinealWashInterval == '1'}">每天</c:if>
							<c:if test="${nurser.perinealWashInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.perinealWashInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.perinealWashInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.perinealWashType == '1'}">
							<c:if test="${nurser.perinealWashInterval == '1'}">每周</c:if>
							<c:if test="${nurser.perinealWashInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.perinealWashInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.perinealWashInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.perinealWashDetails}
					</td>
					<td>${nurser.perinealWashQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.perinealWashTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.bathBath}">checked="checked"</c:if>>介护洗澡   
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.bathBath,'51')}"> ${nurser.perinealWashOther }每周一次</c:if>
						<c:if test="${fns:containStr(nurser.bathBath,'0')}" >${nurser.bathBathOther }</c:if>
					</td>
					<td>${nurser.bathBathQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.bathBathTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.washHair}">checked="checked"</c:if>>介护洗头
					</td>
					<td>
						<c:if test="${nurser.washHairType == '0'}">
							<c:if test="${nurser.washHairInterval == '1'}">每天</c:if>
							<c:if test="${nurser.washHairInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.washHairInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.washHairInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.washHairType == '1'}">
							<c:if test="${nurser.washHairInterval == '1'}">每周</c:if>
							<c:if test="${nurser.washHairInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.washHairInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.washHairInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.washHairDetails}
					</td>
					<td>${nurser.washHairQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.washHairTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.oralMedicine}">checked="checked"</c:if>>介护服药   
					</td>
					<td>
						<c:if test="${nurser.oralMedicineType == '0'}">
							<c:if test="${nurser.oralMedicineInterval == '1'}">每天</c:if>
							<c:if test="${nurser.oralMedicineInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.oralMedicineInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.oralMedicineInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.oralMedicineType == '1'}">
							<c:if test="${nurser.oralMedicineInterval == '1'}">每周</c:if>
							<c:if test="${nurser.oralMedicineInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.oralMedicineInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.oralMedicineInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.oralMedicineDetails}
					</td>
					<td>${nurser.oralMedicineQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.oralMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.chineseMedicine}">checked="checked"</c:if>>介护服中药   
					</td>
					<td>
						<c:if test="${nurser.chineseMedicineType == '0'}">
							<c:if test="${nurser.chineseMedicineInterval == '1'}">每天</c:if>
							<c:if test="${nurser.chineseMedicineInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.chineseMedicineInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.chineseMedicineInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.chineseMedicineType == '1'}">
							<c:if test="${nurser.chineseMedicineInterval == '1'}">每周</c:if>
							<c:if test="${nurser.chineseMedicineInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.chineseMedicineInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.chineseMedicineInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.chineseMedicineDetails}
					</td>
					<td>${nurser.chineseMedicineQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.chineseMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.turnOver}">checked="checked"</c:if>>翻身
					</td>
					<td>
						<c:if test="${nurser.turnOverType == '0'}">
							<c:if test="${nurser.turnOverInterval == '1'}">每天</c:if>
							<c:if test="${nurser.turnOverInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.turnOverInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.turnOverInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.turnOverType == '1'}">
							<c:if test="${nurser.turnOverInterval == '1'}">每周</c:if>
							<c:if test="${nurser.turnOverInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.turnOverInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.turnOverInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.turnOverDetails}
					</td>
					<td>${nurser.turnOverQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.turnOverTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.backslap}">checked="checked"</c:if>>拍背
					</td>
					<td>
						<c:if test="${nurser.backslapType == '0'}">
							<c:if test="${nurser.backslapInterval == '1'}">每天</c:if>
							<c:if test="${nurser.backslapInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.backslapInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.backslapInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.backslapType == '1'}">
							<c:if test="${nurser.backslapInterval == '1'}">每周</c:if>
							<c:if test="${nurser.backslapInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.backslapInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.backslapInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.backslapDetails}
					</td>
					<td>${nurser.backslapQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.backslapTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.skipWatch}">checked="checked"</c:if>>皮肤观察  
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.skipWatch,'1')}" >床单元整洁</c:if>
						<c:if test="${fns:containStr(nurser.skipWatch,'2')}" >皮肤观察</c:if>
						<c:if test="${fns:containStr(nurser.skipWatch,'3')}" >每小时一次</c:if>
						<c:if test="${fns:containStr(nurser.skipWatch,'4')}" >每两小时一次</c:if>
						<c:if test="${fns:containStr(nurser.skipWatch,'5')}" >每四小时一次</c:if>
						<c:if test="${fns:containStr(nurser.skipWatch,'6')}" >每六小时一次</c:if>
					</td>
					<td>${nurser.skipWatchQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.skipWatchTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.bellyMassage}">checked="checked"</c:if>>下腹部按摩  
					</td>
					<td>
						<c:if test="${nurser.bellyMassageType == '0'}">
							<c:if test="${nurser.bellyMassageInterval == '1'}">每天</c:if>
							<c:if test="${nurser.bellyMassageInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.bellyMassageInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.bellyMassageInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.bellyMassageType == '1'}">
							<c:if test="${nurser.bellyMassageInterval == '1'}">每周</c:if>
							<c:if test="${nurser.bellyMassageInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.bellyMassageInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.bellyMassageInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.bellyMassageDetails}
					</td>
					<td>${nurser.bellyMassageQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.bellyMassageTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.drinkWater}">checked="checked"</c:if>>饮水
					</td>
					<td>
						<c:if test="${nurser.drinkWaterType == '0'}">
							<c:if test="${nurser.drinkWaterInterval == '1'}">每天</c:if>
							<c:if test="${nurser.drinkWaterInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.drinkWaterInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.drinkWaterInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.drinkWaterType == '1'}">
							<c:if test="${nurser.drinkWaterInterval == '1'}">每周</c:if>
							<c:if test="${nurser.drinkWaterInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.drinkWaterInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.drinkWaterInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.drinkWaterDetails}
					</td>
					<td>${nurser.drinkWaterQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.drinkWaterTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.communicate}">checked="checked"</c:if>>沟通
					</td>
					<td>
						<c:if test="${nurser.communicateType == '0'}">
							<c:if test="${nurser.communicateInterval == '1'}">每天</c:if>
							<c:if test="${nurser.communicateInterval == '2'}">隔天</c:if>
							<c:if test="${nurser.communicateInterval == '3'}">隔两天</c:if>
							<c:if test="${nurser.communicateInterval == '4'}">隔三天</c:if>
						</c:if>
						<c:if test="${nurser.communicateType == '1'}">
							<c:if test="${nurser.communicateInterval == '1'}">每周</c:if>
							<c:if test="${nurser.communicateInterval == '2'}">隔周</c:if>
							<c:if test="${nurser.communicateInterval == '3'}">隔两周</c:if>
							<c:if test="${nurser.communicateInterval == '4'}">隔三周</c:if>
						</c:if>
						${nurser.communicateDetails}
					</td>
					<td>${nurser.communicateQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.communicateTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
			</table>
			<div class="lineDiv"><input type="button" value="照护项目"></div>
			<table class="interveneTable">
				<tr>
					<th width="15%"></th>
					<th width="55%"></th>
					<th width="15%">执行人(岗位)</th>
					<th width="15%">开始执行时间</th>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.dailyLife}">checked="checked"</c:if>>日常生活活动能力下降  
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.dailyLife,'1')}" >常用物品放置在老人易取的地方,</c:if>
						<c:if test="${fns:containStr(nurser.dailyLife,'2')}" >协助进食,</c:if>
						<c:if test="${fns:containStr(nurser.dailyLife,'3')}" >协助洗漱,</c:if>
						<c:if test="${fns:containStr(nurser.dailyLife,'4')}" >协助更衣</c:if>
					</td>
					<td>${nurser.dailyLifeQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.dailyLifeTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.skipIntegrity}">checked="checked"</c:if>>皮肤完整性受损的危险 
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.skipIntegrity,'1')}" >评估危险因数并记录,</c:if>
						<c:if test="${fns:containStr(nurser.skipIntegrity,'2')}" >环境安全管理,</c:if>
						<c:if test="${fns:containStr(nurser.skipIntegrity,'3')}" >警示标识,</c:if>
						<c:if test="${fns:containStr(nurser.skipIntegrity,'4')}" >床档,</c:if>
						<c:if test="${fns:containStr(nurser.skipIntegrity,'5')}" >必要时使用安全带</c:if>
					</td>
					<td>${nurser.skipIntegrityQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.skipIntegrityTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.anxiety}">checked="checked"</c:if>>孤独、焦虑
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.anxiety,'1')}" >听音乐,</c:if>
						<c:if test="${fns:containStr(nurser.anxiety,'2')}" >看电视,</c:if>
						<c:if test="${fns:containStr(nurser.anxiety,'3')}" >折纸,</c:if>
						<c:if test="${fns:containStr(nurser.anxiety,'4')}" >熟悉的话题沟通,</c:if>
						<c:if test="${fns:containStr(nurser.anxiety,'5')}" >心理支持,</c:if>
						<c:if test="${fns:containStr(nurser.anxiety,'6')}" >使用肢体语言沟通,</c:if>
						<c:if test="${fns:containStr(nurser.anxiety,'7')}" >借助纸笔方式沟通,</c:if>
						<c:if test="${fns:containStr(nurser.anxiety,'0')}" >其他（采用是否问答方式）</c:if>
					</td>
					<td>${nurser.anxietyQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.anxietyTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.solicitude}">checked="checked"</c:if>>关怀
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.solicitude,'1')}" >职业尊称,</c:if>
						<c:if test="${fns:containStr(nurser.solicitude,'2')}" >职务尊称,</c:if>
						<c:if test="${fns:containStr(nurser.solicitude,'3')}" >年龄尊称,</c:if>
						<c:if test="${fns:containStr(nurser.solicitude,'4')}" >心理慰籍[每天两次]</c:if>
					</td>
					<td>${nurser.solicitudeQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.solicitudeTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.walkTrain}">checked="checked"</c:if>>行走训练
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.walkTrain,'1')}" >协助行走,</c:if>
						<c:if test="${fns:containStr(nurser.walkTrain,'2')}" >提供安静舒适的病区环境,</c:if>
						<c:if test="${fns:containStr(nurser.walkTrain,'3')}" >尽量减少对患者的干扰</c:if>
					</td>
					<td>${nurser.walkTrainQuartersNm}
					<td><fmt:formatDate value="${nurser.walkTrainTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.astriction}">checked="checked"</c:if>>便秘
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.astriction,'1')}" >饮食指导,</c:if>
						<c:if test="${fns:containStr(nurser.astriction,'2')}" >活动指导,</c:if>
						<c:if test="${fns:containStr(nurser.astriction,'3')}" >药物应用,</c:if>
						<c:if test="${fns:containStr(nurser.astriction,'4')}" >下腹部顺时针按摩,</c:if>
						<c:if test="${fns:containStr(nurser.astriction,'5')}" >记录排便次数</c:if>
					</td>
					<td>${nurser.astrictionQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.astrictionTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.potentialInfection}">checked="checked"</c:if>>潜在并发症：感染    
					</td>
					<td>
						<c:if test="${fns:containStr(nurser.potentialInfection,'1')}" >拍背,</c:if>
						<c:if test="${fns:containStr(nurser.potentialInfection,'2')}" >注意保暖,</c:if>
						<c:if test="${fns:containStr(nurser.potentialInfection,'3')}" >坐起,</c:if>
						<c:if test="${fns:containStr(nurser.potentialInfection,'4')}" >腔清洁 </c:if>
					</td>
					<td>${nurser.potentialInfectionQuartersNm}
					</td>
					<td><fmt:formatDate value="${nurser.potentialInfectionTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" type="checkbox" <c:if test="${not empty nurser.other}">checked="checked"</c:if>>其他
					</td>
					<td>
						${nurser.other }
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
