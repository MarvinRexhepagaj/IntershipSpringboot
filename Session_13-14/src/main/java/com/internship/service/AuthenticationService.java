package com.internship.service;

import com.internship.model.dto.AuthenticationRequest;
import com.internship.model.dto.AuthenticationResponse;

public interface AuthenticationService {


    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
