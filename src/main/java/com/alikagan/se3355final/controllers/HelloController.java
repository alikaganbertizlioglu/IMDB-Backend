package com.alikagan.se3355final.controllers;

import com.alikagan.se3355final.dto.StringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("https://wonderful-mushroom-0269ae10f.5.azurestaticapps.net")
public class HelloController {


    @GetMapping("/hello")
    public ResponseEntity<StringResponse> hello(){
        return ResponseEntity.status(HttpStatus.OK).body(new StringResponse("hello from secure api"));
    }

}
