<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<script type="text/javascript">	
			$(document).ready(function(){

			var idAuth = '${idAuth}';
			var totalTimelines = '${totalTimelines}';
			
			var timelineAnc = "800";
			var timelineAlt = "500";

			if(totalTimelines <= 11){
				timelineAnc = "800";
				timelineAlt = "300";
			}
			else if(totalTimelines >= 35){
				timelineAnc = "900";
				timelineAlt = "700";
			}
	        	
        	var monthlyChart = new FusionCharts("resources/charts/Gantt.swf","myChartId", timelineAnc, timelineAlt, "0", "1");
        	$.ajax({
            	//url:"http://localhost:8080/PMODashboard/getTimeline?idAuth=" + idAuth,
            	url:"http://10.103.21.16:8080/PMODashboard/getTimeline?idAuth=" + idAuth,
            	dataType:"json",
            	success:function(data){
            	//alert("OK" + data);
                monthlyChart.setJSONData(data);                
                monthlyChart.render("chartContainer");
            },error:function(data){
                alert("OK-ERROR");
            }
        });
	});     
    </script> 	
	</head>
	<body>
	<div class="container">
        <div id="wrapper">
			<div class="content-area">
        		<div id="content-area-inner-main">
                    <p class="text" align="center">&nbsp;</p><h2>${projectNameTitle}</h2><p>&nbsp;</p>

                    <div class="gen-chart-render">
                        <div id="chartContainer">FusionWidgets XT will load here!</div>
					</div>
                    <div class="clear"></div>
                    <p>&nbsp;</p>
                    <p class="small">    </p>
                    <div class="underline-dull"></div>
                </div>
			</div>
			<div id="footer">
                <p class="highlightBlock">&nbsp;</p>
			</div>
        </div>
	</div>
	</body>
</html>