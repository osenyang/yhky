<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="percussBucklePain"><strong>叩诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;扣痛:</label>
	 	<form:select path="percussBucklePain" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('percuss_buckle_pain')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-colm">
		<label class="control-label" for="scapularLineLeft"><strong>肺下界</strong>&nbsp;&nbsp;肩甲线左 :</label>
	 	<form:input path="scapularLineLeft" htmlEscape="false" maxlength="20" class="input-small"/>肋间隙
		<label for="scapularLineRight">&nbsp;&nbsp;右 :</label>
	 	<form:input path="scapularLineRight" htmlEscape="false" maxlength="20" class="input-small"/>肋间隙
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="abnormalPercussionNote">异常叩诊音:</label>
	 	<form:select path="abnormalPercussionNote" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('abnormal_percussion_note')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-colm">
		<label class="control-label" for="moveLeft">移动度&nbsp;左 :</label>
	 	<form:input path="moveLeft" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-small number"/>cm
	 	<label for="moveRight">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;右 :</label>
	 	<form:input path="moveRight" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-small number"/>cm
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="breath"><strong>听诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;呼吸:</label>
	 	<form:select path="breath" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('breath')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="rale">啰音:</label>
	 	<form:select path="rale" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('rale')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="breathSounds">呼吸音:</label>
	 	<form:select path="breathSounds" style="width:140px;" class="input-medium-select" onchange="showbreathSoundsPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('breath_sounds')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-colm" id="showbreathSoundsPosition" style="<c:choose><c:when test="${healthRecord.breathSounds == '3'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="breathSoundsPosition">性质及部位:</label>
		<form:input path="breathSoundsPosition" htmlEscape="false" maxlength="30" />
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="voiceConduction"><strong>触诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;语音传导:</label>
	 	<form:select path="voiceConduction" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('voice_conduction')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="pleuralRale">胸膜摩擦音:</label>
	 	<form:select path="pleuralRale" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="precordialProminence"><strong>心</strong>&nbsp;<strong>视诊</strong>&nbsp;心前区隆起:</label>
	 	<form:select path="precordialProminence" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="precordialBeat">心尖搏动:</label>
	 	<form:select path="precordialBeat" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('apex_beat')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="precordialBeatPosition">心尖搏动位置:</label>
	 	<form:select path="precordialBeatPosition" style="width:140px;" class="input-medium-select" onchange="showlmcl(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_normal')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" id="showlmcl" style="<c:choose><c:when test="${healthRecord.precordialBeatPosition == '3'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
	<label class="control-label" for="lmcl"><font size="1px;">移位距左锁骨中线内外:</font></label>
	<form:input path="lmcl" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-small number"/>cm
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="palpateApexBeat"><strong>触诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;心尖搏动:</label>
	 	<form:select path="palpateApexBeat" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('palpate_apex_beat')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="pericardialFriction">心包摩擦感:</label>
	 	<form:select path="pericardialFriction" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="shuddar">震颤:</label>
	 	<form:select path="shuddar" style="width:140px;" class="input-medium-select" onchange="showtremor(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" id="showtremor" style="<c:choose><c:when test="${healthRecord.shuddar == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
	<div class="div-col">
		<label class="control-label" for="tremor">部位:</label>
	 	<form:input path="tremor" htmlEscape="false" maxlength="50" />
	</div>
	<div class="div-col">
		<label class="control-label" for="tremorSite">时期:</label>
	 	<form:input path="tremorSite" htmlEscape="false" maxlength="30" />
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<label class="control-label" ></label>
	<table id="contentTable" class="table table-striped table-bordered table-condensed" style="width:400px;">
		<thead><tr>
			<th style="text-align: center;">右(cm)</th>
			<th style="width:50px;text-align: center;">肋间</th>
			<th style="text-align: center;">左(cm)</th>
		</tr></thead>
		<tbody>
			<tr>
				<td style="text-align: center;"><form:input path="rightIntercostal1" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
				<td style="text-align: center;">Ⅱ</td>
				<td style="text-align: center;"><form:input path="leftIntercostal1" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
			</tr>
			<tr>
				<td style="text-align: center;"><form:input path="rightIntercostal2" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
				<td style="text-align: center;">Ⅲ</td>
				<td style="text-align: center;"><form:input path="leftIntercostal2" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
			</tr>
			<tr>
				<td style="text-align: center;"><form:input path="rightIntercostal3" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
				<td style="text-align: center;">Ⅳ</td>
				<td style="text-align: center;"><form:input path="leftIntercostal3" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
			</tr>
			<tr>
				<td style="text-align: center;"><form:input path="rightIntercostal4" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
				<td style="text-align: center;">Ⅴ</td>
				<td style="text-align: center;"><form:input path="leftIntercostal4" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')" class="input-mini number"/></td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;">MCL距前正中线:<form:input path="mclFrontLine" htmlEscape="false" maxlength="5" class="input-mini" />cm</td>
			</tr>
		</tbody>
	</table>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="borderRelativeDullness"><strong>叩诊</strong>&nbsp;&nbsp;&nbsp;相对浊音界:</label>
	 	<form:select path="borderRelativeDullness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('border_relative_dullness')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="heartRate"><strong>听诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;心率:</label>
	 	<form:input path="heartRate" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" class="input-mini digits"/>次/分
	</div>
	<div class="div-col">
		<label class="control-label" for="s1">S1:</label>
	 	<form:select path="s1" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('S1')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="s2">S2:</label>
	 	<form:select path="s2" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('S1')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="heartRhythm">心律:</label>
	 	<form:select path="heartRhythm" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('heart_rhythm')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="a2p2"></label>
		<label class="label-col">
		 	<input id="a2" name="a2p2"  <c:if test="${fns:containStr(healthRecord.a2p2,'A2')}">checked</c:if> type="checkbox"  value="A2" />
			<label for="a2">A2</label> 
			<input id="p2" name="a2p2"  <c:if test="${fns:containStr(healthRecord.a2p2,'P2')}">checked</c:if> type="checkbox"  value="P2" />
			<label for="p2">P2</label> 
		</label>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="openingSnap">开瓣音:</label>
	 	<form:select path="openingSnap" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="capillaryVesselSyndrome">毛细血管博动征:</label>
	 	<form:select path="capillaryVesselSyndrome" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="corriganPulse">水冲脉:</label>
	 	<form:select path="corriganPulse" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bigBloodVesselGunshot">大血管枪击音:</label>
	 	<form:select path="bigBloodVesselGunshot" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="oddPulse">奇脉:</label>
	 	<form:select path="oddPulse" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="alternans">交替脉:</label>
	 	<form:select path="alternans" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="duroziezDoubleMurmur">Duroziez二重杂音:</label>
	 	<form:select path="duroziezDoubleMurmur" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="corriganPulseMurmur">杂音:</label>
	 	<form:select path="corriganPulseMurmur" style="width:140px;" class="input-medium-select" onchange="showcorriganPulseMurmurPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showcorriganPulseMurmurPosition" style="<c:choose><c:when test="${healthRecord.corriganPulseMurmur == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="corriganPulseMurmurPosition">部位及性质:</label>
	 	<form:input path="corriganPulseMurmurPosition" htmlEscape="false" maxlength="50" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalConfiguration"><strong>腹部</strong>&nbsp;<strong>望诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;外形:</label>
	 	<form:select path="abdominalConfiguration" style="width:140px;" class="input-medium-select" onchange="showfrogBelly(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('abdominal_configuration')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showfrogBelly" style="<c:choose><c:when test="${healthRecord.abdominalConfiguration == '3'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="frogBelly">腹围:</label>
	 	<form:input path="frogBelly" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d./g,'')" class="input-mini number"/>cm
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="gastricType">胃型:</label>
	 	<form:select path="gastricType" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="intestinalType">肠型:</label>
	 	<form:select path="intestinalType" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="peristalticRushes">蠕动波:</label>
	 	<form:select path="peristalticRushes" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalBreathing">腹式呼吸:</label>
	 	<form:select path="abdominalBreathing" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('abdominal_breathing')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="umbilicus">脐:</label>
	 	<form:select path="umbilicus" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('umbilicus')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="abdominalVaricoseVein">腹部静脉曲张:</label>
	 	<form:select path="abdominalVaricoseVein" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="ventralStripe">腹纹:</label>
	 	<form:select path="ventralStripe" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="surgicalScars">手术疤痕:</label>
	 	<form:select path="surgicalScars" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="hernia">疝:</label>
	 	<form:select path="hernia" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="palpation"><strong>触诊</strong>:</label>
	 	<form:select path="palpation" style="width:140px;" class="input-medium-select" onchange="showpalpationPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('palpation')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showpalpationPosition" style="<c:choose><c:when test="${healthRecord.palpation == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="palpationPosition">部位:</label>
	 	<form:input path="palpationPosition" htmlEscape="false" maxlength="30" />
	</div>
	<div class="div-col">
		<label class="control-label" for="fluidThrill">液波震颤:</label>
	 	<form:select path="fluidThrill" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="tenderness">压痛:</label>
	 	<form:select path="tenderness" style="width:140px;" class="input-medium-select" onchange="showtendernessPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showtendernessPosition" style="<c:choose><c:when test="${healthRecord.tenderness == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="tendernessPosition">部位:</label>
	 	<form:input path="tendernessPosition" htmlEscape="false" maxlength="30" />
	</div>
	<div class="div-col">
		<label class="control-label" for="seismicAcoustic">震水声:</label>
	 	<form:select path="seismicAcoustic" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="reboundTenderness">反跳痛:</label>
	 	<form:select path="reboundTenderness" style="width:140px;" class="input-medium-select" onchange="showreboundTendernessPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showreboundTendernessPosition" style="<c:choose><c:when test="${healthRecord.reboundTenderness == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="reboundTendernessPosition">部位:</label>
	 	<form:input path="reboundTendernessPosition" htmlEscape="false" maxlength="30" />
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalMass">腹部包块:</label>
	 	<form:select path="abdominalMass" style="width:140px;" class="input-medium-select" onchange="showabdominalMassPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-colm" id="showabdominalMassPosition" style="<c:choose><c:when test="${healthRecord.abdominalMass == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="abdominalMassSize">大小:</label>
	 	<form:input path="abdominalMassSize" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d./g,'')" class="input-mini number"/>
		<label for="abdominalMassPosition">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部位:</label>
	 	<form:input path="abdominalMassPosition" htmlEscape="false" maxlength="30" class="input-small"/>
		<label for="abdominalMassNature">&nbsp;&nbsp;&nbsp;&nbsp;性质 :</label>
	 	<form:input path="abdominalMassNature" htmlEscape="false" maxlength="30" class="input-small"/>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="liver">肝:</label>
	 	<form:select path="liver" style="width:140px;" class="input-medium-select" onchange="showliverSubcostal(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('touch')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-colm" id="showliverSubcostal" style="<c:choose><c:when test="${healthRecord.liver == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="liverSubcostal">肋下:</label>
	 	<form:input path="liverSubcostal" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d./g,'')" class="input-mini number"/>cm
		<label for="liverFeature">&nbsp;特征:</label>
	 	<form:input path="liverFeature" htmlEscape="false" maxlength="30" class="input-small"/>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="gallbladder">胆:</label>
	 	<form:select path="gallbladder" style="width:140px;" class="input-medium-select" onchange="showgallbladderSize(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('touch')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showgallbladderSize" style="<c:choose><c:when test="${healthRecord.gallbladder == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="gallbladderSize">大小:</label>
	 	<form:input path="gallbladderSize" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d./g,'')" class="input-mini number"/>cm
	</div>
	<div class="div-col">
		<label class="control-label" for="gallbladderTenderness">压痛:</label>
	 	<form:select path="gallbladderTenderness" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="spleen">脾:</label>
		<form:select path="spleen" style="width:140px;" class="input-medium-select" onchange="showspleenSubcostal(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('touch')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showspleenSubcostal" style="<c:choose><c:when test="${healthRecord.spleen == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label for="spleenSubcostal">肋下:</label>
	 	<form:input path="spleenSubcostal" htmlEscape="false" maxlength="5" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d./g,'')" class="input-mini number"/>cm
		<label for="spleenFeature">&nbsp;特征:</label>
	 	<form:input path="spleenFeature" htmlEscape="false" maxlength="30" class="input-small"/>
	</div>
	<div class="div-col">
		<label class="control-label" for="murphy">Murphy 征:</label>
	 	<form:select path="murphy" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('yin_yang')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="kidney">肾:</label>
	 	<form:select path="kidney" style="width:140px;" class="input-medium-select" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('touch')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col">
		<label class="control-label" for="tenderSpotUreter">输尿管压痛点:</label>
	 	<form:select path="tenderSpotUreter" style="width:140px;" class="input-medium-select" onchange="showtenderSpotUreterPosition(this.value);">
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('not_have')}" itemValue="value" itemLabel="label"/>
	 	</form:select>
	</div>
	<div class="div-col" id="showtenderSpotUreterPosition" style="<c:choose><c:when test="${healthRecord.tenderSpotUreter == '2'}">display: block;</c:when><c:otherwise>display: none;</c:otherwise></c:choose>">
		<label class="control-label" for="tenderSpotUreterPosition">部位:</label>
	 	<form:input path="tenderSpotUreterPosition" htmlEscape="false" maxlength="30" />
	</div>
</div>