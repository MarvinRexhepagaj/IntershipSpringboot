package com.internship.mapper;

import com.internship.model.dto.BookingDTO;
import com.internship.model.dto.UserDTO;
import com.internship.model.dto.UserDetailsDTO;
import com.internship.model.entity.Booking;
import com.internship.model.entity.User;
import com.internship.model.entity.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<UserDTO> mapToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(mapToUserDTO(user));
        }
        return userDTOList;
    }

    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());

        if (user.getUserDetails() != null) {
            UserDetailsDTO userDetailsDTO = UserDetailsMapper.mapToUserDetailsDTO(user.getUserDetails());
            userDTO.setUserDetails(userDetailsDTO);
        }

        if (user.getBookings() != null) {
            List<BookingDTO> bookingDTOs = new ArrayList<>();
            for (Booking booking : user.getBookings()) {
                BookingDTO bookingDTO = BookingMapper.mapToBookingDTO(booking);
                bookingDTOs.add(bookingDTO);
            }
            userDTO.setBookings(bookingDTOs);
        }

        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        if (userDTO.getUserDetails() != null) {
            UserDetails userDetails = UserDetailsMapper.mapToUserDetails(userDTO.getUserDetails());
            user.setUserDetails(userDetails);
        }

        if (userDTO.getBookings() != null) {
            List<Booking> bookings = new ArrayList<>();
            for (BookingDTO bookingDTO : userDTO.getBookings()) {
                Booking booking = BookingMapper.mapToBooking(bookingDTO);
                bookings.add(booking);
            }
            user.setBookings(bookings);
        }

        return user;
    }


}
