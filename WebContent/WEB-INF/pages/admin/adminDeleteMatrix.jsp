<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getMatrixDelete' action="<c:url value='getMatrixDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE MATRIX</th>
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
	
	
	<c:if test="${matrixDeleteSelected}">
	<form name='getMatrixDelByDesc' action="<c:url value='getMatrixDelByDesc'/>" method='GET'>
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
	
	<c:if test="${matrixDescSelectedDel}">	
	<form name='deleteMatrix' action="<c:url value='deleteMatrix'/>" method='GET'>
		<table class="deleteMatrix">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idScalingMatrix" name="idScalingMatrix" value='${idScalingMatrix}' /></td></tr>
			
    		    <tr>
    			<td>Name Team:</td>
    			<td>
    			<p class="nameTeam">
        			<input type="text" name="nameTeam" id="nameTeam" value='${listValue.nameTeam}' readonly />
    			</p>
   				</td>
   				
   				<td>Name TeamPuesto:</td>
    			<td>
    			<p class="nameTeamPuesto">
        			<input type="text" name="nameTeamPuesto" id="nameTeamPuesto" value='${listValue.nameTeamPuesto}' readonly/>
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Support:</td>
    			<td>
    			<p class="support">
        			<input type="text" name="support" id="support" value='${listValue.support}' readonly/>
    			</p>
   				</td>
   				
   				<td>Support Puesto:</td>
    			<td>
    			<p class="supportPuesto">
        			<input type="text" name="supportPuesto" id="supportPuesto" value='${listValue.supportPuesto}' readonly/>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Escalation Level:</td>
    			<td>
    			<p class="escalationLevel">
        			<input type="text" name="escalationLevel" id="escalationLevel" value='${listValue.escalationLevel}' readonly/>
    			</p>
   				</td>
   				
    			<td>Escalation LevelPuesto:</td>
    			<td>
    			<p class="escalationLevelPuesto">
        			<input type="text" name="escalationLevelPuesto" id="escalationLevelPuesto" value='${listValue.escalationLevelPuesto}' readonly/>
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