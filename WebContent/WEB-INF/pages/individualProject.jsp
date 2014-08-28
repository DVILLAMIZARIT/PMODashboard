 <%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/FusionCharts.js"></script>
	
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
	altRows('alternatecolor2');
	altRows('alternatecolor3');
	altRows('alternatecolor4');
}
</script>		
	
	
</head>

<body>

	<%@ include file="header.jsp" %>

		<table class="milestones4ups" id="table4ups">
			<tr>
				<th colspan="2"><h2>${nameProjectHead}</h2></th>
			</tr>
			<tr>
				<td valign="top"><%@ include file="individualMilestones.jsp" %></td>
				<td valign="top"><%@ include file="individualRiskIssues.jsp" %></td>
			</tr>
			<tr>
				<td valign="top"><%@ include file="individualAccomplishments.jsp" %></td>
				<td valign="top"><%@ include file="individualNextSteps.jsp" %></td>
			</tr>	
			<tr>
				<td valign="top"><input type="hidden" name="Language" value="English"></td>
				<td valign="top"><input type="hidden" name="Language" value="English"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<table id="mini">
						<tr>
							<!-- <td><a href="pid" title="PID">PID</a></td> -->
							<td><a href="timeLine?idAuth=${idAuthProject}&projectName=${nameProjectHead}" title="Timeline">Timeline</a></td>
							<!-- <td><a href="projectPlan" title="Project Plan">Project Plan</a></td> -->
							<!-- <td><a href="governance" title="Governance">Governance</a></td> -->
							<!-- <td><a href="budget" title="Budget">Budget</a></td> -->
							<!-- <td><a href="documents" title="Documents">Documents</a></td> -->
						</tr>
					</table>
				</td>
			</tr>
		</table>

		
	</body>
</html>