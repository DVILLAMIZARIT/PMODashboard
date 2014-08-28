
/*
 * 
 * */
function validateCreateData(){
	var projectName = document.getElementById("projectName").value;
	var owner = document.getElementById("owner").value;
	var sponsor = document.getElementById("sponsor").value;
	var stream = document.getElementById("stream").value;
	
	if(projectName == null || projectName.length == 0 ){
		alert("No se ha llenado el campo de Project Name");
		return false;
	}
	if(owner == null || owner.length == 0 ){
		alert("No se ha llenado el campo de owner");
		return false;
	}
	if(sponsor == null || sponsor.length == 0 ){
		alert("No se ha llenado el campo de sponsor");
		return false;
	}
	if(stream == null || stream.length == 0 ){
		alert("No se ha llenado el campo de stream");
		return false;
	}
	
	
	alert(projectName + "--" + owner + "--" + sponsor + "--" + stream);
	
	document.createProject.submit();
	
}


/*
 * 
 * */
function validateModifyData(){
	
	var projectName = document.getElementById("projectName").value;
	var owner = document.getElementById("owner").value;
	var sponsor = document.getElementById("sponsor").value;
	var stream = document.getElementById("stream").value;
	var budgetKey = document.getElementById("budgetKey").value;
	var type = document.getElementById("type").value;
	
	
	if(projectName == null || projectName.length == 0 ){
		alert("No se ha llenado el campo de Project Name");
		return false;
	}
	if(owner == null || owner.length == 0 ){
		alert("No se ha llenado el campo de owner");
		return false;
	}
	if(sponsor == null || sponsor.length == 0 ){
		alert("No se ha llenado el campo de sponsor");
		return false;
	}
	if(stream == null || stream.length == 0 ){
		alert("No se ha llenado el campo de stream");
		return false;
	}
	if(budgetKey == null || budgetKey.length == 0 ){
		alert("No se ha llenado el campo de budgetKey");
		return false;
	}
	if(type == null || type.length == 0 ){
		alert("No se ha llenado el campo de type");
		return false;
	}
	
	document.updateProject.submit();
	
}

