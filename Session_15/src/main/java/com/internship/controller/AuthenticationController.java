package com.internship.controller;

import com.internship.model.dto.AuthenticationRequest;
import com.internship.model.dto.AuthenticationResponse;
import com.internship.service.AuthenticationService;
import com.internship.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;


    private final UserDetailsService userDetailsService;

    public AuthenticationController(AuthenticationService authenticationService, TokenService tokenService, AuthenticationManager authenticationManager,  UserDetailsService userDetailsService) {
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;

        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = tokenService.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }
}


