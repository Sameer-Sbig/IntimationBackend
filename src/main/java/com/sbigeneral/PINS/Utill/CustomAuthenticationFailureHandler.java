package com.sbigeneral.PINS.Utill;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.sbigeneral.PINS.ServiceImpl.UserServiceImpl;
@Configuration
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	@Autowired
	private LoginAttemptService loginAttemptService;
	@Autowired
	private UserSessionService userSessionService;
	
	

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("Authentication Failure Handler"+exception.getMessage());
		
		String username = request.getParameter("username");
		if(username==null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "UserName is Not found in our databse");
		}

		if (loginAttemptService.isBlocked(username)) {
			response.sendError(HttpServletResponse.SC_CONFLICT, "Account is locked");
		} 
		else if (userSessionService.isUserAlreadyLoggedIn(username))
		{ response.sendError(HttpServletResponse.SC_FORBIDDEN, "User is already logged in");
		
		}
		else {
			loginAttemptService.loginFailed(username);
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password");
		}

	}

}
