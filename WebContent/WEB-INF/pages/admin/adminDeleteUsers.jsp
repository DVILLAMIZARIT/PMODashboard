<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getUserDelete' action="<c:url value='getUserDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE USER</th>
			</tr>
		
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
	</table>	
	</form>	

	
	<c:if test="${userDescSelectedDel}">	
	<form name='deleteUser' action="<c:url value='deleteUser'/>" method='GET'>
		<table class="deleteIssueRisk">	
		
			<c:forEach var="listValue" items="${datos}">
			
    		<tr>
    			<td>Username:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="username" id="username" value='${listValue.username}' readonly/>
    			</p>
   				</td>
   				
   				<td>Password:</td>
    			<td>
    			<p class="type">
        			<input type="password" id="password" name="password" value='${listValue.password}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>ROLE:</td>
    			<td>
    			<p class="role">
        			<input type="text" id="role" name="role" value='${listValue.role}' readonly/>
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