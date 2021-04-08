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
      <tr  class="text-primary">
      <th>SerialNo</th>
      <th>EmpNo</th>
      <th>EmpName</th>
      <th>Job</th>
      <th>Salary</th>
      <th>GrossSal</th>
      <th>NetSal</th>
      <th>DeptNo</th>
      <th>operation</th>
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
         <td><a href="editEmp?eno=${dto.empNo }"><img src="images/edit1.png" width="50" height="50"/></a>
         <a href="deleteEmp?eno=${dto.empNo }" onclick="return confirm('Are you sure to delete ${dto.ename} ?')"><img src="images/delete1.jpg" width="50" height="50"/></a></td>
         </tr>                                                                                 
      </c:forEach>
   </table>   
  </c:when> 
  <c:otherwise>
   <h1 style="color:red;text-align:center">Record Not Found</h1>
  </c:otherwise>
</c:choose>
<br><br>

 <marquee direction="right"><h1 class="text-primary font-weight-bold" >${resultMsg }</h1></marquee>
<a href="saveEmp"><img  src="images/add1.jpg" width="100" height="100"/></a>
  &nbsp;&nbsp;<a href="welcome"><img  src="images/home.gif" width="100" height="100"/></a>
&nbsp;&nbsp;<a href="javaScript:doPrint()"><img  src="images/print1.jpg" width="100" height="100"/></a>

</div>
<script language="JavaScript">
      function doPrint(){
    	  frames.focus();
    	  frames.print();
      }
 </script>







