<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="temperature">体温(T):</label>
	 	<form:input path="temperature" htmlEscape="false" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-small number" />ºC
	</div>
	<div class="div-col">
		<label class="control-label" for="pulse">脉搏(P):</label>
	 	<form:input path="pulse" htmlEscape="false" maxlength="3" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-small digits" />次/分
	</div>
	<div class="div-col">
		<label class="control-label" for="breathingRate">呼吸频率(R):</label>
	 	<form:input path="breathingRate" htmlEscape="false" maxlength="6" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-small digits" />次/分
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bloodPressure">血压(Bp):</label>
	 	<form:input path="bloodPressure" htmlEscape="false" maxlength="3" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-small digits"/>mmHg
	</div>
	<div class="div-col">
		<label class="control-label" for="auxe">发育:</label>
	 	<form:select path="auxe" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('auxe')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="face">面容:</label>
	 	<form:select path="face" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('face')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="position">体位:</label>
	 	<form:select path="position" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('position')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="consciousness">神志:</label>
	 	<form:select path="consciousness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('consciousness')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="nutrition">营养:</label>
	 	<form:select path="nutrition" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('nutrition')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="expression">表情:</label>
	 	<form:select path="expression" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('expression')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="gait">步态:</label>
	 	<form:select path="gait" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_normal')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="cooperateInspect">配合检查:</label>
	 	<form:select path="cooperateInspect" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_cooperate')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="pigment"><strong>皮肤黏膜</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色素:</label>
	 	<form:select path="pigment" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('pigment')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="erythra">皮疹:</label>
	 	<form:select path="erythra" style="width:140px;" class="input-medium-select" onchange="showerythraType(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showerythraType" style="<c:choose><c:when test="${healthRecord.erythra == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="erythraType">类型及分布:</label>
	 	<form:input path="erythraType" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="liverPalms">肝掌:</label>
	 	<form:select path="liverPalms" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="subcutaneousHemorrhage">皮下出血:</label>
	 	<form:select path="subcutaneousHemorrhage" style="width:140px;" class="input-medium-select" onchange="showsubcutaneousHemorrhageType(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showsubcutaneousHemorrhageType" style="<c:choose><c:when test="${healthRecord.subcutaneousHemorrhage == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="subcutaneousHemorrhageType">类型及分布:</label>
	 	<form:input path="subcutaneousHemorrhageType" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="temperatureHumidity">温度与湿度:</label>
	 	<form:select path="temperatureHumidity" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('temperature_humidity')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="hairDistribution">毛发分布:</label>
	 	<form:select path="hairDistribution" style="width:140px;" class="input-medium-select" onchange="showhairDistributionPosition(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('hair_distribution')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showhairDistributionPosition" style="<c:choose><c:when test="${healthRecord.hairDistribution == '4'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="hairDistributionPosition">部位:</label>
	 	<form:input path="hairDistributionPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="elastic">弹性:</label>
	 	<form:select path="elastic" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('elastic')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="edema">水肿:</label>
	 	<form:select path="edema" style="width:140px;" class="input-medium-select" onchange="showedemaPosition(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showedemaPosition" style="<c:choose><c:when test="${healthRecord.edema == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="edemaPosition">部位及程度:</label>
	 	<form:input path="edemaPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="spider">蜘蛛痣:</label>
	 	<form:select path="spider" style="width:140px;" class="input-medium-select" onchange="showspiderPosition(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showspiderPosition" style="<c:choose><c:when test="${healthRecord.spider == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="spiderPosition">数目及部位:</label>
	 	<form:input path="spiderPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="superficialLymphNodes"><strong>淋巴结</strong>&nbsp;<font size="1px">全身浅表淋巴结:</font></label>
	 	<form:select path="superficialLymphNodes" style="width:140px;" class="input-medium-select" onchange="showsuperficialLymphNodesPosition(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('superficial_lymph_nodes')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showsuperficialLymphNodesPosition" style="<c:choose><c:when test="${healthRecord.superficialLymphNodes == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="superficialLymphNodesPosition">部位及特征:</label>
	 	<form:input path="superficialLymphNodesPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="head"><strong>头部</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;头颅:</label>
	 	<form:select path="head" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('head')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="malformation">畸形:</label>
	 	<form:select path="malformation" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('malformation')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="headTenderness">压痛:</label>
	 	<form:select path="headTenderness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="headEnclosedMass">包块:</label>
	 	<form:select path="headEnclosedMass" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="concaveLimit">凹限:</label>
	 	<form:select path="concaveLimit" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="eyelid"><strong>眼</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;眼脸:</label>
	 	<form:select path="eyelid" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('eye')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="conjunctiva">结膜:</label>
	 	<form:select path="conjunctiva" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('conjunctiva')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="eyeball">眼球:</label>
	 	<form:select path="eyeball" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('eyeball')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="albugineaOculi">巩膜:</label>
	 	<form:select path="albugineaOculi" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('albuginea_oculi')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="cerato">角膜:</label>
	 	<form:select path="cerato" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('cerato')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="pupil">瞳孔:</label>
	 	<form:select path="pupil" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('pupil')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="lightReaction">对光反射:</label>
	 	<form:select path="lightReaction" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('light_reaction')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="auricle"><strong>耳</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;耳廓:</label>
	 	<form:select path="auricle" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('auricle')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="sternocleidomastoidPain">乳突压痛:</label>
	 	<form:select path="sternocleidomastoidPain" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_left_right')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="coarseHearingImpairment">粗听力障碍:</label>
	 	<form:select path="coarseHearingImpairment" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_left_right')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="externalSecretion">外耳道分泌物:</label>
	 	<form:select path="externalSecretion" style="width:140px;" class="input-medium-select" onchange="showexternalSecretionNature(this.value)">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_left_right')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showexternalSecretionNature" style="<c:choose><c:when test="${healthRecord.externalSecretion == '2' || healthRecord.externalSecretion == '3'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="externalSecretionNature">性质:</label>
	 	<form:input path="externalSecretionNature" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="noseContour"><strong>鼻</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;外形:</label>
	 	<form:select path="noseContour" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('abnormal')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="otherAnomalies">其他异常:</label>
	 	<form:select path="otherAnomalies" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('other_anomalies')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="nasalSinusTenderness">鼻旁窦压痛:</label>
	 	<form:select path="nasalSinusTenderness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="lip"><strong>口唇</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;嘴唇:</label>
	 	<form:select path="lip" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('lip')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="mucousCoat">粘膜:</label>
	 	<form:select path="mucousCoat" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('mucous_coat')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="parotidDuctOpening">腮腺导管开口:</label>
	 	<form:select path="parotidDuctOpening" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('parotid_duct_opening')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="tongue"><strong>舌:</strong></label>
	 	<form:select path="tongue" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('tongue')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="gingiva"><strong>齿龈:</strong></label>
	 	<form:select path="gingiva" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('gingiva')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" style="float:left;">
		<label class="control-label" for="dentition"><strong>齿列:</strong></label>
	 	<form:select path="dentition" style="width:110px;" class="input-medium-select" onchange="showagomphosisNumber(value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('dentition')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	 	<c:choose>
	 		<c:when test="${healthRecord.dentition == '2' || healthRecord.dentition == '3' || healthRecord.dentition == '4'}">
	 			<form:input path="agomphosisNumber" htmlEscape="false" maxlength="2" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-mini digits" />
	 		</c:when>
	 		<c:otherwise>
	 			<form:input style="display: none;" path="agomphosisNumber" htmlEscape="false" maxlength="2" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-mini digits" />
	 		</c:otherwise>
	 	</c:choose>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="tonsilla"><strong>扁桃体:</strong></label>
	 	<form:select path="tonsilla" style="width:100px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('superficial_lymph_nodes')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	 	<form:select path="tonsillaFester" style="width:100px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('fester')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="pharynx"><strong>咽:</strong></label>
	 	<form:select path="pharynx" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('pharynx')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="voice"><strong>声音:</strong></label>
	 	<form:select path="voice" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('voice')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="senseResistance"><strong>颈部</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抵抗感:</label>
	 	<form:select path="senseResistance" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="stiffnessArteryFluctuation">颈动脉波动:</label>
	 	<form:select path="stiffnessArteryFluctuation" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('carotid_artery_fluctuation')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="jugularVein">颈静脉:</label>
	 	<form:select path="jugularVein" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('jugular_vein')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="trachea">气管:</label>
	 	<form:select path="trachea" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('trachea')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="hepatojugularReflux">肝颈静脉回流征:</label>
	 	<form:select path="hepatojugularReflux" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('yin_yang')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col" style="float: left;">
		<label class="control-label" for="thyroid">甲状腺:</label>
	 	<form:select path="thyroid" style="width:110px;" class="input-medium-select" onchange="showthyroidTumefaction(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('thyroid')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	 	<c:choose>
	 		<c:when test="${healthRecord.thyroid == '2'}">
	 			<form:input path="thyroidTumefaction" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number" /><span id='delTume'>度</span>
	 		</c:when>
	 		<c:otherwise>
	 			<form:input style="display: none;" path="thyroidTumefaction" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number" />
	 		</c:otherwise>
	 	</c:choose>
	</div>
	<div class="div-col">
		<label class="control-label" for="leftRightSidesMainly">左右侧为主:</label>
	 	<form:select path="leftRightSidesMainly" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('left_right_sides_mainly')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="thorax"><strong>胸部</strong>&nbsp;&nbsp;<strong>视诊</strong>&nbsp;&nbsp;&nbsp;胸廓:</label>
	 	<form:select path="thorax" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('thorax')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="breast">乳房:</label>
	 	<form:select path="breast" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('breast')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="breastEnclosedMass">包块:</label>
	 	<form:select path="breastEnclosedMass" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="breastTenderness">压痛:</label>
	 	<form:select path="breastTenderness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="excreta">分泌物:</label>
	 	<form:select path="excreta" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="respiratoryMovement">呼吸运动:</label>
	 	<form:select path="respiratoryMovement" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('respiratory_movement')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="vocalFremitus">语颤:</label>
	 	<form:select path="vocalFremitus" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('respiratory_movement')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="ribSpace">肋间隙:</label>
	 	<form:select path="ribSpace" style="width:140px;" class="input-medium-select" onchange="showribSpacePosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('rib_space')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showribSpacePosition" style="<c:choose><c:when test="${healthRecord.ribSpace == '3'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="ribSpacePosition">部位:</label>
	 	<form:input path="ribSpacePosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="pleuralFriction">胸膜摩擦感:</label>
	 	<form:select path="pleuralFriction" style="width:140px;" class="input-medium-select" onchange="showpleuralFrictionPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showpleuralFrictionPosition" style="<c:choose><c:when test="${healthRecord.pleuralFriction == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="pleuralFrictionPosition">部位:</label>
	 	<form:input path="pleuralFrictionPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="subcutaneousCrepitus">皮下捻发感:</label>
	 	<form:select path="subcutaneousCrepitus" style="width:140px;" class="input-medium-select" onchange="showsubcutaneousCrepitusPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showsubcutaneousCrepitusPosition" style="<c:choose><c:when test="${healthRecord.subcutaneousCrepitus == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="subcutaneousCrepitusPosition">部位:</label>
		<form:input path="subcutaneousCrepitusPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
