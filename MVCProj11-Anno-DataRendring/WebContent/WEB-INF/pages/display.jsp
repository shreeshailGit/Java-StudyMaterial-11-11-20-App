<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<h2 style="color:red;text-align:center">Result page Arrays/Collection</h2>
<%-- Data Rendering Message-->${msg} --%>

<c:choose>
     <c:when test="${studList ne null && !empty studList }">
        <table border="3" align="center">
       <tr><th>sno</th><th>sname</th><th>sadd</th></tr> 
        <c:forEach var="dto" items="${studList}">
          <tr>
             <td>${dto.sno}</td>
             <td>${dto.sname}</td>
             <td>${dto.sadd}</td>
          </tr>  
        </c:forEach>
        </table>
     </c:when>
</c:choose>



<%-- <b>names are </b><br>
 <c:forEach var="name" items="${namesInfo}">
    ${name }<br>
 </c:forEach>
 <hr>
 
<b>Fruits are</b><br>
 <c:forEach var="fruit" items="${fruitsInfo}">
     ${fruit }<br>
 </c:forEach> 
 <hr>
 
 <b>phonenumbers are</b><br>
 <c:forEach var="phone" items="${phonesInfo}">
     ${phone }<br>
 </c:forEach> 
 <hr>
 
 <b>ages are</b><br>
 <c:forEach var="age" items="${agesInfo}">
     ${age }<br>
 </c:forEach>  --%>
 <hr>
 <marquee>SHWETA..</marquee>