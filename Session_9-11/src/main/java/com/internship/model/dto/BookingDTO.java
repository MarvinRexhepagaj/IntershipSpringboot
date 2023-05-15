package com.internship.model.dto;

import com.internship.model.enums.BookingStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BookingDTO {
    private Long id;
    private Long userId;
    private Date bookingDate;
    private BookingStatus status;
    private Set<Long> flightIds = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Set<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(Set<Long> flightIds) {
        this.flightIds = flightIds;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                ", flightIds=" + flightIds +
                '}';
    }
}
