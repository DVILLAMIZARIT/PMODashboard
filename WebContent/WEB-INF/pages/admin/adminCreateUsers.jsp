<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	
	<form name='createUser' action="<c:url value='createUser'/>" method='GET'>
		<table class="createProject">
			<tr>
				<th colspan="4">CREATE USER</th>
			</tr>
		
    		<tr>
    			<td>Username:</td>
    			<td>
    			<p class="username">
        			<input type="text" name="username" id="username" />
    			</p>
   				</td>
   				
   				<td>Password:</td>
    			<td>
    			<p class="password">
        			<input type="password" name="password" id="password" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>ROLE:</td>
    			<td>
    			<p class="role">
        			<select id="role" name="role">
        				<option>ROLE_USER</option>
        				<option>ROLE_ADMIN</option>
        			</select>
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateUser();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  