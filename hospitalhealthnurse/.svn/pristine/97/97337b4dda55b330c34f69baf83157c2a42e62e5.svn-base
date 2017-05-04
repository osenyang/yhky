<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<form:form id="recoverForm" action="${ctx}/healtharchives/intervene/saveRecover" method="post">
<input type="hidden" id="id" name="id" value="${nurser.id}">
<input type="hidden" id="interveneId" name="interveneId" value="${intervene.id}">
<div class="docDiv">
	<div class="doctorDiv">	
	<label>康复治疗师</label> 		
	<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="recoverDoctorId" name="doctorId"
	value="${recover.doctorId}" labelName="doctorNm"  labelValue="${recover.doctorNm}" title="人员" cssClass="required"></tags:treeselect>	
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label>康复评定</label>
		<input type="checkbox" value="1" name="recoveryEvaluate"
			<c:if test="${fns:containStr(recover.recoveryEvaluate,'1')}" >checked</c:if>>偏瘫运动功能评定
			<input type="checkbox" value="2" name="recoveryEvaluate"
			<c:if test="${fns:containStr(recover.recoveryEvaluate,'2')}" >checked</c:if>>平衡功能评定
			<input type="checkbox" value="3" name="recoveryEvaluate"
			<c:if test="${fns:containStr(recover.recoveryEvaluate,'3')}" >checked</c:if>>吞咽功能评定
			<input type="checkbox" value="4" name="recoveryEvaluate"
			<c:if test="${fns:containStr(recover.recoveryEvaluate,'4')}" >checked</c:if>>日常生活能力评定
			<input type="checkbox" value="5" name="recoveryEvaluate"
			<c:if test="${fns:containStr(recover.recoveryEvaluate,'5')}" >checked</c:if>>移动能力评定
			<input type="checkbox" value="6" name="recoveryEvaluate"
			<c:if test="${fns:containStr(recover.recoveryEvaluate,'6')}" >checked</c:if>>步行功能评定
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label>病史摘要和存在的主要功能障碍</label>
		<textarea id="dysfunction" name="dysfunction" rows="2" cols="5" style="min-width: 550px;">${recover.dysfunction}</textarea>
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		计划有效日期：　
		<input id="recoverStartTime" name="recoverStartTime" type="text" class="Wdate input-medium required" 
				value="<fmt:formatDate value="${recover.recoverStartTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
		<input id="recoverEndTime" name="recoverEndTime" type="text" class="Wdate input-medium required" 
			value="<fmt:formatDate value="${recover.recoverEndTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#recoverStartTime').val()});"/>
	</div>
</div>
<div class="lineDiv"><input type="button" value="康复计划"></div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label>选择康复计划</label>
		<input type="checkbox" value="1" name="recoveryPlan"
		<c:if test="${fns:containStr(recover.recoveryPlan,'1')}" >checked</c:if>>针灸理疗
		<input type="checkbox" value="2" name="recoveryPlan"
		<c:if test="${fns:containStr(recover.recoveryPlan,'2')}" >checked</c:if>>吞咽训练
		<input type="checkbox" value="3" name="recoveryPlan"
		<c:if test="${fns:containStr(recover.recoveryPlan,'3')}" >checked</c:if>>肢体功能训练
		<input type="checkbox" value="4" name="recoveryPlan"
		<c:if test="${fns:containStr(recover.recoveryPlan,'4')}" >checked</c:if>>日常生活能力训练
		<input type="checkbox" value="5" name="recoveryPlan"
		<c:if test="${fns:containStr(recover.recoveryPlan,'5')}" >checked</c:if>>心理康复
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label>康复场所 </label>
		<input type="checkbox" value="1" name="recoverPlace"
		<c:if test="${fns:containStr(recover.recoverPlace,'1')}" >checked</c:if>>床旁
		<input type="checkbox" value="0" name="recoverPlace"
		<c:if test="${fns:containStr(recover.recoverPlace,'0')}" >checked</c:if>>其他
		<input type="text" value="${recover.recoverPlaceOther}" id="recoverPlaceOther" name="recoverPlaceOther"/>
	</div>
</div>
<table class="interveneTable" style="text-align: center;">
	<tr>
		<th width="15%">康复项目</th>
		<th width="28%">治疗时间</th>
		<th colspan="3" width="30%">治疗频次</th>
		<th width="12%">训练强度</th>
		<th width="15%">执行人(岗位)</th>
	</tr>
	<tr>
		<td style="text-align: left;">
			<input type="checkbox" value="温针" name="acupuncture"
			<c:if test="${fns:containStr(recover.acupuncture,'温针')}" >checked</c:if>>温针
			<input type="checkbox" value="头皮针" name="acupuncture"
			<c:if test="${fns:containStr(recover.acupuncture,'头皮针')}" >checked</c:if>>头皮针
		</td>
		<td>
			<input id="acupunctureStartTime" name="acupunctureStartTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.acupunctureStartTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
			<input id="acupunctureEndTime" name="acupunctureEndTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.acupunctureEndTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#acupunctureStartTime').val()});"/>
		</td>
		<td>
			共计<input id="acupunctureTotal" name="acupunctureTotal" value="${recover.acupunctureTotal }" type="text" class="recoverInput"/>次
		</td>
		<td>
			<input id="acupunctureFrequency" name="acupunctureFrequency" value="${recover.acupunctureFrequency }" type="text" class="recoverInput"/>次/日
		</td>
		<td>
			<input id="acupunctureWhen" name="acupunctureWhen" value="${recover.acupunctureWhen }" type="text" class="recoverInput"/>分钟/次
		</td>
		<td>
			<input id="acupunctureStrength" name="acupunctureStrength" value="${recover.acupunctureStrength }" type="text" class="recoverInput"/>次/组
		</td>
		<td>
			<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="acupunctureQuartersId" name="acupunctureQuartersId"
			value="${recover.acupunctureQuartersId}" labelName="acupunctureQuartersNm"  labelValue="${recover.acupunctureQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters  recoverQuarters"></tags:treeselect>
		</td>
	</tr>
	<tr>
		<td style="text-align: left;">
			<input id="psychologyRecover" name="psychologyRecover" value="心理康复" type="checkbox" <c:if test="${not empty recover.psychologyRecover}">checked="checked"</c:if>>
			心理康复 
		</td>
		<td>
			<input id="psychologyRecoverStartTime" name="psychologyRecoverStartTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.psychologyRecoverStartTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
			<input id="psychologyRecoverEndTime" name="psychologyRecoverEndTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.psychologyRecoverEndTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#psychologyRecoverStartTime').val()});"/>
		</td>
		<td>
			共计<input id="psychologyRecoverTotal" name="psychologyRecoverTotal" value="${recover.psychologyRecoverTotal }" type="text" class="recoverInput"/>次
		</td>
		<td>
			<input id="psychologyRecoverFrequency" name="psychologyRecoverFrequency" value="${recover.psychologyRecoverFrequency }" type="text" class="recoverInput"/>次/日
		</td>
		<td>
			<input id="psychologyRecoverWhen" name="psychologyRecoverWhen" value="${recover.psychologyRecoverWhen }" type="text" class="recoverInput"/>分钟/次
		</td>
		<td>
			<input id="psychologyRecoverStrength" name="psychologyRecoverStrength" value="${recover.psychologyRecoverStrength }" type="text" class="recoverInput"/>次/组
		</td>
		<td>
			<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="psychologyRecoverQuartersId" name="psychologyRecoverQuartersId" 
			value="${recover.psychologyRecoverQuartersId}" labelName="psychologyRecoverQuartersNm"  labelValue="${recover.psychologyRecoverQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters  recoverQuarters"></tags:treeselect>
		</td>
	</tr>
	<tr>
		<td style="text-align: left;">
			<input id="limbsTrain" name="limbsTrain" value="偏瘫肢体综合训练" type="checkbox" <c:if test="${not empty recover.limbsTrain}">checked="checked"</c:if>>
			偏瘫肢体综合训练
		</td>
		<td>
			<input id="limbsTrainStartTime" name="limbsTrainStartTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.limbsTrainStartTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
			<input id="limbsTrainEndTime" name="limbsTrainEndTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.limbsTrainEndTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#limbsTrainStartTime').val()});"/>
		</td>
		<td>
			共计<input id="limbsTrainTotal" name="limbsTrainTotal" value="${recover.limbsTrainTotal }" type="text" class="recoverInput"/>次
		</td>
		<td>
			<input id="limbsTrainFrequency" name="limbsTrainFrequency" value="${recover.limbsTrainFrequency }" type="text" class="recoverInput"/>次/日
		</td>
		<td>
			<input id="limbsTrainWhen" name="limbsTrainWhen" value="${recover.limbsTrainWhen }" type="text" class="recoverInput"/>分钟/次
		</td>
		<td>
			<input id="limbsTrainStrength" name="limbsTrainStrength" value="${recover.limbsTrainStrength }" type="text" class="recoverInput"/>次/组
		</td>
		<td>
			<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="limbsTrainQuartersId" name="limbsTrainQuartersId" 
			value="${recover.limbsTrainQuartersId}" labelName="limbsTrainQuartersNm"  labelValue="${recover.limbsTrainQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters  recoverQuarters"></tags:treeselect>
		</td>
	</tr>
	<tr>
		<td style="text-align: left;">
			<input id="taskTreatment" name="taskTreatment" value="作业治疗" type="checkbox" <c:if test="${not empty recover.taskTreatment}">checked="checked"</c:if>>
			作业治疗
		</td>
		<td>
			<input id="taskTreatmentStartTime" name="taskTreatmentStartTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.taskTreatmentStartTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
			<input id="taskTreatmentEndTime" name="taskTreatmentEndTime" type="text" maxlength="20" class="Wdate recoverTime " 
			value="<fmt:formatDate value="${recover.taskTreatmentEndTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#taskTreatmentEndTime').val()});"/>
		</td>
		<td>
			共计<input id="taskTreatmentTotal" name="taskTreatmentTotal" value="${recover.taskTreatmentTotal }" type="text" class="recoverInput"/>次
		</td>
		<td>
			<input id="taskTreatmentFrequency" name="taskTreatmentFrequency" value="${recover.taskTreatmentFrequency }" type="text" class="recoverInput"/>次/日
		</td>
		<td>
			<input id="taskTreatmentWhen" name="taskTreatmentWhen" value="${recover.taskTreatmentWhen }" type="text" class="recoverInput"/>分钟/次
		</td>
		<td>
			<input id="taskTreatmentStrength" name="taskTreatmentStrength" value="${recover.taskTreatmentStrength }" type="text" class="recoverInput"/>次/组
		</td>
		<td>
			<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="taskTreatmentQuartersId" name="taskTreatmentQuartersId" 
			value="${recover.taskTreatmentQuartersId}" labelName="taskTreatmentQuartersNm"  labelValue="${recover.taskTreatmentQuartersNm}" title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
		</td>
	</tr>
</table>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="doctorLabel">康复近期目标</label>
		<textarea id="recentTarget" name="recentTarget" rows="2" cols="5" style="min-width: 550px;">${recover.recentTarget}</textarea>
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="doctorLabel">康复远期目标</label>
		<textarea id="forwardTarget" name="forwardTarget" rows="2" cols="5" style="min-width: 550px;">${recover.forwardTarget}</textarea>
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="doctorLabel">注意事项</label>
		<textarea id="carefulMatter" name="carefulMatter" rows="2" cols="5" style="min-width: 550px;">${recover.carefulMatter}</textarea>
	</div>
</div>
<div class="form-actions">
<c:if test="${intervene.state == 0 || intervene.state == 2 }">
	<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="submitBut('recoverForm','${ctx}/healtharchives/intervene/saveRecover')" value="保 存"/>&nbsp;
</c:if>
	<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview('1');"/>
</div>
</form:form>