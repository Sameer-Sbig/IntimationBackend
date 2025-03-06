package com.sbigeneral.Intimation.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CLAIMINTIMATION_AGENT_MASTER")
public class Agent {

	@Id
	@Column(name = "AGENT_ID")
	private String agentId;
	
	@Column(name = "CLIENT_ID")
	private String clientId;

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

	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", clientId=" + clientId + "]";
	}
	
	
}
