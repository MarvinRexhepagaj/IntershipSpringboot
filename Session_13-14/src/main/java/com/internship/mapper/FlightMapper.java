package com.internship.mapper;

import com.internship.model.dto.FlightDTO;
import com.internship.model.entity.Flight;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper {

    public static FlightDTO mapToFlightDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flight.getId());
        flightDTO.setOrigin(flight.getOrigin());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setStatus(flight.getStatus());
        flightDTO.setBookingIds(flight.getBookings().stream().map(bookings -> bookings.getId()).collect(Collectors.toSet()));

        return flightDTO;
    }

    public static List<FlightDTO> mapToFlightDTOList(List<Flight> flights) {
        return flights.stream().map(FlightMapper::mapToFlightDTO).collect(Collectors.toList());
    }



}