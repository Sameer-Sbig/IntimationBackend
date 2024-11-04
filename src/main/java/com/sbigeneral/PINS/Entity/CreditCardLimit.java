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
@Table(name="tbl_IMDLIMIT")
public class CreditCardLimit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BMS_Credit_LIMIT_DETAILS_ID_SEQ")
	@SequenceGenerator(name="BMS_Credit_LIMIT_DETAILS_ID_SEQ", allocationSize=1,sequenceName = "BMS_Credit_LIMIT_DETAILS_ID_SEQ")
	@Column(name="ID")
	private Integer CreditId;
	@Column(name="IMD_PARENT_CODE")
	private String imd_paraent_code;
	@Column(name="IMD_CHILD_CODE")
	private String Imd_child_code;
	@Column(name="IMD_NAME")
	private String Imd_Name;
	@Column(name="CREDIT_LIMIT")
	private String Credit_Limit;
	@Column(name="CREDIT_PERIOD")
	private String Credit_period;
	@Column(name="LIMIT_START_DATE")
	private String Limit_start_date;
	@Column(name="LIMIT_END_DATE")
	private String Limit_end_date;
	@Column(name="ACTIVATION_STATUS")
	private String Active_status;
	@Column(name="ACD_NUMBER")
	private String ACD_number;
	@Column(name="LIMIT_SET_DATE")
	private String Limit_set_date;
	@Column(name="LIMIT_SET_BY")
	private String Limit_set_By;
	@Column(name="LIMIT_UPDATE_DATE")
	private String Limit_update_date;
	@Column(name="LIMIT_UPDATE_BY")
	private String Limit_update_by;
	public Integer getCreditId() {
		return CreditId;
	}
	public void setCreditId(Integer creditId) {
		CreditId = creditId;
	}
	public String getImd_paraent_code() {
		return imd_paraent_code;
	}
	public void setImd_paraent_code(String imd_paraent_code) {
		this.imd_paraent_code = imd_paraent_code;
	}
	public String getImd_child_code() {
		return Imd_child_code;
	}
	public void setImd_child_code(String imd_child_code) {
		Imd_child_code = imd_child_code;
	}
	public String getImd_Name() {
		return Imd_Name;
	}
	public void setImd_Name(String imd_Name) {
		Imd_Name = imd_Name;
	}
	public String getCredit_Limit() {
		return Credit_Limit;
	}
	public void setCredit_Limit(String credit_Limit) {
		Credit_Limit = credit_Limit;
	}
	public String getCredit_period() {
		return Credit_period;
	}
	public void setCredit_period(String credit_period) {
		Credit_period = credit_period;
	}
	public String getLimit_start_date() {
		return Limit_start_date;
	}
	public void setLimit_start_date(String limit_start_date) {
		Limit_start_date = limit_start_date;
	}
	public String getLimit_end_date() {
		return Limit_end_date;
	}
	public void setLimit_end_date(String limit_end_date) {
		Limit_end_date = limit_end_date;
	}
	public String getActive_status() {
		return Active_status;
	}
	public void setActive_status(String active_status) {
		Active_status = active_status;
	}
	public String getACD_number() {
		return ACD_number;
	}
	public void setACD_number(String aCD_number) {
		ACD_number = aCD_number;
	}
	public String getLimit_set_date() {
		return Limit_set_date;
	}
	public void setLimit_set_date(String limit_set_date) {
		Limit_set_date = limit_set_date;
	}
	public String getLimit_set_By() {
		return Limit_set_By;
	}
	public void setLimit_set_By(String limit_set_By) {
		Limit_set_By = limit_set_By;
	}
	public String getLimit_update_date() {
		return Limit_update_date;
	}
	public void setLimit_update_date(String limit_update_date) {
		Limit_update_date = limit_update_date;
	}
	public String getLimit_update_by() {
		return Limit_update_by;
	}
	public void setLimit_update_by(String limit_update_by) {
		Limit_update_by = limit_update_by;
	}
	@Override
	public String toString() {
		return "CreditCardLimit [CreditId=" + CreditId + ", imd_paraent_code=" + imd_paraent_code + ", Imd_child_code="
				+ Imd_child_code + ", Imd_Name=" + Imd_Name + ", Credit_Limit=" + Credit_Limit + ", Credit_period="
				+ Credit_period + ", Limit_start_date=" + Limit_start_date + ", Limit_end_date=" + Limit_end_date
				+ ", Active_status=" + Active_status + ", ACD_number=" + ACD_number + ", Limit_set_date="
				+ Limit_set_date + ", Limit_set_By=" + Limit_set_By + ", Limit_update_date=" + Limit_update_date
				+ ", Limit_update_by=" + Limit_update_by + "]";
	}
	
	

	
	
}
