package com.sbigeneral.Intimation.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.AgentDetails;
import com.sbigeneral.Intimation.Repository.AgentDetailsRepo;
import com.sbigeneral.Intimation.Service.AgentDetailsService;

@Service
public class AgentDetailsServiceImpl implements AgentDetailsService {

	@Autowired
	private AgentDetailsRepo agentDetailsRepo;
	
	@Override
	public AgentDetails login(String clientId, String agentId) {
		AgentDetails agentDetails;
		try {
			agentDetails = agentDetailsRepo.findByClientId(clientId);
			
			if(agentDetails==null || !agentDetails.getClientId().equals(clientId)) {
				throw new IllegalStateException("Invalid Client Id");
			}
			
			System.out.println("the session count is : "+agentDetails.getSessionCount());
			
			if(agentDetails.getSessionCount() == 0) {
				agentDetails.setSessionCount(1);
				agentDetailsRepo.save(agentDetails);
			}
			else if (agentDetails.getSessionCount() > 1) {
				throw new IllegalStateException("User is already logged in from other session");
			}
		} catch (Exception e) {
			throw new IllegalStateException("wrong credentials");
		}
		return agentDetails;
	}

	@Override
	public void logout(String clientId) {
		AgentDetails agent = agentDetailsRepo.findByClientId(clientId);
		
		if(agent != null) {
			agent.setSessionCount(0);
			agentDetailsRepo.save(agent);
		}
		
	}

}
