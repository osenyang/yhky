<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>亿灵社区健康服务管理系统</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="${pageContext.request.contextPath}/static/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${pageContext.request.contextPath}/static/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="${pageContext.request.contextPath}/static/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/static/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/static/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${pageContext.request.contextPath}/static/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/media/image/favicon.ico" />
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!--  头 -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<a class="brand" href="#">
				<img src="${pageContext.request.contextPath}/static/images/logo_small.png" alt="logo"/>
				</a>
				<!-- END LOGO -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a href="javascript:alert('sss');" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
				<img src="${pageContext.request.contextPath}/static/media/image/menu-toggler.png" alt="" />
				</a>    
				<!-- END RESPONSIVE MENU TOGGLER -->        
				<!-- BEGIN TOP NAVIGATION MENU -->             
				<ul class="nav pull-right">
					<!-- BEGIN NOTIFICATION DROPDOWN -->   
					<li class="dropdown" id="header_notification_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-warning-sign"></i>
						<span class="badge">6</span>
						</a>
						<ul class="dropdown-menu extended notification">
							<li>
								<p>您有*条通知</p>
							</li>
							<li>
								<a href="#">
								<span class="label label-success"><i class="icon-plus"></i></span>
								New user registered. 
								<span class="time">Just now</span>
								</a>
							</li>			
					</ul>
					</li>
					<!-- END NOTIFICATION DROPDOWN -->
					<!-- BEGIN INBOX DROPDOWN -->
					<li class="dropdown" id="header_inbox_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-envelope"></i>
						<span class="badge">5</span>
						</a>
						<ul class="dropdown-menu extended inbox">
							<li>
								<p>您有*条消息</p>
							</li>
							<li>
								<a href="inbox.html?a=view">
								<span class="photo"><img src="${pageContext.request.contextPath}/static/media/image/avatar2.jpg" alt="" /></span>
								<span class="subject">
								<span class="from">Lisa Wong</span>
								<span class="time">Just Now</span>
								</span>
								<span class="message">
								Vivamus sed auctor nibh congue nibh. auctor nibh
								auctor nibh...
								</span>  
								</a>
							</li>
							<li class="external">
								<a href="inbox.html">查看所有消息<i class="m-icon-swapright"></i></a>
							</li>
						</ul>
					</li>
					<!-- END INBOX DROPDOWN -->
					<!-- BEGIN TODO DROPDOWN -->
					<li class="dropdown" id="header_task_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-tasks"></i>
						<span class="badge">5</span>
						</a>
						<ul class="dropdown-menu extended tasks">
							<li>
								<p>您有*条待办任务</p>
							</li>
							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Mobile app release</span>
								<span class="percent">98%</span>
								</span>
								<span class="progress progress-success">
								<span style="width: 98%;" class="bar"></span>
								</span>
								</a>
							</li>
							<li class="external">
								<a href="#">查看所有任务<i class="m-icon-swapright"></i></a>
							</li>
						</ul>
					</li>
					<!-- END TODO DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="" src="${pageContext.request.contextPath}/static/media/image/avatar1_small.jpg" />
						<span class="username"><shiro:principal property="name"/></span>
						<i class="icon-angle-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="extra_profile.html"><i class="icon-user"></i>个人信息</a></li>
							<li><a href="page_calendar.html"><i class="icon-calendar"></i>我的日历</a></li>
							<li><a href="#"><i class="icon-envelope"></i>我的信箱</a></li>
							<li><a href="#"><i class="icon-tasks"></i>我的任务</a></li>
							<li class="divider"></li>
							<li><a href="${ctx}/sys/user/modifyPwd"><i class="icon-lock"></i>修改密码</a></li>
							<li><a href="${ctx}/logout"><i class="icon-key"></i> 退出</a></li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
				<!-- END TOP NAVIGATION MENU --> 
			</div>
		</div>		
	</div>
	<!-- 头导航结束 -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->        
			<ul class="page-sidebar-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li>
				</li>
				<li class="start active ">
					<a href="index.html">
					<i class="icon-home"></i>
					<span class="title">工作台</span>
					<span class="selected"></span>
					</a>
				</li>
				<c:set var="firstMenu" value="true"/>
				<c:set var="menuList" value="${fns:getMenuList()}"/>
				 <c:forEach items="${menuList}" var="menu" varStatus="idxStatus">				 
				 	<c:if test="${menu.parent.id eq '1' && menu.isShow eq '1'}">			
						<li>
							<a class="active" href="javascript:;">
							<i class="icon-sitemap"></i> 
							<span class="title">${menu.name}</span>
							<span class="arrow "></span>
							</a>
														
								<ul class="sub-menu">
									<c:forEach items="${menu.childList}" var="menuChild">
									<li>
										<a href="javascript:;">
										${menuChild.name}
										<span class="arrow"></span>
										</a>
										
											<ul class="sub-menu">	
											<c:forEach items="${menuChild.childList}" var="menuLeaf">									
												<li>												
												<a href=javascript:loadPage('${fn:indexOf(menuLeaf.href, '://') eq -1?ctx:''}${not empty menuLeaf.href?menuLeaf.href:'/404'}')>${menuLeaf.name}</a>
												</li>															
											</c:forEach>
											</ul>										
									</li>
									</c:forEach>	
								</ul>						
												
						</li>
					</c:if>	
				</c:forEach>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div class="page-content" id="pageContent">
		</div>
		<!-- END PAGE -->
	</div>

	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		<div class="footer-inner">
 			 Copyright &copy; 2014-${fns:getConfig('copyrightYear')} ${fns:getConfig('productName')} - Powered By <a href="#" target="_blank">珠海亿联德源信息技术有限公司</a> ${fns:getConfig('version')}
		</div>
		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="${pageContext.request.contextPath}/static/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${pageContext.request.contextPath}/static/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="${pageContext.request.contextPath}/static/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>
	<script src="media/js/respond.min.js"></script>  
	<![endif]-->  
	<script src="${pageContext.request.contextPath}/static/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="${pageContext.request.contextPath}/static/media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->
<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${pageContext.request.contextPath}/static/media/js/app.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/media/js/index.js" type="text/javascript"></script>        
	<!-- END PAGE LEVEL SCRIPTS --> 
	<script>
		jQuery(document).ready(function() {   
		   App.init(); // initlayout and core plugins
		   Index.init();
//		   Index.initJQVMAP(); // init index page's custom scripts
//		   Index.initCalendar(); // init index page's custom scripts
//		   Index.initCharts();// init index page's custom scripts
//		   Index.initChat();
//		   Index.initMiniCharts();
//		   Index.initDashboardDaterange();
//		   Index.initIntro();
		});
		
		function loadPage(url){
			alert(url);
			$("#pageContent").load(url);
		}

	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>