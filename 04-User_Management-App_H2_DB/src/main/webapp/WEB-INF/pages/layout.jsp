<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="0" width="100%" height="100%">
   <tr height="10%" bgcolor="orange">
      <td colspan="2"><tiles:insertAttribute name="header"/></td>
   </tr>
   <tr height="70%" bgcolor="cyan">
    <%--  <td width="20%" bgcolor="cyan"><tiles:insertAttribute name="menu"/></td> --%>
     <td><tiles:insertAttribute name="body"/></td>  
   </tr>
   <tr height="15%" bgcolor="yellow">
     <td colspan="2"><tiles:insertAttribute name="footer"/> </td>
   </tr>
 </table>
</body>
</html>