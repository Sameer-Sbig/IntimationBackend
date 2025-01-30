package com.sbigeneral.Intimation.ServiceImpl;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.Intimation.Controller.claimIntimationController;
import com.sbigeneral.Intimation.Service.MediTokenService;

@Service
public class MediTokenServiceImpl implements MediTokenService {
	
	private static final Logger logger = LogManager.getLogger(claimIntimationController.class);

	@Override
	public String getMediToken(Map<String, String> encReqBody, String devApiToken) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization", devApiToken);
//			final String apiUrl = "https://devapi.sbigeneral.in/ept/mediToken";
//			final String apiUrl = "https://devapiintrasec.sbigen.in:9443/ept/mediToken";
			final String apiUrl = "http://devapiintra.sbigen.in:8443/ept/mediToken";
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(encReqBody, headers);
			Class<Map<String, String>> responseType = (Class<Map<String, String>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();

			try {
				ResponseEntity<Map<String, String>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
						responseType);
				logger.info("Medi Token : "+response);
				return response.getBody().get("ACCESS_TOKEN");

			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				logger.info("Error in fetching Medi Token httpClient : "+e);
				logger.info("Status code : "+e.getStatusCode());
				return null;
			} catch(Exception e) {
				e.printStackTrace();
				logger.info("Error in fetching Medi : "+e);
				return null;
			}

		
	}

}
