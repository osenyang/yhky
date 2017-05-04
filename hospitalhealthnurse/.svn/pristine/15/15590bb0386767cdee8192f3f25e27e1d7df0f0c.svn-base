<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginName").focus();
			$("#inputForm").validate({
				rules: {
					loginName: {remote: "${ctx}/sys/user/checkLoginName?oldLoginName=" + encodeURIComponent('${user.loginName}')},
					jobNumber: {remote: "${ctx}/serviceorg/serviceUser/checkJobNumber?oldJobNumber=" + encodeURIComponent('${user.jobNumber}')}
				},
				messages: {
					loginName: {remote: "用户登录名已存在"},
					jobNumber: {remote: "不存在或已存在此服务人员工号"},
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
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="office.id"><span class="tishi">*</span>所属机构：</label>
			<div class="controls">
				<input type="hidden" id="officeId" name="office.id" value="${fns:getUser().office.id}"/>
				${fns:getUser().office.name}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="oldLoginName"><span class="tishi">*</span>登录名：</label>
			<div class="controls">
				<input id="oldLoginName" name="oldLoginName" type="hidden" value="${user.loginName}">
				<form:input path="loginName" htmlEscape="false" maxlength="50" class="required userName"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name"><span class="tishi">*</span>姓名：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="newPassword"><span class="tishi">*</span>密码：</label>
			<div class="controls">
				<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="6" class="${empty user.id?'required':''}"/>
				<c:if test="${not empty user.id}"><span class="help-inline">若不修改密码，请留空。</span></c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="confirmNewPassword"><span class="tishi">*</span>确认密码：</label>
			<div class="controls">
				<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" equalTo="#newPassword"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="mobile">手机号码：</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="100"  class="mobile"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="jobNumber">服务人员工号：</label>
			<div class="controls">
				<form:input path="jobNumber" htmlEscape="false" maxlength="5" />
				<span class="help-inline">若不是服务人员，请留空。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="jurisdiction">方案权限：</label>
			<div class="controls">
				<c:forEach items="${fns:getDictList('jurisdiction')}" var="temp" varStatus="v">
					<input id="jurisdiction${v.count}" name="jurisdiction" <c:if test="${fns:containStr(user.jurisdiction,temp.value)}">checked</c:if> type="checkbox"  value="${temp.value}" />
					<label for="jurisdiction${v.count}">${temp.label}</label> 
				</c:forEach>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="roleIdList"><span class="tishi">*</span>用户角色：</label>
			<div class="controls">
				<form:checkboxes path="roleIdList" items="${allRoles}" itemLabel="name" itemValue="id" htmlEscape="false" class="required"/>
			</div>
		</div>
		<c:if test="${not empty user.id}">
			<div class="control-group">
				<label class="control-label">创建时间：</label>
				<div class="controls">
					<label class="lbl"><fmt:formatDate value="${user.createDate}" type="both" dateStyle="full"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">最后登陆：</label>
				<div class="controls">
					<label class="lbl">IP: ${user.loginIp}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.loginDate}" type="both" dateStyle="full"/></label>
				</div>
			</div>
		</c:if>
		<div class="form-actions">
			<shiro:hasPermission name="sys:user:edit">
				<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>