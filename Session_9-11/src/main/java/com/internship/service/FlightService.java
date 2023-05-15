package com.internship.service;

import com.internship.model.dto.FlightDTO;
import com.internship.model.dto.UserDTO;
import com.internship.model.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

    List<Flight> findAll();

    List<FlightDTO> loadAll();

    FlightDTO getFlightById(Long id);



    List<FlightDTO> getFlightsByDepartureDateAndOrigin(LocalDate departureDate, String origin);
}
