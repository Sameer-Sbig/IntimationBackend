/**
 * 
 */
function getPolicyDetails1(val) {
	var hiddenPolValue = document.getElementById("policyNumber").value;
     console.log("Inside getPolicyDetails js ")
	var search = {}
	search["searchType"] = "Policy";
	search["searchValue"] = val;
	 console.log("Inside getPolicyDetails js : " , search )
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/getPolicyDetails",
		data: JSON.stringify(search),
		dataType: 'html',
		cache: false,
		timeout: 600000,
		success: function(data) {
			document.getElementById('dashboardTabs').style.display = "block";
			document.getElementById('close').style.display = "block";
			document.getElementById('dashboardTabs').innerHTML = data;
			;
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
function getReport(val) {

}
//======================Claim Action tab details============================================
function getPolicyDetails(val) {
	var hiddenPolValue = document.getElementById("claimNumber").value;

	var search = {}
	search["searchType"] = "Claim";
	search["searchValue"] = val;
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/getActionClaimDetails",
		data: JSON.stringify(search), 
		dataType: 'html',
		cache: false,
		timeout: 600000,
		success: function(data) {
			document.getElementById('dashboardTabs').style.display = "block";
			document.getElementById('close').style.display = "block";
			document.getElementById('dashboardTabs').innerHTML = data;
			
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
