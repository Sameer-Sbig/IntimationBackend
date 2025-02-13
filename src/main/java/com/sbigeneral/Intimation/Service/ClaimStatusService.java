package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClaimStatusService {

    public ResponseEntity<?> checkMotorClaimStatus(Object obj);

    // public ResponseEntity<?> checkHealthClaimStatus(Object obj);
    
} 
