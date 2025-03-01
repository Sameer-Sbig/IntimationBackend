package com.sbigeneral.Intimation.Service;

import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.model.FinalRequestDTO;
import com.sbigeneral.Intimation.model.MotorClaimStatusChild1;

@Service
public interface MotorClaimStatusRequestMappingService {

    public FinalRequestDTO mapRequest(MotorClaimStatusChild1 obj);
}
