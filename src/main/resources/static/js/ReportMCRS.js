$(document).ready(function() {

	// Add options for year select box
	var currentYear = new Date().getFullYear();
	for (var i = currentYear; i >= currentYear - 10; i--) {
		$('#yearMCRS').append($('<option>', { value: i, text: i }));
	}

	// Add options for month select box
	var monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
	for (var i = 0; i < monthNames.length; i++) {
		$('#monthMCRS').append($('<option>', { value: i + 1, text: monthNames[i] }));
	}

	$("#submit").click(function() {
		debugger;
		$(".loading-icon").removeClass("d-none");


		console.log("Inside Method2");
		var Year = $("#yearMCRS").val();
		console.log("Year", Year);
		var Month = $("#monthMCRS").val();

		var searchType = $('#mcrsReport1').val();
		var search = {}
		search["searchType"] = searchType;

		search["Year"] = start1;
		search["Month"] = end1;

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/EMS/getMCRS",
			data: JSON.stringify(search),
			dataType: 'html',
			cache: false,
			timeout: 600000,
			success: function(msg) {
				if (msg != null) {
					console.log("inside success");
					$("#reportMCRS").html(msg);
					$(".loading-icon").addClass("d-none");
				}
			},
			error: function() {
				console.log("inside error");
				alert("ajax failed" + msg);
			}
		});
	});
	$("#download").click(
		function() {
			var csv_data = [];

			// Get each row data
			var rows = document.getElementsByTagName('tr');
			for (var i = 0; i < rows.length; i++) {

				// Get each column data
				var cols = rows[i].querySelectorAll('td,th');

				// Stores each csv row data
				var csvrow = [];
				for (var j = 0; j < cols.length; j++) {

					// Get the text data of each cell
					// of a row and push it to csvrow
					csvrow.push(cols[j].innerHTML);
				}

				// Combine each column value with comma
				csv_data.push(csvrow.join(","));
			}

			// Combine each row data with new line character
			csv_data = csv_data.join('\n');

			// Create CSV file object and feed
			// our csv_data into it

			var Year = $("#yearMCRS").val();
			var Month = $("#monthMCRS").val();
			CSVFile = new Blob([csv_data], {
				type: "text/csv"
			});

			// Create to temporary link to initiate
			// download process
			var temp_link = document.createElement('a');

			// Download csv file
			temp_link.download = "Year" + Year + "Month"
				+ Month + ".csv";
			var url = window.URL.createObjectURL(CSVFile);
			temp_link.href = url;

			// This link should not be displayed
			temp_link.style.display = "none";
			document.body.appendChild(temp_link);

			// Automatically click the link to
			// trigger download
			temp_link.click();
			document.body.removeChild(temp_link);
		});


	//===================================================================
//	$("#state").change(function() {
//		console.log("Inside Method2 on change state");
//		var stateName = $(this).val();
//		console.log(stateName);
//		$.ajax({
//			type: "POST",
//			url: "/EMS/getCityName",
//			data: {
//				"stateName": stateName
//			},
//			success: function(msg) {
//				if (msg != null) {
//					console.log("msg", msg)
//					console.log("inside success change");
//					$("#city").html(msg);
//				}
//			},
//			error: function() {
//				console.log("inside error");
//				alert("ajax failed" + stateName);
//			}
//		});
//	});
//
});

//=======================================================================================
//=====================State in reportMCRSUpdateSurveyorDetailsPopUp==============================================
//$("#city").change(function() {
//	console.log("Inside Method3 on change state");
//	var state = $(this).val();
//	console.log(state);
//	$.ajax({
//		type: "POST",
//		url: "/EMS/getCityName",
//		data: {
//			"state": state
//		},
//		success: function(msg) {
//			if (msg != null) {
//				console.log("msg", msg)
//				console.log("inside success 3 change");
//				$("#City").html(msg);
//			}
//		},
//		error: function() {
//			console.log("inside error");
//			alert("ajax failed" + state);
//		}
//	});
//});


//=======================================================================================

function convertMonth(dateString) {
	const months = ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUl', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'];
	const dateParts = dateString.split('-');
	const monthIndex = parseInt(dateParts[1]) - 1;
	const year = dateParts[0].substring(2);
	const month = months[monthIndex];
	return month + '-' + year;
}

function getreportMCRS(val) {
	var search = {}
	search["searchType"] = "Policy";
	search["searchValue"] = val;
	console.log("Initiating PopUp : " + val);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/getReportDetails",
		data: JSON.stringify(search),
		dataType: 'html',
		cache: false,
		timeout: 600000,
		success: function(data) {
			document.getElementById('dashboardTabs').style.display = "block";
			document.getElementById('close').style.display = "block";
			document.getElementById('dashboardTabs').innerHTML = data;
			console.log(data);
		},

		error: function(e) {

			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});

	//	function getreportMCRSPopUp(val) {
	//		var search = {}
	//
	//		search["searchType"] = "MCRSAction";
	//		search["searchValue"] = PolicyNumber;
	//		console.log("Initiating PopUp : " + val);
	//		console.log("var search" + search);
	//		$.ajax({
	//			type: "POST",
	//			contentType: "application/json",
	//			url: "/EMS/getMCRSActionPopUp",
	//			data: JSON.stringify(search),
	//			dataType: 'html',
	//			cache: false,
	//			timeout: 600000,
	//			success: function(data) {
	//				//			document.getElementById('dashboardTabs').style.display = "block";
	//				//document.getElementById('close').style.display = "block";
	//				document.getElementById('reportMCRSPopUp').innerHTML = data;
	//				console.log(data);
	//			},
	//
	//			error: function(e) {
	//
	//				var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
	//					+ e.responseText + "&lt;/pre&gt;";
	//				$('#feedback').html(json);
	//
	//				console.log("ERROR : ", e);
	//				$("#btn-search").prop("disabled", false);
	//
	//			}
	//		});
	//
	//	}
	//
}
function getreportMCRS(val) {
	var search = {}
	search["searchType"] = "Policy";
	search["searchValue"] = val;
	console.log("Initiating PopUp : " + val);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/getReportDetails",
		data: JSON.stringify(search),
		dataType: 'html',
		cache: false,
		timeout: 600000,
		success: function(data) {
			document.getElementById('dashboardTabs').style.display = "block";
			document.getElementById('close').style.display = "block";
			document.getElementById('dashboardTabs').innerHTML = data;
			console.log(data);
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

	function getreportMCRSPopUp(val) {
		var search = {}

		search["searchType"] = "MCRSAction";
		search["searchValue"] = PolicyNumber;
		console.log("Initiating PopUp : " + val);
		console.log("var search" + search);
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/EMS/getMCRSActionPopUp",
			data: JSON.stringify(search),
			dataType: 'html',
			cache: false,
			timeout: 600000,
			success: function(data) {
				//			document.getElementById('dashboardTabs').style.display = "block";
				//document.getElementById('close').style.display = "block";
				document.getElementById('reportMCRSPopUp').innerHTML = data;
				console.log(data);
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
	


