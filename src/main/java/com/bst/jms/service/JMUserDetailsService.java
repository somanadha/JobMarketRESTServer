package com.bst.jms.service;

import com.bst.jms.model.JMUserDetails;
import com.bst.jms.repository.JMUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JMUserDetailsService implements UserDetailsService {
    @Autowired
    private JMUserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public Iterable<JMUserDetails> findAll() {
        var usersList = repository.findAll();

        for(var jmud : usersList) {
            jmud.setPassword("*****");
        }
        return usersList;
    }

    public JMUserDetails save(JMUserDetails user) {
        System.out.println("Password Before Encryption:"+ user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Password After Encryption:"+ user.getPassword());
        return repository.save(user);
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
