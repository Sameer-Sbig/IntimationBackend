package com.sbigeneral.PINS.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.model.BirthdayWiseReportModel;
import com.sbigeneral.PINS.model.BussinessSummarryReport;
import com.sbigeneral.PINS.model.DashboardCurrentMonthReport;
import com.sbigeneral.PINS.model.RenewalPolicyDetails;
import com.sbigeneral.PINS.model.RenewalRmsReport;

public interface DashboardRenewalReportService {
	
	
	public List<DashboardCurrentMonthReport> FetchCurrentMonthDashBoardReport(String agrement);
	public List<BussinessSummarryReport> FetchdashboradSummaryReport(String agrement);
	public List<BirthdayWiseReportModel> FetchBirthdayWiseReport(String agrement);
	public List<RenewalRmsReport> FetchPolicyDetails(String byKey,String byValue,String agent_code);
	

}
