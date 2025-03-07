package com.sbigeneral.Intimation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbigeneral.Intimation.Entity.PolicyDetails;

@Repository
public interface PoilcyDetailsRepo extends JpaRepository<PolicyDetails, Integer> {

	@Query("SELECT p.agreementCode FROM PolicyDetails p WHERE p.policyNo =:policyNo")
	public String findAgreementCodeByPolicyNo(@Param("policyNo") String policyNo);
}
