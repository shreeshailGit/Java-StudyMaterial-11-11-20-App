<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>


<head>
 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<h1 style="color:red;text-align:center">Person Registration Form</h1>
<div class="container">
<frm:form modelAttribute="perFrm">
<p style="color:red">
    <frm:errors path="*"/>
   </p>
  
  <table class="table table-dark table-striped"> 
    <tbody>
      <tr>
        <td>Person Name</td>
        <td><frm:input path="name"/></td>
      </tr>
       <tr>
        <td>Person Addrs</td>
        <td><frm:input path="addrs"/></td>
      </tr>
       <tr>
        <td>Person MobileNo</td>
        <td><frm:input path="mobileNo"/></td>
      </tr>
       <tr>
        <td>Person gender</td>
        <td><frm:radiobuttons path="gender" items="${genderList}"/></td>
      </tr>
       <tr>
        <td>hobies</td>
        <td><frm:checkboxes path="hobies" items="${hobiesList}"/></td>
      </tr>
       <tr>
        <td>Qualification</td>
        <td><frm:select path="qlfy">
               <frm:options items="${qlfyList}"/>
            </frm:select></td>
      </tr>
       <tr>
        <td>Favourite color</td>
        <td><frm:select path="colors" multiple="multiple">
            <frm:options items="${colorsList}"/>
          </frm:select></td>
      </tr>
       <tr>
        <td>Person dob(dd-MM-yyyy)</td>
        <td><frm:input type="date" path="dob"/></td>
      </tr>
       <tr>
        <td>Person doj(dd-MM-yyyy)</td>
        <td><frm:input type="date"  path="doj"/></td>
      </tr>
      <tr>
        <td>salary range  </td>
        <td><frm:input  type="range"  min="10000" max="200000"  path="salary"/> </td>
     </tr>
      <tr>
        <td colspan="2"> <input type="submit"  value="register"> </td>
      </tr>
      </tbody>
   </table>
   
</frm:form>
</div>
