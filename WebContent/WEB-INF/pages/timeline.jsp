<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<script type="text/javascript" src="resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/FusionCharts.js"></script>

		<link rel="stylesheet" href="resources/css/projectPortfolio.css">
		<title>Timelines</title>
		
		
		<script>
			function goBack() {
	    		window.history.back();
			}
		</script>
		
		<script type="text/javascript">	
			$(document).ready(function(){

			var idAuth = '${idAuthProject}';
			var totalTimelines = '${totalTimelines}';
			//var timelineAnc = "800";
			//var timelineAlt = "500";
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
    
    	<%@ include file="header.jsp" %>

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
        <script type="text/javascript"><!--//
			$(document).ready ( function() {
			   showConditionalMessage( "Your browser does not seem to have Flash Player support. Gantt Chart  is not supported by JavaScript.", isJSRenderer(myChart) );
			});	
			// -->
		</script>
		          
	</div>		 
	
	<button onclick="goBack()">Go Back</button>
	         
    </body>
</html>