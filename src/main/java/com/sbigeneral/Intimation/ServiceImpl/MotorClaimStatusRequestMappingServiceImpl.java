package com.sbigeneral.Intimation.ServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Service.MotorClaimStatusRequestMappingService;
import com.sbigeneral.Intimation.model.FinalRequestDTO;
import com.sbigeneral.Intimation.model.MotorClaimStatusChild1;
import com.sbigeneral.Intimation.model.RequestHeaderDTO;

@Service
public class MotorClaimStatusRequestMappingServiceImpl implements MotorClaimStatusRequestMappingService {

    @Override
    public FinalRequestDTO mapRequest(MotorClaimStatusChild1 obj) {
        // TODO Auto-generated method stub
        RequestHeaderDTO requestHeaderDTO = new RequestHeaderDTO();
        requestHeaderDTO.setRequestID(obj.getRequestID());
        requestHeaderDTO.setAction("chatbotClaimSearch");
        requestHeaderDTO.setChannel("SBIGIC");
        requestHeaderDTO.setTransactionTimestamp(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy-HH:mm:ss")));
        Map<String,String> requestBodyObj = new HashMap<String,String>();
        requestBodyObj.put("Policy_no", obj.getPolicyNo());
        requestBodyObj.put("Alternate_Policy_no", obj.getAlternatePolicyNo());
        requestBodyObj.put("Claim_no",obj.getClaimNo());
        requestBodyObj.put("Vehicle_Registration_Number",obj.getVehicleRegistrationNumber());

        FinalRequestDTO finalRequestDTO = new FinalRequestDTO();
        finalRequestDTO.setRequestHeader(requestHeaderDTO);
        finalRequestDTO.setRequestBody(requestBodyObj);

        return finalRequestDTO;
    }

}
