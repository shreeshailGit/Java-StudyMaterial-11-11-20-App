<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>    
   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
     
 <h1 style="color:red;text-align:center">Add Phone Number to PhoneBook </h1>   
   

<link rel="stylesheet" href="css/styles.css"/>	
	<!--For Client side form validation  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>	
<!-- Change the "src" attribute according to your installation path -->
<script src="vendor/jquery/dist/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<!-- Change the "src" attribute according to your installation path -->
<script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="js/form-validation.js"></script>

<script type="text/javascript">
   $(document).ready(function(event){
       $("#contactEmail").blur(function(e){
          $("#dupEmail").html("");
          var emailId = $("#contactEmail").val();
          $.ajax({
              url : 'validateEmail?email=' + emailId,
              success : function(response){
                    if(response == "Duplicate"){
                    	$("#dupEmail").html("Email already registred");
                    	$("#contactEmail").focus();
                        }
                }
             });    
        });
	});
  
</script>

</head>   
<body> 
<p><font color="green">${succMsg}</font></p>

<p><font color="red">${errMsg}</font></p>

<frm:form action="saveContact" modelAttribute="contactFrm" method="post" name="contact">
    <table>
        <tr>
         <frm:hidden path="contactId"/>
         <td>Contact Name :</td>
         <td><frm:input path="contactName"/></td>
        </tr>
      
        <tr>
         <td>Contact Email :</td>
         <td><frm:input path="contactEmail"/>
          <font color="red">
            <div id="dupEmail"></div>
          </font>
          </td>
        </tr>
        <tr>
         <td>Contact Number :</td>
         <td><frm:input path="number"/></td>
        </tr>
        <tr>
        
         <td><input type="reset" value="Reset"/></td>
         <td><input type="submit" value="Save"/></td>
        </tr>
     </table>
</frm:form>
 <a href="allContacts">View All Contacts</a>
 
 </body>
 </html>
 
