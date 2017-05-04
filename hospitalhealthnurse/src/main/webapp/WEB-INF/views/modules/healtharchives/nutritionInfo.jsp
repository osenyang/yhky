<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<style>
	.select2-container{
		margin-bottom: 10px;
	}
	
	#xm-table{
		margin-bottom: 10px;
		border-bottom: 1px solid #b7d5df;
	}
</style>
<script>
	$(function(){
	});
	
	function delTr(obj){
		//var node = $(obj);
		//var tr = node.parent().parent();
		$(obj).parent().parent().remove();
	};
	
	function addTr(){
		var trs = $("#xm-tbody").children("tr");
		var size = trs.size();
		var rpl = "[" + size + "]";
		
		
		var addTrHtml = "<tr>" + $("#temp-tr").html() + "</tr>";
		
		re = new RegExp("cnmb","g"); //定义正则表达式
		addTrHtml = addTrHtml.replace(re, size);
		
		//alert("size="+size +"   rpl="+rpl);
		//alert(addTrHtml);
		$("#xm-tbody").append(addTrHtml);
		
		var s1 = "#s2id_itemName-" + size;
		
		
		//$(s1).select2();
		/* $(s1).select2({
			placeholder: "请选择",
			data:[{id: '流质饮食（1200kcal套餐）', text: '流质饮食（1200kcal套餐）'},{id: "流质饮食（1600kcal套餐）", text: "流质饮食（1600kcal套餐）"},{id: "水剂口服营养补充", text: "水剂口服营养补充"},{id: "粉剂口服营养补充", text: "粉剂口服营养补充"},{id: "全天肠内营养制剂", text: "全天肠内营养制剂"},{id: "高能量膳食", text: "高能量膳食"},{id: "高蛋白膳食", text: "高蛋白膳食"},{id: "高膳食纤维膳食", text: "高膳食纤维膳食"},{id: "益生菌补充", text: "益生菌补充"},{id: "饮水+增稠剂粉剂", text: "饮水+增稠剂粉剂"},{id: "增稠剂水剂", text: "增稠剂水剂"}]
		});  */
		//$("#takeWay-" + size).removeClass("select2-container");
		//$("#mealNum-" + size).removeClass("select2-container");
	};
</script>

<form:form id="nutritionForm" action="${ctx}/healtharchives/intervene/saveNutrition" method="post">
<input type="hidden" id="id" name="id" value="${nutrition.id}">
<input type="hidden" id="interveneId" name="interveneId" value="${intervene.id}">
<div class="docDiv">
	<div class="doctorDiv">	
		<label>责任营养师</label> 		
		<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="dietitianId" name="serviceUser.jobNumber"
		value="${nutrition.serviceUser.jobNumber}" labelName="dietitianNm"  labelValue="${nutrition.serviceUser.name}" title="责任营养师" cssClass="required"></tags:treeselect>	
	</div>
	<div class="doctorDiv">
		<label>膳食营养计划时间</label>
		<input id="treatStartTime" name="startTime" type="text" maxlength="20" class="Wdate input-medium required" 
			value="<fmt:formatDate value="${nutrition.startTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true});"/>~
		<input id="treatEndTime" name="endTime" type="text" maxlength="20" class="Wdate input-medium required" 
			value="<fmt:formatDate value="${nutrition.endTime}" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:true,minDate:$('#treatStartTime').val()});"/>
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="doctorLabel" for="height">身高/m</label>
		<input type="text" id="height" name="height" value="${nutrition.height}" class="required"/>
		<label class="doctorLabel" for="weight">体重/kg</label>
		<input type="text" id="weight" name="weight" value="${nutrition.weight}" class="required"/>
	</div>
	<div class="doctorDiv">	
		<label class="doctorLabel" for="calf">小腿围/cm</label>
		<input type="text" id="calf" name="calf" value="${nutrition.calf}" class="required"/>
		<label class="doctorLabel" for="bmi">BMI值</label>
		<input type="text" id="bmi" name="bmi" value="${nutrition.bmi}" readonly="readonly"/>
	</div>
	<div class="doctorDiv">	
		<label class="doctorLabel">临床诊断</label>
		<textarea id="diagnosis" name="diagnosis" rows="2" cols="5" style="min-width: 550px;">${nutrition.diagnosis}</textarea>
	</div>
	<div class="doctorDiv">	
		<label class="doctorLabel">营养相关疾病</label>
		<textarea id="disease" name="disease" rows="2" cols="5" style="min-width: 550px;">${nutrition.disease}</textarea>
	</div>
	
	<div class="doctorDiv">	
		<label class="doctorLabel" for="mnaSf">MNA-SF营养评估结果</label>
		<select id="mnaSf" name="mnaSf">
			<option >请选择</option>
			<option value="营养正常" ${nutrition.mnaSf == '营养正常' ? 'selected' : ''}>营养正常</option>
			<option value="营养不良风险" ${nutrition.mnaSf == '营养不良风险' ? 'selected' : ''}>营养不良风险</option>
			<option value="营养不良" ${nutrition.mnaSf == '营养不良' ? 'selected' : ''}>营养不良</option>
		</select>
		
		<label class="doctorLabel" for="belong">该患者属于</label>
		<input type="text" id="belong" name="belong" value="${nutrition.belong}" readonly="readonly" />
	</div>
	
	<div class="doctorDiv">	
		<label class="doctorLabel" for="nutritionDiagnosis">营养诊断</label>
		<select id="nutritionDiagnosis" name="nutritionDiagnosisIds" multiple="multiple" placeholder='可多选，可不选'>
			<!-- <option >可多选，可不选</option> -->
			<c:forEach items="${nutritionDiagnosisList}" var="var" >
				<option value="${var.id}" ${var.selected}>${var.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="doctorDiv">	
		<label class="doctorLabel" for="feedingActivity">经口摄食能力</label>
		<select id="feedingActivity" name="feedingActivity">
			<option >请选择</option>
			<option value="正常" ${nutrition.feedingActivity == '正常' ? 'selected' : ''}>正常</option>
			<option value="受限" ${nutrition.feedingActivity == '受限' ? 'selected' : ''}>受限</option>
			<option value="丧失" ${nutrition.feedingActivity == '丧失' ? 'selected' : ''}>丧失</option>
		</select>
		
		<label class="doctorLabel" for="digestibility">消化吸收能力</label>
		<select id="digestibility" name="digestibility">
			<option >请选择</option>
			<option value="正常" ${nutrition.digestibility == '正常' ? 'selected' : ''}>正常</option>
			<option value="轻度絮乱" ${nutrition.digestibility == '轻度絮乱' ? 'selected' : ''}>轻度絮乱</option>
			<option value="严重絮乱" ${nutrition.digestibility == '严重絮乱' ? 'selected' : ''}>严重絮乱</option>
		</select>
	</div>
	<div class="doctorDiv">	
		<label class="doctorLabel" for="appetite">食欲情况</label>
		<select id="appetite" name="appetite">
			<option >请选择</option>
			<option value="正常" ${nutrition.appetite == '正常' ? 'selected' : ''}>正常</option>
			<option value="受限" ${nutrition.appetite == '受限' ? 'selected' : ''}>受限</option>
			<option value="丧失" ${nutrition.appetite == '丧失' ? 'selected' : ''}>丧失</option>
		</select>
		
		<label class="doctorLabel" for="nutritionAndMetabolism">营养代谢</label>
		<select id="nutritionAndMetabolism" name="nutritionAndMetabolism">
			<option >请选择</option>
			<option value="正常" ${nutrition.nutritionAndMetabolism == '正常' ? 'selected' : ''}>正常</option>
			<option value="轻度絮乱" ${nutrition.nutritionAndMetabolism == '轻度絮乱' ? 'selected' : ''}>轻度絮乱</option>
			<option value="严重絮乱" ${nutrition.nutritionAndMetabolism == '严重絮乱' ? 'selected' : ''}>严重絮乱</option>
		</select>
	</div>
</div>
<div class="lineDiv"><input type="button" value="膳食营养计划"></div>

<div class="docDiv">
	<div class="doctorDiv">	
		<label class="doctorLabel" for="dailyEnergy">计划每日所需能量/kcal</label>
		<input type="text" id="dailyEnergy" name="dailyEnergy" value="${nutrition.dailyEnergy}" />
		<label class="doctorLabel" for="dailyWater">计划每日所需水量/ml</label>
		<input type="text" id="dailyWater" name="dailyWater" value="${nutrition.dailyWater}" />
		<label class="doctorLabel" for="dailyProtein">计划每日蛋白质供给量/g</label>
		<input type="text" id="dailyProtein" name="dailyProtein" value="${nutrition.dailyProtein}" />
	</div>
	
	<!-- osenyang===================================================================== -->
	<table class="table" id="xm-table">
		<thead>
			<tr>
				<th>营养项目</th>
				<th>给予途径</th>
				<th>餐次</th>
				<th>摄入量(g)</th>
				<th>能量(kcal)</th>
				<th>蛋白质(g)</th>
				<th>配餐时间</th>
				<th>进餐时间</th>
				<th>配餐人</th>
				<th>接收人</th>
				<th>喂养/输注执行人</th>
				<th><a class="btn btn-primary" onclick="addTr()">新增项目</a></th>
			</tr>
		</thead>
		<tbody id="xm-tbody">
			<c:forEach items="${nutrition.items}" var="item" varStatus="status">
					<tr class="fe-tr">
						<td>
						<select id="itemName-${status.index}" name="items[${status.index}].itemName">
							<option >请选择</option>
							<c:forEach items="${nutrition.itemNames}" var="itemName">
								<option value="${itemName}" ${itemName== item.itemName? 'selected': '' }>${itemName}</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select id="takeWay-${status.index}" name="items[${status.index}].takeWay">
							<option >请选择</option>
							<c:forEach items="${nutrition.takeWays}" var="takeWay">
								<option value="${takeWay}" ${takeWay== item.takeWay? 'selected': '' }>${takeWay}</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select id="mealNum-${status.index}" name="items[${status.index}].mealNum">
							<option >请选择</option>
							<c:forEach items="${nutrition.mealNums}" var="mealNum">
								<option value="${mealNum}" ${mealNum== item.mealNum? 'selected': '' }>${mealNum}</option>
							</c:forEach>
						</select>
					</td>
				
					<td>
						<input type="text" name="items[${status.index}].intake" value="${item.intake}">
					</td>
					<td>
						<input type="text" name="items[${status.index}].energy" value="${item.energy}">
					</td>
					<td>
						<input type="text" name="items[${status.index}].protein" value="${item.protein}">
					</td>
					<td>
						<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeDataForEnum" id="caterTime-${status.index}" name="items[${status.index}].caterTime" checked="true"
							value="${item.caterTime}" labelValue="${item.caterTime}" labelName="" 
							title="配餐时间" cssClass=""></tags:treeselect>
					</td>
					<td>
						<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeDataForEnum" id="mealtime-${status.index}" name="items[${status.index}].mealtime" checked="true"
							value="${item.mealtime}" labelValue="${item.mealtime}" labelName="" 
							title="进餐时间" cssClass=""></tags:treeselect>
					</td>
					<td>
						<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="caterUser-${status.index}" name="items[${status.index}].caterUserId"
							value="${item.caterUserId}" labelName="dietitianNm"  labelValue="${item.caterUser.name}" 
							title="配餐人(岗位)" cssClass="required"></tags:treeselect>	
					</td>
					<td>
						<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="receiveUser-${status.index}" name="items[${status.index}].receiveUserId"
							value="${item.receiveUserId}" labelName="dietitianNm"  labelValue="${item.receiveUser.name}" 
							title="接收人(岗位)" cssClass="required"></tags:treeselect>
					</td>
					<td>
						<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="executeUser-${status.index}" name="items[${status.index}].executeUserId"
							value="${item.executeUserId}" labelName="dietitianNm"  labelValue="${item.executeUser.name}" 
							title="喂养/输注执行人(岗位)" cssClass="required"></tags:treeselect>
					</td>
					<td><a class="btn btn-primary" onclick="delTr(this);">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<!-- osenyang===================================================================== -->
	
	
	<div class="doctorDiv">	
		<label class="doctorLabel" for="actualTotalEnergy">实际能量合计/kcal</label>
		<input type="text" id="actualTotalEnergy" name="actualTotalEnergy" value="${nutrition.actualTotalEnergy}" />
		<label class="doctorLabel" for="actualTotalWater">实际水量合计/ml</label>
		<input type="text" id="actualTotalWater" name="actualTotalWater" value="${nutrition.actualTotalWater}" />
		<label class="doctorLabel" for="actualTotalProtein">实际蛋白质合计/g</label>
		<input type="text" id="actualTotalProtein" name="actualTotalProtein" value="${nutrition.actualTotalProtein}" />
	</div>
	
	<div class="doctorDiv">	
		<label class="doctorLabel" for="marginEnergy">能量差额/kcal</label>
		<input type="text" id="marginEnergy" name="marginEnergy" value="${nutrition.marginEnergy}" />
		<label class="doctorLabel" for="marginWater">水量差额/ml</label>
		<input type="text" id="marginWater" name="marginWater" value="${nutrition.marginWater}" />
		<label class="doctorLabel" for="marginProtein">蛋白质差额/g</label>
		<input type="text" id="marginProtein" name="marginProtein" value="${nutrition.marginProtein}" />
	</div>
</div>
<%-- <table class="interveneTable">
	<tr>
		<th width="20%">餐次安排</th>
		<th width="20%">执行人(岗位)</th>
	</tr>
		<td>
			<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeDataForEnum" id="foodArrange" name="foodArrange" checked="true"
			value="${nutrition.foodArrange}" labelName=""  labelValue="${nutrition.foodArrange}" 
			title="餐次安排" cssClass=""></tags:treeselect>
		</td>
		<td>
			<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeData" id="foodQuartersId" name="foodQuartersId" 
			value="${nutrition.foodQuartersId}" labelName="foodQuartersNm"  labelValue="${nutrition.foodQuartersNm}" 
			title="执行人(岗位)" cssClass="recoverQuarters "></tags:treeselect>
		</td>
	</tr>
</table> --%>



<div class="lineDiv"><input type="button" value="相关注意事项"></div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="doctorLabel">膳食营养相关指导</label>
		<textarea id="direct" name="direct" maxlength="100" rows="2" cols="5" style="min-width: 550px;">${nutrition.direct}</textarea>
	</div>
</div>
<div class="docDiv">
	<div class="doctorDiv">	
		<label class="doctorLabel">进餐/营养给予注意事项</label>
		<textarea id="notice" name="notice" maxlength="100" rows="2" cols="5" style="min-width: 550px;">${nutrition.notice}</textarea>
	</div>
</div>
<div class="form-actions">
<c:if test="${intervene.state == 0 || intervene.state == 2 }">
	<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="submitBut('nutritionForm','${ctx}/healtharchives/intervene/saveNutrition')" value="保 存"/>&nbsp;
</c:if>
	<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	<input id="btnPrint" class="btn" type="button" value="打印" onclick="preview('1');"/>
</div>
</form:form>


<table style="display: none;">
		<tr id="temp-tr">
				<td  name="template">
					<select >
					</select>
					<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/itemNameTree" id="itemName-cnmb" name="items[cnmb].itemName" checked="true"
						value="" labelValue="" labelName="" 
						title="营养项目" cssClass=""></tags:treeselect>
				</td>
				<td>
					<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/takeWayTree" id="takeWay-cnmb" name="items[cnmb].takeWay" checked="true"
						value="" labelValue="" labelName="" 
						title="给予途径" cssClass=""></tags:treeselect>
				</td>
				<td>
					<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/mealNumTree" id="mealNum-cnmb" name="items[cnmb].mealNum" checked="true"
						value="" labelValue="" labelName="" 
						title="餐次" cssClass=""></tags:treeselect>
				</td>
				<td>
					<input type="text" name="items[cnmb].intake">
				</td>
				<td>
					<input type="text" name="items[cnmb].energy">
				</td>
				<td>
					<input type="text" name="items[cnmb].protein">
				</td>
				<td>
					<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeDataForEnum" id="caterTime-cnmb" name="items[cnmb].caterTime" checked="true"
						value="" labelValue="" labelName="" 
						title="配餐时间" cssClass=""></tags:treeselect>
				</td>
				<td>
					<tags:treeselect allowClear="true" notAllowSelectParent="true" url="/healtharchives/intervene/treeDataForEnum" id="mealtime-cnmb" name="items[cnmb].mealtime" checked="true"
						value="" labelValue="" labelName="" 
						title="进餐时间" cssClass=""></tags:treeselect>
				</td>
				<td>
					<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="caterUser-cnmb" name="items[cnmb].caterUserId"
						value="" labelName="dietitianNm"  labelValue="" 
						title="配餐人(岗位)" cssClass="required"></tags:treeselect>	
				</td>
				<td>
					<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="receiveUser-cnmb" name="items[cnmb].receiveUserId"
						value="" labelName="dietitianNm"  labelValue="" 
						title="接收人(岗位)" cssClass="required"></tags:treeselect>
				</td>
				<td>
					<tags:treeselect notAllowSelectParent="true" url="/healtharchives/healthArchives/treeData" id="executeUser-cnmb" name="items[cnmb].executeUserId"
						value="" labelName="dietitianNm"  labelValue="" 
						title="喂养/输注执行人(岗位)" cssClass="required"></tags:treeselect>
				</td>
				<td><a class="btn btn-primary" onclick="delTr(this);">删除</a></td>
			</tr>
	</table>