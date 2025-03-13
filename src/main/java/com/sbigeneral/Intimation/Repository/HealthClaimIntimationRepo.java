package com.sbigeneral.Intimation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;

@Repository
public interface HealthClaimIntimationRepo extends JpaRepository<HealthClaimIntimation, Integer> {

	@Query("SELECT c FROM HealthClaimIntimation c")
	public List<HealthClaimIntimation> getHealthIntimationData();
	
	@Query("SELECT c FROM HealthClaimIntimation c WHERE c.requestId =:requestId")
	public List<HealthClaimIntimation> getHealthIntimationByRequestId(@Param("requestId") String requestId);

	@Query("SELECT c FROM HealthClaimIntimation c WHERE c.policyNumber =:policyNumber")
	public List<HealthClaimIntimation> getHealthIntimationByPolicyNo(@Param("policyNumber") String policyNumber);
}
