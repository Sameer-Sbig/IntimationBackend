package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.model.FinalRequestDTO;


@Service
public interface ClaimStatusService {

    public ResponseEntity<?> checkMotorClaimStatus(FinalRequestDTO obj);

    // public ResponseEntity<?> checkHealthClaimStatus(Object obj);
    
    public ResponseEntity<?> checkMotorStatusCustomerPortal(String claimRefNo);
    
} 
