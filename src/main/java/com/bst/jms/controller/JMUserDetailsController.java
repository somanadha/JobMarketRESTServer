package com.bst.jms.controller;

import com.bst.jms.model.JMUserDetails;
import com.bst.jms.service.JMUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JMUserDetailsController {

    @Autowired
    private JMUserDetailsService userService;

    @GetMapping("about")
    public String aboutThisApp (HttpServletRequest request) {
        return "Job Market Portal For All Your Job Needs: " +
                request.getSession().getId();
    }

    @GetMapping("session")
    public String session (HttpServletRequest request) {
        return "Session Id: " + request.getSession().getId();
    }

    @GetMapping("users")
    public Iterable<JMUserDetails> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("register")
    public JMUserDetails registerUser(@RequestBody JMUserDetails user){
        return userService.save(user);
    }
}
