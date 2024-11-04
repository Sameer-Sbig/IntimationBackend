/**
 * 
 */
 function getUploadDetails() {
			var searchBySelect = document.getElementById("appSelector");
			var value = searchBySelect.options[searchBySelect.selectedIndex].value;
//  			var searchByValue = document.getElementById("searchByValue").value;
			var search = {}
		search["searchType"] = value;
// 			search["searchValue"] = searchByValue;
			$.ajax({
 				type : "POST",
 				contentType : "application/json",
 				url : "/EMS/getUploadForms",
 				data : JSON.stringify(search),
 				dataType : 'html',
 				cache : false,
 				timeout : 600000,
 				success : function(data) {

 					document.getElementById('uploadForm').innerHTML = data;

 				},
			error : function(e) {

				var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
						+ e.responseText + "&lt;/pre&gt;";
					$('#feedback').html(json);

 					console.log("ERROR : ", e);
 					$("#btn-search").prop("disabled", false);

 				}
 			});

 			// Some operations with parameters IP and Port
 		}
