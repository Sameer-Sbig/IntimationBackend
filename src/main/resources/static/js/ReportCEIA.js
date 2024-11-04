$(document).ready(function() {
	var today = new Date();
	var mm = today.getMonth() + 1; //January is 0!
	var maxMM = today.getMonth() + 4;
	var yyyy = today.getFullYear();

	console.log(minMM);
	var maxYYYY = yyyy;
	if (mm < 10) {
		mm = '0' + mm;
	}

	var minMM = today.getMonth();
	var minYYYY = yyyy;
	if (minMM < 0) {
		minMM = 15 + minMM;
		var minYYYY = yyyy - 1;
	}
	if (minMM == 0) {
		minMM = '01';
	}
	if (minMM < 10) {
		minMM = '0' + minMM;
	}

	if (maxMM < 10) {
		maxMM = '0' + maxMM;
	}
	today = yyyy + '-' + mm;
	console.log(minYYYY);
	var max = maxYYYY + "-" + maxMM;
	console.log(max);
	var min = minYYYY + "-" + minMM;
	console.log(min);
	$("#month").attr({
		"max": max, // substitute your own
		"min": min// values (or variables) here
	});
	
	$("#submit").click(function() {
		
		$(".loading-icon").removeClass("d-none");
		$('#dot-spinner').addClass('d-none');
		
		
				
		
		console.log("Inside Method2");
		var fromDate = $("#fromDatemonth").val();
		console.log("fromDate", fromDate);
		var start = moment(fromDate, "YYYY-MM-DD").format("DD-MM-YYYY");
		console.log("formattedDate", start);
		var toDate = $("#toDatemonth").val();
		var end = moment(toDate, "YYYY-MM-DD").format("DD-MM-YYYY");
		console.log("formattedDate", end);
		var searchType = $('#renewal').val();
		var search = {}
		search["searchType"] = searchType;
		
		search["fromDate"] = start;
		search["toDate"] = end;
		console.log("Searching for : " + JSON.stringify(search))
		
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/EMS/getCEIA",
			data: JSON.stringify(search),
			dataType: 'html',
			cache: false,
			timeout: 600000,
			success: function(msg) {
				if (msg != null) {
					console.log("inside success");
					$("#reportCEIA").html(msg);
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
			
			var fromDate = $("#fromDate").val();
			var toDate = $("#toDate").val();
			CSVFile = new Blob([csv_data], {
				type: "text/csv"
			});

			// Create to temporary link to initiate
			// download process
			var temp_link = document.createElement('a');

			// Download csv file
			temp_link.download = "FromDate" + fromDate + "ToDate"
				+ toDate+".csv";
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
});

function convertMonth(dateString) {
	const months = ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUl', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'];
	const dateParts = dateString.split('-');
	const monthIndex = parseInt(dateParts[1]) - 1;
	const year = dateParts[0].substring(2);
	const month = months[monthIndex];
	return month + '-' + year;
}

function getreportCEIA(val) {
	var search = {}
	
	search["searchType"] = "Policy";
	search["searchValue"] = val;
	console.log("Initiating PopUp : " + val);
	console.log("var search"+search);
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
			//document.getElementById('close').style.display = "block";
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
