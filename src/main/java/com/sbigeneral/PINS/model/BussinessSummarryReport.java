package com.sbigeneral.PINS.model;

public class BussinessSummarryReport {
	
	private String Id;
	private String ProductName;
	private String TotalNumberOfpolicy;
	private String DocumentPending;
	private String MyQuote;
	private String PaymentPanding;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getTotalNumberOfpolicy() {
		return TotalNumberOfpolicy;
	}
	public void setTotalNumberOfpolicy(String totalNumberOfpolicy) {
		TotalNumberOfpolicy = totalNumberOfpolicy;
	}
	public String getDocumentPending() {
		return DocumentPending;
	}
	public void setDocumentPending(String documentPending) {
		DocumentPending = documentPending;
	}
	public String getMyQuote() {
		return MyQuote;
	}
	public void setMyQuote(String myQuote) {
		MyQuote = myQuote;
	}
	public String getPaymentPanding() {
		return PaymentPanding;
	}
	public void setPaymentPanding(String paymentPanding) {
		PaymentPanding = paymentPanding;
	}
	@Override
	public String toString() {
		return "BussinessSummarryReport [Id=" + Id + ", ProductName=" + ProductName + ", TotalNumberOfpolicy="
				+ TotalNumberOfpolicy + ", DocumentPending=" + DocumentPending + ", MyQuote=" + MyQuote
				+ ", PaymentPanding=" + PaymentPanding + "]";
	}
	
	
	

}
