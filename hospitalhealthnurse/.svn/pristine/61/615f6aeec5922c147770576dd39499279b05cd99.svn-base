<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script type="text/javascript">
/**介护口腔清洗 */
function addcavityClean(){
	if($("#cavityCleanDetails").val().length>0){
		if($("#cavityCleanDetails").val().indexOf($("#cavityCleanHide").val()) == -1){
			$("#cavityCleanDetails").val($("#cavityCleanDetails").val()+";"+$("#cavityCleanHide").val());
		}
	}else{
		$("#cavityCleanDetails").val($("#cavityCleanHide").val());
	}
}

/**介护会阴冲洗 */
function addperinealWash(){
	if($("#perinealWashDetails").val().length>0){
		if($("#perinealWashDetails").val().indexOf($("#perinealWashHide").val()) == -1){
			$("#perinealWashDetails").val($("#perinealWashDetails").val()+";"+$("#perinealWashHide").val());
		}
	}else{
		$("#perinealWashDetails").val($("#perinealWashHide").val());
	}
}

/**介护洗澡*/
function addbathBath(){
	if($("#bathBathDetails").val().length>0){
		if($("#bathBathDetails").val().indexOf($("#bathBathHide").val()) == -1){
			$("#bathBathDetails").val($("#bathBathDetails").val()+";"+$("#bathBathHide").val());
		}
	}else{
		$("#bathBathDetails").val($("#bathBathHide").val());
	}
}

/**介护洗头*/
function addwashHair(){
	if($("#washHairDetails").val().length>0){
		if($("#washHairDetails").val().indexOf($("#washHairHide").val()) == -1){
			$("#washHairDetails").val($("#washHairDetails").val()+";"+$("#washHairHide").val());
		}
	}else{
		$("#washHairDetails").val($("#washHairHide").val());
	}
}

/**介护服药 */
function addoralMedicine(){
	if($("#oralMedicineDetails").val().length>0){
		if($("#oralMedicineDetails").val().indexOf($("#oralMedicineHide").val()) == -1){
			$("#oralMedicineDetails").val($("#oralMedicineDetails").val()+";"+$("#oralMedicineHide").val());
		}
	}else{
		$("#oralMedicineDetails").val($("#oralMedicineHide").val());
	}
}

/**介护服中药*/
function addchineseMedicine(){
	if($("#chineseMedicineDetails").val().length>0){
		if($("#chineseMedicineDetails").val().indexOf($("#chineseMedicineHide").val()) == -1){
			$("#chineseMedicineDetails").val($("#chineseMedicineDetails").val()+";"+$("#chineseMedicineHide").val());
		}
	}else{
		$("#chineseMedicineDetails").val($("#chineseMedicineHide").val());
	}
}


/**翻身*/
function addturnOver(){
	if($("#turnOverDetails").val().length>0){
		if($("#turnOverDetails").val().indexOf($("#turnOverHide").val()) == -1){
			$("#turnOverDetails").val($("#turnOverDetails").val()+";"+$("#turnOverHide").val());
		}
	}else{
		$("#turnOverDetails").val($("#turnOverHide").val());
	}
}


/**拍背*/
function addbackslap(){
	if($("#backslapDetails").val().length>0){
		if($("#backslapDetails").val().indexOf($("#backslapHide").val()) == -1){
			$("#backslapDetails").val($("#backslapDetails").val()+";"+$("#backslapHide").val());
		}
	}else{
		$("#backslapDetails").val($("#backslapHide").val());
	}
}

/**下腹部按摩 */
function addbellyMassage(){
	if($("#bellyMassageDetails").val().length>0){
		if($("#bellyMassageDetails").val().indexOf($("#bellyMassageHide").val()) == -1){
			$("#bellyMassageDetails").val($("#bellyMassageDetails").val()+";"+$("#bellyMassageHide").val());
		}
	}else{
		$("#bellyMassageDetails").val($("#bellyMassageHide").val());
	}
}


/**饮水*/
function adddrinkWater(){
	if($("#drinkWaterDetails").val().length>0){
		if($("#drinkWaterDetails").val().indexOf($("#drinkWaterHide").val()) == -1){
			$("#drinkWaterDetails").val($("#drinkWaterDetails").val()+";"+$("#drinkWaterHide").val());
		}
	}else{
		$("#drinkWaterDetails").val($("#drinkWaterHide").val());
	}
}

/**沟通 */
function addcommunicate(){
	if($("#communicateDetails").val().length>0){
		if($("#communicateDetails").val().indexOf($("#communicateHide").val()) == -1){
			$("#communicateDetails").val($("#communicateDetails").val()+";"+$("#communicateHide").val());
		}
	}else{
		$("#communicateDetails").val($("#communicateHide").val());
	}
}

</script>
<!-- 照护计划 -->
<form:form id="nurserForm" action="${ctx}/healtharchives/intervene/saveNurser" method="post">
	<%-- <input type="hidden" id="id" name="id" value="${nurser.id}"> --%>
	<input type="hidden" id="interveneId" name="interveneId" value="${intervene.id}">
	<div class="docDiv">
		<div class="doctorDiv">	
		<label>主管医师</label> 		
		<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="doctorId1" name="doctorId"
		value="${nurser.doctorId}" labelName="doctorNm"  labelValue="${nurser.doctorNm}" title="人员" cssClass="required"></tags:treeselect>	
		</div>
		<div class="doctorDiv">
		主管护士
		<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="nurseId1" name="nurseId"
		value="${nurser.nurseId}" labelName="nurseNm"  labelValue="${nurser.nurseNm}" title="人员" cssClass="required"></tags:treeselect>
		</div>
		<div class="doctorDiv">
		 主管护理员
		 <tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="directorId1" name="directorId"
		value="${nurser.directorId}" labelName="directorNm"  labelValue="${nurser.directorNm}" title="人员" cssClass="required"></tags:treeselect>
		</div>
	</div>
	<div class="doctorDiv">	
		临床诊断
		<textarea  rows="1" cols="1" readonly="readonly" style="min-width: 550px;">${assessment.diagnosis}</textarea>
	</div>
	
	<div class="docDiv">
		<div class="doctorDiv">	
			护理评估
		</div>
		<div class="doctorDiv">	
			<input type="checkbox" <c:if test="${not empty nurser.fallScore}">checked="checked"</c:if>>
			跌倒：
			<input id="fallScore" name="fallScore" type="text" value="${nurser.fallScore}" style="width: 50px;">分	
		</div>
		<div class="doctorDiv">	
			<input type="checkbox" <c:if test="${not empty nurser.ulcerScore}">checked="checked"</c:if>>
			压疮评估：
			<input id="ulcerScore" name="ulcerScore" type="text" value="${nurser.ulcerScore }" style="width: 50px;">分	
		</div>
		<div class="doctorDiv">	
			<input type="checkbox" <c:if test="${not empty nurser.mmseScore}">checked="checked"</c:if>>
			MMSE:
			<input id="mmseScore" name="mmseScore" type="text" value="${nurser.mmseScore }" style="width: 50px;">分
		</div>
		<div class="doctorDiv">	
			<input type="checkbox" <c:if test="${not empty nurser.adlScore}">checked="checked"</c:if>>
			ADL:
			<input id="adlScore" name="adlScore" type="text" value="${nurser.adlScore }" style="width: 50px;">分	
		</div>
		<div class="doctorDiv">	
			<input type="checkbox" <c:if test="${not empty nurser.watianScore}">checked="checked"</c:if>>
			洼田饮水：
			<input id="watianScore" name="watianScore" type="text" value="${nurser.watianScore }" style="width: 50px;">	
		</div>
	</div>
	<div class="docDiv">
		<div class="doctorDiv">	
			照护诊断
			<textarea id="careDiagnosis" name="careDiagnosis" rows="2" cols="5" style="min-width: 550px;">${nurser.careDiagnosis}</textarea>
		</div>
	</div>
	<div class="docDiv">
		<div class="doctorDiv">	
			计划有效日期：　
			<input id="nurserStartTime" name="nurserStartTime" type="text" class="Wdate input-medium required" 
					value="<fmt:formatDate value="${nurser.nurserStartTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
			<input id="nurserEndTime" name="nurserEndTime" type="text" class="Wdate input-medium required" 
				value="<fmt:formatDate value="${nurser.nurserEndTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#nurserStartTime').val()});"/>
		</div>
	</div>
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
				<input type="checkbox" value="照护级别" <c:if test="${not empty nurser.careLevel}">checked="checked"</c:if>>照护级别
			</td>
			<td>
				<input type="checkbox" value="1" name="careLevel"
				<c:if test="${fns:containStr(nurser.careLevel,'1')}" >checked</c:if>>特级照护
				<input type="checkbox" value="2" name="careLevel"
				<c:if test="${fns:containStr(nurser.careLevel,'2')}" >checked</c:if>>Ⅲ级照护
				<input type="checkbox" value="3" name="careLevel"
				<c:if test="${fns:containStr(nurser.careLevel,'3')}" >checked</c:if>>Ⅱ级照护 
				<input type="checkbox" value="4" name="careLevel"
				<c:if test="${fns:containStr(nurser.careLevel,'4')}" >checked</c:if>>Ⅰ级照护
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="careLevelQuartersId" name="careLevelQuartersId" 
		value="${nurser.careLevelQuartersId}" labelName="careLevelQuartersNm"  labelValue="${nurser.careLevelQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="careLevelTime" name="careLevelTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.careLevelTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="饮食护理" <c:if test="${not empty nurser.deitNuser}">checked="checked"</c:if>>饮食护理 
			</td>
			<td>
				<input type="checkbox" value="1" name="deitNuser"
				<c:if test="${fns:containStr(nurser.deitNuser,'1')}" >checked</c:if>>普通饮食
				<input type="checkbox" value="2" name="deitNuser"
				<c:if test="${fns:containStr(nurser.deitNuser,'2')}" >checked</c:if>>流质饮食
				<input type="checkbox" value="3" name="deitNuser"
				<c:if test="${fns:containStr(nurser.deitNuser,'3')}" >checked</c:if>>低盐低脂饮食
				<input type="checkbox" value="4" name="deitNuser"
				<c:if test="${fns:containStr(nurser.deitNuser,'4')}" >checked</c:if>>糖尿病饮食
				<input type="checkbox" value="5" name="deitNuser"
				<c:if test="${fns:containStr(nurser.deitNuser,'5')}" >checked</c:if>>营养餐
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="nurserDeitNuserQuartersId" name="deitNuserQuartersId" 
		value="${nurser.deitNuserQuartersId}" labelName="deitNuserQuartersNm"  labelValue="${nurser.deitNuserQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="deitNuserTime" name="deitNuserTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.deitNuserTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="介护口腔清洗" <c:if test="${not empty nurser.cavityClean}">checked="checked"</c:if>>介护口腔清洗 
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="cavityCleanType" name="cavityCleanType" onchange="changeType('cavityClean')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.cavityCleanType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.cavityCleanType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="cavityCleanDay" class="dateDay" <c:if test="${nurser.cavityCleanType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('cavityClean')" class="selectType" style="width: 100px;" id="cavityCleanDaySelect" name="cavityCleanDaySelect">
						<option value="1" <c:if test="${nurser.cavityCleanInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.cavityCleanInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.cavityCleanInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.cavityCleanInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'cavityCleanHide',dateFmt:'HH:mm',onpicked:addcavityClean})" class="btn" type="button" value="请选择" />
				</div>
				<div id="cavityCleanWeek" class="dateWeek" <c:if test="${nurser.cavityCleanType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('cavityClean')" class="selectType" style="width: 100px;" id="cavityCleanWeekSelect" name="cavityCleanWeekSelect">
						<option value="1" <c:if test="${nurser.cavityCleanInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.cavityCleanInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.cavityCleanInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.cavityCleanInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'cavityCleanHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addcavityClean})" class="btn" type="button" value="请选择" />
				</div>
				<input id="cavityCleanHide" name="cavityCleanHide" type="hidden">
				<input id="cavityCleanInterval" name="cavityCleanInterval" value="${nurser.cavityCleanInterval }" type="hidden">
				<input id="cavityCleanDetails" name="cavityCleanDetails" type="text" readonly="readonly" value="${nurser.cavityCleanDetails}" <c:if test="${empty nurser.cavityCleanType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="cavityCleanQuartersId" name="cavityCleanQuartersId" 
		value="${nurser.cavityCleanQuartersId}" labelName="cavityCleanQuartersNm"  labelValue="${nurser.cavityCleanQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="cavityCleanTime" name="cavityCleanTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.cavityCleanTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="介护会阴冲洗" <c:if test="${not empty nurser.perinealWash}">checked="checked"</c:if>>介护会阴冲洗
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="perinealWashType" name="perinealWashType" onchange="changeType('perinealWash')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.perinealWashType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.perinealWashType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="perinealWashDay" class="dateDay" <c:if test="${nurser.perinealWashType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('perinealWash')" class="selectType" style="width: 100px;" id="perinealWashDaySelect" name="perinealWashDaySelect">
						<option value="1" <c:if test="${nurser.perinealWashInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.perinealWashInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.perinealWashInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.perinealWashInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'perinealWashHide',dateFmt:'HH:mm',onpicked:addperinealWash})" class="btn" type="button" value="请选择" />
				</div>
				<div id="perinealWashWeek" class="dateWeek" <c:if test="${nurser.perinealWashType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('perineWeekSelectsh')" class="selectType" style="width: 100px;" id="perinealWashWeekSelect" name="perinealWashWeekSelect">
						<option value="1" <c:if test="${nurser.perinealWashInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.perinealWashInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.perinealWashInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.perinealWashInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'perinealWashHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addperinealWash})" class="btn" type="button" value="请选择" />
				</div>
				<input id="perinealWashHide" name="perinealWashHide" type="hidden">
				<input id="perinealWashInterval" name="perinealWashInterval" value="${nurser.perinealWashInterval }" type="hidden">
				<input id="perinealWashDetails" name="perinealWashDetails" type="text" readonly="readonly" value="${nurser.perinealWashDetails}" <c:if test="${empty nurser.perinealWashType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="perinealWashQuartersId" name="perinealWashQuartersId" 
		value="${nurser.perinealWashQuartersId}" labelName="perinealWashQuartersNm"  labelValue="${nurser.perinealWashQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="perinealWashTime" name="perinealWashTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.perinealWashTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="介护洗澡" <c:if test="${not empty nurser.bathBath}">checked="checked"</c:if>>介护洗澡   
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="bathBathType" name="bathBathType" onchange="changeType('bathBath')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.bathBathType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.bathBathType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="bathBathDay" class="dateDay" <c:if test="${nurser.bathBathType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('bathBath')" class="selectType" style="width: 100px;" id="bathBathDaySelect" name="bathBathDaySelect">
						<option value="1" <c:if test="${nurser.bathBathInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.bathBathInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.bathBathInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.bathBathInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'bathBathHide',dateFmt:'HH:mm',onpicked:addbathBath})" class="btn" type="button" value="请选择" />
				</div>
				<div id="bathBathWeek" class="dateWeek" <c:if test="${nurser.bathBathType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('bathBath')" class="selectType" style="width: 100px;" id="bathBathWeekSelect" name="bathBathWeekSelect">
						<option value="1" <c:if test="${nurser.bathBathInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.bathBathInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.bathBathInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.bathBathInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'bathBathHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addbathBath})" class="btn" type="button" value="请选择" />
				</div>
				<input id="bathBathHide" name="bathBathHide" type="hidden">
				<input id="bathBathInterval" name="bathBathInterval" value="${nurser.bathBathInterval }" type="hidden">
				<input id="bathBathDetails" name="bathBathDetails" type="text" readonly="readonly" value="${nurser.bathBathDetails}" <c:if test="${empty nurser.bathBathType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="bathBathQuartersId" name="bathBathQuartersId" 
		value="${nurser.bathBathQuartersId}" labelName="bathBathQuartersNm"  labelValue="${nurser.bathBathQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="bathBathTime" name="bathBathTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.bathBathTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="介护洗头" <c:if test="${not empty nurser.washHair}">checked="checked"</c:if>>介护洗头
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="washHairType" name="washHairType" onchange="changeType('washHair')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.washHairType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.washHairType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="washHairDay" class="dateDay" <c:if test="${nurser.washHairType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('washHair')" class="selectType" style="width: 100px;" id="washHairDaySelect" name="washHairDaySelect">
						<option value="1" <c:if test="${nurser.washHairInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.washHairInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.washHairInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.washHairInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'washHairHide',dateFmt:'HH:mm',onpicked:addwashHair})" class="btn" type="button" value="请选择" />
				</div>
				<div id="washHairWeek" class="dateWeek" <c:if test="${nurser.washHairType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('washHair')" class="selectType" style="width: 100px;" id="washHairWeekSelect" name="washHairWeekSelect">
						<option value="1" <c:if test="${nurser.washHairInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.washHairInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.washHairInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.washHairInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'washHairHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addwashHair})" class="btn" type="button" value="请选择" />
				</div>
				<input id="washHairHide" name="washHairHide" type="hidden">
				<input id="washHairInterval" name="washHairInterval" value="${nurser.washHairInterval }" type="hidden">
				<input id="washHairDetails" name="washHairDetails" type="text" readonly="readonly" value="${nurser.washHairDetails}" <c:if test="${empty nurser.washHairType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="washHairQuartersId" name="washHairQuartersId" 
		value="${nurser.washHairQuartersId}" labelName="washHairQuartersNm"  labelValue="${nurser.washHairQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="washHairTime" name="washHairTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.washHairTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="介护服药" <c:if test="${not empty nurser.oralMedicine}">checked="checked"</c:if>>介护服药   
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="oralMedicineType" name="oralMedicineType" onchange="changeType('oralMedicine')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.oralMedicineType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.oralMedicineType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="oralMedicineDay" class="dateDay" <c:if test="${nurser.oralMedicineType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('oralMedicine')" class="selectType" style="width: 100px;" id="oralMedicineDaySelect" name="oralMedicineDaySelect">
						<option value="1" <c:if test="${nurser.oralMedicineInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.oralMedicineInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.oralMedicineInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.oralMedicineInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'oralMedicineHide',dateFmt:'HH:mm',onpicked:addoralMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<div id="oralMedicineWeek" class="dateWeek" <c:if test="${nurser.oralMedicineType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('oralMedicine')" class="selectType" style="width: 100px;" id="oralMedicineWeekSelect" name="oralMedicineWeekSelect">
						<option value="1" <c:if test="${nurser.oralMedicineInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.oralMedicineInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.oralMedicineInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.oralMedicineInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'oralMedicineHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addoralMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<input id="oralMedicineHide" name="oralMedicineHide" type="hidden">
				<input id="oralMedicineInterval" name="oralMedicineInterval" value="${nurser.oralMedicineInterval }" type="hidden">
				<input id="oralMedicineDetails" name="oralMedicineDetails" type="text" readonly="readonly" value="${nurser.oralMedicineDetails}" <c:if test="${empty nurser.oralMedicineType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="nurserOralMedicineQuartersId" name="oralMedicineQuartersId" 
		value="${nurser.oralMedicineQuartersId}" labelName="oralMedicineQuartersNm"  labelValue="${nurser.oralMedicineQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="oralMedicineTime" name="oralMedicineTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.oralMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="介护服中药" <c:if test="${not empty nurser.chineseMedicine}">checked="checked"</c:if>>介护服中药   
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="chineseMedicineType" name="chineseMedicineType" onchange="changeType('chineseMedicine')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.chineseMedicineType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.chineseMedicineType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="chineseMedicineDay" class="dateDay" <c:if test="${nurser.chineseMedicineType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('chineseMedicine')" class="selectType" style="width: 100px;" id="chineseMedicineDaySelect" name="chineseMedicineDaySelect">
						<option value="1" <c:if test="${nurser.chineseMedicineInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.chineseMedicineInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.chineseMedicineInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.chineseMedicineInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'chineseMedicineHide',dateFmt:'HH:mm',onpicked:addchineseMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<div id="chineseMedicineWeek" class="dateWeek" <c:if test="${nurser.chineseMedicineType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('chineseMedicine')" class="selectType" style="width: 100px;" id="chineseMedicineWeekSelect" name="chineseMedicineWeekSelect">
						<option value="1" <c:if test="${nurser.chineseMedicineInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.chineseMedicineInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.chineseMedicineInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.chineseMedicineInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'chineseMedicineHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addchineseMedicine})" class="btn" type="button" value="请选择" />
				</div>
				<input id="chineseMedicineHide" name="chineseMedicineHide" type="hidden">
				<input id="chineseMedicineInterval" name="chineseMedicineInterval" value="${nurser.chineseMedicineInterval }" type="hidden">
				<input id="chineseMedicineDetails" name="chineseMedicineDetails" type="text" readonly="readonly" value="${nurser.chineseMedicineDetails}" <c:if test="${empty nurser.chineseMedicineType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="nurserChineseMedicineQuartersId" name="chineseMedicineQuartersId" 
		value="${nurser.chineseMedicineQuartersId}" labelName="chineseMedicineQuartersNm"  labelValue="${nurser.chineseMedicineQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="chineseMedicineTime" name="chineseMedicineTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.chineseMedicineTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="翻身" <c:if test="${not empty nurser.turnOver}">checked="checked"</c:if>>翻身
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="turnOverType" name="turnOverType" onchange="changeType('turnOver')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.turnOverType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.turnOverType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="turnOverDay" class="dateDay" <c:if test="${nurser.turnOverType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('turnOver')" class="selectType" style="width: 100px;" id="turnOverDaySelect" name="turnOverDaySelect">
						<option value="1" <c:if test="${nurser.turnOverInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.turnOverInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.turnOverInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.turnOverInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'turnOverHide',dateFmt:'HH:mm',onpicked:addturnOver})" class="btn" type="button" value="请选择" />
				</div>
				<div id="turnOverWeek" class="dateWeek" <c:if test="${nurser.turnOverType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('turnOver')" class="selectType" style="width: 100px;" id="turnOverWeekSelect" name="turnOverWeekSelect">
						<option value="1" <c:if test="${nurser.turnOverInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.turnOverInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.turnOverInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.turnOverInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'turnOverHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addturnOver})" class="btn" type="button" value="请选择" />
				</div>
				<input id="turnOverHide" name="turnOverHide" type="hidden">
				<input id="turnOverInterval" name="turnOverInterval" value="${nurser.turnOverInterval }" type="hidden">
				<input id="turnOverDetails" name="turnOverDetails" type="text" readonly="readonly" value="${nurser.turnOverDetails}" <c:if test="${empty nurser.turnOverType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="turnOverQuartersId" name="turnOverQuartersId" 
		value="${nurser.turnOverQuartersId}" labelName="turnOverQuartersNm"  labelValue="${nurser.turnOverQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="turnOverTime" name="turnOverTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.turnOverTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="拍背" <c:if test="${not empty nurser.backslap}">checked="checked"</c:if>>拍背
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="backslapType" name="backslapType" onchange="changeType('backslap')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.backslapType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.backslapType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="backslapDay" class="dateDay" <c:if test="${nurser.backslapType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('backslap')" class="selectType" style="width: 100px;" id="backslapDaySelect" name="backslapDaySelect">
						<option value="1" <c:if test="${nurser.backslapInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.backslapInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.backslapInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.backslapInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'backslapHide',dateFmt:'HH:mm',onpicked:addbackslap})" class="btn" type="button" value="请选择" />
				</div>
				<div id="backslapWeek" class="dateWeek" <c:if test="${nurser.backslapType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('backslap')" class="selectType" style="width: 100px;" id="backslapWeekSelect" name="backslapWeekSelect">
						<option value="1" <c:if test="${nurser.backslapInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.backslapInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.backslapInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.backslapInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'backslapHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addbackslap})" class="btn" type="button" value="请选择" />
				</div>
				<input id="backslapHide" name="backslapHide" type="hidden">
				<input id="backslapInterval" name="backslapInterval" value="${nurser.backslapInterval }" type="hidden">
				<input id="backslapDetails" name="backslapDetails" type="text" readonly="readonly" value="${nurser.backslapDetails}" <c:if test="${empty nurser.backslapType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="backslapQuartersId" name="backslapQuartersId" 
		value="${nurser.backslapQuartersId}" labelName="backslapQuartersNm"  labelValue="${nurser.backslapQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="backslapTime" name="backslapTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.backslapTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="皮肤观察" <c:if test="${not empty nurser.skipWatch}">checked="checked"</c:if>>皮肤观察  
			</td>
			<td>
				<input type="checkbox" value="1" name="skipWatch"
				<c:if test="${fns:containStr(nurser.skipWatch,'1')}" >checked</c:if>>床单元整洁
				<input type="checkbox" value="2" name="skipWatch"
				<c:if test="${fns:containStr(nurser.skipWatch,'2')}" >checked</c:if>>皮肤观察
				<input type="checkbox" value="3" name="skipWatch"
				<c:if test="${fns:containStr(nurser.skipWatch,'3')}" >checked</c:if>>每小时一次
				<input type="checkbox" value="4" name="skipWatch"
				<c:if test="${fns:containStr(nurser.skipWatch,'4')}" >checked</c:if>>每两小时一次
				<input type="checkbox" value="5" name="skipWatch"
				<c:if test="${fns:containStr(nurser.skipWatch,'5')}" >checked</c:if>>每四小时一次
				<input type="checkbox" value="6" name="skipWatch"
				<c:if test="${fns:containStr(nurser.skipWatch,'6')}" >checked</c:if>>每六小时一次
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="skipWatchQuartersId" name="skipWatchQuartersId" 
		value="${nurser.skipWatchQuartersId}" labelName="skipWatchQuartersNm"  labelValue="${nurser.skipWatchQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="skipWatchTime" name="skipWatchTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.skipWatchTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="下腹部按摩" <c:if test="${not empty nurser.bellyMassage}">checked="checked"</c:if>>下腹部按摩  
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="bellyMassageType" name="bellyMassageType" onchange="changeType('bellyMassage')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.bellyMassageType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.bellyMassageType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="bellyMassageDay" class="dateDay" <c:if test="${nurser.bellyMassageType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('bellyMassage')" class="selectType" style="width: 100px;" id="bellyMassageDaySelect" name="bellyMassageDaySelect">
						<option value="1" <c:if test="${nurser.bellyMassageInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.bellyMassageInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.bellyMassageInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.bellyMassageInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'bellyMassageHide',dateFmt:'HH:mm',onpicked:addbellyMassage})" class="btn" type="button" value="请选择" />
				</div>
				<div id="bellyMassageWeek" class="dateWeek" <c:if test="${nurser.bellyMassageType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('bellyMassage')" class="selectType" style="width: 100px;" id="bellyMassageWeekSelect" name="bellyMassageWeekSelect">
						<option value="1" <c:if test="${nurser.bellyMassageInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.bellyMassageInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.bellyMassageInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.bellyMassageInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'bellyMassageHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addbellyMassage})" class="btn" type="button" value="请选择" />
				</div>
				<input id="bellyMassageHide" name="bellyMassageHide" type="hidden">
				<input id="bellyMassageInterval" name="bellyMassageInterval" value="${nurser.bellyMassageInterval }" type="hidden">
				<input id="bellyMassageDetails" name="bellyMassageDetails" type="text" readonly="readonly" value="${nurser.bellyMassageDetails}" <c:if test="${empty nurser.bellyMassageType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="bellyMassageQuartersId" name="bellyMassageQuartersId" 
		value="${nurser.bellyMassageQuartersId}" labelName="bellyMassageQuartersNm"  labelValue="${nurser.bellyMassageQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="bellyMassageTime" name="bellyMassageTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.bellyMassageTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="饮水" <c:if test="${not empty nurser.drinkWater}">checked="checked"</c:if>>饮水
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="drinkWaterType" name="drinkWaterType" onchange="changeType('drinkWater')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.drinkWaterType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.drinkWaterType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="drinkWaterDay" class="dateDay" <c:if test="${nurser.drinkWaterType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('drinkWater')" class="selectType" style="width: 100px;" id="drinkWaterDaySelect" name="drinkWaterDaySelect">
						<option value="1" <c:if test="${nurser.drinkWaterInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.drinkWaterInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.drinkWaterInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.drinkWaterInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'drinkWaterHide',dateFmt:'HH:mm',onpicked:adddrinkWater})" class="btn" type="button" value="请选择" />
				</div>
				<div id="drinkWaterWeek" class="dateWeek" <c:if test="${nurser.drinkWaterType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('drinkWater')" class="selectType" style="width: 100px;" id="drinkWaterWeekSelect" name="drinkWaterWeekSelect">
						<option value="1" <c:if test="${nurser.drinkWaterInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.drinkWaterInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.drinkWaterInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.drinkWaterInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'drinkWaterHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:adddrinkWater})" class="btn" type="button" value="请选择" />
				</div>
				<input id="drinkWaterHide" name="drinkWaterHide" type="hidden">
				<input id="drinkWaterInterval" name="drinkWaterInterval" value="${nurser.drinkWaterInterval }" type="hidden">
				<input id="drinkWaterDetails" name="drinkWaterDetails" type="text" readonly="readonly" value="${nurser.drinkWaterDetails}" <c:if test="${empty nurser.drinkWaterType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="drinkWaterQuartersId" name="drinkWaterQuartersId" 
		value="${nurser.drinkWaterQuartersId}" labelName="drinkWaterQuartersNm"  labelValue="${nurser.drinkWaterQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="drinkWaterTime" name="drinkWaterTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.drinkWaterTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="沟通" <c:if test="${not empty nurser.communicate}">checked="checked"</c:if>>沟通
			</td>
			<td>
				<select class="selectType" style="width: 100px;" id="communicateType" name="communicateType" onchange="changeType('communicate')">
					<option value=" ">请选择</option>
					<option value="0" <c:if test="${nurser.communicateType == '0'}">selected="selected"</c:if>>按天</option>
					<option value="1" <c:if test="${nurser.communicateType == '1'}">selected="selected"</c:if>>按周</option>
				</select>
				<div id="communicateDay" class="dateDay" <c:if test="${nurser.communicateType != '0'}">style="display: none;"</c:if>>
					<select onchange="changeSelectDay('communicate')" class="selectType" style="width: 100px;" id="communicateDaySelect" name="communicateDaySelect">
						<option value="1" <c:if test="${nurser.communicateInterval == '1'}">selected="selected"</c:if>>每天</option>
						<option value="2" <c:if test="${nurser.communicateInterval == '2'}">selected="selected"</c:if>>隔天</option>
						<option value="3" <c:if test="${nurser.communicateInterval == '3'}">selected="selected"</c:if>>隔两天</option>
						<option value="4" <c:if test="${nurser.communicateInterval == '4'}">selected="selected"</c:if>>隔三天</option>
					</select>
					<input onclick="WdatePicker({el:'communicateHide',dateFmt:'HH:mm',onpicked:addcommunicate})" class="btn" type="button" value="请选择" />
				</div>
				<div id="communicateWeek" class="dateWeek" <c:if test="${nurser.communicateType != '1'}">style="display: none;"</c:if>>
					<select onchange="changeSelectWeek('communicate')" class="selectType" style="width: 100px;" id="communicateWeekSelect" name="communicateWeekSelect">
						<option value="1" <c:if test="${nurser.communicateInterval == '1'}">selected="selected"</c:if>>每周</option>
						<option value="2" <c:if test="${nurser.communicateInterval == '2'}">selected="selected"</c:if>>隔一周</option>
						<option value="3" <c:if test="${nurser.communicateInterval == '3'}">selected="selected"</c:if>>隔两周</option>
						<option value="4" <c:if test="${nurser.communicateInterval == '4'}">selected="selected"</c:if>>隔三周</option>
					</select>
					<input onclick="WdatePicker({el:'communicateHide',isShowWeek:true,dateFmt:'yyyy-MM-dd HH:mm',onpicked:addcommunicate})" class="btn" type="button" value="请选择" />
				</div>
				<input id="communicateHide" name="communicateHide" type="hidden">
				<input id="communicateInterval" name="communicateInterval" value="${nurser.communicateInterval }" type="hidden">
				<input id="communicateDetails" name="communicateDetails" type="text" readonly="readonly" value="${nurser.communicateDetails}" <c:if test="${empty nurser.communicateType}">style="display: none;"</c:if>>
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="communicateQuartersId" name="communicateQuartersId" 
		value="${nurser.communicateQuartersId}" labelName="communicateQuartersNm"  labelValue="${nurser.communicateQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="communicateTime" name="communicateTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.communicateTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
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
				<input type="checkbox" value="日常生活活动能力下降" <c:if test="${not empty nurser.dailyLife}">checked="checked"</c:if>>日常生活活动能力下降  
			</td>
			<td>
				<input type="checkbox" value="1" name="dailyLife"
				<c:if test="${fns:containStr(nurser.dailyLife,'1')}" >checked</c:if>>常用物品放置在老人易取的地方
				<input type="checkbox" value="2" name="dailyLife"
				<c:if test="${fns:containStr(nurser.dailyLife,'2')}" >checked</c:if>>协助进食
				<input type="checkbox" value="3" name="dailyLife"
				<c:if test="${fns:containStr(nurser.dailyLife,'3')}" >checked</c:if>>协助洗漱
				<input type="checkbox" value="4" name="dailyLife"
				<c:if test="${fns:containStr(nurser.dailyLife,'4')}" >checked</c:if>>协助更衣
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="dailyLifeQuartersId" name="dailyLifeQuartersId" 
		value="${nurser.dailyLifeQuartersId}" labelName="dailyLifeQuartersNm"  labelValue="${nurser.dailyLifeQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="dailyLifeTime" name="dailyLifeTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.dailyLifeTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="皮肤完整性受损的危险 " <c:if test="${not empty nurser.skipIntegrity}">checked="checked"</c:if>>皮肤完整性受损的危险 
			</td>
			<td>
				<input type="checkbox" value="1" name="skipIntegrity"
				<c:if test="${fns:containStr(nurser.skipIntegrity,'1')}" >checked</c:if>>评估危险因数并记录
				<input type="checkbox" value="2" name="skipIntegrity"
				<c:if test="${fns:containStr(nurser.skipIntegrity,'2')}" >checked</c:if>>环境安全管理
				<input type="checkbox" value="3" name="skipIntegrity"
				<c:if test="${fns:containStr(nurser.skipIntegrity,'3')}" >checked</c:if>>警示标识
				<input type="checkbox" value="4" name="skipIntegrity"
				<c:if test="${fns:containStr(nurser.skipIntegrity,'4')}" >checked</c:if>>床档
				<input type="checkbox" value="5" name="skipIntegrity"
				<c:if test="${fns:containStr(nurser.skipIntegrity,'5')}" >checked</c:if>>必要时使用安全带
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="skipIntegrityQuartersId" name="skipIntegrityQuartersId" 
		value="${nurser.skipIntegrityQuartersId}" labelName="skipIntegrityQuartersNm"  labelValue="${nurser.skipIntegrityQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="skipIntegrityTime" name="skipIntegrityTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.skipIntegrityTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="孤独、焦虑" <c:if test="${not empty nurser.anxiety}">checked="checked"</c:if>>孤独、焦虑
			</td>
			<td>
				<input type="checkbox" value="1" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'1')}" >checked</c:if>>听音乐
				<input type="checkbox" value="2" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'2')}" >checked</c:if>>看电视
				<input type="checkbox" value="3" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'3')}" >checked</c:if>>折纸
				<input type="checkbox" value="4" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'4')}" >checked</c:if>>熟悉的话题沟通
				<input type="checkbox" value="5" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'5')}" >checked</c:if>>心理支持
				<input type="checkbox" value="6" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'6')}" >checked</c:if>>使用肢体语言沟通
				<input type="checkbox" value="7" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'7')}" >checked</c:if>>借助纸笔方式沟通
				<input type="checkbox" value="0" name="anxiety"
				<c:if test="${fns:containStr(nurser.anxiety,'0')}" >checked</c:if>>其他（采用是否问答方式）
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="nurserAnxietyQuartersId" name="anxietyQuartersId" 
		value="${nurser.anxietyQuartersId}" labelName="anxietyQuartersNm"  labelValue="${nurser.anxietyQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="anxietyTime" name="anxietyTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.anxietyTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="关怀" <c:if test="${not empty nurser.solicitude}">checked="checked"</c:if>>关怀
			</td>
			<td>
				<input type="checkbox" value="1" name="solicitude"
				<c:if test="${fns:containStr(nurser.solicitude,'1')}" >checked</c:if>>职业尊称
				<input type="checkbox" value="2" name="solicitude"
				<c:if test="${fns:containStr(nurser.solicitude,'2')}" >checked</c:if>>职务尊称
				<input type="checkbox" value="3" name="solicitude"
				<c:if test="${fns:containStr(nurser.solicitude,'3')}" >checked</c:if>>年龄尊称
				<input type="checkbox" value="4" name="solicitude"
				<c:if test="${fns:containStr(nurser.solicitude,'4')}" >checked</c:if>>心理慰籍[每天两次]
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="solicitudeQuartersId" name="solicitudeQuartersId" 
		value="${nurser.solicitudeQuartersId}" labelName="solicitudeQuartersNm"  labelValue="${nurser.solicitudeQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="solicitudeTime" name="solicitudeTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.solicitudeTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="行走训练" <c:if test="${not empty nurser.walkTrain}">checked="checked"</c:if>>行走训练
			</td>
			<td>
				<input type="checkbox" value="1" name="walkTrain"
				<c:if test="${fns:containStr(nurser.walkTrain,'1')}" >checked</c:if>>协助行走
				<input type="checkbox" value="2" name="walkTrain"
				<c:if test="${fns:containStr(nurser.walkTrain,'2')}" >checked</c:if>>提供安静舒适的病区环境
				<input type="checkbox" value="3" name="walkTrain"
				<c:if test="${fns:containStr(nurser.walkTrain,'3')}" >checked</c:if>>尽量减少对患者的干扰
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="walkTrainQuartersId" name="walkTrainQuartersId" 
		value="${nurser.walkTrainQuartersId}" labelName="walkTrainQuartersNm"  labelValue="${nurser.walkTrainQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="walkTrainTime" name="walkTrainTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.walkTrainTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="便秘" <c:if test="${not empty nurser.astriction}">checked="checked"</c:if>>便秘
			</td>
			<td>
				<input type="checkbox" value="1" name="astriction"
				<c:if test="${fns:containStr(nurser.astriction,'1')}" >checked</c:if>>饮食指导
				<input type="checkbox" value="2" name="astriction"
				<c:if test="${fns:containStr(nurser.astriction,'2')}" >checked</c:if>>活动指导
				<input type="checkbox" value="3" name="astriction"
				<c:if test="${fns:containStr(nurser.astriction,'3')}" >checked</c:if>>药物应用
				<input type="checkbox" value="4" name="astriction"
				<c:if test="${fns:containStr(nurser.astriction,'4')}" >checked</c:if>>下腹部顺时针按摩
				<input type="checkbox" value="5" name="astriction"
				<c:if test="${fns:containStr(nurser.astriction,'5')}" >checked</c:if>>记录排便次数
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="astrictionQuartersId" name="astrictionQuartersId" 
		value="${nurser.astrictionQuartersId}" labelName="astrictionQuartersNm"  labelValue="${nurser.astrictionQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="astrictionTime" name="astrictionTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.astrictionTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" value="潜在并发症：感染" <c:if test="${not empty nurser.potentialInfection}">checked="checked"</c:if>>潜在并发症：感染    
			</td>
			<td>
				<input type="checkbox" value="1" name="potentialInfection"
				<c:if test="${fns:containStr(nurser.potentialInfection,'1')}" >checked</c:if>>拍背
				<input type="checkbox" value="2" name="potentialInfection"
				<c:if test="${fns:containStr(nurser.potentialInfection,'2')}" >checked</c:if>>注意保暖
				<input type="checkbox" value="3" name="potentialInfection"
				<c:if test="${fns:containStr(nurser.potentialInfection,'3')}" >checked</c:if>>坐起
				<input type="checkbox" value="4" name="potentialInfection"
				<c:if test="${fns:containStr(nurser.potentialInfection,'4')}" >checked</c:if>>腔清洁 
			</td>
			<td>
				<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="nurserPotentialInfectionQuartersId" name="potentialInfectionQuartersId" 
		value="${nurser.potentialInfectionQuartersId}" labelName="potentialInfectionQuartersNm"  labelValue="${nurser.potentialInfectionQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
			</td>
			<td>
				<input id="potentialInfectionTime" name="potentialInfectionTime" type="text" maxlength="20" class="Wdate input-medium " 
				value="<fmt:formatDate value="${nurser.potentialInfectionTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" <c:if test="${not empty nurser.other}">checked="checked"</c:if>>其他
			</td>
			<td>
				<input type="text" value="${nurser.other }" id="Other" name="other"/>
			</td>
		</tr>
	</table>
	<div class="form-actions">
		<c:if test="${intervene.state == 0 || intervene.state == 2 }">
			<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="submitBut('nurserForm','${ctx}/healtharchives/nurser/saveNurser')" value="保 存"/>&nbsp;
		</c:if>
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview('1');"/>
	</div>
</form:form>