package com.sbigeneral.SECUREAPI.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.*;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.SECUREAPI.Controller.getPolicyInfoController;
import com.sbigeneral.SECUREAPI.Entity.SecurePolicyInfo;
import com.sbigeneral.SECUREAPI.Service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

    private static final Logger logger = LogManager.getLogger(getPolicyInfoController.class);
    
    @Autowired
	private DataSource dataSource;
    
    @Value("${myapp.getPolicyInfo}")
    private String getReportLink;
  
	@Override
	public ResponseEntity<?> getSecurePolicyInfo(String policyNumber) {
		// TODO Auto-generated method stub
		List<SecurePolicyInfo> results = new ArrayList<>();
		
		String sqlProd = "SELECT ID.POLICY_NO,ID.CUSTOMER_NAME,ID.PRODUCT_NAME,ID.AGREEMENT_CODE,ID.INTERMEDIARY_CODE, " +
					 "ID.INTERMEDIARY_NAME,ID.SBI_BRANCH,ID.SECONDARY_SALES_MANAGER_CODE, " +
					 "from DWH_LAND.INTERMEDIARIES_DATA@link_sbigans ID " + 
					 "join dwh_edw.DE_SALES_HIERARCHY@link_sbigans SH on ID.SECONDARY_SALES_MANAGER_CODE=SH.EMP_CODE " +
					 "where policy_no= ? " +
					 "group by ID.POLICY_NO,ID.CUSTOMER_NAME,ID.PRODUCT_NAME,ID.AGREEMENT_CODE,ID.INTERMEDIARY_CODE, " + 
					 "ID.INTERMEDIARY_NAME,ID.SBI_BRANCH,ID.SECONDARY_SALES_MANAGER_CODE, " +
					 "ID.SECONDARY_SALES_MANAGER_NAME,SH.EMAIL,SH.MOBILE_NUMBER ";
		String sql = "SELECT * FROM SECUREAPI WHERE POLICY_NO = ?";
		try (Connection conn = dataSource.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, policyNumber);
			try (ResultSet rs = ps.executeQuery()) {
				
				while(rs.next()) {
					SecurePolicyInfo info = new SecurePolicyInfo();
					info.setPOLICY_NO(rs.getString("POLICY_NO"));
					info.setCUSTOMER_NAME(rs.getString("CUSTOMER_NAME"));
					info.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
					info.setAGREEMENT_CODE(rs.getString("AGREEMENT_CODE"));
					info.setINTERMEDIARY_CODE(rs.getString("INTERMEDIARY_CODE"));
					info.setINTERMEDIARY_NAME(rs.getString("INTERMEDIARY_NAME"));
					info.setSBI_BRANCH(rs.getString("SBI_BRANCH"));
					info.setSECONDARY_SALES_MANAGER_CODE(rs.getString("SECONDARY_SALES_MANAGER_CODE"));
					info.setSECONDARY_SALES_MANAGER_NAME(rs.getString("SECONDARY_SALES_MANAGER_NAME"));
					info.setEMAIL(rs.getString("EMAIL"));
					info.setMOBILE_NUMBER(rs.getString("MOBILE_NUMBER"));
					results.add(info);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				logger.info("Error in fetching information based on policy information");
				return new ResponseEntity<>("Error in fetching information based on policy information" , HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Could not establish database connection");
			return new ResponseEntity<>("Could not establish database connection" , HttpStatus.BAD_GATEWAY);
		}
		
		logger.info(results);
		  if (results.isEmpty()) {
			  logger.info("No data found for following policy no" + policyNumber);
		        return new ResponseEntity<>("No data found for the given policy number", HttpStatus.NOT_FOUND);
		    }
		System.out.println(results);
//		return (ResponseEntity<?>) results;
		 return new ResponseEntity<>(results, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> fetchSecurePolicyInfo(String policyNumber) {
		// TODO Auto-generated method stub
		 MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
	        Map map = new HashMap<String, String>();
	        map.put("Content-Type", "application/json");

	        headers.setAll(map);

	        Map req_payload = new HashMap();
	        req_payload.put("policyNumber", policyNumber);

	        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
	        

			ResponseEntity<?> response = null;
			try {
		logger.info("API Url is :" + getReportLink);
		response = new RestTemplate().postForEntity(getReportLink, request, String.class);
	        System.out.println("The response is " +response.getBody());
	        
		
	} catch (Exception e) {
		// TODO: handle exception
		logger.error(e);
		return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
	}
	return new ResponseEntity<>(response.getBody(),HttpStatus.OK);
	}
    	
}
