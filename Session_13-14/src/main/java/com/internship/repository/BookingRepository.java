package com.internship.repository;

import com.internship.model.dto.BookingDTO;
import com.internship.model.entity.Booking;
import com.internship.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {



    List<Booking> findAllByOrderByBookingDateDesc();
    List<Booking> findAllByUserId(Long userId);

    BookingDTO findBookingByIdAndUserId(Long id, Long userId);

    Booking findByIdAndUser(Long bookingId, User user);

    Optional<Booking> findByUser_IdAndId(Long userId, Long bookingId);

    List<Booking> findAllByFlights_Id(Long flightId);

}
