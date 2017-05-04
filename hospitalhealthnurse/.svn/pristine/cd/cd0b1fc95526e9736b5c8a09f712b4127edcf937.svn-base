<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>基础数据管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/echarts-2.2.7/js/echarts.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			launchSexChart();
			launchAgeChart();
			launchRecureChart();
			launchPlanChart();
		});
		//var echarts;
		require.config({
	        paths: {
	            echarts: '${ctxStatic}/echarts-2.2.7/js'
	        }
	    });	    
	    var echarts1;
	    var echarts2;
	    //加载性别人数图表
	    function launchSexChart(){	 	
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
	                var url = '${ctx}/statistics/baseData/getSexAvgTrend';  
	                //图表容器div  
	                var elem = "sexGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                SexEconfigAPI(ec,url,elem);  
	            } 
		     );		     
	    }	    
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function SexEconfigAPI(ec,url,elem){  
	    	var valuelist; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{},function(response) {  	 
		    	valuelist = response.valuelist;  
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
	        myChart.clear();
            myChart.setOption({  
    	        title : {
    	            text: '性别统计'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['人数']  
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
                        data:['女','男']              
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
                        name:'人数',  
                        type:'bar', 
                        barWidth: 40,
                        data:valuelist
                    }
                ]  
            });  	
	    } 
	 	//加载年龄断人数图表
	    function launchAgeChart(){	 	
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
	                var url = '${ctx}/statistics/baseData/getAgeAvgTrend';  
	                //图表容器div  
	                var elem = "ageGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                AgeEconfigAPI(ec,url,elem);  
	            } 
		     );		     
	    }
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function AgeEconfigAPI(ec,url,elem){  
	    	var valuelist; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{},function(response) {  	 
		    	valuelist = response.valuelist;  
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
	        myChart.clear();
            myChart.setOption({  
    	        title : {
    	            text: '年龄统计'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['人数']  
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
                        data:['60岁以下','60~69岁','70~79岁','80岁以上']                 
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
                        name:'人数',  
                        type:'bar', 
                        barWidth: 40,
                        data:valuelist
                    }
                ]  
            });  	
	    } 
	 	 //加载康复情况图表
	    function launchRecureChart(){	 	
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
	                var url = '${ctx}/statistics/baseData/getRecureAvgTrend';  
	                //图表容器div  
	                var elem = "recureGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                RecureEconfigAPI(ec,url,elem);  
	            } 
		     );		     
	    }	 
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function RecureEconfigAPI(ec,url,elem){  
	    	var valuelist; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{},function(response) {  	 
		    	valuelist = response.valuelist;  
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
	        myChart.clear();
            myChart.setOption({  
    	        title : {
    	            text: '康复情况统计'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['人数']  
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
                        data:['已康复','治疗中']              
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
                        name:'人数',  
                        type:'bar', 
                        barWidth: 60,
                        data:valuelist
                    }
                ]  
            });  	
	    } 
	 	 //加载计划类型图表
	    function launchPlanChart(){	 	
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
	                var url = '${ctx}/statistics/baseData/getPlanAvgTrend';  
	                //图表容器div  
	                var elem = "planGraph";  
	                //自定义加载图表函数   echartsConfig.js  
	                PlanEconfigAPI(ec,url,elem);  
	            } 
		     );		     
	    }	 
	    /**  
	     * 构建动态图表  
	     * @param url   获取后台数据地址  
	     * @param time  图表查询时间  
	     * @param elem  加载容器  
	     */  
	    function PlanEconfigAPI(ec,url,elem){  
	    	var valuelist; 
	         $.ajaxSettings.async = false;  //同步才能获取数据  
	         $.post(url,{},function(response) {  	 
		    	valuelist = response.valuelist;  
	        }, "json");        
	        //--- 折柱 ---  
	        var myChart = ec.init(document.getElementById(elem)); 
	        myChart.clear();
            myChart.setOption({  
    	        title : {
    	            text: '计划类型统计'
    	        },
                tooltip : {  
                    trigger: 'axis'  
                },  
                legend: {  
                    data:['计划数量']  
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
                        data:['诊疗计划','护理计划','照护计划','营养计划','康复计划','社工计划','其他计划']              
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
                        name:'计划数量',  
                        type:'bar', 
                        barWidth: 40,
                        data:valuelist
                    }
                ]  
            });  	
	    } 
	  	
	</script>
	<style type="text/css">
		.controls{
			width:100%;float: left;
		}
	</style>
</head>
<body>
	<tags:message content="${message}"/>
	<div class="tab-content" style="width:99.8%;border:1px solid #ccc;">
		<div class="controls" >
		 	<div id="sexGraph"  style="height:380px;width:45%;padding:5px;float: left;"></div>
		  	<div id="ageGraph"  style="height:380px;width:53.13%;padding:5px;float: left;"></div>
	 	</div>
	 	<div class="controls">
	 		<div id="recureGraph"  style="height:380px;border-top:1px solid #ccc;padding:5px;"></div>
	 	</div>
	 	<div class="controls">
	  		<div id="planGraph"  style="height:380px;border-top:1px solid #ccc;padding:5px;"></div>
	  	</div>
	</div>
</body>
</html>
