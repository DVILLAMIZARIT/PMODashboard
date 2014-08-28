<table class="milestone" id="alternatecolor2">
	<tr>
		<th colspan="6">Risk & Issues</th>
	</tr>
	<tr>
		<th>Description</th>
		<th>ActionPlan</th>
		<th>DueDate</th>
		<th>Type</th>
		<th>Status</th>
		<th>Creation</th>
	</tr>
	<c:forEach var="listValue" items="${datosO}">
	<tr>
		<td class="medium">${listValue.issueRiskDescription}</td>
		<td class="small">${listValue.actionPlan}</td>
		<td class="smallest">${listValue.dueDateFC}</td>
		<td class="smallest">${listValue.issueType}</td>
		<td class="smallest">${listValue.status}</td>
		<td class="smallest">${listValue.creationDate}</td>
	</tr>
	</c:forEach>
</table>
