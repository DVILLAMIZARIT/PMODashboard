<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getWMScheduleDelete' action="<c:url value='getWMScheduleDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE WM SCHEDULE</th>
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
	
	
	<c:if test="${wmscheduleDeleteSelected}">
	<form name='getWMScheduleDelByDesc' action="<c:url value='getWMScheduleDelByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idWM" name="idWM" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listWMScheduleDescriptions}">
        				<option value='${listValue.idWM}'>${listValue.scheduleDesc}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${wmscheduleDescSelectedDel}">	
	<form name='deleteWMSchedule' action="<c:url value='deleteWMSchedule'/>" method='GET'>
		<table class="deleteWMSchedule">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idWM" name="idWM" value='${idWM}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="scheduleDesc" id="scheduleDesc" value='${listValue.scheduleDesc}' readonly />
    			</p>
   				</td>
   				
   				<td>Schedule Date:</td>
    			<td>
    			<p class="scheduleDate">
        			<input type="text" name="scheduleDateRO" id="scheduleDateRO" value='${listValue.scheduleDate}' readonly />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>CR ID:</td>
    			<td>
    			<p class="CR_Id">
        			<input type="text" name="cR_Id" id="cR_Id" value='${listValue.CR_Id}' readonly />
    			</p>
   				</td>
   				
   				<td>Project Manager:</td>
    			<td>
    			<p class="ProjectName">
    				<input type="text" name="idPM" id="idPM" value='${pmName}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Engineering:</td>
    			<td>
    			<p class="dueDateACT">
        			<input type="text" name="engineering" id="engineering" value='${listValue.engineering}' readonly />
    			</p>
   				</td>
   				
    			<td>Operations:</td>
    			<td>
    			<p class="operations">
        			<input type="text" name="operations" id="operations" value='${listValue.operations}' readonly/>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Deployment:</td>
    			<td>
    			<p class="deployment">
        			<input type="text" name="deployment" id="deployment" value='${listValue.deployment}' readonly/>
    			</p>
   				</td>
   				
    			<td>Security:</td>
    			<td>
    			<p class="security">
        			<input type="text" name="security" id="security" value='${listValue.security}' readonly />
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
