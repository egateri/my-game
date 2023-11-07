package com.moringaschool.student.response;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author egateri@gmail.com
 *
 *
 */

public class Header {
    @JsonProperty
    private String requestRefId;
    @JsonProperty("statusCode")
    private int responseCode;
    @JsonProperty("status")
    private String responseStatus;
    @JsonProperty("message")
    private String responseMessage;
    @JsonProperty
    private String timestamp;


    public Header() {
    }

    public void setHeaders(String requestRefId,int responseCode, String responseStatus, String responseMessage, String timestamp) {
        this.requestRefId=requestRefId;
        this.responseCode = responseCode;
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
        this.timestamp = timestamp;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "HeaderResponse{}";
    }

    public String getRequestRefId() {
        return requestRefId;
    }

    public void setRequestRefId(String requestRefId) {
        this.requestRefId = requestRefId;
    }
}