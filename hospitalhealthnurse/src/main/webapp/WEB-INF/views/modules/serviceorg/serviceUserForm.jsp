<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				ignore:"",
				rules : {
					mobile: {remote: "${ctx}/serviceorg/serviceUser/checkMobile?oldMobile=" + encodeURIComponent('${serviceUser.mobile}')},
					jobNumber: {remote: "${ctx}/serviceorg/serviceUser/checkJobNumber?oldJobNumber=" + encodeURIComponent('${serviceUser.jobNumber}')},
				},
				messages: {
					mobile: {remote: "已存在当前联系电话"},
					jobNumber: {remote: "当前工号已存在"},
				}
			});
			
		});
		function deleteUrl(value){
			var imgUrl = $("#imgUrl").val();
			if(imgUrl != ''){
				$("#imgUrl").val('');
				$("#thumbImg").val('');
				$("#imgContent").html("");
				if(value == 1){
					$("#loading").html("");
				}else{
					$("#urlSubmit").hide();
				}
			}
		}
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
	<form:form id="inputForm" modelAttribute="serviceUser" action="${ctx}/serviceorg/serviceUser/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="name"><span class="tishi">*</span>姓 名:</label>
			 	<form:input path="name" htmlEscape="false" maxlength="15" class="required"/>
			</div>
			<div class="from-info">		
				<label class="control-label" for="officeId"><span class="tishi">*</span>所属机构:</label>
				<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
				${fns:getUser().office.name}
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">		
				<label class="control-label" for="sex"><span class="tishi">*</span>性 别:</label>
			 	<form:select path="sex" cssClass="input-medium-select required">
					<form:option value="" label="请选择"/>
					<form:option value="男" label="男"/>
					<form:option value="女" label="女"/>
				</form:select>
			</div>
			<div class="from-info">
				<label class="control-label" for="departmentId"><span class="tishi">*</span>所在科室:</label>
			 	<tags:treeselect id="department" name="departmentId" parentId="officeId" value="${serviceUser.departmentId}" labelName="departmentNm" labelValue="${serviceUser.departmentNm}" 
				title="科室" url="/serviceorg/department/departmentDataByOfficeId" notAllowSelectParent="true" cssClass="required" cssStyle="width:140px;" allowClear="true" changeQuarters="true"/>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="birthDate"><span class="tishi">*</span>出生日期:</label>
				<input id="birthDate" name="birthDate" type="text" value="<fmt:formatDate value="${serviceUser.birthDate}" pattern="yyyy-MM-dd"/>"  readonly="readonly" maxlength="20" class="required input-small Wdate"
				 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,maxDate:'%y-%M-{%d-1}'});"/>
			</div>
			<div class="from-info">	
				<label class="control-label" for="quartersId"><span class="tishi">*</span>岗位:</label>
			 	<tags:treeselect id="quarters" name="quartersId" parentId="departmentId" value="${serviceUser.quartersId}" labelName="quartersNm"  labelValue="${serviceUser.quartersNm}" 
			 	title="岗位" url="/serviceorg/quarters/treeData" cssStyle="width:140px;" cssClass="required" allowClear="true" ></tags:treeselect>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="mobile"><span class="tishi">*</span>联系电话:</label>
			 	<form:input path="mobile" htmlEscape="false" maxlength="18" class="required phone"/>
			</div>
			<div class="from-info">	
				<label class="control-label" for="jobNumber">工号:</label>
				<form:input path="jobNumber" htmlEscape="false" maxlength="18" class="required"/>
			</div>
		</div>
		<div class="control-group">	
			<label class="control-label" for="remarks"><span class="tishi">*</span>简 介：</label>
		 	<form:textarea path="remarks" htmlEscape="false" onpropertychange="if(this.value.length>200) this.value=this.value.substr(0,200);" oninput="if(this.value.length>200) this.value=this.value.substr(0,200);" rows="3" cols="100" class="required input-xxlarge"></form:textarea>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">照 片：</label>
			<input type="hidden" name="imgUrl" id="imgUrl" value="${serviceUser.imgUrl}" />	
			<input type="hidden" name="thumbImg" id="thumbImg" value="${serviceUser.thumbImg}" />
			<tags:uploadImg imgOri="imgUrl" imgContent="imgContent" uploadPath="serviceUser"  imgThumb="thumbImg" isDelete="true"/>
   			<c:if test="${not empty serviceUser.id && not empty serviceUser.imgUrl}">
   				<input id="urlSubmit" class="btn btn-yellow" type="button" onclick="deleteUrl(2);" value="删除" />
   			</c:if>
   			<div id="imgContent" style="text-align: center;">
   				<c:if test="${not empty serviceUser.imgUrl}">
   					<tags:printImg defaultUrl="/static/images/archives.png" imgOriUrl="${serviceUser.imgUrl}" imgUrl="${serviceUser.thumbImg}" width="100" height="90" />
    			</c:if>
   			</div>
		</div>

		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			<a href="${ctx}/serviceorg/serviceUser/"><input id="btnCancel" class="btn" type="button" value="返 回" /></a>
		</div>
	</form:form>
</body>
</html>
