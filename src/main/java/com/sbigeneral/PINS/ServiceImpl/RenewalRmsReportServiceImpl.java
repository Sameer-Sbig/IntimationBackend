package com.sbigeneral.PINS.ServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sbigeneral.PINS.Controller.loginController;
import com.sbigeneral.PINS.Entity.AgreementCodeEntity;
import com.sbigeneral.PINS.Service.RenewalRmsReportService;
import com.sbigeneral.PINS.Utill.Commons;
import com.sbigeneral.PINS.Utill.EmailSender;
import com.sbigeneral.PINS.Utill.ZipUtil;
import com.sbigeneral.PINS.model.DocSearchRequest;
import com.sbigeneral.PINS.model.DocSearchResponse;
import com.sbigeneral.PINS.model.DocSearchService;
import com.sbigeneral.PINS.model.DocumentumsearchRequest;
import com.sbigeneral.PINS.model.RenewalRmsModel;
import com.sbigeneral.PINS.model.RenewalRmsReport;

@Service
@PropertySource("classpath:sqlQuery.properties")
@PropertySource("classpath:log4j2.properties")
public class RenewalRmsReportServiceImpl implements RenewalRmsReportService {

	@Autowired
	private SessionFactory sessionfactory;

	/*
	 * @Value("${Erms.DwbiSmeRenewalPolicyReport}") private String Smedetails;
	 */
	@Value("${Erms.DwbiMotorRenewalPolicyReport}")
	private String Motordetails;

	@Autowired
	private Environment enviorment;
	@Autowired
	private EmailSender emailSender;
	private static RestTemplate restTemplate = new RestTemplate();
	private static final Logger logger = LogManager.getLogger(RenewalRmsReportServiceImpl.class);

	@Override
	public List<RenewalRmsReport> fetchRenewalrmsReport(RenewalRmsModel renewalRmsModel) {
		Session session = this.sessionfactory.openSession();
		logger.info("Fetch Renewal  report details{}", renewalRmsModel);
		List<RenewalRmsReport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		System.out.println(renewalRmsModel.getAgrementCode());
		String formattedMonth;
		String days = renewalRmsModel.getDays();

		LocalDate startDate;
		LocalDate endDate;

		/* if (renewalRmsModel.getLob().equalsIgnoreCase("Health")) { */
		sql.append(this.Motordetails.toString());

		int numericMonth = Integer.parseInt(renewalRmsModel.getMonth());
		Month month = Month.of(numericMonth);
		String POLICY_EXPIRY_MONTH = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		YearMonth yearMonth = YearMonth.of(Integer.parseInt(renewalRmsModel.getYear()), numericMonth);

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM-yy", Locale.ENGLISH);
		formattedMonth = yearMonth.format(outputFormatter).toUpperCase(Locale.ENGLISH);
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

		/*
		 * } else if (renewalRmsModel.getLob().equalsIgnoreCase("SME")) {
		 * sql.append(this.Smedetails .toString());
		 * 
		 * int numericMonth = Integer.parseInt(renewalRmsModel.getMonth()); Month month
		 * = Month.of(numericMonth); String POLICY_EXPIRY_MONTH =
		 * month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		 * 
		 * YearMonth yearMonth =
		 * YearMonth.of(Integer.parseInt(renewalRmsModel.getYear()), numericMonth);
		 * 
		 * DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM-yy",
		 * Locale.ENGLISH); formattedMonth =
		 * yearMonth.format(outputFormatter).toUpperCase(Locale.ENGLISH); switch (days)
		 * { case "1to10": startDate = yearMonth.atDay(1); endDate =
		 * startDate.plusDays(10); break; case "11to20": startDate =
		 * yearMonth.atDay(11); endDate = startDate.plusDays(9); break; case "21above":
		 * startDate = yearMonth.atDay(21); endDate = yearMonth.atEndOfMonth(); break;
		 * default: startDate = yearMonth.atDay(1); endDate = yearMonth.atEndOfMonth();
		 * break;
		 * 
		 * }
		 * 
		 * } else { sql.append(this.Motordetails.toString());
		 * 
		 * int numericMonth = Integer.parseInt(renewalRmsModel.getMonth()); Month month
		 * = Month.of(numericMonth); String POLICY_EXPIRY_MONTH =
		 * month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		 * 
		 * YearMonth yearMonth =
		 * YearMonth.of(Integer.parseInt(renewalRmsModel.getYear()), numericMonth);
		 * 
		 * DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM-yyyy",
		 * Locale.ENGLISH); formattedMonth =
		 * yearMonth.format(outputFormatter).toUpperCase(Locale.ENGLISH); switch (days)
		 * { case "1to10": startDate = yearMonth.atDay(1); endDate =
		 * startDate.plusDays(10); break; case "11to20": startDate =
		 * yearMonth.atDay(11); endDate = startDate.plusDays(9); break; case "21above":
		 * startDate = yearMonth.atDay(21); endDate = yearMonth.atEndOfMonth(); break;
		 * default: startDate = yearMonth.atDay(1); endDate = yearMonth.atEndOfMonth();
		 * break;
		 * 
		 * } }
		 */
		// logger.info("print the sql query"+sql);
		if ((null != renewalRmsModel.getYear()) && (null != renewalRmsModel.getMonth())
				&& (null != renewalRmsModel.getDays()) && (null != renewalRmsModel.getLob())
				&& (null != renewalRmsModel.getProductType())) {
			String product = renewalRmsModel.getProductType();
			String[] products = product.split(",");
			String agent_code = renewalRmsModel.getAgrementCode();
			// String intermediary_code="0065359";
			System.out.println(agent_code);
			String sqlQuery = sql.toString();

			if (Arrays.asList(products).contains("All")) {
				/* sqlQuery = sqlQuery.replaceAll("and PRODUCT_NAME IN (:product)", " "); */
				sqlQuery = sqlQuery.replace("and PRODUCT_NAME IN (:product)", " ");
			}

			// logger.info("startDate "+startDate+"EndDate"+endDate);
			System.out.println("startdate=" + startDate);
			System.out.println("enddate=" + endDate);
			System.out.println(sqlQuery);
			SQLQuery query1 = session.createSQLQuery(sqlQuery.toString());

			// query1.setParameter("formattedMonth", formattedMonth);
			query1.setParameter("agent_code", agent_code);

			query1.setParameter("startDate", startDate);

			query1.setParameter("endDate", endDate);

			/*
			 * if (!Arrays.asList(products).contains("All")) {
			 * query1.setParameterList("product", products); }
			 */
			logger.info("print the all query with parameter " + query1);
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
				if (row[2] != null) {
					String formattdate = null;

					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						date = dateformat.parse(row[2].toString());
						SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd ");
						formattdate = dateformat1.format(date);
						System.out.println(formattdate);
						report.setPOLICY_START_DATE(formattdate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (row[3] != null) {

						String formattdate1 = null;

						SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						try {
							date = dateformat2.parse(row[3].toString());
							SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd ");
							formattdate1 = dateformat1.format(date);
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
						report.setCURRENT_PHONE_NO(row[10].toString());
					if (row[11] != null)
						report.setPRIMARY_EMAIL_ID(row[11].toString());
					if (row[12] != null)
						report.setINTERMEDIARY_CODE(row[12].toString());
					if (row[13] != null)
						report.setINTERMEDIARY_NAME(row[13].toString());
					if (row[14] != null)
						report.setSBIG_BRANCH_NAME(row[14].toString());

					list.add(report);
				}
				session.close();

			}
		}
		logger.info("fetch all the details" + list);
		return list;

	}

	@Override
	public JSONObject downloadRenewalNotice(String renewalNoticeNo, String policyNo, String option,
			HttpServletResponse response, String userId) {
		DocSearchResponse xmlResponse = null;
		String message = "";
		JSONObject jObj = new JSONObject();
		logger.info("Download  Renewal report details for renewalNoticeNo: {}", renewalNoticeNo);
		if (option.equalsIgnoreCase("downloadblk")) {
			String renewalNoticeNos[] = renewalNoticeNo.split(",");
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("DDMMYYYY");
			String folder = userId + "-" + df.format(date);
			for (String renewalNo : renewalNoticeNos) {

				xmlResponse = fetchPolicyData("Quote", "quoteId", renewalNo);
				if (xmlResponse == null) {
					System.out.println("No response returned for policy No3::" + renewalNo);
					jObj.put("Description", "No results found");
					continue;

				}
				if (xmlResponse.getResponse() == null) {
					System.out.println("No response returned for policy No4::" + renewalNo);
					jObj.put("Description", "No results found");
					continue;
				}

				String objectId = getObjectId(xmlResponse, renewalNo);

				String actualRenewalNoticeNo = renewalNo;

				if (objectId == null) {
					System.out.println("No response returned for Renewal Notice No:" + renewalNo);
					try {
						if (renewalNo.contains("-"))
							generateBlankRenewalNoticePdf(Commons.maskNumber(renewalNo, "XXXXXXXXXXXX#######"), "",
									option, response, folder, actualRenewalNoticeNo);
						else
							generateBlankRenewalNoticePdf(Commons.maskNumber(renewalNo, "XXXXXXXXXXXX####"), "", option,
									response, folder, actualRenewalNoticeNo);
						System.out.println("In option downloadblk" + renewalNo);
						jObj.put("Description", "Object id is null");
						System.out.println("Jobj::" + jObj.toJSONString());
						continue;

					} catch (Exception e) {
						System.out.println("Error in generatepolicy" + e.getMessage());
						jObj.put("Description", e.getMessage());
						return jObj;
					}
				}
				if (objectId.contains("No Results found for the given Criteria")) {
					System.out.println("No results found for Renewal Notice No:" + renewalNo);
					try {
						if (renewalNo.contains("-"))
							generateBlankRenewalNoticePdf(Commons.maskNumber(renewalNo, "XXXXXXXXXXXX#######"), "",
									option, response, folder, actualRenewalNoticeNo);
						else
							generateBlankRenewalNoticePdf(Commons.maskNumber(renewalNo, "XXXXXXXXXXXX####"), "", option,
									response, folder, actualRenewalNoticeNo);
						System.out.println("In option downloadblk" + renewalNo);
						jObj.put("Description", "No Results found for the given Criteria");
						System.out.println("Jobj::" + jObj.toJSONString());
						logger.info("Jobj::" + jObj.toJSONString());
						continue;

					} catch (Exception e) {
						jObj.put("Description", e.getMessage());
						return jObj;
					}
				}

				DocSearchResponse documentInfo = fetchPolicyData("portal_doc", "DocumentId", objectId);
				String result = getDocument(documentInfo);
				if (result.contains("No Results found for the given Criteria")) {
					System.out.println("No results found for Renewal Notice No:" + renewalNo);
					System.out.println("In option downloadblk" + renewalNo);
					jObj.put("Description", "No Results found for the given Criteria");
					System.out.println("Jobj::" + jObj.toJSONString());
					logger.info("Jobj::" + jObj.toJSONString());
					continue;
				}
				String[] documentDataArray = result.split(";");
				String policyPdfName = documentDataArray[0];
				String encodedData = documentDataArray[1];
				message = encodedData;
				try {
					if (renewalNo.contains("-"))
						generateRenewalNoticePdf(Commons.maskNumber(renewalNo, "XXXXXXXXXXXX#######"), encodedData,
								option, response, folder, actualRenewalNoticeNo);
					else
						generateRenewalNoticePdf(Commons.maskNumber(renewalNo, "XXXXXXXXXXXX####"), encodedData, option,
								response, folder, actualRenewalNoticeNo);
					continue;
				} catch (Exception e) {
					System.out.println("Error in generatepolicy:" + e.getMessage());
					jObj.put("Description", e.getMessage());
					logger.error("Error in generatepolicy:" + e.getMessage());
					return jObj;
				}

			}
			String zipFile = createZip(enviorment.getProperty("pdfPath"), folder, response);
			jObj.put("Description", "OK");
			jObj.put("DocBase64", zipFile);
			jObj.put("PdfName", folder);
			return jObj;
		}

		else {
			if (renewalNoticeNo != null) {
				xmlResponse = fetchPolicyData("Quote", "quoteId", renewalNoticeNo);
			} else {
				jObj.put("Description", "Renewal Notice Number does not exist");
				return jObj;
			}
			if (xmlResponse == null) {
				System.out.println("No response returned for policy No3::" + renewalNoticeNo);
				jObj.put("Description", "No results found");
				return jObj;
			}
			if (xmlResponse.getResponse() == null) {
				System.out.println("No response returned for policy No4::" + renewalNoticeNo);
				jObj.put("Description", "No results found");
				return jObj;
			}

			String objectId = getObjectId(xmlResponse, renewalNoticeNo);

			String actualRenewalNoticeNo = renewalNoticeNo;
			if (objectId == null) {
				System.out.println("In option Download" + renewalNoticeNo);
				jObj.put("Description", "Object id is null");
				System.out.println("Jobj::" + jObj.toJSONString());
				logger.info("Jobj::" + jObj.toJSONString());
				return jObj;
			}
			if (objectId.contains("No Results found for the given Criteria")) {
				System.out.println("In option Download" + renewalNoticeNo);
				jObj.put("Description", "No Results found for the given Criteria");
				System.out.println("Jobj::" + jObj.toJSONString());
				logger.info("Jobj::" + jObj.toJSONString());
				return jObj;
			}

			DocSearchResponse documentInfo = fetchPolicyData("portal_doc", "DocumentId", objectId);
			String result = getDocument(documentInfo);
			if (result.contains("No Results found for the given Criteria")) {
				jObj.put("Description", "No Results found for the given Criteria");
				System.out.println("Jobj::" + jObj.toJSONString());
				logger.info("Jobj::" + jObj.toJSONString());
				return jObj;
			}

			String[] documentDataArray = result.split(";");
			System.out.println("documentDataArray::" + documentDataArray);
			String policyPdfName = documentDataArray[0];
			String encodedData = documentDataArray[1];
			String folder = "";
			try {
				String pdfName = renewalNoticeNo.contains("-")
						? Commons.maskNumber(renewalNoticeNo, "XXXXXXXXXXXX#######")
						: Commons.maskNumber(renewalNoticeNo, "XXXXXXXXXXXX####");
				if (!option.equalsIgnoreCase("download")) {
					folder = generateRenewalNoticePdf(pdfName, encodedData, option, response, folder,
							actualRenewalNoticeNo);
				}
				if (option.equalsIgnoreCase("email")) {
					emailSender.sendEmail(folder, userId, policyNo, "", "", enviorment.getProperty("RMS.emailSubject"),
							enviorment.getProperty("RMS.emailFrom"), enviorment.getProperty("RMS.emailBody"));
					jObj.put("Description", "OK");
					jObj.put("message", "email Sent Successfully");
					logger.info(jObj);
					return jObj;
				}

				jObj.put("Description", "OK");
				jObj.put("DocBase64", encodedData);
				jObj.put("PdfName", pdfName);
			} catch (Exception e) {
				jObj.put("Description", e.getMessage());
				logger.error(jObj);
				return jObj;
			}

			return jObj;
		}

	}

	public DocSearchResponse fetchPolicyData(String type, String attribute, String value) {
		// TODO Auto-generated method stub
		DocSearchRequest parameters = new DocSearchRequest();

		DocSearchRequest.Header _documentumsearchRequestCreation_parametersHeader = new DocSearchRequest.Header();
		_documentumsearchRequestCreation_parametersHeader.setSender(Commons.SENDER);
		_documentumsearchRequestCreation_parametersHeader.setReceiver(Commons.RECEIVER);
		_documentumsearchRequestCreation_parametersHeader.setUserID(Commons.USER);
		parameters.setHeader(_documentumsearchRequestCreation_parametersHeader);
		DocSearchRequest.Request parametersRequest = new DocSearchRequest.Request();
		parametersRequest.setStrTypeName(type);
		parametersRequest.setStrAttrName(attribute);
		parametersRequest.setStrValue(value);
		parameters.setRequest(parametersRequest);
		System.out.println("Calling web service for " + type);
		logger.info("Calling web service for " + type);
		DocSearchResponse response = policySearchCall(parameters);
		System.out.println("Data received:: " + response.toString());
		logger.info("Data received:: " + response.toString());
		return response;
	}

	public String getObjectId(DocSearchResponse response, String policyNo) {
		List<String> URL = response.getResponse().getURL();
		String objectId = null;
		if (URL.size() == 0) {
			return "No Results found for the given Criteria";

		}
		for (String xmlData : URL) {
			System.out.println("xmlData::" + xmlData);

			if (xmlData.contains("No Results found for the given Criteria")) {
				return "No Results found for the given Criteria";
			} else if (xmlData.toUpperCase().contains("RenewalNotice_".toUpperCase())) {
				String[] tempArray = xmlData.split(";");
				objectId = tempArray[1].substring(tempArray[1].indexOf("=") + 1);
				if (xmlData.contains("DMS")) {
					objectId = tempArray[1].substring(tempArray[1].indexOf("objectId=") + 9, tempArray[1].indexOf("&"));
				} else {
					objectId = tempArray[1].substring(tempArray[1].indexOf("=") + 1);
				}
			}

		}
		return objectId;
	}

	public void generateBlankRenewalNoticePdf(String quoteNo, String encodedString, String option,
			HttpServletResponse response, String folder, String actualRenewalNoticeNo) throws IOException {
		String filePath = "";
		String mycontent = "PDF Not available for Renewal Notice No " + actualRenewalNoticeNo;
		File file1 = new File(enviorment.getProperty("pdfPath") + folder);
		if (!file1.exists())
			file1.mkdirs();

		filePath = enviorment.getProperty("pdfPath") + folder + "/" + "RenewalNotice_" + quoteNo + ".pdf";
		try {
			FileOutputStream file = new FileOutputStream(new File(filePath));
			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph(mycontent));
			// document.add(new Paragraph(new Date().toString()));

			document.close();
			file.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Pdf created ::" + filePath);
	}

	public String generateRenewalNoticePdf(String quoteNo, String encodedString, String option,
			HttpServletResponse response, String folder, String actualRenewalNoticeNo) throws IOException {
		String filePath = "";
		if (folder != null && !folder.isEmpty()) {
			File file = new File(enviorment.getProperty("pdfPath") + folder);
			if (!file.exists())
				file.mkdirs();
			filePath = enviorment.getProperty("pdfPath") + folder + "/" + "RenewalNotice_" + quoteNo + ".pdf";

		} else
			filePath = enviorment.getProperty("pdfPath") + "RenewalNotice_" + quoteNo + ".pdf";
		FileOutputStream fos = new FileOutputStream(filePath);

		Base64 b = new Base64();

		byte[] fileBytes = b.decode(encodedString);

		fos.write(fileBytes);
		fos.close();
		System.out.println("Pdf created ::" + filePath);
		return filePath;
	}

	public String getDocument(DocSearchResponse response) {
		List<String> URL = response.getResponse().getURL();
		StringBuilder responseData = new StringBuilder();
		if (URL.size() == 0) {
			return "No Results found for the given Criteria";

		}
		for (String xmlData : URL) {
			if (xmlData.contains("No Results found for the given Criteria")) {
				return "No Results found for the given Criteria";
			}

			responseData.append(xmlData + ";");

		}
		return responseData.toString();
	}

	public String createZip(String filepath, String folder, HttpServletResponse response) {
		String baseCode = "";
		try {
			System.out.println("start in createZip");

			File dir = new File(filepath + folder);
			String zipDirName = filepath + folder + ".zip";
			if (dir.getParentFile().list().length > 0) {
				ZipUtil.zipDirectory(dir, zipDirName);
				InputStream inputStream = new FileInputStream(zipDirName);
				/*
				 * response.setContentType("application/force-download");
				 * response.setHeader("Content-Disposition",
				 * "attachment; filename="+"RenewalNotice.zip"); IOUtils.copy(inputStream,
				 * response.getOutputStream()); response.flushBuffer(); inputStream.close();
				 */
				FileUtils.deleteDirectory(dir);
				File file = new File(zipDirName);
				baseCode = ZipUtil.convertZipFileToBaseEncodeString(file);
				file.delete();
			} else
				baseCode = "No file to download";

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return baseCode;
	}

	public DocSearchResponse policySearchCall(DocSearchRequest parameters) {
		// TODO Auto-generated method stub
		// logg.info("Call the web service");
		URL wsdlURL;
		try {
			wsdlURL = new URL(enviorment.getProperty("wsdl_URL"));
			DocSearchService ss = new DocSearchService(wsdlURL, Commons.SERVICE_NAME);
			DocumentumsearchRequest port = ss.getDocumentumsearchRequestSoapHttpPort();
			return port.documentumsearchRequestCreation(parameters);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}

		return null;
	}

	@Override
	public JSONObject sendRenewalSms(String mobileNo, String policyNo, String userId) {
		JSONObject jObj = new JSONObject();
		JSONObject resObj = new JSONObject();
		try {

			jObj.put("policy_no", policyNo);
			jObj.put("mobile_no", mobileNo);
			jObj.put("txn_source", "EMS");

			HttpHeaders headers = new HttpHeaders();
			headers.set("x-api-key", "Sbig@123");
			headers.set("Content-Type", "application/json");

			HttpEntity<String> requestEntity = new HttpEntity<String>(jObj.toString(), headers);
			// log.debug("requestEntity === "+jObj.toString());
			System.out.println("requestEntity === " + jObj.toString());

			String REST_URL = enviorment.getProperty("SEND_RENEWAL_SMS_URL");

			ResponseEntity<String> responseEntity = restTemplate.exchange(REST_URL, HttpMethod.POST, requestEntity,
					String.class);

			// logger.debug("getStatusCode === " +
			// responseEntity.getStatusCode().toString());
			System.out.println("getStatusCode === " + responseEntity.getStatusCode().toString());
			new JSONObject();
			if (responseEntity.getStatusCode().toString().contains("200")) {
				resObj.put("message", responseEntity.getBody().toString());
			} else {
				resObj.put("message", "SMS failed");

			}

		} catch (Exception e) {
			resObj.put("status", "SMS failed" + e.getMessage());
			System.out.println("status SMS failed" + e.getMessage());
			logger.error("status SMS failed" + e.getMessage());
		}
		return resObj;
	}

	@Override
	public JSONObject getPDF(JSONObject inJson) {

		String pdfType = (String) inJson.get("searchType");
		String pdfValue = (String) inJson.get("searchPolicy");
		String base64String = null;
		JSONObject jsObj = null;
		try {
			if (pdfType.equalsIgnoreCase("download")) {
				jsObj = getPolicypdf(pdfValue);

			} else if (pdfType.equalsIgnoreCase("Member")) {

			}
			else if(pdfType.equalsIgnoreCase("email"))
			{
				jsObj = getPolicypdf(pdfValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsObj;
	}

	private JSONObject getPolicypdf(String policyNumber) {
		String base64PolicyPdfStr = null;
		JSONObject jsObj = null;
		try {

			// base64PolicyPdfStr = getDMSPDF(policyNumber);
			/* UAT GETPDF */
			
			
//			  String REST_URL =
//			  "http://172.18.115.192:7803/GETPDF/ng/GETPDFService/GETPDF";
//			 
			 
			/* PROD GETPDF */

			
			
			
			  String REST_URL = "http://172.16.110.254:7803/GETPDF/ng/GETPDFService/GETPDF";
			 
			  
			 

			JSONObject get_policy_pdf = new JSONObject();
			get_policy_pdf.put("PolicyNumber", policyNumber);
			get_policy_pdf.put("Regeneration", "N");
			get_policy_pdf.put("SourceSystem", "DPI");
			get_policy_pdf.put("IntermediateCode", "9999999999");
			get_policy_pdf.put("ProductName", "DPI");
			get_policy_pdf.put("Offline", "N");
			final String POST_PARAMS = get_policy_pdf.toString();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> requestEntity = new HttpEntity<String>(POST_PARAMS, headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(REST_URL, HttpMethod.POST, requestEntity,
					String.class);
			base64PolicyPdfStr = responseEntity.getBody().toString();
			JSONParser parser = new JSONParser();
			jsObj = (JSONObject) parser.parse(base64PolicyPdfStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsObj;
	}

}
