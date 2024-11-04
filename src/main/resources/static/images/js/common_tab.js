/**
 * 
 */

function getDetails(val) {

	var hidPolNumber = document.getElementById("policyNumber").value;
	var search = {}
	search["searchType"] = val;
	search["searchValue"] = hidPolNumber;
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/getDetails",
		data: JSON.stringify(search),
		dataType: 'html',
		cache: false,
		timeout: 600000,
		success: function(data) {
			document.getElementById('policyTabTable').innerHTML = "";
			document.getElementById('policyTabTable').innerHTML = data;
			console.log("sdasdas")
			var loadingIndicator = document.getElementById("loadingIndicator");
			loadingIndicator.style.display = "none";
		},
		error: function(e) {
			alert("Response Failed");
			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});

}


function getPDF(val) {

	var hidPolNumber = document.getElementById("policyNumber").value;

	var search = {}
	search["pdfType"] = val;
	search["pdfValue"] = hidPolNumber;
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/getPDF",
		data: JSON.stringify(search),
		cache: false,
		timeout: 600000,
		success: function(data) {


			if (data.DocBase64 == "") {
				alert(data.Description);

			}
			else {

				var bufferArray = base64ToArrayBuffer(data.DocBase64);
				var blobStore = new Blob([bufferArray], { type: "application/pdf" });
				if (window.navigator && window.navigator.msSaveOrOpenBlob) {
					window.navigator.msSaveOrOpenBlob(blobStore);
					return;
				}
				var datab = window.URL.createObjectURL(blobStore);
				var link = document.createElement('a');
				document.body.appendChild(link);
				link.href = datab;
				link.download = "Policy_" + hidPolNumber + ".pdf";
				link.click();
				window.URL.revokeObjectURL(datab);
				link.remove();
			}
		},
		error: function(e) {
			alert(data);
			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});
}



function base64ToArrayBuffer(data) {
	var bString = window.atob(data);
	var bLength = bString.length;
	var bytes = new Uint8Array(bLength);
	for (var i = 0; i < bLength; i++) {
		var ascii = bString.charCodeAt(i);
		bytes[i] = ascii;
	}
	return bytes;
};

function getUserPopUp (e) {
	e.preventDefault();
	var saveUserDetails = {}
	console.log("Inside submit")
	saveUserDetails["empId"] = document.querySelector('#EmpId').value;
	saveUserDetails["emailId"] = document.querySelector('#EmailId').value;
	saveUserDetails["firstName"] = document.querySelector('#FirstName').value;
	saveUserDetails["lastName"] = document.querySelector('#LastName').value;
	saveUserDetails["roleId"] = document.querySelector('#RoleId').value;
	
	console.log("saveClaimDetails : " + saveUserDetails["FirstName"]);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/saveUser",
		data: JSON.stringify(saveUserDetails),
		dataType: 'html',
		cache: false,
		timeout: 600000,
		success: function(data) {
			console.log(Success);
		},

		error: function(e) {

			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});

}
$(document).ready(function() {
var form=document.getElementById("form1");
form.addEventListener('submit', getEndrosmentPopUp);

function getEndrosmentPopUp(e) {
	e.preventDefault();
	var saveEndrosmentDetails = {}
	console.log("Inside submit pop up")
	saveEndrosmentDetails["PolicyId"] = document.querySelector('#PolicyId').value;
	console.log("EmpId")
	saveEndrosmentDetails["PolicyStartdate"] = document.querySelector('#PolicyStartdate').value;
	saveEndrosmentDetails["CustomerName"] = document.querySelector('#CustomerName').value;
	saveEndrosmentDetails["CustomerEmailId"] = document.querySelector('#CustomerEmailId').value;
	saveEndrosmentDetails["EndrosmentType"] = document.querySelector('#EndrosmentType').value;
	saveEndrosmentDetails["AddressLine1"] = document.querySelector('#AddressLine1').value;
	saveEndrosmentDetails["AddressLine2"] = document.querySelector('#AddressLine2').value;
	saveEndrosmentDetails["PinCode"] = document.querySelector('#PinCode').value;
	saveEndrosmentDetails["roleId"] = document.querySelector('#RoleId').value;
	saveEndrosmentDetails["firstName"] = document.querySelector('#City').value;
	saveEndrosmentDetails["lastName"] = document.querySelector('#State').value;
	saveEndrosmentDetails["REQUIREDDOCUMENT"] = document.querySelector('#REQUIREDDOCUMENT').value;
	saveEndrosmentDetails["FlieName"] = document.querySelector('#FlieName').value;
	saveEndrosmentDetails["Commants"] = document.querySelector('#Commants').value;
	
	console.log("saveUserDetails : " + saveEndrosmentDetails["PolicyId"]);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/ShowMISPAI1",
		data: JSON.stringify(saveEndrosmentDetails),
		dataType: 'html',
		cache: false,
		timeout: 600000,
		success: function(data) {
			  alert("Data saved successfully!!!");
			console.log("Data saved successfully");
		},
		error: function(e) {

			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});

}
});


$(document).ready(function() {
	  $('#form1').submit(function(event) {
	    event.preventDefault(); // Prevent the form from submitting normally
	   
	    var saveEndrosmentDetails = {
	      PolicyId: $('#PolicyId').val(),
	      PolicyStartdate: $('#PolicyStartdate').val(),
	      CustomerName: $('#CustomerName').val(),
	      CustomerEmailId: $('#CustomerEmailId').val(),
	      EndrosmentType: $('#EndrosmentType').val(),
	      AddressLine1: $('#AddressLine1').val(),
	      AddressLine2: $('#AddressLine2').val(),
	      PinCode: $('#PinCode').val(),
	      RoleId: $('#RoleId').val(),
	      City: $('#City').val(),
	      State: $('#State').val(),
	      REQUIREDDOCUMENT: $('#REQUIREDDOCUMENT').val(),
	      FlieName: $('#FlieName').val(),
	      Comments: $('#Comments').val()
	    };
	   
	    $.ajax({
	      url: '/ShowMISPAI1',
	      type: 'POST',
	      contentType: 'application/json',
	      data: JSON.stringify(saveEndrosmentDetails),
	      success: function(response) {
	        alert("Data saved successfully!");
	        console.log("Data saved successfully");
	      },
	      error: function(xhr, status, error) {
	        console.log("Error:", error);
	      }
	    });
	  });
	});
