package com.alikagan.se3355final.services;

import com.alikagan.se3355final.dto.SignupRequest;
import com.alikagan.se3355final.entities.User;
import com.alikagan.se3355final.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createCustomer(SignupRequest signupRequest) {
        //check if customer already exists
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return false;
        }

        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);

        //hash the password before saving
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
        return true;
    }
}
