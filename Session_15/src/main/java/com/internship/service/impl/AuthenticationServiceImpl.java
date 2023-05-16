package com.internship.service.impl;

import com.internship.model.dto.AuthenticationRequest;
import com.internship.model.dto.AuthenticationResponse;
import com.internship.service.AuthenticationService;
import com.internship.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenService = tokenService;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws AuthenticationException {
        final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        authenticationResponse.setToken(tokenService.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername())));
        return authenticationResponse;


    }
}
