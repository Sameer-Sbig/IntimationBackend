package com.sbigeneral.Intimation.Util;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 6239921560724451905L;
	
	private String agentId;
	private String clientId;
	private String policyNo;
	private String source;
	
	public JwtRequest()
	{
		
	}

	public JwtRequest(String agentId, String clientId, String policyNo, String source) {
		super();
		this.agentId = agentId;
		this.clientId = clientId;
		this.policyNo = policyNo;
		this.source = source;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JwtRequest [agentId=" + agentId + ", clientId=" + clientId + ", policyNo=" + policyNo + ", source="
				+ source + "]";
	}

	

	
}