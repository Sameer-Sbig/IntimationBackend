package com.sbigeneral.PINS.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.model.ExtraKmModel;

@Service
public interface ExtraKMRequestedService {

	ResponseEntity<?> getExtraKMResponse(ExtraKmModel entity);
}
