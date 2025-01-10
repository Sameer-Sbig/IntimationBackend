package com.sbigeneral.Intimation.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Repository.HealthClaimIntimationRepo;
import com.sbigeneral.Intimation.Service.HealthClaimIntimationService;

@Service
public class HealthClaimIntimationServiceImpl implements HealthClaimIntimationService {
	
	@Autowired
	private HealthClaimIntimationRepo healthClaimRepo;

	@Override
	public ResponseEntity<?> saveHealthClaim(HealthClaimIntimation obj) {
		try {
			healthClaimRepo.save(obj);
			return new ResponseEntity<>("Health Claim Saved Successfully !" , HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			e.getLocalizedMessage();
			return new ResponseEntity<>("Error Ocurred "+e.getLocalizedMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
