package com.sbigeneral.Intimation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbigeneral.Intimation.Entity.Agent;

@Repository
public interface AgentRepo extends JpaRepository<Agent, String> {

	public Agent findByClientId(String clientId);
}
