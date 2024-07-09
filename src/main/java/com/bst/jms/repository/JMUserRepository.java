package com.bst.jms.repository;

import com.bst.jms.model.JMUserDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMUserRepository extends JpaRepository<JMUserDetails, Integer> {
    JMUserDetails findByUsername(String username);
}
