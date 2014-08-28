<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getProjectsDateDelete' action="<c:url value='getProjectsDateDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE PROJECTDATE</th>
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
	
	
	<c:if test="${projectDateForDeleteSelected}">
	<form name='getProjectsDateDataDelByDesc' action="<c:url value='getProjectsDateDataDelByDesc'/>" method='GET'>
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
	
	<c:if test="${projectDateDescSelectedDel}">	
	<form name='deleteProjectsDate' action="<c:url value='deleteProjectsDate'/>" method='GET'>
		<table class="deleteProject">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idDate" name="idDate" value='${idDate}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="description" id="description" value='${listValue.description}' readonly/>
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<input type="text" id="type" name="type" value='${listValue.type}' readonly />
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
        			<input type="text" id="startFCRO" name="startFCRO" value='${listValue.startFC}' readonly/>
    			</p>
   				</td>
   				
   				<td>EndFC:</td>
    			<td>
    			<p class="EndFC">
        			<input type="text" id="endFCRO" name="endFCRO" value='${listValue.endFC}' readonly/>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>StartACT:</td>
    			<td>
    			<p class="startACT">
        			<input type="text" id="startACTRO" name="startACTRO" value='${listValue.startACT}' readonly/>
    			</p>
   				</td>
   				
   				<td>EndACT:</td>
    			<td>
    			<p class="EndACT">
        			<input type="text" id="endACTRO" name="endACTRO" value='${listValue.endACT}' readonly/>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>ID Task:</td>
    			<td>
    			<p class="idTask">
        			<input type="text" name="idTask" id="idTask" value='${listValue.idTask}' readonly/>
    			</p>
   				</td>
   				
   				<td>Predecesor:</td>
    			<td>
    			<p class="predecesor">
					<input type="text" name="predecesor" id="predecesor" value='${listValue.predecesor}' readonly/>
    			</p>
   				</td>
    		</tr>
			
			<tr>
    			<td>Advance:</td>
    			<td>
    			<p class="advance">
        			<input type="text" name="advance" id="advance" value='${listValue.advance}' readonly/>
    			</p>
   				</td>
   				
   				<td>ResourceName:</td>
    			<td>
    			<p class="resource">
					<input type="text" name="resourceName" id="resourceName" value='${listValue.resourceName}' readonly/>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Principal:</td>
    			<td>
    			<p class="principal">
        			<input type="text" name="principal" id="principal" value='${listValue.principal}' readonly/>
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