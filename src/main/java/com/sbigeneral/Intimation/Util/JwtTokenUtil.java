package com.sbigeneral.Intimation.Util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sbigeneral.Intimation.Service.TokenStore;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {


	private static final long serialVersionUID = 1L;

	public static final long JWT_TOKEN_VALIDITY = 15 * 900;  // we have kept 1 min validity

	//@Value("${jwt.secret}")
	private String secret = "javatrainingschool";
	 	
	 @Autowired
	 private TokenStore tokenStore; 

	//get username from jwt token
	public String getClientIdFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	//get expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
    //secret key needed
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	//it checks if the token is expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	//this generates token
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	//claims of the token like Issuer, Expiration, Subject, and the ID
	//HS512 algorithm is used here to sign the token
	//JWT is compacted using compact() to a URL-safe string 
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	//this validates token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getClientIdFromToken(token);
		final String currentToken = tokenStore.getToken(username); ;
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && token.equals(currentToken) );
	}
	
}