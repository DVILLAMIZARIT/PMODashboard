<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<form name='createResponsabilityRolesByProject' action="<c:url value='createResponsabilityRolesByProject'/>" method='GET'>
		<table class="deleteProject">
			<tr>
				<th colspan="4">CREATE RESPONSABILITY ROLES</th>
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

	
	 <c:if test="${responsabilityRolesSelectedForCreate}">
	<form name='createResponsabilityRoles' action="<c:url value='createResponsabilityRoles'/>" method='GET'>
		<table class="createProject">
		
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Task:</td>
    			<td>
    			<p class="task">
        			<input type="text" name="task" id="task" />
    			</p>
   				</td>
   				
   				<td>Area:</td>
    			<td>
    			<p class="area">
        			<input type="text" name="area" id="area" />
    			</p>
   				</td>
   				
    		</tr>
    		
    		<tr>
    			<td>Role:</td>
    			<td>
    			<p class="role">
        			<select id="role" name="role">
        				<option>R</option>
        				<option>I</option>
        				<option>C</option>
        				<option>A</option>
        			</select>
    			</p>
   				</td>
    		
    		
    			<td>Clasifica:</td>
    			<td>
    			<p class="clasifica">
        			<input type="text" name="clasifica" id="clasifica" />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateResponsabilityRoles();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  
    </c:if>