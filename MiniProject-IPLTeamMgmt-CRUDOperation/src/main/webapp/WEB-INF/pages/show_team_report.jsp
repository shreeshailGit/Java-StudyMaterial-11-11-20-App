<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:choose>
  <c:when test="${!empty teamList}">
     <h1 style="color:red;text-align:center">IPL Team Report</h1>
    <table border="1" align="center" bgcolor="LightGray">
        <tr style="color:red;">
         <th>Teamno</th><th>Team name</th><th>Owner</th><th>Area</th><th>Action</th>
        </tr>
        <c:forEach var="team" items="${teamList}">
            <tr style="color:blue">
              <td>${team.teamId}</td>
              <td>${team.teamName}</td>
              <td>${team.owner}</td>
              <td>${team.area}</td>
               
              <td> <a href="team_edit?no=${team.teamId}">edit</a>
                   <a href="team_delete?no=${team.teamId}" onclick="return confirm('Do you want to delete the IPL Team')">delete</a></td>
            </tr>
        </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
        <h1 style="color:red;text-align:center">IPL Team not Found</h1>
  </c:otherwise>

</c:choose>
<br><br><br><br>
<center>
<a href="./">Home</a>&nbsp;&nbsp;&nbsp;&nbsp; 
<a href="register">Register IPL Team</a>

<h2 style="color:green;text-align:center">${resultMsg}</h2>
</center>


