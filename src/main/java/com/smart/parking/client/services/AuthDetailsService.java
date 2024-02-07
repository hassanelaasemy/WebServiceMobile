package com.smart.parking.client.services;

import com.smart.parking.client.repository.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    public AuthDetailsService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        return authRepository.findAuthByEmail(username).orElseThrow(
                ()-> new UsernameNotFoundException("Username Or password incorecct"));
    }
}
