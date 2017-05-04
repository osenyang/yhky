<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<form:form id="socialForm" modelAttribute="social" action="${ctx}/healtharchives/intervene/saveSocial" method="post">
<input type="hidden" id="id" name="id" value="${social.id}">
<input type="hidden" id="interveneId" name="interveneId" value="${intervene.id}">
<div class="docDiv">
	<div class="doctorDiv">	
		<label>家庭成员情况</label> 		
		<input id="familyFather" name="familyFather" value="1" type="checkbox" <c:if test="${not empty social.familyFather}">checked="checked"</c:if>>父亲
		<input id="familyMother" name="familyMother" value="1" type="checkbox" <c:if test="${not empty social.familyMother}">checked="checked"</c:if>>母亲
		<input id="familySpouse" name="familySpouse" value="1" type="checkbox" <c:if test="${not empty social.familySpouse}">checked="checked"</c:if>>配偶
		<input type="checkbox" <c:if test="${not empty social.familySon}">checked="checked"</c:if>>
		<input type="text" id="familySon" name="familySon" value="${social.familySon}" class="socialFamily">个儿子
		<input type="checkbox" <c:if test="${not empty social.familyDaughter}">checked="checked"</c:if>>
		<input type="text" id="familyDaughter" name="familyDaughter" value="${social.familyDaughter}" class="socialFamily">个女儿
		<input type="checkbox" <c:if test="${not empty social.familyBrother}">checked="checked"</c:if>>
		<input type="text" id="familyBrother" name="familyBrother" value="${social.familyBrother}" class="socialFamily">个姐姐
		<input type="checkbox" <c:if test="${not empty social.familySister}">checked="checked"</c:if>>
		<input type="text" id="familySister" name="familySister" value="${social.familySister}" class="socialFamily">个哥哥
		<input type="checkbox" <c:if test="${not empty social.familyYoungerBrother}">checked="checked"</c:if>>
		<input type="text" id="familyYoungerBrother" name="familyYoungerBrother" value="${social.familyYoungerBrother}" class="socialFamily">个妹妹
		<input type="checkbox" <c:if test="${not empty social.familyYoungerSister}">checked="checked"</c:if>>
		<input type="text" id="familyYoungerSister" name="familyYoungerSister" value="${social.familyYoungerSister}" class="socialFamily">个弟弟
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="socialLabel">老人经济情况</label> 		
		<label>工资状况</label>
		<form:select path="wageStatus">
			<form:options items="${fns:getDictList('wage_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
		</form:select>
		<label>存款</label>
		<select id="deposit" name="deposit">
			<option value="1" <c:if test="${social.deposit == '1'}">selected="selected"</c:if>>有</option>
			<option value="0" <c:if test="${social.deposit == '0'}">selected="selected"</c:if>>无</option>
		</select>
		<label>金额</label>
		<input id="depositMoney" name="depositMoney" type="text" value="${social.depositMoney}" class="socialFamily"/>
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="socialLabel">现在费用承担情况</label> 		
		<textarea rows="2" cols="5" id="costBear" name="costBear" style="min-width: 500px;">${social.costBear}</textarea>
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="socialLabel">初步护理级别</label> 	
		<input class="required" type="text" id="nuserLevel" name="nuserLevel" value="${social.nuserLevel}">	
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		计划有效日期：　
		<input id="socialStartTime" name="socialStartTime" type="text" class="Wdate input-medium required" 
				value="<fmt:formatDate value="${social.socialStartTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
		<input id="socialEndTime" name="socialEndTime" type="text" class="Wdate input-medium required" 
			value="<fmt:formatDate value="${social.socialEndTime}" pattern="yyyy-MM-dd HH:mm"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#socialStartTime').val()});"/>
	</div>
</div>
<div class="lineDiv"><input type="button" value="兴趣爱好计划"></div>
<table id="hobbyTable" class="interveneTable" style="text-align: center;">
	<tr>
		<th>兴趣爱好</th>
		<th>计划内容</th>
		<th>计划时间</th>
		<th>补充</th>
		<th>执行人(岗位)</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${hobbyList}" var="hobby">
		<tr id="${hobby.id}">
			<td>${hobby.hobby}</td>
			<td>${hobby.hobbyAsk}</td>
			<td><fmt:formatDate value="${hobby.hobbyStartTime}" pattern="yyyy-MM-dd HH:mm"/>~<fmt:formatDate value="${hobby.hobbyEndTime}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td>${hobby.hobbyOther}</td>
			<td>${hobby.hobbyQuartersNm}</td>
			<td>
			<c:if test="${intervene.state == 0 || intervene.state == 2 }">
				<a onclick="updateHobby('${hobby.id}')">修改</a>　
				<a onclick="deleteHobby('${hobby.id}')">删除</a>
			</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${intervene.state == 0 || intervene.state == 2 }">
<div class="addTableDiv">
	<input type="button" value="添加" onclick="addHobby()">
</div>
</c:if>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="socialLabel">特殊要求</label> 	
		<%-- <input type="text" id="specialAsk" name="specialAsk" value="${social.specialAsk}"> --%>
		<textarea id="specialAsk" name="specialAsk" rows="2" cols="5" style="min-width: 500px;">${social.specialAsk}</textarea>	
	</div>
</div>
<div class="form-actions">
<c:if test="${intervene.state == 0 || intervene.state == 2 }">
	<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="submitBut('socialForm','${ctx}/healtharchives/intervene/saveSocial')" value="保 存"/>&nbsp;
</c:if>
	<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview('1');"/>
</div>
</form:form>