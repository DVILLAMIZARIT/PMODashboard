 <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@page session="true"%>
<html>

<head>
	<title>Project Portfolio</title>

	<link rel="stylesheet" href="resources/css/projectPortfolio.css">
	<link rel="stylesheet" href="resources/css/forms.css">
	<link rel="stylesheet" href="resources/css/jquery-ui.css">
	
	<script type="text/javascript" src="resources/js/validateDataProjects.js"></script>		
	<script type="text/javascript" src="resources/js/validateDataProjectsDate.js"></script>	
	<script type="text/javascript" src="resources/js/validateDataPM.js"></script>	
	<script type="text/javascript" src="resources/js/validateData4Ups.js"></script>
	<script type="text/javascript" src="resources/js/validateDataIssueRisk.js"></script>
	<script type="text/javascript" src="resources/js/validateDataDashboard.js"></script>
	<script type="text/javascript" src="resources/js/validateDataMatrix.js"></script>
	<script type="text/javascript" src="resources/js/validateDataWMSchedule.js"></script>
	<script type="text/javascript" src="resources/js/validateDataCommunicationPlan.js"></script>
	<script type="text/javascript" src="resources/js/validateDataResponsabilityRoles.js"></script>
	<script type="text/javascript" src="resources/js/validateDataUser.js"></script>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="resources/js/FusionCharts.js"></script>
	
	<script>
	$(function() {
		//Projects
		 $( "#startBL" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
		 $( "#endBL" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
		 $( "#startFC" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
		 $( "#endFC" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
		 $( "#startACT" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
		 $( "#endACT" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();

		 //4UPS
		 $( "#dateups" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();

		 //IssueRisk
		 $( "#dueDateBL" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
		 $( "#dueDateFC" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
		 $( "#dueDateACT" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();

		//WMSchedule
		 $( "#scheduleDate" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
	});
	</script>	
	
</head>

<body>

	<%@ include file="../header.jsp" %>
	
	<div class="container">	
	<form name='admin' action="<c:url value='admin'/>" method='GET'>
		<table>
			<tr>
				<td id="adminLabel"><label for="name">Administration</label></td>
			</tr>
			<tr>
				<td>
				<p class="adminSelect">
					<label>
					<span class="custom-dropdown custom-dropdown--white">
        			<select id="admin" name="admin" onchange="submit()">
        				<option selected="selected"> ---- Select ---- </option>
        				<security:authorize ifAnyGranted="ROLE_ADMIN">
        				<option>Create Project</option>
  						<option>Modify Project</option>
  						<option>Delete Project</option>
  						<option disabled>──────────────────────────────────────────</option>
  						</security:authorize>
  						<option>Create ProjectsDate</option>
  						<option>Modify ProjectsDate</option>
  						<option>Delete ProjectsDate</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create FourUp</option>
  						<option>Modify FourUp</option>
  						<option>Delete FourUp</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create IssueRisk</option>
  						<option>Modify IssueRisk</option>
  						<option>Delete IssueRisk</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create Dashboard</option>
  						<option>Modify Dashboard</option>
  						<option>Delete Dashboard</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create Matrix</option>
  						<option>Modify Matrix</option>
  						<option>Delete Matrix</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create WMSchedule</option>
  						<option>Modify WMSchedule</option>
  						<option>Delete WMSchedule</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create CommunicationPlan</option>
  						<option>Modify CommunicationPlan</option>
  						<option>Delete CommunicationPlan</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create ResponsabilityRoles</option>
  						<option>Modify ResponsabilityRoles</option>
  						<option>Delete ResponsabilityRoles</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<security:authorize ifAnyGranted="ROLE_ADMIN">
  						<option>Create Project Manager</option>
  						<option>Modify Project Manager</option>
  						<option>Delete Project Manager</option>
  						<option disabled>──────────────────────────────────────────</option>
  						<option>Create User</option>
  						</security:authorize>
  						
  						<option>Modify User</option>
  						
  						<security:authorize ifAnyGranted="ROLE_ADMIN">
  						<option>Delete User</option>
  						</security:authorize>
        			</select>
        			</span>
        			</label>
    			</p>
				</td>
			</tr>
    	</table>
    </form>
    
    <br><br>
    
    <!-- Projects -->
    <c:if test="${createProjectSelected}">
   		<%@ include file="adminCreateProject.jsp" %>
    </c:if>
    
    <c:if test="${modifyProjectSelected}">
   		<%@ include file="adminModifyProject.jsp" %> 
    </c:if>
    
    <c:if test="${deleteProjectSelected}">
   		<%@ include file="adminDeleteProject.jsp" %> 
    </c:if>
    
    
    <!-- ProjectsDate -->
    <c:if test="${createProjectsDateSelected}">
   		<%@ include file="adminCreateProjectsDate.jsp" %>
    </c:if>
    
    <c:if test="${modifyProjectsDateSelected}">
   		<%@ include file="adminModifyProjectsDate.jsp" %> 
    </c:if>
    
    <c:if test="${deleteProjectsDateSelected}">
   		<%@ include file="adminDeleteProjectsDate.jsp" %> 
    </c:if>
    
    
    <!-- 4Ups -->
    <c:if test="${create4upSelected}">
   		<%@ include file="adminCreate4Ups.jsp" %>
    </c:if>
    
    <c:if test="${modify4upSelected}">
   		<%@ include file="adminModify4Ups.jsp" %> 
    </c:if>
    
    <c:if test="${delete4upSelected}">
   		<%@ include file="adminDelete4Ups.jsp" %> 
    </c:if>
    
    
    <!-- IssueRisk -->
    <c:if test="${createIssueRiskSelected}">
   		<%@ include file="adminCreateIssueRisk.jsp" %>
    </c:if>
    
    <c:if test="${modifyIssueRiskSelected}">
   		<%@ include file="adminModifyIssueRisk.jsp" %> 
    </c:if>
    
    <c:if test="${deleteIssueRiskSelected}">
   		<%@ include file="adminDeleteIssueRisk.jsp" %> 
    </c:if>
    
    
    <!-- Dashboard -->
    <c:if test="${createDashboardSelected}">
   		<%@ include file="adminCreateDashboard.jsp" %>
    </c:if>
    
    <c:if test="${modifyDashboardSelected}">
   		<%@ include file="adminModifyDashboard.jsp" %> 
    </c:if>
    
    <c:if test="${deleteDashboardSelected}">
   		<%@ include file="adminDeleteDashboard.jsp" %> 
    </c:if>
    
    
    <!-- Matrix -->
    <c:if test="${createMatrixSelected}">
   		<%@ include file="adminCreateMatrix.jsp" %>
    </c:if>
    
    <c:if test="${modifyMatrixSelected}">
   		<%@ include file="adminModifyMatrix.jsp" %> 
    </c:if>
    
    <c:if test="${deleteMatrixSelected}">
   		<%@ include file="adminDeleteMatrix.jsp" %> 
    </c:if>


    <!-- WMSchedule -->
    <c:if test="${createWMScheduleSelected}">
   		<%@ include file="adminCreateWMSchedule.jsp" %>
    </c:if>
    
    <c:if test="${modifyWMScheduleSelected}">
   		<%@ include file="adminModifyWMSchedule.jsp" %> 
    </c:if>
    
    <c:if test="${deleteWMScheduleSelected}">
   		<%@ include file="adminDeleteWMSchedule.jsp" %> 
    </c:if>
    
    
    
    <!-- CommunicationPlan -->
    <c:if test="${createCommunicationPlanSelected}">
   		<%@ include file="adminCreateComPlan.jsp" %>
    </c:if>
    
    <c:if test="${modifyCommunicationPlanSelected}">
   		<%@ include file="adminModifyComPlan.jsp" %> 
    </c:if>
    
    <c:if test="${deleteCommunicationPlanSelected}">
   		<%@ include file="adminDeleteComPlan.jsp" %> 
    </c:if>
    
    
    
    <!-- ResponsabilityRoles -->
    <c:if test="${createResponsabilityRolesSelected}">
   		<%@ include file="adminCreateResponsabilityRoles.jsp" %>
    </c:if>
    
    <c:if test="${modifyResponsabilityRolesSelected}">
   		<%@ include file="adminModifyResponsabilityRoles.jsp" %> 
    </c:if>
    
    <c:if test="${deleteResponsabilityRolesSelected}">
   		<%@ include file="adminDeleteResponsabilityRoles.jsp" %> 
    </c:if>
    
    
    <!-- ProjectsManager -->
    <c:if test="${createProjectManagerSelected}">
   		<%@ include file="adminCreatePM.jsp" %>
    </c:if>
    
    <c:if test="${modifyProjectManagerSelected}">
   		<%@ include file="adminModifyPM.jsp" %> 
    </c:if>
    
    <c:if test="${deleteProjectManagerSelected}">
   		<%@ include file="adminDeletePM.jsp" %> 
    </c:if>


    <!-- Users -->
    <c:if test="${createUserSelected}">
   		<%@ include file="adminCreateUsers.jsp" %>
    </c:if>
    
    <c:if test="${modifyUserSelected}">
   		<%@ include file="adminModifyUsers.jsp" %> 
    </c:if>
    
    <c:if test="${deleteUserSelected}">
   		<%@ include file="adminDeleteUsers.jsp" %> 
    </c:if>


    
    
    <!-- VALIDATIONS -->
    <c:if test="${projectCreated}">
    	<div>
    		El Proyecto ${idAuth} - ${projectName}, se ha CREADO satisfactoriamente
    	</div>
    </c:if>
    
    <c:if test="${projectUpdated}">
    	<div>
    		Proyecto ${idAuth} - ${projectName}, se ha ACTUALIZADO satisfactoriamente
    	</div>
    </c:if>
    
    
    <c:if test="${projectDeleted}">
    	<div>
    		Proyecto ${idAuth} - ${projectName}, se ha ELIMINADO satisfactoriamente
    	</div>
    </c:if>



    <c:if test="${projectDateCreated}">
    	<div>
    		Proyect Date ${description} CREADO satisfactoriamente
    	</div>
    </c:if>

    <c:if test="${projectDateUpdated}">
    	<div>
    		Proyect Date ${description} MODIFICADO satisfactoriamente
    	</div>
    </c:if>
    
    <c:if test="${projectDateDeleted}">
    	<div>
    		Proyect Date ${description} ELIMINADO satisfactoriamente
    	</div>
    </c:if>



    <c:if test="${pmCreated}">
    	<div>
    		Proyect Manager ${pmName} CREADO satisfactoriamente
    	</div>
    </c:if>

	<c:if test="${pmUpdated}">
    	<div>
    		Proyect Manager ${pmName} MODIFICADO satisfactoriamente
    	</div>
    </c:if>
    
    <c:if test="${pmDeleted}">
    	<div>
    		Proyect Manager ${pmName} ELIMINADO satisfactoriamente
    	</div>
    </c:if>
    
	</div>
</body>
</html>