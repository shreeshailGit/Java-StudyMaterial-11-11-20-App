<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<head>
  <!-- <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
  
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">

</head>    
 <h1 style="color:red;text-align:center">Edit book record page</h1> 
 
 <div class="container-sm">
 <frm:form  action="editBook.htm"    modelAttribute="bid" >
   <table class="table table-striped" bgcolor="YellowGreen" align="center">
     
    <tr>
       <td>BookId::</td>
       <td><frm:input path="bookId" readonly="true" /> </td>
    </tr>
    <tr>
       <td>BookName::</td>
       <td><frm:input path="bookName"/> </td>
    </tr>
     <tr>
       <td>Author::</td>
       <td><frm:input path="author"/> </td>
    </tr>
     <tr>
       <td>Price::</td>
       <td><frm:input path="price"/> </td>
    </tr>
     <tr>
       <td>Publisher::</td>
       <td><frm:input path="publisher"/> </td>
    </tr>
     <tr>
       <td>Category::</td>
       <td><frm:input path="category"/> </td>
    </tr>
    <tr>
    <td colspan="2"><input type="submit" value="update"/> </td>
    </tr>   
   </table> 
 </frm:form>
 </div>