<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
<script src="js/validation.js"></script>
</head>
<body>

<font color="red" align="right">${errMsg}</font>
<frm:form action="validatelogin" modelAttribute="usr" method="POST" onsubmit="return validate(this)">
   <table border="1" align="center">
        <tr><td><frm:hidden path="vflag"/></td></tr>
       <tr>
         <td>Enter Email :</td>
        <td><frm:input path="userEmail"/><frm:errors cssClass="text-danger" path="userEmail"/><span id="userEmailId"></span></td>
      </tr>
      <tr>
        <td>Enter Password :</td>
        <td><frm:input path="pwd"/><frm:errors cssClass="text-danger" path="pwd"/><span id="pwdId"></span></td>
      </tr>
      <tr>
      
        <td><input type="submit" value="Reset"/></td>
         <td><input type="submit" value="Submit"/></td>
         
      </tr>
   
    </table>
     <a href="/User/addUser"style="margin-left: 450px" >Sign Up</a>
    <a href="/User/forgot_password" style="margin-left: 100px">Forgot Password ?</a>
</frm:form>
  
</body>
</html>