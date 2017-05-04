<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>社工计划详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
	    
	    function query(){
			$("#pageNo").val(1);
			$("#searchForm").submit();
	    	return false;
	    }
	    function preview(){
        	$(".form-actions").hide();
        	window.print(); 
        	$(".form-actions").show();
		}
	</script>
<style type="text/css">
.tishi{
	color: #FF0000;
	font-weight: bold;
	margin-right: 5px;
}
.photoDiv{
	float: left;
	width: 100px;
	height: 100px;
	margin:0 20px;
}
.inforDiv{
	float: left;
	left: 100px;
	height: 50px;
	width: 90%;
	padding: 0;
	margin: 0;
}
.inforLabel{
	height: 20px;
	line-height: 20px;
	font-size: 20px;
	top: 15px;
	position: relative;
	margin-left: 20px;
	min-width: 100px;
}
.inforLabel span{
	font-weight: bold;
}
.planDiv{
	text-align: center;
}
.planDiv input{
	margin: 0 15px;
}
.docDiv{
	width: 100%;
	float: left;
	margin-top: 20px;
}
.doctorDiv{
	float: left;
	margin: auto 20px;
}
.doctorLabel{
	min-width: 120px;
	text-align: right;
}
.table-label{
	float: right;
}
.table-textarea{
	float: left;
}
.lineDiv{
	border-bottom: 1px solid #93BAB6; 
	width: 100%;
	float: left;
	margin-top: 5px;
	margin-bottom: 20px;
}
.lineDiv input{
	min-width: 100px;
	background: #49AFB3;
	border: 0;
	border-radius: 1px;
	color: #FFFFFF;
	font-size: 14px;
	font-weight: bold;
}
.groupDiv{
	width: 100%;
	float: left;
	margin-top: 5px;
}
.control-div{
	margin-top: 10px;
	float: left;
}
.control-input{
	float: left;
}
.control-span{
	float: left;
	margin: 5px;
}
.interveneTable{
	width: 90%;
	margin: auto 5%; 
}
.nutritionMeals,.nutritionEnergy,.energyTotal,.nutritionDrinkWater,.recoverInput,.socialFamily{
	width: 50px
}
.recoverQuarters{
	width: 100px;
}
.recoverTime{
	width: 130px;
}
.socialLabel{
	min-width: 130px;
}
.addTableDiv{
	width: 80%;
	float: left;
	text-align: right;
	margin: 20px 10% auto;
}
.selected{
	background: #20B496 !important;
	color: #FFFFFF !important;
}
.lbl{
	display:block;
}
.interveneTable tr{
	height:40px;
	border-top: 1px dotted #b7d5df;
	border-bottom: 1px dotted #b7d5df;
}
.interveneTable tr td{
	border-left: 1px dotted #b7d5df;
	border-right: 1px dotted #b7d5df;
}
.interveneTable tr th{
	border-left: 1px dotted #b7d5df;
	border-right: 1px dotted #b7d5df;
	background-color: #b7d5df;
	}
	.form-actions{
	text-align: center;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/plan/planExecuteRecord/planExeRecordInfo?id=${planExecuteRecord.id}">社工计划详情</a></li>
	</ul><br/>
	
	<tags:message content="${message}"/>
	<div class="form-horizontal" id="infoControl">
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">老人头像:</label>
				<tags:printImg defaultUrl="/static/images/archives.png" imgOriUrl="${planExecuteRecord.photo}" imgUrl="${planExecuteRecord.photo}" width="60" height="60" />
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">老人姓名:</label><label class="lbl">${planExecuteRecord.elderName}</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info" style="width:100%;">	
				<label class="control-label">家庭成员情况:</label>
				<label class="lbl">
					<input disabled="disabled" id="familyFather" name="familyFather" value="1" type="checkbox" <c:if test="${not empty social.familyFather}">checked="checked"</c:if>>父亲
					<input disabled="disabled" id="familyMother" name="familyMother" value="1" type="checkbox" <c:if test="${not empty social.familyMother}">checked="checked"</c:if>>母亲
					<input disabled="disabled" id="familySpouse" name="familySpouse" value="1" type="checkbox" <c:if test="${not empty social.familySpouse}">checked="checked"</c:if>>配偶
					<input disabled="disabled" type="checkbox" <c:if test="${not empty social.familySon}">checked="checked"</c:if>>
					<input disabled="disabled" type="text" id="familySon" name="familySon" value="${social.familySon}" class="socialFamily">个儿子
					<input disabled="disabled" type="checkbox" <c:if test="${not empty social.familyDaughter}">checked="checked"</c:if>>
					<input disabled="disabled" type="text" id="familyDaughter" name="familyDaughter" value="${social.familyDaughter}" class="socialFamily">个女儿
					<input disabled="disabled" type="checkbox" <c:if test="${not empty social.familyBrother}">checked="checked"</c:if>>
					<input disabled="disabled" type="text" id="familyBrother" name="familyBrother" value="${social.familyBrother}" class="socialFamily">个姐姐
					<input disabled="disabled" type="checkbox" <c:if test="${not empty social.familySister}">checked="checked"</c:if>>
					<input disabled="disabled" type="text" id="familySister" name="familySister" value="${social.familySister}" class="socialFamily">个哥哥
					<input disabled="disabled" type="checkbox" <c:if test="${not empty social.familyYoungerBrother}">checked="checked"</c:if>>
					<input disabled="disabled" type="text" id="familyYoungerBrother" name="familyYoungerBrother" value="${social.familyYoungerBrother}" class="socialFamily">个妹妹
					<input disabled="disabled" type="checkbox" <c:if test="${not empty social.familyYoungerSister}">checked="checked"</c:if>>
					<input disabled="disabled" type="text" id="familyYoungerSister" name="familyYoungerSister" value="${social.familyYoungerSister}" class="socialFamily">个弟弟
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info" style="width:100%;">	
				<label class="control-label">老人经济情况:</label>
				<label class="lbl">
					<label>工资状况:</label>${fns:getDictLabel(social.wageStatus, 'wage_status', '无')}
					<label style="margin-left: 20px;">存款:</label>
					<c:if test="${social.deposit == '1'}">有</c:if>
					<c:if test="${social.deposit == '0'}">无</c:if>
					<label style="margin-left: 20px;">金额:</label>${social.depositMoney}
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">现在费用承担情况:</label>
				<label class="lbl">
					${social.costBear}
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label">初步护理级别:</label>
				<label class="lbl">
					${social.nuserLevel}
				</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">	
				<label class="control-label">计划有效日期:</label>
				<label class="lbl">
					<fmt:formatDate value="${social.socialStartTime}" pattern="yyyy-MM-dd HH:mm"/>
					~
					<fmt:formatDate value="${social.socialEndTime}" pattern="yyyy-MM-dd HH:mm"/>
				</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="lineDiv"><input type="button" value="兴趣爱好计划"></div>
			<table id="hobbyTable" class="interveneTable" style="text-align: center;">
				<tr>
					<th>兴趣爱好</th>
					<th>兴趣爱好要求</th>
					<th colspan="2">计划时间</th>
					<th>执行人(岗位)</th>
					<th>其它</th>
				</tr>
				<c:forEach items="${social.hobbyList}" var="hobby">
					<tr id="${hobby.id}">
						<td>${hobby.hobby}</td>
						<td>${hobby.hobbyAsk}</td>
						<td colspan="2"><fmt:formatDate value="${hobby.hobbyStartTime}" pattern="yyyy-MM-dd HH:mm"/>~<fmt:formatDate value="${hobby.hobbyEndTime}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td>${hobby.hobbyQuartersNm}</td>
						<td>${hobby.hobbyOther}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="control-group">
			<div class="from-info">	
				<label class="control-label" style="width:100%;">特殊要求:</label>
				<label class="lbl">
					${social.specialAsk}
				</label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview()"/>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</div>
</body>
</html>
