<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forget password page</title>
</head>
<div>
    <h1 style="color:red;text-align:center">Forgot Password</h1>
<div>
<body>
<form action="forgot_password" method="post" style="max-width: 420px; margin: 0 auto;">
<div class="border border-secondary rounded p-3">
    <div>
        <p>We will be sending a reset password link to your email.</p>
    </div>
    <div>
        <p>
            <input type="email" name="userEmail" class="form-control" placeholder="Enter your e-mail" required autofocus/>
        </p>         
        <p class="text-center">
            <input type="submit" value="Send" class="btn btn-primary" />
        </p>
    </div>
</div>
</form>
</body>
</html>