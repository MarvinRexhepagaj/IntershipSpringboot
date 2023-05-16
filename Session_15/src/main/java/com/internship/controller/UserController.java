package com.internship.controller;

import com.internship.exception.UserNotFoundException;
import com.internship.mapper.UserMapper;
import com.internship.model.dto.UserDTO;
import com.internship.model.entity.User;
import com.internship.repository.UserRepository;
import com.internship.service.BookingService;
import com.internship.service.UserService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
@Schema
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;
    private final UserRepository userRepository;


    public UserController(UserService userService, BookingService bookingService, UserRepository userRepository) {
        this.userService = userService;
        this.bookingService = bookingService;
        this.userRepository = userRepository;
    }

    @PreAuthorize(value ="hasRole('USER')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getUser() {
        return ResponseEntity.ok(userService.loadAll());
    }
    @PreAuthorize(value ="hasRole('USER')")
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        try {
            return ResponseEntity.ok(userService.loadById(id));
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/userWithDetails")
    public List<UserDTO> loadAllWithDetails() {
        return userService.loadAllWithDetails();
    }
    @PreAuthorize(value ="hasRole('USER')")
    @GetMapping("/flights/{flightId}")
    public ResponseEntity<List<UserDTO>> getUsersByFlight(@PathVariable Long flightId) {
        List<UserDTO> userDTOList = userService.findAllByBookings_Flights(flightId);
        return ResponseEntity.ok().body(userDTOList);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO userDTO) {
        User savedUser = userService.createNewUser(userDTO);
        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

}


