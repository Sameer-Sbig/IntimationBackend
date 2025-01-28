package com.sbigeneral.Intimation.ServiceImpl;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.Intimation.Service.MediTokenService;

@Service
public class MediTokenServiceImpl implements MediTokenService {

	@Override
	public String getMediToken(Map<String, String> encReqBody, String devApiToken) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization", devApiToken);
			final String apiUrl = "https://devapi.sbigeneral.in/ept/mediToken";
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(encReqBody, headers);
			Class<Map<String, String>> responseType = (Class<Map<String, String>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();

			try {
				ResponseEntity<Map<String, String>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
						responseType);
				return response.getBody().get("ACCESS_TOKEN");

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
