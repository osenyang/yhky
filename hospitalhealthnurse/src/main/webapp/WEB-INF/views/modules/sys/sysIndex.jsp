<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${fns:getConfig('productName')}</title>
	<%@include file="/WEB-INF/views/include/dialog.jsp" %>
	<meta name="decorator" content="default"/>
	<script type="text/javascript"> 
		$(document).ready(function() {
			$("#menu a.menu").click(function(){
				$("#menu li.menu").removeClass("active");
				$(this).parent().addClass("active");
				if(!$("#openClose").hasClass("close")){
					$("#openClose").click();
				}
			});
			
		});
		
		function fallMonitor(){
			$.get(
					"${ctx}/sys/fallGpsData/fallMonitor",
					function(json){
						$.each(json, function(n, value){
							var htmlvar = '<div class="fall"><br/><input id="id" type="hidden" value="'+value.id+'" />产品编号：'+value.productId+'<br/>';
							htmlvar += '姓名：'+value.fullNm+'<br/>';
							htmlvar += '性别：'+value.sex+'<br/>';
							htmlvar += '联系电话：'+value.tel+'<br/>';
							htmlvar += '定位时间：'+value.gpsDate+'<br/>';
							htmlvar += '经纬度：'+value.gpsLong+' '+value.gpsLat+'<br/>';
							htmlvar += '</div>';
							$.jBox(htmlvar, {
								title:"跌倒预警提示", 
								bottomText : "点击确定后不再显示预警!",
								width : 350,
								height : 250, 
								buttons:{"确定":"ok","关 闭":true},
								submit :  function (v, h, f){
									if(v == "ok"){
										var id = h.find("#id").val();
										$.get(
											"${ctx}/sys/fallGpsData/updateSta?id="+id,
											function (date){
												$.jBox.tip("已确定!");
										});
										return true;
									}
								}
							});
						})
			});
		}
	</script>
	
	<style type="text/css">
		#main {padding:0;margin:0;} 
		#main .container-fluid{padding:0 4px 0 0px;background-color: #f3f9ee;}
		#header {padding:0 0 3px 165px;position:static;background-color: #1AB5AC;} 
		#header li {
			font-size:16px;
			_font-size:14px;
			font-weight: bold;
			font-family: 微软雅黑;
			}
		#header .brand {
			font-size:26px;
 			padding-left:0px; 
 			border-right: 2px solid white;
			height: 10px; 
		}
		#footer {padding:3px 0 0 0;font-size:16px;text-align:center;border-top:2px solid #0663A2;}
		#footer, #footer a {color:#0d6fb8;background-color: #E9EAEB;} 
		.hredDiv{
			padding-left: 60px;
			padding-top : 10px;
			padding-bottom : 15px;
			background-color: #A0D6D6;
			
		}
		.infoe{
			float: right;
			margin-top: 20px;
			margin-right:40px;
			font-size: 20px;
			font-family: "微软雅黑";
			color: white;
		}
		.fall{
			margin-left:10px;
			font-size: 16px;
			font-family: "微软雅黑";
		}
		.menuWidth{
			width:130px;
		}
	</style>
</head>
<body>
	<div id="main">
		<div class="hredDiv">
			<img style="height: 50px" src="${ctxStatic}/images/yi_hu_hred_logo.png">
			<img style="height: 45px;padding-left:30px" src="${ctxStatic}/images/yi-hu-kang-yang.png">
			<img style="height: 40px;padding-left:15px" src="${ctxStatic}/images/guan-li-xi-tong.png">
			<div class="infoe" >
				<font style="color:#fe6f06">尊敬的用户,你好!</font>&nbsp;&nbsp;&nbsp;
<%-- 				<shiro:principal property="name"/>&nbsp; --%>
				<a style="color: #262626;" href="${ctx}/logout" title="退出系统">退出系统</a> 
			</div>
		</div>
		<div id="header" class="navbar navbar-fixed-top">
	      <div class="navbar-inner">
	      	 <div class="brand"></div>
	         <div class="nav-collapse">
	           <ul id="menu" class="nav">
				 <c:set var="firstMenu" value="true"/>
				 <c:forEach items="${fns:getMenuList()}" var="menu" varStatus="idxStatus">
					<c:if test="${menu.parent.id eq '1' && menu.isShow eq '1'}">
						<li class="menu ${firstMenu ? ' active' : ''} menuWidth">
							<a class="menu" href="${ctx}/sys/menu/tree?parentId=${menu.id}" target="menuFrame" >${menu.name}</a>
						</li>
						<c:if test="${firstMenu}">
							<c:set var="firstMenuId" value="${menu.id}"/>
						</c:if>
						<c:set var="firstMenu" value="false"/>
					</c:if>
				 </c:forEach>
	           </ul>
	         </div>
	      </div>
	    </div>
	    <div class="container-fluid">
			<div id="content" class="row-fluid">
				<div id="left" >
					<iframe id="menuFrame" name="menuFrame" src="${ctx}/sys/menu/tree?parentId=${firstMenuId}" style="overflow:visible;border: 1px solid #b7d5df;  "
						scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
				</div>
				<div id="openClose" class="close">&nbsp;</div>
				<div id="right">
					<iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;  border: 1px solid #b7d5df;"
						scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
				</div>
				
			</div>
		    <div id="footer" class="row-fluid" >
	            Copyright &copy;${fns:getConfig('copyrightYear')} ${fns:getConfig('productName')} 
<%-- 	            - Powered By <a href="#" target="_blank">珠海亿联德源信息技术有限公司</a> ${fns:getConfig('version')} --%>
			</div>
		</div>
	</div>
	<script type="text/javascript"> 
		var leftWidth = "160"; // 左侧窗口大小
		function wSize(){
			var minHeight = 500, minWidth = 980;
			var strs=getWindowSize().toString().split(",");
			//alert(strs[1]);
			$("#menuFrame, #mainFrame, #openClose").height((strs[0]<minHeight?minHeight:strs[0])-$("#header").height()-$("#footer").height()-70);
			$("#openClose").height($("#openClose").height()-5);
//			$("#main").css("width","auto");
			 if(strs[1]<minWidth){
				$("#main").css("width",minWidth-10);
				$("html,body").css({"overflow":"auto","overflow-x":"auto","overflow-y":"auto"});
			}else{
				$("#main").css("width","auto");
				$("html,body").css({"overflow":"hidden","overflow-x":"hidden","overflow-y":"hidden"}); 
			} 
			$("#right").width($("#content").width()-$("#left").width()-$("#openClose").width()-5);
		}
	</script>
	<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
</body>
</html>