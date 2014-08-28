<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<form name='createWMScheduleByProject' action="<c:url value='createWMScheduleByProject'/>" method='GET'>
		<table class="deleteProject">
			<tr>
				<th colspan="4">CREATE WMSCHEDULE</th>
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

	
	 <c:if test="${wmscheduleSelectedForCreate}">
	<form name='createWMSchedule' action="<c:url value='createWMSchedule'/>" method='GET'>
		<table class="createProject">
		
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="Description">
        			<input type="text" name="scheduleDesc" id="scheduleDesc" />
    			</p>
   				</td>
   				
   				<td>Schedule Date:</td>
    			<td>
    			<p class="scheduleDate">
        			<input type="text" name="scheduleDate" id="scheduleDate" />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>CR ID:</td>
    			<td>
    			<p class="CR_Id">
        			<input type="text" name="cR_Id" id="cR_Id" />
    			</p>
   				</td>
   				
   				<td>Project Manager:</td>
    			<td>
    			<p class="ProjectName">
        			<select id="idPM" name="idPM">
        				<c:forEach var="listValue" items="${listPM}">
        				<option value='${listValue.idPM}'>${listValue.pmName}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Engineering:</td>
    			<td>
    			<p class="dueDateACT">
        			<input type="text" name="engineering" id="engineering" />
    			</p>
   				</td>
   				
    			<td>Operations:</td>
    			<td>
    			<p class="operations">
        			<input type="text" name="operations" id="operations" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Deployment:</td>
    			<td>
    			<p class="priority">
        			<input type="text" name="deployment" id="deployment" />
    			</p>
   				</td>
   				
    			<td>Security:</td>
    			<td>
    			<p class="security">
        			<input type="text" name="security" id="security" />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateWMSchedule();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  
    </c:if>