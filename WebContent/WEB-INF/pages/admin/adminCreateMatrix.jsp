<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<form name='createMatrixByProject' action="<c:url value='createMatrixByProject'/>" method='GET'>
		<table class="deleteProject">
			<tr>
				<th colspan="4">CREATE MATRIX</th>
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

	
	 <c:if test="${matrixSelectedForCreate}">
	<form name='createMatrix' action="<c:url value='createMatrix'/>" method='GET'>
		<table class="createProject">
		
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Name Team:</td>
    			<td>
    			<p class="nameTeam">
        			<input type="text" name="nameTeam" id="nameTeam" />
    			</p>
   				</td>
   				
   				<td>Name TeamPuesto:</td>
    			<td>
    			<p class="nameTeamPuesto">
        			<input type="text" name="nameTeamPuesto" id="nameTeamPuesto" />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Support:</td>
    			<td>
    			<p class="support">
        			<input type="text" name="support" id="support" />
    			</p>
   				</td>
   				
   				<td>Support Puesto:</td>
    			<td>
    			<p class="supportPuesto">
        			<input type="text" name="supportPuesto" id="supportPuesto" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Escalation Level:</td>
    			<td>
    			<p class="escalationLevel">
        			<input type="text" name="escalationLevel" id="escalationLevel" />
    			</p>
   				</td>
   				
    			<td>Escalation LevelPuesto:</td>
    			<td>
    			<p class="escalationLevelPuesto">
        			<input type="text" name="escalationLevelPuesto" id="escalationLevelPuesto" />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateMatrix();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  
    </c:if>