<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>康复计划详情</title>
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
		<div class="control-group" >
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
			<div class="from-info">	
				<label class="control-label">康复治疗师:</label><label class="lbl">${recover.doctorNm}</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info" style="width:100%;">
				<label class="control-label">康复评定:</label>
				<label class="lbl">
					<c:if test="${fns:containStr(recover.recoveryEvaluate,'1')}" >偏瘫运动功能评定,</c:if>
					<c:if test="${fns:containStr(recover.recoveryEvaluate,'2')}" >平衡功能评定,</c:if>
					<c:if test="${fns:containStr(recover.recoveryEvaluate,'3')}" >吞咽功能评定,</c:if>
					<c:if test="${fns:containStr(recover.recoveryEvaluate,'4')}" >日常生活能力评定,</c:if>
					<c:if test="${fns:containStr(recover.recoveryEvaluate,'5')}" >移动能力评定,</c:if>
					<c:if test="${fns:containStr(recover.recoveryEvaluate,'6')}" >步行功能评定</c:if>
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info" style="width:100%;">
				<label class="control-label">病史摘要和存在的主要功能障碍:</label>
				<label class="lbl">${recover.dysfunction}</label>
			</div>
		</div>
		<div class="control-group" >
			<div class="from-info" style="width:100%;">	
				<label class="control-label">计划有效日期:</label>
				<label class="lbl">
					<fmt:formatDate value="${recover.recoverStartTime}" pattern="yyyy-MM-dd HH:mm"/>
					~
					<fmt:formatDate value="${recover.recoverEndTime}" pattern="yyyy-MM-dd HH:mm"/>
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="lineDiv"><input type="button" value="康复计划"></div>
			<div class="from-info" style="width:100%;">
				<label class="control-label">康复计划:</label>
				<label class="lbl">
					<c:if test="${fns:containStr(recover.recoveryPlan,'1')}" >针灸理疗,</c:if>
					<c:if test="${fns:containStr(recover.recoveryPlan,'2')}" >吞咽训练,</c:if>
					<c:if test="${fns:containStr(recover.recoveryPlan,'3')}" >肢体功能训练,</c:if>
					<c:if test="${fns:containStr(recover.recoveryPlan,'4')}" >日常生活能力训练,</c:if>
					<c:if test="${fns:containStr(recover.recoveryPlan,'5')}" >心理康复</c:if>
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info" style="width:100%;">
				<label class="control-label">康复场所:</label>
				<label class="lbl">
					<c:if test="${fns:containStr(recover.recoverPlace,'1')}" >床上</c:if>
					<c:if test="${fns:containStr(recover.recoverPlace,'0')}" >${recover.recoverPlaceOther}</c:if>
				</label>
			</div>
		</div>
		<div class="control-group">
			<table class="interveneTable">
				<tr>
					<th width="15%">康复项目</th>
					<th width="28%">开始治疗时间</th>
					<th colspan="3" width="30%">治疗频次</th>
					<th width="12%">训练强度</th>
					<th width="15%">执行人(岗位)</th>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" id="psychologyRecover" name="psychologyRecover" value="1" type="checkbox" <c:if test="${fns:containStr(recover.acupuncture,'温针')}" >checked="checked"</c:if>>温针
						<input disabled="disabled" id="psychologyRecover" name="psychologyRecover" value="1" type="checkbox" <c:if test="${fns:containStr(recover.acupuncture,'头皮针')}" >checked="checked"</c:if>>头皮针
					</td>
					<td><fmt:formatDate value="${recover.acupunctureStartTime}" pattern="yyyy-MM-dd HH:mm"/>~
						<fmt:formatDate value="${recover.acupunctureEndTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td>
						共计 ${recover.acupunctureTotal } 次
					</td>
					<td>
						${recover.acupunctureFrequency } 次/日
					</td>
					<td>
						${recover.acupunctureWhen } 分钟/次
					</td>
					<td>
						${recover.acupunctureStrength } 次/组
					</td>
					<td>
						${recover.acupunctureQuartersNm}
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" id="psychologyRecover" name="psychologyRecover" value="1" type="checkbox" <c:if test="${not empty recover.psychologyRecover}">checked="checked"</c:if>>
						心理康复 
					</td>
					<td><fmt:formatDate value="${recover.psychologyRecoverStartTime}" pattern="yyyy-MM-dd HH:mm"/>~
						<fmt:formatDate value="${recover.psychologyRecoverEndTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td>
						共计 ${recover.psychologyRecoverTotal } 次
					</td>
					<td>
						${recover.psychologyRecoverFrequency } 次/日
					</td>
					<td>
						${recover.psychologyRecoverWhen } 分钟/次
					</td>
					<td>
						${recover.psychologyRecoverStrength } 次/组
					</td>
					<td>
						${recover.psychologyRecoverQuartersNm}
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" id="limbsTrain" name="limbsTrain" value="1" type="checkbox" <c:if test="${not empty recover.limbsTrain}">checked="checked"</c:if>>
						偏瘫肢体综合训练
					</td>
					<td>
						<fmt:formatDate value="${recover.limbsTrainStartTime}" pattern="yyyy-MM-dd HH:mm"/>~
						<fmt:formatDate value="${recover.limbsTrainEndTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td>
						共计 ${recover.limbsTrainTotal } 次
					</td>
					<td>
						${recover.limbsTrainFrequency } 次/日
					</td>
					<td>
						${recover.limbsTrainWhen } 分钟/次
					</td>
					<td>
						${recover.limbsTrainStrength } 次/组
					</td>
					<td>
						${recover.limbsTrainQuartersNm}
					</td>
				</tr>
				<tr>
					<td>
						<input disabled="disabled" id="taskTreatment" name="taskTreatment" value="1" type="checkbox" <c:if test="${not empty recover.taskTreatment}">checked="checked"</c:if>>
						作业治疗
					</td>
					<td>
						<fmt:formatDate value="${recover.taskTreatmentStartTime}" pattern="yyyy-MM-dd HH:mm"/>~
						<fmt:formatDate value="${recover.taskTreatmentEndTime}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td>
						共计 ${recover.taskTreatmentTotal } 次
					</td>
					<td>
						${recover.taskTreatmentFrequency } 次/日
					</td>
					<td>
						${recover.taskTreatmentWhen } 分钟/次
					</td>
					<td>
						${recover.taskTreatmentStrength } 次/组
					</td>
					<td>
						${recover.taskTreatmentQuartersNm}
					</td>
				</tr>
			</table>
			</div>
			<div class="control-group">
				<div class="from-info" style="width:100%;">
					<label class="control-label">康复近期目标:</label>
					<label class="lbl">${recover.recentTarget}</label>
				</div>
			</div>
			<div class="control-group">
				<div class="from-info" style="width:100%;">
					<label class="control-label">康复远期目标:</label>
					<label class="lbl">${recover.forwardTarget}</label>
				</div>
			</div>
			<div class="control-group">
				<div class="from-info" style="width:100%;">
					<label class="control-label">注意事项:</label>
					<label class="lbl">${recover.carefulMatter}</label>
				</div>
			</div>
			<div class="form-actions">
				<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview()"/>
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</div>
	</div>
</body>
</html>
