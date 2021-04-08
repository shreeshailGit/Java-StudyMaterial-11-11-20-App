<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 

<h1 style="color:red;text-align:center">show All files to Download</h1>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

 <c:choose>
   <c:when test="${filesList ne null && !empty filesList }">
     <div class="container">
      <table bgcolor="yellow" align="center" class="table table-dark table-hover">
       <c:forEach var="fileName" items="${filesList }">
           <tbody>
            <tr>
              <td>${fileName}</td>
              <td><a href="download.htm?fname=${fileName}">download</a></td>
            </tr>
           </tbody> 
       </c:forEach>
       </table>
       </div>
   </c:when>
   <c:otherwise>
   <h1 style="color:red;text-align:center">No files  found to download</h1>
   </c:otherwise>
 </c:choose>
 