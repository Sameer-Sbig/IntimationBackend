	package com.sbigeneral.Intimation.ServiceImpl;
	
	import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpMethod;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	import org.springframework.web.client.RestTemplate;
	
	import com.sbigeneral.Intimation.Service.DevApiTokenService;
	
	@Service
	public class DevApiTokenServiceImpl implements DevApiTokenService {
	
		@Override
		public ResponseEntity<Map<String, String>> getToken() {
			// TODO Auto-generated method stub
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret","51d9ae9279382a4fa6f1becd4c41ca84");
		    final String apiUrl ="https://devapi.sbigeneral.in/v1/tokens"; 
		    HttpEntity<String> entity = new HttpEntity<String>(headers);
		    Class<Map<String,String>> responseType = (Class<Map<String,String>>) (Class<?>) Map.class;
		    
		    RestTemplate restTemplate = new RestTemplate();
		    try {
		    	ResponseEntity<Map<String,String>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity , responseType);
		    	System.out.println(response);
		    	return new ResponseEntity<>(response.getBody(),HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				Map<String, String> errorMap = new HashMap<String, String>();
				errorMap.put("error", "Something went wrong");
				return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	}
