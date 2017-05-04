<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>科室管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				rules : {
					name: {
						remote:{
							url:'${ctx}/serviceorg/department/checkName',
							data:{
								 oldName:'${department.name}',
								 oldParentId:'${department.parent.id}',
								 name:function(){ return $("#name").val();  },
								 parentId:function(){return $("#departmentId").val();},
								}
						}
					}
				},
				messages: {
					name: {remote: "已存在当前科室名称"}
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
	<form:form id="inputForm" modelAttribute="department" action="${ctx}/serviceorg/department/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label" for="officeId"><span class="tishi">*</span>所属医院：</label>
			<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
			${fns:getUser().office.name}
		</div>
		<div class="control-group">
			<label class="control-label" for="name">上级科室：</label>
		 	<div class="controls">		
		 		<c:choose>
		 			<c:when test="${not empty department.id}">
		 				<input type="hidden" id="departmentId" name="parent.id" value="${department.parent.id}"/>
		 				<c:if test="${department.parent.id != '1'}">${department.parent.name}</c:if>
		 			</c:when>
		 			<c:otherwise>
		 				<tags:treeselect id="department" name="parent.id" parentId="officeId" value="${department.parent.id}" labelName="parent.name" labelValue="${department.parent.name}" 
							title="科室" url="/serviceorg/department/departmentDataByOfficeId" cssClass="input-small" allowClear="true" />
		 			</c:otherwise>
		 		</c:choose>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="name"><span class="tishi">*</span>科室名称：</label>
			<div class="controls">			
			 	<form:input path="name" htmlEscape="false" maxlength="15" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="remarks">备注：</label>
			<div class="controls">			
			 	<form:textarea path="remarks" onpropertychange="if(value.length>200) value=value.substr(0,200)" oninput="if(this.value.length>200) this.value=this.value.substr(0,200);" rows="3" cols="100" class="input-xlarge"/>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
