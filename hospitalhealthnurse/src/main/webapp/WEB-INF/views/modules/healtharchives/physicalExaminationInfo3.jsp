<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="liverDullness"><strong>叩诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;肝浊音:</label>
	 	${fns:getDictLabel(healthRecord.liverDullness,'liver_dullness','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="shiftingDullness">移动性浊音:</label>
		${fns:getDictLabel(healthRecord.shiftingDullness,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="renalRegionBucklePain">肾区扣痛:</label>
		${fns:getDictLabel(healthRecord.renalRegionBucklePain,'not_left_right','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label for="rmcl"><strong>肝上界</strong>位于右锁骨中线</label>
	 	&nbsp;&nbsp;&nbsp;&nbsp;${healthRecord.rmcl}肋间
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bowelSound"><strong>听诊</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;肠鸣音:</label>
	 	${fns:getDictLabel(healthRecord.bowelSound,'reflex','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="gurgling">气过水声:</label>
		${fns:getDictLabel(healthRecord.gurgling,'not_have','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="vascularMurmur">血管杂音:</label>
		${fns:getDictLabel(healthRecord.vascularMurmur,'not_have','')}
	</div>
	<c:if test="${healthRecord.vascularMurmur == '2'}">
		<div class="div-col" id="showvascularMurmurPosition">
			<label class="control-label" for="vascularMurmurPosition">部位:</label>
		 	${healthRecord.vascularMurmurPosition}
		</div>
	</c:if>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="genitals"><strong>生殖器</strong>:</label>
		${fns:getDictLabel(healthRecord.genitals,'inspect','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="anorectum"><strong>肛门直肠</strong>:</label>
		${fns:getDictLabel(healthRecord.anorectum,'inspect','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="spine"><strong>脊柱四脚</strong>&nbsp;&nbsp;&nbsp;&nbsp;脊柱:</label>
		${fns:getDictLabel(healthRecord.spine,'spine','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="spinousProcess">棘突:</label>
		${fns:getDictLabel(healthRecord.spinousProcess,'spinous_process','')}
	</div>
	<c:if test="${healthRecord.spinousProcess == '2'}">
		<div class="div-col" id="showspinousProcessPosition">
			<label class="control-label" for="spinousProcessPosition">部位:</label>
		 		${healthRecord.spinousProcessPosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="limb">四肢:</label>
		${fns:getDictLabel(healthRecord.limb,'limb','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="jointSwelling">关节红肿:</label>
		${fns:getDictLabel(healthRecord.jointSwelling,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="muscleTenderness">肌肉压痛:</label>
		${fns:getDictLabel(healthRecord.muscleTenderness,'not_have','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="acropachia">杵状指:</label>
		${fns:getDictLabel(healthRecord.acropachia,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="arthrocleisis">关节强直:</label>
		${fns:getDictLabel(healthRecord.arthrocleisis,'not_have','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="muscleAtrophy">肌肉萎缩:</label>
		${fns:getDictLabel(healthRecord.muscleAtrophy,'not_have','')}
	</div>
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="varixLowerLimb">下肢静脉曲张:</label>
		${fns:getDictLabel(healthRecord.varixLowerLimb,'not_have','')}
	</div>
	<c:if test="${healthRecord.varixLowerLimb == '2'}">
		<div class="div-col" id="showvarixLowerLimbPosition">
			<label class="control-label" for="varixLowerLimbPosition">部位及特征:</label>
		 	${healthRecord.varixLowerLimbPosition}
		</div>
	</c:if>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="abdominalRadiation"><strong>神经系统</strong>&nbsp;&nbsp;&nbsp;&nbsp;腹壁放射:</label>
	 	${fns:getDictLabel(healthRecord.abdominalRadiation,'abdominal_radiation','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="limbParalysis">肢体瘫痪:</label>
		${fns:getDictLabel(healthRecord.limbParalysis,'paralysis','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="muscleTension">肌张力:</label>
		${fns:getDictLabel(healthRecord.muscleTension,'abdominal_tension','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="muscleTensionLevel">肌力:</label>
		${healthRecord.muscleTensionLevel}级
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="bicepsReflexLeft">肱二头肌反射左:</label>
		${fns:getDictLabel(healthRecord.bicepsReflexLeft,'reflex','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="kneePhenomenonLeft">膝腱反射左:</label>
		${fns:getDictLabel(healthRecord.kneePhenomenonLeft,'reflex','')}
	</div>
		<div class="div-col">
		<label class="control-label" for="achillesTendonReflexLeft">跟腱反射左:</label>
		${fns:getDictLabel(healthRecord.achillesTendonReflexLeft,'reflex','')}
	</div>
	
</div>
<div class="control-group" style="border-bottom: 2px solid #93BAB6">
	<div class="div-col">
		<label class="control-label" for="bicepsReflexRight">肱二头肌反射右:</label>
		${fns:getDictLabel(healthRecord.bicepsReflexRight,'reflex','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="kneePhenomenonRight">膝腱反射右:</label>
		${fns:getDictLabel(healthRecord.kneePhenomenonRight,'reflex','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="achillesTendonReflexRight">跟腱反射右:</label>
		${fns:getDictLabel(healthRecord.achillesTendonReflexRight,'reflex','')}
	</div>
</div>
<div class="control-group">
	<div class="div-col">
		<label class="control-label" for="hoffmann">Hoffmann征:</label>
		${fns:getDictLabel(healthRecord.hoffmann,'left_right','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="babinski">Babinski征:</label>
		${fns:getDictLabel(healthRecord.babinski,'left_right','')}
	</div>
	<div class="div-col">
		<label class="control-label" for="kernig">Kernig征:</label>
		${fns:getDictLabel(healthRecord.kernig,'left_right','')}
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="routineBloodTest"><strong>辅助检查</strong>&nbsp;&nbsp;&nbsp;血常规:</label>
	${healthRecord.routineBloodTest}
</div>
<div class="control-group">
	<label class="control-label" for="electrocardiogram">心电图:</label>
	${healthRecord.electrocardiogram}
</div>
<div class="control-group">
	<label class="control-label" for="xrayChestRadiography">X线胸部摄片:</label>
	${healthRecord.xrayChestRadiography}
</div>
<div class="control-group">
	<label class="control-label" for="bultrasonic">B超:</label>
	${healthRecord.bultrasonic}
</div>
<div class="control-group">
	<label class="control-label" for="liverKidneyFunction">肝、肾功能:</label>
	${healthRecord.liverKidneyFunction}
</div>
<div class="control-group">
	<label class="control-label" for="bloodGlucoseLipid">血糖、血脂:</label>
	${healthRecord.bloodGlucoseLipid}
</div>
<div class="control-group">
	<label class="control-label" for="electrolytic">电解质:</label>
	${healthRecord.electrolytic}
</div>
<div class="control-group">	
	<label class="control-label" for="other">其他:</label>
	${healthRecord.other}
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
	 	${healthRecord.contactAddress}
	</div>
	<div class="div-col">
		<label class="control-label" for="ontactNumber">联系电话:</label>
	 	${healthRecord.ontactNumber}
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









