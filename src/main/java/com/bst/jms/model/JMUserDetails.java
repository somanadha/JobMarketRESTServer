package com.bst.jms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
@Entity
@Table(name = "JMUserDetails")
@Scope("prototype")
public class JMUserDetails implements UserDetails {
    @Id
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
//    private boolean isAccountExpired;
//    private boolean isAccountLocked;
//    private boolean isCredentialsExpired;
//    private boolean isAccountEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

}
