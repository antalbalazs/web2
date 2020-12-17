package com.example.RentGames.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return new User("admin","$2y$12$JVkHXQyhQIHVjnLpW.knDeRSEhczDrSC6G8ZPHaP2tjI3JeJqNmNO", new ArrayList<>());
    }
}
