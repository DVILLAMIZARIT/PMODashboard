<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getProjectDataDelete' action="<c:url value='getProjectDataDelete'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>DELETE PROJECT</th>
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
	
	
	 <c:if test="${projectSelectedForDelete}">	
	<form name='deleteProject' action="<c:url value='deleteProject'/>" method='GET'>
		<table class="deleteProject">	
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			
    		<tr>
    			<td>Project Name:</td>
    			<td>
    			<p class="ProjectName">
        			<input type="text" name="projectName" id="projectName" value='${listValue.projectName}' readonly/>
    			</p>
   				</td>
   				
   				<td>Project Manager:</td>
    			<td>
    			<p class="ProjectManager">
    				<input type="text" name="projectManager" id="projectManager" value='${listValue.idPM}' readonly/>
        			<!-- <option selected="selected" >${pmName}</option> -->
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Owner:</td>
    			<td>
    			<p class="owner">
        			<input type="text" name="owner" id="owner" value='${listValue.owner}' readonly />
    			</p>
   				</td>
   				
   				<td>POI:</td>
    			<td>
    			<p class="poi">
    				<input type="text" name="poi" id="poi" value='${listValue.poi}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Sponsor:</td>
    			<td>
    			<p class="sponsor">
        			<input type="text" name="sponsor" id="sponsor" value='${listValue.sponsor}' readonly />
    			</p>
   				</td>
   				
   				<td>Manager:</td>
    			<td>
    			<p class="manager">
    				<input type="text" name="manager" id="manager" value='${listValue.manager}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Stream:</td>
    			<td>
    			<p class="stream">
        			<input type="text" name="stream" id="stream" value='${listValue.stream}' readonly />
    			</p>
   				</td>
   				
   				<td>Top Project:</td>
    			<td>
    			<p class="topProject">
    				<input type="text" name="topProject" id="topProject" value='${listValue.topProject}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<!-- ACA CAMBIARA -->
    		<tr>
    			<td>BudgetKey:</td>
    			<td>
    			<p class="budgetKey">
        			<input type="text" name="budgetKey" id="budgetKey" value='${listValue.budgetKey}' readonly />
    			</p>
   				</td>
   				
   				<td>Type:</td>
    			<td>
    			<p class="type">
        			<input type="text" name="type" id="type" value='${listValue.type}' readonly />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Status:</td>
    			<td>
    				<input type="text" name="status" id="status" value='${listValue.status}' readonly />
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
    