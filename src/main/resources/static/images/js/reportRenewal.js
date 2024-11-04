document.addEventListener("DOMContentLoaded", function(event) {
	var today = new Date();
	var mm = today.getMonth() + 1; //January is 0!
	var yyyy = today.getFullYear();
	if (mm < 10) {
		mm = '0' + mm;
	}

	today = yyyy + '-' + mm;
	/*$("#month").attr({
		"max": today + 3, // substitute your own
		"min": today - 2// values (or variables) here
	});*/
	document.querySelector("#month").setAttribute("max", today + 3, "min", today - 2);
//	$("#searchBy").change(function() {
//		console.log("Inside Method2");
//		var lob = $(this).val();
//		$.ajax({
//			type: "POST",
//			url: "/EMS/getProductName",
//			data: {
//				"lob": lob
//			},
//			success: function(msg) {
//				if (msg != null) {
//					console.log("inside success");
//					$("#Products").html(msg);
//				}
//			},
//			error: function() {
//				console.log("inside error");
//				alert("ajax failed" + lob);
//			}
//		});
//	});
//	$("#submit").click(function() {
//		console.log("Inside Method2");
//		var lob = $(this).val();
//		$.ajax({
//			type: "POST",
//			url: "/EMS/renewalTable",
//			//			data : {},
//			success: function(msg) {
//				if (msg != null) {
//					console.log("inside success");
//					$("#reportDetails").html(msg);
//				}
//			},
//			error: function() {
//				console.log("inside error");
//				alert("ajax failed" + msg);
//			}
//		});
//	});
});