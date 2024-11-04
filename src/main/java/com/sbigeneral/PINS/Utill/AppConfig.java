package com.sbigeneral.PINS.Utill;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppConfig {
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://commonsecure.sbigen.in/VBIM/","http://172.16.232.92:7002/PIN","http://localhost:4200","https://secure.sbigeneral.in","http://localhost:5173", "http://172.18.115.105:7003/BMS", "https://ansappsuat.sbigen.in")); //

		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		
		  configuration.setAllowedHeaders(Arrays.asList("authorization",
		  "content-type", "x-auth-token" ,"content-security-policy" , "clientid"));
		  configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		 
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Bean
	public CorsFilter crosfilter() {
		return new CorsFilter(corsConfigurationSource());
		
	}

}
