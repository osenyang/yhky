<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="percussBucklePain"><strong>叩诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;扣痛:</label>
	 	${fns:getDictLabel(healthRecord.percussBucklePain,'percuss_buckle_pain','')}
	</div>
	<div class="div-colm">
		<label class="control-label" for="scapularLineLeft"><strong>肺下界</strong>&nbsp;&nbsp;肩甲线左 :</label>
	 	&nbsp;&nbsp;${healthRecord.scapularLineLeft}&nbsp;&nbsp;肋间隙
		<label for="scapularLineRight">&nbsp;&nbsp;右 :</label>
	 	&nbsp;&nbsp;${healthRecord.scapularLineRight}&nbsp;&nbsp;肋间隙
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="abnormalPercussionNote">异常叩诊音:</label>
		${fns:getDictLabel(healthRecord.abnormalPercussionNote,'abnormal_percussion_note','')}
	</div>
	<div class="div-colm">
		<label class="control-label" for="moveLeft">移动度&nbsp;左 :</label>
	 	&nbsp;&nbsp;${healthRecord.moveLeft}&nbsp;&nbsp;cm
	 	<label for="moveRight">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;右 :</label>
	 	&nbsp;&nbsp;${healthRecord.moveRight}&nbsp;&nbsp;cm
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="breath"><strong>听诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;呼吸:</label>
	 	${fns:getDictLabel(healthRecord.breath,'breath','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="rale">啰音:</label>
		${fns:getDictLabel(healthRecord.rale,'rale','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="breathSounds">呼吸音:</label>
		${fns:getDictLabel(healthRecord.breathSounds,'breath_sounds','')}
	</div>
	<c:if test="${healthRecord.breathSounds == '3'}">
		<div class="div-colm" id="showbreathSoundsPosition">
			<label class="control-label" for="breathSoundsPosition">性质及部位:</label>
			${healthRecord.breathSoundsPosition}
		</div>
	</c:if>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="voiceConduction"><strong>触诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;语音传导:</label>
	 	${fns:getDictLabel(healthRecord.voiceConduction,'voice_conduction','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="pleuralRale">胸膜摩擦音:</label>
		${fns:getDictLabel(healthRecord.pleuralRale,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="precordialProminence"><strong>心</strong>&nbsp;<strong>视诊</strong>&nbsp;心前区隆起:</label>
	 	${fns:getDictLabel(healthRecord.precordialProminence,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="precordialBeat">心尖搏动:</label>
		${fns:getDictLabel(healthRecord.precordialBeat,'apex_beat','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="precordialBeatPosition">心尖搏动位置:</label>
		${fns:getDictLabel(healthRecord.precordialBeatPosition,'not_normal','')}
	</div>
</div>
<c:if test="${healthRecord.precordialBeatPosition == '3'}">
<div class="control-group" id="showlmcl">
	<label class="control-label" for="lmcl"><font size="1px;">移位距左锁骨中线内外:</font></label>
	&nbsp;&nbsp;&nbsp;${healthRecord.lmcl}cm
</div>
</c:if>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="palpateApexBeat"><strong>触诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;心尖搏动:</label>
	 	${fns:getDictLabel(healthRecord.palpateApexBeat,'palpate_apex_beat','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="pericardialFriction">心包摩擦感:</label>
		${fns:getDictLabel(healthRecord.pericardialFriction,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="shuddar">震颤:</label>
		${fns:getDictLabel(healthRecord.shuddar,'not_have','')}
	</div>
</div>
<c:if test="${healthRecord.shuddar == '2'}">
	<div class="control-group" id="showtremor">
		<div class="div-col">
			<label class="control-label" for="tremor">部位:</label>
		 	${healthRecord.tremor}
		</div>
		<div class="div-col">
			<label class="control-label" for="tremorSite">时期:</label>
		 	${healthRecord.tremorSite}
		</div>
	</div>
</c:if>
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
				<td style="text-align: center;">${healthRecord.rightIntercostal1}</td>
				<td style="text-align: center;">Ⅱ</td>
				<td style="text-align: center;">${healthRecord.leftIntercostal1}</td>
			</tr>
			<tr>
				<td style="text-align: center;">${healthRecord.rightIntercostal2}</td>
				<td style="text-align: center;">Ⅲ</td>
				<td style="text-align: center;">${healthRecord.leftIntercostal2}</td>
			</tr>
			<tr>
				<td style="text-align: center;">${healthRecord.rightIntercostal3}</td>
				<td style="text-align: center;">Ⅳ</td>
				<td style="text-align: center;">${healthRecord.leftIntercostal3}</td>
			</tr>
			<tr>
				<td style="text-align: center;">${healthRecord.rightIntercostal4}</td>
				<td style="text-align: center;">Ⅴ</td>
				<td style="text-align: center;">${healthRecord.leftIntercostal4}</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;">MCL距前正中线:${healthRecord.mclFrontLine}cm</td>
			</tr>
		</tbody>
	</table>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="borderRelativeDullness"><strong>叩诊</strong>&nbsp;&nbsp;&nbsp;相对浊音界:</label>
	 	${fns:getDictLabel(healthRecord.borderRelativeDullness,'border_relative_dullness','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="heartRate"><strong>听诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;心率:</label>
	 	${healthRecord.heartRate}次/分
	</div>
	<div class="div-col">
		<label class="control-label" for="s1">S1:</label>
		${fns:getDictLabel(healthRecord.s1,'S1','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="s2">S2:</label>
		${fns:getDictLabel(healthRecord.s2,'S1','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="heartRhythm">心律:</label>
		${fns:getDictLabel(healthRecord.heartRhythm,'heart_rhythm','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="a2p2"></label>
		<label class="label-col">
		 	<c:if test="${fns:containStr(healthRecord.a2p2,'A2')}">A2</c:if>
		 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${fns:containStr(healthRecord.a2p2,'P2')}">P2</c:if> 
		</label>
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="openingSnap">开瓣音:</label>
		${fns:getDictLabel(healthRecord.openingSnap,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="capillaryVesselSyndrome">毛细血管博动征:</label>
		${fns:getDictLabel(healthRecord.capillaryVesselSyndrome,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="corriganPulse">水冲脉:</label>
		${fns:getDictLabel(healthRecord.corriganPulse,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bigBloodVesselGunshot">大血管枪击音:</label>
		${fns:getDictLabel(healthRecord.bigBloodVesselGunshot,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="oddPulse">奇脉:</label>
		${fns:getDictLabel(healthRecord.oddPulse,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="alternans">交替脉:</label>
		${fns:getDictLabel(healthRecord.alternans,'not_have','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="duroziezDoubleMurmur">Duroziez二重杂音:</label>
		${fns:getDictLabel(healthRecord.duroziezDoubleMurmur,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="corriganPulseMurmur">杂音:</label>
		${fns:getDictLabel(healthRecord.corriganPulseMurmur,'not_have','')}
	</div>
	<c:if test="${healthRecord.corriganPulseMurmur == '2'}">
		<div class="div-col" id="showcorriganPulseMurmurPosition">
			<label class="control-label" for="corriganPulseMurmurPosition">部位及性质:</label>
		 	${healthRecord.corriganPulseMurmurPosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalConfiguration"><strong>腹部</strong>&nbsp;<strong>望诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;外形:</label>
	 	${fns:getDictLabel(healthRecord.abdominalConfiguration,'abdominal_configuration','')}
	</div>
	<c:if test="${healthRecord.abdominalConfiguration == '3'}">
		<div class="div-col" id="showfrogBelly">
			<label class="control-label" for="frogBelly">腹围:</label>
		 	&nbsp;&nbsp;${healthRecord.corriganPulseMurmurPosition}cm
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="gastricType">胃型:</label>
		${fns:getDictLabel(healthRecord.gastricType,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="intestinalType">肠型:</label>
		${fns:getDictLabel(healthRecord.intestinalType,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="peristalticRushes">蠕动波:</label>
		${fns:getDictLabel(healthRecord.peristalticRushes,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalBreathing">腹式呼吸:</label>
		${fns:getDictLabel(healthRecord.abdominalBreathing,'abdominal_breathing','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="umbilicus">脐:</label>
		${fns:getDictLabel(healthRecord.umbilicus,'umbilicus','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="abdominalVaricoseVein">腹部静脉曲张:</label>
		${fns:getDictLabel(healthRecord.abdominalVaricoseVein,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="ventralStripe">腹纹:</label>
		${fns:getDictLabel(healthRecord.ventralStripe,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="surgicalScars">手术疤痕:</label>
		${fns:getDictLabel(healthRecord.surgicalScars,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="hernia">疝:</label>
		${fns:getDictLabel(healthRecord.hernia,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="palpation"><strong>触诊</strong>:</label>
		${fns:getDictLabel(healthRecord.palpation,'palpation','')}
	</div>
	<c:if test="${healthRecord.palpation == '2'}">
		<div class="div-col" id="showpalpationPosition">
			<label class="control-label" for="palpationPosition">部位:</label>
		 	${healthRecord.palpationPosition}
		</div>
	</c:if>
	<div class="div-col">
		<label class="control-label" for="fluidThrill">液波震颤:</label>
		${fns:getDictLabel(healthRecord.fluidThrill,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="tenderness">压痛:</label>
		${fns:getDictLabel(healthRecord.tenderness,'not_have','')}
	</div>
	<c:if test="${healthRecord.tenderness == '2'}">
		<div class="div-col" id="showtendernessPosition">
			<label class="control-label" for="tendernessPosition">部位:</label>
		 	${healthRecord.tendernessPosition}
		</div>
	</c:if>
	<div class="div-col">
		<label class="control-label" for="seismicAcoustic">震水声:</label>
		${fns:getDictLabel(healthRecord.seismicAcoustic,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="reboundTenderness">反跳痛:</label>
		${fns:getDictLabel(healthRecord.reboundTenderness,'not_have','')}
	</div>
	<c:if test="${healthRecord.reboundTenderness == '2'}">
		<div class="div-col" id="showreboundTendernessPosition">
			<label class="control-label" for="reboundTendernessPosition">部位:</label>
		 	${healthRecord.reboundTendernessPosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalMass">腹部包块:</label>
		${fns:getDictLabel(healthRecord.abdominalMass,'not_have','')}
	</div>
	<c:if test="${healthRecord.abdominalMass == '2'}">
		<div class="div-colm" id="showabdominalMassPosition">
			<label class="control-label" for="abdominalMassSize">大小:</label>
		 	${healthRecord.abdominalMassSize}&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="abdominalMassPosition">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部位:</label>
		 	${healthRecord.abdominalMassPosition}&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="abdominalMassNature">&nbsp;&nbsp;&nbsp;&nbsp;性质 :</label>
		 	${healthRecord.abdominalMassNature}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="liver">肝:</label>
		${fns:getDictLabel(healthRecord.liver,'touch','')}
	</div>
	<c:if test="${healthRecord.liver == '2'}">
		<div class="div-colm" id="showliverSubcostal">
			<label class="control-label" for="liverSubcostal">肋下:</label>
		 	&nbsp;&nbsp;${healthRecord.liverSubcostal}&nbsp;&nbsp;cm
			<label for="liverFeature">&nbsp;特征:</label>
		 	&nbsp;&nbsp;${healthRecord.liverFeature}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="gallbladder">胆:</label>
		${fns:getDictLabel(healthRecord.gallbladder,'touch','')}
	</div>
	<c:if test="${healthRecord.gallbladder == '2'}">
		<div class="div-col" id="showgallbladderSize">
			<label class="control-label" for="gallbladderSize">大小:</label>
		 	&nbsp;&nbsp;${healthRecord.gallbladderSize}&nbsp;&nbsp;cm
		</div>
	</c:if>
	<div class="div-col">
		<label class="control-label" for="gallbladderTenderness">压痛:</label>
		${fns:getDictLabel(healthRecord.gallbladderTenderness,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="spleen">脾:</label>
		${fns:getDictLabel(healthRecord.spleen,'touch','')}
	</div>
	<c:if test="${healthRecord.spleen == '2'}">
		<div class="div-col" id="showspleenSubcostal">
			<label for="spleenSubcostal">肋下:</label>
			&nbsp;&nbsp;${healthRecord.spleenSubcostal}&nbsp;&nbsp;cm
			<label for="spleenFeature">&nbsp;特征:</label>
		 	${healthRecord.spleenFeature}
		</div>
	</c:if>
	<div class="div-col">
		<label class="control-label" for="murphy">Murphy 征:</label>
		${fns:getDictLabel(healthRecord.murphy,'yin_yang','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="kidney">肾:</label>
		${fns:getDictLabel(healthRecord.kidney,'touch','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="tenderSpotUreter">输尿管压痛点:</label>
		${fns:getDictLabel(healthRecord.tenderSpotUreter,'not_have','')}
	</div>
	<c:if test="${healthRecord.tenderSpotUreter == '2'}">
		<div class="div-col" id="showtenderSpotUreterPosition">
			<label class="control-label" for="tenderSpotUreterPosition">部位:</label>
		 	${healthRecord.tenderSpotUreterPosition}
		</div>
	</c:if>
</div>