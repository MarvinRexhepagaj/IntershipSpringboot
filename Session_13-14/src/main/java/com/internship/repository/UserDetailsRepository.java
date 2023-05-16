package com.internship.repository;

import com.internship.model.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {


    List<UserDetails> findByPhoneNumber(String phoneNumber);
}
