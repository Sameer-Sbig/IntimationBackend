package com.sbigeneral.Intimation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestBody {

	
	private Claims claims;
	@JsonProperty("Claims")
	public Claims getClaims() {
		return claims;
	}

	public void setClaims(Claims claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return "RequestBody [claims=" + claims + "]";
	}
	
	
	
}
