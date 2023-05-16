package com.internship.repository;

import com.internship.model.dto.UserDTO;
import com.internship.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findByRole(String role);

    List<Object[]> findUserAndDetailsById(Long userId);

    List<User> findAllByBookings_Flights_Id(Long flightId);


}