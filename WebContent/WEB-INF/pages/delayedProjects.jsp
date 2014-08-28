<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resources/js/paging.js"></script>
	
	<link rel="stylesheet" href="resources/css/projectPortfolio.css">
	<title>Project Portfolio</title>
	
	<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr");

		var delayedRows = table.getElementsByTagName("th");

		for(i = 0; i < delayedRows.length; i++){
			delayedRows[i].className = "delayedcolor";
		} 
		 
		for(i = 0; i < rows.length; i++){
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}
window.onload=function(){
	altRows('alternatecolor');
}
</script>	
	
	
</head>

<body>

	<%@ include file="header.jsp" %>

	<div class="container">
		<div id="NavPosicion"></div>
		<table class="altrowstable" id="alternatecolor">
			<tr>
				<th>No</th>
				<th>Project</th>
				<th>Responsable</th>
				<th>Issue</th>
				<th>Action Plan</th>
				<th>Due Date</th>
			</tr>
			<c:forEach var="listValue" items="${datos}">
			<tr>
				<td>${listValue.numberId}</td>
				<td>${listValue.projectName}</td>
				<td>${listValue.owner}</td> 
				<td id="halfsize">${listValue.issueRiskDescription}</td>
				<td id="halfsize">${listValue.actionPlan}</td>
				<td>${listValue.dueDateBL}</td>
			</tr>
			</c:forEach>
		</table>
		</div>		
		
		<!-- Invoke the Pager and pass the values for pagination -->
		<script type="text/javascript">
			var pager = new Pager('alternatecolor', 20);
			pager.init();
			pager.showPageNav('pager', 'NavPosicion');
			pager.showPage(1);
		</script>
			
	</body>
</html>