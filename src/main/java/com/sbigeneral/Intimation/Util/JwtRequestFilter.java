package com.sbigeneral.Intimation.Util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtAgentDetailsService jwtAgentDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		
		String username = null;
		String jwtToken = null;
		// JWT Token is passed in the form "Bearer <token>". Thus, let's remove Bearer
		//word and get the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getClientIdFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Failed to get token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token is expired");
			}
		} else {
			System.out.println("JWT Token does not begin with Bearer word");
		}

		//Validate the token
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = jwtAgentDetailsService.loadUserByUsername(username);

			// on valid token configure Spring Security to authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}
	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//	        throws ServletException, IOException {
//
//	    // Wrap the request to cache the body
//	    CachedBodyHttpServletRequest cachedRequest;
//	    try {
//	        cachedRequest = new CachedBodyHttpServletRequest(request);
//	    } catch (IOException e) {
//	        System.out.println("Error wrapping the request: " + e.getMessage());
//	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request body");
//	        return;
//	    }
//
//	    String username = null;
//	    String jwtToken = null;
//	    boolean isSimbaSource = false;
//
//	    // Check if the request body contains "source" with value "simba"
//	    try {
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        Map<String, Object> body = objectMapper.readValue(cachedRequest.getInputStream(), Map.class);
//
//	        if (body != null && "simba".equals(body.get("source"))) {
//	            isSimbaSource = true;
//	        }
//	    } catch (Exception e) {
//	        System.out.println("Error reading request body: " + e.getMessage());
//	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request body");
//	        return;
//	    }
//
//	    // If the source is not "simba", block unauthorized access
//	    if (!isSimbaSource) {
//	        chain.doFilter(cachedRequest, response); // Proceed with no security restrictions
//	        return;
//	    }
//
//	    // Process JWT only if Authorization header is present
//	    final String requestTokenHeader = cachedRequest.getHeader("Authorization");
//	    if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//	        jwtToken = requestTokenHeader.substring(7);
//	        try {
//	            username = jwtTokenUtil.getClientIdFromToken(jwtToken);
//	        } catch (IllegalArgumentException e) {
//	            System.out.println("Failed to get token");
//	        } catch (ExpiredJwtException e) {
//	            System.out.println("JWT Token is expired");
//	        }
//	    } else if (requestTokenHeader != null) {
//	        System.out.println("JWT Token does not begin with Bearer word");
//	    }
//
//	    // Validate the token
//	    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//	        UserDetails userDetails = jwtAgentDetailsService.loadUserByUsername(username);
//
//	        // Configure Spring Security authentication for valid tokens
//	        if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//	            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//	                    userDetails, null, userDetails.getAuthorities());
//	            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(cachedRequest));
//
//	            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//	        }
//	    }
//
//	    chain.doFilter(cachedRequest, response);
//	}

	

}