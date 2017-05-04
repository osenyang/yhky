<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="temperature">体温(T):</label>${healthRecord.temperature}
	</div>
	<div class="div-col">
		<label class="control-label" for="pulse">脉搏(P):</label>${healthRecord.pulse}
	</div>
	<div class="div-col">
		<label class="control-label" for="breathingRate">呼吸频率(R):</label>${healthRecord.breathingRate}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bloodPressure">血压(Bp):</label>${healthRecord.bloodPressure}
	</div>
	<div class="div-col">
		<label class="control-label" for="auxe">发育:</label>
		${fns:getDictLabel(healthRecord.auxe,'auxe','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="face">面容:</label>
		${fns:getDictLabel(healthRecord.face,'face','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="position">体位:</label>
		${fns:getDictLabel(healthRecord.position,'position','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="consciousness">神志:</label>
		${fns:getDictLabel(healthRecord.consciousness,'consciousness','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="nutrition">营养:</label>
		${fns:getDictLabel(healthRecord.nutrition,'nutrition','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="expression">表情:</label>
		${fns:getDictLabel(healthRecord.expression,'expression','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="gait">步态:</label>
		${fns:getDictLabel(healthRecord.gait,'not_normal','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="cooperateInspect">配合检查:</label>
		${fns:getDictLabel(healthRecord.cooperateInspect,'not_cooperate','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="pigment"><strong>皮肤黏膜</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色素:</label>
	 	${fns:getDictLabel(healthRecord.pigment,'pigment','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="erythra">皮疹:</label>
		${fns:getDictLabel(healthRecord.erythra,'not_have','')}
	</div>
	<c:if test="${healthRecord.erythra == '2'}">
		<div class="div-col" id="showerythraType" >
			<label class="control-label" for="erythraType">类型及分布:</label>
			${healthRecord.erythraType}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="liverPalms">肝掌:</label>
		${fns:getDictLabel(healthRecord.liverPalms,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="subcutaneousHemorrhage">皮下出血:</label>
		${fns:getDictLabel(healthRecord.subcutaneousHemorrhage,'not_have','')}
	</div>
	<c:if test="${healthRecord.subcutaneousHemorrhage == '2'}">
		<div class="div-col" id="showsubcutaneousHemorrhageType">
			<label class="control-label" for="subcutaneousHemorrhageType">类型及分布:</label>
			${healthRecord.subcutaneousHemorrhageType}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="temperatureHumidity">温度与湿度:</label>
		${fns:getDictLabel(healthRecord.temperatureHumidity,'temperature_humidity','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="hairDistribution">毛发分布:</label>
		${fns:getDictLabel(healthRecord.hairDistribution,'hair_distribution','')}
	</div>
	<c:if test="${healthRecord.hairDistribution == '4'}">
		<div class="div-col" id="showhairDistributionPosition">
			<label class="control-label" for="hairDistributionPosition">部位:</label>
		 	${healthRecord.hairDistributionPosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="elastic">弹性:</label>
		${fns:getDictLabel(healthRecord.elastic,'elastic','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="edema">水肿:</label>
		${fns:getDictLabel(healthRecord.edema,'not_have','')}
	</div>
	<c:if test="${healthRecord.edema == '2'}">
		<div class="div-col" id="showedemaPosition">
			<label class="control-label" for="edemaPosition">部位及程度:</label>
		 	${healthRecord.edemaPosition}
		</div>
	</c:if>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="spider">蜘蛛痣:</label>
		${fns:getDictLabel(healthRecord.spider,'not_have','')}
	</div>
	<c:if test="${healthRecord.spider == '2'}">
		<div class="div-col" id="showspiderPosition">
			<label class="control-label" for="spiderPosition">数目及部位:</label>
		 	${healthRecord.spiderPosition}
		</div>
	</c:if>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="superficialLymphNodes"><strong>淋巴结</strong>&nbsp;<font size="1px">全身浅表淋巴结:</font></label>
	 	${fns:getDictLabel(healthRecord.superficialLymphNodes,'superficial_lymph_nodes','')}
	</div>
	<c:if test="${healthRecord.superficialLymphNodes == '2'}">
		<div class="div-col" id="showsuperficialLymphNodesPosition">
			<label class="control-label" for="superficialLymphNodesPosition">部位及特征:</label>
		 	${healthRecord.superficialLymphNodesPosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="head"><strong>头部</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;头颅:</label>
	 	${fns:getDictLabel(healthRecord.head,'head','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="malformation">畸形:</label>
		${fns:getDictLabel(healthRecord.malformation,'malformation','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="headTenderness">压痛:</label>
		${fns:getDictLabel(healthRecord.headTenderness,'not_have','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="headEnclosedMass">包块:</label>
		${fns:getDictLabel(healthRecord.headEnclosedMass,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="concaveLimit">凹限:</label>
		${fns:getDictLabel(healthRecord.concaveLimit,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="eyelid"><strong>眼</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;眼脸:</label>
	 	${fns:getDictLabel(healthRecord.eyelid,'eye','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="conjunctiva">结膜:</label>
		${fns:getDictLabel(healthRecord.conjunctiva,'conjunctiva','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="eyeball">眼球:</label>
		${fns:getDictLabel(healthRecord.eyeball,'eyeball','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="albugineaOculi">巩膜:</label>
		${fns:getDictLabel(healthRecord.albugineaOculi,'albuginea_oculi','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="cerato">角膜:</label>
		${fns:getDictLabel(healthRecord.cerato,'cerato','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="pupil">瞳孔:</label>
		${fns:getDictLabel(healthRecord.pupil,'pupil','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="lightReaction">对光反射:</label>
		${fns:getDictLabel(healthRecord.lightReaction,'lightReaction','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="auricle"><strong>耳</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;耳廓:</label>
	 	${fns:getDictLabel(healthRecord.auricle,'auricle','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="sternocleidomastoidPain">乳突压痛:</label>
		${fns:getDictLabel(healthRecord.sternocleidomastoidPain,'not_left_right','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="coarseHearingImpairment">粗听力障碍:</label>
		${fns:getDictLabel(healthRecord.coarseHearingImpairment,'not_left_right','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="externalSecretion">外耳道分泌物:</label>
		${fns:getDictLabel(healthRecord.externalSecretion,'not_left_right','')}
	</div>
	<c:if test="${healthRecord.externalSecretion == '2' || healthRecord.externalSecretion == '3'}">
		<div class="div-col" id="showexternalSecretionNature">
			<label class="control-label" for="externalSecretionNature">性质:</label>
		 	${healthRecord.externalSecretionNature}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="noseContour"><strong>鼻</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;外形:</label>
	 	${fns:getDictLabel(healthRecord.noseContour,'abnormal','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="otherAnomalies">其他异常:</label>
		${fns:getDictLabel(healthRecord.otherAnomalies,'other_anomalies','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="nasalSinusTenderness">鼻旁窦压痛:</label>
		${fns:getDictLabel(healthRecord.nasalSinusTenderness,'not_have','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="lip"><strong>口唇</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;嘴唇:</label>
	 	${fns:getDictLabel(healthRecord.lip,'lip','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="mucousCoat">粘膜:</label>
		${fns:getDictLabel(healthRecord.mucousCoat,'mucous_coat','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="parotidDuctOpening">腮腺导管开口:</label>
		${fns:getDictLabel(healthRecord.parotidDuctOpening,'parotid_duct_opening','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="tongue"><strong>舌:</strong></label>
		${fns:getDictLabel(healthRecord.tongue,'tongue','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="gingiva"><strong>齿龈:</strong></label>
		${fns:getDictLabel(healthRecord.gingiva,'gingiva','')}
	</div>
	<div class="div-col" style="float:left;">
		<label class="control-label" for="dentition"><strong>齿列:</strong></label>
		${fns:getDictLabel(healthRecord.dentition,'dentition','')}
	 	<c:if test="${healthRecord.dentition == '2' || healthRecord.dentition == '3' || healthRecord.dentition == '4'}">
	 		(${healthRecord.agomphosisNumber})
	 	</c:if>
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="tonsilla"><strong>扁桃体:</strong></label>
		${fns:getDictLabel(healthRecord.tonsilla,'superficial_lymph_nodes','')},${fns:getDictLabel(healthRecord.tonsillaFester,'fester','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="pharynx"><strong>咽:</strong></label>
	 	${fns:getDictLabel(healthRecord.pharynx,'pharynx','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="voice"><strong>声音:</strong></label>
		${fns:getDictLabel(healthRecord.voice,'voice','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="senseResistance"><strong>颈部</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抵抗感:</label>
		 ${fns:getDictLabel(healthRecord.senseResistance,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="stiffnessArteryFluctuation">颈动脉波动:</label>
		 ${fns:getDictLabel(healthRecord.stiffnessArteryFluctuation,'carotid_artery_fluctuation','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="jugularVein">颈静脉:</label>
		${fns:getDictLabel(healthRecord.jugularVein,'jugular_vein','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="trachea">气管:</label>
		${fns:getDictLabel(healthRecord.trachea,'trachea','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="hepatojugularReflux">肝颈静脉回流征:</label>
		${fns:getDictLabel(healthRecord.hepatojugularReflux,'yin_yang','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col" style="float: left;">
		<label class="control-label" for="thyroid">甲状腺:</label>
		${fns:getDictLabel(healthRecord.thyroid,'thyroid','')}
	 	<c:if test="${healthRecord.thyroid == '2'}">
	 		${healthRecord.thyroidTumefaction}度
	 	</c:if>
	</div>
	<div class="div-col">
		<label class="control-label" for="leftRightSidesMainly">左右侧为主:</label>
		${fns:getDictLabel(healthRecord.leftRightSidesMainly,'left_right_sides_mainly','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="thorax"><strong>胸部</strong>&nbsp;&nbsp;<strong>视诊</strong>&nbsp;&nbsp;&nbsp;胸廓:</label>
	 	${fns:getDictLabel(healthRecord.thorax,'thorax','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="breast">乳房:</label>
		${fns:getDictLabel(healthRecord.breast,'breast','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="breastEnclosedMass">包块:</label>
		${fns:getDictLabel(healthRecord.breastEnclosedMass,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="breastTenderness">压痛:</label>
		${fns:getDictLabel(healthRecord.breastTenderness,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="excreta">分泌物:</label>
		${fns:getDictLabel(healthRecord.excreta,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="respiratoryMovement">呼吸运动:</label>
		${fns:getDictLabel(healthRecord.respiratoryMovement,'respiratory_movement','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="vocalFremitus">语颤:</label>
		${fns:getDictLabel(healthRecord.vocalFremitus,'respiratory_movement','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="ribSpace">肋间隙:</label>
		${fns:getDictLabel(healthRecord.ribSpace,'rib_space','')}
	</div>
	<c:if test="${healthRecord.ribSpace == '3'}">
		<div class="div-col" id="showribSpacePosition">
			<label class="control-label" for="ribSpacePosition">部位:</label>
			${healthRecord.ribSpacePosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="pleuralFriction">胸膜摩擦感:</label>
		${fns:getDictLabel(healthRecord.pleuralFriction,'not_have','')}
	</div>
	<c:if test="${healthRecord.pleuralFriction == '2'}">
		<div class="div-col" id="showpleuralFrictionPosition">
			<label class="control-label" for="pleuralFrictionPosition">部位:</label>
		 	${healthRecord.pleuralFrictionPosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="subcutaneousCrepitus">皮下捻发感:</label>
		${fns:getDictLabel(healthRecord.subcutaneousCrepitus,'not_have','')}
	</div>
	<c:if test="${healthRecord.subcutaneousCrepitus == '2'}">
		<div class="div-col" id="showsubcutaneousCrepitusPosition">
			<label class="control-label" for="subcutaneousCrepitusPosition">部位:</label>
			${healthRecord.subcutaneousCrepitusPosition}
		</div>
	</c:if>
</div>
