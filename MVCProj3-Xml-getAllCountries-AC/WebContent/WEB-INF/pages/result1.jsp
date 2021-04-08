<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
 <h1 style="color:red;text-align:center"> All Country Names  </h1>
<br><br>
<%-- <h3 style="color:green;text-align:center">Enduser wish:::</b>${wmsg}</h3> --%>

   <c:forEach var="locale" items="${cntr}" >
  
     Country name:: ${locale}<br>
     
    </c:forEach>

<br>
 <h2> <a href="welcome.htm">home</a></h2>
  
 