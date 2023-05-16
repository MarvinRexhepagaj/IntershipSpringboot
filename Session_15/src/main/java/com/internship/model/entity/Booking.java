package com.internship.model.entity;

import com.internship.model.enums.BookingStatus;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name = "booking_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus status;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "booking_flight",
            joinColumns = @JoinColumn(name = "booking_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id",referencedColumnName = "id"))
    private Set<Flight> flights ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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





    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +

                ", bookingDate=" + bookingDate +
                ", status=" + status +
                ",flights=" + flights +
                '}';
    }
}