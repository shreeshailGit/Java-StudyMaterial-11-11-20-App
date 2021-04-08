<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 <h1 style="color:red;text-align:center"> All Country Names  </h1>
<br><br>
<%-- <h3 style="color:green;text-align:center">Enduser wish:::</b>${wmsg}</h3> --%>

   <c:forEach var="locale" items="${cntr}" >
  
     Country name:: ${locale.getDisplayCountry()}<br>
     
    </c:forEach>

<br>
 <h2> <a href="welcome">home</a></h2>

