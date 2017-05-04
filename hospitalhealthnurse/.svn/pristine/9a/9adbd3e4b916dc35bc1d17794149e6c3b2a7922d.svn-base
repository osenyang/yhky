<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/dialog.jsp" %>
	<style type="text/css">.sort{color:#0663A2;cursor:pointer;}</style>
	<script type="text/javascript">
		$(document).ready(function() {
			// 表格排序
			tableSort({callBack : page});
			
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出用户数据吗？","系统提示",function(v,h,f){
					if(v == "ok"){
						$("#searchForm").attr("action","${ctx}/sys/user/export").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			
			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true}, 
					bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
			});
		});
		
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sys/user/").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/sys/user/import" method="post" enctype="multipart/form-data"
			style="padding-left:20px;text-align:center;" class="form-search" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-yellow" type="submit" value="   导    入   "/>
			<a href="${ctx}/sys/user/import/template">下载模板</a>
		</form>
	</div>
	<form:form id="searchForm" modelAttribute="user" action="${ctx}/sys/user/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="orderBy" name="orderBy" type="hidden" value="${page.orderBy}"/>
		<label>账号：</label><form:input path="loginName" htmlEscape="false" maxlength="18" class="input-small" onkeydown="if(event.keyCode==13){page();return false;}"/>
		<label>姓&nbsp;&nbsp;&nbsp;名：</label><form:input path="name" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){page();return false;}"/>
		<label>用户类型：</label>
		<form:select path="userType"  cssClass="required input-small">
				<form:option value="">请选择</form:option>
				<form:options items="${fns:getDictList('sys_user_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
		</form:select>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="submit" value="查询" onclick="return page();"/>
		&nbsp;<shiro:hasPermission name="sys:user:edit"><a href="${ctx}/sys/user/form"><input id="btnSubmit" class="btn btn-yellow" type="button" value="新增用户" /></a></shiro:hasPermission>
<!-- 		&nbsp;<input id="btnExport" class="btn btn-yellow" type="button" value="导出"/> -->
<!-- 		&nbsp;<input id="btnImport" class="btn btn-yellow" type="button" value="导入"/> -->
	</form:form>
	
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>序号</th>
			<th>所属机构</th>
			<th class="sort loginName">账号</th>
			<th class="sort name">姓名</th>
			<th>手机号码</th>
			<th class="sort userType">用户类型</th>
			<th>角色</th>
			<th>更新时间</th>
			<shiro:hasPermission name="sys:user:edit"><th>操作</th></shiro:hasPermission>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.office.name}</td>
				<td>${user.loginName}</td>
				<td>${user.name}</td>
				<td>${user.mobile}</td>
				<td>${fns:getDictLabel(user.userType,'sys_user_type','')}</td>
				<td>${user.roleNames}</td>
				<td><fmt:formatDate value="${user.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				
				<shiro:hasPermission name="sys:user:edit">
					<td>
						<c:if test="${user.userType == '1'}">
		    				<a href="${ctx}/sys/user/form?id=${user.id}">修改</a>
							<a href="${ctx}/sys/user/delete?id=${user.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
						</c:if>
					</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>