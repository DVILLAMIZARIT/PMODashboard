
/*
 * 
 * */
function validatePM(){
	var idPM = document.getElementById("idPM").value;
	var pmName = document.getElementById("pmName").value;
	var email = document.getElementById("email").value;
	
	if(idPM == null || idPM.length == 0 ){
		alert("No se ha llenado el campo de ID Projec tManager");
		return false;
	}
	if(pmName == null || pmName.length == 0 ){
		alert("No se ha llenado el campo de Project Manger Name");
		return false;
	}
	if(email == null || email.length == 0 ){
		alert("No se ha llenado el campo de Email");
		return false;
	}
	
	document.createProject.submit();
	
}

