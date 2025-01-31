package com.sbigeneral.Intimation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbigeneral.Intimation.Entity.MotorClaimIntimation;

public interface MotorIntimationRepo extends JpaRepository<MotorClaimIntimation, Integer>{

	@Query("SELECT c FROM MotorClaimIntimation c")
	public List<MotorClaimIntimation> getMotorIntimationData();
}
