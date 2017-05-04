<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="liverDullness"><strong>叩诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;肝浊音:</label>
	 	<form:select path="liverDullness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('liver_dullness')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="shiftingDullness">移动性浊音:</label>
	 	<form:select path="shiftingDullness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="renalRegionBucklePain">肾区扣痛:</label>
	 	<form:select path="renalRegionBucklePain" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_left_right')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label for="rmcl"><strong>肝上界</strong>位于右锁骨中线</label>
	 	<form:input path="rmcl" htmlEscape="false" maxlength="30" class="input-small"/>肋间
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bowelSound"><strong>听诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;肠鸣音:</label>
	 	<form:select path="bowelSound" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('reflex')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="gurgling">气过水声:</label>
	 	<form:select path="gurgling" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="vascularMurmur">血管杂音:</label>
	 	<form:select path="vascularMurmur" style="width:140px;" class="input-medium-select" onchange="showvascularMurmurPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showvascularMurmurPosition" style="<c:choose><c:when test="${healthRecord.vascularMurmur == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="vascularMurmurPosition">部位:</label>
	 	<form:input path="vascularMurmurPosition" htmlEscape="false" maxlength="30" />
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="genitals"><strong>生殖器</strong>:</label>
	 	<form:select path="genitals" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('inspect')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="anorectum"><strong>肛门直肠</strong>:</label>
	 	<form:select path="anorectum" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('inspect')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="spine"><strong>脊柱四脚</strong>&nbsp;&nbsp;&nbsp;&nbsp;脊柱:</label>
	 	<form:select path="spine" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('spine')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="spinousProcess">棘突:</label>
	 	<form:select path="spinousProcess" style="width:140px;" class="input-medium-select" onchange="showspinousProcessPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('spinous_process')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showspinousProcessPosition" style="<c:choose><c:when test="${healthRecord.spinousProcess == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="spinousProcessPosition">部位:</label>
	 	<form:input path="spinousProcessPosition" htmlEscape="false" maxlength="30" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="limb">四肢:</label>
	 	<form:select path="limb" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('limb')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="jointSwelling">关节红肿:</label>
	 	<form:select path="jointSwelling" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="muscleTenderness">肌肉压痛:</label>
	 	<form:select path="muscleTenderness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="acropachia">杵状指:</label>
		<form:select path="acropachia" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="arthrocleisis">关节强直:</label>
	 	<form:select path="arthrocleisis" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="muscleAtrophy">肌肉萎缩:</label>
	 	<form:select path="muscleAtrophy" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="varixLowerLimb">下肢静脉曲张:</label>
	 	<form:select path="varixLowerLimb" style="width:140px;" class="input-medium-select" onchange="showvarixLowerLimbPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showvarixLowerLimbPosition" style="<c:choose><c:when test="${healthRecord.varixLowerLimb == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="varixLowerLimbPosition">部位及特征:</label>
	 	<form:input path="varixLowerLimbPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalRadiation"><strong>神经系统</strong>&nbsp;&nbsp;&nbsp;&nbsp;腹壁放射:</label>
	 	<form:select path="abdominalRadiation" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('abdominal_radiation')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="limbParalysis">肢体瘫痪:</label>
	 	<form:select path="limbParalysis" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('paralysis')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="muscleTension">肌张力:</label>
	 	<form:select path="muscleTension" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('abdominal_tension')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="muscleTensionLevel">肌力:</label>
	 	<form:input path="muscleTensionLevel" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-small digits"/>级
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bicepsReflexLeft">肱二头肌反射左:</label>
	 	<form:select path="bicepsReflexLeft" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('reflex')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="kneePhenomenonLeft">膝腱反射左:</label>
		 <form:select path="kneePhenomenonLeft" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('reflex')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
		<div class="div-col">
		<label class="control-label" for="achillesTendonReflexLeft">跟腱反射左:</label>
	 	<form:select path="achillesTendonReflexLeft" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('reflex')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="bicepsReflexRight">肱二头肌反射右:</label>
	 	<form:select path="bicepsReflexRight" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('reflex')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="kneePhenomenonRight">膝腱反射右:</label>
	 	<form:select path="kneePhenomenonRight" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('reflex')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="achillesTendonReflexRight">跟腱反射右:</label>
	 	<form:select path="achillesTendonReflexRight" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('reflex')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="hoffmann">Hoffmann征:</label>
	 	<form:select path="hoffmann" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('left_right')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="babinski">Babinski征:</label>
	 	<form:select path="babinski" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('left_right')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="kernig">Kernig征:</label>
	 	<form:select path="kernig" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('left_right')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="routineBloodTest"><strong>辅助检查</strong>&nbsp;&nbsp;&nbsp;血常规:</label>
 	<form:textarea path="routineBloodTest" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">
	<label class="control-label" for="electrocardiogram">心电图:</label>
 	<form:textarea path="electrocardiogram" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">
	<label class="control-label" for="xrayChestRadiography">X线胸部摄片:</label>
 	<form:textarea path="xrayChestRadiography" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">
	<label class="control-label" for="bultrasonic">B超:</label>
 	<form:textarea path="bultrasonic" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">
	<label class="control-label" for="liverKidneyFunction">肝、肾功能:</label>
	<form:textarea path="liverKidneyFunction" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">
	<label class="control-label" for="bloodGlucoseLipid">血糖、血脂:</label>
 	<form:textarea path="bloodGlucoseLipid" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">
	<label class="control-label" for="electrolytic">电解质:</label>
	<form:textarea path="electrolytic" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">	
	<label class="control-label" for="other">其他:</label>
 	<form:textarea path="other" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
</div>
<div class="control-group">	
	<label class="control-label">其他待说明情况:</label>
	<label class="label-col"></label>
</div>
<div class="control-group">	
	<label class="control-label"></label>
	<label class="label-col">1、因老人生理机能衰退、骨质疏松、痴呆以及心理情绪失调等原因以避免发生突发心脑血管疾病、
	<br/>伤残、猝死、衰老死亡等意外情况。</label>
</div>
<div class="control-group">	
	<label class="control-label"></label>
	<label class="label-col">2、长期卧床老人难以避免地出现褥疮、肺部感染、泌尿系统感染等意外情况。</label>
</div>
<div class="control-group">	
	<label class="control-label"></label>
	<label class="label-col">3、其他不可预见的情况。</label>
</div>
<div class="control-group">	
	<div class="div-col">
		<label class="control-label" for="contactAddress">联系地址:</label>
	 	<form:textarea path="contactAddress" htmlEscape="false" maxlength="50" class="input-mlarge"/>
	</div>
	<div class="div-col">
		<label class="control-label" for="ontactNumber">联系电话:</label>
	 	<form:input path="ontactNumber" htmlEscape="false" maxlength="18" class="phone"/>
	</div>
</div>
<div class="control-group">	
	<label class="control-label"></label>
	<label class="label-col">以上各项属实。</label>
</div>
<div class="control-group">	
	<div class="div-col">
		<label class="control-label">家属签名:</label>
		<label class="label-col"></label>
	</div>
	<div class="div-col">
		<label class="control-label">保健医生签名:</label>
		<label class="label-col"></label>
	</div>
</div>
<div class="control-group">	
	<div class="div-col">
		<label class="control-label"></label>
		<label class="label-col">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</label>
	</div>
	<div class="div-col">
		<label class="control-label"></label>
		<label class="label-col">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</label>
	</div>
</div>









