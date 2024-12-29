package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ticket_flights")
@Check(constraints = "amount >= 0 AND fare_conditions IN ('Economy', 'Comfort', 'Business')")
public class TicketFlights {

    @EmbeddedId
    private TicketFlightsId id;

    @ManyToOne
    @MapsId("ticketNo")
    @JoinColumn(name = "ticket_no")
    private Tickets ticket;

    @ManyToOne
    @MapsId("flightId")
    @JoinColumn(name = "flight_id")
    private Flights flight;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @Column(name = "amount", nullable = false, scale = 2, precision = 10)
    private BigDecimal amount;
}