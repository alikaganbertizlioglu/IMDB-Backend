package com.alikagan.se3355final.dto;

public class StringResponse {
    private String message;
    public StringResponse(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "StringResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
