<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>修改密码</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			var result = $("#result").val();
			if(result != null && result !="" && result == 'true'){
				setTimeout(function(){
					parent.location.href  = '${ctx}/logout';
				},1000);
			}
			$("#oldPassword").focus();
			$("#inputForm").validate({
				messages: {
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
				}
			});
		});
	</script>
	<style type="text/css">
		.tishi{
			color: #FF0000;
			font-weight: bold;
			margin-right: 5px;
		}
	</style>
</head>
<body>
	<br/>	
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/modifyPwd" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<input id="result" name="result" type="hidden" value="${result}"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="oldPassword"><span class="tishi">*</span>旧密码：</label>
			<div class="controls">
				<input id="oldPassword" name="oldPassword" type="password" value="" maxlength="50" minlength="3" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="newPassword"><span class="tishi">*</span>新密码：</label>
			<div class="controls">
				<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="3" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="confirmNewPassword"><span class="tishi">*</span>确认新密码：</label>
			<div class="controls">
				<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" class="required" equalTo="#newPassword"/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>
		</div>
	</form:form>
</body>
</html>