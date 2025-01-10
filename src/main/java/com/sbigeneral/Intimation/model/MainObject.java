package com.sbigeneral.Intimation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainObject {

	
	private Claims claims;
	@JsonProperty("Claims")
	public Claims getClaims() {
		return claims;
	}

	public void setClaims(Claims claims) {
		this.claims = claims;
	}
	
	
}
