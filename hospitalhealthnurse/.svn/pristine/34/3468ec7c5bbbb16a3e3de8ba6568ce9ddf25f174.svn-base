<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" type="text/css" href="${ctxStatic}/fullcalendar/css/fullcalendar.css">
	<link rel="stylesheet" type="text/css" media='print' href="${ctxStatic}/fullcalendar/css/fullcalendar.print.css">
	<style type="text/css">
		#calendar{width:500px; margin:0 auto;}
	</style>
	<script type="text/javascript" src="${ctxStatic}/fullcalendar/js/moment.min.js"></script> 
	<script type="text/javascript" src="${ctxStatic}/fullcalendar/js/jquery-ui.custom.min.js"></script> 
	<script type="text/javascript" src="${ctxStatic}/fullcalendar/js/fullcalendar.min.js"></script> 
	<script type="text/javascript">
	$(document).ready(function() {
		var today=new Date();
		var beginDate="${beginDateStr}";
		var date;
		if(beginDate!=""){
			date =  new Date(Date.parse(beginDate.replace(/-/g, "/")));  
		}else{
			date = today;
		}
	    var d = date.getDate();
	    var m = date.getMonth();
	    var y = date.getFullYear();
		$('#calendar').fullCalendar({
			now:date,
			viewDisplay: function (view) {
				$(".fc-today").removeClass("fc-state-highlight");
			},
	        dayClick: function(date, allDay, jsEvent, view) {
	        	var canNotSel=$(this).hasClass("fc-other-month");
	        	if(!canNotSel){ 
		        	if(date<today){
		        		alert("不能编辑今天和之前的日期");
		        	}else{
		        		if($(this).attr("selected")){
			        		$(this).attr("selected",false);
			        		//$(this).css('background-color', 'white');
			        		$(this).html("");
			        	}else{
			        		$(this).attr("selected",true);
			        		//$(this).css('background-color', 'red');
			        		$(this).html("<div style='width:100%;height:100%;text-align:center;margin-top: 50%;'>上班</div>");
			        	}
		        	}
	        	}
	           },
	           firstDay: 1,
	           year:y,
	           month:m,
	           date:d,
	          monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
	          monthNamesShort: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
	          dayNames: ['周日','周一','周二','周三','周日','周五','周六'],
	          dayNamesShort: ['日','一','二','三','四','五','六'],
	          buttonText: {
	            today: '今天',
	            month: '月',
	            week: '周',
	            day: '日'
	          },
	          titleFormat: {
	              month: 'YYYY年MMMM'
	            },
	            columnFormat: {
	              month: 'ddd',
	              week: 'ddd M/d',
	              day: 'dddd M/d'
	            },
	            timeFormat: { // for event elements
	              '': 'HH:mm-' // default
	            },
            events: function (start, end,timezone, callback){
            	var serialNumber="${serialNumber}";
        		if(serialNumber!=""){
        			$.get("${ctx}/plan/serviceUserRoster/listJson",{serialNumber : "${serialNumber}"},
        					function(json){
        						$.each(json, function(n, obj){
        							var d=$(".fc-day[data-date='"+obj.beginDate+"']");
        							 d.attr("selected",true);
					        		// d.css('background-color', 'red');
					        		 d.append("<div style='width:100%;height:100%;text-align:center;margin-top: 50%;'>上班</div>");
        						});
        					}
        				);
        		}
            }
		});
	});
	</script>
</head>
<body>
	<div id="calendar"></div>
</body>
</html>
