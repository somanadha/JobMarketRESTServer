package com.bst.jms.service;

import com.bst.jms.model.JMUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JMUserSigningService {

    @Autowired
    JMJwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signIn(JMUserDetails userDetails){
        String message = "Login Failed";
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword()));

            if (authentication != null && authentication.isAuthenticated()) {
                message = "Login Success. JWT Token: " + jwtService.generateToken(userDetails.getUsername());
            }
            else {
                message += ": Unknown Reason For Authentication Failure";
            }
        }
        catch (Exception ex) {
            System.out.println("Exception in Authenticating: "+ex);
            message += ": "+ex.getMessage();
        }
        return message;
    }
}
