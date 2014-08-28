<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<form name='createIssueRiskByProject' action="<c:url value='createIssueRiskByProject'/>" method='GET'>
		<table class="deleteProject">
			<tr>
				<th colspan="4">CREATE ISSUE & RISK</th>
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

	
	 <c:if test="${issueRiskSelectedForCreate}">
	<form name='createIssueRisk' action="<c:url value='createIssueRisk'/>" method='GET'>
		<table class="createProject">
		
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="Description">
        			<input type="text" name="description" id="description" />
    			</p>
   				</td>
   				
   				<td>Action Plan:</td>
    			<td>
    			<p class="actionPlan">
        			<input type="text" name="actionPlan" id="actionPlan" />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>DueDateBL:</td>
    			<td>
    			<p class="dueDateBL">
        			<input type="text" name="dueDateBL" id="dueDateBL" />
    			</p>
   				</td>
   				
   				<td>DueDateFC:</td>
    			<td>
    			<p class="dueDateFC">
        			<input type="text" name="dueDateFC" id="dueDateFC" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>DueDateACT:</td>
    			<td>
    			<p class="dueDateACT">
        			<input type="text" name="dueDateACT" id="dueDateACT" />
    			</p>
   				</td>
   				
    			<td>IssueStatus:</td>
    			<td>
    			<p class="issueStatus">
        			<select id="issueStatus" name="issueStatus">
        				<option>Open</option>
        				<option>Closed</option>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Prioridad:</td>
    			<td>
    			<p class="priority">
        			<input type="text" name="priority" id="priority" />
    			</p>
   				</td>
   				
    			<td>IssueType:</td>
    			<td>
    			<p class="issueType">
        			<select id="issueType" name="issueType">
        				<option>Issue</option>
        				<option>Risk</option>
        			</select>
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateIssueRisk();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  
    </c:if>