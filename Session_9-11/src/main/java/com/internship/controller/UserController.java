package com.internship.controller;

import com.internship.model.dto.UserDTO;
import com.internship.model.entity.User;
import com.internship.repository.UserRepository;
import com.internship.service.BookingService;
import com.internship.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;
    private final UserRepository userRepository;


    public UserController(UserService userService, BookingService bookingService, UserRepository userRepository) {
        this.userService = userService;
        this.bookingService = bookingService;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getUser() {
        return ResponseEntity.ok(userService.loadAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id) {
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

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<List<UserDTO>> getUsersByFlight(@PathVariable Long flightId) {
        List<UserDTO> userDTOList = userService.findAllByBookings_Flights(flightId);
        return ResponseEntity.ok().body(userDTOList);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.saveOrUpdateUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        UserDTO updatedUser = userService.saveOrUpdateUser(userDTO);
        return ResponseEntity.ok(updatedUser);
    }


}


