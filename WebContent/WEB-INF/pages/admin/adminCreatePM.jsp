<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	
	<form name='createPM' action="<c:url value='createPM'/>" method='GET'>
		<table class="createProject">
			<tr>
				<th colspan="4">CREATE PROJECT MANAGER</th>
			</tr>
			
			
			<tr>
				<td>ID ProjectManager:</td>
    			<td>
    			<p class="idPM">
        			<input type="text" name="idPM" id="idPM" />
    			</p>
   				</td>
			
    			<td>PM Name:</td>
    			<td>
    			<p class="pmName">
        			<input type="text" name="pmName" id="pmName" />
    			</p>
   				</td>
    		</tr>
    		
    		<tr>
    			<td>Radio:</td>
    			<td>
    			<p class="radio">
        			<input type="text" name="radio" id="radio" />
    			</p>
   				</td>
    		
    			<td>Extension:</td>
    			<td>
    			<p class="ext">
        			<input type="text" name="ext" id="ext" />
    			</p>
   				</td>
    		</tr>
			
    		<tr>
    			<td>Celular:</td>
    			<td>
    			<p class="celular">
        			<input type="text" name="celular" id="celular" />
    			</p>
   				</td>
    		
    			<td>Skype:</td>
    			<td>
    			<p class="skype">
        			<input type="text" name="skype" id="skype" />
    			</p>
   				</td>
    		</tr>		
    		
    		<tr>
    			<td>Email:</td>
    			<td>
    			<p class="email">
        			<input type="text" name="email" id="email" />
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
   		</table>
    </form>  