<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>紧急计划详情</title>
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
		<div class="control-group" >
			<div class="lineDiv"><input type="button" value="应急计划"></div>
			<table id="meetTable" class="interveneTable">
				<tr>
					<th width="15%">项目名称</th>
					<th width="45%">治疗频次</th>
					<th width="25%">执行时间</th>
					<th width="15%">执行人(岗位)</th>
				</tr>
				<c:forEach items="${meetList}" var="meet">
					<tr id="${meet.id}">
						<td>${meet.entryName}</td>
						<td>共${meet.frequencyTotal}次,${meet.frequency}次/日,${meet.frequencyTime}分钟/次</td>
						<td><fmt:formatDate value="${meet.startTime}" pattern="yyyy-MM-dd HH:mm"/>~<fmt:formatDate value="${meet.endTime}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td>${meet.quartersNm}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="form-actions">
				<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview()"/>
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</div>
	</div>
</body>
</html>
