<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>分配角色</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	
	<tags:message content="${message}"/>
	<div class="breadcrumb">
		<span class="span4">角色名称: <b>${role.name}</b></span>
		<c:set var="dictvalue" value="${role.dataScope}" scope="page" />
<%-- 		<span class="span4">数据范围: ${fns:getDictLabel(dictvalue, 'sys_data_scope', '')}</span> --%>
		<form id="assignRoleForm" action="" method="post" class="hide"></form>
		<a id="assignButton" href="javascript:" class="btn btn-yellow">分配角色</a>
		<script type="text/javascript">
			$("#assignButton").click(function(){
				top.$.jBox.open("iframe:${ctx}/sys/role/usertorole?id=${role.id}", "分配角色",$(top.document).width()-240,$(top.document).height()-240,{
					buttons:{"确定分配":"ok", "清除已选":"clear", "关闭":true}, submit:function(v, h, f){
						var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;
						var ids = h.find("iframe")[0].contentWindow.ids;
						//nodes = selectedTree.getSelectedNodes();
						if (v=="ok"){
							// 删除''的元素
							if(ids[0]==''){
								ids.shift();
								pre_ids.shift();
							}
							if(pre_ids.sort().toString() == ids.sort().toString()){
								top.$.jBox.tip("未给角色【${role.name}】分配新成员！", 'info');
								return false;
							};
					    	// 执行保存
					    	loading('正在提交，请稍等...');
					    	var idsArr = "";
					    	for (var i = 0; i<ids.length; i++) {
					    		idsArr = (idsArr + ids[i]) + (((i + 1)== ids.length) ? '':',');
					    	}
					    	$('#assignRoleForm').attr('action','${ctx}/sys/role/assignrole?id=${role.id}&idsArr='+idsArr).submit();
					    	return true;
						} else if (v=="clear"){
							h.find("iframe")[0].contentWindow.clearAssign();
							return false;
		                }
					}, loaded:function(h){
						$(".jbox-content", top.document).css("overflow-y","hidden");
					}
				});
			});
		</script>
	</div>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>登录名</th>
			<th>姓名</th>
			<th>手机</th>
			<shiro:hasPermission name="sys:user:edit"><th>操作</th></shiro:hasPermission>
		</tr></thead>
		<tbody>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><a href="${ctx}/sys/user/form?id=${user.id}">${user.loginName}</a></td>
				<td>${user.name}</td>
				<td>${user.mobile}</td>
				<shiro:hasPermission name="sys:role:edit"><td>
					<a href="${ctx}/sys/role/outrole?userId=${user.id}&roleId=${role.id}" 
						onclick="return confirmx('确认要将用户<b>[${user.name}]</b>从<b>[${role.name}]</b>角色中移除吗？', this.href)">移除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
