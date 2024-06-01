package com.alikagan.se3355final.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String name;
    private String password;
    private String country;
    private String city;
}
