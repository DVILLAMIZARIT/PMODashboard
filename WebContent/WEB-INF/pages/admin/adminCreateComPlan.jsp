<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<form name='createCommunicationPlanByProject' action="<c:url value='createCommunicationPlanByProject'/>" method='GET'>
		<table class="deleteProject">
			<tr>
				<th colspan="4">CREATE COMMUNICATION PLAN</th>
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

	
	 <c:if test="${communicationPlanSelectedForCreate}">
	<form name='createCommunicationPlan' action="<c:url value='createCommunicationPlan'/>" method='GET'>
		<table class="createProject">
		
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Communication:</td>
    			<td>
    			<p class="communication">
        			<input type="text" name="communication" id="communication" />
    			</p>
   				</td>
   				
   				<td>Frequency:</td>
    			<td>
    			<p class="frequency">
        			<select id="frequency" name="frequency">
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
        			<input type="text" name="media" id="media" />
    			</p>
   				</td>
   				
   				<td>Audience:</td>
    			<td>
    			<p class="audience">
        			<input type="text" name="audience" id="audience" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Deliverable:</td>
    			<td>
    			<p class="deliverable">
        			<input type="text" name="deliverable" id="deliverable" />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateCommunicationPlan();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  
    </c:if>