package com.bst.jms.service;

import com.bst.jms.model.JMUserDetails;
import com.bst.jms.repository.JMUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JMUserDetailsService implements UserDetailsService {
    @Autowired
    private JMUserRepository repository;

    public Iterable<JMUserDetails> findAll() {
        var usersList = repository.findAll();
        for(var jmud : usersList) {
            jmud.setPassword("*****");
        }
        return usersList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var userDetails = repository.findByUsername(username);
        if (userDetails == null){
            String errorMessage = "Error: User Not Found: "+username;
            System.out.println(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        return userDetails;
    }
}
