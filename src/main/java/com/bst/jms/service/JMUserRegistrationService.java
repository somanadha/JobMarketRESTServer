package com.bst.jms.service;

import com.bst.jms.model.JMUserDetails;
import com.bst.jms.repository.JMUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JMUserRegistrationService {
    @Autowired
    private JMUserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public JMUserDetails register(JMUserDetails userDetails) {
        System.out.println("Password Before Encryption:"+ userDetails.getPassword());
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        System.out.println("Password After Encryption:"+ userDetails.getPassword());
        return repository.save(userDetails);
    }
}
