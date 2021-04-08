<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<header>
    <title><tiles:insertAttribute name="title"/></title>
</header>

<table height="100%" width="100%" border="0">
  <tr height="15%" bgcolor="orange">
     <td colspan="2"> <tiles:insertAttribute name="header"/></td>
  </tr>
  <tr height="70%" bgcolor="pink">
    <td width="20%"  bgcolor="cyan"><tiles:insertAttribute name="menu"/></td>
    <td width="70%"><tiles:insertAttribute name="body"/></td>
  </tr>
  
  <tr height="15%" bgcolor="yellow">
     <td colspan="2"><tiles:insertAttribute name="footer"/></td>
  </tr>
</table>

