package com.internship.service.impl;

import com.internship.mapper.BookingMapper;
import com.internship.model.dto.BookingDTO;
import com.internship.model.entity.Booking;
import com.internship.repository.BookingRepository;
import com.internship.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<BookingDTO> findAllBookingsOrderByBookingDateDesc() {
        List<Booking> bookings = bookingRepository.findAllByOrderByBookingDateDesc();
        return BookingMapper.mapToBookingDTOList(bookings);
    }
    @Override
    public BookingDTO getBookingForUser(Long userId, Long bookingId) {
        Optional<Booking> booking = bookingRepository.findByUser_IdAndId(userId, bookingId);
        return BookingMapper.mapToBookingDTO(booking.get());
    }
    @Override
    public List<BookingDTO> findAllByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findAllByUserId(userId);
        return BookingMapper.mapToBookingDTOList(bookings);
    }
}
