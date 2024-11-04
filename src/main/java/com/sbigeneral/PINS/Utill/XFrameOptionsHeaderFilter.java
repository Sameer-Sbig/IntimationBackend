package com.sbigeneral.PINS.Utill;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
@Order(1)
public class XFrameOptionsHeaderFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(XFrameOptionsHeaderFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String sessionId = httpRequest.getSession().getId();
        logger.info("CustomHeaderFilter: Session ID: {}", sessionId);

        // Invalidate existing cookies and set only the specific cookie
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
            }
        }
        httpResponse.setHeader("Set-Cookie", null);
        // Set the specific JSESSIONID cookie
        String cookieHeader = "JSESSIONID=" + sessionId + "; Max-Age=43200; HttpOnly; Secure; Path=/PHS/; SameSite=Strict";
        httpResponse.addHeader("Set-Cookie", cookieHeader);
        logger.info("CustomHeaderFilter: Setting cookie: {}", cookieHeader);

        // Setting headers
        httpResponse.setHeader("X-XSS-Protection", "1; mode=block");
        httpResponse.setHeader("Content-Security-Policy", "default-src 'self'; script-src 'self' ");
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpResponse.setHeader("Expires", "0");
        httpResponse.setHeader("Pragma", "no-cache");

        // Log headers for debugging
        httpResponse.getHeaderNames().forEach(headerName ->
            logger.info("Header set: {} = {}", headerName, httpResponse.getHeader(headerName))
        );

        chain.doFilter(request, response);
    }
    @Override
   	public void init(FilterConfig filterConfig) throws ServletException {
   		// TODO Auto-generated method stub
   		Filter.super.init(filterConfig);
   	}
   	 @Override
   	public void destroy() {
   		// TODO Auto-generated method stub
   		Filter.super.destroy();
   	}
}
    