<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.blockUI.js"></script>
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

	$(document).ready(function() { 
	    $('#demo3').click(function() { 
	        $.blockUI({ css: { 
	            border: 'none', 
	            padding: '15px', 
	      		backgroundColor: '#000', 
	            '-webkit-border-radius': '10px', 
	            '-moz-border-radius': '10px', 
	            opacity: .5, 
	            color: '#fff' 
	        } }); 
	 
	        setTimeout($.unblockUI, 2000); 
	    }); 
	});
}

</script>	
	
	
</head>

<body>
	<%@ include file="header.jsp" %>


	<form name='allProjectsForm' action="<c:url value='allProjectsFilter'/>" method='GET'>
	<div class="container">
		<div id="NavPosicion"></div>
		<table class="altrowstable" id="alternatecolor">
			<tr>
				<td colspan="6" align="center"><h2><a href='download' title="individual">Download data in a Excel File</a></h2></td>
				<td><img src="<c:url value="resources/images/excelLogo.png" />" /></td>
			</tr>
			<tr>
				<th>No</th>
				<th colspan="2">Project</th>
				<th>PM<br>
					<select id="filterPM" name="filterPM" onchange="submit()">
						<c:choose>
  							<c:when test="${pmSelected != 'ALL'}">
    							<option>ALL</option>
								<option selected="selected">${pmSelected}</option>
  							</c:when>
							<c:otherwise>
    							<option selected="selected">${pmSelected}</option>
							</c:otherwise>
						</c:choose>
						
						<c:forEach var="listValue" items="${datos}">
						<option>${listValue.pmName}</option>
						</c:forEach>
					</select>
				</th>	
				<th>DueDate BL</th>
				<th>DueDate FC</th>
				<th>DueDate ACT</th>
			</tr>
			<c:forEach var="listValue" items="${datos}">
			<tr>
				<td>${listValue.numberId}</td>
				<td><a href='individual?idAuth=${listValue.idAuth}&projectName=${listValue.projectName}' title="individual">${listValue.projectName}</a></td>
				<c:if test="${listValue.status eq 'Closed'}">
					<td bgcolor="#0597D2">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'On Track'}">
					<td bgcolor="#32CD32">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'Delayed'}">
					<td bgcolor="#FF0000">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'On Risk'}">
					<td bgcolor="#FFD700">${listValue.status}</td>
				</c:if>
				<c:if test="${listValue.status eq 'Canceled'}">
					<td bgcolor="#696969">${listValue.status}</td>
				</c:if>
				<td>${listValue.pmName}</td>
				<td>${listValue.endBL}</td>
				<td>${listValue.endFC}</td>
				<td>${listValue.endACT}</td>
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
		
	</form>		
	</body>
</html>