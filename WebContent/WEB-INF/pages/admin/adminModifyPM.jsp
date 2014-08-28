<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>	
	
	<form name='getPMModify' action="<c:url value='getPMModify'/>" method='GET'>
		<table class="getProject">
			<tr>
				<th>MODIFY PROJECT MANAGER</th>
			</tr>
		
			<tr>
				<td>
				<p class="project">
        			<select id="idPM" name="idPM" onchange='submit()'>
        				<c:forEach var="listValue" items="${listPMs}">
        				<option value='${listValue.idPM}'>${listValue.pmName}</option>
        				</c:forEach>
        			</select>
    			</p>
				</td>
			</tr>
	</table>	
	</form>	
	
	
	 <c:if test="${pmSelected}">	
	<form name='updatePM' action="<c:url value='updatePM'/>" method='GET'>
		<table class="modifyProject">	
			<c:forEach var="listValue" items="${datos}">
			
			<input type="hidden" id="idPM" name="idPM" value='${idPM}' />
			
    		<tr>
    			<td>pmName:</td>
    			<td>
    			<p class="pmName">
        			<input type="text" name="pmName" id="pmName" value='${listValue.pmName}' />
    			</p>
   				</td>
   				
   				<td>radio:</td>
    			<td>
    			<p class="type">
        			<input type="text" name="radio" id="radio" value='${listValue.radio}' />
    			</p>
   				</td>
    		</tr>

			<tr>
    			<td>Extension:</td>
    			<td>
    			<p class="ext">
        			<input type="text" id="ext" name="ext" value='${listValue.ext}' />
    			</p>
   				</td>
   				
   				<td>Celular:</td>
    			<td>
    			<p class="celular">
        			<input type="text" id="celular" name="celular" value='${listValue.celular}' />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Skype:</td>
    			<td>
    			<p class="skype">
        			<input type="text" id="skype" name="skype" value='${listValue.skype}' />
    			</p>
   				</td>
   				
   				<td>Email:</td>
    			<td>
    			<p class="email">
        			<input type="text" id="email" name="email" value='${listValue.email}' />
    			</p>
   				</td>
    		</tr>
    		<tr>
    			<td>PM Enabled:</td>
    			<td>
				<p class="project">
        			<select id="pmenabled" name="pmenabled">
        				<option selected="selected">${listValue.enabled}</option>
        				<option>Activo</option>
        				<option>Baja</option>
        			</select>
    			</p>
				</td>
    		</tr>
   			
   			<tr><td><br><br></td></tr>
			
			<tr>	
   				<td colspan="4">
    			<p class="submit">
        			<input type="button" value="Create" onClick="validatePM();" />
    			</p>
    			</td>
   			</tr>	
   			
   			</c:forEach> 
   		</table>
    </form>  
    </c:if>