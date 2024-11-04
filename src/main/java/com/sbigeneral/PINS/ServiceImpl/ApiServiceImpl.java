package com.sbigeneral.PINS.ServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.PINS.Controller.loginController;
import com.sbigeneral.PINS.Entity.PinDetails;
import com.sbigeneral.PINS.Service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

    private static final Logger logger = LogManager.getLogger(loginController.class);
    
    @Value("${myapp.getReportLink}")
    private String getReportLink;
    
    
    @Value("${myapp.getLoginImagePath}")
    private String loginImagePath;

    private static RestTemplate restTemplate = new RestTemplate();
    @Override
    public ResponseEntity<String> getReport(String employeeId) {

        
        try {
			
			String decision = "Extra KM Requested|Extra KM Approved|Case Recommend|Case Reject";

			String encodedDecision = URLEncoder.encode(decision, "UTF-8");
			String apiUrl = getReportLink + "?VendorCode=" + employeeId ;
//					+ "&Decision=" + encodedDecision;

//		       String apiUrl = "https://uat-dil.sbigen.in/services/PINModule/fetchPINDetails/v1?VendorCode=V003&Decision=Extra%20KM%20Requested|Extra%20KM%20Approved|Case%20Recommend|Case%20Reject";
			logger.info("API URL: {}", getReportLink);
			System.out.println(getReportLink);

			//URL url = new URL(apiUrl);
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				logger.debug("Response Body: {}", response.toString());
				return ResponseEntity.ok(response.toString());
			} else {
				logger.error("Failed to fetch report. Response Code: {}", responseCode);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch report");
			}

		} catch (Exception e) {
			logger.error("Error in PIN survey getReport: {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch report");
		}
    }

    @Override
    public ResponseEntity<Map<String, List<PinDetails>>> getByPinDetails(String pinNumber) {
        // TODO Auto-generated method stub
       logger.info("Response of getByPinDetails method in PIN details {}", pinNumber);
		System.out.println(pinNumber);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Class<Map<String, List<PinDetails>>> responseType = (Class<Map<String, List<PinDetails>>>) (Class<?>) Map.class;

		String apiUrl = "https://uat-dil.sbigen.in:443/services/PINModule/fetchPINDetails/v1?PINNumber=" + pinNumber;
		System.out.println(apiUrl);

		ResponseEntity<Map<String, List<PinDetails>>> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET,
				null, responseType);
		System.out.println(responseEntity.getBody());
		logger.info("Response of getByPinDetails method in PIN details {}", responseEntity.getBody());

		return responseEntity.ok(responseEntity.getBody());

    }

	@Override
	public String getLoginImage() {
		//prod path = /u01/Oracle/Middleware/Oracle_Home/user_projects/domains/base_domain/Sameer/
		//uat path == /u02/Oracle/Middleware/Oracle_Home/user_projects/domains/base_domain
		String loginPage = "";
			try {
//			loginPage = new String(Files.readAllBytes(Paths.get("/u02/Oracle/Middleware/Oracle_Home/user_projects/domains/base_domain/login.txt")));
				loginPage = new String(Files.readAllBytes(Paths.get(loginImagePath)));
			System.out.println(loginPage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginPage;
	}
    
}
