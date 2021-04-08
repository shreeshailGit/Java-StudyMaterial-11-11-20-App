<%@  page isELIgnored="false"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 style="color:red;text-align:center">Login Page</h2>

<frm:form modelAttribute="user">
  <table bgcolor="cyan" border="1" align="center">
   <tr>
     <td>Username::</td>
     <td><frm:input path="uname"/></td>
   </tr>
   <tr>
     <td>Password::</td>
     <td><frm:password path="pwd"/></td>
   </tr>
   <tr>
     <td colspan="2"><input type="submit" value="login"></td>
   </tr>
   
  </table>
</frm:form>
<br>
<c:if test="${resultMsg ne null && !empty resultMsg }">
<h1 style="color:red;text-align:center">${resultMsg}</h1>
</c:if>
