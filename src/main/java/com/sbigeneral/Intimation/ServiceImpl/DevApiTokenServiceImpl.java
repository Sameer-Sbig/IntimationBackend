package com.sbigeneral.Intimation.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.Intimation.Controller.claimIntimationController;
import com.sbigeneral.Intimation.Service.DevApiTokenService;

@Service
public class DevApiTokenServiceImpl implements DevApiTokenService {

	private static final Logger logger = LogManager.getLogger(claimIntimationController.class);

	@Override
		public ResponseEntity<Map<String, String>> getToken() {
			// TODO Auto-generated method stub
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret","51d9ae9279382a4fa6f1becd4c41ca84");
//		    final String apiUrl ="https://devapi.sbigeneral.in/v1/tokens"; 
			final String apiUrl = "http://devapiintra.sbigen.in:8443/v1/tokens";
//			final String apiUrl = "https://devapiintrasec.sbigen.in:9443/v1/tokens";
		    HttpEntity<String> entity = new HttpEntity<String>(headers);
		    Class<Map<String,String>> responseType = (Class<Map<String,String>>) (Class<?>) Map.class;
		    
		    RestTemplate restTemplate = new RestTemplate();
		    try {
//		    	disableSSLVerification();
		    	ResponseEntity<Map<String,String>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity , responseType);
		    	logger.info("Devapi Token : "+response);
		    	System.out.println(response);
		    	return new ResponseEntity<>(response.getBody(),HttpStatus.OK);
				
			} catch (HttpClientErrorException e) {
				// TODO: handle exception
				System.out.println(e);
				logger.info("Error in fetching Devapi Token HttpClient : "+e);
				logger.info("Status code : "+e.getStatusCode());
				Map<String, String> errorMap = new HashMap<String, String>();
				errorMap.put("error", "Something went wrong");
				return new ResponseEntity<>(errorMap,e.getStatusCode());
			} catch(Exception e) {
				Map<String, String> errorMap = new HashMap<String, String>();
				logger.info("Error in fetching Devapi Token : "+e);
				return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	private void disableSSLVerification() {
		// TODO Auto-generated method stub
		logger.debug("Start of disableSSLVerification method of ImageDownloaderServiceImpl");
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCertificates = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
 
				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
 
				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
			} };
 
			// Install the trust manager
			SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
			sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("End of disableSSLVerification method of ImageDownloaderServiceImpl");
 
	}

}
