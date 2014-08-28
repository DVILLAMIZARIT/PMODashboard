<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getDashboardModify' action="<c:url value='getDashboardModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY DASHBOARD</th>
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
	
	
	<c:if test="${dashboardForModifySelected}">
	<form name='getDashboardDataByDesc' action="<c:url value='getDashboardDataByDesc'/>" method='GET'>
		<table class="getProject">
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr>
				<td>
				<p class="description">
        			<select id="idDashboard" name="idDashboard" onchange='submit()'>
        				<option selected="selected"> ---- Select ---- </option>
        				<c:forEach var="listValue" items="${listSubProjects}">
        				<option value='${listValue.idDashboard}'>${listValue.subProject}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>
		
	</c:if>
	
	<c:if test="${dashboardDescSelected}">	
	<form name='updateDashboard' action="<c:url value='updateDashboard'/>" method='GET'>
		<table class="modifyDashboard">	
		
			<c:forEach var="listValue" items="${datos}">
			
			<tr><td><input type="hidden" id="idAuth" name="idAuth" value='${idAuth}' /></td></tr>
			<tr><td><input type="hidden" id="idDashboard" name="idDashboard" value='${idDashboard}' /></td></tr>
			
    		<tr>
    			<td>ID Priority:</td>
    			<td>
    			<p class="idPriority">
        			<input type="text" name="idPriority" id="idPriority" value='${listValue.idPriority}' />
    			</p>
   				</td>
   				
   				<td>SubProject:</td>
    			<td>
    			<p class="subProject">
        			<input type="text" name="subProject" id="subProject" value='${listValue.subProject}' />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Item:</td>
    			<td>
    			<p class="item">
        			<input type="text" name="item" id="item" value='${listValue.item}' />
    			</p>
   				</td>
   				
   				<td>Qty Target:</td>
    			<td>
    			<p class="qtyTarget">
        			<input type="text" name="qtyTarget" id="qtyTarget" value='${listValue.qtyTarget}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Qty AoT:</td>
    			<td>
    			<p class="qtyAoT">
        			<input type="text" name="qtyAoT" id="qtyAoT" value='${listValue.qtyAoT}' />
    			</p>
   				</td>
   				
    			<td>Advance:</td>
    			<td>
    			<p class="advance">
        			<input type="text" name="advance" id="advance" value='${listValue.advance}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>   				
    			<td>Status:</td>
    			<td>
    			<p class="status">
        			<select id="status" name="status">
        				<option selected="selected">${listValue.status}</option>
        				<option>On Risk</option>
        				<option>On Going</option>
        				<option>Finished</option>
        				<option>On Hold</option>
        			</select>
    			</p>
   				</td> 				
   				
    			<td>Remarks:</td>
    			<td>
    			<p class="remarks">
        			<input type="text" name="remarks" id="remarks" value='${listValue.remarks}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>   				
    			<td>Historic:</td>
    			<td>
    			<p class="historic">
        			<input type="text" name="historic" id="historic" value='${listValue.historic}' />
    			</p>
   				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Modify" onClick="validateModifyDashboard();" />
    			</p>
    			</td>
   			</tr>	 
   			
   			</c:forEach>
   		</table>
    </form>  
    </c:if>
    