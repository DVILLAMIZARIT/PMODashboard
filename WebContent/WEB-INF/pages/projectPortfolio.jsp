<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/FusionCharts.js"></script>
	
	<link rel="stylesheet" href="resources/css/projectPortfolio.css">
	<title>Project Portfolio</title>  
	
	
	<script type="text/javascript">	
	$(document).ready(function(){
        
        var monthlyChart = new FusionCharts("resources/charts/MSCombi2D.swf","myMSCombiChartId", "600", "350", "0", "1");
        $.ajax({
            //url:"http://localhost:8080/PMODashboard/monthlyTarget",
            url:"http://10.103.21.16:8080/PMODashboard/monthlyTarget",
            dataType:"json",
            success:function(data){
            	//alert("OK" + data);
                monthlyChart.setJSONData(data);                
                monthlyChart.render("mscombichartContainer");
            },error:function(data){
                alert("OK-ERROR");
            }
        });


        var accumulatedChart = new FusionCharts("resources/charts/MSLine.swf","myMSCombiChartId", "600", "350", "0", "1");
        $.ajax({
            //url:"http://localhost:8080/PMODashboard/accumulated",
            url:"http://10.103.21.16:8080/PMODashboard/accumulated",
            dataType:"json",
            success:function(data){
                accumulatedChart.setJSONData(data);                
                accumulatedChart.render("linechartContainer");
            },error:function(data){
                alert("OK-ERROR");
            }
        });
	});     
    </script>     
	
	<script type="text/javascript">

function altRows(id){
	//if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	//}
}
window.onload=function(){
	altRows('alternatecolor');
	altRows('alternatecolor2');
}
</script>
	
</head>

<body>

	<%@ include file="header.jsp" %>

	<div class="container">

	<div style="width: 100%;">
		<table class="charts">
			<tr>
				<td id="withoutColor" valign="top">
					<table class="altrowstable" id="alternatecolor">
						<tr>
							<th colspan="2">Summary</th>
							<th colspan="2">Projects</th>
							<th colspan="2">Initiatives</th>
						</tr>
						<c:forEach var="listValue" items="${datos}"> 
						<tr>
							<td>${listValue.status}</td>
							<c:if test="${listValue.status eq 'Closed'}">
								<td><img src="<c:url value="resources/images/Closed.png" />" /></td>
							</c:if> 
							<c:if test="${listValue.status eq 'On Track'}">
								<td><img src="<c:url value="resources/images/OnTrack.png" />" /></td>
							</c:if>
							<c:if test="${listValue.status eq 'On Risk'}">
								<td><img src="<c:url value="resources/images/OnRisk.png" />" /></td>
							</c:if>
							<c:if test="${listValue.status eq 'Delayed'}">
								<td><img src="<c:url value="resources/images/Delayed.png" />" /></td>
							</c:if>
							<c:if test="${listValue.status eq 'Canceled'}">
								<td><img src="<c:url value="resources/images/Canceled.png" />" /></td>
							</c:if>
							<td>${listValue.totProject}</td>
							<td>${listValue.percentageProject}%</td>
							<td>${listValue.totInitiatives}</td>
							<td>${listValue.percentageInitiatives}%</td>
						</tr>
						</c:forEach>
						<tr>
							<td colspan="2">Total</td>
							<td>${totalProjects}</td>
							<td>${totalPercentageProjects}%</td>
							<td>${totalInitiatives}</td>
							<td>${totalPercentageInitiatives}%</td>
						</tr>
					</table>
				</td>
				<td colspan="2"><br></td>
				<td valign="top"><div id="linechartContainer">FusionCharts XT will load here!</div></td>
			</tr>
			<tr>
				<td id="withoutColor" valign="top">
					<table class="altrowstable" id="alternatecolor2">
						<tr>
							<th colspan="3">Top Projects - Month Target</th>
						</tr>
						<c:forEach var="listValue" items="${topProject}">
						<tr>
							<td><a href='individual?idAuth=${listValue.idAuth}&projectName=${listValue.projectName}' title="individual">${listValue.projectName}</a></td>
							<c:if test="${listValue.status eq 'Closed'}">
								<td><img src="<c:url value="resources/images/Closed.png" />" /></td>
							</c:if> 
							<c:if test="${listValue.status eq 'On Track'}">
								<td><img src="<c:url value="resources/images/OnTrack.png" />" /></td>
							</c:if>
							<c:if test="${listValue.status eq 'Delayed'}">
								<td><img src="<c:url value="resources/images/Delayed.png" />" /></td>
							</c:if>
							<c:if test="${listValue.status eq 'On Risk'}">
								<td><img src="<c:url value="resources/images/OnRisk.png" />" /></td>
							</c:if>
							<c:if test="${listValue.status eq 'Canceled'}">
								<td><img src="<c:url value="resources/images/Canceled.png" />" /></td>
							</c:if>
								<td></td>
						</tr>
					</c:forEach>
					</table>
				</td>
				<td colspan="2"><br></td>
				<td valign="top"><div id="mscombichartContainer">FusionCharts XT will load here!</div></td>
			</tr>
		</table>
	</div>	
	
	
	<script>
		/*
		var myChart= new FusionCharts("resources/charts/MSLine.swf","myLineChartId", "600", "300", "0");
		myChart.setXMLUrl("resources/Data/Monthly.xml");
		myChart.render("linechartContainer");
		*/
	</script>
        
	</div>
	
	</body>
</html>