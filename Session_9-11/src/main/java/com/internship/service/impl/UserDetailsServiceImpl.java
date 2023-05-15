package com.internship.service.impl;

import com.internship.model.entity.UserDetails;
import com.internship.repository.UserDetailsRepository;
import com.internship.service.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }


    @Override
    public Optional<UserDetails> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserDetails> findAll() {
        return null;
    }

    @Override
    public void save(UserDetails userDetails) {

    }

    @Override
    public void delete(UserDetails userDetails) {

    }

    @Override
    public List<UserDetails> findByPhoneNumber(String phoneNumber) {
        return null;
    }
}