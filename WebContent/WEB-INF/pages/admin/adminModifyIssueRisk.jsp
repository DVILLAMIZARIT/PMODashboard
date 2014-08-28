<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getIssueRiskModify' action="<c:url value='getIssueRiskModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY ISSUE & RISK</th>
			</tr>
		
			<tr>
				<td>
				<p class="project">
        			<select id="idAuth" name="idAuth" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listProjects}">
        				<option value='${listValue.idAuth}'>${listValue.projectName}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
				
			</tr>
	</table>	
	</form>	
	
	
	<c:if test="${issueRiskForModifySelected}">
	<form name='getIssueRiskDataByDesc' action="<c:url value='getIssueRiskDataByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idIssueRisk" name="idIssueRisk" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listIssueRiskDescriptions}">
        				<option value='${listValue.idIssueRisk}'>${listValue.issueRiskDescription}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${issueRiskDescSelected}">	
	<form name='updateIssueRisk' action="<c:url value='updateIssueRisk'/>" method='GET'>
		<table class="modifyIssueRisk">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idIssueRisk" name="idIssueRisk" value='${idIssueRisk}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="description" id="description" value='${listValue.issueRiskDescription}' />
    			</p>
   				</td>
   				
   				<td>actionPlan:</td>
    			<td>
    			<p class="actionPlan">
        			<input type="text" name="actionPlan" id="actionPlan" value='${listValue.actionPlan}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>DueDateBL:</td>
    			<td>
    			<p class="dueDateBL">
        			<input type="text" id="dueDateBL" name="dueDateBL" value='${listValue.dueDateBL}'/>
    			</p>
   				</td>
   				
   				<td>DueDateFC:</td>
    			<td>
    			<p class="dueDateFC">
        			<input type="text" id="dueDateFC" name="dueDateFC" value='${listValue.dueDateFC}'/>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>DueDateACT:</td>
    			<td>
    			<p class="DueDateACT">
        			<input type="text" id="dueDateACT" name="dueDateACT" value='${listValue.dueDateACT}'/>
    			</p>
   				</td>
   				
   				<td>IssueStatus:</td>
    			<td>
    			<p class="issueStatus">
        			<select id="issueStatus" name="issueStatus">
        				<option selected="selected">${listValue.issueStatus}</option>
        				<option>Open</option>
        				<option>Closed</option>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Priority:</td>
    			<td>
    			<p class="priority">
        			<input type="text" id="priority" name="priority" value='${listValue.priority}'/>
    			</p>
   				</td>
   				
   				<td>IssueType:</td>
    			<td>
    			<p class="issueType">
        			<select id="issueType" name="issueType">
        				<option selected="selected">${listValue.issueType}</option>
        				<option>Risk</option>
        				<option>Issue</option>
        			</select>
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyIssueRisk();" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>
    
    <c:if test="${throwTimeline}">
    	<table class="milestones4ups" id="table4ups">
    		<tr>
				<td valign="top"><%@ include file="../individualRiskIssues.jsp" %></td>
			</tr>
    	</table>
    </c:if>
    