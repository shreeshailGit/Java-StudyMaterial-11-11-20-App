

function validate(frm) {
	alert("js")
	let ename = frm.ename.value;
	let job = frm.job.value;
	let sal = frm.sal.value;
	let flag = true;

	//change vflag(hidden box) to "yes" indicating client side javascript is executed
	frm.vflag.value="yes";
	
	document.getElementById("enameId").innerHTML = "";
	document.getElementById("jobId").innerHTML = "";
	document.getElementById("salId").innerHTML = "";

	if (ename == "") {
		flag = false;
		document.getElementById("enameId").innerHTML = "Employee name is required(js)";
	} else if (ename < 5 || ename > 10) {
		flag = false;
		document.getElementById("enameId").innerHTML = "Employee length must have min 5 chars and max 10 chars(js)";
	}

	if (job == "") {
		flag = false;
		document.getElementById("jobId").innerHTML = "Employee job is required(js)";
	} else if (job < 5 || job > 10) {
		flag = false;
		document.getElementById("jobId").innerHTML = "Employee desg must have min 3 charas and max 9 charas(js)";
	}

	if (sal == "") {
		flag = false;
		document.getElementById("salId").innerHTML = "Employee salary is required(js)";
	} else if (isNaN(sal)) {
		flag = false;
		document.getElementById("salId").innerHTML = "salary must be numeric value(js)";
	} else if (sal < 10000 || sal > 100000) {
		flag = false;
		document.getElementById("salId").innerHTML = "Employee salary range must be in between 10000 to 100000(js)";
	}

	return flag;


}
