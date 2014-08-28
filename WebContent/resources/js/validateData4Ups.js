
/*
 * 
 * */
function validateCreate4up(){
	var description = document.getElementById("description").value;
	var dateups = document.getElementById("dateups").value;
	var flag = document.getElementById("flag").value;
	
	if(description == null || description.length == 0 ){
		alert("No se ha llenado el campo Description");
		return false;
	}
	if(dateups == null || dateups.length == 0 ){
		alert("No se ha llenado el campo Date Ups");
		return false;
	}
	if(flag == null || flag.length == 0 ){
		alert("No se ha llenado el campo Flag");
		return false;
	}
	
	document.create4up.submit();
	
}


/*
 * 
 * */
function validateModify4up(){
	var description = document.getElementById("description").value;
	var dateups = document.getElementById("dateups").value;
	var flag = document.getElementById("flag").value;
	
	if(description == null || description.length == 0 ){
		alert("No se ha llenado el campo Description");
		return false;
	}
	if(dateups == null || dateups.length == 0 ){
		alert("No se ha llenado el campo Date Ups");
		return false;
	}
	if(flag == null || flag.length == 0 ){
		alert("No se ha llenado el campo Flag");
		return false;
	}
	
	document.update4up.submit();
	
}

