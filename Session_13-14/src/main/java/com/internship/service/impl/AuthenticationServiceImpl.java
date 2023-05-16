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
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            authenticationResponse.setToken(tokenService.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername())));
        } catch (AuthenticationException e) {

            String errorMessage;
            if (e instanceof DisabledException) {
                errorMessage = "User account has been disabled";
            } else if (e instanceof BadCredentialsException) {
                errorMessage = "Invalid username or password";
            } else {
                errorMessage = "Authentication failed";
            }
            authenticationResponse.setError(errorMessage);
        }
        return authenticationResponse;
    }


}
