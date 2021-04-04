<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>

<h1 style="color:red;text-align:center">Registration Form</h1>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="./js/app.js"></script><!-- ./ optional  -->
<script src="./js/datepicker.js"></script><!-- ./ optional  -->

</head>
<div class="container">
<frm:form action="register" modelAttribute="userFrm" method="POST">

    <table border="0" align="center">
         <tr>
            <td>First Name : </td>
             <td><frm:input path="fname" placeholder="enter first name"/></td>
         </tr>
         <tr>
            <td>Last Name : </td>
            <td><frm:input path="lname" placeholder="enter last name"/></td>
         </tr>
         <tr>
            <td>Email : </td>
            <td><frm:input path="userEmail" placeholder="email"/></td>
         </tr>
         <tr>
            <td>Phone No : </td>
            <td><frm:input path="phNo" placeholder="phone number"/></td>
         </tr>
         <tr>
            <td>Dob : </td>
            <td><frm:input path="dob" id="dob" placeholder="date of birth"/></td>
         </tr>
         <tr>
            <td>Gender : </td>
            <td><frm:radiobutton path="gender" value="male"/>Male
                <frm:radiobutton path="gender" value="female"/>Female</td>
         </tr>
         <tr>
            <td>Country : </td>
            <td>
					<frm:select path="countryId">
						<frm:option value="">-Select-</frm:option>
						<frm:options items="${countriesMap}"/>
					</frm:select>
				</td>
         </tr>
         <tr>
            <td>State : </td>
                 <td>
					<frm:select path="stateId">
					   <frm:option value="">-Select-</frm:option>
					</frm:select>
				</td>
         </tr>
         <tr>
            <td>City : </td>
                <td>
                   <frm:select path="cityId">
					<frm:option value="">-Select-</frm:option>
					</frm:select>
				</td>
         </tr>
         <tr>
            <td>
              <input type="reset" value="Reset">&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="submit" value="Save">
              
            </td>
         </tr>
    </table>
   <h1 style="color:red;text-align:center">${resultMsg}</h1> 
</frm:form>
</div>
