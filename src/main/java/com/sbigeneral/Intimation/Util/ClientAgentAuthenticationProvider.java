package com.sbigeneral.Intimation.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.sbigeneral.Intimation.Entity.Agent;
import com.sbigeneral.Intimation.Repository.AgentRepo;

@Component
public class ClientAgentAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AgentRepo agentRepo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String clientId = authentication.getName();
        String agentId = (String) authentication.getCredentials();

        Agent agent = agentRepo.findByClientId(clientId);
        if (agent == null || !agent.getAgentId().equals(agentId)) {
            throw new BadCredentialsException("INVALID_CREDENTIALS");
        }
        // if (!agent.isEnabled()) {
        //     throw new DisabledException("Agent is disabled");
        // }

        return new ClientAgentAuthenticationToken(clientId, agentId);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ClientAgentAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
