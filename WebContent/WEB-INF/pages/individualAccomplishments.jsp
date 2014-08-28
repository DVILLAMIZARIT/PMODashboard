
<table class="milestone" id="alternatecolor3">
	<tr>
		<th colspan="2">Accomplishments</th>
	</tr>
	<tr>
		<th>Description</th>
		<th>Due Date</th>
	</tr>
	<c:forEach var="listValue" items="${datosA}">
	<tr>
		<td class="big">${listValue.description}</td>
		<td class="small">${listValue.dueDate}</td>
	</tr>
	</c:forEach>
</table>
