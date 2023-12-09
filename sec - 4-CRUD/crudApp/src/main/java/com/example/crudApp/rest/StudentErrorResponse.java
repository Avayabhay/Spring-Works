package com.example.crudApp.rest;

public class StudentErrorResponse {

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String response, long timeStamp) {
        this.status = status;
        this.response = response;
        this.timeStamp = timeStamp;
    }

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private String response;

    private long timeStamp;
}
