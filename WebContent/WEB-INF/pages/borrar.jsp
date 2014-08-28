<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Prueba de paginador</title>
           
          
<script type="text/javascript" src="resources/js/paging.js"></script>                     

</head>
<body>
 
<h1>PAGINADOR CON JSTL</h1>

<div id="NavPosicion"></div>

<table id="resultados">
	<tr>
		<td>ACA 1</td>
	</tr>	
	<tr>
		<td>ACA 2</td>
	</tr>
	<tr>
		<td>ACA 3</td>
	</tr>
	<tr>
		<td>ACA 4</td>
	</tr>
	<tr>
		<td>ACA 5</td>
	</tr>
	<tr>
		<td>ACA 6</td>
	</tr>
	<tr>
		<td>ACA 7</td>
	</tr>
	<tr>
		<td>ACA 8</td>
	</tr>
	<tr>
		<td>ACA 9</td>
	</tr>
	<tr>
		<td>ACA 10</td>
	</tr>
		<tr>
		<td>ACA 11</td>
	</tr>
	<tr>
		<td>ACA 12</td>
	</tr>
	<tr>
		<td>ACA 13</td>
	</tr>
	<tr>
		<td>ACA 14</td>
	</tr>
	<tr>
		<td>ACA 15</td>
	</tr>
	<tr>
		<td>ACA 16</td>
	</tr>
	<tr>
		<td>ACA 17</td>
	</tr>
	<tr>
		<td>ACA 18</td>
	</tr>
	<tr>
		<td>ACA 19</td>
	</tr>
	<tr>
		<td>ACA 20</td>
	</tr>
		<tr>
		<td>ACA 21</td>
	</tr>
		<tr>
		<td>ACA 22</td>
	</tr>	
</table> 
 
<script type="text/javascript">
var pager = new Pager('resultados', 9);
pager.init();
pager.showPageNav('pager', 'NavPosicion');
pager.showPage(1);
</script>  
 
</body>
</html>