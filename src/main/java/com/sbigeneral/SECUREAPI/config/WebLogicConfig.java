package com.sbigeneral.SECUREAPI.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebLogicConfig {
	
	static {
		System.setProperty("UseSunHttpHandler", "true");
	}

}
