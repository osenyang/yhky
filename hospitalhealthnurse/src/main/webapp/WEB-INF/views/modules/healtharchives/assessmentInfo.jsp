<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<form:form id="assessmentForm" action="${ctx}/healtharchives/intervene/saveAssessment" method="post">
	<input type="hidden" id="id" name="id" value="${assessment.id}">
	<input type="hidden" id="interveneId" name="interveneId" value="${intervene.id}">
	<div class="docDiv">
		<div class="doctorDiv">	
		<label>责任医生</label> 		
		<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="doctorId" name="doctorId"
		value="${assessment.doctorId}" labelName="doctorNm"  labelValue="${assessment.doctorNm}" title="人员" cssClass="required"></tags:treeselect>	
		</div>
		<div class="doctorDiv">
		护士长 
		<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="nurseId" name="nurseId" 
		value="${assessment.nurseId}" labelName="nurseNm"  labelValue="${assessment.nurseNm}" title="人员" cssClass="required"></tags:treeselect>
		</div>
		<div class="doctorDiv">
		 科主任
		 <tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="directorId" name="directorId" 
		value="${assessment.directorId}" labelName="directorNm"  labelValue="${assessment.directorNm}" title="人员" cssClass="required"></tags:treeselect>
		</div>
	</div>
	<div class="docDiv">
		<div class="doctorDiv">	
			计划有效日期：　
			<input id="startTime" name="startTime" type="text" class="Wdate input-medium required" 
				value="<fmt:formatDate value="${assessment.startTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>
			<input id="endTime" name="endTime" type="text" class="Wdate input-medium required" 
				value="<fmt:formatDate value="${assessment.endTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#startTime').val()});"/>
			<%-- <input id="assessmentStartTime" name="assessmentStartTime" type="text" class="Wdate input-medium required" 
					value="<fmt:formatDate value="${assessment.assessmentStartTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>~
			<input id="assessmentEndTime" name="assessmentEndTime" type="text" class="Wdate input-medium required" 
				value="<fmt:formatDate value="${assessment.assessmentEndTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,minDate:$('#assessmentStartTime').val()});"/> --%>
		</div>
	</div>
	<div class="lineDiv"><input type="button" value="医疗"></div>
	<table class="interveneTable">
		<tr>
			<td width="150"><label class="table-label">主要诊断:</label></td>
			<td>
			<%-- <div class="table-textarea" id="diagnosis" name="diagnosis" contenteditable="true" style="width: 500px; min-height: 50px; border: 1px solid #FFFFFF;text-align: left;" onkeyup="test(this,'diagnosis')">${assessment.diagnosis}</div> --%>
			<textarea class="table-textarea" id="diagnosis" name="diagnosis" rows="3" cols="3" style="min-width: 500px;">${assessment.diagnosis}</textarea>
			</td>
		</tr>
		<tr>
			<td><label class="table-label">全身情况:</label></td>
			<td><textarea class="table-textarea" id="generalCondition" name="generalCondition" rows="3" cols="5" style="min-width: 550px;">${assessment.generalCondition}</textarea></td>
		</tr>
		<tr>
			<td><label class="table-label">综合评估:</label></td>
			<td><textarea class="table-textarea" id="colligateAssess" name="colligateAssess" rows="3" cols="5" style="min-width: 550px;">${assessment.colligateAssess}</textarea></td>
		</tr>
		<tr>
			<td><label class="table-label">诊疗计划:</label></td>
			<td><textarea class="table-textarea" id="medicalPlan" name="medicalPlan" rows="3" cols="3" style="min-width: 550px;">${assessment.medicalPlan}</textarea></td>
		</tr>
		<tr>
			<td><label class="table-label">家属需求:</label></td>
			<td><textarea class="table-textarea" id="familyNeeds" name="familyNeeds" rows="3" cols="3" style="min-width: 550px;">${assessment.familyNeeds}</textarea></td>
		</tr>
		<tr>
			<td><label class="table-label">会诊结论:</label></td>
			<td><textarea class="table-textarea" id="consultationDepartment" name="consultationDepartment" rows="3" cols="5" style="min-width: 550px;">${assessment.consultationDepartment}</textarea></td>
		</tr>
		<tr>
			<td><label class="table-label">目前最急迫处理病情:</label></td>
			<td><textarea class="table-textarea" id="illnessTook" name="illnessTook" rows="3" cols="3" style="min-width: 550px;">${assessment.illnessTook}</textarea></td>
		</tr>
	</table>
	<%-- <div class="lineDiv"><input type="button" value="护理"></div>
	<table class="interveneTable">
		<tr>
			<td width="150"><label class="table-label">护理项目:</label></td>
			<td><textarea class="table-textarea" id="nurseItem" name="nurseItem" rows="3" cols="5" style="min-width: 550px;">${assessment.nurseItem}</textarea></td>
		</tr>
	</table>
	<div class="lineDiv"><input type="button" value="营养"></div>
	<table class="interveneTable">
		<tr>
			<td><label class="table-label">计划每日所需液体量:</label></td>
			<td><input class="control-input " id="liquid" name="liquid" type="text" value="${assessment.liquid}"/><span class="control-span">毫升</span></td>
			<td><label class="table-label">计划每日热卡:</label></td>
			<td><input class="control-input " id="calorie" name="calorie" type="text" value="${assessment.calorie}"/></td>
			<td><label class="table-label">途径:</label></td>
			<td><input class="control-input " id="channel" name="channel" type="text" value="${assessment.channel}"/></td>
		</tr>
		<tr>
			<td><label class="table-label">进餐方式:</label></td>
			<td><input class="control-input " id="dining" name="dining" type="text" value="${assessment.dining}"/></td>
			<td><label class="table-label">每日:</label></td>
			<td><input class="control-input " id="frequency" name="frequency" type="text" value="${assessment.frequency}"/><span class="control-span">次</span></td>
			<td><label class="table-label">每次剂量:</label></td>
			<td><input class="control-input " id="dose" name="dose" type="text" value="${assessment.dose}"/><span class="control-span">g</span></td>
		</tr>
		<tr>
			<td><label class="table-label">营养餐性质:</label></td>
			<td><input class="control-input " id="nutritionalMeal" name="nutritionalMeal" type="text" value="${assessment.nutritionalMeal}"/></td>
			<td><label class="table-label">进餐体位:</label></td>
			<td><input class="control-input " id="diningPosition" name="diningPosition" type="text" value="${assessment.diningPosition}"/></td>
			<td><label class="table-label ">餐后体位保持时间:</label></td>
			<td><input class="control-input " id="holdTime" name="holdTime" type="text" value="${assessment.holdTime}"/><span class="control-span">分钟</span></td>
		</tr>
	</table>
	<div class="lineDiv"><input type="button" value="照护"></div>
	<table class="interveneTable">
		<tr>
			<td><label class="table-label">功能缺陷程度:</label></td>
			<td><input class="control-input " id="defectDegree" name="defectDegree" type="text" value="${assessment.defectDegree}"/></td>
			<td><label class="table-label">照护注意事项:</label></td>
			<td><textarea id="needingAttention" name="needingAttention" rows="2" cols="3" style="min-width: 200px;">${assessment.needingAttention}</textarea></td>
		</tr>
	</table> --%>
	<div class="form-actions">
		<c:if test="${intervene.state == 0 || intervene.state == 2 }">
			<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="submitBut('assessmentForm','${ctx}/healtharchives/intervene/saveAssessment')" value="保 存"/>&nbsp;
		</c:if>
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview('1');"/> 
	</div>
</form:form>