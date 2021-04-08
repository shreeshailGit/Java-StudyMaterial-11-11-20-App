<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>


<head>
  <title>Internationalization</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 
</head>

<h1 style="color:red;text-align:center"><spring:message code="person.title"/></h1>

<frm:form modelAttribute="perFrm">
  <div class="container">
  <table class="table table-primary table-hover"  align="center">
    <tbody> 
     <tr>
       <td><spring:message code="person.name"/> </td>
       <td><frm:input path="name"/></td>
     </tr>
     <tr>
       <td><spring:message code="person.addrs"/> </td>
       <td><frm:input path="addrs"/></td>
     </tr>
     <tr>
       <td><spring:message code="person.mobileNo"/> </td>
       <td><frm:input path="mobileNo"/></td>
     </tr>
     <tr>
        <td><input type="submit" class="btn btn-success" value="<spring:message code='person.submit.cap'/>"></td>
     </tr><!-- <button type="button" class="btn btn-success">Success</button> -->
     </tbody>   
  </table>
   </div>
</frm:form>
&nbsp;&nbsp;<a href="?lang=fr_FR">French</a>  &nbsp;&nbsp;<a href="?lang=de_DE">German</a>
&nbsp;&nbsp;<a href="?lang=hi_IN">Hindi</a>  &nbsp;&nbsp;<a href="?lang=zn_CN">China</a>
 &nbsp;&nbsp;<a href="?lang=en_US">English</a>
 
      <fmt:setLocale value="${response.locale}"/>
     
       <jsp:useBean id="dt"  class="java.util.Date"/>
       <fmt:formatDate var="fdt" value="${dt}" type="both" dateStyle="full" timeStyle="full"/>
             formatted date::${fdt}
              <br>
     <fmt:formatNumber var="fno" value="545454353454554" type="currency"/>
     formatted number :: ${fno}

