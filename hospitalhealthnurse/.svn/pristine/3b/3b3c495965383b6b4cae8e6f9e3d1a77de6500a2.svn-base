<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>喜爱统计管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/echarts-2.2.7/js/echarts.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		//var echarts;
		require.config({
	        paths: {
	            echarts: '${ctxStatic}/echarts-2.2.7/js'
	        }
	    });	    
	    var echarts1;
	    var echarts2;
	    //加载图表
	    function launchLoveChart(pageNo,pageSize,statType){
	    	if(statType == '1'){
	    		$("#btnWeekLove").removeClass().addClass("btn active");
	    		$("#btnMonthLove").removeClass().addClass("btn");
	    		$("#btnQuarterLove").removeClass().addClass("btn");
	    		$("#btnYear").removeClass().addClass("btn");
	    	}else if(statType == '2'){
	    		$("#btnWeekLove").removeClass().addClass("btn");
	    		$("#btnMonthLove").removeClass().addClass("btn active");
	    		$("#btnQuarterLove").removeClass().addClass("btn");
	    		$("#btnYearLove").removeClass().addClass("btn");
	    	}else if(statType == '3'){
	    		$("#btnWeekLove").removeClass().addClass("btn");
	    		$("#btnMonthLove").removeClass().addClass("btn");
	    		$("#btnQuarterLove").removeClass().addClass("btn active");
	    		$("#btnYearLove").removeClass().addClass("btn");
	    	}else if(statType == '4'){
	    		$("#btnWeekLove").removeClass().addClass("btn");
	    		$("#btnMonthLove").removeClass().addClass("btn");
	    		$("#btnQuarterLove").removeClass().addClass("btn");
	    		$("#btnYearLove").removeClass().addClass("btn active");
	    	}
		    require(
	            [
	                'echarts',
	                'echarts/chart/bar',
	                'echarts/chart/line'	        
	            ],
	           // requireCallback  
	            function(ec) {  
	                //数据时间查询参数  	             
	                //数据生成路径  
	                var url = '${ctx}/statistics/loveCensus/getLoveCensusAvgTrend?departmentId='+$("#departmentId").val();  
	                //图表容器div  
	                var elem = "loveGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                EconfigLoveAPI(ec,url,statType,pageNo,elem);  
	            } 
		     );		     
	    }	    
	    
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function EconfigLoveAPI(ec,url,statType,pageNo,elem){  
	    	var serviceUserNmlist,numberlist,pagestr ; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{statType:statType,pageNo:pageNo},function(response) {  	 
	        	serviceUserNmlist = response.serviceUserNmlist;  
		    	numberlist = response.numberlist;  
		    	pagestr = response.pagestr[0];
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
            myChart.setOption({  
    	        title : {
    	            text: '服务人员喜爱数统计'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['人数统计']
                },  
                toolbox: {  
                    show : true,  
                    feature : {  
                        mark : {show: true},  
                        dataView : {show: true, readOnly: false},  
                        magicType : {show: true, type: ['line','bar']},  
                        restore : {show: true},  
                        saveAsImage : {show: true}  
                    }  
                },  
                calculable : true,  
                xAxis : [  
                    {  
                        type : 'value',    
                        boundaryGap : [0, 1],
                    }  
                ],  
                yAxis : [  
                    {  
                        type : 'category',
                        data:serviceUserNmlist,
                    }  
                ],  
                series : [  
                    {  
                        name:'人数统计',  
                        type:'bar',  
                        data:numberlist
                    }
                ]  
            });  	
            $("#loveTendPage").html(pagestr);
	    } 
	    
	    //加载图表
	    function launchNotLoveChart(pageNo,pageSize,statType){
	    	if(statType == '1'){
	    		$("#btnWeekNotLove").removeClass().addClass("btn active");
	    		$("#btnMonthNotLove").removeClass().addClass("btn");
	    		$("#btnQuarterNotLove").removeClass().addClass("btn");
	    		$("#btnYearNotLove").removeClass().addClass("btn");
	    	}else if(statType == '2'){
	    		$("#btnWeekNotLove").removeClass().addClass("btn");
	    		$("#btnMonthNotLove").removeClass().addClass("btn active");
	    		$("#btnQuarterNotLove").removeClass().addClass("btn");
	    		$("#btnYearNotLove").removeClass().addClass("btn");
	    	}else if(statType == '3'){
	    		$("#btnWeekNotLove").removeClass().addClass("btn");
	    		$("#btnMonthNotLove").removeClass().addClass("btn");
	    		$("#btnQuarterNotLove").removeClass().addClass("btn active");
	    		$("#btnYearNotLove").removeClass().addClass("btn");
	    	}else if(statType == '4'){
	    		$("#btnWeekNotLove").removeClass().addClass("btn");
	    		$("#btnMonthNotLove").removeClass().addClass("btn");
	    		$("#btnQuarterNotLove").removeClass().addClass("btn");
	    		$("#btnYearNotLove").removeClass().addClass("btn active");
	    	}
		    require(
	            [
	                'echarts',
	                'echarts/chart/bar',
	                'echarts/chart/line'	        
	            ],
	           // requireCallback  
	            function(ec) {  
	                //数据时间查询参数  	             
	                //数据生成路径  
	                var url = '${ctx}/statistics/loveCensus/getNotLoveCensusAvgTrend?departmentId='+$("#departmentId").val();  
	                //图表容器div  
	                var elem = "notLoveGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                EconfigNotLoveAPI(ec,url,statType,pageNo,elem);  
	            } 
		     );		     
	    }	    
	    
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function EconfigNotLoveAPI(ec,url,statType,pageNo,elem){  
	    	var serviceUserNmlist,numberlist,pagestr ; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{statType:statType,pageNo:pageNo},function(response) {  	 
	        	serviceUserNmlist = response.serviceUserNmlist;  
		    	numberlist = response.numberlist;  
		    	pagestr = response.pagestr[0];
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
            myChart.setOption({  
    	        title : {
    	            text: '撤销服务人员喜爱数统计'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['人数统计']
                },  
                toolbox: {  
                    show : true,  
                    feature : {  
                        mark : {show: true},  
                        dataView : {show: true, readOnly: false},  
                        magicType : {show: true, type: ['line','bar']},  
                        restore : {show: true},  
                        saveAsImage : {show: true}  
                    }  
                },  
                calculable : true,  
                xAxis : [  
                    {  
                        type : 'value',    
                        boundaryGap : [0, 10],
                    }  
                ],  
                yAxis : [  
                    {  
                        type : 'category',
                        data:serviceUserNmlist,
	                    axisLabel:{  
	                        interval:0 ,  
	                        rotate:10 
	                    }  
                    }  
                ],  
                series : [  
                    {  
                        name:'人数统计',  
                        type:'bar',  
                        data:numberlist
                    }
                ]  
            });  	
            $("#notLoveTendPage").html(pagestr);
	    } 
	    
	    function showloveSelect(){
	    	$("#loveInfoBtn").removeClass().addClass("btn active");
	    	$("#loveTendBtn").removeClass().addClass("btn");
	    	$("#loveSelect").show();
	    	$("#loveInfo").show();
	    	$("#loveTend").hide();
	    }
	    
	    function showLoveTend(){
	    	$("#loveInfoBtn").removeClass().addClass("btn");
	    	$("#loveTendBtn").removeClass().addClass("btn active");
	    	$("#loveInfo").hide();
	    	$("#loveTend").show();
	    	$("#loveSelect").hide();
	    	launchLoveChart('1','10','1');
			launchNotLoveChart('1','10','1');
	    }
	    
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
		
		function preview(oper){
			if (oper < 10){
				bdhtml=window.document.body.innerHTML;//获取当前页的html代码
				sprnstr="<!--startprint-->";//设置打印开始区域
				eprnstr="<!--endprint-->";//设置打印结束区域
				prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html
				prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
				window.document.body.innerHTML=prnhtml;		
				$("a").each(function(){  
		         	var xx=$(this).html();  
		         	$(this).replaceWith(xx);  
		     	}) 
				window.print();
				window.document.body.innerHTML=bdhtml;
			} else {
				window.print();
			}
		}
		
	</script>
</head>
<body>
	<form:form id="searchForm" modelAttribute="loveCensusVO" action="${ctx}/statistics/loveCensus/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
		<label>科 室 ：</label>
		<tags:treeselect id="department" name="departmentId" parentId="officeId" value="${loveCensusVO.departmentId}" labelName="departmentNm" labelValue="${loveCensusVO.departmentNm}" 
		title="科室" url="/serviceorg/department/departmentDataByOfficeId" notAllowSelectParent="true" cssStyle="width:125px;" cssClass="required" allowClear="true" change="true" />
		<span id="loveSelect">
			<label>老人姓名 ：</label><form:input path="fullNm" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
			<label>人员姓名 ：</label><form:input path="serviceUserNm" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
			<label>住院号 ：</label><form:input path="hospitalizationNumber" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
			<label>病区 ：</label><form:input path="inpatientNm" htmlEscape="false" maxlength="15" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
			<br/>
			<label style="padding-top: 10px;">时间段 ：</label>
		 	<input id="startDate" name="startDate" value="${loveCensusVO.startDate}" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
				 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,maxDate:'#F{$dp.$D(\'endDate\')}'});"/>
			- <input id="endDate" name="endDate" value="${loveCensusVO.endDate}" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
				 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,minDate:'#F{$dp.$D(\'startDate\')}'});"/>
			&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query()" value="查询"/>
			&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="preview(1)" value="打印"/>
		</span>
	</form:form>
	<label style="padding: 10px;">
		&nbsp;<input id="loveInfoBtn" class="btn active" type="button" onclick="showloveSelect()" value="信息表"/>
		&nbsp;<input id="loveTendBtn" class="btn" type="button" onclick="showLoveTend();" value="趋势图"/>
	</label>
	<tags:message content="${message}"/>
	<div class="tab-content">
		 <div class="tab-pane active" id="loveInfo">
		 <!--startprint-->
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead><tr>
					<th style="text-align:center;display:table-cell; vertical-align:middle">序号</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">老人姓名</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">性别</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">住院号</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">病区</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">年龄</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">机构</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">科室</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">人员姓名</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">创建时间</th>
				</tr></thead>
				<tbody>
				<c:forEach items="${page.list}" var="loveCensus" varStatus="status">
					<tr>			
						<td style="text-align:center;display:table-cell; vertical-align:middle">${status.count}</td>	
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.fullNm}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.sex}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.hospitalizationNumber}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.inpatientNm}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.age}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.officeNm}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.departmentNm}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.serviceUserNm}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${loveCensus.createDate}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		<!--endprint-->
			<div class="pagination">${page}</div>
		</div>
		<div class="tab-pane" id="loveTend">
		 	 <div class="controls">
				<input id="btnWeekLove" class="btn active" type="button"  onclick="launchLoveChart('1','10','1');" value="最近一周"/>
				<input id="btnMonthLove" class="btn" type="button" onclick="launchLoveChart('1','10','2');" value="最近一月"/>
				<input id="btnQuarterLove" class="btn" type="button" onclick="launchLoveChart('1','10','3');" value="最近一季"/>
				<input id="btnYearLove" class="btn" type="button"  onclick="launchLoveChart('1','10','4');" value="最近一年"/>
			 	<div id="loveGraph"  style="height:380px;border:1px solid #ccc;padding:9px;"></div>
			 </div>
			 <div class="pagination" id="loveTendPage"></div>	
			 
			 <div class="controls">
				<input id="btnWeekNotLove" class="btn active" type="button"  onclick="launchNotLoveChart('1','10','1');" value="最近一周"/>
				<input id="btnMonthNotLove" class="btn" type="button" onclick="launchNotLoveChart('1','10','2');" value="最近一月"/>
				<input id="btnQuarterNotLove" class="btn" type="button" onclick="launchNotLoveChart('1','10','3');" value="最近一季"/>
				<input id="btnYearNotLove" class="btn" type="button"  onclick="launchNotLoveChart('1','10','4');" value="最近一年"/>
			 	<div id="notLoveGraph"  style="height:380px;border:1px solid #ccc;padding:9px;"></div>
			 </div>
		 	 <div class="pagination" id="notLoveTendPage"></div>	
	   </div>
	</div>
</body>
</html>
