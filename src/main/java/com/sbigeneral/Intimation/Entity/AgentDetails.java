package com.sbigeneral.Intimation.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CLAIMINTIMATION_AGENT_MASTER")
public class AgentDetails {

	@Id
	@Column(name = "AGENT_ID")
	private String agentId;
	
	@Column(name = "CLIENT_ID")
	private String clientId;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "SESSIONCOUNT")
	private Integer sessionCount;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getSessionCount() {
		return sessionCount;
	}

	public void setSessionCount(Integer sessionCount) {
		this.sessionCount = sessionCount;
	}

	@Override
	public String toString() {
		return "AgentMaster [agentId=" + agentId + ", clientId=" + clientId + ", token=" + token + ", sessionCount="
				+ sessionCount + "]";
	}

	
}
