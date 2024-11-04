package com.sbigeneral.PINS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbigeneral.PINS.Entity.CreditCardLimit;

@Repository
public interface CreditCardLimitRepo extends JpaRepository<CreditCardLimit, Integer> {
	
	
	@Query("select e from CreditCardLimit e where e.imd_paraent_code=:imd_paraent_code ")
	public List<CreditCardLimit> fetchCreditCardDetailsByAgremtCode(String imd_paraent_code);

}
