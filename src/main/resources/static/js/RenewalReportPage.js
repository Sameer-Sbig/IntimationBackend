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
	$("#searchBy").change(function() {
		console.log("Inside Method2");
		var lob = $(this).val();
		$.ajax({
			type: "POST",
			url: "/EMS/getProductName",
			data: {
				"lob": lob
			},
			success: function(msg) {
				if (msg != null) {
					console.log("inside success");
					$("#Products").html(msg);
				}
			},
			error: function() {
				console.log("inside error");
				alert("ajax failed" + lob);
			}
		});
	});
	$("#submit").click(function() {
		console.log("Inside Method2");
		var lob = $("#searchBy").val();
		var product = $("#Products").val();
		var month = $("#month").val();
		var date = convertMonth(month);
		var status = $("#renewal").val();

		var search = {}
		search["searchType"] = "RMS";
		search["lob"] = lob;
		search["product"] = product;
		search["date"] = date;
		search["status"] = status;

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/EMS/getRenewalReport",
			data: JSON.stringify(search),
			dataType: 'html',
			cache: false,
			timeout: 600000,
			success: function(msg) {
				if (msg != null) {
					console.log("inside success");
					$("#reportDetails").html(msg);
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
			var lob = $("#searchBy").val();
			var product = $("#Products").val();
			var month = $("#month").val();
			var date = convertMonth(month);
			var status = $("#renewal").val();
			CSVFile = new Blob([csv_data], {
				type: "text/csv"
			});

			// Create to temporary link to initiate
			// download process
			var temp_link = document.createElement('a');

			// Download csv file
			temp_link.download = lob + "_" + product + "_"
				+ date + "_" + status + ".csv";
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
