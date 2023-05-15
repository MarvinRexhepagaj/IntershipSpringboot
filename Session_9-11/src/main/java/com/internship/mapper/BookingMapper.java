package com.internship.mapper;

import com.internship.model.dto.BookingDTO;
import com.internship.model.entity.Booking;
import com.internship.model.entity.Flight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class BookingMapper {

    public static List<BookingDTO> mapToBookingDTOList(List<Booking> bookingList) {
        List<BookingDTO> bookingDTOList = new ArrayList<>();
        for (Booking booking : bookingList) {
            bookingDTOList.add(mapToBookingDTO(booking));
        }
        return bookingDTOList;
    }

    public static BookingDTO mapToBookingDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setUserId(booking.getUser().getId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setStatus(booking.getStatus());

        // Map flight IDs
        bookingDTO.setFlightIds(booking.getFlights().stream().map(flights -> flights.getId()).collect(Collectors.toSet()));

        return bookingDTO;
    }

    public static Booking mapToBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setStatus(bookingDTO.getStatus());

        // Map flight IDs
        booking.setFlights(bookingDTO.getFlightIds().stream()
                .map(flightId -> {
                    Flight flight = new Flight();
                    flight.setId(flightId);
                    return flight;
                })
                .collect(Collectors.toSet()));

        return booking;
    }



}
