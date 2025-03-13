package com.sbigeneral.Intimation.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.PolicyDetails;
import com.sbigeneral.Intimation.Repository.PoilcyDetailsRepo;
import com.sbigeneral.Intimation.Service.PolicyDetailsService;

@Service
public class PolicyDetailsServiceImpl implements PolicyDetailsService {

	@Autowired
	PoilcyDetailsRepo poilcyDetailsRepo;
	
	@Override
	public Boolean checkPolicyWithAgreementCode(String policyNo, String agreementCode) {
		try {
			String agreementCodeByPolicyNo = poilcyDetailsRepo.findAgreementCodeByPolicyNo(policyNo);
			if(agreementCode.equals(agreementCodeByPolicyNo)) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PolicyDetails getPolicyByPolicyNo(String policyNo) {
		try {
			PolicyDetails policy = poilcyDetailsRepo.getPolicyDetailsByPolicyNo(policyNo);
			return policy;
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
		}
	}

	

}
