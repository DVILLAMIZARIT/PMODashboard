<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@page session="true"%>	
	
	<form name='getUserModify' action="<c:url value='getUserModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY USER</th>
			</tr>
		
			<security:authorize ifAnyGranted="ROLE_ADMIN">
			<tr>
				<td>
				<p class="project">
        			<select id="username" name="username" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listUsers}">
        				<option>${listValue.username}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>	
			</tr>
			</security:authorize>
							

			<security:authorize ifNotGranted="ROLE_ADMIN">	
			<tr>
				<td>
				<p class="project">
					<input type="text" name="username" id="username" value='${pageContext.request.userPrincipal.name}' readonly />
				</p>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Modify" /></td>
			</tr>
			</security:authorize>
	</table>	
	</form>	
	
	
	<c:if test="${userSelected}">	
	<form name='updateUser' action="<c:url value='updateUser'/>" method='GET'>
		<table class="modifyUser">	
		
			<c:forEach var="listValue" items="${datos}">
			
    		<tr>
    			<td>Username:</td>
    			<td>
    			<p class="username">
        			<input type="text" name="username" id="username" value='${listValue.username}' readonly />
    			</p>
   				</td>
   				
   				<td>Password:</td>
    			<td>
    			<p class="password">
        			<input type="password" name="password" id="password" value='${listValue.password}' />
    			</p>
   				</td>
    		</tr>
    		
    		<security:authorize ifAnyGranted="ROLE_ADMIN">
    		<tr>
    			<td>ROLE:</td>
    			<td>
    			<p class="role">
        			<select id="role" name="role">
        				<option selected="selected">${listValue.role}</option>
        				<option>ROLE_USER</option>
        				<option>ROLE_ADMIN</option>
        			</select>
    			</p>
   				</td>
    		</tr>
    		</security:authorize>
    		
    		
    		<security:authorize ifNotGranted="ROLE_ADMIN">
    		<tr>
    			<td>ROLE:</td>
    			<td>
    			<p class="role">
					<input type="text" name="role" id="role" value='${listValue.role}' readonly />
    			</p>
   				</td>
    		</tr>
    		</security:authorize>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyUser();" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>