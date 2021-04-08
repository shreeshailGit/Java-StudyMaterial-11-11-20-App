<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red;text-align:center">All language Info</h1>

<c:choose>
   
  <c:when test="${ listInfo1 ne null && !empty listInfo1}">
  
  <b> Languages count::${count}</b>
  
     <table align="center" bgcolor="yellow">
     <c:forEach var="lang" items="${listInfo1}" >
        <tr>
         <td style="color:red">  ${lang}</td>
        </tr>
     </c:forEach>
     </table>
  </c:when>
 
  <c:otherwise>
  <h1 style="color:red;text-align:center">No records found</h1>
  </c:otherwise>
</c:choose>
<br><br>
<a href="welcome">home</a>