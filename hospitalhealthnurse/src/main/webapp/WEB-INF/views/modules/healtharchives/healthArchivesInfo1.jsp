<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div id="hideAssessDiv" class="control-group">
	<label>时间段 ：</label><input id="startDate" name="startDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate" value="${startDate}"
				 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,maxDate:'#F{$dp.$D(\'endDate\')}'});" />
	- <input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate" value="${endDate}" 
				 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,minDate:'#F{$dp.$D(\'startDate\')}'});" />
	&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查 询"/>
</div>
<div id="hideAssessTable" class="control-group">
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>评估人</th>
			<th>评估类别</th>
			<th>评估项目</th>
			<th>评估分数</th>
			<th>评估结果</th>
			<th>评估时间</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${assessList}" var="assess" varStatus="status">
			<tr>			
				<td>${status.count}</td>
				<td>${assess.doctorNm}</td>
				<td>${assess.typeNm}</td>
				<td>${assess.questNm}</td>
				<td>${assess.score}</td>
				<td>${assess.gradeNm}</td>
				<td>${assess.createDate}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>