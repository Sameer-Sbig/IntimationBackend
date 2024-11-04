$(document).ready(function() {
			console.log("Inside Function");
			$("#appSelector").change(function() {
				console.log("Inside Method2");
				var appSelector = $(this).val();
				if (appSelector) {
					$.ajax({
						type : "POST",
						url : "/EMS/uploadForm",
						data : {
							"appSelector" : appSelector
						},
						cache : false,
						success : function(msg) {
							$("#uploadForm").html(msg);
						},
						error : function() {
							console.log("inside error");
							alert("ajax failed" + appSelector);
						}
					});
				} else {
					$("#uploadForm").empty();
				}
			});
		});