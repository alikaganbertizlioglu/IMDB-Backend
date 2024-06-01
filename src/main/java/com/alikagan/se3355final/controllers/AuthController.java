package com.alikagan.se3355final.controllers;

import com.alikagan.se3355final.dto.LoginRequest;
import com.alikagan.se3355final.dto.LoginResponse;
import com.alikagan.se3355final.dto.SignupRequest;
import com.alikagan.se3355final.dto.StringResponse;
import com.alikagan.se3355final.entities.User;
import com.alikagan.se3355final.services.AuthService;
import com.alikagan.se3355final.services.jwt.UserServiceImpl;
import com.alikagan.se3355final.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/auth")
@CrossOrigin
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;
    private final AuthService authService;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserServiceImpl userService,
                          JwtUtil jwtUtil, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }


    @PostMapping(value = "/signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringResponse> signupUser(@RequestBody SignupRequest signupRequest){
        boolean isUserCreated = authService.createCustomer(signupRequest);
        if(isUserCreated){
            return ResponseEntity.status(HttpStatus.CREATED).body(new StringResponse("User created successfully"));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StringResponse("Failed to create user"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        }catch (AuthenticationException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDetails userDetails;
        User user;
        try {
            userDetails = userService.loadUserByUsername(loginRequest.getEmail());
            user = userService.findByEmail(loginRequest.getEmail()).orElseThrow();
        }catch (UsernameNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new LoginResponse(jwt, user.getId(),user.getName()));
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
