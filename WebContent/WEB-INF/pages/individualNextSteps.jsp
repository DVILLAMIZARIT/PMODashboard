<table class="milestone" id="alternatecolor4">
	<tr>
		<th colspan="2">Next Steps</th>
	</tr>
	<tr>
		<th>Description</th>
		<th>Due Date</th>
	</tr>
	<c:forEach var="listValue" items="${datosN}">
	<tr>
		<td class="big">${listValue.description}</td>
		<td class="small">${listValue.dueDate}</td>
	</tr>
	</c:forEach>
</table>
