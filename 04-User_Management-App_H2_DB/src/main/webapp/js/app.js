$(document).ready(function(){
	$("#countryId").on('change', function(){
	
	   $("#stateId").find('option').remove();
	    $('<option>').val('').text('-Select-').appendTo("#stateId");
	    
	   $("#cityId").find('option').remove();
	    $('<option>').val('').text('-Select-').appendTo("#cityId");
	     
		var countryId = $("#countryId").val();
		$.ajax({
			type : "GET",
			url : "getStates?cid=" + countryId,
			success : function(result) {
			       $.each(result,function(key,value){
			       $('<option>').val(key).text(value).appendTo("#stateId");
			       });
			  }
		});
	});

	$("#stateId").on('change', function(){
	
	   $("#cityId").find('option').remove();
	    $('<option>').val('').text('-Select-').appendTo("#cityId");
	     
		var stateId = $("#stateId").val();
		$.ajax({
			type : "GET",
			url : "getCities?sid=" + stateId,
			success : function(result) {
			       $.each(result,function(key,value){
			       $('<option>').val(key).text(value).appendTo("#cityId");
			       });
			  }
		});
	});


});