package com.sbigeneral.Intimation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClaimsWrapper {
	
	private RequestBody requestBody;

	private RequestHeader requestHeader;

	@JsonProperty("RequestBody")
	public RequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}
	@JsonProperty("RequestHeader")
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	@Override
	public String toString() {
		return "ClaimsWrapper [requestBody=" + requestBody + ", requestHeader=" + requestHeader + "]";
	}
	
	
	}
	
	


