package com.internship.mapper;

import com.internship.model.dto.UserDetailsDTO;
import com.internship.model.entity.UserDetails;

public class UserDetailsMapper {

    public static UserDetailsDTO mapToUserDetailsDTO(UserDetails userDetails) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(userDetails.getId());
        userDetailsDTO.setFirstName(userDetails.getFirstName());
        userDetailsDTO.setLastName(userDetails.getLastName());
        userDetailsDTO.setEmail(userDetails.getEmail());
        userDetailsDTO.setPhoneNumber(userDetails.getPhoneNumber());
        return userDetailsDTO;
    }

    public static UserDetails mapToUserDetails(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(userDetailsDTO.getId());
        userDetails.setFirstName(userDetailsDTO.getFirstName());
        userDetails.setLastName(userDetailsDTO.getLastName());
        userDetails.setEmail(userDetailsDTO.getEmail());
        userDetails.setPhoneNumber(userDetailsDTO.getPhoneNumber());
        return userDetails;
    }


}
