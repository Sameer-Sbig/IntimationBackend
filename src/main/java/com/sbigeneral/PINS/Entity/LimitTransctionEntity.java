package com.sbigeneral.PINS.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="tbl_limit_transaction")
public class LimitTransctionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BMS_Transaction_LIMIT_DETAILS_ID_SEQ")
	@SequenceGenerator(name="BMS_Transaction_LIMIT_DETAILS_ID_SEQ", allocationSize=1,sequenceName = "BMS_Transaction_LIMIT_DETAILS_ID_SEQ")
	@Column(name = "TRAN_ID")
	private Integer Tran_id;
	@Column(name = "IMD_PARENT_CODE")
	private String IMD_parent_code;
	@Column(name = "IMD_CHILD_CODE")
	private String IMD_child_code;
	@Column(name = "QUOTE_NUMBER")
	private String QuoteNumber;
	@Column(name = "POLICYNUMBER")
	private String PolicyNumber;
	@Column(name = "ACDNUMBER")
	private String ACD_number;
	@Column(name = "PREMIUM")
	private String premium;
	@Column(name = "TRAN_DATE")
	private Date Tran_date;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "REPLENISH_STATUS")
	private String replenish_status;
	
	public Integer getTran_id() {
		return Tran_id;
	}
	public void setTran_id(Integer tran_id) {
		Tran_id = tran_id;
	}
	public String getIMD_parent_code() {
		return IMD_parent_code;
	}
	public void setIMD_parent_code(String iMD_parent_code) {
		IMD_parent_code = iMD_parent_code;
	}
	public String getIMD_child_code() {
		return IMD_child_code;
	}
	public void setIMD_child_code(String iMD_child_code) {
		IMD_child_code = iMD_child_code;
	}
	public String getQuoteNumber() {
		return QuoteNumber;
	}
	public void setQuoteNumber(String quoteNumber) {
		QuoteNumber = quoteNumber;
	}
	public String getPolicyNumber() {
		return PolicyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		PolicyNumber = policyNumber;
	}
	public String getACD_number() {
		return ACD_number;
	}
	public void setACD_number(String aCD_number) {
		ACD_number = aCD_number;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public Date getTran_date() {
		return Tran_date;
	}
	public void setTran_date(Date tran_date) {
		Tran_date = tran_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReplenish_status() {
		return replenish_status;
	}
	public void setReplenish_status(String replenish_status) {
		this.replenish_status = replenish_status;
	}
	@Override
	public String toString() {
		return "LimitTransctionEntity [Tran_id=" + Tran_id + ", IMD_parent_code=" + IMD_parent_code
				+ ", IMD_child_code=" + IMD_child_code + ", QuoteNumber=" + QuoteNumber + ", PolicyNumber="
				+ PolicyNumber + ", ACD_number=" + ACD_number + ", premium=" + premium + ", Tran_date=" + Tran_date
				+ ", status=" + status + ", replenish_status=" + replenish_status + "]";
	}
	
	

}
