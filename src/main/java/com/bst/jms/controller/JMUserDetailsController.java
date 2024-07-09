package com.bst.jms.controller;

import com.bst.jms.model.JMUserDetails;
import com.bst.jms.service.JMUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class JMUserDetailsController {

    @Autowired
    private JMUserDetailsService userDetailsService;

    @GetMapping("/")
    public String aboutThisApp () {
        return "Job Market Portal For All Your Job Needs";
    }

    @GetMapping("users")
    public Iterable<JMUserDetails> getAllUsers() {
        return userDetailsService.findAll();
    }
}
