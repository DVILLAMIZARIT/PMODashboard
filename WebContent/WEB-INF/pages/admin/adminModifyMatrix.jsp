<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getMatrixModify' action="<c:url value='getMatrixModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY MATRIX</th>
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
	
	
	<c:if test="${matrixForModifySelected}">
	<form name='getMatrixDataByDesc' action="<c:url value='getMatrixDataByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idScalingMatrix" name="idScalingMatrix" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${getListNameTeam}">
        				<option value='${listValue.idScalingMatrix}'>${listValue.nameTeam}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${matrixDescSelected}">	
	<form name='updateMatrix' action="<c:url value='updateMatrix'/>" method='GET'>
		<table class="modifyMatrix">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idScalingMatrix" name="idScalingMatrix" value='${idScalingMatrix}' /></td></tr>
			
    		<tr>
    			<td>Name Team:</td>
    			<td>
    			<p class="nameTeam">
        			<input type="text" name="nameTeam" id="nameTeam" value='${listValue.nameTeam}' />
    			</p>
   				</td>
   				
   				<td>Name TeamPuesto:</td>
    			<td>
    			<p class="nameTeamPuesto">
        			<input type="text" name="nameTeamPuesto" id="nameTeamPuesto" value='${listValue.nameTeamPuesto}' />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Support:</td>
    			<td>
    			<p class="support">
        			<input type="text" name="support" id="support" value='${listValue.support}' />
    			</p>
   				</td>
   				
   				<td>Support Puesto:</td>
    			<td>
    			<p class="supportPuesto">
        			<input type="text" name="supportPuesto" id="supportPuesto" value='${listValue.supportPuesto}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Escalation Level:</td>
    			<td>
    			<p class="escalationLevel">
        			<input type="text" name="escalationLevel" id="escalationLevel" value='${listValue.escalationLevel}' />
    			</p>
   				</td>
   				
    			<td>Escalation LevelPuesto:</td>
    			<td>
    			<p class="escalationLevelPuesto">
        			<input type="text" name="escalationLevelPuesto" id="escalationLevelPuesto" value='${listValue.escalationLevelPuesto}' />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyMatrix();" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>
    