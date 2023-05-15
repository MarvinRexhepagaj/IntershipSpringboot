package com.internship.repository;

import com.internship.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {


    List<Flight> findAllByDepartureDateAndOrigin(LocalDate departureDate, String origin);
}
