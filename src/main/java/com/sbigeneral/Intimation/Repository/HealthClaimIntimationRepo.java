package com.sbigeneral.Intimation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;

@Repository
public interface HealthClaimIntimationRepo extends JpaRepository<HealthClaimIntimation, Integer> {

	@Query("SELECT c FROM HealthClaimIntimation c")
	public List<HealthClaimIntimation> getHealthIntimationData();
}
