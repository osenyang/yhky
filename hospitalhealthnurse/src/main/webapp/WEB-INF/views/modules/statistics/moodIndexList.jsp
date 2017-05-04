<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>心情指数管理</title>
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
	    function launchMoodChart(pageNo,pageSize,statType){
	    	$("#moodInfoBtn").removeClass().addClass("btn");
	    	$("#moodTendBtn").removeClass().addClass("btn active");
	    	$("#searchForm").hide();
	    	$("#moodInfo").hide();
	    	$("#moodTend").show();
	    	if(statType == '1'){
	    		$("#btnWeek").removeClass().addClass("btn active");
	    		$("#btnMonth").removeClass().addClass("btn");
	    		$("#btnQuarter").removeClass().addClass("btn");
	    		$("#btnYear").removeClass().addClass("btn");
	    	}else if(statType == '2'){
	    		$("#btnWeek").removeClass().addClass("btn");
	    		$("#btnMonth").removeClass().addClass("btn active");
	    		$("#btnQuarter").removeClass().addClass("btn");
	    		$("#btnYear").removeClass().addClass("btn");
	    	}else if(statType == '3'){
	    		$("#btnWeek").removeClass().addClass("btn");
	    		$("#btnMonth").removeClass().addClass("btn");
	    		$("#btnQuarter").removeClass().addClass("btn active");
	    		$("#btnYear").removeClass().addClass("btn");
	    	}else if(statType == '4'){
	    		$("#btnWeek").removeClass().addClass("btn");
	    		$("#btnMonth").removeClass().addClass("btn");
	    		$("#btnQuarter").removeClass().addClass("btn");
	    		$("#btnYear").removeClass().addClass("btn active");
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
	                var url = '${ctx}/statistics/moodIndex/getMoodIndexAvgTrend';  
	                //图表容器div  
	                var elem = "moodGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                EconfigAPI(ec,url,statType,pageNo,elem);  
	            } 
		     );		     
	    }	    
	    
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function EconfigAPI(ec,url,statType,pageNo,elem){  
	    	var timelist,joylist,happylist,commonlylist,depressedlist,angrylist,sadlist,pagestr ; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{statType:statType,pageNo:pageNo},function(response) {  	 
		    	timelist = response.timelist;  
		    	joylist = response.joylist;  
		    	happylist = response.happylist; 
		    	commonlylist = response.commonlylist;
		    	depressedlist = response.depressedlist;
		    	angrylist = response.angrylist;
		    	sadlist = response.sadlist;
		    	pagestr = response.pagestr[0];
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
	        myChart.clear();
            myChart.setOption({  
    	        title : {
    	            text: '心情值人数统计'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['喜悦','开心','一般','沮丧','发怒','伤心']  
                },  
                toolbox: {  
                    show : true,  
                    padding : 10,
                    feature : {  
                        mark : {show: true},  
                        dataView : {show: true, readOnly: false},  
                        magicType : {show: true, type: ['line', 'bar']},  
                        restore : {show: true},  
                        saveAsImage : {show: true}  
                    }  
                },  
                calculable : true,  
                xAxis : [  
                    {  
                        type : 'category',    
                        boundaryGap : false,
                        data:timelist              
                    }  
                ],  
                yAxis : [  
                    {  
                        type : 'value',  
                        splitNumber : 10,
                       // scale : true,
                        splitArea : {show : true}  
                    }  
                ],  
                series : [  
                    {  
                        name:'喜悦',  
                        type:'line',  
                        data:joylist
                    },  
                    {  
                        name:'开心',  
                        type:'line',  
                        data:happylist
                    },  
                    {  
                        name:'一般',  
                        type:'line',  
                        data:commonlylist
                    },  
                    {  
                        name:'沮丧',  
                        type:'line',  
                        data:depressedlist
                    },  
                    {  
                        name:'发怒',  
                        type:'line',  
                        data:angrylist
                    },  
                    {  
                        name:'伤心',  
                        type:'line',  
                        data:sadlist
                    }
                ]  
            });  	
            $("#moodTendPage").html(pagestr);
	    } 
	    
	    function showsearchForm(){
	    	$("#moodInfoBtn").removeClass().addClass("btn active");
	    	$("#moodTendBtn").removeClass().addClass("btn");
	    	$("#searchForm").show();
	    	$("#moodInfo").show();
	    	$("#moodTend").hide();
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
	<form:form id="searchForm" modelAttribute="moodIndexVO" action="${ctx}/statistics/moodIndex/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label style="padding-top: 10px;">老人姓名 ：</label><form:input path="fullNm" htmlEscape="false" maxlength="30" class="input-small" onkeydown="if(event.keyCode==13){query();return false;}" />
		<label>时间段 ：</label>
	 	<input id="startDate" name="startDate" value="${moodIndexVO.startDate}" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
			 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,maxDate:'#F{$dp.$D(\'endDate\')}'});" />
		- <input id="endDate" name="endDate" value="${moodIndexVO.endDate}" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
			 pattern="yyyy-MM-dd" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,minDate:'#F{$dp.$D(\'startDate\')}'});" />
	 	<label>心情值 ：</label>
		<form:select path="moodValue" htmlEscape="false" cssClass="input-medium-select" style="width:138px;" >
	 		<form:option value="">请选择</form:option>
	 		<form:options items="${fns:getDictList('mood_value')}" itemLabel="label" itemValue="value"/>
	 	</form:select>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="query()" value="查询"/>
		&nbsp;<input id="btnSubmit" class="btn btn-yellow" type="button" onclick="preview(1)" value="打印"/>
	</form:form>
	<label style="padding: 10px;">
		&nbsp;<input id="moodInfoBtn" class="btn active" type="button" onclick="showsearchForm()" value="信息表"/>
		&nbsp;<input id="moodTendBtn" class="btn" type="button" onclick="launchMoodChart('1','10','1');" value="趋势图"/>
	</label>
	<tags:message content="${message}"/>
	<div class="tab-content">
		 <div class="tab-pane active" id="moodInfo">
		 <!--startprint-->
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead><tr>
					<th style="text-align:center;display:table-cell; vertical-align:middle">序号</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">头像</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">老人姓名</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">性别</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">年龄</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">机构</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">心情值</th>
					<th style="text-align:center;display:table-cell; vertical-align:middle">记录日期</th>
				</tr></thead>
				<tbody>
				<c:forEach items="${page.list}" var="moodIndex" varStatus="status">
					<tr >		
						<td style="text-align:center;display:table-cell; vertical-align:middle">${status.count}</td>	
						<td style="text-align:center;display:table-cell; vertical-align:middle"><tags:printImg defaultUrl="/static/images/archives.png" imgOriUrl="${moodIndex.photo}" imgUrl="${moodIndex.photo}" width="30" height="30" /></td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${moodIndex.fullNm}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${moodIndex.sex}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${moodIndex.age}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${moodIndex.officeNm}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${fns:getDictLabel(moodIndex.moodValue, 'mood_value', '')}</td>
						<td style="text-align:center;display:table-cell; vertical-align:middle">${moodIndex.createDate}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		<!--endprint-->
			<div class="pagination">${page}</div>
		</div>
		<div class="tab-pane" id="moodTend">
		 	 <div class="controls">
				<input id="btnWeek" class="btn active" type="button"  onclick="launchMoodChart('1','10','1');" value="最近一周"/>
				<input id="btnMonth" class="btn" type="button" onclick="launchMoodChart('1','10','2');" value="最近一月"/>
				<input id="btnQuarter" class="btn" type="button" onclick="launchMoodChart('1','10','3');" value="最近一季"/>
				<input id="btnYear" class="btn" type="button"  onclick="launchMoodChart('1','10','4');" value="最近一年"/>
			 	<div id="moodGraph"  style="height:380px;border:1px solid #ccc;padding:9px;"></div>
			 </div>
			 <div class="pagination" id="moodTendPage"></div>	
	   </div>
	</div>
</body>
</html>
