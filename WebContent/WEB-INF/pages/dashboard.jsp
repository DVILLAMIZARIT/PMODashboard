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
	
	
	<form name='dashboardForm' action="<c:url value='dashboardFilter'/>" method='GET'>
	<div class="container">
		<div id="NavPosicion"></div>
		<table class="altrowstable" id="alternatecolor">
			<tr>
				<th>No</th>
				<th>Stream</th>
				<th>Priority<br>
					<select id="filterPriority" name="filterPriority" onchange="submit()">
						<c:choose>
  							<c:when test="${priSelected != 'ALL'}">
    							<option>ALL</option>
								<option selected="selected">${priSelected}</option>
  							</c:when>
							<c:otherwise>
    							<option selected="selected">${priSelected}</option>
							</c:otherwise>
						</c:choose>
						
						<c:forEach var="listValue" items="${datos}">
						<option>${listValue.idPrioridad}</option>
						</c:forEach>
					</select>
				</th>
				<th>Project<br>
					<select id="filterProject" name="filterProject" onchange="submit()">
						<c:choose>
  							<c:when test="${proSelected != 'ALL'}">
    							<option>ALL</option>
								<option selected="selected">${proSelected}</option>
  							</c:when>
							<c:otherwise>
    							<option selected="selected">${proSelected}</option>
							</c:otherwise>
						</c:choose>
						
						<c:forEach var="listValue" items="${datos}">
						<option>${listValue.type}</option>
						</c:forEach>
					</select>
				</th>
				<th>Sub Project</th>
				<th>Qty Target</th>
				<th>Qty AoT</th>
				<th>Progress</th>
				<th>Status</th>
				<th>End FC</th>
			</tr>
			<c:forEach var="listValue" items="${datos}">
			<tr>
				<td>${listValue.numberId}</td>
				<td>${listValue.stream}</td>
				<td>${listValue.idPrioridad}</td>
				<td>${listValue.type}</td>
				<td>${listValue.subProject}</td>
				<td>${listValue.qtyTarget}</td>
				<td>${listValue.qtyAoT}</td>
				<td>${listValue.advance}%</td>
				
				<c:if test="${listValue.status eq 'Closed'}">
					<td bgcolor="#0597D2">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'On Track'}">
					<td bgcolor="#32CD32">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'Delayed'}">
					<td bgcolor="FF0000">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'On Risk'}">
					<td bgcolor="#FFD700">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'Canceled'}">
					<td bgcolor="#696969">${listValue.status}</td>
				</c:if>
				
				<td>${listValue.endFC}</td>				
			</tr>
			</c:forEach>
		</table>
		
		</div>		
		</form>	
		
		<!-- Invoke the Pager and pass the values for pagination -->
		<script type="text/javascript">
			var pager = new Pager('alternatecolor', 20);
			pager.init();
			pager.showPageNav('pager', 'NavPosicion');
			pager.showPage(1);
		</script>
		
	</body>
</html>