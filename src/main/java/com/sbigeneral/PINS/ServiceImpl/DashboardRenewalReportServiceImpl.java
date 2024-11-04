package com.sbigeneral.PINS.ServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.Controller.loginController;
import com.sbigeneral.PINS.Service.DashboardRenewalReportService;
import com.sbigeneral.PINS.model.BirthdayWiseReportModel;
import com.sbigeneral.PINS.model.BussinessSummarryReport;
import com.sbigeneral.PINS.model.DashboardCurrentMonthReport;
import com.sbigeneral.PINS.model.RenewalPolicyDetails;
import com.sbigeneral.PINS.model.RenewalRmsReport;

@Service
public class DashboardRenewalReportServiceImpl implements DashboardRenewalReportService {
	@Autowired
	private SessionFactory sessionfactory;
	
	@Value("${Erms.dashPolicyCountMonthReport}")
	private String DashboardCount;
	@Value("${Erms.BussinessSummaryReport}")
	private String BussinessSummaryCount;
	@Value("${Erms.BirthdayWise}")
	private String BirthdayWise;
	@Value("${Erms.PolicyDeatils}")
	private String PolicyDetails;
	private static final Logger logger=LogManager.getLogger(DashboardRenewalReportServiceImpl.class);
	@Override
	public List<DashboardCurrentMonthReport> FetchCurrentMonthDashBoardReport(String agrement) {
		Session session = this.sessionfactory.openSession();
		List<DashboardCurrentMonthReport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		System.out.println(agrement);
		LocalDate CurrentDate=LocalDate.now();
		int currentYear=CurrentDate.getYear();
		Month currentmonth= CurrentDate.getMonth();
		YearMonth yearMonth = YearMonth.of(currentYear,currentmonth);
		  DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH);
		  String formattedMonth = yearMonth.format(outputFormatter).toUpperCase(Locale.ENGLISH);
		String POLICY_EXPIRY_MONTH = formattedMonth;
		/*
		 * Month month1 = Month.of(numericMonth); String POLICY_EXPIRY_MONTH =
		 * month1.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		 */
		
		
			sql.append(this.DashboardCount.toString());
			SQLQuery query1 = session.createSQLQuery(sql.toString());
			
		query1.setParameter("POLICY_EXPIRY_MONTH", POLICY_EXPIRY_MONTH);
		
		query1.setParameter("INTERMEDIATECODE", agrement);
		List result = query1.list();
		ListIterator iterator = result.listIterator();
		while (iterator.hasNext()) {
			Object[] row = (Object[]) (Object[]) iterator.next();
			DashboardCurrentMonthReport report = new DashboardCurrentMonthReport();
			if (row[0] != null)
				report.setProductName(row[0].toString());
			if (row[1] != null)
				report.setRenewalCount(row[1].toString());
			if (row[2] != null)
				report.setRenewed(row[2].toString());
			if (row[3] != null)
				report.setRenewalDue(row[3].toString());
			if (row[4] != null)
				report.setExpired(row[4].toString());
			list.add(report);
		}
		session.close();

	
	return list;
	}

	@Override
	public List<BussinessSummarryReport> FetchdashboradSummaryReport(String agrement) {
		Session session = this.sessionfactory.openSession();
		List<BussinessSummarryReport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		System.out.println(agrement);
		LocalDate CurrentDate=LocalDate.now();
		int currentYear=CurrentDate.getYear();
		Month currentmonth= CurrentDate.getMonth();
		YearMonth yearMonth = YearMonth.of(currentYear,currentmonth);
		  DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH);
		  String formattedMonth = yearMonth.format(outputFormatter).toUpperCase(Locale.ENGLISH);
		String POLICY_EXPIRY_MONTH = formattedMonth;
		/*
		 * Month month1 = Month.of(numericMonth); String POLICY_EXPIRY_MONTH =
		 * month1.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		 */
		
		
			sql.append(this.BussinessSummaryCount.toString());
			SQLQuery query1 = session.createSQLQuery(sql.toString());
			
		query1.setParameter("POLICY_EXPIRY_MONTH", POLICY_EXPIRY_MONTH);
		
		query1.setParameter("INTERMEDIATECODE", agrement);
		List result = query1.list();
		ListIterator iterator = result.listIterator();
		while (iterator.hasNext()) {
			Object[] row = (Object[]) (Object[]) iterator.next();
			BussinessSummarryReport report = new BussinessSummarryReport();
			if (row[0] != null)
				report.setProductName(row[0].toString());
			if (row[1] != null)
				report.setTotalNumberOfpolicy(row[1].toString());
			if (row[2] != null)
				report.setDocumentPending(row[2].toString());
			if (row[3] != null)
				report.setMyQuote(row[3].toString());
			if (row[4] != null)
				report.setPaymentPanding(row[4].toString());
			list.add(report);
		}
		session.close();

	
	return list;
	}
	
	
	
	@Override
	public List<BirthdayWiseReportModel> FetchBirthdayWiseReport(String agrement) {
		Session session = this.sessionfactory.openSession();
		List<BirthdayWiseReportModel> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		System.out.println(agrement);
		LocalDate CurrentDate=LocalDate.now();
		int currentYear=CurrentDate.getYear();
//		int current
//		Month currentmonth= CurrentDate.getMonth();
//		YearMonth yearMonth = YearMonth.of(currentYear,currentmonth);
//		  DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH);
//		  String formattedMonth = yearMonth.format(outputFormatter).toUpperCase(Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
		  String formattedMonth = CurrentDate.format(outputFormatter).toUpperCase(Locale.ENGLISH);
		String POLICY_EXPIRY_MONTH = formattedMonth;
		/*
		 * Month month1 = Month.of(numericMonth); String POLICY_EXPIRY_MONTH =
		 * month1.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		 */
		System.out.println(POLICY_EXPIRY_MONTH);
		
			sql.append(this.BirthdayWise.toString());
			SQLQuery query1 = session.createSQLQuery(sql.toString());
			
		query1.setParameter("POLICY_EXPIRY_MONTH", POLICY_EXPIRY_MONTH);
		
		query1.setParameter("INTERMEDIATECODE", agrement);
		List result = query1.list();
		ListIterator iterator = result.listIterator();
		while (iterator.hasNext()) {
			Object[] row = (Object[]) (Object[]) iterator.next();
			BirthdayWiseReportModel report = new BirthdayWiseReportModel();
			if (row[0] != null)
				report.setCustomeName(row[0].toString());
			if (row[1] != null)
				report.setMobileNumber(Long.valueOf(row[1].toString()));
			if (row[2] != null)
				report.setEmailId(row[2].toString());
			if (row[3] != null)
				report.setDOB(row[3].toString());
			
			list.add(report);
		}
		session.close();

	
	return list;
	}
	
	@Override
	public List<RenewalRmsReport> FetchPolicyDetails(String byKey, String byValue,String agent_code) {
		  logger.info("Fetching policy details service  for PolicyNumber: {}", byValue);
		Session session = this.sessionfactory.openSession();
		List<RenewalRmsReport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		System.out.println(byValue);
		
		sql.append(this.PolicyDetails.toString());

		if (byKey.equalsIgnoreCase("PolicyNumber")) {

			sql.append(" and policy_no=:POLICYNUMBER");

		} else if(byKey.equalsIgnoreCase("QuoteNumber")) {
			String QuoteNumber = byValue;
			sql.append(" and QUOTE_NO=:QuoteNumber");
		}
		else if(byKey.equalsIgnoreCase("MobileNumber")) {
			String MobileNumber = byValue;
			sql.append(" and MOBILE_NUMBER=:MobileNumber");
		}
		else {
			String QuoteNumber = byValue;
			sql.append(" and EMAIL_ID=:EmailId");
		}

		SQLQuery query1 = session.createSQLQuery(sql.toString());
		if (byKey.equalsIgnoreCase("PolicyNumber")) {
			query1.setParameter("POLICYNUMBER", byValue);
			query1.setParameter("agent_code", agent_code);

		} else if(byKey.equalsIgnoreCase("QuoteNumber")) {

			query1.setParameter("QuoteNumber", byValue);
			query1.setParameter("agent_code", agent_code);

		}
		else if(byKey.equalsIgnoreCase("MobileNumber")) {
			query1.setParameter("MobileNumber", byValue);
			query1.setParameter("agent_code", agent_code);
		}
		else {
			query1.setParameter("EmailId", byValue);
			query1.setParameter("agent_code", agent_code);
		}
		logger.info(query1);
		try {
		List result = query1.list();
		ListIterator iterator = result.listIterator();
		while (iterator.hasNext()) {
			Object[] row = (Object[]) (Object[]) iterator.next();
			RenewalRmsReport report = new RenewalRmsReport();
			String flag = "";
			String flag1 = "";
			Date date = null;
			if (row[0] != null)
				report.setPOLICY_NO(row[0].toString());
			if (row[1] != null)
				report.setPOLICY_ISSUE_DATE(row[1].toString());
			if (row[2] != null)
			{
				String formattdate=null;
			
			SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date = dateformat.parse(row[2].toString());
				SimpleDateFormat dateformat1= new SimpleDateFormat("yyyy-MM-dd ");
				formattdate=dateformat1.format(date);
				System.out.println(formattdate);
				report.setPOLICY_START_DATE(formattdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (row[3] != null)
			{
				
				String formattdate1=null;
				
				SimpleDateFormat dateformat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date = dateformat2.parse(row[3].toString());
					SimpleDateFormat dateformat1= new SimpleDateFormat("yyyy-MM-dd ");
					formattdate1=dateformat1.format(date);
					System.out.println(formattdate1);
					report.setPOLICY_EXPIRY_DATE(formattdate1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if (row[4] != null)
				report.setCUSTOMER_NAME(row[4].toString());
			if (row[5] != null)
				report.setPRODUCT_NAME(row[5].toString());
			if (row[6] != null)
				report.setPRODUCT_CODE(row[6].toString());
			if (row[7] != null)
				report.setTOTAL_RENEWAL_PREMIUM(row[7].toString());
			if (row[8] != null)
				report.setPARTY_ID(row[8].toString());
			if (row[9] != null)
				report.setQUOTE_NO(row[9].toString());
			if (row[10] != null)
				report.setINTERMEDIARY_CODE(row[10].toString());
			
			
			list.add(report);
		}
		session.close();

		}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("while fetching policy details getting internal server error{}",e);
		}
	return list;
	}
}
