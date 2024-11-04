package com.sbigeneral.PINS.Service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.Entity.PinDetails;

@Service
public interface ApiService {
    public ResponseEntity<String>  getReport(String employeeId);

    public ResponseEntity<Map<String, List<PinDetails>>> getByPinDetails(String pinNumber);
    public String getLoginImage();
}
