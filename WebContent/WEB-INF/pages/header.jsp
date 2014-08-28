 <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/FusionCharts.js"></script>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
	
	<link rel="stylesheet" href="resources/css/projectPortfolio.css">
	<title>Project Portfolio</title>
</head>

<body>
	
	<div id="upbar">
		<table id="encabezado">
			<tr>
				<td colspan="7"><h1>PMO Dashboard</h1></td>
				
				<td id="searcher">
					<form name='searchForm' action="searchProject" value>
						<input type="search" id="searchingProject" name="searchingProject" onkeydown="if (event.keyCode == 13) onSubmit()" />
						<input type="image" src="<c:url value="resources/images/search.png" />" alt="Submit Form" />
					</form>
				</td>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
				<td id="logout">
					Usuario: ${pageContext.request.userPrincipal.name} |
					<a href="javascript:formSubmit()"> Logout</a>	
				</td>	
				</c:if>
			</tr>
			<tr>
				<td colspan="8" id="principalMenu">
							<ul id="minitabs">			
								<li id="projectAdmin" title="Administration"><a href="admin">Admin</a>
								<!-- 
									<ul>
										<li id="project"><a href="#">Projects</a></li>
										<li id="pm"><a href="#">PMs</a></li>
									</ul>
								-->	
								</li>
								<li><a href="welcome" title="Project Portfolio" >Project Portfolio</a></li>
								<li><a href="top" title="Dashboard">Dashboard</a></li>
								<li><a href="delayed" title="Delayed Projects">Delayed Projects</a></li>
								<li><a href="onRisk" title="On Risk Projects">On Risk Projects</a></li>
								<li><a href="current" title="Current Targets">Current Targets</a></li>
								<li><a href="all" title="All Projects">All Projects</a></li>
								<li><a href="myplanner" title="WM Schedule">WM Schedule</a></li>
							</ul>
				</td>
				<c:set var="pageImage" value='<%=request.getSession().getAttribute("headerImg")%>'></c:set>
				<c:if test="${pageImage eq 'portfolio'}">
					<td id="searcher"><img src="<c:url value="resources/images/Portfolio.png" />" /></td>
				</c:if>
				<c:if test="${pageImage eq 'dashboard'}">
					<td id="searcher"><img src="<c:url value="resources/images/Marker.png" />" /></td>
				</c:if>
				<c:if test="${pageImage eq 'onRisk'}">
					<td id="searcher"><img src="<c:url value="resources/images/OnRiskImg.png" />" /></td>
				</c:if>
				<c:if test="${pageImage eq 'delayed'}">
					<td id="searcher"><img src="<c:url value="resources/images/DelayedImg.png" />" /></td>
				</c:if>
				<c:if test="${pageImage eq 'timeline'}">
					<td id="searcher"><img src="<c:url value="resources/images/Timeline.png" />" /></td>
				</c:if>
				<c:if test="${pageImage eq 'wmschedule'}">
					<td id="searcher"><img src="<c:url value="resources/images/Calendar.png" />" /></td>
				</c:if>
				<c:if test="${pageImage eq 'formulario'}">
					<td id="searcher"><img src="<c:url value="resources/images/formulaire.png" />" /></td>
				</c:if>
				<c:if test="${pageImage eq 'none'}">
					<td id="searcher"></td>
				</c:if>
			</tr>
		</table>	
	</div>
	
	

			<!-- For login user -->
			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}				
			</script>
	
	</body>
</html>