const model = {
		  productName: null,
		  channelType: null
		};
function getProductInformation() {
  const productTypeSelect = document.getElementById('productType');
  const productNameSelect = document.getElementById('productName');
  const channelTypeSelect = document.getElementById('channelType');
  const selectedProductType = productTypeSelect.value;

  // Clear previous options
  productNameSelect.innerHTML = '';
  channelTypeSelect.innerHTML = '';

  // Update model attributes and populate the dropdown options based on the selected product type
  if (selectedProductType === 'Health') {
    model.productName = `${healthProd}`;
    model.channelType = `${healthChannl}`;
  } else if (selectedProductType === 'Motor') {
    model.productName = `${motorProd}`;
    model.channelType = `${MotorChannl}`;
  } else if (selectedProductType === 'SME') {
    model.productName = `${smeProd}`;
    model.channelType = `${smeChannl}`;
  }
 
  // Add options to the dropdowns
  const productNameOption = document.createElement('option');
  productNameOption.value = model.productName;
  productNameOption.textContent = model.productName;
  productNameSelect.appendChild(productNameOption);

  const channelTypeOption = document.createElement('option');
  channelTypeOption.value = model.channelType;
  channelTypeOption.textContent = model.channelType;
  channelTypeSelect.appendChild(channelTypeOption);
}