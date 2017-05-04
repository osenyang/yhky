<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>个人信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate({
				rules : {
					mobile: {mobile:true},
					name: true,
				},
				messages: {
					mobile: {mobile: "请输入正确手机号"},
				},
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/info" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<div class="from-info">
				<label class="control-label">姓 名：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="required" />
			</div>
			<div class="from-info">
				<label class="control-label">手 机：</label>
				<form:input path="mobile" htmlEscape="false" maxlength="11"/>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">
				<label class="control-label">用户角色：</label>
				<label class="lbl">${user.roleNames}</label>
			</div>
			<div class="from-info">
				<label class="control-label">用户类型：</label>
				<label class="lbl">${fns:getDictLabel(user.userType,'sys_user_type','')}</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">
				<label class="control-label">最后登陆：</label>
				<label class="lbl">IP: ${user.loginIp}</label>
			</div>
			<div class="from-info">
				<label class="control-label">登陆时间：</label>
				<label class="lbl"><fmt:formatDate value="${user.loginDate}" type="both" dateStyle="full"/></label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value=" 保 存 "/>
		</div>
	</form:form>
</body>
</html>