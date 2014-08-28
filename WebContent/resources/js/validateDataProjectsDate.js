
/*
 * 
 * */
function validateCreateProjectDate(){
	var description = document.getElementById("description").value;
	var idTask = document.getElementById("idTask").value;
	var predecesor = document.getElementById("predecesor").value;
	var startFC = document.getElementById("startFC").value;
	var endFC = document.getElementById("endFC").value;
	var startACT = document.getElementById("startACT").value;
	var endACT = document.getElementById("endACT").value;
	var resourceName = document.getElementById("resourceName").value;
	var advance = document.getElementById("advance").value;
	var principal = document.getElementById("principal").value;
	
	
	if(description == null || description.length == 0 ){
		alert("No se ha llenado el campo de Description");
		return false;
	}
	if(idTask == null || idTask.length == 0 ){
		alert("No se ha llenado el campo de IDTask");
		return false;
	}
	if(predecesor == null || predecesor.length == 0 ){
		alert("No se ha llenado el campo de Predecesor");
		return false;
	}
	if(startFC == null || startFC.length == 0 ){
		alert("No se ha llenado el campo de StartFC");
		return false;
	}
	if(endFC == null || endFC.length == 0 ){
		alert("No se ha llenado el campo de EndFC");
		return false;
	}
	if(startACT == null || startACT.length == 0 ){
		alert("No se ha llenado el campo de StartACT");
		return false;
	}
	if(endACT == null || endACT.length == 0 ){
		alert("No se ha llenado el campo de EndACT");
		return false;
	}
	if(resourceName == null || resourceName.length == 0 ){
		alert("No se ha llenado el campo de ResourceName");
		return false;
	}
	if(advance == null || advance.length == 0 ){
		alert("No se ha llenado el campo de Advance");
		return false;
	}
	if(principal == null || principal.length == 0 ){
		alert("No se ha llenado el campo de Principal");
		return false;
	}
	
	document.createProjectsDate.submit();
	
}


/*
 * 
 * */
function validateModifyProjectDate(){
	var description = document.getElementById("description").value;
	var idTask = document.getElementById("idTask").value;
	var predecesor = document.getElementById("predecesor").value;
	var startFC = document.getElementById("startFC").value;
	var endFC = document.getElementById("endFC").value;
	var startACT = document.getElementById("startACT").value;
	var endACT = document.getElementById("endACT").value;
	var resourceName = document.getElementById("resourceName").value;
	var advance = document.getElementById("advance").value;
	var principal = document.getElementById("principal").value;
	
	
	if(description == null || description.length == 0 ){
		alert("No se ha llenado el campo de Description");
		return false;
	}
	if(idTask == null || idTask.length == 0 ){
		alert("No se ha llenado el campo de IDTask");
		return false;
	}
	if(predecesor == null || predecesor.length == 0 ){
		alert("No se ha llenado el campo de Predecesor");
		return false;
	}	
	if(startFC == null || startFC.length == 0 ){
		alert("No se ha llenado el campo de StartFC");
		return false;
	}
	if(endFC == null || endFC.length == 0 ){
		alert("No se ha llenado el campo de EndFC");
		return false;
	}
	if(startACT == null || startACT.length == 0 ){
		alert("No se ha llenado el campo de StartACT");
		return false;
	}
	if(endACT == null || endACT.length == 0 ){
		alert("No se ha llenado el campo de EndACT");
		return false;
	}
	if(resourceName == null || resourceName.length == 0 ){
		alert("No se ha llenado el campo de ResourceName");
		return false;
	}
	if(advance == null || advance.length == 0 ){
		alert("No se ha llenado el campo de Advance");
		return false;
	}
	if(principal == null || principal.length == 0 ){
		alert("No se ha llenado el campo de Principal");
		return false;
	}
	
	document.updateProjectsDate.submit();
	
}