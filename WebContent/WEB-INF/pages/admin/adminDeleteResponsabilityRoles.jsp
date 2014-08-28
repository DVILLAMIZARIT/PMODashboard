<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getResponsabilityRolesDelete' action="<c:url value='getResponsabilityRolesDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE RESPONSABILITY ROLE</th>
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
	
	
	<c:if test="${responsabilityRolesDeleteSelected}">
	<form name='getResponsabilityRolesDelByDesc' action="<c:url value='getResponsabilityRolesDelByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idRole" name="idRole" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listTask}">
        				<option value='${listValue.idRole}'>${listValue.task}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${responsabilityRolesDescSelectedDel}">	
	<form name='deleteResponsabilityRoles' action="<c:url value='deleteResponsabilityRoles'/>" method='GET'>
		<table class="deleteResponsabilityRoles">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idRole" name="idRole" value='${idRole}' /></td></tr>
			
    		<tr>
    			<td>Task:</td>
    			<td>
    			<p class="task">
        			<input type="text" name="task" id="task" value='${listValue.task}' readonly />
    			</p>
   				</td>
   				
   				<td>Area:</td>
    			<td>
    			<p class="area">
        			<input type="text" name="area" id="area" value='${listValue.area}' readonly />
    			</p>
   				</td>
   				
    		</tr>
    		
    		<tr>
    			<td>Role:</td>
    			<td>
    			<p class="role">
    				<input type="text" name="role" id="role" value='${listValue.role}' readonly />
    			</p>
   				</td>
    		
    		
    			<td>Clasifica:</td>
    			<td>
    			<p class="clasifica">
        			<input type="text" name="clasifica" id="clasifica" value='${listValue.clasifica}' readonly />
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