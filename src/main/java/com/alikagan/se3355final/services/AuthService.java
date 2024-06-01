package com.alikagan.se3355final.services;

import com.alikagan.se3355final.dto.SignupRequest;

public interface AuthService {
    boolean createCustomer(SignupRequest signupRequest);
}
