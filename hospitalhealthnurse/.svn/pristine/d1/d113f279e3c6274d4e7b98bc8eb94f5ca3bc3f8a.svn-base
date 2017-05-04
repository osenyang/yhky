<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>健康管理管理</title>
<meta name="decorator" content="default"/>
<script type="text/javascript">
	$(document).ready(function() {
		$("#name").focus();
		$("#inputForm").validate();
		$("#btnSubmit").hide();
	});
	function reply(){
		$("#btnReply").hide();
		$("#btnSubmit").show();
		$(".replyDiv").show();
	}
</script>
<style type="text/css">
	.tishi{
		color: #FF0000;
		font-weight: bold;
		margin-right: 5px;
	}
	.replyDiv{
		display: none;
	}
</style>
</head>
<body>
	<br/>
	<form:form id="inputForm" modelAttribute="information" action="${ctx}/healtharchives/information/save" method="post" class="form-horizontal">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label><span style="font-size: 18px; font-weight: bold;">${information.title}</span></label>
		</div>
		<div class="control-group">
			<label>会诊老人：${information.fullNm}</label>
		</div>
		<div class="control-group">
			<label>发起人：${information.sendNm}(${information.departmentNm})</label>
		</div>
		<div class="control-group">
			<label>发起时间：<fmt:formatDate value="${information.createDate}" pattern="yyyy-MM-dd HH:mm"/></label>
		</div>
		<div class="control-group">
			<label>接收人：${information.receiveUsers}</label>
		</div>
		<div class="control-group">
			<textarea rows="5" cols="5" readonly="readonly" style="min-width: 400px;">${information.content }</textarea>
		</div>
		
		<div id="replyDiv" class="replyDiv">
			<input id="archivesId" name="archivesId" type="hidden" value="${information.archivesId}">
			<input id="sendJobNumber" name="sendJobNumber" type="hidden" value="${information.receiveJobNumber}">
			<input id="receiveJobNumber" name="receiveJobNumber" type="hidden" value="${information.sendJobNumber}">
			<input id="receiveUsers" name="receiveUsers" type="hidden" value="${information.sendNm}(${information.departmentNm})">
			<div class="control-group">
				<div class="from-info">	
					<label class="control-label" for="title">标题:</label>
				 	<input id="title" name="title" type="text" value="回复：${information.title}">
				</div>
			</div>
			<div class="control-group">
				<div class="control">
					<label class="control-label">内容:</label>
					<textarea id="content" name="content" rows="5" cols="5" style="min-width: 400px;"></textarea>
				</div>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="发送"/>&nbsp;
			<input id="btnReply" class="btn" type="button" value="回复" onclick="reply()">
			<a class="btn" href="${ctx}/healtharchives/information" target="mainFrame">返 回</a>
		</div>
	</form:form>
</body>
</html>
