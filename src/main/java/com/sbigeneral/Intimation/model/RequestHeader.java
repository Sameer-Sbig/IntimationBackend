package com.sbigeneral.Intimation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestHeader {

	private String requestId;
	private String action;
	private String channel;
	private String transactionTimestamp;
	
	@JsonProperty("requestID")
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	@JsonProperty("action")
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@JsonProperty("channel")
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	@JsonProperty("transactionTimestamp")
	public String getTransactionTimestamp() {
		return transactionTimestamp;
	}
	public void setTransactionTimestamp(String transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	@Override
	public String toString() {
		return "RequestHeader [requestId=" + requestId + ", action=" + action + ", channel=" + channel
				+ ", transactionTimestamp=" + transactionTimestamp + "]";
	}
	
	
}
