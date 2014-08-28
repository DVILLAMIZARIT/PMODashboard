<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	
	<form name='createProjectsDateByProject' action="<c:url value='createProjectsDateByProject'/>" method='GET'>
		<table class="createProject">
			<tr>
				<th>CREATE PROJECT DATE</th>
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
			
			
	 <c:if test="${projectDateSelectedForCreate}">	
	<form name='createProjectsDate' action="<c:url value='createProjectsDate'/>" method='GET'>
		<table class="deleteProject">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
						
			<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="description" id="description" />
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<select id="type" name="type">
        				<option>Project</option>
        				<option>Group</option>
        				<option>Task</option>
        				<option>Milestone</option>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>IdTask:</td>
    			<td>
    			<p class="idTask">
        			<input type="text" name="idTask" id="idTask" />
    			</p>
   				</td>
   				
   				<td>Predecesor:</td>
    			<td>
    			<p class="predecesor">
        			<input type="text" name="predecesor" id="predecesor" />
    			</p>
   				</td>
    		</tr>
			
			<tr>
    			<td>StartBL:</td>
    			<td>
    			<p class="startBL">
        			<input type="text" name="startBL" id="startBL" />
    			</p>
   				</td>
   				
   				<td>EndBL:</td>
    			<td>
    			<p class="EndBL">
        			<input type="text" name="endBL" id="endBL" />
    			</p>
   				</td>
    		</tr>
			
    		<tr>
    			<td>StartFC:</td>
    			<td>
    			<p class="startFC">
        			<input type="text" name="startFC" id="startFC" />
    			</p>
   				</td>
   				
   				<td>EndFC:</td>
    			<td>
    			<p class="EndFC">
        			<input type="text" name="endFC" id="endFC" />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>StartACT:</td>
    			<td>
    			<p class="startACT">
        			<input type="text" name="startACT" id="startACT" />
    			</p>
   				</td>
   				
   				<td>EndACT:</td>
    			<td>
    			<p class="endACT">
        			<input type="text" name="endACT" id="endACT" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>ResourceName:</td>
    			<td>
    			<p class="resourceName">
        			<input type="text" name="resourceName" id="resourceName" />
    			</p>
   				</td>
   				
   				<td>Advance:</td>
    			<td>
    			<p class="advance">
        			<input type="text" name="advance" id="advance" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Principal:</td>
    			<td>
    			<p class="principal">
        			<input type="text" name="principal" id="principal" />
    			</p>
   				</td>
   				
   				<td>IdGroup:</td>
    			<td>
    			<p class="idGroup">
        			<input type="text" name="idGroup" id="idGroup" />
    			</p>
   				</td>
    		</tr>
			
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateProjectDate();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  
    </c:if>
    
    <c:if test="${throwTimeline}">
    	<%@ include file="../timelineExecute.jsp" %>
    </c:if>