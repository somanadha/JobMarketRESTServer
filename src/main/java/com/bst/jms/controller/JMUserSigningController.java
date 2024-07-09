package com.bst.jms.controller;

import com.bst.jms.model.JMUserDetails;
import com.bst.jms.service.JMUserSigningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class JMUserSigningController {
    @Autowired
    private JMUserSigningService userSigningService;

    @PostMapping("signIn")
    public String signIn(@RequestBody JMUserDetails userDetails){
        return userSigningService.signIn(userDetails);
    }
}
