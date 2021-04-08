<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<h1 style="color:red;text-align:center">JobSeeker Profile</h1>

<frm:form modelAttribute="jsFrm" enctype="multipart/form-data">
  <table bgcolor="yellow" align="center">
    <tr>
       <td>JobSeeker Name::</td>
       <td><frm:input path="jsName"/></td>
    </tr>
    <tr>
       <td>JobSeeker Addrs::</td>
       <td><frm:input path="jsAddrs"/></td>
    </tr>
    <tr>
       <td>JobSeeker Resume::</td>
       <td><input type="file" name="resume"/></td>
    </tr>
    <tr>
       <td>JobSeeker Photo::</td>
       <td><input type="file" name="photo"/></td>
    </tr>
     <tr>
       <td><input type="submit" value="submit"/></td>
       <td><input type="reset" value="cancel"/> </td>
    </tr>
  </table>
</frm:form>



