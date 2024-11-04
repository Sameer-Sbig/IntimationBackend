/**
 * 
 */

function bodyOnLoad() {
	//alert("on lead hide table");

selectBulk = [];


}
selectBulk = [];
function getCommonDetails() {
	var searchBySelect = document.getElementById("searchBy");
	var value = searchBySelect.options[searchBySelect.selectedIndex].value;
	var searchByValue = document.getElementById("searchByValue").value;
	
	console.log("searchByType : " + value);
	
	if(value=="Policy_Number") {
     var tmpValue = searchByValue;
	// alert(searchByValue.length);
	if (searchByValue.length < 16) {
		for (var i = searchByValue.length + 1; i <= 16; i++) {
			var tmpValue = "0" + tmpValue;
		}
	}
	}else{
		var tmpValue = searchByValue;
	}
		var search = {}
		search["searchType"] = value;
		search["searchValue"] = tmpValue;
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/EMS/getCommonDetails",
			data: JSON.stringify(search),
			dataType: 'html',
			cache: false,
			timeout: 600000,
			success: function(data) {
				document.getElementById('commonDetails').innerHTML = data;
				console.log("universal search");
				let loadingSpinner = document.getElementById('loadingIndicator');
				loadingSpinner.style.display = "none";
			},
			error: function(e) {
				var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
					+ e.responseText + "&lt;/pre&gt;";
				$('#feedback').html(json);
				console.log("ERROR : ", e);
				$("#btn-search").prop("disabled", false);
			}
		});	
	// Some operations with parameters IP and Port
}


function getRmsExcel()
{

var search={}
var yearMCRS = document.getElementById("yearMCRS").value;
var monthMCRS = document.getElementById("monthMCRS").value;
var lobMcrs = document.getElementById("lobMcrs").value;
var daysMCRS = document.getElementById("daysMCRS").value;
var ProducetRms = document.getElementById("ProducetRms").value;

console.log(daysMCRS);

search["year"] = yearMCRS;
search["month"] = monthMCRS;
search["lob"] = lobMcrs;
search["days"] = daysMCRS;
search["producet"] = ProducetRms;
var currentDate = new Date();      
var formattedDate = currentDate.toISOString().slice(0, 10);       
var filename = "RenewalRmsReport-" + formattedDate + ".xlsx";
$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/EMS/RmsExcel",
			data: JSON.stringify(search),
			  contentType: 'application/json',
            xhrFields: {
                responseType: 'blob' // Set the response type to blob
            },
            success: function(data) {
                var blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });

                var link = document.createElement('a');
                link.href = URL.createObjectURL(blob);
                link.download = filename;
                link.click();

                // Clean up
                URL.revokeObjectURL(link.href);
            },
            error: function(xhr, status, error) {
                // Handle error, e.g. display an error message
            }
        });
        
   

}



function getSubmit() {
    var search = {};
    var yearMCRS = document.getElementById("yearMCRS").value;
    var monthMCRS = document.getElementById("monthMCRS").value;
    var lobMcrs = document.getElementById("lobMcrs").value;
    var daysMCRS = document.getElementById("daysMCRS").value;
    var ProducetRms = document.getElementById("ProducetRms").value;
    var Channelname = document.getElementById("Channelname").value;
    var Intermediaryname1 = document.getElementById("Intermediaryname1").value;
    var SMname1 = document.getElementById("SMname1").value;

    if (!formValidation()) {
        return; // Exit if validation fails
    }
    var datacontainer1 = document.getElementById("datacontainer1");  
       datacontainer1.style.display = "none";
       
    var loadingIndicator = document.getElementById("loadingIndicator");  
       loadingIndicator.style.display = "block";
    

    search["year"] = yearMCRS;
    search["month"] = monthMCRS;
    search["lob"] = lobMcrs;
    search["days"] = daysMCRS;
    search["producet"] = ProducetRms;
    search["Channelname"] = Channelname;
    search["Intermediaryname1"] = Intermediaryname1;
    search["SMname1"] = SMname1;

    $.ajax({
        type: "POST",
        url: "/EMS/Reports",
        data: JSON.stringify(search),
        contentType: "application/json",
        dataType: 'html',
        cache: false,
        timeout: 600000,
        success: function(data) {
         loadingIndicator.style.display = "none";
          datacontainer1.style.display = "block";
            document.getElementById('datacontainer1').innerHTML = data;
            $('#filtertable').DataTable({
                lengthMenu: [5, 10, 50, 100, 200],
                scrollX: true,
                scrollY: 250
            });
            
        },
        error: function(e) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;" + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);
             loadingIndicator.style.display = "none";
            console.log("ERROR : ", e);
            displayMessage("An error occurred during the request.");
        }
    });
}

function displayMessage(message) {
    var messageContainer = document.getElementById("message");
    messageContainer.innerHTML = "<div class='error-message'>" + message + "</div>";
}

function formValidation() {
    var yearMCRS = document.getElementById("yearMCRS").value;
    var monthMCRS = document.getElementById("monthMCRS").value;
    var lobMcrs = document.getElementById("lobMcrs").value;
    var daysMCRS = document.getElementById("daysMCRS").value;
    var ProducetRms = document.getElementById("ProducetRms").value;
	var Channelname = document.getElementById("Channelname").value;
    if (yearMCRS == "") {
        displayMessage("Please select year.");
        return false;
    }
    if (monthMCRS == "") {
        displayMessage("Please select month.");
        return false;
    }
    if (lobMcrs == "") {
        displayMessage("Please select LOB.");
        return false;
    }
    if (daysMCRS == "") {
        displayMessage("Please select Days.");
        return false;
    }
    if (ProducetRms == "") {
        displayMessage("Please select Product.");
        return false;
    }
    if (Channelname == "") {
        displayMessage("Please select Channel.");
        return false;
    }
    return true;
}

function downloadNotice(val1,val2,val3) {
   

	var search = {};
	
	if(val3 == "downloadblk")
	{
		if(selectBulk.length == 0)
			{
				toastr.error("Kindly select checkbox");
			return false;
			}
		else if(selectBulk.length >50)
			{
				toastr.error("select less than or equal 50 checkboxes");
			return false;
			}
	search["searchValue"] = selectBulk.toString();
	search["searchPolicy"] = val2;	
	search["searchType"] = val3;
	}
	else{
	search["searchValue"] = val1;
	search["searchPolicy"] = val2;	
	search["searchType"] = val3;
	}
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/generateRenewalNote",
		data: JSON.stringify(search),
		cache: false,
		timeout: 600000,
		success: function(data) {


			if (data.Description != "OK") {
               toastr.error(data.Description);
			}
			else {
				
				if(val3 == "email" || val3 == "sms")
				{
				toastr.success(data.message);
				}
              else{
				var bufferArray = base64ToArrayBuffer(data.DocBase64);
				if(val3 == "download"){
					var blobStore = new Blob([bufferArray], { type: "application/pdf" });
					}
					else if(val3 == "downloadblk")
					{	
					var blobStore = new Blob([bufferArray], { type: "application/zip" });
					}
				
				if (window.navigator && window.navigator.msSaveOrOpenBlob) {
					window.navigator.msSaveOrOpenBlob(blobStore);
					return;
				}
				var datab = window.URL.createObjectURL(blobStore);
				var link = document.createElement('a');
				document.body.appendChild(link);
				link.href = datab;
				link.download = data.PdfName;
				link.click();
				window.URL.revokeObjectURL(datab);
				link.remove();
				toastr.success('Downloaded Successfully');

			}}
		},
		error: function(e) {
			toastr.error(e.responseText);
			
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
}

  function chk_status(ele,value) {
	    	 //var checkedValue = $('#chk_sts_str:checked').val();
              if (ele.checked) {
            	 /*  alert("checked::"+value);   */
            	 if(!selectBulk.includes(value)){
            		 selectBulk.push(value);
            	 }
              }
              else{
            	/*  alert("unchecked::"+value);  */
            	  var index = selectBulk.indexOf(value);
            	  if (index > -1) { // only splice array when item is found
            		  selectBulk.splice(index, 1); // 2nd parameter means remove one item only
            	  }
              }
            
            
        }
	    
	    function checkAll(ele) {
	        var checkboxes = document.getElementsByName('chksts');
	        if (ele.checked) {
	            for (var i = 0; i < checkboxes.length; i++) {
	                if (checkboxes[i].type == 'checkbox') {
	                    checkboxes[i].checked = true;
                         selectBulk.push(checkboxes[i].value);
	                    
	                }
	            }
	           /*   alert("selectBulk:"+selectBulk);  */
	        } else {
	            for (var i = 0; i < checkboxes.length; i++) {
	                if (checkboxes[i].type == 'checkbox') {
	                    checkboxes[i].checked = false;
	                    selectBulk=[];
	                }
	            }
	            /*  alert("selectBulk:"+selectBulk);  */
	        }
	    }

function sendSmsPopUp(mNo,polNo)
{
	$.ajax({
			type : "GET",
			url : "/EMS/openSmsPopup",
			cache : false,
			timeout : 600000,
			dataType : 'html',
			success : function(msg) {
				if (msg != null) {
					console.log("inside success");
			      $('#sendSmsPopUp').removeClass('d-none');	
					$("#sendSmsPopUp").html(msg);
					document.getElementById("polNo").innerHTML = "Send SMS For Policy - "+polNo;
					document.getElementById("mobileNo").value = mNo;

				}
			},
			error : function() {
				console.log("inside error");
				alert("ajax failed" + policyNumber);
			}
		});
}

function sendRenewalSms()
{
	var mNo = document.getElementById("mobileNo").value;
	var polNo = document.getElementById("polNo").innerHTML;
	polNo = polNo.replace('Send SMS For Policy - ', '');
	var search = {};
	search["mobileNo"]=mNo;
	search["policyNo"]=polNo;

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/sendRenewalSms",
		data: JSON.stringify(search),
		cache: false,
		timeout: 600000,
		success: function(data) {
				toastr.success(data.message);

			},
		error: function(e) {
			toastr.error(e.responseText);
			
			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});
}

function getRenewalPopup(Mcode,status)
{
var lobMcrs = document.getElementById("lobMcrs").value;
var month = document.getElementById("month").value;
var search = {};
	search["lobMcrs"]=lobMcrs;
	search["month"]=month;
	search["status"]=status;
	search["Mcode"]=Mcode;

   
       
   var loadingIndicatorforpoup = document.getElementById("loadingIndicatorforpopup");  
       loadingIndicatorforpoup.style.display = "block";

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/GetRenewalDeshboardReport",
		data: JSON.stringify(search),
		cache: false,
		timeout: 600000,
		success: function(data) {
		 loadingIndicatorforpoup.style.display = "none";
          $('#datacontainer2').removeClass('d-none');
          document.getElementById('datacontainer2').innerHTML = data;
			
			
            $('#filtertable1').DataTable({
            "pageLength":7
                 });
           
			},
		error: function(e) {
			toastr.error(e.responseText);
			
			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});
}
 

function sendSmsPopUpUAT()
{
	var search = {};
	search["mobileNo"]="8108328336";
	search["policyNo"]="0000000025632563";

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/EMS/sendRenewalSms",
		data: JSON.stringify(search),
		cache: false,
		timeout: 600000,
		success: function(data) {
				toastr.success(data.status);

			},
		error: function(e) {
			toastr.error(e.responseText);
			
			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});
	}
	
function closeDPopUp ()
{
	console.log("close-works");
			$('#datacontainer2').addClass('d-none');
			$('#DashboardTablePopUpblur').addClass('d-none');
}
 			
 	
	
	
	