<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计划统计</title>
	<meta name="decorator" content="default"/>
	<style type="text/css">.sort{color:#0663A2;cursor:pointer;}</style>
	<script src="${ctxStatic}/echarts-2.2.7/js/echarts.js"></script>
	<script type="text/javascript">	
		$(document).ready(function() {
			launchPlanChart('1');
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
	    function launchPlanChart(statType){	 			
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
	                var url = '${ctx}/plan/serviceUserRoster/getPlanStatTrend?departmentId='+$("#departmentId").val();  
	                //图表容器div  
	                var elem = "planGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                EconfigAPI(ec,url,statType,elem);  
	            } 
		     );		     
	    }	    
	    
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function EconfigAPI(ec,url,statType,elem){  
	    	var timelist,totallist,unFinishlist,onTimeComplist,delayComplist; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{statType:statType},function(response) {  	 
		    	timelist = response.timelist;  
		    	totallist = response.totallist;  
		    	unFinishlist = response.unFinishlist;  
		    	onTimeComplist = response.onTimeComplist;  
		    	delayComplist = response.delayComplist;  
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
	        myChart.clear();
            myChart.setOption({  
    	        title : {
    	            text: '全部科室'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['计划总数','未执行','准时执行','延时执行']  
                },  
                toolbox: {  
                    show : true,  
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
                        name:'计划总数',  
                        type:'line',  
                        data:totallist,
                    },  
                    {  
                        name:'未执行',  
                        type:'line',  
                        data:unFinishlist ,
                    },  
                    {  
                        name:'准时执行',  
                        type:'line',  
                        data:onTimeComplist,
                    },
                    {  
                        name:'延时执行',  
                        type:'line',  
                        data:delayComplist,
                    }
                ]  
            });  	
	    }      
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/plan/serviceUserRoster/">计划统计</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="elderPlanVO" action="${ctx}/plan/serviceUserRoster/planStatChart" method="post" class="breadcrumb form-search">
		<input type="hidden" id="officeId" name="officeId" value="${fns:getUser().office.id}"/>
		<label>科室 ：</label>
		<tags:treeselect id="department" name="departmentId" parentId="officeId" value="${elderPlanVO.departmentId}" labelName="departmentNm" labelValue="${elderPlanVO.departmentNm}" 
			title="科室" url="/serviceorg/department/departmentDataByOfficeId" notAllowSelectParent="true" cssClass="required" cssStyle="width:125px;" allowClear="true" changePlan="true"/> 
	</form:form>
	<div class="tab-content">	   
	   <div class="tab-pane active" id="planTend">
		 	 <div class="controls">
				<input id="btnWeek" class="btn active" type="button"  onclick="launchPlanChart('1');" value="最近一周"/>
				<input id="btnMonth" class="btn" type="button" onclick="launchPlanChart('2');" value="最近一月"/>
				<input id="btnQuarter" class="btn" type="button" onclick="launchPlanChart('3');" value="最近一季"/>
				<input id="btnYear" class="btn" type="button"  onclick="launchPlanChart('4');" value="最近一年"/>
			 	<div id="planGraph"  style="height:400px;border:1px solid #ccc;padding:10px;"></div>
			 </div>
	   </div>
	</div>
</body>
</html>
