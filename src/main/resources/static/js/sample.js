var grid = new ej.grids.Grid({
   dataSource: data,
   columns: [
            { field: 'OrderID', headerText: 'Order ID', width: 120, textAlign: 'Right' },
            { field: 'EmployeeID', headerText: 'Employee ID', width: 150, textAlign: 'Right' },
            { field: 'Freight', width: 120, format: 'C2', textAlign: 'Right' },
            { field: 'ShipCountry', headerText: 'Ship Country', width: 150 }
        ]
});
grid.appendTo('#Grid');
 
document.getElementById("Gridform").addEventListener("submit", (e) => {
e.preventDefault();
  var value = parseInt(document.getElementById('multiplier').value, 10);
 
 // Filtering the data with user input value
  data = new ej.data.DataManager(window.hierarchyOrderdata).executeLocal(new ej.data.Query().where("EmployeeID", "equal", value).take(15));
 
  // Assigning to DataGrid
  grid.dataSource = data;
 
  document.getElementById("userinput").style.display = "none";
  document.getElementById("mtable").style.display = "";
  document.getElementById("Gridform").reset();
});
document.getElementById("close").addEventListener("click", (e)=>{
document.getElementById("mtable").style.display = "none";
document.getElementById("userinput").style.display = "";
});
 