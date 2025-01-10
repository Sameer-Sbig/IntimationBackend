package com.sbigeneral.Intimation.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.Intimation.Service.Decrypt;
import com.sbigeneral.Intimation.Service.DevApiTokenService;
import com.sbigeneral.Intimation.Service.HealthIntimationDevApi;

@Service
public class HealthIntimationDevApiImpl implements HealthIntimationDevApi {

	@Autowired
	private DevApiTokenService getToken;

	@Autowired
	private Decrypt decrypt;

	@Override
	public ResponseEntity<?> IntimateDevApiService(String encryptedObj) {
		try {
			ResponseEntity<Map<String, String>> token = getToken.getToken();
			System.out.println("The token is " + token.getBody());
			Map<String, String> reqBody = new HashMap<String, String>();
			reqBody.put("ciphertext", encryptedObj);
			String apiUrl = "https://devapi.sbigeneral.in/v1/Motoveys/API1/ICIntimation";
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization", token.getBody().get("accessToken"));
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(reqBody, headers);
			Class<Map<String, String>> responseType = (Class<Map<String, String>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<Map<String, String>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
						responseType);
				System.out.println(response);
				String response2 = decrypt.decrypt(response.getBody().get("ciphertext"),
						 "VTXb7e2p1iQ=","05y/Zh9tsXeFAkRCz93poem27hMLV2iX");
				System.out.println(response2);
				return new ResponseEntity<>(response2, HttpStatus.OK);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return new ResponseEntity<>("Error In Motoveys Service", HttpStatus.BAD_GATEWAY);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
