package com.sbigeneral.PINS.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.Entity.UploadImage;


@Service
public interface UpdateStatusService {
	
	ResponseEntity<?> updateStatus(UploadImage obj);
	
}
