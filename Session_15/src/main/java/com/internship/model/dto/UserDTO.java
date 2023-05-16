package com.internship.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.internship.model.entity.User;

import java.util.List;
@JsonSerialize

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String role;
    private UserDetailsDTO userDetails;
    private List<BookingDTO> bookings;


    public UserDTO() {

    }

    public UserDetailsDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", userDetailsDTO='" + userDetails + '\'' +
                ", bookings='" + bookings + '\'' +

                '}';
    }
}