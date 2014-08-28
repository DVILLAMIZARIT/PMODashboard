<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getCommunicationPlanModify' action="<c:url value='getCommunicationPlanModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY COMMUNICATION PLAN</th>
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
	
	
	<c:if test="${communicationPlanForModifySelected}">
	<form name='getCommunicationPlanDataByDesc' action="<c:url value='getCommunicationPlanDataByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idCommunicationPlan" name="idCommunicationPlan" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listCommunications}">
        				<option value='${listValue.idCommunicationPlan}'>${listValue.communication}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${communicationPlanDescSelected}">	
	<form name='updateCommunicationPlan' action="<c:url value='updateCommunicationPlan'/>" method='GET'>
		<table class="modifyCommunicationPlan">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idCommunicationPlan" name="idCommunicationPlan" value='${idCommunicationPlan}' /></td></tr>
			
    		<tr>
    			<td>Communication:</td>
    			<td>
    			<p class="communication">
        			<input type="text" name="communication" id="communication" value='${listValue.communication}' />
    			</p>
   				</td>
   				
   				<td>Frequency:</td>
    			<td>
    			<p class="frequency">
        			<select id="frequency" name="frequency">
        				<option selected="selected">${listValue.frequency}</option>
        				<option>Once</option>
        				<option>Weekly</option>
        			</select>
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Media:</td>
    			<td>
    			<p class="media">
        			<input type="text" name="media" id="media" value='${listValue.media}' />
    			</p>
   				</td>
   				
   				<td>Audience:</td>
    			<td>
    			<p class="audience">
        			<input type="text" name="audience" id="audience" value='${listValue.audience}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Deliverable:</td>
    			<td>
    			<p class="deliverable">
        			<input type="text" name="deliverable" id="deliverable" value='${listValue.deliverable}' />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyCommunicationPlan();" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>
    