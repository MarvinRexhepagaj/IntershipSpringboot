package com.internship.service;

import com.internship.model.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {
    Optional<UserDetails> findById(Long id);

    List<UserDetails> findAll();

    void save(UserDetails userDetails);

    void delete(UserDetails userDetails);

    List<UserDetails> findByPhoneNumber(String phoneNumber);
}
