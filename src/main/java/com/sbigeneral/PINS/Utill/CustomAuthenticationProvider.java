package com.sbigeneral.PINS.Utill;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sbigeneral.PINS.Service.UserService;
import com.sbigeneral.PINS.model.PasswordEncode;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserDetailsService userservice;
	String SECRET_KEY="SGVsbG8gV29ybGQh";
	@Autowired
	private GCMUtilty gcmUtility;
	@Autowired
	@Lazy
	private PasswordEncoder encoder;
	
	
	// Replace with your IV
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String username = authentication.getName();
		  Object credentials = authentication.getCredentials();
		  if (credentials instanceof String && credentials != null) {
		        String combinedPassword = (String) credentials;
		       
		        // Split the combined password into password, IV, and key
//		        String[] parts = combinedPassword.split(":");
//		        if (parts.length == 3) {
//		            String password = parts[0];
//		            String iv = parts[1];
//		            String key = parts[2];
	           
	            UserDetails user = userservice.loadUserByUsername(username);
	            
	            try {

//	            String decryptedPassword = gcmUtility.decrypt(password,key,iv);
//	            System.out.println(decryptedPassword);
//	            String decryptedPassword1 = decryptedPassword.replaceAll("^\"|\"$", "");
//	            System.out.println(decryptedPassword1);
	            if (user != null )
	            {
	            	//String decryptedPassword="sbig@123";
	            	if (encoder.matches(combinedPassword, user.getPassword()))
	            	{
                    return new UsernamePasswordAuthenticationToken(username, combinedPassword, user.getAuthorities());
                } 
	            	else {
	                    throw new AuthenticationCredentialsNotFoundException("Authentication failed for user: " + username);
	            	
	            }
	            }
	            	else {
                    throw new AuthenticationCredentialsNotFoundException("Authentication failed for user: " + username);
                }
            } catch (Exception e) {
                throw new AuthenticationServiceException("Error decrypting password", e);
            }
        } else {
            throw new AuthenticationServiceException("Invalid combined password format");
        }
	}
//    } else {
//        throw new AuthenticationServiceException("Invalid credentials type");
//    }
//}

	 @Override
	    public boolean supports(Class<?> authentication) {
	        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	    }

	    
	}

