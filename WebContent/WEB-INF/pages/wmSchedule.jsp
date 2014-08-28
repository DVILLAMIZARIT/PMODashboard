<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/FusionCharts.js"></script>
	
	<script type="text/javascript" src="resources/js/dhtmlxcommon.js"></script>
	<script type="text/javascript" src="resources/js/dhtmlxgrid.js"></script>
	<script type="text/javascript" src="resources/js/dhtmlxgridcell.js"></script>
	<script type="text/javascript" src="resources/js/dashboardGrids.js"></script>
	
	<link rel="stylesheet" href="resources/css/projects.css">
	<link rel="stylesheet" href="resources/css/dhtmlxgrid.css">
	<title>Project Portfolio</title>
</head>

<body onload="doInitGrid()">

	<%@ include file="header.jsp" %>

		<div id="mygrid_container" style="width:600px;height:150px;"></div>		
</body>
</html>