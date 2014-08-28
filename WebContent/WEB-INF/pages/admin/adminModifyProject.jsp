<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getProjectDataModify' action="<c:url value='getProjectDataModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY PROJECT</th>
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
	
	
	 <c:if test="${projectSelected}">	
	<form name='updateProject' action="<c:url value='updateProject'/>" method='GET'>
		<table class="modifyProject">	
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Project Name:</td>
    			<td>
    			<p class="ProjectName">
        			<input type="text" name="projectName" id="projectName" value='${listValue.projectName}' />
    			</p>
   				</td>
   				
   				<td>Project Manager:</td>
    			<td>
    			<p class="ProjectName">
        			<select id="idPM" name="idPM">
        			
        				<option selected="selected" value='${listValue.idPM}'>${pmName}</option>
        			
        				<c:forEach var="listValuePM" items="${listPM}">
        				<option value='${listValuePM.idPM}'>${listValuePM.pmName}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Owner:</td>
    			<td>
    			<p class="owner">
        			<input type="text" name="owner" id="owner" value='${listValue.owner}' />
    			</p>
   				</td>
   				
   				<td>POI:</td>
    			<td>
    			<p class="poi">
        			<select id="poi" name="poi">
        			
        				<option selected="selected">${listValue.poi}</option>
        				
        				<c:forEach var="listValuePOI" items="${listPOI}">
        				<option>${listValuePOI.poi}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Sponsor:</td>
    			<td>
    			<p class="sponsor">
        			<input type="text" name="sponsor" id="sponsor" value='${listValue.sponsor}' />
    			</p>
   				</td>
   				
   				<td>Manager:</td>
    			<td>
    			<p class="manager">
        			<select id="manager" name="manager">
        			
        				<option selected="selected">${listValue.manager}</option>
        			
        				<c:forEach var="listValueManager" items="${listManager}">
        				<option>${listValueManager.manager}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Stream:</td>
    			<td>
    			<p class="stream">
        			<input type="text" name="stream" id="stream" value='${listValue.stream}' />
    			</p>
   				</td>
   				
   				<td>Top Project:</td>
    			<td>
    			<p class="topProject">
        			<select id="topProject" name="topProject">
        				
        				<option selected="selected">${listValue.topProject}</option>
        			
        				<c:forEach var="listValueTopProject" items="${listTopProject}">
        				<option>${listValueTopProject.topProject}</option>
        				</c:forEach>
        			</select>
    			</p>
   				</td>
    		</tr>
    		
    		<!-- ACA CAMBIARA -->
    		<tr>
    			<td>BudgetKey:</td>
    			<td>
    			<p class="budgetKey">
        			<input type="text" name="budgetKey" id="budgetKey" value='${listValue.budgetKey}' />
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<input type="text" name="type" id="type" value='${listValue.type}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Status:</td>
    			<td>
    			<select id="status" name="status">
    					<option selected>${listValue.status}</option>
        				<c:forEach var="listValueInt" items="${listStatus}">
        				<option>${listValueInt.status}</option>
        				</c:forEach>
        			</select>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyData();" />
    			</p>
    			</td>
   			</tr>	
   			</c:forEach> 
   		</table>
    </form>  
    </c:if>
    