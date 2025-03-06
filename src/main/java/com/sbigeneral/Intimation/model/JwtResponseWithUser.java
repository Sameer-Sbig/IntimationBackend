package com.sbigeneral.Intimation.model;

public class JwtResponseWithUser {

	private String token;
	private String clientId;
	private String agentId;
	private String source;
	private String policyNo;
	
	public JwtResponseWithUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtResponseWithUser(String token, String clientId, String agentId, String source, String policyNo) {
		super();
		this.token = token;
		this.clientId = clientId;
		this.agentId = agentId;
		this.source = source;
		this.policyNo = policyNo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	@Override
	public String toString() {
		return "JwtResponseWithUser [token=" + token + ", clientId=" + clientId + ", agentId=" + agentId + ", source="
				+ source + ", policyNo=" + policyNo + "]";
	}
	
	
	
	
}
