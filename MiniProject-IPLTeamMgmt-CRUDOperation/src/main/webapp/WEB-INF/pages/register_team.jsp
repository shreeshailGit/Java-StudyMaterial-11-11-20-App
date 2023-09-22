<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:red;text-align:center">Registration IPL Team</h1>

<frm:form modelAttribute="team">

 <table border="0" align="center" bgcolor="LightGray">
        <tr>
           <td>Team Name</td>
           <td><frm:input path="teamName"/></td>
        </tr>
       <tr>
           <td>Team Owner</td>
           <td><frm:input path="owner"/></td>
        </tr>
          <tr>
           <td>Team city</td>
           <td><frm:input path="area"/></td>
        </tr>
       
        <tr>
        <td>
           <input type="reset" value="cancel">
           <input type="submit" value="Save"></td>
        </tr>
    </table>
</frm:form>