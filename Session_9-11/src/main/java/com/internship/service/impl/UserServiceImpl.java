package com.internship.service.impl;

import com.internship.mapper.UserDetailsMapper;
import com.internship.mapper.UserMapper;
import com.internship.model.dto.UserDTO;
import com.internship.model.dto.UserDetailsDTO;
import com.internship.model.entity.User;
import com.internship.repository.BookingRepository;
import com.internship.repository.UserRepository;
import com.internship.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;




    public UserServiceImpl(UserRepository userRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;

    }

    @Override
    public UserDTO saveOrUpdateUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }
    @Override
    public List<UserDTO> loadAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.mapToUserDTOList(users);
    }



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public UserDTO loadById(Long id) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<Object[]> findUserAndDetailsById(Long userId) {
            return userRepository.findUserAndDetailsById(userId);
    }

    @Override
    public List<UserDTO> loadAllWithDetails() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = UserMapper.mapToUserDTO(user);
            if (user.getUserDetails() != null) {
                UserDetailsDTO userDetailsDTO = UserDetailsMapper.mapToUserDetailsDTO(user.getUserDetails());
                userDTO.setUserDetails(userDetailsDTO);
            }
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    @Override
    public List<UserDTO> findAllByBookings_Flights(Long flightId) {
        List<User> users = userRepository.findAllByBookings_Flights_Id(flightId);
        return UserMapper.mapToUserDTOList(users);
    }







}
