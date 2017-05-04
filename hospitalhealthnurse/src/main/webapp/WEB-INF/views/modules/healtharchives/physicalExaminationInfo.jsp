<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<label class="control-label" for="userId">头像:</label>
 	<label id="photo" ><c:if test="${healthRecord.photo != null && healthRecord.photo != ''}"><img src='${healthRecord.photo}' style='width:35px;height:35;'></img></c:if></label>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="fullNm">姓名:</label>
		<label class="label-col" id="fullNm"><c:if test="${healthRecord.fullNm != ''}">${healthRecord.fullNm}</c:if></label>
	</div>
	<div class="div-col">
		<label class="control-label" for="sex">性别:</label>
		<label class="label-col" id="sex" ><c:if test="${healthRecord.sex != ''}">${healthRecord.sex}</c:if></label>
	</div>
	<div class="div-col">
		<label class="control-label" for="age">年龄:</label>
		<label class="label-col" id="age" ><c:if test="${healthRecord.age != ''}">${healthRecord.age}</c:if></label>	
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="province">籍贯:</label>${areaAddress}
</div>
<div class="control-group">
	<label class="control-label" for="maritalStatus">详细地址:</label>${healthRecord.address}
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="maritalStatus">婚姻状况:</label>
	 	${fns:getDictLabel(healthRecord.maritalStatus,'marital_status','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="nation">民族:</label>${healthRecord.nation}
	</div>
	<div class="div-col">
		<label class="control-label" for="relator">健康状况陈述者:</label>${healthRecord.relator}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">		
		<label class="control-label" for="relation">与入住者关系:</label>${healthRecord.relation}
	</div>
	<div class="div-col">
		<label class="control-label" for="arrivalDate">入住日期:</label><fmt:formatDate value="${healthRecord.arrivalDate}" type="date"/>
	</div>
	<div class="div-col">
		<label class="control-label" for="arrivalReason">入住原因:</label>${healthRecord.arrivalReason}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="emotion"><strong>一般情况</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情绪:</label>
	 	${fns:getDictLabel(healthRecord.emotion,'emotion','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="somnus">睡眠:</label>
		${fns:getDictLabel(healthRecord.somnus,'somnus','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="spirit">精神:</label>
		${fns:getDictLabel(healthRecord.spirit,'spirit','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="orexia">食欲:</label>
		${fns:getDictLabel(healthRecord.orexia,'orexia','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="habitsCustoms">生活习惯:</label>
		${fns:getDictLabel(healthRecord.habitsCustoms,'habits_customs','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="lifeSelfAbility">生活自理能力:</label>
		${fns:getDictLabel(healthRecord.lifeSelfAbility,'life_self_care_ability','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="pee">小便:</label>
		${fns:getDictLabel(healthRecord.pee,'pee','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="shit">大便:</label>
		${fns:getDictLabel(healthRecord.shit,'shit','')}
	</div>
	<c:if test="${healthRecord.shit == '2'}">
		<div class="div-col" id="showlooseStoolsNumber" >
			<label class="control-label" for="looseStoolsNumber">便溏次数:</label>
			${healthRecord.looseStoolsNumber}次/${healthRecord.looseStoolsDays}日
		</div>
	</c:if>
</div>
<div class="control-group">
	<label class="control-label" for="healthCondition"><strong>既往史</strong>&nbsp;平常健康情况:</label>
	${fns:getDictLabel(healthRecord.healthCondition,'health_condition','')}
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm1">疾病史 :</label>
	<label class="control-label-col" for="diseaseNm1" >病名</label>
	<label class="control-label-col" for="diseaseYear1">患病年数</label>
	<label class="control-label-col" for="diagnosedHospital1">确诊医院</label>
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm1"></label>
	1)&nbsp;&nbsp;${healthRecord.diseaseNm1}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${healthRecord.diseaseYear1}&nbsp;&nbsp;&nbsp;${healthRecord.diagnosedHospital1}
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm2"></label>
	2)&nbsp;&nbsp;${healthRecord.diseaseNm2}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${healthRecord.diseaseYear2}&nbsp;&nbsp;&nbsp;${healthRecord.diagnosedHospital2}
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm3"></label>
	3)&nbsp;&nbsp;${healthRecord.diseaseNm3}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${healthRecord.diseaseYear3}&nbsp;&nbsp;&nbsp;${healthRecord.diagnosedHospital3}
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm4"></label>
	4)&nbsp;&nbsp;${healthRecord.diseaseNm4}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${healthRecord.diseaseYear4}&nbsp;&nbsp;&nbsp;${healthRecord.diagnosedHospital4}
</div>
<div class="control-group">
	<label class="control-label" for="diseaseNm5"></label>
	5)&nbsp;&nbsp;${healthRecord.diseaseNm5}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${healthRecord.diseaseYear5}&nbsp;&nbsp;&nbsp;${healthRecord.diagnosedHospital5}
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="infectionHistory">传染病史:</label>
		${fns:getDictLabel(healthRecord.infectionHistory,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="bloodHistory">输血史:</label>
		${fns:getDictLabel(healthRecord.bloodHistory,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="vaccinationHistory">预防接种史:</label>
		${fns:getDictLabel(healthRecord.vaccinationHistory,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="localLesionHistory">局部病灶史:</label>
		${fns:getDictLabel(healthRecord.localLesionHistory,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="traumaSurgeryHistory">外伤手术史:</label>
		${fns:getDictLabel(healthRecord.traumaSurgeryHistory,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="allergyHistory">药物过敏史:</label>
		${fns:getDictLabel(healthRecord.allergyHistory,'not_have','')}
	</div>
</div>
<c:if test="${healthRecord.allergyHistory == '2'}">
	<div class="div-col">
		<label class="control-label" for="anaphylactogen">过敏源:</label>
		${healthRecord.anaphylactogen}
	</div>
	<div class="div-col">
		<label class="control-label" for="allergyClinicalManifestation">过敏后临床表现:</label>
		${healthRecord.allergyClinicalManifestation}
	</div>
</c:if>
<div class="control-group">
	<label class="control-label" for="respiratorySystem">呼吸系统:</label>
	<c:forEach items="${fns:getDictList('respiratory_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.respiratorySystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="circulatorySystem">循环系统:</label>
	<c:forEach items="${fns:getDictList('circulatory_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.circulatorySystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="alimentarySystem">消化系统:</label>
	<c:forEach items="${fns:getDictList('alimentary_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.alimentarySystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="urogenitalSystem">泌尿生殖系统:</label>
	<c:forEach items="${fns:getDictList('urogenital_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.urogenitalSystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="bloodSystem">血液系统:</label>
	<c:forEach items="${fns:getDictList('blood_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.bloodSystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="endocrineMetabolicSystem">内分泌与代谢系统:</label>
	<c:forEach items="${fns:getDictList('endocrine_metabolic_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.endocrineMetabolicSystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="nervousSystem">神经系统:</label>
	<c:forEach items="${fns:getDictList('nervous_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.nervousSystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>
<div class="control-group">
	<label class="control-label" for="movingSkeletalSystem">运动骨骼系统:</label>
	<c:forEach items="${fns:getDictList('moving_skeletal_system')}" var="system" varStatus="v">
		<c:if test="${fns:containStr(healthRecord.movingSkeletalSystem,system.value)}">${system.label},</c:if>
	</c:forEach>
</div>