package com.sbigeneral.Intimation.Service;

import org.springframework.stereotype.Service;

@Service
public interface PolicyDetailsService {

	public Boolean checkPolicyWithAgreementCode(String policyNo , String agreementCode);
}
