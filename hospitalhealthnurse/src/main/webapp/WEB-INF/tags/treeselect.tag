<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="id" type="java.lang.String" required="true" description="编号"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域名称（ID）"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="隐藏域值（ID）"%>
<%@ attribute name="labelName" type="java.lang.String" required="true" description="输入框名称（Name）"%>
<%@ attribute name="labelValue" type="java.lang.String" required="true" description="输入框值（Name）"%>
<%@ attribute name="title" type="java.lang.String" required="true" description="选择框标题"%>
<%@ attribute name="url" type="java.lang.String" required="true" description="树结构数据地址"%>
<%@ attribute name="checked" type="java.lang.Boolean" required="false" description="是否显示复选框"%>
<%@ attribute name="extId" type="java.lang.String" required="false" description="排除掉的编号（不能选择的编号）"%>
<%@ attribute name="notAllowSelectRoot" type="java.lang.Boolean" required="false" description="不允许选择根节点"%>
<%@ attribute name="notAllowSelectParent" type="java.lang.Boolean" required="false" description="不允许选择父节点"%>
<%@ attribute name="module" type="java.lang.String" required="false" description="过滤栏目模型（只显示指定模型，仅针对CMS的Category树）"%>
<%@ attribute name="selectScopeModule" type="java.lang.Boolean" required="false" description="选择范围内的模型（控制不能选择公共模型，不能选择本栏目外的模型）（仅针对CMS的Category树）"%>
<%@ attribute name="allowClear" type="java.lang.Boolean" required="false" description="是否允许清除"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="cssStyle" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="disabled" type="java.lang.String" required="false" description="是否限制选择，如果限制，设置为disabled"%>
<%@ attribute name="nodesLevel" type="java.lang.String" required="false" description="菜单展开层数"%>
<%@ attribute name="nameLevel" type="java.lang.String" required="false" description="返回名称关联级别"%>
<%@ attribute name="parentId" type="java.lang.String" required="false" description="父级节点ID"%>
<%@ attribute name="isClear" type="java.lang.Boolean" required="false" description="清除子节点数据"%>
<%@ attribute name="onSelectedChange" type="java.lang.String" required="false" description="选择改变"%>
<%@ attribute name="change" type="java.lang.Boolean" required="false" description="触发事件"%>
<%@ attribute name="changePlan" type="java.lang.Boolean" required="false" description="触发事件计划统计"%>
<%@ attribute name="changeQuarters" type="java.lang.Boolean" required="false" description="触发事件岗位"%>
<%@ attribute name="onshow" type="java.lang.Boolean" required="false" description="触发岗位是否显示"%>

<div class="input-append">
	<input id="${id}Id" name="${name}" type="hidden" value="${value}"${disabled eq 'true' ? ' disabled=\'disabled\'' : ''}/>
	<input id="${id}Name" name="${labelName}" readonly="readonly" type="text" value="${labelValue}" ${disabled eq "true"? " disabled=\"disabled\"":""}"
		class="${cssClass}" style="${cssStyle}"/><a id="${id}Button" href="javascript:" class="btn${disabled eq 'true' ? ' disabled' : ''}"><i class="icon-search"></i></a>&nbsp;&nbsp;
</div>
<script type="text/javascript">
	$("#${id}Button").click(function(){
		// 是否限制选择，如果限制，设置为disabled
		if ($("#${id}Id").attr("disabled")){
			return true;
		}
		var parentId = "";
		if(${parentId ne null}){
			parentId = $("#${parentId}").val();
		}
        var nameLevel = ${nameLevel eq null ? "1" : nameLevel};
        
		// 正常打开	
		top.$.jBox.open("iframe:${ctx}/tag/treeselect?url=" + encodeURIComponent("${url}") + "${fn:indexOf(url,'?')==-1 ? '?' : '&'}parentId="+parentId+"&module=${module}&checked=${checked}&extId =${extId}&nodesLevel=${nodesLevel}&selectIds=" + $("#${id}Id").val(), "选择${title}", 300, 420, {
			buttons:{"确定":"ok", ${allowClear ? "\"清除\" : \"clear\", ":""}"关闭":true}, submit:function(v, h, f){
				if (v=="ok"){
					var ids = [], 
						  names = [], 
						  nodes = [],
						  tree = h.find("iframe")[0].contentWindow.tree; //h.find("iframe").contents();
						  
					if ("${checked}"){
						nodes = tree.getCheckedNodes(); //省略checked参数，等同于 true
					}else{
						nodes = tree.getSelectedNodes();
					}
					
					if("${isClear}"){
						$("#villageId").val("");
						$("#villageName").val("");
						$("#communityIdId").val("");
						$("#communityIdName").val("");
					}
					
					for(var i=0; i<nodes.length; i++) {//<c:if test="${checked}">
						if (nodes[i].isParent){
							continue; // 如果为复选框选择，则过滤掉父节点
						}//</c:if><c:if test="${notAllowSelectRoot}">
						if (nodes[i].level == 0){
							top.$.jBox.tip("不能选择根节点（"+nodes[i].name+"）请重新选择。");
							return false;
						}//</c:if><c:if test="${notAllowSelectParent}">
						if (nodes[i].isParent){
							top.$.jBox.tip("不能选择父节点（"+nodes[i].name+"）请重新选择。");
							return false;
						}//</c:if><c:if test="${not empty module && selectScopeModule}">
						if (nodes[i].module == ""){
							top.$.jBox.tip("不能选择公共模型（"+nodes[i].name+"）请重新选择。");
							return false;
						}else if (nodes[i].module != "${module}"){
							top.$.jBox.tip("不能选择当前栏目以外的栏目模型，请重新选择。");
							return false;
						}//</c:if>
						
						ids.push(nodes[i].id);
						
                        var t_name = "",
                        	  t_node = nodes[i],
                        	  name_l = 0;
                        
                        do{
                            name_l++;
                            t_name = t_node.name + " " + t_name;
                            t_node = t_node.getParentNode();
                        }while(name_l < nameLevel);
                        
						names.push(t_name);//<c:if test="${!checked}">
						break; // 如果为非复选框选择，则返回第一个选择  </c:if>
					}
					
					$("#${id}Id").val(ids);
					$("#${id}Name").val(names);
					${onSelectedChange};
					if("${change}"){
						if($("#loveSelect").is(":hidden")){
							if($("#departmentId").val() != null){
								launchLoveChart('1','10','1');
								launchNotLoveChart('1','10','1');
							}
						}
					}
					if("${changePlan}"){
						launchPlanChart('1')
					}
					if("${changeQuarters}"){
						$("#quartersId").val("");
						$("#quartersName").val("");
					}
					if("${onshow}"){
						$("#showquarters").show();
					}
				}//<c:if test="${allowClear}">
				else if (v == "clear"){
					$("#${id}Id").val("");
					$("#${id}Name").val("");
					if("${onshow}"){
						$("#quartersId").val("");
						$("#quartersName").val("");
						$("#showquarters").hide();
					}
                }//</c:if>
			}, loaded:function(h){
				$(".jbox-content", top.document).css("overflow-y","hidden");
			}
		});
	});
</script>
