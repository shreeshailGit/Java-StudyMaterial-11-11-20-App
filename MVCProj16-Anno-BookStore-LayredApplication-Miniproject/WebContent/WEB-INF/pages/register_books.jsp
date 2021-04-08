<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<head>
  <!-- <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
  
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">

</head>    
 <h1 style="color:red;text-align:center">Insertion book record page</h1> 
 
<div class="Container"> 
 <frm:form modelAttribute="bid">
 <table class="table table-striped"  bgcolor="BlanchedAlmond" align="center">
  <tr>
    <td>BookName::</td>
     <td><frm:input path="bookName"/></td>
  </tr>
   <tr>
    <td>Author::</td>
     <td><frm:input path="author"/></td>
  </tr>
  <tr>
    <td>Price::</td>
     <td><frm:input path="price"/></td>
  </tr>
  <tr>
    <td>Publisher::</td>
     <td><frm:input path="publisher"/></td>
  </tr>
  <tr>
    <td>Category::</td>
     <td><frm:input path="category"/></td>
  </tr>
  <tr>
    
  <tr>
    <td><input type="submit" value="insert"/> </td>
  </tr>
</table>
  </div>
 </frm:form>  
 <br>
 <a href="welcome.htm"><img src="images/home.gif" class="img-circle" alt="Cinque Terre" height="100" width="100"/></a>
  
    
    