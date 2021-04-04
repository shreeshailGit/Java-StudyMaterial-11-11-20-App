
function validate(frm) {
  alert("js")
   let userEmail = frm.userEmail.value;
   let pwd = frm.pwd.value;
   let flag = true;
   
   //change vflag(hidden box) to "yes" indicating client side javascript is executed
	frm.vflag.value="yes";
	
	document.getElementById("userEmailId").innerHTML = "";
	document.getElementById("pwdId").innerHTML = "";
	
	if (userEmail == "") {
		flag = false;
		document.getElementById("userEmailId").innerHTML = "user email is required(js)";
	} else if (userEmail < 3 || userEmail > 10) {
		flag = false;
		document.getElementById("userEmailId").innerHTML = "emailId must be having minimum 3 charas and maximum 10 charas required(js)";
	}
	
	if (pwd == "") {
		flag = false;
		document.getElementById("pwdId").innerHTML = "password is required(js)";
	} else if (pwd < 5 || pwd > 10) {
		flag = false;
		document.getElementById("pwdId").innerHTML = " password must be having min 6 and max 10 charas required(js)";
	}
	
	return flag;
	
}
