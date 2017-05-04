<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>岗位管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				rules : {
					name: {
						remote:{
							url:'${ctx}/serviceorg/quarters/checkName',
							data:{
								 oldName:'${quarters.name}',
								 oldDepartmentId:'${quarters.departmentId}',
								 name:function(){ return $("#name").val();  },
								 departmentId:function(){return $("#departmentId").val();},
								}
						}
					}
				},
				messages: {
					name: {remote: "所属科室已存在当前岗位名称"}
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
	<form:form id="inputForm" modelAttribute="quarters" action="${ctx}/serviceorg/quarters/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label" for="officeId"><span class="tishi">*</span>所属机构:</label>
			<div class="controls">			
				<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
				${fns:getUser().office.name}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name"><span class="tishi">*</span>所属科室:</label>
			<div class="controls">			
			 	<tags:treeselect id="department" name="departmentId" parentId="officeId" value="${quarters.departmentId}" labelName="departmentNm" labelValue="${quarters.departmentNm}"
				title="科室" url="/serviceorg/department/departmentDataByOfficeId" notAllowSelectParent="true" cssClass="required" cssStyle="width:140px;" allowClear="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name"><span class="tishi">*</span>岗位名称:</label>
			<div class="controls">			
			 	<form:input path="name" htmlEscape="false" maxlength="10" class="required" />
			</div>
		</div>

		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
