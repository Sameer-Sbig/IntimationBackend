var inputFields = [
	document.getElementById("searchBy"),
	document.getElementById("searchByValue"),];
	
inputFields.forEach(function(input) {
	input.addEventListener("change", function() {         // Display the loading indicator when any input value changes      
		
	});
});

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