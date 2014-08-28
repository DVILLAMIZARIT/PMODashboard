<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	
	<form name='createProject' action="<c:url value='createProject'/>" method='GET'>
		<table class="createProject">
			<tr>
				<th colspan="4">CREATE PROJECT</th>
			</tr>
    		<tr>
    			<td>Project Name:</td>
    			<td>
    			<p class="ProjectName">
        			<input type="text" name="projectName" id="projectName" />
    			</p>
   				</td>
   				
   				<td>Project Manager:</td>
    			<td>
    			<p class="ProjectName">
        			<select id="admin" name="idPM">
        				<c:forEach var="listValue" items="${listPM}">
        				<option value='${listValue.idPM}'>${listValue.pmName}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Owner:</td>
    			<td>
    			<p class="owner">
        			<input type="text" name="owner" id="owner" />
    			</p>
   				</td>
   				
   				<td>POI:</td>
    			<td>
    			<p class="poi">
        			<select id="admin" name="poi">
        				<c:forEach var="listValue" items="${listPOI}">
        				<option>${listValue.poi}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Sponsor:</td>
    			<td>
    			<p class="sponsor">
        			<input type="text" name="sponsor" id="sponsor" />
    			</p>
   				</td>
   				
   				<td>Manager:</td>
    			<td>
    			<p class="manager">
        			<select id="admin" name="manager">
        				<c:forEach var="listValue" items="${listManager}">
        				<option>${listValue.manager}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Stream:</td>
    			<td>
    			<p class="stream">
        			<input type="text" name="stream" id="stream" />
    			</p>
   				</td>
   				
   				<td>Top Project:</td>
    			<td>
    			<p class="topProject">
        			<select id="admin" name="topProject">
        				<c:forEach var="listValue" items="${listTopProject}">
        				<option>${listValue.topProject}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
			
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validateCreateData();" />
    			</p>
    			</td>
   			</tr>	 
   		</table>
    </form>  