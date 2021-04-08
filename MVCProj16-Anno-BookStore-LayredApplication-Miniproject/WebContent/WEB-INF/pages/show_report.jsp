<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<head>
  <title>BookStore_Application</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<div class="container">
<h1 style="color:purple;text-align:center">Books Details</h1>
<c:choose>
 <c:when test="${booksInfo ne null && !empty booksInfo }">
   <table class=table "table-striped">
     <thead>
      <tr>
         <th>BookId</th>
         <th>BookName</th>
         <th>Author</th>
         <th>Price</th>
         <th>Publisher</th>
         <th>category</th>
         <th>operations</th>
      </tr>
      </thead>
      <c:forEach var="dto"  items="${booksInfo }">
       <tbody> 
        <tr>
          <td>${dto.bookId}</td>
          <td>${dto.bookName}</td>
          <td>${dto.author}</td>
          <td>${dto.price}</td>
          <td>${dto.publisher}</td>
          <td>${dto.category}</td>
          <td><a href="editBook.htm?bookId=${dto.bookId}"><img src="images/edit.png" height="50" width="50"/></a>&nbsp;&nbsp;
&nbsp;&nbsp;<a href="deleteBook.htm?bookId=${dto.bookId}" onclick="return confirm('Are you sure to delete ${dto.bookName} ?')"><img src="images/delete.png" height="50" width="50"/></a></td>
        </tr>                                                                   
             </tbody> 
      </c:forEach>
   </table>
 </c:when>

  <c:otherwise>
  <h1 style="color:red;text-align:center">Books are not found</h1>
  </c:otherwise>
</c:choose>
</div>

<marquee direction="right" behavior="scroll" scrollamount="20" >  <h1 style="color:red;text-align:center">${ resultMsg }</h1></marquee>

<br>
 &nbsp;&nbsp;<a href="welcome.htm"><img src="images/home.gif" class="img-circle" alt="Cinque Terre" height="100" width="100"/></a>
  &nbsp;&nbsp;<a href="add.htm"><img src="images/add.png" class="img-circle" alt="Cinque Terre" height="100" width="100"/></a>
   &nbsp;&nbsp;<a href="javaScript:doPrint()"><img src="images/print1.jpg" class="img-circle" alt="Cinque Terre" height="100" width="100"/></a>
 
 
 <script language="javascript">
       function doPrint() {
		   frames.focus();
		   frames.print();
	}
   	
 </script>
 <script>
function myFunction() {
  var txt;
  var r = confirm("Are u sure to delete ${dto.bookId} ?");
  if (r == true) {
    txt = "${dto.bookId}  bookId is deleted ";
  } else {
    txt = "${dto.bookId}  bookId is not deleted ";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>
 
 
 
 
 
 
 
 