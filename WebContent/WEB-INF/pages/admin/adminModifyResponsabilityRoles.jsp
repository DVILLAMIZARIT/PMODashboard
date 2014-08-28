<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getResponsabilityRolesModify' action="<c:url value='getResponsabilityRolesModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY RESPONSABILITY ROLES</th>
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
	
	
	<c:if test="${responsabilityRolesForModifySelected}">
	<form name='getResponsabilityRolesDataByDesc' action="<c:url value='getResponsabilityRolesDataByDesc'/>" method='GET'>
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
	
	<c:if test="${responsabilityRolesDescSelected}">	
	<form name='updateResponsabilityRoles' action="<c:url value='updateResponsabilityRoles'/>" method='GET'>
		<table class="modifyResponsabilityRoles">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idRole" name="idRole" value='${idRole}' /></td></tr>
			
    		<tr>
    			<td>Task:</td>
    			<td>
    			<p class="task">
        			<input type="text" name="task" id="task" value='${listValue.task}' />
    			</p>
   				</td>
   				
   				<td>Area:</td>
    			<td>
    			<p class="area">
        			<input type="text" name="area" id="area" value='${listValue.area}' />
    			</p>
   				</td>
   				
    		</tr>
    		
    		<tr>
    			<td>Role:</td>
    			<td>
    			<p class="role">
        			<select id="role" name="role">
        				<option selected="selected">${listValue.role}</option>
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
        			<input type="text" name="clasifica" id="clasifica" value='${listValue.clasifica}' />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyResponsabilityRoles();" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>
    