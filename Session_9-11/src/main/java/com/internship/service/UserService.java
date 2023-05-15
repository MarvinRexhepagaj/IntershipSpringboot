package com.internship.service;

import com.internship.model.dto.UserDTO;
import com.internship.model.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface UserService {


    UserDTO saveOrUpdateUser(UserDTO userDTO);

    List<UserDTO> loadAll();


    List<User> findAll();

    UserDTO loadById(Long id) throws ChangeSetPersister.NotFoundException;

    void save(User user);

    void delete(User user);

    Optional<User> findByUsername(String username);

    List<User> findByRole(String role);

    List<Object[]> findUserAndDetailsById(Long userId);


    List<UserDTO> loadAllWithDetails();


    List<UserDTO> findAllByBookings_Flights(Long flightId);


}
