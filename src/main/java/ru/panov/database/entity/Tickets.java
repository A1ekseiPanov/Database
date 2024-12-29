package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tickets {
    @Id
    @Column(name = "ticket_no", nullable = false, length = 13)
    private Character ticketNo;

    @Column(name = "passenger_id", nullable = false, length = 20)
    private String passengerId;

    @Column(name = "passenger_name", nullable = false, columnDefinition = "text")
    private String passengerName;


    @Column(name = "contact_data", columnDefinition = "jsonb")
    private String contact_data;

    @ManyToOne
    @JoinColumn(name = "book_ref")
    private Bookings booking;

    @OneToMany(mappedBy = "ticket")
    private List<TicketFlights> flights;
}