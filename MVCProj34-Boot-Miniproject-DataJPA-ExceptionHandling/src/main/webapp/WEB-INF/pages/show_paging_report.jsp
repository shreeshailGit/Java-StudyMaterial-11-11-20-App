<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<h1 style="color: red; text-align: center">Employees Info report
	page [${page.getNumber()+1}]</h1>
<br>
<br>
<div class="container">
  
	<c:choose>
	     <c:when test="${page ne null && !empty page}">
			<table
				class="table  table-hover table-bordered  table-stripped table-sm">
				<tr class="text-primary">
					<th>SerialNo</th>
					<th>EmpNo</th>
					<th>EmpName</th>
					<th>Job</th>
					<th>Salary</th>
					<th>GrossSal</th>
					<th>NetSal</th>
					<th>DeptNo</th>
				</tr>

				<c:forEach var="dto" items="${page.getContent()}">
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
			</table><br>
			
			<a href="report_paging?page=0">First page</a> 
			&nbsp;&nbsp;
			<c:if test="${!page.isLast()}">
			<a href="report_paging?page=${page.getNumber() + 1}">next</a>
			</c:if>
			&nbsp;&nbsp;
			
			<c:forEach var="i" begin="0" end="${page.getTotalPages()-1}" step="1">
			      [<a href="report_paging?page=${i}">${i+1}</a>]    &nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach>
			<c:if test="${!page.isFirst()}">
			<a href="report_paging?page=${page.getNumber()-1}">previous</a>
			</c:if>
			&nbsp;&nbsp;
             <a href="report_paging?page=${page.getTotalPages()-1}">Last page</a> 
		</c:when>

		<c:otherwise>
			<h1 style="color: red; text-align: center">Record Not Found</h1>
		</c:otherwise>
	</c:choose>

   </div>
      
       


  
   
   

