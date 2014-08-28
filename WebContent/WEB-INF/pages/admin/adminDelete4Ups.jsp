<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='get4upsDelete' action="<c:url value='get4upsDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE FOURUPS</th>
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
	
	
	<c:if test="${fourupForDeleteSelected}">
	<form name='get4upsDelByDesc' action="<c:url value='get4upsDelByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="id4ups" name="id4ups" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listDescriptions}">
        				<option value='${listValue.id4ups}'>${listValue.description}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${fourupDescSelectedDel}">	
	<form name='delete4ups' action="<c:url value='delete4ups'/>" method='GET'>
		<table class="deleteProject">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="id4ups" name="id4ups" value='${id4ups}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="description" id="description" value='${listValue.description}' readonly/>
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<input type="text" id="type" name="type" value='${listValue.type}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>DateUps:</td>
    			<td>
    			<p class="startBL">
        			<input type="text" id="dateupsRO" name="dateupsRO" value='${listValue.dateUps}' readonly/>
    			</p>
   				</td>
   				
   				<td>Flag:</td>
    			<td>
    			<p class="Flag">
        			<input type="text" id="flag" name="flag" value='${listValue.flag}' readonly/>
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