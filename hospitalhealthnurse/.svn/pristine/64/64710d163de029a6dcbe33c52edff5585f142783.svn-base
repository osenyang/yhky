<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>健康档案管理</title>
<meta name="decorator" content="default"/>
<script type="text/javascript">
	$(document).ready(function() {
		$("#name").focus();
		$("#inputForm").validate({
			rules : {
				fullNm:{userName:true,rangelength:[2,20]},
				idCard : {card:true},
				calf:{ range:[0,80]},
				height:{ range:[0,300]},
				weight:{ range:[0,200],digits:true},
				hospitalizationNumber: {remote: "${ctx}/healtharchives/healthArchives/checkHospitalizationNumber?oldHospitalizationNumber=" + encodeURIComponent('${healthArchives.hospitalizationNumber}')},
				//bedNumber: {remote: "${ctx}/healtharchives/healthArchives/checkBedNumber?oldBedNumber=" + encodeURIComponent('${healthArchives.bedNumber}')},
				contact:{mobile:true},
			},
			messages: {
				fullNm:{userName:"只能输入中文字、英文字母、数字",rangelength:"输入长度必须介于{0} 到 {1}之间"},
				idCard: {card: "请输入正确身份证号"},
				calf:{ range:"输入数值范围在 {0} 到 {1} 之间"},
				height:{ range:"输入数值范围在 {0} 到 {1} 之间"},
				weight:{ range:"输入数值范围在 {0} 到 {1} 之间",digits:"请输入正整数"},
				hospitalizationNumber:{remote: "当前住院号已存在"},
				//bedNumber:{remote: "当前床号已有人"},
				contact:{mobile:"请输入正确的联系方式"},
			},
		});
		/* $(".weightCss").keyup(function () {
	        //如果输入非数字，则替换为''.
	        this.value = this.value.replace(/[^\d.\d]/g, '');
	    });
	    $(".heightCss").keyup(function () {
	        //如果输入非数字，则替换为''.
	        this.value = this.value.replace(/[^\d]/g, '');
	    });
	    $("#fullNm").keyup(function(){
	   	 	//如果输入非中文，则替换为''.
	        this.value = this.value.replace(/[^\u4E00-\u9FA5]/g, '');
	   	});
	    $("#fullNm").blur(function(){
	   	 	//如果输入非中文，则替换为''.
	        this.value = this.value.replace(/[^\u4E00-\u9FA5|]/g, '');
	   	}); */
	});
	function idOnblur(){
		var birthDate = getBirthdatByIdNo($("#idCard").val());
		$("#birthDate").val(birthDate);
	}
	function test(){
		return false;
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
	<form:form id="inputForm" modelAttribute="healthArchives" action="${ctx}/healtharchives/healthArchives/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="infoTitle">基本信息</div>
		<div class="control-group">		
			<label class="control-label" for="photo">头像：</label>
			<input type="hidden" name="photo" id="photo" value="${healthArchives.photo}"/>	
			<tags:uploadImg imgOri="photo" imgContent="imgContent" uploadPath="healthArchives"  imgThumb="photo"/>
   			<div id="imgContent" style="text-align: center;">
   				<c:if test="${not empty healthArchives.id}">
   					<tags:printImg  defaultUrl="/static/images/archives.png" imgOriUrl="${healthArchives.photo}" imgUrl="${healthArchives.photo}" width="100" height="90" />
    			</c:if>
   			</div>		
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="fullNm"><span class="tishi">*</span>姓名:</label>
			 	<form:input path="fullNm" htmlEscape="false" maxlength="20" class="required"/>
			</div>
			
			<div class="from-info">		
				<label class="control-label" for="calf">小腿围/CM:</label>	
  				<form:input path="calf" htmlEscape="false" maxlength="10" />
				
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="hospitalizationNumber"><span class="tishi">*</span>住院号:</label>
			 	<form:input path="hospitalizationNumber" htmlEscape="false" maxlength="50" class="required"/>
			</div>
			<div class="from-info">	
				<label class="control-label" for="bedNumber"><span class="tishi">*</span>床号:</label>
			 	<form:input path="bedNumber" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">		
				<label class="control-label" for="sex"><span class="tishi">*</span>性别:</label>	
			 	<form:select path="sex" cssClass="required input-medium-select">
					<%-- <form:option value="">请选择</form:option> --%>
					<form:option value="男">男</form:option>
					<form:option value="女">女</form:option>
				</form:select>
			</div>
			
			<div class="from-info">
				<label class="control-label" for="height">身高/CM:</label>
			 	<form:input path="height" htmlEscape="false" maxlength="5"/>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">			
				<label class="control-label" ><span class="tishi">*</span>身份证号：</label>
				<input type="hidden" name="oldIdCard"  value="${healthArchives.idCard}" >
			 	<form:input path="idCard" htmlEscape="false"  onblur="idOnblur();" maxlength="18" class="input-medium required"/>
			</div>
			<div class="from-info">			
				<label class="control-label">出生日期：</label>
				<input id="birthDate" name="birthDate" type="text" readonly="readonly" maxlength="20" class="input-medium required"
					value="<fmt:formatDate value="${healthArchives.birthDate}" pattern="yyyy-MM-dd"/>"  />
			</div>
		</div>
		
		<div class="control-group">
			<div class="from-info">		
				<label class="control-label" for="occupation"><span class="tishi">*</span>职业:</label>	
			 	<form:input path="occupation" htmlEscape="false" maxlength="10" class="required"/>
			</div>
			
			<div class="from-info">
				<label class="control-label" for="weight">体重/KG:</label>
			 	<form:input path="weight" htmlEscape="false" maxlength="10"/>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" for="medicalType"><span class="tishi">*</span>医保类型:</label>		
			 	<%-- <form:input path="medicalType" htmlEscape="false" maxlength="2" class="required"/> --%>
			 	<form:select path="medicalType">
					<form:options items="${fns:getDictList('medical_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
			
			<div class="from-info">
				<label class="control-label" for="degree"><span class="tishi">*</span>文化程度:</label>
			 	<%-- <form:input path="degree" htmlEscape="false" maxlength="2" class="required"/> --%>
			 	<form:select path="degree">
					<form:options items="${fns:getDictList('hn_culture')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		
		<div class="control-group">
			<div class="from-info">
				<label class="control-label" for="state"><span class="tishi">*</span>状态:</label>
				<%-- <form:select path="state">
					<form:options items="${fns:getDictList('archive_state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select> --%>
				<form:select path="state" cssClass="required">
					<form:option value="1">入院</form:option>
					<form:option value="2">请假</form:option>
					<form:option value="4">康养</form:option>
				</form:select>
			</div>
		
			<div class="from-info">		
				<label class="control-label" for="contact"><span class="tishi">*</span>家属联系方式:</label>	
			 	<form:input path="contact" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<div class="from-info">		
				<label class="control-label" for="healthRisk"><span class="tishi">*</span>风险:</label>	
			 	<form:input path="healthRisk" htmlEscape="false" maxlength="11" class="required"/>
			</div>
			
			<div class="from-info">		
				<label class="control-label" for="healthRisk"><span class="tishi">*</span>病区:</label>
				<form:select path="inpatientId" cssClass="required">
					<c:forEach items="${list}" var="healthInpatient">
						<form:option value="${healthInpatient.id}">${healthInpatient.areaNm}</form:option>
					</c:forEach>
				</form:select>	
			</div>
		</div>

		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
