package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ApiService {

    
    public ResponseEntity<?> getSecurePolicyInfo(String policyNumber);
    public ResponseEntity<?> fetchSecurePolicyInfo(String policyNumber);
}
