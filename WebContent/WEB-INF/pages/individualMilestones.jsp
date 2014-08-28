<table class="milestone" id="alternatecolor1">
	<tr>
		<th colspan="5">Global Activities (next < 3 months)</th>
	</tr>
	<tr>
		<th>Activity</th>
		<th>Start</th>
		<th>Rev</th>
		<th>End</th>
		<th>Rev</th>
	</tr>
	<c:forEach var="listValue" items="${datosM}">
	<tr>
		<td class="medium">${listValue.projectName}</td>
		<td class="small">${listValue.startFC}</td>
		<td class="small">${listValue.startACT}</td>
		<td class="small">${listValue.endFC}</td>
		<td class="small">${listValue.endACT}</td>
	</tr>
	</c:forEach>
</table>