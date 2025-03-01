package com.sbigeneral.Intimation.model;

public class RequestHeaderDTO {

    private String requestID;
    private String action;
    private String channel;
    private String transactionTimestamp;
    public String getRequestID() {
        return requestID;
    }
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }
    public void setTransactionTimestamp(String transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }
    @Override
    public String toString() {
        return "RequestHeaderDTO [requestID=" + requestID + ", action=" + action + ", channel=" + channel
                + ", transactionTimestamp=" + transactionTimestamp + "]";
    }

    

}
