<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<h1 style="color:red;text-align:center">All ${operation} Info</h1>

<c:choose>
   <c:when test="${listInfo ne null && !empty listInfo}">
    <b> countriesCount::${CountriesCount}</b>
      <table align="center" bgcolor="orange">
      <c:forEach var="country" items="${listInfo}">
           <tr>
            <td style="color:blue">${country} </td>
           </tr>    
      </c:forEach>
      
       </table>
     
   </c:when> 
   <c:otherwise>
   <h1 style="color:red;text-align:center">No records found</h1>
   </c:otherwise>
</c:choose>
<br><br>
<a href="logout">logout</a>
<br><br>
<a href="welcome">home</a>