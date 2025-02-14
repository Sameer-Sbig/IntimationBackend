package com.sbigeneral.Intimation.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinalRequestDTO {

    @JsonProperty("RequestHeader")
    private RequestHeaderDTO requestHeader;
    @JsonProperty("RequestBody")
    private Map<String,String> requestBody;
    public RequestHeaderDTO getRequestHeader() {
        return requestHeader;
    }
    public void setRequestHeader(RequestHeaderDTO requestHeader) {
        this.requestHeader = requestHeader;
    }
    public Map<String, String> getRequestBody() {
        return requestBody;
    }
    public void setRequestBody(Map<String, String> requestBody) {
        this.requestBody = requestBody;
    }
    @Override
    public String toString() {
        return "FinalRequestDTO [requestHeader=" + requestHeader + ", requestBody=" + requestBody + "]";
    }
    
   
    
}
