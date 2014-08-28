<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getCommunicationPlanDelete' action="<c:url value='getCommunicationPlanDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE COMMUNICATION PLAN</th>
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
	
	
	<c:if test="${communicationPlanDeleteSelected}">
	<form name='getCommunicationPlanDelByDesc' action="<c:url value='getCommunicationPlanDelByDesc'/>" method='GET'>
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
	
	<c:if test="${communicationPlanDescSelectedDel}">	
	<form name='deleteCommunicationPlan' action="<c:url value='deleteCommunicationPlan'/>" method='GET'>
		<table class="deleteCommunicationPlan">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idCommunicationPlan" name="idCommunicationPlan" value='${idCommunicationPlan}' /></td></tr>
			
<tr>
    			<td>Communication:</td>
    			<td>
    			<p class="communication">
        			<input type="text" name="communication" id="communication" value='${listValue.communication}' readonly />
    			</p>
   				</td>
   				
   				<td>Frequency:</td>
    			<td>
    			<p class="frequency">	
        			<input type="text" id="frequency" name="frequency" value='${listValue.frequency}' readonly />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Media:</td>
    			<td>
    			<p class="media">
        			<input type="text" name="media" id="media" value='${listValue.media}' readonly />
    			</p>
   				</td>
   				
   				<td>Audience:</td>
    			<td>
    			<p class="audience">
        			<input type="text" name="audience" id="audience" value='${listValue.audience}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Deliverable:</td>
    			<td>
    			<p class="deliverable">
        			<input type="text" name="deliverable" id="deliverable" value='${listValue.deliverable}' readonly />
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