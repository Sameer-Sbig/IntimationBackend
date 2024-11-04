package com.sbigeneral.PINS.Service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.sbigeneral.PINS.model.DocSearchRequest;
import com.sbigeneral.PINS.model.DocSearchResponse;
import com.sbigeneral.PINS.model.RenewalRmsModel;
import com.sbigeneral.PINS.model.RenewalRmsReport;

public interface RenewalRmsReportService {
	
	public List<RenewalRmsReport> fetchRenewalrmsReport(RenewalRmsModel renewalRmsModel);
	public JSONObject downloadRenewalNotice(String renewalNoticeNo,String policyNo,String option, HttpServletResponse response,String userId) ;
	public DocSearchResponse policySearchCall(DocSearchRequest parameters);	
	public JSONObject sendRenewalSms(String mobileNo,String policyNo,String userId);
	JSONObject getPDF(JSONObject policyNumber);
}
