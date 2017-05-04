<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">
	<input id="btnSubmit" class="btn btn-primary" type="button" value="新增记录" onclick="addAssess()"/>
</div>
<div id="addAssessTable" class="control-group">
	<table id="assessTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>评估分类</th>
			<th>评估量表</th>
			<th>评估结果</th>
			<th>评估分数</th>
			<th>评估标准</th>
			<th>评估时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${healthAssessList}" var="healthAssess" varStatus="status">
			<tr id="${healthAssess.id}">			
				<td>${healthAssess.typeNm}</td>
				<td>${healthAssess.questNm}</td>
				<td>${healthAssess.gradeNm}</td>
				<td>${healthAssess.score}</td>
				<td>${healthAssess.discribe}</td>
				<td><fmt:formatDate value="${healthAssess.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<a onclick="updateAssess('${healthAssess.id}')">修改</a>　
					<a onclick="deleteAssess('${healthAssess.id}')">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="control-group">
	<input id="btnSubmit" class="btn btn-primary" type="button" value="新增建议"  onclick="addReport()"/>
</div>
<div id="addReportTable" class="control-group">
	<table id="reportTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>建议内容</th>
			<th>建议医生</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${assessReportList}" var="assessReport" varStatus="status">
			<tr id="${assessReport.id}">			
				<td>${assessReport.content}</td>
				<td>${assessReport.doctorNm}</td>
				<td><fmt:formatDate value="${assessReport.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<a onclick="updateReport('${assessReport.id}')">修改</a>　
					<a onclick="deleteReport('${assessReport.id}')">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
