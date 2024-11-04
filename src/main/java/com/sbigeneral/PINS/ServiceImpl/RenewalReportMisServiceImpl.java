package com.sbigeneral.PINS.ServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.Controller.RenewalRmsReportController;
import com.sbigeneral.PINS.Service.RenewalMisReportService;
import com.sbigeneral.PINS.model.RenewalMisReport;
import com.sbigeneral.PINS.model.RenewalRmsModel;
import com.sbigeneral.PINS.model.RenewalRmsReport;

@Service
@PropertySource("classpath:sqlQuery.properties")
@PropertySource("classpath:log4j2.properties")
public class RenewalReportMisServiceImpl implements RenewalMisReportService {
	private static final Logger logger=LogManager.getLogger(RenewalReportMisServiceImpl.class);
	
	@Autowired
	private SessionFactory sessionfactory;
	@Autowired
	private Environment enviorment;

	@Value("${mis.SmeproductType}")
	private String Smedetails;

	@Value("${mis.Motordwbiquery}")
	private String Motordetails;
	@Value("${mis.Healthdwbiquery}")
	private String healthdetails;
	
	@Override
	public List<RenewalMisReport> fetchRenewalMisReport(RenewalRmsModel renewalRmsModel) {
		Session session = this.sessionfactory.openSession();
		logger.info("Get all RmS renewal report");
		List<RenewalMisReport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		//System.out.println(user);
		String formattedMonth;
		String days = renewalRmsModel.getDays();
		String renewalstatus=renewalRmsModel.getRenewalDue();
		LocalDate startDate;
		LocalDate endDate;
		String user=renewalRmsModel.getAgrementCode();

		if (renewalRmsModel.getLob().equalsIgnoreCase("Health")) {
			sql.append(this.healthdetails.toString());
			
			int numericMonth = Integer.parseInt(renewalRmsModel.getMonth());
			Month month = Month.of(numericMonth);
			String POLICY_EXPIRY_MONTH = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

			YearMonth yearMonth = YearMonth.of(Integer.parseInt(renewalRmsModel.getYear()), numericMonth);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yy");
			formattedMonth = yearMonth.format(formatter);
			switch (days) {
			case "1to10":
				startDate = yearMonth.atDay(1);
				endDate = startDate.plusDays(10);
				break;
			case "11to20":
				startDate = yearMonth.atDay(11);
				endDate = startDate.plusDays(9);
				break;
			case "21above":
				startDate = yearMonth.atDay(21);
				endDate = yearMonth.atEndOfMonth();
				break;
			default:
				startDate = yearMonth.atDay(1);
				endDate = yearMonth.atEndOfMonth();
				break;

			}
			
			
		} else if (renewalRmsModel.getLob().equalsIgnoreCase("SME")) {
			sql.append(this.Smedetails.toString());
			
			int numericMonth = Integer.parseInt(renewalRmsModel.getMonth());
			Month month = Month.of(numericMonth);
			String POLICY_EXPIRY_MONTH = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

			
			YearMonth yearMonth = YearMonth.of(Integer.parseInt(renewalRmsModel.getYear()), numericMonth);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yy");
			formattedMonth = yearMonth.format(formatter);
			switch (days) {
			case "1to10":
				startDate = yearMonth.atDay(1);
				endDate = startDate.plusDays(10);
				break;
			case "11to20":
				startDate = yearMonth.atDay(11);
				endDate = startDate.plusDays(9);
				break;
			case "21above":
				startDate = yearMonth.atDay(21);
				endDate = yearMonth.atEndOfMonth();
				break;
			default:
				startDate = yearMonth.atDay(1);
				endDate = yearMonth.atEndOfMonth();
				break;

			}
			
			
		} else {
			sql.append(this.Motordetails.toString());
			
			int numericMonth = Integer.parseInt(renewalRmsModel.getMonth());
			Month month = Month.of(numericMonth);
			String POLICY_EXPIRY_MONTH = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

			//YearMonth yearMonth = YearMonth.of(Integer.parseInt(renewalRmsModel.getYear()), numericMonth);

			YearMonth yearMonth = YearMonth.of(Integer.parseInt(renewalRmsModel.getYear()), numericMonth);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yy");
			formattedMonth = yearMonth.format(formatter);
			switch (days) {
			case "1to10":
				startDate = yearMonth.atDay(1);
				endDate = startDate.plusDays(10);
				break;
			case "11to20":
				startDate = yearMonth.atDay(11);
				endDate = startDate.plusDays(9);
				break;
			case "21above":
				startDate = yearMonth.atDay(21);
				endDate = yearMonth.atEndOfMonth();
				break;
			default:
				startDate = yearMonth.atDay(1);
				endDate = yearMonth.atEndOfMonth();
				break;

			}
		}
			
			
		logger.info("print the sql query"+sql);
		
			String product=renewalRmsModel.getProductType();
			
			String[] products = product.split("\\|");
			
			//String INTERMEDIARY_CODE=renewalRmsModel.getIntermediaryNames();
			//System.out.println(INTERMEDIARY_CODE);
			//String user1=renewalRmsModel.getSaleMName(); 
			//System.out.println(user1);
			
			
			
			String sqlQuery = sql.toString();
			
			
			
			 if (Arrays.asList(products).contains("All")) {
					/* sqlQuery = sqlQuery.replaceAll("and PRODUCT_NAME IN (:product)", " "); */
					sqlQuery = sqlQuery.replace("and PRODUCT_NAME IN (:product)", " ");
				}	
			
//			if (smName.equalsIgnoreCase("All")) {
//				sqlQuery = sqlQuery.replaceAll("and and INTERMEDIARY_CODE:=INTERMEDIARY_CODE", " ");
//			}
			
			 //user="0065359";
			
			logger.info("startDate "+startDate+"EndDate"+endDate);
			System.out.println("startdate="+startDate);
			System.out.println("enddate="+endDate);
			System.out.println(sqlQuery);
			SQLQuery query1 = session.createSQLQuery(sqlQuery.toString());
			
			query1.setParameter("formattedMonth", formattedMonth);
			
			
				query1.setParameter("user", user);
			
			
			query1.setParameter("startDate", startDate);
			
			query1.setParameter("endDate", endDate);
			
			/*
			 * if(!Arrays.asList(products).contains("All")) {
			 * query1.setParameterList("product", products); }
			 */
			
		
			
			
			
			logger.info("print the all query with parameter "+query1);
			List result = query1.list();

			ListIterator iterator = result.listIterator();
			
			while (iterator.hasNext()) {
				Object[] row = (Object[]) (Object[]) iterator.next();
				RenewalMisReport report = new RenewalMisReport();
				String flag = "";
				String flag1 = "";
				Date date = null;
				
				if (row[0] != null)
					report.setPOLICY_NO(row[0].toString());
				if (row[1] != null)
					report.setINSURED_NAME(row[1].toString());
				if (row[2] != null)
					report.setCURRENT_PHONE_NO(row[2].toString());
				if (row[3] != null)
					report.setPRIMARY_EMAIL_ID(row[3].toString());
				if (row[4] != null)
				{
					
					String formattdate=null;
					
					SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						date = dateformat.parse(row[4].toString());
						SimpleDateFormat dateformat1= new SimpleDateFormat("yyyy-MM-dd");
						formattdate=dateformat1.format(date);
						System.out.println(formattdate);
						report.setPOLICY_EXPIRY_DATE(formattdate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if (row[5] != null)
					report.setPOLICY_EXPIRY_MONTH(row[5].toString());
				if (row[6] != null)
					report.setPRODUCT_NAME(row[6].toString());
				if (row[7] != null)
					report.setINTERMEDIARY_CODE(row[7].toString());
				if (row[8] != null)
					report.setINTERMEDIARY_NAME(row[8].toString());
				if (row[9] != null)
					report.setTOTAL_RENEWAL_PREMIUM(row[9].toString());
				if (row[10] != null)
					report.setRENEWAL_QUOTE_STATUS(row[10].toString());
				if (row[11] != null)
					report.setRENEWAL_NOTICE_STATUS(row[11].toString());
				if (row[12] != null)
					report.setAUTO_RENEWAL_FLAG(row[12].toString().toUpperCase());
				if (row[13] != null)
					report.setREGION(row[13].toString());
				if (row[14] != null)
					report.setLOB(row[14].toString());
				if (row[15] != null)
					flag1=Objects.toString(row[15].toString(),"");
				 flag=flag1.trim();
				if(flag.equalsIgnoreCase("Y"))
				{
					report.setRENEWAL_FLAG("RENEWED");
				}
				else
				{
					
					if (isToday(date)) {
				        report.setRENEWAL_FLAG("RENEW DUE");
				    } else if (date.compareTo(new Date()) > 0) {
				        report.setRENEWAL_FLAG("RENEW DUE");
				    } else {
				        report.setRENEWAL_FLAG("EXPIRED");
				    }
				}					
				
				if (row[16] != null)
					report.setSECONDRY_SM_CODE(row[16].toString());
				if (row[17] != null)
					report.setRENEWAL_QUOTE_NUMBER(row[17].toString());
				if (row[18] != null)
					report.setLOAN_ACCOUNT_NUMBER(row[18].toString());
				if (row[19] != null)
					report.setSBIG_BRANCH_NAME(row[19].toString());
				if (row[20] != null)
					report.setSBI_ACCOUNT_NUMBER(row[20].toString());
				if(report.getLOB().equals("Motor"))
				{
				if (row[21] != null)
					report.setREGISTRATION_NUMBER(row[21].toString());
				if (row[22] != null)
					report.setYEAR_OF_MANUFACTURING(row[22].toString());
				if (row[23] != null)
					report.setCHASSIS_NUMBER(row[23].toString());
				if (row[24] != null)
					report.setMAKE(row[24].toString());
				if (row[25] != null)
					report.setMODEL(row[25].toString());
				if (row[26] != null)
					report.setNCB_AMOUNT(row[26].toString());
				}
				list.add(report);
			}
			session.close();
		
		
		logger.info("fetch all the details"+list);
		return list;
	}
	

// Function to check if a date is today's date
public static boolean isToday(Date date) {
    Date today = new Date();
    return date.getYear() == today.getYear() &&
           date.getMonth() == today.getMonth() &&
           date.getDate() == today.getDate();
}

}
