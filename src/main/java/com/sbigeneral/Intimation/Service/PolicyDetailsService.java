package com.sbigeneral.Intimation.Service;

import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.PolicyDetails;

@Service
public interface PolicyDetailsService {

	public Boolean checkPolicyWithAgreementCode(String policyNo , String agreementCode);

	public PolicyDetails getPolicyByPolicyNo(String policyNo);
}
