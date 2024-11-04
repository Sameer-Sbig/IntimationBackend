package com.sbigeneral.PINS.model;

public class JwtResponse {

    private String token;
    private String username;
    private String vendorCode;

    public JwtResponse(String token, String username, String vendorCode) {
        this.token = token;
        this.username = username;
        this.vendorCode = vendorCode;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }
}
