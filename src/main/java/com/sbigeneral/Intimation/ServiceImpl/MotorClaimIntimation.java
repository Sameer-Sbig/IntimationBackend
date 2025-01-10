package com.sbigeneral.Intimation.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.MotorIntimation;
import com.sbigeneral.Intimation.Repository.MotorIntimationRepo;

@Service
public class MotorClaimIntimation implements com.sbigeneral.Intimation.Service.MotorClaimIntimation {
	
    @Autowired
    private MotorIntimationRepo repo;
	@Override
	public ResponseEntity<?> notifyClaim(MotorIntimation object) {
		// TODO Auto-generated method stub
		 try {
	            MotorIntimation savedObject = repo.save(object);
	            return new ResponseEntity<>(savedObject, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>("An error occurred while saving the claim: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}

}
