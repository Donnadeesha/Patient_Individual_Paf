$(document).ready(function() 
	{
	 	$("#alertSuccess").hide();
	
		$("#alertError").hide();
	
		
});


//$(document).ready(function() {
//	if ($("#alertSuccess").text().trim() == "") {
//		$("#alertSuccess").hide();
//	}
//	$("#alertError").hide();
//});



// SAVE ============================================ 

$(document).on("click","#btnSave", function(event) 
		{
	// Clear alerts---------------------
		
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();

	// Form validation------------------- 
		var status = validatePatientForm();
		if(status != true)
			{
				$("#alertError").text(status);
				$("#alertError").show();
				return;
			}

	//From-Lab10	
	//If valid------------------------ 
		var type = ($("#hidPatientIDSave").val() == "") ? "POST" : "PUT"; 
		
		$.ajax(
		{
			url : "PatientsAPI", 
			type : type,
			data : $("#formPatient").serialize(),
			dataType : "text",
				complete : function(response, status)
					{  
						onPatientSaveComplete(response.responseText, status);  
					} 
		}); 
});


function onPatientSaveComplete(response, status)
{  
	if (status == "success") 
	{ 
			var resultSet = JSON.parse(response); 

			if (resultSet.status.trim() == "success")  
				{ 
				$("#alertSuccess").text("Successfully saved."); 
				$("#alertSuccess").show(); 

				$("#divPatientsGrid").html(resultSet.data); 
				}
			else if (resultSet.status.trim() == "error") 
			{    $("#alertError").text(resultSet.data);   
				$("#alertError").show(); 
			} 

	} else if (status == "error") 
	{ 
		
			$("#alertError").text("Error while saving.");
			$("#alertError").show(); 
		} else 
			{  
				$("#alertError").text("Unknown error while saving..");
				$("#alertError").show(); 
			} 

$("#hidPatientIDSave").val(""); 
$("#formPatient")[0].reset();

}	 








//From Lab 9
// UPDATE========================================== 
	
$(document).on("click",".btnUpdate", function(event) 
	{
		//earlier started form 0 
	
	
	
		$("#hidPatientIDSave").val($(this).closest("tr").find('#hidPatientIDUpdate').val());
		//$("#Uid").val($(this).closest("tr").find('td:eq(0)').text());
		$("#first").val($(this).closest("tr").find('td:eq(1)').text());
		$("#lname").val($(this).closest("tr").find('td:eq(2)').text());
		$("#email").val($(this).closest("tr").find('td:eq(3)').text());
		$("#age").val($(this).closest("tr").find('td:eq(4)').text());
		$("#mobile").val($(this).closest("tr").find('td:eq(5)').text());
		$("#password").val($(this).closest("tr").find('td:eq(6)').text());
		
	});



//newly added
//$.ajax( 
//{  
//	url : "PatientsAPI",
	//type : type, 
	//data : $("#formPatient").serialize(),
//	dataType : "text", 
	//complete : function(response, status)
	//{   
		//onPatientSaveComplete(response.responseText, status);
	//} 
//}); 





//REMOVE========================================== 
	

$(document).on("click", ".btnRemove", function(event) 
	{ 
	$.ajax(
		{ 
			url : "PatientsAPI",
			type : "DELETE",
			data : "Uid=" + $(this).data("uid"),
			dataType : "text",
			complete : function(response, status)
			{ 
				onPatientDeleteComplete(response.responseText, status);  
			}
		});
	}); 




function PatientDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();

			$("#divPatientsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}

	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
} 









	
	function validatePatientForm()
	{
		
		// FIRST-NAME
		if ($("#first").val().trim() == "")
		{
			return "Insert First Name ."; 
		}
 
		// LAST-NAME-------------------------------  
		
		if ($("#lname").val().trim() == "") 
		{  
			return "Insert Last Name."; 
		} 
		
		// Email-------------------------------  
		
		if ($("#email").val().trim() == "") 
		{  
			return "Insert Email."; 
		} 
		
 
		// Age 
		var tmpAge = $("#age").val().trim();  
		if (!$.isNumeric(tmpAge)) 
		{ 
			return "Insert a numerical value for Age.";  
		} 
 
		
		// Mobile 
		var tmpMob = $("#mobile").val().trim();  
		if (!$.isNumeric(tmpMob)) 
		{ 
			return "Insert a numerical value for Mobile.";  
		} 
		
		// Password-------------------------------  
		
		if ($("#password").val().trim() == "") 
		{  
			return "Insert Password."; 
		}
		
		 
 

		return true; 
 
} 
 
 
