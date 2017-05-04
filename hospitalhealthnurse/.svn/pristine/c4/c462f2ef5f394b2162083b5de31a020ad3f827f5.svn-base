<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script type="text/javascript">
/**类型更改事件*/
function changeType(str){
	if($("#"+str+"Type").val() == '0'){
		$("#"+str+"Day").show();
		$("#"+str+"Week").hide();
		$("#"+str+"Details").show();
		$("#"+str+"Interval").val($("#"+str+"DaySelect").val());
	}else if($("#"+str+"Type").val() == '1'){
		$("#"+str+"Day").hide();
		$("#"+str+"Week").show();
		$("#"+str+"Details").show();
		$("#"+str+"Interval").val($("#"+str+"WeekSelect").val());
	}else{
		$("#"+str+"Day").hide();
		$("#"+str+"Week").hide();
		$("#"+str+"Details").hide();
	}
	$("#"+str+"Details").val("");
}
/**间隔天更改事件*/
function changeSelectDay(str){
	$("#"+str+"Interval").val($("#"+str+"DaySelect").val());
}
/**间隔一周更改事件*/
function changeSelectWeek(str){
	$("#"+str+"Interval").val($("#"+str+"WeekSelect").val());
}
/**静脉输液*/
function addVeinInfusion(){
	if($("#veinInfusionDetails").val().length>0){
		if($("#veinInfusionDetails").val().indexOf($("#veinInfusionHide").val()) == -1){
			$("#veinInfusionDetails").val($("#veinInfusionDetails").val()+";"+$("#veinInfusionHide").val());
		}
	}else{
		$("#veinInfusionDetails").val($("#veinInfusionHide").val());
	}
}

/**更换湿化瓶*/
function addreplaceWefFlask(){
	if($("#replaceWefFlaskDetails").val().length>0){
		if($("#replaceWefFlaskDetails").val().indexOf($("#replaceWefFlaskHide").val()) == -1){
			$("#replaceWefFlaskDetails").val($("#replaceWefFlaskDetails").val()+";"+$("#replaceWefFlaskHide").val());
		}
	}else{
		$("#replaceWefFlaskDetails").val($("#replaceWefFlaskHide").val());
	}
}

/**吸痰*/
function addsputumSuction(){
	if($("#sputumSuctionDetails").val().length>0){
		if($("#sputumSuctionDetails").val().indexOf($("#sputumSuctionHide").val()) == -1){
			$("#sputumSuctionDetails").val($("#sputumSuctionDetails").val()+";"+$("#sputumSuctionHide").val());
		}
	}else{
		$("#sputumSuctionDetails").val($("#sputumSuctionHide").val());
	}
}
/**雾化*/
function addatomization(){
	if($("#atomizationDetails").val().length>0){
		if($("#atomizationDetails").val().indexOf($("#atomizationHide").val()) == -1){
			$("#atomizationDetails").val($("#atomizationDetails").val()+";"+$("#atomizationHide").val());
		}
	}else{
		$("#atomizationDetails").val($("#atomizationHide").val());
	}
}
/**口腔护理*/
function addoralNuser(){
	if($("#oralNuserDetails").val().length>0){
		if($("#oralNuserDetails").val().indexOf($("#oralNuserHide").val()) == -1){
			$("#oralNuserDetails").val($("#oralNuserDetails").val()+";"+$("#oralNuserHide").val());
		}
	}else{
		$("#oralNuserDetails").val($("#oralNuserHide").val());
	}
}
/**尿管护理*/
function addureterNuser(){
	if($("#ureterNuserDetails").val().length>0){
		if($("#ureterNuserDetails").val().indexOf($("#ureterNuserHide").val()) == -1){
			$("#ureterNuserDetails").val($("#ureterNuserDetails").val()+";"+$("#ureterNuserHide").val());
		}
	}else{
		$("#ureterNuserDetails").val($("#ureterNuserHide").val());
	}
}
/**深静脉置管护理*/
function adddeepVein(){
	if($("#deepVeinDetails").val().length>0){
		if($("#deepVeinDetails").val().indexOf($("#deepVeinHide").val()) == -1){
			$("#deepVeinDetails").val($("#deepVeinDetails").val()+";"+$("#deepVeinHide").val());
		}
	}else{
		$("#deepVeinDetails").val($("#deepVeinHide").val());
	}
}
/**气管切开护理 */
function addtracheaNuser(){
	if($("#tracheaNuserDetails").val().length>0){
		if($("#tracheaNuserDetails").val().indexOf($("#tracheaNuserHide").val()) == -1){
			$("#tracheaNuserDetails").val($("#tracheaNuserDetails").val()+";"+$("#tracheaNuserHide").val());
		}
	}else{
		$("#tracheaNuserDetails").val($("#tracheaNuserHide").val());
	}
}
/**口服药*/
function addoralMedicine(){
	if($("#oralMedicineDetails").val().length>0){
		if($("#oralMedicineDetails").val().indexOf($("#oralMedicineHide").val()) == -1){
			$("#oralMedicineDetails").val($("#oralMedicineDetails").val()+";"+$("#oralMedicineHide").val());
		}
	}else{
		$("#oralMedicineDetails").val($("#oralMedicineHide").val());
	}
}
/**中药*/
function addchineseMedicine(){
	if($("#chineseMedicineDetails").val().length>0){
		if($("#chineseMedicineDetails").val().indexOf($("#chineseMedicineHide").val()) == -1){
			$("#chineseMedicineDetails").val($("#chineseMedicineDetails").val()+";"+$("#chineseMedicineHide").val());
		}
	}else{
		$("#chineseMedicineDetails").val($("#chineseMedicineHide").val());
	}
}
/**特殊用药*/
function addspecialMedicine(){
	if($("#specialMedicineDetails").val().length>0){
		if($("#specialMedicineDetails").val().indexOf($("#specialMedicineHide").val()) == -1){
			$("#specialMedicineDetails").val($("#specialMedicineDetails").val()+";"+$("#specialMedicineHide").val());
		}
	}else{
		$("#specialMedicineDetails").val($("#specialMedicineHide").val());
	}
}
/**营养餐*/
function addnutritionMeal(){
	if($("#nutritionMealDetails").val().length>0){
		if($("#nutritionMealDetails").val().indexOf($("#nutritionMealHide").val()) == -1){
			$("#nutritionMealDetails").val($("#nutritionMealDetails").val()+";"+$("#nutritionMealHide").val());
		}
	}else{
		$("#nutritionMealDetails").val($("#nutritionMealHide").val());
	}
}
</script>
<!-- 护理计划 -->
<form:form id="careForm" modelAttribute="care" action="${ctx}/healtharchives/intervene/saveCare" method="post">
	<%-- <input type="hidden" id="id" name="id" value="${care.id}"> --%>
	<input type="hidden" id="interveneId" name="interveneId" value="${intervene.id}">
	<div class="docDiv">
		<div class="doctorDiv">
			<label>临床诊断:</label>
			<input readonly="readonly" type="text" value="${assessment.diagnosis}"/>
		</div>
	</div>
	<div class="docDiv">
		<div class="doctorDiv">	
			计划有效日期：　
			<input id="careStartTime" name="careStartTime" type="text" class="Wdate input-medium required" 
					value="<fmt:formatDate value="${care.careStartTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
			<input id="careEndTime" name="careEndTime" type="text" class="Wdate input-medium required" 
				value="<fmt:formatDate value="${care.careEndTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#careStartTime').val()});"/>
		</div>
	</div>
	<div class="lineDiv"><input type="button" value="护理计划"></div>
	<table class="interveneTable">
		<tr>
			<th width="130"></th>
			<th></th>
			<th width="120">执行人(岗位)</th>
			<th width="140">开始执行时间</th>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="护理级别" <c:if test="${not empty care.nuserGrade}">checked="checked"</c:if>>
				护理级别
			</td>
			<td>
				<input type="checkbox" value="1" name="nuserGrade"
				<c:if test="${fns:containStr(care.nuserGrade,'1')}" >checked</c:if>>病危
				<input type="checkbox" value="2" name="nuserGrade"
				<c:if test="${fns:containStr(care.nuserGrade,'2')}" >checked</c:if>>病重
				<input type="checkbox" value="3" name="nuserGrade"
				<c:if test="${fns:containStr(care.nuserGrade,'3')}" >checked</c:if>>Ⅰ级护理
				<input type="checkbox" value="4" name="nuserGrade"
				<c:if test="${fns:containStr(care.nuserGrade,'4')}" >checked</c:if>>Ⅱ级护理
				<input type="checkbox" value="5" name="nuserGrade"
				<c:if test="${fns:containStr(care.nuserGrade,'5')}" >checked</c:if>>Ⅲ级护理
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="nuserGradeQuartersId" name="nuserGradeQuartersId"
		value="${care.nuserGradeQuartersId}" labelName="nuserGradeQuartersNm"  labelValue="${care.nuserGradeQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="nuserGradeTime" name="nuserGradeTime" type="text" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.nuserGradeTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="饮食护理" <c:if test="${not empty care.deitNuser}">checked="checked"</c:if>>
				饮食护理
			</td>
			<td>
				<input type="checkbox" value="1" name="deitNuser"
				<c:if test="${fns:containStr(care.deitNuser,'1')}" >checked</c:if>>普通饮食
				<input type="checkbox" value="2" name="deitNuser"
				<c:if test="${fns:containStr(care.deitNuser,'2')}" >checked</c:if>>流质饮食
				<input type="checkbox" value="3" name="deitNuser"
				<c:if test="${fns:containStr(care.deitNuser,'3')}" >checked</c:if>>低盐低脂饮食
				<input type="checkbox" value="4" name="deitNuser"
				<c:if test="${fns:containStr(care.deitNuser,'4')}" >checked</c:if>>糖尿病饮食
				<input type="checkbox" value="5" name="deitNuser"
				<c:if test="${fns:containStr(care.deitNuser,'5')}" >checked</c:if>>软食
				<input type="checkbox" value="6" name="deitNuser"
				<c:if test="${fns:containStr(care.deitNuser,'6')}" >checked</c:if>>禁食
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="deitNuserQuartersId" name="deitNuserQuartersId" 
		value="${care.deitNuserQuartersId}" labelName="deitNuserQuartersNm"  labelValue="${care.deitNuserQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="deitNuserTime" name="deitNuserTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.deitNuserTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="静脉输液" <c:if test="${not empty care.veinInfusion}">checked="checked"</c:if>>
				静脉输液
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="veinInfusionType" name="veinInfusionType" onchange="changeType('veinInfusion')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.veinInfusionType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.veinInfusionType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="veinInfusionDay" class="dateDay" <c:if test="${care.veinInfusionType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('veinInfusion')" class="selectType" style="width: 100px;" id="veinInfusionDaySelect" name="veinInfusionDaySelect">
						<option value="1" <c:if test="${care.veinInfusionInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.veinInfusionInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.veinInfusionInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.veinInfusionInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'veinInfusionHide',dateFmt:'HH:mm',onpicked:addVeinInfusion})" class="btn" type="button" value="请选择" />
				</div>
				<div id="veinInfusionWeek" class="dateWeek" <c:if test="${care.veinInfusionType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('veinInfusion')" class="selectType" style="width: 100px;" id="veinInfusionWeekSelect" name="veinInfusionWeekSelect">
						<option value="1" <c:if test="${care.veinInfusionInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.veinInfusionInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.veinInfusionInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.veinInfusionInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'veinInfusionHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addVeinInfusion})" class="btn" type="button" value="请选择" />
				</div>
				<input id="veinInfusionHide" name="veinInfusionHide" type="hidden">
				<input id="veinInfusionInterval" name="veinInfusionInterval" value="${care.veinInfusionInterval }" type="hidden">
				<input id="veinInfusionDetails" name="veinInfusionDetails" type="text" readonly="readonly" value="${care.veinInfusionDetails}" <c:if test="${empty care.veinInfusionType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="veinInfusionQuartersId" name="veinInfusionQuartersId" 
		value="${care.veinInfusionQuartersId}" labelName="veinInfusionQuartersNm"  labelValue="${care.veinInfusionQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="veinInfusionTime" name="veinInfusionTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.veinInfusionTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="吸氧" <c:if test="${not empty care.oxygen}">checked="checked"</c:if>>
				吸氧
			</td>
			<td>
				<input type="checkbox" value="1" name="oxygen"
				<c:if test="${fns:containStr(care.oxygen,'1')}" >checked</c:if>>持续吸氧[
				<input type="checkbox" value="2" name="oxygen"
				<c:if test="${fns:containStr(care.oxygen,'2')}" >checked</c:if>>吸氧管
				<input type="checkbox" value="3" name="oxygen"
				<c:if test="${fns:containStr(care.oxygen,'3')}" >checked</c:if>>面罩]
				<input type="checkbox" value="4" name="oxygen"
				<c:if test="${fns:containStr(care.oxygen,'4')}" >checked</c:if>>间断吸氧
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="oxygenQuartersId" name="oxygenQuartersId" 
		value="${care.oxygenQuartersId}" labelName="oxygenQuartersNm"  labelValue="${care.oxygenQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="oxygenTime" name="oxygenTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.oxygenTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="更换湿化瓶" <c:if test="${not empty care.replaceWefFlask}">checked="checked"</c:if>>
				更换湿化瓶
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="replaceWefFlaskType" name="replaceWefFlaskType" onchange="changeType('replaceWefFlask')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.replaceWefFlaskType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.replaceWefFlaskType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="replaceWefFlaskDay" class="dateDay" <c:if test="${care.replaceWefFlaskType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('replaceWefFlask')" class="selectType" style="width: 100px;" id="replaceWefFlaskDaySelect" name="replaceWefFlaskDaySelect">
						<option value="1" <c:if test="${care.replaceWefFlaskInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.replaceWefFlaskInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.replaceWefFlaskInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.replaceWefFlaskInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'replaceWefFlaskHide',dateFmt:'HH:mm',onpicked:addreplaceWefFlask})" class="btn" type="button" value="请选择" />
				</div>
				<div id="replaceWefFlaskWeek" class="dateWeek" <c:if test="${care.replaceWefFlaskType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('replaceWefFlask')" class="selectType" style="width: 100px;" id="replaceWefFlaskWeekSelect" name="replaceWefFlaskWeekSelect">
						<option value="1" <c:if test="${care.replaceWefFlaskInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.replaceWefFlaskInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.replaceWefFlaskInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.replaceWefFlaskInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'replaceWefFlaskHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addreplaceWefFlask})" class="btn" type="button" value="请选择" />
				</div>
				<input id="replaceWefFlaskHide" name="replaceWefFlaskHide" type="hidden">
				<input id="replaceWefFlaskInterval" name="replaceWefFlaskInterval" value="${care.replaceWefFlaskInterval }" type="hidden">
				<input id="replaceWefFlaskDetails" name="replaceWefFlaskDetails" type="text" readonly="readonly" value="${care.replaceWefFlaskDetails}" <c:if test="${empty care.veinInfusionType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="replaceWefFlaskQuartersId" name="replaceWefFlaskQuartersId" 
		value="${care.replaceWefFlaskQuartersId}" labelName="replaceWefFlaskQuartersNm"  labelValue="${care.replaceWefFlaskQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="replaceWefFlaskTime" name="replaceWefFlaskTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.replaceWefFlaskTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="吸痰" <c:if test="${not empty care.sputumSuction}">checked="checked"</c:if>>
				吸痰 
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="sputumSuctionType" name="sputumSuctionType" onchange="changeType('sputumSuction')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.sputumSuctionType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.sputumSuctionType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="sputumSuctionDay" class="dateDay" <c:if test="${care.sputumSuctionType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('sputumSuction')" class="selectType" style="width: 100px;" id="sputumSuctionDaySelect" name="sputumSuctionDaySelect">
						<option value="1" <c:if test="${care.sputumSuctionInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.sputumSuctionInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.sputumSuctionInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.sputumSuctionInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'sputumSuctionHide',dateFmt:'HH:mm',onpicked:addsputumSuction})" class="btn" type="button" value="请选择" />
				</div>
				<div id="sputumSuctionWeek" class="dateWeek" <c:if test="${care.sputumSuctionType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('sputumSuction')" class="selectType" style="width: 100px;" id="sputumSuctionWeekSelect" name="sputumSuctionWeekSelect">
						<option value="1" <c:if test="${care.sputumSuctionInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.sputumSuctionInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.sputumSuctionInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.sputumSuctionInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'sputumSuctionHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addsputumSuction})" class="btn" type="button" value="请选择" />
				</div>
				<input id="sputumSuctionHide" name="sputumSuctionHide" type="hidden">
				<input id="sputumSuctionInterval" name="sputumSuctionInterval" value="${care.sputumSuctionInterval }" type="hidden">
				<input id="sputumSuctionDetails" name="sputumSuctionDetails" type="text" readonly="readonly" value="${care.sputumSuctionDetails}" <c:if test="${empty care.sputumSuctionType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="sputumSuctionQuartersId" name="sputumSuctionQuartersId" 
		value="${care.sputumSuctionQuartersId}" labelName="sputumSuctionQuartersNm"  labelValue="${care.sputumSuctionQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="sputumSuctionTime" name="sputumSuctionTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.sputumSuctionTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="雾化" <c:if test="${not empty care.atomization}">checked="checked"</c:if>>
				雾化
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="atomizationType" name="atomizationType" onchange="changeType('atomization')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.atomizationType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.atomizationType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="atomizationDay" class="dateDay" <c:if test="${care.atomizationType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('atomization')" class="selectType" style="width: 100px;" id="atomizationDaySelect" name="atomizationDaySelect">
						<option value="1" <c:if test="${care.atomizationInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.atomizationInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.atomizationInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.atomizationInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'atomizationHide',dateFmt:'HH:mm',onpicked:addatomization})" class="btn" type="button" value="请选择" />
				</div>
				<div id="atomizationWeek" class="dateWeek" <c:if test="${care.atomizationType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('atomization')" class="selectType" style="width: 100px;" id="atomizationWeekSelect" name="atomizationWeekSelect">
						<option value="1" <c:if test="${care.atomizationInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.atomizationInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.atomizationInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.atomizationInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'atomizationHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addatomization})" class="btn" type="button" value="请选择" />
				</div>
				<input id="atomizationHide" name="atomizationHide" type="hidden">
				<input id="atomizationInterval" name="atomizationInterval" value="${care.atomizationInterval }" type="hidden">
				<input id="atomizationDetails" name="atomizationDetails" type="text" readonly="readonly" value="${care.atomizationDetails}" <c:if test="${empty care.atomizationType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="atomizationQuartersId" name="atomizationQuartersId" 
		value="${care.atomizationQuartersId}" labelName="atomizationQuartersNm"  labelValue="${care.atomizationQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="atomizationTime" name="atomizationTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.atomizationTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="口腔护理" <c:if test="${not empty care.oralNuser}">checked="checked"</c:if>>
				口腔护理
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="oralNuserType" name="oralNuserType" onchange="changeType('oralNuser')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.oralNuserType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.oralNuserType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="oralNuserDay" class="dateDay" <c:if test="${care.oralNuserType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('oralNuser')" class="selectType" style="width: 100px;" id="oralNuserDaySelect" name="oralNuserDaySelect">
						<option value="1" <c:if test="${care.oralNuserInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.oralNuserInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.oralNuserInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.oralNuserInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'oralNuserHide',dateFmt:'HH:mm',onpicked:addoralNuser})" class="btn" type="button" value="请选择" />
				</div>
				<div id="oralNuserWeek" class="dateWeek" <c:if test="${care.oralNuserType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('oralNuser')" class="selectType" style="width: 100px;" id="oralNuserWeekSelect" name="oralNuserWeekSelect">
						<option value="1" <c:if test="${care.oralNuserInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.oralNuserInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.oralNuserInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.oralNuserInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'oralNuserHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addoralNuser})" class="btn" type="button" value="请选择" />
				</div>
				<input id="oralNuserHide" name="oralNuserHide" type="hidden">
				<input id="oralNuserInterval" name="oralNuserInterval" value="${care.oralNuserInterval }" type="hidden">
				<input id="oralNuserDetails" name="oralNuserDetails" type="text" readonly="readonly" value="${care.oralNuserDetails}" <c:if test="${empty care.oralNuserType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="oralNuserQuartersId" name="oralNuserQuartersId" 
		value="${care.oralNuserQuartersId}" labelName="oralNuserQuartersNm"  labelValue="${care.oralNuserQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="oralNuserTime" name="oralNuserTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.oralNuserTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="尿管护理" <c:if test="${not empty care.ureterNuser}">checked="checked"</c:if>>
				尿管护理
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="ureterNuserType" name="ureterNuserType" onchange="changeType('ureterNuser')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.ureterNuserType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.ureterNuserType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="ureterNuserDay" class="dateDay" <c:if test="${care.ureterNuserType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('ureterNuser')" class="selectType" style="width: 100px;" id="ureterNuserDaySelect" name="ureterNuserDaySelect">
						<option value="1" <c:if test="${care.ureterNuserInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.ureterNuserInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.ureterNuserInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.ureterNuserInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'ureterNuserHide',dateFmt:'HH:mm',onpicked:addureterNuser})" class="btn" type="button" value="请选择" />
				</div>
				<div id="ureterNuserWeek" class="dateWeek" <c:if test="${care.ureterNuserType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('ureterNuser')" class="selectType" style="width: 100px;" id="ureterNuserWeekSelect" name="ureterNuserWeekSelect">
						<option value="1" <c:if test="${care.ureterNuserInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.ureterNuserInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.ureterNuserInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.ureterNuserInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'ureterNuserHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addureterNuser})" class="btn" type="button" value="请选择" />
				</div>
				<input id="ureterNuserHide" name="ureterNuserHide" type="hidden">
				<input id="ureterNuserInterval" name="ureterNuserInterval" value="${care.ureterNuserInterval }" type="hidden">
				<input id="ureterNuserDetails" name="ureterNuserDetails" type="text" readonly="readonly" value="${care.ureterNuserDetails}" <c:if test="${empty care.ureterNuserType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="ureterNuserQuartersId" name="ureterNuserQuartersId" 
		value="${care.ureterNuserQuartersId}" labelName="ureterNuserQuartersNm"  labelValue="${care.ureterNuserQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="ureterNuserTime" name="ureterNuserTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.ureterNuserTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="深静脉置管护理" <c:if test="${not empty care.deepVein}">checked="checked"</c:if>>深静脉置管护理
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="deepVeinType" name="deepVeinType" onchange="changeType('deepVein')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.deepVeinType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.deepVeinType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="deepVeinDay" class="dateDay" <c:if test="${care.deepVeinType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('deepVein')" class="selectType" style="width: 100px;" id="deepVeinDaySelect" name="deepVeinDaySelect">
						<option value="1" <c:if test="${care.deepVeinInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.deepVeinInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.deepVeinInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.deepVeinInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'deepVeinHide',dateFmt:'HH:mm',onpicked:adddeepVein})" class="btn" type="button" value="请选择" />
				</div>
				<div id="deepVeinWeek" class="dateWeek" <c:if test="${care.deepVeinType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('deepVein')" class="selectType" style="width: 100px;" id="deepVeinWeekSelect" name="deepVeinWeekSelect">
						<option value="1" <c:if test="${care.deepVeinInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.deepVeinInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.deepVeinInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.deepVeinInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'deepVeinHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:adddeepVein})" class="btn" type="button" value="请选择" />
				</div>
				<input id="deepVeinHide" name="deepVeinHide" type="hidden">
				<input id="deepVeinInterval" name="deepVeinInterval" value="${care.deepVeinInterval }" type="hidden">
				<input id="deepVeinDetails" name="deepVeinDetails" type="text" readonly="readonly" value="${care.deepVeinDetails}" <c:if test="${empty care.deepVeinType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="deepVeinQuartersId" name="deepVeinQuartersId" 
		value="${care.deepVeinQuartersId}" labelName="deepVeinQuartersNm"  labelValue="${care.deepVeinQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="deepVeinTime" name="deepVeinTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.deepVeinTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="气管切开护理 " <c:if test="${not empty care.tracheaNuser}">checked="checked"</c:if>>气管切开护理  
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="tracheaNuserType" name="tracheaNuserType" onchange="changeType('tracheaNuser')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.tracheaNuserType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.tracheaNuserType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="tracheaNuserDay" class="dateDay" <c:if test="${care.tracheaNuserType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('tracheaNuser')" class="selectType" style="width: 100px;" id="tracheaNuserDaySelect" name="tracheaNuserDaySelect">
						<option value="1" <c:if test="${care.tracheaNuserInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.tracheaNuserInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.tracheaNuserInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.tracheaNuserInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'tracheaNuserHide',dateFmt:'HH:mm',onpicked:addtracheaNuser})" class="btn" type="button" value="请选择" />
				</div>
				<div id="tracheaNuserWeek" class="dateWeek" <c:if test="${care.tracheaNuserType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('tracheaNuser')" class="selectType" style="width: 100px;" id="tracheaNuserWeekSelect" name="tracheaNuserWeekSelect">
						<option value="1" <c:if test="${care.tracheaNuserInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.tracheaNuserInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.tracheaNuserInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.tracheaNuserInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'tracheaNuserHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addtracheaNuser})" class="btn" type="button" value="请选择" />
				</div>
				<input id="tracheaNuserHide" name="tracheaNuserHide" type="hidden">
				<input id="tracheaNuserInterval" name="tracheaNuserInterval" value="${care.tracheaNuserInterval }" type="hidden">
				<input id="tracheaNuserDetails" name="tracheaNuserDetails" type="text" readonly="readonly" value="${care.tracheaNuserDetails}" <c:if test="${empty care.tracheaNuserType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="tracheaNuserQuartersId" name="tracheaNuserQuartersId" 
		value="${care.tracheaNuserQuartersId}" labelName="tracheaNuserQuartersNm"  labelValue="${care.tracheaNuserQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="tracheaNuserTime" name="tracheaNuserTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.tracheaNuserTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="口服药" <c:if test="${not empty care.oralMedicine}">checked="checked"</c:if>>口服药
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="oralMedicineType" name="oralMedicineType" onchange="changeType('oralMedicine')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.oralMedicineType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.oralMedicineType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="oralMedicineDay" class="dateDay" <c:if test="${care.oralMedicineType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('oralMedicine')" class="selectType" style="width: 100px;" id="oralMedicineDaySelect" name="oralMedicineDaySelect">
						<option value="1" <c:if test="${care.oralMedicineInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.oralMedicineInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.oralMedicineInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.oralMedicineInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'oralMedicineHide',dateFmt:'HH:mm',onpicked:addoralMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<div id="oralMedicineWeek" class="dateWeek" <c:if test="${care.oralMedicineType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('oralMedicine')" class="selectType" style="width: 100px;" id="oralMedicineWeekSelect" name="oralMedicineWeekSelect">
						<option value="1" <c:if test="${care.oralMedicineInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.oralMedicineInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.oralMedicineInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.oralMedicineInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'oralMedicineHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addoralMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<input id="oralMedicineHide" name="oralMedicineHide" type="hidden">
				<input id="oralMedicineInterval" name="oralMedicineInterval" value="${care.oralMedicineInterval }" type="hidden">
				<input id="oralMedicineDetails" name="oralMedicineDetails" type="text" readonly="readonly" value="${care.oralMedicineDetails}" <c:if test="${empty care.oralMedicineType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="oralMedicineQuartersId" name="oralMedicineQuartersId" 
		value="${care.oralMedicineQuartersId}" labelName="oralMedicineQuartersNm"  labelValue="${care.oralMedicineQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="oralMedicineTime" name="oralMedicineTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.oralMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="中药" <c:if test="${not empty care.chineseMedicine}">checked="checked"</c:if>>中药
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="chineseMedicineType" name="chineseMedicineType" onchange="changeType('chineseMedicine')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.chineseMedicineType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.chineseMedicineType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="chineseMedicineDay" class="dateDay" <c:if test="${care.chineseMedicineType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('chineseMedicine')" class="selectType" style="width: 100px;" id="chineseMedicineDaySelect" name="chineseMedicineDaySelect">
						<option value="1" <c:if test="${care.chineseMedicineInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.chineseMedicineInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.chineseMedicineInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.chineseMedicineInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'chineseMedicineHide',dateFmt:'HH:mm',onpicked:addchineseMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<div id="chineseMedicineWeek" class="dateWeek" <c:if test="${care.chineseMedicineType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('chineseMedicine')" class="selectType" style="width: 100px;" id="chineseMedicineWeekSelect" name="chineseMedicineWeekSelect">
						<option value="1" <c:if test="${care.chineseMedicineInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.chineseMedicineInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.chineseMedicineInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.chineseMedicineInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'chineseMedicineHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addchineseMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<input id="chineseMedicineHide" name="chineseMedicineHide" type="hidden">
				<input id="chineseMedicineInterval" name="chineseMedicineInterval" value="${care.chineseMedicineInterval }" type="hidden">
				<input id="chineseMedicineDetails" name="chineseMedicineDetails" type="text" readonly="readonly" value="${care.chineseMedicineDetails}" <c:if test="${empty care.ureterNuserType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="chineseMedicineQuartersId" name="chineseMedicineQuartersId" 
		value="${care.chineseMedicineQuartersId}" labelName="chineseMedicineQuartersNm"  labelValue="${care.chineseMedicineQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="chineseMedicineTime" name="chineseMedicineTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.chineseMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="特殊用药" <c:if test="${not empty care.specialMedicine}">checked="checked"</c:if>>特殊用药
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="specialMedicineType" name="specialMedicineType" onchange="changeType('specialMedicine')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.specialMedicineType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.specialMedicineType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="specialMedicineDay" class="dateDay" <c:if test="${care.specialMedicineType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('specialMedicine')" class="selectType" style="width: 100px;" id="specialMedicineDaySelect" name="specialMedicineDaySelect">
						<option value="1" <c:if test="${care.specialMedicineInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.specialMedicineInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.specialMedicineInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.specialMedicineInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'specialMedicineHide',dateFmt:'HH:mm',onpicked:addspecialMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<div id="specialMedicineWeek" class="dateWeek" <c:if test="${care.specialMedicineType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('specialMedicine')" class="selectType" style="width: 100px;" id="specialMedicineWeekSelect" name="specialMedicineWeekSelect">
						<option value="1" <c:if test="${care.specialMedicineInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.specialMedicineInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.specialMedicineInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.specialMedicineInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'specialMedicineHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addspecialMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<input id="specialMedicineHide" name="specialMedicineHide" type="hidden">
				<input id="specialMedicineInterval" name="specialMedicineInterval" value="${care.specialMedicineInterval }" type="hidden">
				<input id="specialMedicineDetails" name="specialMedicineDetails" type="text" readonly="readonly" value="${care.specialMedicineDetails}" <c:if test="${empty care.specialMedicineType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="specialMedicineQuartersId" name="specialMedicineQuartersId" 
		value="${care.specialMedicineQuartersId}" labelName="specialMedicineQuartersNm"  labelValue="${care.specialMedicineQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="specialMedicineTime" name="specialMedicineTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.specialMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="康复护理" <c:if test="${not empty care.recoveryNuser}">checked="checked"</c:if>>康复护理
			</td>
			<td>
				<input type="checkbox" value="1" name="recoveryNuser"
				<c:if test="${fns:containStr(care.recoveryNuser,'1')}" >checked</c:if>>良肢位摆放
				<input type="checkbox" value="2" name="recoveryNuser"
				<c:if test="${fns:containStr(care.recoveryNuser,'2')}" >checked</c:if>>进食（饮水）训练
				<input type="checkbox" value="3" name="recoveryNuser"
				<c:if test="${fns:containStr(care.recoveryNuser,'3')}" >checked</c:if>>行走训练
				<input type="checkbox" value="4" name="recoveryNuser"
				<c:if test="${fns:containStr(care.recoveryNuser,'4')}" >checked</c:if>>穿衣训练
				<input type="checkbox" value="5" name="recoveryNuser"
				<c:if test="${fns:containStr(care.recoveryNuser,'5')}" >checked</c:if>>洗漱训练
				<input type="checkbox" value="6" name="recoveryNuser"
				<c:if test="${fns:containStr(care.recoveryNuser,'6')}" >checked</c:if>>记忆力训练
				<input type="checkbox" value="0" name="recoveryNuser"
				<c:if test="${fns:containStr(care.recoveryNuser,'0')}" >checked</c:if>>其他
				<input type="text" maxlength="50" value="${care.recoveryNuserOther }" id="recoveryNuserOther" name="recoveryNuserOther"/>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="recoveryNuserQuartersId" name="recoveryNuserQuartersId" 
		value="${care.recoveryNuserQuartersId}" labelName="recoveryNuserQuartersNm"  labelValue="${care.recoveryNuserQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="recoveryNuserTime" name="recoveryNuserTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.recoveryNuserTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="营养餐" <c:if test="${not empty care.nutritionMeal}">checked="checked"</c:if>>营养餐
			</td>
			<td>				
				<select class="selectType" style="width: 100px;" id="nutritionMealType" name="nutritionMealType" onchange="changeType('nutritionMeal')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${care.nutritionMealType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${care.nutritionMealType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="nutritionMealDay" class="dateDay" <c:if test="${care.nutritionMealType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('nutritionMeal')" class="selectType" style="width: 100px;" id="nutritionMealDaySelect" name="nutritionMealDaySelect">
						<option value="1" <c:if test="${care.nutritionMealInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${care.nutritionMealInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${care.nutritionMealInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${care.nutritionMealInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'nutritionMealHide',dateFmt:'HH:mm',onpicked:addnutritionMeal})" class="btn" type="button" value="请选择" />
				</div>
				<div id="nutritionMealWeek" class="dateWeek" <c:if test="${care.nutritionMealType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('nutritionMeal')" class="selectType" style="width: 100px;" id="nutritionMealWeekSelect" name="nutritionMealWeekSelect">
						<option value="1" <c:if test="${care.nutritionMealInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${care.nutritionMealInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${care.nutritionMealInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${care.nutritionMealInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'nutritionMealHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addnutritionMeal})" class="btn" type="button" value="请选择" />
				</div>
				<input id="nutritionMealHide" name="nutritionMealHide" type="hidden">
				<input id="nutritionMealInterval" name="nutritionMealInterval" value="${care.nutritionMealInterval }" type="hidden">
				<input id="nutritionMealDetails" name="nutritionMealDetails" type="text" readonly="readonly" value="${care.nutritionMealDetails}" <c:if test="${empty care.nutritionMealType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="nutritionMealQuartersId" name="nutritionMealQuartersId" 
		value="${care.nutritionMealQuartersId}" labelName="nutritionMealQuartersNm"  labelValue="${care.nutritionMealQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="nutritionMealTime" name="nutritionMealTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.nutritionMealTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="健康教育" <c:if test="${not empty care.healthEducation}">checked="checked"</c:if>>健康教育
			</td>
			<td>
				<input type="checkbox" value="1" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'1')}" >checked</c:if>>高血压
				<input type="checkbox" value="2" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'2')}" >checked</c:if>>糖尿病
				<input type="checkbox" value="3" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'3')}" >checked</c:if>>肺炎
				<input type="checkbox" value="4" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'4')}" >checked</c:if>>COPD
				<input type="checkbox" value="5" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'5')}" >checked</c:if>>冠心病
				<input type="checkbox" value="6" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'6')}" >checked</c:if>>痛风
				<input type="checkbox" value="7" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'7')}" >checked</c:if>>脑梗塞（脑出血）
				<input type="checkbox" value="8" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'8')}" >checked</c:if>>帕金森
				<input type="checkbox" value="9" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'9')}" >checked</c:if>>美尼尔氏综合症
				<input type="checkbox" value="10" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'10')}" >checked</c:if>>消化道出血
				<input type="checkbox" value="0" name="healthEducation"
				<c:if test="${fns:containStr(care.healthEducation,'0')}" >checked</c:if>>其他
				<input type="text" maxlength="50" value="${care.healthEducationOther }" id="healthEducationOther" name="healthEducationOther"/>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="healthEducationQuartersId" name="healthEducationQuartersId" 
		value="${care.healthEducationQuartersId}" labelName="healthEducationQuartersNm"  labelValue="${care.healthEducationQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="healthEducationTime" name="healthEducationTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.healthEducationTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
	</table>
	<div class="lineDiv"><input type="button" value="新增项目" onclick="addItem('addCare')"></div>
	<table id="addCare" class="interveneTable">
		<c:forEach items="${care.extList}" var="ext">
		<tr id="${ext.id}">
			<td><input type="hidden" name="extraItemsId" value="${ext.id}"> ${ext.projectNm}</td>
			<td>
				<c:if test="${ext.frequencyType == '0'}">
					<c:if test="${ext.intervals == '1'}">每天</c:if>
					<c:if test="${ext.intervals == '2'}">隔天</c:if>
					<c:if test="${ext.intervals == '3'}">隔两天</c:if>
					<c:if test="${ext.intervals == '4'}">隔三天</c:if>
				</c:if>
				<c:if test="${ext.frequencyType == '1'}">
					<c:if test="${ext.intervals == '1'}">每周</c:if>
					<c:if test="${ext.intervals == '2'}">隔周</c:if>
					<c:if test="${ext.intervals == '3'}">隔两周</c:if>
					<c:if test="${ext.intervals == '4'}">隔三周</c:if>
				</c:if>
				${ext.dateArray}
			</td>
			<td>${ext.quartersNm}</td>
			<td><fmt:formatDate value="${ext.exeTime}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td><a onclick="deleteExt(${ext.id})">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	<div class="lineDiv"><input type="button" value="护理诊断"></div>
	<table class="interveneTable">
		<tr>
			<th width="130"></th>
			<th></th>
			<th width="120">执行人(岗位)</th>
			<th width="140">开始执行时间</th>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="跌倒风险" <c:if test="${not empty care.fallRisk}">checked="checked"</c:if>>跌倒风险
			</td>
			<td>
				<input type="checkbox" value="1" name="fallRisk"
				<c:if test="${fns:containStr(care.fallRisk,'1')}" >checked</c:if>>评估危险因数并记录
				<input type="checkbox" value="2" name="fallRisk"
				<c:if test="${fns:containStr(care.fallRisk,'2')}" >checked</c:if>>环境安全管理
				<input type="checkbox" value="3" name="fallRisk"
				<c:if test="${fns:containStr(care.fallRisk,'3')}" >checked</c:if>>警示标识
				<input type="checkbox" value="4" name="fallRisk"
				<c:if test="${fns:containStr(care.fallRisk,'4')}" >checked</c:if>>床档
				<input type="checkbox" value="5" name="fallRisk"
				<c:if test="${fns:containStr(care.fallRisk,'5')}" >checked</c:if>>保护性约束
				<input type="checkbox" value="6" name="fallRisk"
				<c:if test="${fns:containStr(care.fallRisk,'6')}" >checked</c:if>>陪护
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="fallRiskQuartersId" name="fallRiskQuartersId" 
		value="${care.fallRiskQuartersId}" labelName="fallRiskQuartersNm"  labelValue="${care.fallRiskQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="fallRiskTime" name="fallRiskTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.fallRiskTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="压疮风险" <c:if test="${not empty care.ulcerRisk}">checked="checked"</c:if>>压疮风险
			</td>
			<td>
				<input type="checkbox" value="1" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'1')}" >checked</c:if>>评估皮肤受损的危险因数并记录
				<input type="checkbox" value="2" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'2')}" >checked</c:if>>当时正确更换体位
				<input type="checkbox" value="3" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'3')}" >checked</c:if>>警示标识
				<input type="checkbox" value="4" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'4')}" >checked</c:if>>给予减压用具
				<input type="checkbox" value="5" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'5')}" >checked</c:if>>定时翻身[
				<input type="checkbox" value="6" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'6')}" >checked</c:if>>每小时一次
				<input type="checkbox" value="7" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'7')}" >checked</c:if>>每两小时一次
				<input type="checkbox" value="8" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'8')}" >checked</c:if>>每四小时一次
				<input type="checkbox" value="9" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'9')}" >checked</c:if>>其他
				<input type="text" maxlength="50" value="${care.ulcerRiskOtherTwo }" id="ulcerRiskOtherTwo" name="ulcerRiskOtherTwo"/>]
				<input type="checkbox" value="10" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'10')}" >checked</c:if>>营养指导
				<input type="checkbox" value="11" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'11')}" >checked</c:if>>皮肤护理[洗澡（擦拭）
				<input type="checkbox" value="12" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'12')}" >checked</c:if>>每天一次
				<input type="checkbox" value="13" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'13')}" >checked</c:if>>隔天一次
				<input type="checkbox" value="14" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'14')}" >checked</c:if>>每周四次
				<input type="checkbox" value="15" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'15')}" >checked</c:if>>其他
				<input type="text" maxlength="50" value="${care.ulcerRiskOtherThree }" id="ulcerRiskOtherThree" name="ulcerRiskOtherThree"/>]
				<input type="checkbox" value="0" name="ulcerRisk"
				<c:if test="${fns:containStr(care.ulcerRisk,'0')}" >checked</c:if>>其他
				<input type="text" maxlength="50" value="${care.ulcerRiskOther }" id="ulcerRiskOther" name="ulcerRiskOther"/>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="ulcerRiskQuartersId" name="ulcerRiskQuartersId" 
		value="${care.ulcerRiskQuartersId}" labelName="ulcerRiskQuartersNm"  labelValue="${care.ulcerRiskQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="ulcerRiskTime" name="ulcerRiskTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.ulcerRiskTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="孤独、焦虑、抑郁" <c:if test="${not empty care.anxiety}">checked="checked"</c:if>>孤独、焦虑、抑郁
			</td>
			<td>
				<input type="checkbox" value="1" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'1')}" >checked</c:if>>讲解疾病治疗、转归及预后知识
				<input type="checkbox" value="2" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'2')}" >checked</c:if>>指导患者采取放松措施[
				<input type="checkbox" value="3" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'3')}" >checked</c:if>>听音乐
				<input type="checkbox" value="4" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'4')}" >checked</c:if>>讲故事
				<input type="checkbox" value="5" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'5')}" >checked</c:if>>聊天
				<input type="checkbox" value="6" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'6')}" >checked</c:if>>看电视
				<input type="checkbox" value="0" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'0')}" >checked</c:if>>其他
				<input type="text" maxlength="50" value="${care.anxietyOther }" id="anxietyOther" name="anxietyOther"/>]
				<input type="checkbox" value="7" name="anxiety"
				<c:if test="${fns:containStr(care.anxiety,'7')}" >checked</c:if>>心理支持
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="anxietyQuartersId" name="anxietyQuartersId" 
		value="${care.anxietyQuartersId}" labelName="anxietyQuartersNm"  labelValue="${care.anxietyQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="anxietyTime" name="anxietyTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.anxietyTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="语言沟通障碍" <c:if test="${not empty care.languageBalk}">checked="checked"</c:if>>语言沟通障碍
			</td>
			<td>
				<input type="checkbox" value="1" name="languageBalk"
				<c:if test="${fns:containStr(care.languageBalk,'1')}" >checked</c:if>>尊重患者
				<input type="checkbox" value="2" name="languageBalk"
				<c:if test="${fns:containStr(care.languageBalk,'2')}" >checked</c:if>>使用肢体语言沟通
				<input type="checkbox" value="3" name="languageBalk"
				<c:if test="${fns:containStr(care.languageBalk,'3')}" >checked</c:if>>借助纸笔方式沟通
				<input type="checkbox" value="4" name="languageBalk"
				<c:if test="${fns:containStr(care.languageBalk,'4')}" >checked</c:if>>其他（采用是否问答方式）
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="languageBalkQuartersId" name="languageBalkQuartersId" 
		value="${care.languageBalkQuartersId}" labelName="languageBalkQuartersNm"  labelValue="${care.languageBalkQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="languageBalkTime" name="languageBalkTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.languageBalkTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="睡眠状态紊乱" <c:if test="${not empty care.sleepDisorder}">checked="checked"</c:if>>睡眠状态紊乱
			</td>
			<td>
				<input type="checkbox" value="1" name="sleepDisorder"
				<c:if test="${fns:containStr(care.sleepDisorder,'1')}" >checked</c:if>>提供安静舒适的病区环境
				<input type="checkbox" value="2" name="sleepDisorder"
				<c:if test="${fns:containStr(care.sleepDisorder,'2')}" >checked</c:if>>尽量减少对患者的干扰
				<input type="checkbox" value="3" name="sleepDisorder"
				<c:if test="${fns:containStr(care.sleepDisorder,'3')}" >checked</c:if>>指导患者运用睡眠促进措施
				<input type="checkbox" value="4" name="sleepDisorder"
				<c:if test="${fns:containStr(care.sleepDisorder,'4')}" >checked</c:if>>遵医嘱用药并评价其效果
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="sleepDisorderQuartersId" name="sleepDisorderQuartersId" 
		value="${care.sleepDisorderQuartersId}" labelName="sleepDisorderQuartersNm"  labelValue="${care.sleepDisorderQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="sleepDisorderTime" name="sleepDisorderTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.sleepDisorderTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="体温过高" <c:if test="${not empty care.temperatureOvertop}">checked="checked"</c:if>>体温过高  
			</td>
			<td>
				<input type="checkbox" value="1" name="temperatureOvertop"
				<c:if test="${fns:containStr(care.temperatureOvertop,'1')}" >checked</c:if>>测量体温
				<input type="checkbox" value="2" name="temperatureOvertop"
				<c:if test="${fns:containStr(care.temperatureOvertop,'2')}" >checked</c:if>>物理降温
				<input type="checkbox" value="3" name="temperatureOvertop"
				<c:if test="${fns:containStr(care.temperatureOvertop,'3')}" >checked</c:if>>药物温度及效果观察
				<input type="checkbox" value="4" name="temperatureOvertop"
				<c:if test="${fns:containStr(care.temperatureOvertop,'4')}" >checked</c:if>>皮肤护理
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="temperatureOvertopQuartersId" name="temperatureOvertopQuartersId" 
		value="${care.temperatureOvertopQuartersId}" labelName="temperatureOvertopQuartersNm"  labelValue="${care.temperatureOvertopQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="temperatureOvertopTime" name="temperatureOvertopTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.temperatureOvertopTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="清理呼吸道无效 " <c:if test="${not empty care.respiratoryTract}">checked="checked"</c:if>>清理呼吸道无效 
			</td>
			<td>
				<input type="checkbox" value="1" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'1')}" >checked</c:if>>指导咳嗽
				<input type="checkbox" value="2" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'2')}" >checked</c:if>>呼吸训练[
				<input type="checkbox" value="3" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'3')}" >checked</c:if>>每天一次
				<input type="checkbox" value="4" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'4')}" >checked</c:if>>每天两次
				<input type="checkbox" value="5" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'5')}" >checked</c:if>>每天三次
				<input type="checkbox" value="0" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'0')}" >checked</c:if>>其他
				<input type="text" maxlength="50" value="${care.respiratoryTractOther }" id="respiratoryTractOther" name="respiratoryTractOther"/>]
				<input type="checkbox" value="6" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'6')}" >checked</c:if>>雾化吸入
				<input type="checkbox" value="7" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'7')}" >checked</c:if>>吸痰
				<input type="checkbox" value="8" name="respiratoryTract"
				<c:if test="${fns:containStr(care.respiratoryTract,'8')}" >checked</c:if>>体位引流
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="respiratoryTractQuartersId" name="respiratoryTractQuartersId" 
		value="${care.respiratoryTractQuartersId}" labelName="respiratoryTractQuartersNm"  labelValue="${care.respiratoryTractQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="respiratoryTractTime" name="respiratoryTractTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.respiratoryTractTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="疼痛" <c:if test="${not empty care.pain}">checked="checked"</c:if>>疼痛    
			</td>
			<td>
				<input type="checkbox" value="1" name="pain"
				<c:if test="${fns:containStr(care.pain,'1')}" >checked</c:if>>评估疼痛级别
				<input type="checkbox" value="2" name="pain"
				<c:if test="${fns:containStr(care.pain,'2')}" >checked</c:if>>观察记录疼痛性质、程度、规律
				<input type="checkbox" value="3" name="pain"
				<c:if test="${fns:containStr(care.pain,'3')}" >checked</c:if>>指导使用放松技术
				<input type="checkbox" value="4" name="pain"
				<c:if test="${fns:containStr(care.pain,'4')}" >checked</c:if>>按医嘱使用止痛剂
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="painQuartersId" name="painQuartersId" 
		value="${care.painQuartersId}" labelName="painQuartersNm"  labelValue="${care.painQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="painTime" name="painTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.painTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="便秘 " <c:if test="${not empty care.constipation}">checked="checked"</c:if>>便秘  
			</td>
			<td>
				<input type="checkbox" value="1" name="constipation"
				<c:if test="${fns:containStr(care.constipation,'1')}" >checked</c:if>>饮食指导
				<input type="checkbox" value="2" name="constipation"
				<c:if test="${fns:containStr(care.constipation,'2')}" >checked</c:if>>活动指导
				<input type="checkbox" value="3" name="constipation"
				<c:if test="${fns:containStr(care.constipation,'3')}" >checked</c:if>>局部按摩
				<input type="checkbox" value="4" name="constipation"
				<c:if test="${fns:containStr(care.constipation,'4')}" >checked</c:if>>缓泻剂应用
				<input type="checkbox" value="5" name="constipation"
				<c:if test="${fns:containStr(care.constipation,'5')}" >checked</c:if>>灌肠治疗
				<input type="checkbox" value="6" name="constipation"
				<c:if test="${fns:containStr(care.constipation,'6')}" >checked</c:if>>记录排便次数
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="constipationQuartersId" name="constipationQuartersId" 
		value="${care.constipationQuartersId}" labelName="constipationQuartersNm"  labelValue="${care.constipationQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="constipationTime" name="constipationTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.constipationTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="失禁" <c:if test="${not empty care.incontinence}">checked="checked"</c:if>>失禁
			</td>
			<td>
				<input type="checkbox" value="1" name="incontinence"
				<c:if test="${fns:containStr(care.incontinence,'1')}" >checked</c:if>>评估失禁程度
				<input type="checkbox" value="2" name="incontinence"
				<c:if test="${fns:containStr(care.incontinence,'2')}" >checked</c:if>>观察排尿规律
				<input type="checkbox" value="3" name="incontinence"
				<c:if test="${fns:containStr(care.incontinence,'3')}" >checked</c:if>>正确使用便器
				<input type="checkbox" value="4" name="incontinence"
				<c:if test="${fns:containStr(care.incontinence,'4')}" >checked</c:if>>帮助不方便的患者排尿
				<input type="checkbox" value="5" name="incontinence"
				<c:if test="${fns:containStr(care.incontinence,'5')}" >checked</c:if>>正确使用尿不湿
				<input type="checkbox" value="6" name="incontinence"
				<c:if test="${fns:containStr(care.incontinence,'6')}" >checked</c:if>>加强会阴部皮肤护理
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="incontinenceQuartersId" name="incontinenceQuartersId" 
		value="${care.incontinenceQuartersId}" labelName="incontinenceQuartersNm"  labelValue="${care.incontinenceQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="incontinenceTime" name="incontinenceTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.incontinenceTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="活动无耐力" <c:if test="${not empty care.activityIntolerance}">checked="checked"</c:if>>活动无耐力
			</td>
			<td>
				<input type="checkbox" value="1" name="activityIntolerance"
				<c:if test="${fns:containStr(care.activityIntolerance,'1')}" >checked</c:if>>评估患者活动能力
				<input type="checkbox" value="2" name="activityIntolerance"
				<c:if test="${fns:containStr(care.activityIntolerance,'2')}" >checked</c:if>>协助患者完成生活护理
				<input type="checkbox" value="3" name="activityIntolerance"
				<c:if test="${fns:containStr(care.activityIntolerance,'3')}" >checked</c:if>>防跌倒指导
				<input type="checkbox" value="4" name="activityIntolerance"
				<c:if test="${fns:containStr(care.activityIntolerance,'4')}" >checked</c:if>>指导床上活动
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="activityIntoleranceQuartersId" name="activityIntoleranceQuartersId" 
		value="${care.activityIntoleranceQuartersId}" labelName="activityIntoleranceQuartersNm"  labelValue="${care.activityIntoleranceQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="activityIntoleranceTime" name="activityIntoleranceTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.activityIntoleranceTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="潜在并发症：窒息" <c:if test="${not empty care.potentialAsphyxia}">checked="checked"</c:if>>潜在并发症：窒息 
			</td>
			<td>
				<input type="checkbox" value="1" name="potentialAsphyxia"
				<c:if test="${fns:containStr(care.potentialAsphyxia,'1')}" >checked</c:if>>评估可能发生窒息的危险因数并记录
				<input type="checkbox" value="2" name="potentialAsphyxia"
				<c:if test="${fns:containStr(care.potentialAsphyxia,'2')}" >checked</c:if>>保护呼吸道通畅
				<input type="checkbox" value="3" name="potentialAsphyxia"
				<c:if test="${fns:containStr(care.potentialAsphyxia,'3')}" >checked</c:if>>体位管理
				<input type="checkbox" value="4" name="potentialAsphyxia"
				<c:if test="${fns:containStr(care.potentialAsphyxia,'4')}" >checked</c:if>>床旁备吸痰器
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="potentialAsphyxiaQuartersId" name="potentialAsphyxiaQuartersId" 
		value="${care.potentialAsphyxiaQuartersId}" labelName="potentialAsphyxiaQuartersNm"  labelValue="${care.potentialAsphyxiaQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="potentialAsphyxiaTime" name="potentialAsphyxiaTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.potentialAsphyxiaTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="潜在并发症：出血" <c:if test="${not empty care.potentialBleeding}">checked="checked"</c:if>>潜在并发症：出血
			</td>
			<td>
				<input type="checkbox" value="1" name="potentialBleeding"
				<c:if test="${fns:containStr(care.potentialBleeding,'1')}" >checked</c:if>>检查生命体征、意识
				<input type="checkbox" value="2" name="potentialBleeding"
				<c:if test="${fns:containStr(care.potentialBleeding,'2')}" >checked</c:if>>观察引流物性质及量
				<input type="checkbox" value="3" name="potentialBleeding"
				<c:if test="${fns:containStr(care.potentialBleeding,'3')}" >checked</c:if>>观察伤口敷料
				<input type="checkbox" value="4" name="potentialBleeding"
				<c:if test="${fns:containStr(care.potentialBleeding,'4')}" >checked</c:if>>观察皮肤颜色及温度 
				<input type="checkbox" value="5" name="potentialBleeding"
				<c:if test="${fns:containStr(care.potentialBleeding,'5')}" >checked</c:if>>遵医嘱使用止血药
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="potentialBleedingQuartersId" name="potentialBleedingQuartersId" 
		value="${care.potentialBleedingQuartersId}" labelName="potentialBleedingQuartersNm"  labelValue="${care.potentialBleedingQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="potentialBleedingTime" name="potentialBleedingTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.potentialBleedingTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="潜在并发症：感染" <c:if test="${not empty care.potentialInfection}">checked="checked"</c:if>>潜在并发症：感染 
			</td>
			<td>
				<input type="checkbox" value="1" name="potentialInfection"
				<c:if test="${fns:containStr(care.potentialInfection,'1')}" >checked</c:if>>监测患者体温、脉搏
				<input type="checkbox" value="2" name="potentialInfection"
				<c:if test="${fns:containStr(care.potentialInfection,'2')}" >checked</c:if>>观察引流物的性质
				<input type="checkbox" value="3" name="potentialInfection"
				<c:if test="${fns:containStr(care.potentialInfection,'3')}" >checked</c:if>>加强管道护理
				<input type="checkbox" value="4" name="potentialInfection"
				<c:if test="${fns:containStr(care.potentialInfection,'4')}" >checked</c:if>>口腔护理
				<input type="checkbox" value="5" name="potentialInfection"
				<c:if test="${fns:containStr(care.potentialInfection,'5')}" >checked</c:if>>伤口护理
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="potentialInfectionQuartersId" name="potentialInfectionQuartersId" 
		value="${care.potentialInfectionQuartersId}" labelName="potentialInfectionQuartersNm"  labelValue="${care.potentialInfectionQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="potentialInfectionTime" name="potentialInfectionTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${care.potentialInfectionTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" <c:if test="${not empty care.other}">checked="checked"</c:if>>其他
			</td>
			<td>
				<input type="text" value="${care.other }" id="other" name="other"/>
			</td>
		</tr>
	</table>
	<div class="form-actions">
		<c:if test="${intervene.state == 0 || intervene.state == 2 }">
			<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="submitBut('careForm','${ctx}/healtharchives/care/saveCare')" value="保 存"/>&nbsp;
		</c:if>
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview('1');"/>
	</div>
</form:form>