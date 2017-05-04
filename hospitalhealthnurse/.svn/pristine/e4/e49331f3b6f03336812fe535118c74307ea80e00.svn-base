<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<label class="control-label" for="userId">头像:</label>
	<form:hidden path="userId" htmlEscape="false" />
 	<label id="photo" ><c:if test="${healthRecord.photo != null && healthRecord.photo != ''}"><img src='${healthRecord.photo}' style='width:35px;height:35;'></img></c:if></label>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="fullNm"><span class="tishi">*</span>姓名:</label>
		<label class="label-col" id="fullNm"><c:if test="${healthRecord.fullNm != ''}">${healthRecord.fullNm}</c:if></label>
	</div>
	<div class="div-col">
		<label class="control-label" for="sex"><span class="tishi">*</span>性别:</label>
		<label class="label-col" id="sex" ><c:if test="${healthRecord.sex != ''}">${healthRecord.sex}</c:if></label>
	</div>
	<div class="div-col">
		<label class="control-label" for="age"><span class="tishi">*</span>年龄:</label>
		<label class="label-col" id="age" ><c:if test="${healthRecord.age != ''}">${healthRecord.age}</c:if></label>	
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="province">籍贯:</label>
	<c:choose>
		<c:when test="${healthRecord.province != null}">
			<select id="province" name="province" style="width:130px;" onchange="showArea(this.value,1)" >
		 		<option value="">省</option>
		 		<c:forEach items="${provinceList}" var="temp">
		 			<option value="${temp.id}" <c:if test="${temp.id == healthRecord.province}">selected</c:if>>${temp.name}</option>
		 		</c:forEach>
		 	</select>
		</c:when>
		<c:otherwise>
			<form:select path="province" style="width:130px;" onchange="showArea(this.value,1)" >
		 		<form:option value="">省</form:option>
		 		<form:options items="${provinceList}" itemValue="id" itemLabel="name"/>
		 	</form:select>
		</c:otherwise>
	</c:choose>	
	&nbsp;&nbsp;
	<c:choose>
		<c:when test="${healthRecord.city != null}">
			<select id="city" name="city" style="width:130px;" onchange="showArea(this.value,2)" >
		 		<option value="">市</option>
		 		<c:forEach items="${cityList}" var="temp">
		 			<option value="${temp.id}" <c:if test="${temp.id == healthRecord.city}">selected</c:if>>${temp.name}</option>
		 		</c:forEach>
		 	</select>
		</c:when>
		<c:otherwise>
			<select id="city" name="city" style="width:130px;" onchange="showArea(this.value,2)" >
		 		<option value="">市</option>
		 	</select>
		</c:otherwise>
	</c:choose>	
	&nbsp;&nbsp;	
 	<c:choose>
		<c:when test="${healthRecord.area != null}">
			<select id="area" name="area" style="width:130px;" >
		 		<option value="">县/区</option>
		 		<c:forEach items="${areaList}" var="temp">
		 			<option value="${temp.id}" <c:if test="${temp.id == healthRecord.area}">selected</c:if>>${temp.name}</option>
		 		</c:forEach>
		 	</select>
		</c:when>
		<c:otherwise>
			<select id="area" name="area" style="width:130px;" >
		 		<option value="">县/区</option>
		 	</select>
		</c:otherwise>
	</c:choose>	
</div>
<div class="control-group">
	<label class="control-label" for="maritalStatus">详细地址:</label>
	<form:input path="address" htmlEscape="false" style="width:380px;" maxlength="50" />
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="maritalStatus">婚姻状况:</label>
	 	<form:select path="maritalStatus" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('marital_status')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="nation">民族:</label>
	 	<form:input path="nation" htmlEscape="false" maxlength="30" />
	</div>
	<div class="div-col">
		<label class="control-label" for="relator">健康状况陈述者:</label>
	 	<form:input path="relator" htmlEscape="false" maxlength="30" />
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">		
		<label class="control-label" for="relation">与入住者关系:</label>
	 	<form:input path="relation" htmlEscape="false" maxlength="30" />
	</div>
	<div class="div-col">
		<label class="control-label" for="arrivalDate">入住日期:</label>
		<input id="arrivalDate" name="arrivalDate" value='<fmt:formatDate value="${healthRecord.arrivalDate}" type="date"/>' type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
		 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>
	</div>
	<div class="div-col">
		<label class="control-label" for="arrivalReason">入住原因:</label>
	 	<form:textarea path="arrivalReason" htmlEscape="false" maxlength="200" rows="3" class="input-mlarge"/>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="emotion"><strong>一般情况</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情绪:</label>
	 	<form:select path="emotion" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('emotion')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="somnus">睡眠:</label>
	 	<form:select path="somnus" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('somnus')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="spirit">精神:</label>
	 	<form:select path="spirit" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('spirit')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="orexia">食欲:</label>
	 	<form:select path="orexia" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('orexia')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="habitsCustoms">生活习惯:</label>
	 	<form:select path="habitsCustoms" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('habits_customs')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="lifeSelfAbility">生活自理能力:</label>
	 	<form:select path="lifeSelfAbility" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('life_self_care_ability')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="pee">小便:</label>
	 	<form:select path="pee" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('pee')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="shit">大便:</label>
	 	<form:select path="shit" style="width:140px;" class="input-medium-select" onchange="showlooseStoolsNumber(this.value)" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('shit')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showlooseStoolsNumber" style="<c:choose><c:when test="${healthRecord.shit == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="looseStoolsNumber">便溏次数:</label>
	 	<form:input path="looseStoolsNumber" htmlEscape="false" maxlength="2" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-mini digits" />次/
	 	<form:input path="looseStoolsDays" htmlEscape="false" maxlength="2" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-mini digits" />日
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="healthCondition"><strong>既往史</strong>&nbsp;平常健康情况:</label>
	<form:select path="healthCondition" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('health_condition')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm1">疾病史 :</label>
	<label class="control-label-col" for="diseaseNm1" >病名</label>
	<label class="control-label-col" for="diseaseYear1">患病年数</label>
	<label class="control-label-col" for="diagnosedHospital1">确诊医院</label>
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm1"></label>
	1)&nbsp;&nbsp;<form:input path="diseaseNm1" htmlEscape="false" maxlength="20" style="width:130px"/>
 	<form:input path="diseaseYear1" htmlEscape="false" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" style="width:50px;"/>
 	<form:input path="diagnosedHospital1" htmlEscape="false" maxlength="50" style="width:160px"/>
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm2"></label>
	2)&nbsp;&nbsp;<form:input path="diseaseNm2" htmlEscape="false" maxlength="20" style="width:130px"/>
 	<form:input path="diseaseYear2" htmlEscape="false" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" style="width:50px;"/>
 	<form:input path="diagnosedHospital2" htmlEscape="false" maxlength="50" style="width:160px"/>
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm3"></label>
	3)&nbsp;&nbsp;<form:input path="diseaseNm3" htmlEscape="false" maxlength="20" style="width:130px"/>
 	<form:input path="diseaseYear3" htmlEscape="false" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" style="width:50px;"/>
 	<form:input path="diagnosedHospital3" htmlEscape="false" maxlength="50" style="width:160px"/>
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm4"></label>
	4)&nbsp;&nbsp;<form:input path="diseaseNm4" htmlEscape="false" maxlength="20" style="width:130px"/>
 	<form:input path="diseaseYear4" htmlEscape="false" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" style="width:50px;"/>
 	<form:input path="diagnosedHospital4" htmlEscape="false" maxlength="50" style="width:160px"/>
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm5"></label>
	5)&nbsp;&nbsp;<form:input path="diseaseNm5" htmlEscape="false" maxlength="20" style="width:130px"/>
 	<form:input path="diseaseYear5" htmlEscape="false" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" style="width:50px;"/>
 	<form:input path="diagnosedHospital5" htmlEscape="false" maxlength="50" style="width:160px"/>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="infectionHistory">传染病史:</label>
		<form:select path="infectionHistory" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="bloodHistory">输血史:</label>
	 	<form:select path="bloodHistory" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="vaccinationHistory">预防接种史:</label>
	 	<form:select path="vaccinationHistory" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="localLesionHistory">局部病灶史:</label>
	 	<form:select path="localLesionHistory" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="traumaSurgeryHistory">外伤手术史:</label>
	 	<form:select path="traumaSurgeryHistory" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="allergyHistory">药物过敏史:</label>
	 	<form:select path="allergyHistory" style="width:140px;" class="input-medium-select" onchange="showanaphylactogen(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>

<div class="control-group" id="showanaphylactogen" style="<c:choose><c:when test="${healthRecord.allergyHistory == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
	<div class="div-col">
		<label class="control-label" for="anaphylactogen">过敏源:</label>
	 	<form:input path="anaphylactogen" htmlEscape="false" maxlength="50" />
	</div>
	<div class="div-col">
		<label class="control-label" for="allergyClinicalManifestation">过敏后临床表现:</label>
	 	<form:input path="allergyClinicalManifestation" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="respiratorySystem">呼吸系统:</label>
	<c:forEach items="${fns:getDictList('respiratory_system')}" var="system" varStatus="v">
		<input id="respiratorySystem${v.count}" name="respiratorySystem"  <c:if test="${fns:containStr(healthRecord.respiratorySystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="respiratorySystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="circulatorySystem">循环系统:</label>
	<c:forEach items="${fns:getDictList('circulatory_system')}" var="system" varStatus="v">
		<input id="circulatorySystem${v.count}" name="circulatorySystem"  <c:if test="${fns:containStr(healthRecord.circulatorySystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="circulatorySystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="alimentarySystem">消化系统:</label>
	<c:forEach items="${fns:getDictList('alimentary_system')}" var="system" varStatus="v">
		<input id="alimentarySystem${v.count}" name="alimentarySystem"  <c:if test="${fns:containStr(healthRecord.alimentarySystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="alimentarySystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="urogenitalSystem">泌尿生殖系统:</label>
	<c:forEach items="${fns:getDictList('urogenital_system')}" var="system" varStatus="v">
		<input id="urogenitalSystem${v.count}" name="urogenitalSystem"  <c:if test="${fns:containStr(healthRecord.urogenitalSystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="urogenitalSystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="bloodSystem">血液系统:</label>
	<c:forEach items="${fns:getDictList('blood_system')}" var="system" varStatus="v">
		<input id="bloodSystem${v.count}" name="bloodSystem"  <c:if test="${fns:containStr(healthRecord.bloodSystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="bloodSystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="endocrineMetabolicSystem">内分泌与代谢系统:</label>
	<c:forEach items="${fns:getDictList('endocrine_metabolic_system')}" var="system" varStatus="v">
		<input id="endocrineMetabolicSystem${v.count}" name="endocrineMetabolicSystem"  <c:if test="${fns:containStr(healthRecord.endocrineMetabolicSystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="endocrineMetabolicSystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="nervousSystem">神经系统:</label>
	<c:forEach items="${fns:getDictList('nervous_system')}" var="system" varStatus="v">
		<input id="nervousSystem${v.count}" name="nervousSystem"  <c:if test="${fns:containStr(healthRecord.nervousSystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="nervousSystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="movingSkeletalSystem">运动骨骼系统:</label>
	<c:forEach items="${fns:getDictList('moving_skeletal_system')}" var="system" varStatus="v">
		<input id="movingSkeletalSystem${v.count}" name="movingSkeletalSystem"  <c:if test="${fns:containStr(healthRecord.movingSkeletalSystem,system.value)}">checked</c:if> type="checkbox"  value="${system.value}" />
		<label for="movingSkeletalSystem${v.count}">${system.label}</label> 
	</c:forEach>
</div>