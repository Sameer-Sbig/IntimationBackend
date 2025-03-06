package com.sbigeneral.Intimation.Util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class ClientAgentAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public ClientAgentAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
