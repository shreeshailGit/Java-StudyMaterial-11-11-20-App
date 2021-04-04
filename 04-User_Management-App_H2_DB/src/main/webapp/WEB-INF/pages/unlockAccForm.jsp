<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$('#newPwd, #confirmPwd').on('keyup', function () {
	  if ($('#newPwd').val() == $('#confirmPwd').val()) {
	    $('#message').html('').css('color', 'green');
	  } else 
	    $('#message').html('password and confirm password should  Match').css('color', 'red');
	});
});	
</script>
</head>
<body>


<h2 style="color:red;text-align:center">Unlock Account Here</h2>
     <font color="red">${errMsg}</font>
<frm:form action="unlockUserAcc" modelAttribute="unlockAcc" method="POST">
    <table>
       <tr>
          <td>Your email :</td>
          <td><frm:input path="email" readonly="true"/>  </td>
       </tr>
      <tr>
          <td>Enter Temporary Password :</td>
          <td>
             <frm:password path="tempPwd"/>
          </td>
       </tr>
      <tr>
          <td>Enter New Password :</td>
          <td>
           <frm:password path="newPwd" id="newPwd"/>
          </td>
       </tr>
      <tr>
          <td>Confirm New Password :</td>
          <td><frm:password path="confirmPwd" id="confirmPwd"/>  <span id='message'></span></td>
       </tr>
      <tr>
          <td>
           <input type="submit" style="margin-left: 100px" value="Unlock">
          </td>
      </tr>  
   </table>
           
</frm:form>
</body>
</html>