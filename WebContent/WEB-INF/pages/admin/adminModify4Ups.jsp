 <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page session="true"%>	
	
	<form name='get4upModify' action="<c:url value='get4upModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY FOURUPS</th>
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
	
	
	<c:if test="${fourupForModifySelected}">
	<form name='get4upDataByDesc' action="<c:url value='get4upDataByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="id4ups" name="id4ups" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${list4upDescriptions}">
        				<option value='${listValue.id4ups}'>${listValue.description}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${fourupDescSelected}">	
	<form name='update4up' action="<c:url value='update4up'/>" method='GET'>
		<table class="modify4up">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="id4ups" name="id4ups" value='${id4ups}' /></td></tr>
			
    		<tr>
    			<td>Description:</td>
    			<td>
    			<p class="description">
        			<input type="text" name="description" id="description" value='${listValue.description}' />
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<select id="type" name="type">
        				<option selected="selected">${listValue.type}</option>
        				<c:forEach var="listTypes" items="${listTypes}">
        				<option>${listTypes.type}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>DateUps:</td>
    			<td>
    			<p class="dateups">
        			<input type="text" id="dateups" name="dateups" value='${listValue.dateUps}'/>
    			</p>
   				</td>
   				
   				<td>Flag:</td>
    			<td>
    			<p class="flag">
        			<input type="text" id="flag" name="flag" value='${listValue.flag}'/>
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModify4up();" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>
    
    <c:if test="${throwTimeline}">
    	<table class="milestones4ups" id="table4ups">
    		<tr>
				<td valign="top"><%@ include file="../individualAccomplishments.jsp" %></td>
				<td valign="top"><%@ include file="../individualNextSteps.jsp" %></td>
			</tr>
    	</table>
    </c:if>
    