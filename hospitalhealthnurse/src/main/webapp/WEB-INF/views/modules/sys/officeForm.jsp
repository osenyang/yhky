<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医院管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
		});
		//通过上级地区获取下级地区
		function showArea(areaId,count){
			if(count == 1){
				$("#city").empty();
				$("#city").html("<option value=''>请选择</option>");
				$("#area").empty();
				$("#area").html("<option value=''>请选择</option>");
			}else{
				$("#area").empty();
				$("#area").html("<option value=''>请选择</option>");
			}
			if(areaId != null && areaId != ""){
				$.get("${ctx}/sys/area/areaList",{parentId:areaId},
					function(json){
						if(count == 1){
							$("#city").empty();
							var options = "<option value=''>请选择</option>";
							$.each(json, function(n, value){
								options += "<option value='"+value.id+"'>"+value.name+"</option>";
							});
							$("#city").html(options);
							$("#city").select2('val','');
						}else {
							$("#area").empty();
							var options = "<option value=''>请选择</option>";
							$.each(json, function(n, value){
								options += "<option value='"+value.id+"'>"+value.name+"</option>";
							});
							$("#area").html(options);
							$("#area").select2('val','');
						}
				});
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
	<form:form id="inputForm" modelAttribute="office" action="${ctx}/sys/office/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="name"><span class="tishi">*</span>医院名称:</label>
			 	<form:input path="name" htmlEscape="false" maxlength="30" class="required"/>
			</div>
			<div class="from-info">	
				<label class="control-label" for="contacts"><span class="tishi">*</span>联系人:</label>
			 	<form:input path="contacts" htmlEscape="false" maxlength="30" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="mobile"><span class="tishi">*</span>联系电话:</label>
			 	<form:input path="mobile" htmlEscape="false" maxlength="18" class="required phone"/>
			</div>
			<div class="from-info">	
				<label class="control-label" for="fax"><span class="tishi">*</span>传真:</label>
			 	<form:input path="fax" htmlEscape="false" maxlength="15" class="required fax"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="province"><span class="tishi">*</span>所在地区:</label>
			<div class="controls">			
			 	<c:choose>
					<c:when test="${office.province != null}">
						<select id="province" name="province" class="input-medium-select required" onchange="showArea(this.value,1)" >
					 		<option value="">请选择</option>
					 		<c:forEach items="${provinceList}" var="temp">
					 			<option value="${temp.id}" <c:if test="${temp.id == office.province}">selected</c:if>>${temp.name}</option>
					 		</c:forEach>
					 	</select>
					</c:when>
					<c:otherwise>
						<form:select path="province" class="input-medium-select required" onchange="showArea(this.value,1)" >
					 		<form:option value="">请选择</form:option>
					 		<form:options items="${provinceList}" itemValue="id" itemLabel="name"/>
					 	</form:select>
					</c:otherwise>
				</c:choose>	
				<c:choose>
					<c:when test="${office.city != null}">
						<select id="city" name="city" class="input-medium-select required" onchange="showArea(this.value,2)" >
					 		<option value="">请选择</option>
					 		<c:forEach items="${cityList}" var="temp">
					 			<option value="${temp.id}" <c:if test="${temp.id == office.city}">selected</c:if>>${temp.name}</option>
					 		</c:forEach>
					 	</select>
					</c:when>
					<c:otherwise>
						<select id="city" name="city" class="input-medium-select required" onchange="showArea(this.value,2)" >
					 		<option value="">请选择</option>
					 	</select>
					</c:otherwise>
				</c:choose>					
			 	<c:choose>
					<c:when test="${office.area != null}">
						<select id="area" name="area" class="input-medium-select required" >
					 		<option value="">请选择</option>
					 		<c:forEach items="${areaList}" var="temp">
					 			<option value="${temp.id}" <c:if test="${temp.id == office.area}">selected</c:if>>${temp.name}</option>
					 		</c:forEach>
					 	</select>
					</c:when>
					<c:otherwise>
						<select id="area" name="area" class="input-medium-select required" >
					 		<option value="">请选择</option>
					 	</select>
					</c:otherwise>
				</c:choose>	
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="address"><span class="tishi">*</span>详细地址:</label>
			<div class="controls">			
			 	<form:input path="address" htmlEscape="false" maxlength="255" class="required" style="width:400px;"/>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
