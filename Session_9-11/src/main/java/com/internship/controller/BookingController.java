package com.internship.controller;

import com.internship.model.dto.BookingDTO;
import com.internship.service.BookingService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @RequestMapping(method = RequestMethod.GET,path ="/ordered-by-booking-date" )
    public List<BookingDTO> findAllBookingsOrderByBookingDateDesc() {
        return bookingService.findAllBookingsOrderByBookingDateDesc();
    }

    @GetMapping("/{bookingId}/{userId}")
    public ResponseEntity<BookingDTO> getBookingForUser(@PathVariable Long userId, @PathVariable Long bookingId) {
        try {
            BookingDTO bookingDTO = bookingService.getBookingForUser(userId, bookingId);
            return ResponseEntity.ok(bookingDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<BookingDTO>> findAllByUserId(@PathVariable Long userId) {
        List<BookingDTO> bookingDTOs = bookingService.findAllByUserId(userId);
        if (bookingDTOs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookingDTOs);
    }
    @GetMapping("/flights/{flightId}")
    public ResponseEntity<List<BookingDTO>> getAllBookingsOnFlights(@PathVariable Long flightId) {
        List<BookingDTO> bookings = bookingService.findAllBookingsOnFlights(flightId);
        if (bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }


}