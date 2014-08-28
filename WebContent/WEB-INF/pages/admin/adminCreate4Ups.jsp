<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<form name='create4upByProject' action="<c:url value='create4upByProject'/>" method='GET'>
		<table class="deleteProject">
			<tr>
				<th colspan="4">CREATE FOURUPS</th>
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

	
	 <c:if test="${fourUpSelectedForCreate}">
	<form name='create4up' action="<c:url value='create4up'/>" method='GET'>
		<table class="createProject">
		
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="Description">
        			<input type="text" name="description" id="description" />
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<select id="type" name="type">
        				<c:forEach var="listValue" items="${listTypes}">
        				<option>${listValue.type}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>DateUps:</td>
    			<td>
    			<p class="dateups">
        			<input type="text" name="dateups" id="dateups" />
    			</p>
   				</td>
   				
   				<td>Flag:</td>
    			<td>
    			<p class="poi">
        			<input type="text" name="flag" id="flag" />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreate4up();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  
    </c:if>