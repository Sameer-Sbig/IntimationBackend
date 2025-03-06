package com.sbigeneral.Intimation.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.AgentDetails;
import com.sbigeneral.Intimation.Repository.AgentDetailsRepo;

@Service
public class TokenStore {

    
    @Autowired
    private AgentDetailsRepo agentMasterRepo;

    @Transactional
    public void storeToken(String token, String clientId) {
    	agentMasterRepo.storeToken(token, clientId);
    }

    public String getToken(String clientId) {
    	AgentDetails agent = agentMasterRepo.findByClientId(clientId);
        return agent != null ? agent.getToken() : null;
    }

}