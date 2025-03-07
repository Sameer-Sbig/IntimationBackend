package com.sbigeneral.Intimation.Service;

import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.AgentDetails;

@Service
public interface AgentDetailsService {

	public AgentDetails login(String clientId ,String agentId);
	
	public void logout(String clientId);
	
	public Boolean checkAgreementCodeWithClientId(String clientId , String agentId);
}
