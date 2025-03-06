package com.sbigeneral.Intimation.Util;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 8869344122384649326L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}