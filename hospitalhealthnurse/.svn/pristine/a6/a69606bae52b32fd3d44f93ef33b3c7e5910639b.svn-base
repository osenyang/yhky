<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人员排班</title>
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/jquery-ztree/3.5.12/js/jquery.ztree.exedit-3.5.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		var serviceUserTree;  // 服务人员
		var selectedUserTree; // 选择的服务人员
		var departmentIdStr;
		var serialNumberStr;
		$(document).ready(function() {
			serialNumberStr="${serviceUserRosterVO.serialNumber}";
			departmentIdStr="${serviceUserRosterVO.departmentId}";
			$("#calendarControl").load("${ctx}/plan/serviceUserRoster/rosterForm?id=${serviceUserRosterVO.id}");
			if(departmentIdStr!=""){
				initServiceUserTreeSetting();
			}
			initSelectedUserTreeSetting();
			// 保存分配点击fun
			$("#saveAll").click(function(){
				serviceUserTree.checkAllNodes(true);
				var anodes = serviceUserTree.getCheckedNodes(true);
				if(anodes == ''){
					top.$.jBox.tip("请选择服务人员！", 'info');
					return ;
				}
				addNodeInfo(anodes);
			});
			// 保存分配点击fun
			$("#save").click(function(){
				var anodes = serviceUserTree.getCheckedNodes(true);
				if(anodes == ''){
					top.$.jBox.tip("请选择服务人员！", 'info');
					return ;
				}
				addNodeInfo(anodes);
			});
			// 保存分配点击fun
			$("#cancel").click(function(){
				var anodes = selectedUserTree.getCheckedNodes(true);
				if(anodes == ''){
					top.$.jBox.tip("请选择排班人员！", 'info');
					return ;
				}
				removeNodeInfo(anodes);
			});
			// 保存分配点击fun
			$("#cancelAll").click(function(){
				selectedUserTree.checkAllNodes(true);
				var anodes = selectedUserTree.getCheckedNodes(true);
				if(anodes == ''){
					top.$.jBox.tip("请选择排班人员！", 'info');
					return ;
				}
				removeNodeInfo(anodes);
			});
		});
		// 添加选择的服务人员节点到分配 
		function addNodeInfo(anodes){
			for(var d = 0; d < anodes.length; d++){
				var pId=anodes[d].pId;
				var parentNode = selectedUserTree.getNodeByParam("id", pId, null);
				if(parentNode==null){
					var pNode=serviceUserTree.getNodeByParam("id", pId, null);
					parentNode = {name:pNode.name,id:pId,pId:0,open:true,isParent:true,nocheck:true};
					selectedUserTree.addNodes(null,parentNode);
					parentNode = selectedUserTree.getNodeByParam("id", pId, null);
				}
				var newNode=selectedUserTree.getNodeByParam("id", anodes[d].id, null);
				if(newNode==null){
					newNode = {name:anodes[d].name,id:anodes[d].id,pId:parentNode.id,isParent:false,nocheck:false};
					selectedUserTree.addNodes(parentNode,newNode);
				}
			}
			expandAllSelectedUserLeaf();
		}
		// 添加选择的服务人员节点到分配 
		function removeNodeInfo(anodes){
			for(var d = 0; d < anodes.length; d++){
				var pId=anodes[d].pId;
				var aParentNode = selectedUserTree.getNodeByParam("id", pId, null);
				selectedUserTree.removeNode(anodes[d]);
				if(aParentNode.children.length==0){
					selectedUserTree.removeNode(aParentNode);
				}
			}
		}
		// 科室选择改变 
		function onDepartmentChange(){
			departmentIdStr=$("#departmentId")[0].value;
			initServiceUserTreeSetting();
		}
		// 服务人员TREE配置
		function initServiceUserTreeSetting(){
			var serviceUserSetting = {
					async : {enable : true,
						url : "${ctx}/plan/serviceUserRoster/serviceUserTreeData",
						contentType : "application/json",
						otherParam: { "departmentId":departmentIdStr},
						type : "GET",
					},
					data: {
		                    simpleData: {
		                        enable: true,
		                        idKey: "id",
		                        pIdKey: "pId",
		                        rootPId: ""
		                    }
		            },
					callback:{
						onExpand: null,
						onAsyncSuccess: expandAllServiceUserLeaf
					},
					check : {enable : true,chkStyle : "checkbox"}
				};
				serviceUserTree = $.fn.zTree.init($("#serviceUserTree"), serviceUserSetting);
		}
		function initSelectedUserTreeSetting(){
			// 选择用户Tree配置
			var selectedUserSetting = {
					async : {enable : true,
						url : "${ctx}/plan/serviceUserRoster/rosterUserTreeData",
						contentType : "application/json",
						otherParam: { "serialNumber":serialNumberStr},
						type : "GET",
					},
					data: {
	                    simpleData: {
	                        enable: true,
	                        idKey: "id",
	                        pIdKey: "pId",
	                        rootPId: ""
	                    }
	           		 },
					callback:{
						onExpand: null,
						onAsyncSuccess: expandAllSelectedUserLeaf
					},
					check : {enable : true,chkStyle : "checkbox"}
				};
			selectedUserTree = $.fn.zTree.init($("#selectedUserTree"), selectedUserSetting);
		}
		// 获取已经选择的服务人员id
		function getSelectedUser(){
			var anodes = selectedUserTree.getNodes();
			var serviceUserId = "";
			for(var d = 0; d < anodes.length; d++){
				var treeNode=anodes[d];
				if (treeNode.isParent) {
			        var childrenNodes = treeNode.children;
			        if (childrenNodes) {
			            for (var i = 0; i < childrenNodes.length; i++) {
			                if (childrenNodes[i].isParent) {
			                	serviceUserId += getAllLeafNodes(childrenNodes[i]);
			                } else {
			                	serviceUserId += childrenNodes[i].id + ",";
			                }
			            }
			        }
			    } else{
			    	serviceUserId += treeNode.id + ",";
			    }
			}
			return serviceUserId;
		}
		//得到所有的叶子节点的服务人员id
		function getAllLeafNodes(treeNode) {
			var serviceUserId = "";
		    if (treeNode.isParent) {
		        var childrenNodes = treeNode.children;
		        if (childrenNodes) {
		            for (var i = 0; i < childrenNodes.length; i++) {
		                if (childrenNodes[i].isParent) {
		                	serviceUserId += getAllLeafNodes(childrenNodes[i]);
		                }else{
		                	serviceUserId += childrenNodes[i].id + ",";
		                }
		            }
		        }
		    } else{
		    	serviceUserId += treeNode.id + ",";
		    }
		    return serviceUserId;
		}
		function expandAllServiceUserLeaf(){
			serviceUserTree.expandAll(true);
		}
		function expandAllSelectedUserLeaf(){
			selectedUserTree.setting.async.enable=false;
			selectedUserTree.expandAll(true);
		}
		// 获取选择的排班日期
		function getSelectedDates(){
			var selectedDates = "";
			var arr = $(".fc-day");
			for(var i=0;i<arr.length;i++)
			{
				 var d = $(arr[i]);
				 if(d.attr("selected")){
					 selectedDates+=d.attr("data-date") + ",";
				 }
			}
			return selectedDates;
		}
		function submitForm(){
			$("#serviceUserIds").val(getSelectedUser());
			$("#selectedDates").val(getSelectedDates());
			if($.trim($("#serviceUserIds").val())==""){
				alert("请选择服务人员");
				return false;
			}
			if($.trim($("#selectedDates").val())==""){
				alert("请选择排班日期");
				return false;
			}
			if($.trim($("#startTime").val())==""){
				alert("请选择上班时间");
				return false;
			}
			if($.trim($("#selectedDates").val())==""){
				alert("请选择下班时间");
				return false;
			}
			return true;
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
	<form:form id="inputForm" modelAttribute="serviceUserRosterVO" action="${ctx}/plan/serviceUserRoster/save" method="post" class="form-horizontal" onSubmit="return submitForm()">
		<form:hidden path="id"/>
		<input type="hidden" id="officeId" value="${serviceUserRosterVO.officeId }"/>
		<input type="hidden" id="serviceUserIds" name="serviceUserIds" value=""/>
		<input type="hidden" id="serviceUserNames" name="serviceUserNames" value=""/>
		<input type="hidden" id="selectedDates" name="selectedDates" value=""/>
		<tags:message content="${message}"/>
		
		<div class="control-group" <c:if test='${empty serviceUserRosterVO.serialNumber }'>style="display:none"</c:if>>
			<div class="from-info">	
				<label class="control-label" for="serialNumber"><span class="tishi">*</span>排班序号:</label>
				<input type="hidden" id="serialNumber" name="serialNumber" value="${serviceUserRosterVO.serialNumber }"  htmlEscape="false" maxlength="30" class="input-medium disabled"  readonly="readonly"/>
				<input type="text" value="${fn:substringAfter(serviceUserRoster.serialNumber, '_')}" readonly="readonly"/>
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">
				<label class="control-label" for=beginTime><span class="tishi">*</span>上班时间:</label>
			 	<input id="startTime" name="beginTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate required" pattern="yyyy-MM-dd"
				  	onclick="WdatePicker({dateFmt:'H:mm',isShowClear:true});" value="<fmt:formatDate value="${serviceUserRoster.beginDate}" pattern='HH:mm'/>" />
			</div>
			<div class="from-info">
				<label class="control-label" for=endTime ><span class="tishi">*</span>下班时间:</label>
			 	 <input id="endTime" name="endTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate required" pattern="yyyy-MM-dd"
				  	onclick="WdatePicker({dateFmt:'H:mm',isShowClear:true});" value="<fmt:formatDate value="${serviceUserRoster.endDate}" pattern='HH:mm'/>" />
			</div>
		</div>
		<div class="control-group">
			<div class="from-info">
				<label class="control-label" for=beginDate><span class="tishi">*</span>排班日历:</label>
				<div id="calendarControl"></div>
			</div>
		</div>
		<div class="control-group">
			<div class="row-fluid span12">
				<div class="span4" style="background-color: #dbf1f1;padding-top: 4px; padding-left: 10px;">
					<div>
						<label  for="departmentId"><span class="tishi">*</span>所在科室:</label>
					 	<tags:treeselect id="department" name="departmentId" value="${serviceUserRosterVO.departmentId}" labelName="departmentName" labelValue="${serviceUserRosterVO.departmentName}" 
						title="科室" url="/serviceorg/department/departmentData" notAllowSelectParent="true" cssClass="required" cssStyle="width:125px;" allowClear="true" onSelectedChange="onDepartmentChange()"/>
					</div>
				</div>
				<div class="span1"></div>
				<div class="span4" style="background-color: #dbf1f1;padding-top: 4px; padding-left: 10px;margin-left:-5px;">
					<span style="font-size: 20px; color: #2fa4e7;">已选择人员</span>
				</div>
			</div>
			<div id="assignRole" class="row-fluid span12">
				<div class="span4" style="border: 1px solid #A8A8A8;padding-left: 15px; height: 400px; overflow:auto;background-color: #f7f7f7;">
					<!-- <p style="background-color: #f5f5f5; margin-top: 8px;">医生专家  姓 名：<input type="text" class="input-small" /></p> -->
					<div id="serviceUserTree" class="ztree"></div>
				</div>
				<div class="span1" style="margin-left: 5px; height: 400px;"  >
					<input id="saveAll"  type="button" class="btn btn-yellow" value="全部添加至" style="margin-top: 50px;"/> 
					<input id="save"  type="button" class="btn btn-yellow" value="添加至" style="margin-top: 50px;"/> 
					<input id="cancel"  type="button" class="btn btn-yellow" value="撤销添加" style="margin-top: 50px;"/> 
					<input id="cancelAll"  type="button" class="btn btn-yellow" value="全部撤销" style="margin-top: 50px;"/> 
				</div>
				<div class="span4" style="border: 1px solid #A8A8A8;margin-left:19px;padding-left: 15px; height: 400px; overflow:auto; background-color: #f7f7f7;">
					<!-- <p style="background-color: #f5f5f5; margin-top: 8px;">老人分配 姓 名：<input type="text" class="input-small" /></p> -->
					<div id="selectedUserTree" class="ztree"></div>
				</div>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-yellow" type="submit" value="保 存"/>&nbsp;
			<a href="${ctx}/plan/serviceUserRoster/"><input id="btnCancel" class="btn" type="button" value="返 回" /></a>
		</div>
	</form:form>
</body>
</html>
