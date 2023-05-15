package com.internship.controller;

import com.internship.model.dto.FlightDTO;
import com.internship.model.entity.Flight;
import com.internship.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FlightDTO>>  getFlights() {

        return ResponseEntity.ok(flightService.loadAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
        try {
            FlightDTO flight = flightService.getFlightById(id);
            return ResponseEntity.ok(flight);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/byDepartureDateAndOrigin")
    public ResponseEntity<List<FlightDTO>> getFlightsByDepartureDateAndOrigin(
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
            @RequestParam("origin") String origin) {
        List<FlightDTO> flights = flightService.getFlightsByDepartureDateAndOrigin(departureDate, origin);
        return ResponseEntity.ok(flights);
    }

}