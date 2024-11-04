package com.sbigeneral.PINS.ServiceImpl;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.PINS.Service.UserDetailsService;

@Service
public class VendorLogoutServiceImpl {

	private ThreadPoolTaskScheduler taskScheduler;

	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Autowired
	UserDetailsService userDetailsService;

	public VendorLogoutServiceImpl() {
		this.taskScheduler = new ThreadPoolTaskScheduler();
		this.taskScheduler.setPoolSize(1);
		this.taskScheduler.initialize();
	}

	public void scheduleLogout(String vendorCode) {
		taskScheduler.schedule(() -> callLogout(vendorCode),
				new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(26)));
		// this will execute after 16 mins
		System.out.println("The scheduler has been set");

	}

	public void callLogout(String vendorCode) {
		

		System.out.println("Calling logout due to inactivity");
		userDetailsService.logout(vendorCode); // Call the logout method
		System.out.println("User logout done");
		// Send response indicating successful logout
	}

}
