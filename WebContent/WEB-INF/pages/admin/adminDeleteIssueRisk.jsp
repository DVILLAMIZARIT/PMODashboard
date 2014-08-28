<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getIssueRiskDelete' action="<c:url value='getIssueRiskDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE ISSUE & RISK</th>
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
	
	
	<c:if test="${issueRiskDeleteSelected}">
	<form name='getIssueRiskDelByDesc' action="<c:url value='getIssueRiskDelByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idIssueRisk" name="idIssueRisk" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listDescriptions}">
        				<option value='${listValue.idIssueRisk}'>${listValue.issueRiskDescription}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${issueRiskDescSelectedDel}">	
	<form name='deleteIssueRisk' action="<c:url value='deleteIssueRisk'/>" method='GET'>
		<table class="deleteIssueRisk">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idIssueRisk" name="idIssueRisk" value='${idIssueRisk}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="description" id="description" value='${listValue.issueRiskDescription}' readonly/>
    			</p>
   				</td>
   				
   				<td>ActionPlan:</td>
    			<td>
    			<p class="type">
        			<input type="text" id="actionPlan" name="actionPlan" value='${listValue.actionPlan}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>DueDateBL:</td>
    			<td>
    			<p class="dueDateBL">
        			<input type="text" id="dueDateBLRO" name="dueDateBLRO" value='${listValue.dueDateBL}' readonly/>
    			</p>
   				</td>
   				
   				<td>DueDateFC:</td>
    			<td>
    			<p class="dueDateFC">
        			<input type="text" id="dueDateFCRO" name="dueDateFCRO" value='${listValue.dueDateFC}' readonly/>
    			</p>
   				</td>
    		</tr>
   			
   			<tr>
    			<td>DueDateACT:</td>
    			<td>
    			<p class="dueDateACT">
        			<input type="text" id="dueDateACTRO" name="dueDateACTRO" value='${listValue.dueDateACT}' readonly/>
    			</p>
   				</td>
   				
   				<td>IssueStatus:</td>
    			<td>
    			<p class="issueStatus">
        			<input type="text" id="issueStatus" name="issueStatus" value='${listValue.issueStatus}' readonly/>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Priority:</td>
    			<td>
    			<p class="priority">
        			<input type="text" id="priority" name="priority" value='${listValue.priority}' readonly/>
    			</p>
   				</td>
   				
   				<td>IssueType:</td>
    			<td>
    			<p class="issueType">
        			<input type="text" id="issueType" name="issueType" value='${listValue.issueType}' readonly/>
    			</p>
   				</td>
    		</tr>
   			
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="submit" value="Delete" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>
    
    <c:if test="${throwTimeline}">
    	<%@ include file="../timelineExecute.jsp" %>
    </c:if>