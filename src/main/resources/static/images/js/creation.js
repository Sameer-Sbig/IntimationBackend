/**
 * 
 */

function openGate() {
	document.getElementById("pai").hidden = true;
	document.getElementById("gpa").hidden = true;
	var searchBySelect = document.getElementById("searchBy");
	var value = searchBySelect.options[searchBySelect.selectedIndex].value;
	var searchByValue = document.getElementById("searchByValue").value;
	var search = {}
	search["searchByName"] = value;
	search["searchByValue"] = searchByValue;
	//alert(value);
	//alert(searchByValue);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/getDetails",
		data: JSON.stringify(search),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			//let json = JSON.stringify
			//alert("data" + data.source);
			//	alert("data" + data.owner_account_number);
			//	let output = '';
			//   $('#paiTable').html(json);
			//for (let i in json) {

			//output +=
			//	`<tr>
			//      <td>'+data.owner_account_number+'</td>
			//     <td>'+data.journal_number+'</td>
			//     <td>'+data.applicant_name+'</td>
			//  </tr>`;
			// alert("output" + output);
			//}
			//document.getElementById('paiTableData').append(output);
			if (data.source == 'PAI') {
				document.getElementById("owner_account_number").value = data.owner_account_number;
				document.getElementById("journal_number").value = data.journal_number;
				document.getElementById("applicant_name").value = data.applicant_name;
				//console.log("SUCCESS : ", json);
				//$("#pai").prop("hidden", false);
				document.getElementById("pai").hidden = false;
			}
			if (data.source == 'GPA') {
				document.getElementById("coiNumber").value = data.coiNumber;
				document.getElementById("journal_number").value = data.journal_number;
				document.getElementById("insuredName").value = data.insuredName;
				//console.log("SUCCESS : ", json);
				//$("#pai").prop("hidden", false);
				document.getElementById("gpa").hidden = false;
			}

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