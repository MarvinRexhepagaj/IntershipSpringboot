package com.internship.service;

import com.internship.model.dto.BookingDTO;
import com.internship.model.entity.Booking;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();

    List<BookingDTO> findAllBookingsOrderByBookingDateDesc();





    BookingDTO getBookingForUser(Long userId, Long bookingId);



    List<BookingDTO> findAllByUserId(Long userId);
}
