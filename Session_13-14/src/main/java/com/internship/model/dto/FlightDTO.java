package com.internship.model.dto;

import com.internship.model.enums.FlightStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FlightDTO {

    private Long id;
    private String origin;
    private String destination;
    private String airline;
    private String flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private FlightStatus status;
    private Set<Long> bookingIds = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Set<Long> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(Set<Long> bookingIds) {
        this.bookingIds = bookingIds;
    }
}
