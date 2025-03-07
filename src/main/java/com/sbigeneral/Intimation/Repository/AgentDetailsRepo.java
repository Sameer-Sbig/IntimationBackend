package com.sbigeneral.Intimation.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbigeneral.Intimation.Entity.AgentDetails;

@Repository
public interface AgentDetailsRepo extends JpaRepository<AgentDetails, String> {

	@Query("SELECT a FROM AgentDetails a WHERE a.clientId =:clientId")
	public AgentDetails findByClientId(@Param("clientId") String clientId);
	
	@Query("UPDATE AgentDetails a SET a.token =:token WHERE a.clientId =:clientId")
	@Modifying
	@Transactional
	public void storeToken(@Param("token") String token , @Param("clientId") String clientId);
	
	@Query("SELECT a.agentId FROM AgentDetails a WHERE a.clientId =:clientId")
	public String findAgreementCodeByClientId(@Param("clientId") String clientId);
	
}
