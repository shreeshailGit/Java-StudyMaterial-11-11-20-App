<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<head>
    <!--For pagination and seraching operation  -->
<link
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">

	<!--For pagination and seraching operation  -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	
</script>
<!--=============================================================================================================================  -->
<!-- https://www.sitepoint.com/basic-jquery-form-validation-tutorial/ -->
<!--=============================================================================================================================  -->

</head>
<div class="container">
 <c:choose>
  <c:when test="${contactInfo ne null && !empty contactInfo}">
     <b  align="center"><a href="addContact">+Add New Contact</a></b>&nbsp;
     <table border="1" id="contactTbl" >
       <thead>
        <tr>
           <th>S.NO</th>
           <th>NAME</th>
           <th>EMAIL</th>
           <th>PHNO</th>
           <th>ACTION</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${contactInfo}" varStatus="index">
           <tr>
             <td>${index.count}</td>
             <td>${dto.contactName}</td>
             <td>${dto.contactEmail}</td>
             <td>${dto.number}</td>
             <td>
             <a href="edit?cid=${dto.contactId}">Edit</a> |
             <a href="delete?cid=${dto.contactId}" onclick="return confirm('Are you sure, you want to delete?')">Delete</a></td> 
           </tr>     
        </c:forEach>
        </tbody>
      </table>
  </c:when>
   
   <c:otherwise>
   
   <h1 style="color:red;text-align:center">Contact Not Found</h1>  
   </c:otherwise>
 </c:choose>
 </div>