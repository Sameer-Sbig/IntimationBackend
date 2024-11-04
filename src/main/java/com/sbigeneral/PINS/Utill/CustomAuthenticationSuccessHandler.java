package com.sbigeneral.PINS.Utill;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbigeneral.PINS.Entity.User;
import com.sbigeneral.PINS.Repository.UserRepository;
import com.sbigeneral.PINS.Service.UserService;
import com.sbigeneral.PINS.ServiceImpl.UserServiceImpl;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserRepository uRepo; 
	@Autowired
	private UserService userservice;
	@Autowired
	private UserSessionService userSessionService;
	
	// Service to handle user data
	private ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper
	private static final Logger logger=LogManager.getLogger(CustomAuthenticationSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		String username = authentication.getName();
		if (userSessionService.isUserAlreadyLoggedIn(username)) {
			logger.error("User is already logged in",username);
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "User is already logged in");

		} else {
			User user = userservice.FindByUserName(username);
			userSessionService.login(username, request.getSession());
			response.setContentType("text/plan");
			PrintWriter writer = response.getWriter();
			Map<String, String> responseData = new HashMap<>();
			String redirectpath;
			if (user.getFlag().equalsIgnoreCase("Y")) {
				redirectpath = "/change";
			} else {
				
				redirectpath = "/report";

			}

			response.getWriter().write(redirectpath);
		}
	}
}
