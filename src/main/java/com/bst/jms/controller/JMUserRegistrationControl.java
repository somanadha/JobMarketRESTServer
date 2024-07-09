package com.bst.jms.controller;

import com.bst.jms.model.JMUserDetails;
import com.bst.jms.service.JMUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class JMUserRegistrationControl {
    @Autowired
    private JMUserRegistrationService userRegistrationService;

    @PostMapping("register")
    public JMUserDetails registerUser(@RequestBody JMUserDetails user){
        return userRegistrationService.register(user);
    }
}
