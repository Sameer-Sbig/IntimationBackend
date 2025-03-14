package com.sbigeneral.Intimation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbigeneral.Intimation.Entity.MotorClaimIntimation;

@Repository
public interface MotorIntimationRepo extends JpaRepository<MotorClaimIntimation, Integer>{

	@Query("SELECT c FROM MotorClaimIntimation c")
	public List<MotorClaimIntimation> getMotorIntimationData();
	
	@Query("SELECT c FROM MotorClaimIntimation c WHERE c.requestId =:requestId")
	public List<MotorClaimIntimation> getMotorIntimationByRequestId(@Param("requestId") String requestId);
	
	@Query("SELECT c FROM MotorClaimIntimation c WHERE c.claimNo =:claimNo")
	public MotorClaimIntimation getMotorIntimationByClaimNo(@Param("claimNo") String claimNo);

	@Query("SELECT c FROM MotorClaimIntimation c WHERE c.policyNumber =:policyNumber")
	public List<MotorClaimIntimation> getMotorIntimationByPolicyNo(@Param("policyNumber") String policyNumber);
}
