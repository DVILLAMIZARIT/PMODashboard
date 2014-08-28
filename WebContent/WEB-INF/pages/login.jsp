<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/login.css">
<title>Login</title>
</head>
<body onload='document.loginForm.username.focus();'>


<table style="width: 100%; height: 100%;">
  <tr>
     <td style="text-align: center; vertical-align: middle;">
        

<div class="login_wrap">
    <div class="logo">
    	<img src="<c:url value="resources/images/logoNextel.png" />" />
        <!-- <img src="http://admin.myvirtualpaper.com/images/logo.png">-->
    </div>
    <div class="vform">
    
    
    <c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
	</c:if>
    
    	<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
            <fieldset class="float">
                <label>Username</label>
                <input type='text'  name='username' class='usertext'><br>
                <label class="clear">Password</label>
                <input type='password' name='password' class="usertext"><br>
                <label class="clear"></label>
				<input name="submit" class="cute_button" type="submit" style="clear:none;" 
						value="submit" />
										<img id='loadeux' src="http://admin.myvirtualpaper.com/images/loader.gif" width="25" height="25" style="display:none;position:relative;top: 5px; left: 70px">
            </fieldset>
                    <div class="clear"></div>
                <div style="text-align: center;">
                    <label><input type="checkbox" name="doRememberUsername"> Remember me |</label>
                    
                    <label><a href="http://admin.myvirtualpaper.com/forgotpassword">Forgot password?</a></label>
                        <div class="clear"></div><br><br><br>
                </div>
           
            <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />    
        </form>
    </div>
		<div id="me_box"></div>
                    
</div>

     </td>
  </tr>
</table>



<div class="login_body" style="background-color:;">
<center>
<div id="me_box">
</div>

</center>

</div>

</body>
</html> 