<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<head>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
</head>

<div class="container">
<h1 style="color:red;text-align:center">Employee registration form</h1>

<script   language="JavaScript"   src="js/validation.js">
</script>
<frm:form modelAttribute="empFrm" onsubmit="return validate(this)">
 <table class="table table-responsive" bgcolor="BlanchedAlmond" align="center">
    <tr>
      <td>Employee name::</td>
       <td><frm:input path="ename"/> <frm:errors cssClass="text-danger" path="ename"/> <span  id="enameId"></span> </td>
    </tr>
    <tr>
      <td>Employee desg::</td>
       <td><frm:input path="job"/> <frm:errors cssClass="text-danger" path="job"/> <span  id="jobId"></span> </td>
    </tr>
    <tr>
      <td>Employee salary::</td>
       <td><frm:input path="sal"/> <frm:errors cssClass="text-danger" path="sal"/> <span  id="salId"></span> </td>
    </tr>
    <tr>
     <%--  <td>Employee DeptNo::</td>
       <td><frm:select path="deptno">
         <option value="10">10</option>
         <option value="20">20</option>
         <option value="30">30</option>
         <option value="40">40</option>
       </frm:select></td> --%>
        <td>Employee DeptNo::</td>
       <td><frm:select path="deptno">
            <frm:options items="${deptsInfo}"/>
       </frm:select></td>
    </tr>
     <tr>
       <td><frm:hidden path="vflag"/></td>
       <td><input type="submit"  value="register"/></td>
    </tr>
 </table>
</frm:form>
</div>
