
/*
 * 
 * */
function validateCreateUser(){

	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	if(username == null || username.length == 0 ){
		alert("No se ha llenado el campo User");
		return false;
	}
	if(password == null || password.length == 0 ){
		alert("No se ha llenado el campo Password");
		return false;
	}
	
	document.createUser.submit();
	
}


/*
 * 
 * */
function validateModifyUser(){
	
	document.updateUser.submit();
	
}


