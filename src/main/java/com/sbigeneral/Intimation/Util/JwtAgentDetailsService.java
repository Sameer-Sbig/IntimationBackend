package com.sbigeneral.Intimation.Util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.Agent;
import com.sbigeneral.Intimation.Repository.AgentRepo;

@Service
public class JwtAgentDetailsService implements UserDetailsService {
	
	@Autowired
	private AgentRepo agentRepo;

	@Override
	public UserDetails loadUserByUsername(String clientId) throws UsernameNotFoundException {
		
		Agent agent = new Agent();
		agent = null;
		try {
			agent = agentRepo.findByClientId(clientId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(agent == null) {
			throw new UsernameNotFoundException("client id " + clientId + " not found");
		}
		
		if (agent.getClientId().equals(clientId)) {
			return new User(agent.getClientId(), agent.getAgentId(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException(clientId + " is not found in the records");
		}
		
	}

}
