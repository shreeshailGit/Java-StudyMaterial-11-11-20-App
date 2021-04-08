<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 class="text-primary text-center">Employees Info Report</h1>
<head>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
</head>
<div class="container">
<c:choose>
  <c:when test="${empsInfo ne null && !empty empsInfo }">
   <table   class="table  table-hover table-bordered  table-stripped table-sm">
      <tr  class="text-info  bg-primary">
      <th>SerialNo</th>
      <th>EmpNo</th>
      <th>EmpName</th>
      <th>Job</th>
      <th>Salary</th>
      <th>GrossSal</th>
      <th>NetSal</th>
      <th>DeptNo</th>
      </tr>
      <c:forEach var="dto" items="${empsInfo}">
         <tr class="bg-success">
         <td>${dto.serialNo}</td>
         <td>${dto.empNo}</td>
         <td>${dto.ename}</td>
         <td>${dto.job}</td>
         <td>${dto.sal}</td>
         <td>${dto.grossSal}</td>
         <td>${dto.netSal}</td>
         <td>${dto.deptno}</td>
         </tr>
      </c:forEach>
   </table>   
  </c:when> 
  <c:otherwise>
   <h1 style="color:red;text-align:center">Record Not Found</h1>
  </c:otherwise>
</c:choose>
<br>
<a class="text-primary  text-center"href="welcome">home</a>

<br>
<a class="text-danger"href="javaScript:doPrint()">print</a>
</div>
<script language="JavaScript">
      function doPrint(){
    	  frames.focus();
    	  frames.print();
      }
 </script>
