<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getProjectsDateModify' action="<c:url value='getProjectsDateModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY PROJECTDATE</th>
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
	
	
	<c:if test="${projectDateForModifySelected}">
	<form name='getProjectsDateDataByDesc' action="<c:url value='getProjectsDateDataByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idDate" name="idDate" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listDescriptions}">
        				<option value='${listValue.idDate}'>${listValue.description}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${projectDateDescSelected}">	
	<form name='updateProjectsDate' action="<c:url value='updateProjectsDate'/>" method='GET'>
		<table class="modifyProject">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idDate" name="idDate" value='${idDate}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="description" id="description" value='${listValue.description}' />
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<select id="type" name="type">
        				<option selected="selected">${listValue.type}</option>
        				<option>Project</option>
        				<option>Group</option>
        				<option>Task</option>
        				<option>Milestone</option>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>StartBL:</td>
    			<td>
    			<p class="startBL">
        			<input type="text" id="startBLRO" name="startBLRO" value='${listValue.startBL}' readonly/>
    			</p>
   				</td>
   				
   				<td>EndBL:</td>
    			<td>
    			<p class="EndBL">
        			<input type="text" id="endBLRO" name="endBLRO" value='${listValue.endBL}' readonly/>
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>StartFC:</td>
    			<td>
    			<p class="startFC">
        			<input type="text" id="startFC" name="startFC" value='${listValue.startFC}' />
    			</p>
   				</td>
   				
   				<td>EndFC:</td>
    			<td>
    			<p class="endFC">
        			<input type="text" id="endFC" name="endFC" value='${listValue.endFC}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>StartACT:</td>
    			<td>
    			<p class="startACT">
        			<input type="text" id="startACT" name="startACT" value='${listValue.startACT}' />
    			</p>
   				</td>
   				
   				<td>EndACT:</td>
    			<td>
    			<p class="endACT">
        			<input type="text" id="endACT" name="endACT" value='${listValue.endACT}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>ID Task:</td>
    			<td>
    			<p class="idTask">
        			<input type="text" name="idTask" id="idTask" value='${listValue.idTask}' />
    			</p>
   				</td>
   				
   				<td>Predecesor:</td>
    			<td>
    			<p class="predecesor">
					<input type="text" name="predecesor" id="predecesor" value='${listValue.predecesor}' />
    			</p>
   				</td>
    		</tr>
			
			<tr>
    			<td>Advance:</td>
    			<td>
    			<p class="advance">
        			<input type="text" name="advance" id="advance" value='${listValue.advance}' />
    			</p>
   				</td>
   				
   				<td>ResourceName:</td>
    			<td>
    			<p class="resourceName">
					<input type="text" name="resourceName" id="resourceName" value='${listValue.resourceName}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Principal:</td>
    			<td>
    			<p class="principal">
        			<input type="text" name="principal" id="principal" value='${listValue.principal}' />
    			</p>
   				</td>
   				
   				<td>IdGroup:</td>
    			<td>
    			<p class="idGroup">
        			<input type="text" name="idGroup" id="idGroup" value='${listValue.idGroup}' />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyProjectDate();" />
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
    