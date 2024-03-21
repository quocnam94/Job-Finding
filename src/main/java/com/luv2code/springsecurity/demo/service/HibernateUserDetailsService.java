package com.luv2code.springsecurity.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.HibernateUserRepository;
import com.luv2code.springsecurity.demo.entity.Users;

@Service
public class HibernateUserDetailsService implements UserDetailsService {

    private final HibernateUserRepository userRepository;

    @Autowired
    public HibernateUserDetailsService(HibernateUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userName: " + username);
        }
        String[] userRoles = user.getRole().split(",");
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(userRoles)
                .build();
    }
  
}
