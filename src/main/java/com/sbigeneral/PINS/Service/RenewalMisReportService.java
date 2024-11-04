package com.sbigeneral.PINS.Service;

import java.util.List;

import com.sbigeneral.PINS.model.RenewalMisReport;
import com.sbigeneral.PINS.model.RenewalRmsModel;
import com.sbigeneral.PINS.model.RenewalRmsReport;

public interface RenewalMisReportService {

	
	public List<RenewalMisReport> fetchRenewalMisReport(RenewalRmsModel renewalRmsModel);
}
